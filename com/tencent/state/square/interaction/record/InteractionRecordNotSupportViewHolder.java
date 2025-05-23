package com.tencent.state.square.interaction.record;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordNotSupportViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/interaction/record/IInteractionRecordViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "data", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class InteractionRecordNotSupportViewHolder extends RecyclerView.ViewHolder implements IInteractionRecordViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionRecordNotSupportViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.tencent.state.square.interaction.record.IInteractionRecordViewHolder
    public void bind(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }
}
