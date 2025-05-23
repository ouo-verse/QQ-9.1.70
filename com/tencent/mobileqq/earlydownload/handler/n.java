package com.tencent.mobileqq.earlydownload.handler;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class n extends b {
    static IPatchRedirector $redirector_;

    public n(String str, QQAppInterface qQAppInterface) {
        super(str, qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) qQAppInterface);
        }
    }

    @TargetApi(9)
    public static boolean M(Context context, String str) {
        File file = new File((context.getApplicationInfo().nativeLibraryDir + "/") + AVSoUtils.s(str));
        File file2 = new File(AVSoUtils.y() + AVSoUtils.s(str));
        if (!file.exists() && !file2.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("QavSoDownloadHandlerBase", 2, "fail to find so:" + str);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean N(Context context, Boolean bool) {
        if (AVCoreSystemInfo.getCpuArchitecture() > 2) {
            return true;
        }
        if (M(context, "traeimp-armeabi") && M(context, "TcVpxDec-armeabi") && M(context, "TcVpxEnc-armeabi")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void i(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        XmlData o16 = o();
        if (o16 != null) {
            String str3 = "QAVSOMD5__" + o16.getSharedPreferencesName();
            SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
            String string = sharedPreferences.getString(str3, null);
            String encodeFileHexStr = MD5Utils.encodeFileHexStr(str);
            if (!TextUtils.isEmpty(o16.MD5) && o16.MD5.equalsIgnoreCase(encodeFileHexStr)) {
                QLog.d("QavSoDownloadHandlerBase", 1, "download success: " + str + "|" + string + "|" + o16.MD5 + "|" + o16);
                if ((!TextUtils.isEmpty(o16.MD5) && !o16.MD5.equalsIgnoreCase(string)) || !N(this.f203921f.getApp().getApplicationContext(), Boolean.TRUE)) {
                    try {
                        FileUtils.uncompressZip(str, AVSoUtils.y(), false);
                        sharedPreferences.edit().putString(str3, o16.MD5).commit();
                        QLog.d("QavSoDownloadHandlerBase", 1, "uncompressZip success: " + str + "|" + string + "|" + o16.MD5 + "|" + o16);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        QLog.e("QavSoDownloadHandlerBase", 1, "uncompressZip qavso failed.");
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("download success but check md5 failed. config zip file md5 = ");
                if (!TextUtils.isEmpty(o16.MD5)) {
                    str2 = o16.MD5;
                } else {
                    str2 = "null";
                }
                sb5.append(str2);
                sb5.append(", realZipFileMd5 = ");
                sb5.append(encodeFileHexStr);
                QLog.e("QavSoDownloadHandlerBase", 1, sb5.toString());
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                    return;
                }
                return;
            }
        }
        super.i(str);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public void j(XmlData xmlData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) xmlData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp begins, respData" + xmlData);
        }
        if (xmlData != null && (xmlData instanceof QavSoData)) {
            super.j(xmlData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoData");
        }
        super.j(xmlData);
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 10048;
    }

    @Override // com.tencent.mobileqq.earlydownload.handler.b
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "qavDownloadSoDuration";
    }
}
