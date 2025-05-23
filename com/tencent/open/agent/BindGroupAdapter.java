package com.tencent.open.agent;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BindGroupAdapter extends com.tencent.mobileqq.adapter.j {
    private Context F;
    private List<TroopInfo> G;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a extends com.tencent.mobileqq.adapter.k {
        public TroopInfo C;

        /* renamed from: i, reason: collision with root package name */
        public TextView f339649i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f339650m;
    }

    public BindGroupAdapter(Context context, QQAppInterface qQAppInterface, ListView listView, int i3, boolean z16) {
        super(context, qQAppInterface, listView, i3, z16);
        this.F = context;
        this.G = new ArrayList();
    }

    private void h(a aVar, TroopInfo troopInfo) {
        aVar.f187210d = troopInfo.troopuin;
        aVar.f187211e = 4;
        aVar.C = troopInfo;
        aVar.f339649i.setText(troopInfo.getTroopDisplayName());
        if (troopInfo.isThirdAppBind()) {
            aVar.f339650m.setVisibility(0);
            aVar.f339650m.setText(HardCodeUtil.qqStr(R.string.k1l));
        } else {
            aVar.f339650m.setVisibility(8);
        }
        aVar.f187212f.setImageBitmap(c(4, troopInfo.troopuin));
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        return this.G.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.F).inflate(R.layout.a3n, (ViewGroup) null);
            aVar = new a();
            aVar.f187212f = (ImageView) view.findViewById(R.id.dic);
            aVar.f339649i = (TextView) view.findViewById(R.id.kfb);
            aVar.f339650m = (TextView) view.findViewById(R.id.kfk);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        h(aVar, getItem(i3));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public TroopInfo getItem(int i3) {
        return this.G.get(i3);
    }

    public void j(final List<TroopInfo> list) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (list != null) {
                this.G.clear();
                this.G.addAll(list);
                notifyDataSetChanged();
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.agent.BindGroupAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                BindGroupAdapter.this.j(list);
            }
        });
    }
}
