package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.parser.OnlinePushJumpReportUtil;
import com.tencent.mobileqq.ark.browser.ArkBrowserFragment;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.api.IRobotProfileCardApi;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQBrowserDelegationActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    public static final String f176747b0;

    /* renamed from: a0, reason: collision with root package name */
    private Intent f176748a0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f176747b0 = com.tencent.mobileqq.activity.home.impl.b.f183052o;
        }
    }

    public QQBrowserDelegationActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176748a0 = null;
        }
    }

    void F2(Intent intent, QQAppInterface qQAppInterface) {
        if (intent != null && qQAppInterface != null && qQAppInterface.getMessageFacade() != null) {
            EcShopAssistantManager ecShopAssistantManager = (EcShopAssistantManager) qQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
            IPublicAccountUtil.UIN_FOR_SHOP.equals(ecShopAssistantManager.f79572f);
            ecShopAssistantManager.f79572f = null;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = getIntent();
        this.f176748a0 = intent;
        if (intent.getExtras() == null) {
            finish();
            return false;
        }
        Intent intent2 = new Intent(getIntent());
        int intExtra = intent2.getIntExtra("browserType", 0);
        intent2.putExtra("needSkey", "true");
        if (intExtra != 1) {
            if (intExtra != 3) {
                if (intExtra != 4) {
                    intent2.setClass(this, QQBrowserActivity.class);
                } else {
                    intent2.setClass(this, QQTranslucentBrowserActivity.class);
                }
            } else {
                intent2.putExtra("fragmentClass", ArkBrowserFragment.class);
                intent2.setClass(this, QQBrowserActivity.class);
            }
        } else {
            intent2.setClass(this, QQH5BrowserActivity.class);
        }
        String stringExtra = intent2.getStringExtra("url");
        OnlinePushJumpReportUtil.a(this);
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).shouldInterceptQQBrowserDelegationActivity(this, stringExtra, intent2)) {
            finish();
            return false;
        }
        if (stringExtra != null && ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).shouldInterceptForRobotProfile(this, stringExtra)) {
            finish();
            return false;
        }
        int intExtra2 = this.f176748a0.getIntExtra("curtype", -1);
        if (intExtra2 != 0) {
            if (intExtra2 != 1) {
                if (intExtra2 != 1000) {
                    if (intExtra2 != 10014) {
                        i3 = 0;
                    } else {
                        i3 = 3;
                    }
                } else {
                    i3 = 5;
                }
            } else {
                i3 = 2;
            }
        } else {
            i3 = 1;
        }
        if (stringExtra != null && ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).interceptFlashTransferUrl(this, stringExtra, i3, 3)) {
            finish();
            return false;
        }
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsFormUrl(stringExtra)) {
            int intExtra3 = intent2.getIntExtra("uinType", 1);
            if (intExtra3 == 1) {
                str = intent2.getStringExtra("groupUin");
            } else if (intExtra3 == 0) {
                str = intent2.getStringExtra("friend_uin");
            } else {
                str = null;
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2) && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).openTroopFormMiniApp(this, stringExtra, ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).getTroopFormGrayParameter(this.app, str2, intExtra3))) {
                ReportController.o(this.app, "dc00898", "", str2, "0X8009FCF", "0X8009FCF", 0, 0, "", "", "", "");
                finish();
                return false;
            }
        }
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).isDocsUrl(stringExtra)) {
            if (intent2.getBooleanExtra(AppConstants.Key.H5_ARK_IS_FROM_SHARE, false)) {
                boolean openDocsMiniApp = ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(this, stringExtra, ITeamWorkUtils.TD_SOURCE_QQ_AIO_ARK_H5);
                finish();
                if (openDocsMiniApp) {
                    return false;
                }
            }
            intent2.setClass(this, TeamWorkDocEditBrowserActivity.class);
            intent2.addFlags(603979776);
            intent2 = TeamWorkDocEditBrowserActivity.getOpenTeamWorkIntent(intent2, stringExtra, this);
        }
        if (((INewQWalletApi) QRoute.api(INewQWalletApi.class)).shouldInterceptQQBrowserDelegationActivity(this, stringExtra, intent2)) {
            finish();
            return false;
        }
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).shouldInterceptWebToNative(this, stringExtra)) {
            finish();
            return false;
        }
        Bundle extrasForQQBrowserActivity = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getExtrasForQQBrowserActivity(stringExtra);
        if (extrasForQQBrowserActivity != null) {
            intent2.putExtras(extrasForQQBrowserActivity);
        }
        F2(intent2, this.app);
        intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent2.putExtra("uin", this.app.getCurrentAccountUin());
        startActivity(intent2);
        finish();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnStart();
        boolean appForground = BaseGesturePWDUtil.getAppForground(getActivity());
        QBaseActivity.mAppForground = appForground;
        if (!appForground && this.mCanLock && this.app != null && BaseGesturePWDUtil.getJumpLock(getActivity(), this.app.getCurrentAccountUin())) {
            startUnlockActivity();
        }
        if (!QBaseActivity.mAppForground) {
            QBaseActivity.mAppForground = true;
            GesturePWDUtils.setAppForground(getActivity(), QBaseActivity.mAppForground);
        }
        this.mStopFlag = 0;
        this.mCanLock = true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
