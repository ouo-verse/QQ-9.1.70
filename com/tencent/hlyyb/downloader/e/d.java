package com.tencent.hlyyb.downloader.e;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile long f114489a;

    /* renamed from: b, reason: collision with root package name */
    public volatile LinkedList<a> f114490b;

    /* renamed from: c, reason: collision with root package name */
    public Object f114491c;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f114493a;

        /* renamed from: b, reason: collision with root package name */
        public long f114494b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f114495c;

        /* renamed from: d, reason: collision with root package name */
        public long f114496d;

        public a(int i3, long j3, byte[] bArr, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, Long.valueOf(j16));
                return;
            }
            this.f114493a = i3;
            this.f114494b = j3;
            this.f114495c = bArr;
            this.f114496d = j16;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114489a = 0L;
        this.f114490b = new LinkedList<>();
        this.f114491c = new Object();
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f114489a;
    }

    public final void b(int i3, long j3, byte[] bArr, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), bArr, Long.valueOf(j16));
            return;
        }
        synchronized (this.f114491c) {
            LinkedList<a> linkedList = this.f114490b;
            int i16 = (int) j16;
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, 0, bArr2, 0, i16);
            linkedList.addLast(new a(i3, j3, bArr2, j16));
            this.f114489a += j16;
        }
    }

    public final a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (this.f114491c) {
            if (this.f114490b.size() > 0) {
                a removeFirst = this.f114490b.removeFirst();
                this.f114489a -= removeFirst.f114496d;
                return removeFirst;
            }
            return null;
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        synchronized (this.f114491c) {
            do {
            } while (c() != null);
        }
    }
}
