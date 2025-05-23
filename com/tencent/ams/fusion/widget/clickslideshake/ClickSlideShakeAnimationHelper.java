package com.tencent.ams.fusion.widget.clickslideshake;

import com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ClickSlideShakeAnimationHelper extends SlideArrowAnimationOtherHelper {
    static IPatchRedirector $redirector_;
    private int mRootWidth;

    public ClickSlideShakeAnimationHelper(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.mRootWidth = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper, com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationHelper
    public float getHandLeftMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return getRelativeWidthSize(12.0f);
    }

    public int getRelativeWidthSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16))).intValue();
        }
        return (int) ((this.mRootWidth * f16) / 375.0f);
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper, com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationHelper
    public int getSlideArrowBgHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return getRelativeWidthSize(130.0f);
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper, com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationHelper
    public int getSlideArrowBgWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return getRelativeWidthSize(43.0f);
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper, com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationHelper
    public int getSlideArrowHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return getRelativeWidthSize(43.0f);
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper, com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationHelper
    public int getSlideHandHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return getRelativeWidthSize(66.0f);
    }

    @Override // com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationOtherHelper, com.tencent.ams.fusion.widget.actionbanner.SlideArrowAnimationHelper
    public float getSlideHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return getRelativeWidthSize(76.0f);
    }

    public void updateRootWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mRootWidth = i3;
        }
    }
}
