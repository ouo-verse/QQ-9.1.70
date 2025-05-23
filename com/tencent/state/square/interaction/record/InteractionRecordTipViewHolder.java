package com.tencent.state.square.interaction.record;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordTipViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/interaction/record/IInteractionRecordViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "tipTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "bind", "", "data", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class InteractionRecordTipViewHolder extends RecyclerView.ViewHolder implements IInteractionRecordViewHolder {
    private final TextView tipTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionRecordTipViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.tipTextView = (TextView) view.findViewById(R.id.q2b);
    }

    @Override // com.tencent.state.square.interaction.record.IInteractionRecordViewHolder
    public void bind(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof InteractionRecordTipData)) {
            data = null;
        }
        InteractionRecordTipData interactionRecordTipData = (InteractionRecordTipData) data;
        if (interactionRecordTipData != null) {
            TextView tipTextView = this.tipTextView;
            Intrinsics.checkNotNullExpressionValue(tipTextView, "tipTextView");
            tipTextView.setText(interactionRecordTipData.getTip());
        }
    }
}
