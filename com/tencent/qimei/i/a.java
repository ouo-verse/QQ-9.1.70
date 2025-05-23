package com.tencent.qimei.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (context != null && intent != null) {
            boolean z16 = false;
            int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
            c.b("shouldUpdateId, notifyFlag : " + intExtra);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                    if (stringArrayListExtra == null) {
                        return;
                    }
                    boolean contains = stringArrayListExtra.contains(context.getPackageName());
                    if (contains) {
                        b a16 = c.a().a(intent.getStringExtra("openIdType"));
                        if (a16 != null) {
                            a16.f343302b = 0L;
                            return;
                        }
                        return;
                    }
                    z16 = contains;
                } else {
                    z16 = true;
                }
                if (intExtra == 0 && z16) {
                    b a17 = c.a().a(intent.getStringExtra("openIdType"));
                    if (a17 != null) {
                        a17.f343302b = 0L;
                        return;
                    }
                    return;
                }
            } else if (TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                z16 = true;
            }
            if (z16) {
                b a18 = c.a().a(intent.getStringExtra("openIdType"));
                if (a18 != null) {
                    a18.f343302b = 0L;
                }
            }
        }
    }
}
