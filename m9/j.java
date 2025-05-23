package m9;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.publish.business.task.IQueueTask;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j extends com.qzone.reborn.base.f<IQueueTask> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(IQueueTask iQueueTask, List<IQueueTask> list, int i3) {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.ckf;
    }

    @Override // com.qzone.reborn.base.f, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup viewGroup, View view, List<Class<? extends Section<IQueueTask>>> list) {
        super.initSection(viewGroup, view, list);
        list.add(y9.a.class);
        list.add(y9.b.class);
    }
}
