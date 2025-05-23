package com.tencent.qqnt.robot.inject;

import android.content.Context;
import com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u000b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/robot/inject/RobotProfileQRProcessor;", "Lcom/tencent/biz/qrcode/processor/BaseQRScanResultProcessor;", "", "type", "", "result", "qBarType", "Lcom/tencent/mobileqq/qrscan/ScannerParams;", "scannerParams", "", "a", "k", "getName", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/qrscan/k;", "callback", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/qrscan/k;)V", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RobotProfileQRProcessor extends BaseQRScanResultProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileQRProcessor(AppRuntime app, k callback) {
        super(app, callback);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int type, String result, String qBarType, ScannerParams scannerParams) {
        if (m(type)) {
            if (!(result == null || result.length() == 0)) {
                return ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).shouldInterceptForRobotProfileNotOpen(result);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "RobotProfileQRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    protected boolean k(String result, String qBarType, ScannerParams scannerParams) {
        if (result == null || scannerParams == null) {
            return false;
        }
        this.f94980b.a(true);
        IRobotProfileCardApi iRobotProfileCardApi = (IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class);
        Context context = this.f94980b.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "onQRHandleResultCallback.context");
        return iRobotProfileCardApi.shouldInterceptForRobotProfile(context, result, new Function0<Unit>() { // from class: com.tencent.qqnt.robot.inject.RobotProfileQRProcessor$doHandleQRResult$handle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                k kVar;
                kVar = ((BaseQRScanResultProcessor) RobotProfileQRProcessor.this).f94980b;
                kVar.finish();
            }
        });
    }
}
