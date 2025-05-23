package com.qzone.reborn.qzmoment.bean;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMFeedDetailInitBean extends QZMInitBean {
    public static final String POPUP_COMMENT = "comment";
    public static final String POPUP_LIKE = "like";
    private Long mCreateTime;
    private String mId;
    private String mPopup;
    private String mPosterId;

    public QZMFeedDetailInitBean(String str, String str2, Long l3, String str3) {
        this.mId = str;
        this.mPosterId = str2;
        this.mCreateTime = l3;
        this.mPopup = str3;
    }

    public Long getCreateTime() {
        return this.mCreateTime;
    }

    public String getId() {
        return this.mId;
    }

    public String getPopup() {
        return this.mPopup;
    }

    public String getPosterId() {
        return this.mPosterId;
    }

    public void setCreateTime(Long l3) {
        this.mCreateTime = l3;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setPopup(String str) {
        this.mPopup = str;
    }

    public void setPosterId(String str) {
        this.mPosterId = str;
    }
}
