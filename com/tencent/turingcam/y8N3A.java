package com.tencent.turingcam;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class y8N3A implements QmgHg {
    static IPatchRedirector $redirector_;

    public y8N3A() {
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
    @Override // com.tencent.turingcam.QmgHg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public wmqhz a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (wmqhz) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Uri parse = Uri.parse(LwgsO.a(LwgsO.f381942x0));
        String a16 = LwgsO.a(LwgsO.f381881a);
        int i3 = Build.VERSION.SDK_INT;
        ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
        Bundle bundle = null;
        try {
            bundle = acquireContentProviderClient.call(a16, null, null);
        } catch (Throwable unused) {
            if (acquireContentProviderClient != null) {
            }
            if (bundle == null) {
                return wmqhz.a(-1);
            }
            if (bundle.getInt(LwgsO.a(LwgsO.f381944y0), -1) != 0) {
                return wmqhz.a(-2);
            }
            return new wmqhz(bundle.getString(LwgsO.a(LwgsO.f381946z0)), 0);
        }
    }

    @Override // com.tencent.turingcam.QmgHg
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }
}
