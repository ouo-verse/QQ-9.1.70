package com.tencent.now.linkpkanchorplay.recommendlist.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.linkpkanchorplay.recommendlist.widget.RecommendAnchorItemView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import vl3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends b<e55.a> {
    private int I;
    private int J;
    private List<e55.a> K;
    private RecyclerView L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.now.linkpkanchorplay.recommendlist.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9246a implements RecommendAnchorItemView.b {
        C9246a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.recommendlist.widget.RecommendAnchorItemView.b
        public void a(e55.a aVar) {
            EventCenter.post(new ym3.a(a.this.J, aVar, a.this.I));
        }
    }

    public a(Context context) {
        super(context, R.layout.fez, new ArrayList());
        this.J = 3;
        this.K = new ArrayList();
    }

    private boolean v0(e55.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0) {
            return false;
        }
        int size = this.K.size();
        int length = aVarArr.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                break;
            }
            e55.a aVar = aVarArr[i3];
            Iterator<e55.a> it = this.K.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (aVar.f395729a.f395735a == it.next().f395729a.f395735a) {
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.K.add(aVar);
            }
            i3++;
        }
        if (size == this.K.size()) {
            return false;
        }
        return true;
    }

    private void w0() {
        RecyclerView recyclerView = this.L;
        if (recyclerView != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void clearData() {
        this.K.clear();
        k0();
        w0();
    }

    @Override // vl3.b, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return super.getNUM_BACKGOURND_ICON();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.L = recyclerView;
    }

    @Override // vl3.b, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.L = null;
    }

    @Override // vl3.b
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(wl3.a aVar, e55.a aVar2) {
        RecommendAnchorItemView recommendAnchorItemView = (RecommendAnchorItemView) aVar.getView(R.id.f71333nv);
        recommendAnchorItemView.setOnInviteClickListener(new C9246a());
        recommendAnchorItemView.setData(aVar2);
        recommendAnchorItemView.c(this.I, aVar.getAdapterPosition());
        recommendAnchorItemView.d(this.J, aVar.getAdapterPosition());
    }

    public void u0(e55.a[] aVarArr) {
        this.K.clear();
        this.K.addAll(Arrays.asList(aVarArr));
        super.setData(this.K);
        w0();
    }

    public void x0(e55.a[] aVarArr) {
        if (v0(aVarArr)) {
            super.setData(this.K);
            w0();
        }
    }

    public void y0(int i3) {
        this.J = i3;
    }

    public void z0(int i3) {
        this.I = i3;
    }
}
