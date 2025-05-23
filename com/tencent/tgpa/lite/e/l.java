package com.tencent.tgpa.lite.e;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Uri f375944a;

    /* renamed from: b, reason: collision with root package name */
    private Context f375945b;

    /* renamed from: c, reason: collision with root package name */
    private j f375946c;

    public l(Context context, j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jVar);
            return;
        }
        this.f375944a = Uri.parse("content://cn.nubia.identity/identity");
        this.f375945b = context;
        this.f375946c = jVar;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = null;
        try {
            int i3 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = this.f375945b.getContentResolver().acquireUnstableContentProviderClient(this.f375944a);
            Bundle call = acquireUnstableContentProviderClient.call(com.tencent.luggage.wxa.q2.e.NAME, null, null);
            if (i3 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call != null && call.getInt("code", -1) == 0) {
                str = call.getString("id");
            }
        } catch (Exception e16) {
            com.tencent.tgpa.lite.g.h.b("MSA Nubia get oaid exception.", new Object[0]);
            e16.printStackTrace();
        }
        j jVar = this.f375946c;
        if (jVar != null) {
            jVar.a(str);
        } else {
            com.tencent.tgpa.lite.g.h.b("MSA oaid callback is null.", new Object[0]);
        }
    }
}
