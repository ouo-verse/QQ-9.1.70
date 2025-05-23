package com.tencent.biz.qqcircle.beans;

import java.util.List;

/* loaded from: classes4.dex */
public class QFSFollowRecommendParseInfo {
    private List<String> mAvatarUrls;
    private String mRecommendStr;

    public List<String> getAvatarUrls() {
        return this.mAvatarUrls;
    }

    public String getRecommendStr() {
        return this.mRecommendStr;
    }

    public void setAvatarUrls(List<String> list) {
        this.mAvatarUrls = list;
    }

    public void setRecommendStr(String str) {
        this.mRecommendStr = str;
    }
}
