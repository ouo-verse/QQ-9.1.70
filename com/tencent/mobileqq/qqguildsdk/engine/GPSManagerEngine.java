package com.tencent.mobileqq.qqguildsdk.engine;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.qqguildsdk.data.GGProAVRoomOptPushInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProAVUserStateChangeInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.GGProSchedulePollingInfo;
import com.tencent.mobileqq.qqguildsdk.data.GGProVoiceSmobaGameRoomManageSysMsg;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProScreenShareUserData;
import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserChannelStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProHeartbeatRsq;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberChange;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSchemaConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.bg;
import com.tencent.mobileqq.qqguildsdk.data.bi;
import com.tencent.mobileqq.qqguildsdk.data.cf;
import com.tencent.mobileqq.qqguildsdk.data.ch;
import com.tencent.mobileqq.qqguildsdk.data.ck;
import com.tencent.mobileqq.qqguildsdk.data.cl;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.ez;
import com.tencent.mobileqq.qqguildsdk.data.fb;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.data.fl;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProCmd0xf5aGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo;
import com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAVChannelConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelUserChangeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf5aGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmdUinInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGroupProStatus;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildListSortInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildStateRspInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSchedulePollingInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import vh2.bt;

/* loaded from: classes17.dex */
public abstract class GPSManagerEngine extends GProSdkWrapperImpl {

    /* renamed from: l, reason: collision with root package name */
    private final String f266755l;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.d f266756m;

    /* renamed from: n, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.b f266757n;

    /* renamed from: o, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.state.f f266758o;

    /* renamed from: p, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.e f266759p;

    /* renamed from: q, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.f f266760q;

    /* renamed from: r, reason: collision with root package name */
    private final ci2.e f266761r;

    /* renamed from: s, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.a f266762s;

    /* renamed from: t, reason: collision with root package name */
    private final com.tencent.mobileqq.qqguildsdk.manager.g f266763t;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f266764u;

    /* renamed from: v, reason: collision with root package name */
    private volatile long f266765v;

    /* renamed from: w, reason: collision with root package name */
    public AtomicBoolean f266766w;

