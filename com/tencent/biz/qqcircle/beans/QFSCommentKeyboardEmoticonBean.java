package com.tencent.biz.qqcircle.beans;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentKeyboardEmoticonBean {
    private String mDesc;
    private int mLocalId;
    private int mServerId;

    public QFSCommentKeyboardEmoticonBean(int i3, int i16, String str) {
        this.mServerId = i3;
        this.mLocalId = i16;
        this.mDesc = str;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public int getLocalId() {
        return this.mLocalId;
    }

    public int getServerId() {
        return this.mServerId;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setLocalId(int i3) {
        this.mLocalId = i3;
    }

    public void setServerId(int i3) {
        this.mServerId = i3;
    }

    public String toString() {
        return "QFSCommentKeyboardEmoticonBean{mServerId=" + this.mServerId + ", mLocalId=" + this.mLocalId + ", mDesc='" + this.mDesc + "'}";
    }
}
