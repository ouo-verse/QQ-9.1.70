package com.tencent.mobileqq.c2cshortcutbar.store;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.e;
import com.tencent.mobileqq.c2cshortcutbar.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f200968a;

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f200969b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC7442a f200970c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.c2cshortcutbar.store.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC7442a {
        void a(int i3, com.tencent.mobileqq.c2cshortcutbar.b bVar);
    }

    public a(Context context, QQAppInterface qQAppInterface, String str, List<com.tencent.mobileqq.c2cshortcutbar.b> list, InterfaceC7442a interfaceC7442a, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, str, list, interfaceC7442a, Boolean.valueOf(z16));
            return;
        }
        this.f200969b = qQAppInterface;
        this.f200970c = interfaceC7442a;
        e(context, qQAppInterface, str, list, z16);
    }

    private void e(Context context, QQAppInterface qQAppInterface, String str, List<com.tencent.mobileqq.c2cshortcutbar.b> list, boolean z16) {
        boolean f16 = g.f(qQAppInterface);
        boolean c16 = g.c(str);
        if (z16) {
            f16 = false;
        }
        this.f200968a = new b(qQAppInterface, context, str, f16, c16, list, this);
    }

    @Override // com.tencent.mobileqq.c2cshortcutbar.store.c
    public void a(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
        } else {
            ((e) this.f200969b.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).l(z16, str);
        }
    }

    @Override // com.tencent.mobileqq.c2cshortcutbar.store.c
    public void b(int i3, com.tencent.mobileqq.c2cshortcutbar.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bVar);
            return;
        }
        InterfaceC7442a interfaceC7442a = this.f200970c;
        if (interfaceC7442a != null) {
            interfaceC7442a.a(i3, bVar);
        }
        d();
    }

    @Override // com.tencent.mobileqq.c2cshortcutbar.store.c
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            d();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f200968a.dismiss();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f200968a.show();
        }
    }
}
