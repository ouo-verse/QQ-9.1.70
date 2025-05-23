package com.tencent.robot.qrcode.api.impl;

import android.content.Context;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.data.RobotShareState;
import com.tencent.robot.qrcode.QRDisplayRobotCardFragment;
import com.tencent.robot.qrcode.api.IRobotQRCodeApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v44.c;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/qrcode/api/impl/RobotQRCodeApiImpl;", "Lcom/tencent/robot/qrcode/api/IRobotQRCodeApi;", "()V", "openRobotQRCodeCard", "", "context", "Landroid/content/Context;", "qrCodeInfo", "Lcom/tencent/robot/data/RobotInfo;", "from", "", "queryRobotShareState", "callback", "Lkotlin/Function1;", "Lcom/tencent/robot/data/RobotShareState;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotQRCodeApiImpl implements IRobotQRCodeApi {
    @Override // com.tencent.robot.qrcode.api.IRobotQRCodeApi
    public void openRobotQRCodeCard(@NotNull Context context, @NotNull RobotInfo qrCodeInfo, int from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(qrCodeInfo, "qrCodeInfo");
        QRDisplayRobotCardFragment.INSTANCE.a(context, qrCodeInfo, from);
    }

    @Override // com.tencent.robot.qrcode.api.IRobotQRCodeApi
    public void queryRobotShareState(@Nullable final Function1<? super RobotShareState, Unit> callback) {
        c.f440966a.c(new Function1<RobotShareState, Unit>() { // from class: com.tencent.robot.qrcode.api.impl.RobotQRCodeApiImpl$queryRobotShareState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotShareState robotShareState) {
                invoke2(robotShareState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RobotShareState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<RobotShareState, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(it);
                }
            }
        });
    }
}
