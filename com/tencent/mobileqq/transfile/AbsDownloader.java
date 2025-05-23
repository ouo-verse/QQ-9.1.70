package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.os.Environment;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLState;
import com.tencent.image.Utils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vfs.d;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class AbsDownloader extends ProtocolDownloader.Adapter implements ProtocolDownloaderConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String CHAT_IMAGE_ROOT;
    public static final String PROTOCAL_FAVORITE_IMAGE = "favimage";
    public static final String PROTOCOL_PUB_ACCOUNT = "pubaccountimage";
    protected static final String TAG = "AbsDownloader";
    public static DiskCache sDiskCache;

    static {
        File cacheDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        } else {
            cacheDir = MobileQQ.sMobileQQ.getCacheDir();
        }
        sDiskCache = new DiskCache(new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE));
        CHAT_IMAGE_ROOT = d.f312453c;
    }

    public AbsDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String covertUrlForAioImage(String str) {
        if (str != null) {
            try {
                if (str.substring(0, 8).equalsIgnoreCase(ProtocolDownloaderConstants.PROTOCOL_AIO_THUMB)) {
                    String str2 = "chatthumb" + str.substring(8);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getUrlStringForDisk newUrl = " + str2);
                    }
                    return str2;
                }
            } catch (IndexOutOfBoundsException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getUrlStringForDisk IndexOutOfBoundsException" + e16);
                }
            }
        }
        return str;
    }

    public static String generateChatImgPath(String str, String str2) {
        String substring = str2.substring(str2.length() - 3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(CHAT_IMAGE_ROOT);
        stringBuffer.append(str);
        String str3 = File.separator;
        stringBuffer.append(str3);
        stringBuffer.append(substring);
        stringBuffer.append(str3);
        stringBuffer.append(str2);
        return RmVFSUtils.getVFSPath(stringBuffer.toString());
    }

    public static String getDisplayFilePath(String str) {
        return getFilePath(str) + "_dp";
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
        if (str != null && str.startsWith("pubaccountimage")) {
            str = str.replace("pubaccountimage:", "");
        }
        return "Cache_" + Utils.Crc64String(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a5, code lost:
    
        if (new java.io.File(r1).exists() != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getFilePath(String str) {
        String generateChatImgPath;
        if (str == null) {
            return null;
        }
        String fileName = getFileName(str);
        String str2 = sDiskCache.getDirectory() + File.separator + fileName;
        String protocol2 = getProtocol(str);
        if ("chatthumb".equals(protocol2)) {
            generateChatImgPath = generateChatImgPath(protocol2, fileName);
            boolean z16 = false;
            if (new File(generateChatImgPath + "_hd").exists()) {
                generateChatImgPath = generateChatImgPath + "_hd";
            } else {
                if (new File(str2 + "_hd").exists()) {
                    str2 = str2 + "_hd";
                    generateChatImgPath = generateChatImgPath + "_hd";
                }
                z16 = true;
            }
            if (z16) {
                migrateChatImage(str, str2, generateChatImgPath);
            }
        } else if (ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE.equals(protocol2)) {
            generateChatImgPath = generateChatImgPath(protocol2, fileName);
            if (new File(str2).exists()) {
                migrateChatImage(str, str2, generateChatImgPath);
            }
        } else if (ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW.equals(protocol2)) {
            generateChatImgPath = generateChatImgPath(protocol2, fileName);
            if (new File(str2).exists()) {
                migrateChatImage(str, str2, generateChatImgPath);
            }
        } else {
            return str2;
        }
        return generateChatImgPath;
    }

    public static final File getFlashPicFile(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(getFilePath(str) + "_fp");
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    @Nullable
    static String getProtocol(String str) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            url = null;
        }
        if (url == null) {
            return null;
        }
        return url.getProtocol();
    }

    public static final VFSFile getVFSFile(String str) {
        if (str == null) {
            return null;
        }
        VFSFile vFSFile = new VFSFile(getFilePath(str));
        if (!vFSFile.exists()) {
            return null;
        }
        return vFSFile;
    }

    public static final boolean hasFile(String str) {
        String[] split;
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (str.startsWith(ProtocolDownloaderConstants.PROTOCOL_REGIONAL_THUMB)) {
            try {
                if (str.substring(0, 14).equalsIgnoreCase("regionalthumb:")) {
                    str2 = str.substring(14);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
            if (str2 == null || (split = str2.split("\\|")) == null) {
                return false;
            }
            return new File(split[0]).exists();
        }
        if (str.toLowerCase(Locale.US).startsWith("file")) {
            try {
                if (str.substring(0, 5).equalsIgnoreCase(HippyBridge.URI_SCHEME_FILE)) {
                    str2 = str.substring(5);
                }
            } catch (IndexOutOfBoundsException unused2) {
            }
            if (str2 == null) {
                return false;
            }
            return new File(str2).exists();
        }
        String covertUrlForAioImage = covertUrlForAioImage(str);
        if (covertUrlForAioImage == null || getFile(covertUrlForAioImage) == null) {
            return false;
        }
        return true;
    }

    public static void migrateChatImage(String str, String str2, String str3) {
        int quickMove = FileUtils.quickMove(str2, str3);
        if (QLog.isColorLevel()) {
            QLog.d("ChatImageMigrate", 2, "migrate:" + str + " from:" + str2 + " to:" + str3 + " status:" + quickMove);
        }
    }

    void asynCommitBitmapFile(DiskCache.Editor editor, File file) {
        ThreadManager.getFileThreadHandler().post(new Runnable(editor) { // from class: com.tencent.mobileqq.transfile.AbsDownloader.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ DiskCache.Editor val$editor;

            {
                this.val$editor = editor;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsDownloader.this, (Object) editor);
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
                    this.val$editor.commit();
                } catch (IOException e16) {
                    QLog.e(AbsDownloader.TAG, 2, e16.getMessage());
                    DiskCache.Editor editor2 = this.val$editor;
                    if (editor2 != null) {
                        editor2.abort(false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int calculateSampleSize(BitmapFactory.Options options, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, options, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return URLState.calculateInSampleSize(options, i3, i16);
    }

    public abstract File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception;

    /* JADX WARN: Removed duplicated region for block: B:31:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    File downloadImageToCache(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, String str) throws Exception {
        File file;
        String fileName = getFileName(str);
        DiskCache.Editor edit = sDiskCache.edit(fileName);
        boolean supportBreakpointContinuingly = supportBreakpointContinuingly();
        FileOutputStream fileOutputStream = null;
        if (supportBreakpointContinuingly) {
            try {
                downloadParams.downloaded = edit.dirtyFile.length();
                supportBreakpointContinuingly &= !needRestart(downloadParams);
            } catch (Exception e16) {
                e = e16;
                file = null;
                if (edit != null) {
                }
                TransFileUtil.printRichMediaError("PIC_TAG_ERROR", "loadImageFile", "outFilePath:" + fileName + ",url:" + str);
                e.printStackTrace();
                throw e;
            } catch (Throwable th5) {
                th = th5;
                file = null;
                releaseStream(fileOutputStream, file);
                throw th;
            }
        }
        FileOutputStream fileOutputStream2 = new FileOutputStream(edit.dirtyFile, supportBreakpointContinuingly);
        try {
            File downloadImage = downloadImage(fileOutputStream2, downloadParams, uRLDrawableHandler);
            if (str.endsWith("?noRound")) {
                str = str.substring(0, str.indexOf("?noRound"));
            }
            File file2 = getFile(str);
            if (file2 != null) {
                TransFileUtil.printRichMediaDebug(TAG, "loadImageFile", "f exist:" + file2.getAbsolutePath());
                edit.dirtyFile.delete();
                releaseStream(fileOutputStream2, downloadImage);
                return file2;
            }
            if (isCommitBimapFileAsyn(downloadImage)) {
                asynCommitBitmapFile(edit, downloadImage);
                releaseStream(fileOutputStream2, downloadImage);
                return downloadImage;
            }
            File commit = edit.commit();
            releaseStream(fileOutputStream2, downloadImage);
            return commit;
        } catch (Exception e17) {
            e = e17;
            file = null;
            fileOutputStream = fileOutputStream2;
            if (edit != null) {
                try {
                    edit.abort(supportBreakpointContinuingly);
                } catch (Throwable th6) {
                    th = th6;
                    releaseStream(fileOutputStream, file);
                    throw th;
                }
            }
            TransFileUtil.printRichMediaError("PIC_TAG_ERROR", "loadImageFile", "outFilePath:" + fileName + ",url:" + str);
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
                TransFileUtil.printRichMediaDebug(TAG, "loadImageFile", "urlString:" + str + " ,file exist:" + file.getAbsolutePath());
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
