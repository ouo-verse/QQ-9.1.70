package com.tencent.ams.xsad.rewarded.player;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer;
import com.tencent.ams.xsad.rewarded.utils.c;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DefaultRewardedAdPlayer implements RewardedAdPlayer, SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnVideoSizeChangedListener {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    private RewardedAdPlayer.b E;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private int f71834d;

    /* renamed from: e, reason: collision with root package name */
    private Context f71835e;

    /* renamed from: f, reason: collision with root package name */
    private MediaPlayer f71836f;

    /* renamed from: h, reason: collision with root package name */
    private RewardedAdPlayer.a f71837h;

    /* renamed from: i, reason: collision with root package name */
    private SurfaceView f71838i;

    /* renamed from: m, reason: collision with root package name */
    private int f71839m;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayerState {
        public static final int STATE_COMPLETED = 5;
        public static final int STATE_ERROR = -1;
        public static final int STATE_IDLE = 0;
        public static final int STATE_PAUSED = 4;
        public static final int STATE_PLAYING = 3;
        public static final int STATE_PREPARED = 2;
        public static final int STATE_PREPARING = 1;
        public static final int STATE_SURFACE_CREATED = 7;
        public static final int STATE_SURFACE_DESTROY = 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnSeekCompleteListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultRewardedAdPlayer.this);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
            } else if (DefaultRewardedAdPlayer.this.f71836f != null) {
                DefaultRewardedAdPlayer.this.f71836f.start();
            }
        }
    }

    public DefaultRewardedAdPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71834d = 0;
        }
    }

    private Configuration f() {
        Resources resources;
        Context context = this.f71835e;
        if (context != null && (resources = context.getResources()) != null) {
            return resources.getConfiguration();
        }
        return null;
    }

    private void g() {
        AudioManager audioManager;
        boolean z16;
        Context context = this.f71835e;
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
            return;
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        c.c("DefaultRewardedAdPlayer", "current volume: " + streamVolume);
        if (streamVolume <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        setOutputMute(z16);
    }

    private void h(Context context, ViewGroup viewGroup) {
        c.c("DefaultRewardedAdPlayer", "loadVideoAdUI");
        try {
            this.f71835e = context;
            SurfaceView surfaceView = new SurfaceView(context);
            this.f71838i = surfaceView;
            SurfaceHolder holder = surfaceView.getHolder();
            holder.addCallback(this);
            holder.setKeepScreenOn(true);
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.f71836f = reportMediaPlayer;
            reportMediaPlayer.setAudioStreamType(3);
            this.f71836f.setOnCompletionListener(this);
            this.f71836f.setOnErrorListener(this);
            this.f71836f.setOnVideoSizeChangedListener(this);
            this.f71836f.setOnPreparedListener(this);
            viewGroup.addView(this.f71838i, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e16) {
            c.e("DefaultRewardedAdPlayer", "initVideoView --> failed! exception = " + e16.getMessage());
        }
    }

    private void i(RewardedAdPlayer.b bVar) {
        this.E = bVar;
        g();
    }

    private boolean j() {
        int i3;
        if (this.f71836f != null && (i3 = this.f71834d) != -1 && i3 != 0 && i3 != 1 && i3 != 6 && i3 != 7) {
            return true;
        }
        return false;
    }

    private void k(String str) {
        c.c("DefaultRewardedAdPlayer", "openVideo: " + str);
        try {
            this.f71836f.reset();
            this.f71836f.setDataSource(this.f71835e, Uri.parse(str));
            this.f71836f.setVideoScalingMode(2);
            this.f71836f.setLooping(false);
            this.f71836f.prepareAsync();
            this.f71834d = 1;
        } catch (Exception e16) {
            c.b("DefaultRewardedAdPlayer", "play failed", e16);
            m(3);
        }
    }

    private void l() {
        RewardedAdPlayer.a aVar = this.f71837h;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void m(int i3) {
        RewardedAdPlayer.a aVar = this.f71837h;
        if (aVar != null) {
            aVar.l1(i3);
        }
    }

    private void n() {
        RewardedAdPlayer.a aVar = this.f71837h;
        if (aVar != null) {
            aVar.onPlayStart();
        }
    }

    private void o(Configuration configuration) {
        MediaPlayer mediaPlayer;
        float max;
        if (this.f71839m > 0 && this.C > 0 && (mediaPlayer = this.f71836f) != null) {
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = this.f71836f.getVideoHeight();
            if (configuration != null && configuration.orientation == 1) {
                max = Math.max(videoWidth / this.f71839m, videoHeight / this.C);
            } else {
                max = Math.max(videoWidth / this.C, videoHeight / this.f71839m);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) Math.ceil(videoWidth / max), (int) Math.ceil(videoHeight / max));
            layoutParams.gravity = 17;
            this.f71838i.setLayoutParams(layoutParams);
        }
    }

    private void p() {
        c.c("DefaultRewardedAdPlayer", "releaseVideoResource");
        MediaPlayer mediaPlayer = this.f71836f;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f71836f.release();
                this.f71836f.setOnPreparedListener(null);
                this.f71836f.setOnCompletionListener(null);
                this.f71836f.setOnErrorListener(null);
            } catch (Throwable th5) {
                c.b("DefaultRewardedAdPlayer", "releaseVideoResource, mediaplayer stop error.", th5);
            }
            this.f71836f = null;
        }
    }

    private void q(int i3) {
        c.c("DefaultRewardedAdPlayer", "start position: " + i3);
        try {
            if (i3 > 0) {
                this.f71836f.setOnSeekCompleteListener(new a());
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f71836f.seekTo(i3, 3);
                } else {
                    this.f71836f.seekTo(i3);
                }
            } else {
                this.f71836f.start();
            }
            n();
            this.f71834d = 3;
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.H = z16;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void b(Context context, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) viewGroup);
        } else {
            this.f71835e = context;
            h(context, viewGroup);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void c(RewardedAdPlayer.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "setVideoParams: " + bVar);
        i(bVar);
        MediaPlayer mediaPlayer = this.f71836f;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            if (!TextUtils.isEmpty(bVar.f71841a)) {
                if (this.D) {
                    k(bVar.f71841a);
                    return;
                }
                return;
            }
            m(2);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void d(RewardedAdPlayer.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f71837h = aVar;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public int getCurrentPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (j()) {
            return this.f71836f.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public int getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        if (j()) {
            return this.f71836f.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (j()) {
            return this.f71836f.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void onActivityPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) mediaPlayer);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "onCompletion");
        if (this.f71834d == 5) {
            return;
        }
        this.f71834d = 5;
        l();
        if (this.H) {
            start();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) configuration);
        } else {
            o(configuration);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        c.c("DefaultRewardedAdPlayer", String.format(Locale.getDefault(), "onError: what-%d, extra-%d", Integer.valueOf(i3), Integer.valueOf(i16)));
        if (this.f71834d == 5) {
            return true;
        }
        this.f71834d = -1;
        if (!g.e(this.f71835e)) {
            m(1);
        } else if (i3 == 1) {
            m(2);
        } else {
            m(3);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) mediaPlayer);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "onPrepared");
        this.f71834d = 2;
        MediaPlayer mediaPlayer2 = this.f71836f;
        if (mediaPlayer2 != null && !mediaPlayer2.isPlaying() && this.G) {
            c.c("DefaultRewardedAdPlayer", "onPrepared seekTo:" + this.F);
            q(this.F);
            n();
            this.f71834d = 3;
            this.F = 0;
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, mediaPlayer, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            o(f());
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "pause");
        if (j()) {
            this.f71836f.pause();
            this.f71834d = 4;
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void seekTo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
            return;
        }
        MediaPlayer mediaPlayer = this.f71836f;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.seekTo((int) j3);
            } catch (Throwable th5) {
                c.b("DefaultRewardedAdPlayer", "seekTo error.", th5);
            }
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void setAutoPlay(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        this.G = z16;
        if (z16) {
            start();
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void setOutputMute(boolean z16) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "setOutputMute: " + z16);
        MediaPlayer mediaPlayer = this.f71836f;
        if (mediaPlayer != null) {
            if (z16) {
                f16 = 0.0f;
            } else {
                f16 = 1.0f;
            }
            mediaPlayer.setVolume(f16, f16);
            c.a("DefaultRewardedAdPlayer", "setVolume: " + f16);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void start() {
        RewardedAdPlayer.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "start");
        if (j()) {
            if (this.D) {
                q(this.F);
                this.F = 0;
                return;
            }
            return;
        }
        int i3 = this.f71834d;
        if (i3 == 6) {
            this.f71834d = 0;
        } else if (i3 == 7 && (bVar = this.E) != null) {
            k(bVar.f71841a);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.player.RewardedAdPlayer
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            p();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            c.a("DefaultRewardedAdPlayer", "surfaceChanged");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) surfaceHolder);
            return;
        }
        c.c("DefaultRewardedAdPlayer", "surfaceCreated");
        if (this.f71838i != null) {
            Configuration f16 = f();
            if (f16 != null && f16.orientation == 1) {
                this.f71839m = this.f71838i.getWidth();
                this.C = this.f71838i.getHeight();
            } else {
                this.f71839m = this.f71838i.getHeight();
                this.C = this.f71838i.getWidth();
            }
        }
        MediaPlayer mediaPlayer = this.f71836f;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
        this.D = true;
        RewardedAdPlayer.b bVar = this.E;
        if (bVar != null && this.f71834d <= 2) {
            k(bVar.f71841a);
            c.c("DefaultRewardedAdPlayer", "surfaceCreated - openVideo mSavedPosition: " + this.F);
            return;
        }
        this.f71834d = 7;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) surfaceHolder);
            return;
        }
        c.a("DefaultRewardedAdPlayer", "surfaceDestroyed");
        this.D = false;
        MediaPlayer mediaPlayer = this.f71836f;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying() || this.f71834d == 4) {
                this.F = this.f71836f.getCurrentPosition();
                this.f71836f.stop();
                this.f71834d = 6;
                c.a("DefaultRewardedAdPlayer", "surfaceDestroyed - mSavedPosition: " + this.F);
            }
        }
    }
}
