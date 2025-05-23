package com.tencent.mobileqq.gamecenter.qa.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import ud1.g;

/* compiled from: P */
/* loaded from: classes12.dex */
public class q extends BaseAdapter implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private List<g.b> f213184d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private int f213185e;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        TextView f213186a;

        a() {
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g.b getItem(int i3) {
        List<g.b> list = this.f213184d;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    public void b(int i3) {
        this.f213185e = i3;
        notifyDataSetChanged();
    }

    public void c(List<g.b> list) {
        this.f213184d.clear();
        this.f213184d.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f213184d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ebm, (ViewGroup) null);
            aVar = new a();
            aVar.f213186a = (TextView) view.findViewById(R.id.f87064tc);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        g.b item = getItem(i3);
        if (item != null) {
            aVar.f213186a.setText(item.f438848b);
            if (this.f213185e == i3) {
                aVar.f213186a.setTextColor(view.getResources().getColor(R.color.cff));
            } else {
                aVar.f213186a.setTextColor(view.getResources().getColor(R.color.qqgame_strategy_article_source_type_item_text_color));
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.xeq || id5 == R.id.f113386qh) {
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
