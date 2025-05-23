package com.tencent.now.pkgame.pkgame.pktoprank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import g55.bc;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContributeView extends ConstraintLayout {
    private d C;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f339039d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f339040e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f339041f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f339042h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f339043i;

    /* renamed from: m, reason: collision with root package name */
    private List<bc> f339044m;

    public ContributeView(Context context) {
        super(context);
        this.f339044m = new ArrayList();
        z0();
    }

    private void z0() {
        LayoutInflater.from(getContext()).inflate(R.layout.hau, this);
        this.f339039d = (ImageView) findViewById(R.id.xin);
        this.f339040e = (ImageView) findViewById(R.id.xio);
        this.f339041f = (TextView) findViewById(R.id.f95775fw);
        this.f339042h = (TextView) findViewById(R.id.f95765fv);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f7886488);
        this.f339043i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        d dVar = new d();
        this.C = dVar;
        dVar.l0(this.f339044m);
        this.f339043i.setAdapter(this.C);
    }

    public void A0(a aVar) {
        this.f339039d.setImageDrawable(aVar.d());
        this.f339040e.setImageDrawable(aVar.c());
        this.f339041f.setText(aVar.b());
        this.f339042h.setText(aVar.f());
        this.f339044m.clear();
        this.f339044m.addAll(aVar.a());
        this.C.notifyDataSetChanged();
    }

    public ContributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f339044m = new ArrayList();
        z0();
    }

    public ContributeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f339044m = new ArrayList();
        z0();
    }
}
