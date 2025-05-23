package com.tencent.halley.common.c.a;

import android.os.SystemClock;
import com.tencent.halley.common.a.d;
import com.tencent.halley.common.b.a.c;
import com.tencent.halley.common.b.a.f;
import com.tencent.halley.common.c.b;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private final String f113371c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113371c = "https://up-hl.3g.qq.com/upreport";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z16) {
        this.f113391b.a(z16, this.f113390a);
        return z16;
    }

    @Override // com.tencent.halley.common.c.b
    public final boolean a(byte[] bArr, int i3, boolean z16, Object obj, b.a aVar, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Boolean.valueOf(z16), obj, aVar, Integer.valueOf(i16))).booleanValue();
        }
        j.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f113391b = aVar;
        this.f113390a = obj;
        HashMap hashMap = new HashMap();
        hashMap.put("B-Length", String.valueOf(i3));
        hashMap.put("HLReportCmd", i16 == 1 ? "devlog" : z16 ? "realtime_speed" : "hllog");
        c a16 = c.a("https://up-hl.3g.qq.com/upreport", hashMap, bArr, 20000, j.h(), null);
        a16.f113307o = false;
        a16.f113309q = "event";
        try {
            d.a().f113264a.execute(new Runnable(a16, elapsedRealtime) { // from class: com.tencent.halley.common.c.a.a.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ c f113373a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ long f113374b;

                {
                    this.f113373a = a16;
                    this.f113374b = elapsedRealtime;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, a.this, a16, Long.valueOf(elapsedRealtime));
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean z17 = false;
                    try {
                        f b16 = this.f113373a.b();
                        this.f113373a.f113296l = SystemClock.elapsedRealtime() - this.f113374b;
                        this.f113373a.a(false);
                        if (b16.f113322a == 0) {
                            if (b16.f113324c == 200) {
                                z17 = true;
                            }
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
            return true;
        } catch (Throwable unused) {
            return a(false);
        }
    }
}
