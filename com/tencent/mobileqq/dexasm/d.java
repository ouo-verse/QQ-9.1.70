package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ClassDef f203494a;

    public d(@Nonnull ClassDef classDef) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) classDef);
        } else {
            this.f203494a = classDef;
        }
    }

    private void b(e eVar) {
        for (Annotation annotation : this.f203494a.getAnnotations()) {
            b b16 = eVar.b(annotation.getVisibility(), annotation.getType());
            if (b16 != null) {
                b16.a(annotation.getVisibility(), annotation.getType());
                b16.b(annotation.getElements());
            }
        }
    }

    private void c(e eVar) {
        for (Field field : this.f203494a.getFields()) {
            i d16 = eVar.d(field.getName(), field.getType(), field.getAccessFlags(), field.getInitialValue(), field.getHiddenApiRestrictions());
            if (d16 != null) {
                for (Annotation annotation : field.getAnnotations()) {
                    b a16 = d16.a(annotation.getVisibility(), annotation.getType());
                    if (a16 != null) {
                        a16.a(annotation.getVisibility(), annotation.getType());
                        a16.b(annotation.getElements());
                    }
                }
                d16.b();
            }
        }
    }

    private void d(e eVar) {
        for (Method method : this.f203494a.getMethods()) {
            k e16 = eVar.e(method.getName(), method.getParameters(), method.getReturnType(), method.getAccessFlags(), method.getHiddenApiRestrictions());
            if (e16 != null) {
                for (Annotation annotation : method.getAnnotations()) {
                    b e17 = e16.e(annotation);
                    if (e17 != null) {
                        e17.a(annotation.getVisibility(), annotation.getType());
                        e17.b(annotation.getElements());
                    }
                }
                e16.k(method.getImplementation());
                e16.h();
            }
        }
    }

    public void a(@Nonnull e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            return;
        }
        eVar.a(this.f203494a.getType(), this.f203494a.getAccessFlags(), this.f203494a.getSuperclass(), this.f203494a.getInterfaces());
        eVar.f(this.f203494a.getSourceFile());
        b(eVar);
        c(eVar);
        d(eVar);
        eVar.c();
    }
}
