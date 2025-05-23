package com.tencent.mobileqq.guild.aisearch;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.history.AIChatHistoryGroupItem;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/AIHistoryListEmptyPart;", "Lcom/tencent/mobileqq/guild/aisearch/x;", "", "F9", "D9", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "historyEmptyView", "Lcom/tencent/mobileqq/guild/aisearch/w;", "e", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/guild/aisearch/w;", "historyViewModel", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AIHistoryListEmptyPart extends x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildQUIEmptyState historyEmptyView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy historyViewModel;

    public AIHistoryListEmptyPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<w>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListEmptyPart$historyViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final w invoke() {
                return (w) AIHistoryListEmptyPart.this.getViewModel(w.class);
            }
        });
        this.historyViewModel = lazy;
    }

    private final GuildQUIEmptyState B9() {
        GuildQUIEmptyState.a s16 = new GuildQUIEmptyState.a(getContext()).s(9);
        String string = getContext().getString(R.string.f138950_y);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026d_ai_history_empty_title)");
        GuildQUIEmptyState a16 = s16.q(string).n(true).o(0).a();
        ImageView imageView = (ImageView) a16.findViewById(R.id.uuj);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        imageView.getLayoutParams().height = com.tencent.guild.aio.util.c.b(120);
        imageView.getLayoutParams().width = com.tencent.guild.aio.util.c.b(120);
        imageView.setLayoutParams((LinearLayout.LayoutParams) layoutParams);
        a16.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        return a16;
    }

    private final w C9() {
        Object value = this.historyViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-historyViewModel>(...)");
        return (w) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9() {
        RecyclerView recyclerView;
        if (this.historyEmptyView == null) {
            return;
        }
        ViewGroup viewGroup = null;
        Object broadcastGetMessage = broadcastGetMessage("broadcast_get_recyclerview_container", null);
        if (broadcastGetMessage instanceof RecyclerView) {
            recyclerView = (RecyclerView) broadcastGetMessage;
        } else {
            recyclerView = null;
        }
        if (recyclerView == null) {
            return;
        }
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            recyclerView.setVisibility(0);
            viewGroup.removeView(this.historyEmptyView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        RecyclerView recyclerView;
        if (this.historyEmptyView == null) {
            this.historyEmptyView = B9();
        }
        ViewGroup viewGroup = null;
        Object broadcastGetMessage = broadcastGetMessage("broadcast_get_recyclerview_container", null);
        if (broadcastGetMessage instanceof RecyclerView) {
            recyclerView = (RecyclerView) broadcastGetMessage;
        } else {
            recyclerView = null;
        }
        if (recyclerView == null) {
            return;
        }
        ViewParent parent = recyclerView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            recyclerView.setVisibility(8);
            viewGroup.removeView(this.historyEmptyView);
            viewGroup.addView(this.historyEmptyView);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ko4.a<ArrayList<AIChatHistoryGroupItem>> d26 = C9().d2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<ArrayList<AIChatHistoryGroupItem>, Unit> function1 = new Function1<ArrayList<AIChatHistoryGroupItem>, Unit>() { // from class: com.tencent.mobileqq.guild.aisearch.AIHistoryListEmptyPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<AIChatHistoryGroupItem> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<AIChatHistoryGroupItem> arrayList) {
                if (arrayList.isEmpty()) {
                    AIHistoryListEmptyPart.this.F9();
                } else {
                    AIHistoryListEmptyPart.this.D9();
                }
            }
        };
        d26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.aisearch.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIHistoryListEmptyPart.E9(Function1.this, obj);
            }
        });
    }
}
