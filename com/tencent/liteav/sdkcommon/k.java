package com.tencent.liteav.sdkcommon;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final g f119143a;

    k(g gVar) {
        this.f119143a = gVar;
    }

    public static View.OnClickListener a(g gVar) {
        return new k(gVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f119143a.a(false);
        EventCollector.getInstance().onViewClicked(view);
    }
}
