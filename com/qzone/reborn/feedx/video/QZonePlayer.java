package com.qzone.reborn.feedx.video;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;

/* loaded from: classes37.dex */
public class QZonePlayer implements ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnCompletionListener {
    public static int L = 3;
    public static int M = 4;
    private boolean C;
    private boolean E;
    private boolean F;
    private boolean G;
    private b H;
    private c I;
    private SuperPlayerOption J;
    private boolean K;

    /* renamed from: e, reason: collision with root package name */
    private ISuperPlayer f55793e;

    /* renamed from: h, reason: collision with root package name */
    private ISPlayerVideoView f55795h;

    /* renamed from: i, reason: collision with root package name */
    private SuperPlayerVideoInfo f55796i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f55797m;

    /* renamed from: d, reason: collision with root package name */
    protected long f55792d = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55794f = true;
    private float D = 1.0f;

    private void A(Object obj) {
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.l(obj);
    }

    private void C(Object obj) {
        if (this.f55796i == null) {
            return;
        }
        this.H.o(obj);
    }

    private boolean F(int i3) {
        if (this.f55793e == null || this.f55796i == null || this.H == null) {
            return false;
        }
        I();
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        this.J = obtain;
        obtain.accurateSeekOnOpen = true;
        this.H.c(obtain, this.f55793e);
        this.f55793e.openMediaPlayer(RFWApplication.getApplication(), this.f55796i, i3, this.J);
        return true;
    }

    private void G() {
        J();
        b bVar = this.H;
        if (bVar != null) {
            bVar.n();
        }
    }

    private void I() {
        this.f55793e.reset();
        this.f55793e.setLoopback(this.f55797m);
        this.f55793e.updatePlayerVideoView(this.f55795h);
        this.f55793e.setOutputMute(this.C);
        this.f55793e.setPlaySpeedRatio(this.D);
    }

