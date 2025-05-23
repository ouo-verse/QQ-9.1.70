package com.tencent.gathererga.core.internal.component.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends com.tencent.gathererga.core.internal.component.db.a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f108215c;

    /* renamed from: d, reason: collision with root package name */
    private WeakHashMap<Integer, Object> f108216d;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108216d = new WeakHashMap<>();
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.c
    public Object a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        return m("" + i3);
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.c
    public void d(int i3, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), obj, Boolean.valueOf(z16));
            return;
        }
        if (obj == null) {
            com.tencent.gathererga.core.internal.util.d.a("ProviderResultCacheImpl save empty result, id = " + i3);
            return;
        }
        this.f108216d.put(Integer.valueOf(i3), obj);
        if (z16) {
            n("" + i3, String.valueOf(obj));
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.c
    public Object g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f108216d.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.gathererga.core.internal.component.db.a
    protected String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.gathererga.core.internal.component.a.f108209g.f();
    }

    @Override // com.tencent.gathererga.core.internal.component.db.a
    protected SharedPreferences l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f108215c;
    }

    @Override // com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        } else {
            this.f108215c = context.getSharedPreferences("gatherer_provider", 0);
        }
    }
}
