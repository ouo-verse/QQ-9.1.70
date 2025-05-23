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
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f276629a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f276630b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276629a = false;
            f276630b = new Object();
        }
    }

    public static byte n(String str) {
        return a.a(0, str);
    }

    public static String o() {
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        String str = filesDir + "/pddata/prd/qq.android.minidecode.so_v8.8.5";
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniScanDecodeSoLoader", 2, "getLibDir ,path = " + str);
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
        return f276630b;
    }

    public static String s(String str) {
        return a.c(0, str);
    }

    public static boolean t() {
        if (!a.h(0, f276629a, "minicode")) {
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "native so is not exist!");
            }
            return false;
        }
        return true;
    }

    public static byte u(String str) {
        return a.i(0, f276629a, str);
    }

    public static boolean v(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("minicode")) {
                        hashMap.put("minicode", newPullParser.nextText());
                    }
                    if (name.equalsIgnoreCase("minicode_64")) {
                        hashMap.put("minicode_64", newPullParser.nextText());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.MiniScanDecodeSoLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MiniRecog.MiniScanDecodeSoLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void w(boolean z16) {
        f276629a = z16;
    }
}
