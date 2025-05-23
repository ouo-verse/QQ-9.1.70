package com.tencent.biz.qqcircle.immersive.personal.data;

import feedcloud.FeedCloudMeta$StUser;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class y extends c {

    /* renamed from: c, reason: collision with root package name */
    protected FeedCloudMeta$StUser f88589c;

    public y(a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public String a() {
        return "QFSUserInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.c
    public List<b> b() {
        return Arrays.asList(new p(), new t(), new q(), new x());
    }

    public void f(FeedCloudMeta$StUser feedCloudMeta$StUser, long j3) {
        this.f88589c = feedCloudMeta$StUser;
        d(j3);
    }

    public void g(String str) {
        if (this.f88589c == null) {
            this.f88589c = new FeedCloudMeta$StUser();
        }
        this.f88589c.f398463id.set(str);
    }
}
