package com.qq.e.comm.plugin.e.a;

import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f39345a;

    /* renamed from: b, reason: collision with root package name */
    private e f39346b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, com.tencent.gathererga.tangram.d> f39347c;

    /* renamed from: d, reason: collision with root package name */
    private String f39348d;

    d() {
        b();
        e eVar = new e();
        this.f39346b = eVar;
        eVar.a(new b());
        this.f39346b.a(new f());
        this.f39346b.a(new c());
    }

    public static d a() {
        if (f39345a == null) {
            synchronized (d.class) {
                if (f39345a == null) {
                    f39345a = new d();
                }
            }
        }
        return f39345a;
    }

    public void b() {
        this.f39348d = com.qq.e.comm.plugin.j.c.a((String) null, Constants.KEYS.PRIVACY_POLICY_LIST, (String) null);
    }

    public String c() {
        return this.f39348d;
    }

    public String d() {
        return com.qq.e.comm.plugin.e.b.a();
    }

    public boolean e() {
        if (new Random().nextInt(1000) >= com.qq.e.comm.plugin.j.c.a("reportGathererDeviceInfoRate", 0)) {
            return false;
        }
        return true;
    }

    public String b(int i3, boolean z16) {
        Object b16 = this.f39346b.b(i3, z16);
        return b16 instanceof String ? (String) b16 : "";
    }

    public Pair<Integer, Integer> c(int i3, boolean z16) {
        Object b16 = this.f39346b.b(i3, z16);
        if (b16 instanceof Pair) {
            Pair pair = (Pair) b16;
            Object obj = pair.first;
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            Object obj2 = pair.second;
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0));
        }
        return new Pair<>(0, 0);
    }

    public void a(Map<Integer, com.tencent.gathererga.tangram.d> map) {
        this.f39347c = map;
    }

    public com.tencent.gathererga.tangram.d a(int i3) {
        Map<Integer, com.tencent.gathererga.tangram.d> map = this.f39347c;
        if (map == null) {
            return null;
        }
        return map.get(Integer.valueOf(i3));
    }

    public boolean a(int i3, boolean z16) {
        return this.f39346b.a(i3, z16);
    }

    public int a(int i3, boolean z16, int i16) {
        Object b16 = this.f39346b.b(i3, z16);
        return b16 instanceof Integer ? ((Integer) b16).intValue() : i16;
    }

    public boolean a(int i3, boolean z16, boolean z17) {
        Object b16 = this.f39346b.b(i3, z16);
        return b16 instanceof Boolean ? ((Boolean) b16).booleanValue() : z17;
    }
}
