package com.tencent.imsdk.v2;

/* loaded from: classes7.dex */
public abstract class V2TIMOfflinePushManager {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMOfflinePushManager getInstance() {
        return V2TIMOfflinePushManagerImpl.getInstance();
    }

    public abstract void doBackground(int i3, V2TIMCallback v2TIMCallback);

    public abstract void doForeground(V2TIMCallback v2TIMCallback);

    public abstract void setOfflinePushConfig(V2TIMOfflinePushConfig v2TIMOfflinePushConfig, V2TIMCallback v2TIMCallback);
}
