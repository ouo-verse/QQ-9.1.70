package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bq implements ef {

    /* renamed from: a, reason: collision with root package name */
    private GProRecommendInfo f265770a;

    /* renamed from: b, reason: collision with root package name */
    private ed f265771b;

    /* renamed from: c, reason: collision with root package name */
    private ec f265772c;

    /* renamed from: d, reason: collision with root package name */
    private eg f265773d;

    public bq(GProRecommendInfo gProRecommendInfo) {
        this.f265770a = gProRecommendInfo;
        this.f265771b = new bo(gProRecommendInfo.getFeed());
        this.f265772c = new bn(gProRecommendInfo.getChannel());
        this.f265773d = new bs(gProRecommendInfo.getShareInfo());
    }
}
