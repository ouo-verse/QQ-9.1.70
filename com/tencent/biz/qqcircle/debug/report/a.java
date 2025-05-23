package com.tencent.biz.qqcircle.debug.report;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends RecyclerView.Adapter<C0866a> {

    /* renamed from: m, reason: collision with root package name */
    private final List<e> f84359m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.debug.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0866a extends RecyclerView.ViewHolder {
        public TextView E;
        public TextView F;

        public C0866a(@NonNull View view) {
            super(view);
            this.E = (TextView) view.findViewById(R.id.f52162_2);
            this.F = (TextView) view.findViewById(R.id.f54822g9);
        }

        public void l(e eVar) {
            long e16 = eVar.e();
            this.E.setText(h.a(R.string.f182753hb) + eVar.c() + "\uff0c" + h.a(R.string.f182763hc) + eVar.d() + "\uff0c" + h.a(R.string.f182743ha) + eVar.b());
            this.F.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(e16)));
        }
    }

    public void clearData() {
        this.f84359m.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f84359m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull C0866a c0866a, int i3) {
        if (i3 >= this.f84359m.size()) {
            return;
        }
        c0866a.l(this.f84359m.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public C0866a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new C0866a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gsz, viewGroup, false));
    }

    public void setData(List<e> list) {
        if (this.f84359m.size() >= 500) {
            this.f84359m.clear();
        }
        this.f84359m.addAll(list);
    }
}
