package com.tencent.common.app.business;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseToolAppInterface extends AppInterface {
    static IPatchRedirector $redirector_;

    public BaseToolAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ, (Object) str);
        }
    }

    @NonNull
    public <T extends IRuntimeService> T getRuntimeService(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        return (T) getRuntimeService(cls, "tool");
    }
}
