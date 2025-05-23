package com.tencent.now.app.music.model.player;

import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompanyListener;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.RTCMusicAccompanyParam;
import com.tencent.mobileqq.qqlive.sail.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements b {

    /* renamed from: j, reason: collision with root package name */
    private static b f338038j;

    /* renamed from: d, reason: collision with root package name */
    private boolean f338042d;

    /* renamed from: e, reason: collision with root package name */
    private IRTCMusicAccompany f338043e;

    /* renamed from: f, reason: collision with root package name */
    private RTCMusicAccompanyParam.Builder f338044f;

    /* renamed from: a, reason: collision with root package name */
    private rz0.a f338039a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f338040b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f338041c = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f338045g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f338046h = 1;

    /* renamed from: i, reason: collision with root package name */
    private final IRTCMusicAccompanyListener f338047i = new C9241a();

    /* compiled from: P */
    /* renamed from: com.tencent.now.app.music.model.player.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class C9241a implements IRTCMusicAccompanyListener {
        C9241a() {
        }

        @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompanyListener
        public void onComplete() {
            LogUtil.i("RtcMusicImpl", "onComplete...", new Object[0]);
            if (a.this.f338039a != null) {
                a.this.f338039a.a(0);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompanyListener
        public void onError(int i3) {
            LogUtil.i("RtcMusicImpl", "onError... code:" + i3, new Object[0]);
            if (a.this.f338039a != null) {
                a.this.f338039a.a(-1);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompanyListener
        public void onProgressUpdate(long j3) {
            a.this.f338041c = j3;
        }

        @Override // com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompanyListener
        public void onStart() {
            long durationMs;
            if (a.this.f338043e == null) {
                durationMs = 0;
            } else {
                durationMs = a.this.f338043e.getDurationMs();
            }
            LogUtil.i("RtcMusicImpl", "onStart durationMs:" + durationMs + " position:" + a.this.f338041c, new Object[0]);
            a.this.f338042d = true;
            a.this.f338040b = durationMs;
        }
    }

    a() {
    }

    public static b o() {
        b bVar = f338038j;
        if (bVar != null) {
            return bVar;
        }
        synchronized (a.class) {
            if (f338038j == null) {
                f338038j = new a();
            }
        }
        return f338038j;
    }

    private int p(float f16) {
        float f17;
        if (f16 <= 1.0f) {
            f17 = f16 * 100.0f;
        } else {
            f17 = (((f16 - 1.0f) / 29.0f) * 50.0f) + 100.0f;
        }
        return (int) f17;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void a(boolean z16) {
        LogUtil.i("RtcMusicImpl", "setKMusicMode... mode:" + z16, new Object[0]);
        this.f338045g = z16;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public boolean b(String str, String str2) {
        LogUtil.i("RtcMusicImpl", "open... musicFile:" + str + " dubFile:" + str2, new Object[0]);
        RTCMusicAccompanyParam.Builder builder = new RTCMusicAccompanyParam.Builder();
        this.f338044f = builder;
        builder.originFilePath(str);
        this.f338044f.dubFilePath(str2);
        return true;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void c(rz0.a aVar) {
        LogUtil.i("RtcMusicImpl", "setNotify... notify:" + aVar, new Object[0]);
        this.f338039a = aVar;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void d(float f16) {
        int p16 = p(f16);
        LogUtil.i("RtcMusicImpl", "setMusciDubVolume... value:" + f16 + " vol:" + p16, new Object[0]);
        IRTCMusicAccompany iRTCMusicAccompany = this.f338043e;
        if (iRTCMusicAccompany != null) {
            iRTCMusicAccompany.setLocalVolume(p16);
            this.f338043e.setPublishVolume(p16);
        }
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void destroy() {
        LogUtil.i("RtcMusicImpl", "destroy...", new Object[0]);
        this.f338043e = null;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void e(int i3) {
        IRTCMusicAccompany iRTCMusicAccompany;
        boolean z16 = false;
        LogUtil.i("RtcMusicImpl", "enableLoop... flag:" + i3 + " isStart:" + this.f338042d, new Object[0]);
        if (this.f338042d && (iRTCMusicAccompany = this.f338043e) != null) {
            if (i3 == 1) {
                z16 = true;
            }
            iRTCMusicAccompany.setLoopback(z16);
        }
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void f(float f16) {
        int p16 = p(f16);
        LogUtil.i("RtcMusicImpl", "[setMicrophoneVolume] value:" + f16 + " vol:" + p16, new Object[0]);
        try {
            c cVar = c.f272176a;
            if (cVar.d().t()) {
                cVar.d().v(p16);
            } else {
                LogUtil.e("RtcMusicImpl", "[setMicrophoneVolume] no anchor room exists", new Object[0]);
            }
        } catch (Throwable th5) {
            LogUtil.e("RtcMusicImpl", "[setMicrophoneVolume] audio source set volume fail! ", th5);
        }
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void g(int i3) {
        LogUtil.i("RtcMusicImpl", "enableMix... flag:" + i3, new Object[0]);
    }

    @Override // com.tencent.now.app.music.model.player.b
    public int getTimestamp() {
        LogUtil.i("RtcMusicImpl", "getTimestamp... position:" + this.f338041c, new Object[0]);
        return (int) this.f338041c;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void h(int i3) {
        LogUtil.i("RtcMusicImpl", "switchMode... flag:" + i3, new Object[0]);
        this.f338046h = i3;
        IRTCMusicAccompany iRTCMusicAccompany = this.f338043e;
        if (iRTCMusicAccompany != null) {
            iRTCMusicAccompany.switchAccompanyType(i3);
        }
    }

    @Override // com.tencent.now.app.music.model.player.b
    public boolean init() {
        LogUtil.i("RtcMusicImpl", "init...", new Object[0]);
        return true;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void pause() {
        LogUtil.i("RtcMusicImpl", "pause...", new Object[0]);
        IRTCMusicAccompany iRTCMusicAccompany = this.f338043e;
        if (iRTCMusicAccompany != null) {
            iRTCMusicAccompany.pause();
        }
    }

    @Override // com.tencent.now.app.music.model.player.b
    public boolean play() {
        LogUtil.i("RtcMusicImpl", "play...", new Object[0]);
        this.f338041c = 0L;
        if (this.f338044f == null) {
            return false;
        }
        this.f338043e = c.f272176a.d().a();
        LogUtil.i("RtcMusicImpl", "[play] accompany=" + this.f338043e, new Object[0]);
        IRTCMusicAccompany iRTCMusicAccompany = this.f338043e;
        if (iRTCMusicAccompany != null) {
            iRTCMusicAccompany.enableMixPublish(true);
            this.f338043e.setListener(this.f338047i);
            this.f338043e.start(this.f338044f.build());
        }
        return true;
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void replay() {
        LogUtil.i("RtcMusicImpl", "replay...", new Object[0]);
        IRTCMusicAccompany iRTCMusicAccompany = this.f338043e;
        if (iRTCMusicAccompany != null) {
            iRTCMusicAccompany.resume();
        }
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void setVolume(float f16) {
        LogUtil.i("RtcMusicImpl", "setVolume... value:" + f16, new Object[0]);
    }

    @Override // com.tencent.now.app.music.model.player.b
    public void stop(int i3) {
        this.f338042d = false;
        LogUtil.i("RtcMusicImpl", "stop... flag:" + i3, new Object[0]);
        IRTCMusicAccompany iRTCMusicAccompany = this.f338043e;
        if (iRTCMusicAccompany != null) {
            if (i3 == 1) {
                iRTCMusicAccompany.stop();
                this.f338043e.setListener(null);
            } else {
                iRTCMusicAccompany.setLoopback(false);
            }
        }
    }
}
