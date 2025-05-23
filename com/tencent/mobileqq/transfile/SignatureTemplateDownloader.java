package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.OutputStream;
import mqq.app.AppRuntime;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SignatureTemplateDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String HEADER_FILENAME = "img_filename";
    public static final String HEADER_UIN = "my_uin";
    public static final String PROTOCAL_SIGNATURE_COVER = "sig_cover";
    public static final String PROTOCAL_SIGNATURE_ZIP = "sig_zip";
    private static final String TAG = "SignatureTemplateDownloader";

    public SignatureTemplateDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getSigTplUri(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return IEPRecommendTask.PROMOTION_IMAGE_URL_PREFIX + str;
    }

    public File downLoadImg(AppRuntime appRuntime, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, appRuntime, str, str2, Boolean.valueOf(z16));
        }
        String sigTplUri = getSigTplUri(Integer.parseInt(str), str2);
        File file = new File(SignatureTemplateConfig.getSignatureFilePath(str, str2));
        g gVar = new g(sigTplUri, file);
        gVar.L = z16;
        if (appRuntime != null) {
            if (DownloaderFactory.o(gVar, appRuntime) == 0) {
                if (file.exists() && !SignatureManager.o(file.getAbsolutePath())) {
                    file.delete();
                } else {
                    if (SharpPUtil.isSharpPFile(file)) {
                        return com.tencent.qqsharpP.a.h(file);
                    }
                    return file;
                }
            } else {
                VasMonitorDT.reportErrCode("individual_v2_signature_download_fail", "tlpId:" + str + " errCode:" + gVar.f313006d + " errMsg:" + gVar.f313007e);
            }
        }
        return new File(AppConstants.SDCARD_PATH);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        String file = downloadParams.url.getFile();
        if (file.startsWith(File.separator)) {
            file = file.substring(1);
        }
        String host = downloadParams.url.getHost();
        Header header = downloadParams.getHeader("my_uin");
        if (header != null) {
            str = header.getValue();
        } else {
            str = null;
        }
        AppRuntime appRuntime = BaseApplicationImpl.sApplication.getAppRuntime(str);
        File file2 = new File(SignatureTemplateConfig.getSignatureFilePath(file, host));
        if (file2.exists()) {
            return file2;
        }
        if (downloadParams.useSharpPImage) {
            File file3 = new File(com.tencent.qqsharpP.a.a(file2));
            if (file3.exists()) {
                return file3;
            }
        }
        return downLoadImg(appRuntime, file, host, downloadParams.useSharpPImage);
    }
}
