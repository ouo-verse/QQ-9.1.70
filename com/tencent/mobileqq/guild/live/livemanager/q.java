package com.tencent.mobileqq.guild.live.livemanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.avbiz.IModule;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.heartbeatreport.impl.AvChannelReportHelper;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.media.core.logic.entertips.UserEnterTipsTrigger;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.widget.MediaChannelDialogFragment;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IEnterChannelPermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserGiftRankInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ag;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.ff;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAudioLiveChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProExitAVChannelRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUser;
import com.tencent.mobileqq.qqguildsdk.data.genc.ai;
import com.tencent.mobileqq.qqguildsdk.data.genc.cf;
import com.tencent.mobileqq.qqguildsdk.data.genc.cn;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import rs0.LiveUserEnterTipsModel;
import vh2.af;
import wh2.es;
import wh2.x;
import wh2.y;

/* compiled from: P */
/* loaded from: classes14.dex */
public class q implements IModule.FocusChangeListener {
    private String C;
    private String D;
    private boolean E;
    private AppRuntime F;
    private long G;
    private String H;
    private String M;
    private com.tencent.mobileqq.guild.media.core.logic.entertips.b<LiveUserEnterTipsModel> N;

    /* renamed from: d, reason: collision with root package name */
    private final GLiveChannelCore f226908d;

    /* renamed from: f, reason: collision with root package name */
    boolean f226910f;

    /* renamed from: i, reason: collision with root package name */
    private String f226912i;

    /* renamed from: m, reason: collision with root package name */
    private String f226913m;

