package com.qzone.reborn.qzmoment.bean;

/* loaded from: classes37.dex */
public class QZMPublishCaptureBean extends QZMInitBean {
    private final String mBackImagePath;
    private final String mFrontImagePath;
    private boolean mIsReversePic = false;

    public QZMPublishCaptureBean(String str, String str2) {
        this.mFrontImagePath = str;
        this.mBackImagePath = str2;
    }

    public String getBackUrl() {
        if (this.mIsReversePic) {
            return this.mFrontImagePath;
        }
        return this.mBackImagePath;
    }

    public String getFrontUrl() {
        if (this.mIsReversePic) {
            return this.mBackImagePath;
        }
        return this.mFrontImagePath;
    }

    public void reverse() {
        this.mIsReversePic = !this.mIsReversePic;
    }
}
