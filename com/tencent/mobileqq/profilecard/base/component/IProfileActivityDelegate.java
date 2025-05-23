package com.tencent.mobileqq.profilecard.base.component;

import android.view.ViewGroup;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.multyple.IProfileCardMultiple;
import com.tencent.mobileqq.profilecard.zplan.IZPlanChangeTitleStatusListener;
import com.tencent.widget.AbsListView;

/* loaded from: classes16.dex */
public interface IProfileActivityDelegate {
    void addProfileScrollListener(AbsListView.OnScrollListener onScrollListener);

    void checkAndSwitch2Friend(boolean z16, boolean z17, String str);

    boolean enableFoldSplit();

    int getComponentBgResource();

    boolean getIsShowZplanCover();

    PullToZoomHeaderListView getListView();

    IProfileCardMultiple getProfileCardMultiple();

    IProfileCardMultiple getProfileCardMultiple(boolean z16);

    IProfileConfig getProfileConfig();

    ViewGroup getRootView();

    IZPlanChangeTitleStatusListener getZPlanChangeTitleStatusListener();

    boolean isForceRefreshDiyProfile();

    boolean isShowQCircleCover();

    boolean isShowVasCustomBgCover();

    void notifyCardUpdate();

    void notifyCardUpdate(Card card);

    void removeProfileScrollListener(AbsListView.OnScrollListener onScrollListener);

    void requestUpdateCard();

    void scrollToListTop();

    void scrollToMoreInfoView(int i3);

    void setInterceptTouchEvent(boolean z16);

    void setRemark(String str);

    void setZPlanChangeTitleStatusListener(IZPlanChangeTitleStatusListener iZPlanChangeTitleStatusListener);
}
