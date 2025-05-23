package com.tencent.turingfd.sdk.xq;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bergamot implements Dorado {
    static IPatchRedirector $redirector_;

    public Bergamot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
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
    @Override // com.tencent.turingfd.sdk.xq.Dorado
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Avocado a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Avocado) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Uri parse = Uri.parse(Ccontinue.a(Ccontinue.f383309x0));
        String a16 = Ccontinue.a(Ccontinue.f383249a);
        int i3 = Build.VERSION.SDK_INT;
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
        Bundle bundle = null;
        try {
            bundle = acquireContentProviderClient.call(a16, null, null);
        } catch (Throwable unused) {
            if (acquireContentProviderClient != null) {
            }
            if (bundle == null) {
                return Avocado.a(-1);
            }
            if (bundle.getInt(Ccontinue.a(Ccontinue.f383311y0), -1) != 0) {
                return Avocado.a(-2);
            }
            return new Avocado(bundle.getString(Ccontinue.a(Ccontinue.f383313z0)), 0);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Dorado
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }
}
