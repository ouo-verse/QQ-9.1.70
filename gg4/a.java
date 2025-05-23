package gg4;

import ag4.g;
import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import fg4.c;
import fg4.e;
import fg4.j;
import pl4.d;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupRoomRsp;
import trpc.yes.common.GameDataServerOuterClass$CreateCFMGroupTeamRsp;
import trpc.yes.common.GameDataServerOuterClass$CreateCODMGroupRoomRsp;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements g {

    /* compiled from: P */
    /* renamed from: gg4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C10376a implements d<GameDataServerOuterClass$CreateCFMGroupTeamRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f402033a;

        C10376a(d dVar) {
            this.f402033a = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameDataServerOuterClass$CreateCFMGroupTeamRsp gameDataServerOuterClass$CreateCFMGroupTeamRsp, @Nullable FromServiceMsg fromServiceMsg) {
            d dVar = this.f402033a;
            if (dVar != null) {
                dVar.b(z16, i3, i16, i17, str, str2, gameDataServerOuterClass$CreateCFMGroupTeamRsp, fromServiceMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(GameDataServerOuterClass$CreateCFMGroupTeamRsp gameDataServerOuterClass$CreateCFMGroupTeamRsp, FromServiceMsg fromServiceMsg) {
            d dVar = this.f402033a;
            if (dVar != null) {
                dVar.a(gameDataServerOuterClass$CreateCFMGroupTeamRsp, fromServiceMsg);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements d<GameDataServerOuterClass$CreateCFMGroupRoomRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f402035a;

        b(d dVar) {
            this.f402035a = dVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable GameDataServerOuterClass$CreateCFMGroupRoomRsp gameDataServerOuterClass$CreateCFMGroupRoomRsp, @Nullable FromServiceMsg fromServiceMsg) {
            d dVar = this.f402035a;
            if (dVar != null) {
                dVar.b(z16, i3, i16, i17, str, str2, gameDataServerOuterClass$CreateCFMGroupRoomRsp, fromServiceMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(GameDataServerOuterClass$CreateCFMGroupRoomRsp gameDataServerOuterClass$CreateCFMGroupRoomRsp, FromServiceMsg fromServiceMsg) {
            d dVar = this.f402035a;
            if (dVar != null) {
                dVar.a(gameDataServerOuterClass$CreateCFMGroupRoomRsp, fromServiceMsg);
            }
        }
    }

    @Override // ag4.g
    public void C0(boolean z16, int i3, int i16, int i17, String str, d<MessageMicro> dVar) {
        if (z16) {
            fg4.d.e(i3, i16, i17, new C10376a(dVar));
        } else {
            c.e(i3, i16, i17, str, new b(dVar));
        }
    }

    @Override // ag4.g
    public void R1(int i3, d<GameDataServerOuterClass$CreateCODMGroupRoomRsp> dVar) {
        e.e(i3, dVar);
    }

    @Override // ag4.g
    public void u2(String str, int i3, boolean z16, d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> dVar) {
        j.e(str, i3, z16, dVar);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
