package com.tencent.bugly.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.lifecycle.a;
import com.tencent.rmonitor.custom.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class NetMonitorReportUtil {
    NetMonitorReportUtil() {
    }

    public static void fillExceptionInfo(JSONObject jSONObject, String str, Exception exc) throws JSONException {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            jSONObject.put("exception_type", str);
            if (exc != null) {
                String stackTraceAsString = getStackTraceAsString(exc);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("call_stack", stackTraceAsString);
                JSONArray jSONArray = new JSONArray();
                jSONArray.mo162put(jSONObject2);
                jSONObject.put("stacks", jSONArray);
            }
        }
    }

    public static void fillMeta(@NonNull HttpReportMeta httpReportMeta) {
        UserMeta userMeta = BaseInfo.userMeta;
        httpReportMeta.accountId = userMeta.uin;
        httpReportMeta.processName = ProcessUtil.getCurrentProcessName(ContextUtil.getGlobalContext());
        httpReportMeta.processLaunchID = TraceGenerator.getProcessLaunchId();
        httpReportMeta.launchID = TraceGenerator.getLaunchId(ContextUtil.getGlobalContext());
        httpReportMeta.stage = a.f();
        httpReportMeta.appVersion = userMeta.appVersion;
        httpReportMeta.appVersionMode = userMeta.appVersionMode;
        httpReportMeta.buildNumber = userMeta.buildNumber;
        httpReportMeta.sdkVersion = userMeta.sdkVersion;
        httpReportMeta.hotPatchVersion = HotPatchWrapper.getInstance().getAppHotPatchNum();
    }

    public static String getStackTraceAsString(Throwable th5) {
        if (th5 == null) {
            return "null";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static JSONObject getUserCustom() {
        return b.a().o();
    }
}
