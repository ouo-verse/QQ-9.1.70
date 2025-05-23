package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class QavListItemBase extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    protected int f75020d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f75021e;

    /* renamed from: f, reason: collision with root package name */
    a f75022f;

    /* renamed from: h, reason: collision with root package name */
    final String f75023h;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(long j3, int i3, QavListItemBase qavListItemBase);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void s(long j3, String str, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f75024a;

        /* renamed from: b, reason: collision with root package name */
        public String f75025b;

        /* renamed from: c, reason: collision with root package name */
        public String f75026c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f75027d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f75028e;

        /* renamed from: g, reason: collision with root package name */
        public int f75030g;

        /* renamed from: k, reason: collision with root package name */
        public String f75034k;

        /* renamed from: f, reason: collision with root package name */
        public int f75029f = 0;

        /* renamed from: h, reason: collision with root package name */
        public boolean f75031h = false;

        /* renamed from: i, reason: collision with root package name */
        public int f75032i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f75033j = 0;

        /* renamed from: l, reason: collision with root package name */
        public Object f75035l = null;

        /* renamed from: m, reason: collision with root package name */
        public boolean f75036m = false;

        public String toString() {
            return "id[" + this.f75024a + "], name[" + this.f75026c + "], desc[" + this.f75034k + "]";
        }
    }

    public QavListItemBase(Context context) {
        super(context);
        this.f75021e = context;
        this.f75023h = getClass().getSimpleName() + "_" + com.tencent.av.utils.e.d();
    }

    public void a(int i3, a aVar) {
        this.f75020d = i3;
        this.f75022f = aVar;
    }

    public abstract void b(int i3, boolean z16, boolean z17, c cVar, a aVar);

    public int d() {
        return this.f75020d;
    }

    public abstract void e(int i3, int i16);

    public abstract void g(int i3, int i16);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f75022f != null) {
            long d16 = com.tencent.av.utils.e.d();
            QLog.w(this.f75023h, 1, "onClick, seq[" + d16 + "], mPosition[" + this.f75020d + "]");
            this.f75022f.a(d16, this.f75020d, this);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public abstract void setHighlight(boolean z16);

    public void f(int i3) {
    }

    public void c(c cVar, int i3) {
    }

    public void setHighlight(boolean z16, boolean z17) {
    }
}
