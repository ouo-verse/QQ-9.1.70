package gn4;

import com.tencent.mobileqq.app.QBaseActivity;
import fm4.TeamCreatePageParam;
import fm4.g;
import gh4.e;
import gh4.f;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static void a() {
        long j3;
        e I0 = ((f) mm4.b.b(f.class)).I0();
        if (I0 != null) {
            I0.Fa();
            return;
        }
        YoloRoomOuterClass$YoloRoomInfo j06 = ((g) mm4.b.b(g.class)).j0(5);
        int t26 = ((g) mm4.b.b(g.class)).t2(j06);
        sm4.a aVar = (sm4.a) mm4.b.b(sm4.a.class);
        QBaseActivity b16 = vf4.a.b();
        if (j06 != null) {
            j3 = j06.room_id.get();
        } else {
            j3 = 0;
        }
        aVar.j1(b16, t26, 1, 1, j3, null, null, new TeamCreatePageParam());
    }
}
