package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends ArrayAdapter<h> {

    /* renamed from: d, reason: collision with root package name */
    private List<h> f292141d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f292142e;

    public i(Context context, int i3, List<h> list) {
        super(context, i3, list);
        this.f292141d = list;
        this.f292142e = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h getItem(int i3) {
        return this.f292141d.get(i3);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f292141d.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        j jVar;
        if (view == null) {
            view = this.f292142e.inflate(R.layout.e7c, (ViewGroup) null);
            jVar = new j();
            jVar.f292144b = (ImageView) view.findViewById(R.id.g3p);
            jVar.f292143a = (TextView) view.findViewById(R.id.g3q);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        h item = getItem(i3);
        jVar.f292145c = item;
        jVar.f292143a.setText(item.f292138c);
        jVar.f292144b.setBackgroundResource(item.f292136a);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
