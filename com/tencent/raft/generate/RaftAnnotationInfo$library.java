package com.tencent.raft.generate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.raftannotation.RaftYMLPath;

/* compiled from: P */
@RaftYMLPath(configFilePath = "", raftFilePath = "")
/* loaded from: classes25.dex */
public class RaftAnnotationInfo$library {
    static IPatchRedirector $redirector_;

    public RaftAnnotationInfo$library() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    String getId() {
        return "3213407943254";
    }
}
