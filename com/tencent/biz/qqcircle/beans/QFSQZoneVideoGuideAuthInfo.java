package com.tencent.biz.qqcircle.beans;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSQZoneVideoGuideAuthInfo {
    private final String mBannerTxt;
    private final String mBtnTxt;
    private final String mPicUrl;
    private final String mToastTxt;

    public QFSQZoneVideoGuideAuthInfo(String str, String str2, String str3, String str4) {
        this.mPicUrl = str;
        this.mBtnTxt = str2;
        this.mBannerTxt = str3;
        this.mToastTxt = str4;
    }

    public String getBannerTxt() {
        return this.mBannerTxt;
    }

    public String getBtnTxt() {
        return this.mBtnTxt;
    }

    public String getPicUrl() {
        return this.mPicUrl;
    }

    public String getToastTxt() {
        return this.mToastTxt;
    }
}
