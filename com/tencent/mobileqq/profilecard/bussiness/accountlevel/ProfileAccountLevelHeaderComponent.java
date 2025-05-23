package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes16.dex */
public class ProfileAccountLevelHeaderComponent extends ProfileAccountLevelComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileAccountLevelHeaderComponent";
    private ProfileCardInfo mCardInfo;
    private boolean mFirstVisible;

    public ProfileAccountLevelHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mFirstVisible = true;
            this.mCardInfo = profileCardInfo;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initAccountLevel() {
        if (this.mViewContainer != 0) {
            this.mActivity.getLayoutInflater().inflate(R.layout.h0i, (ViewGroup) this.mViewContainer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshAccountLevel(Card card, boolean z16) {
        if (this.mViewContainer != 0) {
            boolean needShowAccountLevel = needShowAccountLevel(card);
            boolean isSwitchEnable = this.mConfigHelper.isSwitchEnable(12);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("refreshAccountLevel showAccountInfo=%s baseInfoABTestEnable=%s", Boolean.valueOf(needShowAccountLevel), Boolean.valueOf(isSwitchEnable)));
            }
            if (needShowAccountLevel && isSwitchEnable) {
                if (this.mFirstVisible) {
                    ProfileAccountLevelReport.reportAccountLevelVisible(this.mQQAppInterface, this.mCardInfo);
                }
                this.mFirstVisible = false;
                ((View) this.mViewContainer).setVisibility(0);
                ProfileQQLevelView profileQQLevelView = (ProfileQQLevelView) ((View) this.mViewContainer).findViewById(R.id.gre);
                if (profileQQLevelView != null) {
                    profileQQLevelView.update((ProfileCardInfo) this.mData, this.mIsFromArkBabyQ);
                    profileQQLevelView.setClickable(false);
                    QQValuePagView qQValuePagView = profileQQLevelView.mPagLayout;
                    if (qQValuePagView != null) {
                        qQValuePagView.n(false);
                    }
                }
                updateMedalView();
                updateNumPAGView();
                ((View) this.mViewContainer).setTag(new com.tencent.mobileqq.profile.b(69, null));
                ((View) this.mViewContainer).setOnClickListener(this);
                updateItemTheme((View) this.mViewContainer, null, ((View) this.mViewContainer).findViewById(R.id.icon), null, (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw));
                return;
            }
            ((View) this.mViewContainer).setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1022;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        Card card;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mobileqq.profile.b) {
                int i3 = ((com.tencent.mobileqq.profile.b) tag).f260135a;
                int i16 = 3;
                boolean z16 = false;
                if (i3 != 69) {
                    if (i3 != 100) {
                        if (i3 == 104) {
                            ProfileCardInfo profileCardInfo = this.mCardInfo;
                            if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
                                handleVipNumPagViewClick(view, card.uin);
                            }
                            ProfileCardDtReportUtil.dtReportClick(view);
                        }
                    } else {
                        handleMedalIconClick();
                        if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
                            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                                z16 = true;
                            }
                            QQAppInterface qQAppInterface = this.mQQAppInterface;
                            if (z16) {
                                i16 = 1;
                            }
                            ProfileAccountLevelReport.reportAccountDarenClick(qQAppInterface, i16);
                        }
                    }
                } else {
                    handleAccountLevelClick();
                    if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo) this.mData)) {
                        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                            z16 = true;
                        }
                        QQAppInterface qQAppInterface2 = this.mQQAppInterface;
                        if (z16) {
                            i16 = 1;
                        }
                        ProfileAccountLevelReport.reportAccountLevelClick(qQAppInterface2, i16);
                    }
                    ProfileCardDtReportUtil.dtReportClick(view.findViewById(R.id.dkg));
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
            initAccountLevel();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        this.mCardInfo = profileCardInfo;
        DATA data = this.mData;
        refreshAccountLevel(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        return true;
    }
}
