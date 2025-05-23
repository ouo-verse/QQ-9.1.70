package com.tencent.mobileqq.guild.setting.channeldetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.manager.PanelState;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleUtils;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.setting.member.view.GuildLoadingMemberEmptyView;
import com.tencent.mobileqq.guild.setting.member.view.QQGuildColorMemberListView;
import com.tencent.mobileqq.guild.setting.member.view.j;
import com.tencent.mobileqq.guild.setting.member.view.o;
import com.tencent.mobileqq.guild.setting.member.viewmodel.GuildRoleMemberListViewModel;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildChannelBaseNavBar;
import com.tencent.mobileqq.guild.widget.GuildChannelBaseNavBarStyle;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildChannelDetailFragment extends QQGuildPaddingImmerseTitleBarFragment implements View.OnClickListener {
    private IGProGuildInfo F;
    private String G;
    private IGProChannelInfo H;
    private boolean I;
    private View J;
    private GuildLoadingMemberEmptyView K;
    private GuildChannelDetailHeadViewNew L;
    private QQGuildColorMemberListView M;
    private GuildRoleMemberListViewModel N;
    private i Q;
    private boolean T;
    private int U;
    private GuildMemberListFragment.PendingAction P = new GuildMemberListFragment.PendingAction();
    private boolean R = false;
    private boolean S = false;
    private boolean V = false;
    private final com.tencent.mobileqq.guild.avatar.a W = new com.tencent.mobileqq.guild.avatar.a(o.X, o.Y);
    private final GPServiceObserver X = new a();
    private final y Y = new b();
    private final RobotInfoFragment.a Z = new d();

    /* renamed from: a0, reason: collision with root package name */
    private final GuildProfileCard.e f233346a0 = new e();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        private void b() {
            QQGuildChannelDetailFragment.this.H = ((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(QQGuildChannelDetailFragment.this.G);
            if (QQGuildChannelDetailFragment.this.H == null && QQGuildChannelDetailFragment.this.T) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "checkoutNoChannelInfo");
                QQGuildChannelDetailFragment.this.Hh();
            }
        }

        private boolean e(String str) {
            if (QQGuildChannelDetailFragment.this.F != null && TextUtils.equals(QQGuildChannelDetailFragment.this.F.getGuildID(), str)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            if (QQGuildChannelDetailFragment.this.T && e(str)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onBeKickFromGuild");
                QQGuildChannelDetailFragment.this.Hh();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            super.onChannelListUpdated(str);
            if (!e(str)) {
                return;
            }
            b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(String str, HashSet<String> hashSet) {
            super.onChannelPermissionChanged(str, hashSet);
            if (e(str) && hashSet != null && hashSet.contains(QQGuildChannelDetailFragment.this.G)) {
                IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                QQGuildChannelDetailFragment.this.Zh(iGPSService.getGuildInfo(str), iGPSService.getChannelInfo(QQGuildChannelDetailFragment.this.G));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelVisibleChanged(String str, String str2, int i3, int i16) {
            super.onChannelVisibleChanged(str, str2, i3, i16);
            if (!e(str)) {
                return;
            }
            b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(String str) {
            if (QQGuildChannelDetailFragment.this.T && e(str)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onDeleteGuild");
                QQGuildChannelDetailFragment.this.Hh();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            if (QQGuildChannelDetailFragment.this.T && e(str)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onDestoryGuild");
                QQGuildChannelDetailFragment.this.Hh();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(String str, dx dxVar) {
            if (e(str)) {
                IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                QQGuildChannelDetailFragment.this.Zh(iGPSService.getGuildInfo(str), iGPSService.getChannelInfo(QQGuildChannelDetailFragment.this.G));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(String str, List<String> list) {
            if (QQGuildChannelDetailFragment.this.T && e(str)) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (QQGuildChannelDetailFragment.this.G.equals(it.next())) {
                        QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onPushChannelDestroy");
                        QQGuildChannelDetailFragment.this.Hh();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onQQMsgListChannelUpdated(List<Integer> list, List<fk> list2) {
            for (fk fkVar : list2) {
                if (fkVar != null && e(fkVar.getGuildId()) && TextUtils.equals(fkVar.getChannelId(), QQGuildChannelDetailFragment.this.G) && QQGuildChannelDetailFragment.this.L != null) {
                    QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onQQMsgListChannelUpdated");
                    QQGuildChannelDetailFragment.this.H = ((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(QQGuildChannelDetailFragment.this.G);
                    QQGuildChannelDetailFragment.this.L.I(QQGuildChannelDetailFragment.this.F, QQGuildChannelDetailFragment.this.H);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(String str) {
            if (QQGuildChannelDetailFragment.this.T && e(str)) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onRemoveGuild");
                QQGuildChannelDetailFragment.this.Hh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void t(String str, String str2, String str3) {
            super.t(str, str2, str3);
            if (QQGuildChannelDetailFragment.this.U == 3) {
                QQGuildChannelDetailFragment.this.Hh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (GuildSplitViewUtils.f235370a.n(getActivity())) {
            if (activity.getSupportFragmentManager().isStateSaved()) {
                QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "closeFragment waitToFinish, channelId = " + this.G);
                this.V = true;
                return;
            }
            activity.onBackPressed();
            return;
        }
        activity.finish();
    }

    private j.b Ih() {
        return new c();
    }

    private void Jh() {
        boolean z16;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "doOnResume appInterface is null, channelId = " + this.G);
            return;
        }
        if (this.V) {
            QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "doOnResume waitToFinish, channelId = " + this.G);
            getActivity().onBackPressed();
        }
        IGProChannelInfo channelInfo = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(String.valueOf(this.G));
        this.H = channelInfo;
        if (channelInfo == null) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "channelInfo is null, channelId = " + this.G);
            return;
        }
        if (channelInfo.getFinalMsgNotify() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.I = z16;
        fi();
        Zh(this.F, this.H);
        rh(this.H.getChannelName(), this.I);
        qh();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "[doOnResume] mChannelInfo: ", this.H);
        }
    }

    private Map<String, Object> Kh() {
        HashMap hashMap = new HashMap();
        if (Qh()) {
            hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("pgid", "pg_sgrp_sub_channel_info");
        hashMap.put("sgrp_duration_flag", 1);
        hashMap.put("sgrp_sub_channel_id", Integer.valueOf(this.H.getChannelUin()));
        hashMap.put("sgrp_sub_channel_name", this.H.getChannelName());
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(this.H.getType()));
        hashMap.put("sgrp_sub_channel_limit", String.valueOf(this.H.getTalkPermission()));
        IGProGuildInfo guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(this.H.getGuildId());
        if (guildInfo != null) {
            hashMap.put("sgrp_channel_id", guildInfo.getGuildID());
            hashMap.put("sgrp_user_type", Integer.valueOf(v.b(guildInfo.getUserType())));
        }
        return hashMap;
    }

    private int Lh(Context context, int i3, int i16) {
        return ie0.a.f().g(context, i3, i16);
    }

    private void Mh() {
        GuildRoleMemberListViewModel guildRoleMemberListViewModel;
        this.K.a();
        if (this.H != null && (guildRoleMemberListViewModel = this.N) != null && guildRoleMemberListViewModel.T1().getValue() != null && !this.N.T1().getValue().isEmpty()) {
            this.M.p(this.K);
        }
    }

    private void Nh() {
        IGProGuildInfo iGProGuildInfo = this.F;
        if (iGProGuildInfo != null) {
            if (iGProGuildInfo == null || iGProGuildInfo.getGuildID() != null) {
                GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = this.L;
                if (guildChannelDetailHeadViewNew != null) {
                    this.M.i(guildChannelDetailHeadViewNew);
                }
                this.M.l(this.F.getGuildID(), this.G, ch.v0(this.F), s.a().getGuildPermission(this.F.getGuildID()).a(100001), Ih());
                this.M.setDragEnable(false);
            }
        }
    }

    private void Oh() {
        GuildRoleMemberListViewModel guildRoleMemberListViewModel;
        QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "mRoleMemberViewModel bindLiveDataObservers :" + System.identityHashCode(this.N));
        if (this.H != null && (guildRoleMemberListViewModel = this.N) != null) {
            guildRoleMemberListViewModel.S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildChannelDetailFragment.this.Sh((Integer) obj);
                }
            });
            this.N.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildChannelDetailFragment.this.Th((List) obj);
                }
            });
            this.N.m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQGuildChannelDetailFragment.this.Uh((cf1.b) obj);
                }
            });
        }
    }

    private void Ph(ViewGroup viewGroup) {
        if (this.T) {
            Window window = requireActivity().getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), window);
        }
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            View findViewById = relativeLayout.findViewById(R.id.uzi);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, 0);
            }
            layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext());
            findViewById.setLayoutParams(layoutParams);
            if (QQTheme.isVasTheme()) {
                findViewById.setBackgroundResource(R.drawable.skin_header_bar_bg);
            } else {
                findViewById.setBackgroundColor(Lh(this.C.getContext(), R.color.qui_common_bg_bottom_light, 1000));
            }
            GuildThemeManager.i(!GuildThemeManager.f235286a.b(), requireActivity().getWindow());
            viewGroup.setPadding(viewGroup.getPaddingLeft(), 0, viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
    }

    private boolean Qh() {
        IGProChannelInfo iGProChannelInfo = this.H;
        if (iGProChannelInfo == null || iGProChannelInfo.getType() != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ GuildRoleMemberListViewModel Rh() {
        return new GuildRoleMemberListViewModel(this.F, this.G, r.f232798e, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sh(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() == 0) {
            ii();
        } else if (num.intValue() == 2) {
            Mh();
        } else if (3 == num.intValue()) {
            Mh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Th(List list) {
        Mh();
        this.M.setUIDataList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Uh(final cf1.b bVar) {
        if (bVar != null && bVar.f30775b != 0) {
            if (this.T) {
                QQToast.makeText(BaseApplication.context, 1, getString(R.string.f145790sf), 1).show();
            } else {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.QQGuildChannelDetailFragment.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QQGuildChannelDetailFragment.this.isAdded() && GuildMainFrameManager.g() == PanelState.THIRD_PANEL) {
                            SecurityTipHelperKt.E(QQGuildChannelDetailFragment.this.getContext(), bVar, QQGuildChannelDetailFragment.this.getString(R.string.f145790sf));
                        }
                    }
                }, 300L);
            }
        }
    }

    public static void Wh(AppInterface appInterface, Context context, String str, String str2, int i3) {
        IGProGuildInfo guildInfo;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (guildInfo = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(str)) != null && guildInfo.getGuildID() != null) {
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", str);
            intent.putExtra("extra_channel_id", str2);
            intent.putExtra("START_WITHOUT_MAIN_FRAME", true);
            intent.putExtra("extra_key_chatpie_container", i3);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            GuildSplitViewUtils.f235370a.o(context, intent, QQGuildChannelDetailFragment.class, LaunchMode.standard);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(String str, boolean z16) {
        this.P.setTinyId(str);
        this.P.setRobot(z16);
        if (z16) {
            RobotInfoFragment.xh(requireActivity(), this.G, this.F.getGuildID(), str, "", "1", false, this.Z, 15);
            return;
        }
        GuildProfileData guildProfileData = new GuildProfileData(this.F.getGuildID(), "", str, 0, 1);
        guildProfileData.getGuildBaseProfileData().r(this.G);
        guildProfileData.getGuildBaseProfileData().v(true);
        GuildProfileCard.Mh(requireActivity(), guildProfileData, this.f233346a0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci() {
        ch.Y0(this.L, "em_sgrp_sub_channel_member", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        if (Qh()) {
            hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
            hashMap.put("dt_pgid", "pg_sgrp_sub_channel_info");
        }
        VideoReport.reportEvent("clck", this.L, hashMap);
    }

    private void di() {
        if (!this.R) {
            com.tencent.mobileqq.guild.performance.report.o.c();
        }
    }

    private void ei() {
        View view = this.J;
        if (view == null) {
            return;
        }
        ch.Y0(view, "em_sgrp_set", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        if (Qh()) {
            hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
            hashMap.put("dt_pgid", "pg_sgrp_sub_channel_info");
        }
        VideoReport.reportEvent("clck", this.J, hashMap);
    }

    private void gi() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.E, "pg_sgrp_sub_channel_info");
        VideoReport.setPageReportPolicy(this.E, PageReportPolicy.REPORT_ALL);
        if (this.H == null) {
            QLog.w("Guild.MF.End.QQGuildChannelDetailFragment", 1, "setDtPage: mChannelInfo is null");
        } else {
            VideoReport.setPageParams(this.E, new PageParams((Map<String, ?>) Kh()));
        }
    }

    private void ii() {
        GuildRoleMemberListViewModel guildRoleMemberListViewModel;
        this.K.c();
        if (this.H != null && (guildRoleMemberListViewModel = this.N) != null && guildRoleMemberListViewModel.T1() != null) {
            if (this.N.T1().getValue() == null || this.N.T1().getValue().isEmpty()) {
                this.M.i(this.K);
            }
        }
    }

    private void initData() {
        boolean z16;
        IGProChannelInfo iGProChannelInfo = this.H;
        if (iGProChannelInfo == null) {
            QLog.e("Guild.MF.End.QQGuildChannelDetailFragment", 1, "initData but mChannelInfo == null");
            return;
        }
        if (this.F == null) {
            QLog.e("Guild.MF.End.QQGuildChannelDetailFragment", 1, "initData but mGuildInfo == null");
            return;
        }
        if (iGProChannelInfo.getFinalMsgNotify() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.I = z16;
        GuildRoleMemberListViewModel guildRoleMemberListViewModel = (GuildRoleMemberListViewModel) ef1.c.a(this, GuildRoleMemberListViewModel.class, new Function0() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                GuildRoleMemberListViewModel Rh;
                Rh = QQGuildChannelDetailFragment.this.Rh();
                return Rh;
            }
        });
        this.N = guildRoleMemberListViewModel;
        guildRoleMemberListViewModel.k2(this.W);
        QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "mRoleMemberViewModel inited " + System.identityHashCode(this.N));
        this.Q = new i(this);
        if (this.T) {
            this.R = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "initData isMsgNotifyOpen:" + this.I + "mIsWithoutMainframe:" + this.T + "mHasSlideOutAndShow:" + this.R);
        }
    }

    @RequiresApi(api = 21)
    private void initView() {
        IGProChannelInfo iGProChannelInfo;
        int i3;
        if (getActivity() != null && (iGProChannelInfo = this.H) != null) {
            rh(iGProChannelInfo.getChannelName(), this.I);
            RelativeLayout relativeLayout = this.D;
            if (relativeLayout != null) {
                View findViewById = relativeLayout.findViewById(R.id.w1n);
                this.J = findViewById;
                if (findViewById != null) {
                    if (as.j(this.H)) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    findViewById.setVisibility(i3);
                    this.J.setOnClickListener(this);
                }
            }
            GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = new GuildChannelDetailHeadViewNew(getActivity(), this.F, this.H, this.U, GuildChannelDetailHeadViewStyle.STYLE_SKIN);
            this.L = guildChannelDetailHeadViewNew;
            guildChannelDetailHeadViewNew.setContentView(this.E);
            this.K = new GuildLoadingMemberEmptyView(requireContext());
            QQGuildColorMemberListView qQGuildColorMemberListView = (QQGuildColorMemberListView) this.E.findViewById(R.id.wxc);
            this.M = qQGuildColorMemberListView;
            qQGuildColorMemberListView.setPreLoadHelper(this.W);
            Nh();
            Ph(this.D);
            ii();
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "initData mGuildInfo:" + this.F + "mChannelInfo:" + this.H + "mChatPieContainerType:" + this.U);
                return;
            }
            return;
        }
        QLog.e("Guild.MF.End.QQGuildChannelDetailFragment", 1, "[initView] context || mChannelInfo should not be null.");
    }

    public void Vh(View view) {
        if (QQGuildUIUtil.v()) {
            return;
        }
        ei();
        if (this.H != null && getAppInterface() != null && getActivity() != null) {
            if (as.j(this.H)) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(getAppInterface(), getActivity(), this.H.getGuildId(), this.H.getChannelUin(), 2);
                return;
            }
            QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "handleSettingClick not admin. guildId=" + getGuildId());
            return;
        }
        QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 1, "handleSettingClick error. guildId=" + getGuildId());
    }

    public void Yh() {
        this.S = false;
    }

    public void Zh(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "refreshHeader guildInfo:" + iGProGuildInfo + "guildInfo:" + iGProGuildInfo + "stack:" + QLog.getStackTraceString(new Exception()));
        }
        if (iGProGuildInfo != null && iGProChannelInfo != null) {
            this.F = iGProGuildInfo;
            this.H = iGProChannelInfo;
            int i3 = 0;
            boolean z16 = true;
            if (iGProChannelInfo.getFinalMsgNotify() != 1) {
                z16 = false;
            }
            this.I = z16;
            rh(iGProChannelInfo.getChannelName(), this.I);
            View view = this.J;
            if (view != null) {
                if (!as.j(this.H)) {
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
            GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = this.L;
            if (guildChannelDetailHeadViewNew != null) {
                guildChannelDetailHeadViewNew.I(iGProGuildInfo, iGProChannelInfo);
            }
        }
    }

    public void ai(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "refreshMemberList guildInfo:" + iGProGuildInfo + "channelInfo:" + iGProChannelInfo + "stack:" + QLog.getStackTraceString(new Exception()));
        }
        if (iGProGuildInfo != null && iGProChannelInfo != null) {
            this.F = iGProGuildInfo;
            this.H = iGProChannelInfo;
            fi();
        }
    }

    public void bi(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "refreshPendingActionUser keepPending:" + z16 + "mPendingAction:" + this.P + "stack:" + QLog.getStackTraceString(new Exception()));
        }
        if (!this.P.getTinyId().isEmpty()) {
            this.N.i2(this.P);
            if (!z16) {
                this.P.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment
    @RequiresApi(api = 21)
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initData();
        initView();
        Oh();
        gi();
        GuildSplitViewUtils.f235370a.B(this.D);
        QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "doOnCreateView: " + hashCode() + "  channelId: " + this.G);
    }

    public void fi() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "resetMemberList: " + QLog.getStackTraceString(new Exception()));
        }
        di();
        if (this.N == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.End.QQGuildChannelDetailFragment", 2, "resetMemberList");
        }
        this.N.refresh();
        ii();
        i iVar = this.Q;
        if (iVar != null) {
            iVar.q();
        }
    }

    public String getChannelId() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ehv;
    }

    public String getGuildId() {
        IGProGuildInfo iGProGuildInfo = this.F;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo.getGuildID();
        }
        return null;
    }

    public void hi() {
        this.R = true;
        this.S = true;
        qh();
    }

    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        if (guildSplitViewUtils.n(getQBaseActivity())) {
            return guildSplitViewUtils.t(getQBaseActivity(), false);
        }
        com.tencent.mobileqq.guild.mainframe.s p16 = GuildMainFrameUtils.p(getQBaseActivity());
        if (p16 != null) {
            p16.guildCenterPanelInOrOut(1, true);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.J) {
            Vh(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.G = arguments.getString("extra_channel_id");
            boolean z16 = false;
            this.T = arguments.getBoolean("START_WITHOUT_MAIN_FRAME", false);
            this.U = arguments.getInt("extra_key_chatpie_container", 0);
            this.V = false;
            AppInterface appInterface = getAppInterface();
            if (appInterface != null) {
                this.F = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(arguments.getString("extra_guild_id"));
                IGPSService iGPSService = (IGPSService) appInterface.getRuntimeService(IGPSService.class, "");
                this.H = iGPSService.getChannelInfo(String.valueOf(this.G));
                iGPSService.addObserver(this.X);
                com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.Y);
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("appInterface is null, activity is null: ");
                if (getActivity() == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.e("Guild.MF.End.QQGuildChannelDetailFragment", 1, sb5.toString());
            }
            if (this.H == null) {
                QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "channelInfo is null, channelId = " + this.G);
            }
            if (this.F == null) {
                QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "mGuildInfo is null, channelId = " + arguments.getString("extra_guild_id"));
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 2, "onCreate argument:" + arguments);
            }
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onCreate: " + hashCode() + "  channelId: " + this.G);
            return;
        }
        throw new RuntimeException("bundle should not be null.");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onDestroy: " + hashCode() + "  channelId: " + this.G);
        QQGuildColorMemberListView qQGuildColorMemberListView = this.M;
        if (qQGuildColorMemberListView != null) {
            qQGuildColorMemberListView.o();
        }
        i iVar = this.Q;
        if (iVar != null) {
            iVar.n();
        }
        if (getAppInterface() != null) {
            ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).deleteObserver(this.X);
        }
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.Y);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onDestroyView: " + hashCode() + "  channelId: " + this.G);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.R) {
            Jh();
        }
    }

    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment
    protected void qh() {
        this.C.setBarStyle(GuildChannelBaseNavBarStyle.STYLE_SKIN);
        if (QQTheme.isVasTheme()) {
            this.C.setBackgroundResource(R.drawable.skin_header_bar_bg);
        } else {
            GuildChannelBaseNavBar guildChannelBaseNavBar = this.C;
            guildChannelBaseNavBar.setBackgroundColor(Lh(guildChannelBaseNavBar.getContext(), R.color.qui_common_bg_bottom_light, 1000));
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.End.QQGuildChannelDetailFragment", 1, "initNavBarAndTitleBarColor");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment
    public void rh(CharSequence charSequence, boolean z16) {
        super.rh(charSequence, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements j.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void c() {
            QQGuildChannelDetailFragment.this.N.loadMore();
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void d(IGProUserInfo iGProUserInfo, boolean z16) {
            QQGuildChannelDetailFragment.this.ci();
            QQGuildChannelDetailFragment.this.Xh(iGProUserInfo.getTinyId(), z16);
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void e() {
            FragmentActivity activity = QQGuildChannelDetailFragment.this.getActivity();
            if (activity != null && !activity.isFinishing()) {
                GuildLevelRoleUtils.a(activity, QQGuildChannelDetailFragment.this.F.getGuildID(), 6);
            } else {
                QLog.e("Guild.MF.End.QQGuildChannelDetailFragment", 1, "onLVRoleCLick but activity is null or finishing");
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void a() {
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void b(List<IGProUserInfo> list) {
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void f(j.c cVar) {
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void g(j.c cVar, boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements RobotInfoFragment.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void b(boolean z16) {
            QQGuildChannelDetailFragment.this.bi(true);
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements GuildProfileCard.e {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void b() {
            QQGuildChannelDetailFragment.this.bi(true);
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public /* synthetic */ void c() {
            com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.h.a(this);
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void a() {
        }
    }
}
