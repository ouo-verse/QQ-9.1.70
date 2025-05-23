package com.tencent.tfd.sdk.wxa;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Gemini implements Cstrictfp {
    static IPatchRedirector $redirector_;

    public Gemini() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.Cstrictfp
    public final void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        if (r2 >= 24) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        r5.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003b, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L16;
     */
    @Override // com.tencent.tfd.sdk.wxa.Cstrictfp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Eridanus b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Eridanus) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Uri parse = Uri.parse(Cswitch.a(Cswitch.f375830x0));
        String a16 = Cswitch.a(Cswitch.f375781a);
        int i3 = Build.VERSION.SDK_INT;
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
        Bundle bundle = null;
        try {
            bundle = acquireContentProviderClient.call(a16, null, null);
        } catch (Throwable unused) {
            if (acquireContentProviderClient != null) {
            }
            if (bundle == null) {
                return Eridanus.a(-1);
            }
            if (bundle.getInt(Cswitch.a(Cswitch.f375832y0), -1) != 0) {
                return Eridanus.a(-2);
            }
            return new Eridanus(bundle.getString(Cswitch.a(Cswitch.f375834z0)), 0);
        }
    }
}
