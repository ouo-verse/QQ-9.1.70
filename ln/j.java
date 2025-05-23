package ln;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StReply;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j extends a implements SimpleEventReceiver {

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f415028h;

    /* renamed from: i, reason: collision with root package name */
    private RFWConcatAdapter f415029i;

    /* renamed from: m, reason: collision with root package name */
    private cn.c f415030m;

    private void y() {
        cn.c cVar = new cn.c();
        this.f415030m = cVar;
        cVar.setHasStableIds(true);
        this.f415029i = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f415030m});
    }

    private void z(List<com.qzone.reborn.qzmoment.comment.f> list) {
        cn.c cVar = this.f415030m;
        if (cVar == null) {
            return;
        }
        cVar.setItems(list);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ln.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ml9);
        this.f415028h = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(p()));
        y();
        this.f415028h.setAdapter(this.f415029i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZMomentMeta$StComment qZMomentMeta$StComment, int i3, List<Object> list) {
        this.f415010f = qZMomentMeta$StComment;
        B();
        A(qZMomentMeta$StComment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mk7};
    }

    private void A(QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (qZMomentMeta$StComment == null) {
            return;
        }
        List<QZMomentMeta$StReply> list = qZMomentMeta$StComment.vecReply.get();
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                QZMomentMeta$StReply qZMomentMeta$StReply = list.get(i3);
                if (qZMomentMeta$StReply != null) {
                    com.qzone.reborn.qzmoment.comment.f fVar = new com.qzone.reborn.qzmoment.comment.f();
                    fVar.f58883a = qZMomentMeta$StReply.f430366id.get();
                    fVar.f58884b = qZMomentMeta$StReply;
                    fVar.f58885c = qZMomentMeta$StComment;
                    arrayList.add(fVar);
                }
            }
            z(arrayList);
            return;
        }
        z(new ArrayList());
    }

    private void B() {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
