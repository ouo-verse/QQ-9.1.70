package com.tencent.mobileqq.guild.profile.profilecard.manage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import bw1.o;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildProfileSettingDialogHideEvent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildProfileSettingDialogShowEvent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.profile.profilecard.manage.GuildProfileManageComponent;
import com.tencent.mobileqq.guild.rolegroup.fragments.SelectRoleForUserFragment;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import lv1.b;

/* loaded from: classes14.dex */
public class GuildProfileManageComponent extends AbsGuildProfileComponent implements View.OnClickListener, GuildSwitchButton.a {
    private static final String TAG = "Guild.profile.GuildProfileManageComponent";
    private GuildSecondaryAuthorityViewModel mAuthorityViewModel;
    private Button mBtnPullBlack;
    private Button mBtnRemoveGuild;
    private View mGuildNavigateManageRole;
    private o mManageViewModel;
    private View mPullBlackTips;
    private View mTvGuildManage;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f231540a = false;

        a() {
        }

        @Override // lv1.b
        public void a(boolean z16, int i3) {
            this.f231540a = true;
            QLog.i(GuildProfileManageComponent.TAG, 2, "onRemoveGuild: isBlack=" + z16 + ", msgRevokeType=" + i3);
            GuildProfileManageComponent.this.mManageViewModel.T1(z16, i3);
        }

