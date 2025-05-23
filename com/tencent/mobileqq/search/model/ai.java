package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import lo2.NetSearchTemplateUsedMiniAppItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ai extends com.tencent.mobileqq.search.business.net.view.f {
    private ImageView X;

    public ai(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.f, com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        View view = this.M;
        if (view != null) {
            this.X = (ImageView) view.findViewById(R.id.x1c);
        }
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    public void p(lo2.p pVar) {
        super.p(pVar);
        if (pVar == null) {
            return;
        }
        if (this.S != null && pVar.Z() != null && !pVar.Z().isEmpty()) {
            RecyclerView recyclerView = this.S;
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(recyclerView.getContext(), 0, false));
            ko2.b bVar = new ko2.b();
            this.V = bVar;
            this.S.setAdapter(bVar);
            this.V.setData(pVar.Z());
        }
        if (pVar instanceof NetSearchTemplateUsedMiniAppItem) {
            NetSearchTemplateUsedMiniAppItem netSearchTemplateUsedMiniAppItem = (NetSearchTemplateUsedMiniAppItem) pVar;
            if (!TextUtils.isEmpty(netSearchTemplateUsedMiniAppItem.b0().miniIconUrl)) {
                this.X.setVisibility(0);
                this.X.setImageDrawable(URLDrawable.getDrawable(netSearchTemplateUsedMiniAppItem.b0().miniIconUrl, (URLDrawable.URLDrawableOptions) null));
            }
        }
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int q(boolean z16) {
        return 26;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int r() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int s() {
        return 76;
    }

    @Override // com.tencent.mobileqq.search.business.net.view.f
    protected int t() {
        return 12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.business.net.view.f
    public void u(lo2.p pVar) {
        super.u(pVar);
        LinearLayout linearLayout = this.Q;
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = ViewUtils.dpToPx(6.0f);
            this.Q.setLayoutParams(layoutParams);
        }
    }
}
