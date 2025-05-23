package com.tencent.robot.discover.part;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class RobotCategoryContentPart$onInitView$1 extends Lambda implements Function1<List<GroupRobot>, Unit> {
    final /* synthetic */ RobotCategoryContentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotCategoryContentPart$onInitView$1(RobotCategoryContentPart robotCategoryContentPart) {
        super(1);
        this.this$0 = robotCategoryContentPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotCategoryContentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9(this$0.D9());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<GroupRobot> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<GroupRobot> it) {
        boolean z16;
        boolean z17;
        ArrayList ea5;
        z16 = this.this$0.isFirstEven;
        QLog.i("RobotCategoryContentPart", 4, "data update isFirstEven=" + z16 + " size=" + it.size());
        z17 = this.this$0.isFirstEven;
        if (z17) {
            this.this$0.isFirstEven = false;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!it.isEmpty()) {
            i34.b mAdapter = this.this$0.getMAdapter();
            if (mAdapter != null) {
                ea5 = this.this$0.ea(it);
                mAdapter.setItems(ea5);
            }
            RecyclerView D9 = this.this$0.D9();
            final RobotCategoryContentPart robotCategoryContentPart = this.this$0;
            D9.post(new Runnable() { // from class: com.tencent.robot.discover.part.j
                @Override // java.lang.Runnable
                public final void run() {
                    RobotCategoryContentPart$onInitView$1.b(RobotCategoryContentPart.this);
                }
            });
        }
    }
}
