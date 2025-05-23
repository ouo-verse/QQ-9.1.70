package com.tencent.luggage.wxa.w0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.w0.a {

    /* renamed from: d, reason: collision with root package name */
    public List f143993d;

    /* renamed from: e, reason: collision with root package name */
    public List f143994e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.e1.b f143995f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.e1.c f143996g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f143997a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f1.b f143998b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f143999c;

        public a(boolean z16, com.tencent.luggage.wxa.f1.b bVar, int i3) {
            this.f143997a = z16;
            this.f143998b = bVar;
            this.f143999c = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean a16 = c.this.f143995f.a(this.f143997a);
            if (this.f143997a) {
                c.this.b(this.f143998b, this.f143999c);
            } else if (a16) {
                c.this.a(this.f143998b, this.f143999c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f1.b f144001a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f144002b;

        public b(com.tencent.luggage.wxa.f1.b bVar, int i3) {
            this.f144001a = bVar;
            this.f144002b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f143994e.add(this.f144001a);
            c.this.notifyItemChanged(this.f144002b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w0.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6859c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f1.b f144004a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f144005b;

        public RunnableC6859c(com.tencent.luggage.wxa.f1.b bVar, int i3) {
            this.f144004a = bVar;
            this.f144005b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f143994e.remove(this.f144004a);
            c.this.notifyItemChanged(this.f144005b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f143994e.clear();
            c.this.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f144008a;

        /* renamed from: b, reason: collision with root package name */
        public View f144009b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f144010c;

        /* renamed from: d, reason: collision with root package name */
        public View f144011d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f144012e;

        /* renamed from: f, reason: collision with root package name */
        public FrameLayout f144013f;

        public e(View view) {
            super(view);
            this.f144013f = (FrameLayout) view;
            this.f144008a = (ImageView) view.findViewById(R.id.xiw);
            this.f144009b = view.findViewById(R.id.f1185574g);
            this.f144010c = (TextView) view.findViewById(R.id.ur8);
            this.f144011d = view.findViewById(R.id.ur9);
            this.f144012e = (TextView) view.findViewById(R.id.ur_);
        }
    }

    public c(Context context, com.tencent.luggage.wxa.b1.b bVar, List list, com.tencent.luggage.wxa.e1.b bVar2) {
        super(context, bVar);
        this.f143993d = new ArrayList();
        this.f143994e = new ArrayList();
        this.f143995f = bVar2;
        if (list != null && !list.isEmpty()) {
            this.f143994e.addAll(list);
        }
    }

    public List d() {
        return this.f143994e;
    }

    public void e() {
        a(new d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f143993d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new e(c().inflate(R.layout.ffw, viewGroup, false));
    }

    public final void b(com.tencent.luggage.wxa.f1.b bVar, int i3) {
        a(new RunnableC6859c(bVar, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e eVar, int i3) {
        boolean z16;
        String str;
        com.tencent.luggage.wxa.f1.b bVar = (com.tencent.luggage.wxa.f1.b) this.f143993d.get(i3);
        boolean a16 = a(bVar);
        b().a(bVar.b(), eVar.f144008a, com.tencent.luggage.wxa.b1.c.GALLERY);
        boolean z17 = true;
        String str2 = "";
        if (com.tencent.luggage.wxa.d1.c.a(bVar)) {
            str = a().getResources().getString(R.string.f241477rz);
            z16 = true;
        } else {
            z16 = false;
            str = "";
        }
        eVar.f144010c.setText(str);
        eVar.f144010c.setVisibility(z16 ? 0 : 8);
        if (com.tencent.luggage.wxa.d1.c.b(bVar)) {
            str2 = new SimpleDateFormat("mm:ss").format(Long.valueOf(bVar.a()));
        } else {
            z17 = false;
        }
        eVar.f144011d.setVisibility(z17 ? 0 : 8);
        eVar.f144012e.setText(str2);
        eVar.f144012e.setVisibility(z17 ? 0 : 8);
        eVar.f144009b.setAlpha(a16 ? 0.5f : 0.0f);
        eVar.itemView.setOnClickListener(new a(a16, bVar, i3));
        eVar.f144013f.setForeground(a16 ? ContextCompat.getDrawable(a(), R.drawable.f162707of3) : null);
    }

    public final boolean a(com.tencent.luggage.wxa.f1.b bVar) {
        Iterator it = this.f143994e.iterator();
        while (it.hasNext()) {
            if (((com.tencent.luggage.wxa.f1.b) it.next()).b().equals(bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public void a(List list) {
        this.f143993d.clear();
        this.f143993d.addAll(list);
    }

    public final void a(com.tencent.luggage.wxa.f1.b bVar, int i3) {
        a(new b(bVar, i3));
    }

    public final void a(Runnable runnable) {
        runnable.run();
        com.tencent.luggage.wxa.e1.c cVar = this.f143996g;
        if (cVar != null) {
            cVar.a(this.f143994e);
        }
    }

    public void a(com.tencent.luggage.wxa.e1.c cVar) {
        this.f143996g = cVar;
    }
}
