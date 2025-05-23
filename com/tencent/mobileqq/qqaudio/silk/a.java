package com.tencent.mobileqq.qqaudio.silk;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.b;
import com.tencent.mobileqq.qqaudio.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f262234a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f262234a = false;
        }
    }

    public static String a() {
        String appWorkPath = SoLoadCore.getAppWorkPath(BaseApplication.getContext());
        if (appWorkPath == null) {
            if (QLog.isColorLevel()) {
                QLog.i("SilkSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        return appWorkPath + "/txPttlib/";
    }

    public static String b() {
        String appWorkPath = SoLoadCore.getAppWorkPath(BaseApplication.getContext());
        if (appWorkPath == null) {
            if (QLog.isColorLevel()) {
                QLog.i("SilkSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        return appWorkPath + "/UnCompressPttSoTemp/";
    }

    public static boolean c(Context context, String str) {
        boolean z16;
        int c16 = c.c();
        String a16 = a();
        String str2 = "";
        if (c16 > 2) {
            str2 = a16 + RFixConstants.SO_PATH + str + "_658_v7.so";
        }
        synchronized ("SilkSoLoader") {
            boolean exists = new File(str2).exists();
            if (QLog.isColorLevel()) {
                QLog.i("SilkSoLoader", 2, "start LoadPttSo: " + str2 + " soFileExist=" + exists);
            }
            if (str.equals("codecsilk")) {
                exists = false;
            }
            z16 = true;
            if (exists) {
                try {
                    System.load(str2);
                    f262234a = true;
                } catch (UnsatisfiedLinkError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SilkSoLoader", 2, "load from txlib failed: " + e16.getMessage());
                    }
                    z16 = SoLoadUtilNew.loadSoByName(context, str);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("SilkSoLoader", 2, "no ptt so in txlib.");
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean loadSoByName = SoLoadUtilNew.loadSoByName(context, str);
                QLog.i("SonicLibraryLoad", 1, "9015 \u5361\u987f\u76d1\u6d4b, silk so load cost: " + (System.currentTimeMillis() - currentTimeMillis));
                z16 = loadSoByName;
            }
        }
        b.b(f262234a, str);
        if (QLog.isColorLevel()) {
            QLog.i("SilkSoLoader", 2, "load " + str2 + " result=" + f262234a);
        }
        return z16;
    }
}