    private void J() {
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            T();
        }
        this.f55792d = 0L;
        this.E = false;
        this.F = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i3) {
        f();
        nh.b.c(this.I, this);
        U(i3);
    }

    private boolean V() {
        boolean q75 = uq3.c.q7();
        RFWLog.d(j(), RFWLog.USR, "useSurfaceView:" + q75);
        return q75;
    }

    private void e() {
        b bVar = this.H;
        if (bVar != null) {
            bVar.e();
        }
    }

    private void f() {
        this.H = new b(this);
        if (!TextUtils.isEmpty(this.I.d()) && TextUtils.isEmpty(this.I.e())) {
            this.f55796i = nh.c.a(this.I.d(), "", k());
        } else {
            this.f55796i = nh.c.a(this.I.a(), this.I.e(), k());
        }
        this.f55795h = SuperPlayerFactory.createPlayerVideoView(RFWApplication.getApplication(), !V());
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(RFWApplication.getApplication(), 102, this.f55795h);
        this.f55793e = createMediaPlayer;
        createMediaPlayer.setOnVideoPreparedListener(this);
        this.f55793e.setOnErrorListener(this);
        this.f55793e.setOnInfoListener(this);
        this.f55793e.setOnCompletionListener(this);
        this.f55793e.setOnSeekCompleteListener(this);
        this.f55793e.setOnInfoListener(this);
    }

    private void n() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            RFWLog.i(j(), RFWLog.USR, "sdk init success try openMedia");
            L(this.I.g());
            return;
        }
        try {
            RFWLog.i(j(), RFWLog.USR, "sdk init is not ready");
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.context, new SDKInitListener() { // from class: com.qzone.reborn.feedx.video.QZonePlayer.1
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public void onSDKInited(boolean z16) {
                    if (!z16) {
                        RFWLog.e(QZonePlayer.this.j(), RFWLog.USR, "onSDKInited failed");
                    } else {
                        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.QZonePlayer.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZonePlayer.this.L(0);
                            }
                        });
                    }
                }
            });
        } catch (RuntimeException e16) {
            RFWLog.e(j(), RFWLog.USR, e16.getMessage());
            e16.printStackTrace();
        }
    }

    private void u(Object obj) {
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.g(obj);
    }

    private void v() {
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.h();
        nh.b.i(this.I);
    }

    private void x() {
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.i();
    }

    private void y() {
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.j();
    }

    private void z() {
        b bVar = this.H;
        if (bVar != null) {
            bVar.k();
        }
        nh.b.h(this.I);
    }

    public void B() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.QZonePlayer.3
            @Override // java.lang.Runnable
            public void run() {
                nh.b.b(QZonePlayer.this.I, QZonePlayer.this);
            }
        });
        this.E = true;
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.m();
    }

    public void D() {
        if (this.f55793e == null) {
            RFWLog.w(j(), RFWLog.USR, "[onStartTrackingTouch] null mPlayer");
        } else {
            RFWLog.d(j(), RFWLog.USR, "[startTracking]");
        }
    }

    public void E(int i3, int i16) {
        if (this.f55793e == null) {
            RFWLog.w(j(), RFWLog.USR, "[onStopTrackingTouch] null mPlayer");
            return;
        }
        b bVar = this.H;
        if (bVar != null) {
            bVar.t(i3, i16);
        }
        M((int) ((i3 / (i16 * 1.0f)) * ((float) this.f55793e.getDurationMs())));
    }

    public void H(final int i3) {
        b bVar = this.H;
        if (bVar != null) {
            bVar.p();
        }
        RFWThreadManager.getInstance().getVideoHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.video.QZonePlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZonePlayer.this.f55793e != null) {
                    RFWLog.d(QZonePlayer.this.j(), RFWLog.USR, "[release]:" + i3);
                    QZonePlayer.this.f55793e.stop();
                    QZonePlayer.this.f55793e.release();
                }
            }
        });
    }

    public void K() {
        if (TextUtils.isEmpty(this.I.e())) {
            RFWLog.e(j(), RFWLog.USR, "retryUpdateVideoInfo  realPlayUrl == null");
        } else {
            this.f55796i = SuperPlayerFactory.createVideoInfoForUrl(this.I.e(), 101, (String) null);
            RFWLog.i(j(), RFWLog.USR, "retryUpdateVideoInfo");
        }
    }

    public void M(long j3) {
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer == null) {
            RFWLog.w(j(), RFWLog.USR, "[seek] null mPlayer");
            return;
        }
        try {
            long durationMs = iSuperPlayer.getDurationMs();
            long j16 = 0;
            if (j3 > durationMs && durationMs != 0) {
                RFWLog.d(j(), RFWLog.USR, "seek over position=" + j3 + "duration=" + durationMs);
                j3 = durationMs;
            }
            if (j3 < 0) {
                RFWLog.d(j(), RFWLog.USR, "seek invalid position=" + j3 + "duration=" + this.f55793e.getDurationMs());
            } else {
                j16 = j3;
            }
            this.f55793e.seekTo((int) j16, 3);
            RFWLog.d(j(), RFWLog.USR, "seek position=" + j16 + "duration=" + this.f55793e.getDurationMs());
        } catch (Exception e16) {
            RFWLog.e(j(), RFWLog.USR, "[seek]", e16);
        }
    }

    public void N(boolean z16) {
        this.f55794f = z16;
    }

    public void O(boolean z16) {
        this.f55797m = z16;
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16);
        }
    }

    public void P(boolean z16, int i3, int i16) {
        this.f55797m = z16;
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setLoopback(z16, i3, i16);
        }
    }

    public void Q(boolean z16) {
        this.C = z16;
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    public void R(float f16) {
        this.D = f16;
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer != null) {
            iSuperPlayer.setPlaySpeedRatio(f16);
        }
    }

    public void S() {
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer == null) {
            RFWLog.w(j(), RFWLog.USR, "[start] null mPlayer");
            return;
        }
        if (iSuperPlayer.isPlaying()) {
            RFWLog.w(j(), RFWLog.USR, "[start] mPlayer is playing");
            return;
        }
        b bVar = this.H;
        if (bVar != null) {
            bVar.r();
        }
        this.f55793e.setPlayerActive();
        this.f55793e.start();
    }

    public void T() {
        b bVar = this.H;
        if (bVar != null) {
            bVar.s();
        }
        if (this.f55793e != null) {
            RFWLog.d(j(), RFWLog.USR, "[stop]");
            this.f55793e.stop();
        }
    }

    public void U(int i3) {
        if (this.f55796i == null) {
            RFWLog.e(j(), RFWLog.USR, "playFailed video info null");
            nh.b.k(this.I, 0, Integer.parseInt("19000001"), Integer.parseInt("19000001"), "");
            return;
        }
        RFWLog.d(j(), RFWLog.USR, "[tryToOpenMediaPlayer], fileId = " + this.f55796i.getFileId() + ", url = " + this.f55796i.getPlayUrl());
        G();
        if (F(i3)) {
            this.H.b(this.J, this.f55793e);
        }
    }

    public void d(kh.c cVar) {
        b bVar = this.H;
        if (bVar == null) {
            RFWLog.e(j(), RFWLog.USR, "addPlayerInterceptor, mController == null");
        } else {
            bVar.a(cVar);
        }
    }

    public long g() {
        return 0L;
    }

    public c h() {
        return this.I;
    }

    public ISuperPlayer i() {
        return this.f55793e;
    }

    public String j() {
        if (this.I != null) {
            return "QZonePlayer_" + this.I.s();
        }
        return "QZonePlayer_" + hashCode();
    }

    public int k() {
        return (int) this.I.h();
    }

    public long l() {
        return 0L;
    }

    public View m() {
        return (View) this.f55795h;
    }

    public boolean o() {
        return this.K;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        if (this.H == null) {
            return;
        }
        nh.b.a(this.I, iSuperPlayer);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        t(i3, obj);
        if (i3 == 105) {
            B();
            return false;
        }
        if (i3 == 201) {
            e();
            return false;
        }
        if (i3 == 204) {
            u(obj);
            return false;
        }
        if (i3 == 207) {
            A(obj);
            return false;
        }
        if (i3 == 250) {
            C(obj);
            return false;
        }
        if (i3 == 253) {
            w();
            return false;
        }
        if (i3 == 107) {
            v();
            return false;
        }
        if (i3 == 108) {
            z();
            return false;
        }
        if (i3 == 112) {
            y();
            return false;
        }
        if (i3 != 113) {
            return false;
        }
        x();
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        b bVar = this.H;
        if (bVar != null) {
            bVar.q(iSuperPlayer);
        }
    }

    public boolean p() {
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer == null) {
            return false;
        }
        return iSuperPlayer.isOutputMute();
    }

    public boolean q() {
        ISuperPlayer iSuperPlayer = this.f55793e;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    public boolean r() {
        return this.f55793e != null;
    }

    public void s(c cVar) {
        this.I = cVar;
        n();
    }

    private void w() {
        this.G = true;
        RFWLog.d(j(), RFWLog.USR, "player has deInit");
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        this.F = true;
        ISPlayerVideoView iSPlayerVideoView = this.f55795h;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.setXYaxis(0);
        }
        b bVar = this.H;
        if (bVar == null) {
            return;
        }
        bVar.u();
        nh.b.l(this.I, this);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        String j3 = j();
        int i18 = RFWLog.USR;
        RFWLog.e(j3, i18, "onError, msg =" + ("module:" + i3 + ", errorType:" + i16 + ", errorCode:" + i17 + ", extraInfo:" + str));
        if (this.H == null) {
            return false;
        }
        nh.b.j(this.I, i17, i3, 0L, 0L, 0L);
        nh.b.k(this.I, i3, i16, i17, str);
        this.H.f(iSuperPlayer, i3, i16, i17, str);
        return false;
    }

    private void t(int i3, Object obj) {
    }
}
