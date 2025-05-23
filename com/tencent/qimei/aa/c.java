package com.tencent.qimei.aa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.channels.FileChannel;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f342892a;

    public c(e eVar) {
        this.f342892a = eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            synchronized (this.f342892a.f342901g) {
                byte[] bytes = this.f342892a.f342897c.toString().getBytes("ISO8859-1");
                this.f342892a.getClass();
                byte[] a16 = com.tencent.qimei.f.a.a(bytes, com.tencent.qimei.f.a.a("BEACONDEFAULTAES").getBytes(), 1);
                if (a16 == null) {
                    return;
                }
                long length = a16.length + 10;
                e eVar = this.f342892a;
                if (length > eVar.f342899e) {
                    long length2 = a16.length + 10;
                    eVar.f342899e = length2;
                    if (length2 <= 2097152) {
                        eVar.f342898d.rewind();
                        eVar.f342898d = eVar.f342896b.map(FileChannel.MapMode.READ_WRITE, 0L, length2);
                    } else {
                        throw new IllegalArgumentException("file size to reach maximum!");
                    }
                }
                this.f342892a.f342898d.putInt(0, a16.length);
                this.f342892a.f342898d.position(10);
                this.f342892a.f342898d.put(a16);
                this.f342892a.f342898d.force();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
