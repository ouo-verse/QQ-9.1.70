package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StYouZanGood;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.d;
import com.tencent.biz.subscribe.part.block.base.a;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommodityListView extends BaseWidgetView<ArrayList> {
    private RecyclerView E;
    private LinearLayoutManager F;
    private c G;
    private TextView H;
    private CertifiedAccountMeta$StFeed I;
    private b J;
    private TextView K;
    private View L;
    private boolean M;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StUser f96478d;

        a(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
            this.f96478d = certifiedAccountMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VSReporter.n(this.f96478d.f24929id.get(), "auth_" + SubscribeShareHelper.s(CommodityListView.this.g()), "clk_shop", 0, 0, new String[0]);
            d.l(this.f96478d.youZhan.get(0).schema.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends com.tencent.biz.subscribe.part.block.base.a {

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f96481d;

            a(int i3) {
                this.f96481d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (this.f96481d < ((com.tencent.biz.subscribe.part.block.base.a) b.this).f96195d.size()) {
                    ((com.tencent.biz.subscribe.part.block.base.a) b.this).f96195d.remove(this.f96481d);
                    CommodityListView.this.f().remove(this.f96481d);
                    b.this.notifyDataSetChanged();
                    if (CommodityListView.this.G != null) {
                        CommodityListView.this.G.a(((com.tencent.biz.subscribe.part.block.base.a) b.this).f96195d.size());
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b() {
        }

        @Override // com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f96195d.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            if (!ArrayUtils.isOutOfArrayIndex(i3, this.f96195d)) {
                ((CommodityItemView) viewHolder.itemView).setData(this.f96195d.get(i3));
                ((CommodityItemView) viewHolder.itemView).v().setOnClickListener(new a(i3));
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public a.C0969a onCreateViewHolder(ViewGroup viewGroup, int i3) {
            CommodityItemView commodityItemView = new CommodityItemView(CommodityListView.this.getContext());
            commodityItemView.setIsPublishUI(CommodityListView.this.M);
            commodityItemView.setCurrentFeed(CommodityListView.this.I);
            return new a.C0969a(commodityItemView);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(int i3);
    }

    public CommodityListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c6q;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (RecyclerView) view.findViewById(R.id.m7c);
        this.K = (TextView) view.findViewById(R.id.kbs);
        this.H = (TextView) view.findViewById(R.id.mdr);
        this.L = view.findViewById(R.id.kmm);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.F = linearLayoutManager;
        this.E.setLayoutManager(linearLayoutManager);
        b bVar = new b();
        this.J = bVar;
        this.E.setAdapter(bVar);
    }

    public void setOnDataChangeListener(c cVar) {
        this.G = cVar;
    }

    public void setOrientation(int i3) {
        LinearLayoutManager linearLayoutManager = this.F;
        if (linearLayoutManager != null) {
            linearLayoutManager.setOrientation(i3);
        }
    }

    public void setPublishUI(boolean z16) {
        int i3;
        int i16;
        TextView textView = this.K;
        int i17 = 8;
        if (textView != null) {
            if (z16) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            textView.setVisibility(i16);
        }
        TextView textView2 = this.H;
        if (textView2 != null) {
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView2.setVisibility(i3);
        }
        View view = this.L;
        if (view != null) {
            if (!z16) {
                i17 = 0;
            }
            view.setVisibility(i17);
        }
        setOrientation(1);
        this.M = z16;
        RecyclerView recyclerView = this.E;
        if (recyclerView != null) {
            recyclerView.getLayoutParams().height = ImmersiveUtils.dpToPx(250.0f);
            requestLayout();
        }
    }

    public void setShopData(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        String str;
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountMeta$StFeed.poster;
        this.I = certifiedAccountMeta$StFeed;
        if (this.H != null && certifiedAccountMeta$StUser.youZhan.size() > 0 && certifiedAccountMeta$StUser.youZhan.get(0).goodNum.get() > 0) {
            VSReporter.n(certifiedAccountMeta$StUser.f24929id.get(), "auth_" + SubscribeShareHelper.s(g()), "exp_shop", 0, 0, new String[0]);
            this.H.setVisibility(0);
            TextView textView = this.H;
            String qqStr = HardCodeUtil.qqStr(R.string.vsa);
            Object[] objArr = new Object[1];
            if (SubscribeUtils.o(certifiedAccountMeta$StUser.attr.get())) {
                str = HardCodeUtil.qqStr(R.string.ku8);
            } else {
                str = certifiedAccountMeta$StUser.nick.get();
            }
            objArr[0] = str;
            textView.setText(String.format(qqStr, objArr));
            this.H.setOnClickListener(new a(certifiedAccountMeta$StUser));
        }
    }

    public void w() {
        b bVar = this.J;
        if (bVar != null) {
            bVar.q();
            this.J.notifyDataSetChanged();
        }
    }

    public String x() {
        String str;
        if (f() == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < f().size(); i3++) {
            Object obj = f().get(i3);
            if (obj instanceof CommodityBean) {
                CommodityBean commodityBean = (CommodityBean) obj;
                long j3 = commodityBean.mItemID;
                if (j3 > 0) {
                    str = String.valueOf(j3);
                } else {
                    str = commodityBean.mAlias;
                }
            } else {
                CertifiedAccountMeta$StYouZanGood certifiedAccountMeta$StYouZanGood = (CertifiedAccountMeta$StYouZanGood) obj;
                if (certifiedAccountMeta$StYouZanGood.itemID.get() > 0) {
                    str = String.valueOf(certifiedAccountMeta$StYouZanGood.itemID.get());
                } else {
                    str = certifiedAccountMeta$StYouZanGood.alias.get();
                }
            }
            sb5.append(str);
            if (i3 != f().size() - 1) {
                sb5.append(",");
            }
        }
        return sb5.toString();
    }

    public CommodityListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void setData(ArrayList arrayList) {
        super.setData((CommodityListView) arrayList);
        b bVar = this.J;
        if (bVar != null) {
            bVar.t(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void c(ArrayList arrayList) {
    }
}
