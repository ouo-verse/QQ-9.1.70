package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes24.dex */
public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    static IPatchRedirector $redirector_;

    public ColorTransitionPagerTitleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }
}
