package com.tencent.mobileqq.imcore.proxy.utils;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC7938a f238044a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.imcore.proxy.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7938a {
        String a(BaseQQAppInterface baseQQAppInterface, String str, boolean z16);

        String b(BaseQQAppInterface baseQQAppInterface, String str, boolean z16);
    }

    public static String a(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
        InterfaceC7938a interfaceC7938a = f238044a;
        if (interfaceC7938a != null) {
            return interfaceC7938a.b(baseQQAppInterface, str, z16);
        }
        return str;
    }

    public static String b(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
        InterfaceC7938a interfaceC7938a = f238044a;
        if (interfaceC7938a != null) {
            return interfaceC7938a.a(baseQQAppInterface, str, z16);
        }
        return str;
    }

    public static void c(InterfaceC7938a interfaceC7938a) {
        f238044a = interfaceC7938a;
    }
}
