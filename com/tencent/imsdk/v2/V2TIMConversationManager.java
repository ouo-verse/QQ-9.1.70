package com.tencent.imsdk.v2;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class V2TIMConversationManager {
    static V2TIMConversationManager getInstance() {
        return V2TIMConversationManagerImpl.getInstance();
    }

    public abstract void addConversationListener(V2TIMConversationListener v2TIMConversationListener);

    public abstract void deleteConversation(String str, V2TIMCallback v2TIMCallback);

    public abstract void getConversation(String str, V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback);

    public abstract void getConversationList(long j3, int i3, V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback);

    public abstract void getConversationList(List<String> list, V2TIMValueCallback<List<V2TIMConversation>> v2TIMValueCallback);

    public abstract void getTotalUnreadMessageCount(V2TIMValueCallback<Long> v2TIMValueCallback);

    public abstract void pinConversation(String str, boolean z16, V2TIMCallback v2TIMCallback);

    public abstract void removeConversationListener(V2TIMConversationListener v2TIMConversationListener);

    public abstract void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback);

    @Deprecated
    public abstract void setConversationListener(V2TIMConversationListener v2TIMConversationListener);
}
