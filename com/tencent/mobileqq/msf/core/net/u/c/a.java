package com.tencent.mobileqq.msf.core.net.u.c;

import android.util.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f249428b = "BufferPool";

    /* renamed from: c, reason: collision with root package name */
    public static final int f249429c = 65536;

    /* renamed from: d, reason: collision with root package name */
    private static int f249430d = 8192;

    /* renamed from: a, reason: collision with root package name */
    private final LruCache<Thread, byte[]> f249431a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f249433a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27119);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249433a = new a(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23016);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        }
    }

    /* synthetic */ a(C8093a c8093a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8093a);
    }

    public static a d() {
        return b.f249433a;
    }

    public byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Thread currentThread = Thread.currentThread();
        byte[] bArr = this.f249431a.get(currentThread);
        if (bArr.length < f249430d) {
            c();
            bArr = new byte[f249430d];
            this.f249431a.put(currentThread, bArr);
        }
        QLog.d(f249428b, 1, "[acquireBuffer] buffer size: ", Integer.valueOf(f249430d));
        return bArr;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(f249428b, 1, "[expandBufferSize] before expand size: ", Integer.valueOf(f249430d));
        int i3 = f249430d * 2;
        if (i3 <= 65536) {
            f249430d = i3;
        }
        QLog.d(f249428b, 1, "[expandBufferSize] after expand size: ", Integer.valueOf(f249430d));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.u.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8093a extends LruCache<Thread, byte[]> {
        static IPatchRedirector $redirector_;

        C8093a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] create(Thread thread) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) thread);
            }
            QLog.d(a.f249428b, 1, "[create] alloc buffer size: ", Integer.valueOf(a.f249430d), ", thread: ", thread);
            return new byte[a.f249430d];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z16, Thread thread, byte[] bArr, byte[] bArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), thread, bArr, bArr2);
                return;
            }
            Object[] objArr = new Object[8];
            objArr[0] = "[entryRemoved] ev: ";
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = ", thread: ";
            objArr[3] = thread;
            objArr[4] = ", old: ";
            objArr[5] = Integer.valueOf(bArr != null ? bArr.length : 0);
            objArr[6] = ", new: ";
            objArr[7] = Integer.valueOf(bArr2 != null ? bArr2.length : 0);
            QLog.d(a.f249428b, 1, objArr);
            super.entryRemoved(z16, thread, bArr, bArr2);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f249431a = new C8093a(5);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
