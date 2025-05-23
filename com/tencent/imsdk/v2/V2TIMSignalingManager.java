package com.tencent.imsdk.v2;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class V2TIMSignalingManager {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMSignalingManager getInstance() {
        return V2TIMSignalingManagerImpl.getInstance();
    }

    public abstract void accept(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void addInvitedSignaling(V2TIMSignalingInfo v2TIMSignalingInfo, V2TIMCallback v2TIMCallback);

    public abstract void addSignalingListener(V2TIMSignalingListener v2TIMSignalingListener);

    public abstract void cancel(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract V2TIMSignalingInfo getSignalingInfo(V2TIMMessage v2TIMMessage);

    public abstract String invite(String str, String str2, boolean z16, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, int i3, V2TIMCallback v2TIMCallback);

    public abstract String inviteInGroup(String str, List<String> list, String str2, boolean z16, int i3, V2TIMCallback v2TIMCallback);

    public abstract void reject(String str, String str2, V2TIMCallback v2TIMCallback);

    public abstract void removeSignalingListener(V2TIMSignalingListener v2TIMSignalingListener);
}
