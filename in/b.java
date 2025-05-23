package in;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import fo.c;
import java.util.HashMap;
import java.util.List;
import mn.d;
import mn.g;
import mn.h;
import mn.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {

    /* renamed from: f, reason: collision with root package name */
    private bn.b f408002f;

    private void c(bn.b bVar, SectionViewHolder sectionViewHolder) {
        HashMap hashMap = new HashMap();
        hashMap.put("operated_feed", bVar.a().f430362id.get());
        hashMap.put("author_id", bVar.a().poster.f430367id.get());
        hashMap.put("is_fuzzy_state", Integer.valueOf(!bVar.a().opMask.get().contains(1) ? 1 : 0));
        c.o(sectionViewHolder.itemView, "em_bas_single_feed", new fo.b().l(hashMap).i(bVar.a().f430362id.get()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(bn.b bVar, List<bn.b> list, int i3) {
        this.f408002f = bVar;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(bn.b bVar, SectionViewHolder sectionViewHolder, int i3, List<Object> list) {
        super.onBindViewHolder2((b) bVar, sectionViewHolder, i3, list);
        c(bVar, sectionViewHolder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f128122i;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<bn.b>>> list) {
        super.initSection(viewGroup, view, list);
        list.add(g.class);
        list.add(d.class);
        list.add(i.class);
        list.add(h.class);
        list.add(mn.c.class);
        list.add(mn.b.class);
    }
}
