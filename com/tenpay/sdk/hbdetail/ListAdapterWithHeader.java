package com.tenpay.sdk.hbdetail;

import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tenpay.sdk.hbdetail.ListAdapterWithHeader;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u0019B'\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u0011\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/sdk/hbdetail/ListAdapterWithHeader;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "headerOffset", "", "footerOffset", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;II)V", "helper", "Landroidx/recyclerview/widget/AsyncListDiffer;", "getHelper", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "helper$delegate", "Lkotlin/Lazy;", "getItem", "position", "(I)Ljava/lang/Object;", "getItemCount", "submitList", "", "list", "", "OffsetListUpdateCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class ListAdapterWithHeader<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    @NotNull
    private final DiffUtil.ItemCallback<T> diffCallback;
    private final int footerOffset;
    private final int headerOffset;

    /* renamed from: helper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy helper;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/hbdetail/ListAdapterWithHeader$OffsetListUpdateCallback;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "headerOffset", "", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;I)V", "getOffsetPosition", "originalPosition", "onChanged", "", "position", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class OffsetListUpdateCallback<VH extends RecyclerView.ViewHolder> implements ListUpdateCallback {

        @NotNull
        private final RecyclerView.Adapter<VH> adapter;
        private final int headerOffset;

        public OffsetListUpdateCallback(@NotNull RecyclerView.Adapter<VH> adapter, int i3) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
            this.headerOffset = i3;
        }

        private final int getOffsetPosition(int originalPosition) {
            return originalPosition + this.headerOffset;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, @Nullable Object payload) {
            this.adapter.notifyItemRangeChanged(getOffsetPosition(position), count, payload);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            this.adapter.notifyItemRangeInserted(getOffsetPosition(position), count);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            this.adapter.notifyItemMoved(getOffsetPosition(fromPosition), getOffsetPosition(toPosition));
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            this.adapter.notifyItemRangeRemoved(getOffsetPosition(position), count);
        }
    }

    public /* synthetic */ ListAdapterWithHeader(DiffUtil.ItemCallback itemCallback, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCallback, (i17 & 2) != 0 ? 1 : i3, (i17 & 4) != 0 ? 1 : i16);
    }

    private final AsyncListDiffer<T> getHelper() {
        return (AsyncListDiffer) this.helper.getValue();
    }

    @Nullable
    public final T getItem(int position) {
        Object orNull;
        List<T> currentList = getHelper().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "helper.currentList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(currentList, position - this.headerOffset);
        return (T) orNull;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getHelper().getCurrentList().size() + this.headerOffset + this.footerOffset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void submitList(@Nullable List<? extends T> list) {
        getHelper().submitList(list);
    }

    public ListAdapterWithHeader(@NotNull DiffUtil.ItemCallback<T> diffCallback, int i3, int i16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        this.diffCallback = diffCallback;
        this.headerOffset = i3;
        this.footerOffset = i16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AsyncListDiffer<T>>(this) { // from class: com.tenpay.sdk.hbdetail.ListAdapterWithHeader$helper$2
            final /* synthetic */ ListAdapterWithHeader<T, VH> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AsyncListDiffer<T> invoke() {
                int i17;
                DiffUtil.ItemCallback itemCallback;
                ListAdapterWithHeader<T, VH> listAdapterWithHeader = this.this$0;
                i17 = ((ListAdapterWithHeader) listAdapterWithHeader).headerOffset;
                ListAdapterWithHeader.OffsetListUpdateCallback offsetListUpdateCallback = new ListAdapterWithHeader.OffsetListUpdateCallback(listAdapterWithHeader, i17);
                itemCallback = ((ListAdapterWithHeader) this.this$0).diffCallback;
                return new AsyncListDiffer<>(offsetListUpdateCallback, new AsyncDifferConfig.Builder(itemCallback).build());
            }
        });
        this.helper = lazy;
    }
}
