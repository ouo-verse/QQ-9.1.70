package com.tencent.raft.raftframework.service.api;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.raftframework.constant.RAFTConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ServiceWrapper {
    static IPatchRedirector $redirector_;
    public RAFTConstants.Scope scope;
    public Object service;

    public ServiceWrapper(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) str);
            return;
        }
        this.scope = RAFTConstants.Scope.PROTOTYPE;
        this.service = obj;
        if (!TextUtils.isEmpty(str)) {
            this.scope = RAFTConstants.Scope.parse(str);
        }
    }
}
