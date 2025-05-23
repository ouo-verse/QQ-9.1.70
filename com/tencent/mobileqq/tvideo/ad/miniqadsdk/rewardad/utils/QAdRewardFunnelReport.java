package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import pw2.n;
import pw2.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport;", "", "", "step", "", "a", "b", "I", "INTERVAL", "<init>", "()V", "FunnelReportKey", "FunnelReportParams", "LoadStep", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class QAdRewardFunnelReport {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final QAdRewardFunnelReport f304329b = new QAdRewardFunnelReport();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static int INTERVAL = 1000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport$FunnelReportKey;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes19.dex */
    public @interface FunnelReportKey {

        @NotNull
        public static final String CANCEL_REQUEST = "reward_ad_cancel_request";

        @NotNull
        public static final String CLICK = "reward_ad_click";

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f304330a;

        @NotNull
        public static final String LOAD_AD = "reward_ad_load";

        @NotNull
        public static final String REQUEST = "reward_ad_request";

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport$FunnelReportKey$a;", "", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardFunnelReport$FunnelReportKey$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f304330a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport$FunnelReportParams;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes19.dex */
    public @interface FunnelReportParams {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f304331a;

        @NotNull
        public static final String ERROR_CODE = "error_code";

        @NotNull
        public static final String IS_DOUBLE_CLICK = "is_double_click";

        @NotNull
        public static final String STEP = "step";

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport$FunnelReportParams$a;", "", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardFunnelReport$FunnelReportParams$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f304331a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport$LoadStep;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes19.dex */
    public @interface LoadStep {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f304332a;
        public static final int STEP1 = 1;
        public static final int STEP2 = 2;
        public static final int STEP3 = 3;
        public static final int STEP4 = 4;
        public static final int STEP5 = 5;
        public static final int STEP6 = 6;
        public static final int STEP7 = 7;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/utils/QAdRewardFunnelReport$LoadStep$a;", "", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardFunnelReport$LoadStep$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f304332a = new Companion();

            Companion() {
            }
        }
    }

    QAdRewardFunnelReport() {
    }

    public final void a(int step) {
        n.e("[RewardAd]QAdRewardFunnelReport", "doAdLoadReport, step = " + step);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("step", Integer.valueOf(step));
        w.i(FunnelReportKey.LOAD_AD, linkedHashMap);
    }

    public final void b() {
        n.e("[RewardAd]QAdRewardFunnelReport", "doAdRequestReport");
        w.i(FunnelReportKey.REQUEST, null);
    }
}
