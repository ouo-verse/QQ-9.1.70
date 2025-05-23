package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.view.View;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface IContainer {
    void attachViews();

    void destroy();

    View getHolderView();

    int getType();

    ViewBase getVirtualView();

    void setVirtualView(ViewBase viewBase);
}
