package com.tencent.mobileqq.profilecard.container.titlecontainer;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardBubbleUtil;
import com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;

/* loaded from: classes35.dex */
public class ElegantProfileTitleContainer extends BaseProfileTitleContainer {
    private static final String TAG = "ElegantProfileTitleContainer";
    private View cover;

    public ElegantProfileTitleContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer
    public void initDtReport() {
        com.tencent.mobileqq.profile.b bVar;
        com.tencent.mobileqq.profile.b bVar2;
        com.tencent.mobileqq.profile.b bVar3;
        ProfileCardDtReportUtil.initElementWithExposure(this.mLeftBackViewBg, ProfileCardDtReportUtil.DT_REPORT_EM_NEW_BACK);
        RelativeLayout relativeLayout = this.mRightMsgImageBg;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0 && (bVar3 = (com.tencent.mobileqq.profile.b) this.mRightMsgImageBg.getTag()) != null && bVar3.f260135a == 108) {
            ProfileCardDtReportUtil.initElementWithExposure(this.mRightMsgImageBg, ProfileCardDtReportUtil.DT_REPORT_EM_NEW_MESSAGE);
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            RelativeLayout relativeLayout2 = this.mRightSettingImageBg;
            if (relativeLayout2 == null || relativeLayout2.getVisibility() != 0 || (bVar2 = (com.tencent.mobileqq.profile.b) this.mRightSettingImageBg.getTag()) == null || bVar2.f260135a != 111) {
                return;
            }
            ProfileCardDtReportUtil.initElementWithExposure(this.mRightSettingImageBg, ProfileCardDtReportUtil.DT_REPORT_EM_NEW_SET);
            return;
        }
        RelativeLayout relativeLayout3 = this.mRightImageBg;
        if (relativeLayout3 == null || relativeLayout3.getVisibility() != 0 || (bVar = (com.tencent.mobileqq.profile.b) this.mRightImageBg.getTag()) == null || bVar.f260135a != 16) {
            return;
        }
        ProfileCardDtReportUtil.initElementWithExposure(this.mRightImageBg, ProfileCardDtReportUtil.DT_REPORT_EM_NEW_SET);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer
    public void initViews() {
        super.initViews();
        this.cover = ((FrameLayout) this.mViewContainer).findViewById(R.id.oxi);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            int i3 = ((com.tencent.mobileqq.profile.b) view.getTag()).f260135a;
            if (i3 == 16) {
                dtReport(view);
                if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                    openTroopMore(view);
                    return;
                } else {
                    openProfileMore();
                    return;
                }
            }
            if (i3 == 44) {
                showContactActionSheet();
                return;
            }
            if (i3 == 65) {
                openQRCode();
                ReportController.o(this.mApp, "dc00898", "", "", "0X8007EBB", "0X8007EBB", 0, 0, "", "", "", "");
                return;
            }
            if (i3 == 99) {
                ProfileCardUtil.U(this.mActivity);
                return;
            }
            if (i3 == 108) {
                dtReport(view);
                ProfileCardUtil.U(this.mActivity);
                return;
            }
            if (i3 == 110) {
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).startAvatarSettingActivity(this.mActivity, "friend_card");
                return;
            }
            if (i3 != 111) {
                return;
            }
            reportForZplan("click");
            dtReport(view);
            if (((ProfileCardInfo) this.mData).isTroopMemberCard) {
                openTroopMore(view);
            } else {
                openProfileMore();
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer, com.tencent.mobileqq.profilecard.base.container.AbsQQProfileContainer, com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        initDtReport();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer
    public void updateTitle() {
        this.mLeftBackViewBg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.container.titlecontainer.ElegantProfileTitleContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElegantProfileTitleContainer elegantProfileTitleContainer = ElegantProfileTitleContainer.this;
                elegantProfileTitleContainer.dtReport(elegantProfileTitleContainer.mLeftBackViewBg);
                if (((AbsComponent) ElegantProfileTitleContainer.this).mActivity == null) {
                    return;
                }
                if (AppSetting.t(((AbsComponent) ElegantProfileTitleContainer.this).mActivity) && !(((AbsComponent) ElegantProfileTitleContainer.this).mActivity instanceof FriendProfileCardActivity)) {
                    ((AbsComponent) ElegantProfileTitleContainer.this).mActivity.onKeyDown(4, new KeyEvent(4, 4));
                } else {
                    ((AbsComponent) ElegantProfileTitleContainer.this).mActivity.finish();
                }
            }
        });
        boolean z16 = ((ProfileCardInfo) this.mData).allInOne.f260789pa == 0;
        if (z16) {
            this.mCenterTextView.setText(R.string.bwm);
        } else {
            this.mCenterTextView.setText(R.string.bwj);
        }
        updateTitleRight(z16);
        updateTitleLeft(z16);
    }

    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer
    public void updateTitleMode(int i3) {
        super.updateTitleMode(i3);
        if (i3 == 1) {
            this.cover.setVisibility(0);
        } else if (i3 == 0 || i3 == 2) {
            this.cover.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer
    public void updateTitleRight(boolean z16) {
        Resources resources = this.mActivity.getResources();
        BaseProfileTitleContainer.TitleRightStatus updateTitleRightStatus = updateTitleRightStatus(z16, (ProfileCardInfo) this.mData);
        super.updateTitleRight(z16);
        if (updateTitleRightStatus.showImageView && updateTitleRightStatus.imageTagType == 65) {
            this.mRightImageBg.setVisibility(8);
        }
        if (updateTitleRightStatus.showTextView && updateTitleRightStatus.textTagType == 16) {
            this.mRightTextView.setVisibility(8);
            this.mRightImageBg.setVisibility(0);
            this.mRightImageView.setImageResource(R.drawable.qui_setting_icon_nav_secondary_selector);
            this.mRightImageBg.setContentDescription(HardCodeUtil.qqStr(R.string.f212715o_));
            this.mRightImageBg.setTag(new com.tencent.mobileqq.profile.b(16, null));
            this.mRightImageBg.setOnClickListener(this);
        }
        if (z16 && updateTitleRightStatus.textTagType == 98) {
            this.mRightTextView.setVisibility(8);
            this.mRightMsgImageView.setImageResource(R.drawable.qui_remind_icon_nav_secondary_selector);
            this.mRightMsgImageBg.setContentDescription(HardCodeUtil.qqStr(R.string.f212665o5));
            this.mRightMsgImageBg.setTag(new com.tencent.mobileqq.profile.b(108, null));
            this.mRightMsgImageBg.setVisibility(0);
            this.mRightMsgImageBg.setOnClickListener(this);
            if (SimpleUIUtil.isNowElderMode()) {
                this.mRightMsgImageBg.setMinimumHeight(resources.getDimensionPixelSize(R.dimen.cai));
                this.mRightMsgImageBg.setMinimumWidth(resources.getDimensionPixelSize(R.dimen.cai));
            }
            this.mRightSettingImageBg.setVisibility(0);
            this.mRightSettingImageView.setImageResource(R.drawable.qui_setting_icon_nav_secondary_selector);
            this.mRightSettingImageBg.setContentDescription(HardCodeUtil.qqStr(R.string.f212715o_));
            this.mRightSettingImageBg.setTag(new com.tencent.mobileqq.profile.b(111, null));
            this.mRightSettingImageBg.setOnClickListener(this);
            ProfileCardBubbleUtil.showQCircleOrZPlanTips(this.mActivity, this.mRightSettingImageBg);
            if (this.mHasReportSettingExpose) {
                return;
            }
            reportForZplan("imp");
            this.mHasReportSettingExpose = true;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.container.titlecontainer.BaseProfileTitleContainer
    public void updateTitleLeft(boolean z16) {
    }
}
