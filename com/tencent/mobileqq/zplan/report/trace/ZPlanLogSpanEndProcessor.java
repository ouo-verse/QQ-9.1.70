package com.tencent.mobileqq.zplan.report.trace;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.zplantracing.ZPlanSpanData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/trace/ZPlanLogSpanEndProcessor;", "Lcom/tencent/zplan/zplantracing/a;", "Lcom/tencent/zplan/zplantracing/ZPlanSpanData;", "spanData", "", "handleSpanData", "", "enableLog$delegate", "Lkotlin/Lazy;", "getEnableLog", "()Z", "enableLog", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanLogSpanEndProcessor implements com.tencent.zplan.zplantracing.a {
    public static final String TAG = "ZPlanLogSpanEndProcessor";

    /* renamed from: enableLog$delegate, reason: from kotlin metadata */
    private final Lazy enableLog;

    public ZPlanLogSpanEndProcessor() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.report.trace.ZPlanLogSpanEndProcessor$enableLog$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.enableOpenTelemetryReport());
            }
        });
        this.enableLog = lazy;
    }

    private final boolean getEnableLog() {
        return ((Boolean) this.enableLog.getValue()).booleanValue();
    }

    @Override // com.tencent.zplan.zplantracing.a
    public void handleSpanData(ZPlanSpanData spanData) {
        Intrinsics.checkNotNullParameter(spanData, "spanData");
        if (getEnableLog()) {
            QLog.i(TAG, 1, "logprocessor spanData: " + spanData);
        }
    }
}
