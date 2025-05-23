package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.immersive.views.QFSShoppingGoodsItemView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ar extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSShoppingGoodsItemView C;
    private QCircleShoppingGoodsInfoBean D;
    private q70.a E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Observer<QCircleShoppingGoodsInfoBean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean) {
            if (qCircleShoppingGoodsInfoBean != null) {
                ar.this.D = qCircleShoppingGoodsInfoBean;
                if (ar.this.C != null) {
                    ar.this.C.setData(ar.this.D, 0);
                }
            }
        }
    }

    public ar(Bundle bundle, QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean, q70.a aVar) {
        super(bundle);
        this.D = qCircleShoppingGoodsInfoBean;
        this.E = aVar;
    }

    private void m0() {
        QLog.d("QFSShoppingCartBlock", 1, "init shop view model " + getClass());
        if (this.E == null) {
            QLog.d("QFSShoppingCartBlock", 1, "view model is null " + getClass());
            return;
        }
        if (getParentFragment() == null) {
            QLog.d("QFSShoppingCartBlock", 1, "parent fragment is null " + getClass());
            return;
        }
        this.E.N1().observe(getParentFragment(), new a());
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSShoppingGoodsItemView qFSShoppingGoodsItemView = new QFSShoppingGoodsItemView(viewGroup.getContext());
        this.C = qFSShoppingGoodsItemView;
        return qFSShoppingGoodsItemView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSShoppingCartBlock";
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public QCircleShoppingGoodsInfoBean l0() {
        return this.D;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.D;
        if (qCircleShoppingGoodsInfoBean == null) {
            return;
        }
        this.C.setData(qCircleShoppingGoodsInfoBean, i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        m0();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
