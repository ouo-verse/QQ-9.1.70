package com.qq.e.comm.plugin.base.media.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.k.ai;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.az;
import com.qq.e.comm.plugin.k.n;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GDTVideoView extends TextureView implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, h {
    public static final int SCALE_TYPE_CENTER_CROP = 3;
    public static final int SCALE_TYPE_CROP = 2;
    public static final int SCALE_TYPE_DEFAULT = 1;
    public static final int VIDEO_STATE_END = 6;
    public static final int VIDEO_STATE_ERROR = 0;
    public static final int VIDEO_STATE_PAUSE = 5;
    public static final int VIDEO_STATE_PLAY = 3;
    public static final int VIDEO_STATE_PREPARED = 2;
    public static final int VIDEO_STATE_STOP = 4;
    public static final int VIDEO_STATE_UNINITIALIZED = 1;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private com.qq.e.comm.plugin.m.c G;
    private String H;
    private com.qq.e.comm.plugin.m.b I;

    /* renamed from: a, reason: collision with root package name */
    private int f39206a;

    /* renamed from: b, reason: collision with root package name */
    private int f39207b;

    /* renamed from: c, reason: collision with root package name */
    private SurfaceTexture f39208c;

    /* renamed from: d, reason: collision with root package name */
    private volatile MediaPlayer f39209d;

    /* renamed from: e, reason: collision with root package name */
    private AudioManager f39210e;

    /* renamed from: f, reason: collision with root package name */
    private Surface f39211f;

    /* renamed from: g, reason: collision with root package name */
    private int f39212g;

    /* renamed from: h, reason: collision with root package name */
    private int f39213h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39214i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39215j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39216k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39217l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f39218m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f39219n;

    /* renamed from: o, reason: collision with root package name */
    private int f39220o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39221p;

    /* renamed from: q, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.media.video.c f39222q;

    /* renamed from: r, reason: collision with root package name */
    private a f39223r;

    /* renamed from: s, reason: collision with root package name */
    private int f39224s;

    /* renamed from: t, reason: collision with root package name */
    private int f39225t;

    /* renamed from: u, reason: collision with root package name */
    private long f39226u;

    /* renamed from: v, reason: collision with root package name */
    private int f39227v;

    /* renamed from: w, reason: collision with root package name */
    private int f39228w;

    /* renamed from: x, reason: collision with root package name */
    private String f39229x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f39230y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f39231z;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScaleType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface VideoState {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b extends a {
        void a();

        void a(int i3);
    }

    public GDTVideoView(Context context, boolean z16, boolean z17, File file) {
        super(context);
        this.f39208c = null;
        this.f39209d = null;
        this.f39211f = null;
        this.f39225t = 1;
        this.f39226u = 0L;
        this.f39227v = 0;
        this.f39228w = 0;
        this.f39230y = false;
        this.f39231z = false;
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.I = null;
        q();
        this.D = z16;
        this.F = z17;
        a(context, file);
    }

    private void A() {
        AudioManager audioManager;
        if (!this.f39218m && this.f39224s == 3 && (audioManager = this.f39210e) != null) {
            audioManager.requestAudioFocus(null, 3, 2);
        }
    }

    private void B() {
        AudioManager audioManager = this.f39210e;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    private void q() {
        r();
        this.f39210e = (AudioManager) getContext().getSystemService("audio");
        setSurfaceTextureListener(this);
        try {
            this.f39209d.setOnPreparedListener(this);
            this.f39209d.setOnCompletionListener(this);
            this.f39209d.setOnErrorListener(this);
            this.f39209d.setOnSeekCompleteListener(this);
            this.f39209d.setOnVideoSizeChangedListener(this);
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }

    private void r() {
        if (this.f39209d == null) {
            this.f39209d = new ReportMediaPlayer();
        } else {
            this.f39209d.reset();
        }
        this.f39206a = 0;
        this.f39207b = 0;
        this.f39216k = false;
        this.f39217l = false;
        this.f39219n = false;
        this.f39220o = 0;
        this.f39224s = 1;
    }

    private void s() {
        com.qq.e.comm.plugin.base.media.video.c cVar;
        if (this.f39209d != null && (cVar = this.f39222q) != null) {
            cVar.a(this);
        }
    }

    private void t() {
        com.qq.e.comm.plugin.base.media.video.c cVar = this.f39222q;
        if (cVar != null) {
            cVar.d();
        }
    }

    private void u() {
        com.qq.e.comm.plugin.base.media.video.c cVar = this.f39222q;
        if (cVar != null) {
            cVar.c();
        }
    }

    private boolean v() {
        int i3;
        if (this.f39209d != null && (i3 = this.f39224s) != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    private void w() {
        try {
            if (this.f39209d != null) {
                this.f39209d.prepareAsync();
            }
        } catch (IllegalArgumentException e16) {
            GDTLogger.d(e16.getMessage());
        } catch (IllegalStateException e17) {
            GDTLogger.d(e17.getMessage());
        } catch (SecurityException e18) {
            GDTLogger.d(e18.getMessage());
        }
    }

    private void x() {
        if (this.f39208c == null) {
            GDTLogger.d("SurfaceTexture is not available, can't open video.");
            return;
        }
        if (this.f39209d == null) {
            GDTLogger.d("MediaPlayer is null, can't open video.");
            return;
        }
        if (this.f39211f == null) {
            this.f39211f = new Surface(this.f39208c);
        }
        this.f39209d.setSurface(this.f39211f);
        this.f39215j = true;
        if (this.f39214i && this.f39217l && this.f39216k) {
            GDTLogger.d("SurfaceTexture is available and play() was called.");
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.f39209d != null) {
            this.f39209d.reset();
            this.f39209d.release();
            this.f39209d = null;
            this.f39224s = 1;
            this.f39230y = true;
            this.f39214i = false;
        }
    }

    private void z() {
        float f16;
        GDTLogger.d(hashCode() + " reInit");
        q();
        int i3 = this.A;
        if (i3 > 0) {
            a(i3);
        }
        if (this.f39218m) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        this.f39209d.setVolume(f16, f16);
        if (this.f39229x != null) {
            try {
                this.f39209d.setDataSource(this.f39229x);
                this.f39214i = true;
                w();
                return;
            } catch (Exception e16) {
                GDTLogger.e(e16.getMessage());
                return;
            }
        }
        GDTLogger.e(hashCode() + " reInit failed, path is null");
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public void b() {
        int i3 = this.f39224s;
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
        this.f39224s = 5;
        if (this.f39209d.isPlaying()) {
            this.f39231z = true;
            this.f39209d.pause();
        }
        B();
        a aVar = this.f39223r;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public boolean c() {
        try {
            if (v()) {
                return this.f39209d.isPlaying();
            }
            return false;
        } catch (Throwable th5) {
            GDTLogger.e("GDTVideoView check isPlaying error", th5);
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public boolean d() {
        return this.f39218m;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        l();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public int e() {
        if (v()) {
            try {
                return this.f39209d.getDuration();
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
                return 0;
            }
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public int f() {
        if (v()) {
            if (this.f39224s == 6) {
                return e();
            }
            try {
                return this.f39209d.getCurrentPosition();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public int g() {
        return this.f39224s;
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public void h() {
        if (this.f39209d != null && this.f39224s != 0 && !this.f39218m) {
            GDTLogger.d("Set volume off.");
            try {
                this.f39209d.setVolume(0.0f, 0.0f);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.f39218m = true;
            com.qq.e.comm.plugin.base.media.video.c cVar = this.f39222q;
            if (cVar != null) {
                cVar.e();
            }
            B();
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public void i() {
        if (this.f39209d != null && this.f39224s != 0 && this.f39218m) {
            GDTLogger.d("Set volume on.");
            try {
                this.f39209d.setVolume(1.0f, 1.0f);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.f39218m = false;
            com.qq.e.comm.plugin.base.media.video.c cVar = this.f39222q;
            if (cVar != null) {
                cVar.e();
            }
            A();
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public boolean j() {
        return this.B;
    }

    public void k() {
        GDTLogger.d(hashCode() + " free");
        c.a().b(this);
        p();
        if (this.f39209d != null) {
            this.f39209d.release();
            this.f39209d = null;
            this.f39224s = 1;
            if (!az.b()) {
                this.f39208c = null;
            }
        }
        if (this.G != null) {
            GDTLogger.d("VideoCache videoCacheProxyServer free");
            this.G.a();
        }
    }

    public void l() {
        if (this.f39222q != null && !this.f39221p) {
            if (System.currentTimeMillis() - this.f39226u < 100) {
                GDTLogger.d("TOUCH_THRESHOLD_TIME limit");
                return;
            }
            GDTLogger.d("TOUCH_THRESHOLD_TIME reset");
            this.f39226u = System.currentTimeMillis();
            if (this.f39222q.isShown()) {
                t();
            } else {
                u();
            }
        }
    }

    public boolean m() {
        return this.C;
    }

    public String n() {
        return this.H;
    }

    public boolean o() {
        return this.E;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d(hashCode() + " attached");
        c.a().b(this);
        if (this.f39230y) {
            z();
            this.f39230y = false;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f39224s != 6) {
            this.f39224s = 6;
            GDTLogger.d("Video is ended.");
            B();
            a aVar = this.f39223r;
            if (aVar != null) {
                aVar.d();
            }
            if (this.B) {
                this.C = true;
                a();
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d(hashCode() + " detach");
        this.A = f();
        if (this.f39209d != null) {
            c.a().a(this);
        }
        if (az.b()) {
            SurfaceTexture surfaceTexture = this.f39208c;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f39208c = null;
            }
            Surface surface = this.f39211f;
            if (surface != null) {
                surface.release();
                this.f39211f = null;
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
        StatTracer.trackEvent(30112, i3, (com.qq.e.comm.plugin.stat.b) null);
        if (this.f39224s != 0) {
            this.f39224s = 0;
            GDTLogger.e("Video encountered error, what = " + i3 + ", extra = " + i16);
            B();
            a aVar = this.f39223r;
            if (aVar != null) {
                aVar.e();
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00db, code lost:
    
        if (r0 > r7) goto L50;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int i17;
        int c16;
        int defaultSize = View.getDefaultSize(this.f39206a, i3);
        int defaultSize2 = View.getDefaultSize(this.f39207b, i16);
        if (this.f39206a > 0 && this.f39207b > 0) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size2 = View.MeasureSpec.getSize(i16);
            int i18 = this.f39225t;
            if (i18 == 2 && (size != 0 || size2 != 0)) {
                int i19 = this.f39207b;
                int i26 = size * i19;
                int i27 = this.f39206a;
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
                float f16 = (defaultSize * 1.0f) / this.f39206a;
                float f17 = (defaultSize2 * 1.0f) / this.f39207b;
                float max = Math.max(f16, f17);
                Matrix matrix = new Matrix();
                matrix.setScale(max / f16, max / f17, defaultSize / 2, defaultSize2 / 2);
                setTransform(matrix);
            } else if (mode == 1073741824 && mode2 == 1073741824) {
                int i28 = this.f39206a;
                int i29 = i28 * size2;
                int i36 = this.f39207b;
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
                    int i38 = (this.f39207b * size) / this.f39206a;
                    if (mode2 != Integer.MIN_VALUE || i38 <= size2) {
                        defaultSize2 = i38;
                        defaultSize = size;
                    }
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.f39206a * size2) / this.f39207b;
                    if (mode == Integer.MIN_VALUE) {
                    }
                } else {
                    int i39 = this.f39206a;
                    int i46 = this.f39207b;
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
        } else if (SDKStatus.getSDKVersionCode() >= 13 && this.f39212g > 0 && this.f39213h > 0) {
            defaultSize = View.MeasureSpec.getSize(i3);
            defaultSize2 = View.MeasureSpec.getSize(i16);
            int i48 = this.f39213h;
            int i49 = defaultSize * i48;
            int i56 = this.f39212g;
            if (i49 >= i56 * defaultSize2 && defaultSize2 != 0) {
                if (defaultSize * i48 > i56 * defaultSize2 || defaultSize == 0) {
                    defaultSize = (i56 * defaultSize2) / i48;
                }
            } else {
                defaultSize2 = (i48 * defaultSize) / i56;
            }
        }
        b(defaultSize, defaultSize2);
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f39224s = 2;
        this.f39216k = true;
        GDTLogger.d("Video is prepared.");
        this.f39206a = mediaPlayer.getVideoWidth();
        this.f39207b = mediaPlayer.getVideoHeight();
        a aVar = this.f39223r;
        if (aVar != null) {
            aVar.b();
        }
        if (this.f39219n) {
            GDTLogger.d("Player is prepared and seekTo() was called.");
            a(this.f39220o);
        }
        if (this.f39217l && this.f39215j) {
            GDTLogger.d("Player is prepared and play() was called.");
            a();
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
        a aVar = this.f39223r;
        if (aVar instanceof b) {
            ((b) aVar).a(i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        GDTLogger.d("onSurfaceTextureAvailable");
        SurfaceTexture surfaceTexture2 = this.f39208c;
        if (surfaceTexture2 == null) {
            this.f39208c = surfaceTexture;
        } else {
            setSurfaceTexture(surfaceTexture2);
        }
        x();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        GDTLogger.d("onSurfaceTextureDestroyed");
        this.f39217l = false;
        this.f39215j = false;
        if (az.b() || this.f39208c != null) {
            return false;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (az.b() && surfaceTexture != null && (surfaceTexture2 = this.f39208c) != surfaceTexture) {
            surfaceTexture2.release();
        }
        this.f39208c = surfaceTexture;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i16) {
        this.f39206a = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f39207b = videoHeight;
        if (this.f39206a != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    public void p() {
        com.qq.e.comm.plugin.m.c cVar = this.G;
        if (cVar != null) {
            cVar.b(this.H);
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public void a(a aVar) {
        this.f39223r = aVar;
    }

    public void a(int i3, int i16) {
        this.f39212g = i3;
        this.f39213h = i16;
    }

    public void c(boolean z16) {
        this.C = z16;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static volatile c f39232a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayBlockingQueue<WeakReference<GDTVideoView>> f39233b;

        /* renamed from: c, reason: collision with root package name */
        private int f39234c = -1;

        c() {
            this.f39233b = null;
            this.f39233b = new ArrayBlockingQueue<>(16);
        }

        public static c a() {
            if (f39232a == null) {
                synchronized (c.class) {
                    if (f39232a == null) {
                        f39232a = new c();
                    }
                }
            }
            return f39232a;
        }

        public boolean b(GDTVideoView gDTVideoView) {
            WeakReference<GDTVideoView> weakReference;
            if (gDTVideoView == null) {
                return false;
            }
            Iterator<WeakReference<GDTVideoView>> it = this.f39233b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    weakReference = null;
                    break;
                }
                weakReference = it.next();
                if (gDTVideoView == weakReference.get()) {
                    break;
                }
            }
            if (weakReference != null) {
                boolean remove = this.f39233b.remove(weakReference);
                GDTLogger.d(gDTVideoView.hashCode() + " removed from cache, result = " + remove + ", size = " + this.f39233b.size());
                return remove;
            }
            GDTLogger.d(gDTVideoView.hashCode() + " not in cache");
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int b() {
            int i3;
            int i16 = this.f39234c;
            if (i16 >= 0) {
                return i16;
            }
            SM sm5 = GDTADManager.getInstance().getSM();
            int i17 = 5;
            if (sm5 != null) {
                String string = sm5.getString("maxCachedPlayerCount");
                GDTLogger.d("player cache count str = " + string);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        i3 = Integer.parseInt(string);
                    } catch (Exception e16) {
                        GDTLogger.e(e16.getMessage());
                    }
                    if (i3 >= 0) {
                        GDTLogger.i("player cache count = " + i3 + ", set to default: 5");
                    } else {
                        i17 = i3;
                    }
                    this.f39234c = i17;
                    return i17;
                }
            }
            i3 = 5;
            if (i3 >= 0) {
            }
            this.f39234c = i17;
            return i17;
        }

        public boolean a(GDTVideoView gDTVideoView) {
            if (gDTVideoView == null) {
                GDTLogger.e("view == null, return");
                return false;
            }
            int b16 = b();
            if (b16 == 0) {
                GDTLogger.d("maxCount == 0, return");
                return false;
            }
            if (this.f39233b.size() == b()) {
                WeakReference<GDTVideoView> poll = this.f39233b.poll();
                if (poll != null) {
                    GDTVideoView gDTVideoView2 = poll.get();
                    if (gDTVideoView2 != null) {
                        GDTLogger.e(gDTVideoView2.hashCode() + "'s player will be released, maxCacheCount = " + b16);
                        gDTVideoView2.y();
                    } else {
                        GDTLogger.d("player is released, remove it");
                    }
                } else {
                    GDTLogger.e("queue is empty, why?!");
                }
            }
            boolean offer = this.f39233b.offer(new WeakReference<>(gDTVideoView));
            GDTLogger.d(gDTVideoView.hashCode() + " add to cache, result = " + offer + ", size = " + this.f39233b.size());
            return offer;
        }
    }

    private void a(Context context, File file) {
        if (this.D && com.qq.e.comm.plugin.m.a.a()) {
            this.G = com.qq.e.comm.plugin.m.a.b().getServer(context, file == null ? ai.g() : ai.f(), this.F);
        }
    }

    public void a(com.qq.e.comm.plugin.base.media.video.c cVar) {
        this.f39222q = cVar;
        t();
        s();
    }

    public boolean a(String str, com.qq.e.comm.plugin.m.b bVar) {
        com.qq.e.comm.plugin.m.c cVar;
        this.H = str;
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            if (!this.D || (cVar = this.G) == null) {
                return false;
            }
            str = cVar.a(str);
            GDTLogger.d("VideoCache getProxyUrl:" + str);
            this.I = bVar;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a(str, bVar, false);
        return true;
    }

    public void b(int i3) {
        this.f39225t = i3;
    }

    private void b(int i3, int i16) {
        com.qq.e.comm.plugin.base.media.video.c cVar;
        if (SDKStatus.getSDKVersionCode() < 13 || (cVar = this.f39222q) == null || !(cVar instanceof com.qq.e.comm.plugin.base.media.video.b)) {
            return;
        }
        if (i3 == this.f39227v && i16 == this.f39228w) {
            return;
        }
        this.f39227v = i3;
        this.f39228w = i16;
        ((com.qq.e.comm.plugin.base.media.video.b) cVar).a(i3, i16);
    }

    public void b(boolean z16) {
        this.B = z16;
    }

    public void a(String str) {
        a(str, null, true);
    }

    private void a(String str, com.qq.e.comm.plugin.m.b bVar, boolean z16) {
        r();
        try {
            this.f39229x = str;
            if (TextUtils.isEmpty(this.H) || z16) {
                this.H = this.f39229x;
            }
            if (!TextUtils.isEmpty(this.f39229x) && this.f39229x.startsWith("http")) {
                this.E = true;
                com.qq.e.comm.plugin.m.c cVar = this.G;
                if (cVar != null) {
                    cVar.a(bVar, this.H);
                }
            } else {
                this.D = false;
            }
            this.f39209d.setDataSource(this.f39229x);
            GDTLogger.d("VideoCache setDataSource:" + this.f39229x);
            this.f39214i = true;
            a aVar = this.f39223r;
            if (aVar instanceof b) {
                ((b) aVar).a();
            }
            w();
        } catch (IOException | IllegalStateException e16) {
            GDTLogger.e("VideoCache setDataSource", e16);
            this.f39224s = 0;
            StatTracer.trackEvent(30112, 0, (com.qq.e.comm.plugin.stat.b) null);
            a aVar2 = this.f39223r;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.base.media.video.h
    public void a() {
        if (!this.f39214i) {
            GDTLogger.d("play() was called but video data source was not set.");
            return;
        }
        this.f39217l = true;
        if (!this.f39216k) {
            GDTLogger.d("play() was called but video is not prepared yet, waiting.");
            return;
        }
        if (!this.f39215j) {
            GDTLogger.d("play() was called but SurfaceTexture is not available yet, waiting.");
            return;
        }
        int i3 = this.f39224s;
        if (i3 == 3) {
            GDTLogger.d("play() was called but video is already playing.");
            return;
        }
        if (!this.f39231z && i3 != 5) {
            if ((i3 == 6 && !this.B) || i3 == 4) {
                GDTLogger.d("play() was called but video already ended/stopped, starting over.");
                a(this.H, this.I);
                this.f39217l = true;
                return;
            }
            this.f39224s = 3;
            A();
            this.f39209d.start();
            GDTLogger.d("VideoCache onVideoStart");
            a aVar = this.f39223r;
            if (aVar != null) {
                aVar.c();
                return;
            }
            return;
        }
        GDTLogger.d("play() was called but video is paused, resuming.");
        this.f39224s = 3;
        this.f39231z = false;
        this.f39209d.start();
        A();
        a aVar2 = this.f39223r;
        if (aVar2 != null) {
            aVar2.g();
        }
    }

    public void a(int i3) {
        if (v()) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f39209d.seekTo(i3, 3);
            } else {
                this.f39209d.seekTo(i3);
            }
            this.f39219n = false;
            this.f39220o = 0;
            return;
        }
        this.f39219n = true;
        this.f39220o = i3;
    }

    public void a(boolean z16) {
        this.f39221p = z16;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
    }
}
