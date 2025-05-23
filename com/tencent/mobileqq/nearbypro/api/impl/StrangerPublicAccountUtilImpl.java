package com.tencent.mobileqq.nearbypro.api.impl;

import android.content.Context;
import ca2.PublicAccountConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil;
import com.tencent.mobileqq.nearbypro.base.c;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\r\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J(\u0010\u0010\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/impl/StrangerPublicAccountUtilImpl;", "Lcom/tencent/mobileqq/nearbypro/api/IStrangerPublicAccountUtil;", "", "Lcom/tencent/mobileqq/nearbypro/api/data/AppID;", "appId", "Lca2/c;", "loadConfig", "", "shouldShowFollowModal", "", "markShowFollowModal", "shouldShowFollowBar", "markCloseFollowBar", "isFollowed", "Lkotlin/Function1;", "cb", "follow", "", "uin", "isPAUin", "Landroid/content/Context;", "context", "jumpToPublicAccountPage", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StrangerPublicAccountUtilImpl implements IStrangerPublicAccountUtil {

    @NotNull
    private static final String QQMC_CONFIG_KEY = "103255";

    @NotNull
    private static final String TAG = "StrangerPublicAccountUtil";

    @NotNull
    private static final Map<Integer, String> appIdToConfigKey;

    @NotNull
    private static Map<Integer, PublicAccountConfig> configs;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/nearbypro/api/impl/StrangerPublicAccountUtilImpl$b", "Lcom/tencent/biz/pubaccount/api/IPublicAccountObserver$c;", "", "isSuccess", "", "uin", "", "onFollowPublicAccount", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f253153a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f253153a = function1;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean isSuccess, @Nullable String uin) {
            boolean equals$default;
            equals$default = StringsKt__StringsJVMKt.equals$default(uin, uin, false, 2, null);
            if (!equals$default) {
                return;
            }
            j.c().e(StrangerPublicAccountUtilImpl.TAG, "[followPublicAccount] uin=" + uin + ", success=" + isSuccess);
            this.f253153a.invoke(Boolean.valueOf(isSuccess));
        }
    }

    static {
        Map<Integer, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "jieban"), TuplesKt.to(2, ProcessConstant.NEARBY));
        appIdToConfigKey = mapOf;
        configs = new LinkedHashMap();
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public void follow(int appId, @NotNull Function1<? super Boolean, Unit> cb5) {
        String str;
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(cb5, "cb");
        PublicAccountConfig loadConfig = loadConfig(appId);
        Context context = null;
        if (loadConfig != null) {
            str = loadConfig.getUin();
        } else {
            str = null;
        }
        if (str == null) {
            cb5.invoke(Boolean.FALSE);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        QRouteApi api = QRoute.api(IPublicAccountObserver.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountObserver::class.java)");
        IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) api;
        iPublicAccountObserver.setOnCallback(new b(cb5));
        IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
        if (appInterface != null) {
            context = appInterface.getApplicationContext();
        }
        iPublicAccountUtil.followUin(appInterface, context, str, iPublicAccountObserver);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public boolean isFollowed(int appId) {
        String uin;
        AppInterface appInterface;
        PublicAccountConfig loadConfig = loadConfig(appId);
        if (loadConfig != null && (uin = loadConfig.getUin()) != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            return ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(appInterface, uin);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public boolean isPAUin(@Nullable String uin) {
        boolean z16;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (Intrinsics.areEqual(uin, AppConstants.NEARBY_PUBLIC_ACCOUNT_UIN) || Intrinsics.areEqual(uin, AppConstants.JIEBAN_PUBLIC_ACCOUNT_UIN)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public void jumpToPublicAccountPage(@Nullable Context context, @Nullable String uin) {
        boolean z16;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            j.c().d("QQStrangerPublicAccountApiImpl", "uin is null or empty");
        } else {
            lb2.b.INSTANCE.b(context, uin);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    @Nullable
    public synchronized PublicAccountConfig loadConfig(int appId) {
        String str;
        JSONObject optJSONObject;
        PublicAccountConfig publicAccountConfig = configs.get(Integer.valueOf(appId));
        if (publicAccountConfig != null) {
            return publicAccountConfig;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(QQMC_CONFIG_KEY, "{}");
        j.c().e(TAG, "loadConfig(appId=" + appId + "): " + loadAsString);
        PublicAccountConfig publicAccountConfig2 = null;
        try {
            str = appIdToConfigKey.get(Integer.valueOf(appId));
            if (str == null) {
                str = "";
            }
            optJSONObject = new JSONObject(loadAsString).optJSONObject(str);
        } catch (Exception e16) {
            j.c().d(TAG, "loadConfig failed " + e16);
        }
        if (optJSONObject == null) {
            j.c().d(TAG, "loadConfig failed key=" + str);
            return null;
        }
        String uin = optJSONObject.optString("uin");
        String name = optJSONObject.optString("name");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("follow_modal");
        if (optJSONObject2 == null) {
            return null;
        }
        boolean optBoolean = optJSONObject2.optBoolean("enable", false);
        String title = optJSONObject2.optString("title");
        String posterUrl = optJSONObject2.optString("poster_url");
        long optLong = optJSONObject2.optLong("show_interval_s");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Intrinsics.checkNotNullExpressionValue(posterUrl, "posterUrl");
        PublicAccountConfig.FollowModalConfig followModalConfig = new PublicAccountConfig.FollowModalConfig(optBoolean, title, posterUrl, optLong);
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("follow_bar");
        if (optJSONObject3 == null) {
            return null;
        }
        boolean optBoolean2 = optJSONObject3.optBoolean("enable", false);
        String title2 = optJSONObject3.optString("title");
        String icon = optJSONObject3.optString("icon");
        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("show_interval_s");
        if (optJSONObject4 == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(optJSONObject4, "optJSONObject(\"show_interval_s\")");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : nf2.a.e(optJSONObject4).entrySet()) {
            linkedHashMap.put(Integer.valueOf(Integer.parseInt(entry.getKey())), Integer.valueOf(Integer.parseInt(entry.getValue().toString())));
        }
        Intrinsics.checkNotNullExpressionValue(title2, "title");
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        PublicAccountConfig.FollowBarConfig followBarConfig = new PublicAccountConfig.FollowBarConfig(optBoolean2, title2, icon, linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Intrinsics.checkNotNullExpressionValue(name, "name");
        publicAccountConfig2 = new PublicAccountConfig(appId, uin, name, followModalConfig, followBarConfig);
        if (publicAccountConfig2 != null) {
            configs.put(Integer.valueOf(appId), publicAccountConfig2);
        }
        return publicAccountConfig2;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public void markCloseFollowBar(int appId) {
        c.a.m(j.d(), "NBP_CACHE_KEY_CLOSE_FOLLOW_PUBLIC_ACCOUNT_BAR_TIME_" + appId, String.valueOf(System.currentTimeMillis()), null, false, 12, null);
        String str = "NBP_CACHE_KEY_CLOSE_FOLLOW_PUBLIC_ACCOUNT_BAR_COUNT_" + appId;
        c.a.k(j.d(), str, c.a.d(j.d(), str, 0, null, false, 12, null) + 1, null, false, 12, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public void markShowFollowModal(int appId) {
        c.a.m(j.d(), "NBP_CACHE_KEY_SHOW_FOLLOW_PUBLIC_ACCOUNT_MODAL_TIME_" + appId, String.valueOf(System.currentTimeMillis()), null, false, 12, null);
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public boolean shouldShowFollowBar(int appId) {
        List sorted;
        int i3;
        Long longOrNull;
        long j3;
        int intValue;
        PublicAccountConfig loadConfig = loadConfig(appId);
        if (loadConfig == null) {
            return false;
        }
        if (!loadConfig.getFollowBar().getEnable()) {
            j.c().e(TAG, "[shouldShowFollowBar] enable=false");
            return false;
        }
        if (isFollowed(appId)) {
            j.c().e(TAG, "[shouldShowFollowBar] already followed");
            return false;
        }
        String str = "NBP_CACHE_KEY_CLOSE_FOLLOW_PUBLIC_ACCOUNT_BAR_TIME_" + appId;
        int d16 = c.a.d(j.d(), "NBP_CACHE_KEY_CLOSE_FOLLOW_PUBLIC_ACCOUNT_BAR_COUNT_" + appId, 0, null, false, 12, null);
        if (d16 != 0) {
            sorted = CollectionsKt___CollectionsKt.sorted(loadConfig.getFollowBar().c().keySet());
            Iterator it = sorted.iterator();
            loop0: while (true) {
                i3 = 0;
                while (it.hasNext() && d16 >= (intValue = ((Number) it.next()).intValue())) {
                    Integer num = loadConfig.getFollowBar().c().get(Integer.valueOf(intValue));
                    if (num != null) {
                        i3 = num.intValue();
                    }
                }
            }
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(c.a.g(j.d(), str, "0", null, false, 12, null));
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            long j16 = 1000;
            long j17 = j3 / j16;
            long currentTimeMillis = System.currentTimeMillis() / j16;
            if (currentTimeMillis - j17 < i3) {
                j.c().e(TAG, "[shouldShowFollowBar] frequency limited: lastCloseTimeS=" + j17 + "s, currentTime=" + currentTimeMillis + "s, closeCount=" + d16 + ", targetIntvl=" + i3 + ReportConstant.COSTREPORT_PREFIX);
                return false;
            }
            j.c().e(TAG, "[shouldShowFollowBar] should show modal!");
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil
    public boolean shouldShowFollowModal(int appId) {
        Long longOrNull;
        long j3;
        PublicAccountConfig loadConfig = loadConfig(appId);
        if (loadConfig == null) {
            return false;
        }
        if (!loadConfig.getFollowModal().getEnable()) {
            j.c().e(TAG, "[shouldShowFollowModal] enable=false");
            return false;
        }
        if (isFollowed(appId)) {
            j.c().e(TAG, "[shouldShowFollowModal] already followed");
            return false;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(c.a.g(j.d(), "NBP_CACHE_KEY_SHOW_FOLLOW_PUBLIC_ACCOUNT_MODAL_TIME_" + appId, "0", null, false, 12, null));
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        long j16 = 1000;
        long j17 = j3 / j16;
        long currentTimeMillis = System.currentTimeMillis() / j16;
        if (currentTimeMillis - j17 < loadConfig.getFollowModal().getShowIntervalS()) {
            j.c().e(TAG, "[shouldShowFollowModal] frequency limited: lastShowTime=" + j17 + "s, currentTime=" + currentTimeMillis + "s, configInterval=" + loadConfig.getFollowModal().getShowIntervalS() + ReportConstant.COSTREPORT_PREFIX);
            return false;
        }
        j.c().e(TAG, "[shouldShowFollowModal] should show modal! lastShowTime=" + j17 + "s, currentTime=" + currentTimeMillis + "s, configInterval=" + loadConfig.getFollowModal().getShowIntervalS() + ReportConstant.COSTREPORT_PREFIX);
        return true;
    }
}
