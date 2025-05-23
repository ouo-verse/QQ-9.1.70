package com.tencent.imsdk.v2;

import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageAtInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageOfflinePushInfo;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMMessage implements Serializable {
    public static final int V2TIM_ELEM_TYPE_CUSTOM = 2;
    public static final int V2TIM_ELEM_TYPE_FACE = 8;
    public static final int V2TIM_ELEM_TYPE_FILE = 6;
    public static final int V2TIM_ELEM_TYPE_GROUP_TIPS = 9;
    public static final int V2TIM_ELEM_TYPE_IMAGE = 3;
    public static final int V2TIM_ELEM_TYPE_LOCATION = 7;
    public static final int V2TIM_ELEM_TYPE_MERGER = 10;
    public static final int V2TIM_ELEM_TYPE_NONE = 0;
    public static final int V2TIM_ELEM_TYPE_SOUND = 4;
    public static final int V2TIM_ELEM_TYPE_TEXT = 1;
    public static final int V2TIM_ELEM_TYPE_VIDEO = 5;
    public static final int V2TIM_MSG_STATUS_HAS_DELETED = 4;
    public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
    public static final int V2TIM_MSG_STATUS_LOCAL_REVOKED = 6;
    public static final int V2TIM_MSG_STATUS_SENDING = 1;
    public static final int V2TIM_MSG_STATUS_SEND_FAIL = 3;
    public static final int V2TIM_MSG_STATUS_SEND_SUCC = 2;
    public static final int V2TIM_NOT_RECEIVE_MESSAGE = 1;
    public static final int V2TIM_PRIORITY_DEFAULT = 0;
    public static final int V2TIM_PRIORITY_HIGH = 1;
    public static final int V2TIM_PRIORITY_LOW = 3;
    public static final int V2TIM_PRIORITY_NORMAL = 2;
    public static final int V2TIM_RECEIVE_MESSAGE = 0;
    public static final int V2TIM_RECEIVE_NOT_NOTIFY_MESSAGE = 2;
    private Message message;

    public V2TIMMessage() {
        Message message = new Message();
        this.message = message;
        message.setClientTime(BaseManager.getInstance().getServerTime());
    }

    public String getCloudCustomData() {
        Message message = this.message;
        if (message == null) {
            return "";
        }
        return message.getCloudCustomString();
    }

    public V2TIMCustomElem getCustomElem() {
        if (getElemType() == 0 || getElemType() != 2) {
            return null;
        }
        V2TIMCustomElem v2TIMCustomElem = new V2TIMCustomElem();
        v2TIMCustomElem.setMessage(this.message);
        v2TIMCustomElem.setElemIndex(0);
        return v2TIMCustomElem;
    }

    public int getElemType() {
        Message message = this.message;
        if (message == null || message.getMessageBaseElements().size() <= 0) {
            return 0;
        }
        MessageBaseElement messageBaseElement = this.message.getMessageBaseElements().get(0);
        if (messageBaseElement instanceof TextElement) {
            return 1;
        }
        if (messageBaseElement instanceof ImageElement) {
            return 3;
        }
        if (messageBaseElement instanceof VideoElement) {
            return 5;
        }
        if (messageBaseElement instanceof SoundElement) {
            return 4;
        }
        if (messageBaseElement instanceof FaceElement) {
            return 8;
        }
        if (messageBaseElement instanceof FileElement) {
            return 6;
        }
        if (messageBaseElement instanceof CustomElement) {
            return 2;
        }
        if (messageBaseElement instanceof LocationElement) {
            return 7;
        }
        if (messageBaseElement instanceof GroupTipsElement) {
            return 9;
        }
        if (!(messageBaseElement instanceof MergerElement)) {
            return 0;
        }
        return 10;
    }

    public V2TIMFaceElem getFaceElem() {
        if (getElemType() == 0 || getElemType() != 8) {
            return null;
        }
        V2TIMFaceElem v2TIMFaceElem = new V2TIMFaceElem();
        v2TIMFaceElem.setMessage(this.message);
        v2TIMFaceElem.setElemIndex(0);
        return v2TIMFaceElem;
    }

    public String getFaceUrl() {
        Message message = this.message;
        if (message != null) {
            return message.getFaceUrl();
        }
        return null;
    }

    public V2TIMFileElem getFileElem() {
        if (getElemType() == 0 || getElemType() != 6) {
            return null;
        }
        V2TIMFileElem v2TIMFileElem = new V2TIMFileElem();
        v2TIMFileElem.setMessage(this.message);
        v2TIMFileElem.setElemIndex(0);
        return v2TIMFileElem;
    }

    public String getFriendRemark() {
        Message message = this.message;
        if (message != null) {
            return message.getFriendRemark();
        }
        return null;
    }

    public List<String> getGroupAtUserList() {
        Message message = this.message;
        if (message == null) {
            return new ArrayList();
        }
        List<MessageAtInfo> messageGroupAtInfoList = message.getMessageGroupAtInfoList();
        ArrayList arrayList = new ArrayList();
        Iterator<MessageAtInfo> it = messageGroupAtInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAtUserID());
        }
        return arrayList;
    }

    public String getGroupID() {
        Message message = this.message;
        if (message != null && message.getMessageType() == Message.MESSAGE_TYPE_GROUP) {
            return this.message.getGroupID();
        }
        return null;
    }

    public V2TIMGroupTipsElem getGroupTipsElem() {
        if (getElemType() == 0 || getElemType() != 9) {
            return null;
        }
        V2TIMGroupTipsElem v2TIMGroupTipsElem = new V2TIMGroupTipsElem();
        v2TIMGroupTipsElem.setMessage(this.message);
        v2TIMGroupTipsElem.setElemIndex(0);
        return v2TIMGroupTipsElem;
    }

    public V2TIMImageElem getImageElem() {
        if (getElemType() == 0 || getElemType() != 3) {
            return null;
        }
        V2TIMImageElem v2TIMImageElem = new V2TIMImageElem();
        v2TIMImageElem.setMessage(this.message);
        v2TIMImageElem.setElemIndex(0);
        return v2TIMImageElem;
    }

    public String getLocalCustomData() {
        Message message = this.message;
        if (message == null) {
            return "";
        }
        return message.getLocalCustomString();
    }

    public int getLocalCustomInt() {
        Message message = this.message;
        if (message == null) {
            return 0;
        }
        return message.getLocalCustomNumber();
    }

    public V2TIMLocationElem getLocationElem() {
        if (getElemType() == 0 || getElemType() != 7) {
            return null;
        }
        V2TIMLocationElem v2TIMLocationElem = new V2TIMLocationElem();
        v2TIMLocationElem.setMessage(this.message);
        v2TIMLocationElem.setElemIndex(0);
        return v2TIMLocationElem;
    }

    public V2TIMMergerElem getMergerElem() {
        if (getElemType() == 0 || getElemType() != 10) {
            return null;
        }
        V2TIMMergerElem v2TIMMergerElem = new V2TIMMergerElem();
        v2TIMMergerElem.setMessage(this.message);
        v2TIMMergerElem.setElemIndex(0);
        return v2TIMMergerElem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Message getMessage() {
        return this.message;
    }

    public String getMsgID() {
        Message message = this.message;
        if (message != null) {
            return message.getMsgID();
        }
        return "";
    }

    public String getNameCard() {
        Message message = this.message;
        if (message != null) {
            return message.getNameCard();
        }
        return null;
    }

    public String getNickName() {
        Message message = this.message;
        if (message != null) {
            return message.getNickName();
        }
        return null;
    }

    public V2TIMOfflinePushInfo getOfflinePushInfo() {
        Message message = this.message;
        if (message == null) {
            return null;
        }
        MessageOfflinePushInfo offlinePushInfo = message.getOfflinePushInfo();
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setMessageOfflinePushInfo(offlinePushInfo);
        return v2TIMOfflinePushInfo;
    }

    public int getPriority() {
        Message message = this.message;
        if (message != null) {
            return message.getPriority();
        }
        return 0;
    }

    public long getRandom() {
        Message message = this.message;
        if (message == null) {
            return 0L;
        }
        return message.getRandom();
    }

    public String getSender() {
        Message message = this.message;
        if (message != null) {
            return message.getSenderUserID();
        }
        return null;
    }

    public long getSeq() {
        Message message = this.message;
        if (message == null) {
            return 0L;
        }
        return message.getSeq();
    }

    public V2TIMSoundElem getSoundElem() {
        if (getElemType() == 0 || getElemType() != 4) {
            return null;
        }
        V2TIMSoundElem v2TIMSoundElem = new V2TIMSoundElem();
        v2TIMSoundElem.setMessage(this.message);
        v2TIMSoundElem.setElemIndex(0);
        return v2TIMSoundElem;
    }

    public int getStatus() {
        Message message = this.message;
        if (message == null) {
            return 1;
        }
        return message.getMessageStatus();
    }

    public V2TIMTextElem getTextElem() {
        if (getElemType() == 0 || getElemType() != 1) {
            return null;
        }
        V2TIMTextElem v2TIMTextElem = new V2TIMTextElem();
        v2TIMTextElem.setMessage(this.message);
        v2TIMTextElem.setElemIndex(0);
        return v2TIMTextElem;
    }

    public long getTimestamp() {
        Message message = this.message;
        if (message != null) {
            return message.getTimestamp();
        }
        return 0L;
    }

    public String getUserID() {
        Message message = this.message;
        if (message != null && message.getMessageType() == Message.MESSAGE_TYPE_C2C) {
            if (this.message.isMessageSender()) {
                return this.message.getReceiverUserID();
            }
            return this.message.getSenderUserID();
        }
        return null;
    }

    public V2TIMVideoElem getVideoElem() {
        if (getElemType() == 0 || getElemType() != 5) {
            return null;
        }
        V2TIMVideoElem v2TIMVideoElem = new V2TIMVideoElem();
        v2TIMVideoElem.setMessage(this.message);
        v2TIMVideoElem.setElemIndex(0);
        return v2TIMVideoElem;
    }

    public boolean isExcludedFromLastMessage() {
        Message message = this.message;
        if (message == null) {
            return false;
        }
        return message.isExcludedFromLastMessage();
    }

    public boolean isExcludedFromUnreadCount() {
        Message message = this.message;
        if (message == null) {
            return false;
        }
        return message.isExcludedFromUnreadCount();
    }

    public boolean isPeerRead() {
        Message message;
        int status = getStatus();
        if (status == 1 || status == 3 || (message = this.message) == null) {
            return false;
        }
        return message.isPeerRead();
    }

    public boolean isRead() {
        Message message = this.message;
        if (message != null) {
            return message.isSelfRead();
        }
        return true;
    }

    public boolean isSelf() {
        Message message = this.message;
        if (message != null) {
            return message.isMessageSender();
        }
        return true;
    }

    public void setCloudCustomData(String str) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setCloudCustomString(str);
    }

    public void setExcludedFromLastMessage(boolean z16) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setExcludedFromLastMessage(z16);
    }

    public void setExcludedFromUnreadCount(boolean z16) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setExcludedFromUnreadCount(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setGroupAtUserList(List<String> list) {
        if (this.message != null && list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                MessageAtInfo messageAtInfo = new MessageAtInfo();
                messageAtInfo.setAtUserID(str);
                arrayList.add(messageAtInfo);
            }
            this.message.setMessageGroupAtInfoList(arrayList);
        }
    }

    public void setLocalCustomData(String str) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setLocalCustomString(str);
    }

    public void setLocalCustomInt(int i3) {
        Message message = this.message;
        if (message == null) {
            return;
        }
        message.setLocalCustomNumber(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMessage(Message message) {
        if (message == null) {
            return;
        }
        this.message = message;
    }
}
