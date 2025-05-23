package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC7935a f238037a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.imcore.proxy.msg.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7935a {
        int a(Message message, BaseQQAppInterface baseQQAppInterface);

        void b(BaseQQAppInterface baseQQAppInterface, String str, int i3, int i16);
    }

    public static int a(Message message, BaseQQAppInterface baseQQAppInterface) {
        InterfaceC7935a interfaceC7935a = f238037a;
        if (interfaceC7935a != null) {
            return interfaceC7935a.a(message, baseQQAppInterface);
        }
        return 0;
    }

    public static void b(InterfaceC7935a interfaceC7935a) {
        f238037a = interfaceC7935a;
    }

    public static void c(BaseQQAppInterface baseQQAppInterface, String str, int i3, int i16) {
        InterfaceC7935a interfaceC7935a = f238037a;
        if (interfaceC7935a != null) {
            interfaceC7935a.b(baseQQAppInterface, str, i3, i16);
        }
    }
}
