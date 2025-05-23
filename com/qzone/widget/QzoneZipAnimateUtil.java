package com.qzone.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.NinePatchRefDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import cooperation.qzone.zipanimate.DrawableLoadedListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneZipAnimateUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f60590a = VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true);

    public static void c(final View view, String str, String str2, String str3) {
        com.qzone.util.image.c.L(((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2) + File.separator + str3, true, new ImageLoader.ImageLoadListener() { // from class: com.qzone.widget.QzoneZipAnimateUtil.5
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str4, ImageLoader.Options options) {
                QZLog.e("ziploader", "onImageCanceled");
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str4, ImageLoader.Options options) {
                QZLog.e("ziploader", "onImageFailed");
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str4, final Drawable drawable, ImageLoader.Options options) {
                if (drawable != null && (drawable instanceof NinePatchRefDrawable)) {
                    drawable = ((NinePatchRefDrawable) drawable).newInstance();
                }
                if (drawable == null || view.getHandler() == null) {
                    return;
                }
                view.getHandler().post(new Runnable() { // from class: com.qzone.widget.QzoneZipAnimateUtil.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setBackground(drawable);
                        view.setPadding(0, 0, 0, 0);
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str4, float f16, ImageLoader.Options options) {
            }
        });
    }

    public static void d(final String str, final String str2, final String str3, final QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.widget.QzoneZipAnimateUtil.1
            @Override // java.lang.Runnable
            public void run() {
                if (((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).checkAndDownLoadFileIfNeeded(null, str, str2, str3, -1, qzoneZipCacheHelperCallBack)) {
                    qzoneZipCacheHelperCallBack.onResult(true);
                }
            }
        });
    }

    public static String[] e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("ziploader", "getFileList doesn't exists path = " + str);
                }
                return null;
            }
            String[] list = file.list();
            if (list != null) {
                Arrays.sort(list);
            }
            return list;
        } catch (Exception e16) {
            QZLog.e("ziploader", " getFileList ", e16);
            return null;
        }
    }

    public static com.tencent.mobileqq.vas.ui.c f(String str, String str2, String str3, int i3, int i16) {
        String str4 = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2) + File.separator + str3;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k();
        kVar.B(i16);
        kVar.C(i3);
        return ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneFrameDrawable(str4, str, kVar, 0);
    }

    public static void g(String str, String str2, String str3, ImageLoader.ImageLoadListener imageLoadListener) {
        com.qzone.util.image.c.L(((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2) + File.separator + str3, true, imageLoadListener);
    }

    public static void h(final String str, final String str2, final String str3, final int i3, final int i16, final int i17, final AnimationDrawableLoadedListener animationDrawableLoadedListener) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.widget.QzoneZipAnimateUtil.4

            /* compiled from: P */
            /* renamed from: com.qzone.widget.QzoneZipAnimateUtil$4$a */
            /* loaded from: classes37.dex */
            class a implements FilenameFilter {
                a() {
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.endsWith(".jpg") || str.endsWith(".png");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String basePath = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2);
                AnimationDrawable animationDrawable = new AnimationDrawable();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(basePath);
                String str4 = File.separator;
                sb5.append(str4);
                sb5.append(str3);
                File file = new File(sb5.toString());
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = new File(basePath + str4 + str3).listFiles(new a());
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            Bitmap v3 = com.qzone.util.image.c.v(file2.getAbsolutePath(), i3, i16);
                            if (v3 != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(v3);
                                bitmapDrawable.setBounds(0, 0, i3, i16);
                                animationDrawable.addFrame(bitmapDrawable, i17);
                            }
                        }
                        animationDrawableLoadedListener.onLoadedSuccess(animationDrawable);
                        return;
                    }
                    animationDrawableLoadedListener.onLoadedFailed();
                    QZLog.w("zipLoader", "zip file empty");
                    return;
                }
                QZLog.w("zipLoader", "zip no exist");
                animationDrawableLoadedListener.onLoadedFailed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str, String str2, int i3, int i16, int i17, AnimationDrawableLoadedListener animationDrawableLoadedListener) {
        Bitmap v3;
        String basePath = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        File file = new File(basePath);
        if (file.exists() && file.isDirectory()) {
            String[] e16 = e(basePath);
            if (e16 == null) {
                QZLog.e("zipLoader", "getFileList dir empty = " + basePath);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i18 = 0; i18 < e16.length; i18++) {
                if (e16[i18].endsWith(".jpg") || e16[i18].endsWith(".png")) {
                    arrayList.add(basePath + File.separator + e16[i18]);
                }
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    if (!TextUtils.isEmpty(str3) && (v3 = com.qzone.util.image.c.v(str3, i3, i16)) != null) {
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(v3);
                        bitmapDrawable.setBounds(0, 0, i3, i16);
                        animationDrawable.addFrame(bitmapDrawable, i17);
                    }
                }
                animationDrawableLoadedListener.onLoadedSuccess(animationDrawable);
                return;
            }
            animationDrawableLoadedListener.onLoadedFailed();
            QZLog.e("zipLoader", "zip file empty");
            return;
        }
        QZLog.e("zipLoader", "zip no exist");
        animationDrawableLoadedListener.onLoadedFailed();
    }

    @Deprecated
    public static void j(final String str, final String str2, final String str3, final int i3, final int i16, final int i17, final AnimationDrawableLoadedListener animationDrawableLoadedListener) {
        if (f60590a) {
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k();
            kVar.B(Math.max(i16, 0));
            kVar.C(Math.max(i3, 0));
            kVar.I(false);
            animationDrawableLoadedListener.onNewLoadSuccess(((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneFrameDrawable(str, str2, kVar, i17 < 10 ? 2 : 0));
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.widget.QzoneZipAnimateUtil.2
            @Override // java.lang.Runnable
            public void run() {
                AnimationDrawableLoadedListener.this.mCallBack = new a();
                if (((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).checkAndDownLoadFileIfNeeded(null, str, str2, str3, -1, AnimationDrawableLoadedListener.this.mCallBack)) {
                    QzoneZipAnimateUtil.i(str2, str3, i3, i16, i17, AnimationDrawableLoadedListener.this);
                }
            }

            /* compiled from: P */
            /* renamed from: com.qzone.widget.QzoneZipAnimateUtil$2$a */
            /* loaded from: classes37.dex */
            class a implements QzoneZipCacheHelperCallBack {
                a() {
                }

                @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
                public void onResult(boolean z16) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    QzoneZipAnimateUtil.i(str2, str3, i3, i16, i17, AnimationDrawableLoadedListener.this);
                }

                @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
                public void onResultOfNativeRequest(boolean z16, String str, String str2) {
                }
            }
        });
    }

    public static Drawable k(String str, String str2, String str3, final int i3, final int i16) {
        Bitmap v3;
        String str4 = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(str, str2) + File.separator + str3;
        if (f60590a) {
            return com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str4).g(new a.c() { // from class: com.qzone.widget.s
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                    QzoneZipAnimateUtil.n(i3, i16, kVar);
                }
            }).a();
        }
        if (new File(str4).exists() && (v3 = com.qzone.util.image.c.v(str4, i3, i16)) != null) {
            return new BitmapDrawable(v3);
        }
        QZLog.w("zipLoader", "zip file no exist");
        return null;
    }

    public static void l(final String str, final String str2, final String str3, final int i3, final int i16, final DrawableLoadedListener drawableLoadedListener) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.widget.QzoneZipAnimateUtil.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable k3 = QzoneZipAnimateUtil.k(str, str2, str3, i3, i16);
                DrawableLoadedListener drawableLoadedListener2 = drawableLoadedListener;
                if (drawableLoadedListener2 != null) {
                    drawableLoadedListener2.onLoaded(k3);
                }
            }
        });
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.valueOf(str.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(int i3, int i16, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
        kVar.C(i3);
        kVar.B(i16);
    }
}
