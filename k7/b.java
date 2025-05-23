package k7;

import com.qzone.jbox2d.collision.Collision;
import com.qzone.jbox2d.collision.TimeOfImpact;
import com.qzone.jbox2d.common.Vec2;
import h7.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface b {
    a<d> getChainCircleContactStack();

    a<d> getChainPolyContactStack();

    a<d> getCircleContactStack();

    Collision getCollision();

    com.qzone.jbox2d.collision.b getDistance();

    a<d> getEdgeCircleContactStack();

    a<d> getEdgePolyContactStack();

    a<d> getPolyCircleContactStack();

    a<d> getPolyContactStack();

    TimeOfImpact getTimeOfImpact();

    Vec2 popVec2();

    void pushVec2(int i3);
}
