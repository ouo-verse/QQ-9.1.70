package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationAtInfo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    public static final int TIM_AT_ALL = 2;
    public static final int TIM_AT_ALL_AT_ME = 3;
    public static final int TIM_AT_ME = 1;
    public static final int TIM_AT_UNKNOWN = 0;
    private ConversationAtInfo conversationAtInfo;

    public int getAtType() {
        ConversationAtInfo conversationAtInfo = this.conversationAtInfo;
        if (conversationAtInfo == null) {
            return 0;
        }
        return conversationAtInfo.getAtType();
    }

    public long getSeq() {
        ConversationAtInfo conversationAtInfo = this.conversationAtInfo;
        if (conversationAtInfo == null) {
            return -1L;
        }
        return conversationAtInfo.getAtMessageSequence();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setConversationGroupAtInfo(ConversationAtInfo conversationAtInfo) {
        this.conversationAtInfo = conversationAtInfo;
    }
}
