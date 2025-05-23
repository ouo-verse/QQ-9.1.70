package com.tencent.mobileqq.icgame.view;

import android.app.Activity;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.mobileqq.qqlive.view.a;
import com.tencent.mobileqq.widget.az;

/* loaded from: classes15.dex */
public class TPSurfaceView extends SurfaceView implements com.tencent.mobileqq.qqlive.view.a {
    private int C;
    private float D;
    private SurfaceHolder.Callback E;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC8403a f237815d;

    /* renamed from: e, reason: collision with root package name */
    private int f237816e;

    /* renamed from: f, reason: collision with root package name */
    private int f237817f;

    /* renamed from: h, reason: collision with root package name */
    private int f237818h;

    /* renamed from: i, reason: collision with root package name */
    private int f237819i;

    /* renamed from: m, reason: collision with root package name */
    private int f237820m;

    /* loaded from: classes15.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            if (TPSurfaceView.this.f237815d != null) {
                TPSurfaceView.this.f237815d.onViewChanged(surfaceHolder, TPSurfaceView.this.getWidth(), TPSurfaceView.this.getHeight());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (TPSurfaceView.this.f237815d != null) {
                TPSurfaceView.this.f237815d.onViewCreated(surfaceHolder, TPSurfaceView.this.getWidth(), TPSurfaceView.this.getHeight());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (TPSurfaceView.this.f237815d != null) {
                TPSurfaceView.this.f237815d.onViewDestroyed(surfaceHolder);
            }
        }
    }

    public TPSurfaceView(Context context) {
        super(context);
        this.f237816e = 0;
        this.f237819i = 0;
        this.f237820m = 0;
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
        int i26 = this.f237819i;
        float f18 = 1.0f;
        if (i26 == 2) {
            int i27 = this.f237817f;
            int i28 = i27 * defaultSize2;
            int i29 = this.f237818h;
            if (i28 > defaultSize * i29) {
                defaultSize = (i27 * defaultSize2) / i29;
            } else if (i27 * defaultSize2 < defaultSize * i29) {
                defaultSize2 = (i29 * defaultSize) / i27;
            }
        } else if (i26 != 1) {
            if (i26 == 3) {
                int i36 = this.f237817f;
                int i37 = i36 * defaultSize2;
                int i38 = this.f237818h;
                if (i37 > defaultSize * i38) {
                    defaultSize2 = (i38 * defaultSize) / i36;
                } else if (i36 * defaultSize2 < defaultSize * i38) {
                    defaultSize = (defaultSize2 * i36) / i38;
                    float f19 = defaultSize2;
                    f18 = f19 / ((i36 / i38) * f19);
                }
            } else {
                int i39 = this.f237817f;
                int i46 = this.f237820m;
                if (i46 != 0 && (i19 = this.C) != 0) {
                    i39 = (int) ((i39 * i46) / i19);
                }
                int i47 = i39 * defaultSize2;
                int i48 = this.f237818h;
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
                int i49 = this.f237816e;
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
        this.f237819i = 0;
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
        getHolder().addCallback(this.E);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f237817f > 0 && this.f237818h > 0) {
            b(i3, i16);
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public boolean setDegree(int i3) {
        setRotation(i3);
        this.f237816e = i3;
        return true;
    }

    public void setRadio(int i3, int i16) {
        this.f237820m = i3;
        this.C = i16;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setScaleParam(float f16) {
        if (f16 > 0.0f) {
            this.f237819i = 0;
            this.D = f16;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setVideoWidthAndHeight(int i3, int i16) {
        this.f237817f = i3;
        this.f237818h = i16;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setViewCallBack(a.InterfaceC8403a interfaceC8403a) {
        this.f237815d = interfaceC8403a;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setXYAxis(int i3) {
        this.f237819i = i3;
        this.D = 1.0f;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setOpaqueInfo(boolean z16) {
    }
}
