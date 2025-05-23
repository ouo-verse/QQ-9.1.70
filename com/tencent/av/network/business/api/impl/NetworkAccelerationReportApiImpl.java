package com.tencent.av.network.business.api.impl;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.e;
import com.tencent.av.n;
import com.tencent.av.network.business.api.INetworkAccelerationReportApi;
import com.tencent.avcore.jni.dav.NtrtcUtil;
import com.tencent.qphone.base.util.QLog;
import gv.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class NetworkAccelerationReportApiImpl implements INetworkAccelerationReportApi {
    private static final String KEY = "networkAccelerateOptions";
    private static final int OPTION_CLOSE = 0;
    private static final int OPTION_OPEN = 1;
    private static final int REPORT_DELAY_MS = 1000;
    private static final String TAG = "NetworkAccelerationReportApiImpl";

    @Override // com.tencent.av.network.business.api.INetworkAccelerationReportApi
    public void reportEnableEntry(final boolean z16) {
        final SessionInfo f16 = n.e().f();
        if (f16 == null) {
            QLog.d(TAG, 1, "sessionInfo is null");
        } else {
            a.a().b().postDelayed(new Runnable() { // from class: com.tencent.av.network.business.api.impl.NetworkAccelerationReportApiImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    NtrtcUtil.getInstance().setAVSDKInfo(e.i(f16.f73091w), NetworkAccelerationReportApiImpl.KEY, String.valueOf(z16 ? 1 : 0));
                    QLog.d(NetworkAccelerationReportApiImpl.TAG, 1, "reportEnableEntry enable:=" + z16);
                }
            }, 1000L);
        }
    }
}
