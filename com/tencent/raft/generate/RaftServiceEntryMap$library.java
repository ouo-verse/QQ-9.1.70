package com.tencent.raft.generate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RaftServiceEntryMap$library {
    static IPatchRedirector $redirector_;
    public static final Map<String, IServiceEntry> sDeclareMap;
    public static final Map<Class, IServiceEntry> sServicesMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sServicesMap = new HashMap();
            sDeclareMap = new HashMap();
        }
    }

    public RaftServiceEntryMap$library() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
