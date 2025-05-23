package com.tencent.ams.mosaic.jsengine.component.slideguide;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimatorView;
import com.tencent.ams.mosaic.jsengine.component.FeatureComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideGuideComponentImpl extends FeatureComponent implements SlideGuideComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final SlideArrowAnimatorView f71280d;

    public SlideGuideComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f71280d = new SlideArrowAnimatorView(context);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71280d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.slideguide.SlideGuideComponent
    public void setSlideIconShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f71280d.setSlideIconShape(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "SlideGuideComponentImpl";
    }
}
