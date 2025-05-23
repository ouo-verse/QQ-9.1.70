package com.tencent.ams.mosaic.jsengine.component.twist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.freemode.FreeModeCardInfo;
import com.tencent.ams.fusion.widget.freemode.FreeModeSplashLayerHelper;
import com.tencent.ams.fusion.widget.twist.TwistView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TwistComponentImpl extends FeatureComponent implements TwistComponent {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private JSFunction E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private final TwistView f71344d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71345e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71346f;

    /* renamed from: h, reason: collision with root package name */
    private String f71347h;

    /* renamed from: i, reason: collision with root package name */
    private String f71348i;

    /* renamed from: m, reason: collision with root package name */
    private String f71349m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements FreeModeSplashLayerHelper.OnFreeModeButtonClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TwistComponentImpl.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements TwistView.ITwistInteractListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f71351a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSFunction f71352b;

        b(JSFunction jSFunction) {
            this.f71352b = jSFunction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TwistComponentImpl.this, (Object) jSFunction);
            }
        }

        @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
        public void onBackInteractProgress(float f16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
        public void onInteractProgress(float f16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Integer.valueOf(i3));
            } else {
                this.f71351a = f16;
                TwistComponentImpl.this.getJSEngine().u(this.f71352b, new Object[]{2, Float.valueOf(f16)}, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
        public void onInteractResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
                return;
            }
            f.a("TwistComponentImpl", "onInteractResult isSuccess");
            if (z16 && TwistComponentImpl.this.f71345e) {
                MosaicUtils.a0(((ComponentBase) TwistComponentImpl.this).mContext, 200);
            }
            TwistComponentImpl.this.getJSEngine().u(this.f71352b, new Object[]{3, Float.valueOf(this.f71351a)}, null);
        }

        @Override // com.tencent.ams.fusion.widget.twist.TwistView.ITwistInteractListener
        public void onInteractStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                f.a("TwistComponentImpl", "onInteractStart");
                TwistComponentImpl.this.getJSEngine().u(this.f71352b, new Object[]{1, 0}, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71354a;

        c(String str) {
            this.f71354a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TwistComponentImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "onLoadFinish: " + this.f71354a + ", object: " + obj);
            if (obj instanceof Bitmap) {
                TwistComponentImpl.this.n((Bitmap) obj);
                return;
            }
            if (obj instanceof Drawable) {
                Drawable drawable = (Drawable) obj;
                try {
                    TwistComponentImpl.this.n(MosaicUtils.k(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
                    return;
                } catch (Throwable th5) {
                    com.tencent.ams.mosaic.utils.f.c("TwistComponentImpl", "onLoadFinish: catch Throwable :", th5);
                    return;
                }
            }
            com.tencent.ams.mosaic.utils.f.h("TwistComponentImpl", "onLoadFinish: icon bitmap load failed");
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "onLoadStart: " + this.f71354a);
        }
    }

    public TwistComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.F = 0;
        this.f71344d = new TwistView(context);
        setTitle("\u626d\u52a8\u624b\u673a");
        setSubTitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
        setTwistAngle(50);
        setTwistDirection(2);
    }

    private void m() {
        if (this.F == 2) {
            this.f71344d.setShowMode(1);
            FreeModeCardInfo freeModeCardInfo = new FreeModeCardInfo();
            freeModeCardInfo.setTitle(this.f71347h);
            freeModeCardInfo.setSubTitle(this.f71348i);
            freeModeCardInfo.setRewardTitle(this.f71349m);
            freeModeCardInfo.setRewardSubTitle(this.C);
            freeModeCardInfo.setRewardThemeColor(this.D);
            this.f71344d.setFreeModeCardInfo(freeModeCardInfo);
            this.f71344d.setFreeModeClickListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap) {
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setIconBitmap");
        if (bitmap != null) {
            this.f71344d.setTextBottomMarginDp(111);
            TwistView.CustomImage customImage = new TwistView.CustomImage();
            customImage.setImageBitmap(bitmap);
            this.f71344d.setRewardImage(customImage);
            if (this.f71346f) {
                this.f71344d.restart();
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71344d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.f71344d.stop();
        super.onActivityDestroyed();
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "onActivityDestroyed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.onSwitchBackground();
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f71344d.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.onSwitchForeground();
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f71344d.resume();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setBottomPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setBottomPadding: " + f16);
        this.f71344d.setBottomPaddingDp((int) f16);
        if (f16 > 0.0f) {
            this.f71344d.setTextBottomMarginDp(14);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setEnableShowBgShadow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setEnableShowBgShadow: " + z16);
        this.f71344d.setEnableShowBgShadow(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setFreeModeClickListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) jSFunction);
        } else {
            this.E = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setInteractListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSFunction);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setInteractListener");
        if (jSFunction == null) {
            return;
        }
        this.f71344d.setTwistInteractListener(new b(jSFunction));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setReverseAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TwistComponentImpl", "setReverseAngle, reverseAngle: " + i3);
        TwistView twistView = this.f71344d;
        if (twistView != null) {
            twistView.setReverseAngle(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setRewardDisplayType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TwistComponentImpl", "setRewardDisplayType, type: " + i3);
        this.F = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setRewardIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            com.tencent.ams.mosaic.utils.f.h("TwistComponentImpl", "loadIconBitmap failed: no data or src");
        } else {
            getImageLoader().loadImage(str, new c(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setRewardSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TwistComponentImpl", "setRewardSubTitle, rewardSubTitle: " + str);
        this.C = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setRewardThemeColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TwistComponentImpl", "setRewardThemeColor, color: " + str);
        this.D = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setRewardTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TwistComponentImpl", "setRewardTitle, rewardTitle: " + str);
        this.f71349m = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setSubTitle: " + str);
        this.f71344d.setSubTitle(str);
        this.f71348i = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setSuccessVibrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f71345e = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setTextBottomMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("TwistComponentImpl", "setTextBottomMargin: " + f16);
        this.f71344d.setTextBottomMarginDp((int) f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setTitle: " + str);
        this.f71344d.setTitle(str);
        this.f71347h = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setTwistAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setTwistAngle: " + i3);
        this.f71344d.setTargetAngle((float) i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void setTwistDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "setTwistDirection: " + i3);
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            com.tencent.ams.mosaic.utils.f.h("TwistComponentImpl", "setTwistDirection invalid direction: " + i3);
            return;
        }
        this.f71344d.setDirection(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "start");
        m();
        this.f71344d.start();
        this.f71346f = true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.twist.TwistComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("TwistComponentImpl", "stop");
        this.f71344d.stop();
        this.f71346f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TwistComponentImpl";
    }
}
