package com.tencent.gathererga.core.internal.component.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends com.tencent.gathererga.core.internal.component.db.a implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f108214c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.a
    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        try {
            return Long.valueOf(m("T")).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return m(BdhLogUtil.LogTag.Tag_Conn);
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.a
    public void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        n("T", "" + j3);
    }

    @Override // com.tencent.gathererga.core.internal.component.cache.a
    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            n(BdhLogUtil.LogTag.Tag_Conn, str);
        }
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
        return this.f108214c;
    }

    @Override // com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            this.f108214c = context.getSharedPreferences("gatherer_cloud_conf", 0);
        }
    }
}
