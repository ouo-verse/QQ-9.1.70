package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static a f238029a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        boolean a(BaseQQAppInterface baseQQAppInterface, String str, int i3);

        void b(BaseQQAppInterface baseQQAppInterface, boolean z16);
    }

    public static boolean a(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        a aVar = f238029a;
        if (aVar == null) {
            return false;
        }
        return aVar.a(baseQQAppInterface, str, i3);
    }

    public static void b(a aVar) {
        f238029a = aVar;
    }

    public static void c(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        a aVar = f238029a;
        if (aVar == null) {
            return;
        }
        aVar.b(baseQQAppInterface, z16);
    }
}
