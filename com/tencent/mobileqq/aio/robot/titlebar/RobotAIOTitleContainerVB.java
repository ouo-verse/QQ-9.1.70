package com.tencent.mobileqq.aio.robot.titlebar;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.aio.title.AIODefaultTitleContainerVM;
import com.tencent.mobileqq.aio.title.AIOTitleContainerUIState;
import com.tencent.mobileqq.aio.title.l;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J&\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0012\u0012\u0006\b\u0001\u0012\u00020\u00130\u00010\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00170\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleContainerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/l;", "Lcom/tencent/mobileqq/aio/title/AIOTitleContainerUIState;", "", "visibility", "", "i1", "", ViewStickEventHelper.IS_SHOW, "g1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "d1", "Ljava/lang/Class;", "getObserverStates", "state", "h1", "d", "Landroid/view/View;", "mTitleContainer", "Lcom/tencent/mobileqq/aio/title/j;", "e", "Lkotlin/Lazy;", "f1", "()Lcom/tencent/mobileqq/aio/title/j;", "mMsgShotTitle", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleVB;", "f", "e1", "()Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleVB;", "mAIOTitleVB", tl.h.F, "Z", "mIsLongShotMode", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class RobotAIOTitleContainerVB extends com.tencent.aio.base.mvvm.a<com.tencent.mobileqq.aio.title.l, AIOTitleContainerUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mTitleContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMsgShotTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mAIOTitleVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLongShotMode;

    public RobotAIOTitleContainerVB() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.aio.title.j>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleContainerVB$mMsgShotTitle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.aio.title.j invoke() {
                return new com.tencent.mobileqq.aio.title.j();
            }
        });
        this.mMsgShotTitle = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RobotAIOTitleVB>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleContainerVB$mAIOTitleVB$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotAIOTitleVB invoke() {
                return new RobotAIOTitleVB();
            }
        });
        this.mAIOTitleVB = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(RobotAIOTitleContainerVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int[] iArr = new int[2];
        View view = this$0.mTitleContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            view = null;
        }
        view.getLocationOnScreen(iArr);
        View view3 = this$0.mTitleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
        } else {
            view2 = view3;
        }
        this$0.sendIntent(new l.a(view2.getHeight(), iArr));
    }

    private final RobotAIOTitleVB e1() {
        return (RobotAIOTitleVB) this.mAIOTitleVB.getValue();
    }

    private final com.tencent.mobileqq.aio.title.j f1() {
        return (com.tencent.mobileqq.aio.title.j) this.mMsgShotTitle.getValue();
    }

    private final void g1(boolean isShow) {
        View view = null;
        if (isShow) {
            View view2 = this.mTitleContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = this.mTitleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
        } else {
            view = view3;
        }
        view.setVisibility(8);
    }

    private final void i1(int visibility) {
        if (visibility == 0) {
            if (!this.mIsLongShotMode) {
                addChildVB(f1());
            }
            e1().getHostView().setVisibility(8);
            this.mIsLongShotMode = true;
            return;
        }
        if (this.mIsLongShotMode) {
            removeChildVB(f1());
        }
        e1().getHostView().setVisibility(0);
        this.mIsLongShotMode = false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        View view = this.mTitleContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleContainer");
            view = null;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.aio.robot.titlebar.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotAIOTitleContainerVB.c1(RobotAIOTitleContainerVB.this);
            }
        });
        i1(8);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.mobileqq.aio.title.l, AIOTitleContainerUIState> getViewModel() {
        return new AIODefaultTitleContainerVM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends AIOTitleContainerUIState>> getObserverStates() {
        List<Class<? extends AIOTitleContainerUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(AIOTitleContainerUIState.ShowTitleContainer.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOTitleContainerUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOTitleContainerUIState.ShowTitleContainer) {
            g1(((AIOTitleContainerUIState.ShowTitleContainer) state).a());
        } else if (state instanceof AIOTitleContainerUIState.SetMsgShotTitleVisibility) {
            i1(((AIOTitleContainerUIState.SetMsgShotTitleVisibility) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new com.tencent.mobileqq.aio.reserve1.blur.d(), new com.tencent.mobileqq.aio.reserve1.mask.b(), e1()});
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
}
