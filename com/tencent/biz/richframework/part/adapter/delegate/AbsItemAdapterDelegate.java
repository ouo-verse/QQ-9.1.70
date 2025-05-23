package com.tencent.biz.richframework.part.adapter.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewHelper;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AbsItemAdapterDelegate<I extends T, T> extends AbsListItemAdapterDelegate<I, T, SectionViewHolder> {
    public abstract int getLayoutId();

    public abstract void initSection(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull List<Class<? extends Section<I>>> list);

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    protected abstract boolean isForViewType(@NonNull T t16, @NonNull List<T> list, int i3);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    protected /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull Object obj, @NonNull SectionViewHolder sectionViewHolder, int i3, @NonNull List list) {
        onBindViewHolder((AbsItemAdapterDelegate<I, T>) obj, sectionViewHolder, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (viewHolder instanceof SectionViewHolder) {
            ((SectionViewHolder) viewHolder).onViewRecycled();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    public void onBindViewHolder(@NonNull I i3, @NonNull SectionViewHolder sectionViewHolder, int i16, @NonNull List<Object> list) {
        RecyclerViewHelper.INSTANCE.bindViewHolderToItemView(sectionViewHolder.itemView, sectionViewHolder);
        sectionViewHolder.bindData(i3, i16, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    public SectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(), viewGroup, false);
        initSection(viewGroup, inflate, arrayList);
        return new SectionViewHolder(inflate, arrayList);
    }
}
