package com.tencent.mobileqq.msf.core.net.u;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.net.u.b.c;
import com.tencent.mobileqq.msf.core.net.u.b.e;
import com.tencent.mobileqq.msf.core.net.u.b.g;
import com.tencent.mobileqq.msf.core.net.u.b.i;
import com.tencent.mobileqq.msf.core.net.u.b.j;
import com.tencent.mobileqq.msf.core.net.u.b.k;
import com.tencent.mobileqq.msf.core.net.u.c.d;
import com.tencent.mobileqq.msf.core.net.u.c.f;
import com.tencent.mobileqq.msf.core.net.u.c.g;
import com.tencent.mobileqq.msf.core.net.u.c.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f249402c = "MsfQuickUdpClient";

    /* renamed from: d, reason: collision with root package name */
    private static final List<c> f249403d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f249404e;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.quicksend.b f249405a;

    /* renamed from: b, reason: collision with root package name */
    private final f f249406b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.u.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8092a {
        void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

        void a(ToServiceMsg toServiceMsg, Exception exc);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15063);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f249403d = new ArrayList();
        }
    }

    a(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f249405a = bVar;
        this.f249406b = f.a(bVar);
        List<c> list = f249403d;
        list.add(i.a());
        list.add(new j());
        list.add(new g());
        list.add(e.a(bVar));
        list.add(k.a(bVar));
        list.add(new com.tencent.mobileqq.msf.core.net.u.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class b implements com.tencent.mobileqq.msf.core.net.u.c.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ToServiceMsg f249407a;

        /* renamed from: b, reason: collision with root package name */
        InterfaceC8092a f249408b;

        b(ToServiceMsg toServiceMsg, InterfaceC8092a interfaceC8092a) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) toServiceMsg, (Object) interfaceC8092a);
            } else {
                this.f249407a = toServiceMsg;
                this.f249408b = interfaceC8092a;
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.u.c.e
        public void a(d dVar, Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) exc);
                return;
            }
            InterfaceC8092a interfaceC8092a = this.f249408b;
            if (interfaceC8092a != null) {
                interfaceC8092a.a(this.f249407a, exc);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.u.c.e
        public void a(d dVar, h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar, (Object) hVar);
                return;
            }
            DatagramPacket a16 = hVar.a();
            byte[] data = a16.getData();
            if (data == null) {
                QLog.d(a.f249402c, 1, "[onResponse] receive empty message.");
                return;
            }
            if (data.length > a16.getLength()) {
                int length = a16.getLength();
                byte[] bArr = new byte[length];
                System.arraycopy(data, 0, bArr, 0, length);
                data = bArr;
            }
            FromServiceMsg a17 = com.tencent.mobileqq.msf.core.net.utils.a.a(data, MsfCore.sCore);
            for (int size = a.f249403d.size() - 1; size >= 0; size--) {
                c cVar = (c) a.f249403d.get(size);
                if (cVar instanceof com.tencent.mobileqq.msf.core.net.u.b.b) {
                    a17 = ((com.tencent.mobileqq.msf.core.net.u.b.b) cVar).a(this.f249407a, a17);
                }
            }
            InterfaceC8092a interfaceC8092a = this.f249408b;
            if (interfaceC8092a != null) {
                interfaceC8092a.a(this.f249407a, a17);
            }
            if (QLog.isColorLevel()) {
                QLog.d(a.f249402c, 1, "[onResponse] message after filter: ", com.tencent.mobileqq.msf.core.z.a.a(a17));
            }
        }
    }

    public static a a(com.tencent.mobileqq.msf.core.quicksend.b bVar) {
        if (f249404e == null) {
            synchronized (a.class) {
                if (f249404e == null) {
                    f249404e = new a(bVar);
                }
            }
        }
        return f249404e;
    }

    public void a(ToServiceMsg toServiceMsg, InterfaceC8092a interfaceC8092a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) interfaceC8092a);
            return;
        }
        QLog.d(f249402c, 2, "[sendMessage] message before filter: ", com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
        for (c cVar : f249403d) {
            if ((cVar instanceof com.tencent.mobileqq.msf.core.net.u.b.d) && (toServiceMsg = ((com.tencent.mobileqq.msf.core.net.u.b.d) cVar).a(toServiceMsg)) == null) {
                break;
            }
        }
        if (toServiceMsg == null) {
            QLog.d(f249402c, 1, "[sendMessage] after filter message is null.");
            return;
        }
        QLog.d(f249402c, 2, "[sendMessage] send message after filter: ", toServiceMsg.toString());
        byte[] a16 = com.tencent.mobileqq.msf.core.net.utils.a.a(toServiceMsg, MsfCore.sCore);
        this.f249406b.a(new g.a().a(a16).a(a16.length).a()).a(new b(toServiceMsg, interfaceC8092a));
    }
}
