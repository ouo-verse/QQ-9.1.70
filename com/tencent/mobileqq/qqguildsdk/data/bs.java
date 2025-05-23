package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendShareInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bs implements eg {

    /* renamed from: a, reason: collision with root package name */
    private final GProRecommendShareInfo f265778a;

    /* renamed from: b, reason: collision with root package name */
    private final eh f265779b;

    public bs(GProRecommendShareInfo gProRecommendShareInfo) {
        this.f265778a = gProRecommendShareInfo;
        this.f265779b = new bt(gProRecommendShareInfo.getShareLive());
    }
}
