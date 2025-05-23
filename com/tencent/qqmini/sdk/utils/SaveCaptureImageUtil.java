package com.tencent.qqmini.sdk.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SaveCaptureImageUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f348361a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f348362b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f348363c;

        a(b bVar, Bitmap bitmap, View view) {
            this.f348361a = bVar;
            this.f348362b = bitmap;
            this.f348363c = view;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i3) {
            if (i3 == 0) {
                this.f348361a.onScreenShotFinished(i3, this.f348362b);
            } else {
                this.f348361a.onScreenShotFinished(i3, SaveCaptureImageUtil.d(this.f348363c));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
        void onScreenShotFinished(int i3, Bitmap bitmap);
    }

    public static String b(IMiniAppContext iMiniAppContext, Bitmap bitmap) {
        int width;
        double height;
        if (iMiniAppContext == null) {
            return null;
        }
        if (iMiniAppContext.getAttachedActivity() != null) {
            width = iMiniAppContext.getAttachedActivity().getResources().getDisplayMetrics().widthPixels;
            height = width;
        } else {
            width = (int) DeviceInfoUtil.getWidth();
            height = DeviceInfoUtil.getHeight();
        }
        Bitmap cutOutImg = ImageUtil.cutOutImg(Bitmap.createBitmap(bitmap), width, (int) (height * 0.8d));
        byte[] compressImage = ImageUtil.compressImage(cutOutImg, TextCell.FLAG_EMO_MASK);
        File file = new File(((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("png"));
        boolean saveBitmapToFile = ImageUtil.saveBitmapToFile(compressImage, file);
        if (cutOutImg != null && !cutOutImg.isRecycled()) {
            cutOutImg.recycle();
        }
        if (!saveBitmapToFile) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public static void c(Activity activity, View view, final ICaptureImageCallback iCaptureImageCallback) {
        e(activity, view, new b() { // from class: com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil.1
            @Override // com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil.b
            public void onScreenShotFinished(int i3, final Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.utils.SaveCaptureImageUtil.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ICaptureImageCallback iCaptureImageCallback2 = ICaptureImageCallback.this;
                            if (iCaptureImageCallback2 != null) {
                                iCaptureImageCallback2.onResult(bitmap);
                            }
                        }
                    });
                    return;
                }
                ICaptureImageCallback iCaptureImageCallback2 = ICaptureImageCallback.this;
                if (iCaptureImageCallback2 != null) {
                    iCaptureImageCallback2.onResult(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap d(View view) {
        Bitmap drawingCache;
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        try {
            drawingCache = view.getDrawingCache();
        } catch (Throwable th5) {
            QMLog.e("SaveCaptureImageUtil", "setViewToBitmap failed: " + Log.getStackTraceString(th5));
        }
        if (drawingCache != null && !drawingCache.isRecycled()) {
            bitmap = Bitmap.createBitmap(drawingCache);
            view.setWillNotCacheDrawing(willNotCacheDrawing);
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            return bitmap;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache2 = view.getDrawingCache();
        if (drawingCache2 != null && !drawingCache2.isRecycled()) {
            bitmap = Bitmap.createBitmap(drawingCache2);
            view.setWillNotCacheDrawing(willNotCacheDrawing);
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            return bitmap;
        }
        bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
        view.draw(new Canvas(bitmap));
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return bitmap;
    }

    public static void e(Activity activity, View view, b bVar) {
        Bitmap createBitmap;
        if (activity != null && bVar != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                try {
                    createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565, true);
                    Window window = activity.getWindow();
                    int i3 = iArr[0];
                    PixelCopy.request(window, new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight()), createBitmap, new a(bVar, createBitmap, view), new Handler(Looper.getMainLooper()));
                    return;
                } catch (Throwable th5) {
                    QMLog.e("SaveCaptureImageUtil", "setViewToBitmap failed: " + Log.getStackTraceString(th5));
                    return;
                }
            }
            bVar.onScreenShotFinished(0, d(view));
        }
    }
}
