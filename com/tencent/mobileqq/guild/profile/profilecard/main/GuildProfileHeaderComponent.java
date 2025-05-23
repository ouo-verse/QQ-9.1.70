package com.tencent.mobileqq.guild.profile.profilecard.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import aw1.MedalItem;
import aw1.k;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.base.GuildBlankActivity;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.q;
import com.tencent.mobileqq.guild.profile.me.avatar.GuildCheckAvatarFragment;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildDirectMsgSettingDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.widget.GiftLayout;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.FlowLayout;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.em;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Triple;
import vp1.cr;

/* loaded from: classes14.dex */
public class GuildProfileHeaderComponent extends AbsGuildProfileComponent implements View.OnClickListener, GuildDirectMsgSettingDialogFragment.d {
    private static final int MEDAL_HORIZONTAL_SPACING = 11;
    private static final int SHOW_MEDAL_MAX_COUNT = 3;
    private static final String TAG = "Guild.profile.GuildProfileHeaderComponent";
    private static final int TOP_BANNER_ALPHA_DELAY = 125;
    private static final int TOP_BANNER_ALPHA_DURATION = 500;
    private static final float TOP_BANNER_ASPECT_RATIO = 0.16329706f;
    private TextView mBaseInfoText;
    protected View mDividerLine;
    private GiftLayout mGiftView;
    private ViewStub mGiftViewStub;
    private k mHeaderVModel;
    private GuildUserAvatarViewWithPendant mIvAvatar;
    private ImageView mIvMore;
    private View mIvMuteState;
    private aw1.g mMedalAdapter;
    private FlowLayout mMedalView;
    private ImageView mNewSvipIcon;
    private ViewGroup mProfileContentContainer;
    private View mQQProfile;
    protected aw1.k mRoleGroupAdapter;
    private FlowLayout mRoleGroupLayout;
    private ImageView mSigningView;
    private ImageView mTopBanner;
    private FrameLayout mTopBannerContainer;
    private TextView mTvName;
    private final Observer<Triple<String, String, Boolean>> mUserAdminChangeObserver;
    private final Observer<String> mUserGuildStateChange;

