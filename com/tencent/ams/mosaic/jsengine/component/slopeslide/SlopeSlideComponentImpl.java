package com.tencent.ams.mosaic.jsengine.component.slopeslide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.freemode.FreeModeCardInfo;
import com.tencent.ams.fusion.widget.freemode.FreeModeSplashLayerHelper;
import com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlopeSlideComponentImpl extends FeatureComponent implements SlopeSlideComponent {
    static IPatchRedirector $redirector_;
    private String C;
    private String D;
    private JSFunction E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private final SlopeSlideView f71281d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71282e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71283f;

    /* renamed from: h, reason: collision with root package name */
    private String f71284h;

    /* renamed from: i, reason: collision with root package name */
    private String f71285i;

    /* renamed from: m, reason: collision with root package name */
    private String f71286m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements FreeModeSplashLayerHelper.OnFreeModeButtonClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeSlideComponentImpl.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71288a;

        b(String str) {
            this.f71288a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeSlideComponentImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onLoadFinish: " + this.f71288a + ", object: " + obj);
            if (obj instanceof Bitmap) {
                SlopeSlideComponentImpl.this.p((Bitmap) obj);
            } else {
                if (obj instanceof Drawable) {
                    Drawable drawable = (Drawable) obj;
                    SlopeSlideComponentImpl.this.p(MosaicUtils.k(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
                    return;
                }
                com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "onLoadFinish: icon bitmap load failed");
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onLoadStart: " + this.f71288a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71290a;

        c(String str) {
            this.f71290a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlopeSlideComponentImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onLoadFinish: " + this.f71290a + ", object: " + obj);
            if (obj instanceof Bitmap) {
                SlopeSlideComponentImpl.this.q((Bitmap) obj);
                return;
            }
            if (obj instanceof Drawable) {
                Drawable drawable = (Drawable) obj;
                try {
                    SlopeSlideComponentImpl.this.q(MosaicUtils.k(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
                    return;
                } catch (Throwable th5) {
                    com.tencent.ams.mosaic.utils.f.c("SlopeSlideComponentImpl", "onLoadFinish: catch Throwable :", th5);
                    return;
                }
            }
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "onLoadFinish: icon bitmap load failed");
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onLoadStart: " + this.f71290a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class d implements SlopeSlideView.OnSlopSlideInteractListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f71292a;

        /* renamed from: b, reason: collision with root package name */
        int f71293b;

        /* renamed from: c, reason: collision with root package name */
        int f71294c;

        /* renamed from: d, reason: collision with root package name */
        int f71295d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSFunction f71296e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSFunction f71297f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSFunction f71298g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ JSFunction f71299h;

        d(JSFunction jSFunction, JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4) {
            this.f71296e = jSFunction;
            this.f71297f = jSFunction2;
            this.f71298g = jSFunction3;
            this.f71299h = jSFunction4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SlopeSlideComponentImpl.this, jSFunction, jSFunction2, jSFunction3, jSFunction4);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onAnimatorFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onAnimatorFinish");
            if (this.f71299h != null) {
                SlopeSlideComponentImpl.this.getJSEngine().u(this.f71299h, new Object[0], null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onAnimatorStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractFinish(int i3, boolean z16, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), point);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onInteractFinish type:" + i3 + ", point:" + point);
            if (this.f71297f != null) {
                SlopeSlideComponentImpl.this.getJSEngine().u(this.f71297f, new Object[]{Integer.valueOf(SlopeSlideComponentImpl.this.r(i3))}, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractResult(int i3, boolean z16, int i16, Point point, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), point, Float.valueOf(f16));
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onInteractResult type:" + i3 + ", result:" + z16 + ", reason:" + i16 + ", point:" + point + ", angle:" + f16);
            if (point != null) {
                this.f71294c = point.x;
                this.f71295d = point.y;
            }
            if (z16 && i3 != 4 && SlopeSlideComponentImpl.this.f71283f) {
                MosaicUtils.a0(((ComponentBase) SlopeSlideComponentImpl.this).mContext, 200);
            }
            if (this.f71298g != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("interactType", Integer.valueOf(SlopeSlideComponentImpl.this.r(i3)));
                hashMap.put("result", Boolean.valueOf(z16));
                hashMap.put("failReason", Integer.valueOf(i16));
                hashMap.put("angle", Float.valueOf(f16));
                hashMap.put("startX", Integer.valueOf(this.f71292a));
                hashMap.put("startY", Integer.valueOf(this.f71293b));
                hashMap.put("endX", Integer.valueOf(this.f71294c));
                hashMap.put("endY", Integer.valueOf(this.f71295d));
                SlopeSlideComponentImpl.this.getJSEngine().u(this.f71298g, new Object[]{hashMap}, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onInteractStart(int i3, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) point);
                return;
            }
            com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onInteractStart type:" + i3 + ", point:" + point);
            if (point != null) {
                this.f71292a = point.x;
                this.f71293b = point.y;
            }
            if (this.f71296e != null) {
                SlopeSlideComponentImpl.this.getJSEngine().u(this.f71296e, new Object[]{Integer.valueOf(SlopeSlideComponentImpl.this.r(i3))}, null);
            }
        }

        @Override // com.tencent.ams.fusion.widget.slopeslide.SlopeSlideView.OnSlopSlideInteractListener
        public void onSensorError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }
    }

    public SlopeSlideComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.F = 0;
        this.f71281d = new SlopeSlideView(context);
        setTitle("\u524d\u503e\u624b\u673a");
        setSubTitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
        setInteractiveType(1);
        setSlopeAngle(45.0f);
        setGestureSlideValidHeight(100);
    }

    private void o() {
        if (this.F == 2) {
            this.f71281d.setShowMode(1);
            FreeModeCardInfo freeModeCardInfo = new FreeModeCardInfo();
            freeModeCardInfo.setTitle(this.f71284h);
            freeModeCardInfo.setSubTitle(this.f71285i);
            freeModeCardInfo.setRewardTitle(this.f71286m);
            freeModeCardInfo.setRewardSubTitle(this.C);
            freeModeCardInfo.setRewardThemeColor(this.D);
            this.f71281d.setFreeModeCardInfo(freeModeCardInfo);
            this.f71281d.setFreeModeClickListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Bitmap bitmap) {
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setIconBitmap");
        if (bitmap != null) {
            this.f71281d.setIconBitmap(bitmap);
            if (this.f71282e) {
                this.f71281d.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bitmap bitmap) {
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setIconBitmap");
        if (bitmap != null) {
            this.f71281d.setTextBottomMarginDp(111);
            this.f71281d.setRewardImage(bitmap);
            if (this.f71282e) {
                this.f71281d.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SlopeSlideComponent.InteractType
    public int r(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 4) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71281d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        this.f71281d.stopAnimation();
        super.onActivityDestroyed();
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "onActivityDestroyed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        super.onSwitchBackground();
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f71281d.pauseAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        super.onSwitchForeground();
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f71281d.resumeAnimation();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setBottomPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setBottomMargin: " + f16);
        this.f71281d.setBottomPaddingDp((int) f16);
        if (f16 > 0.0f) {
            this.f71281d.setTextBottomMargin(38);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setEnableShowBgShadow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setEnableShowBgShadow: " + z16);
        this.f71281d.setEnableShowBgShadow(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setFreeModeClickListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) jSFunction);
        } else {
            this.E = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "can't setGestureClickHotArea: click area is only support circle");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.f71281d.setStrokeColor(MosaicUtils.P(str, -1));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f71281d.setHotAreaWithDp(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            this.f71281d.setSlideThresholdWithDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.f71281d.setStrokeWidthDp(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setGestureVisible: " + z16);
        this.f71281d.setEnableShowStroke(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setIconData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setIconData");
        if (TextUtils.isEmpty(str)) {
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "setIconData failed: empty data");
        } else {
            float n3 = MosaicUtils.n(this.f71281d.getContext(), 260);
            p(MosaicUtils.d(str, n3, n3));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            getImageLoader().loadImage(str, new b(str));
        } else {
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "loadIconBitmap failed: no data or src");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setInteractListeners(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) jSObject);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setInteractListeners");
        Map<String, Object> f16 = e.f(getJSEngine().l(), jSObject);
        if (f16 == null) {
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "setInteractListeners failed: invalid listenerDict");
            return;
        }
        this.f71281d.setOnSlopeSlideInteractListener(new d(e.c(f16.get("onInteractStart")), e.c(f16.get("onInteractFinish")), e.c(f16.get("onInteractResult")), e.c(f16.get("onEndAnimatorFinish"))));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setInteractiveType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a("SlopeSlideComponentImpl", "setInteractiveType: " + i3);
        if (i3 == 3) {
            this.f71281d.setEnableClick(true);
        } else {
            this.f71281d.setEnableClick(false);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setReverseAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.f71281d.setReverseRotationThreshold(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setReverseTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f71281d.setReverseTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setRewardDisplayType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlopeSlideComponentImpl", "setRewardDisplayType, type: " + i3);
        this.F = i3;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setRewardIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "loadIconBitmap failed: no data or src");
        } else {
            getImageLoader().loadImage(str, new c(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setRewardSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlopeSlideComponentImpl", "setRewardSubTitle, rewardSubTitle: " + str);
        this.C = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setRewardThemeColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlopeSlideComponentImpl", "setRewardThemeColor, color: " + str);
        this.D = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setRewardTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlopeSlideComponentImpl", "setRewardTitle, rewardTitle: " + str);
        this.f71286m = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        } else {
            com.tencent.ams.mosaic.utils.f.h("SlopeSlideComponentImpl", "can't setSlideGestureListener: has been replaced by 'setInteractListener'");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setSlopeAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.f71281d.setRotationThreshold(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f71281d.setSubTitle(str);
            this.f71285i = str;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setSuccessVibrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.f71283f = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setTextBottomMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("SlopeSlideComponentImpl", "setTextBottomMargin: " + f16);
        this.f71281d.setTextBottomMargin((int) f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f71281d.setTitle(str);
            this.f71284h = str;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        o();
        this.f71281d.start();
        this.f71282e = true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slopeslide.SlopeSlideComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f71281d.stopAnimation();
            this.f71282e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "SlopeSlideComponentImpl";
    }
}
