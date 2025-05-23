package com.tencent.bugly.battery.data;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class AlarmInfo extends BaseBatteryInfo {
    private static final String TAG = "AlarmInfo";
    public AlarmManager.OnAlarmListener onAlarmListener;
    public PendingIntent operation;
    public long triggerAtMillis;
    public int type;
    public boolean wakeUpTypeNumExpired = false;

    @Override // com.tencent.bugly.battery.data.BaseBatteryInfo
    public JSONObject toJSON(long j3) {
        JSONObject json = super.toJSON(j3);
        try {
            json.put("alarm_type", this.type);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
        return json;
    }
}
