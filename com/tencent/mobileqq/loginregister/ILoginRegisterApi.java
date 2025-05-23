package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.login.LoginReportConstants;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILoginRegisterApi extends QRouteApi {
    void accountLogin(QBaseActivity qBaseActivity, com.tencent.mobileqq.login.c cVar, com.tencent.mobileqq.login.aa aaVar);

    void addDevLockVerifyListener(l lVar);

    void changePWDByPhoneSmsLogin(QBaseActivity qBaseActivity, String str, String str2);

    void clearCache();

    void deleteAccount(QBaseActivity qBaseActivity, String str, boolean z16);

    void doRegister(QBaseActivity qBaseActivity, int i3);

    void finishAllLoginActivity(boolean z16);

    Class<?> getDevLockQuickVerifyCls();

    Class<? extends QPublicBaseFragment> getHintDlgFragment();

    List<com.tencent.mobileqq.login.account.a> getLoginAccountList();

    Class<?> getLoginActivityClass();

    QIPCModule getLoginIPCModule();

    byte getLoginType(String str);

    boolean isLoggingIn();

    boolean isUinValid(String str);

    void jumpToAccountLoginPage(Activity activity, Intent intent);

    void jumpToAccountVerifyPage(Activity activity, int i3);

    void jumpToLoginForSplash(Activity activity);

    void jumpToPhoneNumLoginPage(Activity activity, @LoginReportConstants.PhoneLoginScene int i3);

    void logout(Activity activity, boolean z16);

    void notifyDevLockVerifyOpen();

    void onApplicationCreateEnd();

    void onMainPageShowEnd();

    void onRegisterProxyEnd();

    void onRegisterProxyTaskEnd();

    void registerAccountListChangeObserver(a aVar);

    void removeAccountListChangeObserver(a aVar);

    void removeDevLockVerifyListener(l lVar);

    void reportForQuestionnaire();

    void setLoginType(String str, byte b16);

    void setPhoneToMMKV(String str);

    void showDeleteAccountDialog(Activity activity);

    void switchAccount(String str, e72.a aVar);

    void updateLoginAccount(String str, String str2);
}
