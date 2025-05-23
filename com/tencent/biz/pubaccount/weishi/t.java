package com.tencent.biz.pubaccount.weishi;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class t extends BaseAdapter<stSimpleMetaFeed, BaseViewHolder<stSimpleMetaFeed>> {
    public final int C;
    public final int D;
    public final int E;
    public final String F;
    public final String G;
    public boolean H;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerViewWithHeaderFooter f81591d;

    /* renamed from: e, reason: collision with root package name */
    private a f81592e;

    /* renamed from: f, reason: collision with root package name */
    public long f81593f;

    /* renamed from: h, reason: collision with root package name */
    public int f81594h;

    /* renamed from: i, reason: collision with root package name */
    public int f81595i;

    /* renamed from: m, reason: collision with root package name */
    public final int f81596m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(BaseViewHolder<stSimpleMetaFeed> baseViewHolder);
    }

    public t(Context context, RecyclerViewWithHeaderFooter recyclerViewWithHeaderFooter, String str, String str2) {
        super(context);
        this.f81593f = 0L;
        this.f81594h = 0;
        this.f81595i = 0;
        this.f81591d = recyclerViewWithHeaderFooter;
        this.F = str;
        this.G = str2;
        this.f81596m = ScreenUtil.getRealWidth(context);
        this.C = ScreenUtil.dip2px(5.0f);
        this.D = ScreenUtil.dip2px(18.0f);
        this.E = ScreenUtil.dip2px(14.0f);
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        stSimpleMetaFeed stsimplemetafeed;
        List<stSimpleMetaFeed> dataList = getDataList();
        if (dataList == null || dataList.size() <= 0 || (stsimplemetafeed = dataList.get(i3)) == null) {
            return 1;
        }
        if (stsimplemetafeed.gdt_ad_type == 2) {
            return 14;
        }
        stWaterFallCardStyle stwaterfallcardstyle = stsimplemetafeed.waterFallCardStyle;
        if (stwaterfallcardstyle != null) {
            return stwaterfallcardstyle.cardType;
        }
        return 1;
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<stSimpleMetaFeed> baseViewHolder, int i3) {
        if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.recommend.holder.a) {
            ((com.tencent.biz.pubaccount.weishi.recommend.holder.a) baseViewHolder).f81435d.setPosition(i3);
        }
        stSimpleMetaFeed item = getItem(i3);
        if (item != null) {
            baseViewHolder.bindData(item);
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<stSimpleMetaFeed> onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        return com.tencent.biz.pubaccount.weishi.recommend.holder.n.a(i3, viewGroup, this);
    }

    public void p(List<stSimpleMetaFeed> list) {
        List<stSimpleMetaFeed> dataList = getDataList();
        if (dataList == null || !dataList.addAll(list)) {
            return;
        }
        notifyItemRangeChanged(dataList.size() - list.size(), list.size());
    }

    public void q() {
        for (stSimpleMetaFeed stsimplemetafeed : new ArrayList(getDataList())) {
            if (stsimplemetafeed.gdt_ad_type == 2) {
                getDataList().remove(stsimplemetafeed);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder<stSimpleMetaFeed> baseViewHolder) {
        a aVar = this.f81592e;
        if (aVar != null) {
            aVar.a(baseViewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseViewHolder<stSimpleMetaFeed> baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
    }

    public void t(boolean z16) {
        this.H = z16;
    }

    public void u(a aVar) {
        this.f81592e = aVar;
    }
}
