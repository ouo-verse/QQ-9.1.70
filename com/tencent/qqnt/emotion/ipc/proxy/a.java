package com.tencent.qqnt.emotion.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a<T extends IRuntimeService> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected BaseQQAppInterface f356287a;

    /* renamed from: b, reason: collision with root package name */
    protected T f356288b;

    public a(BaseQQAppInterface baseQQAppInterface, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) cls);
            return;
        }
        this.f356287a = baseQQAppInterface;
        if (baseQQAppInterface != null) {
            this.f356288b = (T) baseQQAppInterface.getRuntimeService(cls);
        }
    }
}
