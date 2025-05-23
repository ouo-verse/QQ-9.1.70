package com.tencent.mobileqq.profilecard.bussiness.accountinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.report.ProfileAccountInfoReport;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileAccountInfoHeaderComponent extends ProfileAccountInfoV2Component {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileAccountInfoHeaderComponent";

    public ProfileAccountInfoHeaderComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private SpannableStringBuilder combineAccountInfo(List<SpannableString> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            spannableStringBuilder.append((CharSequence) list.get(i3));
            if (i3 != size - 1) {
                spannableStringBuilder.append((CharSequence) " ");
            }
        }
        return spannableStringBuilder;
    }

    private List<SpannableString> getAccountInfo(AppInterface appInterface, Context context, ProfileCardInfo profileCardInfo) {
        ArrayList arrayList = new ArrayList();
        short genderWithPrivacy = ProfileAccountInfoUtils.getGenderWithPrivacy(profileCardInfo);
        if (genderWithPrivacy == 0) {
            arrayList.add(new SpannableString(context.getString(R.string.c7_)));
        } else if (genderWithPrivacy == 1) {
            arrayList.add(new SpannableString(context.getString(R.string.b5e)));
        }
        String schoolWithPrivacy = ProfileAccountInfoUtils.getSchoolWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(schoolWithPrivacy)) {
            if (profileCardInfo.card.schoolVerifiedFlag) {
                arrayList.add(((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).makeSchoolAuthenticationIcon(schoolWithPrivacy, true, R.drawable.ne8, R.dimen.d6f, R.dimen.d6e, context, appInterface));
            } else {
                arrayList.add(new SpannableString(schoolWithPrivacy));
            }
        }
        String companyWithPrivacy = ProfileAccountInfoUtils.getCompanyWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(companyWithPrivacy)) {
            arrayList.add(new SpannableString(companyWithPrivacy));
        }
        String locationCountryWithPrivacy = ProfileAccountInfoUtils.getLocationCountryWithPrivacy(profileCardInfo);
        String locationProvinceWithPrivacy = ProfileAccountInfoUtils.getLocationProvinceWithPrivacy(profileCardInfo);
        String locationCityWithPrivacy = ProfileAccountInfoUtils.getLocationCityWithPrivacy(profileCardInfo);
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(locationCountryWithPrivacy) && !HardCodeUtil.qqStr(R.string.pdw).equals(locationCountryWithPrivacy)) {
            sb5.append(locationCountryWithPrivacy);
        }
        if (!TextUtils.isEmpty(locationProvinceWithPrivacy)) {
            if (sb5.length() > 0) {
                sb5.append("-");
            }
            sb5.append(locationProvinceWithPrivacy);
        }
        if (!TextUtils.isEmpty(locationCityWithPrivacy)) {
            if (sb5.length() > 0) {
                sb5.append("-");
            }
            sb5.append(locationCityWithPrivacy);
        }
        if (sb5.length() > 0) {
            arrayList.add(new SpannableString(sb5.toString()));
        }
        String constellationWithPrivacy = ProfileAccountInfoUtils.getConstellationWithPrivacy(profileCardInfo);
        if (!TextUtils.isEmpty(constellationWithPrivacy)) {
            arrayList.add(new SpannableString(constellationWithPrivacy));
        }
        if (arrayList.size() >= 4) {
            return arrayList.subList(0, 3);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initAccountInfo() {
        if (this.mViewContainer != 0) {
            this.mActivity.getLayoutInflater().inflate(R.layout.h0h, (ViewGroup) this.mViewContainer);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ClickableViewAccessibility"})
    private void refreshAccountInfo(Card card, boolean z16) {
        boolean z17;
        if (this.mViewContainer != 0) {
            List<SpannableString> accountInfo = getAccountInfo(this.mApp, this.mActivity, (ProfileCardInfo) this.mData);
            boolean isEmpty = accountInfo.isEmpty();
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (isEmpty && z17) {
                accountInfo.add(new SpannableString(this.mActivity.getString(R.string.fpz)));
            }
            boolean z18 = !accountInfo.isEmpty();
            boolean isSwitchEnable = this.mConfigHelper.isSwitchEnable(12);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("refreshAccountInfo showAccountInfo=%s baseInfoABTestEnable=%s", Boolean.valueOf(z18), Boolean.valueOf(isSwitchEnable)));
            }
            if (z18 && !isSwitchEnable) {
                ((View) this.mViewContainer).setVisibility(0);
                TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.jfb);
                if (textView != null) {
                    textView.setText(combineAccountInfo(accountInfo));
                    textView.setOnTouchListener(ba.f77070d);
                    textView.setOnClickListener(this);
                    if (!isEmpty) {
                        ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).dealTextViewForCopyAction(textView, null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            ((View) this.mViewContainer).setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1024;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component, android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view.getId() == R.id.jfb) {
            boolean z16 = false;
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0 && ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit()) {
                ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileEdit(this.mActivity, ((ProfileCardInfo) this.mData).allInOne, false);
            } else {
                ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).jumpProfileOpenDetails((ProfileCardInfo) this.mData, this.mApp, this.mActivity);
            }
            if (((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).isDefaultProfile((ProfileCardInfo) this.mData)) {
                if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                    z16 = true;
                }
                AppInterface appInterface = this.mApp;
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = 4;
                }
                ProfileAccountInfoReport.reportAccountInfoClick(appInterface, i3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
            initAccountInfo();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.accountinfo.BaseProfileAccountInfoV2Component, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        DATA data = this.mData;
        refreshAccountInfo(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        PrettyAccountUtil.reportLhEventForCard(this.mApp, (ProfileCardInfo) this.mData, false);
        return true;
    }
}
