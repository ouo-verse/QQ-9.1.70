package com.tencent.ams.mosaic.jsengine.component;

import android.content.Context;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class FeatureComponent extends ComponentBase {
    static IPatchRedirector $redirector_;

    public FeatureComponent(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void addAnimation(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) animation);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void removeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setAnchorPoint(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            getView().setBackgroundColor(MosaicUtils.O(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundDrawable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundGradient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBorder(float f16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBoxShadow(float f16, float f17, float f18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadii(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fArr);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setOpacity(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPositionOffset(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        }
    }
}
