package com.tencent.robot.discoveryv2.troop.added;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel;
import com.tencent.robot.discoveryv2.troop.added.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/added/TroopRobotAddedViewModel;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "Lcom/tencent/robot/discoveryv2/troop/added/b;", "", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "addedRobotsData", "", "W1", "Q1", "", "getLogTag", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopRobotAddedViewModel extends BaseRobotViewModel<com.tencent.robot.discoveryv2.common.repository.core.d, b, Object> {
    private final void W1(AddedRobotsData addedRobotsData) {
        P1().setValue(new b.RefreshAddedRobotsLayoutUIState(addedRobotsData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object X1(TroopRobotAddedViewModel troopRobotAddedViewModel, AddedRobotsData addedRobotsData, Continuation continuation) {
        troopRobotAddedViewModel.W1(addedRobotsData);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    public void Q1() {
        com.tencent.robot.discoveryv2.troop.repository.a aVar;
        Flow<AddedRobotsData> e16;
        Flow onEach;
        Flow flowOn;
        Object e17 = M1().e();
        if (e17 instanceof com.tencent.robot.discoveryv2.troop.repository.a) {
            aVar = (com.tencent.robot.discoveryv2.troop.repository.a) e17;
        } else {
            aVar = null;
        }
        if (aVar != null && (e16 = aVar.e()) != null && (onEach = FlowKt.onEach(e16, new TroopRobotAddedViewModel$registerNotification$1(this))) != null && (flowOn = FlowKt.flowOn(onEach, Dispatchers.getMain())) != null) {
            FlowKt.launchIn(flowOn, ViewModelKt.getViewModelScope(this));
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "TAG";
    }
}
