package com.tencent.ams.fusion.service.c.a;

import com.tencent.ams.fusion.a.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;
import kt.d;
import kt.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b<T extends d, R extends e> implements kt.b<T, R> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<kt.b<?, ?>> f70255a;

    /* renamed from: b, reason: collision with root package name */
    private String f70256b;

    public b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f70255a = new LinkedList<>();
            this.f70256b = str;
        }
    }

    public void a(kt.b<?, ?> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else if (bVar != null) {
            this.f70255a.add(bVar);
        }
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.f70256b;
        if (str == null) {
            return "SerialTask";
        }
        return str;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [kt.e] */
    @Override // kt.c
    public R c() {
        long c16;
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (R) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        while (this.f70255a.size() > 0) {
            kt.b<?, ?> poll = this.f70255a.poll();
            if (poll != null) {
                f.i(poll.b() + " onPreExecute");
                f.i("SerialTask execute " + poll.getClass().getSimpleName());
                ?? c17 = poll.c();
                if (c17 == 0) {
                    c16 = -1;
                } else {
                    c16 = c17.c();
                }
                if (c16 > -1) {
                    str = " timeCost:" + c16;
                } else {
                    str = "";
                }
                f.i(poll.b() + " onAfterExecute" + str);
                if (c17 != 0 && !c17.b()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                f.i("after " + poll.b() + " needContinue:" + z16);
                if (!z16) {
                    return null;
                }
            }
        }
        return null;
    }
}
