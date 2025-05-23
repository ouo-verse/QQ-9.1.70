package h7;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l extends d {
    public l(k7.b bVar) {
        super(bVar);
    }

    @Override // h7.d
    public void a(Manifold manifold, Transform transform, Transform transform2) {
        this.f404483p.getCollision().e(manifold, (com.qzone.jbox2d.collision.shapes.e) this.f404473f.i(), transform, (com.qzone.jbox2d.collision.shapes.b) this.f404474g.i(), transform2);
    }
}
