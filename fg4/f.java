package fg4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.state.map.MapItemKt;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.GameDataServerOuterClass$GetAllGameConfigReq;
import trpc.yes.common.GameDataServerOuterClass$GetAllGameConfigRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<GameDataServerOuterClass$GetAllGameConfigRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ pl4.d f398655a;

        a(pl4.d dVar) {
            this.f398655a = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameDataServerOuterClass$GetAllGameConfigRsp gameDataServerOuterClass$GetAllGameConfigRsp, @Nullable FromServiceMsg fromServiceMsg) {
            pl4.d dVar = this.f398655a;
            if (dVar != null) {
                dVar.b(z16, i3, i16, i17, str, str2, gameDataServerOuterClass$GetAllGameConfigRsp, fromServiceMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(GameDataServerOuterClass$GetAllGameConfigRsp gameDataServerOuterClass$GetAllGameConfigRsp, FromServiceMsg fromServiceMsg) {
            pl4.d dVar = this.f398655a;
            if (dVar != null) {
                dVar.a(gameDataServerOuterClass$GetAllGameConfigRsp, fromServiceMsg);
            }
        }
    }

    private static NewIntent d() {
        GameDataServerOuterClass$GetAllGameConfigReq gameDataServerOuterClass$GetAllGameConfigReq = new GameDataServerOuterClass$GetAllGameConfigReq();
        gameDataServerOuterClass$GetAllGameConfigReq.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
        return a.C11028a.a(gameDataServerOuterClass$GetAllGameConfigReq, f.class);
    }

    public static void e(pl4.d<GameDataServerOuterClass$GetAllGameConfigRsp> dVar) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(), GameDataServerOuterClass$GetAllGameConfigRsp.class, new a(dVar));
    }

    @Override // pl4.a
    protected int b() {
        return MapItemKt.ITEM_AVATAR_MIN_WIDTH;
    }
}
