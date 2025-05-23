package com.tencent.mobileqq.qqlive.widget.verify;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static String a(String str) {
        return "face_privacy" + str;
    }

    private static MMKVOptionEntity b() {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
    }

    public static boolean c(String str) {
        MMKVOptionEntity b16 = b();
        String a16 = a(str);
        if (!b16.isAccessible()) {
            QLog.e("FacePrivacyMMKVHelper", 1, "entity from QMMKVFile.FILE_QQLIVE is unAccessible");
            return false;
        }
        if (!b16.containsKey(a16)) {
            return false;
        }
        return b16.decodeBool(a16, false);
    }

    public static void d(String str, boolean z16) {
        MMKVOptionEntity b16 = b();
        String a16 = a(str);
        if (!b16.isAccessible()) {
            QLog.e("FacePrivacyMMKVHelper", 1, "entity from QMMKVFile.FILE_QQLIVE is unAccessible");
        } else {
            b16.encodeBool(a16, z16).commitAsync();
        }
    }
}
