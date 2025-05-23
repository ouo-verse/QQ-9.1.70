package com.tencent.mobileqq.guild.profile.profilecard.audio;

import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.profile.profilecard.audio.o;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes14.dex */
public class GuildProfileAudioComponent extends AbsGuildProfileComponent implements View.OnClickListener, o.i {
    private static final String TAG = "Guild.profile.GuildProfileAudioComponent";
    private o mAudioViewModel;
    private GuildSecondaryAuthorityViewModel mAuthorityViewModel;
    private RelativeLayout mBanControl;
    private Switch mBanControlSwitch;
    private TextView mBanControlText;
    private RelativeLayout mInviteTalkControl;
    private TextView mInviteTalkTv;
    private ViewGroup mLlAudioArea;
    private TextView mMediaRoomBanText;
    private e12.a<Boolean> mMuteToMe;
    private RelativeLayout mRemoveChannelControl;
    private RelativeLayout mRemoveGameTeamControl;
    private RelativeLayout mRevokeTalkRightControl;
    private TextView mRevokeTalkRightControlText;
    private SeekBar mSeekBar;
    private RelativeLayout mSeekBarRl;
    private View mTvAudioArea;
    private RelativeLayout mVoiceControl;
    private Switch mVoiceControlSwitch;
    private TextView mVoiceControlText;
    private int mVolume;
    private IDynamicParams mVolumeReport;

    /* loaded from: classes14.dex */
    class a implements IDynamicParams {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
            hashMap.put("sgrp_subchannel_type", 2);
            hashMap.put("dt_pgid", "pg_sgrp_profile");
            hashMap.put("sgrp_voicechannel_profile_volume_volume", Integer.valueOf(GuildProfileAudioComponent.this.mVolume));
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool != null && !bool.booleanValue()) {
                GuildProfileAudioComponent.this.mSeekBarRl.setVisibility(0);
            } else {
                GuildProfileAudioComponent.this.mSeekBarRl.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class d implements Observer<com.tencent.mobileqq.guild.profile.profilecard.audio.a> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.guild.profile.profilecard.audio.a aVar) {
            GuildProfileAudioComponent.this.mVoiceControlText.setText(aVar.b());
            GuildProfileAudioComponent.this.mBanControlText.setText(aVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((AbsGuildProfileComponent) GuildProfileAudioComponent.this).mViewContainer.getLayoutParams();
            if (bool.booleanValue()) {
                marginLayoutParams.bottomMargin = ViewUtils.dip2px(12.0f);
            } else {
                marginLayoutParams.bottomMargin = ViewUtils.dip2px(24.0f);
            }
            ((AbsGuildProfileComponent) GuildProfileAudioComponent.this).mViewContainer.setLayoutParams(marginLayoutParams);
        }
    }

