package com.tencent.imcore.message.core.codec;

import android.util.SparseIntArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final SparseIntArray f116589a;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116589a = new SparseIntArray();
        }
    }

    @Override // com.tencent.imcore.message.core.codec.g
    public synchronized void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f116589a.put(i3, i16);
        }
    }

    @Override // com.tencent.imcore.message.core.codec.g
    public synchronized int getRoutingType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        return this.f116589a.get(i3, 1);
    }
}
