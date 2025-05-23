package com.tencent.mobileqq.setting.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.setting.processor.c;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\u000bH&J\u001c\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0019H&J\b\u0010\u001d\u001a\u00020\u0019H&J\b\u0010\u001e\u001a\u00020\u0019H&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010%\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010#H&J\b\u0010&\u001a\u00020\tH&J2\u0010,\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0*H&J \u0010/\u001a\u00020.2\b\u0010$\u001a\u0004\u0018\u00010#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0*H&J\b\u00101\u001a\u000200H&J\u0010\u00104\u001a\u00020\t2\u0006\u00103\u001a\u000202H&J\u0012\u00105\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u00106\u001a\u00020\u0019H&J\b\u00107\u001a\u00020\u0019H&\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/setting/api/ISettingApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "getSettingFragmentClass", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "params", "", "startMainSettingPage", "Lmqq/app/QActivityLifecycleCallbacks;", "getSettingLifecycleMonitor", "startNotifyPushSettingPage", "startGeneralSettingPage", "startGeneralSettingChatPage", "startSoundAndVibratePage", "startVibrateNewPage", "startTempMsgSettingPage", "startBottomTabSettingPage", "startChatHistorySettingPage", "startSubRichMediaSettingPage", "startPrivacyInteractionSettingPage", "startZPlaneSettingPage", "startZPlanAvatarSettingPage", "", "isLockScreenConfigOpen", "isNotDisturbTimeConfigOpen", "isGroupSoundItemShown", "isNotificationRingtoneShown", "needUseNewStyle", "Lcom/tencent/mobileqq/setting/processor/c;", "getPhoneNumItemProcessor", "getQIDProcessor", "getMoreSecuritySettingProcessor", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "checkHasNotSetPwd", "clearLastAlbumInfo", "", "uin", "isDeleteHistory", "Lkotlin/Function0;", "callback", "deleteAccount", "refreshSubAccount", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "getPushSubMessageObserver", "Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;", "getRecentUserProxy", "Landroid/view/View;", "view", "checkAndStartAnimation", "getMedalProcessor", "isSettingPageNavNeedBlur", "isSettingPageNavNeedAlpha", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISettingApi extends QRouteApi {
    void checkAndStartAnimation(@NotNull View view);

    boolean checkHasNotSetPwd(@Nullable Activity activity);

    void clearLastAlbumInfo();

    void deleteAccount(@Nullable String uin, boolean isDeleteHistory, @Nullable Activity activity, @NotNull Function0<Unit> callback);

    @Nullable
    c getMedalProcessor(@NotNull Context context);

    @NotNull
    c getMoreSecuritySettingProcessor(@NotNull Context context);

    @NotNull
    c getPhoneNumItemProcessor(@NotNull Context context);

    @NotNull
    BaseMessageObserver getPushSubMessageObserver(@Nullable Activity activity, @NotNull Function0<Unit> refreshSubAccount);

    @NotNull
    c getQIDProcessor(@NotNull Context context);

    @NotNull
    RecentUserProxy getRecentUserProxy();

    @NotNull
    Class<? extends Fragment> getSettingFragmentClass();

    @NotNull
    QActivityLifecycleCallbacks getSettingLifecycleMonitor();

    boolean isGroupSoundItemShown();

    boolean isLockScreenConfigOpen();

    boolean isNotDisturbTimeConfigOpen();

    boolean isNotificationRingtoneShown();

    boolean isSettingPageNavNeedAlpha();

    boolean isSettingPageNavNeedBlur();

    boolean needUseNewStyle();

    void startBottomTabSettingPage(@NotNull Context context, @Nullable Intent params);

    void startChatHistorySettingPage(@NotNull Context context, @Nullable Intent params);

    void startGeneralSettingChatPage(@NotNull Context context, @Nullable Intent params);

    void startGeneralSettingPage(@NotNull Context context, @Nullable Intent params);

    void startMainSettingPage(@NotNull Context context, @Nullable Intent params);

    void startNotifyPushSettingPage(@NotNull Context context, @Nullable Intent params);

    void startPrivacyInteractionSettingPage(@NotNull Context context, @Nullable Intent params);

    void startSoundAndVibratePage(@NotNull Context context, @Nullable Intent params);

    void startSubRichMediaSettingPage(@NotNull Context context, @Nullable Intent params);

    void startTempMsgSettingPage(@NotNull Context context, @Nullable Intent params);

    void startVibrateNewPage(@NotNull Context context, @Nullable Intent params);

    void startZPlanAvatarSettingPage(@NotNull Context context, @Nullable Intent params);

    void startZPlaneSettingPage(@NotNull Context context, @Nullable Intent params);
}
