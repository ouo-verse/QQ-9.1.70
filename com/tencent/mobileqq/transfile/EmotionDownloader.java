package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.p;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes19.dex */
public class EmotionDownloader extends AbsDownloader implements EmotionConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String REPORT_CODE = "system_face_decode_copyfile";
    private static final String TAG = "EmotionDownloader";
    static File emotionDir;
    static File rootFile;
    BaseApplicationImpl application;
    public final int exceptionErrorcode;
    public final int fileNotExistErrorcode;

    public EmotionDownloader(BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
            return;
        }
        this.exceptionErrorcode = RichMediaStrategy.POST_DATA_TIMEOUT;
        this.fileNotExistErrorcode = 89501;
        this.application = baseApplicationImpl;
        rootFile = baseApplicationImpl.getDir("", 0);
    }

    public static String getCurrentUin() {
        String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
        if (lastLoginUin != null && lastLoginUin.length() > 0) {
            return lastLoginUin;
        }
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        String value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, file, downloadParams, uRLDrawableHandler);
        }
        try {
            if (file.equals(rootFile)) {
                Header header = downloadParams.getHeader("KEY_STATIC_DRAWABLE_ID");
                if (header != null && (value = header.getValue()) != null) {
                    return BitmapFactory.decodeResource(this.application.getResources(), Integer.valueOf(value).intValue());
                }
                return null;
            }
            if (GifDrawable.isGifFile(file)) {
                return NativeGifFactory.getNativeGifObject(file, false);
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "decode file", e16);
                return null;
            }
            return null;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "decode file", e17);
                return null;
            }
            return null;
        }
    }

    protected File downloadEmoticonImage(DownloadParams downloadParams, p pVar) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) pVar);
        }
        String host = downloadParams.url.getHost();
        File file = new File(emotionDir + "/" + host);
        if (file.exists() && file.length() != 0) {
            if (pVar != null) {
                pVar.L(true);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "downloadImage isGIF !targetFile.exists(),url=" + downloadParams.urlStr + ",drawableName=" + host + ",targetFile=" + file.getAbsolutePath());
            }
            if (pVar != null) {
                Header header = downloadParams.getHeader(EmotcationConstants.IDX);
                if (header != null) {
                    pVar.M(header.getValue());
                }
                pVar.J(false);
                pVar.L(false);
            }
        }
        return file;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        QQAppInterface qQAppInterface;
        IEarlyDownloadService iEarlyDownloadService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        try {
            File file = emotionDir;
            if (file == null || !file.exists()) {
                emotionDir = this.application.getDir("systemface", 0);
                File dir = this.application.getDir("sysface", 0);
                if (dir.exists()) {
                    dir.delete();
                }
                if (!emotionDir.exists()) {
                    emotionDir.mkdirs();
                }
            }
            p pVar = null;
            try {
                qQAppInterface = (QQAppInterface) this.application.getAppRuntime(getCurrentUin());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getting QQApp throws a Exception:" + e16.getMessage());
                }
                qQAppInterface = null;
            }
            if (qQAppInterface != null && (iEarlyDownloadService = (IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")) != null) {
                pVar = (p) iEarlyDownloadService.getEarlyHandler("qq.android.system.face.gifv14");
            }
            File downloadEmoticonImage = downloadEmoticonImage(downloadParams, pVar);
            if (downloadEmoticonImage.exists()) {
                return downloadEmoticonImage;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", Integer.toString(89501));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, REPORT_CODE, false, 0L, 0L, hashMap, "");
            return rootFile;
        } catch (Exception e17) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("param_FailCode", Integer.toString(RichMediaStrategy.POST_DATA_TIMEOUT));
            hashMap2.put("param_FailMsg", ProcessorReport.getExceptionMessage(e17));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, REPORT_CODE, false, 0L, 0L, hashMap2, "");
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, InnerWebView.API_DOWNLOAD_IMAGE, e17);
            }
            return rootFile;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
