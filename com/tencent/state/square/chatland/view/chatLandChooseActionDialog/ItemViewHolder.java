package com.tencent.state.square.chatland.view.chatLandChooseActionDialog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareChatLandChooseActionItemBinding;
import com.tencent.state.template.data.InteractionMotionAction;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.RegexUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/chatland/view/chatLandChooseActionDialog/ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/chatland/view/chatLandChooseActionDialog/IItemViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandChooseActionItemBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "bind", "", "data", "Lcom/tencent/state/template/data/InteractionMotionAction;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class ItemViewHolder extends RecyclerView.ViewHolder implements IItemViewHolder {
    private final VasSquareChatLandChooseActionItemBinding binding;
    private final FastClickUtils clickUtils;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquareChatLandChooseActionItemBinding bind = VasSquareChatLandChooseActionItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareChatLandChooseA\u2026ionItemBinding.bind(view)");
        this.binding = bind;
        this.clickUtils = new FastClickUtils(800L);
    }

    @Override // com.tencent.state.square.chatland.view.chatLandChooseActionDialog.IItemViewHolder
    public void bind(final InteractionMotionAction data) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = this.binding.actionName;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionName");
        textView.setText(data.getName());
        if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, data.getIcon(), false, 2, null)) {
            this.binding.actionImage.setImageDrawable(URLDrawable.getDrawable(data.getIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
        }
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.chatLandChooseActionDialog.ItemViewHolder$bind$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FastClickUtils fastClickUtils;
                fastClickUtils = ItemViewHolder.this.clickUtils;
                if (fastClickUtils.isFastDoubleClick()) {
                    return;
                }
                data.getAction().invoke(data);
            }
        });
    }
}
