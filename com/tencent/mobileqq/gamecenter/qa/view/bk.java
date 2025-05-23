package com.tencent.mobileqq.gamecenter.qa.view;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class bk extends RecyclerView.Adapter<c> {
    private b C;
    private boolean D;

    /* renamed from: m, reason: collision with root package name */
    private List<com.tencent.mobileqq.gamecenter.qa.model.j> f213124m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.gamecenter.qa.model.j f213125d;

        a(com.tencent.mobileqq.gamecenter.qa.model.j jVar) {
            this.f213125d = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bk.this.C.a(this.f213125d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(com.tencent.mobileqq.gamecenter.qa.model.j jVar);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c extends RecyclerView.ViewHolder {
        public final TextView E;
        public final TextView F;
        public final View G;

        public c(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.f89104yv);
            this.F = (TextView) view.findViewById(R.id.f89084yt);
            this.G = view.findViewById(R.id.f89094yu);
        }
    }

    private Set<Integer> j0(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                int indexOf = str2.indexOf(charAt);
                while (indexOf >= 0) {
                    hashSet.add(Integer.valueOf(indexOf));
                    indexOf = str2.indexOf(charAt, indexOf + 1);
                }
            }
            return hashSet;
        }
        return Collections.emptySet();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f213124m.size();
    }

    public boolean k0() {
        if (this.f213124m.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i3) {
        int i16;
        com.tencent.mobileqq.gamecenter.qa.model.j jVar = this.f213124m.get(i3);
        SpannableString spannableString = new SpannableString(jVar.f212665c);
        for (Integer num : j0(jVar.f212668f, jVar.f212665c)) {
            Resources resources = cVar.itemView.getResources();
            if (this.D) {
                i16 = R.color.cg6;
            } else {
                i16 = R.color.cg5;
            }
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(i16)), num.intValue(), num.intValue() + 1, 33);
        }
        if (this.D) {
            cVar.E.setTextColor(cVar.itemView.getResources().getColor(R.color.cg8));
            cVar.F.setTextColor(cVar.itemView.getResources().getColor(R.color.cgb));
            cVar.G.setBackgroundColor(cVar.itemView.getResources().getColor(R.color.cfk));
        } else {
            cVar.E.setTextColor(cVar.itemView.getResources().getColor(R.color.cg7));
            cVar.F.setTextColor(cVar.itemView.getResources().getColor(R.color.cga));
            cVar.G.setBackgroundColor(cVar.itemView.getResources().getColor(R.color.cfj));
        }
        cVar.E.setText(spannableString);
        int i17 = 0;
        cVar.F.setText(String.format(Locale.getDefault(), cVar.itemView.getResources().getString(R.string.f1369205g), Long.valueOf(jVar.f212667e), Long.valueOf(jVar.f212666d)));
        cVar.itemView.setOnClickListener(new a(jVar));
        View view = cVar.G;
        if (i3 == this.f213124m.size() - 1) {
            i17 = 4;
        }
        view.setVisibility(i17);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ec8, viewGroup, false));
    }

    public void n0(b bVar) {
        this.C = bVar;
    }

    public void o0(boolean z16) {
        this.D = z16;
    }

    public void setData(List<com.tencent.mobileqq.gamecenter.qa.model.j> list) {
        this.f213124m.clear();
        this.f213124m.addAll(list);
        notifyDataSetChanged();
    }
}
