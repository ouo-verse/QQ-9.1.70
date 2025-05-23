package com.tencent.luggage.wxa.bi;

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
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.ic.z;
import com.tencent.luggage.wxa.jl.c;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.lo.q;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.ui.widget.dialog.CustomSheetDialog;
import com.tencent.mobileqq.R;
import java.util.TimerTask;
import kotlin.Unit;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final a L = new a(null);
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public Function2 G;
    public Function0 H;
    public Function1 I;
    public Function0 J;
    public final c K;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ai.b f122772a;

    /* renamed from: b, reason: collision with root package name */
    public final i f122773b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f122774c;

    /* renamed from: d, reason: collision with root package name */
    public Dialog f122775d;

    /* renamed from: e, reason: collision with root package name */
    public Context f122776e;

    /* renamed from: f, reason: collision with root package name */
    public View f122777f;

    /* renamed from: g, reason: collision with root package name */
    public b f122778g;

    /* renamed from: h, reason: collision with root package name */
    public int f122779h;

    /* renamed from: i, reason: collision with root package name */
    public BottomSheetBehavior f122780i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f122781j;

    /* renamed from: k, reason: collision with root package name */
    public int f122782k;

    /* renamed from: l, reason: collision with root package name */
    public View f122783l;

    /* renamed from: m, reason: collision with root package name */
    public ViewTreeObserver f122784m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b extends RecyclerView.Adapter {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public final class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f122786a;

            /* renamed from: b, reason: collision with root package name */
            public FrameLayout f122787b;

            /* renamed from: c, reason: collision with root package name */
            public ProgressBar f122788c;

            /* renamed from: d, reason: collision with root package name */
            public ImageView f122789d;

            /* renamed from: e, reason: collision with root package name */
            public final TextView f122790e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f122791f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f122791f = bVar;
                View findViewById = itemView.findViewById(R.id.f107336a5);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_device_name)");
                TextView textView = (TextView) findViewById;
                this.f122786a = textView;
                View findViewById2 = itemView.findViewById(R.id.v7t);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.fl_device_item)");
                this.f122787b = (FrameLayout) findViewById2;
                View findViewById3 = itemView.findViewById(R.id.f234706i);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.pb_device_connecting)");
                this.f122788c = (ProgressBar) findViewById3;
                View findViewById4 = itemView.findViewById(R.id.y1u);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.iv_connected)");
                this.f122789d = (ImageView) findViewById4;
                View findViewById5 = itemView.findViewById(R.id.f1065268y);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_cast_fail)");
                TextView textView2 = (TextView) findViewById5;
                this.f122790e = textView2;
                this.f122789d.setImageResource(R.raw.f169304c0);
                com.tencent.luggage.wxa.jl.c.f131190l.a(itemView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
                ViewCompat.setImportantForAccessibility(textView, 1);
                ViewCompat.setImportantForAccessibility(textView2, 1);
            }

            public final TextView a() {
                return this.f122790e;
            }

            public final ImageView b() {
                return this.f122789d;
            }

            public final ProgressBar c() {
                return this.f122788c;
            }

            public final TextView d() {
                return this.f122786a;
            }

            public final FrameLayout e() {
                return this.f122787b;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bi.g$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public final class C6069b extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f122792a;

            /* renamed from: b, reason: collision with root package name */
            public ProgressBar f122793b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f122794c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C6069b(b bVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f122794c = bVar;
                View findViewById = itemView.findViewById(R.id.f111086k_);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_select_device_title)");
                TextView textView = (TextView) findViewById;
                this.f122792a = textView;
                View findViewById2 = itemView.findViewById(R.id.f234806j);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.pb_device_search)");
                this.f122793b = (ProgressBar) findViewById2;
                com.tencent.luggage.wxa.jl.c.f131190l.a(itemView, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : true, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
                ViewCompat.setImportantForAccessibility(textView, 1);
            }

            public final TextView a() {
                return this.f122792a;
            }

            public final ProgressBar b() {
                return this.f122793b;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f122795a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f122796b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f122797c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f122798d;

            public c(g gVar, int i3, b bVar, int i16) {
                this.f122795a = gVar;
                this.f122796b = i3;
                this.f122797c = bVar;
                this.f122798d = i16;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (this.f122795a.G != null) {
                    if (!(!this.f122795a.d().d().isEmpty()) || this.f122796b > this.f122795a.d().d().size()) {
                        Function2 function2 = this.f122795a.G;
                        Intrinsics.checkNotNull(function2);
                        function2.invoke(this.f122797c.a(this.f122796b).a(), Integer.valueOf(this.f122798d));
                    } else {
                        Function2 function22 = this.f122795a.G;
                        Intrinsics.checkNotNull(function22);
                        function22.invoke(this.f122797c.a(this.f122796b).a(), Integer.valueOf(this.f122798d));
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d extends TimerTask {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C6069b f122799a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f122800b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f122801c;

            public d(C6069b c6069b, g gVar, b bVar) {
                this.f122799a = c6069b;
                this.f122800b = gVar;
                this.f122801c = bVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c0.a(new e(this.f122799a, this.f122800b, this.f122801c));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C6069b f122802a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f122803b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f122804c;

            public e(C6069b c6069b, g gVar, b bVar) {
                this.f122802a = c6069b;
                this.f122803b = gVar;
                this.f122804c = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String b16;
                this.f122802a.b().setVisibility(8);
                TextView a16 = this.f122802a.a();
                if (this.f122803b.f()) {
                    b16 = this.f122804c.b(R.string.z1x);
                } else {
                    b16 = this.f122803b.d().f().isEmpty() ? this.f122804c.b(R.string.z1v) : this.f122804c.b(R.string.z1u);
                }
                a16.setText(b16);
            }
        }

        public b() {
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
            if (g.this.f()) {
                size = g.this.d().d().size() + g.this.d().f().size() + 2;
            } else {
                size = g.this.d().f().size() + g.this.d().d().size() + 1;
            }
            w.a("MicroMsg.VideoCast.SelectDevicesBottomSheet", "item count = " + size);
            return size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (i3 == 0 && g.this.f()) {
                return 1;
            }
            if (i3 == 0 || (g.this.f() && i3 == g.this.d().d().size() + 1)) {
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
                b((C6069b) viewHolder);
                return;
            }
            a((C6069b) viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i3 == 3) {
                View itemView = LayoutInflater.from(g.this.f122776e).inflate(R.layout.fdj, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                return new a(this, itemView);
            }
            View itemView2 = LayoutInflater.from(g.this.f122776e).inflate(R.layout.ffr, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            return new C6069b(this, itemView2);
        }

        public final void a(C6069b c6069b) {
            c6069b.b().setVisibility(8);
            if (g.this.f()) {
                c6069b.a().setText("\u6700\u8fd1\u8fde\u63a5");
            } else {
                c6069b.a().setVisibility(8);
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
            Context context = g.this.f122776e;
            if (context == null) {
                return "";
            }
            String string = context.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(id)");
            return string;
        }

        public final void b(C6069b c6069b) {
            String b16;
            TextView a16 = c6069b.a();
            if (g.this.f()) {
                b16 = b(R.string.z1w);
            } else {
                b16 = b(R.string.z1u);
            }
            a16.setText(b16);
            TimersKt.timer("progressBarHolder", false).schedule(new d(c6069b, g.this, this), 10000L, Long.MAX_VALUE);
        }

        public final void a(a aVar, int i3) {
            int i16 = i3 - 1;
            aVar.e().setOnClickListener(new c(g.this, i16, this, i3));
            com.tencent.luggage.wxa.bi.e a16 = a(i16);
            w.a("MicroMsg.VideoCast.SelectDevicesBottomSheet", "bindDeviceViewHolder: " + a16);
            aVar.d().setText(c(a16));
            if (!g.this.h()) {
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
            } else if (!a16.b() && a16.d() && !a16.c()) {
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
            com.tencent.luggage.wxa.bi.e eVar;
            if ((!g.this.d().d().isEmpty()) && i3 <= g.this.d().d().size()) {
                Object obj = g.this.d().d().get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "{\n                videoC\u2026bFistTitle]\n            }");
                return (com.tencent.luggage.wxa.bi.e) obj;
            }
            if (!g.this.d().d().isEmpty()) {
                eVar = (com.tencent.luggage.wxa.bi.e) g.this.d().f().get((i3 - g.this.d().d().size()) - 1);
            } else {
                eVar = (com.tencent.luggage.wxa.bi.e) g.this.d().f().get(i3);
            }
            Intrinsics.checkNotNullExpressionValue(eVar, "{\n                if (vi\u2026          }\n            }");
            return eVar;
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
    public static final class c extends z {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.ic.z
        public boolean a(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (1 != event.getAction()) {
                Function2 function2 = g.this.G;
                if (function2 != null) {
                }
                g.this.l();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 a16;
            if (g.this.a() != null && (a16 = g.this.a()) != null) {
                a16.invoke();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = g.this.H;
            if (function0 != null) {
                function0.invoke();
            }
            Function2 function2 = g.this.G;
            if (function2 != null) {
            }
            g.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Function2 function2 = g.this.G;
            if (function2 != null) {
            }
            com.tencent.luggage.wxa.ic.g g16 = g.this.e().g();
            if (g16 != null) {
                g16.a((z) g.this.K);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bi.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class DialogInterfaceOnDismissListenerC6070g implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC6070g() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (g.this.f122784m != null) {
                ViewTreeObserver viewTreeObserver = g.this.f122784m;
                Intrinsics.checkNotNull(viewTreeObserver);
                if (!viewTreeObserver.isAlive()) {
                    g gVar = g.this;
                    View view = gVar.f122783l;
                    Intrinsics.checkNotNull(view);
                    gVar.f122784m = view.getViewTreeObserver();
                }
                ViewTreeObserver viewTreeObserver2 = g.this.f122784m;
                Intrinsics.checkNotNull(viewTreeObserver2);
                viewTreeObserver2.removeGlobalOnLayoutListener(g.this);
                g.this.f122784m = null;
            }
            g.this.b().invoke(Integer.valueOf(g.this.d().d().size() + g.this.d().f().size()));
        }
    }

    public g(Context context, boolean z16, com.tencent.luggage.wxa.ai.b videoCastHandler, i videoCastDeviceManager, boolean z17) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoCastHandler, "videoCastHandler");
        Intrinsics.checkNotNullParameter(videoCastDeviceManager, "videoCastDeviceManager");
        this.f122772a = videoCastHandler;
        this.f122773b = videoCastDeviceManager;
        this.f122774c = z17;
        this.f122776e = context;
        this.D = true;
        this.E = z16;
        this.I = h.f122810a;
        c cVar = new c();
        this.K = cVar;
        Context context2 = this.f122776e;
        if (context2 instanceof Activity) {
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            View decorView = ((Activity) context2).getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.f122783l = ((ViewGroup) decorView).findViewById(android.R.id.content);
        }
        a(this.f122776e);
        com.tencent.luggage.wxa.ic.g g16 = videoCastHandler.g();
        if (g16 != null) {
            g16.a(4, -1, cVar);
        }
    }

    public final boolean h() {
        return this.f122774c;
    }

    public final boolean i() {
        Dialog dialog = this.f122775d;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public final void j() {
        if (i() && this.f122775d != null) {
            b bVar = this.f122778g;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleViewAdapter");
                bVar = null;
            }
            bVar.notifyDataSetChanged();
        }
    }

    public final void k() {
        View view = this.f122777f;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.E) {
            this.f122779h = (int) (o.c(this.f122776e, R.dimen.c5t) * 6.5d);
        }
        layoutParams2.height = this.f122779h;
        if (this.f122781j && this.f122783l != null) {
            Rect rect = new Rect();
            View view3 = this.f122783l;
            Intrinsics.checkNotNull(view3);
            view3.getWindowVisibleDisplayFrame(rect);
            if (this.E) {
                layoutParams2.width = (int) (((rect.right * 1.0f) * 4) / 10);
                int i3 = this.F;
                if (i3 != 0) {
                    layoutParams2.width = i3;
                }
                if (q.g(this.f122776e)) {
                    layoutParams2.height = rect.bottom - q.f(this.f122776e);
                } else {
                    layoutParams2.height = rect.bottom;
                }
            } else {
                layoutParams2.width = rect.right;
            }
        }
        View view4 = this.f122777f;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view4;
        }
        view2.setLayoutParams(layoutParams2);
    }

    public final void l() {
        if (this.f122775d != null) {
            BottomSheetBehavior bottomSheetBehavior = this.f122780i;
            if (bottomSheetBehavior != null) {
                Intrinsics.checkNotNull(bottomSheetBehavior);
                bottomSheetBehavior.setHideable(true);
            }
            Context context = this.f122776e;
            if (context != null) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (!((Activity) context).isFinishing()) {
                    Dialog dialog = this.f122775d;
                    if (dialog == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                        dialog = null;
                    }
                    dialog.dismiss();
                }
            }
        }
        com.tencent.luggage.wxa.ic.g g16 = this.f122772a.g();
        if (g16 != null) {
            g16.a((z) this.K);
        }
    }

    public final void m() {
        View view;
        View view2;
        this.f122781j = g();
        this.f122782k = c();
        if (this.f122775d != null) {
            k();
            Dialog dialog = this.f122775d;
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
                Dialog dialog3 = this.f122775d;
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
                Dialog dialog4 = this.f122775d;
                if (dialog4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog4 = null;
                }
                Window window3 = dialog4.getWindow();
                if (window3 != null) {
                    window3.setFlags(8, 8);
                }
                Dialog dialog5 = this.f122775d;
                if (dialog5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog5 = null;
                }
                Window window4 = dialog5.getWindow();
                if (window4 != null) {
                    window4.addFlags(131200);
                }
                Dialog dialog6 = this.f122775d;
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
                Dialog dialog7 = this.f122775d;
                if (dialog7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog7 = null;
                }
                Window window6 = dialog7.getWindow();
                if (window6 != null) {
                    window6.clearFlags(8);
                }
                Dialog dialog8 = this.f122775d;
                if (dialog8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog8 = null;
                }
                Window window7 = dialog8.getWindow();
                if (window7 != null) {
                    window7.clearFlags(131072);
                }
                Dialog dialog9 = this.f122775d;
                if (dialog9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
                    dialog9 = null;
                }
                Window window8 = dialog9.getWindow();
                if (window8 != null) {
                    window8.clearFlags(128);
                }
                Dialog dialog10 = this.f122775d;
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
            BottomSheetBehavior bottomSheetBehavior = this.f122780i;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(false);
            }
            View view3 = this.f122783l;
            if (view3 != null) {
                if (this.f122784m == null) {
                    z16 = true;
                }
                Intrinsics.checkNotNull(view3);
                ViewTreeObserver viewTreeObserver = view3.getViewTreeObserver();
                this.f122784m = viewTreeObserver;
                if (z16) {
                    Intrinsics.checkNotNull(viewTreeObserver);
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                }
            }
            Context context = this.f122776e;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (!((Activity) context).isFinishing()) {
                    Dialog dialog11 = this.f122775d;
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
        if (i()) {
            View view = this.f122783l;
            if (view != null && (view.isShown() || view.getVisibility() == 0)) {
                if (i()) {
                    if (this.f122781j != g() || this.f122782k != c()) {
                        l();
                        return;
                    }
                    return;
                }
                return;
            }
            l();
        }
    }

    public final Function1 b() {
        return this.I;
    }

    public final int c() {
        Context context = this.f122776e;
        if (!(context instanceof Activity)) {
            return 0;
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        return ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }

    public final i d() {
        return this.f122773b;
    }

    public final com.tencent.luggage.wxa.ai.b e() {
        return this.f122772a;
    }

    public final boolean f() {
        return !this.f122773b.d().isEmpty();
    }

    public final boolean g() {
        Context context = this.f122776e;
        Intrinsics.checkNotNull(context);
        return context.getResources().getConfiguration().orientation == 2;
    }

    public final void a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.I = function1;
    }

    public final Function0 a() {
        return this.J;
    }

    public final void a(Function0 function0) {
        this.J = function0;
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
        this.f122775d = aVar;
        Dialog dialog = null;
        View inflate = View.inflate(context, R.layout.ffq, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026video_cast_devices, null)");
        this.f122777f = inflate;
        c.a aVar2 = com.tencent.luggage.wxa.jl.c.f131190l;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_title)");
        aVar2.a(findViewById, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : Boolean.TRUE, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        View view = this.f122777f;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View help = view.findViewById(R.id.f108646do);
        help.setOnClickListener(new d());
        Intrinsics.checkNotNullExpressionValue(help, "help");
        aVar2.a(help, (r27 & 2) != 0 ? null : Button.class, (r27 & 4) != 0 ? null : Integer.valueOf(R.string.zis), (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        View view2 = this.f122777f;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.taq);
        recyclerView.setHasFixedSize(true);
        View view3 = this.f122777f;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View closeClickArea = view3.findViewById(R.id.y1l);
        closeClickArea.setOnClickListener(new e());
        Intrinsics.checkNotNullExpressionValue(closeClickArea, "closeClickArea");
        aVar2.a(closeClickArea, (r27 & 2) != 0 ? null : Button.class, (r27 & 4) != 0 ? null : Integer.valueOf(R.string.z1t), (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? null : null, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null, (r27 & 2048) != 0 ? null : null, (r27 & 4096) == 0 ? null : null);
        View view4 = this.f122777f;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        ImageView imageView = (ImageView) view4.findViewById(R.id.y1k);
        if (l.f126905a.c()) {
            Context context2 = this.f122776e;
            Intrinsics.checkNotNull(context2);
            imageView.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.ofs));
        } else {
            Context context3 = this.f122776e;
            Intrinsics.checkNotNull(context3);
            imageView.setImageDrawable(ContextCompat.getDrawable(context3, R.drawable.ofo));
        }
        this.f122781j = g();
        int c17 = o.c(this.f122776e, R.dimen.c5t);
        if (this.f122781j) {
            i3 = (int) (c17 * 4.5d);
            c16 = o.c(this.f122776e, R.dimen.c5l);
        } else {
            i3 = (int) (c17 * 6.5d);
            c16 = o.c(this.f122776e, R.dimen.c5l);
        }
        this.f122779h = i3 + c16;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f122776e));
        recyclerView.setFocusable(false);
        b bVar = new b();
        this.f122778g = bVar;
        recyclerView.setAdapter(bVar);
        recyclerView.setOverScrollMode(1);
        Dialog dialog2 = this.f122775d;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            dialog2 = null;
        }
        View view5 = this.f122777f;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        dialog2.setContentView(view5);
        if (!this.E) {
            View view6 = this.f122777f;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view6 = null;
            }
            Object parent = view6.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
            this.f122780i = from;
            Intrinsics.checkNotNull(from);
            from.setPeekHeight(this.f122779h);
        }
        Dialog dialog3 = this.f122775d;
        if (dialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            dialog3 = null;
        }
        dialog3.setOnCancelListener(new f());
        Dialog dialog4 = this.f122775d;
        if (dialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
            dialog4 = null;
        }
        dialog4.setOnDismissListener(new DialogInterfaceOnDismissListenerC6070g());
        Dialog dialog5 = this.f122775d;
        if (dialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomSheetDialog");
        } else {
            dialog = dialog5;
        }
        dialog.setCancelable(false);
    }

    public /* synthetic */ g(Context context, boolean z16, com.tencent.luggage.wxa.ai.b bVar, i iVar, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? true : z16, bVar, iVar, z17);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final h f122810a = new h();

        public h() {
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

    public final void a(Function2 function2) {
        this.G = function2;
    }
}
