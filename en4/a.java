package en4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import mm4.b;
import mqq.app.NewIntent;
import pl4.a;
import pl4.c;
import pl4.d;
import trpc.yes.common.PremadesTeamServerOuterClass$SearchGamePremadesTeamReq;
import trpc.yes.common.PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp;
import trpc.yes.common.YoloRoomOuterClass$ListParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {

    /* compiled from: P */
    /* renamed from: en4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10252a implements d<PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f396874a;

        C10252a(d dVar) {
            this.f396874a = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, @Nullable FromServiceMsg fromServiceMsg) {
            d dVar = this.f396874a;
            if (dVar != null) {
                dVar.b(z16, i3, i16, i17, str, str2, null, fromServiceMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, FromServiceMsg fromServiceMsg) {
            if (this.f396874a != null) {
                if (premadesTeamServerOuterClass$SearchGamePremadesTeamRsp == null) {
                    premadesTeamServerOuterClass$SearchGamePremadesTeamRsp = new PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp();
                }
                this.f396874a.a(premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, fromServiceMsg);
            }
        }
    }

    private static NewIntent d(int i3, String str, int i16, boolean z16, int i17, List<YoloRoomOuterClass$ListParam> list) {
        PremadesTeamServerOuterClass$SearchGamePremadesTeamReq premadesTeamServerOuterClass$SearchGamePremadesTeamReq = new PremadesTeamServerOuterClass$SearchGamePremadesTeamReq();
        premadesTeamServerOuterClass$SearchGamePremadesTeamReq.uid.set(((ll4.a) b.b(ll4.a.class)).h());
        premadesTeamServerOuterClass$SearchGamePremadesTeamReq.game_id.set(i3);
        premadesTeamServerOuterClass$SearchGamePremadesTeamReq.origin_id.set(str);
        premadesTeamServerOuterClass$SearchGamePremadesTeamReq.user_from.set(i16);
        premadesTeamServerOuterClass$SearchGamePremadesTeamReq.display_type.set(z16 ? 1 : 0);
        premadesTeamServerOuterClass$SearchGamePremadesTeamReq.page.set(i17);
        if (list != null) {
            premadesTeamServerOuterClass$SearchGamePremadesTeamReq.list_param.set(list);
        }
        return a.C11028a.a(premadesTeamServerOuterClass$SearchGamePremadesTeamReq, a.class);
    }

    public static void e(int i3, String str, int i16, boolean z16, int i17, List<YoloRoomOuterClass$ListParam> list, d<PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp> dVar) {
        ((c) b.b(c.class)).F1(d(i3, str, i16, z16, i17, list), PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp.class, new C10252a(dVar));
    }

    @Override // pl4.a
    protected int b() {
        return 505;
    }
}
