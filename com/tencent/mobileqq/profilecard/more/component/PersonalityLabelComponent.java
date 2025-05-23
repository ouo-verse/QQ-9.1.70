package com.tencent.mobileqq.profilecard.more.component;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.c;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreController;
import com.tencent.mobileqq.profilecard.more.widget.ComponentTitleView;
import com.tencent.mobileqq.profilecard.utils.PersonalityLabelUtil;
import com.tencent.mobileqq.profilecard.widget.TabContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes35.dex */
public class PersonalityLabelComponent extends AbsMoreComponent {
    private static final int TAB_CONTAINER_MAX_LINE = 20;
    private static final String TAG = "PersonalityLabelComponent";
    private Card mCard;
    private boolean mClicked;
    private ProfilePersonalityLabelInfo mLabelInfo;
    private final c mPersonalityLabelObserver;
    private TabContainer mTabContainer;

    public PersonalityLabelComponent(ProfileCardMoreController profileCardMoreController) {
        super(profileCardMoreController);
        this.mPersonalityLabelObserver = new c() { // from class: com.tencent.mobileqq.profilecard.more.component.PersonalityLabelComponent.1
            private boolean isGetPersonalityLabelSuccess(boolean z16, String str) {
                ProfileCardMoreController profileCardMoreController2 = PersonalityLabelComponent.this.mMoreController;
                return profileCardMoreController2 != null && z16 && TextUtils.equals(str, profileCardMoreController2.mTargetUin);
            }

            @Override // com.tencent.mobileqq.profile.PersonalityLabel.c
            public void onGetPersonalityLabel(boolean z16, String str, ProfilePersonalityLabelInfo profilePersonalityLabelInfo, byte[] bArr, int i3) {
                QLog.i(PersonalityLabelComponent.TAG, 2, String.format("onGetPersonalityLabel isSuccess=%s uin=%s flag=%s", Boolean.valueOf(z16), str, Integer.valueOf(i3)));
                if (isGetPersonalityLabelSuccess(z16, str)) {
                    PersonalityLabelComponent.this.handleResponse(profilePersonalityLabelInfo);
                }
            }
        };
    }

