package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes2.dex */
class h extends RecyclerView.Adapter<b> {
    private final DateSelector<?> C;
    private final MaterialCalendar.j D;
    private final int E;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    private final CalendarConstraints f33605m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f33606d;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f33606d = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            if (this.f33606d.getAdapter().n(i3)) {
                h.this.D.a(this.f33606d.getAdapter().getItem(i3).longValue());
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        final TextView E;
        final MaterialCalendarGridView F;

        b(@NonNull LinearLayout linearLayout, boolean z16) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.zdp);
            this.E = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.F = (MaterialCalendarGridView) linearLayout.findViewById(R.id.zdj);
            if (!z16) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.j jVar) {
        int i3;
        Month m3 = calendarConstraints.m();
        Month j3 = calendarConstraints.j();
        Month l3 = calendarConstraints.l();
        if (m3.compareTo(l3) <= 0) {
            if (l3.compareTo(j3) <= 0) {
                int Eh = g.f33599m * MaterialCalendar.Eh(context);
                if (MaterialDatePicker.Eh(context)) {
                    i3 = MaterialCalendar.Eh(context);
                } else {
                    i3 = 0;
                }
                this.E = Eh + i3;
                this.f33605m = calendarConstraints;
                this.C = dateSelector;
                this.D = jVar;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f33605m.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return this.f33605m.m().p(i3).o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month j0(int i3) {
        return this.f33605m.m().p(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CharSequence k0(int i3) {
        return j0(i3).n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l0(@NonNull Month month) {
        return this.f33605m.m().q(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i3) {
        Month p16 = this.f33605m.m().p(i3);
        bVar.E.setText(p16.n());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.F.findViewById(R.id.zdj);
        if (materialCalendarGridView.getAdapter() != null && p16.equals(materialCalendarGridView.getAdapter().f33600d)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m(materialCalendarGridView);
        } else {
            g gVar = new g(p16, this.C, this.f33605m);
            materialCalendarGridView.setNumColumns(p16.f33571h);
            materialCalendarGridView.setAdapter((ListAdapter) gVar);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fll, viewGroup, false);
        if (MaterialDatePicker.Eh(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.E));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }
}
