package com.tencent.imsdk.v2;

import com.tencent.imsdk.offlinePush.OfflinePushToken;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class V2TIMOfflinePushConfig implements Serializable {
    private OfflinePushToken offlinePushToken;

    public V2TIMOfflinePushConfig(long j3, String str) {
        OfflinePushToken offlinePushToken = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken;
        offlinePushToken.setBusinessID((int) j3);
        this.offlinePushToken.setDeviceToken(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflinePushToken getOfflinePushToken() {
        return this.offlinePushToken;
    }
}
