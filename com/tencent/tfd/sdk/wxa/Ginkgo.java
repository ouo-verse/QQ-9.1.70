package com.tencent.tfd.sdk.wxa;

import com.tencent.luggage.wxa.ia.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Ginkgo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Object f375617a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f375618b;

    /* renamed from: c, reason: collision with root package name */
    public Process f375619c;

    /* renamed from: d, reason: collision with root package name */
    public DataOutputStream f375620d;

    /* renamed from: e, reason: collision with root package name */
    public Cdo f375621e;

    /* renamed from: f, reason: collision with root package name */
    public Cdo f375622f;

    /* renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f375623g;

    /* renamed from: h, reason: collision with root package name */
    public ByteArrayOutputStream f375624h;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Ginkgo$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public InputStream f375625a;

        /* renamed from: b, reason: collision with root package name */
        public ByteArrayOutputStream f375626b;

        public Cdo(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Ginkgo.this, str, inputStream, byteArrayOutputStream);
            } else {
                this.f375625a = inputStream;
                this.f375626b = byteArrayOutputStream;
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                bArr = new byte[1024];
            } catch (Exception unused) {
                return;
            }
            while (true) {
                int read = this.f375625a.read(bArr);
                if (read < 0) {
                    synchronized (Ginkgo.this.f375618b) {
                        this.f375626b.write(":RET=EOF".getBytes());
                        this.f375626b.flush();
                    }
                    synchronized (Ginkgo.this.f375617a) {
                        Ginkgo.this.f375617a.notifyAll();
                    }
                    return;
                }
                if (read > 0) {
                    synchronized (Ginkgo.this.f375618b) {
                        this.f375626b.write(bArr, 0, read);
                        this.f375626b.flush();
                    }
                    synchronized (Ginkgo.this.f375617a) {
                        Ginkgo.this.f375617a.notifyAll();
                    }
                }
                return;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Ginkgo$for, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cfor {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f375628a;

        /* renamed from: b, reason: collision with root package name */
        public final String f375629b;

        /* renamed from: c, reason: collision with root package name */
        public final long f375630c;

        public Cfor(String str, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
                return;
            }
            this.f375628a = str;
            this.f375629b = str2;
            this.f375630c = j3;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Ginkgo$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f375631a;

        /* renamed from: b, reason: collision with root package name */
        public final String f375632b;

        public Cif(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f375631a = str;
                this.f375632b = str2;
            }
        }
    }

    public Ginkgo() throws IllegalArgumentException, FileNotFoundException, IOException, InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Object obj = new Object();
        this.f375617a = obj;
        this.f375618b = new Object();
        this.f375623g = new ByteArrayOutputStream();
        this.f375624h = new ByteArrayOutputStream();
        this.f375619c = (Process) a.a(Runtime.getRuntime(), new com.tencent.luggage.wxa.ja.a().a("sh").a(), "com/tencent/tfd/sdk/wxa/Ginkgo", "<init>", "()V", "java/lang/Runtime", "exec", "(Ljava/lang/String;)Ljava/lang/Process;");
        synchronized (obj) {
            obj.wait(10L);
        }
        try {
            this.f375619c.exitValue();
        } catch (Exception unused) {
            z16 = false;
        }
        if (!z16) {
            this.f375620d = new DataOutputStream(this.f375619c.getOutputStream());
            this.f375621e = new Cdo(ReportConstant.COSTREPORT_PREFIX, this.f375619c.getInputStream(), this.f375623g);
            this.f375622f = new Cdo("e", this.f375619c.getErrorStream(), this.f375624h);
            synchronized (this.f375617a) {
                this.f375617a.wait(10L);
            }
            this.f375621e.start();
            this.f375622f.start();
            return;
        }
        throw new IOException();
    }

    public final Cif a(Cfor cfor, long j3) throws InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Cif) iPatchRedirector.redirect((short) 4, this, cfor, Long.valueOf(j3));
        }
        synchronized (this.f375617a) {
            synchronized (this.f375618b) {
                if (new String(this.f375623g.toByteArray()).lastIndexOf(":RET=") != -1) {
                    z16 = false;
                }
            }
            if (z16) {
                this.f375617a.wait(j3);
            }
        }
        synchronized (this.f375618b) {
            byte[] byteArray = this.f375623g.toByteArray();
            byte[] byteArray2 = this.f375624h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") == -1) {
                return null;
            }
            this.f375623g.reset();
            this.f375624h.reset();
            if (str.lastIndexOf(":RET=0") != -1) {
                return new Cif(str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            if (str.lastIndexOf(":RET=EOF") == -1) {
                str2.lastIndexOf(":RET=EOF");
            }
            return new Cif(str.substring(0, str.lastIndexOf(":RET=")), str2);
        }
    }

    public final void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            try {
                a();
            } catch (Throwable unused) {
            }
            super.finalize();
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            this.f375620d.write("exit\n".getBytes());
            this.f375620d.flush();
            this.f375619c.wait(100L);
        } catch (Exception unused) {
        }
        Cdo cdo = this.f375621e;
        if (cdo != null) {
            cdo.interrupt();
            this.f375621e = null;
        }
        Cdo cdo2 = this.f375622f;
        if (cdo2 != null) {
            cdo2.interrupt();
            this.f375622f = null;
        }
        Process process = this.f375619c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.f375619c = null;
        }
    }

    public final synchronized Cif a(Cfor cfor) throws IllegalArgumentException, IOException, InterruptedException, TimeoutException {
        boolean z16;
        Cif a16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cif) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cfor);
        }
        String str2 = cfor.f375628a;
        if (str2 != null && str2.length() > 0 && (str = cfor.f375629b) != null && str.length() > 0) {
            z16 = false;
            if (z16 && cfor.f375630c >= 0) {
                synchronized (this.f375618b) {
                    this.f375623g.reset();
                    this.f375624h.reset();
                }
                this.f375620d.write((cfor.f375629b + "\n").getBytes());
                this.f375620d.flush();
                synchronized (this.f375617a) {
                    this.f375617a.wait(10L);
                }
                this.f375620d.writeBytes("echo :RET=$?\n");
                this.f375620d.flush();
                long nanoTime = System.nanoTime();
                long j3 = 0;
                do {
                    long j16 = cfor.f375630c;
                    if (j16 != 0) {
                        j3 = j16 - ((System.nanoTime() - nanoTime) / 1000000);
                        if (j3 <= 0) {
                            throw new TimeoutException("t");
                        }
                    }
                    a16 = a(cfor, j3);
                } while (a16 == null);
                return a16;
            }
            throw new IllegalArgumentException("v");
        }
        z16 = true;
        if (z16) {
        }
        throw new IllegalArgumentException("v");
    }
}
