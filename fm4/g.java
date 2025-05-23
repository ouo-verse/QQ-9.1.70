package fm4;

import android.app.Activity;
import com.tencent.timi.game.utils.IResultListener;
import trpc.yes.common.UserProxyCmdOuterClass$GetUserRouteInfoRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface g extends mm4.a {
    gm4.b A(long j3);

    void B1(long j3, f fVar);

    boolean D(int i3);

    int J(int i3);

    gm4.c K0(long j3);

    void L();

    void P(Activity activity, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener);

    void R0(t tVar);

    d S2();

    void T2(long j3, boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> iResultListener, boolean z17);

    void U1();

    void Y0(int i3, Activity activity, int i16, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener);

    YoloRoomOuterClass$YoloRoomInfo a1(int i3);

    void a3(Activity activity, j jVar, i iVar);

    void f1(t tVar);

    boolean h2(int i3);

    void i3(IResultListener<UserProxyCmdOuterClass$GetUserRouteInfoRsp> iResultListener);

    YoloRoomOuterClass$YoloRoomInfo j0(int i3);

    void j2(long j3, String str);

    gm4.d k(long j3);

    gm4.a m0(long j3);

    void onLogout();

    void t1(long j3, f fVar);

    int t2(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo);

    YoloRoomOuterClass$YoloRoomInfo z1();
}
