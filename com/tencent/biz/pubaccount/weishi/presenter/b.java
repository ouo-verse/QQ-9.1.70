package com.tencent.biz.pubaccount.weishi.presenter;

import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.holder.f;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.util.x;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b implements com.tencent.biz.pubaccount.weishi.player.a {

    /* renamed from: a, reason: collision with root package name */
    private WSFollowFeedHolder f81239a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f81240b;

    private void a() {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder == null || this.f81240b) {
            return;
        }
        this.f81240b = true;
        wSFollowFeedHolder.k0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void b(e eVar) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder != null) {
            wSFollowFeedHolder.E0(true);
            this.f81239a.C0(false);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void d(e eVar) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder != null) {
            wSFollowFeedHolder.E0(false);
            this.f81239a.C0(true);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void e(e eVar) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder != null) {
            wSFollowFeedHolder.E0(true);
            this.f81239a.H(8, 400);
            this.f81239a.D0(true);
            x.i("WS_VIDEO_PLAYER", "[WSFollowFeedUIDelegate.java][onVideoStart] title:" + eVar.f81127c.f81175j);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void f(e eVar) {
        WSPlayerWrapper wSPlayerWrapper;
        if (this.f81239a != null && eVar != null && (wSPlayerWrapper = eVar.f81129e) != null) {
            boolean b06 = wSPlayerWrapper.b0();
            this.f81239a.E0(b06);
            this.f81239a.H(b06 ? 8 : 0, 0);
        }
        a();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void g(e eVar, boolean z16, boolean z17) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder != null && z16 && z17) {
            wSFollowFeedHolder.H(8, 400);
        }
        x.j("WS_VIDEO_PRE_PLAY", "[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:" + eVar.f81127c.f81175j + "\nisPreOutputFirstFrame:" + z16 + ", isFirstFrameDrawSuccess:" + z17 + "\nmFollowPlayableHolder:" + this.f81239a);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void h(e eVar) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder != null) {
            wSFollowFeedHolder.E0(false);
            this.f81239a.H(0, 0);
            this.f81239a.D0(false);
        }
        a();
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public boolean k(e eVar) {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void o(e eVar) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f81239a;
        if (wSFollowFeedHolder != null) {
            wSFollowFeedHolder.H(0, 100);
        }
    }

    public void r(f fVar) {
        if (fVar instanceof WSFollowFeedHolder) {
            this.f81239a = (WSFollowFeedHolder) fVar;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void m(e eVar, long j3, long j16) {
        if (j3 > 2000) {
            a();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void j(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void n(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void p(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void q(e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void l(e eVar, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void i(e eVar, int i3, boolean z16) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void c(e eVar, int i3, int i16, String str) {
    }
}
