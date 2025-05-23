package fg4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleReq;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f398658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pl4.d f398659b;

        a(int i3, pl4.d dVar) {
            this.f398658a = i3;
            this.f398659b = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, @Nullable FromServiceMsg fromServiceMsg) {
            this.f398659b.b(z16, i3, i16, i17, str, str2, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, fromServiceMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, FromServiceMsg fromServiceMsg) {
            GameCoreServiceImpl.INSTANCE.a().f4(this.f398658a, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
            this.f398659b.a(yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, fromServiceMsg);
        }
    }

    private static NewIntent d(int i3) {
        YesGameInfoOuterClass$GetUserGameDefaultRoleReq yesGameInfoOuterClass$GetUserGameDefaultRoleReq = new YesGameInfoOuterClass$GetUserGameDefaultRoleReq();
        yesGameInfoOuterClass$GetUserGameDefaultRoleReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        yesGameInfoOuterClass$GetUserGameDefaultRoleReq.game_id.set(i3);
        return a.C11028a.a(yesGameInfoOuterClass$GetUserGameDefaultRoleReq, h.class);
    }

    public static void e(int i3, pl4.d<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3), YesGameInfoOuterClass$GetUserGameDefaultRoleRsp.class, new a(i3, dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 323;
    }
}
