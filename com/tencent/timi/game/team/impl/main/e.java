package com.tencent.timi.game.team.impl.main;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.main.TeamConfigDialog;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.ui.TGDialogHelperFragment;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.TeamCreatePageParam;
import fm4.h;
import fm4.i;
import fm4.j;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;
import trpc.yes.common.UserProxyCmdOuterClass$TgpaNewVersionInfo;
import trpc.yes.common.YesGameInfoOuterClass$GetTeamConfigRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomModifyInfoCmd;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379571b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f379572c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f379573d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ fm4.c f379574e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f379575f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Activity f379576g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f379577h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379578i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f379579j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ TeamCreatePageParam f379580k;

        a(int i3, int i16, int i17, long j3, fm4.c cVar, h hVar, Activity activity, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, TeamCreatePageParam teamCreatePageParam) {
            this.f379570a = i3;
            this.f379571b = i16;
            this.f379572c = i17;
            this.f379573d = j3;
            this.f379574e = cVar;
            this.f379575f = hVar;
            this.f379576g = activity;
            this.f379577h = j16;
            this.f379578i = commonOuterClass$QQUserId;
            this.f379579j = str;
            this.f379580k = teamCreatePageParam;
        }

        @Override // fm4.i
        public void a(String str) {
            TeamCreatePageParam teamCreatePageParam = this.f379580k;
            if (teamCreatePageParam != null && teamCreatePageParam.getBaseOnTempActivity()) {
                TGDialogHelperFragment.INSTANCE.b();
            }
            l.e("TeamConfigPageHelper", "enterRoomInterceptCheck checkFail - " + str);
        }

        @Override // fm4.i
        public void b(boolean z16) {
            e.i(this.f379570a, this.f379571b, this.f379572c, this.f379573d, this.f379574e, this.f379575f, this.f379576g, this.f379577h, this.f379578i, this.f379579j, this.f379580k);
            e.l(this.f379570a);
        }

        @Override // fm4.i
        public void c(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            ((sm4.a) mm4.b.b(sm4.a.class)).q0(this.f379576g, yoloRoomOuterClass$YoloRoomInfo, 0);
            l.i("TeamConfigPageHelper", "enterRoomInterceptCheck SameRoomClick");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379581a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f379582b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f379583c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ fm4.c f379584d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f379585e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f379586f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379587g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f379588h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TeamCreatePageParam f379589i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Activity f379590j;

        b(int i3, int i16, long j3, fm4.c cVar, h hVar, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, TeamCreatePageParam teamCreatePageParam, Activity activity) {
            this.f379581a = i3;
            this.f379582b = i16;
            this.f379583c = j3;
            this.f379584d = cVar;
            this.f379585e = hVar;
            this.f379586f = j16;
            this.f379587g = commonOuterClass$QQUserId;
            this.f379588h = str;
            this.f379589i = teamCreatePageParam;
            this.f379590j = activity;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp) {
            com.tencent.timi.game.team.impl.main.d a16 = com.tencent.timi.game.team.impl.main.d.a(this.f379581a, this.f379582b, this.f379583c, this.f379584d, this.f379585e, this.f379586f, this.f379587g, this.f379588h, this.f379589i, yesGameInfoOuterClass$GetTeamConfigRsp);
            Activity activity = this.f379590j;
            TeamConfigDialog.F0(activity, a16, e.f(activity, 0L, a16)).show();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            l.e("TeamConfigPageHelper", "requestTeamConfig failed: errorCode == " + i3 + ", errorMessage == " + str);
            com.tencent.timi.game.ui.widget.f.c("\u83b7\u53d6\u6e38\u620f\u914d\u7f6e\u5931\u8d25");
            TeamCreatePageParam teamCreatePageParam = this.f379589i;
            if (teamCreatePageParam != null && teamCreatePageParam.getBaseOnTempActivity()) {
                TGDialogHelperFragment.INSTANCE.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f379591a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f379592b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f379593c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f379594d;

        c(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, long j3, int i3, Activity activity) {
            this.f379591a = yoloRoomOuterClass$YoloRoomInfo;
            this.f379592b = j3;
            this.f379593c = i3;
            this.f379594d = activity;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp) {
            com.tencent.timi.game.team.impl.main.d b16 = com.tencent.timi.game.team.impl.main.d.b(this.f379593c, this.f379592b, ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.f379592b).getRoomInfo().introduce.get(), yesGameInfoOuterClass$GetTeamConfigRsp, this.f379591a.game_data_info.common_game_data_info.list_param_list.get());
            sm4.a aVar = (sm4.a) mm4.b.b(sm4.a.class);
            Activity activity = this.f379594d;
            aVar.k1(activity, b16, e.f(activity, this.f379592b, b16));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            l.e("TeamConfigPageHelper", "ensureTeamCreateConfigFromCacheOrNet error " + str + " - " + i3);
            com.tencent.timi.game.ui.widget.f.c("\u6570\u636e\u5f02\u5e38\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5\u3002");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements TeamConfigDialog.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.team.impl.main.d f379595a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f379596b;

        d(com.tencent.timi.game.team.impl.main.d dVar, long j3) {
            this.f379595a = dVar;
            this.f379596b = j3;
        }

        @Override // com.tencent.timi.game.team.impl.main.TeamConfigDialog.c
        public void a(TeamConfigDialog teamConfigDialog, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
            com.tencent.timi.game.team.impl.main.d dVar = this.f379595a;
            e.g(teamConfigDialog, yoloRoomOuterClass$YoloRoomParams, yoloRoomOuterClass$YoloGameRoomParams, dVar.f379565j, dVar.f379566k, dVar.f379567l);
        }

        @Override // com.tencent.timi.game.team.impl.main.TeamConfigDialog.c
        public void b(TeamConfigDialog teamConfigDialog, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
            e.h(teamConfigDialog, yoloRoomOuterClass$YoloRoomParams, yoloRoomOuterClass$YoloGameRoomParams, this.f379596b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.team.impl.main.e$e, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9974e implements IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TeamConfigDialog f379597a;

        C9974e(TeamConfigDialog teamConfigDialog) {
            this.f379597a = teamConfigDialog;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomCmdRsp yoloRoomOuterClass$YoloRoomCmdRsp) {
            l.i("TeamConfigPageHelper", "modify room setting success");
            this.f379597a.hideLoadingView();
            this.f379597a.dismiss();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            l.e("TeamConfigPageHelper", "modify room setting failed: errorCode == " + i3 + ",errorMessage == " + str);
            this.f379597a.hideLoadingView();
            this.f379597a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f379598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379599b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f379600c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TeamConfigDialog f379601d;

        f(long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, TeamConfigDialog teamConfigDialog) {
            this.f379598a = j3;
            this.f379599b = commonOuterClass$QQUserId;
            this.f379600c = str;
            this.f379601d = teamConfigDialog;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId;
            l.i("TeamConfigPageHelper", "testRoom CREATE SUCCESS - " + yoloRoomOuterClass$YoloRoomInfo);
            long j3 = this.f379598a;
            if (j3 != 0 && (commonOuterClass$QQUserId = this.f379599b) != null) {
                com.tencent.timi.game.team.impl.main.g.b(yoloRoomOuterClass$YoloRoomInfo, j3, commonOuterClass$QQUserId, this.f379600c);
            } else if (((sm4.a) mm4.b.b(sm4.a.class)).y3()) {
                com.tencent.timi.game.ui.widget.f.a("\u5df2\u5f00\u542f\u6e38\u620f\u7ec4\u961f\u529f\u80fd");
            } else {
                com.tencent.timi.game.ui.widget.f.c("\u521b\u5efa\u8f66\u961f\u6210\u529f");
            }
            this.f379601d.dismiss();
            this.f379601d.hideLoadingView();
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            l.e("TeamConfigPageHelper", "createSmobaRoom : errorCode == " + i3 + ",errorMessage == " + str);
            this.f379601d.hideLoadingView();
            this.f379601d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements pl4.d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f379602a;

        g(int i3) {
            this.f379602a = i3;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable UserProxyCmdOuterClass$GetTgpaVersionInfoRsp userProxyCmdOuterClass$GetTgpaVersionInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
            l.e("TeamConfigPageHelper", "openTeamCreatePage - " + this.f379602a + " error, " + i16 + " " + str2);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(UserProxyCmdOuterClass$GetTgpaVersionInfoRsp userProxyCmdOuterClass$GetTgpaVersionInfoRsp, FromServiceMsg fromServiceMsg) {
            UserProxyCmdOuterClass$TgpaNewVersionInfo userProxyCmdOuterClass$TgpaNewVersionInfo;
            if (userProxyCmdOuterClass$GetTgpaVersionInfoRsp != null && (userProxyCmdOuterClass$TgpaNewVersionInfo = userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info) != null && userProxyCmdOuterClass$TgpaNewVersionInfo.has()) {
                l.i("TeamConfigPageHelper", "openTeamCreatePage - " + this.f379602a + " - getTgpaGameVersion, cur_apk: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.cur_version_id.get() + ", new_apk: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.new_version_id.get() + ", cur_res: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.cur_source_id.get() + ", new_res: " + userProxyCmdOuterClass$GetTgpaVersionInfoRsp.tgpa_new_version_info.new_source_id.get());
                return;
            }
            l.e("TeamConfigPageHelper", "openTeamCreatePage - " + this.f379602a + ", tgpa success but rsp  NULL");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TeamConfigDialog.c f(Activity activity, long j3, com.tencent.timi.game.team.impl.main.d dVar) {
        return new d(dVar, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(TeamConfigDialog teamConfigDialog, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str) {
        teamConfigDialog.showLoadingView();
        ((sm4.a) mm4.b.b(sm4.a.class)).m3(true, yoloRoomOuterClass$YoloRoomParams, yoloRoomOuterClass$YoloGameRoomParams, new f(j3, commonOuterClass$QQUserId, str, teamConfigDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(TeamConfigDialog teamConfigDialog, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, long j3) {
        teamConfigDialog.showLoadingView();
        YoloRoomOuterClass$YoloRoomModifyInfoCmd yoloRoomOuterClass$YoloRoomModifyInfoCmd = new YoloRoomOuterClass$YoloRoomModifyInfoCmd();
        if (yoloRoomOuterClass$YoloRoomParams != null) {
            yoloRoomOuterClass$YoloRoomModifyInfoCmd.room_params.set(yoloRoomOuterClass$YoloRoomParams);
        }
        if (yoloRoomOuterClass$YoloGameRoomParams != null) {
            yoloRoomOuterClass$YoloRoomModifyInfoCmd.game_room_params.set(yoloRoomOuterClass$YoloGameRoomParams);
        }
        ((fm4.g) mm4.b.b(fm4.g.class)).A(j3).a(yoloRoomOuterClass$YoloRoomModifyInfoCmd, new C9974e(teamConfigDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(int i3, int i16, int i17, long j3, fm4.c cVar, h hVar, Activity activity, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, TeamCreatePageParam teamCreatePageParam) {
        zm4.a.a(i3, new b(i16, i17, j3, cVar, hVar, j16, commonOuterClass$QQUserId, str, teamCreatePageParam, activity));
    }

    public static void j(Activity activity, int i3, int i16, int i17, long j3, fm4.c cVar, h hVar, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, TeamCreatePageParam teamCreatePageParam) {
        int i18 = i3;
        l.i("TeamConfigPageHelper", "openTeamCreatePage " + activity + ", yesGameId = " + i18 + ", yoloRoomCreateFrom = " + i16 + ", baseRoomId = " + j3 + ", toShareExpandHallTimGroupId = " + j16 + ", toShareUserId = " + commonOuterClass$QQUserId);
        if (i18 <= 0) {
            i18 = 101;
        }
        int i19 = i18;
        ((fm4.g) mm4.b.b(fm4.g.class)).a3(activity, j.b(YoloRoomUtil.y(i19)), new a(i19, i16, i17, j3, cVar, hVar, activity, j16, commonOuterClass$QQUserId, str, teamCreatePageParam));
    }

    public static void k(Activity activity, long j3) {
        int A = YoloRoomUtil.A(((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).getRoomType());
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 != null && A != 0) {
            ((sm4.a) mm4.b.b(sm4.a.class)).p0(A, new c(z16, j3, A, activity));
        } else {
            l.e("TeamConfigPageHelper", "current roomInfo is null or yesGameId is 0");
            com.tencent.timi.game.ui.widget.f.c("\u6570\u636e\u5f02\u5e38\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5\u3002");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(int i3) {
        ((ag4.i) mm4.b.b(ag4.i.class)).e3(TGPAUtil.b(), i3, true, new g(i3));
    }
}
