package com.tencent.timi.game.liveroom.impl.liveapi.manager.push;

import android.os.Handler;
import android.os.Looper;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import mm4.b;
import si4.c;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;

/* loaded from: classes26.dex */
public class TgLivePushHandler {

    /* renamed from: a, reason: collision with root package name */
    private kf4.a f377355a;

    /* renamed from: b, reason: collision with root package name */
    private int f377356b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f377358d;

    /* renamed from: e, reason: collision with root package name */
    private long f377359e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f377360f = false;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f377361g = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.liveapi.manager.push.TgLivePushHandler.1
        @Override // java.lang.Runnable
        public void run() {
            if (TgLivePushHandler.this.f377360f) {
                TgLivePushHandler.this.l();
            }
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private long f377357c = ((ll4.a) b.b(ll4.a.class)).E().uid.get();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a implements IResultListener<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kf4.a f377362a;

        a(kf4.a aVar) {
            this.f377362a = aVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp) {
            TgLivePushHandler.this.h(this.f377362a, premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            TgLivePushHandler.this.j("requestPushMsgFromNet onError = " + i3 + ", " + str);
            TgLivePushHandler.this.o();
        }
    }

    public TgLivePushHandler(kf4.a aVar, int i3) {
        this.f377355a = aVar;
        this.f377356b = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(kf4.a aVar, PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp) {
        c.s().x(aVar, premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
        if (premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp != null) {
            long j3 = premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp.refresh_interval.get() * 1000;
            if (j3 > 0 && this.f377359e != j3) {
                j("update refresh period time! cur = " + this.f377359e + ", new = " + j3);
                this.f377359e = j3;
            }
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        l.c("TgLiveTag_Manager_PushHandler", 1, str);
    }

    private void k(String str) {
        l.h("TgLiveTag_Manager_PushHandler", 1, str);
    }

    private void m() {
        this.f377360f = true;
        this.f377359e = 2000L;
        this.f377358d.removeCallbacks(this.f377361g);
        this.f377358d.post(this.f377361g);
    }

    private void n() {
        this.f377360f = false;
        this.f377359e = 0L;
        this.f377358d.removeCallbacks(this.f377361g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f377359e > 0) {
            this.f377358d.removeCallbacks(this.f377361g);
            this.f377358d.postDelayed(this.f377361g, this.f377359e);
        }
    }

    public void e() {
        j("destroyExit - " + this.f377355a + " - stopLoop");
        n();
        this.f377355a = null;
    }

    public void f() {
        k("enterRoomInit - " + this.f377355a + " - startLoop");
        this.f377358d = new Handler(Looper.getMainLooper());
        m();
    }

    public kf4.a g() {
        return this.f377355a;
    }

    public boolean i(kf4.a aVar) {
        kf4.a aVar2 = this.f377355a;
        if (aVar2 != null && aVar != null && aVar2.a().equals(aVar.a())) {
            return true;
        }
        return false;
    }

    public void l() {
        kf4.a aVar = this.f377355a;
        if (aVar != null && aVar.b()) {
            ti4.a.e(this.f377357c, this.f377356b, aVar, new a(aVar));
            return;
        }
        j("requestPushMsgFromNet, guildIdInfo invalid! = " + aVar);
        o();
    }
}
