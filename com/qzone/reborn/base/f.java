package com.qzone.reborn.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class f<T> extends AbsItemAdapterDelegate<T, T> {

    /* renamed from: d, reason: collision with root package name */
    private View f53565d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f53566e;

    /* JADX INFO: Access modifiers changed from: protected */
    public <E> E b(Class<E> cls) {
        return (E) RFWIocAbilityProvider.g().getIocInterface(cls, this.f53565d, this.f53566e);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<T>>> list) {
        this.f53565d = view;
        this.f53566e = viewGroup;
        RFWIocAbilityProvider.g().setLogicParentView(this.f53565d, this.f53566e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, SectionViewHolder sectionViewHolder, int i3, List list) {
        onBindViewHolder2((f<T>) obj, sectionViewHolder, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(T t16, SectionViewHolder sectionViewHolder, int i3, List<Object> list) {
        try {
            super.onBindViewHolder((f<T>) t16, sectionViewHolder, i3, list);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }
}
