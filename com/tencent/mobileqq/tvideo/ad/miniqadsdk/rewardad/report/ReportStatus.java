package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/ReportStatus;", "", "Companion", "a", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public @interface ReportStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f304300a;
    public static final int ENGINE_CREATE_FAILURE = 14;
    public static final int ENGINE_CREATE_START = 11;
    public static final int ENGINE_CREATE_SUCCESS = 13;
    public static final int ENGINE_INIT_FAILURE = 16;
    public static final int ENGINE_INIT_SUCCESS = 15;
    public static final int JS_LOAD_FAILURE = 20;
    public static final int JS_LOAD_SUCCESS = 19;
    public static final int VIEW_COMPLETED = 21;
    public static final int VIEW_CREATE_FAILURE = 18;
    public static final int VIEW_CREATE_SUCCESS = 17;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/ReportStatus$a;", "", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.ReportStatus$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f304300a = new Companion();

        Companion() {
        }
    }
}
