package com.tencent.mobileqq.guild.profile.profilecard.privacy;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.profile.profilecard.privacy.GuildProfilePrivacyComponent;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes14.dex */
public class GuildProfilePrivacyComponent extends AbsGuildProfileComponent implements View.OnClickListener {
    private static final String TAG = "Guild.profile.GuildProfilePrivacyComponent";
    private boolean mIsInit;
    private GuildProfilePrivacyViewModel mPrivacyViewModel;
    private View mRlConnectClient;

    public GuildProfilePrivacyComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        super(iGuildComponentController, guildProfileData);
    }

    private void bindUI() {
        View findViewById = this.mViewContainer.findViewById(R.id.f165601ww1);
        this.mRlConnectClient = findViewById;
        findViewById.setOnClickListener(this);
    }

    private void bindViewModel(GuildProfileData guildProfileData) {
        GuildProfilePrivacyViewModel guildProfilePrivacyViewModel = (GuildProfilePrivacyViewModel) h.b(this.mFragment, BaseChannelViewModel.sViewModelFactory).get(GuildProfilePrivacyViewModel.class);
        this.mPrivacyViewModel = guildProfilePrivacyViewModel;
        guildProfilePrivacyViewModel.getRepository().m(this.mApp);
        this.mPrivacyViewModel.setGuildBaseProfileData(guildProfileData.getGuildBaseProfileData());
        this.mPrivacyViewModel.getToastEvent().observe(this.mFragment, new Observer() { // from class: cw1.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfilePrivacyComponent.this.lambda$bindViewModel$0((l) obj);
            }
        });
        this.mPrivacyViewModel.fetchDirectMsgStatus();
    }

    private void dismiss() {
        getComponentController().handleDismissAction();
    }

    private boolean isSelfProfile(GuildProfileData guildProfileData) {
        if (guildProfileData != null && guildProfileData.getGuildBaseProfileData() != null) {
            String j3 = guildProfileData.getGuildBaseProfileData().j();
            String b16 = guildProfileData.getGuildBaseProfileData().b();
            if (j3 == null || !j3.equals(b16)) {
                return false;
            }
            return true;
        }
        QLog.e(TAG, 1, "isSelfProfile\uff1agetGuildBaseProfileData is null !");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$0(l lVar) {
        if (this.mFragment != null) {
            SecurityTipHelperKt.J(lVar.b(), this.mFragment.getContext(), lVar.a(), lVar.c());
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1005;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f168149f25;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.mRlConnectClient) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mRlConnectClient, "em_sgrp_edit_profile", null);
            VideoReport.reportEvent("clck", this.mRlConnectClient, null);
            if (!QQGuildUIUtil.v()) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildClientListSettingFragment(this.mFragment.getActivity(), this.mData.getGuildBaseProfileData().e(), this.mData.getGuildBaseProfileData().j());
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        super.onCreate(fragment, appInterface, bundle);
        bindUI();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(GuildProfileData guildProfileData) {
        super.onInitData(guildProfileData);
        if (this.mIsInit) {
            return;
        }
        this.mIsInit = true;
        if (isSelfProfile(guildProfileData)) {
            bindViewModel(guildProfileData);
        } else {
            this.mViewContainer.setVisibility(8);
        }
    }
}
