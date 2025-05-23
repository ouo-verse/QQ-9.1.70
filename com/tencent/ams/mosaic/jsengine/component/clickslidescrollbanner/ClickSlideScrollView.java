package com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.music.widget.SensorType;
import com.tencent.ams.music.widget.ShakeScrollAndSlideWidget;
import com.tencent.ams.music.widget.ShakeScrollConfig;
import com.tencent.ams.music.widget.ShakeScrollView;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickSlideScrollView extends FrameLayout implements OnActivityLifecycleChanged.OnActivityLifecycleChangedListener {
    static IPatchRedirector $redirector_;
    private Bitmap C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private float K;
    private float L;
    private volatile boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private ShakeScrollView.ShakeScrollListener T;

    /* renamed from: d, reason: collision with root package name */
    private ShakeScrollAndSlideWidget f71000d;

    /* renamed from: e, reason: collision with root package name */
    private final SlideGestureViewHelper f71001e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private f.c f71002f;

    /* renamed from: h, reason: collision with root package name */
    private int f71003h;

    /* renamed from: i, reason: collision with root package name */
    private String f71004i;

    /* renamed from: m, reason: collision with root package name */
    private String f71005m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.c.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClickSlideScrollView.this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "onLoadFinish, object: " + obj);
            if (obj instanceof Bitmap) {
                ClickSlideScrollView.this.C = (Bitmap) obj;
            } else if (obj instanceof BitmapDrawable) {
                ClickSlideScrollView.this.C = ((BitmapDrawable) obj).getBitmap();
            } else if (obj instanceof Drawable) {
                Drawable drawable = (Drawable) obj;
                Rect copyBounds = drawable.copyBounds();
                Bitmap createBitmap = Bitmap.createBitmap(copyBounds.width(), copyBounds.height(), Bitmap.Config.ARGB_4444);
                drawable.draw(new Canvas(createBitmap));
                ClickSlideScrollView.this.C = createBitmap;
            }
            ClickSlideScrollView.this.N = false;
            if (ClickSlideScrollView.this.M) {
                ClickSlideScrollView.this.e();
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", HippyQQPagView.EventName.ON_LOAD_START);
            }
        }
    }

    public ClickSlideScrollView(@NonNull Context context) {
        this(context, f.k().j());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        boolean z16;
        boolean z17;
        com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "build");
        if (this.f71000d != null) {
            return;
        }
        this.M = true;
        if (!this.N && !this.R && this.P) {
            Context context = getContext();
            ShakeScrollConfig shakeScrollConfig = new ShakeScrollConfig();
            shakeScrollConfig.setBackgroundHighLightColor(this.f71003h);
            shakeScrollConfig.setScrollTotalTime(this.F);
            shakeScrollConfig.setShakeScrollGuideIconType(2);
            shakeScrollConfig.setSensorType(SensorType.MIX);
            shakeScrollConfig.setEnableOrientationInitDegreeProtect(true);
            shakeScrollConfig.setEnableOrientationMinXProtect(true);
            shakeScrollConfig.setEnableOrientationMinYProtect(true);
            shakeScrollConfig.setMainContent(this.f71004i);
            shakeScrollConfig.setSubContent(this.f71005m);
            shakeScrollConfig.setInvokeJumpType(this.H);
            shakeScrollConfig.setDegreeA(this.D);
            shakeScrollConfig.setDegreeB(this.E);
            shakeScrollConfig.setScrollIcon(this.C);
            shakeScrollConfig.setArrowHeight((int) MosaicUtils.n(context, 48));
            shakeScrollConfig.setArrowWidth((int) MosaicUtils.n(context, 30));
            shakeScrollConfig.setArrowMargin((int) MosaicUtils.n(context, 30));
            int j3 = (int) MosaicUtils.j(this.I);
            int j16 = (int) MosaicUtils.j(this.J);
            shakeScrollConfig.setButtonRightMargin(j16);
            shakeScrollConfig.setButtonLeftMargin(j3);
            shakeScrollConfig.setButtonBottomMargin((int) MosaicUtils.j(this.K));
            if (this.G == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            shakeScrollConfig.setNeedShowArrow(z16);
            int measuredWidth = (getMeasuredWidth() - j16) - j3;
            com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "widget width: " + measuredWidth);
            shakeScrollConfig.setWidgetWidth(measuredWidth);
            if (!this.S) {
                z17 = true;
            } else {
                z17 = false;
            }
            shakeScrollConfig.setUseDefaultSlideAnimator(z17);
            shakeScrollConfig.setScrollButtonHeight((int) MosaicUtils.j(this.L));
            ShakeScrollAndSlideWidget shakeScrollAndSlideWidget = new ShakeScrollAndSlideWidget(context, shakeScrollConfig);
            this.f71000d = shakeScrollAndSlideWidget;
            shakeScrollAndSlideWidget.setShakeScrollListener(this.T);
            this.f71001e.setGestureClickView(shakeScrollAndSlideWidget.getButtonView());
            post(new Runnable(shakeScrollAndSlideWidget) { // from class: com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollView.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ShakeScrollAndSlideWidget f71007d;

                {
                    this.f71007d = shakeScrollAndSlideWidget;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClickSlideScrollView.this, (Object) shakeScrollAndSlideWidget);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "add scrollView");
                        ClickSlideScrollView.this.addView((View) this.f71007d, 0, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -1));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f16) {
        this.K = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f16) {
        this.L = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f16) {
        this.I = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(float f16) {
        this.J = f16;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "start");
        this.Q = true;
        this.R = false;
        if (!this.M) {
            e();
            return;
        }
        ShakeScrollAndSlideWidget shakeScrollAndSlideWidget = this.f71000d;
        if (shakeScrollAndSlideWidget != null) {
            shakeScrollAndSlideWidget.resume();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "stop");
        this.R = true;
        ShakeScrollAndSlideWidget shakeScrollAndSlideWidget = this.f71000d;
        if (shakeScrollAndSlideWidget != null) {
            shakeScrollAndSlideWidget.pause();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f71001e.onAttachedToWindow();
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged.OnActivityLifecycleChangedListener
    public void onChanged(int i3) {
        ShakeScrollAndSlideWidget shakeScrollAndSlideWidget;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "onChanged, status: " + i3);
        if (i3 == 3) {
            ShakeScrollAndSlideWidget shakeScrollAndSlideWidget2 = this.f71000d;
            if (shakeScrollAndSlideWidget2 != null) {
                shakeScrollAndSlideWidget2.pause();
                return;
            }
            return;
        }
        if (i3 == 4) {
            ShakeScrollAndSlideWidget shakeScrollAndSlideWidget3 = this.f71000d;
            if (shakeScrollAndSlideWidget3 != null && !this.R && this.Q) {
                shakeScrollAndSlideWidget3.resume();
                return;
            }
            return;
        }
        if (i3 == 6 && (shakeScrollAndSlideWidget = this.f71000d) != null) {
            shakeScrollAndSlideWidget.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.f71001e.onDetachedFromWindow();
        ShakeScrollAndSlideWidget shakeScrollAndSlideWidget = this.f71000d;
        if (shakeScrollAndSlideWidget != null) {
            shakeScrollAndSlideWidget.destroy();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "onLayout, changed: " + z16 + ", left: " + i3 + ", top: " + i16 + ", right: " + i17 + ", bottom: " + i18);
        super.onLayout(z16, i3, i16, i17, i18);
        this.P = true;
        if (this.M) {
            e();
        }
    }

    public void setBackgroundHighLightColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            try {
                this.f71003h = Color.parseColor(str);
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.c("ClickSlideScrollView", "parse background highlight color error.", th5);
            }
        }
    }

    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f71001e.setGestureClickHotArea((int) MosaicUtils.j(i3), (int) MosaicUtils.j(i16), (int) MosaicUtils.j(i17), (int) MosaicUtils.j(i18));
        }
    }

    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f71001e.setGestureColor(str);
        }
    }

    public void setGestureListener(SlideGestureViewHelper.ISlideGestureListener iSlideGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iSlideGestureListener);
        } else {
            this.f71001e.setSlideGestureListener(iSlideGestureListener);
        }
    }

    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f71001e.setGestureHotArea((int) MosaicUtils.j(i3), (int) MosaicUtils.j(i16), (int) MosaicUtils.j(i17), (int) MosaicUtils.j(i18));
        }
    }

    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f71001e.setGestureSlideValidHeightDp(i3);
        }
    }

    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f71001e.setGestureStrokeWidthDp(i3);
        }
    }

    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f71001e.setGestureVisible(z16);
        }
    }

    public void setHideClickSlideGuideAnim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.S = z16;
        }
    }

    public void setImageLoader(@NonNull f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.f71002f = cVar;
        }
    }

    public void setInteractionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void setMainTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f71004i = str;
        }
    }

    public void setScrollAroundAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void setScrollBarRightGuideType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void setScrollIcon(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.N = true;
            this.f71002f.loadImage(str, new a());
        }
    }

    public void setScrollIconBase64(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.N = true;
            MosaicUtils.F(new Runnable(str) { // from class: com.tencent.ams.mosaic.jsengine.component.clickslidescrollbanner.ClickSlideScrollView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f71006d;

                {
                    this.f71006d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ClickSlideScrollView.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.ams.mosaic.utils.f.e("ClickSlideScrollView", "decode base64 image.");
                    float n3 = (int) MosaicUtils.n(ClickSlideScrollView.this.getContext(), 134);
                    ClickSlideScrollView.this.C = MosaicUtils.d(this.f71006d, n3, n3);
                    ClickSlideScrollView.this.N = false;
                    if (ClickSlideScrollView.this.M) {
                        ClickSlideScrollView.this.e();
                    }
                }
            });
        }
    }

    public void setScrollTotalTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }

    public void setShakeScrollListener(ShakeScrollView.ShakeScrollListener shakeScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) shakeScrollListener);
            return;
        }
        this.T = shakeScrollListener;
        ShakeScrollAndSlideWidget shakeScrollAndSlideWidget = this.f71000d;
        if (shakeScrollAndSlideWidget != null) {
            shakeScrollAndSlideWidget.setShakeScrollListener(shakeScrollListener);
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.f71005m = str;
        }
    }

    public void setTriggerAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.D = i3;
        }
    }

    public ClickSlideScrollView(@NonNull Context context, @NonNull f.c cVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) cVar);
            return;
        }
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.f71001e = new SlideGestureViewHelper(context, this);
        OnActivityLifecycleChanged.addListener(context, this);
        this.f71002f = cVar;
    }
}
