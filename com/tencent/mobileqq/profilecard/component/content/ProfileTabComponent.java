package com.tencent.mobileqq.profilecard.component.content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreFragment;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileTabUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.widget.TabContainer;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes35.dex */
public class ProfileTabComponent extends AbsQQProfileContentComponent {
    private static final String TAG = "ProfileTabComponent";
    private final CardObserver cardObserver;
    private boolean isInitDtReport;
    private TabContainer tabContainer;
    private final ArrayList<TabContainer.Tab> tabList;

    public ProfileTabComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.tabList = new ArrayList<>();
        this.isInitDtReport = false;
        this.cardObserver = new CardObserver() { // from class: com.tencent.mobileqq.profilecard.component.content.ProfileTabComponent.2
            @Override // com.tencent.mobileqq.app.CardObserver
            protected void onMedalCountGuest(boolean z16, final int i3) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.content.ProfileTabComponent.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((AbsComponent) ProfileTabComponent.this).mData == null || ((ProfileCardInfo) ((AbsComponent) ProfileTabComponent.this).mData).card == null || ((ProfileCardInfo) ((AbsComponent) ProfileTabComponent.this).mData).card.iMedalCount == i3) {
                            return;
                        }
                        ((ProfileCardInfo) ((AbsComponent) ProfileTabComponent.this).mData).card.iMedalCount = i3;
                        ProfileTabComponent profileTabComponent = ProfileTabComponent.this;
                        profileTabComponent.makeOrRefreshUi((ProfileCardInfo) ((AbsComponent) profileTabComponent).mData);
                    }
                });
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void adapterNightTheme(boolean z16) {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((View) view).setBackgroundColor(z16 ? -16777216 : -1);
            this.tabContainer.setBackgroundColor(z16 ? -16777216 : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshUi(final ProfileCardInfo profileCardInfo) {
        Card card = profileCardInfo.card;
        boolean z16 = false;
        if (card == null) {
            return false;
        }
        boolean z17 = !this.mApp.getCurrentAccountUin().equals(card.uin);
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.mApp, false, null);
        List<TabContainer.Tab> mergedTab = ProfileTabUtils.getMergedTab(ProfileTabUtils.getBaseAccountTab(profileCardInfo), ProfileTabUtils.getPersonalityLabelTab(profileCardInfo, this.mApp));
        if (mergedTab.size() == 0 && z17) {
            mergedTab = ProfileTabUtils.getPresentAndMedalList(profileCardInfo);
        }
        boolean z18 = mergedTab.size() > 0;
        if (z18 && this.mViewContainer == 0) {
            ?? inflate = View.inflate(this.mActivity, R.layout.czk, null);
            this.mViewContainer = inflate;
            View findViewById = inflate.findViewById(R.id.f163213ox2);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.component.content.ProfileTabComponent.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (u.a().b()) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra(ProfileCardMoreConstants.KEY_ALL_IN_ONE, profileCardInfo.allInOne);
                    ProfileCardMoreFragment.openProfileCardMore(((AbsComponent) ProfileTabComponent.this).mActivity, intent, 1038);
                    ProfileCardDtReportUtil.dtReportClick(view);
                }
            });
            findViewById.setClickable(!ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne));
            TabContainer tabContainer = (TabContainer) ((View) this.mViewContainer).findViewById(R.id.f163212ox1);
            this.tabContainer = tabContainer;
            tabContainer.setIsShowMore(!ProfilePAUtils.isPaTypeStrangerInContact(profileCardInfo.allInOne));
            updateItemTheme(findViewById, null, null, null);
            z16 = true;
        } else if (!z18) {
            if (this.mViewContainer == 0) {
                return false;
            }
            this.mViewContainer = null;
            return true;
        }
        this.tabList.clear();
        this.tabList.addAll(mergedTab);
        this.tabContainer.setNightTheme(isNowThemeIsNight);
        this.tabContainer.setData(this.tabList);
        adapterNightTheme(isNowThemeIsNight);
        return z16;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1036;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_TAB_LIST;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        this.mActivity.addObserver(this.cardObserver);
        if (ProfileUtils.isFriend(this.mApp, ((ProfileCardInfo) this.mData).allInOne.uin)) {
            return;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.component.content.ProfileTabComponent.1
            @Override // java.lang.Runnable
            public void run() {
                ((CardHandler) ((AbsComponent) ProfileTabComponent.this).mApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a3(((ProfileCardInfo) ((AbsComponent) ProfileTabComponent.this).mData).allInOne.uin);
            }
        });
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        this.mActivity.removeObserver(this.cardObserver);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        boolean makeOrRefreshUi = makeOrRefreshUi(profileCardInfo) | super.lambda$checkValidComponent$3((ProfileTabComponent) profileCardInfo);
        if (makeOrRefreshUi && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_TAG);
        }
        return makeOrRefreshUi;
    }
}
