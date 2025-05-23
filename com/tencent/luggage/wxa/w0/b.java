package com.tencent.luggage.wxa.w0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.w0.a {

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.e1.a f143986d;

    /* renamed from: e, reason: collision with root package name */
    public List f143987e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f1.a f143988a;

        public a(com.tencent.luggage.wxa.f1.a aVar) {
            this.f143988a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f143986d != null) {
                b.this.f143986d.a(this.f143988a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w0.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6858b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f143990a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f143991b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f143992c;

        public C6858b(View view) {
            super(view);
            this.f143990a = (ImageView) view.findViewById(R.id.image);
            this.f143991b = (TextView) view.findViewById(R.id.tv_name);
            this.f143992c = (TextView) view.findViewById(R.id.k9z);
        }
    }

    public b(Context context, com.tencent.luggage.wxa.b1.b bVar, com.tencent.luggage.wxa.e1.a aVar) {
        super(context, bVar);
        this.f143987e = new ArrayList();
        this.f143986d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f143987e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C6858b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new C6858b(c().inflate(R.layout.ffv, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C6858b c6858b, int i3) {
        com.tencent.luggage.wxa.f1.a aVar = (com.tencent.luggage.wxa.f1.a) this.f143987e.get(i3);
        b().a(((com.tencent.luggage.wxa.f1.b) aVar.b().get(0)).b(), c6858b.f143990a, com.tencent.luggage.wxa.b1.c.FOLDER);
        c6858b.f143991b.setText(((com.tencent.luggage.wxa.f1.a) this.f143987e.get(i3)).a());
        c6858b.f143992c.setText(String.valueOf(((com.tencent.luggage.wxa.f1.a) this.f143987e.get(i3)).b().size()));
        c6858b.itemView.setOnClickListener(new a(aVar));
    }

    public void a(List list) {
        if (list != null) {
            this.f143987e.clear();
            this.f143987e.addAll(list);
        }
        notifyDataSetChanged();
    }
}
