package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSmobaGameUserAction;

/* compiled from: P */
/* loaded from: classes17.dex */
public class cg implements ew {

    /* renamed from: a, reason: collision with root package name */
    private final GProVoiceSmobaGameUserAction f265814a;

    public cg(GProVoiceSmobaGameUserAction gProVoiceSmobaGameUserAction) {
        this.f265814a = gProVoiceSmobaGameUserAction;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ew
    public int a() {
        return this.f265814a.getUserActionType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ew
    public long getTinyId() {
        return this.f265814a.getTinyId();
    }
}
