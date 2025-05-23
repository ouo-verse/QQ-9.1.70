package com.tencent.ad.tangram.app.tracer;

import com.tencent.ad.tangram.log.AdLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdAppLaunchTracerActivityLifecycleData {
    private static final String TAG = "AdAppLaunchTracerActivityLifecycleData";
    private final CopyOnWriteArrayList<AdAppLaunchTracerActivityStatus> mStatusList = new CopyOnWriteArrayList<>();

    public boolean addStatus(int i3) {
        if (i3 == getLastStatus()) {
            AdLog.i(TAG, "[addStatus] do nothing status:" + i3 + " mStatusList:" + this);
            return false;
        }
        return this.mStatusList.add(new AdAppLaunchTracerActivityStatus(i3));
    }

    public int getLastStatus() {
        if (this.mStatusList.size() > 0) {
            return this.mStatusList.get(r0.size() - 1).getStatus();
        }
        return 0;
    }

    public boolean matchExactly(int[] iArr) {
        if (iArr == null) {
            AdLog.e(TAG, "[matchExactly] error, statusList is null");
            return false;
        }
        if (iArr.length != this.mStatusList.size()) {
            return false;
        }
        for (int i3 = 0; i3 < iArr.length; i3++) {
            AdAppLaunchTracerActivityStatus adAppLaunchTracerActivityStatus = this.mStatusList.get(i3);
            if (adAppLaunchTracerActivityStatus == null) {
                AdLog.e(TAG, "[matchExactly] error, status is null");
                return false;
            }
            if (adAppLaunchTracerActivityStatus.getStatus() != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public void reset() {
        this.mStatusList.clear();
    }

    public String toString() {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<AdAppLaunchTracerActivityStatus> it = this.mStatusList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().toString());
            }
            return jSONArray.toString();
        } catch (Throwable th5) {
            AdLog.e(TAG, "[toString]", th5);
            return null;
        }
    }
}
