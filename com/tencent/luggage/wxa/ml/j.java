package com.tencent.luggage.wxa.ml;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.luggage.wxa.d5.a;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends RecyclerView.Adapter {

    /* renamed from: b, reason: collision with root package name */
    public static final c f134725b = new c(null);

    /* renamed from: a, reason: collision with root package name */
    public List f134726a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f134727a;

        /* renamed from: b, reason: collision with root package name */
        public String f134728b;

        /* renamed from: c, reason: collision with root package name */
        public String f134729c;

        /* renamed from: d, reason: collision with root package name */
        public final String f134730d;

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f134731e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f134732f;

        /* renamed from: g, reason: collision with root package name */
        public String f134733g;

        /* renamed from: h, reason: collision with root package name */
        public int f134734h;

        public a(int i3, String str, String str2, String str3, Bitmap bitmap, boolean z16, String iconUrl, int i16) {
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            this.f134727a = i3;
            this.f134728b = str;
            this.f134729c = str2;
            this.f134730d = str3;
            this.f134731e = bitmap;
            this.f134732f = z16;
            this.f134733g = iconUrl;
            this.f134734h = i16;
        }

        public final void a(boolean z16) {
            this.f134732f = z16;
        }

        public final boolean b() {
            return this.f134732f;
        }

        public final Bitmap c() {
            return this.f134731e;
        }

        public final String d() {
            return this.f134733g;
        }

        public final String e() {
            return this.f134730d;
        }

        public final String f() {
            return this.f134729c;
        }

        public final String g() {
            return this.f134728b;
        }

        public final int h() {
            return this.f134727a;
        }

        public final int a() {
            return this.f134734h;
        }

        public /* synthetic */ a(int i3, String str, String str2, String str3, Bitmap bitmap, boolean z16, String str4, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, str2, str3, bitmap, (i17 & 32) != 0 ? false : z16, (i17 & 64) != 0 ? "" : str4, (i17 & 128) != 0 ? 0 : i16);
        }

        public a(int i3, String str, String str2, boolean z16) {
            this(i3, str, "", str2, null, z16, "", 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends g {

        /* renamed from: d, reason: collision with root package name */
        public final ViewGroup f134735d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f134736e;

        /* renamed from: f, reason: collision with root package name */
        public final ImageView f134737f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public e(ViewGroup parent, List items, j itemAdapter) {
            super(r0, items, itemAdapter);
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dxl, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026list_item, parent, false)");
            this.f134735d = parent;
            View findViewById = b().findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
            this.f134736e = (TextView) findViewById;
            View findViewById2 = b().findViewById(R.id.ime);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.selected)");
            this.f134737f = (ImageView) findViewById2;
        }

        @Override // com.tencent.luggage.wxa.ml.j.g
        public void a(a item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.f134736e.setText(item.g());
        }

        @Override // com.tencent.luggage.wxa.ml.j.g
        public void a(boolean z16) {
            if (z16) {
                TextView textView = this.f134736e;
                textView.setContentDescription(textView.getText());
                this.f134737f.setVisibility(0);
                ImageView imageView = this.f134737f;
                imageView.setContentDescription(imageView.getContext().getString(R.string.z1i));
                return;
            }
            this.f134736e.setContentDescription(((Object) this.f134736e.getText()) + TokenParser.SP + this.f134737f.getContext().getString(R.string.z1k));
            this.f134737f.setVisibility(4);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class g extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public View f134744a;

        /* renamed from: b, reason: collision with root package name */
        public final List f134745b;

        /* renamed from: c, reason: collision with root package name */
        public final j f134746c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f134747a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f134748b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1 f134749c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f134750d;

            public a(a aVar, g gVar, Function1 function1, int i3) {
                this.f134747a = aVar;
                this.f134748b = gVar;
                this.f134749c = function1;
                this.f134750d = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z16;
                this.f134747a.a(true);
                this.f134748b.a(this.f134747a.b(), this.f134747a);
                ArrayList arrayList = new ArrayList();
                List a16 = this.f134748b.a();
                int i3 = this.f134750d;
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
                this.f134749c.invoke(arrayList);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements View.OnLongClickListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f134752b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f134753c;

            public b(a aVar, int i3) {
                this.f134752b = aVar;
                this.f134753c = i3;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                g.this.f134746c.c();
                return true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(View view, List items, j itemAdapter) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
            this.f134744a = view;
            this.f134745b = items;
            this.f134746c = itemAdapter;
        }

        public abstract void a(a aVar);

        public abstract void a(boolean z16);

        public final View b() {
            return this.f134744a;
        }

        public final List a() {
            return this.f134745b;
        }

        public final void a(a item, int i3, Function1 checkStateChange) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(checkStateChange, "checkStateChange");
            a(item);
            a(item.b(), item);
            this.f134744a.setOnClickListener(new a(item, this, checkStateChange, i3));
            this.f134744a.setOnLongClickListener(new b(item, i3));
        }

        public final void a(boolean z16, a aVar) {
            if (this.f134745b.size() == 1) {
                a(true);
                if (z16) {
                    this.f134746c.a();
                    return;
                }
                return;
            }
            if (z16) {
                this.f134746c.a();
                a(true);
            } else {
                a(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function1 {
        public h() {
            super(1);
        }

        public final void a(ArrayList changed) {
            Intrinsics.checkNotNullParameter(changed, "changed");
            j jVar = j.this;
            Iterator it = changed.iterator();
            while (it.hasNext()) {
                jVar.notifyItemChanged(((Number) it.next()).intValue());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((ArrayList) obj);
            return Unit.INSTANCE;
        }
    }

    public j(List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f134726a = items;
    }

    public final b a() {
        return null;
    }

    public final List b() {
        return this.f134726a;
    }

    public final d c() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f134726a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        a aVar = (a) this.f134726a.get(i3);
        if (aVar != null) {
            return aVar.h();
        }
        return 0;
    }

    public final void a(b bVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i3 == 1) {
            return new e(parent, this.f134726a, this);
        }
        return new f(parent, this.f134726a, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(g holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        a aVar = (a) this.f134726a.get(i3);
        if (aVar != null) {
            holder.a(aVar, i3, new h());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends g {

        /* renamed from: d, reason: collision with root package name */
        public final ViewGroup f134738d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f134739e;

        /* renamed from: f, reason: collision with root package name */
        public final TextView f134740f;

        /* renamed from: g, reason: collision with root package name */
        public final TextView f134741g;

        /* renamed from: h, reason: collision with root package name */
        public final ImageView f134742h;

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
                Bitmap a16 = com.tencent.luggage.wxa.tn.d.a(bitmap, false, com.tencent.luggage.wxa.kn.a.a(f.this.b().getContext(), 4) * 1.0f, false);
                Intrinsics.checkNotNullExpressionValue(a16, "getRoundedCornerBitmap(b\u2026ontext, 4) * 1.0f, false)");
                return a16;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f(ViewGroup parent, List items, j itemAdapter) {
            super(r0, items, itemAdapter);
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(itemAdapter, "itemAdapter");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167649dy2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026list_item, parent, false)");
            this.f134738d = parent;
            View findViewById = b().findViewById(R.id.icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.icon)");
            this.f134739e = (ImageView) findViewById;
            View findViewById2 = b().findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
            this.f134740f = (TextView) findViewById2;
            View findViewById3 = b().findViewById(R.id.f166931j64);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.sub_title)");
            TextView textView = (TextView) findViewById3;
            this.f134741g = textView;
            View findViewById4 = b().findViewById(R.id.ime);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.selected)");
            this.f134742h = (ImageView) findViewById4;
            b().setImportantForAccessibility(1);
            textView.setImportantForAccessibility(2);
        }

        @Override // com.tencent.luggage.wxa.ml.j.g
        public void a(a item) {
            Intrinsics.checkNotNullParameter(item, "item");
            Drawable H = a.C6131a.a().H();
            if (H != null) {
                this.f134739e.setImageDrawable(H);
            } else {
                H = null;
            }
            if (H == null) {
                this.f134739e.setImageDrawable(null);
            }
            TextView textView = this.f134740f;
            CharSequence a16 = com.tencent.luggage.wxa.ql.a.a().a(this.f134740f.getContext(), item.g(), this.f134740f.getTextSize());
            if (a16 == null) {
                a16 = "";
            }
            textView.setText(a16);
            if (!TextUtils.isEmpty(item.f())) {
                this.f134741g.setVisibility(0);
                TextView textView2 = this.f134741g;
                String f16 = item.f();
                textView2.setText(f16 != null ? f16 : "");
            } else {
                this.f134741g.setVisibility(8);
            }
            if (item.c() != null) {
                Bitmap a17 = com.tencent.luggage.wxa.tn.d.a(item.c(), false, com.tencent.luggage.wxa.kn.a.a(b().getContext(), 4) * 1.0f, false);
                if (a17 != null) {
                    this.f134739e.setImageBitmap(a17);
                    return;
                }
                Drawable H2 = a.C6131a.a().H();
                if (H2 != null) {
                    this.f134739e.setImageDrawable(H2);
                } else {
                    H2 = null;
                }
                if (H2 == null) {
                    this.f134739e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (item.d().length() > 0) {
                AppBrandSimpleImageLoader.instance().attach(this.f134739e, item.d(), (Drawable) null, new a());
            }
        }

        @Override // com.tencent.luggage.wxa.ml.j.g
        public void a(boolean z16) {
            if (z16) {
                TextView textView = this.f134740f;
                textView.setContentDescription(textView.getText());
                this.f134742h.setVisibility(0);
                ImageView imageView = this.f134742h;
                imageView.setContentDescription(imageView.getContext().getString(R.string.z1i));
                return;
            }
            this.f134740f.setContentDescription(((Object) this.f134740f.getText()) + TokenParser.SP + this.f134742h.getContext().getString(R.string.z1k));
            this.f134742h.setVisibility(4);
        }
    }
}
