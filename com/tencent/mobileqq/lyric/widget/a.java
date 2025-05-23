package com.tencent.mobileqq.lyric.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<InterfaceC7999a> f243251a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.lyric.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7999a {
        void a(long j3);

        void b(long j3);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243251a = Collections.synchronizedList(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j3) {
        Iterator<InterfaceC7999a> it = this.f243251a.iterator();
        while (it.hasNext()) {
            it.next().a(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j3) {
        Iterator<InterfaceC7999a> it = this.f243251a.iterator();
        while (it.hasNext()) {
            it.next().b(j3);
        }
    }
}
