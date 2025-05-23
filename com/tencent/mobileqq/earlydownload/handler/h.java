package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends b {
    static IPatchRedirector $redirector_;

    public h(QQAppInterface qQAppInterface) {
        super("qq.android.ptt.so.658", qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        PttSilkAndChangeVoiceSoData pttSilkAndChangeVoiceSoData = (PttSilkAndChangeVoiceSoData) o();
        boolean z16 = false;
        if (pttSilkAndChangeVoiceSoData == null) {
            return false;
        }
        int cpuArchitecture = AVCoreSystemInfo.getCpuArchitecture();
        if (QLog.isColorLevel()) {
            QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload cpuArch = " + cpuArchitecture + " isUserNeedDownload try match version=" + AppSetting.f99551k + " data.version=" + pttSilkAndChangeVoiceSoData.version);
        }
        SharedPreferences preferences = this.f203921f.getPreferences();
        if (!preferences.getBoolean("hasReportedCpuArch", false)) {
            PttInfoCollector.reportMyCpuArch();
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean("hasReportedCpuArch", true);
            edit.commit();
        }
        if (cpuArchitecture > 2) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload return " + z16);
        }
        return z16;
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
            QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "download success: " + str);
        }
        try {
            String b16 = com.tencent.mobileqq.qqaudio.silk.a.b();
            if (b16 != null && !b16.equals("")) {
                FileUtils.deleteDirectory(b16);
                if (new File(b16).mkdir()) {
                    FileUtils.uncompressZip(str, b16, false);
                    if (QLog.isColorLevel()) {
                        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip success: " + str);
                    }
                    synchronized ("SilkSoLoader") {
                        if (!com.tencent.mobileqq.qqaudio.silk.a.f262234a) {
                            FileUtils.deleteDirectory(com.tencent.mobileqq.qqaudio.silk.a.a());
                            FileUtils.rename(b16, com.tencent.mobileqq.qqaudio.silk.a.a());
                        }
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip failed: " + e16.getMessage());
            }
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 10007;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return PttSilkAndChangeVoiceSoData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "actEarlyPttSilkAndChangeVoiceSo";
    }
}
