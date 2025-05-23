package com.tencent.mobileqq.mini.appbrand.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandMoveBackUI1;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandMoveBackUI2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandMoveBackUI3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandMoveBackUtil {
    public static final String KEY_SHOT_BITMAP = "KEY_SHOT_BITMAP";
    private static final Map<String, Class> MiniAppBackMovedActivityClass;
    private static final String TAG = "AppBrandMoveBackUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class BitmapBinder extends Binder {
        private Bitmap mBitmap;

        public BitmapBinder(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        MiniAppBackMovedActivityClass = hashMap;
        hashMap.put("AppBrandUI", AppBrandMoveBackUI3.class);
        hashMap.put("AppBrandUI1", AppBrandMoveBackUI1.class);
        hashMap.put("AppBrandUI2", AppBrandMoveBackUI2.class);
    }

    public static Bitmap activityShot(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap bitmap = null;
        try {
            View rootView = activity.getWindow().getDecorView().getRootView();
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache();
            Rect rect = new Rect();
            rootView.getWindowVisibleDisplayFrame(rect);
            int i3 = rect.top;
            WindowManager windowManager = activity.getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i16 = displayMetrics.widthPixels;
            int i17 = displayMetrics.heightPixels + i3;
            int height = rootView.getDrawingCache().getHeight();
            if (i17 > height) {
                i17 = height;
            }
            bitmap = Bitmap.createBitmap(rootView.getDrawingCache(), 0, 0, i16, i17);
            rootView.destroyDrawingCache();
            rootView.setDrawingCacheEnabled(false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "activityShot error: ", e16);
        } catch (OutOfMemoryError e17) {
            QLog.e(TAG, 1, "activityShot OutOfMemoryError: ", e17);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "activityShot cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return bitmap;
    }

    private static Bitmap doActivityShotByPixelCopy(Activity activity) {
        if (Build.VERSION.SDK_INT >= 26) {
            final long currentTimeMillis = System.currentTimeMillis();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            View rootView = activity.getWindow().getDecorView().getRootView();
            final Window window = activity.getWindow();
            final Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
            new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    AppBrandMoveBackUtil.lambda$doActivityShotByPixelCopy$0(window, createBitmap, countDownLatch, currentTimeMillis);
                }
            }, "mini_app_pixel_copy_sub_thread").start();
            try {
                boolean await = countDownLatch.await(600L, TimeUnit.MILLISECONDS);
                if (QLog.isDevelopLevel()) {
                    QLog.e(TAG, 4, "isCompleted:" + await);
                }
                if (await) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i(TAG, 4, "doActivityShotByPixelCopy cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    return createBitmap;
                }
                QLog.e(TAG, 1, "wait onPixelCopy timeout!");
                return activityShot(activity);
            } catch (InterruptedException e16) {
                QLog.e(TAG, 1, "latch.await() error", e16);
                return activityShot(activity);
            }
        }
        return activityShot(activity);
    }

    public static Intent getMoveBackIntent(Activity activity) {
        Bitmap bitmap;
        String simpleName = activity.getClass().getSimpleName();
        Class<AppBrandMoveBackUI3> cls = MiniAppBackMovedActivityClass.get(simpleName);
        if (cls == null) {
            cls = AppBrandMoveBackUI3.class;
        }
        QLog.d(TAG, 1, "simpleName:" + simpleName + " movedActivityClass: " + cls);
        Intent intent = new Intent(activity, cls);
        intent.addFlags(268435456);
        try {
            bitmap = doActivityShotByPixelCopy(activity);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "activityShotByPixelCopy error", th5);
            bitmap = null;
        }
        Bundle bundle = new Bundle();
        bundle.putBinder(KEY_SHOT_BITMAP, new BitmapBinder(bitmap));
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doActivityShotByPixelCopy$0(Window window, final Bitmap bitmap, final CountDownLatch countDownLatch, final long j3) {
        try {
            Looper.prepare();
            final Handler handler = new Handler(Looper.myLooper());
            PixelCopy.request(window, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.tencent.mobileqq.mini.appbrand.utils.AppBrandMoveBackUtil.1
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public void onPixelCopyFinished(int i3) {
                    if (i3 == 0) {
                        countDownLatch.countDown();
                    } else {
                        QLog.e(AppBrandMoveBackUtil.TAG, 1, "onPixelCopy Fail, resultCode:" + i3);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i(AppBrandMoveBackUtil.TAG, 4, "onPixelCopyFinished cost: " + (System.currentTimeMillis() - j3) + "\uff0cresultCode:" + i3 + ", threadName:" + Thread.currentThread().getName() + ", " + bitmap);
                    }
                    handler.getLooper().quit();
                }
            }, handler);
            Looper.loop();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, " PixelCopy.request runnable error", th5);
        }
    }

    public static Bitmap getShotBitmap(Intent intent) {
        BitmapBinder bitmapBinder;
        if (intent == null) {
            return null;
        }
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && (bitmapBinder = (BitmapBinder) extras.getBinder(KEY_SHOT_BITMAP)) != null) {
                return bitmapBinder.getBitmap();
            }
        } catch (Exception e16) {
            QMLog.e(TAG, "getShotBitmap error: ", e16);
        }
        return null;
    }
}
