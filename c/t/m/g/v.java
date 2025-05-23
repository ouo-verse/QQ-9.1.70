package c.t.m.g;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f30064a;

    /* renamed from: b, reason: collision with root package name */
    public File f30065b;

    /* renamed from: c, reason: collision with root package name */
    public FileOutputStream f30066c;

    /* renamed from: d, reason: collision with root package name */
    public BufferedOutputStream f30067d;

    /* renamed from: e, reason: collision with root package name */
    public StringBuilder f30068e;

    /* renamed from: f, reason: collision with root package name */
    public w f30069f;

    /* renamed from: g, reason: collision with root package name */
    public String f30070g;

    /* renamed from: h, reason: collision with root package name */
    public int f30071h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f30072i;

    /* renamed from: j, reason: collision with root package name */
    public long f30073j;

    /* renamed from: k, reason: collision with root package name */
    public String f30074k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f30075l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f30076m;

    /* renamed from: n, reason: collision with root package name */
    public int f30077n;

    /* renamed from: o, reason: collision with root package name */
    public int f30078o;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f30079a;

        public a(String str) {
            this.f30079a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                StringBuilder sb5 = new StringBuilder();
                String str = this.f30079a;
                sb5.append(str.substring(0, str.length() - v.this.f30074k.length()));
                sb5.append(".gzip");
                p0.a(new File(this.f30079a), new File(sb5.toString()), true);
            } catch (Throwable unused) {
            }
        }
    }

    public v(File file) throws IOException {
        this(file, MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE);
    }

    public File b() {
        File file;
        synchronized (this.f30064a) {
            file = this.f30065b;
        }
        return file;
    }

    public final void c() {
        File file = new File(this.f30070g + "_" + this.f30077n + this.f30074k);
        while (file.exists()) {
            this.f30077n++;
            file = new File(this.f30070g + "_" + this.f30077n + this.f30074k);
        }
        boolean renameTo = this.f30065b.renameTo(file);
        if (c1.a()) {
            c1.a("FileWriterWrapper", "rename " + this.f30065b.getName() + " to " + file.getName() + MsgSummary.STR_COLON + renameTo);
        }
        String absolutePath = file.getAbsolutePath();
        if (this.f30076m && !h1.a(absolutePath)) {
            if (c1.a()) {
                c1.a("FileWriterWrapper", "compress file: " + absolutePath);
            }
            new BaseThread(new a(absolutePath), "th_loc_tmp").start();
        }
        this.f30077n++;
    }

    public v(File file, int i3) throws IOException {
        this.f30064a = new byte[0];
        this.f30070g = "";
        this.f30071h = 0;
        this.f30072i = false;
        this.f30073j = Long.MAX_VALUE;
        this.f30074k = "";
        this.f30075l = false;
        this.f30076m = false;
        this.f30077n = 1;
        this.f30078o = 0;
        a(file, i3);
    }

    public final void a(File file, int i3) throws IOException {
        this.f30065b = file;
        File parentFile = file == null ? null : file.getParentFile();
        if ((parentFile == null || !parentFile.exists()) && !parentFile.mkdirs()) {
            return;
        }
        this.f30070g = file.getAbsolutePath();
        this.f30071h = i3;
        if (c1.a()) {
            c1.a("FileWriterWrapper", "create file:" + file.getAbsolutePath() + ",bufSize:" + i3);
        }
        this.f30068e = new StringBuilder(i3);
        this.f30066c = new FileOutputStream(file, true);
        this.f30067d = new BufferedOutputStream(this.f30066c, MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE);
    }

    public void a(String str) throws IOException {
        synchronized (this.f30064a) {
            StringBuilder sb5 = this.f30068e;
            if (sb5 != null) {
                sb5.append(str);
                if (this.f30068e.length() >= this.f30071h) {
                    a(this.f30068e.toString().getBytes("UTF-8"));
                    this.f30068e.setLength(0);
                }
            }
        }
    }

    public void a(byte[] bArr) throws IOException {
        synchronized (this.f30064a) {
            if (this.f30067d == null) {
                return;
            }
            w wVar = this.f30069f;
            this.f30067d.write(wVar == null ? bArr : wVar.a(bArr));
            if (this.f30072i) {
                int length = this.f30078o + bArr.length;
                this.f30078o = length;
                if (length >= 5120) {
                    this.f30078o = 0;
                    File b16 = b();
                    if ((b16 == null ? 0L : b16.length()) >= this.f30073j) {
                        this.f30067d.close();
                        this.f30066c.close();
                        c();
                        a(new File(this.f30070g), this.f30071h);
                    }
                }
            }
        }
    }

    public void a() throws IOException {
        synchronized (this.f30064a) {
            if (this.f30067d == null) {
                return;
            }
            a(this.f30068e.toString().getBytes("UTF-8"));
            this.f30068e.setLength(0);
            if (c1.a()) {
                c1.a("FileWriterWrapper", this.f30065b.getAbsolutePath() + " close(). length=" + this.f30065b.length());
            }
            this.f30067d.close();
            this.f30066c.close();
            if (this.f30072i && this.f30075l) {
                c();
            }
            this.f30077n = 1;
            this.f30067d = null;
            this.f30066c = null;
        }
    }

    public void a(w wVar) {
        synchronized (this.f30064a) {
            this.f30069f = wVar;
        }
    }
}
