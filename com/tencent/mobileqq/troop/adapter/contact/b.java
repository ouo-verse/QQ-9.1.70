package com.tencent.mobileqq.troop.adapter.contact;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements Comparator<d> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private long b(d dVar) {
        Object obj = dVar.f293809b;
        if (obj instanceof TroopInfo) {
            return ((TroopInfo) obj).lastMsgTime;
        }
        if (obj instanceof DiscussionInfo) {
            return ((DiscussionInfo) obj).lastMsgTime;
        }
        return 0L;
    }

    private int c(d dVar) {
        int i3;
        if (b(dVar) != 0 && (i3 = dVar.f293808a) != 4) {
            return i3;
        }
        return dVar.f293808a + 3;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(d dVar, d dVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
        }
        if (dVar == null && dVar2 == null) {
            return 0;
        }
        if (dVar == null) {
            return -1;
        }
        if (dVar2 == null) {
            return 1;
        }
        if (c(dVar) == c(dVar2)) {
            return (int) (b(dVar2) - b(dVar));
        }
        return c(dVar) - c(dVar2);
    }
}
