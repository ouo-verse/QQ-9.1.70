package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ElegantProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileAccountLevelReport;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ElegantNewProfileAccountLevelComponent extends BaseProfileAccountLevelComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ElegantNewProfileAccountLevelComponent";

    public ElegantNewProfileAccountLevelComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [VIEW] */
    /* JADX WARN: Type inference failed for: r9v16, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v19 */
    @Override // com.tencent.mobileqq.profilecard.bussiness.accountlevel.BaseProfileAccountLevelComponent
    public boolean makeOrRefreshAccountLevel(Card card, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        boolean z26;
        ?? r95;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        boolean z27 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, card, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        boolean needShowAccountLevel = needShowAccountLevel(card);
        if (card != null && card.switchMembershipAndRank == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAccountLevel showAccountInfo=%s profileAccountLevelSwitch=%s ", Boolean.valueOf(needShowAccountLevel), Boolean.valueOf(z19)));
        }
        if (!z19) {
            if (this.mViewContainer == null) {
                return false;
            }
            this.mViewContainer = null;
            return true;
        }
        if (!needShowAccountLevel) {
            if (this.mViewContainer != null) {
                this.mViewContainer = null;
            } else {
                z27 = false;
            }
        } else {
            if (this.mViewContainer == null) {
                LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
                IComponentCenter iComponentCenter = this.mComponentCenter;
                if (iComponentCenter != null) {
                    r95 = iComponentCenter.getViewLoader().getViewById(R.layout.h0e);
                } else {
                    r95 = 0;
                }
                if (r95 == 0) {
                    r95 = layoutInflater.inflate(R.layout.h0e, (ViewGroup) null);
                }
                ProfileAccountLevelReport.reportAccountLevelVisible(this.mQQAppInterface, (ProfileCardInfo) this.mData);
                this.mViewContainer = r95;
                z26 = true;
            } else {
                z26 = false;
            }
            ElegantProfileQQLevelView elegantProfileQQLevelView = (ElegantProfileQQLevelView) ((View) this.mViewContainer).findViewById(R.id.gre);
            elegantProfileQQLevelView.update((ProfileCardInfo) this.mData, this.mIsFromArkBabyQ);
            elegantProfileQQLevelView.setClickable(false);
            updateMedalView();
            updateNumPAGView();
            updateNoticeView(z16);
            boolean updateQQLevel = updateQQLevel(true);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f164472yw);
            if (!updateQQLevel) {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            ((View) this.mViewContainer).setTag(new com.tencent.mobileqq.profile.b(69, null));
            ((View) this.mViewContainer).setOnClickListener(this);
            ProfileCardDtReportUtil.initElementWithExposureClick((View) this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_LEVEL);
            z27 = z26;
        }
        IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (diyMoreInfoManager.isDiy() && (obj = this.mViewContainer) != null) {
            ((View) obj).setClickable(false);
            diyMoreInfoManager.updateLevelForDeepDiy((View) this.mViewContainer);
        }
        return z27;
    }
}
