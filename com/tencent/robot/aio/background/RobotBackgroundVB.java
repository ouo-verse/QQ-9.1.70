package com.tencent.robot.aio.background;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.robot.aio.background.RobotBackgroundMviIntent;
import com.tencent.robot.aio.background.RobotBackgroundUIState;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0016R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/aio/background/RobotBackgroundVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/robot/aio/background/RobotBackgroundMviIntent;", "Lcom/tencent/robot/aio/background/RobotBackgroundUIState;", "Lcom/tencent/robot/aio/background/f;", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "d1", "Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "d", "Lkotlin/Lazy;", "c1", "()Lcom/tencent/robot/aio/background/RobotAIOBackgroundContainer;", "bgViewContainer", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotBackgroundVB extends com.tencent.aio.base.mvvm.a<RobotBackgroundMviIntent, RobotBackgroundUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bgViewContainer;

    public RobotBackgroundVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotAIOBackgroundContainer>() { // from class: com.tencent.robot.aio.background.RobotBackgroundVB$bgViewContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotAIOBackgroundContainer invoke() {
                RobotAIOBackgroundContainer robotAIOBackgroundContainer = new RobotAIOBackgroundContainer(RobotBackgroundVB.this.getMContext(), null, 2, null);
                robotAIOBackgroundContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                robotAIOBackgroundContainer.setId(R.id.f767442h);
                return robotAIOBackgroundContainer;
            }
        });
        this.bgViewContainer = lazy;
    }

    private final RobotAIOBackgroundContainer c1() {
        return (RobotAIOBackgroundContainer) this.bgViewContainer.getValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public f createVM() {
        return new f();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        sendIntent(new RobotBackgroundMviIntent.InitBackground(c1()));
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotBackgroundUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotBackgroundUIState.EnterAIOAnimationEnd) {
            c1().u();
        } else if (state instanceof RobotBackgroundUIState.OnBackgroundInfoUpdate) {
            RobotBackgroundUIState.OnBackgroundInfoUpdate onBackgroundInfoUpdate = (RobotBackgroundUIState.OnBackgroundInfoUpdate) state;
            RobotAIOBackgroundContainer.s(c1(), onBackgroundInfoUpdate.getRobotProfile(), onBackgroundInfoUpdate.getIsStoryAIO(), false, 4, null);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return c1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
    }
}
