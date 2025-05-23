package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.ImmutableField;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected String f203509b;

    /* renamed from: c, reason: collision with root package name */
    protected String f203510c;

    /* renamed from: d, reason: collision with root package name */
    protected String f203511d;

    /* renamed from: e, reason: collision with root package name */
    protected int f203512e;

    /* renamed from: f, reason: collision with root package name */
    protected EncodedValue f203513f;

    /* renamed from: g, reason: collision with root package name */
    protected List<c> f203514g;

    /* renamed from: h, reason: collision with root package name */
    protected Set<HiddenApiRestriction> f203515h;

    public j(String str, String str2, String str3, int i3, EncodedValue encodedValue, Set<HiddenApiRestriction> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3), encodedValue, set);
            return;
        }
        this.f203514g = new ArrayList();
        this.f203509b = str;
        this.f203510c = str2;
        this.f203511d = str3;
        this.f203512e = i3;
        this.f203513f = encodedValue;
        this.f203515h = set;
    }

    public ImmutableField c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImmutableField) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashSet hashSet = new HashSet();
        Iterator<c> it = this.f203514g.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().c());
        }
        return new ImmutableField(this.f203509b, this.f203510c, this.f203511d, this.f203512e, this.f203513f, hashSet, this.f203515h);
    }

    @Override // com.tencent.mobileqq.dexasm.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        }
        c cVar = new c();
        this.f203514g.add(cVar);
        return cVar;
    }
}
