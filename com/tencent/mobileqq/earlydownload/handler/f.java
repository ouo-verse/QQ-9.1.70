package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegSoLoad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends b {
    static IPatchRedirector $redirector_;
    QQAppInterface E;
    long F;
    boolean G;

    public f(QQAppInterface qQAppInterface) {
        super(M(), qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.F = 0L;
        this.G = true;
        this.E = qQAppInterface;
    }

    public static String M() {
        String str = Build.CPU_ABI;
        return "qq.android.pic.jpeg.so_v8_820";
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            if (o().loadState == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("QJpegSoDownloadHandler", 2, "is in downloading");
                    return;
                }
                return;
            }
            super.I(z16);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        String jpegSolibPath = JpegSoLoad.getJpegSolibPath(BaseApplication.getContext());
        String str2 = jpegSolibPath + JpegSoLoad.getLibActualName(JpegSoLoad.SO_NAME);
        boolean z16 = false;
        try {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("QJpegSoDownloadHandler", 2, "download success: " + str + " ,so path:" + str2);
                }
                FileUtils.uncompressZip(str, jpegSolibPath, false);
                ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFile(BaseApplication.getContext(), new File(str2));
                String b16 = com.tencent.mobileqq.scribble.f.b(str2);
                XmlData o16 = o();
                if (o16 instanceof JpegSoData) {
                    JpegSoData jpegSoData = (JpegSoData) o16;
                    if (QLog.isColorLevel()) {
                        QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess, soMD5:" + b16 + " soData.SO_MD5:" + jpegSoData.SO_MD5);
                    }
                    if (b16.equalsIgnoreCase(jpegSoData.SO_MD5)) {
                        JpegCompressor.jpegcompressLoadSo();
                        z16 = true;
                    }
                }
                if (!z16) {
                    FileUtils.deleteFile(str2);
                    FileUtils.deleteFile(str);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("QJpegSoDownloadHandler", 2, e16, new Object[0]);
                }
                FileUtils.deleteFile(str2);
                FileUtils.deleteFile(str);
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder();
                }
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("doOnDownloadSuccess,suc:");
                sb5.append(z16);
                QLog.d("QJpegSoDownloadHandler", 2, sb5.toString());
            }
            super.i(str);
        } catch (Throwable th5) {
            FileUtils.deleteFile(str2);
            FileUtils.deleteFile(str);
            if (QLog.isColorLevel()) {
                QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:false");
            }
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void j(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) xmlData);
            return;
        }
        if (QLog.isColorLevel() && xmlData != null && (xmlData instanceof JpegSoData)) {
            QLog.d("QJpegSoDownloadHandler", 2, "doOnServerResp, xmlData=", xmlData);
        }
        super.j(xmlData);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 10043;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return JpegSoData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "qjpegDownloadSoDuration";
    }
}
