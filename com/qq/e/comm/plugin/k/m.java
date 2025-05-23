package com.qq.e.comm.plugin.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.managers.status.SDKStatus;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m {
    public static JSONObject a(JSONObject jSONObject, Context context, Object obj) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    jSONObject2.put("posId", jSONObject.optString("posId"));
                    jSONObject2.put("cl", jSONObject.optString("cl"));
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        jSONObject2.put("pd", Process.myPid());
        jSONObject2.put("pn", a(context));
        jSONObject2.put("td", Thread.currentThread().getId());
        jSONObject2.put("tn", Thread.currentThread().getName());
        if (obj != null) {
            jSONObject2.put("oh", obj.hashCode());
        }
        return jSONObject2;
    }

    private static String a(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "@None@";
    }

    public static int a() {
        return SDKStatus.getSDKVersionCode() >= 20 ? 1 : 0;
    }
}
