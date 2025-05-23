package ln;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class p extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // ln.b, com.tencent.biz.richframework.part.adapter.section.Section
    protected void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: ln.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                p.this.y(view2);
            }
        });
        u(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mla};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.qzmoment.comment.f fVar, int i3, List<Object> list) {
        if (fVar == null) {
            return;
        }
        this.f415014f = fVar.f58884b;
        this.f415015h = fVar.f58885c;
    }
}
