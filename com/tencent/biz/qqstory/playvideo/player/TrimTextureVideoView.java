package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import fd0.a;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrimTextureVideoView extends TextureVideoView implements MediaPlayer.OnSeekCompleteListener, a.f {

    /* renamed from: v0, reason: collision with root package name */
    public static int f94106v0;

    /* renamed from: e0, reason: collision with root package name */
    public int f94107e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f94108f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f94109g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f94110h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f94111i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f94112j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f94113k0;

    /* renamed from: l0, reason: collision with root package name */
    protected int f94114l0;

    /* renamed from: m0, reason: collision with root package name */
    protected int f94115m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f94116n0;

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f94117o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f94118p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f94119q0;

    /* renamed from: r0, reason: collision with root package name */
    protected Runnable f94120r0;

    /* renamed from: s0, reason: collision with root package name */
    protected Runnable f94121s0;

    /* renamed from: t0, reason: collision with root package name */
    private b f94122t0;

    /* renamed from: u0, reason: collision with root package name */
    private a.f f94123u0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements a.c {
        a() {
        }

        @Override // fd0.a.c
        public boolean d(fd0.a aVar, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.e(TrimTextureVideoView.this.f94090d, 2, "TrimTextureVideoView MediaPlayer onError==>what:" + i3 + "|extra:" + i16);
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public TrimTextureVideoView(Context context) {
        super(context);
        this.f94107e0 = 0;
        this.f94108f0 = 0;
        this.f94109g0 = 0;
        this.f94110h0 = 0;
        this.f94111i0 = 0;
        this.f94112j0 = 0;
        this.f94113k0 = 0;
        this.f94114l0 = 0;
        this.f94115m0 = 0;
        this.f94116n0 = false;
        this.f94117o0 = false;
        this.f94118p0 = true;
        this.f94119q0 = true;
        this.f94120r0 = new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.1
            @Override // java.lang.Runnable
            @TargetApi(14)
            public void run() {
                TrimTextureVideoView trimTextureVideoView;
                int i3;
                TrimTextureVideoView trimTextureVideoView2 = TrimTextureVideoView.this;
                if (!trimTextureVideoView2.f94117o0) {
                    c.b(trimTextureVideoView2.f94090d, "[%d]not attach! not schedule!", Integer.valueOf(trimTextureVideoView2.f94107e0));
                    return;
                }
                int currentPosition = trimTextureVideoView2.getCurrentPosition();
                TrimTextureVideoView trimTextureVideoView3 = TrimTextureVideoView.this;
                c.e(trimTextureVideoView3.f94090d, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(trimTextureVideoView3.f94107e0), Boolean.valueOf(TrimTextureVideoView.this.isPlaying()), Integer.valueOf(TrimTextureVideoView.this.f94110h0), Integer.valueOf(currentPosition));
                TrimTextureVideoView trimTextureVideoView4 = TrimTextureVideoView.this;
                if (trimTextureVideoView4.f94110h0 != 0) {
                    if (trimTextureVideoView4.isPlaying()) {
                        TrimTextureVideoView trimTextureVideoView5 = TrimTextureVideoView.this;
                        if (currentPosition == trimTextureVideoView5.f94114l0) {
                            trimTextureVideoView5.f94115m0++;
                        } else {
                            trimTextureVideoView5.f94115m0 = 0;
                        }
                        trimTextureVideoView5.f94114l0 = currentPosition;
                    } else {
                        TrimTextureVideoView trimTextureVideoView6 = TrimTextureVideoView.this;
                        if (currentPosition == trimTextureVideoView6.f94112j0) {
                            trimTextureVideoView6.f94113k0 = 0;
                        } else {
                            trimTextureVideoView6.f94113k0++;
                        }
                        trimTextureVideoView6.f94112j0 = currentPosition;
                    }
                }
                if (TrimTextureVideoView.this.isPlaying() && (i3 = (trimTextureVideoView = TrimTextureVideoView.this).f94110h0) > 0 && currentPosition >= i3) {
                    trimTextureVideoView.t(true);
                } else {
                    TrimTextureVideoView trimTextureVideoView7 = TrimTextureVideoView.this;
                    if (trimTextureVideoView7.f94094h == 5) {
                        trimTextureVideoView7.t(true);
                    }
                }
                c.a(TrimTextureVideoView.this.f94090d, "schedule next!");
                TrimTextureVideoView.this.postDelayed(this, 200L);
            }
        };
        this.f94121s0 = new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.2
            @Override // java.lang.Runnable
            @TargetApi(14)
            public void run() {
                int i3;
                TrimTextureVideoView trimTextureVideoView = TrimTextureVideoView.this;
                if (!trimTextureVideoView.f94117o0) {
                    c.b(trimTextureVideoView.f94090d, "[%d]not attach! not schedule!", Integer.valueOf(trimTextureVideoView.f94107e0));
                    return;
                }
                int currentPosition = trimTextureVideoView.getCurrentPosition();
                TrimTextureVideoView trimTextureVideoView2 = TrimTextureVideoView.this;
                c.f(trimTextureVideoView2.f94090d, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", Integer.valueOf(trimTextureVideoView2.f94107e0), Boolean.valueOf(TrimTextureVideoView.this.isPlaying()), Integer.valueOf(TrimTextureVideoView.this.f94110h0), Integer.valueOf(currentPosition), Integer.valueOf(TrimTextureVideoView.this.f94115m0), Integer.valueOf(TrimTextureVideoView.this.f94113k0));
                if (TrimTextureVideoView.this.isPlaying()) {
                    TrimTextureVideoView trimTextureVideoView3 = TrimTextureVideoView.this;
                    if (currentPosition == trimTextureVideoView3.f94114l0 && (i3 = trimTextureVideoView3.f94115m0) > 0) {
                        if (i3 > 1) {
                            c.i(trimTextureVideoView3.f94090d, "[%d]Position not change for %d times, restart! \u547d\u4e2d\u5f02\u5e38\u64ad\u653e\u5bb9\u9519\u903b\u8f91", Integer.valueOf(trimTextureVideoView3.f94107e0), Integer.valueOf(TrimTextureVideoView.this.f94115m0));
                            TrimTextureVideoView.this.t(true);
                            return;
                        } else {
                            trimTextureVideoView3.postDelayed(this, 250L);
                            return;
                        }
                    }
                }
                if (!TrimTextureVideoView.this.isPlaying()) {
                    TrimTextureVideoView trimTextureVideoView4 = TrimTextureVideoView.this;
                    if (currentPosition != trimTextureVideoView4.f94112j0) {
                        if (trimTextureVideoView4.f94113k0 > 1) {
                            c.i(trimTextureVideoView4.f94090d, "[%d]Position change for %d times, but is pause, restart! \u547d\u4e2d\u5f02\u5e38\u64ad\u653e\u5bb9\u9519\u903b\u8f91", Integer.valueOf(trimTextureVideoView4.f94107e0), Integer.valueOf(TrimTextureVideoView.this.f94113k0));
                            TrimTextureVideoView.this.t(true);
                            return;
                        } else {
                            trimTextureVideoView4.postDelayed(this, 250L);
                            return;
                        }
                    }
                }
                TrimTextureVideoView trimTextureVideoView5 = TrimTextureVideoView.this;
                c.l(trimTextureVideoView5.f94090d, "[%d] CheckNeedRestart good for now", Integer.valueOf(trimTextureVideoView5.f94107e0));
            }
        };
        q();
    }

    private void m() {
        if (DeviceInfoMonitor.getModel().toUpperCase().equals("PIXEL 2 XL")) {
            this.f94119q0 = false;
        }
    }

    private void q() {
        int i3 = f94106v0 + 1;
        f94106v0 = i3;
        this.f94107e0 = i3;
        setOnErrorListener(new a());
        m();
        super.setOnSeekCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.playvideo.player.TextureVideoView
    public fd0.a c() {
        if (this.f94119q0) {
            return new com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer();
        }
        return super.c();
    }

    @Override // fd0.a.f
    public void d(fd0.a aVar) {
        int currentPosition;
        this.f94118p0 = true;
        if (this.f94108f0 != 0 && this.f94110h0 != 0 && (currentPosition = super.getCurrentPosition()) < this.f94110h0) {
            c.c(this.f94090d, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.f94108f0), Integer.valueOf(currentPosition));
            this.f94109g0 = currentPosition;
        }
        a.f fVar = this.f94123u0;
        if (fVar != null) {
            fVar.d(aVar);
        }
        u();
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.TextureVideoView
    public void k() {
        c.b(this.f94090d, "[%d]stopPlayback()", Integer.valueOf(this.f94107e0));
        super.k();
    }

    public int n() {
        return this.f94110h0;
    }

    public int o() {
        return this.f94109g0;
    }

    @Override // android.view.TextureView, android.view.View
    @TargetApi(14)
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f94117o0 = true;
        c.b(this.f94090d, "[%d]onAttachedToWindow! schedule!", Integer.valueOf(this.f94107e0));
        post(this.f94120r0);
    }

    @Override // android.view.View
    @TargetApi(14)
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f94117o0 = false;
        c.b(this.f94090d, "[%d]onDetachedFromWindow! cancel schedule!", Integer.valueOf(this.f94107e0));
        removeCallbacks(this.f94120r0);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    @Deprecated
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        int currentPosition;
        if (this.f94108f0 != 0 && this.f94110h0 != 0 && (currentPosition = super.getCurrentPosition()) < this.f94110h0) {
            c.c(this.f94090d, "It need adjust start time,startTime=%s,currentPos=%s", Integer.valueOf(this.f94108f0), Integer.valueOf(currentPosition));
            this.f94109g0 = currentPosition;
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        c.e(this.f94090d, "onSizeChanged(%d, %d, %d, %d)", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.TextureVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        super.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
        r(this.f94116n0);
    }

    public int p() {
        return this.f94108f0;
    }

    public void r(boolean z16) {
        this.f94116n0 = z16;
        fd0.a aVar = this.C;
        if (aVar == null) {
            return;
        }
        if (z16) {
            aVar.setVolume(0.0f, 0.0f);
        } else {
            aVar.setVolume(1.0f, 1.0f);
        }
    }

    @TargetApi(14)
    public void s() {
        c.b(this.f94090d, "[%d]pausePlay()", Integer.valueOf(this.f94107e0));
        this.f94111i0 = super.getCurrentPosition();
        removeCallbacks(this.f94121s0);
        super.pause();
    }

    public void setOnRecyclePlayListener(b bVar) {
        this.f94122t0 = bVar;
    }

    @Override // com.tencent.biz.qqstory.playvideo.player.TextureVideoView
    public void setOnSeekCompleteListener(a.f fVar) {
        this.f94123u0 = fVar;
    }

    public void setPlayRange(int i3, int i16) {
        int i17;
        int duration = getDuration();
        int max = Math.max(i16 - i3, 1000);
        if (i16 > duration) {
            i3 = duration - max;
            i16 = duration;
        }
        c.d(this.f94090d, "[%d]setPlayRange(%d, %d)", Integer.valueOf(this.f94107e0), Integer.valueOf(i3), Integer.valueOf(i16));
        if (isPlaying() && (i3 != (i17 = this.f94108f0) || i16 != this.f94110h0)) {
            super.seekTo(i17);
            this.f94118p0 = false;
        }
        this.f94108f0 = i3;
        this.f94109g0 = i3;
        this.f94110h0 = i16;
    }

    public void t(boolean z16) {
        c.c(this.f94090d, "[%d]resumePlay(%b)", Integer.valueOf(this.f94107e0), Boolean.valueOf(z16));
        if (z16 || !super.isPlaying()) {
            int i3 = this.f94108f0;
            this.f94111i0 = i3;
            super.seekTo(i3);
            this.f94118p0 = false;
            b bVar = this.f94122t0;
            if (bVar != null) {
                bVar.a();
            }
        }
        super.start();
    }

    @TargetApi(14)
    public void u() {
        if (this.f94110h0 != 0) {
            removeCallbacks(this.f94121s0);
            postDelayed(this.f94121s0, this.f94110h0 - this.f94108f0);
        }
    }

    public TrimTextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94107e0 = 0;
        this.f94108f0 = 0;
        this.f94109g0 = 0;
        this.f94110h0 = 0;
        this.f94111i0 = 0;
        this.f94112j0 = 0;
        this.f94113k0 = 0;
        this.f94114l0 = 0;
        this.f94115m0 = 0;
        this.f94116n0 = false;
        this.f94117o0 = false;
        this.f94118p0 = true;
        this.f94119q0 = true;
        this.f94120r0 = new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.1
            @Override // java.lang.Runnable
            @TargetApi(14)
            public void run() {
                TrimTextureVideoView trimTextureVideoView;
                int i3;
                TrimTextureVideoView trimTextureVideoView2 = TrimTextureVideoView.this;
                if (!trimTextureVideoView2.f94117o0) {
                    c.b(trimTextureVideoView2.f94090d, "[%d]not attach! not schedule!", Integer.valueOf(trimTextureVideoView2.f94107e0));
                    return;
                }
                int currentPosition = trimTextureVideoView2.getCurrentPosition();
                TrimTextureVideoView trimTextureVideoView3 = TrimTextureVideoView.this;
                c.e(trimTextureVideoView3.f94090d, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(trimTextureVideoView3.f94107e0), Boolean.valueOf(TrimTextureVideoView.this.isPlaying()), Integer.valueOf(TrimTextureVideoView.this.f94110h0), Integer.valueOf(currentPosition));
                TrimTextureVideoView trimTextureVideoView4 = TrimTextureVideoView.this;
                if (trimTextureVideoView4.f94110h0 != 0) {
                    if (trimTextureVideoView4.isPlaying()) {
                        TrimTextureVideoView trimTextureVideoView5 = TrimTextureVideoView.this;
                        if (currentPosition == trimTextureVideoView5.f94114l0) {
                            trimTextureVideoView5.f94115m0++;
                        } else {
                            trimTextureVideoView5.f94115m0 = 0;
                        }
                        trimTextureVideoView5.f94114l0 = currentPosition;
                    } else {
                        TrimTextureVideoView trimTextureVideoView6 = TrimTextureVideoView.this;
                        if (currentPosition == trimTextureVideoView6.f94112j0) {
                            trimTextureVideoView6.f94113k0 = 0;
                        } else {
                            trimTextureVideoView6.f94113k0++;
                        }
                        trimTextureVideoView6.f94112j0 = currentPosition;
                    }
                }
                if (TrimTextureVideoView.this.isPlaying() && (i3 = (trimTextureVideoView = TrimTextureVideoView.this).f94110h0) > 0 && currentPosition >= i3) {
                    trimTextureVideoView.t(true);
                } else {
                    TrimTextureVideoView trimTextureVideoView7 = TrimTextureVideoView.this;
                    if (trimTextureVideoView7.f94094h == 5) {
                        trimTextureVideoView7.t(true);
                    }
                }
                c.a(TrimTextureVideoView.this.f94090d, "schedule next!");
                TrimTextureVideoView.this.postDelayed(this, 200L);
            }
        };
        this.f94121s0 = new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.2
            @Override // java.lang.Runnable
            @TargetApi(14)
            public void run() {
                int i3;
                TrimTextureVideoView trimTextureVideoView = TrimTextureVideoView.this;
                if (!trimTextureVideoView.f94117o0) {
                    c.b(trimTextureVideoView.f94090d, "[%d]not attach! not schedule!", Integer.valueOf(trimTextureVideoView.f94107e0));
                    return;
                }
                int currentPosition = trimTextureVideoView.getCurrentPosition();
                TrimTextureVideoView trimTextureVideoView2 = TrimTextureVideoView.this;
                c.f(trimTextureVideoView2.f94090d, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", Integer.valueOf(trimTextureVideoView2.f94107e0), Boolean.valueOf(TrimTextureVideoView.this.isPlaying()), Integer.valueOf(TrimTextureVideoView.this.f94110h0), Integer.valueOf(currentPosition), Integer.valueOf(TrimTextureVideoView.this.f94115m0), Integer.valueOf(TrimTextureVideoView.this.f94113k0));
                if (TrimTextureVideoView.this.isPlaying()) {
                    TrimTextureVideoView trimTextureVideoView3 = TrimTextureVideoView.this;
                    if (currentPosition == trimTextureVideoView3.f94114l0 && (i3 = trimTextureVideoView3.f94115m0) > 0) {
                        if (i3 > 1) {
                            c.i(trimTextureVideoView3.f94090d, "[%d]Position not change for %d times, restart! \u547d\u4e2d\u5f02\u5e38\u64ad\u653e\u5bb9\u9519\u903b\u8f91", Integer.valueOf(trimTextureVideoView3.f94107e0), Integer.valueOf(TrimTextureVideoView.this.f94115m0));
                            TrimTextureVideoView.this.t(true);
                            return;
                        } else {
                            trimTextureVideoView3.postDelayed(this, 250L);
                            return;
                        }
                    }
                }
                if (!TrimTextureVideoView.this.isPlaying()) {
                    TrimTextureVideoView trimTextureVideoView4 = TrimTextureVideoView.this;
                    if (currentPosition != trimTextureVideoView4.f94112j0) {
                        if (trimTextureVideoView4.f94113k0 > 1) {
                            c.i(trimTextureVideoView4.f94090d, "[%d]Position change for %d times, but is pause, restart! \u547d\u4e2d\u5f02\u5e38\u64ad\u653e\u5bb9\u9519\u903b\u8f91", Integer.valueOf(trimTextureVideoView4.f94107e0), Integer.valueOf(TrimTextureVideoView.this.f94113k0));
                            TrimTextureVideoView.this.t(true);
                            return;
                        } else {
                            trimTextureVideoView4.postDelayed(this, 250L);
                            return;
                        }
                    }
                }
                TrimTextureVideoView trimTextureVideoView5 = TrimTextureVideoView.this;
                c.l(trimTextureVideoView5.f94090d, "[%d] CheckNeedRestart good for now", Integer.valueOf(trimTextureVideoView5.f94107e0));
            }
        };
        q();
    }

    public TrimTextureVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94107e0 = 0;
        this.f94108f0 = 0;
        this.f94109g0 = 0;
        this.f94110h0 = 0;
        this.f94111i0 = 0;
        this.f94112j0 = 0;
        this.f94113k0 = 0;
        this.f94114l0 = 0;
        this.f94115m0 = 0;
        this.f94116n0 = false;
        this.f94117o0 = false;
        this.f94118p0 = true;
        this.f94119q0 = true;
        this.f94120r0 = new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.1
            @Override // java.lang.Runnable
            @TargetApi(14)
            public void run() {
                TrimTextureVideoView trimTextureVideoView;
                int i36;
                TrimTextureVideoView trimTextureVideoView2 = TrimTextureVideoView.this;
                if (!trimTextureVideoView2.f94117o0) {
                    c.b(trimTextureVideoView2.f94090d, "[%d]not attach! not schedule!", Integer.valueOf(trimTextureVideoView2.f94107e0));
                    return;
                }
                int currentPosition = trimTextureVideoView2.getCurrentPosition();
                TrimTextureVideoView trimTextureVideoView3 = TrimTextureVideoView.this;
                c.e(trimTextureVideoView3.f94090d, "[%d]mRestartRunnable check enter! isPlaying = %b, mEndTime = %d, pos = %d", Integer.valueOf(trimTextureVideoView3.f94107e0), Boolean.valueOf(TrimTextureVideoView.this.isPlaying()), Integer.valueOf(TrimTextureVideoView.this.f94110h0), Integer.valueOf(currentPosition));
                TrimTextureVideoView trimTextureVideoView4 = TrimTextureVideoView.this;
                if (trimTextureVideoView4.f94110h0 != 0) {
                    if (trimTextureVideoView4.isPlaying()) {
                        TrimTextureVideoView trimTextureVideoView5 = TrimTextureVideoView.this;
                        if (currentPosition == trimTextureVideoView5.f94114l0) {
                            trimTextureVideoView5.f94115m0++;
                        } else {
                            trimTextureVideoView5.f94115m0 = 0;
                        }
                        trimTextureVideoView5.f94114l0 = currentPosition;
                    } else {
                        TrimTextureVideoView trimTextureVideoView6 = TrimTextureVideoView.this;
                        if (currentPosition == trimTextureVideoView6.f94112j0) {
                            trimTextureVideoView6.f94113k0 = 0;
                        } else {
                            trimTextureVideoView6.f94113k0++;
                        }
                        trimTextureVideoView6.f94112j0 = currentPosition;
                    }
                }
                if (TrimTextureVideoView.this.isPlaying() && (i36 = (trimTextureVideoView = TrimTextureVideoView.this).f94110h0) > 0 && currentPosition >= i36) {
                    trimTextureVideoView.t(true);
                } else {
                    TrimTextureVideoView trimTextureVideoView7 = TrimTextureVideoView.this;
                    if (trimTextureVideoView7.f94094h == 5) {
                        trimTextureVideoView7.t(true);
                    }
                }
                c.a(TrimTextureVideoView.this.f94090d, "schedule next!");
                TrimTextureVideoView.this.postDelayed(this, 200L);
            }
        };
        this.f94121s0 = new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.2
            @Override // java.lang.Runnable
            @TargetApi(14)
            public void run() {
                int i36;
                TrimTextureVideoView trimTextureVideoView = TrimTextureVideoView.this;
                if (!trimTextureVideoView.f94117o0) {
                    c.b(trimTextureVideoView.f94090d, "[%d]not attach! not schedule!", Integer.valueOf(trimTextureVideoView.f94107e0));
                    return;
                }
                int currentPosition = trimTextureVideoView.getCurrentPosition();
                TrimTextureVideoView trimTextureVideoView2 = TrimTextureVideoView.this;
                c.f(trimTextureVideoView2.f94090d, "[%d]mCheckNeedRestart check enter! isPlaying = %b, mEndTime = %d, pos = %d, mPositionNotChangeCount = %d, mPausedPositionChangeCount = %d", Integer.valueOf(trimTextureVideoView2.f94107e0), Boolean.valueOf(TrimTextureVideoView.this.isPlaying()), Integer.valueOf(TrimTextureVideoView.this.f94110h0), Integer.valueOf(currentPosition), Integer.valueOf(TrimTextureVideoView.this.f94115m0), Integer.valueOf(TrimTextureVideoView.this.f94113k0));
                if (TrimTextureVideoView.this.isPlaying()) {
                    TrimTextureVideoView trimTextureVideoView3 = TrimTextureVideoView.this;
                    if (currentPosition == trimTextureVideoView3.f94114l0 && (i36 = trimTextureVideoView3.f94115m0) > 0) {
                        if (i36 > 1) {
                            c.i(trimTextureVideoView3.f94090d, "[%d]Position not change for %d times, restart! \u547d\u4e2d\u5f02\u5e38\u64ad\u653e\u5bb9\u9519\u903b\u8f91", Integer.valueOf(trimTextureVideoView3.f94107e0), Integer.valueOf(TrimTextureVideoView.this.f94115m0));
                            TrimTextureVideoView.this.t(true);
                            return;
                        } else {
                            trimTextureVideoView3.postDelayed(this, 250L);
                            return;
                        }
                    }
                }
                if (!TrimTextureVideoView.this.isPlaying()) {
                    TrimTextureVideoView trimTextureVideoView4 = TrimTextureVideoView.this;
                    if (currentPosition != trimTextureVideoView4.f94112j0) {
                        if (trimTextureVideoView4.f94113k0 > 1) {
                            c.i(trimTextureVideoView4.f94090d, "[%d]Position change for %d times, but is pause, restart! \u547d\u4e2d\u5f02\u5e38\u64ad\u653e\u5bb9\u9519\u903b\u8f91", Integer.valueOf(trimTextureVideoView4.f94107e0), Integer.valueOf(TrimTextureVideoView.this.f94113k0));
                            TrimTextureVideoView.this.t(true);
                            return;
                        } else {
                            trimTextureVideoView4.postDelayed(this, 250L);
                            return;
                        }
                    }
                }
                TrimTextureVideoView trimTextureVideoView5 = TrimTextureVideoView.this;
                c.l(trimTextureVideoView5.f94090d, "[%d] CheckNeedRestart good for now", Integer.valueOf(trimTextureVideoView5.f94107e0));
            }
        };
        q();
    }
}
