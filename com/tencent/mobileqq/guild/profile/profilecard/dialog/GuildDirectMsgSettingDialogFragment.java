package com.tencent.mobileqq.guild.profile.profilecard.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildProfileSettingDialogHideEvent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildProfileSettingDialogShowEvent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildConfirmDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildDirectMsgSettingDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.manage.GuildProfileManageComponent;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildSettingMuteAllItemLayout;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.widget.Switch;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.MobileQQ;
import vp1.aj;
import yv1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDirectMsgSettingDialogFragment extends BottomSheetDialogFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, GuildConfirmDialogFragment.a, SimpleEventReceiver<SimpleBaseEvent> {
    private GuildBaseProfileData C;
    private GuildProfileData D;
    private boolean E;
    private boolean F;
    private String G;
    private boolean H;
    private View I;
    private GuildSettingMuteAllItemLayout J;
    private LinearLayout K;
    private Switch L;
    private uv1.a M;
    private GuildUserAvatarView N;
    private TextView P;
    private GuildSecondaryAuthorityViewModel Q;
    private f R;
    private WeakReference<d> S;
    private aj T;
    private final Observer<Long> U = new a();
    private final GPServiceObserver V = new b();
    private IGuildComponentController W;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<Long> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            if (GuildDirectMsgSettingDialogFragment.this.C != null) {
                GuildDirectMsgSettingDialogFragment guildDirectMsgSettingDialogFragment = GuildDirectMsgSettingDialogFragment.this;
                if (guildDirectMsgSettingDialogFragment.Gh(guildDirectMsgSettingDialogFragment.C.c())) {
                    GuildDirectMsgSettingDialogFragment.this.J.setValue("");
                    return;
                }
            }
            GuildDirectMsgSettingDialogFragment.this.J.setValue(com.tencent.mobileqq.guild.setting.mute.c.y(l3.longValue()));
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int i3, String str, String str2, String str3, ev evVar) {
            if (TextUtils.equals(GuildDirectMsgSettingDialogFragment.this.C.b(), str3) && TextUtils.equals(GuildDirectMsgSettingDialogFragment.this.C.e(), str2)) {
                FragmentActivity activity = GuildDirectMsgSettingDialogFragment.this.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    if (i3 == 0) {
                        GuildDirectMsgSettingDialogFragment.this.Qh(evVar);
                        GuildDirectMsgSettingDialogFragment guildDirectMsgSettingDialogFragment = GuildDirectMsgSettingDialogFragment.this;
                        guildDirectMsgSettingDialogFragment.Sh(guildDirectMsgSettingDialogFragment.D);
                        return;
                    }
                    QLog.e("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "onUserProfileInfoUpdate fail, result: " + i3 + ", errMsg: " + str + ", guildId: " + str2 + ", tinyId: " + str3);
                    return;
                }
                QLog.w("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "onUserProfileInfoUpdate activity is finishing");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements IGuildComponentController.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController.a
        public View getRootView() {
            return GuildDirectMsgSettingDialogFragment.this.I;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void onDismissed();
    }

    private String Ah(QBaseActivity qBaseActivity, String str, String str2) {
        long j3;
        IGProChannelInfo channelInfo = ((IGPSService) qBaseActivity.getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        String str3 = "channel_id=" + str + "|tinyid=" + str2;
        if (channelInfo != null) {
            j3 = channelInfo.getLiveRoomId();
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            return str3 + "|roomid=" + j3;
        }
        return str3;
    }

    private int Bh() {
        GuildProfileData guildProfileData = this.D;
        if (guildProfileData != null && guildProfileData.getExtras() != null && this.D.getExtras().getBoolean("open_profile_card_by_live_host")) {
            return TVKEventId.PLAYER_STATE_START_SEEK;
        }
        return TVKEventId.PLAYER_STATE_SEEK_COMPLETE;
    }

    private int Ch() {
        if (TextUtils.equals(this.C.j(), this.C.b())) {
            return 1;
        }
        return 0;
    }

    private void Dh() {
        boolean z16;
        boolean z17;
        if (QBaseActivity.sTopActivity == null) {
            QLog.e("Guild.profile.GuildDirectMsgSettingDialogFragment", 2, "handleJubaoClick\uff1a activity is null");
            return;
        }
        if (this.C.f() == 1) {
            ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuild(QBaseActivity.sTopActivity, this.C.e(), this.C.a(), TVKEventId.PLAYER_STATE_END_BUFFERING, this.C.b(), String.format("roomid=%s|tinyid=%s", this.C.a(), this.C.b()));
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_touin", this.C.b());
            hashMap.put("sgrp_channel_id_report", this.C.e());
            hashMap.put("sgrp_subchannel_type", 2);
            hashMap.put("sgrp_subchannel_id_report", this.C.a());
            VideoReport.reportEvent("clck", this.K, hashMap);
        } else if (this.C.f() == 2) {
            ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuild(QBaseActivity.sTopActivity, this.C.e(), this.C.a(), Bh(), this.C.b(), Ah(QBaseActivity.sTopActivity, this.C.a(), this.C.b()));
        } else if (this.D.getFeedImpeachData() != null) {
            FeedImpeachData feedImpeachData = this.D.getFeedImpeachData();
            String feedContentId = feedImpeachData.getFeedContentId();
            int feedReportScene = feedImpeachData.getFeedReportScene();
            String e16 = this.C.e();
            String a16 = this.C.a();
            String b16 = this.C.b();
            QLog.i("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "FeedImpeach contentId:" + feedContentId + " feedReportScene:" + feedReportScene + " guildId:" + e16 + " channelId:" + a16 + " dstTinyId:" + b16);
            ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuild(QBaseActivity.sTopActivity, e16, a16, feedReportScene, b16, feedContentId);
        } else {
            if ((this.C.g() == 1 && !this.C.m()) || this.C.g() == 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            String e17 = this.C.e();
            String a17 = this.C.a();
            if (this.F) {
                e17 = getArguments().getBundle("extra").getString(AppConstants.Key.GUILD_DIRECT_MESSAGE_GUILD_ID, e17);
                a17 = getArguments().getBundle("extra").getString(AppConstants.Key.GUILD_DIRECT_MESSAGE_CHANNEL_ID, a17);
            }
            String str = e17;
            String str2 = a17;
            if (!z16 && !TextUtils.isEmpty(str2) && !TextUtils.equals("0", str2)) {
                z17 = false;
            } else {
                z17 = true;
            }
            ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuild(QBaseActivity.sTopActivity, str, str2, this.C.b(), z17, this.F);
        }
        dismiss();
    }

    private void Eh() {
        String e16 = this.C.e();
        String a16 = this.C.a();
        if (this.F) {
            e16 = getArguments().getBundle("extra").getString(AppConstants.Key.GUILD_DIRECT_MESSAGE_GUILD_ID, e16);
            a16 = getArguments().getBundle("extra").getString(AppConstants.Key.GUILD_DIRECT_MESSAGE_CHANNEL_ID, a16);
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openMuteUserSetting(getActivity(), e16, a16, this.C.b(), this.C.g());
        dismiss();
    }

    private void Fh(Fragment fragment, AppInterface appInterface) {
        com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.a aVar = new com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.a(wv1.a.c(this.D));
        this.W = aVar;
        aVar.init(fragment, this.D, new c());
        ((GuildProfileManageComponent) this.W.getComponent(1002)).setContentView(this.T.f442225e);
        this.W.setContentViewContainer(this.T.f442224d);
        this.W.onCreate(fragment, appInterface, null);
        this.W.onInitData(this.D);
        this.W.setDismissAction(new xv1.b() { // from class: yv1.c
            @Override // xv1.b
            public final void onDismiss() {
                GuildDirectMsgSettingDialogFragment.this.Ih();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gh(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean Hh() {
        int k3 = this.C.k();
        if (k3 == 2 || k3 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih() {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(Boolean bool) {
        boolean z16;
        if (bool.booleanValue() && !this.H) {
            z16 = true;
        } else {
            z16 = false;
        }
        Ph(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(Boolean bool) {
        this.M.a(bool.booleanValue());
        this.C.w(bool.booleanValue());
    }

    private void Lh() {
        this.M.a(this.C.n());
    }

    private void Nh() {
        Switch r06 = this.L;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.Y0(r06, "em_sgrp_profile_private_block", clickPolicy, exposurePolicy);
        ch.Y0(this.J, "em_sgrp_mute_member", ClickPolicy.REPORT_ALL, exposurePolicy);
        HashMap hashMap = new HashMap();
        if (this.C.f() == 1) {
            hashMap.putAll(j.a().f0().O());
            hashMap.put("dt_pgid", "pg_sgrp_profile");
        }
        ch.T0(this.K, "em_sgrp_report", clickPolicy, exposurePolicy, hashMap);
    }

    private void Oh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.I, "pg_sgrp_profile");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_user_type", Integer.valueOf(v.b(this.C.k())));
        hashMap.put("sgrp_user_master", Integer.valueOf(Ch()));
        hashMap.put("sgrp_profile_scene", Integer.valueOf(this.C.g()));
        hashMap.put("sgrp_channel_id", this.C.e());
        hashMap.put("sgrp_profile_userid", this.C.b());
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        w.b(hashMap);
        VideoReport.setPageParams(this.I, new PageParams(hashMap));
    }

    private void Ph(boolean z16) {
        int i3;
        int i16;
        GuildSettingMuteAllItemLayout guildSettingMuteAllItemLayout = this.J;
        int i17 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        guildSettingMuteAllItemLayout.setVisibility(i3);
        LinearLayout linearLayout = this.T.f442226f;
        if (z16) {
            i16 = R.drawable.qui_common_fill_light_secondary_bg_selector;
        } else {
            i16 = R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector;
        }
        linearLayout.setBackgroundResource(i16);
        ImageView imageView = this.T.f442229i;
        if (!z16) {
            i17 = 8;
        }
        imageView.setVisibility(i17);
        Th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(ev evVar) {
        boolean z16;
        this.D.setUserProfileInfo(evVar);
        GuildBaseProfileData guildBaseProfileData = this.D.getGuildBaseProfileData();
        guildBaseProfileData.t(evVar.getUserType());
        if (evVar.getIsMember() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildBaseProfileData.x(z16);
        guildBaseProfileData.w(evVar.n());
    }

    public static GuildDirectMsgSettingDialogFragment Rh(FragmentManager fragmentManager, @NonNull String str, @NonNull GuildProfileData guildProfileData, Bundle bundle) {
        QLog.i("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "show GuildDirectMsgSettingDialogFragment profileData :" + guildProfileData);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("guildProfileData", guildProfileData);
        bundle2.putString(CommonConstant.KEY_DISPLAY_NAME, str);
        bundle2.putBundle("extra", bundle);
        GuildDirectMsgSettingDialogFragment guildDirectMsgSettingDialogFragment = new GuildDirectMsgSettingDialogFragment();
        guildDirectMsgSettingDialogFragment.setArguments(bundle2);
        guildDirectMsgSettingDialogFragment.show(fragmentManager, "Guild.profile.GuildDirectMsgSettingDialogFragment");
        return guildDirectMsgSettingDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(GuildProfileData guildProfileData) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            IGuildComponentController iGuildComponentController = this.W;
            if (iGuildComponentController != null) {
                iGuildComponentController.onUpdateData(guildProfileData);
                return;
            }
            Fh(this, (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                this.W.onResume();
                return;
            }
            return;
        }
        QLog.w("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "activity is null or finishing!");
    }

    private void Th() {
        int i3;
        LinearLayout linearLayout = this.K;
        if (this.J.getVisibility() != 0 && this.T.f442226f.getVisibility() != 0) {
            i3 = R.drawable.qui_common_fill_light_secondary_round_8_bg_selector;
        } else {
            i3 = R.drawable.guild_qui_common_fill_light_secondary_bg_bottom_round_8_selector;
        }
        linearLayout.setBackgroundResource(i3);
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.e("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "initData error: bundle is null");
            dismiss();
            return;
        }
        GuildProfileData guildProfileData = (GuildProfileData) arguments.getParcelable("guildProfileData");
        this.D = guildProfileData;
        this.C = guildProfileData.getGuildBaseProfileData();
        this.E = arguments.getBundle("extra").getBoolean("show_block_switch", true);
        this.F = arguments.getBundle("extra").getBoolean("from_direct_message", false);
        this.G = arguments.getString(CommonConstant.KEY_DISPLAY_NAME);
        this.H = arguments.getBundle("extra").getBoolean("isSelf");
        if (this.C == null) {
            QLog.e("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "initData error: mProfileData is null");
            dismiss();
            return;
        }
        QLog.i("Guild.profile.GuildDirectMsgSettingDialogFragment", 1, "initData params: " + this.C + ", extra: " + arguments.getBundle("extra"));
        Sh(this.D);
        ((IGPSService) ch.R0(IGPSService.class)).refreshGuildUserProfileInfo(this.C.e(), this.C.b());
    }

    private void initView() {
        int i3;
        this.J = (GuildSettingMuteAllItemLayout) this.I.findViewById(R.id.x4g);
        this.K = (LinearLayout) this.I.findViewById(R.id.yam);
        Switch r06 = (Switch) this.I.findViewById(R.id.t8z);
        this.L = r06;
        this.M = new uv1.a(r06, this);
        this.N = (GuildUserAvatarView) this.I.findViewById(R.id.a38);
        this.P = (TextView) this.I.findViewById(R.id.f5q);
        LinearLayout linearLayout = this.T.f442226f;
        boolean z16 = false;
        if (this.E && !this.H) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        aj ajVar = this.T;
        ajVar.f442227g.setVisibility(ajVar.f442226f.getVisibility());
        if (!this.F) {
            if (Hh() && !this.H) {
                z16 = true;
            }
            Ph(z16);
        } else {
            Ph(false);
        }
        if (this.H) {
            this.T.f442227g.setVisibility(8);
            this.K.setVisibility(8);
        }
        Th();
        Lh();
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.N.setAvatarTinyId(this.C.e(), this.C.b());
        if (TextUtils.isEmpty(this.G)) {
            this.G = QQGuildUIUtil.r(R.string.f143020ky);
        }
        this.P.setText(this.G);
    }

    private void initViewModel() {
        if (!this.F) {
            GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
            this.Q = guildSecondaryAuthorityViewModel;
            guildSecondaryAuthorityViewModel.init(this.C.e(), "GuildDirectMsgSettingDialogFragment");
            this.Q.getShowForbiddenWords().observe(this, new Observer() { // from class: yv1.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildDirectMsgSettingDialogFragment.this.Jh((Boolean) obj);
                }
            });
        }
        if (this.E) {
            f S1 = f.S1(this);
            this.R = S1;
            S1.P1().observe(this, new Observer() { // from class: yv1.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildDirectMsgSettingDialogFragment.this.Kh((Boolean) obj);
                }
            });
            this.R.Q1(this.C.e(), this.C.b());
        }
    }

    private void zh() {
        int i3;
        HashMap hashMap = new HashMap();
        if (this.L.isChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_private_block", Integer.valueOf(i3));
        VideoReport.reportEvent("dt_clck", this.L, hashMap);
    }

    public void Mh(d dVar) {
        this.S = new WeakReference<>(dVar);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildConfirmDialogFragment.a
    public void g8(boolean z16) {
        if (z16) {
            this.R.T1(this.C.b(), true);
        } else {
            Lh();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>(Arrays.asList(GuildProfileSettingDialogHideEvent.class, GuildProfileSettingDialogShowEvent.class));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (getActivity() != null) {
            if (z16) {
                GuildConfirmDialogFragment.rh(getActivity(), false, this);
            } else {
                this.R.T1(this.C.b(), false);
            }
            zh();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.K) {
            Dh();
        } else if (view == this.J) {
            Eh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IGuildComponentController iGuildComponentController = this.W;
        if (iGuildComponentController != null) {
            iGuildComponentController.onConfigurationChanged();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        aj g16 = aj.g(layoutInflater, viewGroup, false);
        this.T = g16;
        this.I = g16.getRoot();
        initData();
        initView();
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.V);
        SimpleEventBus.getInstance().registerReceiver(this);
        View view = this.I;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IGuildComponentController iGuildComponentController = this.W;
        if (iGuildComponentController != null) {
            iGuildComponentController.onDestroy();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.V);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        WeakReference<d> weakReference = this.S;
        if (weakReference != null && weakReference.get() != null) {
            this.S.get().onDismissed();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.mobileqq.guild.setting.mute.c.J(this.C.e(), this.C.b()).removeObserver(this.U);
        IGuildComponentController iGuildComponentController = this.W;
        if (iGuildComponentController != null) {
            iGuildComponentController.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildProfileSettingDialogHideEvent) {
            if (getDialog() != null) {
                getDialog().hide();
            }
        } else if ((simpleBaseEvent instanceof GuildProfileSettingDialogShowEvent) && getDialog() != null) {
            getDialog().show();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.guild.setting.mute.c.J(this.C.e(), this.C.b()).observe(this, this.U);
        IGuildComponentController iGuildComponentController = this.W;
        if (iGuildComponentController != null) {
            iGuildComponentController.onResume();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.I.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initViewModel();
        Oh();
        Nh();
    }
}
