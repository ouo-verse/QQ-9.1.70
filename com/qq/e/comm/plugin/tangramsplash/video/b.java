package com.qq.e.comm.plugin.tangramsplash.video;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ITangramPlayer;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.tangramsplash.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.TangramAlphaVideoPlayInfo;
import com.qq.e.tg.splash.ITangramPlayerListener;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ITangramPlayer f40384a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<f> f40385b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40386c = true;

    /* renamed from: d, reason: collision with root package name */
    private final Object f40387d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f40388e = false;

    public b(Context context, WeakReference<f> weakReference) {
        r A;
        this.f40385b = weakReference;
        if (SDKStatus.getSDKVersionCode() < 70 || weakReference == null || weakReference.get() == null || (A = weakReference.get().A()) == null) {
            return;
        }
        if (SDKStatus.getSDKVersionCode() >= 390 && A.cc() && d.b()) {
            TangramAlphaVideoPlayInfo tangramAlphaVideoPlayInfo = new TangramAlphaVideoPlayInfo();
            tangramAlphaVideoPlayInfo.setPosId(A.s());
            tangramAlphaVideoPlayInfo.setAdInfo(y.a(A.v()) ? A.v().toString() : "");
            tangramAlphaVideoPlayInfo.setOutputMute(A.bM() == 0);
            tangramAlphaVideoPlayInfo.setFormatType(A.cb());
            this.f40384a = new d(context, tangramAlphaVideoPlayInfo);
            if (weakReference.get().e() != null) {
                ((d) this.f40384a).a(new a(weakReference.get().e()));
            }
        } else {
            this.f40384a = new c(context);
        }
        this.f40384a.setVideoPlayerListener(m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        WeakReference<f> weakReference = this.f40385b;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    private ITangramPlayerListener m() {
        return new ITangramPlayerListener() { // from class: com.qq.e.comm.plugin.tangramsplash.video.b.1
            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoComplete() {
                if (b.this.l()) {
                    r b16 = com.qq.e.comm.plugin.tangramsplash.a.a().b();
                    if (com.qq.e.comm.plugin.tangramsplash.a.a().G(b16)) {
                        if (b16 != null && b16.bJ() != null) {
                            int h16 = b16.bJ().h();
                            if (h16 == 2 || h16 == 4) {
                                ((f) b.this.f40385b.get()).f(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ((f) b.this.f40385b.get()).f(13);
                    ((f) b.this.f40385b.get()).g();
                }
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoError() {
                if (b.this.l()) {
                    ((f) b.this.f40385b.get()).g(3);
                    ((f) b.this.f40385b.get()).g();
                }
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoRender() {
                GDTLogger.i("onVideoRender :");
                if (!b.this.f40388e) {
                    b.this.f40388e = true;
                    b.this.n();
                }
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoStart() {
                f fVar;
                GDTLogger.i("onVideoStart :" + b.this.f40388e);
                if (b.this.f40385b != null) {
                    fVar = (f) b.this.f40385b.get();
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    fVar.g(0);
                }
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoStop() {
                if (b.this.l()) {
                    if (com.qq.e.comm.plugin.tangramsplash.a.a().G(com.qq.e.comm.plugin.tangramsplash.a.a().b()) && com.qq.e.comm.plugin.tangramsplash.a.a().b() != null && com.qq.e.comm.plugin.tangramsplash.a.a().b().bJ() != null && com.qq.e.comm.plugin.tangramsplash.a.a().b().bJ().h() != 1) {
                        ((f) b.this.f40385b.get()).f(true);
                    } else {
                        ((f) b.this.f40385b.get()).g();
                    }
                }
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoReady() {
            }

            @Override // com.qq.e.tg.splash.ITangramPlayerListener
            public void onVideoResume() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (l()) {
            o();
        }
    }

    private void o() {
        this.f40385b.get().a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.b.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this.f40387d) {
                    if (!b.this.l()) {
                        return;
                    }
                    ((f) b.this.f40385b.get()).setVisibility(0);
                    ((f) b.this.f40385b.get()).k();
                    ((f) b.this.f40385b.get()).l();
                    ((f) b.this.f40385b.get()).z();
                    ((f) b.this.f40385b.get()).d(false);
                    ((f) b.this.f40385b.get()).y();
                }
            }
        }, com.qq.e.comm.plugin.tangramsplash.d.f.c());
    }

    public boolean f() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            return iTangramPlayer.isPlaying();
        }
        return false;
    }

    public int g() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            return iTangramPlayer.getDuration();
        }
        return 0;
    }

    public int h() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            return iTangramPlayer.getCurrentPosition();
        }
        return 0;
    }

    public void i() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            iTangramPlayer.setVolumeOff();
        }
    }

    public void j() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            iTangramPlayer.free();
        }
    }

    public boolean k() {
        return this.f40388e;
    }

    public View b() {
        Object obj = this.f40384a;
        if (obj instanceof c) {
            return ((c) obj).a();
        }
        if (obj instanceof d) {
            return ((d) obj).a();
        }
        if (obj == null || !(obj instanceof View)) {
            return null;
        }
        return (View) obj;
    }

    public boolean c() {
        return b() != null;
    }

    public void d() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            iTangramPlayer.play();
        }
    }

    public void e() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            iTangramPlayer.pause();
        }
    }

    public void a(boolean z16) {
        this.f40386c = z16;
    }

    public boolean a() {
        ITangramPlayer iTangramPlayer = this.f40384a;
        return iTangramPlayer instanceof c ? (((c) iTangramPlayer).a() instanceof View) && this.f40386c : (iTangramPlayer instanceof View) && this.f40386c;
    }

    public void a(String str) {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer != null) {
            iTangramPlayer.setDataSource(str);
        }
    }

    public void b(boolean z16) {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer instanceof c) {
            TangramGdtVideoView a16 = ((c) iTangramPlayer).a();
            if (a16 instanceof View) {
                a16.b(z16 ? 2 : 3);
            }
        }
    }

    public void a(int i3) {
        ITangramPlayer iTangramPlayer = this.f40384a;
        if (iTangramPlayer instanceof d) {
            ((d) iTangramPlayer).b(i3);
        }
    }

    public b(ITangramPlayer iTangramPlayer, WeakReference<f> weakReference) {
        if (iTangramPlayer != null) {
            this.f40384a = iTangramPlayer;
            iTangramPlayer.setVideoPlayerListener(m());
        }
        this.f40385b = weakReference;
    }
}
