package com.tencent.mobileqq.bigbrother;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardManager;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static f f200379f;

    /* renamed from: d, reason: collision with root package name */
    private int f200380d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<e> f200381e;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f200381e = new SparseArray<>();
        }
    }

    public static f d() {
        if (f200379f == null) {
            synchronized (CheckForwardManager.class) {
                if (f200379f == null) {
                    f200379f = new f();
                }
            }
        }
        return f200379f;
    }

    public int a(Context context, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) aVar)).intValue();
        }
        return c(new e(context, aVar));
    }

    public int b(Context context, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) cVar)).intValue();
        }
        return c(new e(context, cVar));
    }

    public int c(e eVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar)).intValue();
        }
        synchronized (this.f200381e) {
            SparseArray<e> sparseArray = this.f200381e;
            int i16 = this.f200380d + 1;
            this.f200380d = i16;
            sparseArray.append(i16, eVar);
            i3 = this.f200380d;
        }
        return i3;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        int i16 = bundle.getInt(CheckForwardServlet.KEY_REQ_ID);
        e eVar = this.f200381e.get(i16);
        if (eVar == null) {
            return;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                eVar.b(z16, bundle.getInt("jump", 0), bundle.getInt(CheckForwardServlet.KEY_ERR_CODE, 0), bundle.getString("err_msg"));
            }
        } else {
            eVar.a(z16, bundle.getBoolean(CheckForwardServlet.KEY_ALLOW_DOWNLOAD, true), bundle.getInt(CheckForwardServlet.KEY_ERR_CODE, 0), bundle.getString("err_msg"), bundle.getString("jump_url"));
        }
        this.f200381e.delete(i16);
    }
}
