package com.tencent.mobileqq.microapp.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.microapp.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class b extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f245819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f245819a = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a.InterfaceC8026a interfaceC8026a;
        a.InterfaceC8026a interfaceC8026a2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (!StringUtil.isEmpty(intent.getAction())) {
            interfaceC8026a = this.f245819a.f245817a;
            if (interfaceC8026a != null) {
                interfaceC8026a2 = this.f245819a.f245817a;
                interfaceC8026a2.a(context, intent);
            }
        }
    }
}
