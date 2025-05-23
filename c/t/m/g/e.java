package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import c.t.m.g.e1;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class e extends g0 {

    /* renamed from: z, reason: collision with root package name */
    public static final String f29549z = j.b() + d1.a(e.class.getName(), KeyPropertiesCompact.DIGEST_SHA256).substring(0, 8);

    /* renamed from: c, reason: collision with root package name */
    public Context f29550c;

    /* renamed from: d, reason: collision with root package name */
    public final File f29551d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f29552e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Handler f29553f;

    /* renamed from: g, reason: collision with root package name */
    public long f29554g;

    /* renamed from: h, reason: collision with root package name */
    public long f29555h;

    /* renamed from: i, reason: collision with root package name */
    public int f29556i;

    /* renamed from: j, reason: collision with root package name */
    public int f29557j;

    /* renamed from: k, reason: collision with root package name */
    public long f29558k;

    /* renamed from: l, reason: collision with root package name */
    public long f29559l;

    /* renamed from: m, reason: collision with root package name */
    public long f29560m;

    /* renamed from: n, reason: collision with root package name */
    public long f29561n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f29562o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f29563p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f29564q;

    /* renamed from: r, reason: collision with root package name */
    public long f29565r;

    /* renamed from: s, reason: collision with root package name */
    public volatile List<d> f29566s;

    /* renamed from: t, reason: collision with root package name */
    public volatile List<ScanResult> f29567t;

    /* renamed from: u, reason: collision with root package name */
    public volatile Location f29568u;

    /* renamed from: v, reason: collision with root package name */
    public h f29569v;

    /* renamed from: w, reason: collision with root package name */
    public g f29570w;

    /* renamed from: x, reason: collision with root package name */
    public f f29571x;

    /* renamed from: y, reason: collision with root package name */
    public BroadcastReceiver f29572y;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                try {
                    boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                    if (c1.a()) {
                        c1.a("DC_Pro", "intent:" + intent + ",");
                    }
                    if (!booleanExtra) {
                        y0.a(e.this.f29553f, 107, 2000L);
                        if (e.this.f29570w != null) {
                            e.this.f29570w.c(2000L);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f29574a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29575b;

        /* compiled from: P */
        /* loaded from: classes.dex */
        public class a implements x {
            public a() {
            }

            @Override // c.t.m.g.x
            public void a(String str) {
                c1.b("DC_Pro", "upload error," + str);
            }

            @Override // c.t.m.g.x
            public void b(String str) {
                b.this.f29574a.delete();
                if (c1.a()) {
                    c1.a("DC_Pro", "upload " + b.this.f29574a.getName() + " succeed, then delete.");
                }
            }
        }

        public b(e eVar, File file, String str) {
            this.f29574a = file;
            this.f29575b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] a16 = v0.a(this.f29574a);
                if (h1.a(a16)) {
                    this.f29574a.delete();
                    if (c1.a()) {
                        c1.a("DC_Pro", "file " + this.f29574a.getName() + " is empty, then delete.");
                        return;
                    }
                    return;
                }
                j.f29779k.a(this.f29575b, a16, new a());
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("DC_Pro", "upload error,url=" + this.f29575b, th5);
                }
            }
        }
    }

    public e(Context context, String str) {
        this(context, new File(str + "/f_c"));
    }

    @Override // c.t.m.g.h0
    public String a() {
        return "DC_Pro";
    }

    public e(Context context, File file) {
        this.f29550c = null;
        this.f29554g = FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE;
        this.f29555h = 3600000L;
        this.f29556i = 1;
        this.f29557j = 25600;
        this.f29558k = GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT;
        this.f29559l = 10485760L;
        this.f29560m = 259200000L;
        this.f29561n = 2592000000L;
        this.f29562o = true;
        this.f29563p = false;
        this.f29564q = false;
        this.f29565r = 0L;
        this.f29572y = new a();
        this.f29550c = context;
        this.f29551d = file;
        this.f29552e = false;
    }

    @Override // c.t.m.g.g0
    public int b(Looper looper) {
        g();
        File file = this.f29551d;
        this.f29552e = file != null && (file.exists() || this.f29551d.mkdirs());
        if (c1.a()) {
            c1.a("DC_Pro", "startup! prepared:" + this.f29552e);
        }
        if (this.f29552e) {
            this.f29553f = new c(looper);
            this.f29565r = System.currentTimeMillis() - 40000;
            y0.a(this.f29553f, 107, MiniBoxNoticeInfo.MIN_5);
            try {
                this.f29550c.registerReceiver(this.f29572y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("DC_Pro", "listenNetworkState: failed", th5);
                }
            }
        }
        if (this.f29552e && this.f29562o) {
            h hVar = new h(this.f29551d);
            this.f29569v = hVar;
            hVar.b(looper);
        }
        if (this.f29563p) {
            g gVar = new g(this.f29551d);
            this.f29570w = gVar;
            gVar.b(looper);
        }
        if (this.f29564q) {
            f fVar = new f();
            this.f29571x = fVar;
            fVar.b(looper);
        }
        c1.c("FC", "systemInfo," + l1.a() + "," + l1.i());
        c1.c("FC", "start," + f1.a(this.f29562o) + "," + f1.a(this.f29563p) + "," + f1.a(this.f29564q));
        return 0;
    }

    @Override // c.t.m.g.h0
    public void d() {
        try {
            this.f29550c.unregisterReceiver(this.f29572y);
        } catch (Throwable unused) {
        }
        h hVar = this.f29569v;
        if (hVar != null) {
            hVar.a(100L);
            this.f29569v = null;
        }
        g gVar = this.f29570w;
        if (gVar != null) {
            gVar.a(100L);
            this.f29570w = null;
        }
        f fVar = this.f29571x;
        if (fVar != null) {
            fVar.e();
            this.f29571x = null;
        }
        if (e()) {
            y0.b(this.f29553f, 104);
            y0.b(this.f29553f, 106);
            this.f29565r = 0L;
            y0.b(this.f29553f, 107);
            y0.a(this.f29553f, 105, 200L);
            this.f29553f = null;
        }
    }

    public final boolean e() {
        return this.f29552e;
    }

    public final void g() {
        this.f29566s = null;
        this.f29567t = null;
        this.f29568u = null;
        this.f29565r = 0L;
    }

    public void a(String str, String str2) {
        if ("D_UP_INTERVAL".equals(str)) {
            this.f29555h = Math.max(900000L, Long.parseLong(str2));
            return;
        }
        if ("D_UP_USE_HTTPS".equals(str)) {
            j.f29773e = Boolean.parseBoolean(str2);
            return;
        }
        if ("D_MAX_1F_SIZE".equals(str)) {
            this.f29554g = a(Long.parseLong(str2), 10240L, 512000L);
            return;
        }
        if ("D_NUM_UP".equals(str)) {
            this.f29556i = (int) a(Long.parseLong(str2), 1L, 5L);
            return;
        }
        if ("D_MAX_BUF_WF".equals(str)) {
            this.f29557j = (int) a(Long.parseLong(str2), 5120L, 51200L);
            return;
        }
        if ("D_MAX_FOLDER_SIZE".equals(str)) {
            this.f29558k = a(Long.parseLong(str2), 10485760L, 209715200L);
            return;
        }
        if ("D_MAX_SIZE_UP_1DAY".equals(str)) {
            this.f29559l = Math.max(Long.parseLong(str2), 0L);
            return;
        }
        if ("D_MAX_DAY_RENAME".equals(str)) {
            this.f29560m = a(Long.parseLong(str2), 1L, 5L) * 24 * 60 * 60 * 1000;
            return;
        }
        if ("D_MAX_DAY_DELETE".equals(str)) {
            this.f29561n = a(Long.parseLong(str2), 1L, 30L) * 24 * 60 * 60 * 1000;
            return;
        }
        if ("D_UP_WF_INFO".equals(str)) {
            this.f29562o = Boolean.parseBoolean(str2);
        } else if ("D_UP_U_TRACK_INFO".equals(str)) {
            this.f29563p = Boolean.parseBoolean(str2);
        } else if ("D_UP_GPS_FOR_NAVI".equals(str)) {
            this.f29564q = Boolean.parseBoolean(str2);
        }
    }

    public final long a(long j3, long j16, long j17) {
        return Math.max(j16, Math.min(j3, j17));
    }

    public void a(int i3, Location location) {
        g gVar = this.f29570w;
        if (gVar != null) {
            gVar.a(i3, location);
        }
        f fVar = this.f29571x;
        if (fVar != null) {
            fVar.a(i3, location);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public File f29577a;

        /* renamed from: b, reason: collision with root package name */
        public BufferedOutputStream f29578b;

        /* renamed from: c, reason: collision with root package name */
        public StringBuffer f29579c;

        /* renamed from: d, reason: collision with root package name */
        public String f29580d;

        /* renamed from: e, reason: collision with root package name */
        public long f29581e;

        public c(Looper looper) {
            super(looper);
            this.f29580d = "";
            this.f29581e = 0L;
        }

        public final void a(Message message) {
            File file;
            int i3 = message.what;
            switch (i3) {
                case 101:
                case 102:
                    try {
                        a(i3);
                        return;
                    } catch (Throwable th5) {
                        c1.a("DC_Pro", "write data error!", th5);
                        return;
                    }
                case 103:
                    c1.a("DC_Pro", "upload msg");
                    if (e.this.e()) {
                        String absolutePath = e.this.f29551d.getAbsolutePath();
                        if (a(absolutePath)) {
                            return;
                        }
                        a(absolutePath.replaceAll("f_c", "d_c"));
                        return;
                    }
                    return;
                case 104:
                    b();
                    return;
                case 105:
                    try {
                        f();
                        StringBuffer stringBuffer = this.f29579c;
                        if (stringBuffer != null) {
                            stringBuffer.setLength(0);
                        }
                    } catch (Throwable unused) {
                    }
                    this.f29577a = null;
                    v0.a(this.f29578b);
                    a(e.this.f29561n, e.this.f29558k);
                    removeCallbacksAndMessages(null);
                    return;
                case 106:
                    a();
                    if (e.this.f29551d == null || (file = this.f29577a) == null || !file.exists()) {
                        return;
                    }
                    f();
                    long longValue = ((Long) k1.a("LocationSDK", "log_fc_create", (Object) 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (c1.a()) {
                        c1.a("DC_Pro", "desFileLen=" + this.f29577a.length() + ",maxFileSize=" + c() + ",curT=" + currentTimeMillis + ",createT=" + longValue + ",maxTimeRename:" + e.this.f29560m);
                    }
                    if (this.f29577a.length() > c() || currentTimeMillis - longValue > e.this.f29560m) {
                        c1.a("DC_Pro", "start rename file.");
                        e();
                        a(e.this.f29561n, e.this.f29558k);
                        if (j.f29774f) {
                            sendEmptyMessage(107);
                            return;
                        }
                        return;
                    }
                    return;
                case 107:
                    removeMessages(107);
                    e eVar = e.this;
                    eVar.a(eVar.f29553f);
                    y0.a(e.this.f29553f, 107, e.this.f29555h);
                    return;
                default:
                    return;
            }
        }

        public final void b() {
            try {
                BufferedOutputStream bufferedOutputStream = this.f29578b;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.flush();
                }
            } catch (Throwable unused) {
                this.f29577a = null;
                v0.a(this.f29578b);
            }
        }

        public final long c() {
            long j3;
            if (j.f29774f) {
                j3 = 51200;
            } else {
                j3 = 512000;
            }
            if (e.this.f29554g <= j3) {
                return e.this.f29554g;
            }
            return j3;
        }

        public final File d() {
            File file = e.this.f29551d;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, e.f29549z);
        }

        public final void e() {
            b();
            File file = this.f29577a;
            if (file != null && file.length() >= 1024) {
                v0.a(this.f29578b);
                this.f29578b = null;
                a(4, this.f29577a);
                this.f29577a = null;
                k1.b("LocationSDK", "log_fc_create", (Object) 0L);
            }
        }

        public final void f() {
            int length;
            StringBuffer stringBuffer = this.f29579c;
            if (stringBuffer != null && stringBuffer.length() != 0 && this.f29578b != null) {
                byte[] a16 = l.a(this.f29579c.toString());
                if (c1.a()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("write buf to file:buf:");
                    sb5.append(this.f29579c.length());
                    sb5.append(",enc:");
                    if (a16 == null) {
                        length = 0;
                    } else {
                        length = a16.length;
                    }
                    sb5.append(length);
                    c1.a("DC_Pro", sb5.toString());
                }
                this.f29579c.setLength(0);
                if (a16 != null && a16.length != 0) {
                    try {
                        this.f29578b.write(a16);
                        this.f29578b.write(36);
                        this.f29578b.flush();
                        return;
                    } catch (Throwable th5) {
                        c1.a("DC_Pro", "write file failed.", th5);
                        this.f29577a = null;
                        v0.a(this.f29578b);
                        return;
                    }
                }
                c1.a("DC_Pro", "enc result is null or len = 0");
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (c1.a()) {
                    c1.a("DC_Pro", "handleMessage:" + message.what);
                }
                a(message);
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("DC_Pro", "handler msg error!", th5);
                }
            }
        }

        public final boolean a(String str) {
            File[] fileArr = null;
            File file = TextUtils.isEmpty(str) ? null : new File(str);
            if (file != null && file.exists() && file.isDirectory()) {
                fileArr = file.listFiles();
            }
            if (fileArr != null && fileArr.length != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                int i3 = e.this.f29556i;
                for (int i16 = 0; i16 < fileArr.length && i3 > 0; i16++) {
                    File file2 = fileArr[i16];
                    String name = (file2 != null && file2.exists() && file2.isFile()) ? file2.getName() : "";
                    if (name.startsWith("dc") || name.startsWith("fc")) {
                        if (str.endsWith("d_c") && (file2.length() == 0 || currentTimeMillis - file2.lastModified() > e.this.f29561n)) {
                            file2.delete();
                        } else {
                            boolean z16 = (name.startsWith(j.b()) && name.endsWith(".enc")) || (name.startsWith("fc2") || name.startsWith("fc3"));
                            if (!z16) {
                                if (c1.a()) {
                                    c1.a("DC_Pro", str + ",has no " + j.b() + "***.enc files!!!");
                                }
                                z16 = name.startsWith("dc") && System.currentTimeMillis() - file2.lastModified() > 172800000;
                            }
                            if (z16 && a(file2.length())) {
                                if (c1.a()) {
                                    c1.a("DC_Pro", "upload:" + file2.getName() + ",len=" + file2.length());
                                }
                                int a16 = j.a(name);
                                if (a16 > 0) {
                                    String a17 = j.a(a16);
                                    if (!TextUtils.isEmpty(a17)) {
                                        if (!j.f29773e) {
                                            a17 = a17.replace("https:", "http:");
                                        }
                                        e.this.a(file2, a17);
                                        i3--;
                                    }
                                }
                            }
                        }
                    }
                }
                return i3 != e.this.f29556i;
            }
            if (fileArr != null && str.endsWith("d_c")) {
                file.delete();
            }
            return false;
        }

        public final void a(int i3) {
            String str;
            File file;
            a();
            if (!h1.a((Collection) e.this.f29566s)) {
                long j3 = ((d) e.this.f29566s.get(0)).f29526e;
                r1 = this.f29581e != j3;
                this.f29581e = j3;
            }
            if (i3 == 102) {
                str = k.a(j.f29777i, e.this.f29568u, null, e.this.f29566s, r1);
            } else {
                if (i3 == 101) {
                    List list = e.this.f29567t;
                    if (!h1.a((Collection) list)) {
                        str = k.a(j.f29777i, e.this.f29568u, list, e.this.f29566s, r1);
                    }
                }
                str = "";
            }
            if (this.f29578b == null || TextUtils.isEmpty(str) || str.length() < 25) {
                return;
            }
            String a16 = d1.a(str.substring(22).getBytes(), KeyPropertiesCompact.DIGEST_SHA256);
            if (this.f29580d.equals(a16)) {
                return;
            }
            this.f29580d = a16;
            if (this.f29579c == null) {
                this.f29579c = new StringBuffer(e.this.f29557j);
            }
            StringBuffer stringBuffer = this.f29579c;
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (this.f29579c.length() > e.this.f29557j || ((file = this.f29577a) != null && file.length() == 0)) {
                f();
                if (this.f29577a.length() > c()) {
                    y0.b(e.this.f29553f, 106);
                }
            }
            if (c1.a()) {
                c1.a("DC_Pro", "write:" + str.substring(0, 60) + "***,len=" + str.length());
            }
        }

        public final void a() {
            File file = this.f29577a;
            if (file == null || !file.exists() || this.f29578b == null || !e.f29549z.equals(this.f29577a.getName())) {
                File d16 = d();
                this.f29577a = d16;
                try {
                    boolean exists = d16.exists();
                    this.f29578b = new BufferedOutputStream(new FileOutputStream(this.f29577a, true), 1024);
                    if (exists) {
                        return;
                    }
                    k1.b("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
                } catch (Throwable th5) {
                    c1.a("DC_Pro", "open file error", th5);
                }
            }
        }

        public final boolean a(long j3) {
            try {
                SharedPreferences a16 = k1.a("LocationSDK");
                SharedPreferences.Editor edit = a16.edit();
                String string = a16.getString("log_up_fc_date", "");
                long j16 = a16.getLong("log_up_fc_size", 0L);
                String format = q0.b(DateUtil.DATE_FORMAT_8).format(new Date());
                if (!format.equals(string)) {
                    edit.putString("log_up_fc_date", format);
                    edit.putLong("log_up_fc_size", j3);
                } else {
                    if (j16 > e.this.f29559l) {
                        return false;
                    }
                    edit.putLong("log_up_fc_size", j3 + j16);
                }
                edit.apply();
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }

        public final void a(int i3, File file) {
            try {
                if (file.isFile()) {
                    File file2 = new File(file.getAbsolutePath() + "." + System.currentTimeMillis() + ".enc");
                    if (i3 == 4) {
                        byte[] a16 = v0.a(file);
                        if (!h1.a(a16)) {
                            byte[] a17 = p0.a(a16);
                            if (!h1.a(a17)) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                                fileOutputStream.write(a17);
                                fileOutputStream.close();
                                file.delete();
                            }
                        }
                    } else {
                        file.renameTo(file2);
                    }
                    if (c1.a()) {
                        c1.a("DC_Pro", "rename:" + file.getName() + " to " + file2.getName());
                    }
                }
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("DC_Pro", "rename:" + file.getName() + " error.", th5);
                }
            }
        }

        public final void a(long j3, long j16) {
            File file = null;
            File[] listFiles = e.this.f29551d == null ? null : e.this.f29551d.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j17 = 0;
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isFile() && !e.f29549z.equals(file2.getName())) {
                    if (currentTimeMillis - file2.lastModified() <= j3 && file2.length() != 0) {
                        String name = file2.getName();
                        if (currentTimeMillis - file2.lastModified() > 172800000 && !name.endsWith(".enc") && name.startsWith(j.b())) {
                            a(j.a(name), file2);
                        } else {
                            j17 += file2.length();
                            if (file == null || file.lastModified() > file2.lastModified()) {
                                file = file2;
                            }
                        }
                    } else {
                        if (c1.a()) {
                            c1.a("DC_Pro", "delete expired file:" + file2.getName() + ",len:" + file2.length());
                        }
                        file2.delete();
                    }
                }
            }
            if (j17 < j16 || file == null) {
                return;
            }
            if (c1.a()) {
                c1.a("DC_Pro", "too big folder size:" + j17 + ", delete " + file.getName() + ",size:" + file.length());
            }
            file.delete();
        }
    }

    public void a(List<ScanResult> list) {
        h hVar = this.f29569v;
        if (hVar != null) {
            hVar.a(list);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void a(Handler handler) {
        boolean z16;
        c1.a("DC_Pro", "check upload.");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f29565r < 60000) {
            c1.a("DC_Pro", "last upload time: < 1min");
            return;
        }
        y0.b(handler, 106);
        try {
            e1.a a16 = e1.a();
            if (a16 == e1.a.NETWORK_NONE) {
                z16 = false;
            } else {
                if (a16 == e1.a.NETWORK_MOBILE) {
                    boolean z17 = j.f29774f;
                    if (!z17 && j.f29775g) {
                        long longValue = ((Long) k1.a("LocationSDK", "log_fc_up_in_m", Long.valueOf(currentTimeMillis))).longValue();
                        if (currentTimeMillis - longValue > 86400000) {
                            k1.b("LocationSDK", "log_fc_up_in_m", Long.valueOf(currentTimeMillis));
                            if (c1.a()) {
                                c1.a("DC_Pro", "upload in mobile once today. lastUpT=" + longValue + ",curT=" + currentTimeMillis);
                            }
                        }
                    }
                    z16 = z17;
                }
                z16 = true;
            }
            if (c1.a()) {
                c1.a("DC_Pro", "network status:" + a16 + ",isUpload:" + z16);
            }
            if (z16 && e()) {
                y0.b(handler, 103);
                this.f29565r = currentTimeMillis;
                if (c1.a()) {
                    c1.a("DC_Pro", "send upload msg, last upload time:" + this.f29565r);
                }
            }
        } catch (Throwable th5) {
            c1.a("DC_Pro", "", th5);
        }
    }

    public synchronized void a(Location location, List<ScanResult> list, List<d> list2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (location != null && currentTimeMillis - location.getTime() <= 10000) {
            this.f29568u = location;
            this.f29567t = list;
            this.f29566s = list2;
            if (e()) {
                if (list == null) {
                    if (!h1.a((Collection) list2)) {
                        y0.b(this.f29553f, 102);
                    }
                } else if (!h1.a((Collection) list)) {
                    y0.b(this.f29553f, 101);
                }
            }
        }
    }

    public final void a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        w0.a("th_loc_task_t_consume", new b(this, file, str));
    }
}
