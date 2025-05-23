package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TianShuReportData {
    static IPatchRedirector $redirector_;
    public int mActionAttr;
    public int mActionId;
    public int mActionValue;
    public int mAdSpace;
    public String mAppId;
    public String mBusiInfo;
    public String mItemId;
    public String mItemType;
    public String mModuleId;
    public boolean mNeedReportCachedUrl;
    public long mOperTime;
    public String mPageId;
    public String mPositionId;
    public int mRuleId;
    public String mSubItemId;
    public String mSubModuleId;
    public int mTestId;
    public String mToUid;
    public String mTraceDetail;
    public String mTraceId;
    public String mTraceIndex;
    public int mTraceNum;
    public String mTriggerInfo;

    public TianShuReportData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mToUid = "";
        this.mTraceId = "";
        this.mTraceNum = -1;
        this.mTraceDetail = "";
        this.mTraceIndex = "";
        this.mAppId = "";
        this.mPageId = "";
        this.mItemId = "";
        this.mSubItemId = "";
        this.mModuleId = "";
        this.mSubModuleId = "";
        this.mPositionId = "";
        this.mTestId = -1;
        this.mRuleId = -1;
        this.mOperTime = -1L;
        this.mActionId = -1;
        this.mActionValue = -1;
        this.mActionAttr = -1;
        this.mTriggerInfo = "";
        this.mBusiInfo = "";
        this.mItemType = "";
        this.mAdSpace = 0;
        this.mNeedReportCachedUrl = true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TianShuReportData{mToUid='" + this.mToUid + "', mTraceId='" + this.mTraceId + "', mTraceNum=" + this.mTraceNum + ", mTraceDetail='" + this.mTraceDetail + "', mTraceIndex='" + this.mTraceIndex + "', mAppId='" + this.mAppId + "', mPageId='" + this.mPageId + "', mItemId='" + this.mItemId + "', mSubItemId='" + this.mSubItemId + "', mModuleId='" + this.mModuleId + "', mSubModuleId='" + this.mSubModuleId + "', mPositionId='" + this.mPositionId + "', mTestId=" + this.mTestId + ", mRuleId=" + this.mRuleId + ", mOperTime=" + this.mOperTime + ", mActionId=" + this.mActionId + ", mActionValue=" + this.mActionValue + ", mActionAttr=" + this.mActionAttr + ", mTriggerInfo='" + this.mTriggerInfo + "', mBusiInfo='" + this.mBusiInfo + "', mItemType='" + this.mItemType + "', mAdSpace='" + this.mAdSpace + "', mNeedReportCachedUrl='" + this.mNeedReportCachedUrl + "'}";
    }

    public TianShuReportData(String str, int i3, int i16, int i17, String str2, String str3, String str4, String str5, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2, str3, str4, str5, Integer.valueOf(i18));
            return;
        }
        this.mToUid = "";
        this.mTraceDetail = "";
        this.mTraceIndex = "";
        this.mPageId = "";
        this.mSubModuleId = "";
        this.mPositionId = "";
        this.mTestId = -1;
        this.mRuleId = -1;
        this.mActionAttr = -1;
        this.mTriggerInfo = "";
        this.mBusiInfo = "";
        this.mItemType = "";
        this.mAdSpace = 0;
        this.mNeedReportCachedUrl = true;
        this.mTraceId = str;
        this.mTraceNum = i3;
        this.mActionId = i16;
        this.mActionValue = i17;
        this.mAppId = str2;
        this.mModuleId = str3;
        this.mItemId = str4;
        this.mSubItemId = str5;
        this.mOperTime = i18;
    }
}
