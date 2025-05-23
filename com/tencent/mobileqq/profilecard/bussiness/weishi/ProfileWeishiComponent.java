package com.tencent.mobileqq.profilecard.bussiness.weishi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.api.IWSMinePanel;
import com.tencent.biz.videostory.widget.view.MineWSPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileWeishiComponent extends AbsQQProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileWeishiComponent";
    private boolean mIsRequestShow;
    private MineWSPanel mWeishiPanel;

    public ProfileWeishiComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    private static String getCurrentCardUin(ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        if (profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null) {
            return allInOne.uin;
        }
        return "";
    }

    private void initWeishiPanel() {
        if (this.mWeishiPanel == null) {
            this.mWeishiPanel = new MineWSPanel(this);
        }
    }

    private static boolean isProfileMain(ProfileCardInfo profileCardInfo, AppInterface appInterface, String str) {
        if (profileCardInfo == null || profileCardInfo.allInOne == null || appInterface == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (profileCardInfo.allInOne.f260789pa != 0 && !TextUtils.equals(appInterface.getCurrentAccountUin(), str)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.view.View, VIEW] */
    private boolean makeOrRefreshWeishiFeedList(Card card) {
        QLog.i(TAG, 2, "makeOrRefreshWeishiFeedList");
        boolean z16 = false;
        if (this.mWeishiPanel == null) {
            return false;
        }
        boolean shouldShowWeishiPanel = shouldShowWeishiPanel(card, this.mConfigHelper);
        QLog.i(TAG, 2, "makeOrRefreshWeishiFeedList mIsRequestShow:" + this.mIsRequestShow + ", shouldShowWeishiPanel:" + shouldShowWeishiPanel);
        if (this.mIsRequestShow && shouldShowWeishiPanel) {
            View view = (View) this.mViewContainer;
            View view2 = view;
            if (view == null) {
                ?? inflate = this.mActivity.getLayoutInflater().inflate(R.layout.f168390ur, (ViewGroup) null);
                this.mWeishiPanel.l(inflate);
                this.mWeishiPanel.q(new MineWSPanel.e() { // from class: com.tencent.mobileqq.profilecard.bussiness.weishi.ProfileWeishiComponent.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileWeishiComponent.this);
                        }
                    }

                    @Override // com.tencent.biz.videostory.widget.view.MineWSPanel.e
                    public void processClickEvent() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ProfileCardReport.reportWeiShiClick(((AbsQQProfileContentComponent) ProfileWeishiComponent.this).mQQAppInterface, (ProfileCardInfo) ((AbsComponent) ProfileWeishiComponent.this).mData);
                        }
                    }
                });
                this.mViewContainer = inflate;
                QLog.i(TAG, 2, "makeOrRefreshWeishiFeedList show weishi panel!");
                z16 = true;
                view2 = inflate;
            }
            TextView h16 = this.mWeishiPanel.h();
            ImageView f16 = this.mWeishiPanel.f();
            this.mWeishiPanel.s();
            updateItemTheme(view2, h16, null, f16);
            return z16;
        }
        if (this.mViewContainer != 0) {
            this.mViewContainer = null;
            z16 = true;
        }
        QLog.i(TAG, 2, "makeOrRefreshWeishiFeedList remove weishi panel!");
        return z16;
    }

    private void requestWeiShiPanelInfo(Intent intent) {
        if (intent != null && intent.getBundleExtra("result") != null && intent.getBundleExtra("result").getBoolean("key_weishi_switch")) {
            requestWeishiPanelInfo();
        }
    }

    private boolean shouldShowWeishiPanel(Card card, IProfileConfig iProfileConfig) {
        boolean z16;
        boolean z17;
        if (iProfileConfig != null && !iProfileConfig.isSwitchEnable(11)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (card != null && card.switchWeiShi != 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("shouldShowWeishiPanelOrNot configEnable:%s,switchEnable:%s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    public QBaseActivity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (QBaseActivity) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mActivity;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1016;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_MINE_WEISHI;
    }

    public void initOrRefreshWeiShiPanel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        QLog.i(TAG, 2, "initOrRefreshWeishiPanel");
        if (this.mWeishiPanel == null) {
            this.mWeishiPanel = new MineWSPanel(this);
        }
        this.mIsRequestShow = z16;
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.notifyCardUpdate();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1022) {
            requestWeiShiPanelInfo(intent);
        } else if (i16 == -1 && i3 == 1012) {
            requestWeiShiPanelInfo(intent);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        initWeishiPanel();
        requestWeishiPanelInfo();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPause();
        String currentCardUin = getCurrentCardUin((ProfileCardInfo) this.mData);
        ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfilePageVisitExit(currentCardUin, isProfileMain((ProfileCardInfo) this.mData, this.mApp, currentCardUin));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        String currentCardUin = getCurrentCardUin((ProfileCardInfo) this.mData);
        ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfilePageVisitEnter(currentCardUin, isProfileMain((ProfileCardInfo) this.mData, this.mApp, currentCardUin));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void requestWeishiPanelInfo() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mWeishiPanel != null) {
            String str = ((ProfileCardInfo) this.mData).allInOne.uin;
            QLog.i(TAG, 2, "[requestWeishiPanelInfo] currentCardUin:" + str);
            try {
                Long.parseLong(str);
                if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 0 && !this.mApp.getCurrentAccountUin().equals(str)) {
                    z16 = false;
                    this.mWeishiPanel.k(z16, str);
                    this.mWeishiPanel.g();
                }
                z16 = true;
                this.mWeishiPanel.k(z16, str);
                this.mWeishiPanel.g();
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "requestWeishiPanelInfo failed getLong, uin = " + str);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? super.lambda$checkValidComponent$3((ProfileWeishiComponent) profileCardInfo) | makeOrRefreshWeishiFeedList(((ProfileCardInfo) this.mData).card) : ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) profileCardInfo)).booleanValue();
    }
}
