package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive;

import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import ww2.h;
import ww2.i;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends h<uw2.c> {

    /* renamed from: f, reason: collision with root package name */
    private uw2.a f304149f;

    /* renamed from: h, reason: collision with root package name */
    private AdFeedInfo f304150h;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends i {
        a() {
        }

        @Override // ww2.c
        public void b() {
            c.this.q();
        }

        @Override // ww2.c
        public void c() {
            c.this.r();
        }

        @Override // ww2.c
        public void i(boolean z16) {
            c.this.s(z16);
        }
    }

    public c(uw2.c cVar) {
        super(cVar);
        this.f446624e = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Controller controller = this.f446619d;
        if (controller != 0) {
            ((uw2.c) controller).q(1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Controller controller = this.f446619d;
        if (controller != 0) {
            ((uw2.c) controller).q(2, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z16) {
        Controller controller = this.f446619d;
        if (controller != 0) {
            ((uw2.c) controller).l().i(z16);
            ((uw2.c) this.f446619d).q(7, Boolean.valueOf(z16));
        }
    }

    public void t(uw2.a aVar) {
        this.f304149f = aVar;
    }

    public void u(AdFeedInfo adFeedInfo) {
        this.f304150h = adFeedInfo;
    }
}
