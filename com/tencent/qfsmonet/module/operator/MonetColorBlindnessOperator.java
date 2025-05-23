package com.tencent.qfsmonet.module.operator;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetColorBlindnessOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final String OP_TYPE_NAME = "ColorBlindness";

    public MonetColorBlindnessOperator(@NonNull HashMap<String, String> hashMap) {
        super(OP_TYPE_NAME, hashMap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hashMap);
        }
    }
}
