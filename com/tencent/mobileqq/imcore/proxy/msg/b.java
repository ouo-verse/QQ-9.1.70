package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC7936b f238038a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f238039a;

        /* renamed from: b, reason: collision with root package name */
        public String f238040b;

        public a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.f238039a = i3;
                this.f238040b = str;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.imcore.proxy.msg.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7936b {
        boolean a(Entity entity);

        a b(Entity entity);
    }

    public static a a(Entity entity) {
        InterfaceC7936b interfaceC7936b = f238038a;
        if (interfaceC7936b != null) {
            return interfaceC7936b.b(entity);
        }
        return null;
    }

    public static boolean b(Entity entity) {
        InterfaceC7936b interfaceC7936b = f238038a;
        if (interfaceC7936b != null) {
            return interfaceC7936b.a(entity);
        }
        return false;
    }

    public static void c(InterfaceC7936b interfaceC7936b) {
        f238038a = interfaceC7936b;
    }
}
