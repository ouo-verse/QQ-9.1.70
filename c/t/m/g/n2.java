package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class n2 {

    /* renamed from: a, reason: collision with root package name */
    public int f29886a;

    /* renamed from: b, reason: collision with root package name */
    public int f29887b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<a> f29888c;

    /* renamed from: d, reason: collision with root package name */
    public a2 f29889d;

    public n2(int i3, int i16) {
        if (i3 >= i16) {
            if (i16 >= 3) {
                this.f29888c = new LinkedList<>();
                this.f29886a = i3;
                this.f29887b = i16;
                this.f29889d = new a2();
                return;
            }
            throw new IllegalArgumentException("coreSize should >= 3");
        }
        throw new IllegalArgumentException("maxSize should >= coreSize");
    }

    public synchronized void a(TencentLocation tencentLocation) {
        this.f29888c.add(a.a(tencentLocation));
        if (this.f29888c.size() > this.f29886a) {
            this.f29888c.removeFirst();
        }
    }

    public synchronized void b() {
        this.f29888c.clear();
        this.f29889d.c();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public double f29890a;

        /* renamed from: b, reason: collision with root package name */
        public double f29891b;

        /* renamed from: c, reason: collision with root package name */
        public long f29892c;

        /* renamed from: d, reason: collision with root package name */
        public int f29893d;

        public double a(a aVar) {
            return t3.a(this.f29890a, this.f29891b, aVar.f29890a, aVar.f29891b) / ((Math.abs(this.f29892c - aVar.f29892c) + 1) / 1000.0d);
        }

        public String toString() {
            return "[" + this.f29890a + "," + this.f29891b + "]";
        }

        public static a a(TencentLocation tencentLocation) {
            a aVar = new a();
            aVar.f29890a = tencentLocation.getLatitude();
            aVar.f29891b = tencentLocation.getLongitude();
            aVar.f29892c = tencentLocation.getTime();
            tencentLocation.getSpeed();
            if (TencentLocationUtils.isFromGps(tencentLocation)) {
                aVar.f29893d = tencentLocation.getAccuracy() < 100.0f ? 3 : 2;
            } else {
                aVar.f29893d = tencentLocation.getAccuracy() >= 500.0f ? 1 : 2;
            }
            return aVar;
        }
    }

    public synchronized void a(h3 h3Var) {
        if (!h3Var.getProvider().equalsIgnoreCase("gps") || q.b().b("gps_kalman")) {
            LinkedList<a> linkedList = this.f29888c;
            if (linkedList != null && linkedList.size() != 0) {
                this.f29889d.a(h3Var.getLatitude(), h3Var.getLongitude(), h3Var.getAccuracy(), h3Var.getTime());
                h3Var.a(this.f29889d.a(), this.f29889d.b());
            }
        }
    }

    public synchronized boolean a(TencentLocation tencentLocation, n1 n1Var) {
        return a(a.a(tencentLocation), n1Var);
    }

    public synchronized boolean a(a aVar, n1 n1Var) {
        if (n1Var != null) {
            LinkedList<a> linkedList = this.f29888c;
            if (linkedList != null && linkedList.size() != 0) {
                int i3 = aVar.f29893d;
                if (i3 == 3) {
                    return true;
                }
                if (i3 == 1 && !x3.b(n1Var) && !x3.c(n1Var)) {
                    return true;
                }
                if (aVar.f29892c - this.f29888c.getLast().f29892c > 120000) {
                    this.f29888c.clear();
                    return true;
                }
                if (a()) {
                    LinkedList<a> linkedList2 = this.f29888c;
                    ListIterator<a> listIterator = linkedList2.listIterator(linkedList2.size());
                    double d16 = 0.0d;
                    double d17 = 0.0d;
                    int i16 = 0;
                    int i17 = 0;
                    while (listIterator.hasPrevious()) {
                        d17 = listIterator.previous().a(aVar);
                        d16 += d17;
                        if (d17 > 50.0d) {
                            i16++;
                        }
                        i17++;
                        if (i17 > this.f29887b) {
                            break;
                        }
                    }
                    double d18 = d17;
                    if (i16 > 1) {
                        o3.a("TxTrace", "badPoints=" + i16);
                        return false;
                    }
                    h2.a().a(1, d16 / i17, d18, aVar.f29892c);
                }
                return true;
            }
        }
        return true;
    }

    public final boolean a() {
        return this.f29888c.size() >= this.f29887b;
    }
}
