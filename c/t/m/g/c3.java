package c.t.m.g;

import com.tencent.map.geolocation.TencentDistanceAnalysis;

/* compiled from: P */
/* loaded from: classes.dex */
public class c3 implements TencentDistanceAnalysis {

    /* renamed from: a, reason: collision with root package name */
    public double f29519a;

    /* renamed from: b, reason: collision with root package name */
    public int f29520b;

    /* renamed from: c, reason: collision with root package name */
    public int f29521c;

    public void a(double d16) {
        this.f29519a = d16;
    }

    public void b(int i3) {
        this.f29521c = i3;
    }

    @Override // com.tencent.map.geolocation.TencentDistanceAnalysis
    public double getConfidence() {
        return this.f29519a;
    }

    @Override // com.tencent.map.geolocation.TencentDistanceAnalysis
    public int getGpsCount() {
        return this.f29520b;
    }

    @Override // com.tencent.map.geolocation.TencentDistanceAnalysis
    public int getNetworkCount() {
        return this.f29521c;
    }

    public void a(int i3) {
        this.f29520b = i3;
    }
}
