package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendRobot;

/* loaded from: classes17.dex */
public class GGProContentRecommendRobot implements IGProContentRecommendRobot {
    public final GProContentRecommendRobot mInfo;

    public GGProContentRecommendRobot(GProContentRecommendRobot gProContentRecommendRobot) {
        this.mInfo = gProContentRecommendRobot;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getAppId() {
        return this.mInfo.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getButtonName() {
        return this.mInfo.getButtonName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public byte[] getExtra() {
        return this.mInfo.getExtra();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public IGProImageBasicInfo getPicInfo() {
        return new GGProImageBasicInfo(this.mInfo.getPicInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public long getRobotUin() {
        return this.mInfo.getRobotUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getSchema() {
        return this.mInfo.getSchema();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getUid() {
        return this.mInfo.getUid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String toString() {
        return this.mInfo.toString();
    }
}
