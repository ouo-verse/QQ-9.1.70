package fg4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthReq;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<GameAuthOuterClass$GetGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f398656a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pl4.d f398657b;

        a(int i3, pl4.d dVar) {
            this.f398656a = i3;
            this.f398657b = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp, @Nullable FromServiceMsg fromServiceMsg) {
            this.f398657b.b(z16, i3, i16, i17, str, str2, gameAuthOuterClass$GetGameAuthRsp, fromServiceMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp, FromServiceMsg fromServiceMsg) {
            if (gameAuthOuterClass$GetGameAuthRsp != null) {
                GameCoreServiceImpl.INSTANCE.a().e4(this.f398656a, gameAuthOuterClass$GetGameAuthRsp);
            }
            this.f398657b.a(gameAuthOuterClass$GetGameAuthRsp, fromServiceMsg);
        }
    }

    private static NewIntent d(int i3, int i16) {
        GameAuthOuterClass$GetGameAuthReq gameAuthOuterClass$GetGameAuthReq = new GameAuthOuterClass$GetGameAuthReq();
        gameAuthOuterClass$GetGameAuthReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        gameAuthOuterClass$GetGameAuthReq.game_id.set(i3);
        gameAuthOuterClass$GetGameAuthReq.sense.set(i16);
        return a.C11028a.a(gameAuthOuterClass$GetGameAuthReq, g.class);
    }

    public static void e(int i3, int i16, pl4.d<GameAuthOuterClass$GetGameAuthRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, i16), GameAuthOuterClass$GetGameAuthRsp.class, new a(i3, dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 318;
    }
}
