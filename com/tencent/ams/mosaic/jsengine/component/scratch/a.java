package com.tencent.ams.mosaic.jsengine.component.scratch;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.ams.mosaic.jsengine.e;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.ams.music.widget.scratch.ScratchCardListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends FeatureComponent implements ScratchCardComponent, ScratchCardListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ScratchCardView f71260d;

    /* renamed from: e, reason: collision with root package name */
    private JSFunction f71261e;

    /* renamed from: f, reason: collision with root package name */
    private JSFunction f71262f;

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (View) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.f71260d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setBottomPadding(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.f71260d.setBottomPadding(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureSlideValidHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.f71260d.setGestureSlideValidHeight(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.f71260d.setGestureStrokeWidth(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setGuideAnimationTimeMillis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f71260d.setGuideAnimationTimeMillis(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setGuideStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f71260d.setGuideStrokeWidth(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setInteractListeners(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) jSObject);
            return;
        }
        f.e("ScratchCardComponentImpl ", "setInteractListeners :" + jSObject);
        Map<String, Object> f16 = e.f(getJSEngine().l(), jSObject);
        if (f16 == null) {
            f.h("ScratchCardComponentImpl ", "setInteractListeners failed: invalid listenerDict");
        } else {
            this.f71261e = e.c(f16.get("onInteractResult"));
            this.f71262f = e.c(f16.get("onEndAnimatorFinish"));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            super.setJSEngine(aVar);
            this.f71260d.setImageLoader(com.tencent.ams.mosaic.f.k().j());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setRewardDisplayType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f71260d.setRewardDisplayType(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setRewardSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f71260d.setRewardSubTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setRewardTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f71260d.setRewardTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.gesture.GestureComponent
    public void setSlideGestureListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setSmallCardBackgroundUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f71260d.setSmallCardBackgroundUrl(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setSmallCardIconUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.f71260d.setSmallCardIconUrl(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setSubTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f71260d.setSubTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setSuccessVibrate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f71260d.setSuccessVibrate(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setTextBottomMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void setTitle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f71260d.setTitle(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f71260d.v();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.scratch.ScratchCardComponent
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f71260d.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "ScratchCardComponentImpl ";
    }
}
