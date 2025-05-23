package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
class e extends BaseAdapter {

    /* renamed from: h, reason: collision with root package name */
    private static final int f33595h;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final Calendar f33596d;

    /* renamed from: e, reason: collision with root package name */
    private final int f33597e;

    /* renamed from: f, reason: collision with root package name */
    private final int f33598f;

    static {
        int i3;
        if (Build.VERSION.SDK_INT >= 26) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        f33595h = i3;
    }

    public e() {
        Calendar q16 = o.q();
        this.f33596d = q16;
        this.f33597e = q16.getMaximum(7);
        this.f33598f = q16.getFirstDayOfWeek();
    }

    private int b(int i3) {
        int i16 = i3 + this.f33598f;
        int i17 = this.f33597e;
        if (i16 > i17) {
            return i16 - i17;
        }
        return i16;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i3) {
        if (i3 >= this.f33597e) {
            return null;
        }
        return Integer.valueOf(b(i3));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f33597e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i3, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flh, viewGroup, false);
        }
        this.f33596d.set(7, b(i3));
        textView.setText(this.f33596d.getDisplayName(7, f33595h, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.f168582g1), this.f33596d.getDisplayName(7, 2, Locale.getDefault())));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return textView;
    }
}
