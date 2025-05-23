package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.utils.NetworkUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ThumbnailDownloader extends ProtocolDownloader.Adapter implements ProtocolDownloaderConstants {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ThumbnailDownloader";
    private Context mContext;
    private DiskCache mDiskCache;
    private boolean mIsSupportBreakPoint;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class DownloadListenerImpl implements y43.b {
        static IPatchRedirector $redirector_;
        private File mDirtyFile;
        private URLDrawableHandler mHandler;

        public DownloadListenerImpl(File file, URLDrawableHandler uRLDrawableHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThumbnailDownloader.this, file, uRLDrawableHandler);
            } else {
                this.mDirtyFile = file;
                this.mHandler = uRLDrawableHandler;
            }
        }

        private void clearDirtyFile() {
            File file = this.mDirtyFile;
            if (file != null && file.exists()) {
                this.mDirtyFile.delete();
            }
        }

        @Override // y43.b
        public void onDownloadFinished(String str, String str2, boolean z16, String str3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3));
                return;
            }
            synchronized (this.mDirtyFile) {
                if (!z16) {
                    QLog.e(ThumbnailDownloader.TAG, 4, "download failed path =" + str2);
                    clearDirtyFile();
                }
                this.mDirtyFile.notify();
                if (!z16) {
                    this.mHandler.onFileDownloadFailed(i3);
                } else {
                    this.mHandler.onFileDownloadSucceed(this.mDirtyFile.length());
                }
            }
        }

        @Override // y43.b
        public void onDownloadProgress(String str, long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Float.valueOf(f16));
            }
        }
    }

    public ThumbnailDownloader(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
            return;
        }
        this.mContext = context;
        this.mIsSupportBreakPoint = z16;
        this.mDiskCache = initDiskCache();
    }

    private String buildThumbnailUrl(Context context, String str, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        int networkType = NetworkUtils.getNetworkType(context);
        sb5.append("&nettype=");
        sb5.append(networkType);
        if (i3 > 0 && i16 > 0) {
            sb5.append("&size=");
            sb5.append(i3);
            sb5.append("*");
            sb5.append(i16);
        }
        return sb5.toString();
    }

    private File downloadImage(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String str = downloadParams.urlStr;
        ((IWeiyunUploadDownloadService) QRoute.api(IWeiyunUploadDownloadService.class)).downloadImage(str, file.getAbsolutePath(), generateKey(shrinkUrl(str)), new DownloadListenerImpl(file, uRLDrawableHandler));
        synchronized (file) {
            try {
                file.wait(30000L);
            } catch (InterruptedException unused) {
            }
        }
        return file;
    }

    private String generateKey(String str) {
        return com.tencent.securitysdk.utils.c.b(str);
    }

    private final boolean hasFile(String str) {
        if (str != null) {
            if (this.mDiskCache.getCleanFile(generateKey(shrinkUrl(str))).exists()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private DiskCache initDiskCache() {
        File cacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = this.mContext.getCacheDir();
        }
        return new DiskCache(new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE));
    }

    private String shrinkUrl(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceFirst("cn=\\d", "").replaceFirst("nettype=\\d", "");
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public final boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams)).booleanValue();
        }
        if (!useDiskCache()) {
            return false;
        }
        return hasFile(downloadParams.urlStr);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        if (useDiskCache()) {
            String buildThumbnailUrl = buildThumbnailUrl(this.mContext, downloadParams.urlStr, downloadParams.reqWidth, downloadParams.reqHeight);
            downloadParams.urlStr = buildThumbnailUrl;
            String shrinkUrl = shrinkUrl(buildThumbnailUrl);
            String generateKey = generateKey(shrinkUrl);
            if (hasFile(downloadParams.urlStr)) {
                uRLDrawableHandler.onFileDownloadSucceed(0L);
                return this.mDiskCache.getCleanFile(generateKey);
            }
            DiskCache.Editor edit = this.mDiskCache.edit(generateKey);
            try {
                if (this.mIsSupportBreakPoint) {
                    downloadParams.downloaded = edit.dirtyFile.length();
                }
                uRLDrawableHandler.onFileDownloadStarted();
                downloadImage(edit.dirtyFile, downloadParams, uRLDrawableHandler);
                return edit.commit();
            } catch (Exception e16) {
                if (edit != null) {
                    edit.abort(this.mIsSupportBreakPoint);
                }
                f.d("PIC_TAG_ERROR", "loadImageFile", "outFilePath:" + shrinkUrl + ",url:" + downloadParams.urlStr);
                e16.printStackTrace();
                uRLDrawableHandler.onFileDownloadFailed(0);
                throw e16;
            }
        }
        return downloadImage(null, downloadParams, uRLDrawableHandler);
    }

    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
