package com.tencent.tuxmetersdk.export.listener;

import com.tencent.tuxmetersdk.impl.SDKConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxInitSDKListener {
    void onFailure(int i3, String str);

    void onSuccess(boolean z16, SDKConfig sDKConfig);
}
