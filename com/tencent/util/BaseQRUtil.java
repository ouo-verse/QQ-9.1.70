package com.tencent.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BaseQRUtil {
    static IPatchRedirector $redirector_ = null;
    protected static String IP_QM_QQ_COM_DIANXIN = null;
    public static String QM_QQ_COM = null;
    protected static final String TAG = "QRUtils";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44120);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            QM_QQ_COM = "qm.qq.com";
            IP_QM_QQ_COM_DIANXIN = "183.61.32.185";
        }
    }

    public BaseQRUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getIP(Context context, String str) {
        String string = context.getSharedPreferences("host", 0).getString(str, null);
        if (string != null) {
            return string;
        }
        if (!str.equals(QM_QQ_COM)) {
            return null;
        }
        return IP_QM_QQ_COM_DIANXIN;
    }

    public static void lookupIP(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("host", 0);
        try {
            String hostAddress = InetAddress.getByName(str).getHostAddress();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, hostAddress);
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "lookup address: " + str + ", ip: " + hostAddress);
            }
        } catch (UnknownHostException e16) {
            e16.printStackTrace();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
