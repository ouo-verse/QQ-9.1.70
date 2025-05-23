package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.common.cache.ProcessContextWrapper;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bi {
    public static void a(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null || TextUtils.isEmpty(crashDetailBean.f97878d)) {
            return;
        }
        String str = crashDetailBean.f97878d;
        if (TextUtils.equals(str, TraceGenerator.getProcessLaunchId())) {
            String f16 = com.tencent.rmonitor.common.lifecycle.a.f();
            if (!TextUtils.isEmpty(f16)) {
                crashDetailBean.a("stage", f16);
            }
            a(crashDetailBean, com.tencent.rmonitor.custom.b.a());
            return;
        }
        a(crashDetailBean, com.tencent.rmonitor.custom.b.b(ProcessContextWrapper.getInstance().createProcessContextLoader(str, new bl())));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(7:16|17|(1:9)|10|11|12|13)|7|(0)|10|11|12|13) */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject b(CrashDetailBean crashDetailBean) {
        JSONObject jSONObject;
        if (crashDetailBean == null) {
            return new JSONObject();
        }
        String a16 = crashDetailBean.a(ReportDataBuilder.KEY_USER_CUSTOM);
        if (!TextUtils.isEmpty(a16)) {
            try {
                jSONObject = new JSONObject(a16);
            } catch (JSONException unused) {
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            a(crashDetailBean, jSONObject, VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, "a11");
            a(crashDetailBean, jSONObject, "testLabel", "a12");
            a(crashDetailBean, jSONObject, "caseLabel", "a13");
            av.c("[extra data]assemble custom data {%s}", crashDetailBean.f97878d);
            return jSONObject;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
        a(crashDetailBean, jSONObject, VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, "a11");
        a(crashDetailBean, jSONObject, "testLabel", "a12");
        a(crashDetailBean, jSONObject, "caseLabel", "a13");
        av.c("[extra data]assemble custom data {%s}", crashDetailBean.f97878d);
        return jSONObject;
    }

    private static void a(CrashDetailBean crashDetailBean, com.tencent.rmonitor.custom.a aVar) {
        JSONObject k3;
        JSONObject jSONObject;
        if (crashDetailBean == null || aVar == null) {
            return;
        }
        if (a()) {
            k3 = aVar.o();
            jSONObject = aVar.i();
        } else {
            k3 = aVar.k();
            jSONObject = null;
        }
        if (k3 != null) {
            crashDetailBean.a(ReportDataBuilder.KEY_USER_CUSTOM, k3.toString());
        }
        if (jSONObject != null) {
            crashDetailBean.a(ReportDataBuilder.KEY_EXTEND_INFO, jSONObject.toString());
        }
    }

    private static boolean a() {
        com.tencent.rmonitor.base.config.data.k d16 = ConfigFetcher.g().d("crash");
        if (d16 instanceof v) {
            return ((v) d16).f98577e;
        }
        return false;
    }

    public static void a(JSONObject jSONObject, CrashDetailBean crashDetailBean) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(ReportDataBuilder.KEY_BIZ_EXTEND_INFO);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String a16 = crashDetailBean.a(ReportDataBuilder.KEY_EXTEND_INFO);
            if (!TextUtils.isEmpty(a16)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(a16);
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        if (!optJSONObject.has(str)) {
                            optJSONObject.put(str, jSONObject2.getString(str));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            jSONObject.put(ReportDataBuilder.KEY_BIZ_EXTEND_INFO, optJSONObject);
        } catch (Throwable unused2) {
        }
    }

    private static void a(CrashDetailBean crashDetailBean, JSONObject jSONObject, String str, String str2) throws JSONException {
        JSONArray a16 = a(crashDetailBean.a(str));
        if (a16 != null) {
            jSONObject.put(str2, a16);
        }
    }

    private static JSONArray a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str2 : str.split("\\|")) {
                jSONArray.mo162put(str2);
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        return jSONArray;
    }
}
