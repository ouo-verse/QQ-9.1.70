package com.qzone.widget.particle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.qzone.util.ar;
import com.qzone.widget.particle.ParticleManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;

/* loaded from: classes37.dex */
public class ParticleTextSurfaceView extends TextureView implements ParticleManager.a {
    private int C;
    private Rect D;
    private boolean E;
    private View.OnClickListener F;
    private View.OnTouchListener G;
    private View.OnClickListener H;
    private TextureView.SurfaceTextureListener I;

    /* renamed from: d, reason: collision with root package name */
    public final String f60931d;

    /* renamed from: e, reason: collision with root package name */
    private ParticleManager f60932e;

    /* renamed from: f, reason: collision with root package name */
    private Object f60933f;

    /* renamed from: h, reason: collision with root package name */
    private Surface f60934h;

    /* renamed from: i, reason: collision with root package name */
    private Context f60935i;

    /* renamed from: m, reason: collision with root package name */
    private int f60936m;

    /* loaded from: classes37.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ParticleTextSurfaceView.this.f60932e.r() == 2 || ParticleTextSurfaceView.this.f60932e.r() == 1) {
                ParticleTextSurfaceView.this.f60932e.H(ParticleTextSurfaceView.this.f60936m, ParticleTextSurfaceView.this.C);
                ParticleTextSurfaceView.this.f60932e.q();
                if (ParticleTextSurfaceView.this.F != null) {
                    ParticleTextSurfaceView.this.F.onClick(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ParticleTextSurfaceView(Context context) {
        super(context);
        this.f60931d = "ParticleTextSurfaceView";
        this.f60933f = new Object();
        this.D = new Rect();
        this.E = false;
        this.F = null;
        this.G = new a();
        this.H = new b();
        this.I = new c();
        this.f60935i = context;
        j();
    }

    private void j() {
        ParticleManager particleManager = new ParticleManager(this.f60935i);
        this.f60932e = particleManager;
        particleManager.J(this);
        setSurfaceTextureListener(this.I);
        setOnTouchListener(this.G);
        setOnClickListener(this.H);
        setOpaque(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f60932e.z();
    }

    public void i() {
        this.f60932e.l();
    }

    public void m() {
        this.f60932e.C();
    }

    public void n() {
        this.f60932e.F();
    }

    public void o(ParticleManager.b bVar) {
        this.f60932e.P(bVar);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (!z16) {
            this.f60932e.C();
        } else if (getVisibility() == 0) {
            this.f60932e.F();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (i3 != 0) {
            this.f60932e.C();
        } else if (getVisibility() == 0) {
            this.f60932e.F();
        }
    }

    public void setAnimateCenter(int i3, int i16) {
        this.f60932e.H(i3, i16);
    }

    public void setAnimationResume() {
        this.f60932e.I();
    }

    public void setCallBackListener(View.OnClickListener onClickListener) {
        this.F = onClickListener;
    }

    @Override // com.qzone.widget.particle.ParticleManager.a
    public void setCallbackVisibility(int i3) {
        if (this.E) {
            setVisibility(i3);
        }
    }

    public void setCanShowParticle(boolean z16) {
        this.E = z16;
    }

    public void setConfig(d dVar) {
        this.f60932e.N(dVar);
    }

    @Override // com.qzone.widget.particle.ParticleManager.a
    public void update() {
        int saveLayer;
        try {
            Surface surface = this.f60934h;
            if (surface == null) {
                return;
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            if (iArr[1] <= ar.k() && iArr[1] + getHeight() >= 0) {
                System.currentTimeMillis();
                synchronized (surface) {
                    Rect rect = this.D;
                    rect.left = 0;
                    rect.top = 0;
                    rect.bottom = getHeight();
                    this.D.right = getWidth();
                    Canvas lockCanvas = surface.lockCanvas(this.D);
                    if (lockCanvas == null) {
                        return;
                    }
                    lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    int r16 = this.f60932e.r();
                    if (r16 != 4 && r16 != 0) {
                        if (r16 != 1 && r16 != 3) {
                            saveLayer = 0;
                            lockCanvas.clipRect(0, 0, getWidth(), getHeight());
                            if (r16 != 1 || r16 == 3) {
                                this.f60932e.m(lockCanvas);
                                this.f60932e.n(lockCanvas);
                                lockCanvas.restoreToCount(saveLayer);
                            }
                            this.f60932e.w(lockCanvas);
                            surface.unlockCanvasAndPost(lockCanvas);
                            System.currentTimeMillis();
                            return;
                        }
                        saveLayer = lockCanvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                        lockCanvas.clipRect(0, 0, getWidth(), getHeight());
                        if (r16 != 1) {
                        }
                        this.f60932e.m(lockCanvas);
                        this.f60932e.n(lockCanvas);
                        lockCanvas.restoreToCount(saveLayer);
                        this.f60932e.w(lockCanvas);
                        surface.unlockCanvasAndPost(lockCanvas);
                        System.currentTimeMillis();
                        return;
                    }
                    surface.unlockCanvasAndPost(lockCanvas);
                }
            }
        } catch (Exception e16) {
            QZLog.e("ParticleTextSurfaceView", "update canvas error " + e16.toString());
        }
    }

    /* loaded from: classes37.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 0) {
                return false;
            }
            ParticleTextSurfaceView.this.f60936m = (int) motionEvent.getX();
            ParticleTextSurfaceView.this.C = (int) motionEvent.getY();
            return false;
        }
    }

    public void l() {
        this.E = false;
        this.f60932e.A();
    }

    public ParticleTextSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60931d = "ParticleTextSurfaceView";
        this.f60933f = new Object();
        this.D = new Rect();
        this.E = false;
        this.F = null;
        this.G = new a();
        this.H = new b();
        this.I = new c();
        this.f60935i = context;
        j();
    }

    /* loaded from: classes37.dex */
    class c implements TextureView.SurfaceTextureListener {
        c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            ParticleTextSurfaceView.this.f60934h = new Surface(surfaceTexture);
            ParticleTextSurfaceView.this.k();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ParticleTextSurfaceView.this.f60934h = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        }
    }
}
