package com.tencent.biz.subscribe.part.block.base;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a<E> extends RecyclerView.Adapter {

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<E> f96195d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private Handler f96196e;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.part.block.base.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0969a extends RecyclerView.ViewHolder {
        public C0969a(View view) {
            super(view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f96195d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        s().removeCallbacksAndMessages(null);
    }

    public void p(List<E> list) {
        if (list == null) {
            return;
        }
        this.f96195d.addAll(list);
        notifyItemRangeInserted(this.f96195d.size(), list.size());
    }

    public void q() {
        this.f96195d.clear();
    }

    public ArrayList<E> r() {
        return this.f96195d;
    }

    public Handler s() {
        if (this.f96196e == null) {
            this.f96196e = new Handler(Looper.getMainLooper());
        }
        return this.f96196e;
    }

    public void t(ArrayList<E> arrayList) {
        this.f96195d.clear();
        notifyDataSetChanged();
        if (arrayList == null) {
            return;
        }
        this.f96195d.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void u(E e16, int i3) {
        if (e16 != null && i3 < this.f96195d.size()) {
            this.f96195d.set(i3, e16);
        }
    }
}
