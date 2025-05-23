package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.LogUtil;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass$RoomRouteInfo;
import trpc.yes.common.GameDataServerOuterClass$SmobaGameMode;
import trpc.yes.common.PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp;
import trpc.yes.common.RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp;
import trpc.yes.common.SafeOuterClass$SafeCheckResult;
import trpc.yes.common.UserProxyCmdOuterClass$GetUserRouteInfoRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloCommunityRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCreateRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomEnterRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomLeaveRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomRecoverRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class YoloRoomUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements ag4.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ fm4.j f379272a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ fm4.i f379273b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f379274c;

        a(fm4.j jVar, fm4.i iVar, Activity activity) {
            this.f379272a = jVar;
            this.f379273b = iVar;
            this.f379274c = activity;
        }

        @Override // ag4.d
        public void a(String str) {
            fm4.i iVar = this.f379273b;
            if (iVar != null) {
                iVar.a(str);
            }
        }

        @Override // ag4.d
        public void onSuccess() {
            if (com.tencent.timi.game.room.impl.d.g().m()) {
                ArrayList arrayList = new ArrayList();
                if (YoloRoomUtil.c0(this.f379272a.f399883b)) {
                    if (this.f379272a.f399885d == 3) {
                        arrayList.addAll(YoloRoomUtil.J());
                        arrayList.add(5);
                    } else {
                        arrayList.addAll(YoloRoomUtil.J());
                    }
                } else {
                    arrayList.add(Integer.valueOf(this.f379272a.f399883b));
                }
                YoloRoomManager k3 = com.tencent.timi.game.room.impl.d.g().k(arrayList);
                if (k3 == null) {
                    fm4.i iVar = this.f379273b;
                    if (iVar != null) {
                        iVar.b(true);
                        return;
                    }
                    return;
                }
                if (k3.getRoomInfo() != null && k3.getRoomInfo().room_data_info.sub_create_from.get() == 3) {
                    fm4.j jVar = this.f379272a;
                    if (jVar.f399885d == 3) {
                        YoloRoomUtil.n0(k3, jVar, this.f379274c, this.f379273b);
                        return;
                    }
                    fm4.i iVar2 = this.f379273b;
                    if (iVar2 != null) {
                        iVar2.a("\u9700\u9000\u51fa\u5b50\u9891\u9053\u8f66\u961f");
                        com.tencent.timi.game.ui.widget.f.d(true, "\u9700\u9000\u51fa\u5b50\u9891\u9053\u8f66\u961f");
                        return;
                    }
                    return;
                }
                if (!YoloRoomUtil.c0(k3.getRoomType())) {
                    YoloRoomUtil.H(k3, this.f379273b);
                    return;
                } else {
                    YoloRoomUtil.n0(k3, this.f379272a, this.f379274c, this.f379273b);
                    return;
                }
            }
            fm4.i iVar3 = this.f379273b;
            if (iVar3 != null) {
                iVar3.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f379276b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ fm4.j f379277c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ag4.d f379278d;

        b(int i3, Activity activity, fm4.j jVar, ag4.d dVar) {
            this.f379275a = i3;
            this.f379276b = activity;
            this.f379277c = jVar;
            this.f379278d = dVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            ag4.e b16;
            ag4.i iVar = (ag4.i) mm4.b.b(ag4.i.class);
            int i3 = this.f379275a;
            Activity activity = this.f379276b;
            fm4.j jVar = this.f379277c;
            if (jVar.f399882a) {
                b16 = ag4.e.a(jVar.a());
            } else {
                int a16 = jVar.a();
                fm4.j jVar2 = this.f379277c;
                b16 = ag4.e.b(a16, jVar2.f399886e, jVar2.f399887f, jVar2.f399888g);
            }
            iVar.L1(i3, activity, b16, false, this.f379278d);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            ag4.e b16;
            ag4.i iVar = (ag4.i) mm4.b.b(ag4.i.class);
            int i16 = this.f379275a;
            Activity activity = this.f379276b;
            fm4.j jVar = this.f379277c;
            if (jVar.f399882a) {
                b16 = ag4.e.a(jVar.a());
            } else {
                int a16 = jVar.a();
                fm4.j jVar2 = this.f379277c;
                b16 = ag4.e.b(a16, jVar2.f399886e, jVar2.f399887f, jVar2.f399888g);
            }
            iVar.L1(i16, activity, b16, false, this.f379278d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ fm4.i f379279d;

        c(fm4.i iVar) {
            this.f379279d = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            fm4.i iVar = this.f379279d;
            if (iVar != null) {
                iVar.a("\u672a\u9009\u62e9\u9000\u51fa\u5f53\u524d\u623f\u95f4");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ YoloRoomManager f379280d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ fm4.i f379281e;

        d(YoloRoomManager yoloRoomManager, fm4.i iVar) {
            this.f379280d = yoloRoomManager;
            this.f379281e = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            YoloRoomUtil.H(this.f379280d, this.f379281e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ fm4.i f379282a;

        e(fm4.i iVar) {
            this.f379282a = iVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
            fm4.i iVar = this.f379282a;
            if (iVar != null) {
                iVar.b(false);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            fm4.i iVar = this.f379282a;
            if (iVar != null) {
                iVar.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements pl4.d<UserProxyCmdOuterClass$GetUserRouteInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f379283a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f379284b;

        f(long j3, IResultListener iResultListener) {
            this.f379283a = j3;
            this.f379284b = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable UserProxyCmdOuterClass$GetUserRouteInfoRsp userProxyCmdOuterClass$GetUserRouteInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "getUserOnlineRouteInfoList_" + LogUtil.wrapLogUin(String.valueOf(this.f379283a)) + " - onError - " + i16 + " " + str2);
            IResultListener iResultListener = this.f379284b;
            if (iResultListener != null) {
                iResultListener.onError(i16, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(UserProxyCmdOuterClass$GetUserRouteInfoRsp userProxyCmdOuterClass$GetUserRouteInfoRsp, FromServiceMsg fromServiceMsg) {
            com.tencent.timi.game.utils.l.i("YoloRoomUtil", "getUserOnlineRouteInfoList_" + LogUtil.wrapLogUin(String.valueOf(this.f379283a)) + " - onSuccess");
            IResultListener iResultListener = this.f379284b;
            if (iResultListener != null) {
                iResultListener.onSuccess(userProxyCmdOuterClass$GetUserRouteInfoRsp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            YoloRoomUtil.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.utils.r f379285a;

        i(com.tencent.timi.game.utils.r rVar) {
            this.f379285a = rVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            com.tencent.timi.game.utils.r rVar = this.f379285a;
            if (rVar != null) {
                rVar.a(iUserInfo);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.utils.r rVar = this.f379285a;
            if (rVar != null) {
                rVar.a(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class j implements com.tencent.timi.game.utils.r<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f379286a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f379287b;

        j(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, long j3) {
            this.f379286a = yoloRoomOuterClass$YoloRoomInfo;
            this.f379287b = j3;
        }

        @Override // com.tencent.timi.game.utils.r
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(IUserInfo iUserInfo) {
            boolean z16;
            String str;
            long j3;
            int t26 = ((fm4.g) mm4.b.b(fm4.g.class)).t2(this.f379286a);
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(this.f379286a);
            L.put("yes_game_id", String.valueOf(t26));
            if (t26 == 101) {
                z16 = true;
            } else {
                z16 = false;
            }
            long j16 = 0;
            if (this.f379286a.game_route_info.has()) {
                if (z16) {
                    if (this.f379286a.game_route_info.smoba_game_route_info.has() && this.f379286a.game_route_info.smoba_game_route_info.base_info.has()) {
                        j3 = this.f379286a.game_route_info.smoba_game_route_info.base_info.yolo_battle_id.get();
                        j16 = j3;
                    }
                } else if (this.f379286a.game_route_info.common_game_route_info.has() && this.f379286a.game_route_info.common_game_route_info.base_info.has()) {
                    j3 = this.f379286a.game_route_info.common_game_route_info.base_info.yolo_battle_id.get();
                    j16 = j3;
                }
            }
            L.put("yes_launch_id", String.valueOf(j16));
            String str2 = "0";
            if (!((fm4.g) mm4.b.b(fm4.g.class)).m0(this.f379287b).a()) {
                str = "0";
            } else {
                str = "1";
            }
            L.put("yes_voice_status", str);
            if (((fm4.g) mm4.b.b(fm4.g.class)).m0(this.f379287b).b()) {
                str2 = "1";
            }
            L.put("yes_mic_status", str2);
            L.put("yes_game_platid", "1");
            LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2 = ((ag4.i) mm4.b.b(ag4.i.class)).B2(t26);
            if (B2 != null && B2.getValue() != null) {
                L.put("yes_game_areaid", String.valueOf(B2.getValue().role_info.area.get()));
                L.put("yes_game_worldid", String.valueOf(B2.getValue().role_info.partition.get()));
            }
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null && I0.m0() != null) {
                L.put("yes_member_tag_id", I0.m0().o(this.f379287b));
            }
            if (z16) {
                if (iUserInfo != null && iUserInfo.getUserGameOpenid() != null && iUserInfo.getUserGameOpenid().smoba_openid != null) {
                    L.put("yes_game_openid", iUserInfo.getUserGameOpenid().smoba_openid.get());
                }
                YoloRoomOuterClass$YoloRoomSpeakingPosInfo L2 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379287b).L(((ll4.a) mm4.b.b(ll4.a.class)).E());
                if (L2 != null) {
                    L.put("yes_user_branch", L2.user_game_data.user_smoba_game_data.hero_lane_type.get() + "");
                }
            }
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_game_launch_success", L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class k implements IResultListener<UserProxyCmdOuterClass$GetUserRouteInfoRsp> {
        k() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UserProxyCmdOuterClass$GetUserRouteInfoRsp userProxyCmdOuterClass$GetUserRouteInfoRsp) {
            int i3;
            int i16;
            CommonOuterClass$OnlineRouteInfoList N = YoloRoomUtil.N(userProxyCmdOuterClass$GetUserRouteInfoRsp);
            if (N != null) {
                i3 = N.route_list.size();
            } else {
                i3 = 0;
            }
            com.tencent.timi.game.utils.l.i("YoloRoomUtil", "refreshRoomRoute OnlineRouteInfoList - " + i3);
            if (i3 > 0) {
                i16 = 0;
                for (CommonOuterClass$OnlineRouteInfo commonOuterClass$OnlineRouteInfo : N.route_list.get()) {
                    if (commonOuterClass$OnlineRouteInfo.route_status.get() == 1 && commonOuterClass$OnlineRouteInfo.yolo_room_route_info.has()) {
                        i16++;
                        CommonOuterClass$RoomRouteInfo commonOuterClass$RoomRouteInfo = commonOuterClass$OnlineRouteInfo.yolo_room_route_info;
                        long j3 = commonOuterClass$OnlineRouteInfo.expire_time.get() * 1000;
                        long j16 = commonOuterClass$RoomRouteInfo.room_id.get();
                        int i17 = commonOuterClass$RoomRouteInfo.room_type.get();
                        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "refreshRoomRoute - YoloRoomRouteInfo, yoloRoomId = " + j16 + ", yoloRoomType= " + i17 + ", expireTime =" + j3);
                        if (j16 != 0 && j3 > yn4.d.d()) {
                            if (!com.tencent.timi.game.room.impl.d.g().n(j16)) {
                                YoloRoomUtil.g0(j16, i17, false);
                            } else {
                                com.tencent.timi.game.utils.l.i("YoloRoomUtil", "refreshRoomRoute - room exist -" + j16);
                            }
                        }
                    }
                }
            } else {
                i16 = 0;
            }
            if (i16 == 0) {
                com.tencent.timi.game.room.impl.d.w(false);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "refreshRoomRouteAndResume#getOnlineRouteInfoListRequest ERROR - " + i3 + ", errMsg = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class l implements pl4.d<PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379288a;

        l(IResultListener iResultListener) {
            this.f379288a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f379288a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp, FromServiceMsg fromServiceMsg) {
            if (premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp != null) {
                this.f379288a.onSuccess(premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class m implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f379289a;

        m(long j3) {
            this.f379289a = j3;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
            com.tencent.timi.game.room.impl.d.g().d(this.f379289a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.ui.widget.f.c("\u9000\u51fa\u623f\u95f4\u5931\u8d25, " + str + "(" + i3 + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class n implements pl4.d<YoloRoomOuterClass$YoloRoomLeaveRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f379290a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f379291b;

        n(long j3, IResultListener iResultListener) {
            this.f379290a = j3;
            this.f379291b = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp, @Nullable FromServiceMsg fromServiceMsg) {
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "sendExitRoomNetReq " + this.f379290a + " - ERROR " + i16 + " - " + str);
            IResultListener iResultListener = this.f379291b;
            if (iResultListener != null) {
                iResultListener.onError(i16, str);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp, FromServiceMsg fromServiceMsg) {
            com.tencent.timi.game.utils.l.i("YoloRoomUtil", "sendExitRoomNetReq " + this.f379290a + " - SUCCESS");
            IResultListener iResultListener = this.f379291b;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomLeaveRsp);
                ((j05.b) mm4.b.b(j05.b.class)).G1(this.f379290a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class o implements pl4.d<YoloRoomOuterClass$YoloRoomRecoverRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TimiGameBaseActivity f379292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f379293b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f379294c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f379295d;

        o(TimiGameBaseActivity timiGameBaseActivity, long j3, int i3, boolean z16) {
            this.f379292a = timiGameBaseActivity;
            this.f379293b = j3;
            this.f379294c = i3;
            this.f379295d = z16;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$YoloRoomRecoverRsp yoloRoomOuterClass$YoloRoomRecoverRsp, @Nullable FromServiceMsg fromServiceMsg) {
            YoloRoomUtil.X(this.f379292a, this.f379293b, this.f379294c, i16, str, yoloRoomOuterClass$YoloRoomRecoverRsp);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloRoomOuterClass$YoloRoomRecoverRsp yoloRoomOuterClass$YoloRoomRecoverRsp, FromServiceMsg fromServiceMsg) {
            YoloRoomUtil.Y(yoloRoomOuterClass$YoloRoomRecoverRsp, this.f379292a, this.f379293b, this.f379294c, this.f379295d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class p implements pl4.d<YoloRoomOuterClass$YoloRoomEnterRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f379296a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.d f379297b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener f379298c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f379299d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.c f379300e;

        p(Activity activity, com.tencent.timi.game.room.impl.util.d dVar, IResultListener iResultListener, long j3, com.tencent.timi.game.room.impl.util.c cVar) {
            this.f379296a = activity;
            this.f379297b = dVar;
            this.f379298c = iResultListener;
            this.f379299d = j3;
            this.f379300e = cVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$YoloRoomEnterRsp yoloRoomOuterClass$YoloRoomEnterRsp, @Nullable FromServiceMsg fromServiceMsg) {
            int i18;
            String str3;
            YoloRoomUtil.V(z16, i16, str2, this.f379297b, this.f379300e, this.f379298c);
            if (z16) {
                i18 = i16;
            } else {
                i18 = i3;
            }
            if (z16) {
                str3 = str2;
            } else {
                str3 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            long j3 = this.f379299d;
            com.tencent.timi.game.room.impl.util.d dVar = this.f379297b;
            YoloRoomUtil.D(false, j3, i18, str3, dVar.f379324a, dVar.f379325b, dVar.f379328e, dVar.f379329f);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloRoomOuterClass$YoloRoomEnterRsp yoloRoomOuterClass$YoloRoomEnterRsp, FromServiceMsg fromServiceMsg) {
            if (!com.tencent.timi.game.room.impl.util.e.a(this.f379296a, yoloRoomOuterClass$YoloRoomEnterRsp.ieg_real_name_result)) {
                YoloRoomUtil.W(yoloRoomOuterClass$YoloRoomEnterRsp, this.f379297b.f379324a, this.f379298c);
                int A = YoloRoomUtil.A(this.f379297b.f379328e);
                if (A > 0) {
                    ((sm4.a) mm4.b.b(sm4.a.class)).g2(A, null);
                }
                long j3 = this.f379299d;
                com.tencent.timi.game.room.impl.util.d dVar = this.f379297b;
                YoloRoomUtil.D(true, j3, 0, "", dVar.f379324a, dVar.f379325b, dVar.f379328e, dVar.f379329f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class q extends fm4.m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f379301a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379302b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f379303c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f379304d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f379305e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IResultListener f379306f;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements pl4.d<RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp> {
            a() {
            }

            @Override // pl4.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp, @Nullable FromServiceMsg fromServiceMsg) {
                com.tencent.timi.game.utils.l.e("YoloRoomUtil", "getAndEnterExpandHallRoom ERROR , errorCode=" + i16 + ", errorMessage=" + str2);
                Activity activity = q.this.f379301a;
                if (activity != null && (activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
                    ((TimiGameBaseActivity) q.this.f379301a).hideLoadingView();
                }
                IResultListener iResultListener = q.this.f379306f;
                if (iResultListener != null) {
                    iResultListener.onError(i16, str2);
                }
            }

            @Override // pl4.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp, FromServiceMsg fromServiceMsg) {
                q qVar = q.this;
                YoloRoomUtil.T(recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp, qVar.f379306f, qVar.f379301a);
            }
        }

        q(Activity activity, int i3, int i16, boolean z16, int i17, IResultListener iResultListener) {
            this.f379301a = activity;
            this.f379302b = i3;
            this.f379303c = i16;
            this.f379304d = z16;
            this.f379305e = i17;
            this.f379306f = iResultListener;
        }

        @Override // fm4.i
        public void b(boolean z16) {
            int i3;
            YoloRoomUtil.o0(this.f379301a);
            pl4.c cVar = (pl4.c) mm4.b.b(pl4.c.class);
            int i16 = this.f379302b;
            int i17 = this.f379303c;
            if (this.f379304d) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            cVar.F1(jm4.d.d(i16, i17, i3, this.f379305e), RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.class, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class r implements pl4.d<YoloRoomOuterClass$YoloRoomCreateRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379308a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomParams f379309b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f379310c;

        r(IResultListener iResultListener, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, long j3) {
            this.f379308a = iResultListener;
            this.f379309b = yoloRoomOuterClass$YoloRoomParams;
            this.f379310c = j3;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$YoloRoomCreateRsp yoloRoomOuterClass$YoloRoomCreateRsp, @Nullable FromServiceMsg fromServiceMsg) {
            int i18;
            if (z16) {
                i18 = i16;
            } else {
                i18 = i3;
            }
            if (!z16) {
                str2 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom ERROR " + i18 + ", errorMessage=" + str2);
            if (i16 == 120) {
                YoloRoomUtil.F(this.f379309b.room_type.get(), this.f379308a, i18, str2);
            } else {
                YoloRoomUtil.v(this.f379308a, i18, str2);
            }
            YoloRoomUtil.C(this.f379309b, this.f379310c, false, i18, str2);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(YoloRoomOuterClass$YoloRoomCreateRsp yoloRoomOuterClass$YoloRoomCreateRsp, FromServiceMsg fromServiceMsg) {
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
            com.tencent.timi.game.utils.l.i("YoloRoomUtil", "createYoloRoom SUCCESS " + yoloRoomOuterClass$YoloRoomCreateRsp);
            if (yoloRoomOuterClass$YoloRoomCreateRsp != null) {
                ((j05.b) mm4.b.b(j05.b.class)).p2(yoloRoomOuterClass$YoloRoomCreateRsp.room_info.room_id.get(), yoloRoomOuterClass$YoloRoomCreateRsp.rotate_messsage_list.get());
                com.tencent.timi.game.room.impl.d.g().s(0, yoloRoomOuterClass$YoloRoomCreateRsp.room_info, yoloRoomOuterClass$YoloRoomCreateRsp.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomCreateRsp.speaking_pos_list_version.get(), 0L, yoloRoomOuterClass$YoloRoomCreateRsp.room_conf, yoloRoomOuterClass$YoloRoomCreateRsp.room_user_data);
            }
            IResultListener iResultListener = this.f379308a;
            if (yoloRoomOuterClass$YoloRoomCreateRsp != null) {
                yoloRoomOuterClass$YoloRoomInfo = yoloRoomOuterClass$YoloRoomCreateRsp.room_info;
            } else {
                yoloRoomOuterClass$YoloRoomInfo = null;
            }
            YoloRoomUtil.w(iResultListener, yoloRoomOuterClass$YoloRoomInfo);
            YoloRoomUtil.a0(yoloRoomOuterClass$YoloRoomCreateRsp);
            YoloRoomUtil.C(this.f379309b, this.f379310c, true, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class s implements IResultListener<UserProxyCmdOuterClass$GetUserRouteInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379311a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f379312b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f379313c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f379314d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes26.dex */
        public class a implements pl4.d<YoloRoomOuterClass$YoloRoomRecoverRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f379315a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f379316b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.timi.game.room.impl.util.YoloRoomUtil$s$a$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public class C9968a implements IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> {
                C9968a() {
                }

                @Override // com.tencent.timi.game.utils.IResultListener
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(YoloRoomOuterClass$YoloRoomLeaveRsp yoloRoomOuterClass$YoloRoomLeaveRsp) {
                    com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom - YoloRoomRecover YoloRoomLeave SUCCESS roomId = " + a.this.f379315a);
                }

                @Override // com.tencent.timi.game.utils.IResultListener
                public void onError(int i3, String str) {
                    com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom - YoloRoomRecover YoloRoomLeave ERROR roomId = " + a.this.f379315a + " - " + i3 + " - " + str);
                }
            }

            a(long j3, int i3) {
                this.f379315a = j3;
                this.f379316b = i3;
            }

            @Override // pl4.d
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable YoloRoomOuterClass$YoloRoomRecoverRsp yoloRoomOuterClass$YoloRoomRecoverRsp, @Nullable FromServiceMsg fromServiceMsg) {
                com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom - YoloRoomRecover rsp is null! roomId = " + this.f379315a);
                s sVar = s.this;
                if (sVar.f379311a == this.f379316b) {
                    YoloRoomUtil.v(sVar.f379312b, sVar.f379313c, sVar.f379314d);
                }
                YoloRoomUtil.m0(this.f379315a, true, this.f379316b, new C9968a());
            }

            @Override // pl4.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(YoloRoomOuterClass$YoloRoomRecoverRsp yoloRoomOuterClass$YoloRoomRecoverRsp, FromServiceMsg fromServiceMsg) {
                YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
                if (yoloRoomOuterClass$YoloRoomRecoverRsp != null) {
                    com.tencent.timi.game.room.impl.d.g().s(0, yoloRoomOuterClass$YoloRoomRecoverRsp.room_info, yoloRoomOuterClass$YoloRoomRecoverRsp.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomRecoverRsp.speaking_pos_list_version.get(), yoloRoomOuterClass$YoloRoomRecoverRsp.cur_action_id.get(), yoloRoomOuterClass$YoloRoomRecoverRsp.room_conf, yoloRoomOuterClass$YoloRoomRecoverRsp.room_user_data);
                } else {
                    com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom - YoloRoomRecover rsp is null! roomId = " + this.f379315a);
                }
                s sVar = s.this;
                if (sVar.f379311a == this.f379316b) {
                    IResultListener iResultListener = sVar.f379312b;
                    if (yoloRoomOuterClass$YoloRoomRecoverRsp != null) {
                        yoloRoomOuterClass$YoloRoomInfo = yoloRoomOuterClass$YoloRoomRecoverRsp.room_info;
                    } else {
                        yoloRoomOuterClass$YoloRoomInfo = null;
                    }
                    YoloRoomUtil.w(iResultListener, yoloRoomOuterClass$YoloRoomInfo);
                }
            }
        }

        s(int i3, IResultListener iResultListener, int i16, String str) {
            this.f379311a = i3;
            this.f379312b = iResultListener;
            this.f379313c = i16;
            this.f379314d = str;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(UserProxyCmdOuterClass$GetUserRouteInfoRsp userProxyCmdOuterClass$GetUserRouteInfoRsp) {
            List<CommonOuterClass$OnlineRouteInfo> Q = YoloRoomUtil.Q(userProxyCmdOuterClass$GetUserRouteInfoRsp);
            if (Q.size() <= 0) {
                YoloRoomUtil.v(this.f379312b, this.f379313c, this.f379314d);
                return;
            }
            for (CommonOuterClass$OnlineRouteInfo commonOuterClass$OnlineRouteInfo : Q) {
                long j3 = commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_id.get();
                ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.i.d(j3), YoloRoomOuterClass$YoloRoomRecoverRsp.class, new a(j3, commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_type.get()));
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom - getUserOnlineRouteInfoList errorCode = " + i3 + " - " + str);
            YoloRoomUtil.v(this.f379312b, this.f379313c, this.f379314d);
        }
    }

    public static int A(int i3) {
        return ((ag4.h) mm4.b.b(ag4.h.class)).o1(i3);
    }

    public static void B(YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, YoloRoomOuterClass$YoloCommunityRoomParams yoloRoomOuterClass$YoloCommunityRoomParams, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        long currentTimeMillis = System.currentTimeMillis();
        wm4.a.a();
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.b.d(yoloRoomOuterClass$YoloRoomParams, yoloRoomOuterClass$YoloGameRoomParams, yoloRoomOuterClass$YoloCommunityRoomParams), YoloRoomOuterClass$YoloRoomCreateRsp.class, new r(iResultListener, yoloRoomOuterClass$YoloRoomParams, currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, long j3, boolean z16, int i3, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("k_cost_time", String.valueOf(System.currentTimeMillis() - j3));
        if (z16) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, str2);
        hashMap.put("k_err_code", String.valueOf(i3));
        hashMap.put("k_err_msg", str);
        if (yoloRoomOuterClass$YoloRoomParams != null) {
            int i16 = yoloRoomOuterClass$YoloRoomParams.room_type.get();
            int A = A(i16);
            hashMap.put("k_room_type", String.valueOf(i16));
            hashMap.put("k_yes_game_id", String.valueOf(A));
            hashMap.put("k_user_from", String.valueOf(yoloRoomOuterClass$YoloRoomParams.create_from.get()));
            hashMap.put("k_guild_id", String.valueOf(yoloRoomOuterClass$YoloRoomParams.guild_id.get()));
            hashMap.put("k_channel_id", String.valueOf(yoloRoomOuterClass$YoloRoomParams.channel_id.get()));
            hashMap.put("k_channel_name", String.valueOf(yoloRoomOuterClass$YoloRoomParams.channel_name.get()));
        }
        ((ug4.b) mm4.b.b(ug4.b.class)).e("e_room_core_create", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(boolean z16, long j3, int i3, String str, long j16, int i16, int i17, fm4.c cVar) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("k_cost_time", String.valueOf(System.currentTimeMillis() - j3));
        if (z16) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        hashMap.put(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT, str2);
        hashMap.put("k_err_code", String.valueOf(i3));
        hashMap.put("k_err_msg", str);
        hashMap.put("k_room_id", String.valueOf(j16));
        int A = A(i17);
        hashMap.put("k_room_type", String.valueOf(i17));
        hashMap.put("k_yes_game_id", String.valueOf(A));
        hashMap.put("k_user_from", String.valueOf(i16));
        if (cVar != null) {
            hashMap.put("k_guild_id", String.valueOf(cVar.f399871a));
            hashMap.put("k_channel_id", String.valueOf(cVar.f399872b));
            hashMap.put("k_channel_name", String.valueOf(cVar.f399873c));
        }
        ((ug4.b) mm4.b.b(ug4.b.class)).e("e_room_core_join", hashMap);
    }

    private static void E(long j3, int i3) {
        m0(j3, true, i3, new m(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(int i3, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener, int i16, String str) {
        P(((ll4.a) mm4.b.b(ll4.a.class)).h(), new s(i3, iResultListener, i16, str));
    }

    public static void G(Activity activity, fm4.j jVar, fm4.i iVar) {
        YoloRoomManager j3 = com.tencent.timi.game.room.impl.d.g().j(jVar.f399886e);
        if (!jVar.f399882a && j3 != null && jVar.f399886e == j3.m1()) {
            if (iVar != null) {
                iVar.c(j3.getRoomInfo());
                return;
            }
            return;
        }
        a aVar = new a(jVar, iVar, activity);
        if (c0(jVar.f399883b) && jVar.f399885d != 3) {
            ((bo4.d) mm4.b.b(bo4.d.class)).I3(((ll4.a) mm4.b.b(ll4.a.class)).E(), new b(A(jVar.f399883b), activity, jVar, aVar));
        } else {
            aVar.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(YoloRoomManager yoloRoomManager, fm4.i iVar) {
        yoloRoomManager.N1(false, 0, new e(iVar), true);
    }

    public static void I(Activity activity, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.g.d(dVar), YoloRoomOuterClass$YoloRoomEnterRsp.class, new p(activity, dVar, iResultListener, System.currentTimeMillis(), cVar));
    }

    public static List<Integer> J() {
        return ((ag4.h) mm4.b.b(ag4.h.class)).C1();
    }

    public static void K(int i3, Activity activity, int i16, int i17, boolean z16, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "getAndEnterExpandHallRoom , yesGameId=" + i3 + ", enterFrom=" + i16 + ", yoloRoomType=" + i17 + ", activity = " + activity);
        Activity p06 = p0(activity);
        com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
        dVar.f379328e = i17;
        dVar.f379325b = i16;
        dVar.f379326c = 1;
        dVar.f379324a = 0L;
        G(p06, fm4.j.c(dVar), new q(p06, i3, i16, z16, i17, iResultListener));
    }

    public static ConcurrentHashMap<String, String> L(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            concurrentHashMap.put("yes_game_id", String.valueOf(((fm4.g) mm4.b.b(fm4.g.class)).t2(yoloRoomOuterClass$YoloRoomInfo)));
            if (c0(yoloRoomOuterClass$YoloRoomInfo.room_type.get())) {
                concurrentHashMap.putAll(M(yoloRoomOuterClass$YoloRoomInfo));
                long f16 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(yoloRoomOuterClass$YoloRoomInfo.room_id.get()).f();
                if (f16 != 0) {
                    concurrentHashMap.put("yes_ref_room_id", String.valueOf(f16));
                    concurrentHashMap.put("yes_ref_room_type", String.valueOf(5));
                }
                t(concurrentHashMap, ((fm4.g) mm4.b.b(fm4.g.class)).K0(yoloRoomOuterClass$YoloRoomInfo.room_id.get()).G());
                if (((sm4.a) mm4.b.b(sm4.a.class)).y3()) {
                    ConcurrentHashMap<String, String> x16 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(yoloRoomOuterClass$YoloRoomInfo.room_id.get()).x();
                    if (x16 != null) {
                        concurrentHashMap.putAll(x16);
                    }
                    concurrentHashMap.put("yes_ref_room_type", String.valueOf(3));
                }
            } else {
                concurrentHashMap.put("yes_room_type", String.valueOf(yoloRoomOuterClass$YoloRoomInfo.room_type.get()));
                concurrentHashMap.put("yes_room_id", String.valueOf(yoloRoomOuterClass$YoloRoomInfo.room_id.get()));
                gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
                if (I0 != null && I0.m0() != null) {
                    concurrentHashMap.putAll(I0.m0().h());
                }
            }
        }
        return concurrentHashMap;
    }

    public static ConcurrentHashMap<String, String> M(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        if (c0(yoloRoomOuterClass$YoloRoomInfo.room_type.get())) {
            concurrentHashMap.put("yes_team_id", String.valueOf(yoloRoomOuterClass$YoloRoomInfo.room_id.get()));
            concurrentHashMap.put("yes_team_name", yoloRoomOuterClass$YoloRoomInfo.introduce.get());
            YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo = yoloRoomOuterClass$YoloRoomInfo.game_data_info;
            if (yoloRoomOuterClass$YoloGameDataInfo.has()) {
                if (yoloRoomOuterClass$YoloGameDataInfo.smoba_game_data_info.has()) {
                    List<Integer> list = yoloRoomOuterClass$YoloGameDataInfo.smoba_game_data_info.grade_list.get();
                    List<Integer> list2 = yoloRoomOuterClass$YoloGameDataInfo.smoba_game_data_info.need_lane_type.get();
                    concurrentHashMap.put("yes_team_rank", z(list));
                    concurrentHashMap.put("yes_team_branch", z(list2));
                    concurrentHashMap.put("yes_game_mode", String.valueOf(yoloRoomOuterClass$YoloGameDataInfo.smoba_game_data_info.mode_name.get()));
                } else if (yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info.has()) {
                    concurrentHashMap.put("yes_game_mode", String.valueOf(yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info.mode_name.get()));
                    concurrentHashMap.put("yes_team_rank", z(yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info.grade_list.get()));
                }
            }
            if (yoloRoomOuterClass$YoloRoomInfo.game_data_info.common_game_data_info.gift_config.has()) {
                YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = yoloRoomOuterClass$YoloRoomInfo.game_data_info.common_game_data_info.gift_config.get();
                concurrentHashMap.put("yes_team_type", "1");
                concurrentHashMap.put("yes_gift_id", yoloRoomOuterClass$YoloGiftConfig.gift_id.get() + "");
                concurrentHashMap.put("yes_gift_nums", yoloRoomOuterClass$YoloGiftConfig.gift_num.get() + "");
            } else {
                concurrentHashMap.put("yes_team_type", "0");
                concurrentHashMap.put("yes_gift_id", "");
                concurrentHashMap.put("yes_gift_nums", "");
            }
            concurrentHashMap.put("yes_game_id", String.valueOf(((fm4.g) mm4.b.b(fm4.g.class)).t2(yoloRoomOuterClass$YoloRoomInfo)));
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CommonOuterClass$OnlineRouteInfoList N(UserProxyCmdOuterClass$GetUserRouteInfoRsp userProxyCmdOuterClass$GetUserRouteInfoRsp) {
        if (userProxyCmdOuterClass$GetUserRouteInfoRsp != null && userProxyCmdOuterClass$GetUserRouteInfoRsp.route_list.has()) {
            return userProxyCmdOuterClass$GetUserRouteInfoRsp.route_list;
        }
        return null;
    }

    private static Activity O() {
        QBaseActivity b16 = vf4.a.b();
        if (b16 != null && !b16.isFinishing()) {
            return b16;
        }
        return null;
    }

    public static void P(long j3, IResultListener<UserProxyCmdOuterClass$GetUserRouteInfoRsp> iResultListener) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.e.d(j3), UserProxyCmdOuterClass$GetUserRouteInfoRsp.class, new f(j3, iResultListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<CommonOuterClass$OnlineRouteInfo> Q(UserProxyCmdOuterClass$GetUserRouteInfoRsp userProxyCmdOuterClass$GetUserRouteInfoRsp) {
        ArrayList arrayList = new ArrayList();
        if (userProxyCmdOuterClass$GetUserRouteInfoRsp != null && userProxyCmdOuterClass$GetUserRouteInfoRsp.route_list.has() && userProxyCmdOuterClass$GetUserRouteInfoRsp.route_list.route_list.size() > 0) {
            for (CommonOuterClass$OnlineRouteInfo commonOuterClass$OnlineRouteInfo : userProxyCmdOuterClass$GetUserRouteInfoRsp.route_list.route_list.get()) {
                if (commonOuterClass$OnlineRouteInfo != null && commonOuterClass$OnlineRouteInfo.route_status.get() == 1 && commonOuterClass$OnlineRouteInfo.yolo_room_route_info.room_id.get() != 0 && commonOuterClass$OnlineRouteInfo.expire_time.get() * 1000 > yn4.d.d()) {
                    arrayList.add(commonOuterClass$OnlineRouteInfo);
                }
            }
        }
        return arrayList;
    }

    private static void R(int i3, int i16, int i17, String str) {
        if (!S(i3, i17, i16, str)) {
            if (!TextUtils.isEmpty(str)) {
                com.tencent.timi.game.ui.widget.f.c(str);
            } else {
                com.tencent.timi.game.ui.widget.f.c("\u52a0\u5165\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002");
            }
        }
    }

    public static boolean S(int i3, int i16, int i17, String str) {
        String str2;
        String str3;
        com.tencent.timi.game.utils.l.e("YoloRoomUtil", "handleCommonJoinRoomError " + i17 + ", " + str);
        if (U(i3, i17, str)) {
            return true;
        }
        if (i17 == 920002) {
            str2 = "\u8f66\u961f\u5df2\u4eba\u6ee1";
            str3 = "\u6765\u665a\u5566\uff0c\u8f66\u961f\u5df2\u4eba\u6ee1\uff0c\u6682\u65f6\u65e0\u6cd5\u52a0\u5165\uff0c\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662";
        } else if (i17 == 920003) {
            str2 = "\u8f66\u961f\u5df2\u5173\u95ed";
            str3 = "\u6765\u665a\u5566\uff0c\u8f66\u961f\u5df2\u89e3\u6563\uff0c\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662";
        } else if (i17 == 9200119) {
            str2 = "\u8f66\u961f\u5df2\u5f00\u59cb\u6e38\u620f";
            str3 = "\u6765\u665a\u5566\uff0c\u8f66\u961f\u5df2\u5f00\u59cb\u6e38\u620f\uff0c\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662";
        } else if (i17 != 9200121) {
            str2 = "";
            str3 = str2;
        } else {
            str2 = "\u65e0\u6cd5\u52a0\u5165";
            str3 = "\u6e38\u620f\u5185\u623f\u95f4\u6a21\u5f0f\u53d8\u66f4\uff0c\u65e0\u6cd5\u52a0\u5165\uff0c\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662";
        }
        if (i16 != 1 && !TextUtils.isEmpty(str3)) {
            com.tencent.timi.game.ui.widget.f.c(str3.replace("\uff0c\u6211\u4eec\u4e3a\u4f60\u63a8\u8350\u4e86\u5176\u4ed6\u8f66\u961f\u5662", ""));
            return true;
        }
        if (!TextUtils.isEmpty(str3) && i16 == 1) {
            QBaseActivity b16 = vf4.a.b();
            if (b16 != null && !b16.isFinishing()) {
                com.tencent.timi.game.ui.widget.e c16 = new e.a(b16).q(str2).j(str3).p("\u53bb\u770b\u770b").o(new h()).n("\u53d6\u6d88").m(new g()).c();
                i0(i17, c16);
                c16.show();
            } else {
                com.tencent.timi.game.ui.widget.f.c(str3);
            }
            return true;
        }
        if (i17 == -1244 || i17 == -11008) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener, Activity activity) {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        YoloRoomManager j3;
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "getAndEnterExpandHallRoom SUCCESS ");
        if (recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp != null && recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.enter_room_rsp.has()) {
            YoloRoomOuterClass$YoloRoomEnterRsp yoloRoomOuterClass$YoloRoomEnterRsp = recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.enter_room_rsp;
            ((j05.b) mm4.b.b(j05.b.class)).p2(yoloRoomOuterClass$YoloRoomEnterRsp.room_info.room_id.get(), yoloRoomOuterClass$YoloRoomEnterRsp.rotate_messsage_list.get());
            com.tencent.timi.game.room.impl.d.g().s(1, yoloRoomOuterClass$YoloRoomEnterRsp.room_info, yoloRoomOuterClass$YoloRoomEnterRsp.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomEnterRsp.speaking_pos_list_version.get(), yoloRoomOuterClass$YoloRoomEnterRsp.cur_action_id.get(), yoloRoomOuterClass$YoloRoomEnterRsp.room_conf, yoloRoomOuterClass$YoloRoomEnterRsp.room_user_data);
            if (yoloRoomOuterClass$YoloRoomEnterRsp.room_conf.has() && yoloRoomOuterClass$YoloRoomEnterRsp.room_conf.yolo_room_common_conf.has() && (j3 = com.tencent.timi.game.room.impl.d.g().j(yoloRoomOuterClass$YoloRoomEnterRsp.room_info.room_id.get())) != null) {
                j3.R1(yoloRoomOuterClass$YoloRoomEnterRsp.room_info.room_id.get(), yoloRoomOuterClass$YoloRoomEnterRsp.room_conf.yolo_room_common_conf.forbidden_speech_conf_list.get());
            }
            f0(iResultListener, recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp);
        }
        b0(activity);
        if (iResultListener != null) {
            if (recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp != null) {
                yoloRoomOuterClass$YoloRoomInfo = recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.enter_room_rsp.room_info;
            } else {
                yoloRoomOuterClass$YoloRoomInfo = null;
            }
            iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomInfo);
        }
    }

    public static boolean U(int i3, int i16, String str) {
        String str2;
        String str3;
        if (i16 >= 9500000 && i16 <= 9509999) {
            com.tencent.timi.game.utils.l.h("YoloRoomUtil", 1, "handleGameGangupErrorCode- NEED_CHANGE_GAME_ROLE, yoloRoomType " + i3 + ", " + i16 + " - " + str);
            if (TextUtils.isEmpty(str)) {
                str3 = "\u5f53\u524d\u6e38\u620f\u8d26\u53f7\u4e0d\u7b26\u5408\u8f66\u961f\u8981\u6c42\u5662\uff0c\u8bf7\u5207\u6362\u8d26\u53f7\u540e\u518d\u52a0\u5165\u8f66\u961f\u5427";
            } else {
                str3 = str;
            }
            int o16 = ((ag4.h) mm4.b.b(ag4.h.class)).o1(i3);
            Activity O = O();
            if (O != null) {
                hg4.d.u(false, o16, O, "", str3, "\u5207\u6362\u8d26\u53f7", ag4.e.a(0), false, null, false);
            } else {
                com.tencent.timi.game.ui.widget.f.c(str3);
            }
            return true;
        }
        if (i16 < 9510000 || i16 > 9519999) {
            return false;
        }
        com.tencent.timi.game.utils.l.h("YoloRoomUtil", 1, "handleGameGangupErrorCode- NEED_LAUNCH_GAME, yoloRoomType " + i3 + ", " + i16 + " - " + str);
        if (TextUtils.isEmpty(str)) {
            str2 = "\u4f60\u6ca1\u6709\u7b26\u5408\u6761\u4ef6\u7684\u5b89\u5353\u533a\u6e38\u620f\u8d26\u53f7\uff0c\u8bf7\u5148\u5230\u6e38\u620f\u4e2d\u521b\u5efa\u5427";
        } else {
            str2 = str;
        }
        int o17 = ((ag4.h) mm4.b.b(ag4.h.class)).o1(i3);
        Activity O2 = O();
        if (O2 != null) {
            hg4.d.v(o17, O2, "", str2, "\u542f\u52a8\u6e38\u620f");
        } else {
            com.tencent.timi.game.ui.widget.f.c(str2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(boolean z16, int i3, String str, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        com.tencent.timi.game.utils.l.e("YoloRoomUtil", "enterYoloRoom ERROR " + dVar.f379324a + ", errorCode=" + i3 + ", errorMessage=" + str);
        if (!z16) {
            str = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
        }
        R(dVar.f379328e, i3, dVar.f379326c, str);
        if (iResultListener != null) {
            iResultListener.onError(i3, str);
        }
        if (TextUtils.isEmpty(str)) {
            str = "err_" + i3;
        }
        l0(str, dVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W(YoloRoomOuterClass$YoloRoomEnterRsp yoloRoomOuterClass$YoloRoomEnterRsp, long j3, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "enterYoloRoom SUCCESS " + j3);
        e0(yoloRoomOuterClass$YoloRoomEnterRsp, j3);
        if (iResultListener != null) {
            if (yoloRoomOuterClass$YoloRoomEnterRsp != null) {
                yoloRoomOuterClass$YoloRoomInfo = yoloRoomOuterClass$YoloRoomEnterRsp.room_info;
            } else {
                yoloRoomOuterClass$YoloRoomInfo = null;
            }
            iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void X(TimiGameBaseActivity timiGameBaseActivity, long j3, int i3, int i16, String str, YoloRoomOuterClass$YoloRoomRecoverRsp yoloRoomOuterClass$YoloRoomRecoverRsp) {
        if (timiGameBaseActivity != null) {
            timiGameBaseActivity.hideLoadingView();
        }
        com.tencent.timi.game.utils.l.e("YoloRoomUtil", "handleLoginRsp - YoloRoomRecover onError roomId = " + j3 + " - " + i16 + " - " + str);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(920017, "\u623f\u95f4\u5df2\u88ab\u5c01\u7981");
        sparseArray.put(920009, "\u4f60\u5df2\u4e0d\u5728\u623f\u95f4");
        sparseArray.put(920003, "\u623f\u95f4\u5df2\u5173\u95ed");
        sparseArray.put(920010, "\u72b6\u6001\u5f02\u5e38");
        String str2 = "";
        String str3 = (String) sparseArray.get(i16, "");
        boolean z16 = !TextUtils.isEmpty(str3);
        if (!TextUtils.isEmpty(str3)) {
            com.tencent.timi.game.ui.widget.f.c(str3);
        } else if (i16 != 9200200) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u6062\u590d\u623f\u95f4\u5931\u8d25, ");
            sb5.append(str);
            if (eh4.a.e()) {
                str2 = "\nDebugOnly(" + i16 + ")";
            }
            sb5.append(str2);
            com.tencent.timi.game.ui.widget.f.c(sb5.toString());
        }
        if (z16) {
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "handleLoginRsp - YoloRoomRecover needManualExitRoom roomId = " + j3);
            E(j3, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Y(YoloRoomOuterClass$YoloRoomRecoverRsp yoloRoomOuterClass$YoloRoomRecoverRsp, TimiGameBaseActivity timiGameBaseActivity, long j3, int i3, boolean z16) {
        if (timiGameBaseActivity != null) {
            timiGameBaseActivity.hideLoadingView();
        }
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "recoverRoom success " + j3 + " - " + i3 + " - needJumpToRoomPage " + z16);
        if (yoloRoomOuterClass$YoloRoomRecoverRsp != null) {
            if (yoloRoomOuterClass$YoloRoomRecoverRsp.room_info.room_data_info.sub_create_from.get() != 3) {
                ((j05.b) mm4.b.b(j05.b.class)).p2(j3, yoloRoomOuterClass$YoloRoomRecoverRsp.rotate_messsage_list.get());
                com.tencent.timi.game.room.impl.d.g().s(2, yoloRoomOuterClass$YoloRoomRecoverRsp.room_info, yoloRoomOuterClass$YoloRoomRecoverRsp.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomRecoverRsp.speaking_pos_list_version.get(), yoloRoomOuterClass$YoloRoomRecoverRsp.cur_action_id.get(), yoloRoomOuterClass$YoloRoomRecoverRsp.room_conf, yoloRoomOuterClass$YoloRoomRecoverRsp.room_user_data);
                ((sm4.a) mm4.b.b(sm4.a.class)).U2(z16, yoloRoomOuterClass$YoloRoomRecoverRsp.room_info, 3);
                return;
            }
            return;
        }
        com.tencent.timi.game.utils.l.e("YoloRoomUtil", "handleLoginRsp - YoloRoomRecover rsp is null! roomId = " + j3);
    }

    public static boolean Z(int i3) {
        if (i3 != 920003) {
            if (i3 != 920009) {
                return false;
            }
            com.tencent.timi.game.ui.widget.f.c("\u4f60\u5df2\u4e0d\u5728\u623f\u95f4\u5185");
            return true;
        }
        com.tencent.timi.game.ui.widget.f.c("\u623f\u95f4\u5df2\u89e3\u6563");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a0(YoloRoomOuterClass$YoloRoomCreateRsp yoloRoomOuterClass$YoloRoomCreateRsp) {
        SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult;
        if (yoloRoomOuterClass$YoloRoomCreateRsp != null && (safeOuterClass$SafeCheckResult = yoloRoomOuterClass$YoloRoomCreateRsp.safe_check_result) != null && safeOuterClass$SafeCheckResult.has()) {
            final SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult2 = yoloRoomOuterClass$YoloRoomCreateRsp.safe_check_result;
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "createYoloRoom, safeCheckResult = " + safeOuterClass$SafeCheckResult2.code.get() + " - " + safeOuterClass$SafeCheckResult2.check_msg.get());
            if (safeOuterClass$SafeCheckResult2.code.get() != 0 && !TextUtils.isEmpty(safeOuterClass$SafeCheckResult2.check_msg.get())) {
                w.c(new Runnable() { // from class: com.tencent.timi.game.room.impl.util.YoloRoomUtil.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.timi.game.ui.widget.f.c(SafeOuterClass$SafeCheckResult.this.check_msg.get());
                    }
                });
            }
        }
    }

    private static void b0(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).hideLoadingView();
        }
    }

    public static boolean c0(int i3) {
        return ((ag4.h) mm4.b.b(ag4.h.class)).D(i3);
    }

    public static void d0() {
        Context b16 = vf4.a.b();
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "jumpToTeamList-openExpandHall topActivity - " + b16 + ", curHall = " + I0);
        if (I0 != null) {
            I0.Kc();
            return;
        }
        ExpandHallLaunchParam expandHallLaunchParam = new ExpandHallLaunchParam();
        expandHallLaunchParam.G = true;
        gh4.f fVar = (gh4.f) mm4.b.b(gh4.f.class);
        if (b16 == null) {
            b16 = eh4.a.b();
        }
        fVar.openExpandHall(b16, expandHallLaunchParam);
    }

    private static void e0(YoloRoomOuterClass$YoloRoomEnterRsp yoloRoomOuterClass$YoloRoomEnterRsp, long j3) {
        YoloRoomManager j16;
        if (yoloRoomOuterClass$YoloRoomEnterRsp != null) {
            ((j05.b) mm4.b.b(j05.b.class)).p2(j3, yoloRoomOuterClass$YoloRoomEnterRsp.rotate_messsage_list.get());
            com.tencent.timi.game.room.impl.d.g().s(1, yoloRoomOuterClass$YoloRoomEnterRsp.room_info, yoloRoomOuterClass$YoloRoomEnterRsp.room_speaking_pos_list.get(), yoloRoomOuterClass$YoloRoomEnterRsp.speaking_pos_list_version.get(), yoloRoomOuterClass$YoloRoomEnterRsp.cur_action_id.get(), yoloRoomOuterClass$YoloRoomEnterRsp.room_conf, yoloRoomOuterClass$YoloRoomEnterRsp.room_user_data);
        }
        if (yoloRoomOuterClass$YoloRoomEnterRsp != null && yoloRoomOuterClass$YoloRoomEnterRsp.room_conf.has() && yoloRoomOuterClass$YoloRoomEnterRsp.room_conf.yolo_room_common_conf.has() && (j16 = com.tencent.timi.game.room.impl.d.g().j(j3)) != null) {
            j16.R1(yoloRoomOuterClass$YoloRoomEnterRsp.room_info.room_id.get(), yoloRoomOuterClass$YoloRoomEnterRsp.room_conf.yolo_room_common_conf.forbidden_speech_conf_list.get());
        }
    }

    private static void f0(IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener, RecommendProxyOuterClass$GetHallDiversionRecommendRoomRsp recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp) {
        if (iResultListener instanceof gh4.c) {
            ((gh4.c) iResultListener).b(new hh4.a(recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.white_flag.get(), recommendProxyOuterClass$GetHallDiversionRecommendRoomRsp.room_list.get()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g0(long j3, int i3, boolean z16) {
        TimiGameBaseActivity c16 = vf4.a.c();
        if (c16 != null) {
            c16.showLoadingView();
        }
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.i.d(j3), YoloRoomOuterClass$YoloRoomRecoverRsp.class, new o(c16, j3, i3, z16));
    }

    public static void h0() {
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "refreshRoomRoute");
        ((fm4.g) mm4.b.b(fm4.g.class)).i3(new k());
    }

    private static void i0(int i3, com.tencent.timi.game.ui.widget.e eVar) {
        YoloRoomOuterClass$YoloRoomInfo j06;
        String str;
        if (i3 == 920003 && (j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5)) != null) {
            ConcurrentHashMap<String, String> L = L(j06);
            boolean D = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j06.room_id.get()).D();
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                I0.m0().b(eVar);
            } else {
                ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
                if (D) {
                    str = "pg_sgrp_smoba_cpdd";
                } else {
                    str = "pg_kl_smoba_cpdd";
                }
                bVar.G2(eVar, str);
            }
            if (D) {
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getPositiveButton(), false, "", "em_yes_closed_team_win_cancel", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getNegativeButton(), false, "", "em_yes_closed_team_win_confirm", L);
            } else {
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getPositiveButton(), false, "", "em_yes_closed_team_win_confirm", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getNegativeButton(), false, "", "em_yes_closed_team_win_cancel", L);
            }
        }
    }

    private static void j0(com.tencent.timi.game.ui.widget.e eVar) {
        String str;
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        if (j06 != null) {
            ConcurrentHashMap<String, String> L = L(j06);
            boolean D = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j06.room_id.get()).D();
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                I0.m0().b(eVar);
            } else {
                ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
                if (D) {
                    str = "pg_sgrp_smoba_cpdd";
                } else {
                    str = "pg_kl_smoba_cpdd";
                }
                bVar.G2(eVar, str);
            }
            if (D) {
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getPositiveButton(), false, "", "em_yes_changeteam_win_confirm", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getNegativeButton(), false, "", "em_yes_changeteam_win_cancel", L);
            } else {
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getPositiveButton(), false, "", "em_yes_changeteam_win_confirm", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(eVar.getNegativeButton(), false, "", "em_yes_changeteam_win_cancel", L);
            }
        }
    }

    public static void k0(long j3) {
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "reportGangupAutoLaunchSmobaActive - " + j3);
        YoloRoomOuterClass$YoloRoomInfo roomInfo = ((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).getRoomInfo();
        if (roomInfo != null && c0(roomInfo.room_type.get()) && roomInfo.room_data_info.sub_create_from.get() != 3) {
            x(new j(roomInfo, j3));
        }
    }

    public static void l0(String str, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar) {
        ConcurrentHashMap<String, String> s16;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        r(str, concurrentHashMap, dVar.f379324a, cVar.f379323b, cVar.f379322a, dVar.f379330g);
        t(concurrentHashMap, dVar.f379329f);
        s(concurrentHashMap);
        if (dVar.f379325b == 3 && (s16 = ((ni4.a) mm4.b.b(ni4.a.class)).s1(dVar.f379324a)) != null && s16.size() > 0) {
            concurrentHashMap.putAll(s16);
        }
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null && I0.m0() != null) {
            concurrentHashMap.put("yes_member_tag_id", I0.m0().o(dVar.f379324a));
            concurrentHashMap.put("yes_ref_scene", I0.m0().L(dVar.f379324a));
        }
        if (dVar.f379325b == 4) {
            concurrentHashMap.put("yes_ref_scene", "4");
        }
        if (c0(dVar.f379328e) && dVar.f379326c != 3) {
            concurrentHashMap.put("yes_game_id", String.valueOf(A(dVar.f379328e)));
            ((ug4.b) mm4.b.b(ug4.b.class)).reportEvent("ev_yes_team_join_fail", concurrentHashMap);
        }
    }

    public static void m0(long j3, boolean z16, int i3, IResultListener<YoloRoomOuterClass$YoloRoomLeaveRsp> iResultListener) {
        com.tencent.timi.game.utils.l.i("YoloRoomUtil", "sendExitRoomNetReq " + j3 + ", type= " + i3 + ", isForceExit= " + z16);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.h.d(j3, z16, i3), YoloRoomOuterClass$YoloRoomLeaveRsp.class, new n(j3, iResultListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n0(YoloRoomManager yoloRoomManager, fm4.j jVar, Activity activity, fm4.i iVar) {
        String str;
        String str2;
        if (c0(jVar.f399883b)) {
            str = "\u8f66\u961f";
        } else {
            str = "\u623f\u95f4";
        }
        e.a q16 = new e.a(activity).q("");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u662f\u5426\u9000\u51fa\u5f53\u524d");
        sb5.append("\u8f66\u961f");
        sb5.append("\u5e76");
        if (jVar.f399882a) {
            str2 = "\u521b\u5efa";
        } else {
            str2 = "\u52a0\u5165";
        }
        sb5.append(str2);
        sb5.append("\u65b0");
        sb5.append(str);
        sb5.append("\uff1f");
        com.tencent.timi.game.ui.widget.e c16 = q16.j(sb5.toString()).k(17).p("\u786e\u8ba4").o(new d(yoloRoomManager, iVar)).n("\u53d6\u6d88").m(new c(iVar)).c();
        j0(c16);
        c16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o0(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).showLoadingView();
        }
    }

    private static Activity p0(Activity activity) {
        if (activity == null) {
            QBaseActivity b16 = vf4.a.b();
            com.tencent.timi.game.utils.l.e("YoloRoomUtil", "fix activity, new is " + b16);
            return b16;
        }
        return activity;
    }

    private static void r(String str, ConcurrentHashMap<String, String> concurrentHashMap, long j3, List<Integer> list, int i3, long j16) {
        String valueOf;
        concurrentHashMap.put("yes_fail_reason", str);
        concurrentHashMap.put("yes_team_id", String.valueOf(j3));
        concurrentHashMap.put("yes_team_rank", z(list));
        GameDataServerOuterClass$SmobaGameMode t06 = ((pm4.a) mm4.b.b(pm4.a.class)).t0(i3);
        if (t06 != null) {
            valueOf = t06.mode_name.get();
        } else {
            valueOf = String.valueOf(i3);
        }
        concurrentHashMap.put("yes_game_mode", valueOf);
        concurrentHashMap.put("yes_ref_room_id", String.valueOf(j16));
        concurrentHashMap.put("yes_ref_room_type", String.valueOf(5));
    }

    private static void s(ConcurrentHashMap<String, String> concurrentHashMap) {
        if (um4.h.a()) {
            concurrentHashMap.put("yes_gift_price", String.valueOf(um4.h.f439235c));
            concurrentHashMap.put("yes_gift_id", String.valueOf(um4.h.f439233a));
            concurrentHashMap.put("yes_gift_nums", String.valueOf(um4.h.f439234b));
            concurrentHashMap.put("yes_team_type", "1");
            um4.h.b();
        }
    }

    public static void t(ConcurrentHashMap<String, String> concurrentHashMap, fm4.c cVar) {
        if (cVar != null) {
            concurrentHashMap.put("yes_ref_qq_group_num", String.valueOf(cVar.f399871a));
            concurrentHashMap.put("yes_ref_channel_num", String.valueOf(cVar.f399872b));
            concurrentHashMap.put("yes_ref_channel_name", String.valueOf(cVar.f399873c));
        }
    }

    public static void u(long j3, IResultListener<PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp> iResultListener) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(jm4.a.d(((ll4.a) mm4.b.b(ll4.a.class)).h(), 101, j3), PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp.class, new l(iResultListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener, int i3, String str) {
        if (iResultListener != null) {
            iResultListener.onError(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener, @Nullable YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        if (iResultListener != null) {
            iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomInfo);
        }
    }

    private static void x(com.tencent.timi.game.utils.r<IUserInfo> rVar) {
        ((bo4.d) mm4.b.b(bo4.d.class)).l0(((ll4.a) mm4.b.b(ll4.a.class)).E(), new i(rVar));
    }

    public static int y(int i3) {
        return ((ag4.h) mm4.b.b(ag4.h.class)).J(i3);
    }

    public static String z(List<Integer> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 > 0) {
                    sb5.append(",");
                }
                sb5.append(list.get(i3));
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
