package com.tencent.biz.richframework.part.adapter.section;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.VisibleAware;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SectionViewHolder<T> extends RecyclerView.ViewHolder implements VisibleAware {
    private final SectionManager<T> mSectionManager;

    public SectionViewHolder(@NonNull View view, List<Class<? extends Section<T>>> list) {
        super(view);
        SectionManager<T> sectionManager = new SectionManager<>();
        this.mSectionManager = sectionManager;
        sectionManager.registerSections(list);
        sectionManager.initView(view);
    }

    public void bindData(T t16, int i3, List<Object> list) {
        this.mSectionManager.bindData(t16, i3, list);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean z16) {
        this.mSectionManager.onAttachedChanged(z16);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        this.mSectionManager.onDestroy();
    }

    public void onViewRecycled() {
        this.mSectionManager.onViewRecycled();
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean z16) {
        this.mSectionManager.onVisibleChanged(z16);
    }
}
