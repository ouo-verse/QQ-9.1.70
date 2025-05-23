package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.abs.c;

/* loaded from: classes24.dex */
public class DummyPagerTitleView extends View implements c {
    static IPatchRedirector $redirector_;

    public DummyPagerTitleView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }
}
