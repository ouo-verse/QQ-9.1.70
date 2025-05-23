package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.entrance.impl.ExpandEntranceImpl;
import com.tencent.mobileqq.qqexpand.fragment.ExpandOfflineFragment;
import com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.manager.Manager;
import wg2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J8\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00062&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0017H\u0002J@\u0010\u001c\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010 \u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J>\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0\u0016j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!`\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010$\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010#2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J6\u0010%\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/entrance/impl/ExpandEntranceImpl;", "Lcom/tencent/mobileqq/qqexpand/entrance/IExpandEntrance;", "Landroid/content/Context;", "activityContext", "Lcom/tencent/common/app/AppInterface;", "app", "", "pageName", "", "sourceType", WadlProxyConsts.KEY_JUMP_URL, "", "enterFlutterExpand", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "enterExpandOfflinePage", "checkABTestPassTime", "", "success", "", "abTestLastPullTime", "reportGetAbTestCost", AdMetricTag.EVENT_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "reportData", "entry", "page", "jump2FlutterExpandByWidgetName", "getUserCategoryConfig", "getQuietMode", "preloadConfigData", "enterExpand", "", "enterExpandPlugin", "Landroid/app/Activity;", "enterExpandLimitMatch", "enterExpandByJumpAction", "<init>", "()V", "Companion", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandEntranceImpl implements IExpandEntrance {
    public static final String TAG = "ExpandEntranceImpl";
    private static long mLastOpenExpandTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkABTestPassTime$lambda$2(AppInterface appInterface, final ExpandEntranceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            QLog.d(TAG, 1, "checkABTestPassTime uin is empty");
            return;
        }
        if (f.f(currentAccountUin)) {
            return;
        }
        f.g(currentAccountUin, System.currentTimeMillis());
        Manager manager = appInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        this$0.reportData("expand_quality#exp_info#exp_request", null);
        ((e) manager).E(new a() { // from class: xg2.c
            @Override // wg2.a
            public final void onFinish(boolean z16) {
                ExpandEntranceImpl.checkABTestPassTime$lambda$2$lambda$1(ExpandEntranceImpl.this, longRef, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkABTestPassTime$lambda$2$lambda$1(ExpandEntranceImpl this$0, Ref.LongRef abTestLastPullTime, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(abTestLastPullTime, "$abTestLastPullTime");
        QLog.d(TAG, 1, "getABTestConfig success " + z16);
        this$0.reportGetAbTestCost(z16, abTestLastPullTime.element);
    }

    private final void enterExpandOfflinePage(Context activity) {
        QPublicFragmentActivity.start(activity, new Intent(), ExpandOfflineFragment.class);
    }

    private final void enterFlutterExpand(Context activityContext, AppInterface app, String pageName, int sourceType, String jumpUrl) {
        enterExpandOfflinePage(activityContext);
    }

    private final void getQuietMode(final AppInterface app) {
        ThreadManagerV2.excute(new Runnable() { // from class: xg2.b
            @Override // java.lang.Runnable
            public final void run() {
                ExpandEntranceImpl.getQuietMode$lambda$3(AppInterface.this);
            }
        }, 128, null, true);
    }

    private final void jump2FlutterExpandByWidgetName(Context activity, AppInterface app, String entry, String page, int sourceType, String jumpUrl) {
        if (System.currentTimeMillis() - mLastOpenExpandTime < 1000) {
            QLog.i(TAG, 4, "jump2Expand wait a while");
            return;
        }
        mLastOpenExpandTime = System.currentTimeMillis();
        preloadConfigData(app);
        HashMap hashMap = new HashMap();
        hashMap.put("hostId", "8531243");
        hashMap.put("uid", app.getCurrentAccountUin());
        if (sourceType == 6) {
            hashMap.put("isPresent", 1);
        } else {
            hashMap.put("isPresent", 0);
        }
        hashMap.put("from", ExpandPublicFragmentActivity.getReportFromPage(sourceType));
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(currentTimeMillis);
        hashMap.put("startTime", sb5.toString());
        hashMap.put("isRelease", QLog.isDebugVersion() ? "0" : "1");
        hashMap.put("serverEnv", QLog.isDebugVersion() ? "0" : "1");
        hashMap.put("statusBarHeight", Integer.valueOf(ViewUtils.pxToDp(ImmersiveUtils.getStatusBarHeight(activity))));
        hashMap.put("screenWidth", Integer.valueOf(ViewUtils.pxToDp(BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(ViewUtils.pxToDp(BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels)));
        Manager manager = app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
        e eVar = (e) manager;
        if (eVar.e() != null) {
            hashMap.put("centerBannerList", eVar.e().centerBannerList);
            QLog.d(TAG, 4, "jump2FlutterExpandByWidgetName " + hashMap.get("centerBannerList"));
            if (!TextUtils.isEmpty(eVar.e().testStrId)) {
                hashMap.put("testId", eVar.e().testStrId);
            } else {
                int i3 = eVar.e().testId;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(i3);
                hashMap.put("testId", sb6.toString());
            }
        }
        hashMap.put("isHasPersonalLabels", eVar.B() ? "1" : "0");
        boolean C = eVar.C();
        boolean c16 = eVar.c();
        if (C == c16 && QLog.isColorLevel()) {
            QLog.w(TAG, 2, "usedNewMatch and firstPromptExtendFriendNewUser flag is the same");
        }
        if (!C && c16) {
            hashMap.put("isUsedNewExpand", "0");
            eVar.b0(false);
        } else {
            hashMap.put("isUsedNewExpand", "1");
        }
        int X = eVar.X();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(X);
        hashMap.put("userCategory", sb7.toString());
        hashMap.put("isHasNewUserMoment", eVar.T() ? "1" : "0");
        int a16 = eVar.a();
        StringBuilder sb8 = new StringBuilder();
        sb8.append(a16);
        hashMap.put("isHasUpgradeIntroduce", sb8.toString());
        hashMap.put("wavesId", sourceType == 2 ? eVar.i() : "");
        hashMap.put("jump", jumpUrl);
        hashMap.put("serverTime", Long.valueOf(NetConnInfoCenter.getServerTime()));
        hashMap.put("isCloseBlindBox", QLog.isDebugVersion() ? "0" : "1");
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("jump2FlutterExpandByWidgetName params=%s", Arrays.copyOf(new Object[]{hashMap.toString()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
        }
    }

    private final void preloadConfigData(AppInterface app) {
        checkABTestPassTime(app);
        getUserCategoryConfig(app);
        getQuietMode(app);
    }

    private final void reportData(String eventName, HashMap<String, String> params) {
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel(eventName, true, -1L, -1L, params, true, true);
    }

    private final void reportGetAbTestCost(boolean success, long abTestLastPullTime) {
        long currentTimeMillis = System.currentTimeMillis() - abTestLastPullTime;
        int i3 = success ? 1 : 2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("time_cost", String.valueOf(currentTimeMillis));
        hashMap.put("result_code", String.valueOf(i3));
        reportData("expand_quality#exp_info#exp_callback", hashMap);
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance
    public void enterExpand(Context activityContext, AppInterface app, int sourceType) {
        if (activityContext != null && app != null) {
            Manager manager = app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExpandManager");
            ExpandManager expandManager = (ExpandManager) manager;
            QLog.i(TAG, 4, "jump2AB850Expand go to a page with field <expandVersion>");
            expandManager.G0();
            expandManager.I0();
            enterFlutterExpand(activityContext, app, IExpandEntrance.PAGE_MATCH_HOME, sourceType, "");
            return;
        }
        QLog.e(TAG, 2, "enterExpand context is null " + (activityContext == null) + " or app is null " + (app == null));
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance
    public void enterExpandByJumpAction(Context activity, AppInterface app, String pageName, int sourceType, String jumpUrl) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (activity != null && app != null) {
            Manager manager = app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExpandManager");
            QLog.i(TAG, 4, "jump2AB850Expand go to a page with field <expandVersion>");
            ((ExpandManager) manager).G0();
            enterFlutterExpand(activity, app, pageName, sourceType, jumpUrl);
            return;
        }
        QLog.e(TAG, 2, "enterExpandByJumpAction context is null " + (activity == null) + " or app is null " + (app == null));
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance
    public void enterExpandLimitMatch(Activity activity, AppInterface app, int sourceType) {
        boolean z16 = app instanceof QQAppInterface;
        if (z16 && activity != null) {
            enterFlutterExpand(activity, app, IExpandEntrance.PAGE_MATCH_HOME, 6, "");
            activity.overridePendingTransition(R.anim.f154344g1, R.anim.f154343g0);
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("5");
            return;
        }
        QLog.e(TAG, 2, "enterExpandLimitMatch app is not QQAppInterface " + (!z16) + " or activity is null " + (activity == null));
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance
    public void enterExpandPlugin(Context activityContext, HashMap<String, Object> params, String jumpUrl) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(params, "params");
        ExpandPluginLauncher.INSTANCE.a().w(activityContext, params, jumpUrl);
    }

    private final void checkABTestPassTime(final AppInterface app) {
        if (app == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: xg2.a
            @Override // java.lang.Runnable
            public final void run() {
                ExpandEntranceImpl.checkABTestPassTime$lambda$2(AppInterface.this, this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getQuietMode$lambda$3(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.d(TAG, 1, "getQuietMode app is empty");
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl");
        ((ExpandHandlerImpl) businessHandler).k1(appInterface.getCurrentUin());
    }

    private final void getUserCategoryConfig(AppInterface app) {
    }
}
