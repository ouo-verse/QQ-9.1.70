package com.tencent.mobileqq.icgame.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.qqlive.view.a;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* loaded from: classes15.dex */
public class TPTextureView extends TextureView implements com.tencent.mobileqq.qqlive.view.a {
    private int C;
    private int D;
    private TextureView.SurfaceTextureListener E;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC8403a f237822d;

    /* renamed from: e, reason: collision with root package name */
    private int f237823e;

    /* renamed from: f, reason: collision with root package name */
    private int f237824f;

    /* renamed from: h, reason: collision with root package name */
    private int f237825h;

    /* renamed from: i, reason: collision with root package name */
    private int f237826i;

    /* renamed from: m, reason: collision with root package name */
    private float f237827m;

    /* loaded from: classes15.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            if (TPTextureView.this.f237822d != null) {
                TPTextureView.this.f237822d.onViewCreated(surfaceTexture, i3, i16);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (TPTextureView.this.f237822d != null) {
                TPTextureView.this.f237822d.onViewDestroyed(surfaceTexture);
                return false;
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            if (TPTextureView.this.f237822d != null) {
                TPTextureView.this.f237822d.onViewChanged(surfaceTexture, i3, i16);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (TPTextureView.this.f237822d != null) {
                TPTextureView.this.f237822d.onViewChanged(surfaceTexture, TPTextureView.this.getWidth(), TPTextureView.this.getHeight());
            }
        }
    }

    public TPTextureView(Context context) {
        super(context);
        this.f237823e = 0;
        this.f237826i = 0;
        this.f237827m = 1.0f;
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
        super.onAttachedToWindow();
        Log.i("ICGameTPPlayer[TPTextureView]", NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i("ICGameTPPlayer[TPTextureView]", NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        float f16;
        float f17;
        int i19;
        Log.i("ICGameTPPlayer[TPTextureView]", "onMeasure widthMeasureSpec: " + i3 + " heightMeasureSpec:" + i16);
        Log.i("ICGameTPPlayer[TPTextureView]", "onMeasure videoWidth: " + this.f237824f + " videoHeight:" + this.f237825h);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onMeasure type: ");
        sb5.append(this.f237826i);
        Log.i("ICGameTPPlayer[TPTextureView]", sb5.toString());
        if (this.f237824f > 0 && this.f237825h > 0) {
            int defaultSize = View.getDefaultSize(getWidth(), i3);
            int defaultSize2 = View.getDefaultSize(getHeight(), i16);
            int i26 = this.f237826i;
            float f18 = 1.0f;
            if (i26 == 2) {
                int i27 = this.f237824f;
                int i28 = i27 * defaultSize2;
                int i29 = this.f237825h;
                if (i28 > defaultSize * i29) {
                    defaultSize = (i27 * defaultSize2) / i29;
                } else if (i27 * defaultSize2 < defaultSize * i29) {
                    defaultSize2 = (i29 * defaultSize) / i27;
                }
            } else if (i26 != 1) {
                if (i26 == 3) {
                    int i36 = this.f237824f;
                    int i37 = i36 * defaultSize2;
                    int i38 = this.f237825h;
                    if (i37 > defaultSize * i38) {
                        defaultSize2 = (i38 * defaultSize) / i36;
                    } else if (i36 * defaultSize2 < defaultSize * i38) {
                        defaultSize = (defaultSize2 * i36) / i38;
                        float f19 = defaultSize2;
                        f18 = f19 / ((i36 / i38) * f19);
                    }
                } else {
                    int i39 = this.f237824f;
                    int i46 = this.C;
                    if (i46 != 0 && (i19 = this.D) != 0) {
                        i39 = (int) ((i39 * i46) / i19);
                    }
                    int i47 = i39 * defaultSize2;
                    int i48 = this.f237825h;
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
                    int i49 = this.f237823e;
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
            Log.i("ICGameTPPlayer[TPTextureView]", "onMeasure radioWidth:" + this.C + " radioHeight:" + this.D);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onMeasure degree:");
            sb6.append(this.f237823e);
            Log.i("ICGameTPPlayer[TPTextureView]", sb6.toString());
            Log.i("ICGameTPPlayer[TPTextureView]", "onMeasure vScale:" + f18);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("onMeasure setMeasuredDimension: ");
            float f26 = (float) defaultSize;
            sb7.append((int) (this.f237827m * f26 * f18));
            sb7.append("  ");
            float f27 = defaultSize2;
            sb7.append((int) (this.f237827m * f27 * f18));
            Log.i("ICGameTPPlayer[TPTextureView]", sb7.toString());
            float f28 = this.f237827m;
            setMeasuredDimension((int) (f26 * f28 * f18), (int) (f27 * f28 * f18));
            return;
        }
        Log.i("ICGameTPPlayer[TPTextureView]", "onMeasure setMeasuredDimension: " + i3 + "  " + i16);
        super.onMeasure(i3, i16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public boolean setDegree(int i3) {
        setRotation(i3);
        this.f237823e = i3;
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setOpaqueInfo(boolean z16) {
        if (z16) {
            setOpaque(true);
            setAlpha(1.0f);
        } else {
            setOpaque(false);
            setAlpha(0.0f);
        }
    }

    public void setRadio(int i3, int i16) {
        this.D = i16;
        this.C = i3;
        Log.i("ICGameTPPlayer[TPTextureView]", "setRadio num: " + i3 + "  den: " + i16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setScaleParam(float f16) {
        if (f16 > 0.0f) {
            this.f237826i = 0;
            this.f237827m = f16;
        }
        Log.i("ICGameTPPlayer[TPTextureView]", "setScaleParam scale: " + f16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setVideoWidthAndHeight(int i3, int i16) {
        this.f237824f = i3;
        this.f237825h = i16;
        Log.i("ICGameTPPlayer[TPTextureView]", "setVideoWidthAndHeight width: " + i3 + "  height: " + i16);
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setViewCallBack(a.InterfaceC8403a interfaceC8403a) {
        this.f237822d = interfaceC8403a;
    }

    @Override // com.tencent.mobileqq.qqlive.view.a
    public void setXYAxis(int i3) {
        this.f237826i = i3;
        this.f237827m = 1.0f;
        Log.i("ICGameTPPlayer[TPTextureView]", "setXYAxis mXYAxis: " + i3);
    }

    public TPTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f237823e = 0;
        this.f237826i = 0;
        this.f237827m = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = new a();
        b();
    }

    public TPTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f237823e = 0;
        this.f237826i = 0;
        this.f237827m = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = new a();
        b();
    }
}
