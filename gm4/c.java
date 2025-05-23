package gm4;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameOneSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserData;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface c {
    long A(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    YoloRoomOuterClass$YoloCommonGameOneSchema C();

    boolean D();

    @Nullable
    CommonOuterClass$QQUserId E();

    fm4.c G();

    int I();

    YoloRoomOuterClass$YoloRoomSpeakingPosInfo L(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    int M();

    void N(ConcurrentHashMap<String, String> concurrentHashMap);

    gh4.d P();

    CommonOuterClass$QQUserId R();

    boolean S();

    YoloRoomOuterClass$YoloGameRouteInfo U();

    YoloRoomOuterClass$YoloRoomConf Y();

    ConcurrentHashMap<String, String> e();

    long f();

    YoloRoomOuterClass$YoloRoomInfo getRoomInfo();

    int getRoomType();

    YoloRoomOuterClass$YoloRoomUserData m();

    List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n();

    void o(gh4.d dVar);

    int o1();

    boolean q(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    YoloRoomOuterClass$YoloCommonGameOneSchema s();

    YoloRoomOuterClass$YoloRoomDoubleCheckPlayer v(CommonOuterClass$QQUserId commonOuterClass$QQUserId);

    YoloRoomOuterClass$YoloCommonGameDataInfo w();

    ConcurrentHashMap<String, String> x();
}
