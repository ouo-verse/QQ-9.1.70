package com.tencent.mobileqq.avifcodec;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f200169d;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f200170a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f200171b;

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArraySet<x91.a> f200172c;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200170a = new AtomicInteger(-2);
        this.f200171b = false;
        this.f200172c = new CopyOnWriteArraySet<>();
    }

    public static b b() {
        if (f200169d == null) {
            synchronized (b.class) {
                if (f200169d == null) {
                    f200169d = new b();
                }
            }
        }
        return f200169d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i3, LoadExtResult loadExtResult) {
        boolean z16 = true;
        QLog.i("AvifLibraryLoader", 1, "avif load result:" + i3);
        if (i3 != 0) {
            z16 = false;
        }
        this.f200171b = z16;
        this.f200170a.set(0);
        g();
    }

    private void g() {
        Iterator<x91.a> it = this.f200172c.iterator();
        while (it.hasNext()) {
            it.next().onAvifLibraryLoadResult(this.f200171b);
        }
        this.f200172c.clear();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f200170a.get() == 0 && this.f200171b) {
            return true;
        }
        return false;
    }

    public synchronized boolean d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f200170a.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public synchronized void f(@Nullable x91.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            this.f200172c.add(aVar);
        }
        if (this.f200170a.get() == 0) {
            if (aVar != null) {
                aVar.onAvifLibraryLoadResult(this.f200171b);
                this.f200172c.remove(aVar);
            }
            QLog.i("AvifLibraryLoader", 1, "avif has been loaded");
            return;
        }
        if (this.f200170a.get() == -1) {
            QLog.i("AvifLibraryLoader", 1, "avif has been loading");
            return;
        }
        this.f200170a.set(-1);
        try {
            SoLoadManager.getInstance().load("tencent-avif-v2", new OnLoadListener() { // from class: com.tencent.mobileqq.avifcodec.a
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    b.this.e(i3, loadExtResult);
                }
            });
        } catch (Throwable th5) {
            QLog.e("AvifLibraryLoader", 1, "load avif library failed:" + th5);
        }
    }
}
