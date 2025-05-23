package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDownloader;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderX5;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VasApngDownloader extends AbstractImageDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String BUNDLE_KEY_BID = "bundle_key_bid";
    public static final String BUNDLE_KEY_SCID = "bundle_key_scid";
    public static final String PROTOCAL_VAS_APNG = "vasapngdownloader";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class VasApngImage extends ApngImage {
        static IPatchRedirector $redirector_ = null;
        public static final String KEY_FRAME_DELAY_FRACTION = "key_frame_delay_fraction";
        private float frameDelayFraction;

        public VasApngImage(File file, boolean z16, Bundle bundle) throws IOException {
            super(file, z16, bundle);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16), bundle);
            } else {
                this.frameDelayFraction = 0.0f;
                this.frameDelayFraction = bundle.getFloat(KEY_FRAME_DELAY_FRACTION, 0.0f);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.image.ApngImage
        public synchronized boolean getNextFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (super.getNextFrame()) {
                float f16 = this.frameDelayFraction;
                if (f16 > 0.0f) {
                    this.currentFrameDelay = (int) (this.currentFrameDelay * f16);
                }
                return true;
            }
            return false;
        }
    }

    public VasApngDownloader() {
        super("VasApngDownloader", BaseApplicationImpl.getApplication());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int newDownload(g gVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ((IVasDownloader) QRoute.api(IVasDownloader.class)).startDownload(gVar, new f(countDownLatch) { // from class: com.tencent.mobileqq.transfile.VasApngDownloader.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ CountDownLatch val$latch;

            {
                this.val$latch = countDownLatch;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VasApngDownloader.this, (Object) countDownLatch);
                }
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onCancel(g gVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar2);
                } else {
                    super.onCancel(gVar2);
                    this.val$latch.countDown();
                }
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onDone(g gVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar2);
                } else {
                    super.onDone(gVar2);
                    this.val$latch.countDown();
                }
            }

            @Override // com.tencent.mobileqq.vip.f
            public void onProgress(g gVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar2);
                } else {
                    super.onProgress(gVar2);
                }
            }

            @Override // com.tencent.mobileqq.vip.f
            public boolean onStart(g gVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar2)).booleanValue();
                }
                return super.onStart(gVar2);
            }
        }, null);
        try {
            if (countDownLatch.await(30L, TimeUnit.SECONDS)) {
                return gVar.f313006d;
            }
            return -100001;
        } catch (InterruptedException e16) {
            QLog.e(BaseImageDownloader.TAG, 1, e16.getMessage());
            return FileReaderX5.ERR_CODE_NOT_SUPPORT;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbstractImageDownloader, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        Bundle bundle = null;
        if (ApngDrawable.isApngFile(file)) {
            if (!file.exists() || !downloadParams.useApngImage) {
                return null;
            }
            Object obj = downloadParams.mExtraInfo;
            if (obj instanceof Bundle) {
                bundle = (Bundle) obj;
            }
            VasApngImage vasApngImage = new VasApngImage(file, true, bundle);
            if (vasApngImage.firstFrame == null) {
                ChatBackgroundManager.w(file.getAbsolutePath());
            }
            return vasApngImage;
        }
        if (file == null) {
            QLog.e("vasapngdownloader", 1, "decodeFile error : file == null");
            return null;
        }
        return super.decodeFile(file, downloadParams, uRLDrawableHandler);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Bundle bundle;
        String str;
        long j3;
        int o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams == null) {
            return null;
        }
        String host = downloadParams.url.getHost();
        File file = new File(host);
        Object obj = downloadParams.mExtraInfo;
        if (obj instanceof Bundle) {
            bundle = (Bundle) obj;
        } else {
            bundle = null;
        }
        boolean z16 = false;
        if (bundle != null) {
            long j16 = bundle.getLong("bundle_key_bid", 0L);
            str = bundle.getString("bundle_key_scid");
            if (j16 != 0 && !TextUtils.isEmpty(str)) {
                z16 = true;
            }
            j3 = j16;
        } else {
            str = null;
            j3 = 0;
        }
        if (!file.exists()) {
            if (z16) {
                VasUpdateUtil.getFileFromLocal(BaseApplicationImpl.sApplication.getRuntime(), j3, str, null, true, null);
                if (QLog.isColorLevel()) {
                    QLog.e("vasapngdownloader", 2, "downloadImage method err, scid=" + str + ", path=" + host);
                }
                return null;
            }
            String file2 = downloadParams.url.getFile();
            if (TextUtils.isEmpty(file2)) {
                QLog.e("vasapngdownloader", 2, "downloadImage url err, url=" + file2 + ", path=" + host);
                return null;
            }
            if (file2.startsWith(File.separator)) {
                file2 = file2.substring(1);
            }
            if (!file2.startsWith("http")) {
                if (QLog.isColorLevel()) {
                    QLog.e("vasapngdownloader", 2, "downloadImage url has no http err, url=" + file2 + ", path=" + host);
                }
                return null;
            }
            g gVar = new g(file2, file);
            gVar.D = true;
            if (VasNormalToggle.VAS_BUG_118346413.isEnable(true)) {
                o16 = newDownload(gVar);
            } else {
                o16 = DownloaderFactory.o(gVar, BaseApplicationImpl.sApplication.getRuntime());
            }
            if (o16 == 0) {
                if (!file.exists()) {
                    QLog.e("vasapngdownloader", 2, "downloadImage file not exists, url=" + file2 + ", path=" + host + ", ret:" + o16);
                    return null;
                }
            } else {
                QLog.e("vasapngdownloader", 1, "downloadImage Error url=" + file2 + ", path=" + host + ", ret:" + o16);
                return null;
            }
        }
        return file;
    }
}
