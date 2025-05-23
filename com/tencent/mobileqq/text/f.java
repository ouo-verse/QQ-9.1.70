package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
class f extends l {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(@NonNull String str) {
        super(1, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.text.l
    public float c(@NonNull Paint paint) {
        return paint.measureText(a());
    }
}
