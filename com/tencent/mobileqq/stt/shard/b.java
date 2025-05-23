package com.tencent.mobileqq.stt.shard;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected volatile com.tencent.mobileqq.stt.shard.a f290738a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    protected static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f290739a;

        /* renamed from: b, reason: collision with root package name */
        public long f290740b;

        /* renamed from: c, reason: collision with root package name */
        public ByteBuffer f290741c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f290742d;

        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f290742d = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(com.tencent.mobileqq.stt.shard.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f290738a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(a aVar, int i3, int i16, int i17, int i18, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bArr);
        }
        if (aVar == null) {
            aVar = new a();
        }
        if (aVar.f290741c == null) {
            aVar.f290741c = ByteBuffer.allocate(i17);
        }
        if (i16 >= i17) {
            aVar.f290742d = true;
            aVar.f290741c.position(0);
            aVar.f290741c.put(bArr);
            aVar.f290740b = i16;
        } else {
            long j3 = i18;
            if (0 == (aVar.f290739a & j3)) {
                aVar.f290741c.position(i3);
                aVar.f290741c.put(bArr);
                long j16 = aVar.f290740b + i16;
                aVar.f290740b = j16;
                aVar.f290739a |= j3;
                if (j16 >= i17) {
                    aVar.f290742d = true;
                }
            }
        }
        return aVar;
    }
}
