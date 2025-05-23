package com.tencent.state.common.tag;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.common.tag.TagAdapter;
import com.tencent.state.square.databinding.VasSquareLibraryTagItemBinding;
import com.tencent.state.utils.DrawableUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00192\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/common/tag/TagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/common/tag/TagAdapter$ViewHolder;", "()V", "dataList", "", "Lcom/tencent/state/common/tag/TagItemData;", "tagClickListener", "Lcom/tencent/state/common/tag/OnTagClickListener;", "clearTagClickListener", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setData", "list", "", "setTagClickListener", "listener", "Companion", "ViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class TagAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "LibraryTagAdapter";
    private final List<TagItemData> dataList = new ArrayList();
    private OnTagClickListener tagClickListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/common/tag/TagAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryTagItemBinding;", "(Lcom/tencent/state/common/tag/TagAdapter;Lcom/tencent/state/square/databinding/VasSquareLibraryTagItemBinding;)V", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareLibraryTagItemBinding;", "doBindView", "", "data", "Lcom/tencent/state/common/tag/TagItemData;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final VasSquareLibraryTagItemBinding binding;
        final /* synthetic */ TagAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TagAdapter tagAdapter, VasSquareLibraryTagItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = tagAdapter;
            this.binding = binding;
        }

        public final void doBindView(TagItemData data) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(data, "data");
            TextView textView = this.binding.tag;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tag");
            textView.setText(data.getText());
            TextView textView2 = this.binding.tag;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tag");
            if (data.getIsCheck()) {
                this.binding.tag.setTextColor(-1);
                drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.gwj);
            } else {
                this.binding.tag.setTextColor(-16777216);
                drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.gwk);
            }
            textView2.setBackground(drawable);
            this.binding.tag.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.tag.TagAdapter$ViewHolder$doBindView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    List list;
                    List list2;
                    OnTagClickListener onTagClickListener;
                    List list3;
                    list = TagAdapter.ViewHolder.this.this$0.dataList;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((TagItemData) it.next()).setCheck(false);
                    }
                    list2 = TagAdapter.ViewHolder.this.this$0.dataList;
                    ((TagItemData) list2.get(TagAdapter.ViewHolder.this.getAdapterPosition())).setCheck(true);
                    onTagClickListener = TagAdapter.ViewHolder.this.this$0.tagClickListener;
                    if (onTagClickListener != null) {
                        list3 = TagAdapter.ViewHolder.this.this$0.dataList;
                        onTagClickListener.onClick(((TagItemData) list3.get(TagAdapter.ViewHolder.this.getAdapterPosition())).getText(), TagAdapter.ViewHolder.this.getAdapterPosition());
                    }
                    TagAdapter.ViewHolder.this.this$0.notifyDataSetChanged();
                }
            });
        }

        public final VasSquareLibraryTagItemBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final void setData(List<TagItemData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    public final void setTagClickListener(OnTagClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.tagClickListener = listener;
    }

    public final void clearTagClickListener() {
        this.tagClickListener = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        TagItemData tagItemData = (TagItemData) orNull;
        if (tagItemData != null) {
            holder.doBindView(tagItemData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareLibraryTagItemBinding inflate = VasSquareLibraryTagItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryTagItemB\u2026ter.from(parent.context))");
        return new ViewHolder(this, inflate);
    }
}
