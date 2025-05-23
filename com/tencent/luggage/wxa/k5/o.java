package com.tencent.luggage.wxa.k5;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public List f131602a;

    /* renamed from: b, reason: collision with root package name */
    public b f131603b;

    /* renamed from: c, reason: collision with root package name */
    public c f131604c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f131605a;

        /* renamed from: b, reason: collision with root package name */
        public final String f131606b;

        /* renamed from: c, reason: collision with root package name */
        public final String f131607c;

        /* renamed from: d, reason: collision with root package name */
        public Bitmap f131608d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f131609e;

        /* renamed from: f, reason: collision with root package name */
        public String f131610f;

        /* renamed from: g, reason: collision with root package name */
        public int f131611g;

        public a(String str, String str2, String str3, Bitmap bitmap, boolean z16, String iconUrl, int i3) {
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            this.f131605a = str;
            this.f131606b = str2;
            this.f131607c = str3;
            this.f131608d = bitmap;
            this.f131609e = z16;
            this.f131610f = iconUrl;
            this.f131611g = i3;
        }

        public final int a() {
            return this.f131611g;
        }

        public final boolean b() {
            return this.f131609e;
        }

        public final Bitmap c() {
            return this.f131608d;
        }

        public final String d() {
            return this.f131610f;
        }

        public final String e() {
            return this.f131606b;
        }

        public final String f() {
            return this.f131605a;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, String str3, boolean z16, String iconUrl, int i3) {
            this(str, str2, str3, null, z16, iconUrl, i3);
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        }

        public final void a(boolean z16) {
            this.f131609e = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(View view, a aVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public View f131612a;

        /* renamed from: b, reason: collision with root package name */
        public final List f131613b;

        /* renamed from: c, reason: collision with root package name */
        public final o f131614c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f131615d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f131616e;

        /* renamed from: f, reason: collision with root package name */
        public final TextView f131617f;

        /* renamed from: g, reason: collision with root package name */
        public final ImageView f131618g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements AppBrandSimpleImageLoader.j {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.pb.a
            public String b() {
                return "appbrand_user_avatar";
            }

            @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.j
            public Bitmap b(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                Bitmap a16 = com.tencent.luggage.wxa.tn.d.a(bitmap, false, com.tencent.luggage.wxa.kn.a.a(d.this.b().getContext(), 4) * 1.0f, false);
                Intrinsics.checkNotNullExpressionValue(a16, "getRoundedCornerBitmap(b\u2026ontext, 4) * 1.0f, false)");
                return a16;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f131620a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f131621b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1 f131622c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f131623d;

            public b(a aVar, d dVar, Function1 function1, int i3) {
                this.f131620a = aVar;
                this.f131621b = dVar;
                this.f131622c = function1;
                this.f131623d = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                this.f131620a.a(true);
                this.f131621b.a(this.f131620a.b(), this.f131620a);
                ArrayList arrayList = new ArrayList();
                List a16 = this.f131621b.a();
                int i3 = this.f131623d;
                int i16 = 0;
                for (Object obj : a16) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    a aVar = (a) obj;
                    arrayList.add(Integer.valueOf(i16));
                    if (i3 != i16) {
                        if (aVar != null && aVar.b()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            aVar.a(false);
                            arrayList.add(Integer.valueOf(i3));
                        }
                    }
                    i16 = i17;
                }
                this.f131622c.invoke(arrayList);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements View.OnLongClickListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f131625b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f131626c;

            public c(a aVar, int i3) {
                this.f131625b = aVar;
                this.f131626c = i3;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                c b16 = d.this.f131614c.b();
                if (b16 != null) {
                    b16.a(d.this.b(), this.f131625b, this.f131626c);
                    return true;
                }
                return true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View view, List items, o itemAdapter) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
            this.f131612a = view;
            this.f131613b = items;
            this.f131614c = itemAdapter;
            View findViewById = view.findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.te\u2026echat_full_sdk.R.id.icon)");
            this.f131615d = (ImageView) findViewById;
            View findViewById2 = this.f131612a.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(com.te\u2026chat_full_sdk.R.id.title)");
            this.f131616e = (TextView) findViewById2;
            View findViewById3 = this.f131612a.findViewById(R.id.f166931j64);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(com.te\u2026_full_sdk.R.id.sub_title)");
            this.f131617f = (TextView) findViewById3;
            View findViewById4 = this.f131612a.findViewById(R.id.ime);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(com.te\u2026t_full_sdk.R.id.selected)");
            this.f131618g = (ImageView) findViewById4;
        }

        public final View b() {
            return this.f131612a;
        }

        public final List a() {
            return this.f131613b;
        }

        public final void a(a item, int i3, Function1 checkStateChange) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(checkStateChange, "checkStateChange");
            this.f131615d.setImageResource(R.drawable.jkj);
            TextView textView = this.f131616e;
            CharSequence a16 = com.tencent.luggage.wxa.ql.a.a().a(this.f131616e.getContext(), item.f(), this.f131616e.getTextSize());
            if (a16 == null) {
                a16 = "";
            }
            textView.setText(a16);
            if (!TextUtils.isEmpty(item.e())) {
                this.f131617f.setVisibility(0);
                TextView textView2 = this.f131617f;
                String e16 = item.e();
                textView2.setText(e16 != null ? e16 : "");
            } else {
                this.f131617f.setVisibility(8);
            }
            a(item.b(), item);
            if (item.c() != null) {
                Bitmap a17 = com.tencent.luggage.wxa.tn.d.a(item.c(), false, com.tencent.luggage.wxa.kn.a.a(this.f131612a.getContext(), 4) * 1.0f, false);
                if (a17 != null) {
                    this.f131615d.setImageBitmap(a17);
                } else {
                    this.f131615d.setImageResource(R.drawable.jkj);
                }
            } else {
                if (item.d().length() > 0) {
                    AppBrandSimpleImageLoader.instance().attach(this.f131615d, item.d(), R.drawable.jkj, new a());
                }
            }
            this.f131612a.setOnClickListener(new b(item, this, checkStateChange, i3));
            this.f131612a.setOnLongClickListener(new c(item, i3));
        }

        public final void a(boolean z16, a aVar) {
            b a16;
            if (this.f131613b.size() == 1) {
                this.f131618g.setVisibility(0);
                if (!z16 || (a16 = this.f131614c.a()) == null) {
                    return;
                }
                a16.a(aVar);
                return;
            }
            if (z16) {
                b a17 = this.f131614c.a();
                if (a17 != null) {
                    a17.a(aVar);
                }
                this.f131618g.setVisibility(0);
                return;
            }
            this.f131618g.setVisibility(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function1 {
        public e() {
            super(1);
        }

        public final void a(ArrayList changed) {
            Intrinsics.checkNotNullParameter(changed, "changed");
            o oVar = o.this;
            Iterator it = changed.iterator();
            while (it.hasNext()) {
                oVar.notifyItemChanged(((Number) it.next()).intValue());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((ArrayList) obj);
            return Unit.INSTANCE;
        }
    }

    public o(List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f131602a = items;
    }

    public final b a() {
        return this.f131603b;
    }

    public final c b() {
        return this.f131604c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f131602a.size();
    }

    public final void a(b bVar) {
        this.f131603b = bVar;
    }

    public final void a(c cVar) {
        this.f131604c = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View v3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167649dy2, parent, false);
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        return new d(v3, this.f131602a, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        a aVar = (a) this.f131602a.get(i3);
        if (aVar != null) {
            holder.a(aVar, i3, new e());
        }
    }
}
