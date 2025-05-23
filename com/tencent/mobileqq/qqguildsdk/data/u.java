package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAssociativeWords;

/* compiled from: P */
/* loaded from: classes17.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private GProAssociativeWords f266745a;

    /* renamed from: b, reason: collision with root package name */
    private IRecallInfo f266746b;

    public u(GProAssociativeWords gProAssociativeWords) {
        this.f266745a = gProAssociativeWords;
        this.f266746b = new GProRecallInfoData(gProAssociativeWords.getRecallInfo());
    }
}
