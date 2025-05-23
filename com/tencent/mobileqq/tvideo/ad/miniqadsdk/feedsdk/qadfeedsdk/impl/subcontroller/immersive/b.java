package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.f;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdFeedVideoInfo;
import com.tencent.tvideo.protocol.pb.AdImmersivePoster;
import com.tencent.tvideo.protocol.pb.AdPoster;
import java.util.Map;
import ww2.g;
import xw2.d;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends g<uw2.c> {
    protected AdFeedInfo C;
    private AdImmersivePoster D;
    private PlayerStatus E;

    /* renamed from: m, reason: collision with root package name */
    protected f f304148m;

    public b(uw2.c cVar) {
        super(cVar);
        this.E = PlayerStatus.PLAYER_STATUS_IDLE;
    }

    private d p() {
        String str;
        AdImmersivePoster adImmersivePoster = this.D;
        if (adImmersivePoster == null) {
            return null;
        }
        AdFeedVideoInfo adFeedVideoInfo = adImmersivePoster.video_info;
        String str2 = "";
        if (adFeedVideoInfo == null) {
            str = "";
        } else {
            str = adFeedVideoInfo.vid;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        dVar.f448917a = s();
        dVar.d(str);
        boolean z16 = true;
        dVar.b(true);
        AdPoster adPoster = this.D.poster;
        if (adPoster != null) {
            str2 = adPoster.image_url;
        }
        dVar.c(str2);
        Bundle bundle = dVar.f448927k;
        if (r() != 0) {
            z16 = false;
        }
        bundle.putBoolean("isLoopPlayBack", z16);
        return dVar;
    }

    private String s() {
        String str;
        AdImmersivePoster adImmersivePoster = this.D;
        if (adImmersivePoster == null) {
            return "";
        }
        AdFeedVideoInfo adFeedVideoInfo = adImmersivePoster.video_info;
        if (adFeedVideoInfo == null) {
            str = "";
        } else {
            str = adFeedVideoInfo.vid;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "AdFeed_vid=" + str + this.C.hashCode();
    }

    @Nullable
    private xw2.c t() {
        xw2.a aVar = this.f446622h;
        if (aVar == null) {
            return null;
        }
        return aVar.o();
    }

    @Nullable
    private Map<String, Object> u(sv2.a aVar, int i3) {
        if (aVar == null) {
            xw2.c t16 = t();
            if (t16 != null) {
                aVar = t16.f448916a;
            }
            if (aVar == null) {
                aVar = this.f446623i;
            }
        }
        if (aVar != null) {
            return aVar.e(i3);
        }
        return null;
    }

    @Override // ww2.g, ww2.b
    public void a(xw2.a aVar) {
        super.a(aVar);
        v();
    }

    @Override // ww2.g, xw2.b
    public void b(d dVar) {
        long j3;
        super.b(dVar);
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.K();
            this.f304148m.U(true);
            this.f304148m.z(r());
        }
        Map<String, Object> u16 = u(null, 4);
        sv2.a aVar = this.f446623i;
        if (aVar != null) {
            j3 = Math.min(aVar.f434833b, aVar.f434834c);
        } else {
            j3 = 0;
        }
        q(u16, 4, j3, 0);
        this.E = PlayerStatus.PLAYER_STATUS_COMPLETE;
    }

    @Override // ww2.g, xw2.b
    public void e(d dVar, boolean z16, sv2.a aVar) {
        PlayerStatus playerStatus = this.E;
        PlayerStatus playerStatus2 = PlayerStatus.PLAYER_STATUS_PLAYING;
        if (playerStatus == playerStatus2) {
            return;
        }
        Controller controller = this.f446619d;
        if (controller != 0) {
            ((uw2.c) controller).l().h();
        }
        super.e(dVar, z16, aVar);
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.U(false);
            this.f304148m.r();
        }
        if (z16) {
            q(u(this.f446623i, 8), 8, 0L, 0);
        } else {
            q(u(aVar, 1), 1, 0L, 0);
        }
        this.E = playerStatus2;
    }

    @Override // ww2.g, xw2.b
    public void g(d dVar) {
        super.g(dVar);
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.p();
        }
        q(u(null, 2), 2, n(), 0);
        this.E = PlayerStatus.PLAYER_STATUS_PARSED;
    }

    @Override // xw2.b
    public void h(d dVar) {
        Controller controller = this.f446619d;
        if (controller != 0) {
            ((uw2.c) controller).l().g();
        }
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.q();
        }
        q(u(this.f446623i, 3), 3, n(), 0);
    }

    @Override // xw2.b
    public void i(d dVar) {
        this.E = PlayerStatus.PLAYER_STATUS_PARSED;
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.U(false);
        }
        q(u(null, 9), 9, n(), 0);
    }

    @Override // ww2.g, xw2.b
    public void j(d dVar, sv2.a aVar) {
        super.j(dVar, aVar);
        if (aVar == null) {
            return;
        }
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.L(aVar);
        }
        q(null, 6, aVar.f434835d, 0);
    }

    @Override // ww2.g, xw2.b
    public void l(int i3, String str) {
        super.l(i3, str);
        f fVar = this.f304148m;
        if (fVar != null) {
            fVar.U(false);
            this.f304148m.o();
        }
        q(u(null, 5), 5, n(), i3);
        this.E = PlayerStatus.PLAYER_STATUS_ERROR;
    }

    @Override // xw2.b
    public void m(d dVar) {
        this.E = PlayerStatus.PLAYER_STATUS_PREPARED;
    }

    protected void q(Map<String, Object> map, int i3, long j3, int i16) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.report.a.b(this.C, i3, j3, i16, 0, null, map);
    }

    public int r() {
        f fVar = this.f304148m;
        if (fVar != null) {
            return fVar.D();
        }
        return -1;
    }

    protected void v() {
        xw2.a aVar = this.f446622h;
        if (aVar == null) {
            return;
        }
        aVar.I(this);
        this.f446622h.u(this);
        this.f446622h.z(this.f446620e);
        this.f446622h.t(o());
    }

    public void w(f fVar) {
        this.f304148m = fVar;
    }

    public void x(AdFeedInfo adFeedInfo, AdImmersivePoster adImmersivePoster) {
        this.C = adFeedInfo;
        this.D = adImmersivePoster;
        this.f446621f = p();
        this.E = PlayerStatus.PLAYER_STATUS_IDLE;
    }
}
