package com.tencent.mobileqq.uftransfer.common;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue;
import com.tencent.mobileqq.uftransfer.depend.a;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTHashCalculator extends UFTRunnableQueue {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static UFTHashCalculator f304962f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class CalcTask implements UFTRunnableQueue.IUFTRunnable {
        static IPatchRedirector $redirector_;
        int C;
        final a D;
        boolean E;
        Timer F;

        /* renamed from: d, reason: collision with root package name */
        long f304963d;

        /* renamed from: e, reason: collision with root package name */
        final long f304964e;

        /* renamed from: f, reason: collision with root package name */
        long f304965f;

        /* renamed from: h, reason: collision with root package name */
        final String f304966h;

        /* renamed from: i, reason: collision with root package name */
        final b f304967i;

        /* renamed from: m, reason: collision with root package name */
        UFTRunnableQueue.a f304968m;

        CalcTask(String str, long j3, b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UFTHashCalculator.this, str, Long.valueOf(j3), bVar);
                return;
            }
            this.f304965f = 0L;
            this.C = 0;
            this.D = new a();
            this.E = true;
            this.f304966h = str;
            this.f304964e = j3;
            this.f304967i = bVar;
        }

        private synchronized void g() {
            Timer timer = this.F;
            if (timer != null) {
                timer.cancel();
                this.F = null;
            }
        }

        private boolean i(long j3) {
            if ((j3 & this.f304965f) != 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i3) {
            if (this.E) {
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHashCalculator", 1, "[" + this.f304963d + "] calc hash fail. errCode:" + i3);
            g();
            this.E = true;
            this.C = i3;
            this.f304967i.b(this.f304963d, i3, this.D);
            UFTRunnableQueue.a aVar = this.f304968m;
            if (aVar != null) {
                aVar.a(this.f304963d, false, this.C, this);
            }
        }

        private void k() {
            if (this.E) {
                return;
            }
            g();
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHashCalculator", 1, "[" + this.f304963d + "] calc hash suc." + this.D.toString());
            this.C = 0;
            this.E = true;
            this.f304967i.b(this.f304963d, 0, this.D);
            UFTRunnableQueue.a aVar = this.f304968m;
            if (aVar != null) {
                aVar.a(this.f304963d, true, this.C, this);
            }
        }

        private synchronized void m(long j3) {
            g();
            BaseTimer baseTimer = new BaseTimer();
            this.F = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.CalcTask.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) CalcTask.this);
                    }
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        CalcTask.this.j(5);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, j3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void b(boolean z16, boolean z17) {
            if (!z16 && !z17) {
                return;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                MessageDigest messageDigest2 = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                try {
                    FileInputStream fileInputStream = new FileInputStream(this.f304966h);
                    try {
                        try {
                            byte[] bArr = new byte[32768];
                            long j3 = 0;
                            do {
                                int read = fileInputStream.read(bArr);
                                if (read < 0) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                    }
                                    if (z16) {
                                        this.D.f304971b = messageDigest.digest();
                                    }
                                    if (z17) {
                                        this.D.f304972c = messageDigest2.digest();
                                        return;
                                    }
                                    return;
                                }
                                if (z16) {
                                    messageDigest.update(bArr, 0, read);
                                }
                                if (z17) {
                                    messageDigest2.update(bArr, 0, read);
                                }
                                j3 += read;
                                this.f304967i.a(this.f304963d, j3, this.D.f304977h);
                            } while (!this.E);
                            fileInputStream.close();
                        } finally {
                        }
                    } catch (IOException unused) {
                        j(3);
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    j(1);
                }
            } catch (NoSuchAlgorithmException unused3) {
                j(2);
            }
        }

        void e() {
            a.C8866a h16 = com.tencent.mobileqq.uftransfer.depend.a.h(this.f304966h);
            if (h16 != null) {
                a aVar = this.D;
                aVar.f304974e = h16.f305123a;
                aVar.f304975f = h16.f305124b;
                aVar.f304976g = h16.f305125c;
            }
        }

        void f() {
            this.D.f304973d = com.tencent.mobileqq.uftransfer.depend.a.k(this.f304966h);
            if (this.D.f304973d == null && !i(4L)) {
                j(3);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.IUFTRunnable
        public boolean fh(UFTRunnableQueue.IUFTRunnable iUFTRunnable) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) iUFTRunnable)).booleanValue();
            }
            if (iUFTRunnable == null || !(iUFTRunnable instanceof CalcTask) || (str = ((CalcTask) iUFTRunnable).f304966h) == null || !str.equals(this.f304966h)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.IUFTRunnable
        public long getId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
            }
            return this.f304963d;
        }

        void h() {
            this.D.f304970a = com.tencent.mobileqq.uftransfer.depend.a.j(this.f304966h);
            if (this.D.f304970a == null && !i(1L)) {
                j(3);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.IUFTRunnable
        public boolean j9(UFTRunnableQueue.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
            }
            this.f304968m = aVar;
            this.E = false;
            m(90000L);
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHashCalculator", 1, "[" + this.f304963d + "] start");
            com.tencent.mobileqq.uftransfer.depend.a.B(this, 5, true);
            return true;
        }

        public void l(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else {
                this.f304965f = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (this.E) {
                return;
            }
            boolean z17 = true;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHashCalculator", 1, "[" + this.f304963d + "] run calc hash.");
            if (this.f304964e == 0) {
                this.f304967i.e(this.f304963d, 0L);
                this.C = 0;
                k();
                return;
            }
            File file = new File(this.f304966h);
            if (file.exists() && (file.isFile() || file.length() >= 0)) {
                this.D.f304977h = file.length();
                this.f304967i.e(this.f304963d, this.D.f304977h);
                if ((this.f304964e & 1) != 0) {
                    h();
                    if (this.E) {
                        return;
                    }
                }
                if ((this.f304964e & 4) != 0) {
                    f();
                    if (this.E) {
                        return;
                    }
                }
                if ((this.f304964e & 16) != 0) {
                    e();
                    if (this.E) {
                        return;
                    }
                }
                long j3 = this.f304964e;
                if ((2 & j3) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((j3 & 8) == 0) {
                    z17 = false;
                }
                if (z16 || z17) {
                    b(z16, z17);
                    if (this.E) {
                        return;
                    }
                }
                k();
                return;
            }
            this.f304967i.e(this.f304963d, 0L);
            j(1);
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.IUFTRunnable
        public void setId(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            } else {
                this.f304963d = j3;
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.IUFTRunnable
        public void stop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTHashCalculator", 1, "[" + this.f304963d + "] stop");
            g();
            this.E = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        byte[] f304970a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f304971b;

        /* renamed from: c, reason: collision with root package name */
        byte[] f304972c;

        /* renamed from: d, reason: collision with root package name */
        byte[] f304973d;

        /* renamed from: e, reason: collision with root package name */
        int f304974e;

        /* renamed from: f, reason: collision with root package name */
        int f304975f;

        /* renamed from: g, reason: collision with root package name */
        int f304976g;

        /* renamed from: h, reason: collision with root package name */
        long f304977h;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTHashCalculator.this);
                return;
            }
            this.f304974e = 0;
            this.f304975f = 0;
            this.f304976g = 0;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public byte[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f304971b;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public byte[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f304972c;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public byte[] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f304973d;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public byte[] d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f304970a;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.f304975f;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.f304974e;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public long getFileSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f304977h;
        }

        @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.c
        public int getVideoDuration() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.f304976g;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return " fileSize:" + this.f304977h + " 10Mmd5:" + com.tencent.mobileqq.uftransfer.depend.a.a(this.f304970a) + "md5:" + com.tencent.mobileqq.uftransfer.depend.a.a(this.f304971b) + " sha1:" + com.tencent.mobileqq.uftransfer.depend.a.a(this.f304972c) + " sha3:" + com.tencent.mobileqq.uftransfer.depend.a.a(this.f304973d) + " mWith:" + this.f304974e + " mHeight:" + this.f304975f + " mDuration:" + this.f304976g;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(long j3, long j16, long j17);

        void b(long j3, int i3, c cVar);

        void e(long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        byte[] a();

        byte[] b();

        byte[] c();

        byte[] d();

        int e();

        int f();

        long getFileSize();

        int getVideoDuration();
    }

    UFTHashCalculator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized UFTHashCalculator o() {
        UFTHashCalculator uFTHashCalculator;
        synchronized (UFTHashCalculator.class) {
            if (f304962f == null) {
                f304962f = new UFTHashCalculator();
            }
            uFTHashCalculator = f304962f;
        }
        return uFTHashCalculator;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return 4;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
    }

    public long m(String str, long j3, long j16, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Long.valueOf(j16), bVar)).longValue();
        }
        if (TextUtils.isEmpty(str) || bVar == null || j3 == 0) {
            return 0L;
        }
        CalcTask calcTask = new CalcTask(str, j3, bVar);
        calcTask.l(j16);
        e(calcTask);
        return calcTask.getId();
    }

    public void n(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            k(j3);
        }
    }
}
