package com.tencent.luggage.wxa.f5;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends RecyclerView.Adapter {

    /* renamed from: e, reason: collision with root package name */
    public static final b f125283e = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f125284a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC6192a f125285b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f125286c;

    /* renamed from: d, reason: collision with root package name */
    public String f125287d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6192a {
        void a(com.tencent.luggage.wxa.sb.d dVar, boolean z16);

        boolean a(com.tencent.luggage.wxa.sb.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public CheckBox f125288a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f125289b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f125290c;

        /* renamed from: d, reason: collision with root package name */
        public View f125291d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f125288a = (CheckBox) view.findViewById(R.id.axa);
            this.f125289b = (TextView) view.findViewById(R.id.f904652j);
            this.f125290c = (ImageView) view.findViewById(R.id.f904352g);
            this.f125291d = view.findViewById(R.id.jtk);
        }

        public final CheckBox a() {
            return this.f125288a;
        }

        public final ImageView b() {
            return this.f125290c;
        }

        public final TextView c() {
            return this.f125289b;
        }

        public final View d() {
            return this.f125291d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.sb.d f125293b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f5.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class DialogInterfaceOnCancelListenerC6193a implements DialogInterface.OnCancelListener {

            /* renamed from: a, reason: collision with root package name */
            public static final DialogInterfaceOnCancelListenerC6193a f125294a = new DialogInterfaceOnCancelListenerC6193a();

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        }

        public d(com.tencent.luggage.wxa.sb.d dVar) {
            this.f125293b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View a16 = com.tencent.luggage.wxa.wb.c.f144167a.a(a.this.f125284a, this.f125293b.d(), a.this.f125284a.getResources().getDimensionPixelSize(R.dimen.bp8));
            MMAlertDialog.Builder builder = new MMAlertDialog.Builder(a.this.f125284a);
            a aVar = a.this;
            builder.setTitle(aVar.a());
            builder.setPositiveBtnText(aVar.f125284a.getString(R.string.f170383z25));
            builder.setView(a16);
            builder.setCancelable(false);
            builder.setOnCancelListener(DialogInterfaceOnCancelListenerC6193a.f125294a);
            builder.show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f125295a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f125296b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.sb.d f125297c;

        public e(c cVar, a aVar, com.tencent.luggage.wxa.sb.d dVar) {
            this.f125295a = cVar;
            this.f125296b = aVar;
            this.f125297c = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f125295a.a().setChecked(!this.f125295a.a().isChecked());
            this.f125296b.f125285b.a(this.f125297c, this.f125295a.a().isChecked());
        }
    }

    public a(Context context, InterfaceC6192a listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f125284a = context;
        this.f125285b = listener;
        this.f125286c = new ArrayList();
        this.f125287d = "";
    }

    public final void c(c cVar, com.tencent.luggage.wxa.sb.d dVar, int i3) {
        int i16;
        View d16 = cVar.d();
        if (i3 == 0) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        d16.setVisibility(i16);
        cVar.c().setText(dVar.i());
        b(cVar, dVar, i3);
        a(cVar, dVar, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f125286c.size();
    }

    public final String a() {
        return this.f125287d;
    }

    public final void b(c cVar, com.tencent.luggage.wxa.sb.d dVar, int i3) {
        cVar.a().setChecked(this.f125285b.a(dVar));
        cVar.itemView.setOnClickListener(new e(cVar, this, dVar));
    }

    public final void a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f125287d = value;
    }

    public final void a(ArrayList list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f125286c.clear();
        this.f125286c.addAll(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(this.f125284a).inflate(R.layout.hrd, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new c(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.luggage.wxa.sb.d a16 = a(i3);
        if (a16 == null) {
            return;
        }
        w.d("Mp.SubscribeMsgListAdapter", "alvinluo onBindViewHolder item: %s", a16.toString());
        c(holder, a16, i3);
    }

    public final void a(c cVar, com.tencent.luggage.wxa.sb.d dVar, int i3) {
        cVar.b().setOnClickListener(new d(dVar));
    }

    public final com.tencent.luggage.wxa.sb.d a(int i3) {
        if (i3 < 0 || i3 >= this.f125286c.size()) {
            return null;
        }
        return (com.tencent.luggage.wxa.sb.d) this.f125286c.get(i3);
    }
}
