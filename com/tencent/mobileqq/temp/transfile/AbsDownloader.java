package com.tencent.mobileqq.temp.transfile;

import android.os.Environment;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.temp.transfile.a;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class AbsDownloader extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "AbsDownloader";
    public static a sDiskCache;

    static {
        File cacheDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43837);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        sDiskCache = new a(new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE));
    }

    public AbsDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final File getFile(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(getFilePath(str));
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    public static final String getFileName(String str) {
        return "Cache_" + Utils.Crc64String(str);
    }

    public static final String getFilePath(String str) {
        if (str == null) {
            return null;
        }
        return sDiskCache.c() + File.separator + getFileName(str);
    }

    public static final boolean hasFile(String str) {
        if (str == null) {
            return false;
        }
        if (str.toLowerCase(Locale.US).startsWith("file")) {
            String str2 = null;
            try {
                if (str.substring(0, 5).equalsIgnoreCase(HippyBridge.URI_SCHEME_FILE)) {
                    str2 = str.substring(5);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
            if (str2 != null) {
                return new File(str2).exists();
            }
        }
        if (getFile(str) == null) {
            return false;
        }
        return true;
    }

    void asynCommitBitmapFile(a.C8644a c8644a, File file) {
        ThreadManager.getFileThreadHandler().post(new Runnable(c8644a) { // from class: com.tencent.mobileqq.temp.transfile.AbsDownloader.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a.C8644a f292631d;

            {
                this.f292631d = c8644a;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsDownloader.this, (Object) c8644a);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    this.f292631d.b();
                } catch (IOException e16) {
                    QLog.e(AbsDownloader.TAG, 2, e16.getMessage());
                    a.C8644a c8644a2 = this.f292631d;
                    if (c8644a2 != null) {
                        c8644a2.a(false);
                    }
                }
            }
        });
    }

    public abstract File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception;

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    File downloadImageToCache(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, String str) throws Exception {
        File file;
        a.C8644a a16 = sDiskCache.a(getFileName(str));
        boolean supportBreakpointContinuingly = supportBreakpointContinuingly();
        FileOutputStream fileOutputStream = null;
        if (supportBreakpointContinuingly) {
            try {
                downloadParams.downloaded = a16.f292633a.length();
                supportBreakpointContinuingly &= !needRestart(downloadParams);
            } catch (Exception e16) {
                e = e16;
                file = null;
                if (a16 != null) {
                }
                e.printStackTrace();
                throw e;
            } catch (Throwable th5) {
                th = th5;
                file = null;
                releaseStream(fileOutputStream, file);
                throw th;
            }
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(a16.f292633a, supportBreakpointContinuingly);
        try {
            File downloadImage = downloadImage(fileOutputStream2, downloadParams, uRLDrawableHandler);
            if (str.endsWith("?noRound")) {
                str = str.substring(0, str.indexOf("?noRound"));
            }
            File file2 = getFile(str);
            if (file2 != null) {
                a16.f292633a.delete();
                releaseStream(fileOutputStream2, downloadImage);
                return file2;
            }
            if (isCommitBimapFileAsyn(downloadImage)) {
                asynCommitBitmapFile(a16, downloadImage);
                releaseStream(fileOutputStream2, downloadImage);
                return downloadImage;
            }
            File b16 = a16.b();
            releaseStream(fileOutputStream2, downloadImage);
            return b16;
        } catch (Exception e17) {
            e = e17;
            file = null;
            fileOutputStream = fileOutputStream2;
            if (a16 != null) {
                try {
                    a16.a(supportBreakpointContinuingly);
                } catch (Throwable th6) {
                    th = th6;
                    releaseStream(fileOutputStream, file);
                    throw th;
                }
            }
            e.printStackTrace();
            throw e;
        } catch (Throwable th7) {
            th = th7;
            file = null;
            fileOutputStream = fileOutputStream2;
            releaseStream(fileOutputStream, file);
            throw th;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams)).booleanValue();
        }
        if (!useDiskCache()) {
            return false;
        }
        return hasFile(downloadParams.urlStr);
    }

    protected boolean isCommitBimapFileAsyn(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) file)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        if (useDiskCache()) {
            String str = downloadParams.urlStr;
            File file = getFile(str);
            if (file != null) {
                if (uRLDrawableHandler != null) {
                    uRLDrawableHandler.onFileDownloadSucceed(file.length());
                }
                return file;
            }
            if (downloadParams.mHttpDownloaderParams != null) {
                downloadImage(null, downloadParams, uRLDrawableHandler);
                return file;
            }
            return downloadImageToCache(downloadParams, uRLDrawableHandler, str);
        }
        return downloadImage(null, downloadParams, uRLDrawableHandler);
    }

    public boolean needRestart(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadParams)).booleanValue();
        }
        return false;
    }

    protected void releaseStream(OutputStream outputStream, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) outputStream, (Object) file);
        } else if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public boolean supportBreakpointContinuingly() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }
}
