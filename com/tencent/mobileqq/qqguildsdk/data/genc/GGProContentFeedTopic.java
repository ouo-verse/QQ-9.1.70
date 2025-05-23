package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentFeedTopic;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPTopicContent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProContentFeedTopic implements IGProContentFeedTopic {
    public final GProContentFeedTopic mInfo;

    public GGProContentFeedTopic(GProContentFeedTopic gProContentFeedTopic) {
        this.mInfo = gProContentFeedTopic;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentFeedTopic
    public ArrayList<IGProMVPTopicContent> getTopicContents() {
        ArrayList<GProMVPTopicContent> topicContents = this.mInfo.getTopicContents();
        ArrayList<IGProMVPTopicContent> arrayList = new ArrayList<>();
        Iterator<GProMVPTopicContent> it = topicContents.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMVPTopicContent(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentFeedTopic
    public String toString() {
        return this.mInfo.toString();
    }
}
