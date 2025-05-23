package com.tencent.ams.mosaic.jsengine.component.halfarcslope;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.semiarc.ISemiArcInteractListener;
import com.tencent.ams.fusion.widget.semiarc.SemiArcSlopeView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HalfArcSlopeComponentImpl extends FeatureComponent implements HalfArcSlopeComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final SemiArcSlopeView f71131d;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, AnimatorView.ViewShowOnTop> f71132e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements ISemiArcInteractListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSFunction f71133a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.jsengine.a f71134b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSFunction f71135c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSFunction f71136d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSFunction f71137e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSFunction f71138f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSFunction f71139g;

        a(JSFunction jSFunction, com.tencent.ams.mosaic.jsengine.a aVar, JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4, JSFunction jSFunction5, JSFunction jSFunction6) {
            this.f71133a = jSFunction;
            this.f71134b = aVar;
            this.f71135c = jSFunction2;
            this.f71136d = jSFunction3;
            this.f71137e = jSFunction4;
            this.f71138f = jSFunction5;
            this.f71139g = jSFunction6;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, HalfArcSlopeComponentImpl.this, jSFunction, aVar, jSFunction2, jSFunction3, jSFunction4, jSFunction5, jSFunction6);
            }
        }
    }

    public HalfArcSlopeComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71132e = new ConcurrentHashMap<>();
        SemiArcSlopeView semiArcSlopeView = new SemiArcSlopeView(context);
        this.f71131d = semiArcSlopeView;
        semiArcSlopeView.setTitle("\u503e\u659c\u624b\u673a\u6216\u70b9\u51fb");
        semiArcSlopeView.setSubtitle("\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528");
        semiArcSlopeView.setInnerCircleRadius(198);
        semiArcSlopeView.setInnerCircleCenterBottomMargin(6);
        semiArcSlopeView.setOuterRingRadius(211);
        semiArcSlopeView.setOuterRingCenterBottomMargin(11);
        semiArcSlopeView.setInteractiveMode(new int[]{1, 9});
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f71131d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void notifyAppViewChanged(String str) {
        AnimatorView.ViewShowOnTop viewShowOnTop;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str) || (viewShowOnTop = this.f71132e.get(str)) == null) {
                return;
            }
            viewShowOnTop.notifyViewDrawChanged();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void notifyAppViewVisibilityChanged(String str, boolean z16) {
        AnimatorView.ViewShowOnTop viewShowOnTop;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        } else {
            if (TextUtils.isEmpty(str) || (viewShowOnTop = this.f71132e.get(str)) == null) {
                return;
            }
            viewShowOnTop.notifyViewVisibilityChanged(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.f71131d.stop();
        super.onActivityDestroyed();
        f.a("HalfArcSlopeComponentImpl", "onActivityDestroyed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        super.onSwitchBackground();
        f.a("HalfArcSlopeComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND);
        this.f71131d.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onSwitchForeground();
        f.a("HalfArcSlopeComponentImpl", MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND);
        this.f71131d.resume();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setAppViewShowOnTop(String[] strArr) {
        View c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) strArr);
            return;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && (c16 = com.tencent.ams.mosaic.utils.a.b().c(str)) != null) {
                    AnimatorView.ViewShowOnTop viewShowOnTop = new AnimatorView.ViewShowOnTop(c16);
                    viewShowOnTop.setCalculateXYByScreenLocation(true);
                    this.f71132e.put(str, viewShowOnTop);
                }
            }
            Collection<AnimatorView.ViewShowOnTop> values = this.f71132e.values();
            if (values == null && values.size() <= 0) {
                f.e("HalfArcSlopeComponentImpl", "setViewShowOnTop, viewShowOnTopMap values is empty");
                return;
            } else {
                this.f71131d.setViewsShowOnTop((AnimatorView.ViewShowOnTop[]) values.toArray(new AnimatorView.ViewShowOnTop[0]));
                return;
            }
        }
        f.e("HalfArcSlopeComponentImpl", "setViewShowOnTop, viewIds is empty");
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setBigBallCenterYBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f71131d.setInnerCircleCenterBottomMargin(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setBigBallRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f71131d.setInnerCircleRadius(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setInteractListeners(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) jSObject);
            return;
        }
        com.tencent.ams.mosaic.jsengine.a jSEngine = getJSEngine();
        if (jSEngine == null) {
            f.h("HalfArcSlopeComponentImpl", "setInteractListeners, jsEngine is null");
            return;
        }
        Map<String, Object> f16 = e.f(jSEngine.l(), jSObject);
        if (f16 == null) {
            f.h("HalfArcSlopeComponentImpl", "setInteractListeners failed: invalid listenerDict");
            return;
        }
        this.f71131d.setInteractListener(new a(e.c(f16.get("onInteractStart")), jSEngine, e.c(f16.get("onInteractFinish")), e.c(f16.get("onInteractResult")), e.c(f16.get("onEndAnimatorStart")), e.c(f16.get("onEndAnimatorFinish")), e.c(f16.get("onSensorUnavailable"))));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setInteractiveTypeArray(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iArr);
            return;
        }
        f.e("HalfArcSlopeComponentImpl", "setInteractiveTypeArray: " + Arrays.toString(iArr));
        this.f71131d.setInteractiveMode(iArr);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setReverseTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f71131d.setReverseTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setRingCenterYBottomMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f71131d.setOuterRingCenterBottomMargin(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setRingRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f71131d.setOuterRingRadius(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setSlopeAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f71131d.setSlopeAngle(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setSlopeReverseAngle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f71131d.setSlopeReverseAngle(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f71131d.setSubtitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        f.e("HalfArcSlopeComponentImpl", "setTitle, title = " + str);
        this.f71131d.setTitle(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f71131d.start();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.halfarcslope.HalfArcSlopeComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f71131d.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "HalfArcSlopeComponentImpl";
    }
}
