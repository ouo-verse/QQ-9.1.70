package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.part.block.base.a;
import com.tencent.biz.subscribe.part.extendsblock.HorizontalRvInnerView;
import com.tencent.biz.subscribe.part.extendsblock.a;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommodityAdapter extends com.tencent.biz.subscribe.part.extendsblock.a {
    private CertifiedAccountMeta$StFeed K;
    private FrameLayout L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StUser f95723d;

        a(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
            this.f95723d = certifiedAccountMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VSReporter.n(this.f95723d.f24929id.get(), "auth_" + SubscribeShareHelper.s(CommodityAdapter.this.D()), "clk_shop", 0, 0, new String[0]);
            com.tencent.biz.subscribe.d.l(this.f95723d.youZhan.get(0).schema.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public CommodityAdapter(Bundle bundle) {
        super(bundle);
    }

    private FrameLayout n0() {
        FrameLayout B = B(null);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) B.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(30.0f);
        layoutParams.topMargin = ImmersiveUtils.dpToPx(20.0f);
        layoutParams.leftMargin = ImmersiveUtils.dpToPx(16.0f);
        layoutParams.rightMargin = ImmersiveUtils.dpToPx(16.0f);
        B.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(C());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(1.0f)));
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        B.addView(imageView);
        return B;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int P() {
        return 3;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
        View b16 = com.tencent.biz.subscribe.part.b.b(C(), 16.0f, "#222222", HardCodeUtil.qqStr(R.string.kaa));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        layoutParams.leftMargin = ImmersiveUtils.dpToPx(14.0f);
        b16.setLayoutParams(layoutParams);
        this.L = B(b16);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (r().size() > 0) {
            return 3;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return 100001;
            }
            return 100002;
        }
        return 100000;
    }

    @Override // com.tencent.biz.subscribe.part.extendsblock.a
    public int i0() {
        return r().size();
    }

    @Override // com.tencent.biz.subscribe.part.extendsblock.a
    public void j0(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!ArrayUtils.isOutOfArrayIndex(i3, r())) {
            ((CommodityItemView) viewHolder.itemView).setData(r().get(i3));
            ((CommodityItemView) viewHolder.itemView).setExtraTypeInfo(D());
        }
    }

    @Override // com.tencent.biz.subscribe.part.extendsblock.a
    public a.C0970a k0(ViewGroup viewGroup, int i3) {
        CommodityItemView commodityItemView = new CommodityItemView(viewGroup.getContext());
        commodityItemView.setCurrentFeed(this.K);
        return new a.C0970a(commodityItemView);
    }

    @Override // com.tencent.biz.subscribe.part.extendsblock.a
    public void l0(HorizontalRvInnerView horizontalRvInnerView) {
        if ((A().Y(0) instanceof DetailBaseBlock) && ((DetailBaseBlock) A().Y(0)).P0() != null) {
            ((DetailBaseBlock) A().Y(0)).P0().b(horizontalRvInnerView);
        }
    }

    public void o0(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        String str;
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountMeta$StFeed.poster;
        this.K = certifiedAccountMeta$StFeed;
        if (certifiedAccountMeta$StUser.youZhan.size() > 0 && certifiedAccountMeta$StUser.youZhan.get(0).goodNum.get() > 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            layoutParams.rightMargin = ImmersiveUtils.dpToPx(14.0f);
            LinearLayout linearLayout = new LinearLayout(C());
            linearLayout.setOrientation(0);
            this.L.addView(linearLayout, layoutParams);
            a aVar = new a(certifiedAccountMeta$StUser);
            VSReporter.n(certifiedAccountMeta$StUser.f24929id.get(), "auth_" + SubscribeShareHelper.s(D()), "exp_shop", 0, 0, new String[0]);
            Activity y16 = y();
            Object[] objArr = new Object[1];
            if (SubscribeUtils.o(certifiedAccountMeta$StUser.attr.get())) {
                str = HardCodeUtil.qqStr(R.string.ku8);
            } else {
                str = certifiedAccountMeta$StUser.nick.get();
            }
            objArr[0] = str;
            TextView b16 = com.tencent.biz.subscribe.part.b.b(y16, 13.5f, "#878B99", String.format("%s", objArr));
            b16.setMaxLines(1);
            b16.setMaxWidth(ImmersiveUtils.dpToPx(150.0f));
            b16.setGravity(5);
            b16.setEllipsize(TextUtils.TruncateAt.END);
            b16.setOnClickListener(aVar);
            linearLayout.addView(b16, new LinearLayout.LayoutParams(-2, -2));
            TextView b17 = com.tencent.biz.subscribe.part.b.b(y(), 13.5f, "#878B99", "\u7684\u5c0f\u5e97");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            b17.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0f));
            Drawable drawable = y().getResources().getDrawable(R.drawable.common_arrow_right_selector);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            b17.setCompoundDrawables(null, null, drawable, null);
            b17.setOnClickListener(aVar);
            linearLayout.addView(b17, layoutParams2);
        }
    }

    @Override // com.tencent.biz.subscribe.part.extendsblock.a, android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        switch (i3) {
            case 100000:
                return new a.C0969a(this.L);
            case 100001:
                return new a.C0969a(n0());
            default:
                return super.onCreateViewHolder(viewGroup, i3);
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.a.e
    public void r2(String str, a.d dVar) {
        Object obj;
        super.r2(str, dVar);
        if (str.equals("share_key_subscribe_feeds_update") && (obj = dVar.f96169a) != null) {
            this.K = (CertifiedAccountMeta$StFeed) obj;
            if (s() != null) {
                s().post(new Runnable() { // from class: com.tencent.biz.subscribe.bizdapters.CommodityAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CommodityAdapter commodityAdapter = CommodityAdapter.this;
                        commodityAdapter.t((ArrayList) commodityAdapter.K.goods.get());
                        CommodityAdapter commodityAdapter2 = CommodityAdapter.this;
                        commodityAdapter2.o0(commodityAdapter2.K);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
    }
}
