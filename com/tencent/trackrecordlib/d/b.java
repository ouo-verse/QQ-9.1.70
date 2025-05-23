package com.tencent.trackrecordlib.d;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381102a = "ExposureRecorderImpl";

    /* renamed from: b, reason: collision with root package name */
    private final Set<View> f381103b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<View> f381104c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f381105a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11452);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f381105a = new b(null);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) anonymousClass1);
    }

    @Override // com.tencent.trackrecordlib.d.c
    public void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f381103b.add(view);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.trackrecordlib.d.c
    public boolean b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f381103b.contains(view) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
    }

    @Override // com.tencent.trackrecordlib.d.c
    public void c(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f381103b.remove(view);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Set<View> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        this.f381103b = newSetFromMap;
        this.f381104c = Collections.unmodifiableSet(newSetFromMap);
    }

    public static b c() {
        return a.f381105a;
    }

    @Override // com.tencent.trackrecordlib.d.c
    public void a(Collection<View> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f381103b.removeAll(collection);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) collection);
        }
    }

    @Override // com.tencent.trackrecordlib.d.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<View> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f381104c : (Set) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.trackrecordlib.d.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f381103b.clear();
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
