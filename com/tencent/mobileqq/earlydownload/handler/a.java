package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.earlydownload.xmldata.ArNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotificationController;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    public a(QQAppInterface qQAppInterface) {
        super("qq.android.ar.native.so64_v8.0.0", qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void I(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        M(false, z16);
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownload " + z16);
        }
    }

    public void M(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (z16) {
            super.I(z17);
            return;
        }
        if (o() != null && o().loadState == 2) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownloadForce is in downloading");
                return;
            }
            return;
        }
        super.I(z17);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        byte a16 = ArNativeSoLoader.a(str);
        if (QLog.isColorLevel()) {
            QLog.d("ArConfig_NativeSoDownloadHandler", 2, "download success: " + str + ",result=" + ((int) a16));
        }
        if (a16 == 0) {
            BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", v()).commit();
        } else {
            o().loadState = 0;
            o().Version = 0;
            com.tencent.mobileqq.earlydownload.a.f(o(), new String[0]);
        }
        try {
            String string = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("ar_native_ArMapEngine800Arch64", "");
            if (!TextUtils.isEmpty(string)) {
                AppRuntime appRuntime = this.f203921f;
                String valueOf = String.valueOf(o().Version);
                if (TextUtils.isEmpty(string)) {
                    str2 = "0";
                } else {
                    str2 = string;
                }
                ReportController.o(appRuntime, "dc01440", "", "", "0X8007A3D", "0X8007A3D", 0, 0, "", valueOf, str2, "qq.android.ar.native.so64_v8.0.0");
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(NotificationController.Constants.CONFIG_VERSION, String.valueOf(o().Version));
                hashMap.put("md5", string);
                hashMap.put("res_name", "qq.android.ar.native.so64_v8.0.0");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f203921f.getCurrentAccountUin(), "armap_so_update_rate", true, 0L, 0L, hashMap, "", false);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void j(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) xmlData);
            return;
        }
        try {
            SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("ArNativeSoDownloadHandler", 4);
            if (sharedPreferences.getBoolean("qq.android.ar.native.so64_v8.0.0", true)) {
                sharedPreferences.edit().putBoolean("qq.android.ar.native.so64_v8.0.0", false).commit();
                for (File file : new File(ArNativeSoLoader.b() + File.separator).listFiles()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArConfig_NativeSoDownloadHandler", 2, "File name=" + file.getAbsolutePath());
                    }
                    if (file.isFile() && file.getName().startsWith("libArMapEngine") && !file.getName().contains("ArMapEngine800Arch64")) {
                        file.delete();
                        if (QLog.isColorLevel()) {
                            QLog.d("ArConfig_NativeSoDownloadHandler", 2, "delete f=" + file.getName());
                        }
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArConfig_NativeSoDownloadHandler", 2, "exception =" + e16.getMessage());
                e16.printStackTrace();
            }
        }
        super.j(xmlData);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 10024;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public Class<? extends XmlData> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ArNativeSoData.class;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return PreDownloadConstants.DEPARTMENT_PRD;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ArConfig_NativeSoDownloadHandler";
    }
}