    /* loaded from: classes14.dex */
    class a implements Observer<String> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            GuildHeaderData value;
            long longValue;
            if (str != null && GuildProfileHeaderComponent.this.mHeaderVModel != null && GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData() != null) {
                String e16 = GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().e();
                String b16 = GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().b();
                if (str.equals(b16) && (value = GuildProfileHeaderComponent.this.mHeaderVModel.U1().getValue()) != null) {
                    Long value2 = com.tencent.mobileqq.guild.setting.mute.c.J(e16, b16).getValue();
                    if (value2 == null) {
                        longValue = 0;
                    } else {
                        longValue = value2.longValue();
                    }
                    value.y(longValue);
                    GuildProfileHeaderComponent.this.updateUserGuildMuteState();
                }
            }
        }
    }

    /* loaded from: classes14.dex */
    class b implements Observer<Triple<String, String, Boolean>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Triple<String, String, Boolean> triple) {
            if (triple != null && GuildProfileHeaderComponent.this.mHeaderVModel != null && GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData() != null) {
                String e16 = GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().e();
                String b16 = GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().b();
                if (triple.getFirst().equals(e16) && triple.getSecond().equals(b16)) {
                    GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().t(triple.getThird().booleanValue() ? 1 : 0);
                    GuildProfileHeaderComponent.this.updateUserGuildMuteState();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_touin", GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().j());
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(GuildProfileHeaderComponent.this.mNewSvipIcon, "em_sgrp_svip_medal", "clck", hashMap);
            GuildJumpUtil.v(GuildProfileHeaderComponent.this.mNewSvipIcon.getContext(), ig1.a.b(GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().e(), GuildProfileHeaderComponent.this.mHeaderVModel.getGuildBaseProfileData().a()));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ em f231523d;

        d(em emVar) {
            this.f231523d = emVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            new r12.e(((AbsGuildProfileComponent) GuildProfileHeaderComponent.this).mFragment.getContext(), new MedalItem(this.f231523d.getUrl(), this.f231523d.getDesc())).b(GuildProfileHeaderComponent.this.mSigningView);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildProfileHeaderComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        super(iGuildComponentController, guildProfileData);
        this.mUserGuildStateChange = new a();
        this.mUserAdminChangeObserver = new b();
    }

    private void bindUI() {
        this.mIvMore = (ImageView) this.mViewContainer.findViewById(R.id.wue);
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = (GuildUserAvatarViewWithPendant) this.mViewContainer.findViewById(R.id.f166222z25);
        this.mIvAvatar = guildUserAvatarViewWithPendant;
        guildUserAvatarViewWithPendant.setOnClickListener(this);
        this.mIvAvatar.setLogTag(TAG);
        VideoReport.setElementEndExposePolicy(this.mIvAvatar, EndExposurePolicy.REPORT_ALL);
        this.mIvMuteState = this.mViewContainer.findViewById(R.id.wuf);
        this.mTvName = (TextView) this.mViewContainer.findViewById(R.id.eos);
        this.mBaseInfoText = (TextView) this.mViewContainer.findViewById(R.id.f165593wu3);
        this.mGiftViewStub = (ViewStub) this.mViewContainer.findViewById(R.id.wu8);
        this.mNewSvipIcon = (ImageView) this.mViewContainer.findViewById(R.id.f28190i_);
        this.mTopBannerContainer = (FrameLayout) this.mViewContainer.findViewById(R.id.f99745qm);
        this.mProfileContentContainer = (ViewGroup) this.mViewContainer.findViewById(R.id.f28120i3);
        this.mTopBannerContainer.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildProfileHeaderComponent.this.lambda$bindUI$4();
            }
        }, 125L);
        this.mTopBanner = (ImageView) this.mViewContainer.findViewById(R.id.f99735ql);
        FlowLayout flowLayout = (FlowLayout) this.mViewContainer.findViewById(R.id.wub);
        this.mMedalView = flowLayout;
        flowLayout.setHorizontalSpacing(11);
        this.mSigningView = (ImageView) this.mViewContainer.findViewById(R.id.f85484p3);
        View findViewById = this.mViewContainer.findViewById(R.id.f61862z_);
        this.mQQProfile = findViewById;
        findViewById.setOnClickListener(this);
        this.mTvName.getPaint().setFakeBoldText(true);
        this.mIvMore.setOnClickListener(this);
        if (!this.mData.isDirectMessage()) {
            this.mRoleGroupLayout = (FlowLayout) this.mViewContainer.findViewById(R.id.f778145d);
            aw1.k kVar = new aw1.k(this.mFragment.getActivity(), this.mData.getGuildBaseProfileData());
            this.mRoleGroupAdapter = kVar;
            this.mRoleGroupLayout.setAdapter(kVar);
            this.mDividerLine = this.mViewContainer.findViewById(R.id.f164999bn3);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void bindViewModel() {
        k d26 = k.d2(this.mFragment);
        this.mHeaderVModel = d26;
        d26.W1(this.mData);
        this.mHeaderVModel.U1().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileHeaderComponent.this.lambda$bindViewModel$0((GuildHeaderData) obj);
            }
        });
        if (!this.mData.isDirectMessage()) {
            this.mHeaderVModel.S1().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildProfileHeaderComponent.this.lambda$bindViewModel$1((List) obj);
                }
            });
            this.mHeaderVModel.i2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildProfileHeaderComponent.this.lambda$bindViewModel$2((Boolean) obj);
                }
            });
        }
        this.mHeaderVModel.j2().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.main.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileHeaderComponent.this.lambda$bindViewModel$3((l) obj);
            }
        });
        com.tencent.mobileqq.guild.setting.mute.c.K().observe(this.mFragment, this.mUserGuildStateChange);
        com.tencent.mobileqq.guild.setting.mute.c.I().observe(this.mFragment, this.mUserAdminChangeObserver);
    }

    private void configIsChannelManager(List<k.b> list) {
        int i3;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 < list.size()) {
                i3 = 5;
                if (String.valueOf(5).equals(list.get(i17).f27065a) || String.valueOf(7).equals(list.get(i17).f27065a)) {
                    break;
                } else {
                    i17++;
                }
            } else {
                i3 = 0;
                break;
            }
        }
        if (TextUtils.isEmpty(this.mHeaderVModel.getGuildBaseProfileData().a())) {
            QLog.d(TAG, 1, "[configIsChannelManager] channelId is null");
        } else {
            QLog.d(TAG, 1, "[configIsChannelManager] isChannelManager = " + i3);
            i16 = i3;
        }
        this.mHeaderVModel.getGuildBaseProfileData().s(i16);
    }

    private void dismiss() {
        getComponentController().handleDismissAction();
    }

    private VerticalCenterImageSpan generateGenderSpan(Boolean bool) {
        int i3;
        if (bool.booleanValue()) {
            i3 = R.drawable.guild_profile_gender_male;
        } else {
            i3 = R.drawable.guild_profile_gender_female;
        }
        Drawable drawable = ContextCompat.getDrawable(this.mFragment.getContext(), i3);
        drawable.setBounds(0, 0, ViewUtils.dpToPx(14.0f), ViewUtils.dpToPx(14.0f));
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable);
        verticalCenterImageSpan.setPadding(ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(2.0f));
        return verticalCenterImageSpan;
    }

    private Bundle getArgumentBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("show_block_switch", showBlockSwitchEnable());
        bundle.putBoolean("from_direct_message", this.mData.isDirectMessage());
        bundle.putBoolean("isSelf", this.mHeaderVModel.X1());
        bundle.putString(AppConstants.Key.GUILD_DIRECT_MESSAGE_GUILD_ID, this.mData.getExtras().getString(AppConstants.Key.GUILD_DIRECT_MESSAGE_GUILD_ID));
        bundle.putString(AppConstants.Key.GUILD_DIRECT_MESSAGE_CHANNEL_ID, this.mData.getExtras().getString(AppConstants.Key.GUILD_DIRECT_MESSAGE_CHANNEL_ID));
        return bundle;
    }

    private int getReportUserMasterType() {
        if (this.mHeaderVModel.X1()) {
            return 1;
        }
        return 0;
    }

    private boolean isGuildManager(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean isLaunchInStandaloneAio() {
        boolean z16;
        if (d12.a.c()) {
            return true;
        }
        FragmentActivity activity = this.mFragment.getActivity();
        if (activity != null && ((activity instanceof GuildBlankActivity) || ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).isGuildChatActivity(activity))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || !q.l()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindUI$4() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.mTopBannerContainer.setLayoutAnimation(new LayoutAnimationController(alphaAnimation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$1(List list) {
        this.mRoleGroupLayout.removeAllViews();
        this.mRoleGroupAdapter.setData(list);
        configIsChannelManager(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$2(Boolean bool) {
        int i3;
        FlowLayout flowLayout = this.mRoleGroupLayout;
        int i16 = 0;
        if (bool.booleanValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        flowLayout.setVisibility(i3);
        View view = this.mDividerLine;
        if (!bool.booleanValue()) {
            i16 = 8;
        }
        view.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$3(l lVar) {
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
    /* renamed from: refreshUI, reason: merged with bridge method [inline-methods] */
    public void lambda$bindViewModel$0(GuildHeaderData guildHeaderData) {
        updateTopBanner(guildHeaderData.n());
        this.mIvAvatar.setAvatarTinyId(this.mHeaderVModel.getGuildBaseProfileData().e(), guildHeaderData.m());
        this.mTvName.setText(guildHeaderData.e());
        updateNewSvipIcon(guildHeaderData);
        updatePersonInfo(guildHeaderData);
        updateMedal(guildHeaderData);
        updateSignInfo(guildHeaderData);
        updateQQProfileBtn(guildHeaderData);
        updateUserGuildMuteState();
        updateGiftView(guildHeaderData);
    }

    private void setDtPage(View view, boolean z16) {
        String str;
        VideoReport.setPageId(view, "pg_sgrp_profile");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_profile");
        k kVar = this.mHeaderVModel;
        if (kVar != null && kVar.getGuildBaseProfileData() != null && this.mHeaderVModel.getGuildBaseProfileData().f() == 1) {
            hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
        }
        k kVar2 = this.mHeaderVModel;
        if (kVar2 != null && kVar2.getGuildBaseProfileData() != null) {
            hashMap.put("sgrp_user_type", Integer.valueOf(v.b(this.mHeaderVModel.getGuildBaseProfileData().k())));
            hashMap.put("sgrp_user_master", Integer.valueOf(getReportUserMasterType()));
            hashMap.put("sgrp_profile_scene", Integer.valueOf(this.mHeaderVModel.getGuildBaseProfileData().g()));
            hashMap.put("sgrp_channel_id", this.mHeaderVModel.getGuildBaseProfileData().e());
            hashMap.put("sgrp_profile_userid", this.mHeaderVModel.getGuildBaseProfileData().b());
        }
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(view, new PageParams(hashMap));
        if (z16) {
            str = "pgin";
        } else {
            str = "pgout";
        }
        VideoReport.reportEvent(str, view, hashMap);
    }

    private boolean showBlockSwitchEnable() {
        if (this.mData.isDirectMessage()) {
            return true;
        }
        if (!ch.j0(this.mHeaderVModel.getGuildBaseProfileData().e()) && this.mHeaderVModel.getGuildBaseProfileData().p()) {
            return true;
        }
        return false;
    }

    private void updateGiftView(GuildHeaderData guildHeaderData) {
        if (guildHeaderData.b() == null) {
            GiftLayout giftLayout = this.mGiftView;
            if (giftLayout != null) {
                giftLayout.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mGiftView == null) {
            this.mGiftView = (GiftLayout) this.mGiftViewStub.inflate();
        }
        this.mGiftView.b(guildHeaderData.b());
        this.mGiftView.setVisibility(0);
    }

    private void updateMedal(GuildHeaderData guildHeaderData) {
        ArrayList<eu> k3 = guildHeaderData.k();
        if (!k3.isEmpty()) {
            this.mMedalView.setVisibility(0);
            if (this.mMedalAdapter == null) {
                aw1.g gVar = new aw1.g();
                this.mMedalAdapter = gVar;
                this.mMedalView.setAdapter(gVar);
            }
            if (k3.size() > 3) {
                this.mMedalAdapter.setData(MedalItem.c(k3.subList(0, 3)));
                return;
            } else {
                this.mMedalAdapter.setData(MedalItem.c(k3));
                return;
            }
        }
        aw1.g gVar2 = this.mMedalAdapter;
        if (gVar2 != null) {
            gVar2.setData(Collections.emptyList());
        }
        this.mMedalView.setVisibility(8);
    }

    private void updateNewSvipIcon(GuildHeaderData guildHeaderData) {
        IGProIdentityInfo c16 = guildHeaderData.c();
        if (c16 == null) {
            this.mNewSvipIcon.setVisibility(8);
            return;
        }
        String o16 = guildHeaderData.o();
        if (lv1.a.g(guildHeaderData.o())) {
            o16 = "";
        }
        Drawable c17 = ig1.a.c(o16, c16.getPlateData(), this.mNewSvipIcon.getResources());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateSvipIcon plateData: " + new String(c16.getPlateData()) + ", drawable: " + c17);
        }
        if (c17 != null) {
            this.mNewSvipIcon.setVisibility(0);
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAllPolicy(this.mNewSvipIcon, "em_sgrp_svip_medal");
            this.mNewSvipIcon.setImageDrawable(c17);
            this.mNewSvipIcon.setOnClickListener(new c());
        }
    }

    private void updatePersonInfo(GuildHeaderData guildHeaderData) {
        if (this.mFragment.getContext() == null) {
            this.mBaseInfoText.setVisibility(8);
            return;
        }
        int color = this.mFragment.getContext().getResources().getColor(R.color.qui_common_text_secondary);
        int color2 = this.mFragment.getContext().getResources().getColor(R.color.qui_common_text_secondary_light);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(color2);
        String r16 = QQGuildUIUtil.r(R.string.f143320lr);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (guildHeaderData.f() == 1) {
            spannableStringBuilder.append(" ", generateGenderSpan(Boolean.TRUE), 17);
            spannableStringBuilder.append("\u7537", CharacterStyle.wrap(foregroundColorSpan), 17);
        } else if (guildHeaderData.f() == 2) {
            spannableStringBuilder.append(" ", generateGenderSpan(Boolean.FALSE), 17);
            spannableStringBuilder.append("\u5973", CharacterStyle.wrap(foregroundColorSpan), 17);
        }
        String a16 = guildHeaderData.a();
        if (!TextUtils.isEmpty(a16)) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append(r16, CharacterStyle.wrap(foregroundColorSpan2), 17);
            }
            spannableStringBuilder.append(a16, CharacterStyle.wrap(foregroundColorSpan), 17);
        }
        long j3 = guildHeaderData.j();
        if (!this.mData.isDirectMessage() && j3 >= 0 && spannableStringBuilder.length() > 0) {
            spannableStringBuilder.append(r16, CharacterStyle.wrap(foregroundColorSpan2), 17);
        }
        if (!this.mData.isDirectMessage() && j3 > 0) {
            spannableStringBuilder.append("\u52a0\u5165\u8be5\u9891\u9053" + j3 + "\u5929", CharacterStyle.wrap(foregroundColorSpan), 17);
        } else if (!this.mData.isDirectMessage() && j3 == 0) {
            spannableStringBuilder.append("\u521a\u521a\u52a0\u5165\u8be5\u9891\u9053", CharacterStyle.wrap(foregroundColorSpan), 17);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updatePersonInfo address:" + a16 + "joinTime:" + j3 + "isDirectMessage:" + this.mData.isDirectMessage());
        }
        if (spannableStringBuilder.length() == 0) {
            this.mBaseInfoText.setVisibility(8);
        } else {
            this.mBaseInfoText.setText(spannableStringBuilder);
            this.mBaseInfoText.setVisibility(0);
        }
    }

    private void updateQQProfileBtn(GuildHeaderData guildHeaderData) {
        int i3;
        String o16 = guildHeaderData.o();
        View view = this.mQQProfile;
        if (!lv1.a.g(o16) && !lv1.a.f(o16)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void updateSignInfo(GuildHeaderData guildHeaderData) {
        boolean z16;
        em l3 = guildHeaderData.l();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (l3 != null && l3.getStartTime() > 0 && l3.getEndTime() > 0 && currentTimeMillis > l3.getStartTime() && currentTimeMillis < l3.getEndTime() && !TextUtils.isEmpty(l3.getDesc()) && !TextUtils.isEmpty(l3.getUrl())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (l3 != null) {
            QLog.d(TAG, 1, "updateSignInfo isSign:", Boolean.valueOf(z16), " endTime:", Long.valueOf(l3.getEndTime()), ";", "startTime:" + l3.getStartTime() + ";desc:" + l3.getDesc() + ";guildId:" + l3.getGuildId());
        }
        if (z16) {
            u.r(l3.getUrl(), this.mSigningView, false, null);
            this.mSigningView.setVisibility(0);
            this.mSigningView.setOnClickListener(new d(l3));
            return;
        }
        this.mSigningView.setVisibility(8);
    }

    private void updateTopBanner(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTopBanner.setVisibility(0);
            ((FrameLayout.LayoutParams) this.mTopBanner.getLayoutParams()).height = (int) (bi.d() * TOP_BANNER_ASPECT_RATIO);
            u.r(str, this.mTopBanner, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateUserGuildMuteState() {
        long g16;
        boolean z16;
        String j3 = this.mHeaderVModel.getGuildBaseProfileData().j();
        int k3 = this.mHeaderVModel.getGuildBaseProfileData().k();
        String b16 = this.mHeaderVModel.getGuildBaseProfileData().b();
        int c16 = this.mHeaderVModel.getGuildBaseProfileData().c();
        String e16 = this.mHeaderVModel.getGuildBaseProfileData().e();
        String a16 = this.mHeaderVModel.getGuildBaseProfileData().a();
        GuildHeaderData value = this.mHeaderVModel.U1().getValue();
        if (value == null) {
            g16 = 0;
        } else {
            g16 = value.g();
        }
        int i3 = 0;
        if (com.tencent.mobileqq.guild.setting.mute.c.O(Long.valueOf(g16)) && !isGuildManager(c16)) {
            boolean a17 = r.p().getChannelPermission(e16, a16).a(90001);
            if ((j3 != null && j3.equals(b16)) || isGuildManager(k3) || a17) {
                z16 = true;
                View view = this.mIvMuteState;
                if (!z16) {
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
        }
        z16 = false;
        View view2 = this.mIvMuteState;
        if (!z16) {
        }
        view2.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    protected View createView(Context context) {
        return cr.g(LayoutInflater.from(context)).getRoot();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1000;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f168146f22;
    }

    public void jumpToDirectMessageAio(com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        LaunchGuildChatPieParam Q1 = this.mHeaderVModel.Q1(kVar);
        Context context = this.mFragment.getContext();
        if (context == null) {
            QLog.e(TAG, 1, "jumpDirectMessageAIO context is null");
            return;
        }
        GuildAppReportSourceInfo fromActivity = GuildAppReportSourceInfo.fromActivity(this.mFragment.requireActivity());
        if (fromActivity != null) {
            fromActivity.saveTo(Q1.G);
        }
        if (isLaunchInStandaloneAio()) {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildDirectMessageAio(context, Q1);
        } else {
            ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(context, Q1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.wue) {
                QQGuildUIUtil.b(this.mFragment);
                GuildDirectMsgSettingDialogFragment.Rh(this.mFragment.getChildFragmentManager(), this.mData.getUserProfileInfo().getDisplayName(), this.mData, getArgumentBundle()).Mh(this);
                if (((DialogFragment) this.mFragment).getDialog() != null) {
                    ((DialogFragment) this.mFragment).getDialog().hide();
                }
            } else if (id5 == R.id.f166222z25) {
                Intent intent = new Intent();
                intent.putExtra("from", 1);
                intent.putExtra("tinyId", this.mHeaderVModel.getGuildBaseProfileData().b());
                intent.putExtra("guildId", this.mHeaderVModel.getGuildBaseProfileData().e());
                QPublicFragmentActivity.b.b(this.mFragment.getActivity(), intent, QPublicFragmentActivity.class, GuildCheckAvatarFragment.class);
            } else if (id5 == R.id.f61862z_) {
                VideoReport.reportEvent("dt_clck", this.mQQProfile, null);
                AllInOne allInOne = new AllInOne(this.mHeaderVModel.T1().getUin(), 124);
                allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, 3922);
                allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, 1);
                ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(this.mFragment.getActivity(), allInOne);
            } else if (id5 == R.id.f28380is) {
                GuildJumpUtil.v(view.getContext(), ig1.a.b(this.mHeaderVModel.getGuildBaseProfileData().e(), this.mHeaderVModel.getGuildBaseProfileData().a()));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onConfigurationChanged() {
        GuildHeaderData value = this.mHeaderVModel.U1().getValue();
        if (value != null) {
            updateTopBanner(value.n());
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        super.onCreate(fragment, appInterface, bundle);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "onCreate viewContainer : " + this.mViewContainer);
        }
        bindUI();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        setDtPage(getComponentController().getDelegate().getRootView(), false);
        dismiss();
    }

    public void onDirectMsgCreateInfoChange(com.tencent.mobileqq.qqguildsdk.data.k kVar) {
        jumpToDirectMessageAio(kVar);
        dismiss();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildDirectMsgSettingDialogFragment.d
    public void onDismissed() {
        QQGuildUIUtil.a(this.mFragment);
        if (((DialogFragment) this.mFragment).getDialog() != null) {
            ((DialogFragment) this.mFragment).getDialog().show();
            ((IGPSService) ch.R0(IGPSService.class)).refreshGuildUserProfileInfo(this.mHeaderVModel.getGuildBaseProfileData().e(), this.mHeaderVModel.getGuildBaseProfileData().b());
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
        this.mProfileContentContainer.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
        this.mProfileContentContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onResume() {
        if (this.mHeaderVModel != null && !this.mData.isDirectMessage()) {
            this.mHeaderVModel.R1();
        }
        VideoReport.reportEvent("imp", this.mQQProfile, null);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(GuildProfileData guildProfileData) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "onInitData viewContainer : " + this.mViewContainer);
        }
        if (this.mHeaderVModel == null) {
            bindViewModel();
            setDtPage(this.mComponentController.getDelegate().getRootView(), true);
            VideoReport.setElementId(this.mQQProfile, "em_sgrp_qq_card");
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onUpdateData(GuildProfileData guildProfileData) {
        super.onUpdateData(guildProfileData);
        k kVar = this.mHeaderVModel;
        if (kVar != null) {
            kVar.k2(guildProfileData);
        }
    }
}
