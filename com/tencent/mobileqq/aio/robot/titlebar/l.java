package com.tencent.mobileqq.aio.robot.titlebar;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.aio.robot.titlebar.RobotTopBarUIState;
import com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J,\u0010\u0017\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0014\u0012\u0006\b\u0001\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001e\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/l;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState;", "", "isSelectModel", "", "b1", "showEar", "d1", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotTopBarUIState$UpdateModelButton;", "state", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/aio/api/runtime/a;", "initializeChildVB", "c1", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "d", "Landroid/view/View;", "mTitleContainer", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleContainerVB;", "e", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleContainerVB;", "defaultTitleContainerVB", "Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB;", "f", "Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB;", "modelButtonVB", "<init>", "()V", tl.h.F, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class l extends com.tencent.aio.base.mvvm.a<Object, RobotTopBarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mTitleContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotAIOTitleContainerVB defaultTitleContainerVB = new RobotAIOTitleContainerVB();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotAIModelButtonVB modelButtonVB;

    private final void b1(boolean isSelectModel) {
        RobotAIModelButtonVB robotAIModelButtonVB = this.modelButtonVB;
        if (robotAIModelButtonVB != null) {
            robotAIModelButtonVB.u1(isSelectModel);
        }
    }

    private final void d1(boolean showEar) {
        RobotAIModelButtonVB robotAIModelButtonVB = this.modelButtonVB;
        if (robotAIModelButtonVB != null) {
            robotAIModelButtonVB.s1(showEar);
        }
    }

    private final void e1(RobotTopBarUIState.UpdateModelButton state) {
        if (state.getModelProfileInfo().getInputBox().modelList.isEmpty()) {
            RobotAIModelButtonVB robotAIModelButtonVB = this.modelButtonVB;
            if (robotAIModelButtonVB != null) {
                removeChildVB(robotAIModelButtonVB);
                if (getMChildren().contains(robotAIModelButtonVB)) {
                    getMChildren().remove(robotAIModelButtonVB);
                }
            }
            this.modelButtonVB = null;
            return;
        }
        if (this.modelButtonVB == null) {
            RobotAIModelButtonVB robotAIModelButtonVB2 = new RobotAIModelButtonVB(new WeakReference(this.defaultTitleContainerVB));
            addChildVB(robotAIModelButtonVB2);
            this.modelButtonVB = robotAIModelButtonVB2;
        }
        QLog.i("RobotTopBarBaseVB", 1, "updateModelButton selectModelId = " + state.getSelectModelId());
        RobotAIModelButtonVB robotAIModelButtonVB3 = this.modelButtonVB;
        if (robotAIModelButtonVB3 != null) {
            robotAIModelButtonVB3.G1(state.getModelProfileInfo(), state.getSelectModelId());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotTopBarUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotTopBarUIState.UpdateModelButton) {
            e1((RobotTopBarUIState.UpdateModelButton) state);
        } else if (state instanceof RobotTopBarUIState.UpdateEarIconEvent) {
            d1(((RobotTopBarUIState.UpdateEarIconEvent) state).getShowEar());
        } else if (state instanceof RobotTopBarUIState.MultiSelectModelEvent) {
            b1(((RobotTopBarUIState.MultiSelectModelEvent) state).getIsSelectModel());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.defaultTitleContainerVB);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, -2);
        a16.gravity = 48;
        frameLayout.setLayoutParams(a16);
        this.mTitleContainer = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        RobotAIModelButtonVB robotAIModelButtonVB = this.modelButtonVB;
        if (robotAIModelButtonVB != null) {
            robotAIModelButtonVB.onReuseView(reuseParam);
            removeChildVB(robotAIModelButtonVB);
            if (getMChildren().contains(robotAIModelButtonVB)) {
                getMChildren().remove(robotAIModelButtonVB);
            }
            this.modelButtonVB = null;
        }
    }
}
