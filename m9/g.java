package m9;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends com.qzone.reborn.base.f<com.qzone.reborn.albumx.common.bean.e> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(com.qzone.reborn.albumx.common.bean.e eVar, List<com.qzone.reborn.albumx.common.bean.e> list, int i3) {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.ckf;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<com.qzone.reborn.albumx.common.bean.e>>> list) {
        super.initSection(viewGroup, view, list);
        l9.e eVar = (l9.e) b(l9.e.class);
        if (eVar != null) {
            list.addAll(eVar.a6());
        }
    }
}
