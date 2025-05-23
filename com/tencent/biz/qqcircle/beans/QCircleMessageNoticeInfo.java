package com.tencent.biz.qqcircle.beans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleMessageNoticeInfo {
    private String mDisplayText;
    private String mExtInfo;
    private String mJumpLink;
    private List<String> mMessageSenderListUin;
    private int mMessageUnReadCount;
    private String mMessageUrl;

    public QCircleMessageNoticeInfo(List<String> list, int i3, String str, String str2) {
        this.mMessageSenderListUin = list;
        this.mMessageUnReadCount = i3;
        this.mDisplayText = str;
        this.mJumpLink = str2;
    }

    public List<String> getAllSenderList() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<String> list = this.mMessageSenderListUin;
        if (list != null && list.size() > 0) {
            linkedHashSet.addAll(this.mMessageSenderListUin);
        }
        return new ArrayList(linkedHashSet);
    }

    public int getAllUnReadCount() {
        return this.mMessageUnReadCount;
    }

    public String getDisplayText() {
        return this.mDisplayText;
    }

    public String getExtInfo() {
        return this.mExtInfo;
    }

    public String getJumpLink() {
        return this.mJumpLink;
    }

    public int getMessageUnReadCount() {
        return this.mMessageUnReadCount;
    }

    public String getMessageUrl() {
        return this.mMessageUrl;
    }

    public boolean isValidMessageNotice() {
        if (getAllSenderList().size() <= 0 && getAllUnReadCount() <= 0) {
            return false;
        }
        return true;
    }

    public void setExtInfo(String str) {
        this.mExtInfo = str;
    }

    public void setMessageUrl(String str) {
        this.mMessageUrl = str;
    }
}