    private View bindRootView() {
        Activity activity;
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || (activity = profileCardMoreController.mActivity) == null || this.mViewContainer == null) {
            return null;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.czc, (ViewGroup) null);
        this.mViewContainer.addComponentContent(inflate);
        return inflate;
    }

    private List<String> getLabelStringList(List<PersonalityLabelInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (PersonalityLabelInfo personalityLabelInfo : list) {
            if (personalityLabelInfo != null) {
                arrayList.add(personalityLabelInfo.text);
            }
        }
        return arrayList;
    }

    private String getNickName() {
        Card card = this.mCard;
        if (card == null) {
            return "";
        }
        if (!TextUtils.isEmpty(card.strReMark)) {
            return this.mCard.strReMark;
        }
        if (!TextUtils.isEmpty(this.mCard.strNick)) {
            return this.mCard.strNick;
        }
        return this.mCard.uin;
    }

    private String getString(int i3) {
        Activity activity;
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null && (activity = profileCardMoreController.mActivity) != null && activity.getResources() != null) {
            return this.mMoreController.mActivity.getResources().getString(i3);
        }
        return "";
    }

    private List<TabContainer.Tab> getTabList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(TabContainer.Tab.create(str));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponse(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        if (this.mCard == null || profilePersonalityLabelInfo == null) {
            return;
        }
        this.mLabelInfo = profilePersonalityLabelInfo;
        updateUiByLabelInfo(profilePersonalityLabelInfo);
    }

    private void hideAll() {
        ComponentTitleView componentTitleView = this.mViewContainer;
        if (componentTitleView != null) {
            componentTitleView.setVisibility(8);
        }
        TabContainer tabContainer = this.mTabContainer;
        if (tabContainer != null) {
            tabContainer.setVisibility(8);
        }
    }

    private boolean hideAllIfNeed() {
        ProfileCardMoreController profileCardMoreController;
        if (this.mCard != null && (profileCardMoreController = this.mMoreController) != null) {
            if (PersonalityLabelUtil.isNeedShowPersonalityLabel(profileCardMoreController.mAllInOne, this.mLabelInfo, profileCardMoreController.mApp)) {
                return false;
            }
            hideAll();
            return true;
        }
        hideAll();
        QLog.e(TAG, 1, "hideAll, mCard = " + this.mCard + " mMoreController = " + this.mMoreController);
        return true;
    }

    private void initTitleBar() {
        ComponentTitleView componentTitleView = this.mViewContainer;
        if (componentTitleView == null) {
            return;
        }
        componentTitleView.setTitle(R.string.x4f);
        this.mViewContainer.setOnClickListener(this);
        this.mViewContainer.setVisibility(8);
        this.mMoreController.initDtElementReport(this.mViewContainer, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_TAG_GOODLIST, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
    }

    private void jumpToLabelGalleryPage() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || profileCardMoreController.mActivity == null) {
            return;
        }
        Intent intent = new Intent(this.mMoreController.mActivity, (Class<?>) PersonalityLabelGalleryActivity.class);
        intent.putExtra("uin", this.mCard.uin);
        if (!this.mMoreController.isSelf()) {
            intent.putExtra("nickname", getNickName());
        }
        this.mMoreController.mActivity.startActivityForResult(intent, 1029);
    }

    private void jumpToWhoPraiseMePage() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || profileCardMoreController.mActivity == null) {
            return;
        }
        Intent intent = new Intent(this.mMoreController.mActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
        this.mMoreController.mActivity.startActivity(intent);
    }

    private void requestLabelInfo() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || profileCardMoreController.mApp == null) {
            return;
        }
        QLog.i(TAG, 2, "requestLabelInfo");
        PersonalityLabelHandler personalityLabelHandler = (PersonalityLabelHandler) this.mMoreController.mApp.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL);
        if (personalityLabelHandler == null) {
            return;
        }
        personalityLabelHandler.F2(this.mMoreController.mTargetUin, 0);
    }

    private void updateUiByCache() {
        this.mMoreController.updateCard();
        Card card = this.mMoreController.mCard;
        if (card != null) {
            this.mCard = card;
            updateUiByLabelInfo((ProfilePersonalityLabelInfo) card.getBusinessInfo(ProfilePersonalityLabelInfo.class));
        }
    }

    private void updateUiByLabelInfo(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        if (this.mMoreController == null || this.mViewContainer == null || this.mTabContainer == null || profilePersonalityLabelInfo == null) {
            return;
        }
        QLog.i(TAG, 2, "updateUiByLabelInfo");
        if (hideAllIfNeed()) {
            QLog.i(TAG, 2, "updateUiByLabelInfo hideAll");
        } else if (isLabelInfoEmpty(profilePersonalityLabelInfo)) {
            handleLabelListEmpty();
        } else {
            handleLabelListNotEmpty(profilePersonalityLabelInfo.praiseCount, getLabelStringList(profilePersonalityLabelInfo.personalityLabelInfos));
        }
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getComponentKey() {
        return ProfileCardMoreConstants.MORE_COMPONENT_KEY_PERSONALITY_LABEL;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getPartIndex() {
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mClicked || this.mViewContainer == null || this.mMoreController == null || this.mLabelInfo == null) {
            return;
        }
        this.mClicked = true;
        QLog.i(TAG, 2, "handleOnClick");
        if (view == this.mViewContainer && this.mMoreController.isSelf() && !isLabelInfoEmpty(this.mLabelInfo)) {
            jumpToWhoPraiseMePage();
            VideoReport.reportEvent("dt_clck", this.mViewContainer, null);
        } else {
            jumpToLabelGalleryPage();
            VideoReport.reportEvent("dt_clck", this.mTabContainer, null);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onCreate(LayoutInflater layoutInflater) {
        AppInterface appInterface;
        super.onCreate(layoutInflater);
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null && (appInterface = profileCardMoreController.mApp) != null) {
            this.mCard = profileCardMoreController.mCard;
            appInterface.addObserver(this.mPersonalityLabelObserver);
            if (hideAllIfNeed()) {
                return;
            }
            initTitleBar();
            initAndShowContent(bindRootView());
            updateUiByCache();
            QLog.i(TAG, 2, "onCreate success");
            return;
        }
        QLog.e(TAG, 1, "onCreate mMoreController or mApp is null");
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onDestroy() {
        AppInterface appInterface;
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController != null && (appInterface = profileCardMoreController.mApp) != null) {
            appInterface.removeObserver(this.mPersonalityLabelObserver);
        }
        this.mCard = null;
        this.mLabelInfo = null;
        this.mTabContainer = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onResume() {
        super.onResume();
        this.mClicked = false;
        requestLabelInfo();
    }

    private void handleLabelListEmpty() {
        QLog.i(TAG, 2, "handleLabelListEmpty");
        if (this.mMoreController.isSelf()) {
            this.mViewContainer.setVisibility(0);
            this.mViewContainer.setRightTxt(getString(R.string.x5k));
            this.mTabContainer.setVisibility(8);
            return;
        }
        hideAll();
    }

    private void handleLabelListNotEmpty(int i3, List<String> list) {
        QLog.i(TAG, 2, "handleLabelListNotEmpty");
        this.mViewContainer.setVisibility(0);
        this.mViewContainer.setRightTxt(getTitleRightString(i3));
        this.mTabContainer.setVisibility(0);
        this.mTabContainer.setIsShowMore(false);
        this.mTabContainer.setMaxLine(20);
        this.mTabContainer.setNightTheme(this.mMoreController.isNightMode());
        this.mTabContainer.setData(getTabList(list));
    }

    private boolean isLabelInfoEmpty(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        List<PersonalityLabelInfo> list;
        return profilePersonalityLabelInfo == null || (list = profilePersonalityLabelInfo.personalityLabelInfos) == null || list.isEmpty();
    }

    private String getTitleRightString(int i3) {
        if (i3 > 0) {
            return String.format(getString(R.string.x5n), Integer.valueOf(i3));
        }
        return "";
    }

    private void initAndShowContent(View view) {
        if (view == null) {
            return;
        }
        TabContainer tabContainer = (TabContainer) view.findViewById(R.id.f163210ow4);
        this.mTabContainer = tabContainer;
        tabContainer.setOnClickListener(this);
        this.mMoreController.initDtElementReport(this.mTabContainer, ProfileCardMoreConstants.DT_EM_PROFILE_MORE_TAG, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_FIRST);
    }
}
