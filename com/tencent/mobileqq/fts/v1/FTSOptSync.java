package com.tencent.mobileqq.fts.v1;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class FTSOptSync extends Entity {
    static IPatchRedirector $redirector_;
    public String mContent;
    public long mOId;
    public int mOpt;
    public int mType;

    public FTSOptSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
