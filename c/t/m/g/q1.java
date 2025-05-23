package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes.dex */
public class q1 extends p1 {

    /* renamed from: d, reason: collision with root package name */
    public SparseArray<Pair<Double, Double>> f29953d;

    public q1(String str) {
        super(str, "check cell");
        this.f29953d = new SparseArray<>();
    }

    @Override // c.t.m.g.p1
    public void a() {
        super.a();
        this.f29953d.clear();
    }

    @Override // c.t.m.g.p1
    public boolean b(Bundle bundle) {
        int i3 = bundle.getInt("lac");
        long j3 = bundle.getLong("cid", 0L);
        Location location = (Location) bundle.getParcelable("location");
        if (i3 == 0 || j3 == 0 || location == null) {
            return false;
        }
        int i16 = i3 << ((int) (j3 + 16));
        Pair<Double, Double> pair = this.f29953d.get(i16);
        if (pair != null) {
            return t3.a(location.getLatitude(), location.getLongitude(), ((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()) < 6000.0d;
        }
        this.f29953d.put(i16, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        b();
        return true;
    }

    public final void b() {
        if (this.f29953d.size() > 320) {
            SparseArray<Pair<Double, Double>> sparseArray = this.f29953d;
            sparseArray.delete(sparseArray.keyAt(0));
        }
    }
}
