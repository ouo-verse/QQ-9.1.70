package com.tencent.bugly.battery.data;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.rmonitor.common.lifecycle.a;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseBatteryInfo {
    private static final String TAG = "BaseBatteryInfo";
    public StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
    public long startTime = System.currentTimeMillis();
    public long endTime = 0;
    public String threadName = Thread.currentThread().getName();
    public String scene = a.f();
    public boolean singleTimeExpired = false;
    public boolean numExpired = false;
    public boolean totalTimeExpired = false;

    private String stackToString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTraceElementArr = this.stacks;
        if (stackTraceElementArr != null) {
            boolean z17 = false;
            boolean z18 = false;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (z17 && z18) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (stackTraceElement.toString().startsWith("java.lang.reflect.Proxy.invoke")) {
                    z18 = true;
                }
                if (stackTraceElement.toString().startsWith("$Proxy")) {
                    z17 = true;
                }
                if (!z16) {
                    sb5.append(stackTraceElement);
                    sb5.append("\n");
                }
            }
        }
        return sb5.toString();
    }

    public long calculateDuration(long j3) {
        long j16 = this.endTime;
        if (j16 > 0) {
            return j16 - this.startTime;
        }
        return j3 - this.startTime;
    }

    public JSONObject toJSON(long j3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", this.scene);
            jSONObject.put("timestamp", this.startTime);
            jSONObject.put("call_stack", stackToString());
            jSONObject.put("duration_in_ms", calculateDuration(j3));
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, this.threadName);
            return jSONObject;
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
            return new JSONObject();
        }
    }
}
