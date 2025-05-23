package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.PttTransitonAnimData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends b {
    static IPatchRedirector $redirector_;

    public i(QQAppInterface qQAppInterface) {
        super("ptt.transition.anim.res.v8820.zip", qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload");
        }
        if (((PttTransitonAnimData) o()) != null && QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload return true");
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void E(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) xmlData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadBegin()");
        }
        super.E(xmlData);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void H(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadProgeress() curOffset=" + j3 + " totalLen=" + j16);
        }
        super.H(j3, j16);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, " PttTransitionAnimHandler download success: " + str);
        }
        try {
            String str2 = AudioTransitionAnimManager.f178233i;
            if (str2 != null && !str2.equals("")) {
                FileUtils.deleteDirectory(str2);
                if (new File(str2).mkdir()) {
                    FileUtils.uncompressZip(str, str2, false);
                    if (QLog.isColorLevel()) {
                        QLog.d("EarlyDown", 2, " PttTransitionAnimHandler uncompressZip success: " + str + " tempPath=" + str2);
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "PttTransitionAnimHandler uncompressZip failed: " + e16.getMessage());
            }
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void j(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) xmlData);
            return;
        }
        if (QLog.isColorLevel() && xmlData != null && (xmlData instanceof JpegSoData)) {
            QLog.d("EarlyDown", 2, "PttTransitionAnimHandler doOnServerResp, xmlData=", xmlData);
        }
        super.j(xmlData);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 10094;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return PttTransitonAnimData.class;
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
        return "PttTransitionAnimZip";
    }
}
