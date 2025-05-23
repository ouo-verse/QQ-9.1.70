package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSettingBean extends QCircleInitBean {
    private String mTagManagerUrl = "";
    private String mServiceProtocolUrl = "";
    private String mComplaintGuidelinesUrl = "";
    private String mAIGCStatementUrl = "";

    public String getAIGCStatementUrl() {
        if (TextUtils.isEmpty(this.mAIGCStatementUrl)) {
            this.mAIGCStatementUrl = "https://rule.tencent.com/rule/preview/c73d7934-62ee-4a71-a053-4b748883b1f5";
        }
        return this.mAIGCStatementUrl;
    }

    public String getComplaintGuidelinesUrl() {
        if (TextUtils.isEmpty(this.mComplaintGuidelinesUrl)) {
            this.mComplaintGuidelinesUrl = "https://rule.tencent.com/rule/preview/8d955eef-893b-4de3-ab44-0d8bd2f63aca";
        }
        return this.mComplaintGuidelinesUrl;
    }

    public String getServiceProtocolUrl() {
        if (TextUtils.isEmpty(this.mServiceProtocolUrl)) {
            this.mServiceProtocolUrl = "https://rule.tencent.com/rule/preview/a880964c-66e7-4556-8a39-827f92b2b355";
        }
        return this.mServiceProtocolUrl;
    }

    public String getTagManagerUrl() {
        return this.mTagManagerUrl;
    }

    public void setAIGCStatementUrl(String str) {
        this.mAIGCStatementUrl = str;
    }

    public void setComplaintGuidelinesUrl(String str) {
        this.mComplaintGuidelinesUrl = str;
    }

    public void setServiceProtocolUrl(String str) {
        this.mServiceProtocolUrl = str;
    }

    public void setTagManagerUrl(String str) {
        this.mTagManagerUrl = str;
    }
}
