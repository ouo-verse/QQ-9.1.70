package com.tencent.robot.aio.bottomcontainer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.aio.base.mvvm.b;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.bottombar.RobotBottomBarVB;
import com.tencent.robot.aio.bottombar.picture.RobotPictureBarVB;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\t\u0012\u0006\b\u0001\u0012\u00020\n0\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR1\u0010#\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/aio/bottomcontainer/RobotAIOBottomContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "d1", "", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mInputContainer", "Lcom/tencent/robot/aio/bottombar/RobotBottomBarVB;", "e", "Lkotlin/Lazy;", "e1", "()Lcom/tencent/robot/aio/bottombar/RobotBottomBarVB;", "mBottomBarVB", "Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVB;", "f", "f1", "()Lcom/tencent/robot/aio/bottombar/picture/RobotPictureBarVB;", "mBottomPictureBarVB", h.F, "g1", "()Ljava/util/List;", "mChildVb", "<init>", "()V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotAIOBottomContainerVB extends com.tencent.aio.base.mvvm.a<Object, Object> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mInputContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBottomBarVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBottomPictureBarVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mChildVb;

    public RobotAIOBottomContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotBottomBarVB>() { // from class: com.tencent.robot.aio.bottomcontainer.RobotAIOBottomContainerVB$mBottomBarVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotBottomBarVB invoke() {
                return new RobotBottomBarVB();
            }
        });
        this.mBottomBarVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RobotPictureBarVB>() { // from class: com.tencent.robot.aio.bottomcontainer.RobotAIOBottomContainerVB$mBottomPictureBarVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotPictureBarVB invoke() {
                return new RobotPictureBarVB();
            }
        });
        this.mBottomPictureBarVB = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends com.tencent.aio.base.mvvm.a<Object, Object>>>() { // from class: com.tencent.robot.aio.bottomcontainer.RobotAIOBottomContainerVB$mChildVb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends com.tencent.aio.base.mvvm.a<Object, Object>> invoke() {
                RobotPictureBarVB f16;
                RobotBottomBarVB e16;
                List<? extends com.tencent.aio.base.mvvm.a<Object, Object>> listOf;
                f16 = RobotAIOBottomContainerVB.this.f1();
                e16 = RobotAIOBottomContainerVB.this.e1();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{f16, e16});
                return listOf;
            }
        });
        this.mChildVb = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RobotBottomBarVB e1() {
        return (RobotBottomBarVB) this.mBottomBarVB.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RobotPictureBarVB f1() {
        return (RobotPictureBarVB) this.mBottomPictureBarVB.getValue();
    }

    private final List<com.tencent.aio.base.mvvm.a<Object, Object>> g1() {
        return (List) this.mChildVb.getValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOBottomContainerVB", 4, "[bindViewAndData]  " + hashCode());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public b<Object, Object> createVM() {
        return new a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> list;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        list = CollectionsKt___CollectionsKt.toList(g1());
        return list;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = new LinearLayout(getMContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mInputContainer = linearLayout;
        return linearLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isDebugVersion()) {
            QLog.d("RobotAIOBottomContainerVB", 4, "[onDestroy] " + hashCode());
        }
    }
}
