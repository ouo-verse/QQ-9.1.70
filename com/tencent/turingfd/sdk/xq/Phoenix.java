package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* loaded from: classes27.dex */
public class Phoenix implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f382999a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f383000b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Pyxis f383001c;

    public Phoenix(Pyxis pyxis, Context context, Map map) {
        this.f383001c = pyxis;
        this.f382999a = context;
        this.f383000b = map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pyxis, context, map);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f383001c.a(this.f382999a, this.f383000b);
        }
    }
}
