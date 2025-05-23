package com.tencent.mobileqq.app.automator;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountCheck;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderStepAsync;
import com.tencent.mobileqq.app.automator.step.AIOPreLoadStep;
import com.tencent.mobileqq.app.automator.step.ActiveAccount;
import com.tencent.mobileqq.app.automator.step.AdSdkInit;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.app.automator.step.CheckAuthCode;
import com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.app.automator.step.DensityAdjustConfigLoadStep;
import com.tencent.mobileqq.app.automator.step.FEKitUpdateSO;
import com.tencent.mobileqq.app.automator.step.FeatureSwitchStep;
import com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep;
import com.tencent.mobileqq.app.automator.step.GetCheckUpdate;
import com.tencent.mobileqq.app.automator.step.GetClubContentUpdateStatus;
import com.tencent.mobileqq.app.automator.step.GetCommonUsedSystemEmojiStep;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.app.automator.step.GetEmosmList;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeedCount;
import com.tencent.mobileqq.app.automator.step.GetRedpointStep;
import com.tencent.mobileqq.app.automator.step.GetSelfInfo;
import com.tencent.mobileqq.app.automator.step.GetSig;
import com.tencent.mobileqq.app.automator.step.GetSplashConfig;
import com.tencent.mobileqq.app.automator.step.GetSubAccount;
import com.tencent.mobileqq.app.automator.step.HongbaoConfigLoadStep;
import com.tencent.mobileqq.app.automator.step.InitTabData;
import com.tencent.mobileqq.app.automator.step.MqqConfigLoadStep;
import com.tencent.mobileqq.app.automator.step.PreloadBusinessEveryLogin;
import com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerCheck;
import com.tencent.mobileqq.app.automator.step.PreloadBusinessTimerDelay;
import com.tencent.mobileqq.app.automator.step.PreloadQCircleBusiness;
import com.tencent.mobileqq.app.automator.step.QAVStep;
import com.tencent.mobileqq.app.automator.step.QQDtAfterLoginStep;
import com.tencent.mobileqq.app.automator.step.RefreshVerifyPhoneBannerStep;
import com.tencent.mobileqq.app.automator.step.SetLogOn;
import com.tencent.mobileqq.app.automator.step.SignatureScan;
import com.tencent.mobileqq.app.automator.step.StartXpsDetection;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.automator.step.TopInfoMigrateStep;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.mobileqq.app.automator.step.UpdateTroop;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sofixhelper.SoFixHelperLowMachineStep;
import com.tencent.mobileqq.startup.control.MicroStep;
import com.tencent.mobileqq.startup.step.InitQQRMonitorSDK;
import com.tencent.mobileqq.startup.step.InitQQRaftKitSDK;
import com.tencent.mobileqq.startup.step.InitThreadMonitor;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f195318a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final String f195319b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String a16 = new g().a();
        f195318a = a16;
        f195319b = "{54," + a16 + ",10,11,55,56,58,59,20,21,64,66,65,[13,15,16,17,18,31,44,43,38,48,62],51}";
        vy3.a.f443750s.add(39);
        vy3.a.f443750s.add(4);
        vy3.a.f443750s.add(3);
        vy3.a.f443750s.add(5);
        vy3.a.f443750s.add(10);
        vy3.a.f443750s.add(11);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AsyncStep a(Automator automator, String str) {
        Exception e16;
        AsyncStep<Automator> asyncStep;
        AsyncStep<Automator> asyncStep2;
        if (str != null) {
            str = str.trim();
        }
        if (!TextUtils.isEmpty(str)) {
            int i3 = -1;
            if (str.startsWith("{")) {
                LinearGroup linearGroup = new LinearGroup();
                linearGroup.f195314e = str;
                linearGroup.mName = str;
                asyncStep2 = linearGroup;
            } else if (str.startsWith("[")) {
                ParallGroup parallGroup = new ParallGroup();
                parallGroup.f195314e = str;
                parallGroup.mName = str;
                asyncStep2 = parallGroup;
            } else {
                i3 = Integer.parseInt(str);
                Class<? extends AsyncStep> b16 = b(i3);
                if (b16 != null) {
                    try {
                        asyncStep = b16.newInstance();
                    } catch (Exception e17) {
                        e16 = e17;
                        asyncStep = null;
                    }
                    try {
                        asyncStep.mName = asyncStep.getClass().getSimpleName();
                    } catch (Exception e18) {
                        e16 = e18;
                        QLog.e("QQInitHandler", 1, e16, new Object[0]);
                        asyncStep2 = asyncStep;
                        if (asyncStep2 != null) {
                        }
                        return asyncStep2;
                    }
                    asyncStep2 = asyncStep;
                } else {
                    AsyncStep<Automator> b17 = MicroStep.INSTANCE.b(i3);
                    asyncStep2 = b17;
                    if (b17 == null) {
                        AsyncStep<Automator> asyncStep3 = new AsyncStep<>();
                        asyncStep3.mName = AsyncStep.class.getSimpleName();
                        asyncStep2 = asyncStep3;
                    }
                }
            }
            if (asyncStep2 != null) {
                asyncStep2.mAutomator = automator;
                asyncStep2.mStepId = i3;
            }
            return asyncStep2;
        }
        throw new RuntimeException("createStepGroup: " + str);
    }

    private static Class<? extends AsyncStep> b(int i3) {
        switch (i3) {
            case 2:
                return ActiveAccount.class;
            case 3:
            case 6:
            case 7:
                return UpdateFriend.class;
            case 4:
            case 8:
                return UpdateTroop.class;
            case 5:
            case 9:
                return ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountCheck.class);
            case 10:
                return GetSubAccount.class;
            case 11:
                return GetGeneralSettings.class;
            case 12:
            case 14:
            case 22:
            case 24:
            case 25:
            case 26:
            case 28:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 39:
            case 40:
            case 41:
            case 46:
            case 47:
            case 49:
            case 50:
            case 57:
            case 60:
            case 61:
            case 63:
            default:
                return null;
            case 13:
                return QAVStep.class;
            case 15:
                return GetEmosmList.class;
            case 16:
                return GetSelfInfo.class;
            case 17:
                return GetSig.class;
            case 18:
                return SetLogOn.class;
            case 19:
                return GetQZoneFeedCount.class;
            case 20:
                return GetConfig.class;
            case 21:
                return GetCheckUpdate.class;
            case 23:
                return GetSplashConfig.class;
            case 27:
                return CleanCache.class;
            case 29:
                return SignatureScan.class;
            case 30:
                return StartXpsDetection.class;
            case 31:
                return GetClubContentUpdateStatus.class;
            case 37:
                return TimerCheckMsgCount.class;
            case 38:
                return GetBigEmoticonStep.class;
            case 42:
                return GetRedpointStep.class;
            case 43:
                return CheckAuthCode.class;
            case 44:
                return GetCommonUsedSystemEmojiStep.class;
            case 45:
                return DailyReport.class;
            case 48:
                return CheckSafeCenterConfig.class;
            case 51:
                return AutomatorFinish.class;
            case 52:
                return QQReminderStepAsync.class;
            case 53:
                return InitQQRaftKitSDK.class;
            case 54:
                return InitTabData.class;
            case 55:
                return InitQQRMonitorSDK.class;
            case 56:
                return InitThreadMonitor.class;
            case 58:
                return FeatureSwitchStep.class;
            case 59:
                return SoFixHelperLowMachineStep.class;
            case 62:
                return RefreshVerifyPhoneBannerStep.class;
            case 64:
                return PreloadBusinessEveryLogin.class;
            case 65:
                return PreloadBusinessTimerCheck.class;
            case 66:
                return PreloadBusinessTimerDelay.class;
            case 67:
                return PreloadQCircleBusiness.class;
            case 68:
                return FEKitUpdateSO.class;
            case 69:
                return QQDtAfterLoginStep.class;
            case 70:
                return AdSdkInit.class;
            case 71:
                return TopInfoMigrateStep.class;
            case 72:
                return AIOPreLoadStep.class;
            case 73:
                return DensityAdjustConfigLoadStep.class;
            case 74:
                return HongbaoConfigLoadStep.class;
            case 75:
                return MqqConfigLoadStep.class;
        }
    }

    public static boolean c(LinearGroup linearGroup) {
        return com.tencent.mobileqq.startup.a.f289668i;
    }
}
