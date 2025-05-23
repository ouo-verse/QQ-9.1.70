package h7;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: d, reason: collision with root package name */
    int f404492d;

    /* renamed from: e, reason: collision with root package name */
    int f404493e;

    /* renamed from: f, reason: collision with root package name */
    float f404494f;

    /* renamed from: g, reason: collision with root package name */
    float f404495g;

    /* renamed from: j, reason: collision with root package name */
    float f404498j;

    /* renamed from: k, reason: collision with root package name */
    float f404499k;

    /* renamed from: l, reason: collision with root package name */
    Manifold.ManifoldType f404500l;

    /* renamed from: m, reason: collision with root package name */
    float f404501m;

    /* renamed from: n, reason: collision with root package name */
    float f404502n;

    /* renamed from: o, reason: collision with root package name */
    int f404503o;

    /* renamed from: a, reason: collision with root package name */
    Vec2[] f404489a = new Vec2[com.qzone.jbox2d.common.d.f48141i];

    /* renamed from: b, reason: collision with root package name */
    final Vec2 f404490b = new Vec2();

    /* renamed from: c, reason: collision with root package name */
    final Vec2 f404491c = new Vec2();

    /* renamed from: h, reason: collision with root package name */
    final Vec2 f404496h = new Vec2();

    /* renamed from: i, reason: collision with root package name */
    final Vec2 f404497i = new Vec2();

    public f() {
        int i3 = 0;
        while (true) {
            Vec2[] vec2Arr = this.f404489a;
            if (i3 >= vec2Arr.length) {
                return;
            }
            vec2Arr[i3] = new Vec2();
            i3++;
        }
    }
}
