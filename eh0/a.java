package eh0;

import android.graphics.Canvas;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperAdapter;
import com.tencent.ecommerce.base.ui.recyclerviewhelper.ECItemTouchHelperViewHolder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\tH\u0016J@\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Leh0/a;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "source", "target", "onMove", "direction", "", "onSwiped", "Landroid/graphics/Canvas;", "c", "", "dX", "dY", "actionState", "isCurrentlyActive", "onChildDraw", "onSelectedChanged", "clearView", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECItemTouchHelperAdapter;", "a", "Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECItemTouchHelperAdapter;", "adapter", "<init>", "(Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECItemTouchHelperAdapter;)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ECItemTouchHelperAdapter adapter;

    public a(ECItemTouchHelperAdapter eCItemTouchHelperAdapter) {
        this.adapter = eCItemTouchHelperAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof ECItemTouchHelperViewHolder) {
            ((ECItemTouchHelperViewHolder) viewHolder).onItemClear();
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        if (source.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        this.adapter.onItemMove(source.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        this.adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != 0 && (viewHolder instanceof ECItemTouchHelperViewHolder)) {
            ((ECItemTouchHelperViewHolder) viewHolder).onItemSelected();
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(3, 48);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c16, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(dX) / viewHolder.itemView.getWidth()));
            viewHolder.itemView.setTranslationX(dX);
            return;
        }
        super.onChildDraw(c16, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
