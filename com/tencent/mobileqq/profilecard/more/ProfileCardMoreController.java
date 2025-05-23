package com.tencent.mobileqq.profilecard.more;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent;
import com.tencent.mobileqq.profilecard.more.component.DividerComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes35.dex */
public class ProfileCardMoreController {
    private static final String TAG = "ProfileCardMoreController";
    public Activity mActivity;
    public AllInOne mAllInOne;
    public AppInterface mApp;
    public Card mCard;
    private final List<AbsMoreComponent> mComponents = new ArrayList();
    public ViewGroup mRootView;
    public String mTargetUin;

    public ProfileCardMoreController(ViewGroup viewGroup, AppInterface appInterface, Activity activity, AllInOne allInOne) {
        this.mRootView = viewGroup;
        this.mApp = appInterface;
        this.mTargetUin = allInOne.uin;
        this.mActivity = activity;
        this.mAllInOne = allInOne;
    }

    private DividerComponent getDividerComponent() {
        return (DividerComponent) ProfileCardMoreComponentCreator.createComponent(ProfileCardMoreConstants.MORE_COMPONENT_KEY_DIVIDER, this);
    }

    private void initComponent() {
        addComponent(ProfileCardMoreConstants.MORE_COMPONENT_KEY_BASIC_DATA);
        addComponent(ProfileCardMoreConstants.MORE_COMPONENT_KEY_PERSONALITY_LABEL);
        addComponent(ProfileCardMoreConstants.MORE_COMPONENT_KEY_PRESENT_WALL);
        addComponent(ProfileCardMoreConstants.MORE_COMPONENT_KEY_MEDAL);
    }

    private boolean isNeedDivider(int i3, int i16) {
        if (i3 != 0 && i16 != i3) {
            return true;
        }
        return false;
    }

    public void addComponent(int i3) {
        AbsMoreComponent createComponent = ProfileCardMoreComponentCreator.createComponent(i3, this);
        if (createComponent == null) {
            QLog.e(TAG, 1, "addComponent-> component == null");
        } else {
            this.mComponents.add(createComponent);
        }
    }

    public String getString(int i3) {
        Activity activity = this.mActivity;
        if (activity == null) {
            QLog.e(TAG, 1, "mActivity is null");
            return "";
        }
        return activity.getString(i3);
    }

    public void initDtElementReport(View view, String str, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
    }

    public boolean isFriend(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG);
    }

    public boolean isNightMode() {
        return ThemeUtil.isNowThemeIsNight(this.mApp, false, null);
    }

    public boolean isSelf() {
        AppInterface appInterface;
        if (!TextUtils.isEmpty(this.mTargetUin) && (appInterface = this.mApp) != null) {
            return appInterface.getCurrentAccountUin().equals(this.mTargetUin);
        }
        QLog.e(TAG, 1, "mTargetUin is null or mApp == null");
        return false;
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i3, i16, intent);
        }
    }

    public void onCreate(LayoutInflater layoutInflater) {
        updateCard();
        initComponent();
        removeComponentIfNotNeedShow();
        initDividerComponents(this.mComponents);
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onCreate(layoutInflater);
        }
        updateComponent();
    }

    public void onDestroy() {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mRootView = null;
        this.mApp = null;
        this.mTargetUin = null;
        this.mActivity = null;
        this.mAllInOne = null;
        this.mCard = null;
    }

    public void onPause() {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void onResume() {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public void onStart() {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    public void onStop() {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void removeComponent(AbsMoreComponent absMoreComponent) {
        this.mComponents.remove(absMoreComponent);
    }

    public void removeComponentIfNotNeedShow() {
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            if (!it.next().isNeedShow()) {
                it.remove();
            }
        }
    }

    public void updateCard() {
        this.mCard = ((IProfileDataService) this.mApp.getRuntimeService(IProfileDataService.class, "all")).getProfileCard(this.mTargetUin, true);
    }

    public void updateComponent() {
        this.mRootView.removeAllViews();
        Iterator<AbsMoreComponent> it = this.mComponents.iterator();
        while (it.hasNext()) {
            View viewContainer = it.next().getViewContainer();
            if (viewContainer != null) {
                this.mRootView.addView(viewContainer);
            }
        }
    }

    private void initDividerComponents(List<AbsMoreComponent> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (AbsMoreComponent absMoreComponent : list) {
            if (absMoreComponent != null && !(absMoreComponent instanceof DividerComponent) && absMoreComponent.isNeedShow()) {
                if (isNeedDivider(i3, absMoreComponent.getPartIndex())) {
                    arrayList.add(getDividerComponent());
                }
                arrayList.add(absMoreComponent);
                i3 = absMoreComponent.getPartIndex();
            }
        }
        list.clear();
        list.addAll(arrayList);
    }
}
