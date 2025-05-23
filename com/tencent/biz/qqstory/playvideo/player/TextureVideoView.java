package com.tencent.biz.qqstory.playvideo.player;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import fd0.a;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes5.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl, TextureView.SurfaceTextureListener {
    protected fd0.a C;
    protected int D;
    protected int E;
    protected int F;
    protected MediaController G;
    protected a.b H;
    protected a.e I;
    protected a.f J;
    protected int K;
    protected a.c L;
    protected a.d M;
    protected int N;
    protected boolean P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    public boolean T;
    protected boolean U;
    a.g V;
    a.e W;

    /* renamed from: a0, reason: collision with root package name */
    private a.b f94087a0;

    /* renamed from: b0, reason: collision with root package name */
    private a.d f94088b0;

    /* renamed from: c0, reason: collision with root package name */
    private a.c f94089c0;

    /* renamed from: d, reason: collision with root package name */
    protected String f94090d;

    /* renamed from: d0, reason: collision with root package name */
    private a.InterfaceC10303a f94091d0;

    /* renamed from: e, reason: collision with root package name */
    protected Uri f94092e;

    /* renamed from: f, reason: collision with root package name */
    protected Map<String, String> f94093f;

    /* renamed from: h, reason: collision with root package name */
    protected int f94094h;

    /* renamed from: i, reason: collision with root package name */
    protected int f94095i;

    /* renamed from: m, reason: collision with root package name */
    protected Surface f94096m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements a.e {
        a() {
        }

        @Override // fd0.a.e
        @TargetApi(15)
        public void a(fd0.a aVar) {
            MediaController mediaController;
            TextureVideoView textureVideoView = TextureVideoView.this;
            fd0.a aVar2 = textureVideoView.C;
            if (aVar2 == null) {
                return;
            }
            textureVideoView.f94094h = 2;
            textureVideoView.R = true;
            textureVideoView.Q = true;
            textureVideoView.P = true;
            a.e eVar = textureVideoView.I;
            if (eVar != null) {
                eVar.a(aVar2);
            }
            MediaController mediaController2 = TextureVideoView.this.G;
            if (mediaController2 != null) {
                mediaController2.setEnabled(true);
            }
            TextureVideoView.this.E = aVar.getVideoWidth();
            TextureVideoView.this.F = aVar.getVideoHeight();
            TextureVideoView textureVideoView2 = TextureVideoView.this;
            int i3 = textureVideoView2.N;
            if (i3 != 0) {
                textureVideoView2.seekTo(i3);
            }
            TextureVideoView textureVideoView3 = TextureVideoView.this;
            if (textureVideoView3.E != 0 && textureVideoView3.F != 0) {
                SurfaceTexture surfaceTexture = textureVideoView3.getSurfaceTexture();
                TextureVideoView textureVideoView4 = TextureVideoView.this;
                surfaceTexture.setDefaultBufferSize(textureVideoView4.E, textureVideoView4.F);
                TextureVideoView textureVideoView5 = TextureVideoView.this;
                if (textureVideoView5.f94095i == 3) {
                    textureVideoView5.start();
                    MediaController mediaController3 = TextureVideoView.this.G;
                    if (mediaController3 != null) {
                        mediaController3.show();
                        return;
                    }
                    return;
                }
                if (!textureVideoView5.isPlaying()) {
                    if ((i3 != 0 || TextureVideoView.this.getCurrentPosition() > 0) && (mediaController = TextureVideoView.this.G) != null) {
                        mediaController.show(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (textureVideoView3.f94095i == 3) {
                textureVideoView3.start();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements a.b {
        b() {
        }

        @Override // fd0.a.b
        public void b(fd0.a aVar) {
            TextureVideoView textureVideoView = TextureVideoView.this;
            textureVideoView.f94094h = 5;
            textureVideoView.f94095i = 5;
            MediaController mediaController = textureVideoView.G;
            if (mediaController != null) {
                mediaController.hide();
            }
            TextureVideoView textureVideoView2 = TextureVideoView.this;
            a.b bVar = textureVideoView2.H;
            if (bVar != null) {
                bVar.b(textureVideoView2.C);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements a.d {
        c() {
        }

        @Override // fd0.a.d
        public boolean c(fd0.a aVar, int i3, int i16) {
            a.d dVar = TextureVideoView.this.M;
            if (dVar != null) {
                dVar.c(aVar, i3, i16);
                return true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements a.c {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                TextureVideoView textureVideoView = TextureVideoView.this;
                a.b bVar = textureVideoView.H;
                if (bVar != null) {
                    bVar.b(textureVideoView.C);
                }
            }
        }

        d() {
        }

        @Override // fd0.a.c
        public boolean d(fd0.a aVar, int i3, int i16) {
            int i17;
            if (QLog.isColorLevel()) {
                QLog.d(TextureVideoView.this.f94090d, 2, "Error: " + i3 + "," + i16);
            }
            TextureVideoView textureVideoView = TextureVideoView.this;
            textureVideoView.f94094h = -1;
            textureVideoView.f94095i = -1;
            MediaController mediaController = textureVideoView.G;
            if (mediaController != null) {
                mediaController.hide();
            }
            a.c cVar = TextureVideoView.this.L;
            if ((cVar == null || !cVar.d(aVar, i3, i16)) && TextureVideoView.this.getWindowToken() != null) {
                TextureVideoView.this.getContext().getResources();
                if (i3 == 200) {
                    i17 = R.string.VideoView_error_text_invalid_progressive_playback;
                } else {
                    i17 = R.string.VideoView_error_text_unknown;
                }
                Activity e16 = TextureVideoView.this.e();
                if (e16 != null) {
                    new AlertDialog.Builder(e16).setMessage(i17).setPositiveButton(R.string.VideoView_error_button, new a()).setCancelable(false).show();
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements a.InterfaceC10303a {
        e() {
        }

        @Override // fd0.a.InterfaceC10303a
        public void a(fd0.a aVar, int i3) {
            TextureVideoView.this.K = i3;
        }
    }

    public TextureVideoView(Context context) {
        this(context, null, 0);
    }

    private void b() {
        MediaController mediaController;
        View view;
        if (this.C != null && (mediaController = this.G) != null) {
            mediaController.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.G.setAnchorView(view);
            this.G.setEnabled(g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity e() {
        try {
            for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void f() {
        this.E = 0;
        this.F = 0;
        super.setSurfaceTextureListener(this);
        super.setFocusable(true);
        super.setFocusableInTouchMode(true);
        super.requestFocus();
        this.f94094h = 0;
        this.f94095i = 0;
    }

    private boolean g() {
        int i3;
        if (this.C != null && (i3 = this.f94094h) != -1 && i3 != 0 && i3 != 1) {
            return true;
        }
        return false;
    }

    private void h() {
        i(!this.T);
    }

    private void i(boolean z16) {
        if (this.f94092e != null && this.f94096m != null) {
            j(false);
            if (z16) {
                try {
                    ((AudioManager) super.getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w(this.f94090d, 2, "requestAudioFocus Exception: " + QLog.getStackTraceString(e16));
                    }
                }
            }
            try {
                fd0.a c16 = c();
                this.C = c16;
                c16.setLooping(this.S);
                int i3 = this.D;
                if (i3 != 0) {
                    this.C.setAudioSessionId(i3);
                } else {
                    this.D = this.C.getAudioSessionId();
                }
                this.C.a(this.W);
                this.C.c(this.V);
                this.C.e(this.f94087a0);
                this.C.b(this.f94089c0);
                this.C.f(this.f94088b0);
                this.C.d(this.f94091d0);
                a.f fVar = this.J;
                if (fVar != null) {
                    this.C.g(fVar);
                }
                this.K = 0;
                this.C.setDataSource(getContext().getApplicationContext(), this.f94092e, this.f94093f);
                this.C.setSurface(this.f94096m);
                this.C.setAudioStreamType(3);
                this.C.setScreenOnWhilePlaying(true);
                this.C.prepareAsync();
                this.f94094h = 1;
                b();
            } catch (IOException e17) {
                if (QLog.isColorLevel()) {
                    QLog.w(this.f94090d, 2, "Unable to open content: " + this.f94092e, e17);
                }
                this.f94094h = -1;
                this.f94095i = -1;
                this.f94089c0.d(this.C, 1, 0);
            } catch (IllegalArgumentException e18) {
                if (QLog.isColorLevel()) {
                    QLog.w(this.f94090d, 2, "Unable to open content: " + this.f94092e, e18);
                }
                this.f94094h = -1;
                this.f94095i = -1;
                this.f94089c0.d(this.C, 1, 0);
            } catch (IllegalStateException e19) {
                if (QLog.isColorLevel()) {
                    QLog.w(this.f94090d, 2, "prepareAsync cause  IllegalStateException", e19);
                }
                this.f94094h = -1;
                this.f94095i = -1;
                this.f94089c0.d(this.C, 1, 0);
            }
        }
    }

    private void j(boolean z16) {
        fd0.a aVar = this.C;
        if (aVar != null) {
            aVar.stop();
            try {
                this.C.reset();
                this.C.release();
            } catch (IllegalStateException e16) {
                QLog.e(this.f94090d, 1, "mMediaPlayer.release() throw a exception!!", new IllegalStateException("CatchedException, caused by: ", e16));
            }
            this.C = null;
            this.f94094h = 0;
            if (z16) {
                this.f94095i = 0;
            }
            ((AudioManager) super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    private void l() {
        if (this.G.isShowing()) {
            this.G.hide();
        } else {
            this.G.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fd0.a c() {
        return new fd0.b();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.P;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.Q;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.R;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        if (this.D == 0) {
            ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
            this.D = reportMediaPlayer.getAudioSessionId();
            reportMediaPlayer.release();
        }
        return this.D;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.C != null) {
            return this.K;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (g()) {
            return this.C.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (g()) {
            return this.C.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (g() && this.C.isPlaying()) {
            return true;
        }
        return false;
    }

    public void k() {
        fd0.a aVar = this.C;
        if (aVar != null) {
            aVar.stop();
            this.C.release();
            this.C.a(null);
            this.C.c(null);
            this.C.e(null);
            this.C.b(null);
            this.C.f(null);
            this.C.d(null);
            this.C.g(null);
            this.C = null;
            this.f94094h = 0;
            this.f94095i = 0;
            ((AudioManager) super.getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureVideoView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        if (i3 != 4 && i3 != 24 && i3 != 25 && i3 != 164 && i3 != 82 && i3 != 5 && i3 != 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (g() && z16 && this.G != null) {
            if (i3 != 79 && i3 != 85) {
                if (i3 == 126) {
                    if (!this.C.isPlaying()) {
                        start();
                        this.G.hide();
                    }
                    return true;
                }
                if (i3 != 86 && i3 != 127) {
                    l();
                } else {
                    if (this.C.isPlaying()) {
                        pause();
                        this.G.show();
                    }
                    return true;
                }
            } else {
                if (this.C.isPlaying()) {
                    pause();
                    this.G.show();
                } else {
                    start();
                    this.G.hide();
                }
                return true;
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (r1 > r6) goto L33;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i3, int i16) {
        int i17;
        int defaultSize = View.getDefaultSize(this.E, i3);
        int defaultSize2 = View.getDefaultSize(this.F, i16);
        if (this.E > 0 && this.F > 0) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i16);
            int size2 = View.MeasureSpec.getSize(i16);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i18 = this.E;
                int i19 = i18 * size2;
                int i26 = this.F;
                if (i19 < size * i26) {
                    if (this.U) {
                        defaultSize = (i18 * size2) / i26;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = (i26 * size) / i18;
                        defaultSize = size;
                    }
                } else {
                    if (i18 * size2 > size * i26) {
                        if (this.U) {
                            defaultSize2 = (i26 * size) / i18;
                            defaultSize = size;
                        } else {
                            defaultSize = (i18 * size2) / i26;
                            defaultSize2 = size2;
                        }
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i27 = (this.F * size) / this.E;
                if (mode2 != Integer.MIN_VALUE || i27 <= size2) {
                    defaultSize2 = i27;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                if (mode2 == 1073741824) {
                    i17 = (this.E * size2) / this.F;
                    if (mode == Integer.MIN_VALUE) {
                    }
                } else {
                    int i28 = this.E;
                    int i29 = this.F;
                    if (mode2 == Integer.MIN_VALUE && i29 > size2) {
                        i17 = (size2 * i28) / i29;
                    } else {
                        i17 = i28;
                        size2 = i29;
                    }
                    if (mode == Integer.MIN_VALUE && i17 > size) {
                        defaultSize2 = (i29 * size) / i28;
                        defaultSize = size;
                    }
                }
                defaultSize = i17;
                defaultSize2 = size2;
            }
        }
        super.setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.f94096m = new Surface(surfaceTexture);
        if (QLog.isColorLevel()) {
            QLog.w(this.f94090d, 1, "onSurfaceTextureAvailable: openVideo");
        }
        h();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Surface surface = this.f94096m;
        if (surface != null) {
            surface.release();
            this.f94096m = null;
        }
        MediaController mediaController = this.G;
        if (mediaController != null) {
            mediaController.hide();
        }
        j(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        boolean z16;
        boolean z17 = true;
        if (this.f94095i == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 <= 0 || i16 <= 0) {
            z17 = false;
        }
        if (this.C != null && z16 && z17) {
            int i17 = this.N;
            if (i17 != 0) {
                seekTo(i17);
            }
            start();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (g() && this.G != null) {
            l();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (g() && this.G != null) {
            l();
            return false;
        }
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (g() && this.C.isPlaying()) {
            this.C.pause();
            this.f94094h = 4;
        }
        this.f94095i = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i3) {
        if (g()) {
            this.C.seekTo(i3);
            this.N = 0;
        } else {
            this.N = i3;
        }
    }

    public void setCenterInside(boolean z16) {
        this.U = z16;
    }

    public void setLooping(boolean z16) {
        this.S = z16;
        fd0.a aVar = this.C;
        if (aVar != null) {
            aVar.setLooping(z16);
        }
    }

    public void setOnCompletionListener(a.b bVar) {
        this.H = bVar;
    }

    public void setOnErrorListener(a.c cVar) {
        this.L = cVar;
    }

    public void setOnInfoListener(a.d dVar) {
        this.M = dVar;
    }

    public void setOnPreparedListener(a.e eVar) {
        this.I = eVar;
    }

    public void setOnSeekCompleteListener(a.f fVar) {
        this.J = fVar;
        fd0.a aVar = this.C;
        if (aVar != null) {
            aVar.g(fVar);
        }
    }

    public void setVideoPath(String str) {
        Uri parse;
        if (str == null) {
            parse = null;
        } else {
            parse = Uri.parse(str);
        }
        setVideoURI(parse);
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (g()) {
            this.C.start();
            this.f94094h = 3;
        }
        this.f94095i = 3;
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setVideoURI(Uri uri, Map<String, String> map) {
        this.f94092e = uri;
        this.f94093f = map;
        this.N = 0;
        if (QLog.isColorLevel()) {
            QLog.w(this.f94090d, 1, "setVideoURI: openVideo");
        }
        h();
        super.requestLayout();
        super.invalidate();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94090d = "Q.qqstory.player.TextureVideoView";
        this.f94094h = 0;
        this.f94095i = 0;
        this.f94096m = null;
        this.C = null;
        this.U = false;
        this.V = new a.g() { // from class: com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1
            @Override // fd0.a.g
            @TargetApi(15)
            public void a(final fd0.a aVar, int i16, int i17) {
                if (TextureVideoView.this.getHandler() == null) {
                    return;
                }
                TextureVideoView.this.getHandler().post(new Runnable() { // from class: com.tencent.biz.qqstory.playvideo.player.TextureVideoView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TextureVideoView.this.E = aVar.getVideoWidth();
                            TextureVideoView.this.F = aVar.getVideoHeight();
                            TextureVideoView textureVideoView = TextureVideoView.this;
                            if (textureVideoView.E != 0 && textureVideoView.F != 0) {
                                SurfaceTexture surfaceTexture = textureVideoView.getSurfaceTexture();
                                TextureVideoView textureVideoView2 = TextureVideoView.this;
                                surfaceTexture.setDefaultBufferSize(textureVideoView2.E, textureVideoView2.F);
                                TextureVideoView.this.requestLayout();
                            }
                        } catch (Exception e16) {
                            QLog.e(TextureVideoView.this.f94090d, 1, e16, new Object[0]);
                        }
                    }
                });
            }
        };
        this.W = new a();
        this.f94087a0 = new b();
        this.f94088b0 = new c();
        this.f94089c0 = new d();
        this.f94091d0 = new e();
        f();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setmOnTextureUpdateListener(a.h hVar) {
    }
}
