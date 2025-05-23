package com.tencent.mobileqq.qqsec.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ISafeBlockApi extends QRouteApi {
    void cancelVerifyRiskDialog(String str);

    void doAfterPushRiskDialog(String str, long j3);

    void enableJumpLoginFromFund(QBaseActivity qBaseActivity);

    void exitApp(Activity activity);

    boolean finishNotifyActivityByKicked(Context context);

    com.tencent.mobileqq.setting.processor.c getAccountPwdProcessor(Context context);

    String getAppendMsgWithSceneId(int i3);

    int getForbidScene(byte[] bArr);

    com.tencent.mobileqq.setting.processor.c getGesturePwdProcessor(Context context);

    String getJumpAQH5Url(String str, String str2, boolean z16);

    int getLinkTypeForReport(String str, int i3, int i16);

    com.tencent.mobileqq.setting.processor.c getLoginDeviceProcessor(Context context);

    Class<?> getNotifyActivityClass();

    com.tencent.mobileqq.setting.processor.c getThirdAccountBindProcessor(Context context);

    int getTipResIdWithSceneId(int i3);

    void handleLoginOnlinePush(int i3, String str, String str2);

    CharSequence handleNotifyMsg(String str, QBaseActivity qBaseActivity, int i3);

    View initModifyPwdBanner(BaseQQAppInterface baseQQAppInterface, Context context);

    boolean isBlockNotifyActivity(Object obj);

    boolean isGroupSoundItemShow();

    boolean isNotDisturbTimeConfigOpen();

    boolean isNotitiRingtoneShow();

    void reportFrozenDlg(BaseQQAppInterface baseQQAppInterface, int i3, int i16, String str);

    void startAccountSecurityPage(Context context, Intent intent, int i3);

    void startBottomTabSettingFragmentPage(Context context, Intent intent, int i3);

    void startChatHistorySettingFragmentPage(Context context, Intent intent, int i3);

    void startGeneralSettingChatActivityPage(Context context, Intent intent, int i3);

    void startGeneralSettingFragmentPage(Context context, Intent intent, int i3);

    void startPrivacyInteractionSettingFragmentPage(Context context, Intent intent, int i3);

    void startPushSettingFragmentPage(Context context, Intent intent, int i3);

    void startSoundAndVibrateActivityPage(Context context, Intent intent, int i3);

    void startSubRichMediaSettingFragmentPage(Context context, Intent intent, int i3);

    void startTempMsgSettingAvtivityPage(Context context, Intent intent, int i3);

    void startVibrateNewActivityPage(Context context, Intent intent, int i3);

    void startZPlanAvatarSettingFragmentPage(Context context, Intent intent, int i3);

    void startZPlaneSettingFragmentPage(Context context, Intent intent, int i3);

    boolean unBlockWithMiniAppFromCnt(QBaseActivity qBaseActivity, String str);

    void updateBarDisplayStatus(BaseQQAppInterface baseQQAppInterface, long j3);
}
