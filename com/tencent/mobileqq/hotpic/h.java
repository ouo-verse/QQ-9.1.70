package com.tencent.mobileqq.hotpic;

import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends b {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static URL f(String str) {
        try {
            return new URL("hot_pic_origin", "", str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.hotpic.b
    protected String c(HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) hotPicData);
        }
        return hotPicData.originalUrl;
    }

    @Override // com.tencent.mobileqq.hotpic.b, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        HotPicData hotPicData = (HotPicData) downloadParams.mExtraInfo;
        String c16 = c(hotPicData);
        File diskFile = b.getDiskFile(c16);
        if (diskFile.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager.HotPicOriginDownLoader", 2, "loadImageFile file exist:" + diskFile.getAbsolutePath());
            }
            return diskFile;
        }
        diskFile.getParentFile().mkdirs();
        if (Utils.B() && Utils.z() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
            throw new IOException("SD card free space is " + Utils.z());
        }
        File file = new File(b.f237006d);
        if (!file.exists()) {
            file.mkdir();
        }
        int a16 = a(c16, diskFile);
        if (a16 == 0) {
            if (!hotPicData.originalMD5.equalsIgnoreCase(com.tencent.mobileqq.portal.o.e(diskFile.getAbsolutePath()))) {
                diskFile.delete();
                uRLDrawableHandler.onFileDownloadFailed(0);
                return null;
            }
            uRLDrawableHandler.onFileDownloadSucceed(diskFile.length());
            if (QLog.isColorLevel()) {
                QLog.d("HotPicManager.HotPicOriginDownLoader", 2, "url->" + c16 + " result->0");
            }
            return diskFile;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotPicManager.HotPicOriginDownLoader", 2, "url->" + c16 + " result->" + a16);
        }
        return null;
    }
}
