package com.tencent.now.pkgame.pkgame.pktoprank;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.RoundImageView;
import g55.bc;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private List<bc> f339064m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        private final RoundImageView E;
        private final ImageView F;
        private final TextView G;
        private final TextView H;
        private final TextView I;
        private final TextView J;

        public a(@NonNull View view) {
            super(view);
            this.E = (RoundImageView) view.findViewById(R.id.twz);
            this.F = (ImageView) view.findViewById(R.id.y0m);
            this.G = (TextView) view.findViewById(R.id.f112296nj);
            this.H = (TextView) view.findViewById(R.id.f112316nl);
            this.I = (TextView) view.findViewById(R.id.f112306nk);
            this.J = (TextView) view.findViewById(R.id.k85);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f339064m.size();
    }

    public int i0(int i3) {
        if (i3 == 1) {
            return R.drawable.nof;
        }
        if (i3 == 2) {
            return R.drawable.nod;
        }
        return R.drawable.noe;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        bc bcVar = this.f339064m.get(i3);
        if (TextUtils.isEmpty(bcVar.f401354b)) {
            aVar.E.setImageResource(R.drawable.nog);
            aVar.I.setVisibility(0);
        } else {
            aVar.E.setImageDrawable(URLDrawable.getDrawable(bcVar.f401354b, (URLDrawable.URLDrawableOptions) null));
            aVar.I.setVisibility(4);
            aVar.G.setText(bcVar.f401353a);
            aVar.H.setText(String.valueOf(bcVar.f401356d));
        }
        aVar.F.setImageResource(i0(bcVar.f401355c));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hat, viewGroup, false));
    }

    public void l0(List<bc> list) {
        this.f339064m = list;
    }
}
