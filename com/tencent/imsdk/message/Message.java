package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Message implements Serializable {
    public static int MESSAGE_TYPE_C2C = 1;
    public static int MESSAGE_TYPE_GROUP = 2;
    public static int MESSAGE_TYPE_MULTI_SYNC = 3;
    public static int MESSAGE_TYPE_UNKNOWN = 0;
    public static int PLATFORM_ANDROID = 2;
    public static int PLATFORM_IOS = 3;
    public static int PLATFORM_MAC = 4;
    public static int PLATFORM_OTHER = 0;
    public static int PLATFORM_SIMULATOR = 5;
    public static int PLATFORM_WINDOWS = 1;
    public static final int V2TIM_MSG_STATUS_DELETED = 4;
    public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
    public static final int V2TIM_MSG_STATUS_REVOKED = 6;
    public static final int V2TIM_MSG_STATUS_SENDING = 1;
    public static final int V2TIM_MSG_STATUS_SEND_FAILED = 3;
    public static final int V2TIM_MSG_STATUS_SUCCESS = 2;
    private long clientTime;
    private String cloudCustomString;
    private String faceUrl;
    private String friendRemark;
    private String groupID;
    private boolean isForward;
    private boolean isPeerRead;
    private boolean isSelfRead;
    private int localCustomNumber;
    private String localCustomString;
    private int messageStatus;
    private int messageType;
    private String nameCard;
    private String nickName;
    private MessageOfflinePushInfo offlinePushInfo;
    private int platform;
    private int priority;
    private long random;
    private long receiverTinyID;
    private String receiverUserID;
    private long senderTinyID;
    private String senderUserID;
    private long seq;
    private long serverTime;
    private String msgID = "";
    private boolean isMessageSender = true;
    private int lifeTime = -1;
    private List<MessageBaseElement> messageBaseElements = new ArrayList();
    private List<MessageAtInfo> messageGroupAtInfoList = new ArrayList();
    private boolean excludedFromUnreadCount = false;
    private boolean excludedFromLastMessage = false;

    public void addElement(MessageBaseElement messageBaseElement) {
        if (messageBaseElement == null) {
            return;
        }
        this.messageBaseElements.add(messageBaseElement);
    }

    protected void addMessageGroupAtInfo(MessageAtInfo messageAtInfo) {
        this.messageGroupAtInfoList.add(messageAtInfo);
    }

    public long getClientTime() {
        return this.clientTime;
    }

    public String getCloudCustomString() {
        return this.cloudCustomString;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public String getFriendRemark() {
        return this.friendRemark;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public int getLifeTime() {
        return this.lifeTime;
    }

    public int getLocalCustomNumber() {
        return this.localCustomNumber;
    }

    public String getLocalCustomString() {
        return this.localCustomString;
    }

    public List<MessageBaseElement> getMessageBaseElements() {
        return this.messageBaseElements;
    }

    public List<MessageAtInfo> getMessageGroupAtInfoList() {
        return this.messageGroupAtInfoList;
    }

    public MessageKey getMessageKey() {
        MessageKey messageKey = new MessageKey();
        messageKey.setMessageID(this.msgID);
        messageKey.setMessageType(this.messageType);
        messageKey.setIsMessageSender(this.isMessageSender);
        messageKey.setSenderUserID(this.senderUserID);
        messageKey.setReceiverUserID(this.receiverUserID);
        messageKey.setGroupID(this.groupID);
        messageKey.setClientTime(this.clientTime);
        messageKey.setServerTime(this.serverTime);
        messageKey.setSeq(this.seq);
        messageKey.setRandom(this.random);
        return messageKey;
    }

    public int getMessageStatus() {
        return this.messageStatus;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getMsgID() {
        return this.msgID;
    }

    public String getNameCard() {
        return this.nameCard;
    }

    public String getNickName() {
        return this.nickName;
    }

    public MessageOfflinePushInfo getOfflinePushInfo() {
        return this.offlinePushInfo;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getRandom() {
        return this.random;
    }

    public String getReceiverUserID() {
        return this.receiverUserID;
    }

    public String getSenderUserID() {
        return this.senderUserID;
    }

    public long getSeq() {
        return this.seq;
    }

    public long getTimestamp() {
        long j3 = this.serverTime;
        if (j3 > 0) {
            return j3;
        }
        return this.clientTime;
    }

    public boolean isExcludedFromLastMessage() {
        return this.excludedFromLastMessage;
    }

    public boolean isExcludedFromUnreadCount() {
        return this.excludedFromUnreadCount;
    }

    public boolean isForward() {
        return this.isForward;
    }

    public boolean isMessageSender() {
        return this.isMessageSender;
    }

    public boolean isPeerRead() {
        if (this.isPeerRead) {
            return true;
        }
        boolean isMessagePeerRead = MessageCenter.getInstance().isMessagePeerRead(getMessageKey());
        this.isPeerRead = isMessagePeerRead;
        return isMessagePeerRead;
    }

    public boolean isSelfRead() {
        if (this.isSelfRead) {
            return true;
        }
        boolean isMessageSelfRead = MessageCenter.getInstance().isMessageSelfRead(getMessageKey());
        this.isSelfRead = isMessageSelfRead;
        return isMessageSelfRead;
    }

    public void setClientTime(long j3) {
        this.clientTime = j3;
    }

    public void setCloudCustomString(String str) {
        this.cloudCustomString = str;
    }

    public void setExcludedFromLastMessage(boolean z16) {
        this.excludedFromLastMessage = z16;
    }

    public void setExcludedFromUnreadCount(boolean z16) {
        this.excludedFromUnreadCount = z16;
    }

    public void setForward(boolean z16) {
        this.isForward = z16;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setIsMessageSender(boolean z16) {
        this.isMessageSender = z16;
    }

    public void setLifeTime(int i3) {
        this.lifeTime = i3;
    }

    public void setLocalCustomNumber(int i3) {
        this.localCustomNumber = i3;
        MessageCenter.getInstance().setLocalCustomNumber(this, i3);
    }

    public void setLocalCustomString(String str) {
        this.localCustomString = str;
        MessageCenter.getInstance().setLocalCustomString(this, str);
    }

    public void setMessageBaseElements(List<MessageBaseElement> list) {
        this.messageBaseElements = list;
    }

    public void setMessageGroupAtInfoList(List<MessageAtInfo> list) {
        this.messageGroupAtInfoList = list;
    }

    public void setMessageStatus(int i3) {
        this.messageStatus = i3;
    }

    public void setMessageType(int i3) {
        this.messageType = i3;
    }

    public void setOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo) {
        this.offlinePushInfo = messageOfflinePushInfo;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setPriority(int i3) {
        this.priority = i3;
    }

    public void setReceiverUserID(String str) {
        this.receiverUserID = str;
    }

    public void setSenderUserID(String str) {
        this.senderUserID = str;
    }

    public void update(Message message) {
        this.msgID = message.msgID;
        this.messageType = message.messageType;
        this.isMessageSender = message.isMessageSender;
        this.senderUserID = message.senderUserID;
        this.receiverUserID = message.receiverUserID;
        this.groupID = message.groupID;
        this.clientTime = message.clientTime;
        this.serverTime = message.serverTime;
        this.seq = message.seq;
        this.random = message.random;
        this.messageStatus = message.messageStatus;
        for (MessageBaseElement messageBaseElement : this.messageBaseElements) {
            Iterator<MessageBaseElement> it = message.messageBaseElements.iterator();
            while (it.hasNext() && !messageBaseElement.update(it.next())) {
            }
        }
    }
}
