package fg4;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameAuthOuterClass$CancelGameAuthReq;
import trpc.yes.common.GameAuthOuterClass$CancelGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<GameAuthOuterClass$CancelGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f398653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pl4.d f398654b;

        a(int i3, pl4.d dVar) {
            this.f398653a = i3;
            this.f398654b = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameAuthOuterClass$CancelGameAuthRsp gameAuthOuterClass$CancelGameAuthRsp, @Nullable FromServiceMsg fromServiceMsg) {
            pl4.d dVar = this.f398654b;
            if (dVar != null) {
                dVar.b(z16, i3, i16, i17, str, str2, gameAuthOuterClass$CancelGameAuthRsp, fromServiceMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(GameAuthOuterClass$CancelGameAuthRsp gameAuthOuterClass$CancelGameAuthRsp, FromServiceMsg fromServiceMsg) {
            GameCoreServiceImpl.Companion companion = GameCoreServiceImpl.INSTANCE;
            companion.a().f4(this.f398653a, null);
            companion.a().g4(this.f398653a, null);
            GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp = new GameAuthOuterClass$GetGameAuthRsp();
            PBRepeatField<String> pBRepeatField = gameAuthOuterClass$GetGameAuthRsp.auth_desc;
            pBRepeatField.set(pBRepeatField.get());
            PBBoolField pBBoolField = gameAuthOuterClass$GetGameAuthRsp.is_auth;
            pBBoolField.set(pBBoolField.get());
            companion.a().e4(this.f398653a, gameAuthOuterClass$GetGameAuthRsp);
            pl4.d dVar = this.f398654b;
            if (dVar != null) {
                dVar.a(gameAuthOuterClass$CancelGameAuthRsp, fromServiceMsg);
            }
        }
    }

    private static NewIntent d(int i3, int i16) {
        GameAuthOuterClass$CancelGameAuthReq gameAuthOuterClass$CancelGameAuthReq = new GameAuthOuterClass$CancelGameAuthReq();
        gameAuthOuterClass$CancelGameAuthReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        gameAuthOuterClass$CancelGameAuthReq.game_id.set(i3);
        gameAuthOuterClass$CancelGameAuthReq.sense.set(i16);
        return a.C11028a.a(gameAuthOuterClass$CancelGameAuthReq, b.class);
    }

    public static void e(int i3, int i16, pl4.d<GameAuthOuterClass$CancelGameAuthRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, i16), GameAuthOuterClass$CancelGameAuthRsp.class, new a(i3, dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 320;
    }
}
