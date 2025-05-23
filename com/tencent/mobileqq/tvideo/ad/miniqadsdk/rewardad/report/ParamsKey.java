package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/ParamsKey;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public @interface ParamsKey {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f304299f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0013\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/ParamsKey$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setCALL_ID", "(Ljava/lang/String;)V", "CALL_ID", "c", "setENGINE_TYPE", "ENGINE_TYPE", "e", "setTIME_COST", "TIME_COST", "d", "setBUNDLE_ID", "BUNDLE_ID", "setFAIL_REASON", "FAIL_REASON", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.ParamsKey$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* renamed from: f, reason: collision with root package name */
        static final /* synthetic */ Companion f304299f = new Companion();

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String CALL_ID = "callid";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String ENGINE_TYPE = StartupReportKey.ENGINE_TYPE;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String TIME_COST = "time_cost";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String BUNDLE_ID = ReportDataBuilder.KEY_BUNDLE_ID;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static String FAIL_REASON = VRReportDefine$ReportParam.FAIL_REASON;

        Companion() {
        }

        @NotNull
        public final String a() {
            return BUNDLE_ID;
        }

        @NotNull
        public final String b() {
            return CALL_ID;
        }

        @NotNull
        public final String c() {
            return ENGINE_TYPE;
        }

        @NotNull
        public final String d() {
            return FAIL_REASON;
        }

        @NotNull
        public final String e() {
            return TIME_COST;
        }
    }
}
