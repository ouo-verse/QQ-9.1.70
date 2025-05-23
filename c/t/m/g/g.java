package c.t.m.g;

import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.e1;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes.dex */
public class g extends f0 {

    /* renamed from: f, reason: collision with root package name */
    public final File f29646f;

    /* renamed from: n, reason: collision with root package name */
    public volatile long f29654n;

    /* renamed from: o, reason: collision with root package name */
    public volatile int f29655o;

    /* renamed from: p, reason: collision with root package name */
    public volatile int f29656p;

    /* renamed from: q, reason: collision with root package name */
    public volatile int f29657q;

    /* renamed from: r, reason: collision with root package name */
    public volatile float f29658r;

    /* renamed from: s, reason: collision with root package name */
    public volatile float f29659s;

    /* renamed from: e, reason: collision with root package name */
    public final StringBuilder f29645e = new StringBuilder();

    /* renamed from: g, reason: collision with root package name */
    public volatile long f29647g = 0;

    /* renamed from: h, reason: collision with root package name */
    public volatile long f29648h = 0;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f29649i = new long[2];

    /* renamed from: j, reason: collision with root package name */
    public final int[] f29650j = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<Float> f29651k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<Float> f29652l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public HashSet<Integer> f29653m = new HashSet<>();

    /* renamed from: t, reason: collision with root package name */
    public AtomicBoolean f29660t = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f29660t.get()) {
                return;
            }
            g.this.f29660t.set(true);
            try {
                g.this.j();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f29662a;

        public b(g gVar, File file) {
            this.f29662a = file;
        }

        @Override // c.t.m.g.x
        public void a(String str) {
            if (c1.a()) {
                c1.b("UserTrackPro", "upload failed:" + str);
            }
        }

        @Override // c.t.m.g.x
        public void b(String str) {
            if (c1.a()) {
                c1.a("UserTrackPro", "upload succeed:" + str);
            }
            this.f29662a.delete();
        }
    }

    public g(File file) {
        this.f29646f = file;
    }

    @Override // c.t.m.g.i0
    public String a() {
        return "UserTrackPro";
    }

    @Override // c.t.m.g.i0
    public void c() {
        a(1002, 0L);
        this.f29651k.clear();
        this.f29652l.clear();
        this.f29653m.clear();
    }

    public final void f() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f29647g < 60000) {
            if (c1.a()) {
                c1.a("UserTrackPro", "last upload time: < 1min");
                return;
            }
            return;
        }
        this.f29647g = currentTimeMillis;
        e1.a a16 = e1.a();
        if (a16 == e1.a.NETWORK_NONE) {
            z16 = false;
        } else {
            if (a16 == e1.a.NETWORK_MOBILE) {
                boolean z17 = j.f29774f;
                if (!z17 && j.f29775g) {
                    long longValue = ((Long) k1.a("LocationSDK", "log_utr_up_in_m", Long.valueOf(currentTimeMillis))).longValue();
                    if (currentTimeMillis - longValue > 86400000) {
                        k1.b("LocationSDK", "log_utr_up_in_m", Long.valueOf(currentTimeMillis));
                        if (c1.a()) {
                            c1.a("UserTrackPro", "upload in mobile once today. lastUpT=" + longValue + ",curT=" + currentTimeMillis);
                        }
                    }
                }
                z16 = z17;
            }
            z16 = true;
        }
        if (z16) {
            w0.a("th_loc_task_t_consume", new a());
        }
    }

    public final String g() {
        String a16;
        String str = l1.b().replaceAll("[| _,]", "") + "_" + l1.c() + "_" + l1.d();
        String str2 = ((String) g1.a(Build.MANUFACTURER, "")).replaceAll("[| _,]", "") + "_" + ((String) g1.a(l1.e(), "")).replaceAll("[| _,]", "");
        String a17 = l1.a();
        if (h1.a(a17) || "0123456789ABCDEF".equals(a17)) {
            a17 = l1.i();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SYSTEM,");
        sb5.append(System.currentTimeMillis());
        sb5.append(',');
        sb5.append(a17);
        sb5.append(',');
        if (j.f29777i == null) {
            a16 = "";
        } else {
            a16 = j.f29777i.a();
        }
        sb5.append(a16);
        sb5.append(',');
        sb5.append(str);
        sb5.append(',');
        sb5.append(str2);
        sb5.append(',');
        sb5.append(Build.VERSION.SDK_INT);
        sb5.append(',');
        sb5.append(m.a());
        sb5.append(',');
        sb5.append(m.b());
        sb5.append(',');
        sb5.append(m.c().replaceAll(":", "").toLowerCase());
        sb5.append(',');
        sb5.append(m.d());
        return sb5.toString();
    }

    public final String h() {
        String str;
        if (j.f29776h) {
            str = "https://testdatalbs.sparta.html5.qq.com/tr?utr";
        } else {
            str = "https://analytics.map.qq.com/tr?utr";
        }
        if (!j.f29773e) {
            return str.replace("https:", "http:");
        }
        return str;
    }

    public final void i() {
        this.f29648h = System.currentTimeMillis();
        this.f29645e.setLength(0);
        Arrays.fill(this.f29650j, 0);
        Arrays.fill(this.f29649i, 0L);
    }

    public final void j() {
        File[] fileArr;
        File file = this.f29646f;
        if (file != null && file.exists()) {
            fileArr = this.f29646f.listFiles();
        } else {
            fileArr = null;
        }
        if (h1.b(fileArr)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        e1.a a16 = e1.a();
        String a17 = q0.a(DateUtil.DATE_FORMAT_8);
        int i3 = 0;
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (file2.exists() && file2.isFile() && name.startsWith("utr_") && !name.contains(a17)) {
                if (currentTimeMillis - file2.lastModified() > 1296000000) {
                    if (c1.a()) {
                        c1.a("UserTrackPro", "del file:" + file2.getName());
                    }
                    file2.delete();
                } else {
                    byte[] a18 = v0.a(file2);
                    i3 += a18.length;
                    if (c1.a()) {
                        c1.a("UserTrackPro", "upload file:" + file2.getName() + ",len=" + a18.length + ",sum=" + i3 + ",netType=" + a16);
                    }
                    if (a18.length == 0) {
                        file2.delete();
                    } else {
                        j.f29779k.a(h(), a18, new b(this, file2));
                        if (a16 == e1.a.NETWORK_MOBILE || i3 >= 512000) {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void b(String str) {
        if (h1.a(str)) {
            return;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] a16 = l.a(bytes, 3);
            if (c1.a()) {
                c1.a("UserTrackPro", "srcBytes.len=" + bytes.length + ",encBytes.len=" + a16.length);
            }
            File file = new File(this.f29646f, "utr_" + d1.a(e.class.getName(), KeyPropertiesCompact.DIGEST_SHA256).substring(0, 8) + "_" + q0.a(DateUtil.DATE_FORMAT_8));
            v0.a(file, a16, true);
            if (file.length() > 51200) {
                file.renameTo(new File(file.getParent(), file.getName() + "_" + q0.a("HHmmss")));
            }
        } catch (Throwable th5) {
            if (c1.a()) {
                c1.a("UserTrackPro", "writeStrToFile error.", th5);
            }
        }
    }

    @Override // c.t.m.g.f0
    public void a(Message message) throws Exception {
        switch (message.what) {
            case 1001:
                i();
                this.f29647g = System.currentTimeMillis() - 40000;
                a(1004, MiniBoxNoticeInfo.MIN_5);
                return;
            case 1002:
                y0.b(d());
                int[] iArr = this.f29650j;
                if (iArr[0] + iArr[1] >= 3) {
                    b(this.f29645e.toString());
                }
                i();
                f();
                return;
            case 1003:
                a((String) message.obj);
                return;
            case 1004:
                a(1004, 1800000L);
                f();
                return;
            default:
                return;
        }
    }

    public void c(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        a(1004, j3);
    }

    @Override // c.t.m.g.i0
    public int a(Looper looper) {
        this.f29654n = 0L;
        this.f29657q = -1;
        this.f29656p = -1;
        a(1001, 0L);
        return 0;
    }

    public void a(int i3, Location location) {
        String format;
        synchronized (this.f29761b) {
            if (b()) {
                long currentTimeMillis = System.currentTimeMillis();
                long[] jArr = this.f29649i;
                if (currentTimeMillis - jArr[0] < 900) {
                    return;
                }
                jArr[0] = currentTimeMillis;
                int[] iArr = this.f29650j;
                iArr[0] = iArr[0] + 1;
                if (location != null) {
                    try {
                    } catch (Throwable th5) {
                        if (c1.a()) {
                            c1.a("UserTrackPro", "set gps loc error.", th5);
                        }
                    }
                    if ("gps".equals(location.getProvider())) {
                        if (j.f29776h || !location.isFromMockProvider()) {
                            if (currentTimeMillis - this.f29654n > 2000) {
                                format = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,-1,-1,0,-1,0", Long.valueOf(currentTimeMillis), Long.valueOf(location.getTime()), Integer.valueOf(i3), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(LocationMonitor.getAccuracy(location)), Float.valueOf(location.getSpeed()), Float.valueOf(location.getBearing()));
                            } else {
                                format = String.format(Locale.ENGLISH, "%d,G,%d,%d,%.6f,%.6f,%.1f,%.1f,%.1f,%.1f,%d,%d,%.2f,%d,%.2f", Long.valueOf(currentTimeMillis), Long.valueOf(location.getTime()), Integer.valueOf(i3), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Float.valueOf(LocationMonitor.getAccuracy(location)), Float.valueOf(location.getSpeed()), Float.valueOf(location.getBearing()), Integer.valueOf(this.f29655o), Integer.valueOf(this.f29656p), Float.valueOf(this.f29658r), Integer.valueOf(this.f29657q), Float.valueOf(this.f29659s));
                            }
                            y0.b(d(), 1003, 0, 0, format);
                        }
                    }
                }
            }
        }
    }

    public final void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f29645e.length() == 0) {
            this.f29645e.append(g());
            this.f29648h = currentTimeMillis;
        }
        StringBuilder sb5 = this.f29645e;
        sb5.append('$');
        sb5.append(str);
        if (this.f29645e.length() >= 15360 || (this.f29648h != 0 && currentTimeMillis - this.f29648h >= 600000)) {
            int[] iArr = this.f29650j;
            if (iArr[0] + iArr[1] >= 3) {
                b(this.f29645e.toString());
            }
            this.f29645e.setLength(0);
            Arrays.fill(this.f29650j, 0);
        }
    }
}
