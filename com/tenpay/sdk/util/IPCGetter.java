package com.tenpay.sdk.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tenpay.proxy.DataProxy;

/* loaded from: classes27.dex */
public class IPCGetter extends ResultReceiver {
    public static final int GetQQPersonalPortait_FaceType_Anonymity = 32;
    public static final int GetQQPersonalPortait_FaceType_Normal = 1;
    public static final int IPCType_GetQQPersonalPortait = 1;
    public static final int IPCType_GetREAL_TIME_LOCATION = 19;
    protected OnGetResult onGetResult;
    protected Bundle outBundle;
    protected int which;

    public IPCGetter(Handler handler, OnGetResult onGetResult) {
        super(handler);
        this.onGetResult = onGetResult;
    }

    public void startGet(Bundle bundle) {
        int i3 = bundle.getInt("IPCType");
        this.which = i3;
        DataProxy.getByIPC(i3, this, bundle);
    }

    protected void whenException() {
    }
}
