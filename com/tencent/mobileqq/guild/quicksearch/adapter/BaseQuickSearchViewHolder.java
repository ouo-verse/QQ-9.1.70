package com.tencent.mobileqq.guild.quicksearch.adapter;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/adapter/BaseQuickSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/LifecycleRegistry;", "E", "Lkotlin/Lazy;", "l", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class BaseQuickSearchViewHolder extends RecyclerView.ViewHolder implements LifecycleOwner {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy lifecycleRegistry;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/adapter/BaseQuickSearchViewHolder$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "p0", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f231562e;

        a(View view) {
            this.f231562e = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View p06) {
            BaseQuickSearchViewHolder.this.m();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View p06) {
            this.f231562e.removeOnAttachStateChangeListener(this);
            BaseQuickSearchViewHolder.this.onDestroy();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseQuickSearchViewHolder(@NotNull View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LifecycleRegistry>() { // from class: com.tencent.mobileqq.guild.quicksearch.adapter.BaseQuickSearchViewHolder$lifecycleRegistry$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LifecycleRegistry invoke() {
                return new LifecycleRegistry(BaseQuickSearchViewHolder.this);
            }
        });
        this.lifecycleRegistry = lazy;
        itemView.addOnAttachStateChangeListener(new a(itemView));
    }

    private final LifecycleRegistry l() {
        return (LifecycleRegistry) this.lifecycleRegistry.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        l().setCurrentState(Lifecycle.State.CREATED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        l().setCurrentState(Lifecycle.State.DESTROYED);
    }
}
