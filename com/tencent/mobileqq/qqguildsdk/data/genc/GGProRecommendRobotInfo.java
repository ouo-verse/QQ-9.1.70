package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendRobotInfo;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProRecommendRobotInfo implements IGProRecommendRobotInfo {
    public final GProRecommendRobotInfo mInfo;

    public GGProRecommendRobotInfo(GProRecommendRobotInfo gProRecommendRobotInfo) {
        this.mInfo = gProRecommendRobotInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotInfo
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotInfo
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotInfo
    public ArrayList<String> getIntroduceList() {
        return this.mInfo.getIntroduceList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotInfo
    public long getRobotUin() {
        return this.mInfo.getRobotUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
