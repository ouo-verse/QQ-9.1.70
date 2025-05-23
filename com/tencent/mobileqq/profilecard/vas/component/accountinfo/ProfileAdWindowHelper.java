package com.tencent.mobileqq.profilecard.vas.component.accountinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.VasIpcTempData;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.UserLeadingActivity;
import cooperation.vip.ad.UserLeadingDialogModel;
import cooperation.vip.ad.ai;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/accountinfo/ProfileAdWindowHelper;", "", "()V", "isShowing", "", "preRequestTime", "", "clearShowingState", "", "getExpEntityInfo", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "appId", "", "key", "isCanRequest", "app", "Lmqq/app/AppRuntime;", "isQIDAd", "adItem", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "postTianshuAd", "appRuntime", "Lcom/tencent/mobileqq/app/QQAppInterface;", "profileCardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", "showingState", "tianShuAdCheck", "Companion", "WindowTaskHelper", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileAdWindowHelper {

    @NotNull
    private static final String AB_TEST_KEY = "exp_f_club_ziliao_card_window";
    private static final int AD_POS_ID = 1222;

    @NotNull
    private static final String TAG = "ProfileAdWindowHelper";
    private volatile boolean isShowing;
    private long preRequestTime = -1;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/accountinfo/ProfileAdWindowHelper$WindowTaskHelper;", "Lcooperation/vip/ad/a;", "Lcooperation/vip/ad/UserLeadingDialogModel;", "model", "", "checkModels", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "showLayer", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lcooperation/vip/pb/TianShuAccess$AdItem;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class WindowTaskHelper extends cooperation.vip.ad.a {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [cooperation.vip.ad.UserLeadingDialogModel[], java.io.Serializable] */
        public WindowTaskHelper(@NotNull TianShuAccess.AdItem adItem, @NotNull QQAppInterface app, @NotNull Activity activity) {
            Integer num;
            Intrinsics.checkNotNullParameter(adItem, "adItem");
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.dialogModels = ai.a(adItem.argList.get());
            this.intervalTime = ai.b(adItem.argList.get());
            cooperation.vip.ad.a.adid = adItem.iAdId.get();
            cooperation.vip.ad.a.traceInfo = adItem.traceinfo.get();
            boolean c16 = ai.c(adItem.argList.get());
            UserLeadingDialogModel[] userLeadingDialogModelArr = this.dialogModels;
            if (userLeadingDialogModelArr != null) {
                num = Integer.valueOf(userLeadingDialogModelArr.length);
            } else {
                num = null;
            }
            QLog.i(ProfileAdWindowHelper.TAG, 1, "WindowTask, pageSize=" + num + "intervalTime=" + this.intervalTime + "adid=" + cooperation.vip.ad.a.adid + "needHideTitleArea=" + c16);
            UserLeadingDialogModel[] dialogModels = this.dialogModels;
            Intrinsics.checkNotNullExpressionValue(dialogModels, "dialogModels");
            for (UserLeadingDialogModel userLeadingDialogModel : dialogModels) {
                QLog.i(ProfileAdWindowHelper.TAG, 1, "display ad model: " + userLeadingDialogModel);
            }
            initHelper();
            Intent intent = new Intent(activity, (Class<?>) UserLeadingActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("dialogModels", this.dialogModels);
            bundle.putInt(WinkDaTongReportConstant.ElementParamKey.ADID, cooperation.vip.ad.a.adid);
            bundle.putString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, cooperation.vip.ad.a.traceInfo);
            bundle.putLong("startTime", new Date().getTime());
            bundle.putString("nickName", ac.y(app, app.getCurrentAccountUin()));
            bundle.putInt("intervalTime", this.intervalTime);
            bundle.putBoolean("hideTitleArea", c16);
            intent.addFlags(603979776);
            intent.setFlags(65536);
            intent.putExtras(bundle);
            this.intent = intent;
        }

        private final boolean checkModels(UserLeadingDialogModel model) {
            if (!TextUtils.equals("3", model.getResType()) || !TextUtils.isEmpty(model.getResCustomUrl())) {
                return true;
            }
            QLog.w(ProfileAdWindowHelper.TAG, 1, "model is invalid : " + model);
            return false;
        }

        public final void showLayer(@NotNull Activity activity) {
            Integer num;
            boolean z16;
            Intrinsics.checkNotNullParameter(activity, "activity");
            QLog.d(ProfileAdWindowHelper.TAG, 1, "showLayer  | activity = " + activity);
            UserLeadingDialogModel[] dialogModels = this.dialogModels;
            if (dialogModels != null) {
                Intrinsics.checkNotNullExpressionValue(dialogModels, "dialogModels");
                if (dialogModels.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    UserLeadingDialogModel[] dialogModels2 = this.dialogModels;
                    Intrinsics.checkNotNullExpressionValue(dialogModels2, "dialogModels");
                    for (UserLeadingDialogModel it : dialogModels2) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (!checkModels(it)) {
                            return;
                        }
                    }
                    activity.startActivity(this.intent);
                    return;
                }
            }
            UserLeadingDialogModel[] userLeadingDialogModelArr = this.dialogModels;
            if (userLeadingDialogModelArr != null) {
                num = Integer.valueOf(userLeadingDialogModelArr.length);
            } else {
                num = null;
            }
            QLog.d(ProfileAdWindowHelper.TAG, 1, "showLayer  | dialogModels = " + num);
        }
    }

    private final ExpEntityInfo getExpEntityInfo(String appId, String key) {
        Map<String, String> tabParams;
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(appId, key);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(appId, key)");
        if (expEntity.isExperiment() || expEntity.isContrast()) {
            expEntity.reportExpExposure();
        }
        QLog.i(TAG, 1, "appId " + appId + " key " + key + " grayId: " + expEntity.getGrayId() + " isExperiment: " + expEntity.isExperiment() + " isContrast: " + expEntity.isContrast() + " mAssignment: " + expEntity.getAssignment());
        if (QLog.isDebugVersion() && (tabParams = expEntity.getTabParams()) != null) {
            for (Map.Entry<String, String> entry : tabParams.entrySet()) {
                QLog.i(TAG, 1, "key: " + ((Object) entry.getKey()) + " value: " + ((Object) entry.getValue()));
            }
        }
        return expEntity;
    }

    static /* synthetic */ ExpEntityInfo getExpEntityInfo$default(ProfileAdWindowHelper profileAdWindowHelper, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = ABTestController.APPID_1505;
        }
        if ((i3 & 2) != 0) {
            str2 = AB_TEST_KEY;
        }
        return profileAdWindowHelper.getExpEntityInfo(str, str2);
    }

    private final boolean isCanRequest(AppRuntime app) {
        String str = null;
        boolean z16 = true;
        ExpEntityInfo expEntityInfo$default = getExpEntityInfo$default(this, null, AB_TEST_KEY, 1, null);
        if (TextUtils.isEmpty(expEntityInfo$default.getGrayId())) {
            return VasLongToggle.VAS_PROFILE_CARD_TIANSHU_AD_FLOAT_DIALOG.isEnable(true);
        }
        Map<String, String> tabParams = expEntityInfo$default.getTabParams();
        if (tabParams != null) {
            str = tabParams.get("flag");
        }
        if (Intrinsics.areEqual(str, "1")) {
            QLog.i(TAG, 1, "\u5728\u5b9e\u9a8c\u7ec4 " + expEntityInfo$default.getExpName());
        } else {
            z16 = false;
        }
        ReportController.o(app, "dc00898", "", "", "0X800C51A", "0X800C51A", 0, 0, expEntityInfo$default.getGrayId(), "", "", "");
        return z16;
    }

    private final boolean isQIDAd(TianShuAccess.AdItem adItem) {
        List<TianShuAccess.MapEntry> list = adItem.argList.get();
        Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
        for (TianShuAccess.MapEntry mapEntry : list) {
            if (Intrinsics.areEqual(mapEntry.key.get(), "kuikly_url") && !TextUtils.isEmpty(mapEntry.value.get())) {
                return true;
            }
        }
        return false;
    }

    private final void postTianshuAd(final QQAppInterface appRuntime, final ProfileCardInfo profileCardInfo, final QBaseActivity activity) {
        if (this.isShowing && !activity.isFinishing()) {
            ArrayList arrayList = new ArrayList();
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mPosId = 1222;
            tianShuAdPosItemData.mNeedCnt = 1;
            arrayList.add(tianShuAdPosItemData);
            TianShuManager.getInstance().requestAdv(arrayList, new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.profilecard.vas.component.accountinfo.b
                @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
                public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                    ProfileAdWindowHelper.postTianshuAd$lambda$5(ProfileAdWindowHelper.this, activity, profileCardInfo, appRuntime, z16, getAdsRsp);
                }
            });
            return;
        }
        QLog.w(TAG, 1, "no display for user 1. isShowing: " + this.isShowing + " or finishing: " + activity.isFinishing());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postTianshuAd$lambda$5(final ProfileAdWindowHelper this$0, final QBaseActivity activity, final ProfileCardInfo profileCardInfo, final QQAppInterface appRuntime, boolean z16, final TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(profileCardInfo, "$profileCardInfo");
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        QLog.w(TAG, 1, "fetch 1222 ad success result: " + z16);
        if (!z16) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.accountinfo.c
            @Override // java.lang.Runnable
            public final void run() {
                ProfileAdWindowHelper.postTianshuAd$lambda$5$lambda$4(ProfileAdWindowHelper.this, activity, getAdsRsp, profileCardInfo, appRuntime);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.app.Activity] */
    public static final void postTianshuAd$lambda$5$lambda$4(ProfileAdWindowHelper this$0, QBaseActivity activity, TianShuAccess.GetAdsRsp getAdsRsp, ProfileCardInfo profileCardInfo, QQAppInterface appRuntime) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(getAdsRsp, "$getAdsRsp");
        Intrinsics.checkNotNullParameter(profileCardInfo, "$profileCardInfo");
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        if (VasIpcTempData.INSTANCE.getTempVar().getLong("key_profile_half_screen", 0L) != 3 && !((IProfileCardApi) QRoute.api(IProfileCardApi.class)).isBizPopGuideShow()) {
            if (this$0.isShowing && !activity.isFinishing()) {
                for (TianShuAccess.RspEntry rspEntry : getAdsRsp.mapAds.get()) {
                    if (rspEntry.key.get() == 1222) {
                        TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry.value.get();
                        Intrinsics.checkNotNullExpressionValue(adPlacementInfo, "rspEntry.value.get()");
                        TianShuAccess.AdPlacementInfo adPlacementInfo2 = adPlacementInfo;
                        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField = adPlacementInfo2.lst;
                        if (pBRepeatMessageField == null || pBRepeatMessageField.size() <= 0) {
                            return;
                        }
                        TianShuAccess.AdItem adItem = adPlacementInfo2.lst.get(0);
                        Intrinsics.checkNotNullExpressionValue(adItem, "adPlacementInfo.lst[0]");
                        TianShuAccess.AdItem adItem2 = adItem;
                        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).setBizPopGuideShow(true);
                        if (this$0.isQIDAd(adItem2)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(SsoReporter.POS_ID_KEY, 1222);
                            jSONObject.put("ad_id", adItem2.iAdId.get());
                            jSONObject.put("trace_info", adItem2.traceinfo.get());
                            Card card = profileCardInfo.card;
                            if (card != null) {
                                Intrinsics.checkNotNullExpressionValue(card, "card");
                                jSONObject.put("qid", card.qid);
                                jSONObject.put("qid_color", card.qidColor);
                                jSONObject.put("qid_bg_url", card.qidBgUrl);
                                jSONObject.put("qid_logo_url", card.qidLogoUrl);
                            }
                            List<TianShuAccess.MapEntry> list = adItem2.argList.get();
                            Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
                            for (TianShuAccess.MapEntry mapEntry : list) {
                                jSONObject.put(mapEntry.key.get(), mapEntry.value.get());
                            }
                            IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "param.toString()");
                            iVasKuiklyApi.setMqqToKuiklyData("vas_ad_qid", jSONObject2);
                            String kuiklyUrl = jSONObject.getString("kuikly_url");
                            Intrinsics.checkNotNullExpressionValue(kuiklyUrl, "kuiklyUrl");
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) kuiklyUrl, (CharSequence) "{qid}", false, 2, (Object) null);
                            if (contains$default) {
                                Intrinsics.checkNotNullExpressionValue(kuiklyUrl, "kuiklyUrl");
                                Card card2 = profileCardInfo.card;
                                String str = card2 != null ? card2.qid : null;
                                kuiklyUrl = StringsKt__StringsJVMKt.replace$default(kuiklyUrl, "{qid}", str == null ? "" : str, false, 4, (Object) null);
                            }
                            QLog.i(TAG, 1, "real url: " + kuiklyUrl);
                            IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                            BaseApplication baseApplication = BaseApplication.context;
                            Intrinsics.checkNotNullExpressionValue(kuiklyUrl, "kuiklyUrl");
                            iVasHybridRoute.openSchema(baseApplication, kuiklyUrl);
                            return;
                        }
                        try {
                            boolean isFinishing = activity.isFinishing();
                            QBaseActivity curActivity = activity;
                            if (isFinishing) {
                                curActivity = Foreground.getTopActivity();
                            }
                            Intrinsics.checkNotNullExpressionValue(curActivity, "curActivity");
                            new WindowTaskHelper(adItem2, appRuntime, curActivity).showLayer(curActivity);
                            return;
                        } catch (Exception e16) {
                            QLog.w(TAG, 1, "show layer exception: " + e16);
                            return;
                        }
                    }
                }
                return;
            }
            QLog.w(TAG, 1, "no display for user 2. isShowing: " + this$0.isShowing + " or finishing: " + activity.isFinishing());
            return;
        }
        QLog.i(TAG, 1, "intercept by miniHome");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tianShuAdCheck$lambda$0(ProfileAdWindowHelper this$0, QQAppInterface appRuntime, ProfileCardInfo profileCardInfo, QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(profileCardInfo, "$profileCardInfo");
        this$0.postTianshuAd(appRuntime, profileCardInfo, qBaseActivity);
    }

    public final void clearShowingState() {
        this.isShowing = false;
    }

    public final void showingState() {
        this.isShowing = true;
    }

    public final void tianShuAdCheck(@NotNull final ProfileCardInfo profileCardInfo, @Nullable final QBaseActivity activity) {
        final QQAppInterface qQAppInterface;
        String str;
        Intrinsics.checkNotNullParameter(profileCardInfo, "profileCardInfo");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.preRequestTime < 2000) {
            QLog.w(TAG, 1, "\u77ed\u65f6\u95f4\u8fde\u7eed\u8bf7\u6c42,\u8fdb\u884c\u63a7\u5236");
            return;
        }
        this.preRequestTime = currentTimeMillis;
        if (activity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Boolean bool = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        AllInOne allInOne = profileCardInfo.allInOne;
        if (allInOne != null) {
            str = allInOne.uin;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, qQAppInterface.getCurrentAccountUin())) {
            if (!SimpleUIUtil.isNowSimpleMode() && !((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                showingState();
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.component.accountinfo.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProfileAdWindowHelper.tianShuAdCheck$lambda$0(ProfileAdWindowHelper.this, qQAppInterface, profileCardInfo, activity);
                    }
                }, 1000L);
                return;
            }
            boolean isNowSimpleMode = SimpleUIUtil.isNowSimpleMode();
            boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
            Card card = profileCardInfo.card;
            if (card != null) {
                bool = Boolean.valueOf(card.dressUpIsOn);
            }
            QLog.w(TAG, 1, "block by mode: simple " + isNowSimpleMode + " study:" + studyModeSwitch + " dressUpIsOn:" + bool);
            return;
        }
        QLog.w(TAG, 1, "uin is invalid card.uin:" + str + " , cur uin:" + qQAppInterface.getCurrentAccountUin());
    }
}
