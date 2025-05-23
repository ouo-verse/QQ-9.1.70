package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR/\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/o;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "adapterPos", "", "E", "Lkotlin/jvm/functions/Function1;", "onItemClicked", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public o(@NotNull View view, @NotNull Function1<? super Integer, Unit> onItemClicked) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o.m(o.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onItemClicked.invoke(Integer.valueOf(this$0.getAdapterPosition()));
        EventCollector.getInstance().onViewClicked(view);
    }
}
