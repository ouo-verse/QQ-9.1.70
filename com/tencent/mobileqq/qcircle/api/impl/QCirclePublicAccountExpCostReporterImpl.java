package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountExpCostReporter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountExpCostReporterImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountExpCostReporter;", "()V", "startTime", "", "endExposure", "", "startExposure", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountExpCostReporterImpl implements IQCirclePublicAccountExpCostReporter {

    @NotNull
    private static final String TAG = "QCirclePublicAccountExpCostReporterImpl";
    private long startTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endExposure$lambda$1(QCirclePublicAccountExpCostReporterImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.startTime > 0) {
            QLog.i(TAG, 1, "endExposure, cost = " + (System.currentTimeMillis() - this$0.startTime));
            this$0.startTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startExposure$lambda$0(QCirclePublicAccountExpCostReporterImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.startTime <= 0) {
            this$0.startTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountExpCostReporter
    public void endExposure() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePublicAccountExpCostReporterImpl.endExposure$lambda$1(QCirclePublicAccountExpCostReporterImpl.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountExpCostReporter
    public void startExposure() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                QCirclePublicAccountExpCostReporterImpl.startExposure$lambda$0(QCirclePublicAccountExpCostReporterImpl.this);
            }
        });
    }
}
