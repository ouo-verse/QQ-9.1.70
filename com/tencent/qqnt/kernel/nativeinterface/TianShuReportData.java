package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TianShuReportData {
    public int mActionAttr;
    public int mActionId;
    public int mActionValue;
    public String mAppId;
    public String mItemId;
    public String mPageId;
    public String mSubItemId;

    public TianShuReportData() {
        this.mAppId = "";
        this.mPageId = "";
        this.mItemId = "";
        this.mSubItemId = "";
    }

    public int getMActionAttr() {
        return this.mActionAttr;
    }

    public int getMActionId() {
        return this.mActionId;
    }

    public int getMActionValue() {
        return this.mActionValue;
    }

    public String getMAppId() {
        return this.mAppId;
    }

    public String getMItemId() {
        return this.mItemId;
    }

    public String getMPageId() {
        return this.mPageId;
    }

    public String getMSubItemId() {
        return this.mSubItemId;
    }

    public String toString() {
        return "TianShuReportData{mAppId=" + this.mAppId + ",mPageId=" + this.mPageId + ",mItemId=" + this.mItemId + ",mSubItemId=" + this.mSubItemId + ",mActionId=" + this.mActionId + ",mActionValue=" + this.mActionValue + ",mActionAttr=" + this.mActionAttr + ",}";
    }

    public TianShuReportData(String str, String str2, String str3, String str4, int i3, int i16, int i17) {
        this.mAppId = str;
        this.mPageId = str2;
        this.mItemId = str3;
        this.mSubItemId = str4;
        this.mActionId = i3;
        this.mActionValue = i16;
        this.mActionAttr = i17;
    }
}
