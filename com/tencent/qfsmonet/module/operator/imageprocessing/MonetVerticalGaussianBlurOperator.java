package com.tencent.qfsmonet.module.operator.imageprocessing;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetVerticalGaussianBlurOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final String OP_TYPE_NAME = "GaussianVerticalBlur";

    public MonetVerticalGaussianBlurOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
