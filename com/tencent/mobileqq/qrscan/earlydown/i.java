package com.tencent.mobileqq.qrscan.earlydown;

import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f276635a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f276636b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27515);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276635a = new Object();
            f276636b = false;
        }
    }

    public static byte n(String str) {
        return a.a(3, str);
    }

    public static String o() {
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.QBarModelLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        String str = filesDir + "/pddata/prd/qq.android.qbarnative.model_v8.6.0";
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.QBarModelLoader", 2, "getLibDir ,path = " + str);
        }
        return str;
    }

    public static Object r() {
        return f276635a;
    }

    public static boolean s() {
        if (t("detect_model.bin") && t("detect_model.param") && t("srnet.bin") && t("srnet.param")) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.QBarModelLoader", 2, "model res is not exist!");
            return false;
        }
        return false;
    }

    public static boolean t(String str) {
        return a.h(3, f276636b, str);
    }

    public static boolean u(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("detect_model.bin")) {
                        hashMap.put("detect_model.bin", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("detect_model.param")) {
                        hashMap.put("detect_model.param", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("srnet.bin")) {
                        hashMap.put("srnet.bin", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("srnet.param")) {
                        hashMap.put("srnet.param", newPullParser.nextText());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.QBarModelLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MiniRecog.QBarModelLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void v(boolean z16) {
        f276636b = z16;
    }

    public static String p(String str) {
        return str;
    }

    public static String q(String str) {
        return str;
    }
}
