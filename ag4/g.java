package ag4;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.yes.common.GameDataServerOuterClass$CreateCODMGroupRoomRsp;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface g extends mm4.a {
    void C0(boolean z16, int i3, int i16, int i17, String str, pl4.d<MessageMicro> dVar);

    void R1(int i3, pl4.d<GameDataServerOuterClass$CreateCODMGroupRoomRsp> dVar);

    void u2(String str, int i3, boolean z16, pl4.d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> dVar);
}
