package com.tencent.halley.downloader.task;

import android.os.SystemClock;
import com.tencent.halley.common.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    long f113758a;

    /* renamed from: b, reason: collision with root package name */
    public long f113759b;

    /* renamed from: c, reason: collision with root package name */
    long f113760c;

    /* renamed from: d, reason: collision with root package name */
    private c f113761d;

    /* renamed from: e, reason: collision with root package name */
    private long f113762e;

    /* renamed from: f, reason: collision with root package name */
    private long f113763f;

    /* renamed from: g, reason: collision with root package name */
    private int f113764g;

    /* renamed from: h, reason: collision with root package name */
    private int f113765h;

    /* renamed from: i, reason: collision with root package name */
    private List<C1246a> f113766i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1246a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f113767a;

        /* renamed from: b, reason: collision with root package name */
        int f113768b;

        public C1246a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.f113768b = 0;
                this.f113767a = i3;
            }
        }
    }

    public a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            return;
        }
        this.f113758a = 0L;
        this.f113759b = 0L;
        this.f113760c = 0L;
        this.f113762e = 0L;
        this.f113763f = 0L;
        this.f113764g = 0;
        this.f113765h = 0;
        this.f113766i = new LinkedList();
        this.f113761d = cVar;
    }

    private int b() {
        if (this.f113766i.size() == 0) {
            return 0;
        }
        long j3 = 0;
        for (C1246a c1246a : this.f113766i) {
            if (c1246a.f113768b <= 2000) {
                j3 += c1246a.f113767a;
                if (j3 < 0) {
                    d.d("halley-downloader-CostTimeCounter", "sum:" + j3 + ",len:" + c1246a.f113767a);
                }
            }
        }
        return (int) ((j3 * 1000) / 2000);
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f113760c - this.f113759b : ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bd, code lost:
    
        if ((r3 - r9.f113763f) > 200) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f113765h += i16;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - this.f113758a;
        this.f113758a = elapsedRealtime;
        this.f113761d.C += j3;
        boolean z17 = i3 <= 0;
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        int i17 = (int) (elapsedRealtime2 - this.f113762e);
        this.f113762e = elapsedRealtime2;
        if (this.f113766i.size() != 0) {
            for (C1246a c1246a : this.f113766i) {
                int i18 = c1246a.f113768b + i17;
                c1246a.f113768b = i18;
                if (!z17 && i18 > 2000) {
                    c1246a.f113768b = 0;
                    c1246a.f113767a = i3;
                    z17 = true;
                }
            }
            if (!z17) {
                if (this.f113766i.size() > (2000 / com.tencent.halley.downloader.a.a.f113581d) + 1) {
                    d.e("halley-downloader-CostTimeCounter", "records.size():" + this.f113766i.size());
                } else {
                    this.f113766i.add(new C1246a(i3));
                }
            }
        } else if (!z17) {
            this.f113766i.add(new C1246a(i3));
        }
        z16 = true;
        if (z16) {
            this.f113764g = b();
            this.f113763f = elapsedRealtime2;
        }
        this.f113761d.K = this.f113764g;
    }
}
