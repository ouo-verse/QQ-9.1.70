package h7;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends d {

    /* renamed from: r, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.shapes.c f404466r;

    public a(k7.b bVar) {
        super(bVar);
        this.f404466r = new com.qzone.jbox2d.collision.shapes.c();
    }

    @Override // h7.d
    public void a(Manifold manifold, Transform transform, Transform transform2) {
        ((com.qzone.jbox2d.collision.shapes.a) this.f404473f.i()).i(this.f404466r, this.f404475h);
        this.f404483p.getCollision().c(manifold, this.f404466r, transform, (com.qzone.jbox2d.collision.shapes.b) this.f404474g.i(), transform2);
    }

    @Override // h7.d
    public void h(com.qzone.jbox2d.dynamics.e eVar, int i3, com.qzone.jbox2d.dynamics.e eVar2, int i16) {
        super.h(eVar, i3, eVar2, i16);
    }
}
