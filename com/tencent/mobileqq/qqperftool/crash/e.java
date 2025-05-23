package com.tencent.mobileqq.qqperftool.crash;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile List<b> f274256a;

    /* renamed from: b, reason: collision with root package name */
    private String f274257b;

    public e(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f274256a = new CopyOnWriteArrayList();
            this.f274257b = str;
        }
    }

    private synchronized void c(b bVar) {
        if (bVar != null) {
            this.f274256a.add(bVar);
        }
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.d
    public void b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            c(bVar);
        }
    }

    public synchronized List<b> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f274256a);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqperftool.common.c
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f274257b;
    }
}
