package h7;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j extends d {
    public j(k7.b bVar) {
        super(bVar);
    }

    @Override // h7.d
    public void a(Manifold manifold, Transform transform, Transform transform2) {
        this.f404483p.getCollision().c(manifold, (com.qzone.jbox2d.collision.shapes.c) this.f404473f.i(), transform, (com.qzone.jbox2d.collision.shapes.b) this.f404474g.i(), transform2);
    }

    @Override // h7.d
    public void h(com.qzone.jbox2d.dynamics.e eVar, int i3, com.qzone.jbox2d.dynamics.e eVar2, int i16) {
        super.h(eVar, i3, eVar2, i16);
    }
}
