package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0003\u0005\u0007\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d;", "", "", "specialId", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d$c;", "a", "", "b", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "c", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mRewardTaskMap", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ActiveController> mRewardTaskMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d$a;", "", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final d a() {
            return b.f304219b.a();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d$b;", "", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d;", "a", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d;", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d;", "INSTANCE", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes19.dex */
    private static final class b {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f304219b = new b();

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final d INSTANCE = new d();

        b() {
        }

        @NotNull
        public final d a() {
            return INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u000b\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\r\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/d$c;", "", "", "toString", "", "a", "Z", "isUnlock", "()Z", "d", "(Z)V", "b", "isFinshTask", "c", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "packageName", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController;", "e", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController;", "getController", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController;", "setController", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/QAdRewardController;)V", "controller", "f", "getSpecialId", "specialId", "", "g", "J", "getCreateTime", "()J", WadlProxyConsts.CREATE_TIME, "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller.d$c, reason: from toString */
    /* loaded from: classes19.dex */
    public static final class ActiveController {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isUnlock;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isFinshTask;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String packageName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String orderId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private QAdRewardController controller;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String specialId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final long createTime;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getOrderId() {
            return this.orderId;
        }

        public final void b(boolean z16) {
            this.isFinshTask = z16;
        }

        public final void c(@Nullable String str) {
            this.orderId = str;
        }

        public final void d(boolean z16) {
            this.isUnlock = z16;
        }

        @NotNull
        public String toString() {
            return "ActiveController(controller=" + this.controller + ", specialId='" + this.specialId + "', createTime=" + this.createTime + ", isUnlock=" + this.isUnlock + ", isFinshTask=" + this.isFinshTask + ", packageName='" + this.packageName + "')";
        }
    }

    @Nullable
    public final synchronized ActiveController a(@Nullable String specialId) {
        if (specialId == null) {
            return null;
        }
        ActiveController activeController = this.mRewardTaskMap.get(specialId);
        n.e("[RewardAd]QAdRewardTaskManager", "findCurrTask, specialId = " + specialId);
        return activeController;
    }

    public final synchronized void b(@NotNull String specialId) {
        Intrinsics.checkNotNullParameter(specialId, "specialId");
        ActiveController a16 = a(specialId);
        if (a16 != null) {
            a16.b(true);
        }
    }

    public final synchronized void c(@NotNull String specialId, @Nullable String orderId) {
        Intrinsics.checkNotNullParameter(specialId, "specialId");
        ActiveController a16 = a(specialId);
        if (a16 != null) {
            a16.c(orderId);
            if (a16.getOrderId() == null) {
                a16.b(true);
            }
        }
    }

    public final synchronized void d(@NotNull String specialId) {
        Intrinsics.checkNotNullParameter(specialId, "specialId");
        ActiveController a16 = a(specialId);
        if (a16 != null) {
            a16.d(true);
        }
    }
}
