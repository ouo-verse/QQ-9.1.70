package com.tencent.mobileqq.vasgift.view;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private long f312113d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f312114e;

    public b(int i3) {
        this.f312114e = i3;
    }

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (System.currentTimeMillis() - this.f312113d >= this.f312114e) {
            this.f312113d = System.currentTimeMillis();
            a(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
