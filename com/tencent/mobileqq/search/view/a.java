package com.tencent.mobileqq.search.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements sn2.b {

    /* renamed from: d, reason: collision with root package name */
    protected View f285109d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f285110e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f285111f;

    /* renamed from: h, reason: collision with root package name */
    private List<sn2.c> f285112h;

    /* renamed from: i, reason: collision with root package name */
    private sn2.c f285113i;

    public a(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false);
        this.f285109d = inflate;
        this.f285111f = (TextView) inflate.findViewById(R.id.ezq);
        ArrayList arrayList = new ArrayList();
        this.f285112h = arrayList;
        arrayList.add(new yn2.c(this.f285109d.findViewById(R.id.dor)));
        this.f285112h.add(new yn2.c(this.f285109d.findViewById(R.id.doy)));
        this.f285112h.add(new yn2.c(this.f285109d.findViewById(R.id.f165845dp4)));
        this.f285112h.add(new yn2.c(this.f285109d.findViewById(R.id.dp_)));
        this.f285112h.add(new yn2.c(this.f285109d.findViewById(R.id.dpa)));
        this.f285113i = new yn2.c(this.f285109d.findViewById(R.id.dpb));
    }

    @Override // sn2.b
    public TextView b() {
        return this.f285110e;
    }

    @Override // sn2.b
    public List<sn2.c> e() {
        return this.f285112h;
    }

    @Override // sn2.b
    public TextView getMoreView() {
        return this.f285111f;
    }

    @Override // sn2.d
    public View getView() {
        return this.f285109d;
    }
}
