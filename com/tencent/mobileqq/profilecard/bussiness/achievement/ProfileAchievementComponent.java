package com.tencent.mobileqq.profilecard.bussiness.achievement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.bean.ProfileLifeAchievementInfo;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementHandler;
import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementObserver;
import com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileAchievementComponent extends AbsProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileAchievementComponent";
    private Handler mHandler;
    private boolean mHasScrollToAchievement;
    private LifeAchievementObserver mLifeAchievementObserver;
    private boolean mScrollToAchievement;

    public ProfileAchievementComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mLifeAchievementObserver = new LifeAchievementObserver() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileAchievementComponent.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementObserver
                protected void onPraiseLifeAchievement(boolean z16, int i3, int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfileAchievementComponent.TAG, 2, String.format("onPraiseLifeAchievement isSuccess=%s actionType=%s achievementId=%s", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16)));
                    }
                    ProfileAchievementComponent.this.handlePraiseLifeAchievementResponse(z16, i3, i16);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void handlePraiseLifeAchievementResponse(boolean z16, int i3, int i16) {
        ArrayList<LifeAchivementData> arrayList;
        if (!z16) {
            ProfileLifeAchievementInfo profileLifeAchievementInfo = (ProfileLifeAchievementInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileLifeAchievementInfo.class);
            if (profileLifeAchievementInfo != null && (arrayList = profileLifeAchievementInfo.lifeAchievementList) != null) {
                Iterator<LifeAchivementData> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LifeAchivementData next = it.next();
                    if (next.f260664id == i16) {
                        if (i3 == 1) {
                            next.praiseNum--;
                            next.hasPraised = false;
                        } else if (i3 == 2) {
                            next.praiseNum++;
                            next.hasPraised = true;
                        }
                    }
                }
            }
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            QQToast.makeText(applicationContext, applicationContext.getString(R.string.cpp), 0).show();
        }
        if (this.mViewContainer != 0) {
            makeOrRefreshLifeAchievement(((ProfileCardInfo) this.mData).card, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementPanelView, com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView, VIEW] */
    private boolean makeOrRefreshLifeAchievement(Card card, boolean z16) {
        boolean z17;
        boolean z18;
        String str;
        int i3;
        ArrayList<LifeAchivementData> arrayList;
        ProfileLifeAchievementInfo profileLifeAchievementInfo = (ProfileLifeAchievementInfo) ((ProfileCardInfo) this.mData).getBusinessInfo(ProfileLifeAchievementInfo.class);
        boolean z19 = false;
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (profileLifeAchievementInfo != null && (arrayList = profileLifeAchievementInfo.lifeAchievementList) != null && !arrayList.isEmpty()) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean shouldShowAchivementPanelOrNot = LifeAchivementHelper.shouldShowAchivementPanelOrNot(card, this.mConfigHelper, z17, z18);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("makeOrRefreshLifeAchievement isSelf=%s hasLifeAchievement=%s showLifeAchievement=%s", Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(shouldShowAchivementPanelOrNot)));
        }
        if (!shouldShowAchivementPanelOrNot) {
            if (this.mViewContainer != 0) {
                this.mViewContainer = null;
                return true;
            }
        } else {
            if (this.mViewContainer == 0) {
                ?? lifeAchivementPanelView = new LifeAchivementPanelView(this.mActivity);
                lifeAchivementPanelView.setLifeAchievementHandler((LifeAchievementHandler) this.mApp.getBusinessHandler(LifeAchievementHandler.class.getName()));
                lifeAchivementPanelView.setTitle(this.mActivity.getString(R.string.zof));
                this.mViewContainer = lifeAchivementPanelView;
                z19 = true;
            }
            LifeAchivementPanelView lifeAchivementPanelView2 = (LifeAchivementPanelView) this.mViewContainer;
            if (profileLifeAchievementInfo != null) {
                str = profileLifeAchievementInfo.lifeAchievementOpenId;
            } else {
                str = "";
            }
            lifeAchivementPanelView2.updateUserInfo((ProfileCardInfo) this.mData, card, str);
            updateLifeAchievementView(profileLifeAchievementInfo, z18, lifeAchivementPanelView2);
            if (z17) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(this.mApp, "", "", "", "0X800AE53", "0X800AE53", i3, 0, "", "", "", "");
        }
        return z19;
    }

    private void scrollToAchievement() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileAchievementComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int top;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (((AbsComponent) ProfileAchievementComponent.this).mViewContainer != null && (top = ((View) ((AbsComponent) ProfileAchievementComponent.this).mViewContainer).getTop()) >= 0 && ((AbsProfileComponent) ProfileAchievementComponent.this).mDelegate != null) {
                        ((AbsProfileComponent) ProfileAchievementComponent.this).mDelegate.scrollToMoreInfoView(top);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateLifeAchievementView(ProfileLifeAchievementInfo profileLifeAchievementInfo, boolean z16, LifeAchivementPanelView lifeAchivementPanelView) {
        updateItemTheme((ProfileContentTitleView) lifeAchivementPanelView, true);
        boolean z17 = false;
        if (z16) {
            String format = String.format(this.mActivity.getString(R.string.f199664q1), Integer.valueOf(profileLifeAchievementInfo.lifeAchievementTotalCount));
            TextView textView = new TextView(this.mActivity);
            textView.setText(format);
            lifeAchivementPanelView.mTitleExtContainer.removeAllViews();
            lifeAchivementPanelView.mTitleExtContainer.addView(textView);
            lifeAchivementPanelView.mTitleExtContainer.setVisibility(0);
            lifeAchivementPanelView.showAchivementList(profileLifeAchievementInfo.lifeAchievementList, profileLifeAchievementInfo.lifeAchievementTotalCount);
            updateItemTheme((TextView) null, textView);
        } else {
            lifeAchivementPanelView.mTitleExtContainer.removeAllViews();
            lifeAchivementPanelView.mTitleExtContainer.setVisibility(8);
            lifeAchivementPanelView.showEmptyView();
            boolean isInNightMode = ThemeUtil.isInNightMode(this.mApp);
            if (((ProfileCardInfo) this.mData).currentTemplate != null) {
                z17 = true;
            }
            if (isInNightMode || z17) {
                ((URLImageView) lifeAchivementPanelView.findViewById(R.id.yc7)).setVisibility(4);
            }
            TextView textView2 = (TextView) lifeAchivementPanelView.findViewById(R.id.k4h);
            TextView textView3 = (TextView) lifeAchivementPanelView.findViewById(R.id.k4i);
            updateItemTheme(textView2, (View) null);
            updateItemTheme(textView3, (View) null);
        }
        if (this.mScrollToAchievement && !this.mHasScrollToAchievement) {
            this.mHasScrollToAchievement = true;
            scrollToAchievement();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1007;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_LIFE_ACHIEVEMENT;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.mScrollToAchievement = intent.getBooleanExtra(IProfileCardConst.PROFILE_SCROLL_TO_ACHIEVEMENT, false);
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mApp.addObserver(this.mLifeAchievementObserver);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        this.mApp.removeObserver(this.mLifeAchievementObserver);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileAchievementComponent) profileCardInfo);
        DATA data = this.mData;
        return lambda$checkValidComponent$3 | makeOrRefreshLifeAchievement(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
    }
}
