package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class x2 extends w2 {

    /* renamed from: c, reason: collision with root package name */
    public static final x2 f30100c = new x2(Collections.emptyList(), 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final List<ScanResult> f30101a;

    /* renamed from: b, reason: collision with root package name */
    public final long f30102b;

    public x2(List<ScanResult> list, long j3, int i3) {
        this.f30102b = j3;
        this.f30101a = new ArrayList(list);
    }

    public List<ScanResult> a() {
        return Collections.unmodifiableList(this.f30101a);
    }

    public boolean a(long j3, long j16) {
        return j3 - this.f30102b < j16;
    }

    public boolean a(x2 x2Var) {
        List<ScanResult> list = x2Var.f30101a;
        List<ScanResult> list2 = this.f30101a;
        if (list == null || list2 == null || list.size() == 0 || list2.size() == 0) {
            return false;
        }
        return !o2.a(list, list2);
    }
}
