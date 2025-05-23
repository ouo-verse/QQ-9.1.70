package com.tencent.ams.fusion.widget.slideinteractive;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.base.SlideInspector;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FeatureGestureView extends FrameLayout implements com.tencent.ams.fusion.widget.base.SlideGestureView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FeatureGestureView";
    private final SlideGestureViewHelper mHelper;

    public FeatureGestureView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mHelper = new SlideGestureViewHelper(context, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.mHelper.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.mHelper.onDetachedFromWindow();
            super.onDetachedFromWindow();
        }
    }

    public void setDisallowGestureEventNotify(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mHelper.setDisallowGestureEventNotify(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureClickHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mHelper.setGestureClickHotArea(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureClickView(View... viewArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewArr);
        } else {
            this.mHelper.setGestureClickView(viewArr);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mHelper.setGestureColor(str);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideDirection(@SlideGestureViewHelper.SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mHelper.setGestureSlideDirection(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideHotArea(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.mHelper.setGestureHotArea(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideValidAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.mHelper.setGestureSlideValidAngle(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mHelper.setGestureSlideValidHeightDp(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureStrokeWidthDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mHelper.setGestureStrokeWidthDp(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mHelper.setGestureVisible(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideGestureView
    public void setSlideGestureListener(SlideGestureViewHelper.ISlideGestureListener iSlideGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iSlideGestureListener);
        } else {
            this.mHelper.setSlideGestureListener(iSlideGestureListener);
        }
    }

    public void setSlideInspector(SlideInspector slideInspector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) slideInspector);
        } else {
            this.mHelper.setSlideInspector(slideInspector);
        }
    }
}
