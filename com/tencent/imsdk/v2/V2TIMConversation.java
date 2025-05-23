package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationAtInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.DraftMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMConversation implements Serializable {
    static final String CONVERSATION_C2C_PREFIX = "c2c_";
    static final String CONVERSATION_GROUP_PREFIX = "group_";
    public static final int CONVERSATION_TYPE_INVALID = 0;
    public static final int V2TIM_C2C = 1;
    public static final int V2TIM_GROUP = 2;
    private Conversation conversation;

    public String getConversationID() {
        Conversation conversation = this.conversation;
        if (conversation != null) {
            if (conversation.getConversationKey().getConversationType() == 1) {
                return CONVERSATION_C2C_PREFIX + this.conversation.getConversationKey().getConversationID();
            }
            if (this.conversation.getConversationKey().getConversationType() == 2) {
                return "group_" + this.conversation.getConversationKey().getConversationID();
            }
            return "";
        }
        return null;
    }

    public String getDraftText() {
        DraftMessage draftMessage;
        byte[] userDefinedData;
        Conversation conversation = this.conversation;
        if (conversation == null || (draftMessage = conversation.getDraftMessage()) == null || (userDefinedData = draftMessage.getUserDefinedData()) == null) {
            return null;
        }
        return new String(userDefinedData);
    }

    public long getDraftTimestamp() {
        DraftMessage draftMessage;
        Conversation conversation = this.conversation;
        if (conversation == null || (draftMessage = conversation.getDraftMessage()) == null) {
            return 0L;
        }
        return draftMessage.getEditTime();
    }

    public String getFaceUrl() {
        if (this.conversation != null) {
            if (getType() == 1) {
                return this.conversation.getC2cFaceUrl();
            }
            if (getType() == 2) {
                return this.conversation.getGroupFaceUrl();
            }
            return null;
        }
        return null;
    }

    public List<V2TIMGroupAtInfo> getGroupAtInfoList() {
        if (this.conversation == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ConversationAtInfo conversationAtInfo : this.conversation.getConversationAtInfoList()) {
            V2TIMGroupAtInfo v2TIMGroupAtInfo = new V2TIMGroupAtInfo();
            v2TIMGroupAtInfo.setConversationGroupAtInfo(conversationAtInfo);
            arrayList.add(v2TIMGroupAtInfo);
        }
        return arrayList;
    }

    public String getGroupID() {
        Conversation conversation = this.conversation;
        if (conversation == null || conversation.getConversationType() != 2) {
            return null;
        }
        return this.conversation.getGroupID();
    }

    public String getGroupType() {
        Conversation conversation = this.conversation;
        if (conversation == null) {
            return null;
        }
        String groupType = conversation.getGroupType();
        if (TextUtils.isEmpty(groupType)) {
            return null;
        }
        if (groupType.equals("Private")) {
            return V2TIMManager.GROUP_TYPE_WORK;
        }
        if (groupType.equals("ChatRoom")) {
            return V2TIMManager.GROUP_TYPE_MEETING;
        }
        return groupType;
    }

    public V2TIMMessage getLastMessage() {
        Conversation conversation = this.conversation;
        if (conversation != null && conversation.getLastMessage() != null) {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            v2TIMMessage.setMessage(this.conversation.getLastMessage());
            return v2TIMMessage;
        }
        return null;
    }

    public long getOrderKey() {
        Conversation conversation = this.conversation;
        if (conversation == null) {
            return 0L;
        }
        return conversation.getOrderKey();
    }

    public int getRecvOpt() {
        int groupMessageReceiveOption;
        if (this.conversation != null) {
            if (getType() == 1) {
                int userMessageReceiveOption = this.conversation.getUserMessageReceiveOption();
                if (userMessageReceiveOption == 1) {
                    return 0;
                }
                if (userMessageReceiveOption == 2) {
                    return 1;
                }
                if (userMessageReceiveOption == 3) {
                    return 2;
                }
            } else {
                if (getType() != 2 || (groupMessageReceiveOption = this.conversation.getGroupMessageReceiveOption()) == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
                    return 0;
                }
                if (groupMessageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
                    return 1;
                }
                if (groupMessageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public String getShowName() {
        Conversation conversation = this.conversation;
        if (conversation == null) {
            return null;
        }
        if (conversation.getConversationType() == 2) {
            return this.conversation.getGroupName();
        }
        if (this.conversation.getConversationType() != 1) {
            return null;
        }
        if (!TextUtils.isEmpty(this.conversation.getC2cRemark())) {
            return this.conversation.getC2cRemark();
        }
        if (!TextUtils.isEmpty(this.conversation.getC2cNickname())) {
            return this.conversation.getC2cNickname();
        }
        return this.conversation.getC2cUserID();
    }

    public int getType() {
        Conversation conversation = this.conversation;
        if (conversation != null) {
            return conversation.getConversationType();
        }
        return 0;
    }

    public int getUnreadCount() {
        Conversation conversation = this.conversation;
        if (conversation != null) {
            return (int) conversation.getUnreadMessageCount();
        }
        return 0;
    }

    public String getUserID() {
        Conversation conversation = this.conversation;
        if (conversation == null || conversation.getConversationType() != 1) {
            return null;
        }
        return this.conversation.getC2cUserID();
    }

    public boolean isPinned() {
        Conversation conversation = this.conversation;
        if (conversation == null) {
            return false;
        }
        return conversation.isPinned();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
