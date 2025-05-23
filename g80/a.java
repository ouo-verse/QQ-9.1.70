package g80;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BlockMerger {

    /* renamed from: m, reason: collision with root package name */
    private final List<InterfaceC10363a> f401530m;

    /* compiled from: P */
    /* renamed from: g80.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC10363a {
        void C(RecyclerView.ViewHolder viewHolder);

        void L(@NonNull RecyclerView recyclerView);

        void a0(RecyclerView.ViewHolder viewHolder);

        void q2(@NonNull RecyclerView recyclerView);
    }

    public a(BlockContainer blockContainer) {
        super(blockContainer);
        this.f401530m = new ArrayList();
    }

    public void i0(InterfaceC10363a interfaceC10363a) {
        if (interfaceC10363a != null && !this.f401530m.contains(interfaceC10363a)) {
            this.f401530m.add(interfaceC10363a);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Iterator<InterfaceC10363a> it = this.f401530m.iterator();
        while (it.hasNext()) {
            it.next().L(recyclerView);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        Iterator<InterfaceC10363a> it = this.f401530m.iterator();
        while (it.hasNext()) {
            it.next().q2(recyclerView);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        Iterator<InterfaceC10363a> it = this.f401530m.iterator();
        while (it.hasNext()) {
            it.next().C(viewHolder);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.BlockMerger, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        Iterator<InterfaceC10363a> it = this.f401530m.iterator();
        while (it.hasNext()) {
            it.next().a0(viewHolder);
        }
    }
}
