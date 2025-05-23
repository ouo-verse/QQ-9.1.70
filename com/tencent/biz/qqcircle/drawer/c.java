package com.tencent.biz.qqcircle.drawer;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private d f84389m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        QFSDrawerHeaderView E;

        public a(@NonNull QFSDrawerHeaderView qFSDrawerHeaderView) {
            super(qFSDrawerHeaderView);
            this.E = qFSDrawerHeaderView;
        }

        public void l(d dVar) {
            this.E.b(dVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f84389m != null) {
            return 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        aVar.l(this.f84389m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSDrawerHeaderView qFSDrawerHeaderView = new QFSDrawerHeaderView(viewGroup.getContext());
        qFSDrawerHeaderView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new a(qFSDrawerHeaderView);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void k0(d dVar) {
        this.f84389m = dVar;
        notifyDataSetChanged();
    }
}
