package com.qq.e.comm.plugin.ipc.business;

import android.os.Bundle;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.plugin.ipc.IPCModule;
import com.qq.e.comm.plugin.ipc.IPCResult;

/* loaded from: classes3.dex */
public class StubVisitorProxyIPCModule extends IPCModule {
    private static final String ACTION_GET_LPS_OPTIONS = "actionGetLandingPageShareOptions";
    private static final String KEY_GET_LPS_OPTIONS = "keyGetLandingPageShareOptions";

    public StubVisitorProxyIPCModule(String str) {
        super(str);
    }

    private IPCResult getOptionsByIPC(Bundle bundle) {
        int landingPageShareOptions = StubVisitor.getInstance().getLandingPageShareOptions();
        IPCResult iPCResult = new IPCResult();
        iPCResult.code = 0;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("keyGetLandingPageShareOptions", landingPageShareOptions);
        iPCResult.data = bundle2;
        return iPCResult;
    }

    @Override // com.qq.e.comm.plugin.ipc.IPCModule
    public IPCResult onCall(String str, Bundle bundle) {
        if ("actionGetLandingPageShareOptions".equals(str)) {
            return getOptionsByIPC(bundle);
        }
        return null;
    }
}
