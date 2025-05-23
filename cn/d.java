package cn;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.base.h;
import com.qzone.reborn.base.p;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends h<bn.b> {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends DiffUtil.ItemCallback<bn.b> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(bn.b bVar, bn.b bVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(bn.b bVar, bn.b bVar2) {
            return Objects.equals(bVar.a().f430362id.get(), bVar2.a().f430362id.get());
        }
    }

    public d() {
        super(new a(), new AdapterDelegatesManager(new in.b()));
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (getItems().size() > i3) {
            return getItems().get(i3).a().f430362id.get().hashCode();
        }
        return super.getItemId(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.h
    public void k0(List<p> list) {
        super.k0(list);
        list.add(new qn.a());
    }
}
