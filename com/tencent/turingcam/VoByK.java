package com.tencent.turingcam;

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
public class VoByK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final Object f382071a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f382072b;

    /* renamed from: c, reason: collision with root package name */
    public Process f382073c;

    /* renamed from: d, reason: collision with root package name */
    public DataOutputStream f382074d;

    /* renamed from: e, reason: collision with root package name */
    public spXPg f382075e;

    /* renamed from: f, reason: collision with root package name */
    public spXPg f382076f;

    /* renamed from: g, reason: collision with root package name */
    public ByteArrayOutputStream f382077g;

    /* renamed from: h, reason: collision with root package name */
    public ByteArrayOutputStream f382078h;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShGzN {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f382079a;

        /* renamed from: b, reason: collision with root package name */
        public final String f382080b;

        public ShGzN(String str, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
            } else {
                this.f382079a = str;
                this.f382080b = str2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SkEpO {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f382081a;

        /* renamed from: b, reason: collision with root package name */
        public final String f382082b;

        public SkEpO(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f382081a = str;
                this.f382082b = str2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public InputStream f382083a;

        /* renamed from: b, reason: collision with root package name */
        public ByteArrayOutputStream f382084b;

        public spXPg(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VoByK.this, str, inputStream, byteArrayOutputStream);
            } else {
                this.f382083a = inputStream;
                this.f382084b = byteArrayOutputStream;
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
                int read = this.f382083a.read(bArr);
                if (read < 0) {
                    synchronized (VoByK.this.f382072b) {
                        this.f382084b.write(":RET=EOF".getBytes());
                        this.f382084b.flush();
                    }
                    synchronized (VoByK.this.f382071a) {
                        VoByK.this.f382071a.notifyAll();
                    }
                    return;
                }
                if (read > 0) {
                    synchronized (VoByK.this.f382072b) {
                        this.f382084b.write(bArr, 0, read);
                        this.f382084b.flush();
                    }
                    synchronized (VoByK.this.f382071a) {
                        VoByK.this.f382071a.notifyAll();
                    }
                }
                return;
            }
        }
    }

    public VoByK(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        Object obj = new Object();
        this.f382071a = obj;
        this.f382072b = new Object();
        this.f382077g = new ByteArrayOutputStream();
        this.f382078h = new ByteArrayOutputStream();
        if (str != null && str.length() != 0) {
            if (str.startsWith("/") && !new File(str).exists()) {
                throw new FileNotFoundException();
            }
            this.f382073c = RuntimeMonitor.exec(Runtime.getRuntime(), str);
            synchronized (obj) {
                obj.wait(10L);
            }
            try {
                this.f382073c.exitValue();
            } catch (Exception unused) {
                z16 = false;
            }
            if (!z16) {
                this.f382074d = new DataOutputStream(this.f382073c.getOutputStream());
                this.f382075e = new spXPg(ReportConstant.COSTREPORT_PREFIX, this.f382073c.getInputStream(), this.f382077g);
                this.f382076f = new spXPg("e", this.f382073c.getErrorStream(), this.f382078h);
                synchronized (this.f382071a) {
                    this.f382071a.wait(10L);
                }
                this.f382075e.start();
                this.f382076f.start();
                return;
            }
            throw new IOException();
        }
        throw new IllegalArgumentException();
    }

    public final SkEpO a(ShGzN shGzN, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SkEpO) iPatchRedirector.redirect((short) 4, this, shGzN, Long.valueOf(j3));
        }
        synchronized (this.f382071a) {
            synchronized (this.f382072b) {
                if (new String(this.f382077g.toByteArray()).lastIndexOf(":RET=") != -1) {
                    z16 = false;
                }
            }
            if (z16) {
                this.f382071a.wait(j3);
            }
        }
        synchronized (this.f382072b) {
            byte[] byteArray = this.f382077g.toByteArray();
            byte[] byteArray2 = this.f382078h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") == -1) {
                return null;
            }
            this.f382077g.reset();
            this.f382078h.reset();
            if (str.lastIndexOf(":RET=0") != -1) {
                return new SkEpO(str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            if (str.lastIndexOf(":RET=EOF") == -1) {
                str2.lastIndexOf(":RET=EOF");
            }
            return new SkEpO(str.substring(0, str.lastIndexOf(":RET=")), str2);
        }
    }

    public void finalize() {
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
            this.f382074d.write("exit\n".getBytes());
            this.f382074d.flush();
            this.f382073c.wait(100L);
        } catch (Exception unused) {
        }
        spXPg spxpg = this.f382075e;
        if (spxpg != null) {
            spxpg.interrupt();
            this.f382075e = null;
        }
        spXPg spxpg2 = this.f382076f;
        if (spxpg2 != null) {
            spxpg2.interrupt();
            this.f382076f = null;
        }
        Process process = this.f382073c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.f382073c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002e A[Catch: all -> 0x00ac, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0014, B:13:0x0018, B:15:0x001e, B:17:0x0022, B:22:0x002e, B:23:0x0030, B:27:0x003c, B:28:0x0060, B:32:0x0069, B:33:0x007a, B:35:0x008c, B:42:0x0094, B:43:0x009c, B:47:0x009f, B:51:0x00a2, B:52:0x00a3, B:53:0x00ab, B:25:0x0031, B:26:0x003b, B:30:0x0061, B:31:0x0068), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a3 A[Catch: all -> 0x00ac, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0014, B:13:0x0018, B:15:0x001e, B:17:0x0022, B:22:0x002e, B:23:0x0030, B:27:0x003c, B:28:0x0060, B:32:0x0069, B:33:0x007a, B:35:0x008c, B:42:0x0094, B:43:0x009c, B:47:0x009f, B:51:0x00a2, B:52:0x00a3, B:53:0x00ab, B:25:0x0031, B:26:0x003b, B:30:0x0061, B:31:0x0068), top: B:2:0x0001, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized SkEpO a(ShGzN shGzN) {
        boolean z16;
        SkEpO a16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SkEpO) iPatchRedirector.redirect((short) 3, (Object) this, (Object) shGzN);
        }
        String str2 = shGzN.f382079a;
        if (str2 != null && str2.length() > 0 && (str = shGzN.f382080b) != null && str.length() > 0) {
            z16 = false;
            if (z16) {
                synchronized (this.f382072b) {
                    this.f382077g.reset();
                    this.f382078h.reset();
                }
                this.f382074d.write((shGzN.f382080b + "\n").getBytes());
                this.f382074d.flush();
                synchronized (this.f382071a) {
                    this.f382071a.wait(10L);
                }
                this.f382074d.writeBytes("echo :RET=$?\n");
                this.f382074d.flush();
                long nanoTime = System.nanoTime();
                do {
                    long nanoTime2 = 5000 - ((System.nanoTime() - nanoTime) / 1000000);
                    if (nanoTime2 > 0) {
                        a16 = a(shGzN, nanoTime2);
                    } else {
                        throw new TimeoutException("t");
                    }
                } while (a16 == null);
                return a16;
            }
            throw new IllegalArgumentException("v");
        }
        z16 = true;
        if (z16) {
        }
    }
}
