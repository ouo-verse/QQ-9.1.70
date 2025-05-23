package com.tencent.av.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f76975a;

    public static boolean a(String str) {
        if (f76975a == null) {
            f76975a = Integer.valueOf(af.d(com.tencent.luggage.wxa.ci.b.CTRL_INDEX, str).getInt("is_perf_test_open", 0));
            QLog.i("QAVPerfTestConfig", 1, "isPerfTestOpen, {" + f76975a + "}");
        }
        if (f76975a.intValue() != 0) {
            return true;
        }
        return false;
    }

    public static void b(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("QAVPerfTestConfig", 2, " parseAndSave parse json = " + str);
        }
        int i3 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("is_perf_test_open")) {
                    i3 = jSONObject.getInt("is_perf_test_open");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("handleGetQAVGeneralConfig", 2, " parse json: " + QLog.getStackTraceString(e16));
                }
            }
        }
        SharedPreferences.Editor edit = af.d(com.tencent.luggage.wxa.ci.b.CTRL_INDEX, str2).edit();
        edit.putInt("is_perf_test_open", i3);
        edit.commit();
    }
}
