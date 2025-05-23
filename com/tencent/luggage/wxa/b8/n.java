package com.tencent.luggage.wxa.b8;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.ic.z;
import com.tencent.luggage.wxa.jl.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.y0;
import com.tencent.mm.ui.widget.dialog.CustomSheetDialog;
import com.tencent.mobileqq.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final b L = new b(null);
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public Function0 G;
    public Function0 H;
    public Function2 I;
    public Function1 J;
    public final d K;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f122036a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f122037b;

    /* renamed from: c, reason: collision with root package name */
    public final l f122038c;

    /* renamed from: d, reason: collision with root package name */
    public Dialog f122039d;

    /* renamed from: e, reason: collision with root package name */
    public Context f122040e;

    /* renamed from: f, reason: collision with root package name */
    public View f122041f;

    /* renamed from: g, reason: collision with root package name */
    public c f122042g;

    /* renamed from: h, reason: collision with root package name */
    public int f122043h;

    /* renamed from: i, reason: collision with root package name */
    public BottomSheetBehavior f122044i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f122045j;

    /* renamed from: k, reason: collision with root package name */
    public int f122046k;

    /* renamed from: l, reason: collision with root package name */
    public View f122047l;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver f122048m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.b8.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6039a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f122050a;

            public RunnableC6039a(n nVar) {
                this.f122050a = nVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f122050a.h();
            }
        }

        public a() {
            super(0);
        }

        public final void a() {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new RunnableC6039a(n.this));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
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
    public final class c extends RecyclerView.Adapter {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public final class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f122052a;

            /* renamed from: b, reason: collision with root package name */
            public FrameLayout f122053b;

            /* renamed from: c, reason: collision with root package name */
            public ProgressBar f122054c;

            /* renamed from: d, reason: collision with root package name */
            public ImageView f122055d;

            /* renamed from: e, reason: collision with root package name */
            public final TextView f122056e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ c f122057f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f122057f = cVar;
                View findViewById = itemView.findViewById(R.id.f107336a5);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_device_name)");
                TextView textView = (TextView) findViewById;
                this.f122052a = textView;
                View findViewById2 = itemView.findViewById(R.id.v7t);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.fl_device_item)");
                this.f122053b = (FrameLayout) findViewById2;
                View findViewById3 = itemView.findViewById(R.id.f234706i);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.pb_device_connecting)");
                this.f122054c = (ProgressBar) findViewById3;
                View findViewById4 = itemView.findViewById(R.id.y1u);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.iv_connected)");
                this.f122055d = (ImageView) findViewById4;
                View findViewById5 = itemView.findViewById(R.id.f1065268y);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_cast_fail)");
                TextView textView2 = (TextView) findViewById5;
                this.f122056e = textView2;
                this.f122055d.setImageResource(R.raw.f169304c0);
                com.tencent.luggage.wxa.jl.c.f131190l.a(itemView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
                ViewCompat.setImportantForAccessibility(textView, 1);
                ViewCompat.setImportantForAccessibility(textView2, 1);
            }

            public final TextView a() {
                return this.f122056e;
            }

            public final ImageView b() {
                return this.f122055d;
            }

            public final ProgressBar c() {
                return this.f122054c;
            }

            public final TextView d() {
                return this.f122052a;
            }

            public final FrameLayout e() {
                return this.f122053b;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public final class b extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f122058a;

            /* renamed from: b, reason: collision with root package name */
            public ProgressBar f122059b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f122060c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(c cVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f122060c = cVar;
                View findViewById = itemView.findViewById(R.id.f111086k_);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_select_device_title)");
                TextView textView = (TextView) findViewById;
                this.f122058a = textView;
                View findViewById2 = itemView.findViewById(R.id.f234806j);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.pb_device_search)");
                this.f122059b = (ProgressBar) findViewById2;
                com.tencent.luggage.wxa.jl.c.f131190l.a(itemView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
                ViewCompat.setImportantForAccessibility(textView, 1);
            }

            public final TextView a() {
                return this.f122058a;
            }

            public final ProgressBar b() {
                return this.f122059b;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.b8.n$c$c, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class ViewOnClickListenerC6040c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ n f122061a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f122062b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f122063c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f122064d;

            public ViewOnClickListenerC6040c(n nVar, int i3, c cVar, int i16) {
                this.f122061a = nVar;
                this.f122062b = i3;
                this.f122063c = cVar;
                this.f122064d = i16;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.f122061a.a() != null) {
                    if (!(!this.f122061a.f122038c.g().isEmpty()) || this.f122062b > this.f122061a.f122038c.g().size()) {
                        this.f122061a.a(this.f122063c.a(this.f122062b).a(), this.f122064d);
                    } else {
                        this.f122061a.a(this.f122063c.a(this.f122062b).a(), this.f122064d);
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f122065a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ n f122066b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f122067c;

            public d(b bVar, n nVar, c cVar) {
                this.f122065a = bVar;
                this.f122066b = nVar;
                this.f122067c = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String b16;
                this.f122065a.b().setVisibility(8);
                TextView a16 = this.f122065a.a();
                if (this.f122066b.e()) {
                    b16 = this.f122067c.b(R.string.z1x);
                } else {
                    b16 = this.f122066b.f122038c.h().isEmpty() ? this.f122067c.b(R.string.z1v) : this.f122067c.b(R.string.z1u);
                }
                a16.setText(b16);
            }
        }

        public c() {
        }

        public final String c(com.tencent.luggage.wxa.bi.e eVar) {
            String b16 = b(eVar);
            if (w0.c(b16)) {
                return a(eVar);
            }
            return b16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size;
            if (n.this.e()) {
                size = n.this.f122038c.g().size() + n.this.f122038c.h().size() + 2;
            } else {
                size = n.this.f122038c.h().size() + n.this.f122038c.g().size() + 1;
            }
            w.a("MicroMsg.MediaCastSelectDeviceBottomSheet", "item count = " + size);
            return size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (i3 == 0 && n.this.e()) {
                return 1;
            }
            if (i3 == 0 || (n.this.e() && i3 == n.this.f122038c.g().size() + 1)) {
                return 2;
            }
            return 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType == 3) {
                        a((a) viewHolder, i3);
                        return;
                    }
                    return;
                }
                b((b) viewHolder);
                return;
            }
            a((b) viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i3 == 3) {
                View itemView = LayoutInflater.from(n.this.f122040e).inflate(R.layout.fdj, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                return new a(this, itemView);
            }
            View itemView2 = LayoutInflater.from(n.this.f122040e).inflate(R.layout.ffr, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            return new b(this, itemView2);
        }

        public final void a(b bVar) {
            bVar.b().setVisibility(8);
            if (n.this.e()) {
                bVar.a().setText("\u6700\u8fd1\u8fde\u63a5");
            } else {
                bVar.a().setVisibility(8);
            }
        }

        public final String b(com.tencent.luggage.wxa.bi.e eVar) {
            com.tencent.luggage.wxa.md.b c16 = eVar.a().c();
            Intrinsics.checkNotNull(c16);
            String str = c16.f134427g;
            Intrinsics.checkNotNullExpressionValue(str, "device.mrDevice.dlnaDevice!!.friendlyName");
            return str;
        }

        public final String b(int i3) {
            Context context = n.this.f122040e;
            if (context == null) {
                return "";
            }
            String string = context.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(id)");
            return string;
        }

        public final void b(b bVar) {
            String b16;
            TextView a16 = bVar.a();
            if (n.this.e()) {
                b16 = b(R.string.z1w);
            } else {
                b16 = b(R.string.z1u);
            }
            a16.setText(b16);
            com.tencent.luggage.wxa.zp.h.f146825d.c(new d(bVar, n.this, this), 10000L);
        }

        public final void a(a aVar, int i3) {
            int i16 = i3 - 1;
            aVar.e().setOnClickListener(new ViewOnClickListenerC6040c(n.this, i16, this, i3));
            com.tencent.luggage.wxa.bi.e a16 = a(i16);
            w.a("MicroMsg.MediaCastSelectDeviceBottomSheet", "bindDeviceViewHolder: " + a16);
            aVar.d().setText(c(a16));
            if (!n.this.f122037b) {
                aVar.c().setVisibility(8);
                aVar.b().setVisibility(8);
                aVar.a().setVisibility(8);
                return;
            }
            if (a16.c() && a16.d() && !a16.b()) {
                aVar.c().setVisibility(0);
                aVar.a().setVisibility(8);
                aVar.b().setVisibility(8);
                return;
            }
            if (!a16.c() && a16.b() && a16.d()) {
                aVar.c().setVisibility(8);
                aVar.a().setVisibility(8);
                aVar.b().setVisibility(0);
            } else if (!a16.b() && a16.d()) {
                aVar.c().setVisibility(8);
                aVar.a().setVisibility(8);
                aVar.b().setVisibility(0);
            } else {
                if (a16.d()) {
                    return;
                }
                aVar.c().setVisibility(8);
                aVar.a().setVisibility(8);
                aVar.b().setVisibility(8);
            }
        }

        public final com.tencent.luggage.wxa.bi.e a(int i3) {
            if (!(!n.this.f122038c.g().isEmpty()) || i3 > n.this.f122038c.g().size()) {
                com.tencent.luggage.wxa.bi.e eVar = n.this.f122038c.g().isEmpty() ^ true ? (com.tencent.luggage.wxa.bi.e) n.this.f122038c.h().get((i3 - n.this.f122038c.g().size()) - 1) : (com.tencent.luggage.wxa.bi.e) n.this.f122038c.h().get(i3);
                Intrinsics.checkNotNullExpressionValue(eVar, "{\n                if (de\u2026          }\n            }");
                return eVar;
            }
            Object obj = n.this.f122038c.g().get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "{\n                device\u2026bFistTitle]\n            }");
            return (com.tencent.luggage.wxa.bi.e) obj;
        }

        public final String a(com.tencent.luggage.wxa.bi.e eVar) {
            com.tencent.luggage.wxa.md.b c16 = eVar.a().c();
            Intrinsics.checkNotNull(c16);
            String str = c16.f134429i;
            Intrinsics.checkNotNullExpressionValue(str, "device.mrDevice.dlnaDevice!!.modeName");
            return str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends z {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (1 != event.getAction()) {
                n.this.a((com.tencent.luggage.wxa.md.c) null, 0);
                n.this.j();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f122070b;

        public e(Context context) {
            this.f122070b = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("https://");
            sb5.append(y0.a(R.string.f159091rd));
            sb5.append("/mp/readtemplate?t=weapp/airplay_intro_tmpl&appid=");
            com.tencent.luggage.wxa.ic.g gVar = n.this.f122036a;
            if (gVar != null) {
                str = gVar.getAppId();
            } else {
                str = null;
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            com.tencent.luggage.wxa.bi.b bVar = (com.tencent.luggage.wxa.bi.b) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bi.b.class);
            if (bVar != null) {
                bVar.a(sb6, this.f122070b);
            }
            Function0 b16 = n.this.b();
            if (b16 != null) {
                b16.invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = n.this.G;
            if (function0 != null) {
                function0.invoke();
            }
            n.this.a((com.tencent.luggage.wxa.md.c) null, 0);
            n.this.j();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements DialogInterface.OnCancelListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            n.this.a((com.tencent.luggage.wxa.md.c) null, 0);
            com.tencent.luggage.wxa.ic.g gVar = n.this.f122036a;
            if (gVar != null) {
                gVar.a((z) n.this.K);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements DialogInterface.OnDismissListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (n.this.f122048m != null) {
                ViewTreeObserver viewTreeObserver = n.this.f122048m;
                Intrinsics.checkNotNull(viewTreeObserver);
                if (!viewTreeObserver.isAlive()) {
                    n nVar = n.this;
                    View view = nVar.f122047l;
                    Intrinsics.checkNotNull(view);
                    nVar.f122048m = view.getViewTreeObserver();
                }
                ViewTreeObserver viewTreeObserver2 = n.this.f122048m;
                Intrinsics.checkNotNull(viewTreeObserver2);
                viewTreeObserver2.removeOnGlobalLayoutListener(n.this);
                n.this.f122048m = null;
            }
            n.this.f122038c.i().clear();
            n.this.c().invoke(Integer.valueOf(n.this.f122038c.g().size() + n.this.f122038c.h().size()));
        }
    }

    public n(Context context, com.tencent.luggage.wxa.ic.g gVar, boolean z16, boolean z17, l deviceManager) {
        Intrinsics.checkNotNullParameter(deviceManager, "deviceManager");
        this.f122036a = gVar;
        this.f122037b = z17;
        this.f122038c = deviceManager;
        this.f122040e = context;
        this.D = true;
        this.E = z16;
        this.J = i.f122074a;
        d dVar = new d();
        this.K = dVar;
        Context context2 = this.f122040e;
        if (context2 instanceof Activity) {
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            View decorView = ((Activity) context2).getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.f122047l = ((ViewGroup) decorView).findViewById(android.R.id.content);
        }
        a(this.f122040e);
        if (gVar != null) {
            gVar.a(4, -1, dVar);
        }
        deviceManager.a(new a());
    }

    public final void j() {
        if (this.f122039d != null) {
            BottomSheetBehavior bottomSheetBehavior = this.f122044i;
            if (bottomSheetBehavior != null) {
                Intrinsics.checkNotNull(bottomSheetBehavior);
                bottomSheetBehavior.setHideable(true);
            }
            Context context = this.f122040e;
            if (context != null && (context instanceof Activity)) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (!((Activity) context).isFinishing()) {
                    Dialog dialog = this.f122039d;
                    if (dialog == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                        dialog = null;
                    }
                    dialog.dismiss();
                }
            }
        }
        com.tencent.luggage.wxa.ic.g gVar = this.f122036a;
        if (gVar != null) {
            gVar.a((z) this.K);
        }
    }

    public final void k() {
        View view;
        View view2;
        this.f122045j = f();
        this.f122046k = d();
        if (this.f122039d != null) {
            i();
            Dialog dialog = this.f122039d;
            Dialog dialog2 = null;
            if (dialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                dialog = null;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            if (this.C) {
                Dialog dialog3 = this.f122039d;
                if (dialog3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog3 = null;
                }
                Window window2 = dialog3.getWindow();
                if (window2 != null) {
                    window2.addFlags(1024);
                }
            }
            boolean z16 = false;
            if (!com.tencent.luggage.wxa.uk.b.f142651b.isEnable() && this.D) {
                Dialog dialog4 = this.f122039d;
                if (dialog4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog4 = null;
                }
                Window window3 = dialog4.getWindow();
                if (window3 != null) {
                    window3.setFlags(8, 8);
                }
                Dialog dialog5 = this.f122039d;
                if (dialog5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog5 = null;
                }
                Window window4 = dialog5.getWindow();
                if (window4 != null) {
                    window4.addFlags(131200);
                }
                Dialog dialog6 = this.f122039d;
                if (dialog6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog6 = null;
                }
                Window window5 = dialog6.getWindow();
                if (window5 != null) {
                    view2 = window5.getDecorView();
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    view2.setSystemUiVisibility(6);
                }
            } else {
                Dialog dialog7 = this.f122039d;
                if (dialog7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog7 = null;
                }
                Window window6 = dialog7.getWindow();
                if (window6 != null) {
                    window6.clearFlags(8);
                }
                Dialog dialog8 = this.f122039d;
                if (dialog8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog8 = null;
                }
                Window window7 = dialog8.getWindow();
                if (window7 != null) {
                    window7.clearFlags(131072);
                }
                Dialog dialog9 = this.f122039d;
                if (dialog9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog9 = null;
                }
                Window window8 = dialog9.getWindow();
                if (window8 != null) {
                    window8.clearFlags(128);
                }
                Dialog dialog10 = this.f122039d;
                if (dialog10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog10 = null;
                }
                Window window9 = dialog10.getWindow();
                if (window9 != null) {
                    view = window9.getDecorView();
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setSystemUiVisibility(0);
                }
            }
            BottomSheetBehavior bottomSheetBehavior = this.f122044i;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(false);
            }
            View view3 = this.f122047l;
            if (view3 != null) {
                if (this.f122048m == null) {
                    z16 = true;
                }
                Intrinsics.checkNotNull(view3);
                ViewTreeObserver viewTreeObserver = view3.getViewTreeObserver();
                this.f122048m = viewTreeObserver;
                if (z16) {
                    Intrinsics.checkNotNull(viewTreeObserver);
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                }
            }
            Context context = this.f122040e;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (!((Activity) context).isFinishing()) {
                    Dialog dialog11 = this.f122039d;
                    if (dialog11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    } else {
                        dialog2 = dialog11;
                    }
                    dialog2.show();
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (g()) {
            View view = this.f122047l;
            if (view != null && (view.isShown() || view.getVisibility() == 0)) {
                if (g()) {
                    if (this.f122045j != f() || this.f122046k != d()) {
                        j();
                        return;
                    }
                    return;
                }
                return;
            }
            j();
        }
    }

    public final Function0 b() {
        return this.H;
    }

    public final Function1 c() {
        return this.J;
    }

    public final int d() {
        Context context = this.f122040e;
        if (!(context instanceof Activity)) {
            return 0;
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        return ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }

    public final boolean e() {
        return !this.f122038c.g().isEmpty();
    }

    public final boolean f() {
        Context context = this.f122040e;
        Intrinsics.checkNotNull(context);
        return context.getResources().getConfiguration().orientation == 2;
    }

    public final boolean g() {
        Dialog dialog = this.f122039d;
        return dialog != null && dialog.isShowing();
    }

    public final void h() {
        if (g() && this.f122039d != null) {
            c cVar = this.f122042g;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleViewAdapter");
                cVar = null;
            }
            cVar.notifyDataSetChanged();
        }
    }

    public final void i() {
        View view = this.f122041f;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.E) {
            this.f122043h = (int) (com.tencent.luggage.wxa.lo.o.c(this.f122040e, R.dimen.c5t) * 6.5d);
        }
        layoutParams2.height = this.f122043h;
        if (this.f122045j && this.f122047l != null) {
            Rect rect = new Rect();
            View view3 = this.f122047l;
            Intrinsics.checkNotNull(view3);
            view3.getWindowVisibleDisplayFrame(rect);
            if (this.E) {
                layoutParams2.width = (int) (((rect.right * 1.0f) * 4) / 10);
                int i3 = this.F;
                if (i3 != 0) {
                    layoutParams2.width = i3;
                }
                if (com.tencent.luggage.wxa.lo.q.g(this.f122040e)) {
                    layoutParams2.height = rect.bottom - com.tencent.luggage.wxa.lo.q.f(this.f122040e);
                } else {
                    layoutParams2.height = rect.bottom;
                }
            } else {
                layoutParams2.width = rect.right;
            }
        }
        View view4 = this.f122041f;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view4;
        }
        view2.setLayoutParams(layoutParams2);
    }

    public final void a(Function0 function0) {
        this.H = function0;
    }

    public final Function2 a() {
        return this.I;
    }

    public final void a(Function2 function2) {
        this.I = function2;
    }

    public final void a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.J = function1;
    }

    public final void a(Context context) {
        Dialog aVar;
        int i3;
        int c16;
        if (this.E) {
            Intrinsics.checkNotNull(context);
            aVar = new CustomSheetDialog(context);
        } else {
            Intrinsics.checkNotNull(context);
            aVar = new com.google.android.material.bottomsheet.a(context);
        }
        this.f122039d = aVar;
        Dialog dialog = null;
        View inflate = View.inflate(context, R.layout.ffq, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026video_cast_devices, null)");
        this.f122041f = inflate;
        c.a aVar2 = com.tencent.luggage.wxa.jl.c.f131190l;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_title)");
        aVar2.a(findViewById, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : Boolean.TRUE, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        View view = this.f122041f;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View help = view.findViewById(R.id.f108646do);
        help.setOnClickListener(new e(context));
        Intrinsics.checkNotNullExpressionValue(help, "help");
        aVar2.a(help, (r27 & 2) != 0 ? null : Button.class, (r27 & 4) != 0 ? null : Integer.valueOf(R.string.zis), (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        View view2 = this.f122041f;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.taq);
        recyclerView.setHasFixedSize(true);
        View view3 = this.f122041f;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View closeClickArea = view3.findViewById(R.id.y1l);
        closeClickArea.setOnClickListener(new f());
        Intrinsics.checkNotNullExpressionValue(closeClickArea, "closeClickArea");
        aVar2.a(closeClickArea, (r27 & 2) != 0 ? null : Button.class, (r27 & 4) != 0 ? null : Integer.valueOf(R.string.z1t), (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        View view4 = this.f122041f;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        ImageView imageView = (ImageView) view4.findViewById(R.id.y1k);
        if (com.tencent.luggage.wxa.h6.l.f126905a.c()) {
            Context context2 = this.f122040e;
            Intrinsics.checkNotNull(context2);
            imageView.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.ofs));
        } else {
            Context context3 = this.f122040e;
            Intrinsics.checkNotNull(context3);
            imageView.setImageDrawable(ContextCompat.getDrawable(context3, R.drawable.ofo));
        }
        this.f122045j = f();
        int c17 = com.tencent.luggage.wxa.lo.o.c(this.f122040e, R.dimen.c5t);
        if (this.f122045j) {
            i3 = (int) (c17 * 4.5d);
            c16 = com.tencent.luggage.wxa.lo.o.c(this.f122040e, R.dimen.c5l);
        } else {
            i3 = (int) (c17 * 6.5d);
            c16 = com.tencent.luggage.wxa.lo.o.c(this.f122040e, R.dimen.c5l);
        }
        this.f122043h = i3 + c16;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f122040e));
        recyclerView.setFocusable(false);
        c cVar = new c();
        this.f122042g = cVar;
        recyclerView.setAdapter(cVar);
        recyclerView.setOverScrollMode(1);
        Dialog dialog2 = this.f122039d;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            dialog2 = null;
        }
        View view5 = this.f122041f;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        dialog2.setContentView(view5);
        if (!this.E) {
            View view6 = this.f122041f;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view6 = null;
            }
            Object parent = view6.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
            this.f122044i = from;
            Intrinsics.checkNotNull(from);
            from.setPeekHeight(this.f122043h);
        }
        Dialog dialog3 = this.f122039d;
        if (dialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            dialog3 = null;
        }
        dialog3.setOnCancelListener(new g());
        Dialog dialog4 = this.f122039d;
        if (dialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            dialog4 = null;
        }
        dialog4.setOnDismissListener(new h());
        Dialog dialog5 = this.f122039d;
        if (dialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        } else {
            dialog = dialog5;
        }
        dialog.setCancelable(false);
    }

    public /* synthetic */ n(Context context, com.tencent.luggage.wxa.ic.g gVar, boolean z16, boolean z17, l lVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, gVar, (i3 & 4) != 0 ? true : z16, z17, lVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final i f122074a = new i();

        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }

        public final void a(int i3) {
        }
    }

    public final void a(com.tencent.luggage.wxa.md.c cVar, int i3) {
        if (cVar != null) {
            this.f122038c.c(cVar);
        }
        Function2 function2 = this.I;
        if (function2 != null) {
            function2.invoke(cVar, Integer.valueOf(i3));
        }
    }
}
