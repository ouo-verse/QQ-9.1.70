package com.tencent.mobileqq.imcore.proxy.troop;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC7937a f238043a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.imcore.proxy.troop.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7937a {
        TroopInfo a(BaseQQAppInterface baseQQAppInterface, String str);
    }

    public static TroopInfo a(BaseQQAppInterface baseQQAppInterface, String str) {
        InterfaceC7937a interfaceC7937a = f238043a;
        if (interfaceC7937a != null) {
            return interfaceC7937a.a(baseQQAppInterface, str);
        }
        return null;
    }

    public static void b(InterfaceC7937a interfaceC7937a) {
        f238043a = interfaceC7937a;
    }
}