        @Override // lv1.b
        public void onDismiss() {
            if (!this.f231540a) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildProfileSettingDialogShowEvent());
            }
            QLog.i(GuildProfileManageComponent.TAG, 2, "onDismiss: removeGuild=" + this.f231540a);
        }
    }

    public GuildProfileManageComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        super(iGuildComponentController, guildProfileData);
    }

    private void bindUI() {
        this.mBtnRemoveGuild = (Button) this.mViewContainer.findViewById(R.id.f28020ht);
        this.mGuildNavigateManageRole = this.mViewContainer.findViewById(R.id.ws5);
        this.mBtnPullBlack = (Button) this.mViewContainer.findViewById(R.id.f29310la);
        this.mTvGuildManage = this.mViewContainer.findViewById(R.id.x3d);
        this.mPullBlackTips = this.mViewContainer.findViewById(R.id.f29320lb);
        this.mBtnRemoveGuild.setOnClickListener(this);
        this.mGuildNavigateManageRole.setOnClickListener(this);
        this.mBtnRemoveGuild.setOnClickListener(this);
        this.mBtnPullBlack.setOnClickListener(new View.OnClickListener() { // from class: bw1.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileManageComponent.this.onClick(view);
            }
        });
        resetEditRoleGroupMargin();
        setAccessibilityUI();
        Button button = this.mBtnRemoveGuild;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.T0(button, "em_sgrp_remove_channel", clickPolicy, exposurePolicy, new HashMap());
        ch.T0(this.mBtnPullBlack, "em_sgrp_block_remove_channel", clickPolicy, exposurePolicy, new HashMap());
    }

    private void bindViewModel() {
        o oVar = (o) h.b(this.mFragment, o.F).get(o.class);
        this.mManageViewModel = oVar;
        oVar.setGuildBaseProfileData(this.mData.getGuildBaseProfileData());
        this.mManageViewModel.U1(this.mApp, this.mData.isDirectMessage());
        this.mManageViewModel.Z1().observe(this.mFragment, new Observer() { // from class: bw1.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileManageComponent.this.lambda$bindViewModel$0((com.tencent.mobileqq.guild.profile.profilecard.main.l) obj);
            }
        });
        this.mManageViewModel.Q1().observe(this.mFragment, new Observer() { // from class: bw1.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileManageComponent.this.lambda$bindViewModel$1((Boolean) obj);
            }
        });
        this.mManageViewModel.R1().observe(this.mFragment, new Observer() { // from class: bw1.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileManageComponent.this.lambda$bindViewModel$2((Boolean) obj);
            }
        });
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
        this.mAuthorityViewModel = guildSecondaryAuthorityViewModel;
        guildSecondaryAuthorityViewModel.init(this.mData.getGuildBaseProfileData().e(), this.mData.getGuildBaseProfileData().a(), "GuildProfileManageComponent");
        this.mAuthorityViewModel.getShowRemoveMember().observe(this.mFragment, new Observer() { // from class: bw1.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileManageComponent.this.lambda$bindViewModel$3((Boolean) obj);
            }
        });
        this.mAuthorityViewModel.getShowModifyRole().observe(this.mFragment, new Observer() { // from class: bw1.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileManageComponent.this.lambda$bindViewModel$4((Boolean) obj);
            }
        });
        this.mAuthorityViewModel.getShowBlackListMember().observe(this.mFragment, new Observer() { // from class: bw1.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileManageComponent.this.lambda$bindViewModel$5((Boolean) obj);
            }
        });
    }

    private boolean canRemoveNormalMember(String str, String str2, int i3) {
        if (as.i(str, str2, 100001) && i3 == 0) {
            return true;
        }
        return false;
    }

    private static boolean canShowBlackBtn(Boolean bool, GuildBaseProfileData guildBaseProfileData) {
        if ((guildBaseProfileData.k() == 2 || bool.booleanValue()) && guildBaseProfileData.c() != 2) {
            return true;
        }
        return false;
    }

    private void dismiss() {
        getComponentController().handleDismissAction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$0(l lVar) {
        if (TextUtils.isEmpty(lVar.c())) {
            return;
        }
        if (lVar.d()) {
            ch.u1(this.mFragment.getContext(), lVar.c());
        } else {
            ch.t1(this.mFragment.getContext(), lVar.a(), lVar.c(), lVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$1(Boolean bool) {
        if (bool.booleanValue()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$2(Boolean bool) {
        if (bool.booleanValue()) {
            refreshGuildUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$3(Boolean bool) {
        refreshGuildUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindViewModel$4(Boolean bool) {
        int i3;
        View view = this.mGuildNavigateManageRole;
        int i16 = 0;
        if (bool.booleanValue() && this.mData.getGuildBaseProfileData().p()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.mTvGuildManage;
        if (!bool.booleanValue()) {
            i16 = 8;
        }
        view2.setVisibility(i16);
    }

    private void navigateToSelectUserRoleFragment() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.mGuildNavigateManageRole, "em_sgrp_edit_role", null);
        VideoReport.reportEvent("clck", this.mGuildNavigateManageRole, new HashMap());
        GuildBaseProfileData guildBaseProfileData = this.mData.getGuildBaseProfileData();
        QPublicFragmentActivity.start(this.mFragment.getContext(), SelectRoleForUserFragment.Oh(guildBaseProfileData.e(), guildBaseProfileData.a(), guildBaseProfileData.b()), SelectRoleForUserFragment.class);
    }

    private void onClickBottomButton(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onClickRemoveGuild");
        }
        GuildBaseProfileData guildBaseProfileData = this.mData.getGuildBaseProfileData();
        ArrayList arrayList = new ArrayList();
        arrayList.add(guildBaseProfileData.b());
        GuildRemoveGuildDialogFragment.vh(this.mFragment.getActivity(), guildBaseProfileData.e(), arrayList, guildBaseProfileData.p(), false, z16, new a());
        SimpleEventBus.getInstance().dispatchEvent(new GuildProfileSettingDialogHideEvent());
    }

    private void refreshDirectMsgUI() {
        if (this.mManageViewModel.getGuildBaseProfileData().j().equals(this.mManageViewModel.getGuildBaseProfileData().b())) {
            this.mTvGuildManage.setVisibility(8);
            this.mGuildNavigateManageRole.setVisibility(8);
            this.mBtnRemoveGuild.setVisibility(8);
            setPullBackVisible(false);
        }
    }

    private void refreshGuildUI() {
        updateRemoveGuildBtn();
        GuildBaseProfileData guildBaseProfileData = this.mManageViewModel.getGuildBaseProfileData();
        setManageContainerUI(guildBaseProfileData.k(), guildBaseProfileData.c(), guildBaseProfileData.p(), TextUtils.equals(guildBaseProfileData.j(), guildBaseProfileData.b()), guildBaseProfileData.e(), guildBaseProfileData.a());
    }

    private void resetEditRoleGroupMargin() {
        ImageView imageView = (ImageView) this.mGuildNavigateManageRole.findViewById(R.id.wvw);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.rightMargin = ViewUtils.dpToPx(14.0f);
        imageView.setLayoutParams(marginLayoutParams);
    }

    private void setManageContainerUI(int i3, int i16, boolean z16, boolean z17, String str, String str2) {
        int i17;
        int i18 = 8;
        int i19 = 0;
        if (i3 != 2) {
            boolean z18 = true;
            if (i3 != 1 || i16 != 0) {
                if (z16) {
                    boolean h16 = as.h(str, 70002);
                    View view = this.mGuildNavigateManageRole;
                    if (h16) {
                        i17 = 0;
                    } else {
                        i17 = 8;
                    }
                    view.setVisibility(i17);
                    if (z17 || !canRemoveNormalMember(str, str2, i16)) {
                        z18 = false;
                    }
                    View view2 = this.mTvGuildManage;
                    if (h16 || z18) {
                        i18 = 0;
                    }
                    view2.setVisibility(i18);
                    return;
                }
                View view3 = this.mTvGuildManage;
                if (!as.h(str, 100001)) {
                    i19 = 8;
                }
                view3.setVisibility(i19);
                this.mGuildNavigateManageRole.setVisibility(8);
                return;
            }
        }
        if (z16) {
            this.mTvGuildManage.setVisibility(0);
            this.mGuildNavigateManageRole.setVisibility(0);
        } else if (z17) {
            this.mTvGuildManage.setVisibility(8);
            this.mGuildNavigateManageRole.setVisibility(8);
        } else {
            this.mTvGuildManage.setVisibility(0);
            this.mGuildNavigateManageRole.setVisibility(8);
        }
    }

    private void setPullBackVisible(boolean z16) {
        if (z16) {
            this.mBtnPullBlack.setVisibility(0);
            this.mPullBlackTips.setVisibility(0);
        } else {
            this.mBtnPullBlack.setVisibility(8);
            this.mPullBlackTips.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateBlackBtn, reason: merged with bridge method [inline-methods] */
    public void lambda$bindViewModel$5(Boolean bool) {
        GuildBaseProfileData guildBaseProfileData = this.mManageViewModel.getGuildBaseProfileData();
        if (TextUtils.equals(guildBaseProfileData.j(), guildBaseProfileData.b())) {
            setPullBackVisible(false);
            return;
        }
        setPullBackVisible(canShowBlackBtn(bool, guildBaseProfileData));
        if (!guildBaseProfileData.p()) {
            this.mBtnPullBlack.setText(R.string.f1520319a);
        }
    }

    private void updateRemoveGuildBtn() {
        GuildBaseProfileData guildBaseProfileData = this.mManageViewModel.getGuildBaseProfileData();
        if (!TextUtils.equals(guildBaseProfileData.j(), guildBaseProfileData.b()) && guildBaseProfileData.p()) {
            String e16 = guildBaseProfileData.e();
            guildBaseProfileData.a();
            boolean h16 = as.h(e16, 100001);
            boolean h17 = as.h(e16, 100002);
            if ((guildBaseProfileData.k() == 2 || h16 || h17) && guildBaseProfileData.c() != 2) {
                this.mBtnRemoveGuild.setVisibility(0);
                return;
            } else {
                this.mBtnRemoveGuild.setVisibility(8);
                return;
            }
        }
        this.mBtnRemoveGuild.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1002;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.mBtnRemoveGuild) {
            onClickBottomButton(false);
        } else if (view == this.mGuildNavigateManageRole) {
            navigateToSelectUserRoleFragment();
        } else if (view == this.mBtnPullBlack) {
            onClickBottomButton(true);
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        super.onCreate(fragment, appInterface, bundle);
        bindUI();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        this.mManageViewModel.onDestroy();
        dismiss();
    }

    public void setContentView(View view) {
        this.mViewContainer = view;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(GuildProfileData guildProfileData) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "onInitData viewContainer : " + this.mViewContainer);
        }
        if (this.mManageViewModel == null) {
            bindViewModel();
            if (this.mData.isDirectMessage()) {
                refreshDirectMsgUI();
            } else {
                refreshGuildUI();
            }
        }
    }

    private void setAccessibilityUI() {
    }

    @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
    public void onCheckedChanged(GuildSwitchButton guildSwitchButton, boolean z16) {
    }
}
