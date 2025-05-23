package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForNearbyRecommenderTips extends ChatMessage {
    public boolean readFlag;
    public String strBrief = "";
    public long uRecommendTime;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class NearbyRecommenderInfo implements Serializable {
        public boolean readFlag;
        public String strBrief;
        public long uRecommendTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        NearbyRecommenderInfo nearbyRecommenderInfo;
        try {
            nearbyRecommenderInfo = (NearbyRecommenderInfo) MessagePkgUtils.getObjectFromBytes(this.msgData);
        } catch (Exception e16) {
            e16.printStackTrace();
            nearbyRecommenderInfo = null;
        }
        if (nearbyRecommenderInfo != null) {
            this.uRecommendTime = nearbyRecommenderInfo.uRecommendTime;
            this.readFlag = nearbyRecommenderInfo.readFlag;
            this.strBrief = nearbyRecommenderInfo.strBrief;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void serial() {
        NearbyRecommenderInfo nearbyRecommenderInfo = new NearbyRecommenderInfo();
        nearbyRecommenderInfo.uRecommendTime = this.uRecommendTime;
        nearbyRecommenderInfo.readFlag = this.readFlag;
        nearbyRecommenderInfo.strBrief = this.strBrief;
        try {
            this.msgData = MessagePkgUtils.getBytesFromObject(nearbyRecommenderInfo);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
