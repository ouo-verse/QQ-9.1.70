package com.tencent.mobileqq.guild.discoveryv2.tips;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.MVPFeedsUIState;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH&R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/tips/ReservePart;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Landroid/view/View;", "view", "", "onInitView", "Lqh1/e;", "viewState", "B9", "Lqh1/d;", "state", "A9", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "reserveLayout", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class ReservePart extends MVPFeedsPart {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup reserveLayout;

    @Nullable
    public abstract View A9(@NotNull qh1.d state);

    public final void B9(@NotNull MVPFeedsUIState viewState) {
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        View A9 = A9(viewState.f());
        ViewGroup viewGroup = null;
        if (A9 == null) {
            ViewGroup viewGroup2 = this.reserveLayout;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reserveLayout");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup3 = this.reserveLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reserveLayout");
            viewGroup3 = null;
        }
        viewGroup3.setVisibility(0);
        ViewGroup viewGroup4 = this.reserveLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reserveLayout");
            viewGroup4 = null;
        }
        viewGroup4.removeAllViews();
        ViewGroup viewGroup5 = this.reserveLayout;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reserveLayout");
        } else {
            viewGroup = viewGroup5;
        }
        viewGroup.addView(A9);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = getPartRootView().findViewById(R.id.uiy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026scovery_v2_skeleton_root)");
        this.reserveLayout = (ViewGroup) findViewById;
        Object broadcastGetMessage = broadcastGetMessage(Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class));
        Intrinsics.checkNotNull(broadcastGetMessage, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart.getStateFlow>");
        Flow distinctUntilChangedBy = FlowKt.distinctUntilChangedBy((StateFlow) broadcastGetMessage, new Function1<MVPFeedsUIState, qh1.d>() { // from class: com.tencent.mobileqq.guild.discoveryv2.tips.ReservePart$onInitView$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final qh1.d invoke(@NotNull MVPFeedsUIState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.f();
            }
        });
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = a16.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new ReservePart$onInitView$$inlined$collectIn$default$1(lifecycle, state, distinctUntilChangedBy, null, this));
    }
}
