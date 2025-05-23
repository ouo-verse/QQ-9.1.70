package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMConversationResult implements Serializable {
    private ConversationResult conversationResult;

    public List<V2TIMConversation> getConversationList() {
        if (this.conversationResult == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Conversation conversation : this.conversationResult.getConversationList()) {
            V2TIMConversation v2TIMConversation = new V2TIMConversation();
            v2TIMConversation.setConversation(conversation);
            arrayList.add(v2TIMConversation);
        }
        return arrayList;
    }

    public long getNextSeq() {
        ConversationResult conversationResult = this.conversationResult;
        if (conversationResult != null) {
            return conversationResult.getNextSeq();
        }
        return 0L;
    }

    public boolean isFinished() {
        ConversationResult conversationResult = this.conversationResult;
        if (conversationResult != null) {
            return conversationResult.isFinish();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConversationResult(ConversationResult conversationResult) {
        this.conversationResult = conversationResult;
    }
}
