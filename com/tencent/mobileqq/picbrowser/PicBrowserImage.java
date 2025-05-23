package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.galleryactivity.k;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes16.dex */
public class PicBrowserImage extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Context f258906d;

    /* renamed from: e, reason: collision with root package name */
    public PicInfo f258907e;

    /* renamed from: f, reason: collision with root package name */
    int f258908f;

    /* loaded from: classes16.dex */
    class a implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f258913d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f258914e;

        a(b bVar, int i3) {
            this.f258913d = bVar;
            this.f258914e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PicBrowserImage.this, bVar, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
            } else {
                this.f258913d.k2(this.f258914e, false);
                this.f258913d.D0(this.f258914e);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, interruptedException);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, uRLDrawable, Integer.valueOf(i3));
            } else if (i3 > 0 && i3 < 10000) {
                this.f258913d.q(this.f258914e, i3 / 100);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
            } else {
                this.f258913d.k2(this.f258914e, true);
                this.f258913d.D0(this.f258914e);
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface b {
        void D0(int i3);

        void I0(int i3, int i16);

        void k2(int i3, boolean z16);

        void q(int i3, int i16);
    }

    public PicBrowserImage(Context context, PicInfo picInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) picInfo);
        } else {
            this.f258906d = context;
            this.f258907e = picInfo;
        }
    }

    public View c(int i3, Handler handler, b bVar) {
        Drawable drawable;
        boolean z16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), handler, bVar);
        }
        URLImageView uRLImageView = new URLImageView(this.f258906d);
        PicInfo picInfo = this.f258907e;
        if (picInfo == null) {
            return uRLImageView;
        }
        URLDrawable uRLDrawable = null;
        if (!TextUtils.isEmpty(picInfo.f258919h)) {
            drawable = URLDrawable.getDrawable(new File(this.f258907e.f258919h), (URLDrawable.URLDrawableOptions) null);
        } else if (!TextUtils.isEmpty(this.f258907e.f258918f)) {
            String replaceFirst = this.f258907e.f258918f.replaceFirst("http", ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE);
            if (AbsDownloader.hasFile(replaceFirst)) {
                URLDrawable drawable2 = URLDrawable.getDrawable(replaceFirst, (URLDrawable.URLDrawableOptions) null);
                if (QLog.isColorLevel()) {
                    QLog.i("PicBrowser", 2, "PicBrowserGalleryAdapter getView loadingDrawble is: " + replaceFirst);
                }
                drawable = drawable2;
            } else {
                drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            }
        } else {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mRequestWidth = this.f258906d.getResources().getDisplayMetrics().widthPixels;
        obtain.mRequestHeight = this.f258906d.getResources().getDisplayMetrics().heightPixels;
        obtain.mPlayGifImage = true;
        PicInfo picInfo2 = this.f258907e;
        obtain.mExtraInfo = picInfo2;
        if (!TextUtils.isEmpty(picInfo2.f258919h)) {
            try {
                File file = new File(this.f258907e.f258919h);
                URL url = file.toURL();
                uRLDrawable = URLDrawable.getDrawable(new URL(ProtocolDownloaderConstants.PROTOCOL_NEARBY_LOCAL_IMAGE, url.getAuthority(), url.getFile()), obtain);
                uRLImageView.setImageDrawable(uRLDrawable);
                if (file.exists()) {
                    if (file.isFile()) {
                        z16 = true;
                    }
                }
            } catch (MalformedURLException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
            z16 = false;
        } else {
            if (!TextUtils.isEmpty(this.f258907e.f258917e)) {
                try {
                    URL convertURL = NearbyImgDownloader.convertURL(this.f258907e.f258917e);
                    this.f258907e.f258917e = convertURL.toString();
                    uRLDrawable = URLDrawable.getDrawable(convertURL, obtain);
                    uRLDrawable.setDownloadListener(new ImgDownloadListener(this.f258906d, StatisticCollector.NEARBY_PIC_BROWSER_STATISTIC_TAG));
                    uRLImageView.setImageDrawable(uRLDrawable);
                    z16 = AbsDownloader.hasFile(this.f258907e.f258917e);
                } catch (MalformedURLException e17) {
                    if (QLog.isDevelopLevel()) {
                        e17.printStackTrace();
                    }
                }
            }
            z16 = false;
        }
        if (uRLDrawable != null && uRLDrawable.getStatus() != 1 && uRLDrawable.getStatus() != 2 && uRLDrawable.getStatus() != 4) {
            uRLImageView.setURLDrawableDownListener(new a(bVar, i3));
            if (z16) {
                j3 = 1000;
            } else {
                j3 = 300;
            }
            handler.postDelayed(new Runnable(uRLDrawable, bVar, i3) { // from class: com.tencent.mobileqq.picbrowser.PicBrowserImage.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ URLDrawable f258910d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ b f258911e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f258912f;

                {
                    this.f258910d = uRLDrawable;
                    this.f258911e = bVar;
                    this.f258912f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PicBrowserImage.this, uRLDrawable, bVar, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (this.f258910d.getStatus() != 1 && this.f258910d.getStatus() != 2) {
                        this.f258911e.I0(this.f258912f, this.f258910d.getProgress());
                    }
                }
            }, j3);
        } else if (uRLDrawable == null) {
            bVar.k2(i3, false);
        } else {
            if (uRLDrawable.getStatus() == 1) {
                z17 = true;
            }
            bVar.k2(i3, z17);
        }
        return uRLImageView;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        PicInfo picInfo = this.f258907e;
        if (picInfo != null) {
            try {
                URL convertURL = NearbyImgDownloader.convertURL(picInfo.f258917e);
                if (convertURL != null) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mExtraInfo = this.f258907e;
                    URLDrawable drawable = URLDrawable.getDrawable(convertURL, obtain);
                    drawable.setDownloadListener(new ImgDownloadListener(this.f258906d));
                    ThreadManagerV2.postImmediately(new Runnable(drawable) { // from class: com.tencent.mobileqq.picbrowser.PicBrowserImage.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ URLDrawable f258909d;

                        {
                            this.f258909d = drawable;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PicBrowserImage.this, (Object) drawable);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f258909d.downloadImediatly();
                            }
                        }
                    }, null, true);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.common.galleryactivity.k
    public Drawable getAnimationDrawable() {
        URLDrawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f258907e == null) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable2;
        obtain.mLoadingDrawable = drawable2;
        obtain.mPlayGifImage = true;
        PicInfo picInfo = this.f258907e;
        obtain.mExtraInfo = picInfo;
        if (!TextUtils.isEmpty(picInfo.f258919h)) {
            try {
                drawable = URLDrawable.getDrawable(new File(this.f258907e.f258919h).toURL(), obtain);
            } catch (MalformedURLException e16) {
                if (QLog.isDevelopLevel()) {
                    e16.printStackTrace();
                }
            }
        } else {
            if (!TextUtils.isEmpty(this.f258907e.f258918f)) {
                try {
                    URL url = new URL(this.f258907e.f258918f);
                    URL url2 = new URL(ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE, url.getAuthority(), url.getFile());
                    if (AbsDownloader.hasFile(url2.toString())) {
                        drawable = URLDrawable.getDrawable(url2, obtain);
                    } else {
                        URL url3 = new URL(this.f258907e.f258917e);
                        drawable = URLDrawable.getDrawable(new URL(ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE, url3.getAuthority(), url3.getFile()), obtain);
                    }
                } catch (MalformedURLException e17) {
                    if (QLog.isDevelopLevel()) {
                        e17.printStackTrace();
                    }
                }
            }
            drawable = null;
        }
        Rect thumbRect = getThumbRect();
        if (drawable == null || thumbRect == null) {
            return null;
        }
        this.f258908f = k.getCutValue(thumbRect, drawable);
        if (QLog.isColorLevel()) {
            QLog.d("PicBrowser", 2, "getAnimationDrawable ,cutValue = " + this.f258908f);
        }
        return drawable;
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getCutValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f258908f;
    }

    public void j(View view, int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), bVar);
            return;
        }
        URLImageView uRLImageView = (URLImageView) view;
        URLDrawable uRLDrawable = (URLDrawable) uRLImageView.getDrawable();
        if (uRLDrawable == null) {
            return;
        }
        if (uRLDrawable.getStatus() != 1 && uRLDrawable.getStatus() != 2) {
            int progress = uRLDrawable.getProgress();
            if (progress > 0) {
                bVar.q(i3, progress / 100);
            }
        } else {
            if (uRLDrawable.getStatus() == 1) {
                z16 = true;
            }
            bVar.k2(i3, z16);
        }
        uRLImageView.setMinimumHeight(10);
        uRLImageView.setMinimumWidth(10);
    }
}
