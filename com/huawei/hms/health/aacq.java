package com.huawei.hms.health;

import android.os.RemoteException;
import com.huawei.hms.health.aacp;
import com.huawei.hms.hihealth.data.RealTimeSampleSet;
import com.huawei.hms.hihealth.options.OnBeginActivityListener;
import com.huawei.hms.hihealth.options.aaba;

/* compiled from: P */
/* loaded from: classes2.dex */
class aacq extends aaba.aab {
    final /* synthetic */ aacp.aabd aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aacq(aacp.aabd aabdVar) {
        this.aab = aabdVar;
    }

    @Override // com.huawei.hms.hihealth.options.aaba
    public void onReceive(int i3, RealTimeSampleSet realTimeSampleSet) throws RemoteException {
        OnBeginActivityListener onBeginActivityListener;
        onBeginActivityListener = this.aab.aaba;
        onBeginActivityListener.onReceive(i3, realTimeSampleSet);
    }
}
