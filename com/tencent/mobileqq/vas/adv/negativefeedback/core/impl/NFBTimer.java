package com.tencent.mobileqq.vas.adv.negativefeedback.core.impl;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.adv.negativefeedback.bean.NFBSessionInfo;
import com.tencent.mobileqq.vas.adv.negativefeedback.config.NFBHeartBeatConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mz2.b;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBTimer;", "Ljava/lang/Runnable;", "", "f", TencentLocation.RUN_MODE, "", "stop", "g", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "d", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "sessionInfo", "", "e", "I", "mHeartBeatCount", "Z", "mStopFlag", "<init>", "(Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;)V", h.F, "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NFBTimer implements Runnable {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<List<Integer>> f308125i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NFBSessionInfo sessionInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mHeartBeatCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mStopFlag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBTimer$a;", "", "", "", "DURATION_TIMES$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/List;", "DURATION_TIMES", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.negativefeedback.core.impl.NFBTimer$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Integer> b() {
            return (List) NFBTimer.f308125i.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<List<Integer>> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<Integer>>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.core.impl.NFBTimer$Companion$DURATION_TIMES$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<Integer> invoke() {
                return NFBHeartBeatConfigParser.INSTANCE.a().a();
            }
        });
        f308125i = lazy;
    }

    public NFBTimer(@NotNull NFBSessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.sessionInfo = sessionInfo;
    }

    private final void f() {
        Map<String, String> mapOf;
        long currentTimeMillis = System.currentTimeMillis();
        long startTime = currentTimeMillis - this.sessionInfo.getStartTime();
        long heartBeatTime = currentTimeMillis - this.sessionInfo.getHeartBeatTime();
        this.sessionInfo.i(currentTimeMillis);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, String.valueOf(startTime)), TuplesKt.to("delta_time", String.valueOf(heartBeatTime)));
        b.f417903a.e(this.sessionInfo.c(), "pg_dur", this.sessionInfo.getSessionId(), mapOf, this.sessionInfo.d());
    }

    public final void g(boolean stop) {
        this.mStopFlag = stop;
    }

    @Override // java.lang.Runnable
    public void run() {
        int intValue;
        QLog.d("NegativeFBTimer", 4, "FB duration timer execute");
        if (this.mStopFlag) {
            QLog.d("NegativeFBTimer", 4, "FB duration timer return, activity stopped");
            return;
        }
        if (this.mHeartBeatCount != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("NegativeFBTimer", 4, "FB duration timer report, heartBeatCount: " + this.mHeartBeatCount);
            }
            f();
        }
        int i3 = this.mHeartBeatCount;
        Companion companion = INSTANCE;
        if (i3 >= companion.b().size()) {
            return;
        }
        if (this.mHeartBeatCount == 0) {
            intValue = ((Number) companion.b().get(this.mHeartBeatCount)).intValue();
        } else {
            intValue = ((Number) companion.b().get(this.mHeartBeatCount)).intValue() - ((Number) companion.b().get(this.mHeartBeatCount - 1)).intValue();
        }
        this.mHeartBeatCount++;
        ThreadManagerV2.getUIHandlerV2().postDelayed(this, intValue);
    }
}
