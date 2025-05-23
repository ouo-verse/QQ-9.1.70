package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<Object, b> f381101a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11445);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381101a = new WeakHashMap<>();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Object obj, b bVar) {
        f381101a.put(obj, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(@NonNull Object obj) {
        return f381101a.get(obj);
    }
}
