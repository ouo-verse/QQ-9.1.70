package com.tencent.robot.slash.dialog.content.root;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVB;
import com.tencent.robot.slash.dialog.content.root.SlashRootUIState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u54.c;
import w64.e;
import x64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J2\u0010\u0014\u001a$\u0012 \u0012\u001e\u0012\u0006\b\u0001\u0012\u00020\u0012\u0012\u0006\b\u0001\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00110\u00102\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR3\u0010!\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/root/SlashRootVB;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVB;", "", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVB;", "Lcom/tencent/robot/slash/dialog/content/root/SlashRootUIState$OnDisplayModeUpdated;", "state", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "f1", "", "e", "I", "mTopPadding", "Lz64/a;", "f", "Lkotlin/Lazy;", "d1", "()Lz64/a;", "mBottomInsetVB", "<init>", "()V", h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SlashRootVB extends SlashDialogVB<Object, SlashRootUIState, e<c>> {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f368493h = new a(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mTopPadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mBottomInsetVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/slash/dialog/content/root/SlashRootVB$a;", "", "", "LITTLE_TONGUE_HEIGHT_DP", "I", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public SlashRootVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<z64.a<b, MviUIState, e<c>>>() { // from class: com.tencent.robot.slash.dialog.content.root.SlashRootVB$mBottomInsetVB$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final z64.a<b, MviUIState, e<c>> invoke() {
                int i3;
                z64.a<b, MviUIState, e<c>> aVar = new z64.a<>();
                i3 = SlashRootVB.this.mTopPadding;
                aVar.d1(i3);
                aVar.c1(R.color.qui_common_bg_middle_light);
                return aVar;
            }
        });
        this.mBottomInsetVB = lazy;
    }

    private final z64.a<b, MviUIState, e<c>> d1() {
        return (z64.a) this.mBottomInsetVB.getValue();
    }

    private final void e1(SlashRootUIState.OnDisplayModeUpdated state) {
        int i3;
        z64.a<b, MviUIState, e<c>> d16 = d1();
        if (state.getNewMode() == 1) {
            i3 = ViewUtils.f352270a.d() >> 1;
        } else {
            i3 = this.mTopPadding;
        }
        d16.d1(i3);
        View safetyGetHostView = d1().safetyGetHostView();
        if (safetyGetHostView != null) {
            ViewGroup.LayoutParams layoutParams = safetyGetHostView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = d1().getLayoutHeight();
                safetyGetHostView.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<Object, SlashRootUIState, e<c>> createVM() {
        return new com.tencent.robot.slash.dialog.content.root.a();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull SlashRootUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof SlashRootUIState.OnDisplayModeUpdated) {
            e1((SlashRootUIState.OnDisplayModeUpdated) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends b, ? extends MviUIState, e<c>>> initializeChildVB(@NotNull View hostView) {
        List<BaseVB<? extends b, ? extends MviUIState, e<c>>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        z64.b bVar = new z64.b();
        bVar.h1(R.color.qui_common_bg_middle_light);
        bVar.i1(ViewUtils.f352270a.b(32));
        bVar.g1(R.color.qui_common_icon_tertiary);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BaseVB[]{bVar, new com.tencent.robot.slash.dialog.content.middle.b(), d1()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        int i3;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        j jVar = (j) getMStrategyService().b(j.class);
        if (jVar != null) {
            i3 = jVar.g();
        } else {
            i3 = 0;
        }
        this.mTopPadding = i3;
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        return linearLayout;
    }
}
