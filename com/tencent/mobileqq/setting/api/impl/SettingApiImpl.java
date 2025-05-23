package com.tencent.mobileqq.setting.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.activity.VibrateNewFragment;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.login.bq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment;
import com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment;
import com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.SubRichMediaSettingFragment;
import com.tencent.mobileqq.setting.main.MainSettingFragment;
import com.tencent.mobileqq.setting.main.account.QIDProcessor;
import com.tencent.mobileqq.setting.main.gxh.MedalProcessor;
import com.tencent.mobileqq.setting.main.processor.PhoneNumItemProcessor;
import com.tencent.mobileqq.setting.processor.c;
import com.tencent.mobileqq.setting.utils.AccountUtil;
import com.tencent.mobileqq.setting.utils.l;
import com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.e;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import hq2.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010%\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\tH\u0016J2\u0010,\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0*H\u0016J \u0010/\u001a\u00020.2\b\u0010$\u001a\u0004\u0018\u00010#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0*H\u0016J\b\u00101\u001a\u000200H\u0016J\u0010\u00104\u001a\u00020\t2\u0006\u00103\u001a\u000202H\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u00020\u0017H\u0016\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/setting/api/impl/SettingApiImpl;", "Lcom/tencent/mobileqq/setting/api/ISettingApi;", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "getSettingFragmentClass", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "params", "", "startMainSettingPage", "startNotifyPushSettingPage", "startGeneralSettingPage", "startGeneralSettingChatPage", "startSoundAndVibratePage", "startVibrateNewPage", "startTempMsgSettingPage", "startBottomTabSettingPage", "startChatHistorySettingPage", "startSubRichMediaSettingPage", "startPrivacyInteractionSettingPage", "startZPlaneSettingPage", "startZPlanAvatarSettingPage", "", "isLockScreenConfigOpen", "isNotDisturbTimeConfigOpen", "isGroupSoundItemShown", "isNotificationRingtoneShown", "Lmqq/app/QActivityLifecycleCallbacks;", "getSettingLifecycleMonitor", "needUseNewStyle", "Lcom/tencent/mobileqq/setting/processor/c;", "getPhoneNumItemProcessor", "getQIDProcessor", "getMoreSecuritySettingProcessor", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "checkHasNotSetPwd", "clearLastAlbumInfo", "", "uin", "isDeleteHistory", "Lkotlin/Function0;", "callback", "deleteAccount", "refreshSubAccount", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "getPushSubMessageObserver", "Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;", "getRecentUserProxy", "Landroid/view/View;", "view", "checkAndStartAnimation", "getMedalProcessor", "isSettingPageNavNeedBlur", "isSettingPageNavNeedAlpha", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SettingApiImpl implements ISettingApi {
    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void checkAndStartAnimation(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        q.INSTANCE.b(view);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void clearLastAlbumInfo() {
        e.f();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void deleteAccount(String uin, boolean isDeleteHistory, Activity activity, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AccountUtil.f286728a.d(uin, isDeleteHistory, activity, callback);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public c getMedalProcessor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (ea.x0(peekAppRuntime.getApplication(), peekAppRuntime.getCurrentAccountUin()) == 1) {
            return new MedalProcessor(context);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public c getMoreSecuritySettingProcessor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new com.tencent.mobileqq.setting.main.account.c(context);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public c getPhoneNumItemProcessor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PhoneNumItemProcessor(context);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public BaseMessageObserver getPushSubMessageObserver(Activity activity, Function0<Unit> refreshSubAccount) {
        Intrinsics.checkNotNullParameter(refreshSubAccount, "refreshSubAccount");
        return com.tencent.mobileqq.setting.utils.q.f286771a.a(activity, refreshSubAccount);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public c getQIDProcessor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new QIDProcessor(context);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public RecentUserProxy getRecentUserProxy() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        RecentUserProxy recentUserProxy = ((QQAppInterface) peekAppRuntime).getRecentUserProxy();
        Intrinsics.checkNotNullExpressionValue(recentUserProxy, "app.getRecentUserProxy()");
        return recentUserProxy;
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public Class<? extends Fragment> getSettingFragmentClass() {
        return MainSettingFragment.class;
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public QActivityLifecycleCallbacks getSettingLifecycleMonitor() {
        return new q();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean isGroupSoundItemShown() {
        return SoundAndVibrateActivity.g3();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean isLockScreenConfigOpen() {
        return !NotifyPushSettingFragment.qi() && NotifyPushSettingFragment.ri();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean isNotDisturbTimeConfigOpen() {
        return NotifyPushSettingFragment.si();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean isNotificationRingtoneShown() {
        return SoundAndVibrateActivity.h3();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean isSettingPageNavNeedAlpha() {
        return QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight();
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean isSettingPageNavNeedBlur() {
        com.tencent.qui.quiblurview.c cVar = com.tencent.qui.quiblurview.c.f363628c;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return cVar.b(context) && (QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight());
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean needUseNewStyle() {
        return l.f286758a.a(true);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startBottomTabSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUIBottomTabSettingPage(context, params);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startChatHistorySettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        new Intent().putExtra("set_display_type", 1);
        ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUIChatHistorySettingPage(context, params);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startGeneralSettingChatPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, SubChatSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startGeneralSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, GeneralSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startMainSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null) {
            params = new Intent();
        }
        if (!(context instanceof Activity)) {
            params.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, params, MainSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startNotifyPushSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        PublicFragmentActivity.start(context, params, NotifyPushSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startPrivacyInteractionSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUIPrivacyInteractionSettingPage(context, params);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startSoundAndVibratePage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUISoundPage(context, params);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startSubRichMediaSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null) {
            params = new Intent();
        }
        QPublicFragmentActivity.start(context, params, SubRichMediaSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startTempMsgSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUITempMsgSettingPage(context, params);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startVibrateNewPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        PublicFragmentActivity.start(context, params, VibrateNewFragment.class);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startZPlanAvatarSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startAvatarSettingActivity(context, IZPlanApi.FROM_QQ_SETTING, params);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public void startZPlaneSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startSettingActivity(context, IZPlanApi.FROM_QQ_SETTING);
    }

    @Override // com.tencent.mobileqq.setting.api.ISettingApi
    public boolean checkHasNotSetPwd(Activity activity) {
        if (activity == null) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return true;
        }
        return bq.a(appInterface, activity);
    }
}
