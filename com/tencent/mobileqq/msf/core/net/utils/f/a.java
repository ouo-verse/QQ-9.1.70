package com.tencent.mobileqq.msf.core.net.utils.f;

import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: d, reason: collision with root package name */
    protected static final String f249515d = "enable";

    /* renamed from: a, reason: collision with root package name */
    protected String f249516a;

    /* renamed from: b, reason: collision with root package name */
    protected List<Pair<String, String>> f249517b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f249518c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f249516a : (String) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public abstract boolean a(Pair<String, String> pair);

    public abstract boolean a(@NonNull String str, List<Pair<String, String>> list);

    public abstract boolean b();

    public boolean a(@NonNull String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (b()) {
            Iterator<Pair<String, String>> it = this.f249517b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = true;
                    break;
                }
                if (!a(it.next())) {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                try {
                    return a(str, this.f249517b);
                } catch (Throwable th5) {
                    try {
                        QLog.e(MsfCmdConfig.TAG, 1, getClass().getSimpleName() + ".execute failed!", th5);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return false;
    }
}
