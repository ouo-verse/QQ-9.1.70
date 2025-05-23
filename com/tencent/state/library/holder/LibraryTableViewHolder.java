package com.tencent.state.library.holder;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.state.library.data.LibraryTableItem;
import com.tencent.state.library.view.LibraryTableView;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapItemController;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.databinding.VasSquareItemLibraryTableBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u000fH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/library/holder/LibraryTableViewHolder;", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/library/data/LibraryTableItem;", "binding", "Lcom/tencent/state/square/databinding/VasSquareItemLibraryTableBinding;", "(Lcom/tencent/state/square/databinding/VasSquareItemLibraryTableBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareItemLibraryTableBinding;", "bindListeners", "", "doBind", "data", "index", "", "onFirstScreenCompleted", "Lcom/tencent/state/map/MapItem;", "onRecycled", "onScaleToDetail", "", "transform", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryTableViewHolder extends MapViewHolder<LibraryTableItem> {
    private final VasSquareItemLibraryTableBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LibraryTableViewHolder(VasSquareItemLibraryTableBinding binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(binding, "binding");
        RelativeLayout mRv = binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        this.binding = binding;
    }

    private final void bindListeners() {
        this.binding.tableView.setClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.state.library.holder.LibraryTableViewHolder$bindListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
            
                r9 = r8.this$0.getController();
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(View v3, int i3) {
                MapItemController controller;
                IMapViewListener listener;
                Intrinsics.checkNotNullParameter(v3, "v");
                if ((i3 != 0 && i3 != 1) || controller == null || (listener = controller.getListener()) == null) {
                    return;
                }
                LibraryTableViewHolder libraryTableViewHolder = LibraryTableViewHolder.this;
                IMapViewListener.DefaultImpls.onItemClicked$default(listener, libraryTableViewHolder, libraryTableViewHolder.getIndex(), LibraryTableViewHolder.this.getData(), 2, null, 16, null);
            }
        });
    }

    public final VasSquareItemLibraryTableBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onFirstScreenCompleted(MapItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.state.map.MapViewHolder
    public void onRecycled() {
        super.onRecycled();
        this.binding.tableView.getTable().setImageDrawable(null);
        this.binding.tableView.getDecorator().setImageDrawable(null);
    }

    @Override // com.tencent.state.map.MapViewHolder
    public boolean onScaleToDetail() {
        MapItemController controller;
        boolean onScaleToDetail = super.onScaleToDetail();
        if (onScaleToDetail && (controller = getController()) != null) {
            controller.setItemAlpha(0.0f);
        }
        return onScaleToDetail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.state.map.MapViewHolder
    public void doBind(LibraryTableItem data, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        bindListeners();
        this.binding.tableView.bindTableImage(data.getTable().getImage().getUrl(), data.getTable().getImage().getSize());
        LibraryTableView.bindBrandOrExpect$default(this.binding.tableView, data.getTable(), 0.0f, 2, null);
        this.binding.tableView.updateHitAreaLocation(data.getItemViewLocation(), data.getLocation());
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        MapItemController controller = getController();
        itemView.setAlpha(controller != null ? controller.getItemAlpha() : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.state.map.MapViewHolder
    public LibraryTableItem transform(MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof LibraryTableItem)) {
            data = null;
        }
        return (LibraryTableItem) data;
    }
}
