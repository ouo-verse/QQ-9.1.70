package com.qzone.reborn.qzmoment.itemview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import java.util.List;
import ln.j;
import ln.l;
import qzonemoment.QZMomentMeta$StComment;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends com.qzone.reborn.base.f<QZMomentMeta$StComment> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(QZMomentMeta$StComment qZMomentMeta$StComment, List<QZMomentMeta$StComment> list, int i3) {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.f1280027;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<QZMomentMeta$StComment>>> list) {
        super.initSection(viewGroup, view, list);
        list.add(ln.h.class);
        list.add(ln.g.class);
        list.add(l.class);
        list.add(j.class);
        list.add(ln.d.class);
    }
}
