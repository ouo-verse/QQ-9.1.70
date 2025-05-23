package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class k extends a<stSimpleMetaFeed> implements View.OnClickListener, g {

    /* renamed from: h, reason: collision with root package name */
    private final h f81459h;

    @Override // com.tencent.biz.pubaccount.weishi.recommend.holder.g
    public com.tencent.biz.pubaccount.weishi.t a() {
        return this.f81437f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bb.E()) {
            return;
        }
        int adapterPosition = getAdapterPosition() - ((RecyclerViewHeaderViewAdapter) this.f81437f.f81591d.getAdapter()).getHeaderCount();
        com.tencent.biz.pubaccount.weishi.util.x.b("WSGridCommonHolder", "onClick: " + adapterPosition);
        if (adapterPosition < this.f81437f.getCustomItemCount() && adapterPosition >= 0) {
            stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) this.f81436e;
            if (stsimplemetafeed == null) {
                com.tencent.biz.pubaccount.weishi.util.x.f("WSGridCommonHolder", "feed is null");
                return;
            }
            WSReportDc00898.o(112, WSReportDc00898.h(adapterPosition, stsimplemetafeed));
            WeishiLinkUtil.p();
            Context context = getContext();
            int i3 = stsimplemetafeed.video_type;
            if (i3 == 1) {
                this.f81459h.g(context, stsimplemetafeed, adapterPosition);
                return;
            }
            if (i3 == 6) {
                this.f81459h.k(context, adapterPosition, stsimplemetafeed);
                return;
            } else {
                if (this.f81459h.f(context, adapterPosition, stsimplemetafeed, this.itemView)) {
                    return;
                }
                this.f81459h.l(context, adapterPosition, stsimplemetafeed, true, false, this.itemView);
                com.tencent.biz.pubaccount.weishi.recommend.a.c("gzh_click", stsimplemetafeed, com.tencent.biz.pubaccount.weishi.report.a.b(stsimplemetafeed, adapterPosition), 1000001, this.f81437f.F);
                return;
            }
        }
        com.tencent.biz.pubaccount.weishi.util.x.f("WSGridCommonHolder", "position out of bound");
    }

    public k(ViewGroup viewGroup, int i3, com.tencent.biz.pubaccount.weishi.t tVar) {
        super(viewGroup, R.layout.fxi, i3, tVar);
        this.f81459h = new h(this);
        this.itemView.setOnClickListener(this);
    }
}
