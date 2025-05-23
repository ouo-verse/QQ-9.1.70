package g7;

import com.qzone.jbox2d.common.Vec2;
import f7.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface b {
    void a(g gVar, com.qzone.jbox2d.collision.a aVar);

    boolean b(int i3, com.qzone.jbox2d.collision.a aVar, Vec2 vec2);

    int c(com.qzone.jbox2d.collision.a aVar, Object obj);

    void destroyProxy(int i3);

    com.qzone.jbox2d.collision.a getFatAABB(int i3);

    Object getUserData(int i3);
}
