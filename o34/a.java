package o34;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J=\u0010\n\u001a\u00028\u0000\"\u0016\b\u0000\u0010\u0007*\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\"\b\b\u0001\u0010\u0003*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\n\u0010\u000bJE\u0010\u000e\u001a\u00028\u0000\"\u0016\b\u0000\u0010\u0007*\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lo34/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lq34/a;", BdhLogUtil.LogTag.Tag_Req, "x9", "()Lq34/a;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "M", "Ljava/lang/Class;", "viewModelClass", "z9", "(Ljava/lang/Class;)Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "", "keyPrefix", "A9", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class a extends Part {
    private final <R extends q34.a> R x9() {
        Object broadcastGetMessage = broadcastGetMessage("get_robot_repository", null);
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type R of com.tencent.robot.discoveryv2.common.core.part.BaseRobotPart.getRobotRepository");
        return (R) broadcastGetMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <M extends BaseRobotViewModel<R, ?, ?>, R extends q34.a> M A9(@NotNull String keyPrefix, @NotNull Class<M> viewModelClass) {
        Intrinsics.checkNotNullParameter(keyPrefix, "keyPrefix");
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        M viewModel = (M) getViewModel(keyPrefix, viewModelClass);
        viewModel.L1(x9());
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        return viewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <M extends BaseRobotViewModel<R, ?, ?>, R extends q34.a> M z9(@NotNull Class<M> viewModelClass) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        M viewModel = (M) getViewModel(viewModelClass);
        viewModel.L1(x9());
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        return viewModel;
    }
}
