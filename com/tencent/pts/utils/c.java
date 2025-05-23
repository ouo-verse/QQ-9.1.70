package com.tencent.pts.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f342264a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f342265b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342264a = null;
            f342265b = Color.parseColor("#FFAAFF");
        }
    }

    public static int a(String str) {
        a aVar = f342264a;
        if (aVar != null) {
            return aVar.getColor(str);
        }
        return f342265b;
    }

    public static Drawable b(String str) {
        a aVar = f342264a;
        if (aVar != null) {
            return aVar.getDrawable(str);
        }
        return null;
    }

    public static void c(String str, b bVar) {
        a aVar = f342264a;
        if (aVar != null) {
            aVar.a(str, bVar);
        }
    }

    public static void d(a aVar) {
        f342264a = aVar;
    }
}
