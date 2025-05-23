package fg4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthReq;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {

    /* compiled from: P */
    /* renamed from: fg4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10314a implements pl4.d<GameAuthOuterClass$AgreeGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f398651a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pl4.d f398652b;

        C10314a(int i3, pl4.d dVar) {
            this.f398651a = i3;
            this.f398652b = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameAuthOuterClass$AgreeGameAuthRsp gameAuthOuterClass$AgreeGameAuthRsp, @Nullable FromServiceMsg fromServiceMsg) {
            pl4.d dVar = this.f398652b;
            if (dVar != null) {
                dVar.b(z16, i3, i16, i17, str, str2, gameAuthOuterClass$AgreeGameAuthRsp, fromServiceMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(GameAuthOuterClass$AgreeGameAuthRsp gameAuthOuterClass$AgreeGameAuthRsp, FromServiceMsg fromServiceMsg) {
            if (gameAuthOuterClass$AgreeGameAuthRsp != null) {
                GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp = new GameAuthOuterClass$GetGameAuthRsp();
                gameAuthOuterClass$GetGameAuthRsp.auth_desc.set(gameAuthOuterClass$AgreeGameAuthRsp.auth_desc.get());
                gameAuthOuterClass$GetGameAuthRsp.is_auth.set(gameAuthOuterClass$AgreeGameAuthRsp.is_auth.get());
                GameCoreServiceImpl.INSTANCE.a().e4(this.f398651a, gameAuthOuterClass$GetGameAuthRsp);
            }
            pl4.d dVar = this.f398652b;
            if (dVar != null) {
                dVar.a(gameAuthOuterClass$AgreeGameAuthRsp, fromServiceMsg);
            }
        }
    }

    private static NewIntent d(int i3, int i16) {
        GameAuthOuterClass$AgreeGameAuthReq gameAuthOuterClass$AgreeGameAuthReq = new GameAuthOuterClass$AgreeGameAuthReq();
        gameAuthOuterClass$AgreeGameAuthReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        gameAuthOuterClass$AgreeGameAuthReq.game_id.set(i3);
        gameAuthOuterClass$AgreeGameAuthReq.sense.set(i16);
        return a.C11028a.a(gameAuthOuterClass$AgreeGameAuthReq, a.class);
    }

    public static void e(int i3, int i16, pl4.d<GameAuthOuterClass$AgreeGameAuthRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, i16), GameAuthOuterClass$AgreeGameAuthRsp.class, new C10314a(i3, dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 319;
    }
}
