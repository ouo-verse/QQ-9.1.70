package com.tencent.biz.richframework.widget.listview.card.api;

import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWCardModel {
    public View cardView;

    public abstract RFWCardModel deepClone();

    public void setView(View view) {
        this.cardView = view;
    }
}