    /* renamed from: e, reason: collision with root package name */
    private final List<com.tencent.mobileqq.guild.live.livemanager.h> f226909e = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private boolean f226911h = false;
    private final AvChannelReportHelper I = new AvChannelReportHelper("5");
    private final BroadcastReceiver J = new a();
    private boolean K = true;
    private final INetworkStateApi.a L = new INetworkStateApi.a() { // from class: com.tencent.mobileqq.guild.live.livemanager.i
        @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
        public final void onNetworkConnect(boolean z16) {
            q.this.s0(z16);
        }
    };
    private final GPServiceObserver P = new b();
    private final oo1.a Q = new c();
    private final Observer<Long> R = new d();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLiveEventHelper", 2, "mQqAccountReceiver onReceive=" + action);
            }
            q.this.W(null, "receive qq account action:" + action);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GPServiceObserver {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes14.dex */
        public class a implements ff {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f226916a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f226917b;

            a(String str, String str2) {
                this.f226916a = str;
                this.f226917b = str2;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.ff
            public String a() {
                return this.f226916a;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.ff
            public String getCoverUrl() {
                return this.f226917b;
            }
        }

        b() {
        }

        public ff b(String str, String str2) {
            return new a(str, str2);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAddGuildNotInfo(String str) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "onAddGuildNotInfo guildId=" + str);
            q.this.P0();
            q.this.X();
            q.this.C0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "onAddGuildWithInfo info=" + iGProGuildInfo);
            q.this.P0();
            q.this.X();
            q.this.C0();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(String str, String str2, boolean z16) {
            if (q.this.Q(str) && q.this.T(str2)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onChannelAdminChange guildId=" + str);
                q.this.D0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            if (TextUtils.equals(str, q.this.C)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onBeKickFromGuild.");
                q.this.W(null, "onBeKickFromGuild");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelAdminChange(String str, String str2, int i3, List<String> list) {
            if (q.this.P(str, str2)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onChannelAdminChange guildId=" + str + ",channelId=" + str2);
                q.this.D0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            if (TextUtils.equals(str, q.this.D)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onChannelInfoUpdated.");
                q.this.M0();
                q.this.C0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            if (!q.this.Q(str)) {
                return;
            }
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "onChannelListUpdated guildId=" + str);
            if (((IGPSService) q.this.F.getRuntimeService(IGPSService.class, "")).getChannelInfo(q.this.D) == null) {
                q.this.W(HardCodeUtil.qqStr(R.string.f141890hw), "onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelUserPermissionChanged(String str, List<String> list) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "[onChannelUserPermissionChanged] guild = " + str + ", channelIdList = " + list);
            if (TextUtils.equals(str, q.this.C) && list != null && list.contains(q.this.D)) {
                q.this.z0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(String str, String str2, int i3, int i16) {
            if (!q.this.P(str, str2)) {
                return;
            }
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "onChannelVisibleChanged oldVisibleType=" + i3 + " newVisibleType=" + i16);
            if (((IGPSService) q.this.F.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2) == null) {
                q.this.W(HardCodeUtil.qqStr(R.string.f141890hw), "onChannelVisibleChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            if (TextUtils.equals(str, q.this.C)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onDestoryGuild.");
                q.this.W(HardCodeUtil.qqStr(R.string.f147550x7), "onDestoryGuild");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            if (TextUtils.equals(str, q.this.C)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onGuildInfoUpdated.");
                q.this.P0();
                q.this.C0();
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onLiveRoomInfoChange(String str, String str2, String str3, String str4) {
            if (!q.this.P(str, str2)) {
                return;
            }
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "onLiveRoomInfoChange title=" + str3 + ", coverUrl=" + str4);
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (gLiveChannelCore.r().d()) {
                q.this.f226908d.t().m0(b(str3, str4));
            } else if (gLiveChannelCore.r().e()) {
                q.this.f226908d.t().X(b(str3, str4));
            }
            q.this.a0();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onLiveRoomStatusChange(String str, String str2, String str3, String str4, String str5, int i3, int i16, ILiveProgramInfo iLiveProgramInfo, long j3, ILiveRoomInfo iLiveRoomInfo) {
            q.this.j0(str, str2, str3, str5, i3, i16, j3, iLiveRoomInfo);
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onLiveRoomUserChange(String str, String str2, List<Object> list, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onLiveRoomUserChange guildId=" + str + " channelId=" + str2 + " action=" + i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(String str, List<String> list) {
            String str2;
            if (TextUtils.equals(str, q.this.C)) {
                for (String str3 : list) {
                    if (TextUtils.equals(str3, q.this.D)) {
                        QLog.i("QGL.QQGuildLiveEventHelper", 1, "onPushChannelDestroy.");
                        if (!si1.a.f433837a.a(q.this.C, str3, 1)) {
                            str2 = HardCodeUtil.qqStr(R.string.f147550x7);
                        } else {
                            str2 = "";
                        }
                        q.this.W(str2, "onPushChannelDestroy");
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPushUserGiftRankChangeNotify(String str, String str2, IGProUserGiftRankInfo iGProUserGiftRankInfo) {
            if (q.this.O(str2) && iGProUserGiftRankInfo != null && iGProUserGiftRankInfo.getUserInfo() != null && iGProUserGiftRankInfo.getUserInfo().getRoleManagementTag() != null) {
                IGProUser userInfo = iGProUserGiftRankInfo.getUserInfo();
                String memberName = userInfo.getMemberName();
                if (TextUtils.isEmpty(memberName)) {
                    memberName = userInfo.getNickName();
                }
                NotifyGiftRankChanged notifyGiftRankChanged = new NotifyGiftRankChanged(String.valueOf(userInfo.getTinyId()), memberName, userInfo.getRoleManagementTag().getColor(), iGProUserGiftRankInfo.getRankInfo(), iGProUserGiftRankInfo.getTopNum());
                QLog.d("QGL.QQGuildLiveEventHelper", 1, "onPushUserGiftRankChangeNotify " + notifyGiftRankChanged);
                GLiveChannelCore.f226698a.t().Z(notifyGiftRankChanged);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            if (TextUtils.equals(str, q.this.C)) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onRemoveGuild.");
                if (q.this.f226908d.t().D().getValue() == Boolean.TRUE) {
                    q.this.W(HardCodeUtil.qqStr(R.string.f147550x7), "onRemoveGuild");
                } else {
                    q.this.W(null, "onRemoveGuild");
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserEnterListNotifyForAll(String str, String str2, ArrayList<IGProUserInfo> arrayList, IGProChannelUserNum iGProChannelUserNum) {
            if (q.this.P(str, str2)) {
                q.this.k0(arrayList);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c extends oo1.a {
        c() {
        }

        @Override // oo1.a
        public void b(boolean z16, IGProChannelInfo iGProChannelInfo) {
            String str;
            if (z16 && q.this.P(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin())) {
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "onChannelDelete.");
                if (!si1.a.f433837a.a(q.this.C, iGProChannelInfo.getChannelUin(), 1)) {
                    str = HardCodeUtil.qqStr(R.string.f147550x7);
                } else {
                    str = "";
                }
                q.this.W(str, "onChannelDelete");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements Observer<Long> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            if (com.tencent.mobileqq.guild.setting.mute.c.l(q.this.C) && q.this.f226908d.t().D().getValue() == Boolean.TRUE) {
                QLog.d("QGL.QQGuildLiveEventHelper", 1, "[mGuildMutingObserver] anchorExitRoom with muting");
                QQToast.makeText(q.this.d0(), R.string.f155861in, 0).show();
                q.this.L("anchorExitRoom with muting");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements af {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226921a;

        e(String str) {
            this.f226921a = str;
        }

        @Override // vh2.af
        public void a(int i3, String str, List<ILiveRoomInfo> list, List<String> list2, int i16) {
            String str2;
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "checkLiveStateWhenNetRestore. result:" + i3 + " errMsg:" + str);
            if (q.this.U(this.f226921a, "checkLiveStateWhenNetRestore") && i3 == 0) {
                q qVar = q.this;
                boolean z16 = false;
                if (qVar.N(list, qVar.D)) {
                    str2 = list.get(0).getRoomId();
                    z16 = true;
                } else {
                    str2 = null;
                }
                boolean booleanValue = ((Boolean) e12.d.b(q.this.f226908d.t().n(), Boolean.FALSE)).booleanValue();
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "checkLiveStateWhenNetRestore. haveLiveRoomInfo:" + z16 + " isEnterRoom:" + booleanValue);
                if (booleanValue) {
                    if (!z16) {
                        q.this.f226908d.c("net restore check, but room info is null");
                    }
                } else if (z16 && !TextUtils.isEmpty(str2)) {
                    q.this.M(str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements af {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226923a;

        f(String str) {
            this.f226923a = str;
        }

        @Override // vh2.af
        public void a(int i3, String str, List<ILiveRoomInfo> list, List<String> list2, int i16) {
            if (!q.this.U(this.f226923a, "onFetchLiveRoomInfo")) {
                return;
            }
            if (i3 != 0) {
                QLog.e("QGL.QQGuildLiveEventHelper", 1, "fetchEndLivePosterByLastRoomId, errMsg=" + str);
                return;
            }
            if (list != null && !list.isEmpty()) {
                q.this.i0(list.get(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g implements af {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226925a;

        g(String str) {
            this.f226925a = str;
        }

        @Override // vh2.af
        public void a(int i3, String str, List<ILiveRoomInfo> list, List<String> list2, int i16) {
            if (!q.this.U(this.f226925a, "fetchLiveRoomInfo")) {
                return;
            }
            if (i3 != 0) {
                QLog.e("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo, errMsg=" + str);
                return;
            }
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo finished: roomInfoList=" + list);
            if (list == null || list.isEmpty()) {
                q.this.S0(null);
            } else {
                q.this.S0(list.get(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f226927d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f226928e;

        h(LiveData liveData, long j3) {
            this.f226927d = liveData;
            this.f226928e = j3;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoEnterLiveRoom onChanged isInitSuc=" + bool + " mAutoInitSDKStart=" + q.this.f226910f);
            if (q.this.f226910f) {
                this.f226927d.removeObserver(this);
            }
            if (bool == Boolean.TRUE) {
                q.this.f226908d.o().e(this.f226928e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class i implements vh2.s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f226930a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226931b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IGPSService f226932c;

        i(String str, String str2, IGPSService iGPSService) {
            this.f226930a = str;
            this.f226931b = str2;
            this.f226932c = iGPSService;
        }

        @Override // vh2.s
        public void a(int i3, String str, IGProGuildInfo iGProGuildInfo, List<cy> list) {
            if (!q.this.U(this.f226930a, "handleReportGuestEnteringGuildResult,fetchGuestGuild")) {
                return;
            }
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchGuestGuild, guildId:" + this.f226931b + " result:" + i3 + " errMsg:" + str);
            if (i3 != 0) {
                q.this.W(HardCodeUtil.qqStr(R.string.f147670xi), "onFetchGuestGuild, result not success");
                return;
            }
            if (this.f226932c.getGuildInfo(this.f226931b) == null || this.f226932c.getChannelInfo(q.this.D) == null) {
                q.this.W(HardCodeUtil.qqStr(R.string.f147670xi), "onFetchGuestGuild, data is null");
                return;
            }
            q.this.Q0(this.f226932c.getGuildInfo(this.f226931b));
            q qVar = q.this;
            qVar.N0(this.f226932c.getChannelInfo(qVar.D));
            if (q.this.f226908d.s().getLiveChannelRoomInfo() == null) {
                q.this.a0();
            }
            q.this.f226908d.t().R(true);
        }
    }

    public q(GLiveChannelCore gLiveChannelCore) {
        this.f226908d = gLiveChannelCore;
    }

    private void A0() {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "[onSelfAllowLiveChange] ");
        C0();
        P0();
        M0();
        R0();
    }

    private Map<String, String> B0(IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
        if (iGProEnterAudioLiveChannelRsp == null) {
            return new HashMap();
        }
        IEnterChannelPermission liveChannelPermission = iGProEnterAudioLiveChannelRsp.getLiveChannelPermission();
        HashMap hashMap = new HashMap();
        hashMap.put("allowed_enter", String.valueOf(liveChannelPermission.getAllowEnter()));
        hashMap.put("disallow_enter_reason", String.valueOf(liveChannelPermission.getDisallowReason()));
        hashMap.put("allowed_live", String.valueOf(liveChannelPermission.getAllowLive()));
        hashMap.put("disallow_live_reason", String.valueOf(liveChannelPermission.getDisallowLiveReason()));
        hashMap.put("live_url", String.valueOf(liveChannelPermission.getLiveUrl()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        IGProGuildInfo guildInfo = this.f226908d.s().getGuildInfo();
        IGProChannelInfo channelInfo = this.f226908d.s().getChannelInfo();
        if (guildInfo != null && channelInfo != null) {
            boolean t06 = ch.t0(guildInfo);
            boolean isChannelOrCategoryAdmin = channelInfo.isChannelOrCategoryAdmin();
            boolean z16 = true;
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "querySelfIsAdmin isGuildManager=" + t06 + " isChannelAdmin=" + isChannelOrCategoryAdmin);
            tq1.b t16 = this.f226908d.t();
            if (!t06 && !isChannelOrCategoryAdmin) {
                z16 = false;
            }
            t16.q0(z16);
            R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        IGProGuildInfo guildInfo = this.f226908d.s().getGuildInfo();
        if (guildInfo != null && guildInfo.isMember()) {
            IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
            int permissionChangeFilter = iGPSService.getPermissionChangeFilter(this.C, this.D);
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "[queryUserCanStartLive] filter = " + permissionChangeFilter);
            if (permissionChangeFilter == 0) {
                this.E = K(iGPSService.getChannelUserPermission(this.C, this.D));
                A0();
                return;
            } else {
                Y(this.C, this.D, 103);
                return;
            }
        }
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "queryAnchorList, ignore.");
    }

    private void F0(long j3) {
        if (j3 > 0) {
            this.G = j3;
        }
    }

    private void G0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName());
        intentFilter.addAction(AppConstants.QQ_KICKED_LOGIN_OTHER_DEVICE);
        d0().registerReceiver(this.J, intentFilter);
    }

    private boolean I0() {
        IGProGuildInfo guildInfo = this.f226908d.s().getGuildInfo();
        IGProChannelInfo channelInfo = this.f226908d.s().getChannelInfo();
        if (guildInfo != null && channelInfo != null && guildInfo.isMember()) {
            return false;
        }
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "reportGuestEnteringGuild.");
        IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
        long d16 = az.d(iGPSService.getSelfTinyId(), 0L);
        final long d17 = az.d(this.C, 0L);
        long d18 = az.d(this.D, 0L);
        if (d17 <= 0) {
            QLog.e("QGL.QQGuildLiveEventHelper", 1, "tinyId or guildId is Illegal,  tinyId = " + d16 + ", guildId = " + d17);
            return false;
        }
        cn cnVar = new cn();
        cnVar.o(d16);
        cnVar.l(true);
        cf cfVar = new cf();
        cfVar.d(d17);
        if (d18 > 0) {
            cfVar.a().add(Long.valueOf(d18));
        }
        cnVar.b().add(cfVar);
        final String str = this.f226912i;
        iGPSService.userOnlineReport(cnVar, new es() { // from class: com.tencent.mobileqq.guild.live.livemanager.p
            @Override // wh2.es
            public final void a(int i3, String str2, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
                q.this.t0(str, d17, i3, str2, iGProGuildOnlineReportRsp);
            }
        });
        return true;
    }

    private void J0() {
        long j3;
        long j16;
        try {
            j3 = Long.parseLong(this.C);
            try {
                j16 = Long.parseLong(this.D);
            } catch (NumberFormatException unused) {
                QLog.e("QGL.QQGuildLiveEventHelper", 1, "requestEnterLiveChannel NumberFormatException, please check params!!!");
                j16 = 0;
                if (j3 == 0) {
                } else {
                    return;
                }
            }
        } catch (NumberFormatException unused2) {
            j3 = 0;
        }
        if (j3 == 0 && j16 != 0) {
            GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_ENTER_CHANNEL);
            com.tencent.mobileqq.guild.performance.report.l.c("live_room_enter_permission_start");
            final String str = this.f226912i;
            ai aiVar = new ai();
            aiVar.j(j3);
            aiVar.g(j16);
            aiVar.i(false);
            aiVar.h(5);
            aiVar.k(b0());
            ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).enterAudioLiveChannel(aiVar, new x() { // from class: com.tencent.mobileqq.guild.live.livemanager.o
                @Override // wh2.x
                public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
                    q.this.u0(str, i3, str2, iGProSecurityResult, iGProEnterAudioLiveChannelRsp);
                }
            });
        }
    }

    private void K0(int i3, int i16, String str, ILiveRoomInfo iLiveRoomInfo) {
        if (i3 == 2 && i16 == 0 && T(str) && iLiveRoomInfo != null && !TextUtils.isEmpty(iLiveRoomInfo.getCloseTips())) {
            aa.e(iLiveRoomInfo.getCloseTips());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str) {
        ((com.tencent.mobileqq.guild.live.viewmodel.h) this.f226908d.q(com.tencent.mobileqq.guild.live.viewmodel.h.class)).c2(str);
    }

    private void L0() {
        d0().unregisterReceiver(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str) {
        try {
            long parseLong = Long.parseLong(str);
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoEnterLiveRoom start, roomId=" + parseLong);
            if (this.f226908d.p().h()) {
                this.f226908d.o().e(parseLong);
            } else {
                this.f226910f = false;
                LiveData<Boolean> k3 = this.f226908d.p().k();
                k3.observeForever(new h(k3, parseLong));
                this.f226910f = true;
                QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoEnterLiveRoom start initLiveSDK.");
                this.f226908d.p().g(c0());
            }
        } catch (NumberFormatException unused) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "autoEnterLiveRoom parse roomId exception.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        N0(((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.D));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(List<ILiveRoomInfo> list, String str) {
        if (list != null && !list.isEmpty()) {
            for (ILiveRoomInfo iLiveRoomInfo : list) {
                if (TextUtils.equals(iLiveRoomInfo.getQueryId(), str) && !TextUtils.isEmpty(iLiveRoomInfo.getRoomId())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(IGProChannelInfo iGProChannelInfo) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "updateChannelInfo, update cache. channelInfo=" + iGProChannelInfo);
        if (iGProChannelInfo == null) {
            return;
        }
        this.f226908d.t().U(iGProChannelInfo);
        F0(iGProChannelInfo.getLiveRoomId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O(String str) {
        return TextUtils.equals(str, this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P(String str, String str2) {
        if (TextUtils.equals(str, this.C) && TextUtils.equals(str2, this.D)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        Q0(((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).getGuildInfo(this.C));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q(String str) {
        return TextUtils.equals(str, this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(IGProGuildInfo iGProGuildInfo) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "updateGuildInfo, update cache. guildInfo=" + iGProGuildInfo);
        if (iGProGuildInfo == null) {
            return;
        }
        this.f226908d.t().a0(iGProGuildInfo);
    }

    private boolean R(String str, String str2, String str3) {
        if (T(str) && Q(str2) && O(str3)) {
            return true;
        }
        return false;
    }

    private void R0() {
        boolean z16;
        boolean booleanValue = ((Boolean) e12.d.b(this.f226908d.t().E(), Boolean.FALSE)).booleanValue();
        if (!booleanValue && !this.E) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f226908d.s().setAllowStartLive(z16);
        this.f226908d.t().p0(z16);
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "haveStartLivePermission:" + z16 + " isAdmin:" + booleanValue + " mSelfAllowLive:" + this.E);
    }

    private void S() {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "checkLiveStateWhenNetRestore.");
        if (!this.f226911h) {
            return;
        }
        String str = this.f226912i;
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.D);
        ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).fetchLiveRoomInfo(new ag.a().g(this.C).f(arrayList).e(), new e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(@Nullable ILiveRoomInfo iLiveRoomInfo) {
        if (iLiveRoomInfo == null) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "updateLiveChannelRoomInfo null.");
        } else {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "updateLiveChannelRoomInfo, roomId:" + iLiveRoomInfo.getRoomId() + ",programId:" + iLiveRoomInfo.getProgramId());
        }
        this.f226908d.s().updateFromLiveRoomInfo(iLiveRoomInfo);
        this.f226908d.t().e0(LiveChannelRoomInfo.parseFrom(iLiveRoomInfo));
        this.f226908d.t().Q(true);
        U0();
        if (iLiveRoomInfo == null) {
            this.f226908d.d("updateLiveChannelRoomInfo, roomInfo is null.", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T(String str) {
        return TextUtils.equals(str, this.f226913m);
    }

    private void T0(long j3) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "updateMsgSeq:" + j3);
        this.f226908d.t().t0(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U(String str, String str2) {
        if (TextUtils.equals(str, this.f226912i)) {
            return true;
        }
        QLog.e("QGL.QQGuildLiveEventHelper", 1, str2 + ",uuid is invalid, ignore result.");
        return false;
    }

    private void U0() {
        if (this.f226908d.s().getAnchorIsSelf() && this.f226908d.r().c()) {
            this.f226908d.t().r0(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(@Nullable String str, String str2) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "exitLiveRoomPageAndDestroySDK. dialogTip=" + str);
        ArrayList arrayList = new ArrayList(this.f226909e);
        this.f226908d.b(str2);
        v0(arrayList, str, str2);
        if (!TextUtils.isEmpty(str)) {
            MediaChannelDialogFragment.wh(str, QQGuildUIUtil.r(R.string.f146610un));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (!this.f226911h) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchChannelInfo.");
            return;
        }
        IGProChannelInfo channelInfo = ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.D);
        if (channelInfo != null) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchChannelInfo suc: " + channelInfo);
            this.f226908d.t().U(channelInfo);
        }
    }

    private void Y(String str, String str2, int i3) {
        final boolean booleanValue = ((Boolean) e12.d.b(this.f226908d.t().D(), Boolean.FALSE)).booleanValue();
        ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).fetchChannelUserPermission(str, str2, i3, new xh2.n() { // from class: com.tencent.mobileqq.guild.live.livemanager.n
            @Override // xh2.n
            public final void onResult(int i16, String str3, int i17) {
                q.this.o0(booleanValue, i16, str3, i17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (!this.f226911h) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo.");
            return;
        }
        String str = this.f226912i;
        IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.D);
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "fetchLiveRoomInfo start, oldUuid=" + str);
        iGPSService.fetchLiveRoomInfo(new ag.a().g(this.C).f(arrayList).e(), new g(str));
    }

    private String b0() {
        String str;
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) this.f226908d.s().getBundle().getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null) {
            str = guildAppReportSourceInfo.getReportInfoMap().get("sgrp_stream_pgin_source_name");
        } else {
            str = "";
        }
        if (StringUtil.isEmpty(str)) {
            str = com.tencent.mobileqq.guild.report.b.c();
        }
        this.f226908d.s().setEnterSourceType(str);
        QLog.d("QGL.QQGuildLiveEventHelper", 1, "checkEnterChannelPermission joinSourceType " + str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context d0() {
        return BaseApplication.getContext().getApplicationContext();
    }

    private static int e0(GLiveChannelStartParams gLiveChannelStartParams) {
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) gLiveChannelStartParams.getBundle().getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null) {
            return guildAppReportSourceInfo.extraInfo.channelOpenSourceForOnlineReport;
        }
        return 0;
    }

    private static String f0(GLiveChannelStartParams gLiveChannelStartParams) {
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) gLiveChannelStartParams.getBundle().getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null) {
            return guildAppReportSourceInfo.getPageInSourceName();
        }
        return "";
    }

    private static boolean g0(GLiveChannelStartParams gLiveChannelStartParams) {
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) gLiveChannelStartParams.getBundle().getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null) {
            return guildAppReportSourceInfo.getStartFromGuildTab();
        }
        return false;
    }

    private void h0(int i3, String str, IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "handleEnterChannelPermissionResult, result:" + i3 + " errMsg:" + str);
        if (iGProEnterAudioLiveChannelRsp == null) {
            aa.d(R.string.f147660xh);
            W(null, "IGProEnterAudioLiveChannelRsp is null, result:" + i3 + " errMsg:" + str);
            return;
        }
        IEnterChannelPermission liveChannelPermission = iGProEnterAudioLiveChannelRsp.getLiveChannelPermission();
        if (i3 == 0 && liveChannelPermission.getAllowEnter()) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "enterChannelPermission.getAllowLive == " + liveChannelPermission.getAllowLive());
            GLiveChannelStartParams s16 = this.f226908d.s();
            this.I.i(s16.getGuildId(), s16.getChannelId(), Integer.valueOf(e0(s16)), f0(s16), g0(s16), null);
            s16.setLiveType(liveChannelPermission.getLiveType());
            s16.setLiveUrl(liveChannelPermission.getLiveUrl());
            IGProChannelInfo channelInfo = s16.getChannelInfo();
            T0(liveChannelPermission.getMsgSeq());
            if (channelInfo != null && this.f226908d.r().c()) {
                this.f226908d.o().f(liveChannelPermission.getLiveUrl());
                return;
            }
            return;
        }
        if (i3 == 0) {
            aa.e(liveChannelPermission.getDisallowReason());
        } else if (i3 == -93) {
            aa.d(R.string.f148380zf);
        } else if (!TextUtils.isEmpty(str)) {
            aa.e(str);
        } else {
            aa.d(R.string.f147660xh);
        }
        W(null, "not enter permission, result:" + i3 + " errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(@NonNull ILiveRoomInfo iLiveRoomInfo) {
        String str;
        HashMap<String, String> roomIcons = iLiveRoomInfo.getRoomIcons();
        if (roomIcons != null && roomIcons.containsKey("1:1")) {
            str = roomIcons.get("1:1");
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "handleLiveRoomPoster from Map = " + str);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = this.H;
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "handleLiveRoomPoster from mLastAnchorHeadUrl = " + str);
        }
        if (TextUtils.isEmpty(str) && iLiveRoomInfo.getAnchorInfo() != null) {
            str = iLiveRoomInfo.getAnchorInfo().getAnchorIcon();
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "handleLiveRoomPoster from getAnchorIcon = " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f226908d.t().W(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String str, String str2, String str3, String str4, final int i3, int i16, long j3, final ILiveRoomInfo iLiveRoomInfo) {
        String str5;
        if (!P(str, str2)) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "channel not equal, ignore");
            return;
        }
        if (iLiveRoomInfo != null) {
            str5 = iLiveRoomInfo.getProgramId();
        } else {
            str5 = "";
        }
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "onLiveRoomStatusChange guildId=" + str + " channelId=" + str2 + " roomId=" + str3 + " anchorTinyId=" + str4 + " action=" + i3 + " liveType =" + i16 + " programId=" + str5);
        if (i3 == 1) {
            T0(j3);
        }
        K0(i3, i16, str4, iLiveRoomInfo);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.m
            @Override // java.lang.Runnable
            public final void run() {
                q.this.p0(i3, iLiveRoomInfo);
            }
        });
        this.f226908d.s().setLiveType(i16);
        if (GLiveChannelCore.f226698a.s().getAnchorIsSelf() && i3 == 1) {
            this.f226908d.t().P();
        }
        if (i16 == 0 && T(str4) && !this.f226908d.r().b()) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "PUSH_FLOW, TinyId is self");
            if (i3 == 2) {
                this.f226908d.e("PUSH_FLOW, TinyId is self", true, str5);
                return;
            }
            return;
        }
        if (i3 == 2) {
            this.M = null;
            this.f226908d.e("handleOnLiveRoomStatusChange, LIVE_ROOM_STATUS_CHANGE_ACTION_CLOSE", true, str5);
            return;
        }
        if (i3 == 1) {
            this.M = str3;
            boolean y06 = y0(new ArrayList(this.f226909e));
            if (i16 == 1) {
                if (T(str4)) {
                    this.f226908d.t().r0(Boolean.TRUE);
                    return;
                } else {
                    if (GuardManager.sInstance.isApplicationForeground()) {
                        x0();
                        return;
                    }
                    return;
                }
            }
            if (i16 == 0 && !y06) {
                x0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(ArrayList<IGProUserInfo> arrayList) {
        if (arrayList != null && this.N != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<IGProUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                IGProUserInfo next = it.next();
                if (!T(next.getTinyId())) {
                    arrayList2.add(new LiveUserEnterTipsModel(next.getTinyId(), ch.d0(next), next.getMyRoles().contains(6)));
                }
            }
            this.N.a(arrayList2);
        }
    }

    private void l0(boolean z16, String str) {
        if (!Q(str)) {
            QLog.e("QGL.QQGuildLiveEventHelper", 1, "handleReportGuestEnteringGuildResult, guild id not equal.");
            return;
        }
        if (z16) {
            String str2 = this.f226912i;
            IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
            iGPSService.fetchGuestGuild(this.C, false, new i(str2, str, iGPSService));
        } else {
            QLog.e("QGL.QQGuildLiveEventHelper", 1, "handleReportGuestEnteringGuildResult, guild id not equal.");
            W("", "handleReportGuestEnteringGuildResult not success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(String str, int i3, String str2, IGProExitAVChannelRsp iGProExitAVChannelRsp) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "exitAudioLiveChannel, " + str + ", result:" + i3 + ", errMsg:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(boolean z16, int i3, String str, int i16) {
        boolean z17 = true;
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "[fetchChannelUserPermission] onResult result = " + i3 + ", errMsg = " + str + ", userPermission = " + i16);
        if (i3 != 0 || !K(i16)) {
            z17 = false;
        }
        this.E = z17;
        if (this.F != null) {
            A0();
        }
        if (!this.E && z16) {
            aa.d(R.string.f147480x0);
            L("anchor loss live permission");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(int i3, ILiveRoomInfo iLiveRoomInfo) {
        if (i3 == 2) {
            S0(null);
        } else {
            S0(iLiveRoomInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CoroutineScope q0() {
        return com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(List list) {
        this.f226908d.t().u0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(boolean z16) {
        if (!this.K && z16) {
            S();
        }
        this.K = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str, long j3, int i3, String str2, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
        if (U(str, "handleOnUserOnlineReport.")) {
            boolean z16 = true;
            QLog.d("QGL.QQGuildLiveEventHelper", 1, "userOnlineReport guildId = " + j3 + ", result = " + i3 + ", errMsg = " + str2);
            if (i3 != 0) {
                z16 = false;
            }
            l0(z16, this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(String str, int i3, String str2, IGProSecurityResult iGProSecurityResult, IGProEnterAudioLiveChannelRsp iGProEnterAudioLiveChannelRsp) {
        QLog.d("QGL.QQGuildLiveEventHelper", 1, "enterAudioLiveChannel: ", Integer.valueOf(i3), " errMsg: ", str2);
        if (U(str, "handleEnterAudioLiveChannelResult")) {
            GuildTimeRecHelper.d(GuildLiveTimeEvent.LIVE_ENTER_CHANNEL);
            com.tencent.mobileqq.guild.performance.report.l.g("live_room_enter_permission_callback", B0(iGProEnterAudioLiveChannelRsp), i3, str2);
            h0(i3, str2, iGProEnterAudioLiveChannelRsp);
        }
    }

    private void v0(List<com.tencent.mobileqq.guild.live.livemanager.h> list, @Nullable String str, String str2) {
        for (com.tencent.mobileqq.guild.live.livemanager.h hVar : list) {
            if (hVar != null) {
                hVar.onAutoExitRoomPage(str, str2);
            }
        }
    }

    private void w0(List<com.tencent.mobileqq.guild.live.livemanager.h> list, @NonNull sq1.b bVar) {
        for (com.tencent.mobileqq.guild.live.livemanager.h hVar : list) {
            if (hVar != null) {
                hVar.onEndLiveEvent(bVar);
            }
        }
    }

    private boolean y0(List<com.tencent.mobileqq.guild.live.livemanager.h> list) {
        for (com.tencent.mobileqq.guild.live.livemanager.h hVar : list) {
            if (hVar != null && hVar.onLiveRoomStatusOpenEvent()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "[onPermissionChanged] ");
        D0();
    }

    public void E0(String str) {
        this.H = str;
    }

    public void H0(com.tencent.mobileqq.guild.live.livemanager.h hVar) {
        this.f226909e.remove(hVar);
    }

    public void J(@NonNull com.tencent.mobileqq.guild.live.livemanager.h hVar) {
        this.f226909e.add(hVar);
    }

    protected boolean K(int i3) {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "[allowLive] permission = " + i3);
        if ((i3 & 8) == 8) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(@NonNull sq1.b bVar) {
        this.f226908d.s().setEnterSourceType("");
        w0(new ArrayList(this.f226909e), bVar);
    }

    public boolean V() {
        if (!this.f226911h) {
            return false;
        }
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "destroy. " + this.C + ", " + this.D);
        L0();
        IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
        iGPSService.deleteObserver(this.P);
        AppRuntime appRuntime = this.F;
        if (appRuntime instanceof BaseQQAppInterface) {
            ((BaseQQAppInterface) appRuntime).removeObserver(this.Q);
        }
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.L);
        final String str = this.f226912i;
        try {
            iGPSService.exitAudioLiveChannel(Long.parseLong(this.C), Long.parseLong(this.D), 5, new ArrayList<>(), new y() { // from class: com.tencent.mobileqq.guild.live.livemanager.j
                @Override // wh2.y
                public final void a(int i3, String str2, IGProExitAVChannelRsp iGProExitAVChannelRsp) {
                    q.n0(str, i3, str2, iGProExitAVChannelRsp);
                }
            });
        } catch (NumberFormatException unused) {
            QLog.e("QGL.QQGuildLiveEventHelper", 1, "guildId or channelId invalid.");
        }
        com.tencent.mobileqq.guild.setting.mute.c.C(this.C).removeObserver(this.R);
        this.I.g();
        this.F = null;
        this.f226911h = false;
        this.f226912i = null;
        this.f226913m = null;
        this.C = null;
        this.D = null;
        this.E = false;
        this.H = null;
        this.G = 0L;
        this.N.release();
        this.N = null;
        this.f226908d.t().r0(Boolean.FALSE);
        this.f226908d.t().t0(-1L);
        return true;
    }

    public void Z() {
        if (this.f226911h && this.G > 0) {
            String str = this.f226912i;
            IGPSService iGPSService = (IGPSService) this.F.getRuntimeService(IGPSService.class, "");
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(String.valueOf(this.G));
            iGPSService.fetchLiveRoomInfo(new ag.a().h(arrayList).e(), new f(str));
        }
    }

    public AppRuntime c0() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public boolean m0(String str, String str2) {
        String selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        if (R(selfTinyId, str, str2) && this.f226911h) {
            QLog.i("QGL.QQGuildLiveEventHelper", 1, "init. params is equals and inited, ignore");
            return false;
        }
        V();
        this.f226912i = UUID.randomUUID().toString();
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "init. guildId=" + str + ", channelId=" + str2 + ", mInitedUuid=" + this.f226912i);
        this.f226911h = true;
        this.f226913m = selfTinyId;
        this.C = str;
        this.D = str2;
        this.F = c0();
        this.N = new UserEnterTipsTrigger(new Function0() { // from class: com.tencent.mobileqq.guild.live.livemanager.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CoroutineScope q06;
                q06 = q.q0();
                return q06;
            }
        }, new com.tencent.mobileqq.guild.media.core.logic.entertips.a() { // from class: com.tencent.mobileqq.guild.live.livemanager.l
            @Override // com.tencent.mobileqq.guild.media.core.logic.entertips.a
            public final void a(List list) {
                q.this.r0(list);
            }
        });
        G0();
        ((IGPSService) this.F.getRuntimeService(IGPSService.class, "")).addObserver(this.P);
        AppRuntime appRuntime = this.F;
        if (appRuntime instanceof BaseQQAppInterface) {
            ((BaseQQAppInterface) appRuntime).addObserver(this.Q);
        }
        F0(this.f226908d.s().getRoomId());
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(this.L);
        I0();
        C0();
        D0();
        a0();
        com.tencent.mobileqq.guild.setting.mute.c.C(this.C).observeForever(this.R);
        J0();
        U0();
        this.f226908d.t().s0(true);
        return true;
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "AVFocus onFocusGain.");
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "AVFocus onFocusLoss.");
    }

    public void x0() {
        QLog.i("QGL.QQGuildLiveEventHelper", 1, "notifyEnterAudienceRoomIfCan." + this.M);
        if (!TextUtils.isEmpty(this.M)) {
            M(this.M);
            this.M = null;
        }
    }
}
