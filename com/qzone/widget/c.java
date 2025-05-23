package com.qzone.widget;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private long f60706a;

    /* renamed from: b, reason: collision with root package name */
    private d5.g f60707b;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f60708d;

        a(View view) {
            this.f60708d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (c.this.f60707b != null && !c.this.f60707b.onClick(this.f60708d)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.f60706a > 1000) {
                    c.this.f60706a = currentTimeMillis;
                } else {
                    c.this.f60707b.onDoubleClick(this.f60708d);
                    c.this.f60706a = 0L;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(View view) {
        view.setOnClickListener(new a(view));
    }

    public void d(d5.g gVar) {
        this.f60707b = gVar;
    }
}
