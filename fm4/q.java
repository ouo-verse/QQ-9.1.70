package fm4;

import java.util.List;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface q extends o {
    void b(int i3);

    void c(boolean z16);

    void d(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j16);

    void e(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);

    void i(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);

    void k(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);

    void m(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list, int i3);

    void n(int i3, String str);

    void o(List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);

    void p(List<YoloRoomOuterClass$YoloRoomModifyInfoActionContent> list);

    void q(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    void r(String str, int i3, YoloRoomOuterClass$YoloBattleOBStatusChangeAction yoloRoomOuterClass$YoloBattleOBStatusChangeAction);

    void s(boolean z16, int i3, YoloRoomOuterClass$YoloGameRouteInfo yoloRoomOuterClass$YoloGameRouteInfo);

    void t(CommonOuterClass$QQUserId commonOuterClass$QQUserId, CommonOuterClass$QQUserId commonOuterClass$QQUserId2, long j3, long j16);

    void u(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3);

    void v(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    void w(YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);

    void x(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);

    void y(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    void z(int i3, YoloRoomOuterClass$YoloRoomSpeakingPosInfo yoloRoomOuterClass$YoloRoomSpeakingPosInfo, List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> list);
}
