package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class MessageOfflinePushInfo implements Serializable {
    public static final int OFFLINE_APNS_BADGE_MODE_DEFAULT = 0;
    public static final int OFFLINE_APNS_BADGE_MODE_IGNORE = 1;
    public static final int OFFLINE_PUSH_FLAG_DEFAULT = 0;
    public static final int OFFLINE_PUSH_FLAG_NO_PUSH = 1;
    private String description;
    private byte[] extension;
    private int pushFlag;
    private String soundFilePath;
    private String title;
    private APNSOfflinePushInfo apnsConfig = new APNSOfflinePushInfo();
    private AndroidOfflinePushInfo androidConfig = new AndroidOfflinePushInfo();

    /* loaded from: classes7.dex */
    public class APNSOfflinePushInfo implements Serializable {
        private int badgeMode;
        private String description;
        private String soundFilePath;
        private String title;

        public APNSOfflinePushInfo() {
        }

        public void setBadgeMode(int i3) {
            this.badgeMode = i3;
        }

        public void setSoundFilePath(String str) {
            this.soundFilePath = str;
        }
    }

    /* loaded from: classes7.dex */
    public class AndroidOfflinePushInfo implements Serializable {
        private String description;
        private int notifyMode;
        private String oppoChannelID;
        private String soundFilePath;
        private String title;
        private int vivoClassification = 1;

        public AndroidOfflinePushInfo() {
        }

        public void setOppoChannelID(String str) {
            this.oppoChannelID = str;
        }

        public void setVivoClassification(int i3) {
            this.vivoClassification = i3;
        }
    }

    public AndroidOfflinePushInfo getAndroidConfig() {
        return this.androidConfig;
    }

    public APNSOfflinePushInfo getApnsConfig() {
        return this.apnsConfig;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getExtension() {
        return this.extension;
    }

    public int getPushFlag() {
        return this.pushFlag;
    }

    public String getSoundFilePath() {
        return this.soundFilePath;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAndroidConfig(AndroidOfflinePushInfo androidOfflinePushInfo) {
        this.androidConfig = androidOfflinePushInfo;
    }

    public void setApnsConfig(APNSOfflinePushInfo aPNSOfflinePushInfo) {
        this.apnsConfig = aPNSOfflinePushInfo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtension(byte[] bArr) {
        this.extension = bArr;
    }

    public void setPushFlag(int i3) {
        this.pushFlag = i3;
    }

    public void setSoundFilePath(String str) {
        this.soundFilePath = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
