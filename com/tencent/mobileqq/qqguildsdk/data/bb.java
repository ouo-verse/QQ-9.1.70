package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveSearchInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private GProLiveSearchInfo f265723a;

    /* renamed from: b, reason: collision with root package name */
    private final IRecallInfo f265724b;

    public bb(GProLiveSearchInfo gProLiveSearchInfo) {
        this.f265723a = gProLiveSearchInfo;
        this.f265724b = new GProRecallInfoData(gProLiveSearchInfo.getRecallInfo());
    }
}
