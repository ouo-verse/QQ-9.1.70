package com.tencent.ams.mosaic.jsengine.component.scratch;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.music.widget.scratch.ScratchCard;
import com.tencent.ams.music.widget.scratch.ScratchCardConfig;
import com.tencent.ams.music.widget.scratch.ScratchCardListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScratchCardView extends FrameLayout implements OnActivityLifecycleChanged.OnActivityLifecycleChangedListener {
    static IPatchRedirector $redirector_;
    private int C;
    private String D;
    private String E;
    private String F;
    private String G;
    private Bitmap H;
    private Bitmap I;
    private f.c J;
    private volatile boolean K;
    private volatile boolean L;
    private volatile boolean M;
    private volatile boolean N;
    private float P;
    private boolean Q;
    private ScratchCardListener R;
    private int S;

    /* renamed from: d, reason: collision with root package name */
    private ScratchCard f71251d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f71252e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f71253f;

    /* renamed from: h, reason: collision with root package name */
    private float f71254h;

    /* renamed from: i, reason: collision with root package name */
    private float f71255i;

    /* renamed from: m, reason: collision with root package name */
    private int f71256m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.d.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScratchCardView.this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "SmallCardBackgroundUrl onLoadFinish :" + obj);
            ScratchCardView.this.N = false;
            if (obj instanceof Bitmap) {
                ScratchCardView.this.H = (Bitmap) obj;
                if (ScratchCardView.this.L) {
                    ScratchCardView scratchCardView = ScratchCardView.this;
                    scratchCardView.u(scratchCardView.getContext());
                }
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements f.d.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScratchCardView.this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "SmallCardIconUrl onLoadFinish :" + obj);
            ScratchCardView.this.M = false;
            if (obj instanceof Bitmap) {
                ScratchCardView.this.I = (Bitmap) obj;
                if (ScratchCardView.this.L) {
                    ScratchCardView scratchCardView = ScratchCardView.this;
                    scratchCardView.u(scratchCardView.getContext());
                }
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public ScratchCardView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(Context context) {
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "buildWidget");
        if (this.f71251d != null) {
            com.tencent.ams.mosaic.utils.f.b("ScratchCardView ", "mScratchCardView != null");
            return;
        }
        this.L = true;
        if (!this.M && !this.N && !this.f71252e && this.K) {
            post(new Runnable(context) { // from class: com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f71257d;

                {
                    this.f71257d = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScratchCardView.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (ScratchCardView.this.f71251d != null) {
                        com.tencent.ams.mosaic.utils.f.b("ScratchCardView ", "mScratchCardView != null");
                        return;
                    }
                    ScratchCardView.this.f71251d = new ScratchCard(new ScratchCardConfig(this.f71257d).setGuideStrokeWidthDp(MosaicUtils.E(ScratchCardView.this.f71255i)).setScratchCompleteDp((int) MosaicUtils.E(ScratchCardView.this.f71256m)).setScratchStrokeWidthDp(MosaicUtils.E(ScratchCardView.this.f71254h)).setGuideAnimationTimeMills(ScratchCardView.this.C).setTitle(ScratchCardView.this.D).setSubtitle(ScratchCardView.this.E).setSmallCardTitle(ScratchCardView.this.F).setSmallCardSubtitle(ScratchCardView.this.G).setSmallCardBackgroundImgBitmap(ScratchCardView.this.H).setSmallCardIconImgBitmap(ScratchCardView.this.I).setLogProxy(new com.tencent.ams.mosaic.jsengine.component.scratch.b()).setCardListener(ScratchCardView.this.R));
                    com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "add ScratchCardView");
                    int j3 = (int) MosaicUtils.j(261.0f);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(j3, (int) (j3 * 0.726f));
                    layoutParams.gravity = 81;
                    layoutParams.bottomMargin = (int) (((int) MosaicUtils.j(32.0f)) + ScratchCardView.this.P);
                    ScratchCardView scratchCardView = ScratchCardView.this;
                    scratchCardView.addView((View) scratchCardView.f71251d, 0, (ViewGroup.LayoutParams) layoutParams);
                }
            });
            return;
        }
        com.tencent.ams.mosaic.utils.f.b("ScratchCardView ", "not ready " + this.K + " mIconIsLoading:" + this.M + " mBgImgIsLoading:" + this.N);
    }

    @Override // com.tencent.ams.fusion.widget.utils.OnActivityLifecycleChanged.OnActivityLifecycleChangedListener
    public void onChanged(int i3) {
        ScratchCard scratchCard;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "onChanged, status: " + i3);
        if (i3 == 3) {
            ScratchCard scratchCard2 = this.f71251d;
            if (scratchCard2 != null) {
                scratchCard2.pause();
                return;
            }
            return;
        }
        if (i3 == 4) {
            if (this.f71251d != null && !this.f71252e && this.f71253f) {
                this.f71251d.resume();
                return;
            }
            return;
        }
        if (i3 == 6 && (scratchCard = this.f71251d) != null) {
            scratchCard.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", NodeProps.ON_DETACHED_FROM_WINDOW);
        ScratchCard scratchCard = this.f71251d;
        if (scratchCard != null) {
            scratchCard.destroy();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "onLayout, changed: " + z16 + ", left: " + i3 + ", top: " + i16 + ", right: " + i17 + ", bottom: " + i18);
        super.onLayout(z16, i3, i16, i17, i18);
        this.K = true;
        if (this.L) {
            u(getContext());
        }
    }

    public void setBottomPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setBottomPadding :" + f16);
        this.P = f16;
    }

    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setGestureSlideValidHeight :" + i3);
        this.f71256m = i3;
    }

    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setGestureStrokeWidth :" + i3);
        this.f71254h = (float) i3;
    }

    public void setGuideAnimationTimeMillis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setGuideAnimationTimeMillis :" + i3);
        this.C = i3;
    }

    public void setGuideStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setGuideStrokeWidth :" + i3);
        this.f71255i = (float) i3;
    }

    public void setImageLoader(f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        } else {
            this.J = cVar;
        }
    }

    public void setListener(ScratchCardListener scratchCardListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) scratchCardListener);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setListener :" + scratchCardListener);
        this.R = scratchCardListener;
    }

    public void setRewardDisplayType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setRewardDisplayType :" + i3);
        this.S = i3;
    }

    public void setRewardSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setRewardSubTitle :" + str);
        this.G = str;
    }

    public void setRewardTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setRewardTitle :" + str);
        this.F = str;
    }

    public void setSmallCardBackgroundUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setSmallCardBackgroundUrl :" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f.c cVar = this.J;
        if (!(cVar instanceof f.d)) {
            com.tencent.ams.mosaic.utils.f.b("ScratchCardView ", "imageLoader is null");
        } else {
            this.N = true;
            ((f.d) cVar).a(str, new a());
        }
    }

    public void setSmallCardIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setSmallCardIconUrl :" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f.c cVar = this.J;
        if (!(cVar instanceof f.d)) {
            com.tencent.ams.mosaic.utils.f.b("ScratchCardView ", "imageLoader is null");
        } else {
            this.M = true;
            ((f.d) cVar).a(str, new b());
        }
    }

    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setSubTitle :" + str);
        this.E = str;
    }

    public void setSuccessVibrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setSuccessVibrate :" + z16);
        this.Q = z16;
    }

    public void setTextBottomMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        }
    }

    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "setTitle :" + str);
        this.D = str;
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "start");
        this.f71253f = true;
        this.f71252e = false;
        if (!this.L) {
            u(getContext());
            return;
        }
        ScratchCard scratchCard = this.f71251d;
        if (scratchCard != null) {
            scratchCard.resume();
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("ScratchCardView ", "stop");
        this.f71252e = true;
        this.f71253f = false;
        ScratchCard scratchCard = this.f71251d;
        if (scratchCard != null) {
            scratchCard.destroy();
        }
    }

    public ScratchCardView(@NonNull Context context, @NonNull f.c cVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) cVar);
        } else {
            this.J = cVar;
            OnActivityLifecycleChanged.addListener(context, this);
        }
    }
}
