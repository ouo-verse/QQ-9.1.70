package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "mTag, mDetail")
/* loaded from: classes18.dex */
public class Reporting extends Entity implements Cloneable {
    static IPatchRedirector $redirector_;
    public int mCount;
    public String mDetail;
    public int mDetailHashCode;
    public int mLockedCount;
    public int mSeqKey;
    public String mTag;

    public Reporting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Reporting m222clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Reporting) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return (Reporting) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
