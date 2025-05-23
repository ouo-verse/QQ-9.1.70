package com.tencent.luggage.wxa.bm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.bm.a f123075a;

    /* renamed from: b, reason: collision with root package name */
    public View f123076b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            int i3;
            if (b.this.f123076b != null) {
                View view = b.this.f123076b;
                if (b.this.c()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                view.setVisibility(i3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bm.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6084b implements com.tencent.luggage.wxa.bm.c {
        public C6084b() {
        }

        @Override // com.tencent.luggage.wxa.bm.c
        public void a(View view, int i3, long j3) {
            b.b(b.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.bm.d {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.bm.d
        public boolean a(View view, int i3, long j3) {
            b.c(b.this);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
    }

    public b(Context context) {
        super(context);
        a();
    }

    public static /* synthetic */ e c(b bVar) {
        bVar.getClass();
        return null;
    }

    public boolean b() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter<?> getAdapter() {
        return this.f123075a;
    }

    public View getEmptyView() {
        return this.f123076b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i3) {
        super.scrollToPosition(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        this.f123075a.a(adapter);
    }

    public void setEmptyView(View view) {
        int i3;
        if (this.f123076b == view) {
            return;
        }
        this.f123076b = view;
        if (view != null) {
            if (c()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public void setOnItemClickListener(d dVar) {
        this.f123075a.a(new C6084b());
    }

    public void setOnItemLongClickListener(e eVar) {
        this.f123075a.a(new c());
    }

    public static /* synthetic */ d b(b bVar) {
        bVar.getClass();
        return null;
    }

    public final void a() {
        this.f123075a = new com.tencent.luggage.wxa.bm.a();
        if (b()) {
            this.f123075a.setHasStableIds(true);
        }
        super.setAdapter(this.f123075a);
        this.f123075a.registerAdapterDataObserver(new a());
    }

    public void c(View view) {
        this.f123075a.c(view);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void b(View view) {
        this.f123075a.b(view);
    }

    public boolean c() {
        return this.f123075a.getItemCount() == 0;
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }

    public void a(View view) {
        this.f123075a.a(view);
    }

    public void a(int i3, View view) {
        this.f123075a.a(i3, view);
    }
}
