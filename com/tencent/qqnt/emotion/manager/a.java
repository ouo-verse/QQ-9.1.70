package com.tencent.qqnt.emotion.manager;

import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static a f356290b;

    /* renamed from: a, reason: collision with root package name */
    CopyOnWriteArrayList<WeakReference<b>> f356291a;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f356291a = new CopyOnWriteArrayList<>();
        }
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f356290b == null) {
                f356290b = new a();
            }
            aVar = f356290b;
        }
        return aVar;
    }

    @Override // com.tencent.qqnt.emotion.manager.c
    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        Iterator<WeakReference<b>> it = this.f356291a.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() == bVar) {
                this.f356291a.remove(next);
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.manager.c
    public void b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        synchronized (this.f356291a) {
            Iterator<WeakReference<b>> it = this.f356291a.iterator();
            while (it.hasNext()) {
                if (it.next().get() == bVar) {
                    return;
                }
            }
            this.f356291a.add(new WeakReference<>(bVar));
        }
    }

    public void d(EmoticonPackage emoticonPackage, int i3, Bundle bundle) {
        CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, emoticonPackage, Integer.valueOf(i3), bundle);
            return;
        }
        if (emoticonPackage != null && (copyOnWriteArrayList = this.f356291a) != null) {
            Iterator<WeakReference<b>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                b bVar = it.next().get();
                if (bVar != null) {
                    bVar.a(emoticonPackage, i3, bundle);
                }
            }
        }
    }
}
