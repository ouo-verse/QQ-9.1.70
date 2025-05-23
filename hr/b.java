package hr;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {

    /* renamed from: s, reason: collision with root package name */
    public static int f406001s = 95;

    /* renamed from: t, reason: collision with root package name */
    public static int f406002t = 100;

    /* renamed from: n, reason: collision with root package name */
    private volatile List<EmoticonInfo> f406003n;

    /* renamed from: o, reason: collision with root package name */
    private volatile HashMap<Integer, String> f406004o;

    /* renamed from: p, reason: collision with root package name */
    public AtomicBoolean f406005p;

    /* renamed from: q, reason: collision with root package name */
    public volatile AtomicInteger f406006q;

    /* renamed from: r, reason: collision with root package name */
    public int f406007r;

    public b(String str) {
        super(str);
        this.f406005p = new AtomicBoolean(false);
        this.f406006q = new AtomicInteger(0);
        this.f406007r = 0;
        this.f406003n = new ArrayList();
    }

    @Override // hr.a
    public int b() {
        return this.f406003n.size();
    }

    @Override // hr.a
    public String d(int i3) {
        return null;
    }

    @Override // hr.a
    public String e() {
        return "FavFacePackage";
    }

    public HashMap<Integer, String> g() {
        return this.f406004o;
    }

    public List<EmoticonInfo> h() {
        return this.f406003n;
    }

    public boolean i() {
        return this.f406003n == null || this.f406003n.size() == 0;
    }

    public void j(HashMap<Integer, String> hashMap) {
        this.f406004o = hashMap;
    }

    public void k(List<EmoticonInfo> list) {
        this.f406003n = list;
    }
}
