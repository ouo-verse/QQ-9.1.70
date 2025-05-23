package com.tencent.mobileqq.surfaceviewaction.gl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView;
import com.tencent.mobileqq.surfaceviewaction.gl.d;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpriteGLView extends FrameLayout implements com.tencent.mobileqq.surfaceviewaction.e<d> {
    static IPatchRedirector $redirector_;
    private final Object C;
    protected View D;
    private a E;
    private long F;
    public boolean G;
    public boolean H;
    int I;
    public volatile boolean J;

    /* renamed from: d, reason: collision with root package name */
    private int f291242d;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedList<Integer> f291243e;

    /* renamed from: f, reason: collision with root package name */
    private final List<com.tencent.mobileqq.surfaceviewaction.a> f291244f;

    /* renamed from: h, reason: collision with root package name */
    private List<Runnable> f291245h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f291246i;

    /* renamed from: m, reason: collision with root package name */
    private List<Runnable> f291247m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        int getCurrentTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements GLSurfaceView.Renderer {
        static IPatchRedirector $redirector_;
        private int C;
        private int D;
        private long E;
        private int F;
        private com.tencent.mobileqq.surfaceviewaction.gl.b G;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f291248d;

        /* renamed from: e, reason: collision with root package name */
        private final float[] f291249e;

        /* renamed from: f, reason: collision with root package name */
        private final float[] f291250f;

        /* renamed from: h, reason: collision with root package name */
        private int f291251h;

        /* renamed from: i, reason: collision with root package name */
        private int f291252i;

        /* renamed from: m, reason: collision with root package name */
        private int f291253m;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpriteGLView.this);
                return;
            }
            this.f291248d = new float[16];
            this.f291249e = new float[16];
            this.f291250f = new float[16];
            this.F = 0;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        @SuppressLint({"DefaultLocale"})
        public void onDrawFrame(GL10 gl10) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                synchronized (SpriteGLView.this.f291246i) {
                    for (int i3 = 0; i3 < SpriteGLView.this.f291245h.size(); i3++) {
                        ((Runnable) SpriteGLView.this.f291245h.get(i3)).run();
                    }
                    SpriteGLView.this.f291245h.clear();
                }
                synchronized (SpriteGLView.this.C) {
                    for (int i16 = 0; i16 < SpriteGLView.this.f291247m.size(); i16++) {
                        ((Runnable) SpriteGLView.this.f291247m.get(i16)).run();
                    }
                }
                GLES20.glClear(16640);
                for (Object obj : SpriteGLView.this.f291244f.toArray()) {
                    if (obj instanceof d) {
                        GLES20.glEnable(3042);
                        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
                        GLES20.glUseProgram(SpriteGLView.this.I);
                        ((d) obj).A(SpriteGLView.this.getWidth(), SpriteGLView.this.getHeight(), this.f291251h, this.f291253m, this.f291252i, this.C, this.D, this.f291250f);
                    }
                }
                if (SpriteGLView.this.G) {
                    int i17 = this.F + 1;
                    this.F = i17;
                    if (i17 >= 5) {
                        String format = String.format("fps: %.1f", Float.valueOf((this.F * 1000.0f) / ((int) (System.currentTimeMillis() - this.E))));
                        this.E = System.currentTimeMillis();
                        this.F = 0;
                        this.G.L(SpriteGLView.this, format);
                    }
                    GLES20.glUseProgram(SpriteGLView.this.I);
                    this.G.A(SpriteGLView.this.getWidth(), SpriteGLView.this.getHeight(), this.f291251h, this.f291253m, this.f291252i, this.C, this.D, this.f291250f);
                }
                GLES20.glFlush();
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gl10);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, gl10, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            float f16 = i3 / i16;
            Matrix.frustumM(this.f291248d, 0, -f16, f16, -1.0f, 1.0f, 3.0f, 7.0f);
            Matrix.setLookAtM(this.f291249e, 0, 0.0f, 0.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.f291250f, 0, this.f291248d, 0, this.f291249e, 0);
            this.G.f291153h = x.c(SpriteGLView.this.getContext(), 50.0f) - (i3 / 2);
            this.G.f291154i = x.c(SpriteGLView.this.getContext(), 10.0f) - (i16 / 2);
            GLES20.glViewport(0, 0, i3, i16);
            SpriteGLView.this.q();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gl10, (Object) eGLConfig);
                return;
            }
            try {
                SpriteGLView spriteGLView = SpriteGLView.this;
                Context context = spriteGLView.getContext();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("troop");
                String str = File.separator;
                sb5.append(str);
                sb5.append("shaders");
                sb5.append(str);
                sb5.append("VertexShader.glsl");
                spriteGLView.I = com.tencent.mobileqq.surfaceviewaction.util.a.a(com.tencent.mobileqq.surfaceviewaction.util.a.c(context, sb5.toString()), com.tencent.mobileqq.surfaceviewaction.util.a.c(SpriteGLView.this.getContext(), "troop" + str + "shaders" + str + "FragmentShader.glsl"));
                GLES20.glUseProgram(SpriteGLView.this.I);
                this.f291251h = GLES20.glGetAttribLocation(SpriteGLView.this.I, "vPosition");
                this.f291253m = GLES20.glGetAttribLocation(SpriteGLView.this.I, "a_texCoord");
                this.f291252i = GLES20.glGetUniformLocation(SpriteGLView.this.I, "uMVPMatrix");
                this.C = GLES20.glGetUniformLocation(SpriteGLView.this.I, "s_texture");
                this.D = GLES20.glGetUniformLocation(SpriteGLView.this.I, "v_alpha");
            } catch (Exception e16) {
                QLog.e("SpriteGLView", 2, QLog.getStackTraceString(e16));
            }
            QLog.i("SpriteGLView", 1, "program = " + SpriteGLView.this.I + ",mPositionHandle =" + this.f291251h + ",mTexCoordHandle =" + this.f291253m + ",mMatrixHandle= " + this.f291252i + ",mTexSamplerHandle =" + this.C + ",mAlphaHandle = " + this.D);
            SpriteGLView spriteGLView2 = SpriteGLView.this;
            this.G = new com.tencent.mobileqq.surfaceviewaction.gl.b(spriteGLView2, spriteGLView2.getContext(), "fps:", -1, 40);
            SpriteGLView.this.F = System.currentTimeMillis();
        }
    }

    public SpriteGLView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f291242d = 0;
        this.f291243e = new LinkedList<>();
        this.f291244f = Collections.synchronizedList(new ArrayList());
        this.f291245h = new LinkedList();
        this.f291246i = new Object();
        this.f291247m = new ArrayList();
        this.C = new Object();
        this.G = false;
        this.H = false;
        o();
    }

    private void o() {
        if (this.f291242d == 0) {
            GLSurfaceView gLSurfaceView = new GLSurfaceView(getContext());
            this.D = gLSurfaceView;
            addView(gLSurfaceView, -1, -1);
            gLSurfaceView.setEGLContextClientVersion(2);
            gLSurfaceView.getHolder().setFormat(-3);
            gLSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            gLSurfaceView.setRenderer(new b());
            gLSurfaceView.setZOrderOnTop(true);
        } else {
            GLTextureView l3 = l(getContext());
            this.D = l3;
            addView(l3, -1, -1);
            l3.setRenderer(new b());
        }
        setFocusableInTouchMode(true);
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.e
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        a aVar = this.E;
        if (aVar != null) {
            return aVar.getCurrentTime();
        }
        return (int) (System.currentTimeMillis() - this.F);
    }

    public void h(int i3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) dVar);
            return;
        }
        synchronized (this.f291244f) {
            if (!this.f291244f.contains(dVar)) {
                this.f291244f.add(i3, dVar);
            }
        }
    }

    public void i(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) dVar);
            return;
        }
        synchronized (this.f291244f) {
            if (!this.f291244f.contains(dVar)) {
                this.f291244f.add(dVar);
            }
        }
    }

    public void j(GLTextureView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        View view = this.D;
        if (view instanceof GLTextureView) {
            ((GLTextureView) view).o(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i3) {
        synchronized (this.f291243e) {
            this.f291243e.add(Integer.valueOf(i3));
        }
    }

    protected GLTextureView l(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GLTextureView) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        return new GLTextureView(context);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        synchronized (this.f291243e) {
            int size = this.f291243e.size();
            int[] iArr = new int[size];
            int i3 = 0;
            while (!this.f291243e.isEmpty()) {
                iArr[i3] = this.f291243e.remove(0).intValue();
                i3++;
            }
            GLES20.glDeleteTextures(size, iArr, 0);
        }
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        synchronized (this.f291243e) {
            int i16 = 0;
            while (true) {
                if (i16 < this.f291243e.size()) {
                    if (i3 == this.f291243e.get(i16).intValue()) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 > 0) {
                this.f291243e.remove(i16);
                GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Object[] array = this.f291244f.toArray();
        for (int length = array.length - 1; length >= 0; length--) {
            Object obj = array[length];
            if ((obj instanceof d.a) && ((d.a) obj).c(motionEvent, getWidth(), getHeight())) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.f291244f.isEmpty();
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        Iterator<com.tencent.mobileqq.surfaceviewaction.a> it = this.f291244f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).B();
        }
    }

    public void r(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) dVar);
            return;
        }
        if (dVar.k()) {
            dVar.m();
        }
        this.f291244f.remove(dVar);
    }

    public void s(GLTextureView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        View view = this.D;
        if (view instanceof GLTextureView) {
            ((GLTextureView) view).x(aVar);
        }
    }

    public void setFps(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        View view = this.D;
        if (view instanceof GLTextureView) {
            ((GLTextureView) view).setFps(i3);
        }
    }

    public void setRetainBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.J = z16;
        }
    }

    public void setVideoTimeGetter(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar);
        } else {
            this.E = aVar;
        }
    }

    public void t(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this.f291246i) {
            this.f291245h.add(runnable);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpriteGLView", 2, "stopDraw");
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SpriteGLView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SpriteGLView.this.m();
                for (Object obj : SpriteGLView.this.f291244f.toArray()) {
                    if (obj instanceof d) {
                        ((d) obj).m();
                    }
                }
                SpriteGLView.this.f291244f.clear();
            }
        };
        View view = this.D;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
            ((GLSurfaceView) this.D).queueEvent(runnable);
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).w(runnable);
        }
    }

    public SpriteGLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f291242d = 0;
        this.f291243e = new LinkedList<>();
        this.f291244f = Collections.synchronizedList(new ArrayList());
        this.f291245h = new LinkedList();
        this.f291246i = new Object();
        this.f291247m = new ArrayList();
        this.C = new Object();
        this.G = false;
        this.H = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SpriteGLView, 0, 0);
        try {
            this.f291242d = obtainStyledAttributes.getInt(R.styleable.SpriteGLView_viewMode, 0);
            obtainStyledAttributes.recycle();
            o();
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    public SpriteGLView(Context context, int i3) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, i3);
            return;
        }
        this.f291242d = 0;
        this.f291243e = new LinkedList<>();
        this.f291244f = Collections.synchronizedList(new ArrayList());
        this.f291245h = new LinkedList();
        this.f291246i = new Object();
        this.f291247m = new ArrayList();
        this.C = new Object();
        this.G = false;
        this.H = false;
        this.f291242d = i3;
        o();
    }
}
