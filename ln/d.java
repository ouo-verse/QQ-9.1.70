package ln;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ln.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: ln.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.y(view2);
            }
        });
        u(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZMomentMeta$StComment qZMomentMeta$StComment, int i3, List<Object> list) {
        this.f415010f = qZMomentMeta$StComment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162776mk4};
    }
}
