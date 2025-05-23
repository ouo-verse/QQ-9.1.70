package com.tencent.mobileqq.rfw.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWDelegate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f281298a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public static String a(@NonNull String str, @Nullable String str2) {
        if (b() != null) {
            return b().getConfig(str, str2);
        }
        return str2;
    }

    private static a b() {
        if (f281298a == null) {
            synchronized (b.class) {
                if (f281298a == null) {
                    f281298a = (a) RFWDelegate.getDelegate(a.class);
                }
            }
        }
        return f281298a;
    }

    public static void c(@NonNull String str, Object obj) {
        if (b() != null) {
            b().updateConfig(str, obj);
        }
    }
}