    public GPSManagerEngine(@NonNull AppRuntime appRuntime, @NonNull com.tencent.mobileqq.qqguildsdk.wrapper.a aVar) {
        super(appRuntime, aVar);
        this.f266764u = true;
        this.f266765v = 0L;
        this.f266766w = new AtomicBoolean(false);
        com.tencent.mobileqq.qqguildsdk.util.h.u("GPSManagerEngine", true, "sdk service init", "getCurrentUin begin");
        String currentUin = appRuntime.getCurrentUin();
        this.f266755l = currentUin;
        com.tencent.mobileqq.qqguildsdk.util.h.u("GPSManagerEngine", true, "sdk service init", "getCurrentUin after uin\uff1a " + currentUin);
        this.f266756m = new com.tencent.mobileqq.qqguildsdk.manager.d(this);
        this.f266757n = new com.tencent.mobileqq.qqguildsdk.manager.b(this);
        this.f266758o = new com.tencent.mobileqq.qqguildsdk.state.f(this);
        this.f266759p = new com.tencent.mobileqq.qqguildsdk.manager.e(this);
        this.f266761r = new ci2.e(this, el());
        this.f266760q = new com.tencent.mobileqq.qqguildsdk.manager.f(this);
        this.f266762s = new com.tencent.mobileqq.qqguildsdk.manager.a(this);
        this.f266763t = new com.tencent.mobileqq.qqguildsdk.manager.g(appRuntime, this);
        this.f266766w.set(Ek(appRuntime.getAccount()));
        wl(xl());
        ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).initSdkStatusStaticCallback();
        Dl();
    }

    private void Dl() {
        com.tencent.mobileqq.qqguildsdk.util.h.t("GPSManagerEngine", true, "reportNTInitTime, ntStartTime= " + com.tencent.mobileqq.startup.a.f289678s + ", ntEndTime= " + com.tencent.mobileqq.startup.a.f289679t + ", gproEndTime= " + com.tencent.mobileqq.startup.a.f289680u);
        Reporters.f231995a.b().newReportTask().setEventCode("guild_nt_gpro_init").setExtra("json_extra_nt_start_time", Long.valueOf(com.tencent.mobileqq.startup.a.f289678s)).setExtra("json_extra_nt_end_time", Long.valueOf(com.tencent.mobileqq.startup.a.f289679t)).setExtra("json_extra_gpro_end_time", Long.valueOf(com.tencent.mobileqq.startup.a.f289680u)).setAppChannel(com.tencent.mobileqq.guild.report.b.c()).report();
    }

    private void Pk(String str, GProGuildInfo gProGuildInfo, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        ll().l(str, gProGuildInfo);
        ej(1, "addGuildAndChannelList", new Object[0]);
    }

    private void Vk(String str, int i3) {
        if (i3 != 16) {
            if (i3 == 18) {
                ej(22, "switchFollowAdminNotifyMsgType", str);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            tl().l(arrayList);
        }
    }

    private boolean xl() {
        IGuildUserService.GuildUser guildUserCached = ((IGuildUserService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGuildUserService.class, "")).guildUserCached();
        QLog.i("GPSManagerEngine", 1, "needRefreshGuildList guildUser is " + guildUserCached);
        if (guildUserCached != IGuildUserService.GuildUser.FALSE) {
            return true;
        }
        return false;
    }

    private void yl(int i3, String str, GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        ej(i3, str, com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannelUserChangeInfo.getGuildId()), com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannelUserChangeInfo.getChannelId()), com.tencent.mobileqq.qqguildsdk.util.g.X(gProChannelUserChangeInfo.getChangeUserList()), new GGProChannelUserNum(gProChannelUserChangeInfo.getChannelUserNum()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void A(String str, bg bgVar) {
        ej(121, "doOnPushGuildPermissionChanged", str, bgVar);
        ej(122, "doOnPushGuildPermissionChanged", str, Ue(str));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void A0(String str, String str2, String str3, String str4, int i3, String str5, int i16) {
        ej(35, "doOnPushKickOutAudioChannel", str, str2, str3, new Object[]{str4, Integer.valueOf(i3), str5, Integer.valueOf(i16)});
    }

    public void Al(String str, boolean z16) {
        tl().n(str);
        if (z16) {
            ej(1, "removeAllCacheForGuild", new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void B(String str, String str2, int i3, List<String> list) {
        ej(85, "doOnPushChannelAdminChange", str, str2, Integer.valueOf(i3), list);
        if (list.contains(Rf())) {
            HashSet hashSet = new HashSet();
            hashSet.add(str2);
            ej(122, "doOnPushChannelAdminChange", str, hashSet);
            com.tencent.mobileqq.qqguildsdk.util.h.r("GPSManagerEngine", 1, "UpdatePermission guild=" + str + " channel=" + str2);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void B0(int i3, GProGuildInfo gProGuildInfo, boolean z16) {
        boolean z17;
        if (gProGuildInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "doOnGuildInfoUpdated result:" + i3 + ",fetchChannelList:" + z16);
            return;
        }
        String guildID = gProGuildInfo.getGuildID();
        if (i3 != 0) {
            if (i3 != 10003 && i3 != 10004 && i3 != 10005 && i3 != 21001 && i3 != 21002) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                com.tencent.mobileqq.qqguildsdk.util.h.n("GPSManagerEngine", true, "system notify", "doOnGuildInfoUpdated", "error", i3, "guild not exist or not member for this guild", "guildId: " + guildID);
                Al(guildID, true);
                ej(18, "doOnGuildInfoUpdated", guildID);
            }
            ll().e(i3, guildID);
            return;
        }
        ll().l(guildID, gProGuildInfo);
        com.tencent.mobileqq.qqguildsdk.util.h.e("GPSManagerEngine", false, "system notify", "doOnGuildInfoUpdated", "", "guildId: " + gProGuildInfo.getGuildID() + ", fetchChannelList : " + z16);
        if (z16) {
            ll().p(guildID);
        } else {
            ll().e(i3, guildID);
            ej(4, "doOnGuildInfoUpdated", guildID);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bl(String str, String str2) {
        el().j(str2);
        tl().m(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void C(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3105, "doOnUserWaitingToSpeakNotifyForAll", gProChannelUserChangeInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void C0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3116, "doOnUserLeaveListNotifyForAll", gProChannelUserChangeInfo);
    }

    public void Cl(@NonNull bt btVar) {
        tl().o(btVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void D(String str, GProGuildInfo gProGuildInfo) {
        if (com.tencent.mobileqq.qqguildsdk.util.j.h(str)) {
            return;
        }
        if (gProGuildInfo != null && !com.tencent.mobileqq.qqguildsdk.util.j.h(gProGuildInfo.getGuildID())) {
            ll().l(str, gProGuildInfo);
        } else {
            QLog.e("GPSManagerEngine", 1, "guildInfo has exception not update cache");
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void D0(List<String> list, List<fc> list2) {
        ej(227, "doOnSpeakableThresholdUpdate", list, list2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void E(String str, String str2) {
        ej(84, "doOnPushAddChannelSpeakPermission", str, str2, Boolean.TRUE);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void E0(String str, List<GProGuildRoleInfo> list) {
        ej(75, "doOnPushCreateRole", str, list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void F(String str, List<String> list) {
        ej(223, "doOnPushChannelAdminChange", str, list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void F0(String str, String str2, List<Object> list, int i3) {
        ej(45, "doOnSwitchLiveRoom", str, str2, list, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void Fk() {
        this.f266758o.d();
        this.f266763t.f();
        this.f266759p.a();
        com.tencent.mobileqq.qqguildsdk.util.i.a();
        super.Fk();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void G(List<bi> list) {
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (bi biVar : list) {
            List list2 = (List) hashMap.get(biVar.d());
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.add(biVar.e());
            hashMap.put(biVar.d(), list2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null && !((List) entry.getValue()).isEmpty()) {
                ej(83, "doOnPollingLiveChannelPresence", entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void G0() {
        QLog.i("GPSManagerEngine", 1, "doOnAllGuildChannelListFetchCompleted Guild cost, in main thread!");
        ej(9100, "doOnAllGuildChannelListFetchCompleted", new Object[0]);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void H(int i3, String str, int i16, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        if (i3 != 0) {
            ll().d(i3, str);
            return;
        }
        ll().d(i3, str);
        ej(2, "doOnChannelListUpdated", str);
        Vk(str, i16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void H0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine.1
            @Override // java.lang.Runnable
            public void run() {
                if (GPSManagerEngine.this.ll() == null) {
                    QLog.e("GPSManagerEngine", 1, "doAutoFetchGuildState getGuildListMgr() is null");
                    return;
                }
                List<String> g16 = GPSManagerEngine.this.ll().g();
                GPSManagerEngine.this.zl(g16);
                QLog.d("GPSManagerEngine", 1, "doAutoFetchGuildState Guild cost, size=" + g16.size());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void I(GGProAVUserStateChangeInfo gGProAVUserStateChangeInfo) {
        ej(3127, "doOnPushAVUserStateChange", gGProAVUserStateChangeInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void I0(String str, ck ckVar) {
        el().l(str, ckVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void J(int i3, long j3, int i16) {
        ej(9110, "doOnRecentVisitGuildListChange", Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void J0(String str, String str2, int i3) {
        ej(46, "doOnLiveChannelAnchorIdentityChange", str, str2, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void K(int i3, byte[] bArr) {
        ej(232, "doOnPushBussinessConfig", Integer.valueOf(i3), bArr);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void K0(GGProAVRoomOptPushInfo gGProAVRoomOptPushInfo) {
        ej(3221, "doOnPushAVRoomOptChange", gGProAVRoomOptPushInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void L(String str, String str2, String str3, int i3, String str4) {
        ej(3129, "doOnPushAVChannelPlayListChange", str, str2, str3, Integer.valueOf(i3), str4);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void L0(String str, String str2) {
        ej(80, "doOnPushMemberTopRoleChanged", str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void M(String str, String str2, ck ckVar) {
        Uk(str2, ckVar);
        qj(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void M0(String str, String str2, GProGuildRoleInfo gProGuildRoleInfo) {
        ej(77, "doOnPushModifyRole", str, str2, gProGuildRoleInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void N(String str, String str2, int i3, int i16) {
        IGProGuildInfo jl5 = jl(str);
        if (jl5 == null || !jl5.isGroupGuild()) {
            tl().e(str, str2);
        }
        ej(73, "doOnChannelVisibleChanged", str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void O(String str, String str2, boolean z16) {
        com.tencent.mobileqq.qqguildsdk.util.h.p("GPSManagerEngine", false, "system notify", "doOnPushAdminChanged", "change cache", "selfTinyId: " + Rf());
        if (str2.equals(Rf())) {
            ej(4, "doOnPushAdminChanged", str);
        }
        ej(13, "doOnPushAdminChanged", str, str2, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void P(List<bi> list) {
        GProChannelInfo c16;
        if (list != null && !list.isEmpty() && list.get(0) != null && (c16 = list.get(0).c()) != null) {
            ej(5, "doOnPollingChannelInfo", c16.getChannelUin());
            ej(19, "doOnPollingChannelInfo", com.tencent.mobileqq.qqguildsdk.data.g.a(c16));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void Q(String str) {
        ej(3210, "doOnPushAVChannelAppMsg", str);
    }

    public void Qk(@NonNull bt btVar) {
        tl().a(btVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void R(List<bi> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (bi biVar : list) {
            arrayList.add(biVar.g());
            arrayList2.add(biVar.b());
            arrayList3.add(biVar.d());
        }
        ej(94, "doOnPollingRecommendEssences", arrayList2, arrayList3, arrayList);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public String Rf() {
        String Rf = super.Rf();
        if (!TextUtils.isEmpty(Rf) && !Rf.equals("0")) {
            return Rf;
        }
        String c16 = com.tencent.mobileqq.qqguildsdk.util.i.c(this.f266755l);
        if (TextUtils.isEmpty(c16)) {
            return "0";
        }
        super.xk(c16);
        return c16;
    }

    public IGProGuildInfo Rk(IGProCmd0xf5aGuildInfo iGProCmd0xf5aGuildInfo, int i3, IGProCmd0xf5aUserInfo iGProCmd0xf5aUserInfo) {
        GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo = ((GGProCmd0xf5aGuildInfo) iGProCmd0xf5aGuildInfo).mInfo;
        int i16 = 1;
        if (this.f266768a == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GPSManagerEngine", 1, "convertToGuildInviteInfo kernelGuildService is null");
            return null;
        }
        GProGuild gProGuild = new GProGuild();
        com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo gProGuildInfo = new com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo();
        gProGuildInfo.guildCode = gProCmd0xf5aGuildInfo.guildId;
        gProGuildInfo.guildName = gProCmd0xf5aGuildInfo.guildName;
        gProGuildInfo.profile = gProCmd0xf5aGuildInfo.profile;
        gProGuildInfo.bannedTimeLimit = gProCmd0xf5aGuildInfo.bannedTimeLimit;
        gProGuildInfo.memberNum = gProCmd0xf5aGuildInfo.guildMemberNum;
        Matcher matcher = Pattern.compile("t=([^&]*)").matcher(gProCmd0xf5aGuildInfo.avatar);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                Objects.requireNonNull(group);
                gProGuildInfo.faceSeq = Long.parseLong(group);
            } catch (Exception e16) {
                com.tencent.mobileqq.qqguildsdk.util.h.r("GPSManagerEngine", 1, e16.getMessage());
            }
        }
        GProGroupProStatus gProGroupProStatus = new GProGroupProStatus();
        if (i3 == 300117) {
            gProGroupProStatus.isBanned = 1;
        }
        if (i3 == 300116) {
            gProGroupProStatus.isEnable = 0;
        }
        if (i3 == 300137) {
            gProGroupProStatus.isFrozen = 1;
        }
        gProGuildInfo.guildStatus = gProGroupProStatus;
        gProGuild.setGuildId(gProCmd0xf5aGuildInfo.guildId);
        gProGuild.setGuildInfo(gProGuildInfo);
        GProCmdUinInfo gProCmdUinInfo = new GProCmdUinInfo();
        gProCmdUinInfo.role = iGProCmd0xf5aUserInfo.getVisitorRole();
        if (iGProCmd0xf5aUserInfo.getIsMember() == 2) {
            if (iGProCmd0xf5aUserInfo.getVisitorRole() > 0) {
                i16 = 3;
            } else {
                i16 = 2;
            }
            gProCmdUinInfo.setIsMember(2);
        } else {
            gProCmdUinInfo.setIsMember(1);
        }
        gProGuild.setCmdUinInfo(gProCmdUinInfo);
        gProGuild.memberCode = i16;
        return new GProGuildInfo(gProGuild);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void S(int i3, String str, IGProHeartbeatRsq iGProHeartbeatRsq) {
        ej(3110, "doOnPushAVHeartbeatRsp", Integer.valueOf(i3), str, iGProHeartbeatRsq);
        if (iGProHeartbeatRsq == null) {
            return;
        }
        if (iGProHeartbeatRsq.getForceExit() < 1) {
            com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "doOnPushAVHeartbeatRsp forceExit is invalid:" + iGProHeartbeatRsq.getForceExit());
            return;
        }
        String valueOf = String.valueOf(iGProHeartbeatRsq.getGuildId());
        String valueOf2 = String.valueOf(iGProHeartbeatRsq.getChannelId());
        if (iGProHeartbeatRsq.getForceExit() == 1) {
            ej(3117, "doOnPushAVHeartbeatRsp", valueOf, valueOf2, iGProHeartbeatRsq.getShowTips());
        } else if (iGProHeartbeatRsq.getForceExit() == 2) {
            ej(3118, "doOnPushAVHeartbeatRsp", valueOf, valueOf2, iGProHeartbeatRsq.getShowTips());
        }
    }

    public ez Sk(IGProCmd0xf5aGuildInfo iGProCmd0xf5aGuildInfo) {
        GProCmd0xf5aGuildInfo gProCmd0xf5aGuildInfo = ((GGProCmd0xf5aGuildInfo) iGProCmd0xf5aGuildInfo).mInfo;
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GPSManagerEngine", 1, "convertToGuildInviteInfo kernelGuildService is null");
            return null;
        }
        return new cl(iKernelGuildService.convertToGuildInviteInfo(gProCmd0xf5aGuildInfo));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void T(String str, String str2, boolean z16, long j3) {
        ej(37, "doOnPushUserMuteSeatInGuild", str, str2, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    public void Tk(GProChannelInfo gProChannelInfo) {
        el().c(gProChannelInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void U(GGProAVUserStateChangeInfo gGProAVUserStateChangeInfo) {
        String str;
        IGProChannelInfo cl5 = cl(gGProAVUserStateChangeInfo.getChannelId());
        if (cl5 != null && cl5.isAllowOtherRaiseHand()) {
            ej(3102, "doOnPushUserHandUpResult", gGProAVUserStateChangeInfo);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnPushUserHandUpResult push is invalid, guildId=");
        sb5.append(gGProAVUserStateChangeInfo.getGuildId());
        sb5.append(", channelId=");
        sb5.append(gGProAVUserStateChangeInfo.getChannelId());
        sb5.append(", tinyId=");
        sb5.append(gGProAVUserStateChangeInfo.getTinyId());
        sb5.append(", reason: ");
        if (cl5 == null) {
            str = "channel is null";
        } else {
            str = "not allow raise hand";
        }
        sb5.append(str);
        com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", sb5.toString());
    }

    public void Uk(String str, ck ckVar) {
        el().d(str, ckVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void V(String str) {
        Al(str, true);
        ej(11, "doOnPushDestroyGuild", str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void W(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3106, "doOnUserSpeakingNotifyForAll", gProChannelUserChangeInfo);
    }

    @Nullable
    public GProScheduleInfo Wk(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GPSManagerEngine", 1, "decodeScheduleInfo kernelGuildService is null");
            return null;
        }
        return iKernelGuildService.decodeScheduleInfo(bArr);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void X(int i3, String str) {
        if (i3 == 0) {
            ej(3, "doOnUserListFetchFinish", str);
        }
    }

    public void Xk(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QLog.e("GPSManagerEngine", 1, "doOnPushChannelSubscribeBubbleShow guildId = " + str + ", channelId = " + str2);
        }
        ej(23, "doOnPushChannelSubscribeBubbleShow", str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void Y(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3115, "doOnUserEnterListNotifyForAll", gProChannelUserChangeInfo);
    }

    public void Yk(String str, boolean z16, int i3, vh2.v vVar) {
        if (vVar != null) {
            ll().a(str, vVar);
        }
        lj(str, z16, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void Z(String str, GProGuildInfo gProGuildInfo, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list) {
        Pk(str, gProGuildInfo, hashMap, bVar, list);
        ej(7, "doOnPushCreateGuild", gProGuildInfo);
    }

    public void Zk(String str, boolean z16, int i3, vh2.v vVar) {
        if (vVar != null) {
            ll().a(str, vVar);
        }
        kj(str, z16, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void a(HashSet<String> hashSet) {
        com.tencent.mobileqq.qqguildsdk.util.h.p("GPSManagerEngine", false, "sdkWrapper interface", "doOnPollingLiveAudioChannelPresence", "", "gid=" + no0.a.a(",", hashSet));
        if (hashSet.isEmpty()) {
            return;
        }
        ej(3222, "doOnPollingLiveAudioChannelPresence", hashSet);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void a0(String str, String str2, int i3) {
        ej(109, "doOnPushNotifySwitchUpdate", str, str2, Integer.valueOf(i3));
    }

    public com.tencent.mobileqq.qqguildsdk.manager.a al() {
        return this.f266762s;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void b(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannelUserChangeInfo.getGuildId());
        String X02 = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannelUserChangeInfo.getChannelId());
        List<GProUserInfo> X = com.tencent.mobileqq.qqguildsdk.util.g.X(gProChannelUserChangeInfo.getChangeUserList());
        if (X.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (GProUserInfo gProUserInfo : X) {
            int groupType = gProUserInfo.getBusinessInfo().getUserListGroupInfo().getGroupType();
            if (groupType != 0 && groupType != 1) {
                if (groupType != 2) {
                    com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "doOnAVUserInfoChangeNotifyForAll userlist has a unkown group type, guildId=" + X0 + ", channelId=" + X02 + ", groupType=" + groupType);
                } else {
                    arrayList2.add(gProUserInfo);
                }
            } else {
                arrayList.add(gProUserInfo);
            }
        }
        ej(3126, "doOnAVUserInfoChangeNotifyForAll", X0, X02, arrayList, arrayList2, new GGProChannelUserNum(gProChannelUserChangeInfo.getChannelUserNum()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void b0() {
        ej(149, "doOnQQMsgListChannelDataReady", new Object[0]);
    }

    public List<cy> bl(String str) {
        return el().e(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void c(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3108, "doOnSmobaGameUserChangeNotifyForAll", gProChannelUserChangeInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void c0(GGProVoiceSmobaGameRoomManageSysMsg gGProVoiceSmobaGameRoomManageSysMsg) {
        ej(229, "doOnVoiceSmobaGameRooManageUpdate", gGProVoiceSmobaGameRoomManageSysMsg);
    }

    @Nullable
    public IGProChannelInfo cl(String str) {
        return el().f(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void d(String str, String str2, String str3, int i3) {
        ej(47, "doOnSelfBannedSpeakChange", str, str2, str3, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void d0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3107, "doOnUserAVStateResetNotifyForAll", gProChannelUserChangeInfo);
    }

    @NotNull
    public List<IGProChannelInfo> dl(String str) {
        return el().g(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void e(int i3, String str, String str2, String str3, cf cfVar) {
        ej(16, "doOnRefreshGuildUserProfileInfo", Integer.valueOf(i3), str, str2, str3, cfVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void e0(int i3, GProChannelInfo gProChannelInfo) {
        if (i3 == 0) {
            ej(5, "doOnChannelInfoUpdated", gProChannelInfo.getChannelUin());
            ej(19, "doOnChannelInfoUpdated", com.tencent.mobileqq.qqguildsdk.data.g.a(gProChannelInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.mobileqq.qqguildsdk.manager.b el() {
        return this.f266757n;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void f(com.tencent.mobileqq.qqguildsdk.data.o oVar) {
        ej(3220, "doOnPushPreventAddictionInstructions", oVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void f0(String str, String str2, GProAVChannelConfig gProAVChannelConfig) {
        if (gProAVChannelConfig != null && gProAVChannelConfig.getBusinessList().size() != 0) {
            ej(3120, "doOnPushAVChannelConfigUpdate", str, str2, new GGProAVChannelConfig(gProAVChannelConfig));
        } else {
            com.tencent.mobileqq.qqguildsdk.util.h.e("GPSManagerEngine", true, "system notify", "doOnPushAVChannelConfigUpdate", "error", "channelConfig is null or BusinessList is empty");
        }
    }

    public String fl() {
        return this.f266755l;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void g(List<bi> list) {
        if (list != null && !list.isEmpty()) {
            for (bi biVar : list) {
                ej(93, "doOnPollingWorldChannelPresence", biVar.d(), biVar.b());
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void g0(String str, boolean z16, boolean z17, boolean z18, long j3) {
        ej(161, "doOnPushBannedStatusChanged", str, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j3));
    }

    public List<IGProGuildInfo> gl() {
        return ll().h();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void h(List<bi> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<bi> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f());
            }
            ej(54, "doOnPollingOnlineMember", arrayList);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void h0(String str, String str2, boolean z16, long j3) {
        ej(39, "doOnPushAllowScreenShareInGuild", str, str2, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    public String hl(String str, int i3) {
        IGProGuildInfo jl5 = jl(str);
        if (jl5 != null) {
            return jl5.getAvatarUrl(i3);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void i(GProSchedulePollingInfo gProSchedulePollingInfo) {
        com.tencent.mobileqq.qqguildsdk.util.h.p("GPSManagerEngine", false, "sdkWrapper interface", "doOnPollingScheduleInfo", "aohe#", gProSchedulePollingInfo.toString());
        if (gProSchedulePollingInfo.schedulerStatus.isEmpty()) {
            return;
        }
        ej(95, "doOnPollingScheduleInfo", new GGProSchedulePollingInfo(gProSchedulePollingInfo));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void i0(ArrayList<String> arrayList, String str) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            Bl(str, it.next());
        }
        ej(17, "doOnPushChannelDestroy", str, arrayList);
        ej(2, "doOnPushChannelDestroy", str);
    }

    public String il(String str) {
        return el().h(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void j(String str, String str2, List<GProScreenShareUserData> list, String str3) {
        ej(38, "doOnPushUserScreenShare", str, str2, list, str3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void j0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3104, "doOnUserHandUpRequestNotifyForAll", gProChannelUserChangeInfo);
    }

    public IGProGuildInfo jl(String str) {
        return ll().i(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void k(String str, String str2, String str3, IGuildSchemaConfig iGuildSchemaConfig) {
        ej(222, "doOnPushInviteMemberEvent", str, str2, str3, iGuildSchemaConfig);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void k0(ch chVar) {
        ej(228, "doOnVoiceSmobaGameUserActionUpdate", chVar);
    }

    public List<IGProGuildInfo> kl() {
        return ll().j();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void l(String str, String str2, int i3, int i16, String str3) {
        if (str2.equals(Rf())) {
            ej(233, "doOnPushJoinGuildFail", new com.tencent.mobileqq.qqguildsdk.data.a(str, str2, i3, i16, str3));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void l0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3125, "doOnEnterSpeakQueueNotifyForAll", gProChannelUserChangeInfo);
    }

    protected com.tencent.mobileqq.qqguildsdk.manager.d ll() {
        return this.f266756m;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void m(int i3, String str, boolean z16, ArrayList<String> arrayList, ArrayList<GProGuildInfo> arrayList2, GProGuildListSortInfo gProGuildListSortInfo) {
        if (i3 == 0) {
            if (z16) {
                ll().f(arrayList, arrayList2);
                if (ll().k()) {
                    ll().n(arrayList2);
                    ej(50, "doOnGuildListUpdated", Integer.valueOf(i3), str);
                    ej(81, "doOnGuildListUpdated", new Object[0]);
                    ej(1, "doOnGuildListUpdated", new Object[0]);
                    return;
                }
            }
            ej(1, "doOnGuildListUpdated", new Object[0]);
            ej(81, "doOnGuildListUpdated", new Object[0]);
        }
        ej(50, "doOnGuildListUpdated", Integer.valueOf(i3), str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void m0(String str, String str2) {
        if (str2.equals(Rf())) {
            Al(str, true);
            ej(9, "doOnPushQuitGuild", str);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void mj(boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!z16 && currentTimeMillis - this.f266765v < 60000) {
            return;
        }
        super.mj(z16);
        this.f266765v = currentTimeMillis;
    }

    public String ml(String str) {
        IGProGuildInfo jl5 = jl(str);
        if (jl5 != null) {
            return jl5.getGuildName();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void n(String str, List<IGProRoleMemberChange> list) {
        ej(79, "doOnPushChangeRoleMember", str, list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void n0(GProChannelUserChangeInfo gProChannelUserChangeInfo) {
        yl(3123, "doOnRobotStateChangeNotifyForAll", gProChannelUserChangeInfo);
    }

    public com.tencent.mobileqq.qqguildsdk.manager.e nl() {
        return this.f266759p;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void o(String str, String str2) {
        tl().m(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void o0(GGProAVUserStateChangeInfo gGProAVUserStateChangeInfo) {
        String str;
        IGProChannelInfo cl5 = cl(gGProAVUserStateChangeInfo.getChannelId());
        if (cl5 != null && cl5.isAllowOtherRaiseHand()) {
            ej(3112, "doOnPushCanceledSpeak", gGProAVUserStateChangeInfo);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doOnPushCanceledSpeak push is invalid, guildId=");
        sb5.append(gGProAVUserStateChangeInfo.getGuildId());
        sb5.append(", channelId=");
        sb5.append(gGProAVUserStateChangeInfo.getChannelId());
        sb5.append(", tinyId=");
        sb5.append(gGProAVUserStateChangeInfo.getTinyId());
        sb5.append(", reason: ");
        if (cl5 == null) {
            str = "channel is null";
        } else {
            str = "not allow raise hand";
        }
        sb5.append(str);
        com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", sb5.toString());
    }

    public IGuildSpeakableThresholdPermission ol(String str) {
        return this.f266763t.g(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void p(String str, GProGuildInfo gProGuildInfo, @NonNull HashMap<String, GProChannelInfo> hashMap, @NonNull com.tencent.mobileqq.qqguildsdk.data.b bVar, @NonNull List<com.tencent.mobileqq.qqguildsdk.data.b> list, String str2, int i3) {
        if (str2.equals(Rf())) {
            Pk(str, gProGuildInfo, hashMap, bVar, list);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            zl(arrayList);
            ej(43, "doOnPushJoinGuild", gProGuildInfo, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void p0(int i3) {
        ej(108, "doOnPushDirectMsgSwitchUpdate", Integer.valueOf(i3));
    }

    @Nullable
    public dt pl(String str) {
        return tl().g(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void q(String str, String str2, String str3, String str4) {
        ej(48, "doOnLiveRoomInfoChange", str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void q0(String str, long j3) {
        ej(160, "doOnPushShutUpStateChanged", str, Long.valueOf(j3));
    }

    public com.tencent.mobileqq.qqguildsdk.manager.f ql() {
        return this.f266760q;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void r(String str) {
        ej(78, "doOnPushSortRole", str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void r0(String str, String str2, int i3) {
        if (str2.equals(Rf())) {
            Al(str, true);
            ej(10, "doOnPushKickOffGuild", str, Integer.valueOf(i3));
        }
    }

    public List<IGProGuildInfo> rl() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
            return new ArrayList();
        }
        return com.tencent.mobileqq.qqguildsdk.util.g.B0(iKernelGuildService.getSortedGuildsFromCache());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void s(GProUserChannelStateInfo gProUserChannelStateInfo) {
        if (gProUserChannelStateInfo == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.e("GPSManagerEngine", true, "system notify", "doOnUserChannelStateChange", "error", "userChannelState == null");
            return;
        }
        com.tencent.mobileqq.qqguildsdk.util.h.e("GPSManagerEngine", true, "system notify", "doOnUserChannelStateChange", "", "userChannelState=" + gProUserChannelStateInfo);
        tl().q(gProUserChannelStateInfo);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void s0(GProSecurityInfo gProSecurityInfo) {
        ej(82, "doOnPushSecurityResult", gProSecurityInfo);
    }

    public com.tencent.mobileqq.qqguildsdk.manager.g sl() {
        return this.f266763t;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void t(fb fbVar) {
        ej(40, "doOnMemberCountUpdate", fbVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void t0(String str, String str2, String str3, int i3, String str4) {
        ej(34, "doOnPushAudioChannelUserPlatSwitch", str, str2, str3, Integer.valueOf(i3), str4);
    }

    public com.tencent.mobileqq.qqguildsdk.state.f tl() {
        return this.f266758o;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void u(List<Integer> list, List<fl> list2) {
        String str;
        if (list.size() != list2.size()) {
            com.tencent.mobileqq.qqguildsdk.util.h.r("GPSManagerEngine", 1, "doOnQQMsgListGuildUpdated ops=" + list.size() + " guilds=" + list2.size());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (fl flVar : list2) {
            String guildId = flVar.getGuildId();
            long topTimestamp = flVar.getTopTimestamp();
            String guildName = flVar.getGuildName();
            long avatarSeq = flVar.getAvatarSeq();
            IGProGuildInfo jl5 = jl(guildId);
            if (jl5 != null) {
                String guildName2 = jl5.getGuildName();
                if (!TextUtils.isEmpty(guildName2)) {
                    guildName = guildName2;
                }
                avatarSeq = jl5.getAvatarSeq();
            }
            long j3 = avatarSeq;
            if (guildName == null) {
                com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "doOnQQMsgListGuildUpdated guildName is null, gid:" + guildId);
                str = "";
            } else {
                str = guildName;
            }
            arrayList.add(new fl(guildId, topTimestamp, str, j3));
        }
        ej(148, "doOnQQMsgListGuildUpdated", list, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u0(List<Integer> list, List<fk> list2) {
        int i3;
        String str;
        String str2;
        if (list.size() != list2.size()) {
            com.tencent.mobileqq.qqguildsdk.util.h.r("GPSManagerEngine", 1, "doOnQQMsgListChannelUpdated ops=" + list.size() + " channels=" + list2.size());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (fk fkVar : list2) {
            String guildId = fkVar.getGuildId();
            String channelId = fkVar.getChannelId();
            long topTimestamp = fkVar.getTopTimestamp();
            String guildName = fkVar.getGuildName();
            String channelName = fkVar.getChannelName();
            long avatarSeq = fkVar.getAvatarSeq();
            int channelType = fkVar.getChannelType();
            long appId = fkVar.getAppId();
            IGProGuildInfo jl5 = jl(guildId);
            if (jl5 != null) {
                String guildName2 = jl5.getGuildName();
                if (!TextUtils.isEmpty(guildName2)) {
                    guildName = guildName2;
                }
                avatarSeq = jl5.getAvatarSeq();
            }
            long j3 = avatarSeq;
            IGProChannelInfo cl5 = cl(channelId);
            if (cl5 != null) {
                String channelName2 = cl5.getChannelName();
                if (!TextUtils.isEmpty(channelName2)) {
                    channelName = channelName2;
                }
                int type = cl5.getType();
                if (type != 0) {
                    i3 = type;
                    if (guildName != null) {
                        com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "doOnQQMsgListChannelUpdated guildName is null, gid:" + guildId + ",cid:" + channelId);
                        str = "";
                    } else {
                        str = guildName;
                    }
                    if (channelName != null) {
                        com.tencent.mobileqq.qqguildsdk.util.h.k("GPSManagerEngine", 1, "sdk interface", "doOnQQMsgListChannelUpdated channelName is null, gid:" + guildId + ",cid:" + channelId);
                        str2 = "";
                    } else {
                        str2 = channelName;
                    }
                    arrayList.add(new fk(guildId, channelId, topTimestamp, str, str2, j3, i3, appId));
                }
            }
            i3 = channelType;
            if (guildName != null) {
            }
            if (channelName != null) {
            }
            arrayList.add(new fk(guildId, channelId, topTimestamp, str, str2, j3, i3, appId));
        }
        ej(150, "doOnQQMsgListChannelUpdated", list, arrayList);
    }

    public List<String> ul() {
        IKernelGuildService iKernelGuildService = this.f266768a;
        if (iKernelGuildService == null) {
            hj();
            return new ArrayList();
        }
        return com.tencent.mobileqq.qqguildsdk.util.g.Y0(iKernelGuildService.getToppedGuildIdsFromCache());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void v(List<com.tencent.mobileqq.qqguildsdk.state.a> list) {
        tl().r(list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void v0(String str, String str2, int i3) {
        ej(5, "doOnPushMsgRecvTypeChanged", str2);
        ej(12, "doOnPushMsgRecvTypeChanged", str, str2, Integer.valueOf(i3));
        IGProChannelInfo cl5 = cl(str2);
        if (cl5 != null) {
            ej(19, "doOnPushMsgRecvTypeChanged", com.tencent.mobileqq.qqguildsdk.data.g.a(cl5));
        }
    }

    public ci2.e vl() {
        return this.f266761r;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void w(List<String> list) {
        QLog.i("GPSManagerEngine", 1, "doOnNotifyGuildMainFrameHeaderUpdated guildIdList size=" + list.size());
        ej(9101, "doOnNotifyGuildMainFrameHeaderUpdated", list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void w0(String str, String str2, String str3, String str4, String str5, int i3, int i16, ILiveProgramInfo iLiveProgramInfo, long j3, ILiveRoomInfo iLiveRoomInfo) {
        ej(44, "doOnLiveRoomStatusChange", str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), iLiveProgramInfo, Long.valueOf(j3), iLiveRoomInfo);
    }

    public synchronized void wl(boolean z16) {
        if (!this.f266764u) {
            return;
        }
        if (this.f266768a == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.t("GPSManagerEngine", true, "initCache but kernelGuildService = null");
        } else {
            ag(z16);
            this.f266764u = false;
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void x(GProGuildStateRspInfo gProGuildStateRspInfo) {
        tl().h(gProGuildStateRspInfo, true);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void x0(String str, List<GProGuildRoleInfo> list) {
        ej(76, "doOnPushDeleteRole", str, list);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl
    public void xk(String str) {
        super.xk(str);
        com.tencent.mobileqq.qqguildsdk.util.i.d(fl(), str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void y(String str, String str2, boolean z16, long j3) {
        ej(3111, "doOnPushPermissionInGuild", str, str2, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void y0(String str, String str2) {
        ej(84, "doOnPushRemoveChannelSpeakPermission", str, str2, Boolean.FALSE);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void z(List<bi> list) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (bi biVar : list) {
                List list2 = (List) hashMap.get(biVar.d());
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(biVar.b());
                hashMap.put(biVar.d(), list2);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() != null && !((List) entry.getValue()).isEmpty()) {
                    ej(3101, "doOnPollingVoiceChannelPresence", entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.hn
    public void z0(String str, String str2, String str3, ArrayList<IGProTopMsg> arrayList, ArrayList<IGProTopMsg> arrayList2) {
        vl().m(str, str2);
        ej(20, "doOnPushChannelTopMsgUpdated", str, str2, str3, arrayList, arrayList2);
    }

    protected void zl(@NonNull List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            IGProGuildInfo jl5 = jl(it.next());
            if (jl5 != null && jl5.isGroupGuild()) {
                it.remove();
            }
        }
        if (tl() == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.j("GPSManagerEngine", 1, "refreshGuildState getStateMgr() is null");
        } else {
            tl().l(list);
        }
    }
}
