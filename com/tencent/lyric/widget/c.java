package com.tencent.lyric.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<a> f147264a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(long j3);

        void b(long j3, long j16);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f147264a = Collections.synchronizedList(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j3) {
        Iterator<a> it = this.f147264a.iterator();
        while (it.hasNext()) {
            it.next().a(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j3, int i3) {
        Iterator<a> it = this.f147264a.iterator();
        while (it.hasNext()) {
            it.next().b(j3, i3);
        }
    }
}
