package com.tencent.mobileqq.guild.jump;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.guild.aisearch.GuildAISearchChatFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.impl.QQGuildRouterApiImpl;
import com.tencent.mobileqq.guild.channel.managev2.item.delete.GuildDeleteSubChannelConfirmDialog;
import com.tencent.mobileqq.guild.channellist.GuildTextChannelListFragment;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.discovery.avblockdetail.repo.DiscoveryAVBlockDetailDataRepo$RecommendTagLisType;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildNewRecommendFragment;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.jump.api.IJumpParserApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.q;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.mainframe.w;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildUserProfileCardFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleListFragment;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildBlackAndRiskFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ez;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import vh2.aa;
import vh2.cd;
import vh2.n;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildJumpAction implements IJumpParserApi.b {

    /* renamed from: a, reason: collision with root package name */
    private final BaseQQAppInterface f226357a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f226358b;

    /* renamed from: c, reason: collision with root package name */
    private final String f226359c;

    /* renamed from: d, reason: collision with root package name */
    private final String f226360d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, String> f226361e;

    /* renamed from: f, reason: collision with root package name */
    private final IJumpParserApi.a f226362f;

    /* renamed from: g, reason: collision with root package name */
    private final String f226363g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements cd {
        a() {
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            QLog.d("Guild.jump.GuildJumpAction", 1, "deleteChannel result=" + i3 + " errMsg=" + str);
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                QQToastUtil.showQQToastInUiThread(2, GuildJumpAction.this.f226358b.getString(R.string.f141390gj));
            } else {
                SecurityTipHelperKt.B(GuildJumpAction.this.f226358b, i3, str, iGProSecurityResult, HardCodeUtil.qqStr(R.string.f141910hy));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements Function1<IGProGuildInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f226365d;

        b(String str) {
            this.f226365d = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            if (iGProGuildInfo != null && (iGProGuildInfo.getUserType() == 2 || iGProGuildInfo.getUserType() == 1)) {
                QQGuildManageFragment.Yk(GuildJumpAction.this.f226358b, iGProGuildInfo, 0, Integer.valueOf(this.f226365d).intValue());
                return null;
            }
            QQToastUtil.showQQToast(R.string.f1489510z);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f226367a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226368b;

        c(Bundle bundle, String str) {
            this.f226367a = bundle;
            this.f226368b = str;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.w
        public void onFailed(int i3, String str) {
            QLog.w("Guild.jump.GuildJumpAction", 1, "requestOpenGuildTab failed!! code=" + i3 + " msg=" + str + " jumpUrl=" + GuildJumpAction.this.f226363g);
            GuildJumpAction.U(new kh1.a(i3, str), this.f226368b, GuildJumpAction.this.f226363g);
        }

        @Override // com.tencent.mobileqq.guild.mainframe.w
        public void onSuccess() {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.jump.GuildJumpAction", 1, "requestOpenGuildTab succ");
            }
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(GuildJumpAction.this.f226358b, 0, this.f226367a);
        }
    }

    public GuildJumpAction(BaseQQAppInterface baseQQAppInterface, Context context, JumpParserResult jumpParserResult, IJumpParserApi.a aVar) {
        this.f226357a = baseQQAppInterface;
        this.f226358b = context;
        this.f226359c = jumpParserResult.getAction();
        this.f226360d = jumpParserResult.getServer();
        this.f226361e = jumpParserResult.getParamMap();
        this.f226362f = aVar;
        this.f226363g = jumpParserResult.getUrl();
    }

    private void A(HashMap<String, String> hashMap) {
        QQGuildNavigatorConfigFragment.Wi(this.f226358b, hashMap.get("guildid"));
    }

    private void B(HashMap<String, String> hashMap) {
        GuildNoticeFragment.Mh(this.f226358b, hashMap.get("guildid"));
    }

    private void C() {
        boolean z16;
        Bundle h16 = h();
        String string = h16.getString("guildid", "");
        String string2 = h16.getString("channelid", "");
        String string3 = h16.getString("joinGuildSig", "");
        try {
            string3 = URLDecoder.decode(string3, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            QLog.d("Guild.jump.GuildJumpAction", 1, "joinGuildSig decode error ", string3);
        }
        String str = string3;
        String string4 = h16.getString("sourceId", "");
        String string5 = h16.getString("subSourceId", "");
        String string6 = h16.getString("aio_locate_msg", "");
        boolean j06 = ch.j0(string);
        QLog.d("Guild.jump.GuildJumpAction", 1, "gotoOpenChannelFromFeedDetail, isGuest: " + j06 + ", guildId: " + string + ", channelId: " + string2 + ", sourceId: " + string4 + ", subSourceId: " + string5 + ", joinGuildSig.length: " + str + ", aioLocateMsg: " + string6);
        if ((j06 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string5) && !TextUtils.isEmpty(string)) || (!j06 && !TextUtils.isEmpty(string))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QQToast.makeText(this.f226358b, R.string.f156441k8, 0).show();
            return;
        }
        o02.a.g(11);
        String string7 = h16.getString("appChannel");
        String string8 = h16.getString("pginSource");
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        if (!TextUtils.isEmpty(string7)) {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", string7);
        }
        if (!TextUtils.isEmpty(string8)) {
            guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_into_source", string8);
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(string, string2, str, string4, string5);
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        try {
            jumpGuildParam.extras.putLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP, Long.parseLong(string6));
        } catch (NumberFormatException unused2) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoOpenChannel aioLocateMsg format error");
        }
        GuildJumpUtil.n(this.f226358b, jumpGuildParam);
    }

    private void D() {
        String str;
        String str2 = this.f226361e.get("guildid");
        if (str2 == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoProfileCard,guildId is null");
            return;
        }
        String str3 = this.f226361e.get("tinyid");
        if (str3 == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoProfileCard,tinyId is null");
            return;
        }
        String str4 = this.f226361e.get("channelid");
        String str5 = "";
        if (str4 == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoProfileCard,channelId is null");
            str = "";
        } else {
            str = str4;
        }
        String str6 = this.f226361e.get("from");
        if (str6 == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoProfileCard,from is null");
        } else {
            str5 = str6;
        }
        GuildProfileData guildProfileData = new GuildProfileData(str2, "", str3, 4, az.c(str5, 0));
        guildProfileData.getGuildBaseProfileData().r(str);
        GuildUserProfileCardFragment.rh(this.f226358b, guildProfileData);
    }

    private void E(HashMap<String, String> hashMap) {
        String str;
        String str2;
        int i3 = 0;
        try {
            String str3 = hashMap.get("categoryConfId");
            if (str3 != null) {
                i3 = Integer.parseInt(str3);
            }
        } catch (NumberFormatException e16) {
            QLog.i("Guild.jump.GuildJumpAction", 1, "gotoRecommendPage parse categoryConfId exception:" + e16);
        }
        int i16 = i3;
        String str4 = hashMap.get("mainSourceId");
        String str5 = hashMap.get("subSourceId");
        GuildNewRecommendFragment.Companion companion = GuildNewRecommendFragment.INSTANCE;
        Context context = this.f226358b;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        companion.c(context, 8, i16, str, str2, new ArrayList<>());
    }

    private void F() {
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).addGuildByShareUrl(this.f226358b, this.f226362f.c());
        com.tencent.mobileqq.guild.mainframe.d.f227410a.b(QQGuildRouterApiImpl.transferReportSourceInfoFromUrl(this.f226362f.c(), new Intent()));
        QLog.d("Guild.jump.GuildJumpAction", 2, "gotoShare!! sourceInfo=$sourceInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(int i3, String str, ez ezVar, IGProSecurityResult iGProSecurityResult, long j3) {
        if (i3 == 0 && ezVar != null) {
            QLog.i("Guild.jump.GuildJumpAction", 1, "gotoGuildFeed result: " + i3 + ", errMsg: " + str + ", inviteInfo: " + ezVar);
            this.f226361e.put(com.tencent.mobileqq.guild.feed.b.f218132r, ezVar.getJoinSig());
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedByScheme(this.f226358b, this.f226359c, this.f226361e);
            return;
        }
        QLog.w("Guild.jump.GuildJumpAction", 1, "gotoGuildFeed fetchGuildInfoByInviteCode failed result: " + i3 + ", errMsg: " + str);
        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedByScheme(this.f226358b, this.f226359c, this.f226361e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(boolean z16, int i3, String str, IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo == null) {
            QLog.e("QGL.Guild.jump.GuildJumpAction", 1, "get channelInfo is null, return.");
            return;
        }
        GLiveChannelStartParams create = GLiveChannelStartParams.create(iGProChannelInfo);
        create.setNeedOpenSharePanel(z16);
        o02.a.g(11);
        gq1.c.e(create);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit J(IGProChannelInfo iGProChannelInfo) {
        V(iGProChannelInfo);
        return Unit.INSTANCE;
    }

    private void K() {
        String str = this.f226361e.get("channelid");
        final IGProChannelInfo B = ch.B(str);
        boolean z16 = true;
        if (str != null && B != null) {
            if (!(this.f226358b instanceof Activity)) {
                QLog.e("Guild.jump.GuildJumpAction", 1, "openDeleteChannelDialog,context is not activity");
                return;
            }
            if (!r.p().getChannelPermission(B.getGuildId(), str).a(20002)) {
                QQToastUtil.showQQToastInUiThread(0, this.f226358b.getString(R.string.f15123175));
                return;
            }
            Activity activity = (Activity) this.f226358b;
            if (B.getOperationType() != 1) {
                z16 = false;
            }
            GuildDeleteSubChannelConfirmDialog.i(activity, z16, B, B.getGuildId(), B.getChannelUin(), null, new Function0() { // from class: com.tencent.mobileqq.guild.jump.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit J;
                    J = GuildJumpAction.this.J(B);
                    return J;
                }
            });
            return;
        }
        QLog.e("Guild.jump.GuildJumpAction", 1, "openDeleteChannelDialog,channelInfo is null");
    }

    private void L(HashMap<String, String> hashMap) {
        GuildTextChannelListFragment.ji(this.f226358b, new JumpGuildParam(hashMap.get("GuildID"), "", hashMap.get("JoinSig"), hashMap.get("mainSourceId"), hashMap.get("subSourceId")));
    }

    private void M() {
        String str = this.f226361e.get("params");
        if (TextUtils.isEmpty(str)) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openFeedGallery params is empty");
            return;
        }
        try {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedGalleryActivity(this.f226358b, new String(PluginBaseInfoHelper.Base64Helper.decode(str, 0)));
        } catch (Throwable th5) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openFeedGallery e:", th5);
        }
    }

    private void N() {
        QLog.i("Guild.jump.GuildJumpAction", 1, "openGuildAISearchPage");
        if (!q.l()) {
            QQToast.makeText(this.f226358b, "\u8bf7\u5148\u5f00\u542f\u9891\u9053\u5e95\u90e8\u5bfc\u822a\u680f", 0).show();
        } else {
            if (GuildAISearchConfBean.e().r()) {
                Intent intent = new Intent();
                intent.putExtra("ENTER_TYPE", 1);
                GuildAISearchChatFragment.INSTANCE.a(this.f226358b, intent);
                return;
            }
            QQToast.makeText(this.f226358b, "\u8be5\u529f\u80fd\u6682\u672a\u5bf9\u5916\u5f00\u653e", 0).show();
        }
    }

    private void P() {
        IGProGuildInfo L = ch.L(this.f226361e.get("guildid"));
        if (L == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openGuildSharePanel,guildInfo is null");
            return;
        }
        Context context = this.f226358b;
        if (!(context instanceof Activity)) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openGuildSharePanel,context is not activity");
            return;
        }
        m mVar = new m((Activity) context, L, null, GuildSharePageSource.GUILD_PROFILE);
        com.tencent.mobileqq.guild.share.util.c.c(mVar, 1);
        mVar.z();
    }

    private void Q() {
        String str = this.f226361e.get("guild_id");
        if (r.p().getGuildPermission(str).a(100002)) {
            GuildBlackAndRiskFragment.uh(this.f226358b, str, 1);
            return;
        }
        QQToastUtil.showQQToastInUiThread(0, this.f226358b.getString(R.string.f15118170));
        QLog.e("Guild.jump.GuildJumpAction", 1, "openManageRiskMember not permission, guildId:" + str);
    }

    private void R() {
        String str = this.f226361e.get("guildid");
        if (str == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openRoleSetting,guildId is null");
            return;
        }
        if (!r.p().getGuildPermission(str).i()) {
            QQToastUtil.showQQToastInUiThread(0, this.f226358b.getString(R.string.f15123175));
            return;
        }
        Intent Sh = GuildRoleListFragment.Sh(str);
        if (!(this.f226358b instanceof Activity)) {
            Sh.addFlags(268435456);
        }
        QPublicFragmentActivity.start(this.f226358b, Sh, GuildRoleListFragment.class);
    }

    private void S() {
        String str = this.f226361e.get("url");
        if (str != null && !str.isEmpty()) {
            try {
                ((IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class)).onInlineBtnClick(this.f226357a, this.f226358b, URLUtil.decodeUrl(str));
                return;
            } catch (IllegalArgumentException e16) {
                QLog.e("Guild.jump.GuildJumpAction", 1, "openUrl, decode failed", e16);
                return;
            }
        }
        QLog.e("Guild.jump.GuildJumpAction", 1, "openUrl, url is null");
    }

    private void T() {
        QBaseActivity splashActivity;
        if ("1".equals(this.f226361e.get("jumpGuildTab")) && (splashActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity()) != null && splashActivity.getIntent() != null) {
            splashActivity.getIntent().putExtra(IGuildMainFrameApi.GOTO_GUILD_TAB, true);
        }
    }

    public static void U(kh1.a aVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_is_success", Integer.valueOf(aVar.d() ? 1 : 0));
        if (!aVar.d()) {
            hashMap.put("sgrp_return_code", aVar.getCode() + "");
        }
        hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, aVar.getMsg());
        hashMap.put("sgrp_set_source", str);
        hashMap.put("sgrp_jump_url", str2);
        VideoReport.reportEvent("ev_float_schema_jump", hashMap);
    }

    private void V(IGProChannelInfo iGProChannelInfo) {
        QQGuildHandler qQGuildHandler = (QQGuildHandler) ch.k(QQGuildHandler.class.getName());
        if (qQGuildHandler == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "requestDeleteChannel,handler is null");
            QQToastUtil.showQQToastInUiThread(1, this.f226358b.getString(R.string.f141910hy));
        } else {
            qQGuildHandler.N2(iGProChannelInfo, 0, new a());
        }
    }

    private void i() {
        IGProGuildInfo L = ch.L(this.f226361e.get("guildid"));
        if (L == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "copyGuildNumber,guildInfo is null");
        } else {
            com.tencent.mobileqq.guild.util.b.a(L.getGuildNumber());
        }
    }

    private DiscoverTabType j(String str) {
        if ("hot".equals(str)) {
            return DiscoverTabType.HOT;
        }
        if (DiscoveryAVBlockDetailDataRepo$RecommendTagLisType.MY_GUILD.equals(str)) {
            return DiscoverTabType.ME;
        }
        return DiscoverTabType.RECOMMEND;
    }

    private void k() {
        String str;
        String str2;
        String str3 = this.f226361e.get("appChannel");
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = this.f226361e.get("traceId");
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        String str5 = this.f226361e.get("tabType");
        if (TextUtils.isEmpty(str5)) {
            str5 = "hot";
        }
        GuildHotLiveFragment.INSTANCE.c(this.f226358b, "", "\u70ed\u95e8\u6d3b\u52a8", str2, true, 0, 0, 0, j(str5), false, str, null);
    }

    private void l() {
        String str = this.f226361e.get("guildid");
        boolean z16 = true;
        if (str == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoChannelListSetting,guildId is null");
            return;
        }
        if (!r.p().getGuildPermission(str).d() && !ch.g0(str)) {
            z16 = false;
        }
        if (!z16) {
            QQToastUtil.showQQToastInUiThread(0, this.f226358b.getString(R.string.f15123175));
        } else {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelListSetting(this.f226358b, str, 0);
        }
    }

    private void n() {
        Bundle h16 = h();
        String str = this.f226361e.get("busi_info");
        int c16 = az.c(this.f226361e.get("jump_detail"), 0);
        String str2 = this.f226361e.get("jump_url");
        h16.putString("busi_info", str);
        h16.putInt("jump_detail", c16);
        h16.putString("discoveryTargetTab", this.f226361e.get("discoveryTargetTab"));
        String str3 = this.f226361e.get("appChannel");
        if (!TextUtils.isEmpty(str3)) {
            h16.putString("sgrp_stream_pgin_source_name", str3);
            h16.remove("appChannel");
        }
        QLog.d("Guild.jump.GuildJumpAction", 1, "gotoDiscoverPage ", h16, APLogFileUtil.SEPARATOR_LOG, this.f226361e);
        GuildJumpUtil.o(this.f226358b, h16);
        if (c16 != 2 && !TextUtils.isEmpty(str2)) {
            if (com.tencent.mobileqq.guild.share.shorturl.a.m(str2)) {
                GuildJumpUtil.i(this.f226358b, str2, new Bundle());
            } else {
                cx.a(this.f226358b, str2);
            }
        }
    }

    private void o() {
        String str = this.f226361e.get("channel_link");
        GuildJumpUtil.q(this.f226358b, new Bundle());
        if (!TextUtils.isEmpty(str)) {
            GuildJumpUtil.i(this.f226358b, str, new Bundle());
        }
        QLog.d("Guild.jump.GuildJumpAction", 1, "gotoFeaturedGuildPage ", this.f226361e);
    }

    private void p() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.jump.GuildJumpAction.3
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(GuildJumpAction.this.f226358b, R.string.f146030t3, 0).show();
            }
        });
    }

    private void q() {
        if (!(this.f226358b instanceof QBaseActivity)) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openGuildProfile,context is not QBaseActivity");
            return;
        }
        final String str = this.f226361e.get("guildid");
        if (str == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openGuildProfile,guildId is null");
        } else {
            if (ch.j0(str)) {
                QLog.e("Guild.jump.GuildJumpAction", 1, "openGuildProfile isGuest");
                return;
            }
            GuildJumpUtil.n(this.f226358b, new JumpGuildParam(str, ""));
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.jump.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMainFrameManager.k(str);
                }
            }, 200L);
        }
    }

    private void r() {
        if ("1".equals(this.f226361e.get("jumpGuildTab")) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getSplashActivity() == null) {
            v();
        }
        String str = this.f226361e.get(com.tencent.mobileqq.guild.feed.b.f218130p);
        if (str != null && !str.isEmpty()) {
            ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoByInviteCode(this.f226361e.get(com.tencent.mobileqq.guild.feed.b.f218130p), new aa() { // from class: com.tencent.mobileqq.guild.jump.b
                @Override // vh2.aa
                public final void a(int i3, String str2, ez ezVar, IGProSecurityResult iGProSecurityResult, long j3) {
                    GuildJumpAction.this.H(i3, str2, ezVar, iGProSecurityResult, j3);
                }
            });
        } else {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedByScheme(this.f226358b, this.f226359c, this.f226361e);
        }
    }

    private void s() {
        Bundle h16 = h();
        Intent intent = new Intent();
        intent.putExtra("key_params", h16);
        QPublicFragmentActivity.b.b(this.f226358b, intent, QPublicTransFragmentActivity.class, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildVerifyAccountAndOpenH5FragmentClass());
    }

    private void t(HashMap<String, String> hashMap) {
        String str = hashMap.get("guildid");
        String str2 = hashMap.get(IProfileCardConst.KEY_FROM_TYPE);
        GuildMainFrameUtils.k(str, new b(str2));
    }

    private void v() {
        String str;
        boolean z16;
        String str2;
        String str3;
        Bundle bundle;
        boolean a16 = ca.a();
        HashMap<String, String> hashMap = this.f226361e;
        if (hashMap != null && hashMap.size() > 0) {
            z16 = TextUtils.equals(this.f226361e.get("openTab"), "1");
            str = this.f226361e.get("appChannel");
            str2 = this.f226361e.get("tabid");
            str3 = this.f226361e.get("command");
        } else {
            str = "";
            z16 = false;
            str2 = "";
            str3 = str2;
        }
        QLog.d("Guild.jump.GuildJumpAction", 1, "gotoGuildTab needOpenTab=", Boolean.valueOf(z16), " appChannel=", str);
        if (z16) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("appChannel", str);
            bundle2.putString("url", this.f226363g);
            if (a16) {
                ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(this.f226358b, 0, bundle2);
                return;
            } else {
                zr1.d.f("share", new c(bundle2, str));
                return;
            }
        }
        if (str2 != null) {
            bundle = new Bundle();
            bundle.putString(IGuildMainFrameApi.GUILD_TAB_ID, str2);
        } else {
            bundle = null;
        }
        if (str3 != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("command", str3);
        }
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(this.f226358b, 0, bundle);
    }

    private void w() {
        GuildHotLiveFragment.Rh(this.f226358b, 6);
    }

    private void y(HashMap<String, String> hashMap, final boolean z16) {
        if (!ca.a()) {
            QLog.e("QGL.Guild.jump.GuildJumpAction", 1, "tab is not show, return.");
            return;
        }
        String str = hashMap.get("guildid");
        String str2 = hashMap.get("channelid");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new com.tencent.mobileqq.guild.mainframe.util.b(str, str2, 0L).e(new n() { // from class: com.tencent.mobileqq.guild.jump.d
                @Override // vh2.n
                public final void a(int i3, String str3, IGProChannelInfo iGProChannelInfo) {
                    GuildJumpAction.I(z16, i3, str3, iGProChannelInfo);
                }
            });
        } else {
            QLog.e("QGL.Guild.jump.GuildJumpAction", 1, "params is invalid, return.");
        }
    }

    private void z(HashMap<String, String> hashMap) {
        try {
            ((IGuildMsgApi) QRoute.api(IGuildMsgApi.class)).locateToMessage(Long.parseLong(hashMap.get(AppConstants.Key.COLUMN_SHMSG_SEQ)), this.f226358b);
        } catch (NumberFormatException unused) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "gotoLocateMsg format error");
        }
    }

    public void O() {
        String str = this.f226361e.get("guildid");
        if (str == null) {
            QLog.e("Guild.jump.GuildJumpAction", 1, "openGuildQRCodeFragment,guildId is null");
        } else {
            GuildSettingQRCodeFragment.ji(this.f226358b, str);
        }
    }

    @Override // com.tencent.mobileqq.guild.jump.api.IJumpParserApi.b
    public boolean a() {
        QLog.i("Guild.jump.GuildJumpAction", 1, "doAction: action=" + this.f226359c + " jumpUrl=" + this.f226363g);
        T();
        if (OperateCustomButton.OPERATE_CREATE.equals(this.f226359c)) {
            m();
        } else if (IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE.equals(this.f226359c)) {
            x();
        } else if (!"show".equals(this.f226359c) && !"main".equals(this.f226359c)) {
            if ("share".equals(this.f226359c)) {
                F();
            } else if (((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).isGuildFeedSchemeAction(this.f226359c)) {
                r();
            } else if ("openchannel".equals(this.f226359c)) {
                C();
            } else if ("open_live_channel".equals(this.f226359c)) {
                y(this.f226361e, false);
            } else if ("open_live_channel_share".equals(this.f226359c)) {
                y(this.f226361e, true);
            } else if ("aio_locate_msg".equals(this.f226359c)) {
                z(this.f226361e);
            } else if ("openH5".equals(this.f226359c)) {
                s();
            } else if ("init_team".equals(this.f226359c)) {
                p();
            } else if ("opendiscover".equals(this.f226359c)) {
                n();
            } else if ("open_recommend".equals(this.f226359c)) {
                o();
            } else if ("open_notice_detail".equals(this.f226359c)) {
                B(this.f226361e);
            } else if ("avdetaillist".equals(this.f226359c)) {
                k();
            } else if ("openProfileCard".equals(this.f226359c)) {
                D();
            } else if ("openFeedGallery".equals(this.f226359c)) {
                M();
            } else if ("open_manager".equals(this.f226359c)) {
                t(this.f226361e);
            } else if ("openhotlive?".equals(this.f226359c)) {
                w();
            } else if ("jumpToRecommendPage".equals(this.f226359c)) {
                E(this.f226361e);
            } else if ("edit_channel_home".equals(this.f226359c)) {
                l();
            } else if ("share_guild".equals(this.f226359c)) {
                P();
            } else if ("call_team".equals(this.f226359c)) {
                P();
            } else if ("invite_friends".equals(this.f226359c)) {
                P();
            } else if ("copy_guild_number".equals(this.f226359c)) {
                i();
            } else if ("generate_guild_qrcode".equals(this.f226359c)) {
                O();
            } else if ("remove_channel".equals(this.f226359c)) {
                K();
            } else if ("setting_super_administrator".equals(this.f226359c)) {
                R();
            } else if ("open_guild_profile".equals(this.f226359c)) {
                q();
            } else if ("open_url".equals(this.f226359c)) {
                S();
            } else if ("mange_risk_member".equals(this.f226359c)) {
                Q();
            } else if ("schedule_notify".equals(this.f226359c)) {
                ry1.b.f432950a.e(this.f226361e, this.f226358b);
            } else if ("navi_service".equals(this.f226359c)) {
                A(this.f226361e);
            } else if ("open_discussion_aggregation".equals(this.f226359c)) {
                L(this.f226361e);
            } else if ("role_list".equals(this.f226359c)) {
                R();
            } else {
                if (!"openGuildAISearch".equals(this.f226359c)) {
                    return false;
                }
                N();
            }
        } else {
            v();
        }
        return true;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.f226361e.entrySet()) {
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                bundle.putString(entry.getKey(), value);
            }
        }
        bundle.putString("pkg_name", this.f226362f.a());
        bundle.putString("pkg_sig", this.f226362f.b());
        bundle.putString("extra_raw_url", this.f226362f.c());
        return bundle;
    }

    public void m() {
        Intent intent = new Intent();
        Bundle h16 = h();
        h16.putString("extra_action", OperateCustomButton.OPERATE_CREATE);
        intent.putExtra("key_params", h16);
        u(intent);
    }

    public void u(Intent intent) {
        QPublicFragmentActivity.b.b(this.f226358b, intent, QPublicTransFragmentActivity.class, ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildOpenVerifyFragmentClass());
    }

    public void x() {
        Intent intent = new Intent();
        Bundle h16 = h();
        h16.putString("extra_action", IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE);
        intent.putExtra("key_params", h16);
        u(intent);
    }
}
