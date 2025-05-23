package com.qzone.reborn.base;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class h<E> extends AsyncListDifferDelegationAdapter<E> {
    private RecyclerView C;
    private boolean D;

    /* renamed from: m, reason: collision with root package name */
    private q f53567m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(h.this.C);
            }
        }
    }

    public h(DiffUtil.ItemCallback<E> itemCallback, AdapterDelegatesManager<List<E>> adapterDelegatesManager) {
        super(itemCallback, adapterDelegatesManager);
        this.D = false;
    }

    protected boolean j0() {
        return false;
    }

    public void l0() {
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        m0(recyclerView);
    }

    public void onDestroy() {
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerView recyclerView2 = this.C;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f53567m);
        }
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.onDestroy();
        }
    }

    public void onResume() {
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.onResume();
        }
    }

    public void onStop() {
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.onStop();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.h(viewHolder);
        }
        if (!j0() || this.D) {
            return;
        }
        this.D = true;
        RFWIocAbilityProvider.g().getIoc(hb.d.class).originView(viewHolder.itemView).done(new OnPromiseResolved() { // from class: com.qzone.reborn.base.g
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                ((hb.d) obj).S();
            }
        }).run();
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        q qVar = this.f53567m;
        if (qVar != null) {
            qVar.i(viewHolder);
        }
    }

    protected void m0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            QLog.e("QZMBaseListAdapter", 1, "registerScroller  recyclerView == null");
            return;
        }
        this.C = recyclerView;
        recyclerView.addOnScrollListener(new a());
        this.f53567m = new q(this.C.getContext(), this.C, this);
        ArrayList arrayList = new ArrayList();
        k0(arrayList);
        Iterator<p> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f53567m.d(it.next());
        }
        this.C.addOnScrollListener(this.f53567m);
        this.f53567m.g(this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(List<p> list) {
    }
}
