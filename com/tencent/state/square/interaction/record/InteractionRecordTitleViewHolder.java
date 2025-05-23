package com.tencent.state.square.interaction.record;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareItemInteractionRecordTitleBinding;
import com.tencent.state.utils.RegexUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/interaction/record/InteractionRecordTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/interaction/record/IInteractionRecordViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemInteractionRecordTitleBinding;", "bind", "", "data", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class InteractionRecordTitleViewHolder extends RecyclerView.ViewHolder implements IInteractionRecordViewHolder {
    private final VasSquareItemInteractionRecordTitleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionRecordTitleViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquareItemInteractionRecordTitleBinding bind = VasSquareItemInteractionRecordTitleBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareItemInteraction\u2026rdTitleBinding.bind(view)");
        this.binding = bind;
    }

    @Override // com.tencent.state.square.interaction.record.IInteractionRecordViewHolder
    public void bind(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof InteractionRecordTitleData)) {
            data = null;
        }
        InteractionRecordTitleData interactionRecordTitleData = (InteractionRecordTitleData) data;
        if (interactionRecordTitleData != null) {
            TextView textView = this.binding.interactionRecordTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.interactionRecordTitle");
            textView.setText(interactionRecordTitleData.getTitle());
            if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, interactionRecordTitleData.getIcon(), false, 2, null)) {
                this.binding.interactionRecordIcon.setImageDrawable(URLDrawable.getDrawable(interactionRecordTitleData.getIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
            }
        }
    }
}
