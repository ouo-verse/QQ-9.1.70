package com.tencent.mobileqq.vashealth.api.impl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.vashealth.QQSportRequestUtil;
import com.tencent.mobileqq.vashealth.RunningBannerProcessor;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.f;
import com.tencent.mobileqq.vashealth.n;
import com.tencent.mobileqq.vashealth.u;
import com.tencent.qphone.base.util.QLog;
import h43.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\f\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0004H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthApiImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthApi;", "", "uin", "", "isHealthUin", "isNeedRedirectAIOToMainPage", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/persistence/Entity;", "getTracePathDataClass", "getTracePointDataClass", "Landroid/content/Context;", "appContext", "isSupportStepCounter", "isNeedReport", "Lmqq/app/NewIntent;", "getStepCounterServletIntent", "getSpLBSLatitude", "getSpLBSLogitude", "getSpLBSUpdateTimeStamp", "", "runningState", "cookieUrl", "", "showBanner", "hideBanner", "getParserClass", "url", "isHealthDomain", "isSubscribedHealthPA", "Lh43/d;", "callback", "requestRankingState", "getRankingSwitchStateDefault", h.f248218g, "requestJoinRanking", "<init>", "()V", "Companion", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQHealthApiImpl implements IQQHealthApi {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String TAG = "QQHealthApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @NotNull
    public Class<?> getParserClass() {
        return n.class;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean getRankingSwitchStateDefault() {
        return QQSportRequestUtil.f312159a.q();
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @NotNull
    public String getSpLBSLatitude() {
        return "search_lbs_latitude";
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @NotNull
    public String getSpLBSLogitude() {
        return "search_lbs_logitude";
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @NotNull
    public String getSpLBSUpdateTimeStamp() {
        return "search_lbs_timestamp";
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @Nullable
    public NewIntent getStepCounterServletIntent(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        NewIntent newIntent = new NewIntent(appContext, u.class);
        newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_HEALTH_SWITCH);
        return newIntent;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @NotNull
    public Class<? extends Entity> getTracePathDataClass() {
        return TracePathData.class;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    @NotNull
    public Class<? extends Entity> getTracePointDataClass() {
        return TracePointsData.class;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public void hideBanner() {
        BannerManager.l().E(RunningBannerProcessor.f312172e, 3000, 1000L);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean isHealthDomain(@NotNull String url) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        if (!TextUtils.isEmpty(url)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "yundong.qq.com", false, 2, null);
            return startsWith$default;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean isHealthUin(@Nullable String uin) {
        return Intrinsics.areEqual(IPublicAccountUtil.UIN_FOR_HEALTH, uin);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean isNeedRedirectAIOToMainPage(@Nullable String uin) {
        return f.f312270a.i(uin);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean isNeedReport(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return SSOHttpUtils.p(1, uin);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean isSubscribedHealthPA() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        return ((IPublicAccountDataManager) runtimeService).isFollowedUin(Long.valueOf(Long.parseLong(IPublicAccountUtil.UIN_FOR_HEALTH)));
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public boolean isSupportStepCounter(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return SportManagerImpl.isSupportStepCounter(appContext);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public /* bridge */ /* synthetic */ void requestJoinRanking(Boolean bool) {
        requestJoinRanking(bool.booleanValue());
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public void requestRankingState(@Nullable d callback) {
        QQSportRequestUtil.f312159a.C(callback);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthApi
    public void showBanner(long runningState, @Nullable String cookieUrl) {
        try {
            Message obtain = Message.obtain();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("runningState", runningState);
            jSONObject.put("cookieUrl", cookieUrl);
            obtain.obj = jSONObject;
            BannerManager.l().O(RunningBannerProcessor.f312172e, 2, obtain);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public void requestJoinRanking(boolean isOpen) {
        QQSportRequestUtil.f312159a.A(isOpen);
    }
}
