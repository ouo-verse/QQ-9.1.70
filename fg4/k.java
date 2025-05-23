package fg4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleReq;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f398662a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pl4.d f398663b;

        a(int i3, pl4.d dVar) {
            this.f398662a = i3;
            this.f398663b = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YesGameInfoOuterClass$SetUserGameDefaultRoleRsp yesGameInfoOuterClass$SetUserGameDefaultRoleRsp, @Nullable FromServiceMsg fromServiceMsg) {
            this.f398663b.b(z16, i3, i16, i17, str, str2, yesGameInfoOuterClass$SetUserGameDefaultRoleRsp, fromServiceMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YesGameInfoOuterClass$SetUserGameDefaultRoleRsp yesGameInfoOuterClass$SetUserGameDefaultRoleRsp, FromServiceMsg fromServiceMsg) {
            if (yesGameInfoOuterClass$SetUserGameDefaultRoleRsp != null) {
                YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = new YesGameInfoOuterClass$GetUserGameDefaultRoleRsp();
                yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info.set(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp.role_info.get());
                yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.openid.set(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp.openid.get());
                yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.auth_status.set(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp.auth_status.get());
                GameCoreServiceImpl.INSTANCE.a().f4(this.f398662a, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
            }
            this.f398663b.a(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp, fromServiceMsg);
        }
    }

    private static NewIntent d(int i3, YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo) {
        YesGameInfoOuterClass$SetUserGameDefaultRoleReq yesGameInfoOuterClass$SetUserGameDefaultRoleReq = new YesGameInfoOuterClass$SetUserGameDefaultRoleReq();
        yesGameInfoOuterClass$SetUserGameDefaultRoleReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        yesGameInfoOuterClass$SetUserGameDefaultRoleReq.game_id.set(i3);
        if (yesGameInfoOuterClass$YesGameRoleAbsInfo != null) {
            yesGameInfoOuterClass$SetUserGameDefaultRoleReq.area.set(yesGameInfoOuterClass$YesGameRoleAbsInfo.area.get());
            yesGameInfoOuterClass$SetUserGameDefaultRoleReq.partition.set(yesGameInfoOuterClass$YesGameRoleAbsInfo.partition.get());
        }
        return a.C11028a.a(yesGameInfoOuterClass$SetUserGameDefaultRoleReq, k.class);
    }

    public static void e(int i3, YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo, pl4.d<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, yesGameInfoOuterClass$YesGameRoleAbsInfo), YesGameInfoOuterClass$SetUserGameDefaultRoleRsp.class, new a(i3, dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 322;
    }
}
