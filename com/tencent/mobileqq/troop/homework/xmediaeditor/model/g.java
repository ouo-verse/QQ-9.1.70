package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class g extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public int f297417d;

    /* renamed from: e, reason: collision with root package name */
    public List<Integer> f297418e;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f297417d = 0;
        ArrayList arrayList = new ArrayList();
        this.f297418e = arrayList;
        arrayList.add(0);
        this.f297418e.add(3);
        this.f297418e.add(1);
        this.f297418e.add(2);
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f297417d;
    }
}
