package com.tencent.mobileqq.highway.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwNetSegConf implements Serializable, Cloneable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 3334652520215468712L;
    public long curConnNum;
    public long netType;
    public long segNum;
    public long segSize;

    public HwNetSegConf(long j3, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        this.netType = j3;
        this.segSize = j16;
        this.segNum = j17;
        this.curConnNum = j18;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HwNetSegConf m195clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (HwNetSegConf) super.clone() : (HwNetSegConf) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
