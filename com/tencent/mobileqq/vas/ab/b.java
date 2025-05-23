package com.tencent.mobileqq.vas.ab;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u4f7f\u7528[VasTabFactory]")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/ab/b;", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/vas/ab/ABTest;", "", "", "a", "Ljava/lang/String;", "testName", "<init>", "(Ljava/lang/String;)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String testName;

    public b(@NotNull String testName) {
        Intrinsics.checkNotNullParameter(testName, "testName");
        this.testName = testName;
    }

    @NotNull
    public final Pair<ABTest, Map<String, String>> a() {
        boolean z16;
        String trimIndent;
        ABTest aBTest;
        Map<String, String> tabParams;
        long j3;
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_1505, this.testName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026ler.APPID_1505, testName)");
        if (expEntity.isExperiment() || expEntity.isContrast()) {
            expEntity.reportExpExposure();
        }
        z16 = c.f307908a;
        if (z16) {
            ReportInfo hotFeature = VasCommonReporter.getHotFeature("card_test_report");
            if (expEntity.isExperiment()) {
                j3 = 1;
            } else if (expEntity.isContrast()) {
                j3 = 2;
            } else {
                j3 = 0;
            }
            hotFeature.setNum1(j3).setValue1(this.testName).report(false);
        }
        trimIndent = StringsKt__IndentKt.trimIndent("\n            testName " + this.testName + " grayId: " + expEntity.getGrayId() + " isExperiment: " + expEntity.isExperiment() + " isContrast: " + expEntity.isContrast() + " assignment: " + expEntity.getAssignment() + "    \n            ");
        QLog.i("VasABTestProxy", 1, trimIndent);
        if (QLog.isDebugVersion() && (tabParams = expEntity.getTabParams()) != null) {
            for (Map.Entry<String, String> entry : tabParams.entrySet()) {
                QLog.i("VasABTestProxy", 1, "key: " + ((Object) entry.getKey()) + " value: " + ((Object) entry.getValue()));
            }
        }
        if (expEntity.isContrast()) {
            aBTest = ABTest.A;
        } else if (expEntity.isExperiment()) {
            aBTest = ABTest.B;
        } else {
            aBTest = ABTest.MISS;
        }
        return new Pair<>(aBTest, expEntity.getTabParams());
    }
}
