package com.tencent.mobileqq.freshnews.feed;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.WindowManager;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NearbyImgLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f211515e;

    /* renamed from: f, reason: collision with root package name */
    public static int f211516f;

    /* renamed from: g, reason: collision with root package name */
    public static int f211517g;

    /* renamed from: h, reason: collision with root package name */
    private static NearbyImgLoader f211518h;

    /* renamed from: a, reason: collision with root package name */
    NearbyImgDownloader f211519a;

    /* renamed from: b, reason: collision with root package name */
    public List<URL> f211520b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<a> f211521c;

    /* renamed from: d, reason: collision with root package name */
    AtomicInteger f211522d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class RequestLoadedImgTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f211523d;

        /* renamed from: e, reason: collision with root package name */
        URL f211524e;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements URLDrawableHandler {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestLoadedImgTask.this);
                }
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void doCancel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                }
            }

            @Override // com.tencent.image.URLDrawableHandler
            public boolean isCancelled() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                }
                return false;
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadFailed(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, i3);
                }
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadStarted() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                }
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void onFileDownloadSucceed(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, j3);
                }
            }

            @Override // com.tencent.image.URLDrawableHandler
            public void publishProgress(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
            }
        }

        public RequestLoadedImgTask(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NearbyImgLoader.this, (Object) url);
                return;
            }
            this.f211523d = 0;
            NearbyImgLoader.this.f211522d.getAndIncrement();
            this.f211524e = url;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f211524e != null) {
                DownloadParams downloadParams = new DownloadParams();
                URL url = this.f211524e;
                downloadParams.url = url;
                String url2 = url.toString();
                downloadParams.urlStr = url2;
                try {
                    File loadImageFile = NearbyImgLoader.this.f211519a.loadImageFile(downloadParams, new a());
                    if (loadImageFile.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.NEARBY_FRESHNEWS, 2, "task run. file exist, url = " + this.f211524e.toString());
                        }
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        try {
                            BaseImageUtil.decodeFileWithBufferedStream(loadImageFile.getAbsolutePath(), options);
                        } catch (OutOfMemoryError e16) {
                            e16.printStackTrace();
                        }
                        if (options.outWidth > ah.M()) {
                            options.inSampleSize = (int) (ah.M() / options.outWidth);
                        }
                        options.inJustDecodeBounds = false;
                        try {
                            bitmap = BaseImageUtil.decodeFileWithBufferedStream(loadImageFile.getAbsolutePath(), options);
                        } catch (OutOfMemoryError e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.NEARBY_FRESHNEWS, 2, "decode bitmap oom!");
                            }
                            e17.printStackTrace();
                        }
                        synchronized (NearbyImgLoader.this.f211521c) {
                            Iterator<a> it = NearbyImgLoader.this.f211521c.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null) {
                                    if (bitmap == null) {
                                        if (this.f211523d < 3) {
                                            NearbyImgLoader.this.b(new URL(url2));
                                            this.f211523d++;
                                        } else {
                                            next.a(url2);
                                        }
                                    } else {
                                        next.b(url2, bitmap);
                                    }
                                }
                            }
                        }
                    }
                    bitmap = null;
                    synchronized (NearbyImgLoader.this.f211521c) {
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
            NearbyImgLoader.this.f211522d.getAndDecrement();
            NearbyImgLoader.this.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    interface a {
        void a(String str);

        void b(String str, Bitmap bitmap);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        int width = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        f211516f = (width - BaseAIOUtils.f(2.0f, context.getResources())) / 2;
        f211515e = width;
        f211517g = context.getResources().getDisplayMetrics().densityDpi;
        f211518h = new NearbyImgLoader();
    }

    NearbyImgLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f211520b = new ArrayList();
        this.f211521c = new ArrayList<>();
        this.f211522d = new AtomicInteger();
        this.f211519a = new NearbyImgDownloader();
    }

    void a() {
        URL url;
        if (this.f211522d.get() < 4) {
            synchronized (this.f211520b) {
                if (this.f211520b.size() > 0) {
                    List<URL> list = this.f211520b;
                    url = list.remove(list.size() - 1);
                } else {
                    url = null;
                }
            }
            if (url != null) {
                ThreadManagerV2.post(new RequestLoadedImgTask(url), 8, null, true);
                return;
            }
            synchronized (this.f211520b) {
                if (this.f211520b.size() > 0) {
                    a();
                }
            }
        }
    }

    public void b(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
            return;
        }
        synchronized (this.f211520b) {
            if (!this.f211520b.contains(url)) {
                this.f211520b.add(url);
            }
        }
        a();
    }
}
