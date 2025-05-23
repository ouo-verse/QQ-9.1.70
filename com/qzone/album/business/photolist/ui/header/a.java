package com.qzone.album.business.photolist.ui.header;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.album.business.search.SearchFilterComposition;
import com.tencent.mobileqq.R;
import u4.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private SearchFilterComposition f43526a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f43527b;

    /* renamed from: c, reason: collision with root package name */
    private h f43528c;

    /* renamed from: d, reason: collision with root package name */
    private View f43529d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f43530e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.album.business.photolist.adapter.b f43531f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayoutManager f43532g;

    public a(Activity activity, h hVar, SearchFilterComposition searchFilterComposition) {
        this.f43527b = activity;
        this.f43528c = hVar;
        this.f43526a = searchFilterComposition;
        c();
    }

    private boolean b() {
        SearchFilterComposition searchFilterComposition;
        return (this.f43527b == null || this.f43528c == null || (searchFilterComposition = this.f43526a) == null || !searchFilterComposition.isDataValid()) ? false : true;
    }

    private void c() {
        if (b()) {
            View inflate = LayoutInflater.from(this.f43527b).inflate(R.layout.bis, (ViewGroup) null);
            this.f43529d = inflate;
            this.f43530e = (RecyclerView) inflate.findViewById(R.id.f166689hd2);
            this.f43531f = new com.qzone.album.business.photolist.adapter.b(this.f43527b, this.f43526a);
            this.f43532g = new LinearLayoutManager(this.f43527b, 0, false);
            this.f43530e.setOverScrollMode(2);
            this.f43530e.setHasFixedSize(true);
            this.f43530e.setLayoutManager(this.f43532g);
            this.f43530e.setAdapter(this.f43531f);
        }
    }

    public void a() {
        h hVar = this.f43528c;
        if (hVar == null || hVar.getListView() == null || this.f43529d == null) {
            return;
        }
        this.f43528c.getListView().addHeaderView(this.f43529d);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f43528c.getListView().getLayoutParams();
        layoutParams.addRule(3, R.id.f166672ha0);
        this.f43528c.getListView().setLayoutParams(layoutParams);
    }

    public void d() {
        com.qzone.album.business.photolist.adapter.b bVar = this.f43531f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }
}
