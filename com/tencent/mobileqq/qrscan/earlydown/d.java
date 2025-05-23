package com.tencent.mobileqq.qrscan.earlydown;

import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f276631a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f276632b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276631a = new Object();
            f276632b = false;
        }
    }

    public static byte n(String str) {
        return a.a(2, str);
    }

    public static String o() {
        File filesDir = BaseApplication.getContext().getFilesDir();
        if (filesDir == null) {
            if (QLog.isColorLevel()) {
                QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getFilesDir is null");
                return "";
            }
            return "";
        }
        String str = filesDir + "/pddata/prd/qq.android.minidetect.model_v8.9.85";
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, "getLibDir ,path = " + str);
        }
        return str;
    }

    public static Object r() {
        return f276631a;
    }

    public static String s() {
        String decodeString;
        String str;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (!from.decodeBool("qrscan_native_res_match_detect_so_md5_64_migrate_flag", false)) {
            decodeString = MobileQQ.sMobileQQ.getSharedPreferences("mobileQQ", 4).getString("qrscan_native_res_match_detect_so_md5_64", null);
            from.encodeString("qrscan_native_res_match_detect_so_md5_64", decodeString);
            from.encodeBool("qrscan_native_res_match_detect_so_md5_64_migrate_flag", true);
        } else {
            decodeString = from.decodeString("qrscan_native_res_match_detect_so_md5_64", null);
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            if (decodeString == null) {
                str = "null";
            } else {
                str = decodeString;
            }
            objArr[0] = str;
            objArr[1] = "match_detect_so_md5_64";
            QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("getMatchDetectSoMd5=%s tag=%s", objArr));
        }
        return decodeString;
    }

    public static boolean t() {
        if (u("qr_anchor.bin") && u("qr_detection_model.txt") && u("qr_detection_model.bin")) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "modules is not exist!");
            return false;
        }
        return false;
    }

    public static boolean u(String str) {
        return a.h(2, f276632b, str);
    }

    public static boolean v(String str, HashMap<String, String> hashMap) {
        XmlPullParser newPullParser = Xml.newPullParser();
        hashMap.clear();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("qr_anchor.bin")) {
                        hashMap.put("qr_anchor.bin", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("qr_detection_model.txt")) {
                        hashMap.put("qr_detection_model.txt", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("qr_detection_model.bin")) {
                        hashMap.put("qr_detection_model.bin", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("match_detect_so_md5")) {
                        w("match_detect_so_md5", newPullParser.nextText());
                    } else if (name.equalsIgnoreCase("match_detect_so_md5_64")) {
                        w("match_detect_so_md5_64", newPullParser.nextText());
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.MiniScanDetectModelLoader", 2, "parseConfig success|config=" + hashMap);
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MiniRecog.MiniScanDetectModelLoader", 2, str, e16);
                return false;
            }
            return false;
        }
    }

    public static void w(String str, String str2) {
        String str3;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeBool("qrscan_native_res_" + str + "_migrate_flag", true);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qrscan_native_res_");
        sb5.append(str);
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = str2;
        }
        from.encodeString(sb6, str3);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            if (str2 == null) {
                str2 = "null";
            }
            objArr[0] = str2;
            objArr[1] = str;
            QLog.i("MiniRecog.MiniScanDetectModelLoader", 2, String.format("saveMatchDetectSoMd5=%s tag=%s", objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void x(boolean z16) {
        f276632b = z16;
    }

    public static String p(String str) {
        return str;
    }

    public static String q(String str) {
        return str;
    }
}
