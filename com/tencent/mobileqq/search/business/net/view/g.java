package com.tencent.mobileqq.search.business.net.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends f {
    public g(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    public void p(lo2.p pVar) {
        super.p(pVar);
        if (pVar != null && this.S != null && pVar.Y() != null && !pVar.Y().isEmpty()) {
            RecyclerView recyclerView = this.S;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
            ko2.a aVar = new ko2.a();
            this.U = aVar;
            this.S.setAdapter(aVar);
            this.U.setData(pVar.Y());
        }
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int q(boolean z16) {
        if (z16) {
            return 26;
        }
        return 20;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int r() {
        return 64;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int s() {
        return 84;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int t() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.f
    public void u(lo2.p pVar) {
        super.u(pVar);
        LinearLayout linearLayout = this.N;
        if (linearLayout != null) {
            linearLayout.setPadding(ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(4.0f));
        }
    }
}
