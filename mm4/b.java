package mm4;

import ag4.h;
import ag4.i;
import android.content.Context;
import bo4.d;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import com.tencent.timi.game.initer.impl.IniterServiceImpl;
import com.tencent.timi.game.liveroom.impl.room.anchor.AnchorRoomService;
import do4.e;
import fm4.g;
import gh4.f;
import ih4.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pl4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<? extends a>, a> f417005a = new HashMap();

    static {
        e(hi4.b.class, new IniterServiceImpl());
        e(f05.a.class, new h05.a());
        e(sm4.a.class, new com.tencent.timi.game.team.impl.a());
        e(qo4.a.class, new ro4.a());
        e(c.class, new ly4.b());
        e(ll4.a.class, new ml4.a());
        e(f.class, new n());
        e(g.class, new com.tencent.timi.game.room.impl.b());
        e(j05.b.class, new km4.b());
        e(d.class, new e());
        e(i.class, GameCoreServiceImpl.INSTANCE.a());
        e(h.class, new com.tencent.timi.game.component.gamecore.impl.a());
        e(ag4.g.class, new gg4.a());
        e(kn4.b.class, new mn4.b());
        e(uh4.f.class, new vh4.b());
        e(pm4.a.class, new qm4.a());
        e(ql4.a.class, new tl4.b());
        e(bm4.a.class, new cm4.c());
        e(ni4.a.class, new AnchorRoomService());
        e(jg4.b.class, new kg4.a());
        e(ug4.b.class, new vg4.b());
        e(ei4.a.class, new fi4.a());
        e(hn4.a.class, new in4.e());
        e(lo4.a.class, new no4.a());
        e(nl4.c.class, new ol4.a());
        e(ug4.a.class, new vg4.c("0AND06MK9E48EOTF"));
        e(jg4.a.class, new og4.a());
        e(bi4.a.class, new ci4.a());
    }

    public static void a() {
        Iterator<a> it = f417005a.values().iterator();
        while (it.hasNext()) {
            it.next().o2();
        }
    }

    public static <T extends a> T b(Class<T> cls) {
        return (T) f417005a.get(cls);
    }

    public static void c(Context context) {
        Iterator<a> it = f417005a.values().iterator();
        while (it.hasNext()) {
            it.next().init(context);
        }
    }

    public static void d() {
        a aVar = f417005a.get(ug4.a.class);
        if (aVar != null) {
            aVar.init(null);
        }
    }

    private static void e(Class<? extends a> cls, a aVar) {
        f417005a.put(cls, aVar);
    }
}
