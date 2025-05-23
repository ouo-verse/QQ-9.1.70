package gm4;

import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface b {
    void B(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void F(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void J(int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void K(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void O(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void T(boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void W(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void X(boolean z16, YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void Z(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void a(YoloRoomOuterClass$YoloRoomModifyInfoCmd yoloRoomOuterClass$YoloRoomModifyInfoCmd, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void g(boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void h(IResultListener<YoloRoomOuterClass$YoloRoomStartGameCmdRsp> iResultListener);

    void i(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void k(IResultListener<YoloRoomOuterClass$YoloRoomJoinGameCmdRsp> iResultListener);

    void p(String str);

    void r(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);

    void u(fm4.a aVar);

    void z(boolean z16, int i3, boolean z17, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener);
}
