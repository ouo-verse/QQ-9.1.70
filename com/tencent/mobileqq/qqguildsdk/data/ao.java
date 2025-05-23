package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtSetInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ao implements ey {

    /* renamed from: a, reason: collision with root package name */
    private GProAtSetInfo f265684a;

    public ao(GProAtSetInfo gProAtSetInfo) {
        if (gProAtSetInfo == null) {
            this.f265684a = new GProAtSetInfo();
        } else {
            this.f265684a = gProAtSetInfo;
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ey
    public int getRemainingAtAllCount() {
        return this.f265684a.getRemainingAtAllCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ey
    public int getRemainingAtNotifyTimes() {
        return this.f265684a.getRemainingAtNotifyTimes();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ey
    public int getRemainingAtOnlCount() {
        return this.f265684a.getRemainingAtOnlCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ey
    public int getRemainingAtRoleCount() {
        return this.f265684a.getRemainingAtRoleCount();
    }
}
