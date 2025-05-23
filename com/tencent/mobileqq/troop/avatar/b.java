package com.tencent.mobileqq.troop.avatar;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import java.net.HttpURLConnection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Bundle f294539a;

    /* renamed from: b, reason: collision with root package name */
    protected c f294540b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f294540b;
    }

    public abstract int b(HttpURLConnection httpURLConnection, TroopUploadingThread.b bVar, g gVar);

    public abstract List<String> c(AppInterface appInterface);

    public void d(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            this.f294539a = bundle;
        }
    }

    public abstract void e(AppInterface appInterface);
}
