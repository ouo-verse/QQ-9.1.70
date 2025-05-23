package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJoinCondition;

/* loaded from: classes17.dex */
public class GGProJoinCondition implements IGProJoinCondition {
    public final GProJoinCondition mInfo;

    public GGProJoinCondition(GProJoinCondition gProJoinCondition) {
        this.mInfo = gProJoinCondition;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinCondition
    public IGProAccountCondition getAccountCondition() {
        return new GGProAccountCondition(this.mInfo.getAccountCondition());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinCondition
    public String toString() {
        return this.mInfo.toString();
    }
}
