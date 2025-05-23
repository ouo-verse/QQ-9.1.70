package l14;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.MD5Utils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.listener.IMemoryPeakListener;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f extends Handler {

    /* renamed from: t, reason: collision with root package name */
    private static SharedPreferences f413654t;

    /* renamed from: u, reason: collision with root package name */
    private static SharedPreferences.Editor f413655u;

    /* renamed from: v, reason: collision with root package name */
    private static final String f413656v;

    /* renamed from: w, reason: collision with root package name */
    private static final String f413657w;

    /* renamed from: x, reason: collision with root package name */
    private static f f413658x;

    /* renamed from: y, reason: collision with root package name */
    public static int f413659y;

    /* renamed from: a, reason: collision with root package name */
    private int f413660a;

    /* renamed from: b, reason: collision with root package name */
    private final g04.a f413661b;

    /* renamed from: c, reason: collision with root package name */
    private long f413662c;

    /* renamed from: d, reason: collision with root package name */
    private long f413663d;

    /* renamed from: e, reason: collision with root package name */
    private long f413664e;

    /* renamed from: f, reason: collision with root package name */
    private long f413665f;

    /* renamed from: g, reason: collision with root package name */
    private long f413666g;

    /* renamed from: h, reason: collision with root package name */
    private long f413667h;

    /* renamed from: i, reason: collision with root package name */
    private String f413668i;

    /* renamed from: j, reason: collision with root package name */
    private final h f413669j;

    /* renamed from: k, reason: collision with root package name */
    private final h f413670k;

    /* renamed from: l, reason: collision with root package name */
    private long f413671l;

    /* renamed from: m, reason: collision with root package name */
    private LinkedList<a> f413672m;

    /* renamed from: n, reason: collision with root package name */
    private LinkedList<a> f413673n;

    /* renamed from: o, reason: collision with root package name */
    private LinkedList<a> f413674o;

    /* renamed from: p, reason: collision with root package name */
    private LinkedList<b> f413675p;

    /* renamed from: q, reason: collision with root package name */
    private LinkedList<c> f413676q;

    /* renamed from: r, reason: collision with root package name */
    private LinkedList<l14.a> f413677r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f413678s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        Long f413679a;

        /* renamed from: b, reason: collision with root package name */
        Long f413680b;

        public a(Long l3, Long l16) {
            this.f413679a = l3;
            this.f413680b = l16;
        }

        public String toString() {
            return this.f413679a + ProgressTracer.SEPARATOR + this.f413680b;
        }
    }

    static {
        String e16;
        String md5;
        String substring;
        String str = "main";
        try {
            e16 = com.tencent.rmonitor.common.util.a.e(BaseInfo.app);
            md5 = MD5Utils.getMD5(e16.getBytes());
        } catch (Throwable th5) {
            e.a("name_parser_error", th5.toString());
        }
        if (md5 != null) {
            substring = md5.substring(10, 20);
        } else {
            if (e16.contains(":")) {
                substring = e16.substring(e16.lastIndexOf(":") + 1);
            }
            f413656v = str;
            f413657w = "last_mem_valid_" + str;
            f413659y = 30;
        }
        str = substring;
        f413656v = str;
        f413657w = "last_mem_valid_" + str;
        f413659y = 30;
    }

    f() {
        super(ThreadManager.getMonitorThreadLooper());
        this.f413660a = 0;
        this.f413661b = new g04.a(10000L, 10000L, 30000L);
        this.f413667h = 0L;
        this.f413668i = "";
        String str = f413656v;
        h hVar = new h(str);
        this.f413669j = hVar;
        h hVar2 = new h(str);
        this.f413670k = hVar2;
        this.f413671l = -1L;
        this.f413672m = new LinkedList<>();
        this.f413673n = new LinkedList<>();
        this.f413674o = new LinkedList<>();
        this.f413675p = new LinkedList<>();
        this.f413676q = new LinkedList<>();
        this.f413677r = new LinkedList<>();
        this.f413678s = false;
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        f413654t = sharedPreferences;
        if (sharedPreferences != null) {
            f413655u = sharedPreferences.edit();
            hVar2.l(f413654t);
            this.f413664e = Runtime.getRuntime().totalMemory();
            this.f413665f = Runtime.getRuntime().freeMemory();
            this.f413666g = Runtime.getRuntime().maxMemory();
            long i3 = i(false) * 1024;
            this.f413662c = i3;
            long k3 = k() * 1024;
            this.f413663d = k3;
            hVar.j(i3, k3, this.f413664e - this.f413665f, com.tencent.rmonitor.common.lifecycle.a.f(), j());
            hVar.n(f413655u);
            s();
        }
    }

    private boolean a() {
        if (this.f413672m.size() == this.f413673n.size() && this.f413672m.size() == this.f413674o.size()) {
            return true;
        }
        return false;
    }

    private boolean b() {
        try {
            if (f413654t == null || f413655u == null) {
                BaseInfo.initSp();
                SharedPreferences sharedPreferences = BaseInfo.sharePreference;
                f413654t = sharedPreferences;
                f413655u = sharedPreferences.edit();
            }
        } catch (Throwable unused) {
            f413654t = null;
            f413655u = null;
        }
        if (f413654t != null && f413655u != null) {
            return true;
        }
        return false;
    }

    public static f f() {
        if (f413658x == null) {
            synchronized (f.class) {
                if (f413658x == null) {
                    f413658x = new f();
                }
            }
        }
        return f413658x;
    }

    private String j() {
        com.tencent.rmonitor.custom.a a16 = com.tencent.rmonitor.custom.b.a();
        long j3 = a16.j();
        if (j3 != this.f413667h) {
            try {
                JSONObject o16 = a16.o();
                if (o16 != null) {
                    this.f413668i = o16.toString();
                }
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_MemoryQuantile", "getUserCustom", th5);
            }
            this.f413667h = j3;
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_MemoryQuantile", "getUserCustom, seq: " + this.f413667h + ", userCustom: " + this.f413668i);
            }
        }
        return this.f413668i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r5 = java.lang.Long.parseLong(java.util.regex.Pattern.compile("[^0-9]").matcher(r3).replaceAll("").trim());
        r10.f413660a = 0;
        r1 = r5;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0048 -> B:13:0x007a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long k() {
        BufferedReader bufferedReader;
        long j3 = 0;
        String str = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
            try {
                str = bufferedReader.readLine();
                while (true) {
                    if (str == null) {
                        break;
                    }
                    if (str.startsWith("VmSize")) {
                        break;
                    }
                    str = bufferedReader.readLine();
                }
                bufferedReader.close();
            } catch (Throwable th6) {
                th = th6;
                try {
                    int i3 = this.f413660a + 1;
                    this.f413660a = i3;
                    if (i3 > 5) {
                        e.a("vss_parser_error", str);
                        removeMessages(2);
                    }
                    Logger.f365497g.e("RMonitor_MemoryQuantile", th.toString());
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return j3;
                } catch (Throwable th7) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
        return j3;
    }

    private void l() {
        this.f413661b.f();
        sendEmptyMessage(2);
    }

    private void s() {
        synchronized (this) {
            if (!this.f413678s) {
                r(true);
                sendEmptyMessage(1);
                this.f413678s = true;
            }
        }
    }

    private void t() {
        this.f413662c = i(false) * 1024;
        this.f413663d = k() * 1024;
        this.f413664e = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        this.f413665f = freeMemory;
        v(this.f413662c, this.f413663d, this.f413664e - freeMemory);
        u(this.f413662c, this.f413663d, this.f413664e - this.f413665f);
    }

    private void u(long j3, long j16, long j17) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        a aVar = new a(valueOf, Long.valueOf(j3));
        a aVar2 = new a(valueOf, Long.valueOf(j16));
        a aVar3 = new a(valueOf, Long.valueOf(j17));
        this.f413672m.addFirst(aVar);
        this.f413673n.addFirst(aVar2);
        this.f413674o.addFirst(aVar3);
        if (!a()) {
            this.f413672m.clear();
            this.f413673n.clear();
            this.f413674o.clear();
        } else {
            while (this.f413672m.size() > f413659y) {
                this.f413672m.removeLast();
                this.f413673n.removeLast();
                this.f413674o.removeLast();
            }
        }
    }

    private void v(long j3, long j16, long j17) {
        boolean z16;
        boolean z17;
        boolean z18;
        g e16 = this.f413669j.e();
        long c16 = e16.c();
        if (j3 > c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (j16 > e16.e()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (j17 > e16.a()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_MemoryQuantile", "current's pss = " + j3 + ", max_pss = " + c16);
        }
        if (this.f413661b.e() == 10000) {
            this.f413669j.b().l(f413655u, j3, j16, j17);
        } else {
            this.f413669j.a().l(f413655u, j3, j16, j17);
        }
        this.f413669j.e().l(f413655u, j3, j16, j17);
        if (z16 || z17 || z18) {
            this.f413669j.o(f413655u, com.tencent.rmonitor.common.lifecycle.a.f(), j(), z18, z16, z17);
        }
        f413655u.commit();
        n(j3);
        o(j16);
        m(j17);
        Iterator<IMemoryPeakListener> it = i04.a.memoryPeakListener.c().iterator();
        while (it.hasNext()) {
            IMemoryPeakListener next = it.next();
            if (z16) {
                next.onPssUpdate(j3);
            }
            if (z17) {
                next.onVssUpdate(j16);
            }
            if (z18) {
                next.onJavaHeapUpdate(j17);
            }
        }
    }

    public LinkedList<a> c() {
        return this.f413674o;
    }

    public LinkedList<a> d() {
        return this.f413672m;
    }

    public LinkedList<a> e() {
        return this.f413673n;
    }

    public boolean g() {
        SharedPreferences sharedPreferences = f413654t;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(f413657w, false);
    }

    public h h() {
        return new h(this.f413670k);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                t();
                sendEmptyMessageDelayed(2, this.f413661b.e());
                return;
            }
            return;
        }
        l();
    }

    public long i(boolean z16) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f413671l <= MiniBoxNoticeInfo.MIN_5 && !z16) {
                return SystemMethodProxy.getPss();
            }
            this.f413671l = currentTimeMillis;
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_MemoryQuantile", "get pss info from ActivityManager");
            }
            if (((ActivityManager) ContextUtil.getGlobalContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null) {
                return SystemMethodProxy.getProcessMemoryInfo(r7, new int[]{Process.myPid()})[0].getTotalPss();
            }
            return 0L;
        } catch (Throwable unused) {
            return SystemMethodProxy.getPss();
        }
    }

    public void m(long j3) {
        Iterator<l14.a> it = this.f413677r.iterator();
        while (it.hasNext()) {
            it.next().onJavaHeapUpdate(j3);
        }
    }

    public void n(long j3) {
        Iterator<b> it = this.f413675p.iterator();
        while (it.hasNext()) {
            it.next().onPssUpdate(j3);
        }
    }

    public void o(long j3) {
        Iterator<c> it = this.f413676q.iterator();
        while (it.hasNext()) {
            it.next().onVssUpdate(j3);
        }
    }

    public void p(b bVar) {
        if (b() && !this.f413675p.contains(bVar)) {
            this.f413675p.addLast(bVar);
            s();
        }
    }

    public void q(c cVar) {
        if (b() && !this.f413676q.contains(cVar)) {
            this.f413676q.addLast(cVar);
            s();
        }
    }

    public void r(boolean z16) {
        SharedPreferences.Editor editor;
        if (f413654t != null && (editor = f413655u) != null) {
            editor.putBoolean(f413657w, z16);
            f413655u.commit();
        }
    }
}
