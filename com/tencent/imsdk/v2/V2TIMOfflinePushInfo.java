package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageOfflinePushInfo;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class V2TIMOfflinePushInfo implements Serializable {
    public static final String IOS_OFFLINE_PUSH_DEFAULT_SOUND = "default";
    public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
    private MessageOfflinePushInfo messageOfflinePushInfo;

    public void disablePush(boolean z16) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        if (z16) {
            this.messageOfflinePushInfo.setPushFlag(1);
        } else {
            this.messageOfflinePushInfo.setPushFlag(0);
        }
    }

    public String getDesc() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            return messageOfflinePushInfo.getDescription();
        }
        return null;
    }

    public byte[] getExt() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo == null) {
            return null;
        }
        return messageOfflinePushInfo.getExtension();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageOfflinePushInfo getMessageOfflinePushInfo() {
        return this.messageOfflinePushInfo;
    }

    public String getTitle() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            return messageOfflinePushInfo.getTitle();
        }
        return null;
    }

    public boolean isDisablePush() {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo == null || messageOfflinePushInfo.getPushFlag() != 1) {
            return false;
        }
        return true;
    }

    public void setAndroidOPPOChannelID(String str) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getAndroidConfig().setOppoChannelID(str);
        }
    }

    public void setAndroidVIVOClassification(int i3) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getAndroidConfig().setVivoClassification(i3);
        }
    }

    public void setDesc(String str) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo.setDescription(str);
    }

    public void setExt(byte[] bArr) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo.setExtension(bArr);
    }

    public void setIOSSound(String str) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            messageOfflinePushInfo.getApnsConfig().setSoundFilePath(str);
        }
    }

    public void setIgnoreIOSBadge(boolean z16) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (messageOfflinePushInfo != null) {
            if (z16) {
                messageOfflinePushInfo.getApnsConfig().setBadgeMode(1);
            } else {
                messageOfflinePushInfo.getApnsConfig().setBadgeMode(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMessageOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo) {
        this.messageOfflinePushInfo = messageOfflinePushInfo;
    }

    public void setTitle(String str) {
        if (this.messageOfflinePushInfo == null) {
            this.messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo.setTitle(str);
    }
}
