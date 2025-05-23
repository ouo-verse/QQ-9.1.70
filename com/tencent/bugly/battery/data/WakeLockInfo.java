package com.tencent.bugly.battery.data;

import android.os.IBinder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class WakeLockInfo extends BaseBatteryInfo {
    private static final String TAG = "WakeLockInfo";
    public int flags;
    public String tag;
    public IBinder token;

    @Override // com.tencent.bugly.battery.data.BaseBatteryInfo
    public JSONObject toJSON(long j3) {
        JSONObject json = super.toJSON(j3);
        try {
            json.put(WadlProxyConsts.FLAGS, this.flags);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
        return json;
    }
}
