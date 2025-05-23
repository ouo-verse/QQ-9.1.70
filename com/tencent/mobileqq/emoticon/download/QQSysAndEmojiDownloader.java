package com.tencent.mobileqq.emoticon.download;

import android.graphics.BitmapFactory;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.temp.transfile.AbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSysAndEmojiDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String REPORT_APNG_EMOTICON = "EmoticonApngReport";
    private static final String TAG = "QQSysAndEmojiDownloader";

    public QQSysAndEmojiDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void checkFileStatus(File file) {
        long j3;
        try {
            boolean exists = file.exists();
            if (exists) {
                j3 = file.length();
            } else {
                j3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Decode Failed.File:" + file.getAbsolutePath() + " isExist:" + exists + " length:" + j3);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "checkFileStatus:" + e16);
        }
    }

    private String genResFilePath(String str, int i3) {
        int i16;
        int i17;
        int i18;
        if ("host_emoji".equals(str)) {
            i18 = QQEmojiUtil.getEmojiUnicode(i3);
            i17 = 3;
        } else {
            if ("host_qqsys_apng".equals(str)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            int convertToServer = QQSysFaceUtil.convertToServer(i3);
            i17 = i16;
            i18 = convertToServer;
        }
        return QQSysAndEmojiResMgr.getInstance().getFullResPath(i17, i18);
    }

    protected boolean checkIsStatic(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        return QQSysFaceUtil.isStaticFace(i3);
    }

    protected Object decodeApngImage(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, (Object) file);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "decodeFile isAPNGFile, path = " + file.getAbsolutePath());
        }
        ApngImage apngImage = new ApngImage(file, true, null);
        apngImage.setDensity(320);
        return apngImage;
    }

    protected Object decodeBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return BitmapFactory.decodeFile(str);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (file == null) {
            return null;
        }
        if (GifDrawable.isGifFile(file)) {
            return decodeGifFile(file);
        }
        if (downloadParams != null && "host_qqsys_apng".equals(downloadParams.url.getHost()) && isApngFile(file)) {
            try {
                return decodeApngImage(file);
            } catch (Throwable th5) {
                QLog.e(TAG, 2, th5, new Object[0]);
                reportEmoticonApngFailEvent(th5.toString(), file.getName());
                return decodeBitmap(file.getAbsolutePath());
            }
        }
        Object decodeBitmap = decodeBitmap(file.getAbsolutePath());
        if (decodeBitmap == null) {
            checkFileStatus(file);
        }
        return decodeBitmap;
    }

    protected Object decodeGifFile(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, (Object) file);
        }
        return NativeGifFactory.getNativeGifObject(file, false);
    }

    @Override // com.tencent.mobileqq.temp.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        String host = downloadParams.url.getHost();
        String file = downloadParams.url.getFile();
        try {
            parseInt = Integer.parseInt(file.substring(1));
        } catch (Exception unused) {
            QLog.d(TAG, 1, "[downloadImage] parse localId from drawableName error. url=", downloadParams.url);
            Header header = downloadParams.getHeader(QQSysAndEmojiResInfo.EMO_ID);
            if (header == null) {
                return null;
            }
            try {
                parseInt = Integer.parseInt(header.getValue());
            } catch (Exception unused2) {
                QLog.d(TAG, 1, "[downloadImage] parse localId from header error. url=", downloadParams.url);
                return null;
            }
        }
        File file2 = new File(genResFilePath(host, parseInt));
        if (file2.exists()) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "found file:", file);
            }
            return file2;
        }
        QLog.d(TAG, 1, String.format("file[%s] not found, loading[%s], host[%s]", file, Integer.valueOf(parseInt), host));
        if ("host_qqsys_apng".equals(host)) {
            if (checkIsStatic(parseInt)) {
                File file3 = new File(genResFilePath("host_qqsys_static", parseInt));
                if (file3.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "static file exist:", Integer.valueOf(parseInt));
                    }
                    return file3;
                }
            }
            needToReload(1, parseInt);
        } else if ("host_qqsys_static".equals(host)) {
            needToReload(1, parseInt);
        } else if ("host_emoji".equals(host)) {
            needToReload(2, parseInt);
        }
        return null;
    }

    protected boolean isApngFile(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file)).booleanValue();
        }
        return ApngDrawable.isApngFile(file);
    }

    protected void needToReload(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            QQSysAndEmojiResMgr.getInstance().getResImpl(i3).addReloadDrawable(i16);
        }
    }

    protected void reportEmoticonApngFailEvent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("error_msg", str);
        hashMap.put("error_res_file", str2);
        StatisticCollector.d(BaseApplication.getContext()).c(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), REPORT_APNG_EMOTICON, false, 0L, 0L, hashMap, null);
    }
}
