package com.tencent.robot.aio.panel.menu;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotMenuPanelVM$createTimeoutJob$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ RobotMenuPanelVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMenuPanelVM$createTimeoutJob$2$1(RobotMenuPanelVM robotMenuPanelVM) {
        super(1);
        this.this$0 = robotMenuPanelVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotMenuPanelVM this$0) {
        c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cVar = this$0.mRobotAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotAdapter");
            cVar = null;
        }
        cVar.s0(-1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
        invoke2(th5);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th5) {
        if (th5 != null && !(th5 instanceof CancellationException)) {
            QLog.e("RobotMenuPanelVM", 1, "timeoutJob exception happens: " + th5);
        }
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final RobotMenuPanelVM robotMenuPanelVM = this.this$0;
        rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.robot.aio.panel.menu.g
            @Override // java.lang.Runnable
            public final void run() {
                RobotMenuPanelVM$createTimeoutJob$2$1.b(RobotMenuPanelVM.this);
            }
        });
    }
}
