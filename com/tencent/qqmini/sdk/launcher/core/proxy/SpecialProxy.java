package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.os.Bundle;

/* loaded from: classes23.dex */
public interface SpecialProxy {
    public static final int EVENT_FOLLOW_MINIGAME_PA = 4;
    public static final int EVENT_GET_MINIGAME_PA_SUBMSG = 3;
    public static final int EVENT_INIT_NETWORKINFO = 2;
    public static final int EVENT_OPEN_MINIAPP = 1;
    public static final String KEY_DATA = "key_bundle_data";
    public static final String KEY_NETWORK_TIMEOUT_INFO = "NetworkTimeOutInfo";

    /* loaded from: classes23.dex */
    public interface EventCallback {
        void onResult(boolean z16, Bundle bundle);
    }

    boolean sendEventToHost(int i3, Bundle bundle, EventCallback eventCallback);
}
