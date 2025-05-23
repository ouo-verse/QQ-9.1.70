package com.tencent.biz.qqcircle.immersive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class x extends com.tencent.biz.qqcircle.immersive.views.banner.k<a> implements View.OnClickListener {
    private ArrayList<String> G;
    private int H;
    private QCircleShoppingGoodsInfoBean I;
    private Context J;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        public ImageView E;

        public a(@NonNull ImageView imageView) {
            super(imageView);
            this.E = imageView;
        }
    }

    public x(QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean, Context context) {
        this.G = new ArrayList<>();
        this.J = context;
        this.I = qCircleShoppingGoodsInfoBean;
        if (qCircleShoppingGoodsInfoBean != null) {
            this.G = qCircleShoppingGoodsInfoBean.getImageUrls();
        }
    }

    private void u0() {
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.I;
        if (qCircleShoppingGoodsInfoBean == null) {
            return;
        }
        qCircleShoppingGoodsInfoBean.setCurPos(this.H);
        com.tencent.biz.qqcircle.launcher.c.E0(this.J, this.I);
    }

    private void x0(int i3) {
        this.H = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        ArrayList<String> arrayList = this.G;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            u0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
        ArrayList<String> arrayList = this.G;
        if (arrayList != null && aVar.E != null && arrayList.size() > i3) {
            aVar.E.setOnClickListener(this);
            aVar.E.setScaleType(ImageView.ScaleType.CENTER_CROP);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.G.get(i3)).setTargetView(aVar.E).setRequestWidth(cx.a(366.0f)).setRequestHeight(cx.a(343.0f)).setPredecode(true));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return new a(imageView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NonNull a aVar) {
        super.onViewAttachedToWindow(aVar);
        x0(aVar.getAdapterPosition() + 1);
    }
}
