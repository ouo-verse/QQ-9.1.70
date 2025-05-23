package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class p extends RecyclerView.Adapter<b> {

    /* renamed from: m, reason: collision with root package name */
    private final MaterialCalendar<?> f33613m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f33614d;

        a(int i3) {
            this.f33614d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            p.this.f33613m.Jh(p.this.f33613m.Ah().f(Month.e(this.f33614d, p.this.f33613m.Ch().f33569e)));
            p.this.f33613m.Kh(MaterialCalendar.CalendarSelector.DAY);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        final TextView E;

        b(TextView textView) {
            super(textView);
            this.E = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MaterialCalendar<?> materialCalendar) {
        this.f33613m = materialCalendar;
    }

    @NonNull
    private View.OnClickListener j0(int i3) {
        return new a(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f33613m.Ah().n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k0(int i3) {
        return i3 - this.f33613m.Ah().m().f33570f;
    }

    int l0(int i3) {
        return this.f33613m.Ah().m().f33570f + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i3) {
        com.google.android.material.datepicker.a aVar;
        int l06 = l0(i3);
        String string = bVar.E.getContext().getString(R.string.f168632g6);
        bVar.E.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(l06)));
        bVar.E.setContentDescription(String.format(string, Integer.valueOf(l06)));
        com.google.android.material.datepicker.b Bh = this.f33613m.Bh();
        Calendar o16 = o.o();
        if (o16.get(1) == l06) {
            aVar = Bh.f33592f;
        } else {
            aVar = Bh.f33590d;
        }
        Iterator<Long> it = this.f33613m.Dh().T().iterator();
        while (it.hasNext()) {
            o16.setTimeInMillis(it.next().longValue());
            if (o16.get(1) == l06) {
                aVar = Bh.f33591e;
            }
        }
        aVar.d(bVar.E);
        bVar.E.setOnClickListener(j0(l06));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flp, viewGroup, false));
    }
}
