package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFeedbackReq {
    public GProItemCbData callback;
    public String contentType;
    public String feedId;
    public String feedbackType;
    public String scene;

    public GProFeedbackReq() {
        this.scene = "";
        this.feedbackType = "";
        this.feedId = "";
        this.contentType = "";
        this.callback = new GProItemCbData();
    }

    public GProItemCbData getCallback() {
        return this.callback;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getFeedbackType() {
        return this.feedbackType;
    }

    public String getScene() {
        return this.scene;
    }

    public void setCallback(GProItemCbData gProItemCbData) {
        this.callback = gProItemCbData;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setFeedbackType(String str) {
        this.feedbackType = str;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public String toString() {
        return "GProFeedbackReq{scene=" + this.scene + ",feedbackType=" + this.feedbackType + ",feedId=" + this.feedId + ",contentType=" + this.contentType + ",callback=" + this.callback + ",}";
    }

    public GProFeedbackReq(String str, String str2, String str3, String str4, GProItemCbData gProItemCbData) {
        this.scene = "";
        this.feedbackType = "";
        this.feedId = "";
        this.contentType = "";
        new GProItemCbData();
        this.scene = str;
        this.feedbackType = str2;
        this.feedId = str3;
        this.contentType = str4;
        this.callback = gProItemCbData;
    }
}
