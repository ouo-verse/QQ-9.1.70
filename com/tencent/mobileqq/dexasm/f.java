package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.ImmutableClassDef;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private String f203497c;

    /* renamed from: d, reason: collision with root package name */
    private int f203498d;

    /* renamed from: e, reason: collision with root package name */
    private String f203499e;

    /* renamed from: f, reason: collision with root package name */
    private List<String> f203500f;

    /* renamed from: g, reason: collision with root package name */
    private String f203501g;

    /* renamed from: h, reason: collision with root package name */
    private final Set<c> f203502h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<j> f203503i;

    /* renamed from: j, reason: collision with root package name */
    private final List<l> f203504j;

    public f(@Nonnull Opcodes opcodes) {
        super(opcodes);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) opcodes);
            return;
        }
        this.f203502h = new HashSet();
        this.f203503i = new HashSet();
        this.f203504j = new ArrayList();
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public void a(String str, int i3, @Nullable String str2, @Nonnull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, list);
            return;
        }
        this.f203497c = str;
        this.f203498d = i3;
        this.f203499e = str2;
        this.f203500f = list;
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public b b(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
        }
        c cVar = new c();
        this.f203502h.add(cVar);
        return cVar;
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public i d(@Nonnull String str, @Nonnull String str2, int i3, EncodedValue encodedValue, @Nonnull Set<HiddenApiRestriction> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (i) iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), encodedValue, set);
        }
        j jVar = new j(this.f203497c, str, str2, i3, encodedValue, set);
        this.f203503i.add(jVar);
        return jVar;
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public k e(@Nonnull String str, @Nonnull List<? extends MethodParameter> list, @Nonnull String str2, int i3, @Nonnull Set<HiddenApiRestriction> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (k) iPatchRedirector.redirect((short) 6, this, str, list, str2, Integer.valueOf(i3), set);
        }
        l lVar = new l(this.f203495a, this.f203497c, str, list, str2, i3, set);
        this.f203504j.add(lVar);
        return lVar;
    }

    @Override // com.tencent.mobileqq.dexasm.e
    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f203501g = str;
        }
    }

    public ImmutableClassDef g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ImmutableClassDef) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet(this.f203503i.size());
        for (j jVar : this.f203503i) {
            n.h(this.f203497c, jVar.c());
            hashSet.add(jVar.c());
        }
        HashSet hashSet2 = new HashSet(this.f203504j.size());
        Iterator<l> it = this.f203504j.iterator();
        while (it.hasNext()) {
            hashSet2.add(it.next().t());
        }
        HashSet hashSet3 = new HashSet();
        Iterator<c> it5 = this.f203502h.iterator();
        while (it5.hasNext()) {
            hashSet3.add(it5.next().c());
        }
        return new ImmutableClassDef(this.f203497c, this.f203498d, this.f203499e, this.f203500f, this.f203501g, hashSet3, hashSet, hashSet2);
    }
}
