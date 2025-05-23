package com.tencent.ams.fusion.widget.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HighRateRotationSensor extends RotationSensor {
    static IPatchRedirector $redirector_;

    public HighRateRotationSensor(Context context, boolean z16) {
        super(context, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.RotationSensor
    protected int getSamplingPeriodUs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }
}
