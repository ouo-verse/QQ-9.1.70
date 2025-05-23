package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private long f209528d = 0;

    public abstract void b(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f209528d >= 500) {
            b(view);
            this.f209528d = currentTimeMillis;
        } else {
            a(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void a(View view) {
    }
}
