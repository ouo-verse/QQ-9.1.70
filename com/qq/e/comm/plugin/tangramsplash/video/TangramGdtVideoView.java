package com.qq.e.comm.plugin.tangramsplash.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ITangramPlayer;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.n;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.splash.ITangramPlayerListener;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramGdtVideoView extends TextureView implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, ITangramPlayer {

    /* renamed from: a, reason: collision with root package name */
    private int f40343a;

    /* renamed from: b, reason: collision with root package name */
    private int f40344b;

    /* renamed from: c, reason: collision with root package name */
    private SurfaceTexture f40345c;

    /* renamed from: d, reason: collision with root package name */
    private volatile MediaPlayer f40346d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f40347e;

    /* renamed from: f, reason: collision with root package name */
    private AudioManager f40348f;

    /* renamed from: g, reason: collision with root package name */
    private AudioFocusRequest f40349g;

    /* renamed from: h, reason: collision with root package name */
    private int f40350h;

    /* renamed from: i, reason: collision with root package name */
    private int f40351i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f40352j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f40353k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f40354l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f40355m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f40356n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f40357o;

    /* renamed from: p, reason: collision with root package name */
    private int f40358p;

    /* renamed from: q, reason: collision with root package name */
    private ITangramPlayerListener f40359q;

    /* renamed from: r, reason: collision with root package name */
    private int f40360r;

    /* renamed from: s, reason: collision with root package name */
    private int f40361s;

    /* renamed from: t, reason: collision with root package name */
    private long f40362t;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f40363u;

    /* renamed from: v, reason: collision with root package name */
    private String f40364v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f40365w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f40366x;

    /* renamed from: y, reason: collision with root package name */
    private int f40367y;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScaleType {
    }

    public TangramGdtVideoView(Context context) {
        super(context, null, 0);
        this.f40345c = null;
        this.f40346d = null;
        this.f40347e = null;
        this.f40361s = 1;
        this.f40362t = 0L;
        this.f40365w = false;
        this.f40366x = false;
        this.f40367y = 0;
        b();
    }

    private void c() {
        if (this.f40346d != null) {
            GDTLogger.d("Player initPlayer mediaPlayer is not null, release it!");
            this.f40346d.release();
            this.f40346d = null;
        }
        this.f40346d = new ReportMediaPlayer();
        this.f40346d.setOnPreparedListener(this);
        this.f40346d.setOnCompletionListener(this);
        this.f40346d.setOnErrorListener(this);
        this.f40346d.setOnSeekCompleteListener(this);
        this.f40346d.setOnVideoSizeChangedListener(this);
        this.f40346d.setOnInfoListener(this);
        this.f40343a = 0;
        this.f40344b = 0;
        this.f40354l = false;
        this.f40355m = false;
        this.f40357o = false;
        this.f40358p = 0;
        this.f40356n = false;
        this.f40360r = 1;
    }

    private boolean d() {
        int i3;
        if (this.f40346d != null && (i3 = this.f40360r) != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    private void e() {
        try {
            if (this.f40346d != null) {
                this.f40346d.prepareAsync();
            }
        } catch (IllegalArgumentException e16) {
            GDTLogger.d(e16.getMessage());
        } catch (IllegalStateException e17) {
            GDTLogger.d(e17.getMessage());
        } catch (SecurityException e18) {
            GDTLogger.d(e18.getMessage());
        } catch (Throwable th5) {
            GDTLogger.d(th5.getMessage());
        }
    }

    private void f() {
        if (this.f40345c == null) {
            GDTLogger.d("SurfaceTexture is not available, can't open video.");
            return;
        }
        if (this.f40346d == null) {
            GDTLogger.d("MediaPlayer is null, can't open video.");
            return;
        }
        if (this.f40347e == null) {
            this.f40347e = new Surface(this.f40345c);
        }
        this.f40346d.setSurface(this.f40347e);
        this.f40353k = true;
        if (this.f40352j && this.f40355m && this.f40354l) {
            GDTLogger.d("SurfaceTexture is available and play() was called.");
            play();
        }
    }

    private void g() {
        boolean z16;
        MediaPlayer mediaPlayer = this.f40346d;
        if (mediaPlayer != null) {
            long currentTimeMillis = System.currentTimeMillis();
            mediaPlayer.reset();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reset call cost time :");
            sb5.append(System.currentTimeMillis() - currentTimeMillis);
            sb5.append(", is main thread :");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            GDTLogger.d(sb5.toString());
            mediaPlayer.release();
            this.f40346d = null;
            this.f40360r = 1;
            this.f40345c = null;
            this.f40348f = null;
            return;
        }
        GDTLogger.e("mediaPlayer has destroyed!");
    }

    private void h() {
        float f16;
        GDTLogger.d(hashCode() + " reInit");
        b();
        int i3 = this.f40367y;
        if (i3 > 0) {
            a(i3);
        }
        if (this.f40356n) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        this.f40346d.setVolume(f16, f16);
        if (this.f40364v != null) {
            try {
                this.f40346d.setDataSource(this.f40364v);
                this.f40352j = true;
                e();
                return;
            } catch (Exception e16) {
                GDTLogger.e(e16.getMessage());
                return;
            }
        }
        GDTLogger.e(hashCode() + " reInit failed, path is null");
    }

    private void i() {
        if (!this.f40356n && this.f40360r == 3 && this.f40348f != null) {
            GDTLogger.d("tryRequestAudioFocus");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f40348f.requestAudioFocus(this.f40349g);
                } else {
                    this.f40348f.requestAudioFocus(null, 3, 2);
                }
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    private void j() {
        if (this.f40348f != null) {
            GDTLogger.d("tryAbandonAudioFocus");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f40348f.abandonAudioFocusRequest(this.f40349g);
                } else {
                    this.f40348f.abandonAudioFocus(null);
                }
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void free() {
        GDTLogger.d(hashCode() + " free");
        g();
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public int getCurrentPosition() {
        try {
            if (d()) {
                if (this.f40360r == 6) {
                    return getDuration();
                }
                return this.f40346d.getCurrentPosition();
            }
            return 0;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public int getDuration() {
        if (d()) {
            try {
                return this.f40346d.getDuration();
            } catch (Throwable th5) {
                GDTLogger.e("TangramGdtVideoView getDuration", th5);
                return 0;
            }
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public boolean isPlaying() {
        try {
            if (!d()) {
                return false;
            }
            if (!this.f40346d.isPlaying()) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d(hashCode() + " attached");
        if (this.f40365w) {
            h();
            this.f40365w = false;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f40360r != 6) {
            this.f40360r = 6;
            GDTLogger.d("Player is complete.");
            j();
            c(2);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d(hashCode() + " detach");
        this.f40367y = getCurrentPosition();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(30112, i3);
        if (this.f40360r != 0) {
            this.f40360r = 0;
            GDTLogger.e("Player encountered error, what = " + i3 + ", extra = " + i16);
            j();
            c(1);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i16) {
        if (i3 == 3) {
            GDTLogger.d("onInfo = MEDIA_INFO_VIDEO_RENDERING_START");
            c(8);
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f9, code lost:
    
        if (r0 > r8) goto L50;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int i17;
        int c16;
        int defaultSize = View.getDefaultSize(this.f40343a, i3);
        int defaultSize2 = View.getDefaultSize(this.f40344b, i16);
        if (this.f40343a > 0 && this.f40344b > 0) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size2 = View.MeasureSpec.getSize(i16);
            int i18 = this.f40361s;
            if (i18 == 2 && (size != 0 || size2 != 0)) {
                int i19 = this.f40344b;
                int i26 = size * i19;
                int i27 = this.f40343a;
                if (i26 >= i27 * size2 && size != 0) {
                    if (size * i19 > i27 * size2 || size2 == 0) {
                        size2 = (i19 * size) / i27;
                    }
                } else {
                    size = (i27 * size2) / i19;
                }
                int b16 = ak.b(getContext());
                if (com.qq.e.comm.plugin.j.c.a("splashFixNotch", 1, 1)) {
                    c16 = n.b(getContext());
                } else {
                    c16 = ak.c(getContext());
                }
                if (size > c16) {
                    size = b16;
                }
                if (size2 > c16) {
                    size2 = c16;
                }
            } else if (i18 == 3) {
                float f16 = (defaultSize * 1.0f) / this.f40343a;
                float f17 = (defaultSize2 * 1.0f) / this.f40344b;
                float max = Math.max(f16, f17);
                Matrix matrix = new Matrix();
                matrix.setScale(max / f16, max / f17, defaultSize / 2, defaultSize2 / 2);
                GDTLogger.d("video center crop: scaleX = " + f16 + "; scaleY = " + f17);
                setTransform(matrix);
            } else if (mode == 1073741824 && mode2 == 1073741824) {
                int i28 = this.f40343a;
                int i29 = i28 * size2;
                int i36 = this.f40344b;
                if (i29 < size * i36) {
                    defaultSize = (i28 * size2) / i36;
                    defaultSize2 = size2;
                } else if (i28 * size2 > size * i36) {
                    int i37 = (i36 * size) / i28;
                    defaultSize = size;
                    defaultSize2 = i37;
                }
            } else {
                if (mode == 1073741824) {
                    int i38 = (this.f40344b * size) / this.f40343a;
                    if (mode2 != Integer.MIN_VALUE || i38 <= size2) {
                        defaultSize2 = i38;
                        defaultSize = size;
                    }
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.f40343a * size2) / this.f40344b;
                    if (mode == Integer.MIN_VALUE) {
                    }
                } else {
                    int i39 = this.f40343a;
                    int i46 = this.f40344b;
                    if (mode2 == Integer.MIN_VALUE && i46 > size2) {
                        i17 = (size2 * i39) / i46;
                    } else {
                        i17 = i39;
                        size2 = i46;
                    }
                    if (mode == Integer.MIN_VALUE && i17 > size) {
                        int i47 = (i46 * size) / i39;
                        defaultSize = size;
                        defaultSize2 = i47;
                    } else {
                        defaultSize2 = size2;
                        defaultSize = i17;
                    }
                }
                defaultSize2 = size2;
            }
            defaultSize = size;
            defaultSize2 = size2;
        } else if (SDKStatus.getSDKVersionCode() >= 13 && this.f40350h > 0 && this.f40351i > 0) {
            defaultSize = View.MeasureSpec.getSize(i3);
            defaultSize2 = View.MeasureSpec.getSize(i16);
            int i48 = this.f40351i;
            int i49 = defaultSize * i48;
            int i56 = this.f40350h;
            if (i49 >= i56 * defaultSize2 && defaultSize2 != 0) {
                if (defaultSize * i48 > i56 * defaultSize2 || defaultSize == 0) {
                    defaultSize = (i56 * defaultSize2) / i48;
                }
            } else {
                defaultSize2 = (i48 * defaultSize) / i56;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f40360r = 2;
        this.f40354l = true;
        GDTLogger.d("Player is prepared.");
        if (mediaPlayer == null) {
            GDTLogger.e("Player is null in onPrepared");
            return;
        }
        try {
            this.f40343a = mediaPlayer.getVideoWidth();
            this.f40344b = mediaPlayer.getVideoHeight();
        } catch (Throwable th5) {
            GDTLogger.e("Player onPrepare:", th5);
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(30114, 0);
        c(3);
        if (this.f40357o) {
            GDTLogger.d("Player is prepared and seekTo() was called.");
            a(this.f40358p);
        }
        GDTLogger.d("isViewAvailable :" + this.f40353k + " isSurfaceTextureAvailable :" + this.f40363u);
        if (this.f40355m && this.f40353k) {
            GDTLogger.d("Player is prepared and play() was called.");
            play();
        } else if (!this.f40353k && this.f40363u) {
            GDTLogger.d("SurfaceTextureAvailable but first open video failed try again.");
            f();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        int i3;
        try {
            i3 = mediaPlayer.getCurrentPosition();
        } catch (Throwable th5) {
            th5.printStackTrace();
            i3 = 0;
        }
        GDTLogger.d("onSeekComplete: " + i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        GDTLogger.d("onSurfaceTextureAvailable");
        SurfaceTexture surfaceTexture2 = this.f40345c;
        if (surfaceTexture2 == null) {
            this.f40345c = surfaceTexture;
        } else {
            setSurfaceTexture(surfaceTexture2);
        }
        this.f40363u = true;
        f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        GDTLogger.d("onSurfaceTextureDestroyed");
        this.f40355m = false;
        this.f40353k = false;
        if (this.f40345c != null) {
            return false;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f40345c = surfaceTexture;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
        if (mediaPlayer == null) {
            return;
        }
        try {
            this.f40343a = mediaPlayer.getVideoWidth();
            this.f40344b = mediaPlayer.getVideoHeight();
        } catch (Throwable th5) {
            GDTLogger.e("onVideoSizeChangedInternal error :", th5);
        }
        post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.TangramGdtVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (TangramGdtVideoView.this.f40343a != 0 && TangramGdtVideoView.this.f40344b != 0) {
                    TangramGdtVideoView.this.requestLayout();
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void pause() {
        int i3 = this.f40360r;
        if (i3 == 1) {
            GDTLogger.d("pause() was called but video is not initialized.");
            return;
        }
        if (i3 == 2) {
            GDTLogger.d("pause() was called but video is just prepared, not playing.");
            return;
        }
        if (i3 == 5) {
            GDTLogger.d("pause() was called but video already paused.");
            return;
        }
        if (i3 == 4) {
            GDTLogger.d("pause() was called but video already stopped.");
            return;
        }
        if (i3 == 6) {
            GDTLogger.d("pause() was called but video already ended.");
            return;
        }
        this.f40360r = 5;
        try {
            if (this.f40346d != null && this.f40346d.isPlaying()) {
                this.f40366x = true;
                this.f40346d.pause();
                GDTLogger.d("Player was pause in pause().");
            }
            j();
            c(6);
        } catch (Throwable th5) {
            GDTLogger.e("pause() error :", th5);
            this.f40366x = false;
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void play() {
        try {
            if (!this.f40352j) {
                GDTLogger.d("play() was called but video data source was not set.");
                return;
            }
            this.f40355m = true;
            if (!this.f40354l) {
                GDTLogger.d("play() was called but video is not prepared yet, waiting.");
                return;
            }
            if (!this.f40353k) {
                GDTLogger.d("play() was called but SurfaceTexture is not available yet, waiting.");
                return;
            }
            int i3 = this.f40360r;
            if (i3 == 3) {
                GDTLogger.d("play() was called but video is already playing.");
                return;
            }
            if (!this.f40366x && i3 != 5) {
                if (i3 != 6 && i3 != 4) {
                    if (this.f40347e != null) {
                        this.f40346d.setSurface(this.f40347e);
                    }
                    this.f40360r = 3;
                    i();
                    GDTLogger.d("Player was begin start.");
                    this.f40346d.start();
                    com.qq.e.comm.plugin.tangramsplash.report.c.a(30113, 0);
                    c(5);
                    return;
                }
                GDTLogger.d("play() was called but video already ended/stopped, starting over.");
                setDataSource(this.f40364v);
                this.f40355m = true;
                return;
            }
            GDTLogger.d("play() was called but video is paused, resuming.");
            this.f40360r = 3;
            this.f40366x = false;
            this.f40346d.start();
            i();
            c(4);
        } catch (Exception e16) {
            GDTLogger.e("play() is error " + e16.getMessage());
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setDataSource(String str) {
        c();
        a(str);
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVideoPlayerListener(ITangramPlayerListener iTangramPlayerListener) {
        this.f40359q = iTangramPlayerListener;
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolume(float f16) {
        if (this.f40346d != null && this.f40360r != 0) {
            this.f40346d.setVolume(f16, f16);
            i();
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolumeOff() {
        if (this.f40346d != null && this.f40360r != 0 && !this.f40356n) {
            try {
                GDTLogger.d("Set volume off.");
                this.f40346d.setVolume(0.0f, 0.0f);
                this.f40356n = true;
                j();
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void setVolumeOn() {
        if (this.f40346d != null && this.f40360r != 0 && this.f40356n) {
            try {
                GDTLogger.d("Set volume on.");
                this.f40346d.setVolume(1.0f, 1.0f);
                this.f40356n = false;
                i();
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    @Override // com.qq.e.comm.pi.ITangramPlayer
    public void stop() {
        a(false, false);
    }

    private void a(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f40346d.setDataSource(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setDataSource call cost time :");
            sb5.append(System.currentTimeMillis() - currentTimeMillis);
            sb5.append(", is main thread :");
            sb5.append(Looper.myLooper() == Looper.getMainLooper());
            GDTLogger.d(sb5.toString());
            this.f40352j = true;
            this.f40364v = str;
            e();
        } catch (Throwable th5) {
            GDTLogger.d(th5.getMessage());
            this.f40360r = 0;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(30112, 0);
            c(1);
        }
    }

    private void b() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest build;
        setSurfaceTextureListener(this);
        b(2);
        setId(5);
        this.f40348f = (AudioManager) getContext().getSystemService("audio");
        if (Build.VERSION.SDK_INT >= 26) {
            audioAttributes = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build());
            build = audioAttributes.build();
            this.f40349g = build;
        }
    }

    public void a(boolean z16, boolean z17) {
        int i3 = this.f40360r;
        if (i3 == 1) {
            GDTLogger.d("stop() was called but video is not initialized.");
            return;
        }
        if (i3 == 2) {
            GDTLogger.d("stop() was called but video is just prepared, not playing.");
            return;
        }
        if (i3 == 4) {
            GDTLogger.d("stop() was called but video already stopped.");
            return;
        }
        if (i3 == 6) {
            GDTLogger.d("stop() was called but video already ended.");
            return;
        }
        if (i3 == 0) {
            GDTLogger.d("stop() was called but video already encountered error.");
            return;
        }
        this.f40360r = 4;
        j();
        c(7);
        if (z16 || this.f40346d.isPlaying()) {
            this.f40346d.seekTo(z17 ? 0 : getDuration());
            this.f40346d.pause();
            GDTLogger.d("Player was pause in doStop().");
        }
        if (z16) {
            this.f40366x = false;
        }
    }

    public void b(int i3) {
        this.f40361s = i3;
    }

    private void c(final int i3) {
        final ITangramPlayerListener iTangramPlayerListener = this.f40359q;
        post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.video.TangramGdtVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                ITangramPlayerListener iTangramPlayerListener2 = iTangramPlayerListener;
                if (iTangramPlayerListener2 != null) {
                    switch (i3) {
                        case 1:
                            iTangramPlayerListener2.onVideoError();
                            return;
                        case 2:
                            iTangramPlayerListener2.onVideoComplete();
                            return;
                        case 3:
                            iTangramPlayerListener2.onVideoReady();
                            return;
                        case 4:
                            iTangramPlayerListener2.onVideoResume();
                            return;
                        case 5:
                            iTangramPlayerListener2.onVideoStart();
                            return;
                        case 6:
                            iTangramPlayerListener2.onVideoPause();
                            return;
                        case 7:
                            iTangramPlayerListener2.onVideoStop();
                            return;
                        case 8:
                            iTangramPlayerListener2.onVideoRender();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    public void a(int i3) {
        if (d()) {
            this.f40346d.seekTo(i3);
            this.f40357o = false;
            this.f40358p = 0;
        } else {
            this.f40357o = true;
            this.f40358p = i3;
        }
    }

    public ITangramPlayerListener a() {
        return this.f40359q;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
    }
}
