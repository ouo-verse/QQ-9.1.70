package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendGroup;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProContentRecommendGroup implements IGProContentRecommendGroup {
    public final GProContentRecommendGroup mInfo;

    public GGProContentRecommendGroup(GProContentRecommendGroup gProContentRecommendGroup) {
        this.mInfo = gProContentRecommendGroup;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public long getGroupCode() {
        return this.mInfo.getGroupCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getGroupMembers() {
        return this.mInfo.getGroupMembers();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getGroupName() {
        return this.mInfo.getGroupName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getGroupSummary() {
        return this.mInfo.getGroupSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getHeadUrl() {
        return this.mInfo.getHeadUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getJoinGroupAuth() {
        return this.mInfo.getJoinGroupAuth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getJoinText() {
        return this.mInfo.getJoinText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public ArrayList<String> getRecommendReasons() {
        return this.mInfo.getRecommendReasons();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String toString() {
        return this.mInfo.toString();
    }
}
