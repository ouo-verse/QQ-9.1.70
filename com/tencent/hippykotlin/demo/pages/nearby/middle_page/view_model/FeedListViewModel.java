package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view_model;

import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.common.a;
import com.tencent.ntcompose.lifecycle.common.c;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import p35.ah;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class FeedListViewModel extends g implements a {
    public final float collapsedHeight;
    public final NBPMiddlePageDTReporter dtReporter;
    public final ah poiInfo;

    public FeedListViewModel(float f16, NBPMiddlePageDTReporter nBPMiddlePageDTReporter, ah ahVar) {
        this.collapsedHeight = f16;
        this.dtReporter = nBPMiddlePageDTReporter;
        this.poiInfo = ahVar;
    }

    public abstract /* synthetic */ void onStateChanged(c cVar, Lifecycle.Event event);
}
