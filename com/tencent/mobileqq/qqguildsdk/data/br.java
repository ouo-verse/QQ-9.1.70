package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendResult;

/* compiled from: P */
/* loaded from: classes17.dex */
public class br {

    /* renamed from: a, reason: collision with root package name */
    private ef f265774a;

    /* renamed from: b, reason: collision with root package name */
    private ee f265775b;

    /* renamed from: c, reason: collision with root package name */
    private int f265776c;

    /* renamed from: d, reason: collision with root package name */
    private eb f265777d;

    public br(GProRecommendResult gProRecommendResult) {
        this.f265774a = new bq(gProRecommendResult.getRecommendInfo());
        this.f265775b = new bp(gProRecommendResult.getRecommendGroupInfo());
        this.f265776c = gProRecommendResult.getType();
        this.f265777d = new bm(gProRecommendResult.getRecommendCardInfo());
    }
}
