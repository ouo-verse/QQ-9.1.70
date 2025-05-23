package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSearchTopicRsp {
    public boolean isFinished;
    public ArrayList<GProTopicInfo> topicList = new ArrayList<>();
    public byte[] cookie = new byte[0];

    public byte[] getCookie() {
        return this.cookie;
    }

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public ArrayList<GProTopicInfo> getTopicList() {
        return this.topicList;
    }

    public String toString() {
        return "GProSearchTopicRsp{topicList=" + this.topicList + ",cookie=" + this.cookie + ",isFinished=" + this.isFinished + ",}";
    }
}
