package com.qzone.reborn.qzmoment.itemview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c extends com.qzone.reborn.base.f<bn.g> {

    /* renamed from: f, reason: collision with root package name */
    private int f58899f = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(bn.g gVar, List<bn.g> list, int i3) {
        this.f58899f = list.size();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(bn.g gVar, SectionViewHolder sectionViewHolder, int i3, List<Object> list) {
        super.onBindViewHolder2((c) gVar, sectionViewHolder, i3, list);
        View findViewById = sectionViewHolder.itemView.findViewById(R.id.mkr);
        FrameLayout frameLayout = (FrameLayout) sectionViewHolder.itemView.findViewById(R.id.mkq);
        if (i3 == 0) {
            findViewById.setVisibility(0);
            frameLayout.setBackgroundResource(R.drawable.f13840y);
        } else if (i3 == this.f58899f - 1) {
            findViewById.setVisibility(8);
            frameLayout.setBackgroundResource(R.drawable.f13820w);
        } else {
            findViewById.setVisibility(0);
            frameLayout.setBackgroundResource(R.drawable.f13830x);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f128252v;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<bn.g>>> list) {
        super.initSection(viewGroup, view, list);
        list.add(nn.a.class);
        list.add(nn.h.class);
        list.add(nn.e.class);
        list.add(nn.g.class);
    }
}
