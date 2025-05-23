package com.tencent.mobileqq.vip;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {
    static IPatchRedirector $redirector_;
    public long A;
    public int B;
    public boolean C;
    public boolean D;
    public long E;
    private Map<String, String> F;
    public long G;
    public long H;
    public long I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public long P;
    public boolean Q;
    public String R;
    public String S;
    public boolean T;
    public boolean U;
    public byte V;
    public boolean W;
    public boolean X;
    public int Y;
    public a Z;

    /* renamed from: a, reason: collision with root package name */
    public int f313000a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f313001a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f313002b;

    /* renamed from: b0, reason: collision with root package name */
    ArrayList<g> f313003b0;

    /* renamed from: c, reason: collision with root package name */
    public String f313004c;

    /* renamed from: c0, reason: collision with root package name */
    Object f313005c0;

    /* renamed from: d, reason: collision with root package name */
    public int f313006d;

    /* renamed from: e, reason: collision with root package name */
    public String f313007e;

    /* renamed from: f, reason: collision with root package name */
    public int f313008f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f313009g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, File> f313010h;

    /* renamed from: i, reason: collision with root package name */
    public String f313011i;

    /* renamed from: j, reason: collision with root package name */
    public int f313012j;

    /* renamed from: k, reason: collision with root package name */
    public long f313013k;

    /* renamed from: l, reason: collision with root package name */
    public long f313014l;

    /* renamed from: m, reason: collision with root package name */
    public float f313015m;

    /* renamed from: n, reason: collision with root package name */
    private AtomicInteger f313016n;

    /* renamed from: o, reason: collision with root package name */
    private AtomicBoolean f313017o;

    /* renamed from: p, reason: collision with root package name */
    private AtomicBoolean f313018p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f313019q;

    /* renamed from: r, reason: collision with root package name */
    private f f313020r;

    /* renamed from: s, reason: collision with root package name */
    private Bundle f313021s;

    /* renamed from: t, reason: collision with root package name */
    public int f313022t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f313023u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f313024v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f313025w;

    /* renamed from: x, reason: collision with root package name */
    public String f313026x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f313027y;

    /* renamed from: z, reason: collision with root package name */
    public long f313028z;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f313029a;

        /* renamed from: b, reason: collision with root package name */
        public long f313030b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f313029a = VipFunCallConstants.MM_APPID;
                this.f313030b = -1L;
            }
        }
    }

    public g(String str, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) file);
            return;
        }
        this.f313000a = 0;
        this.f313002b = false;
        this.f313004c = null;
        this.f313006d = 0;
        this.f313008f = 3;
        this.f313015m = 0.0f;
        this.f313016n = new AtomicInteger(2);
        this.f313017o = new AtomicBoolean(false);
        this.f313018p = new AtomicBoolean(false);
        this.f313019q = false;
        this.f313023u = true;
        this.f313024v = true;
        this.f313025w = true;
        this.f313026x = null;
        this.f313027y = false;
        this.f313028z = 0L;
        this.A = 0L;
        this.B = 60000;
        this.C = false;
        this.D = false;
        this.E = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.Q = false;
        this.S = "Vip";
        this.T = true;
        this.U = true;
        this.V = (byte) 0;
        this.W = false;
        this.X = false;
        this.Z = new a();
        this.f313001a0 = true;
        this.f313005c0 = new Object();
        this.f313009g = new ArrayList();
        this.f313010h = new HashMap();
        this.f313009g.add(str);
        this.f313010h.put(str, file);
        this.f313004c = str;
        this.f313022t = 1;
    }

    public void a(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) gVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask,task.key=" + gVar.f313004c);
        }
        synchronized (this.f313005c0) {
            if (this.f313003b0 == null) {
                this.f313003b0 = new ArrayList<>();
            }
            if (this.f313003b0.size() < 5) {
                this.f313003b0.add(gVar);
            } else if (QLog.isColorLevel()) {
                QLog.d("DownloadTask", 2, "DownloadTask.addDuplicateListenerTask, taskList.size() >= DUPLICATE_LIMIT,size=" + this.f313003b0.size());
            }
        }
    }

    public synchronized void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2);
        } else if (str != null && str2 != null) {
            if (this.F == null) {
                this.F = new HashMap();
            }
            this.F.put(str, str2);
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f313017o.set(z16);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null) {
                        gVar.u(null);
                    }
                }
                this.f313003b0.clear();
                this.f313003b0 = null;
            }
        }
    }

    public boolean e(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, Byte.valueOf(b16))).booleanValue();
        }
        if ((((byte) (this.V | 0)) & b16) != b16) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, obj)).booleanValue();
        }
        if ((obj instanceof g) && ((g) obj).f313009g.equals(this.f313009g)) {
            return true;
        }
        return false;
    }

    public Map<String, String> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Map) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.F;
    }

    public f g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f313020r;
    }

    public Bundle h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.f313021s == null) {
            this.f313021s = new Bundle();
        }
        return this.f313021s;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f313016n.get();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f313017o.get();
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f313018p.get();
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.A = 0L;
            this.f313018p.set(true);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (g() != null) {
            g().onCancel(this);
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onCancel(gVar);
                    }
                }
            }
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (g() != null) {
            g().onDone(this);
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onDone(gVar);
                    }
                }
            }
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (g() != null) {
            g().onDoneFile(this);
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onDoneFile(gVar);
                    }
                }
            }
        }
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (g() != null) {
            g().onNetMobile2None();
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onNetMobile2None();
                    }
                }
            }
        }
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (g() != null) {
            g().onNetWifi2Mobile();
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onNetWifi2Mobile();
                    }
                }
            }
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        if (g() != null) {
            g().onNetWifi2None();
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onNetWifi2None();
                    }
                }
            }
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (g() != null) {
            g().onProgress(this);
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.f313013k = this.f313013k;
                        gVar.f313014l = this.f313014l;
                        gVar.g().onProgress(gVar);
                    }
                }
            }
        }
    }

    public boolean t() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (g() != null) {
            z16 = g().onStart(this);
        } else {
            z16 = true;
        }
        synchronized (this.f313005c0) {
            ArrayList<g> arrayList = this.f313003b0;
            if (arrayList != null && this.f313001a0) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    g gVar = this.f313003b0.get(size);
                    if (gVar != null && gVar.g() != null) {
                        gVar.y(i());
                        gVar.f313006d = this.f313006d;
                        gVar.f313015m = this.f313015m;
                        gVar.g().onStart(gVar);
                    }
                }
            }
        }
        return z16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return " key=" + this.f313004c + ",urlList size=" + this.f313009g.size() + "|currentUrlIndex=" + this.f313012j + "|errCode=" + this.f313006d + "|status=" + this.f313016n + "|readSize=" + this.f313014l + "|maxSize=" + this.f313013k + "|percent=" + this.f313015m;
    }

    public void u(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
        } else {
            this.f313020r = fVar;
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void w(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        } else {
            this.f313021s = bundle;
        }
    }

    public void x(long j3, long j16, int i3) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
            return;
        }
        this.f313013k = j3;
        this.f313014l = j16;
        this.f313012j = i3;
        int i16 = i3 + 1;
        if (j16 <= 0) {
            f16 = 30.0f;
        } else if (j16 >= j3) {
            if (i16 == this.f313009g.size()) {
                y(3);
                this.f313015m = 100.0f;
                return;
            }
            f16 = 100.0f;
        } else {
            f16 = (((float) j16) * 100.0f) / ((float) j3);
        }
        this.f313015m = ((i3 * 100) + f16) / this.f313009g.size();
    }

    public void y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f313016n.set(i3);
        }
    }

    public g(List<String> list, Map<String, File> map, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, map, str);
            return;
        }
        this.f313000a = 0;
        this.f313002b = false;
        this.f313004c = null;
        this.f313006d = 0;
        this.f313008f = 3;
        this.f313015m = 0.0f;
        this.f313016n = new AtomicInteger(2);
        this.f313017o = new AtomicBoolean(false);
        this.f313018p = new AtomicBoolean(false);
        this.f313019q = false;
        this.f313023u = true;
        this.f313024v = true;
        this.f313025w = true;
        this.f313026x = null;
        this.f313027y = false;
        this.f313028z = 0L;
        this.A = 0L;
        this.B = 60000;
        this.C = false;
        this.D = false;
        this.E = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.Q = false;
        this.S = "Vip";
        this.T = true;
        this.U = true;
        this.V = (byte) 0;
        this.W = false;
        this.X = false;
        this.Z = new a();
        this.f313001a0 = true;
        this.f313005c0 = new Object();
        this.f313009g = list == null ? new ArrayList<>() : list;
        this.f313010h = map == null ? new HashMap<>() : map;
        this.f313004c = str;
        this.f313022t = 2;
    }
}
