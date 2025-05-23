package com.tencent.mobileqq.qqlive.view;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.view.a;
import com.tencent.mobileqq.widget.az;

/* loaded from: classes17.dex */
public class TPSurfaceView extends SurfaceView implements com.tencent.mobileqq.qqlive.view.a {
    static IPatchRedirector $redirector_;
    private int C;
    private float D;
    private SurfaceHolder.Callback E;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC8403a f273471d;

    /* renamed from: e, reason: collision with root package name */
    private int f273472e;

    /* renamed from: f, reason: collision with root package name */
    private int f273473f;

    /* renamed from: h, reason: collision with root package name */
    private int f273474h;

    /* renamed from: i, reason: collision with root package name */
    private int f273475i;

    /* renamed from: m, reason: collision with root package name */
    private int f273476m;

    /* loaded from: classes17.dex */
    class a implements SurfaceHolder.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TPSurfaceView.this);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else if (TPSurfaceView.this.f273471d != null) {
                TPSurfaceView.this.f273471d.onViewChanged(surfaceHolder, TPSurfaceView.this.getWidth(), TPSurfaceView.this.getHeight());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceHolder);
            } else if (TPSurfaceView.this.f273471d != null) {
                TPSurfaceView.this.f273471d.onViewCreated(surfaceHolder, TPSurfaceView.this.getWidth(), TPSurfaceView.this.getHeight());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceHolder);
            } else if (TPSurfaceView.this.f273471d != null) {
                TPSurfaceView.this.f273471d.onViewDestroyed(surfaceHolder);
            }
        }
    }

    public TPSurfaceView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f273472e = 0;
        this.f273475i = 0;
        this.f273476m = 0;
        this.C = 0;
        this.D = 1.0f;
        this.E = new a();
        c();
    }

    private void b(int i3, int i16) {
        int i17;
        int i18;
        float f16;
        float f17;
        int i19;
        int defaultSize = View.getDefaultSize(getWidth(), i3);
        int defaultSize2 = View.getDefaultSize(getHeight(), i16);
        int i26 = this.f273475i;
        float f18 = 1.0f;
        if (i26 == 2) {
            int i27 = this.f273473f;
            int i28 = i27 * defaultSize2;
            int i29 = this.f273474h;
            if (i28 > defaultSize * i29) {
                defaultSize = (i27 * defaultSize2) / i29;
            } else if (i27 * defaultSize2 < defaultSize * i29) {
                defaultSize2 = (i29 * defaultSize) / i27;
            }
        } else if (i26 != 1) {
            if (i26 == 3) {
                int i36 = this.f273473f;
                int i37 = i36 * defaultSize2;
                int i38 = this.f273474h;
                if (i37 > defaultSize * i38) {
                    defaultSize2 = (i38 * defaultSize) / i36;
                } else if (i36 * defaultSize2 < defaultSize * i38) {
                    defaultSize = (defaultSize2 * i36) / i38;
                    float f19 = defaultSize2;
                    f18 = f19 / ((i36 / i38) * f19);
                }
            } else {
                int i39 = this.f273473f;
                int i46 = this.f273476m;
                if (i46 != 0 && (i19 = this.C) != 0) {
                    i39 = (int) ((i39 * i46) / i19);
                }
                int i47 = i39 * defaultSize2;
                int i48 = this.f273474h;
                if (i47 > defaultSize * i48) {
                    i18 = (i48 * defaultSize) / i39;
                    i17 = defaultSize;
                } else {
                    if (i47 < defaultSize * i48) {
                        i17 = i47 / i48;
                    } else {
                        i17 = defaultSize;
                    }
                    i18 = defaultSize2;
                }
                int i49 = this.f273472e;
                if ((i49 == 90 || i49 == 270) && i18 > 0 && i17 > 0) {
                    if (defaultSize / i18 < defaultSize2 / i17) {
                        f16 = defaultSize;
                        f17 = i18;
                    } else {
                        f16 = defaultSize2;
                        f17 = i17;
                    }
                    f18 = f16 / f17;
                }
                defaultSize = i17;
                defaultSize2 = i18;
            }
        }
        if ((getContext() instanceof Activity) && az.e((Activity) getContext())) {
            defaultSize2 -= az.c(getContext());
        }
        float f26 = this.D;
        setMeasuredDimension((int) (defaultSize * f26 * f18), (int) (defaultSize2 * f26 * f18));
    }

    private void c() {
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        this.D = 1.0f;
        this.f273475i = 0;
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
        getHolder().addCallback(this.E);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.f273473f > 0 && this.f273474h > 0) {
            b(i3, i16);
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public boolean setDegree(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        setRotation(i3);
        this.f273472e = i3;
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setOpaqueInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
    }

    public void setRadio(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f273476m = i3;
            this.C = i16;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setScaleParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else if (f16 > 0.0f) {
            this.f273475i = 0;
            this.D = f16;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setVideoWidthAndHeight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f273473f = i3;
            this.f273474h = i16;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setViewCallBack(a.InterfaceC8403a interfaceC8403a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) interfaceC8403a);
        } else {
            this.f273471d = interfaceC8403a;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setXYAxis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f273475i = i3;
            this.D = 1.0f;
        }
    }

    public TPSurfaceView(Context context, boolean z16, boolean z17) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f273472e = 0;
        this.f273475i = 0;
        this.f273476m = 0;
        this.C = 0;
        this.D = 1.0f;
        this.E = new a();
        if (z16) {
            setZOrderOnTop(z16);
        }
        if (z17) {
            setZOrderMediaOverlay(z17);
        }
        c();
    }
}
