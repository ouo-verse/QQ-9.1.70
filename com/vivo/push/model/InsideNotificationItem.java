package com.vivo.push.model;

/* compiled from: P */
/* loaded from: classes13.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageType;
    private int mNotifyDisplayStatus;
    private String mReactPackage;
    private String mSuitReactVersion;

    private int parsingNotifyStyle() {
        int i3 = this.mDisplayStyle;
        if ((i3 & 32) != 0 || (i3 & 16) == 0) {
            return 0;
        }
        return 1;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setAppType(int i3) {
        this.mAppType = i3;
    }

    public void setDisplayStyle(int i3) {
        this.mDisplayStyle = i3;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }

    public void setInnerPriority(int i3) {
        this.mInnerPriority = i3;
    }

    public void setIsShowBigPicOnMobileNet(boolean z16) {
        this.mIsShowBigPicOnMobileNet = z16;
    }

    public void setMessageType(int i3) {
        this.mMessageType = i3;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }
}
