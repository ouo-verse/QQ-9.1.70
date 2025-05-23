package com.qzone.reborn.qzmoment.itemview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import java.util.List;
import ln.p;
import ln.s;
import ln.u;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends com.qzone.reborn.base.f<com.qzone.reborn.qzmoment.comment.f> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(com.qzone.reborn.qzmoment.comment.f fVar, List<com.qzone.reborn.qzmoment.comment.f> list, int i3) {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f128052b;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<com.qzone.reborn.qzmoment.comment.f>>> list) {
        super.initSection(viewGroup, view, list);
        list.add(s.class);
        list.add(u.class);
        list.add(p.class);
    }
}
