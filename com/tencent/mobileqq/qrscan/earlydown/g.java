package com.tencent.mobileqq.qrscan.earlydown;

import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f276633a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f276634b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276633a = false;
            f276634b = new Object();
        }
    }

    public static byte n(String str) {
        return a.a(1, str);
    }

    public static String o() {
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.MiniScanDetectSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        String str = filesDir + "/pddata/prd/qq.android.minidetect.so_v8.9.85";
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniScanDetectSoLoader", 2, "getLibDir ,path = " + str);
        }
        return str;
    }

    public static String p(String str) {
        return RFixConstants.SO_PATH + str + "_64.so";
    }

    public static String q(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    public static Object r() {
        return f276634b;
    }

    public static String s(String str) {
        return a.c(1, str);
    }

    public static boolean t() {
        if (a.h(1, f276633a, "QMCF_qr")) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDetectSoLoader", 2, "native so is not exist!");
            return false;
        }
        return false;
    }

    public static byte u(String str) {
        if (str == "yuvutil") {
            return (byte) 0;
        }
        return a.i(1, f276633a, str);
    }

    public static boolean v(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("QMCF_qr")) {
                        hashMap.put("QMCF_qr", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("yuvutil")) {
                        hashMap.put("yuvutil", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("QMCF_qr_64")) {
                        hashMap.put("QMCF_qr_64", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("yuvutil_64")) {
                        hashMap.put("yuvutil_64", newPullParser.nextText());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.MiniScanDetectSoLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MiniRecog.MiniScanDetectSoLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void w(boolean z16) {
        f276633a = z16;
    }
}
