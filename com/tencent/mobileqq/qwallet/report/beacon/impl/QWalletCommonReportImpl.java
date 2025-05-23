package com.tencent.mobileqq.qwallet.report.beacon.impl;

import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;
import com.tencent.mobileqq.qwallet.report.beacon.QWalletTechBeaconReport;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ml2.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0010H\u0016J<\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0012j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/report/beacon/impl/QWalletCommonReportImpl;", "Lcom/tencent/mobileqq/qwallet/report/beacon/IQWalletCommonReport;", "()V", "reporter", "Lcom/tencent/mobileqq/qwallet/report/beacon/QWalletTechBeaconReport;", "getReporter", "()Lcom/tencent/mobileqq/qwallet/report/beacon/QWalletTechBeaconReport;", "reporter$delegate", "Lkotlin/Lazy;", "report", "", "eventCode", "", "reportBean", "", "params", "", "reportRemote", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sampleRate", "", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QWalletCommonReportImpl implements IQWalletCommonReport {

    /* renamed from: reporter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy reporter;

    public QWalletCommonReportImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletTechBeaconReport>() { // from class: com.tencent.mobileqq.qwallet.report.beacon.impl.QWalletCommonReportImpl$reporter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletTechBeaconReport invoke() {
                return new QWalletTechBeaconReport();
            }
        });
        this.reporter = lazy;
    }

    private final QWalletTechBeaconReport getReporter() {
        return (QWalletTechBeaconReport) this.reporter.getValue();
    }

    @Override // com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport
    public void report(@NotNull String eventCode, @NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        QWalletTechBeaconReport.e(getReporter(), eventCode, params, 0, false, 12, null);
    }

    @Override // com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport
    public void reportRemote(@NotNull String eventCode, @NotNull HashMap<String, String> params, int sampleRate) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        QWalletTechBeaconReport.e(getReporter(), eventCode, params, sampleRate, false, 8, null);
    }

    @Override // com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport
    public void report(@NotNull String eventCode, @NotNull Object reportBean) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(d.f416922a.a(reportBean));
        report(eventCode, (Map<String, String>) linkedHashMap);
    }
}
