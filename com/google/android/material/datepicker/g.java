package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class g extends BaseAdapter {

    /* renamed from: m, reason: collision with root package name */
    static final int f33599m = o.q().getMaximum(4);

    /* renamed from: d, reason: collision with root package name */
    final Month f33600d;

    /* renamed from: e, reason: collision with root package name */
    final DateSelector<?> f33601e;

    /* renamed from: f, reason: collision with root package name */
    private Collection<Long> f33602f;

    /* renamed from: h, reason: collision with root package name */
    b f33603h;

    /* renamed from: i, reason: collision with root package name */
    final CalendarConstraints f33604i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f33600d = month;
        this.f33601e = dateSelector;
        this.f33604i = calendarConstraints;
        this.f33602f = dateSelector.T();
    }

    private void e(Context context) {
        if (this.f33603h == null) {
            this.f33603h = new b(context);
        }
    }

    private boolean h(long j3) {
        Iterator<Long> it = this.f33601e.T().iterator();
        while (it.hasNext()) {
            if (o.a(j3) == o.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(@Nullable TextView textView, long j3) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.f33604i.g().i(j3)) {
            textView.setEnabled(true);
            if (h(j3)) {
                aVar = this.f33603h.f33588b;
            } else if (o.o().getTimeInMillis() == j3) {
                aVar = this.f33603h.f33589c;
            } else {
                aVar = this.f33603h.f33587a;
            }
        } else {
            textView.setEnabled(false);
            aVar = this.f33603h.f33593g;
        }
        aVar.d(textView);
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j3) {
        if (Month.f(j3).equals(this.f33600d)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f33600d.m(j3)) - materialCalendarGridView.getFirstVisiblePosition()), j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i3) {
        return b() + (i3 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f33600d.k();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i3) {
        if (i3 >= this.f33600d.k() && i3 <= i()) {
            return Long.valueOf(this.f33600d.l(j(i3)));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    @Override // android.widget.Adapter
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i3, @Nullable View view, @NonNull ViewGroup viewGroup) {
        Long item;
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flg, viewGroup, false);
        }
        int b16 = i3 - b();
        if (b16 >= 0) {
            Month month = this.f33600d;
            if (b16 < month.f33572i) {
                int i16 = b16 + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i16)));
                long l3 = this.f33600d.l(i16);
                if (this.f33600d.f33570f == Month.j().f33570f) {
                    textView.setContentDescription(d.g(l3));
                } else {
                    textView.setContentDescription(d.l(l3));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i3);
                if (item != null) {
                    k(textView, item.longValue());
                }
                EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i3);
        if (item != null) {
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i3) {
        if (i3 % this.f33600d.f33571h == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i3) {
        if ((i3 + 1) % this.f33600d.f33571h == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f33600d.f33572i + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3 / this.f33600d.f33571h;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return (this.f33600d.k() + this.f33600d.f33572i) - 1;
    }

    int j(int i3) {
        return (i3 - this.f33600d.k()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.f33602f.iterator();
        while (it.hasNext()) {
            l(materialCalendarGridView, it.next().longValue());
        }
        DateSelector<?> dateSelector = this.f33601e;
        if (dateSelector != null) {
            Iterator<Long> it5 = dateSelector.T().iterator();
            while (it5.hasNext()) {
                l(materialCalendarGridView, it5.next().longValue());
            }
            this.f33602f = this.f33601e.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(int i3) {
        if (i3 >= b() && i3 <= i()) {
            return true;
        }
        return false;
    }
}
