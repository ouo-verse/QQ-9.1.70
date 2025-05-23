package com.tencent.gathererga.core.internal.component.db;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.gathererga.core.internal.util.d;
import com.tencent.gathererga.core.internal.util.h;
import com.tencent.gathererga.core.internal.util.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<String, String> f108225a;

    /* renamed from: b, reason: collision with root package name */
    protected String f108226b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108225a = new WeakHashMap<>();
        }
    }

    private String h(String str) {
        if (str != null) {
            try {
                j();
                return l.a(this.f108226b, str);
            } catch (Throwable th5) {
                d.h(th5);
            }
        }
        return str;
    }

    private String i(String str) {
        if (str != null) {
            j();
            try {
                return l.c(this.f108226b, str);
            } catch (Throwable th5) {
                d.h(th5);
            }
        }
        return str;
    }

    private synchronized void j() {
        if (this.f108226b == null) {
            this.f108226b = h.c(k());
            d.a("mEncryptKey : " + this.f108226b);
        }
    }

    protected abstract String k();

    protected abstract SharedPreferences l();

    public final String m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        WeakHashMap<String, String> weakHashMap = this.f108225a;
        if (weakHashMap != null && weakHashMap.containsKey(str)) {
            return this.f108225a.get(str);
        }
        String string = l().getString(i(str), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String h16 = h(string);
        this.f108225a.put(str, h16);
        return h16;
    }

    public final void n(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        l().edit().putString(i(str), i(str2)).commit();
        WeakHashMap<String, String> weakHashMap = this.f108225a;
        if (weakHashMap == null) {
            return;
        }
        weakHashMap.put(str, str2);
    }
}
