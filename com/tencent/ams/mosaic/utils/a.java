package com.tencent.ams.mosaic.utils;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f71556a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private interface b {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final a f71557a;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(59136), (Class<?>) b.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                f71557a = new a(null);
            }
        }
    }

    /* synthetic */ a(C0698a c0698a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) c0698a);
    }

    public static a b() {
        return b.f71557a;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f71556a.clear();
        }
    }

    public View c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        Object obj = this.f71556a.get(str);
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public void d(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) strArr);
            return;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    f.a("AppResourceManager", "removeResource id=" + str);
                    this.f71556a.remove(str);
                }
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f71556a = new ConcurrentHashMap<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
