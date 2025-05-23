package fg4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListReq;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f398660a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pl4.d f398661b;

        a(int i3, pl4.d dVar) {
            this.f398660a = i3;
            this.f398661b = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp, @Nullable FromServiceMsg fromServiceMsg) {
            this.f398661b.b(z16, i3, i16, i17, str, str2, yesGameInfoOuterClass$GetUserGameRoleListRsp, fromServiceMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp, FromServiceMsg fromServiceMsg) {
            if (yesGameInfoOuterClass$GetUserGameRoleListRsp != null) {
                GameCoreServiceImpl.INSTANCE.a().g4(this.f398660a, yesGameInfoOuterClass$GetUserGameRoleListRsp);
            }
            this.f398661b.a(yesGameInfoOuterClass$GetUserGameRoleListRsp, fromServiceMsg);
        }
    }

    private static NewIntent d(int i3) {
        YesGameInfoOuterClass$GetUserGameRoleListReq yesGameInfoOuterClass$GetUserGameRoleListReq = new YesGameInfoOuterClass$GetUserGameRoleListReq();
        yesGameInfoOuterClass$GetUserGameRoleListReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        yesGameInfoOuterClass$GetUserGameRoleListReq.game_id.set(i3);
        return a.C11028a.a(yesGameInfoOuterClass$GetUserGameRoleListReq, i.class);
    }

    public static void e(int i3, pl4.d<YesGameInfoOuterClass$GetUserGameRoleListRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3), YesGameInfoOuterClass$GetUserGameRoleListRsp.class, new a(i3, dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 321;
    }
}
