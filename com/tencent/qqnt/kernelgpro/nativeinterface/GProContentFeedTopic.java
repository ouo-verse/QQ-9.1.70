package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentFeedTopic implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProMVPTopicContent> topicContents = new ArrayList<>();

    public ArrayList<GProMVPTopicContent> getTopicContents() {
        return this.topicContents;
    }

    public String toString() {
        return "GProContentFeedTopic{topicContents=" + this.topicContents + ",}";
    }
}
