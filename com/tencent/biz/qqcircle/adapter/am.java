package com.tencent.biz.qqcircle.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class am extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private final List<String> f82634m = new ArrayList();
    private final List<String> C = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView E;
        public String F;
        public int G;

        public a(@NonNull View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.f52162_2);
            this.E = textView;
            textView.setOnClickListener(this);
        }

        public void l(String str, String str2, int i3) {
            this.E.setText(str);
            this.F = str2;
            this.G = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.f52162_2) {
                QCircleInitBean qCircleInitBean = new QCircleInitBean();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.F);
                com.tencent.biz.qqcircle.launcher.c.w0(view.getContext(), arrayList, qCircleInitBean);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public void clearData() {
        this.f82634m.clear();
        this.C.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f82634m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        if (i3 >= this.f82634m.size()) {
            return;
        }
        aVar.l(this.f82634m.get(i3), this.C.get(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gqg, viewGroup, false));
    }

    public void k0(String str, String str2) {
        if (this.f82634m.size() >= 500) {
            this.f82634m.clear();
            this.C.clear();
        }
        this.f82634m.add(str);
        this.C.add(str2);
    }
}
