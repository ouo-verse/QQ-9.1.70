package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.k;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GalleryItemVideo extends PicBrowserImage implements DynamicAvatarDownloadManager.b {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    DynamicAvatarManager E;
    DynamicAvatarDownloadManager F;
    boolean G;
    Handler H;

    /* renamed from: h, reason: collision with root package name */
    WeakReference<URLImageView> f258883h;

    /* renamed from: i, reason: collision with root package name */
    public WeakReference<PicBrowserImage.b> f258884i;

    /* renamed from: m, reason: collision with root package name */
    int f258885m;

    public GalleryItemVideo(Context context, PicInfo picInfo) {
        super(context, picInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) picInfo);
            return;
        }
        this.C = 0;
        this.D = 0;
        this.G = false;
        this.H = new Handler(Looper.getMainLooper());
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (appInterface instanceof QQAppInterface) {
            this.E = (DynamicAvatarManager) appInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
        } else if (appInterface instanceof INearbyAppInterface) {
            this.E = (DynamicAvatarManager) appInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER);
        }
        DynamicAvatarManager dynamicAvatarManager = this.E;
        if (dynamicAvatarManager != null) {
            DynamicAvatarDownloadManager n3 = dynamicAvatarManager.n();
            this.F = n3;
            n3.e(this);
        }
    }

    private URLDrawable k(String str) {
        URLDrawable uRLDrawable = null;
        if (!TextUtils.isEmpty(str)) {
            String replaceFirst = str.replaceFirst("http", ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE);
            if (AbsDownloader.hasFile(replaceFirst)) {
                uRLDrawable = URLDrawable.getDrawable(replaceFirst, (URLDrawable.URLDrawableOptions) null);
                if (QLog.isColorLevel()) {
                    QLog.i("GalleryItemVideo", 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + replaceFirst);
                }
            }
        }
        return uRLDrawable;
    }

    @NonNull
    private URLDrawable.URLDrawableOptions l(Drawable drawable) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mUseMemoryCache = false;
        obtain.mMemoryCacheKeySuffix = "GalleryItemVideo";
        VideoDrawable.VideoDrawableParams videoDrawableParams = new VideoDrawable.VideoDrawableParams();
        videoDrawableParams.mPlayVideoFrame = true;
        videoDrawableParams.mPlayAudioFrame = true;
        videoDrawableParams.mEnableAntiAlias = true;
        videoDrawableParams.mEnableFilter = true;
        obtain.mUseMemoryCache = false;
        obtain.mExtraInfo = videoDrawableParams;
        HashMap hashMap = new HashMap();
        PicInfo picInfo = this.f258907e;
        if (picInfo != null) {
            hashMap.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, picInfo.f258920i);
        } else {
            hashMap.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, "");
        }
        Context context = this.f258906d;
        if (context != null) {
            hashMap.put("contextString", context.toString());
        } else {
            hashMap.put("contextString", "");
        }
        QQBeaconReport.report("", "old_picViewer_info", hashMap);
        return obtain;
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.b
    public void a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
            return;
        }
        if (str.equals(this.f258907e.f258920i)) {
            this.C = i3;
            WeakReference<PicBrowserImage.b> weakReference = this.f258884i;
            if (weakReference != null && weakReference.get() != null) {
                this.f258884i.get().q(this.f258885m, i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.b
    public void b(String str, boolean z16, boolean z17) {
        int i3;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str.equals(this.f258907e.f258920i)) {
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.D = i3;
            if (QLog.isColorLevel()) {
                QLog.i("GalleryItemVideo", 2, "onDownloadFinish pos:" + this.f258885m + " suc:" + z16);
            }
            WeakReference<PicBrowserImage.b> weakReference = this.f258884i;
            if (weakReference != null && this.f258883h != null) {
                PicBrowserImage.b bVar = weakReference.get();
                URLImageView uRLImageView = this.f258883h.get();
                if (bVar != null) {
                    bVar.k2(this.f258885m, z16);
                    bVar.D0(this.f258885m);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onDownloadFinish onloadli=null:");
                    if (bVar == null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    sb5.append(z18);
                    QLog.i("GalleryItemVideo", 2, sb5.toString());
                }
                if (uRLImageView != null) {
                    if (z16 && DynamicAvatarDownloadManager.m(this.f258907e.f258920i)) {
                        this.H.post(new Runnable(uRLImageView, URLDrawable.getDrawable(DynamicAvatarDownloadManager.h(this.f258907e.f258920i), l(uRLImageView.getDrawable()))) { // from class: com.tencent.mobileqq.picbrowser.GalleryItemVideo.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ URLImageView f258886d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ URLDrawable f258887e;

                            {
                                this.f258886d = uRLImageView;
                                this.f258887e = r9;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, GalleryItemVideo.this, uRLImageView, r9);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    this.f258886d.setImageDrawable(this.f258887e);
                                }
                            }
                        });
                        z19 = true;
                    }
                    if (!z19) {
                        this.H.post(new Runnable(uRLImageView, BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.aio_image_fail)) { // from class: com.tencent.mobileqq.picbrowser.GalleryItemVideo.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ URLImageView f258888d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ Drawable f258889e;

                            {
                                this.f258888d = uRLImageView;
                                this.f258889e = r9;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, GalleryItemVideo.this, uRLImageView, r9);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    this.f258888d.setImageDrawable(this.f258889e);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage
    public View c(int i3, Handler handler, PicBrowserImage.b bVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), handler, bVar);
        }
        this.f258885m = i3;
        URLImageView uRLImageView = new URLImageView(this.f258906d);
        if (this.f258907e == null) {
            return uRLImageView;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GalleryItemVideo", 2, "getView pos:" + i3);
        }
        this.f258883h = new WeakReference<>(uRLImageView);
        this.f258884i = new WeakReference<>(bVar);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = URLDrawableHelper.getTransparent();
        obtain.mLoadingDrawable = URLDrawableHelper.getTransparent();
        Drawable k3 = k(this.f258907e.f258917e);
        if (k3 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            k3 = k(this.f258907e.f258918f);
            if (k3 != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (!TextUtils.isEmpty(this.f258907e.f258918f)) {
                    k3 = URLDrawable.getDrawable(this.f258907e.f258918f.replaceFirst("http", ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE), obtain);
                } else {
                    k3 = URLDrawableHelper.getTransparent();
                }
            }
        }
        if (!TextUtils.isEmpty(this.f258907e.f258921m)) {
            File file = new File(this.f258907e.f258921m);
            z17 = file.exists();
            if (z17) {
                uRLImageView.setImageDrawable(URLDrawable.getDrawable(file, l(k3)));
            }
        } else {
            z17 = false;
        }
        if (!z17 && !TextUtils.isEmpty(this.f258907e.f258920i) && (z17 = DynamicAvatarDownloadManager.m(this.f258907e.f258920i))) {
            uRLImageView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.h(this.f258907e.f258920i), l(k3)));
        }
        if (!z17) {
            if (!TextUtils.isEmpty(this.f258907e.f258920i)) {
                this.D = 0;
                uRLImageView.setImageDrawable(k3);
                if (this.F.q(this.f258907e.f258920i)) {
                    this.C = 0;
                }
                bVar.I0(i3, this.C);
            } else {
                uRLImageView.setImageDrawable(BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.aio_image_fail));
                this.D = 2;
                bVar.k2(i3, false);
            }
            if (QLog.isColorLevel()) {
                QLog.i("GalleryItemVideo", 2, "fileNotExsits progress:" + this.C + " url:" + this.f258907e.f258920i);
            }
        } else {
            this.C = 0;
            this.D = 1;
            bVar.k2(i3, true);
        }
        return uRLImageView;
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.G = true;
        m();
        super.e();
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage
    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else if (!z16) {
            m();
        }
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.f258907e.f258920i)) {
            if (QLog.isColorLevel()) {
                QLog.i("GalleryItemVideo", 2, "preload:" + this.f258885m);
            }
            if (!DynamicAvatarDownloadManager.m(this.f258907e.f258920i)) {
                this.F.q(this.f258907e.f258920i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r3 = k(r8.f258907e.f258918f);
     */
    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage, com.tencent.common.galleryactivity.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getAnimationDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f258907e == null) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = URLDrawableHelper.getTransparent();
        obtain.mLoadingDrawable = URLDrawableHelper.getTransparent();
        URLDrawable k3 = k(this.f258907e.f258917e);
        if (k3 == null && k3 == null) {
            try {
                URL url = new URL(this.f258907e.f258918f);
                k3 = URLDrawable.getDrawable(new URL(ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE, url.getAuthority(), url.getFile()), obtain);
            } catch (MalformedURLException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        }
        Rect thumbRect = getThumbRect();
        if (k3 == null || thumbRect == null) {
            return null;
        }
        this.f258908f = k.getCutValue(thumbRect, k3);
        if (QLog.isColorLevel()) {
            QLog.d("GalleryItemVideo", 2, "getAnimationDrawable ,cutValue = " + this.f258908f);
        }
        return k3;
    }

    @Override // com.tencent.mobileqq.picbrowser.PicBrowserImage
    public void j(View view, int i3, PicBrowserImage.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Integer.valueOf(i3), bVar);
            return;
        }
        URLImageView uRLImageView = (URLImageView) view;
        Drawable drawable = uRLImageView.getDrawable();
        if (drawable != null && (drawable instanceof URLDrawable)) {
            int i16 = this.D;
            if (i16 != 1 && i16 != 2 && i16 != 3 && i16 != 4) {
                if (QLog.isColorLevel()) {
                    QLog.i("GalleryItemVideo", 2, "updateProgressOnSelected:" + this.C);
                }
                int i17 = this.C;
                if (i17 > 0) {
                    bVar.q(i3, i17 / 100);
                }
            } else {
                if (i16 == 1 || i16 == 4) {
                    z16 = true;
                }
                bVar.k2(i3, z16);
            }
            uRLImageView.setMinimumHeight(10);
            uRLImageView.setMinimumWidth(10);
        }
    }

    public void m() {
        URLImageView uRLImageView;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GalleryItemVideo", 2, "pause audio:" + this.f258885m);
        }
        WeakReference<URLImageView> weakReference = this.f258883h;
        if (weakReference != null && (uRLImageView = weakReference.get()) != null && (drawable = uRLImageView.getDrawable()) != null && (drawable instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getCurrDrawable() instanceof VideoDrawable) {
                ((VideoDrawable) uRLDrawable.getCurrDrawable()).stopAudio();
            }
        }
    }
}
