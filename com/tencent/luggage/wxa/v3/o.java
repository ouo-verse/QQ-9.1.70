package com.tencent.luggage.wxa.v3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget;
import com.tencent.luggage.wxa.ml.t;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class o extends com.tencent.luggage.wxa.ml.b {

    /* renamed from: g0, reason: collision with root package name */
    public final LinearLayout f143175g0;

    /* renamed from: h0, reason: collision with root package name */
    public final Button f143176h0;

    /* renamed from: i0, reason: collision with root package name */
    public final QRCodeTransferQRDisplayWidget f143177i0;

    /* renamed from: j0, reason: collision with root package name */
    public c f143178j0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v3) {
            int b16;
            int b17;
            Intrinsics.checkNotNullParameter(v3, "v");
            ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
            if (layoutParams != null) {
                o oVar = o.this;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                b16 = p.b(context, 303.7f);
                Context context2 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                b17 = p.b(context2, 326.7f);
                int[] iArr = {b16, b17};
                Context context3 = oVar.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext()");
                DisplayMetrics displayMetrics = oVar.getContext().getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "getContext().resources.displayMetrics");
                t.a(context3, iArr, displayMetrics);
                layoutParams.height = iArr[1];
                layoutParams.width = iArr[0];
                v3.requestLayout();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f143180a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public /* synthetic */ void a(o oVar) {
            j41.a.a(this, oVar);
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public void a(o dialog, com.tencent.luggage.wxa.xd.i component, JSONObject args) {
            int b16;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(args, "args");
            int color = ContextCompat.getColor(dialog.getContext(), R.color.c7t);
            TextView textView = new TextView(dialog.getContext());
            textView.setText(R.string.f216975zr);
            textView.setTextColor(color);
            Context context = dialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            b16 = p.b(context, 16.0f);
            textView.setTextSize(0, b16);
            textView.setTypeface(null, 1);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.topMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bil);
            layoutParams.bottomMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bi8);
            dialog.f143175g0.addView(textView, 0, layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(o oVar);

        void a(o oVar, com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements c {
        @Override // com.tencent.luggage.wxa.v3.o.c
        public /* synthetic */ void a(o oVar) {
            j41.a.a(this, oVar);
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public void a(o dialog, com.tencent.luggage.wxa.xd.i component, JSONObject args) {
            int b16;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(args, "args");
            int color = ContextCompat.getColor(dialog.getContext(), R.color.c7t);
            TextView textView = new TextView(dialog.getContext());
            textView.setText(R.string.f216985zs);
            textView.setTextColor(color);
            Context context = dialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            b16 = p.b(context, 16.0f);
            textView.setTextSize(0, b16);
            textView.setTypeface(null, 1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bil);
            layoutParams.bottomMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bi8);
            layoutParams.gravity = 1;
            dialog.f143175g0.addView(textView, 0, layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f143181a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f143182b = {com.tencent.luggage.wxa.y2.h.NAME, "requestPayment", "requestPaymentToBank"};

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String[] a() {
                return e.f143182b;
            }
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public /* synthetic */ void a(o oVar) {
            j41.a.a(this, oVar);
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public void a(o dialog, com.tencent.luggage.wxa.xd.i component, JSONObject args) {
            int b16;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(args, "args");
            int color = ContextCompat.getColor(dialog.getContext(), R.color.c7t);
            TextView textView = new TextView(dialog.getContext());
            textView.setText(R.string.f216995zt);
            textView.setTextColor(color);
            Context context = dialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            b16 = p.b(context, 16.0f);
            textView.setTextSize(0, b16);
            textView.setTypeface(null, 1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bil);
            layoutParams.bottomMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bi8);
            layoutParams.gravity = 1;
            dialog.f143175g0.addView(textView, 0, layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f143183b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f143184c = {com.tencent.luggage.wxa.c3.d.NAME, com.tencent.luggage.wxa.c3.e.NAME};

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f143185a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final String[] a() {
                return f.f143184c;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements AppBrandSimpleImageLoader.j {

            /* renamed from: a, reason: collision with root package name */
            public static final b f143186a = new b();

            @Override // com.tencent.luggage.wxa.pb.a
            public String b() {
                return "QRCodeDisplayDialog.ShareAppMessageLayoutFactory.ThumbImageTransformation";
            }

            @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.j
            public Bitmap b(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, min, min);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 0, 0, size, size)");
                if (!Intrinsics.areEqual(createBitmap, bitmap)) {
                    try {
                        bitmap.recycle();
                    } catch (Exception unused) {
                    }
                }
                return createBitmap;
            }
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public void a(o dialog, com.tencent.luggage.wxa.xd.i component, JSONObject args) {
            int b16;
            String d16;
            String c16;
            String c17;
            int b17;
            int b18;
            int b19;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(args, "args");
            this.f143185a = args;
            int color = ContextCompat.getColor(dialog.getContext(), R.color.c7t);
            TextView textView = new TextView(dialog.getContext());
            textView.setText(R.string.f217035zx);
            textView.setTextColor(color);
            Context context = dialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            b16 = p.b(context, 16.0f);
            textView.setTextSize(0, b16);
            textView.setTypeface(null, 1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bil);
            layoutParams.bottomMargin = dialog.getContext().getResources().getDimensionPixelSize(R.dimen.bi8);
            layoutParams.gravity = 1;
            dialog.f143175g0.addView(textView, 0, layoutParams);
            View inflate = LayoutInflater.from(dialog.getContext()).inflate(R.layout.ff6, (ViewGroup) dialog.f143175g0, false);
            dialog.f143175g0.addView(inflate);
            ViewGroup.LayoutParams layoutParams2 = inflate.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                Context context2 = dialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "dialog.context");
                b17 = p.b(context2, 23.0f);
                marginLayoutParams.topMargin = b17;
                Context context3 = dialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "dialog.context");
                b18 = p.b(context3, 16.0f);
                marginLayoutParams.leftMargin = b18;
                Context context4 = dialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "dialog.context");
                b19 = p.b(context4, 16.0f);
                marginLayoutParams.rightMargin = b19;
                inflate.requestLayout();
            }
            AppBrandSimpleImageLoader instance = AppBrandSimpleImageLoader.instance();
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f84304lw);
            com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime, "component.runtime");
            d16 = p.d(runtime);
            com.tencent.luggage.wxa.il.l lVar = (com.tencent.luggage.wxa.il.l) component.b(com.tencent.luggage.wxa.il.l.class);
            instance.attach(imageView, d16, lVar != null ? lVar.q() : null, WxaIconTransformation.INSTANCE);
            TextView textView2 = (TextView) inflate.findViewById(R.id.f84274lt);
            com.tencent.luggage.wxa.ic.g runtime2 = component.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime2, "component.runtime");
            c16 = p.c(runtime2);
            textView2.setText(c16);
            com.tencent.luggage.wxa.ic.g runtime3 = component.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime3, "component.runtime");
            c17 = p.c(runtime3);
            ((TextView) inflate.findViewById(R.id.f84294lv)).setText(args.optString("desc", c17));
        }

        @Override // com.tencent.luggage.wxa.v3.o.c
        public void a(o dialog) {
            String optString;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            JSONObject jSONObject = this.f143185a;
            if (jSONObject == null || (optString = jSONObject.optString("imageUrl", null)) == null) {
                return;
            }
            AppBrandSimpleImageLoader.instance().attach((ImageView) dialog.f143175g0.findViewById(R.id.f84314lx), optString, (Drawable) null, b.f143186a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.super.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setContentView(LayoutInflater.from(context).inflate(R.layout.f168240ff4, (ViewGroup) null));
        View findViewById = getContentView().findViewById(R.id.u6v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.container_ll)");
        this.f143175g0 = (LinearLayout) findViewById;
        View findViewById2 = getContentView().findViewById(R.id.close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.close)");
        this.f143176h0 = (Button) findViewById2;
        View findViewById3 = getContentView().findViewById(R.id.f650737y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.qrcode_display)");
        this.f143177i0 = (QRCodeTransferQRDisplayWidget) findViewById3;
        getContentView().addOnAttachStateChangeListener(new a());
    }

    @Override // com.tencent.luggage.wxa.ml.b, com.tencent.mm.ui.widget.dialog.MMAlertDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        com.tencent.luggage.wxa.tk.l.a(new g());
    }

    public void f() {
        this.f143177i0.a();
    }

    public void g() {
        this.f143177i0.b();
    }

    public void h() {
        this.f143177i0.c();
    }

    public final void a(com.tencent.luggage.wxa.xd.o jsapi, com.tencent.luggage.wxa.xd.i component, JSONObject args) {
        c bVar;
        Intrinsics.checkNotNullParameter(jsapi, "jsapi");
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(args, "args");
        if (ArrayUtils.contains(e.f143181a.a(), jsapi.getName())) {
            bVar = new e();
        } else if (ArrayUtils.contains(f.f143183b.a(), jsapi.getName())) {
            bVar = new f();
        } else {
            bVar = jsapi.getName().equals("standaloneFunctionalDirectApi") ? new b() : new d();
        }
        this.f143178j0 = bVar;
        bVar.a(this, component, args);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f143176h0.setVisibility(0);
        this.f143176h0.setOnClickListener(onClickListener);
    }

    public void a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.f143177i0.a(bitmap);
        c cVar = this.f143178j0;
        if (cVar != null) {
            cVar.a(this);
        }
    }
}
