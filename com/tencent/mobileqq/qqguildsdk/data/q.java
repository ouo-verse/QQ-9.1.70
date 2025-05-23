package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVDevOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSpeakTimeCtl;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserCtlInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class q implements es {

    /* renamed from: a, reason: collision with root package name */
    public final GProUserCtlInfo f266734a;

    public q(GProUserCtlInfo gProUserCtlInfo) {
        this.f266734a = gProUserCtlInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.es
    public IGProAVDevOptInfo a() {
        return new GGProAVDevOptInfo(this.f266734a.getDevOpt());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.es
    public int b() {
        return this.f266734a.getNextAVState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.es
    public IGProSpeakTimeCtl getSpeakTimeCtl() {
        return new GGProSpeakTimeCtl(this.f266734a.getSpeakTimeCtl());
    }
}
