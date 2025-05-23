package com.tencent.halley.downloader.task.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f113789a;

    /* renamed from: b, reason: collision with root package name */
    private volatile LinkedList<C1247a> f113790b;

    /* renamed from: c, reason: collision with root package name */
    private Object f113791c;

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.task.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1247a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f113792a;

        /* renamed from: b, reason: collision with root package name */
        public long f113793b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f113794c;

        /* renamed from: d, reason: collision with root package name */
        public long f113795d;

        public C1247a(int i3, long j3, byte[] bArr, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, Long.valueOf(j16));
                return;
            }
            this.f113792a = i3;
            this.f113793b = j3;
            this.f113794c = bArr;
            this.f113795d = j16;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113789a = 0L;
        this.f113790b = new LinkedList<>();
        this.f113791c = new Object();
    }

    public final C1247a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C1247a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (this.f113791c) {
            if (this.f113790b.size() <= 0) {
                return null;
            }
            C1247a removeFirst = this.f113790b.removeFirst();
            this.f113789a -= removeFirst.f113795d;
            return removeFirst;
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f113791c) {
            do {
            } while (a() != null);
        }
    }

    public final void a(int i3, long j3, byte[] bArr, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, Long.valueOf(j16));
            return;
        }
        synchronized (this.f113791c) {
            LinkedList<C1247a> linkedList = this.f113790b;
            int i16 = (int) j16;
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, 0, bArr2, 0, i16);
            linkedList.addLast(new C1247a(i3, j3, bArr2, j16));
            this.f113789a += j16;
        }
    }
}
