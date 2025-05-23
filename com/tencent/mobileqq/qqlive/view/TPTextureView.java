package com.tencent.mobileqq.qqlive.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.view.a;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* loaded from: classes17.dex */
public class TPTextureView extends TextureView implements com.tencent.mobileqq.qqlive.view.a {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private TextureView.SurfaceTextureListener E;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC8403a f273478d;

    /* renamed from: e, reason: collision with root package name */
    private int f273479e;

    /* renamed from: f, reason: collision with root package name */
    private int f273480f;

    /* renamed from: h, reason: collision with root package name */
    private int f273481h;

    /* renamed from: i, reason: collision with root package name */
    private int f273482i;

    /* renamed from: m, reason: collision with root package name */
    private float f273483m;

    /* loaded from: classes17.dex */
    class a implements TextureView.SurfaceTextureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TPTextureView.this);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (TPTextureView.this.f273478d != null) {
                TPTextureView.this.f273478d.onViewCreated(surfaceTexture, i3, i16);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceTexture)).booleanValue();
            }
            if (TPTextureView.this.f273478d != null) {
                TPTextureView.this.f273478d.onViewDestroyed(surfaceTexture);
                return false;
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (TPTextureView.this.f273478d != null) {
                TPTextureView.this.f273478d.onViewChanged(surfaceTexture, i3, i16);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceTexture);
            } else if (TPTextureView.this.f273478d != null) {
                TPTextureView.this.f273478d.onViewChanged(surfaceTexture, TPTextureView.this.getWidth(), TPTextureView.this.getHeight());
            }
        }
    }

    public TPTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f273479e = 0;
        this.f273482i = 0;
        this.f273483m = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = new a();
        b();
    }

    private void b() {
        setScaleX(1.0001f);
        setScaleY(1.0001f);
        setSurfaceTextureListener(this.E);
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onAttachedToWindow();
            Log.i("TPPlayer[TPTextureView]", NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onDetachedFromWindow();
            Log.i("TPPlayer[TPTextureView]", NodeProps.ON_DETACHED_FROM_WINDOW);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        float f16;
        float f17;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Log.i("TPPlayer[TPTextureView]", "onMeasure widthMeasureSpec: " + i3 + " heightMeasureSpec:" + i16);
        Log.i("TPPlayer[TPTextureView]", "onMeasure videoWidth: " + this.f273480f + " videoHeight:" + this.f273481h);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onMeasure type: ");
        sb5.append(this.f273482i);
        Log.i("TPPlayer[TPTextureView]", sb5.toString());
        if (this.f273480f > 0 && this.f273481h > 0) {
            int defaultSize = View.getDefaultSize(getWidth(), i3);
            int defaultSize2 = View.getDefaultSize(getHeight(), i16);
            int i26 = this.f273482i;
            float f18 = 1.0f;
            if (i26 == 2) {
                int i27 = this.f273480f;
                int i28 = i27 * defaultSize2;
                int i29 = this.f273481h;
                if (i28 > defaultSize * i29) {
                    defaultSize = (i27 * defaultSize2) / i29;
                } else if (i27 * defaultSize2 < defaultSize * i29) {
                    defaultSize2 = (i29 * defaultSize) / i27;
                }
            } else if (i26 != 1) {
                if (i26 == 3) {
                    int i36 = this.f273480f;
                    int i37 = i36 * defaultSize2;
                    int i38 = this.f273481h;
                    if (i37 > defaultSize * i38) {
                        defaultSize2 = (i38 * defaultSize) / i36;
                    } else if (i36 * defaultSize2 < defaultSize * i38) {
                        defaultSize = (defaultSize2 * i36) / i38;
                        float f19 = defaultSize2;
                        f18 = f19 / ((i36 / i38) * f19);
                    }
                } else {
                    int i39 = this.f273480f;
                    int i46 = this.C;
                    if (i46 != 0 && (i19 = this.D) != 0) {
                        i39 = (int) ((i39 * i46) / i19);
                    }
                    int i47 = i39 * defaultSize2;
                    int i48 = this.f273481h;
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
                    int i49 = this.f273479e;
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
            Log.i("TPPlayer[TPTextureView]", "onMeasure radioWidth:" + this.C + " radioHeight:" + this.D);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onMeasure degree:");
            sb6.append(this.f273479e);
            Log.i("TPPlayer[TPTextureView]", sb6.toString());
            Log.i("TPPlayer[TPTextureView]", "onMeasure vScale:" + f18);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("onMeasure setMeasuredDimension: ");
            float f26 = (float) defaultSize;
            sb7.append((int) (this.f273483m * f26 * f18));
            sb7.append("  ");
            float f27 = defaultSize2;
            sb7.append((int) (this.f273483m * f27 * f18));
            Log.i("TPPlayer[TPTextureView]", sb7.toString());
            float f28 = this.f273483m;
            setMeasuredDimension((int) (f26 * f28 * f18), (int) (f27 * f28 * f18));
            return;
        }
        Log.i("TPPlayer[TPTextureView]", "onMeasure setMeasuredDimension: " + i3 + "  " + i16);
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public boolean setDegree(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        setRotation(i3);
        this.f273479e = i3;
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setOpaqueInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else if (z16) {
            setOpaque(true);
            setAlpha(1.0f);
        } else {
            setOpaque(false);
            setAlpha(0.0f);
        }
    }

    public void setRadio(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.D = i16;
        this.C = i3;
        Log.i("TPPlayer[TPTextureView]", "setRadio num: " + i3 + "  den: " + i16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setScaleParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        if (f16 > 0.0f) {
            this.f273482i = 0;
            this.f273483m = f16;
        }
        Log.i("TPPlayer[TPTextureView]", "setScaleParam scale: " + f16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setVideoWidthAndHeight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f273480f = i3;
        this.f273481h = i16;
        Log.i("TPPlayer[TPTextureView]", "setVideoWidthAndHeight width: " + i3 + "  height: " + i16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setViewCallBack(a.InterfaceC8403a interfaceC8403a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC8403a);
        } else {
            this.f273478d = interfaceC8403a;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setXYAxis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f273482i = i3;
        this.f273483m = 1.0f;
        Log.i("TPPlayer[TPTextureView]", "setXYAxis mXYAxis: " + i3);
    }

    public TPTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f273479e = 0;
        this.f273482i = 0;
        this.f273483m = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = new a();
        b();
    }

    public TPTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f273479e = 0;
        this.f273482i = 0;
        this.f273483m = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = new a();
        b();
    }
}
