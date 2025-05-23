package com.tencent.mobileqq.microapp.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f245816b;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC8026a f245817a;

    /* renamed from: c, reason: collision with root package name */
    private final BroadcastReceiver f245818c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.microapp.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8026a {
        void a(Context context, Intent intent);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f245818c = new b(this);
        }
    }

    public static a a() {
        if (f245816b == null) {
            synchronized (a.class) {
                if (f245816b == null) {
                    f245816b = new a();
                }
            }
        }
        return f245816b;
    }

    public void a(InterfaceC8026a interfaceC8026a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) interfaceC8026a);
            return;
        }
        this.f245817a = interfaceC8026a;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        BaseApplication.getContext().registerReceiver(this.f245818c, intentFilter);
    }
}
