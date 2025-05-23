package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageSearchResultItem;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMMessageSearchResultItem implements Serializable {
    private MessageSearchResultItem messageSearchResultItem;

    public String getConversationID() {
        MessageSearchResultItem messageSearchResultItem = this.messageSearchResultItem;
        if (messageSearchResultItem != null) {
            if (messageSearchResultItem.getMessageType() == Message.MESSAGE_TYPE_C2C) {
                return "c2c_" + this.messageSearchResultItem.getConversationID();
            }
            if (this.messageSearchResultItem.getMessageType() == Message.MESSAGE_TYPE_GROUP) {
                return VipFunCallConstants.KEY_GROUP_ONE + this.messageSearchResultItem.getConversationID();
            }
            return "";
        }
        return "";
    }

    public int getMessageCount() {
        MessageSearchResultItem messageSearchResultItem = this.messageSearchResultItem;
        if (messageSearchResultItem != null) {
            return messageSearchResultItem.getMessageCount();
        }
        return 0;
    }

    public List<V2TIMMessage> getMessageList() {
        MessageSearchResultItem messageSearchResultItem = this.messageSearchResultItem;
        if (messageSearchResultItem != null) {
            List<Message> messageList = messageSearchResultItem.getMessageList();
            ArrayList arrayList = new ArrayList();
            for (Message message : messageList) {
                V2TIMMessage v2TIMMessage = new V2TIMMessage();
                v2TIMMessage.setMessage(message);
                arrayList.add(v2TIMMessage);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMessageSearchResultItem(MessageSearchResultItem messageSearchResultItem) {
        this.messageSearchResultItem = messageSearchResultItem;
    }
}
