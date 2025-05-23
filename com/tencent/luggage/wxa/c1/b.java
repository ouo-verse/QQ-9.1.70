package com.tencent.luggage.wxa.c1;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.x0.c;
import com.tencent.luggage.wxa.x0.h;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f123197a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f123198b;

    /* renamed from: c, reason: collision with root package name */
    public final c f123199c;

    /* renamed from: d, reason: collision with root package name */
    public GridLayoutManager f123200d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.g1.a f123201e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.w0.c f123202f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.w0.b f123203g;

    /* renamed from: h, reason: collision with root package name */
    public Parcelable f123204h;

    /* renamed from: i, reason: collision with root package name */
    public int f123205i;

    /* renamed from: j, reason: collision with root package name */
    public int f123206j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.e1.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.e1.a f123207a;

        public a(com.tencent.luggage.wxa.e1.a aVar) {
            this.f123207a = aVar;
        }

        @Override // com.tencent.luggage.wxa.e1.a
        public void a(com.tencent.luggage.wxa.f1.a aVar) {
            b bVar = b.this;
            bVar.f123204h = bVar.f123198b.getLayoutManager().onSaveInstanceState();
            this.f123207a.a(aVar);
        }
    }

    public b(RecyclerView recyclerView, c cVar, int i3) {
        this.f123198b = recyclerView;
        this.f123199c = cVar;
        this.f123197a = recyclerView.getContext();
        a(i3);
    }

    public final void b(int i3) {
        com.tencent.luggage.wxa.g1.a aVar = this.f123201e;
        if (aVar != null) {
            this.f123198b.removeItemDecoration(aVar);
        }
        com.tencent.luggage.wxa.g1.a aVar2 = new com.tencent.luggage.wxa.g1.a(i3, this.f123197a.getResources().getDimensionPixelSize(R.dimen.dk7), false);
        this.f123201e = aVar2;
        this.f123198b.addItemDecoration(aVar2);
        this.f123200d.setSpanCount(i3);
    }

    public String c() {
        boolean z16;
        if (d()) {
            return com.tencent.luggage.wxa.d1.a.b(this.f123197a, this.f123199c);
        }
        if (this.f123199c.k() == 1) {
            return com.tencent.luggage.wxa.d1.a.c(this.f123197a, this.f123199c);
        }
        int size = this.f123202f.d().size();
        if (!com.tencent.luggage.wxa.d1.c.b(this.f123199c.h()) && size == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return com.tencent.luggage.wxa.d1.a.c(this.f123197a, this.f123199c);
        }
        if (this.f123199c.j() == 999) {
            return String.format(this.f123197a.getString(R.string.f241557s7), Integer.valueOf(size));
        }
        return String.format(this.f123197a.getString(R.string.f241567s8), Integer.valueOf(size), Integer.valueOf(this.f123199c.j()));
    }

    public final boolean d() {
        if (this.f123198b.getAdapter() != null && !(this.f123198b.getAdapter() instanceof com.tencent.luggage.wxa.w0.b)) {
            return false;
        }
        return true;
    }

    public boolean e() {
        if (!d() && !this.f123202f.d().isEmpty() && this.f123199c.b() != h.ALL && this.f123199c.b() != h.GALLERY_ONLY) {
            return true;
        }
        return false;
    }

    public void a(int i3) {
        this.f123205i = i3 == 1 ? 3 : 5;
        this.f123206j = i3 == 1 ? 2 : 4;
        int i16 = this.f123199c.n() && d() ? this.f123206j : this.f123205i;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f123197a, i16);
        this.f123200d = gridLayoutManager;
        this.f123198b.setLayoutManager(gridLayoutManager);
        this.f123198b.setHasFixedSize(true);
        b(i16);
    }

    public void b(List list) {
        this.f123202f.a(list);
        b(this.f123205i);
        this.f123198b.setAdapter(this.f123202f);
    }

    public List b() {
        a();
        return this.f123202f.d();
    }

    public void a(com.tencent.luggage.wxa.e1.b bVar, com.tencent.luggage.wxa.e1.a aVar) {
        ArrayList l3 = (this.f123199c.k() != 2 || this.f123199c.l().isEmpty()) ? null : this.f123199c.l();
        com.tencent.luggage.wxa.b1.b g16 = this.f123199c.g();
        this.f123202f = new com.tencent.luggage.wxa.w0.c(this.f123197a, g16, l3, bVar);
        this.f123203g = new com.tencent.luggage.wxa.w0.b(this.f123197a, g16, new a(aVar));
    }

    public void a(com.tencent.luggage.wxa.c1.a aVar) {
        if (this.f123199c.n() && !d()) {
            a((List) null);
            aVar.a();
        } else {
            aVar.b();
        }
    }

    public void a(List list) {
        this.f123203g.a(list);
        b(this.f123206j);
        this.f123198b.setAdapter(this.f123203g);
        if (this.f123204h != null) {
            this.f123200d.setSpanCount(this.f123206j);
            this.f123198b.getLayoutManager().onRestoreInstanceState(this.f123204h);
        }
    }

    public final void a() {
        if (this.f123202f == null) {
            throw new IllegalStateException("Must call setupAdapters first!");
        }
    }

    public void a(com.tencent.luggage.wxa.e1.c cVar) {
        a();
        this.f123202f.a(cVar);
    }

    public boolean a(boolean z16) {
        if (this.f123199c.k() == 2) {
            if (this.f123202f.d().size() >= this.f123199c.j() && !z16) {
                Toast.makeText(this.f123197a, R.string.f241507s2, 0).show();
                return false;
            }
        } else if (this.f123199c.k() == 1 && this.f123202f.d().size() > 0) {
            this.f123202f.e();
        }
        return true;
    }
}
