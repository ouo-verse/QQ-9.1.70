package com.tencent.mobileqq.qqsec.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.security.a;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.account.AccountSecurityFragment;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qqsec.processors.AccountPwdProcessor;
import com.tencent.mobileqq.qqsec.processors.GesturePwdProcessor;
import com.tencent.mobileqq.qqsec.processors.LoginDeviceProcessor;
import com.tencent.mobileqq.qqsec.processors.ThirdAccountBindProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.security.b;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.processor.c;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SafeBlockApiImpl implements ISafeBlockApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SafeBlockApiImpl";

    public SafeBlockApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void cancelVerifyRiskDialog(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            b.d().a(str);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void doAfterPushRiskDialog(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3));
        } else {
            b.d().c(str, j3);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void enableJumpLoginFromFund(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity);
        } else if (qBaseActivity != null && (qBaseActivity instanceof NotificationActivity)) {
            ((NotificationActivity) qBaseActivity).enableJumpLoginFromFund();
        } else {
            QLog.e(TAG, 1, "enableJumpLoginFromFund error: baseActivity param error");
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void exitApp(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else if (activity != null && (activity instanceof NotificationActivity)) {
            ((NotificationActivity) activity).exitApp();
        } else {
            QLog.e(TAG, 1, "exitApp error: activity param error");
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public boolean finishNotifyActivityByKicked(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        if (context == null) {
            QLog.e(TAG, 1, "finishNotifyActivityByKicked error: context == null");
            return false;
        }
        NotificationActivity notificationActivity = NotificationActivity.instance;
        if (notificationActivity == null || notificationActivity.isFinishing()) {
            return false;
        }
        QLog.d(TAG, 1, "needFinish, notification activity exists");
        Intent intent = NotificationActivity.instance.getIntent();
        NotificationActivity.instance.finish();
        context.startActivity(intent);
        return true;
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public c getAccountPwdProcessor(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (c) iPatchRedirector.redirect((short) 37, (Object) this, (Object) context);
        }
        return new AccountPwdProcessor(context);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public String getAppendMsgWithSceneId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        return a.d().b(i3);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public int getForbidScene(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) bArr)).intValue();
        }
        return a.d().c(bArr);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public c getGesturePwdProcessor(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (c) iPatchRedirector.redirect((short) 39, (Object) this, (Object) context);
        }
        return new GesturePwdProcessor(context);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public String getJumpAQH5Url(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, this, str, str2, Boolean.valueOf(z16));
        }
        return a.d().e(str, str2, z16);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public int getLinkTypeForReport(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return a.d().f(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public c getLoginDeviceProcessor(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (c) iPatchRedirector.redirect((short) 38, (Object) this, (Object) context);
        }
        return new LoginDeviceProcessor(context);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public Class<?> getNotifyActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return NotificationActivity.class;
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public c getThirdAccountBindProcessor(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (c) iPatchRedirector.redirect((short) 36, (Object) this, (Object) context);
        }
        return new ThirdAccountBindProcessor(context);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public int getTipResIdWithSceneId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, i3)).intValue();
        }
        return a.d().g(i3);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void handleLoginOnlinePush(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), str, str2);
        } else {
            com.tencent.mobileqq.security.a.b(i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public CharSequence handleNotifyMsg(String str, QBaseActivity qBaseActivity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (CharSequence) iPatchRedirector.redirect((short) 16, this, str, qBaseActivity, Integer.valueOf(i3));
        }
        return a.d().i(str, qBaseActivity, i3);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public View initModifyPwdBanner(BaseQQAppInterface baseQQAppInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
        return b.d().h(baseQQAppInterface, context);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public boolean isBlockNotifyActivity(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            QLog.e(TAG, 1, "isBlockNotifyActivity error: activity == null");
            return false;
        }
        return obj instanceof NotificationActivity;
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public boolean isGroupSoundItemShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return ((ISettingApi) QRoute.api(ISettingApi.class)).isGroupSoundItemShown();
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public boolean isNotDisturbTimeConfigOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return ((ISettingApi) QRoute.api(ISettingApi.class)).isNotDisturbTimeConfigOpen();
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public boolean isNotitiRingtoneShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return ((ISettingApi) QRoute.api(ISettingApi.class)).isNotificationRingtoneShown();
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void reportFrozenDlg(BaseQQAppInterface baseQQAppInterface, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, baseQQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16), str);
        } else {
            a.d().n(baseQQAppInterface, i3, i16, str);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startAccountSecurityPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        boolean z16 = context instanceof Activity;
        if (!z16) {
            intent.addFlags(268435456);
        }
        if (z16 && i3 >= 0) {
            QPublicFragmentActivity.startForResult((Activity) context, intent, (Class<? extends QPublicBaseFragment>) AccountSecurityFragment.class, i3);
        } else {
            QPublicFragmentActivity.start(context, intent, AccountSecurityFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startBottomTabSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startBottomTabSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startChatHistorySettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startChatHistorySettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startGeneralSettingChatActivityPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingChatPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startGeneralSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startGeneralSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startPrivacyInteractionSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startPrivacyInteractionSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startPushSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startNotifyPushSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startSoundAndVibrateActivityPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startSoundAndVibratePage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startSubRichMediaSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startSubRichMediaSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startTempMsgSettingAvtivityPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startTempMsgSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startVibrateNewActivityPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startVibrateNewPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startZPlanAvatarSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startZPlanAvatarSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void startZPlaneSettingFragmentPage(Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, context, intent, Integer.valueOf(i3));
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ((ISettingApi) QRoute.api(ISettingApi.class)).startZPlaneSettingPage(context, intent);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public boolean unBlockWithMiniAppFromCnt(QBaseActivity qBaseActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) qBaseActivity, (Object) str)).booleanValue();
        }
        return a.d().u(qBaseActivity, str);
    }

    @Override // com.tencent.mobileqq.qqsec.api.ISafeBlockApi
    public void updateBarDisplayStatus(BaseQQAppInterface baseQQAppInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, baseQQAppInterface, Long.valueOf(j3));
        } else {
            b.d().m(baseQQAppInterface, j3);
        }
    }
}
