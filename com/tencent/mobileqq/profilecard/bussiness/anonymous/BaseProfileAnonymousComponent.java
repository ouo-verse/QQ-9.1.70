package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileCardFeatureSwitch;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes16.dex */
public class BaseProfileAnonymousComponent extends AbsProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    protected static final String DT_REPORT_ANONYMOUS = "em_profile_question";
    protected static final String DT_REPORT_PARAM_GUEST_EMPTY_IS_NEW = "profile_em_guest_empty_is_new";
    protected static final String DT_REPORT_PARAM_IS_EMPTY = "profile_em_is_empty";
    protected static final int DT_REPORT_PARAM_IS_NOT_EMPTY = 2;
    protected static final int DT_REPORT_PARAM_ITEM_IS_EMPTY = 1;
    public static final String TAG = "BaseProfileAnonymousComponent";
    private AnonymousObserver anonymousObserver;
    protected AnonymousView anonymousView;
    private boolean isInitDtReport;
    public final HashMap<String, Object> reportParams;

    public BaseProfileAnonymousComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.isInitDtReport = false;
        this.reportParams = new HashMap<>();
        this.anonymousObserver = new AnonymousObserver() { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.BaseProfileAnonymousComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProfileAnonymousComponent.this);
                }
            }

            @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver
            public void onLikeAnonymousAnswer(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                } else if (QLog.isColorLevel()) {
                    QLog.d(BaseProfileAnonymousComponent.TAG, 2, "onLikeAnonymousAnswer() success = " + z16);
                }
            }
        };
    }

    private void initDtElementReport(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(this.mViewContainer, this.reportParams);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<AnonymousQuestion> buildRecyclerAdapterData(List<AnonymousQuestion> list, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        boolean isHost = isHost();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("buildRecyclerAdapterData() isHost=%b, hasQuestion=%b , hasAnswer=%b ,hasMoreQues=%b ,", Boolean.valueOf(isHost), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18)));
        }
        ArrayList arrayList = new ArrayList();
        AnonymousQuestion anonymousQuestion = new AnonymousQuestion();
        if (isHost) {
            if (z16) {
                if (z17) {
                    arrayList.addAll(list);
                    if (list.size() > 10 || (list.size() == 10 && z18)) {
                        z19 = true;
                    }
                    if (z19) {
                        anonymousQuestion.uiState = 3;
                        arrayList.add(anonymousQuestion);
                    }
                } else {
                    anonymousQuestion.uiState = 2;
                    arrayList.add(anonymousQuestion);
                }
            } else {
                anonymousQuestion.uiState = 1;
                arrayList.add(anonymousQuestion);
            }
        } else if (z16 && z17) {
            anonymousQuestion.uiState = 5;
            arrayList.add(anonymousQuestion);
            arrayList.addAll(list);
        } else {
            anonymousQuestion.uiState = 4;
            arrayList.add(anonymousQuestion);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 1026;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_ANONYMOUS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected View initAnonymousView() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AnonymousView anonymousView = new AnonymousView(this.mActivity);
        this.anonymousView = anonymousView;
        anonymousView.setTitle(this.mActivity.getString(R.string.f197614kh));
        AnonymousView anonymousView2 = this.anonymousView;
        AppInterface appInterface = this.mApp;
        DATA data = this.mData;
        if (((ProfileCardInfo) data).currentTemplate != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        anonymousView2.initData(appInterface, z16, ((ProfileCardInfo) data).allInOne.uin);
        return this.anonymousView;
    }

    public boolean isGuestEmptyItemFold(ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, profileAnonymousAnswerInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if ((profileAnonymousAnswerInfo == null || profileAnonymousAnswerInfo.mAnsweredQuestionCount == 0) && !z16 && ProfileCardFeatureSwitch.INSTANCE.isVisitorProfileCardEmptySignEnable()) {
            return true;
        }
        return false;
    }

    public boolean isGuestEmptyItemFoldNewProfileCard(ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, profileAnonymousAnswerInfo, Boolean.valueOf(z16))).booleanValue();
        }
        if ((profileAnonymousAnswerInfo == null || profileAnonymousAnswerInfo.mAnsweredQuestionCount == 0) && !z16) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshAnonymous(Card card) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) card)).booleanValue();
        }
        ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo = (ProfileAnonymousAnswerInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileAnonymousAnswerInfo.class);
        IProfileConfig iProfileConfig = this.mConfigHelper;
        boolean z27 = false;
        if (iProfileConfig != null && !iProfileConfig.isSwitchEnable(13)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(42425, card, this.mApp) != 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isPaTypeFriend = ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo) this.mData).allInOne);
        boolean isHost = isHost();
        boolean isOwnerProfileCardEmptyItemFoldEnable = ProfileCardFeatureSwitch.INSTANCE.isOwnerProfileCardEmptyItemFoldEnable();
        if (profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.mTotalQuestionCount > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (isHost && isOwnerProfileCardEmptyItemFoldEnable && !z18) {
            z19 = true;
        } else {
            z19 = false;
        }
        boolean isGuestEmptyItemFold = isGuestEmptyItemFold(profileAnonymousAnswerInfo, isHost);
        if ((card == null || profileAnonymousAnswerInfo == null || !profileAnonymousAnswerInfo.needForbidEntry) && !z19 && !isGuestEmptyItemFold) {
            z26 = false;
        } else {
            z26 = true;
        }
        HashMap<String, Object> hashMap = this.reportParams;
        if (z18) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("profile_em_is_empty", Integer.valueOf(i3));
        HashMap<String, Object> hashMap2 = this.reportParams;
        if (isGuestEmptyItemFold(profileAnonymousAnswerInfo, isHost)) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        hashMap2.put("profile_em_guest_empty_is_new", Integer.valueOf(i16));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshAnonymous() configEnable=%b, visible=%b , isFriend=%b ,isForbidEntry=%b", Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(isPaTypeFriend), Boolean.valueOf(z26)));
        }
        if (!z26 && z16 && z17 && isPaTypeFriend) {
            if (this.mViewContainer == 0) {
                this.mViewContainer = initAnonymousView();
                if (isHost()) {
                    str = "";
                } else {
                    str = ((ProfileCardInfo) this.mData).allInOne.uin;
                }
                String str4 = str;
                if (isHost()) {
                    str2 = "0X800B461";
                } else {
                    str2 = "0X800B462";
                }
                if (isHost()) {
                    str3 = "0X800B461";
                } else {
                    str3 = "0X800B462";
                }
                ReportController.o(null, "dc00898", "", str4, str2, str3, 0, 0, "", "", "", "");
                z27 = true;
            }
            refreshAnonymousUI(profileAnonymousAnswerInfo, this.anonymousView);
            return z27;
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IProfileActivityDelegate iProfileActivityDelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 4660 && (iProfileActivityDelegate = this.mDelegate) != null) {
            iProfileActivityDelegate.requestUpdateCard();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
            this.mApp.addObserver(this.anonymousObserver);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mApp.removeObserver(this.anonymousObserver);
        AnonymousView anonymousView = this.anonymousView;
        if (anonymousView != null) {
            anonymousView.destroy();
        }
        super.onDestroy();
    }

    protected void refreshAnonymousUI(ProfileAnonymousAnswerInfo profileAnonymousAnswerInfo, AnonymousView anonymousView) {
        boolean z16;
        boolean z17;
        boolean z18;
        List<AnonymousQuestion> arrayList;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) profileAnonymousAnswerInfo, (Object) anonymousView);
            return;
        }
        updateItemTheme((ProfileContentTitleView) anonymousView, true);
        if (profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.mTotalQuestionCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (profileAnonymousAnswerInfo != null && profileAnonymousAnswerInfo.mAnonymousQuestions.size() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && profileAnonymousAnswerInfo.mTotalQuestionCount > profileAnonymousAnswerInfo.mAnonymousQuestions.size()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16) {
            if (isHost()) {
                i3 = R.string.f197644kk;
            } else {
                i3 = R.string.f197684ko;
            }
            if (isHost()) {
                i16 = profileAnonymousAnswerInfo.mTotalQuestionCount;
            } else {
                i16 = profileAnonymousAnswerInfo.mAnsweredQuestionCount;
            }
            if (i16 > 0) {
                String format = String.format(this.mActivity.getString(i3), Integer.valueOf(i16));
                TextView textView = new TextView(this.mActivity);
                textView.setText(format);
                anonymousView.mTitleExtContainer.removeAllViews();
                anonymousView.mTitleExtContainer.addView(textView);
                anonymousView.mTitleExtContainer.setVisibility(0);
                updateItemTheme((TextView) null, textView);
            }
        }
        if (AnonymousRedPointUtils.showProfileRedPointGuide(this.mApp) && isHost()) {
            Drawable drawable = anonymousView.getResources().getDrawable(R.drawable.skin_tips_dot);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            anonymousView.mTitleText.setCompoundDrawables(null, null, drawable, null);
            anonymousView.mTitleText.setCompoundDrawablePadding(Utils.n(4.0f, anonymousView.getResources()));
        }
        if (profileAnonymousAnswerInfo != null) {
            arrayList = profileAnonymousAnswerInfo.mAnonymousQuestions;
        } else {
            arrayList = new ArrayList<>();
        }
        anonymousView.show(buildRecyclerAdapterData(arrayList, z16, z17, z18));
        updateItemTheme((TextView) null, (View) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean onDataUpdate = super.onDataUpdate((BaseProfileAnonymousComponent) profileCardInfo) | makeOrRefreshAnonymous(((ProfileCardInfo) this.mData).card);
        if (onDataUpdate && !this.isInitDtReport) {
            this.isInitDtReport = true;
            initDtElementReport((View) this.mViewContainer, DT_REPORT_ANONYMOUS);
        }
        return onDataUpdate;
    }
}