    public GuildProfileAudioComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        super(iGuildComponentController, guildProfileData);
        this.mVolume = bw.k0(this.mData.getGuildBaseProfileData().b());
        this.mMuteToMe = new e12.a<>(Boolean.FALSE);
        this.mVolumeReport = new a();
    }

    private void bindUI() {
        this.mLlAudioArea = (ViewGroup) this.mViewContainer.findViewById(R.id.wog);
        this.mTvAudioArea = this.mViewContainer.findViewById(R.id.x2v);
        this.mVoiceControl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f28070hy);
        this.mVoiceControlText = (TextView) this.mViewContainer.findViewById(R.id.f28090i0);
        this.mVoiceControlSwitch = (Switch) this.mViewContainer.findViewById(R.id.f28080hz);
        this.mBanControl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f27950hm);
        this.mBanControlText = (TextView) this.mViewContainer.findViewById(R.id.f27970ho);
        this.mBanControlSwitch = (Switch) this.mViewContainer.findViewById(R.id.f27960hn);
        this.mRemoveChannelControl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f28010hs);
        this.mMediaRoomBanText = (TextView) this.mViewContainer.findViewById(R.id.wqg);
        this.mInviteTalkControl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f27980hp);
        this.mInviteTalkTv = (TextView) this.mViewContainer.findViewById(R.id.f27990hq);
        this.mRevokeTalkRightControl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f28040hv);
        this.mRevokeTalkRightControlText = (TextView) this.mViewContainer.findViewById(R.id.f28050hw);
        this.mRemoveGameTeamControl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f28030hu);
        this.mSeekBar = (SeekBar) this.mViewContainer.findViewById(R.id.f12023790);
        this.mSeekBarRl = (RelativeLayout) this.mViewContainer.findViewById(R.id.f28100i1);
        this.mVoiceControlSwitch.setOnClickListener(this);
        this.mBanControlSwitch.setOnClickListener(this);
        this.mRemoveChannelControl.setOnClickListener(this);
        this.mInviteTalkControl.setOnClickListener(this);
        this.mRevokeTalkRightControl.setOnClickListener(this);
        this.mRemoveGameTeamControl.setOnClickListener(this);
        this.mSeekBar.setProgress(this.mVolume);
        this.mSeekBar.setOnSeekBarChangeListener(new b());
        this.mMuteToMe.observe(this.mFragment.getViewLifecycleOwner(), new c());
        setDtElement();
    }

    private void bindViewModel() {
        o oVar = (o) com.tencent.mobileqq.mvvm.h.b(this.mFragment, o.M).get(o.class);
        this.mAudioViewModel = oVar;
        oVar.B2(this.mData.getGuildBaseProfileData());
        this.mAudioViewModel.init(this.mApp);
        this.mAudioViewModel.h2().observe(this.mFragment, new d());
        this.mAudioViewModel.n2().observe(this.mFragment, new e());
        this.mAudioViewModel.i2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$0((Boolean) obj);
            }
        });
        this.mAudioViewModel.g2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$1((GuildAudioChannelData) obj);
            }
        });
        this.mAudioViewModel.E2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$2((com.tencent.mobileqq.guild.profile.profilecard.main.l) obj);
            }
        });
        this.mAudioViewModel.j2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$3((Integer) obj);
            }
        });
        this.mAudioViewModel.f2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$4((List) obj);
            }
        });
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
        this.mAuthorityViewModel = guildSecondaryAuthorityViewModel;
        guildSecondaryAuthorityViewModel.init(this.mData.getGuildBaseProfileData().e(), "GuildProfileAudioComponent");
        this.mAuthorityViewModel.getShowModifyVoiceChannel().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$5((Boolean) obj);
            }
        });
        this.mAuthorityViewModel.getNoticeAuthorityEnd().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.audio.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileAudioComponent.this.lambda$bindViewModel$6((Boolean) obj);
            }
        });
    }

    private boolean checkDstIsChannelAdmin(GuildAudioChannelData guildAudioChannelData) {
        boolean z16;
        String b16 = guildAudioChannelData.b();
        if (guildAudioChannelData.c() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<String> value = this.mAudioViewModel.f2().getValue();
        if (value != null && !value.isEmpty()) {
            boolean contains = value.contains(b16);
            if (!z16 && !contains) {
                return false;
            }
            return true;
        }
        return z16;
    }

    private boolean checkSelfIsChannelAdmin(GuildAudioChannelData guildAudioChannelData) {
        boolean z16;
        boolean z17;
        IGProChannelInfo channelInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getChannelInfo(guildAudioChannelData.a());
        if (channelInfo != null && channelInfo.isChannelOrCategoryAdmin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (guildAudioChannelData.k() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean a16 = r.p().getChannelPermission(channelInfo.getGuildId(), channelInfo.getChannelUin()).a(20012);
        if (!z16 && !z17 && !a16) {
            return false;
        }
        return true;
    }

    private boolean checkSelfIsChildAndCategory(GuildAudioChannelData guildAudioChannelData) {
        IGProChannelInfo channelInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getChannelInfo(guildAudioChannelData.a());
        return r.p().getChannelPermission(channelInfo.getGuildId(), channelInfo.getChannelUin()).j();
    }

    private void dismiss() {
        getComponentController().handleDismissAction();
    }

    private void handleNormalMode(String str) {
        com.tencent.mobileqq.guild.media.core.data.p g16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().g(str);
        if (g16 != null && !g16.f228101i) {
            this.mInviteTalkTv.setText(R.string.f140090d1);
            this.mInviteTalkControl.setVisibility(0);
            this.mRevokeTalkRightControl.setVisibility(8);
        }
    }

    private void handleRaiseHandMode(String str, String str2, String str3, boolean z16) {
        int i3;
        if (this.mAudioViewModel.j2().getValue().intValue() != 0) {
            this.mRevokeTalkRightControl.setVisibility(8);
            return;
        }
        if (!com.tencent.mobileqq.guild.media.core.j.a().T().i1(str, str2, str3)) {
            this.mInviteTalkTv.setText(R.string.f140090d1);
            this.mInviteTalkControl.setVisibility(0);
            this.mRevokeTalkRightControl.setVisibility(8);
            return;
        }
        this.mInviteTalkControl.setVisibility(8);
        this.mRevokeTalkRightControl.setVisibility(0);
        TextView textView = this.mRevokeTalkRightControlText;
        if (z16) {
            i3 = R.string.f140290dk;
        } else {
            i3 = R.string.f140300dl;
        }
        textView.setText(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$0(Boolean bool) {
        if (bool.booleanValue()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$2(com.tencent.mobileqq.guild.profile.profilecard.main.l lVar) {
        if (TextUtils.isEmpty(lVar.c())) {
            return;
        }
        if (lVar.d()) {
            ch.f1(lVar.c());
        } else {
            ch.t1(this.mFragment.getContext(), lVar.a(), lVar.c(), lVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$3(Integer num) {
        if (num.intValue() != -1 && this.mAudioViewModel.g2().getValue() != null) {
            lambda$bindViewModel$1(this.mAudioViewModel.g2().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$4(List list) {
        lambda$bindViewModel$1(this.mAudioViewModel.g2().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$5(Boolean bool) {
        int i3;
        RelativeLayout relativeLayout = this.mRemoveChannelControl;
        if (bool.booleanValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$6(Boolean bool) {
        QQGuildUIUtil.G(R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector, R.drawable.qui_common_fill_light_secondary_bg_selector, R.drawable.guild_qui_common_fill_light_secondary_bg_bottom_round_8_selector, R.drawable.qui_common_fill_light_secondary_round_8_bg_selector, this.mLlAudioArea);
    }

    private void onSwitchBan() {
        int i3;
        boolean f16 = this.mAudioViewModel.g2().getValue().f();
        this.mAudioViewModel.y2(f16);
        if (!f16) {
            GuildSpeakManageGuide.c(new GuildSpeakParamsInfo(this.mData.getGuildBaseProfileData().e(), this.mData.getGuildBaseProfileData().a(), null, 4), this.mData.getGuildBaseProfileData().e(), this.mData.getGuildBaseProfileData().b(), R.string.f1506115g);
        }
        HashMap hashMap = new HashMap();
        if (f16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("sgrp_switch_type", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", this.mBanControlSwitch, hashMap);
    }

    private void resetProfileCard() {
        this.mLlAudioArea.setVisibility(8);
        this.mTvAudioArea.setVisibility(8);
        this.mVoiceControl.setVisibility(8);
        this.mBanControl.setVisibility(8);
        this.mInviteTalkControl.setVisibility(8);
        this.mRevokeTalkRightControl.setVisibility(8);
        this.mRemoveChannelControl.setVisibility(8);
        this.mRemoveGameTeamControl.setVisibility(8);
    }

    private void setDtElement() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_subchannel_type", 2);
        hashMap.put("dt_pgid", "pg_sgrp_profile");
        hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickDynamicParams(this.mSeekBar, "em_sgrp_volume_touser", this.mVolumeReport);
        setDtElementsPolicy(this.mVoiceControlSwitch, "em_sgrp_profile_block", hashMap);
        setDtElementsPolicy(this.mBanControlSwitch, "em_sgrp_profile_avchannel_write", hashMap);
        setDtElementsPolicy(this.mInviteTalkControl, "em_sgrp_profile_invitetalk", hashMap);
        setDtElementsPolicy(this.mRevokeTalkRightControl, "em_sgrp_profile_invitetalk", hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.mRemoveChannelControl, "em_sgrp_profile_remove_trtc_channel", hashMap);
    }

    private void setDtElementsPolicy(View view, String str, HashMap<String, Object> hashMap) {
        ch.T0(view, str, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, hashMap);
    }

    private void showBanInChannelControl(boolean z16, boolean z17) {
        int i3;
        this.mBanControl.setVisibility(0);
        TextView textView = this.mBanControlText;
        if (z16) {
            i3 = R.string.f139920ck;
        } else {
            i3 = R.string.f139930cl;
        }
        textView.setText(i3);
        this.mBanControlSwitch.setChecked(z17);
    }

    private void showManageProfileCard(boolean z16, boolean z17, boolean z18, boolean z19) {
        this.mViewContainer.setVisibility(0);
        this.mLlAudioArea.setVisibility(0);
        this.mTvAudioArea.setVisibility(0);
        this.mRemoveChannelControl.setVisibility(0);
        this.mMediaRoomBanText.setVisibility(0);
        showVoiceControl(z18, z16);
        showBanInChannelControl(z18, z19);
        showRaiseHandControl(z18);
    }

    private void showMemberProfileCard(boolean z16, boolean z17) {
        int i3 = 0;
        this.mViewContainer.setVisibility(0);
        this.mLlAudioArea.setVisibility(0);
        this.mTvAudioArea.setVisibility(0);
        showVoiceControl(z17, z16);
        this.mBanControl.setVisibility(8);
        this.mInviteTalkControl.setVisibility(8);
        showRaiseHandControl(z17);
        boolean a16 = r.p().getChannelPermission(this.mData.getGuildBaseProfileData().e(), this.mData.getGuildBaseProfileData().a()).a(20012);
        RelativeLayout relativeLayout = this.mRemoveChannelControl;
        if (!a16) {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
    }

    private void showMyselfProfileCard() {
        this.mLlAudioArea.setVisibility(8);
        this.mTvAudioArea.setVisibility(8);
        this.mVoiceControl.setVisibility(8);
        this.mBanControl.setVisibility(8);
        this.mInviteTalkControl.setVisibility(8);
        this.mRevokeTalkRightControl.setVisibility(8);
        this.mRemoveChannelControl.setVisibility(8);
    }

    private void showOwnerOrOtherManageProfileCard(boolean z16, boolean z17, boolean z18) {
        this.mViewContainer.setVisibility(0);
        this.mLlAudioArea.setVisibility(0);
        this.mTvAudioArea.setVisibility(0);
        showVoiceControl(z18, z16);
        this.mRemoveChannelControl.setVisibility(8);
    }

    private void showRaiseHandControl(boolean z16) {
        boolean z17;
        String e16 = this.mData.getGuildBaseProfileData().e();
        String a16 = this.mData.getGuildBaseProfileData().a();
        if (ch.M(e16) == null) {
            QLog.d(TAG, 1, "showRaiseHandControl: guild info is null");
            return;
        }
        if (!r.p().getChannelPermission(e16, a16).a(20012)) {
            this.mInviteTalkControl.setVisibility(8);
            this.mRevokeTalkRightControl.setVisibility(8);
            QLog.d(TAG, 1, "showRaiseHandControl: selfIsAdminUser false");
            return;
        }
        if (!checkDstIsChannelAdmin(this.mAudioViewModel.g2().getValue()) && this.mAudioViewModel.g2().getValue().c() != 2) {
            if (!this.mData.getGuildBaseProfileData().p()) {
                return;
            }
            if (com.tencent.mobileqq.guild.media.core.j.a().d0().m1()) {
                this.mRevokeTalkRightControl.setVisibility(8);
                QLog.d(TAG, 1, "showRaiseHandControl: checkThirdAppTalkControl true");
                return;
            }
            IGProChannelInfo channelInfo = ((IGPSService) this.mApp.getRuntimeService(IGPSService.class, "")).getChannelInfo(a16);
            boolean z18 = false;
            if (channelInfo != null && channelInfo.getVoiceSpeakModeCfg().getSpeakMode() == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            String b16 = this.mData.getGuildBaseProfileData().b();
            if (z17) {
                if (!com.tencent.mobileqq.guild.media.core.j.a().N().T0(b16)) {
                    this.mInviteTalkTv.setText(R.string.f140080d0);
                    this.mInviteTalkControl.setVisibility(0);
                    this.mRevokeTalkRightControl.setVisibility(8);
                    return;
                }
                return;
            }
            if (MediaChannelUtils.f228046a.n(channelInfo.getChannelUin()) == 4) {
                z18 = true;
            }
            QLog.d(TAG, 1, "showRaiseHandControl: isAllowRaiseHand " + z18);
            if (z18) {
                handleRaiseHandMode(e16, a16, b16, z16);
                return;
            } else {
                handleNormalMode(b16);
                return;
            }
        }
        this.mInviteTalkControl.setVisibility(8);
        this.mRevokeTalkRightControl.setVisibility(8);
        QLog.d(TAG, 1, "showRaiseHandControl: dstIsAdminUser true");
    }

    private void showVoiceControl(boolean z16, boolean z17) {
        int i3;
        this.mVoiceControl.setVisibility(0);
        TextView textView = this.mVoiceControlText;
        if (z16) {
            i3 = R.string.f139860ce;
        } else {
            i3 = R.string.f139870cf;
        }
        textView.setText(i3);
        this.mVoiceControlSwitch.setChecked(!z17);
        this.mMuteToMe.setValue(Boolean.valueOf(!this.mVoiceControlSwitch.isChecked()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAudioProfileCardView, reason: merged with bridge method [inline-methods] */
    public void lambda$bindViewModel$1(GuildAudioChannelData guildAudioChannelData) {
        boolean z16;
        String j3 = guildAudioChannelData.j();
        int k3 = guildAudioChannelData.k();
        String b16 = guildAudioChannelData.b();
        int c16 = guildAudioChannelData.c();
        boolean g16 = guildAudioChannelData.g();
        boolean f16 = guildAudioChannelData.f();
        boolean f17 = guildAudioChannelData.f();
        boolean z17 = true;
        if (guildAudioChannelData.e() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!checkSelfIsChannelAdmin(guildAudioChannelData) || k3 == 2) {
            z17 = false;
        }
        boolean checkDstIsChannelAdmin = checkDstIsChannelAdmin(guildAudioChannelData);
        QLog.d(TAG, 4, "updateAudioProfileCardView: self[" + z17 + "] dst[" + checkDstIsChannelAdmin + "]");
        resetProfileCard();
        if (j3.equals(b16)) {
            showMyselfProfileCard();
        } else if ((z17 || k3 == 2) && c16 == 0 && !checkDstIsChannelAdmin) {
            showManageProfileCard(g16, f16, z16, f17);
            if (checkSelfIsChildAndCategory(guildAudioChannelData)) {
                this.mBanControl.setVisibility(8);
            }
        } else if (k3 == 2 && checkDstIsChannelAdmin) {
            showManageProfileCard(g16, f16, z16, f17);
        } else if (z17 && (checkDstIsChannelAdmin || c16 == 2)) {
            showOwnerOrOtherManageProfileCard(g16, f16, z16);
            if (c16 != 2) {
                showBanInChannelControl(z16, f17);
                showRaiseHandControl(z16);
            }
        } else {
            showMemberProfileCard(g16, z16);
        }
        if (com.tencent.mobileqq.guild.media.core.j.c().T().getValue().intValue() == 2 && !j3.equals(b16) && com.tencent.mobileqq.guild.media.core.j.c().o() && com.tencent.mobileqq.guild.media.core.j.c().n().getRoomInfo().getCaptainTinyId() == Long.parseLong(j3)) {
            this.mRemoveGameTeamControl.setVisibility(0);
        }
        QQGuildUIUtil.G(R.drawable.guild_qui_common_fill_light_secondary_bg_top_round_8_selector, R.drawable.qui_common_fill_light_secondary_bg_selector, R.drawable.guild_qui_common_fill_light_secondary_bg_bottom_round_8_selector, R.drawable.qui_common_fill_light_secondary_round_8_bg_selector, this.mLlAudioArea);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1001;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f1w;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f28080hz) {
            ((Vibrator) this.mFragment.getContext().getSystemService("vibrator")).vibrate(20L);
            onClickControlVoice(this.mVoiceControl);
        } else if (id5 == R.id.f28010hs) {
            this.mAudioViewModel.w2();
        } else if (id5 == R.id.f27980hp) {
            this.mAudioViewModel.v2();
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_set_speak_apply", 1);
            VideoReport.reportEvent("clck", this.mInviteTalkControl, hashMap);
        } else if (id5 == R.id.f28040hv) {
            this.mAudioViewModel.x2();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sgrp_set_speak_apply", 2);
            VideoReport.reportEvent("clck", this.mRevokeTalkRightControl, hashMap2);
        } else if (id5 == R.id.f27960hn) {
            ((Vibrator) this.mFragment.getContext().getSystemService("vibrator")).vibrate(20L);
            onSwitchBan();
        } else if (id5 == R.id.f28030hu) {
            this.mAudioViewModel.A2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onClickControlVoice(View view) {
        String b16 = this.mAudioViewModel.g2().getValue().b();
        int i3 = 1;
        boolean z16 = !this.mAudioViewModel.g2().getValue().g();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onClickControlVoice, tinyId[" + b16 + "], bVoiceless[" + z16 + "]");
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            i3 = 2;
        }
        hashMap.put("sgrp_switch_type", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", this.mVoiceControlSwitch, hashMap);
        this.mAudioViewModel.u2(z16);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        super.onCreate(fragment, appInterface, bundle);
        bindUI();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        this.mAudioViewModel.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.audio.o.i
    public void onRaiseHandStateUpdate() {
        lambda$bindViewModel$1(this.mAudioViewModel.g2().getValue());
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(GuildProfileData guildProfileData) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "onInitData viewContainer : " + this.mViewContainer);
        }
        if (this.mAudioViewModel == null) {
            bindViewModel();
            this.mAudioViewModel.C2((GuildAudioChannelData) guildProfileData.getExtras().getParcelable(GuildProfileData.KEY_CHANNEL_DATA));
            this.mAudioViewModel.D2(this);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onUpdateData(GuildProfileData guildProfileData) {
        QLog.i(TAG, 1, "onUpdateData: ");
        lambda$bindViewModel$1(this.mAudioViewModel.g2().getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            GuildProfileAudioComponent.this.mVolume = i3;
            VideoReport.reportEvent("clck", GuildProfileAudioComponent.this.mSeekBar, null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (NetworkUtil.isNetworkAvailable()) {
                com.tencent.mobileqq.guild.media.core.j.a().J().h(((AbsGuildProfileComponent) GuildProfileAudioComponent.this).mData.getGuildBaseProfileData().b(), GuildProfileAudioComponent.this.mVolume);
            } else {
                QQToast.makeText(((AbsGuildProfileComponent) GuildProfileAudioComponent.this).mApp.getApplicationContext(), R.string.f140530e8, 0).show();
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
    }
}
