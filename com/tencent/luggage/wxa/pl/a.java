package com.tencent.luggage.wxa.pl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.luggage.wxa.pl.i;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends ArrayAdapter implements h {

    /* renamed from: a, reason: collision with root package name */
    public final LayoutInflater f137621a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.pl.b f137622b;

    /* renamed from: c, reason: collision with root package name */
    public i f137623c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f137624d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pl.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6607a implements PopupWindow.OnDismissListener {
        public C6607a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (a.this.f137623c != null && !a.this.f137624d) {
                a.this.f137623c.a("", i.a.CANCEL);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public View f137626a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f137627b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f137628c;

        /* renamed from: d, reason: collision with root package name */
        public View f137629d;

        /* renamed from: e, reason: collision with root package name */
        public View f137630e;

        /* renamed from: f, reason: collision with root package name */
        public com.tencent.luggage.wxa.vl.b f137631f;

        public b(View view) {
            this.f137626a = view;
            this.f137627b = (TextView) view.findViewById(R.id.title);
            this.f137628c = (TextView) view.findViewById(R.id.content);
            this.f137629d = view.findViewById(R.id.close);
            this.f137630e = view.findViewById(R.id.bmt);
            view.setBackgroundResource(R.drawable.k6u);
            view.setOnClickListener(this);
            this.f137629d.setOnClickListener(this);
        }

        public void a(com.tencent.luggage.wxa.vl.b bVar) {
            int i3;
            this.f137631f = bVar;
            this.f137627b.setText(bVar.f143649b);
            this.f137628c.setText(bVar.f143650c);
            TextView textView = this.f137628c;
            if (w0.c(bVar.f143650c)) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f137631f != null) {
                if (view.getId() == R.id.close) {
                    a.this.remove(this.f137631f);
                    if (a.this.f137623c != null) {
                        a.this.f137623c.a(this.f137631f.f143648a, i.a.DELETE);
                        return;
                    }
                    return;
                }
                if (view == this.f137626a && a.this.f137623c != null) {
                    if (this.f137631f != null) {
                        a.this.f137623c.a(this.f137631f.f143648a, i.a.SELECT);
                    }
                    a.this.f137624d = true;
                    if (a.this.f137622b != null) {
                        a.this.f137622b.a();
                    }
                }
            }
        }
    }

    public a(Context context, List list) {
        super(context, R.layout.f167647dy0, list);
        this.f137624d = false;
        this.f137621a = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return super.getFilter();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        int i16 = 0;
        if (view == null) {
            view = this.f137621a.inflate(R.layout.f167647dy0, viewGroup, false);
        }
        b bVar = (b) view.getTag();
        if (bVar == null) {
            bVar = new b(view);
            view.setTag(bVar);
        }
        bVar.a((com.tencent.luggage.wxa.vl.b) getItem(i3));
        View view2 = bVar.f137630e;
        if (i3 == getCount() - 1) {
            i16 = 8;
        }
        view2.setVisibility(i16);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.luggage.wxa.pl.h
    public void b(com.tencent.luggage.wxa.pl.b bVar) {
        this.f137622b.a((PopupWindow.OnDismissListener) null);
        this.f137622b = null;
    }

    @Override // com.tencent.luggage.wxa.pl.h
    public void a(com.tencent.luggage.wxa.pl.b bVar) {
        this.f137622b = bVar;
        bVar.a(new C6607a());
    }

    public void a(i iVar) {
        this.f137623c = iVar;
    }
}
