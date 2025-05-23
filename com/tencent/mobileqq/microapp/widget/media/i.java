package com.tencent.mobileqq.microapp.widget.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.microapp.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class i implements a.InterfaceC8026a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppVideoPlayer f246232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MiniAppVideoPlayer miniAppVideoPlayer) {
        this.f246232a = miniAppVideoPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppVideoPlayer);
        }
    }

    @Override // com.tencent.mobileqq.microapp.a.a.InterfaceC8026a
    public void a(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (StringUtil.isEmpty(action)) {
            return;
        }
        if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
            this.f246232a.c();
            return;
        }
        if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
            MiniAppVideoPlayer miniAppVideoPlayer = this.f246232a;
            com.tencent.mobileqq.microapp.appbrand.a aVar = miniAppVideoPlayer.f246202n.appBrandRuntime;
            if (aVar == null || aVar.f245905j) {
                return;
            }
            miniAppVideoPlayer.b();
        }
    }
}
