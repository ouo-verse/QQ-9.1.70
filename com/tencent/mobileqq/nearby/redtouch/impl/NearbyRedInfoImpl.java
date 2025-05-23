package com.tencent.mobileqq.nearby.redtouch.impl;

import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearby.redtouch.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyRedInfoImpl implements INearbyRedInfo {
    private final c mNearbyRedInfo = new c();

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void addFaceUrl(String str, boolean z16) {
        this.mNearbyRedInfo.a(str, z16);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void addRedNum(int i3) {
        this.mNearbyRedInfo.c(i3);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public String getCornerInfo() {
        return this.mNearbyRedInfo.f253075h;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public int getRedAppIdType() {
        return this.mNearbyRedInfo.f253074g;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public int getRedNum() {
        return this.mNearbyRedInfo.f253069b;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public int getRedPointReportType() {
        return this.mNearbyRedInfo.f253073f;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public int getRedType() {
        return this.mNearbyRedInfo.f253068a;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public List<String> getRedUrl() {
        return this.mNearbyRedInfo.f253071d;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public String getTipTextInfo() {
        return this.mNearbyRedInfo.f253076i;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void setCornerInfo(String str) {
        this.mNearbyRedInfo.f253075h = str;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void setRedAppIdType(int i3) {
        this.mNearbyRedInfo.f253074g = i3;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void setRedPointReportType(int i3) {
        this.mNearbyRedInfo.f253073f = i3;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void setRedType(int i3) {
        this.mNearbyRedInfo.e(i3);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void setTipTextInfo(String str) {
        this.mNearbyRedInfo.f253076i = str;
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void addFaceUrl(List<String> list, boolean z16) {
        this.mNearbyRedInfo.b(list, z16);
    }

    @Override // com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo
    public void addRedNum(String str) {
        this.mNearbyRedInfo.d(str);
    }
}
