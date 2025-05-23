package com.tencent.widget.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.datepicker.SimpleMonthView;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b extends RecyclerView.Adapter<a> implements SimpleMonthView.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final TypedArray f384777d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f384778e;

    /* renamed from: f, reason: collision with root package name */
    private CalendarDay f384779f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, ArrayList<MessageRecord>> f384780h;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final SimpleMonthView f384781d;

        public a(View view, SimpleMonthView.a aVar) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) aVar);
                return;
            }
            SimpleMonthView simpleMonthView = (SimpleMonthView) view;
            this.f384781d = simpleMonthView;
            simpleMonthView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            simpleMonthView.setClickable(true);
            simpleMonthView.setOnDayClickListener(aVar);
        }
    }

    public b(Context context, com.tencent.widget.datepicker.a aVar, TypedArray typedArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, typedArray);
            return;
        }
        this.f384780h = new HashMap<>();
        this.f384778e = context;
        this.f384777d = typedArray;
        if (typedArray.getBoolean(jj2.b.S0, false)) {
            r(new CalendarDay(System.currentTimeMillis()));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        throw null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // com.tencent.widget.datepicker.SimpleMonthView.a
    public void n(SimpleMonthView simpleMonthView, CalendarDay calendarDay, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, simpleMonthView, calendarDay, obj);
        } else if (calendarDay != null && obj != null && (obj instanceof MessageRecord)) {
            r(calendarDay);
            throw null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, i3);
            EventCollector.getInstance().onRecyclerBindViewHolder(aVar, i3, getItemId(i3));
        } else {
            SimpleMonthView simpleMonthView = aVar.f384781d;
            new HashMap();
            throw null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        return new a(new SimpleMonthView(this.f384778e, this.f384777d), this);
    }

    protected void r(CalendarDay calendarDay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) calendarDay);
        } else {
            this.f384779f = calendarDay;
            notifyDataSetChanged();
        }
    }
}
