package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.b;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyRedDotCustomInfoImpl implements INearbyRedDotCustomInfo {
    private final b mNearbyRedDotCustomInfo = new b();

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public String getContentMsg() {
        return this.mNearbyRedDotCustomInfo.f253062f;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public int getContentType() {
        return this.mNearbyRedDotCustomInfo.f253060d;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public String getFaceUrl() {
        return this.mNearbyRedDotCustomInfo.f253065i;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public boolean getIsOfficialNotify() {
        return this.mNearbyRedDotCustomInfo.f253059c;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public boolean getIsOfficialNum() {
        return this.mNearbyRedDotCustomInfo.f253058b;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public String getRecommendPeopleMsgId() {
        return this.mNearbyRedDotCustomInfo.f253064h;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public int getRedDotNum() {
        return this.mNearbyRedDotCustomInfo.f253057a;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public String getTopicId() {
        return this.mNearbyRedDotCustomInfo.f253063g;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public long getUin() {
        return this.mNearbyRedDotCustomInfo.f253066j;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public int getUserType() {
        return this.mNearbyRedDotCustomInfo.f253061e;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public void parse(Object obj) {
        this.mNearbyRedDotCustomInfo.b((oidb_0x791$RedDotInfo) obj);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo
    public void parse(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        this.mNearbyRedDotCustomInfo.a(redTypeInfo);
    }
}
