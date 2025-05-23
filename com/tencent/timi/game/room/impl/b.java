package com.tencent.timi.game.room.impl;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.room.impl.test.TimiRoomTestFragment;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.i;
import fm4.j;
import fm4.m;
import fm4.p;
import fm4.q;
import fm4.s;
import fm4.t;
import fm4.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.UserProxyCmdOuterClass$GetUserRouteInfoRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameOneSchema;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDoubleCheckPlayer;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomJoinGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomStartGameCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass$YoloUserGameData;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b implements fm4.g {

    /* renamed from: a, reason: collision with root package name */
    com.tencent.timi.game.tim.api.message.d f379171a = new a();

    /* renamed from: b, reason: collision with root package name */
    private gm4.c f379172b = new c();

    /* renamed from: c, reason: collision with root package name */
    private gm4.b f379173c = new d();

    /* renamed from: d, reason: collision with root package name */
    private gm4.d f379174d = new e();

    /* renamed from: e, reason: collision with root package name */
    private gm4.a f379175e = new f();

    /* renamed from: f, reason: collision with root package name */
    private gm4.e f379176f = new g();

    /* renamed from: g, reason: collision with root package name */
    private gm4.f f379177g = new h();

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.room.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C9963b extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.d f379179a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f379180b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.c f379181c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IResultListener f379182d;

        C9963b(com.tencent.timi.game.room.impl.util.d dVar, Activity activity, com.tencent.timi.game.room.impl.util.c cVar, IResultListener iResultListener) {
            this.f379179a = dVar;
            this.f379180b = activity;
            this.f379181c = cVar;
            this.f379182d = iResultListener;
        }

        @Override // fm4.m, fm4.i
        public void a(String str) {
            IResultListener iResultListener = this.f379182d;
            if (iResultListener != null) {
                iResultListener.onError(-1244, "");
            }
            b.Q3(this.f379180b);
            YoloRoomUtil.l0(str, this.f379179a, this.f379181c);
        }

        @Override // fm4.i
        public void b(boolean z16) {
            l.i("RoomServiceImpl", "enterYoloRoom " + this.f379179a.f379324a + " - checkSuccess");
            b.R3(this.f379180b);
            YoloRoomUtil.I(this.f379180b, this.f379179a, this.f379181c, this.f379182d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class g implements gm4.e {
        g() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class h implements gm4.f {
        h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q3(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R3(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).showLoadingView();
        }
    }

    @Override // fm4.g
    public gm4.b A(long j3) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            return j16;
        }
        l.e("RoomServiceImpl", "YoloRoomManager is null! - IRoomDoOpService");
        return this.f379173c;
    }

    @Override // fm4.g
    public void B1(long j3, fm4.f fVar) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            j16.X1(true, fVar);
        } else {
            l.e("RoomServiceImpl", "YoloRoomManager is null! - notifyRoomPageOpen");
        }
    }

    @Override // fm4.g
    public boolean D(int i3) {
        return YoloRoomUtil.c0(i3);
    }

    @Override // fm4.g
    public int J(int i3) {
        return YoloRoomUtil.y(i3);
    }

    @Override // fm4.g
    public gm4.c K0(long j3) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            return j16;
        }
        l.e("RoomServiceImpl", "YoloRoomManager is null! - IRoomGetDataService");
        return this.f379172b;
    }

    @Override // fm4.g
    public void L() {
        TimiRoomTestFragment.ph(vf4.a.b());
    }

    @Override // fm4.g
    public void P(Activity activity, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        j c16;
        if (cVar.f379322a > 0) {
            c16 = j.d(dVar, cVar);
        } else {
            c16 = j.c(dVar);
        }
        YoloRoomUtil.G(activity, c16, new C9963b(dVar, activity, cVar, iResultListener));
    }

    public void P3(long j3, IResultListener<UserProxyCmdOuterClass$GetUserRouteInfoRsp> iResultListener) {
        YoloRoomUtil.P(j3, iResultListener);
    }

    @Override // fm4.g
    public void R0(t tVar) {
        com.tencent.timi.game.room.impl.d.g().u(tVar);
    }

    @Override // fm4.g
    public fm4.d S2() {
        return YoloRoomCommonConfManager.f379027a;
    }

    @Override // fm4.g
    public void T2(long j3, boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> iResultListener, boolean z17) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            j16.N1(z16, i3, iResultListener, z17);
        } else {
            l.e("RoomServiceImpl", "YoloRoomManager is null! - leaveRoom");
        }
    }

    @Override // fm4.g
    public void U1() {
        YoloRoomUtil.h0();
    }

    @Override // fm4.g
    public void Y0(int i3, Activity activity, int i16, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        YoloRoomUtil.K(i3, activity, i16, 5, false, iResultListener);
    }

    @Override // fm4.g
    public YoloRoomOuterClass$YoloRoomInfo a1(int i3) {
        return com.tencent.timi.game.room.impl.d.g().i(i3);
    }

    @Override // fm4.g
    public void a3(Activity activity, j jVar, i iVar) {
        YoloRoomUtil.G(activity, jVar, iVar);
    }

    @Override // fm4.g
    public void f1(t tVar) {
        com.tencent.timi.game.room.impl.d.g().v(tVar);
    }

    @Override // fm4.g
    public boolean h2(int i3) {
        return hm4.a.u(i3);
    }

    @Override // fm4.g
    public void i3(IResultListener<UserProxyCmdOuterClass$GetUserRouteInfoRsp> iResultListener) {
        P3(((ll4.a) mm4.b.b(ll4.a.class)).h(), iResultListener);
    }

    @Override // fm4.g
    public YoloRoomOuterClass$YoloRoomInfo j0(int i3) {
        return com.tencent.timi.game.room.impl.d.g().h(i3);
    }

    @Override // fm4.g
    public void j2(long j3, String str) {
        YoloRoomManager.b1(str);
    }

    @Override // fm4.g
    public gm4.d k(long j3) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            return j16;
        }
        l.e("RoomServiceImpl", "YoloRoomManager is null! - IRoomListenerService");
        return this.f379174d;
    }

    @Override // fm4.g
    public gm4.a m0(long j3) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            return j16.l1();
        }
        l.e("RoomServiceImpl", "YoloRoomManager is null! - IRoomAudioService");
        return this.f379175e;
    }

    @Override // fm4.g
    public void onLogout() {
        com.tencent.timi.game.room.impl.d.g().t();
    }

    @Override // fm4.g
    public void t1(long j3, fm4.f fVar) {
        YoloRoomManager j16 = com.tencent.timi.game.room.impl.d.g().j(j3);
        if (j16 != null) {
            j16.X1(false, fVar);
        } else {
            l.e("RoomServiceImpl", "YoloRoomManager is null! - notifyRoomPageClose");
        }
    }

    @Override // fm4.g
    public int t2(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo;
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            yoloRoomOuterClass$YoloRoomDataInfo = yoloRoomOuterClass$YoloRoomInfo.room_data_info;
        } else {
            yoloRoomOuterClass$YoloRoomDataInfo = null;
        }
        if (yoloRoomOuterClass$YoloRoomDataInfo != null) {
            return yoloRoomOuterClass$YoloRoomDataInfo.game_id.get();
        }
        return 0;
    }

    @Override // fm4.g
    public YoloRoomOuterClass$YoloRoomInfo z1() {
        return com.tencent.timi.game.room.impl.d.g().f();
    }

    @Override // mm4.a
    public void o2() {
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements com.tencent.timi.game.tim.api.message.d {
        a() {
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a aVar) {
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void a(long j3, @NotNull MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements gm4.c {
        c() {
        }

        @Override // gm4.c
        public long A(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            return 0L;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloCommonGameOneSchema C() {
            return null;
        }

        @Override // gm4.c
        public boolean D() {
            return false;
        }

        @Override // gm4.c
        @Nullable
        public CommonOuterClass$QQUserId E() {
            return null;
        }

        @Override // gm4.c
        public fm4.c G() {
            return null;
        }

        @Override // gm4.c
        public int I() {
            return 0;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloRoomSpeakingPosInfo L(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            return null;
        }

        @Override // gm4.c
        public int M() {
            return 0;
        }

        @Override // gm4.c
        public gh4.d P() {
            return null;
        }

        @Override // gm4.c
        public CommonOuterClass$QQUserId R() {
            return new CommonOuterClass$QQUserId();
        }

        @Override // gm4.c
        public boolean S() {
            return false;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloGameRouteInfo U() {
            return null;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloRoomConf Y() {
            return null;
        }

        @Override // gm4.c
        public ConcurrentHashMap<String, String> e() {
            return new ConcurrentHashMap<>();
        }

        @Override // gm4.c
        public long f() {
            return 0L;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloRoomInfo getRoomInfo() {
            return null;
        }

        @Override // gm4.c
        public int getRoomType() {
            return 0;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloRoomUserData m() {
            return null;
        }

        @Override // gm4.c
        public List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n() {
            return new ArrayList();
        }

        @Override // gm4.c
        public int o1() {
            return 0;
        }

        @Override // gm4.c
        public boolean q(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            return false;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloCommonGameOneSchema s() {
            return null;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloRoomDoubleCheckPlayer v(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            return null;
        }

        @Override // gm4.c
        public YoloRoomOuterClass$YoloCommonGameDataInfo w() {
            return null;
        }

        @Override // gm4.c
        public ConcurrentHashMap<String, String> x() {
            return new ConcurrentHashMap<>();
        }

        @Override // gm4.c
        public void N(ConcurrentHashMap<String, String> concurrentHashMap) {
        }

        @Override // gm4.c
        public void o(gh4.d dVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements gm4.b {
        d() {
        }

        @Override // gm4.b
        public void K(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void h(IResultListener<YoloRoomOuterClass$YoloRoomStartGameCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void i(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void k(IResultListener<YoloRoomOuterClass$YoloRoomJoinGameCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void p(String str) {
        }

        @Override // gm4.b
        public void u(fm4.a aVar) {
        }

        @Override // gm4.b
        public void F(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void J(int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void T(boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void W(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void Z(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void a(YoloRoomOuterClass$YoloRoomModifyInfoCmd yoloRoomOuterClass$YoloRoomModifyInfoCmd, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void c(CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void B(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void O(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void X(boolean z16, YoloRoomOuterClass$YoloUserGameData yoloRoomOuterClass$YoloUserGameData, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void g(boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void r(CommonOuterClass$QQUserId commonOuterClass$QQUserId, boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }

        @Override // gm4.b
        public void z(boolean z16, int i3, boolean z17, IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements gm4.d {
        e() {
        }

        @Override // gm4.d
        public void H(u uVar) {
        }

        @Override // gm4.d
        public void Q(q qVar) {
        }

        @Override // gm4.d
        public void V(p pVar) {
        }

        @Override // gm4.d
        public void b(s sVar) {
        }

        @Override // gm4.d
        public void d(s sVar) {
        }

        @Override // gm4.d
        public void j(t tVar) {
        }

        @Override // gm4.d
        public void l(p pVar) {
        }

        @Override // gm4.d
        public void t(t tVar) {
        }

        @Override // gm4.d
        public void y(q qVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class f implements gm4.a {
        f() {
        }

        @Override // gm4.a
        public boolean a() {
            return false;
        }

        @Override // gm4.a
        public boolean b() {
            return false;
        }

        @Override // gm4.a
        public LiveData<Boolean> d() {
            return null;
        }

        @Override // gm4.a
        public LiveData<Boolean> e() {
            return null;
        }

        @Override // gm4.a
        public void c(boolean z16) {
        }
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
