package com.tencent.mobileqq.util;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class ScreenShotUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f306471a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Method f306472b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f306481d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ocr.view.e f306482e;

        a(AtomicBoolean atomicBoolean, com.tencent.mobileqq.ocr.view.e eVar) {
            this.f306481d = atomicBoolean;
            this.f306482e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f306481d.set(true);
            this.f306482e.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ocr.view.e f306483d;

        b(com.tencent.mobileqq.ocr.view.e eVar) {
            this.f306483d = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f306483d.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f306484d;

        c(AnimatorSet animatorSet) {
            this.f306484d = animatorSet;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f306484d.isRunning()) {
                this.f306484d.end();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d<T> implements e<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f306485a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ocr.view.e f306486b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f306487c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WebView f306488d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f306489e;

        d(AtomicBoolean atomicBoolean, com.tencent.mobileqq.ocr.view.e eVar, e eVar2, WebView webView, AnimatorSet animatorSet) {
            this.f306485a = atomicBoolean;
            this.f306486b = eVar;
            this.f306487c = eVar2;
            this.f306488d = webView;
            this.f306489e = animatorSet;
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        public void a(T t16, Bitmap bitmap) {
            if (this.f306485a.get()) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "postBitmap isCanceled");
                this.f306486b.dismiss();
                return;
            }
            if (t16 == null) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "postBitmap t is null");
                this.f306486b.dismiss();
                return;
            }
            if (bitmap == null) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "postBitmap bitmap is null");
                this.f306486b.dismiss();
                this.f306487c.b(new NullPointerException("postBitmap bitmap is null"));
            } else {
                if (this.f306488d.getContext() != null && this.f306486b.isShowing()) {
                    if (this.f306489e.isRunning()) {
                        this.f306489e.end();
                    }
                    this.f306486b.dismiss();
                }
                this.f306487c.a(t16, bitmap);
            }
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        public void b(Exception exc) {
            this.f306487c.b(exc);
            this.f306486b.dismiss();
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        public T c(Bitmap bitmap) {
            if (this.f306485a.get()) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "onScreenshotFinish isCanceled");
                this.f306486b.dismiss();
                return null;
            }
            if (bitmap == null) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "onScreenshotFinish bitmap is null");
                this.f306486b.dismiss();
                return null;
            }
            return (T) this.f306487c.c(bitmap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e<T> {
        void a(T t16, Bitmap bitmap);

        void b(Exception exc);

        T c(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
        void a(Bitmap bitmap);
    }

    public static Bitmap a(int i3, int i16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "createBitmap failed", e16);
            System.gc();
            try {
                return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e17) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "createBitmap failed again", e17);
                return null;
            }
        }
    }

    public static String b() {
        return VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/web_long_shot/");
    }

    public static String c(Bitmap bitmap, File file, String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        if (bitmap == null || file == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
            } catch (IOException e16) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "saveBitmap failed.", e16);
            }
            return file2.getAbsolutePath();
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, th, new Object[0]);
                return "";
            } finally {
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e17) {
                        QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "saveBitmap failed.", e17);
                    }
                }
            }
        }
    }

    public static Bitmap d(WebView webView, int i3, int i16) {
        Bitmap a16;
        if (webView == null || i3 <= 0 || i16 <= 0 || (a16 = a(i3, i16)) == null) {
            return null;
        }
        Canvas canvas = new Canvas(a16);
        if (webView.getX5WebViewExtension() != null) {
            PaintFlagsDrawFilter paintFlagsDrawFilter = new PaintFlagsDrawFilter(134, 64);
            int tbsVersion = QbSdk.getTbsVersion(webView.getContext());
            if (tbsVersion >= 43000 && tbsVersion < 43105) {
                float measuredWidth = i3 / webView.getMeasuredWidth();
                canvas.scale(measuredWidth, measuredWidth);
                canvas.setDrawFilter(paintFlagsDrawFilter);
                webView.getX5WebViewExtension().snapshotVisible(canvas, false, false, false, false);
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 2, "snapshot with snapshotVisible()");
                }
            } else {
                float contentWidth = i3 / webView.getContentWidth();
                canvas.scale(contentWidth, contentWidth);
                canvas.setDrawFilter(paintFlagsDrawFilter);
                webView.getX5WebViewExtension().snapshotWholePage(canvas, false, false);
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 2, "snapshot with snapshotWholePage()");
                }
            }
            canvas.setDrawFilter(null);
        } else {
            float measuredWidth2 = i3 / webView.getMeasuredWidth();
            canvas.scale(measuredWidth2, measuredWidth2);
            Picture capturePicture = webView.capturePicture();
            if (capturePicture != null) {
                capturePicture.draw(canvas);
            }
        }
        return a16;
    }

    public static void e(WebView webView, final f fVar) {
        final Bitmap a16;
        if (webView != null && fVar != null) {
            int measuredWidth = webView.getMeasuredWidth();
            int measuredHeight = webView.getMeasuredHeight();
            if (measuredWidth <= 0 || measuredHeight <= 0 || (a16 = a(measuredWidth, measuredHeight)) == null) {
                return;
            }
            Canvas canvas = new Canvas(a16);
            if (webView.getX5WebViewExtension() != null) {
                boolean z16 = false;
                if (!f306471a && f306472b == null) {
                    Class<?>[] interfaces = webView.getX5WebViewExtension().getClass().getInterfaces();
                    int length = interfaces.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        Class<?> cls = interfaces[i3];
                        if ("com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(cls.getName())) {
                            try {
                                Class<?> cls2 = Boolean.TYPE;
                                Class<?> cls3 = Float.TYPE;
                                f306472b = cls.getDeclaredMethod("snapshotVisibleWithBitmap", Bitmap.class, cls2, cls2, cls2, cls2, cls3, cls3, Runnable.class);
                                if (QLog.isColorLevel()) {
                                    QLog.i(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 2, "call snapshotVisibleWithBitmap");
                                }
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 2, "call snapshotVisibleWithBitmap failed: " + e16.getMessage());
                                }
                                f306472b = null;
                            }
                        } else {
                            i3++;
                        }
                    }
                    f306471a = true;
                }
                try {
                    Method method = f306472b;
                    if (method != null) {
                        IX5WebViewExtension x5WebViewExtension = webView.getX5WebViewExtension();
                        Boolean bool = Boolean.TRUE;
                        method.invoke(x5WebViewExtension, a16, bool, bool, bool, bool, 1, 1, new Runnable() { // from class: com.tencent.mobileqq.util.ScreenShotUtil.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QLog.isColorLevel()) {
                                    QLog.i(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 2, "ScreenShot Finish Callback");
                                }
                                f.this.a(a16);
                            }
                        });
                    }
                    z16 = true;
                } catch (Exception unused) {
                }
                if (!z16) {
                    canvas.setDrawFilter(new PaintFlagsDrawFilter(134, 64));
                    webView.getX5WebViewExtension().snapshotVisible(canvas, false, false, false, false);
                    if (QLog.isColorLevel()) {
                        QLog.d(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 2, "snapshot with snapshotVisible()");
                    }
                    canvas.setDrawFilter(null);
                    fVar.a(a16);
                    return;
                }
                return;
            }
            webView.draw(canvas);
            fVar.a(a16);
        }
    }

    public static <T> boolean f(final WebView webView, final e<T> eVar) {
        QLog.d(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "snapshotWholePage start");
        if (webView == null) {
            QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "snapshotWholePage error, mWebView is null");
            eVar.b(new NullPointerException("mWebView is null"));
            return false;
        }
        int measuredWidth = webView.getMeasuredWidth();
        int contentWidth = webView.getContentWidth();
        int contentHeight = webView.getContentHeight();
        if (measuredWidth > 0 && contentWidth > 0 && contentHeight > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, String.format("snapshotWholePage content:[%d, %d] wvWidth:%d", Integer.valueOf(contentWidth), Integer.valueOf(contentHeight), Integer.valueOf(measuredWidth)));
            }
            float f16 = measuredWidth / contentWidth;
            int i3 = (int) (contentHeight * f16);
            if (i3 > 20000) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "height > 20000, out of height limit");
                eVar.b(new IllegalStateException(HardCodeUtil.qqStr(R.string.vxv)));
                return false;
            }
            try {
                final Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, i3, Bitmap.Config.RGB_565);
                if (createBitmap == null) {
                    return false;
                }
                final Canvas canvas = new Canvas(createBitmap);
                canvas.scale(f16, f16);
                ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.util.ScreenShotUtil.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            WebView.this.getX5WebViewExtension().snapshotWholePage(canvas, false, false);
                            final Object c16 = eVar.c(createBitmap);
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.ScreenShotUtil.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    eVar.a(c16, createBitmap);
                                }
                            });
                        } catch (Exception e16) {
                            QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "snapshotWholePage error : " + e16.getMessage());
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.ScreenShotUtil.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    eVar.b(e16);
                                }
                            });
                        } catch (OutOfMemoryError unused) {
                            QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "snapshotWholePage out of memory ");
                            Bitmap bitmap = createBitmap;
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.ScreenShotUtil.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    eVar.b(new IllegalStateException(HardCodeUtil.qqStr(R.string.vxv)));
                                }
                            });
                        }
                    }
                });
                return true;
            } catch (OutOfMemoryError unused) {
                QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "createBitmap out of memory");
                eVar.b(new IllegalStateException(HardCodeUtil.qqStr(R.string.vxv)));
                return false;
            }
        }
        QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0");
        eVar.b(new IllegalStateException("measuredWidth <= 0 || contentWidth <= 0 || contentHeight <= 0"));
        return false;
    }

    public static <T> void g(WebView webView, e<T> eVar) {
        QLog.d(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "webViewFragmentScreenLongShot start");
        if (webView == null) {
            QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "webviewFragmentScreenLongShot error, mWebView is null");
            eVar.b(new NullPointerException("mWebView is null"));
            return;
        }
        Context context = webView.getContext();
        if (context == null) {
            QLog.e(com.tencent.qqmini.sdk.utils.ScreenShotUtil.TAG, 1, "webviewFragmentScreenLongShot error, context is null");
            eVar.b(new NullPointerException("context is null"));
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.tencent.mobileqq.ocr.view.e eVar2 = new com.tencent.mobileqq.ocr.view.e(context);
        eVar2.N(HardCodeUtil.qqStr(R.string.vvf));
        eVar2.P(true);
        eVar2.O(new a(atomicBoolean, eVar2));
        eVar2.show();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 90);
        ofInt.setDuration(2000L);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(90, 99);
        ofInt2.setDuration(10000L);
        b bVar = new b(eVar2);
        ofInt.addUpdateListener(bVar);
        ofInt2.addUpdateListener(bVar);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofInt, ofInt2);
        animatorSet.start();
        eVar2.setOnDismissListener(new c(animatorSet));
        f(webView, new d(atomicBoolean, eVar2, eVar, webView, animatorSet));
    }
}
