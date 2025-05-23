package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleSearchInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bw {

    /* renamed from: a, reason: collision with root package name */
    private GProScheduleSearchInfo f265786a;

    /* renamed from: b, reason: collision with root package name */
    private el f265787b;

    /* renamed from: c, reason: collision with root package name */
    private final IRecallInfo f265788c;

    public bw(GProScheduleSearchInfo gProScheduleSearchInfo) {
        this.f265786a = gProScheduleSearchInfo;
        this.f265787b = new bx(gProScheduleSearchInfo.getCreator());
        this.f265788c = new GProRecallInfoData(this.f265786a.getRecallInfo());
    }
}
