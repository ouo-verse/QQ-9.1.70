package com.tencent.tfd.sdk.wxa;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.try, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Ctry implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Handler.Callback f375853a;

    /* renamed from: b, reason: collision with root package name */
    public final Cfor f375854b;

    /* renamed from: c, reason: collision with root package name */
    public final String f375855c;

    public Ctry(Handler.Callback callback, Cfor cfor, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, callback, cfor, str);
            return;
        }
        this.f375853a = callback;
        this.f375854b = cfor;
        this.f375855c = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        try {
            int i3 = message.arg2;
            int i16 = message.what;
            Cfor cfor = this.f375854b;
            if (cfor != null && i16 == 1) {
                cfor.a(this.f375855c);
            }
        } catch (Throwable unused) {
        }
        Handler.Callback callback = this.f375853a;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }
}
