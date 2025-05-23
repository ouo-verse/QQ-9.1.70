package com.tencent.biz.qqcircle.immersive.personal.data;

import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n extends c {

    /* renamed from: c, reason: collision with root package name */
    protected FeedCloudRead$StGetMainPageBasicDataRsp f88549c;

    public n(a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public String a() {
        return "QFSMainPageCommRspData";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public List<b> b() {
        return Arrays.asList(new m());
    }

    public void f(FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp, long j3) {
        this.f88549c = feedCloudRead$StGetMainPageBasicDataRsp;
        d(j3);
    }
}
