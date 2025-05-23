package com.tencent.luggage.wxa.pl;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.n;
import com.tencent.luggage.wxa.ol.q0;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final q0 f137651a;

    /* renamed from: b, reason: collision with root package name */
    public final e f137652b;

    /* renamed from: d, reason: collision with root package name */
    public v f137654d;

    /* renamed from: c, reason: collision with root package name */
    public final n.d f137653c = new a();

    /* renamed from: e, reason: collision with root package name */
    public int f137655e = Integer.MIN_VALUE;

    /* renamed from: f, reason: collision with root package name */
    public boolean f137656f = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements n.d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ol.n.d
        public void a() {
            c.this.f137655e = Integer.MIN_VALUE;
            c.this.b(3);
        }

        @Override // com.tencent.luggage.wxa.ol.n.d
        public void b() {
            c.this.f137655e = Integer.MIN_VALUE;
            c.this.b(3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (c.this.f137652b.i()) {
                c.this.b(1);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pl.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewTreeObserverOnPreDrawListenerC6609c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListView f137659a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f137660b;

        public ViewTreeObserverOnPreDrawListenerC6609c(ListView listView, int i3) {
            this.f137659a = listView;
            this.f137660b = i3;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f137659a.getViewTreeObserver().removeOnPreDrawListener(this);
            c.this.a(this.f137660b);
            return true;
        }
    }

    public c(q0 q0Var, e eVar) {
        this.f137651a = q0Var;
        this.f137652b = eVar;
    }

    public void b(v vVar) {
        n.b(vVar).b(this.f137653c);
    }

    public void a() {
        n.b(this.f137654d).b(this.f137653c);
    }

    public final void b(int i3) {
        ListView e16 = this.f137652b.e();
        if (e16 != null && this.f137652b.i()) {
            if (1 == i3 && this.f137656f) {
                this.f137655e = Integer.MIN_VALUE;
                this.f137656f = false;
            }
            e16.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC6609c(e16, i3));
        }
    }

    public void a(v vVar) {
        this.f137654d = vVar;
        n.b(vVar).a(this.f137653c);
    }

    public void a(CharSequence charSequence) {
        b(2);
        this.f137655e = Integer.MIN_VALUE;
        if (!w0.a(charSequence)) {
            this.f137656f = true;
        }
        ListView e16 = this.f137652b.e();
        if (e16 != null) {
            e16.getAdapter().registerDataSetObserver(new b());
        }
    }

    public final void a(int i3) {
        View inputPanel;
        int i16;
        if (!this.f137652b.i() || this.f137652b.e() == null || this.f137652b.e().getAdapter() == null || this.f137652b.e().getAdapter().getCount() <= 0 || (inputPanel = this.f137651a.getInputPanel()) == null) {
            return;
        }
        int a16 = com.tencent.luggage.wxa.kn.a.a(this.f137651a.getContext(), 8);
        int height = this.f137652b.e().getChildAt(0).getHeight();
        int count = this.f137652b.e().getAdapter().getCount() * height;
        int i17 = a16 * 2;
        int i18 = count + i17;
        int i19 = (height * 3) + i17;
        if (i18 > i19) {
            i16 = i19 - i17;
            i18 = i19;
        } else {
            i16 = count;
        }
        this.f137652b.b(i18);
        int[] iArr = new int[2];
        this.f137651a.getView().getLocationInWindow(iArr);
        int height2 = this.f137651a.getView().getHeight() + iArr[1];
        inputPanel.getLocationInWindow(iArr);
        a(height2, iArr[1], height, i16, a16);
        this.f137652b.k();
        this.f137655e = this.f137652b.f();
    }

    public final void a(int i3, int i16, int i17, int i18, int i19) {
        int i26 = this.f137655e;
        if ((i26 == Integer.MIN_VALUE || i26 >= 0 - i19) && i16 - i3 >= i18 + i19) {
            this.f137652b.a(this.f137651a.getView());
            this.f137652b.b(i18 + (i19 * 2));
            this.f137652b.e(0 - i19);
            return;
        }
        if (i3 - this.f137651a.getView().getHeight() >= i18) {
            this.f137652b.a(this.f137651a.getView());
            this.f137652b.b((i19 * 2) + i18);
            this.f137652b.e((-(i18 + i19)) - this.f137651a.getView().getHeight());
        } else {
            if (i18 <= i17) {
                this.f137652b.b(i17);
                this.f137652b.a(this.f137651a.getView());
                int i27 = 0 - i19;
                if (this.f137655e < i27) {
                    this.f137652b.e((-(i18 + i19)) - this.f137651a.getView().getHeight());
                    return;
                } else {
                    this.f137652b.e(i27);
                    return;
                }
            }
            a(i3, i16, i17, i18 - i17, i19);
        }
    }
}
