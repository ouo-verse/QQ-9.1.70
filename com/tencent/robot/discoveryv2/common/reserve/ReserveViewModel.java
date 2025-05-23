package com.tencent.robot.discoveryv2.common.reserve;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel;
import com.tencent.robot.discoveryv2.common.data.LoadState;
import com.tencent.robot.discoveryv2.common.repository.core.d;
import com.tencent.robot.discoveryv2.common.reserve.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/reserve/ReserveViewModel;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "Lcom/tencent/robot/discoveryv2/common/reserve/b;", "", "Lcom/tencent/robot/discoveryv2/common/data/LoadState;", "loadState", "", "W1", "", "getLogTag", "Q1", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ReserveViewModel extends BaseRobotViewModel<d, b, Object> {
    private final void W1(LoadState loadState) {
        P1().setValue(new b.UpdateLoadStateUIState(loadState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object X1(ReserveViewModel reserveViewModel, LoadState loadState, Continuation continuation) {
        reserveViewModel.W1(loadState);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    public void Q1() {
        super.Q1();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(M1().b(), new ReserveViewModel$registerNotification$1(this)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "ReserveViewModel";
    }
}
