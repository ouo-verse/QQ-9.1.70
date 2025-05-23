package com.tencent.biz.richframework.widget.listview.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardHolder;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardViewBuilder {
    public float firstCardMargin;
    public RecyclerView.ItemDecoration itemDecoration;
    public float largeCardHeight;
    public float largeCardMargin;
    public float largeCardWidth;
    public float normalCardHeight;
    public float normalCardWidth;
    public OnLargeBindListener onLargeBindListener;
    public OnNormalBindListener onNormalBindListener;
    public int normalCardResId = 0;
    public int largeCardResId = 0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnLargeBindListener {
        void onBind(IRFWCardHolder iRFWCardHolder, RFWCardModel rFWCardModel, int i3);

        IRFWCardHolder onCreate(View view);

        void onLayoutDuringAnimation(IRFWCardHolder iRFWCardHolder, View view, float f16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnNormalBindListener {
        void onBind(IRFWCardHolder iRFWCardHolder, RFWCardModel rFWCardModel, int i3);

        IRFWCardHolder onCreate(View view);
    }

    public RFWCardViewBuilder setLargeCardAttribute(int i3, int i16, int i17, int i18) {
        this.largeCardWidth = i3;
        this.largeCardHeight = i16;
        this.largeCardMargin = i17;
        this.firstCardMargin = i18;
        return this;
    }

    public RFWCardViewBuilder setLargeCardDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
        return this;
    }

    public RFWCardViewBuilder setLargeCardView(int i3, OnLargeBindListener onLargeBindListener) {
        this.largeCardResId = i3;
        this.onLargeBindListener = onLargeBindListener;
        return this;
    }

    public RFWCardViewBuilder setNormalCardAttribute(int i3, int i16) {
        this.normalCardWidth = i3;
        this.normalCardHeight = i16;
        return this;
    }

    public RFWCardViewBuilder setNormalCardView(int i3, OnNormalBindListener onNormalBindListener) {
        this.normalCardResId = i3;
        this.onNormalBindListener = onNormalBindListener;
        return this;
    }
}
