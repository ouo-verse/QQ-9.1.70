package com.tencent.state.square.interaction.settingme;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.databinding.VasSquareItemInteractionSettingMeBinding;
import com.tencent.state.square.interaction.InteractionSettingOption;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.RegexUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J@\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/state/square/interaction/settingme/IInteractionSettingMeHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemInteractionSettingMeBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "bind", "", "adapter", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeAdapter;", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "position", "", "event", "Lcom/tencent/state/square/interaction/settingme/ItemUpdateEvent;", "clickHandler", "itemData", "Lcom/tencent/state/square/interaction/settingme/InteractionSettingMeItemData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class InteractionSettingMeItemHolder extends RecyclerView.ViewHolder implements IInteractionSettingMeHolder {
    private final VasSquareItemInteractionSettingMeBinding binding;
    private final FastClickUtils clickUtils;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemUpdateEvent.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ItemUpdateEvent.CLICK_SELECT_ITEM.ordinal()] = 1;
            iArr[ItemUpdateEvent.UN_CLICK_SELECT_ITEM.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionSettingMeItemHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        VasSquareItemInteractionSettingMeBinding bind = VasSquareItemInteractionSettingMeBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "VasSquareItemInteraction\u2026ttingMeBinding.bind(view)");
        this.binding = bind;
        this.clickUtils = new FastClickUtils(800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickHandler(View view, InteractionSettingMeItemData itemData, ArrayList<Object> list, int position, InteractionSettingMeAdapter adapter) {
        if (view.isSelected() || this.clickUtils.isFastDoubleClick()) {
            return;
        }
        itemData.getAction().invoke(new InteractionSettingOption(itemData));
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            boolean z16 = i3 == position;
            if (!(obj instanceof InteractionSettingMeItemData)) {
                obj = null;
            }
            InteractionSettingMeItemData interactionSettingMeItemData = (InteractionSettingMeItemData) obj;
            if (z16) {
                if (interactionSettingMeItemData != null) {
                    interactionSettingMeItemData.setSelect(true);
                }
                adapter.notifyItemChanged(i3, ItemUpdateEvent.CLICK_SELECT_ITEM);
            } else if (interactionSettingMeItemData != null && interactionSettingMeItemData.isSelect()) {
                interactionSettingMeItemData.setSelect(false);
                adapter.notifyItemChanged(i3, ItemUpdateEvent.UN_CLICK_SELECT_ITEM);
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.state.square.interaction.settingme.IInteractionSettingMeHolder
    public void bind(ItemUpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i3 == 1) {
            LinearLayout mRv = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            mRv.setSelected(true);
            this.binding.vasSquareInteractionSettingItemText.setTextColor(-16777216);
            return;
        }
        if (i3 != 2) {
            return;
        }
        LinearLayout mRv2 = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
        mRv2.setSelected(false);
        this.binding.vasSquareInteractionSettingItemText.setTextColor(Color.parseColor("#888888"));
    }

    @Override // com.tencent.state.square.interaction.settingme.IInteractionSettingMeHolder
    public void bind(final InteractionSettingMeAdapter adapter, final ArrayList<Object> list, final int position) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(list, "list");
        final Object obj = list.get(position);
        Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
        final InteractionSettingMeItemData interactionSettingMeItemData = (InteractionSettingMeItemData) (!(obj instanceof InteractionSettingMeItemData) ? null : obj);
        if (interactionSettingMeItemData != null) {
            TextView textView = this.binding.vasSquareInteractionSettingItemText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.vasSquareInteractionSettingItemText");
            InteractionSettingMeItemData interactionSettingMeItemData2 = (InteractionSettingMeItemData) obj;
            textView.setText(interactionSettingMeItemData2.getOptionText());
            if (RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, interactionSettingMeItemData2.getOptionIcon(), false, 2, null)) {
                this.binding.vasSquareInteractionSettingItemImg.setImageDrawable(URLDrawable.getDrawable(interactionSettingMeItemData2.getOptionIcon(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
            }
            LinearLayout mRv = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            mRv.setSelected(interactionSettingMeItemData2.isSelect());
            this.binding.vasSquareInteractionSettingItemText.setTextColor(interactionSettingMeItemData2.isSelect() ? -16777216 : Color.parseColor("#888888"));
            this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.interaction.settingme.InteractionSettingMeItemHolder$bind$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InteractionSettingMeItemHolder interactionSettingMeItemHolder = this;
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    interactionSettingMeItemHolder.clickHandler(view, InteractionSettingMeItemData.this, list, position, adapter);
                }
            });
        }
    }
}
