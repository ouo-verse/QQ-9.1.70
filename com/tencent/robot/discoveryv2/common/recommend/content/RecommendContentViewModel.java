package com.tencent.robot.discoveryv2.common.recommend.content;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel;
import com.tencent.robot.discoveryv2.common.recommend.content.c;
import com.tencent.robot.discoveryv2.common.repository.core.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/recommend/content/RecommendContentViewModel;", "Lcom/tencent/robot/discoveryv2/common/core/viewmodel/BaseRobotViewModel;", "Lcom/tencent/robot/discoveryv2/common/repository/core/d;", "Lcom/tencent/robot/discoveryv2/common/recommend/content/c;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "categoryTabList", "", "W1", "", "getLogTag", "Q1", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RecommendContentViewModel extends BaseRobotViewModel<d, c, Object> {
    private final void W1(List<ListNode> categoryTabList) {
        P1().setValue(new c.UpdateCategoryTabUIState(categoryTabList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object X1(RecommendContentViewModel recommendContentViewModel, List list, Continuation continuation) {
        recommendContentViewModel.W1(list);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.robot.discoveryv2.common.core.viewmodel.BaseRobotViewModel
    public void Q1() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(M1().d(), new RecommendContentViewModel$registerNotification$1(this)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "RecommendContentViewModel";
    }
}
