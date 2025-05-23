package com.tencent.mobileqq.dov.story.api.impl;

import NS_COMM.COMM;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.dov.story.api.IVSReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VSReporterImpl implements IVSReporter {
    static IPatchRedirector $redirector_;

    public VSReporterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.dov.story.api.IVSReporter
    public List<COMM.Entry> newPerfEntries(int i3, long j3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), str, Long.valueOf(j16));
        }
        return VSReporter.f(i3, j3, str, j16);
    }

    @Override // com.tencent.mobileqq.dov.story.api.IVSReporter
    public void reportPerfEvent(String str, List<COMM.Entry> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) list);
        } else {
            VSReporter.q(str, list);
        }
    }
}
