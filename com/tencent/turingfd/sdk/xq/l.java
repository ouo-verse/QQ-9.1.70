package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Object f383381a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f383382b;

    /* renamed from: c, reason: collision with root package name */
    public Process f383383c;

    /* renamed from: d, reason: collision with root package name */
    public DataOutputStream f383384d;

    /* renamed from: e, reason: collision with root package name */
    public Cdo f383385e;

    /* renamed from: f, reason: collision with root package name */
    public Cdo f383386f;

    /* renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f383387g;

    /* renamed from: h, reason: collision with root package name */
    public ByteArrayOutputStream f383388h;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.l$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class Cdo extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public InputStream f383389a;

        /* renamed from: b, reason: collision with root package name */
        public ByteArrayOutputStream f383390b;

        public Cdo(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, l.this, str, inputStream, byteArrayOutputStream);
            } else {
                this.f383389a = inputStream;
                this.f383390b = byteArrayOutputStream;
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
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
                int read = this.f383389a.read(bArr);
                if (read < 0) {
                    synchronized (l.this.f383382b) {
                        this.f383390b.write(":RET=EOF".getBytes());
                        this.f383390b.flush();
                    }
                    synchronized (l.this.f383381a) {
                        l.this.f383381a.notifyAll();
                    }
                    return;
                }
                if (read > 0) {
                    synchronized (l.this.f383382b) {
                        this.f383390b.write(bArr, 0, read);
                        this.f383390b.flush();
                    }
                    synchronized (l.this.f383381a) {
                        l.this.f383381a.notifyAll();
                    }
                }
                return;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.l$for, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cfor {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f383392a;

        /* renamed from: b, reason: collision with root package name */
        public final String f383393b;

        /* renamed from: c, reason: collision with root package name */
        public final long f383394c;

        public Cfor(String str, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
                return;
            }
            this.f383392a = str;
            this.f383393b = str2;
            this.f383394c = j3;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.l$if, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cif {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f383395a;

        /* renamed from: b, reason: collision with root package name */
        public final String f383396b;

        public Cif(String str, Integer num, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, num, str2, str3);
            } else {
                this.f383395a = str2;
                this.f383396b = str3;
            }
        }
    }

    public l(String str) throws IllegalArgumentException, FileNotFoundException, IOException, InterruptedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        Object obj = new Object();
        this.f383381a = obj;
        this.f383382b = new Object();
        this.f383387g = new ByteArrayOutputStream();
        this.f383388h = new ByteArrayOutputStream();
        if (str != null && str.length() != 0) {
            if (str.startsWith("/") && !new File(str).exists()) {
                throw new FileNotFoundException();
            }
            this.f383383c = RuntimeMonitor.exec(Runtime.getRuntime(), str);
            synchronized (obj) {
                obj.wait(10L);
            }
            try {
                this.f383383c.exitValue();
            } catch (Exception unused) {
                z16 = false;
            }
            if (!z16) {
                this.f383384d = new DataOutputStream(this.f383383c.getOutputStream());
                this.f383385e = new Cdo(ReportConstant.COSTREPORT_PREFIX, this.f383383c.getInputStream(), this.f383387g);
                this.f383386f = new Cdo("e", this.f383383c.getErrorStream(), this.f383388h);
                synchronized (this.f383381a) {
                    this.f383381a.wait(10L);
                }
                this.f383385e.start();
                this.f383386f.start();
                return;
            }
            throw new IOException();
        }
        throw new IllegalArgumentException();
    }

    public final Cif a(Cfor cfor, long j3) throws InterruptedException {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Cif) iPatchRedirector.redirect((short) 4, this, cfor, Long.valueOf(j3));
        }
        synchronized (this.f383381a) {
            synchronized (this.f383382b) {
                z16 = new String(this.f383387g.toByteArray()).lastIndexOf(":RET=") == -1;
            }
            if (z16) {
                this.f383381a.wait(j3);
            }
        }
        synchronized (this.f383382b) {
            byte[] byteArray = this.f383387g.toByteArray();
            byte[] byteArray2 = this.f383388h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") == -1) {
                return null;
            }
            this.f383387g.reset();
            this.f383388h.reset();
            if (str.lastIndexOf(":RET=0") != -1) {
                return new Cif(cfor.f383392a, 0, str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            if (str.lastIndexOf(":RET=EOF") == -1 && str2.lastIndexOf(":RET=EOF") == -1) {
                i3 = 1;
            }
            return new Cif(cfor.f383392a, Integer.valueOf(i3), str.substring(0, str.lastIndexOf(":RET=")), str2);
        }
    }

    public void finalize() throws Throwable {
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
            this.f383384d.write("exit\n".getBytes());
            this.f383384d.flush();
            this.f383383c.wait(100L);
        } catch (Exception unused) {
        }
        Cdo cdo = this.f383385e;
        if (cdo != null) {
            cdo.interrupt();
            this.f383385e = null;
        }
        Cdo cdo2 = this.f383386f;
        if (cdo2 != null) {
            cdo2.interrupt();
            this.f383386f = null;
        }
        Process process = this.f383383c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.f383383c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Cif a(Cfor cfor) throws IllegalArgumentException, IOException, InterruptedException, TimeoutException {
        boolean z16;
        Cif a16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cif) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cfor);
        }
        if (cfor != null) {
            String str2 = cfor.f383392a;
            if (str2 != null && str2.length() > 0 && (str = cfor.f383393b) != null && str.length() > 0) {
                z16 = false;
                if (!z16 && cfor.f383394c >= 0) {
                    synchronized (this.f383382b) {
                        this.f383387g.reset();
                        this.f383388h.reset();
                    }
                    this.f383384d.write((cfor.f383393b + "\n").getBytes());
                    this.f383384d.flush();
                    synchronized (this.f383381a) {
                        this.f383381a.wait(10L);
                    }
                    this.f383384d.writeBytes("echo :RET=$?\n");
                    this.f383384d.flush();
                    long nanoTime = System.nanoTime();
                    long j3 = 0;
                    do {
                        long j16 = cfor.f383394c;
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
            }
            z16 = true;
            if (!z16) {
                synchronized (this.f383382b) {
                }
            }
        }
        throw new IllegalArgumentException("v");
    }
}
