package com.tencent.luggage.wxa.bg;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.s;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.widget.ToastView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122653a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f122654b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f122655c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f122656d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f122657e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f122658f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f122659g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f122660h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f122661i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f122662j;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bg.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6063a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f122664a;

            public RunnableC6063a(View view) {
                this.f122664a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f122664a.announceForAccessibility(a.this.f122658f);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public TouchDelegate f122666a;

            /* renamed from: b, reason: collision with root package name */
            public View f122667b;

            /* renamed from: c, reason: collision with root package name */
            public View f122668c;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.bg.d$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class ViewOnTouchListenerC6064a implements View.OnTouchListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f122670a;

                public ViewOnTouchListenerC6064a(a aVar) {
                    this.f122670a = aVar;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            }

            public b(View view) {
                view.addOnAttachStateChangeListener(this);
                view.setOnTouchListener(new ViewOnTouchListenerC6064a(a.this));
                this.f122667b = view;
            }

            public final void a() {
                View view = this.f122668c;
                if (view != null && view.getTouchDelegate() == this.f122666a) {
                    this.f122668c.setTouchDelegate(null);
                }
                View view2 = this.f122668c;
                if (view2 != null) {
                    view2.removeOnLayoutChangeListener(this);
                }
            }

            public final void b() {
                if (this.f122668c != null && ViewCompat.isAttachedToWindow(this.f122667b)) {
                    Rect rect = new Rect(0, 0, this.f122668c.getWidth(), this.f122668c.getHeight());
                    View view = this.f122668c;
                    TouchDelegate touchDelegate = new TouchDelegate(rect, this.f122667b);
                    this.f122666a = touchDelegate;
                    view.setTouchDelegate(touchDelegate);
                }
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                b();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                this.f122668c = (View) view.getParent();
                b();
                this.f122668c.addOnLayoutChangeListener(this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                a();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TextView f122672a;

            public c(TextView textView) {
                this.f122672a = textView;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (this.f122672a.getLineCount() > 1) {
                    this.f122672a.setTextSize(0, com.tencent.luggage.wxa.kn.a.d(r0.getContext(), R.dimen.bfo));
                    TextView textView = this.f122672a;
                    textView.setSpannableFactory(a.this.a(com.tencent.luggage.wxa.kn.a.d(textView.getContext(), R.dimen.bkf)));
                }
                this.f122672a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bg.d$a$d, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6065d extends Spannable.Factory {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f122674a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.bg.d$a$d$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6066a extends com.tencent.luggage.wxa.cm.a {
                public C6066a(float f16, int i3) {
                    super(f16, i3);
                }

                @Override // com.tencent.luggage.wxa.cm.a, android.text.style.LineHeightSpan
                public void chooseHeight(CharSequence charSequence, int i3, int i16, int i17, int i18, Paint.FontMetricsInt fontMetricsInt) {
                    if (fontMetricsInt != null && a() >= fontMetricsInt.bottom - fontMetricsInt.top) {
                        super.chooseHeight(charSequence, i3, i16, i17, i18, fontMetricsInt);
                    }
                }
            }

            public C6065d(int i3) {
                this.f122674a = i3;
            }

            @Override // android.text.Spannable.Factory
            public Spannable newSpannable(CharSequence charSequence) {
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!TextUtils.isEmpty(newSpannable)) {
                    newSpannable.setSpan(new C6066a(this.f122674a, 17), 0, newSpannable.length(), 18);
                }
                return newSpannable;
            }
        }

        public a(l lVar, boolean z16, v vVar, int i3, int i16, String str, int i17, boolean z17, String str2, String str3) {
            this.f122653a = lVar;
            this.f122654b = z16;
            this.f122655c = vVar;
            this.f122656d = i3;
            this.f122657e = i16;
            this.f122658f = str;
            this.f122659g = i17;
            this.f122660h = z17;
            this.f122661i = str2;
            this.f122662j = str3;
        }

        public final void b(View view) {
            if (this.f122660h) {
                new b(view);
            }
        }

        public final void c(View view) {
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (!w0.c(this.f122658f)) {
                textView.setLineSpacing(0.0f, 1.0f);
                textView.setSpannableFactory(a(com.tencent.luggage.wxa.kn.a.d(textView.getContext(), R.dimen.bpp)));
                textView.setText(this.f122658f, TextView.BufferType.SPANNABLE);
                textView.setVisibility(0);
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new c(textView));
                if (!this.f122654b) {
                    view.findViewById(R.id.f85234oe).setPadding(0, com.tencent.luggage.wxa.kn.a.a(textView.getContext(), 27), 0, 0);
                    return;
                }
                return;
            }
            textView.setVisibility(8);
        }

        @Override // java.lang.Runnable
        public void run() {
            View inflate;
            if (!this.f122653a.isRunning()) {
                w.f("MicroMsg.JsApiShowToast", "service is not running");
                return;
            }
            if (this.f122654b) {
                inflate = LayoutInflater.from(this.f122655c.getContext()).inflate(R.layout.dyk, (ViewGroup) this.f122655c.getContentView(), false);
            } else {
                inflate = LayoutInflater.from(this.f122655c.getContext()).inflate(R.layout.dyl, (ViewGroup) this.f122655c.getContentView(), false);
            }
            b(inflate);
            c(inflate);
            if (!this.f122654b) {
                a(inflate);
            }
            int i3 = this.f122656d;
            if (i3 != -1) {
                inflate.setTag(Integer.valueOf(i3));
            }
            this.f122655c.u0().d();
            this.f122655c.u0().a(inflate, this.f122657e);
            inflate.post(new RunnableC6063a(inflate));
            this.f122653a.a(this.f122659g, d.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }

        public final void a(View view) {
            Drawable drawable;
            Drawable drawable2;
            ImageView imageView = (ImageView) view.findViewById(R.id.dvu);
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.g1f);
            if (this.f122661i.equals(ToastView.ICON_LOADING)) {
                imageView.setVisibility(8);
                progressBar.setVisibility(0);
                return;
            }
            imageView.setVisibility(0);
            progressBar.setVisibility(8);
            if (!w0.c(this.f122662j)) {
                Bitmap a16 = s.a(this.f122653a.getRuntime(), this.f122662j);
                drawable2 = (a16 == null || a16.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), a16);
            } else {
                if (this.f122661i.equals("error")) {
                    drawable = this.f122653a.getContext().getResources().getDrawable(R.drawable.m8d);
                } else {
                    drawable = this.f122653a.getContext().getResources().getDrawable(R.drawable.m8r);
                }
                drawable2 = drawable;
                drawable2.mutate().setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            }
            if (drawable2 != null) {
                imageView.setImageDrawable(drawable2);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }

        public final Spannable.Factory a(int i3) {
            return new C6065d(i3);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        boolean z16;
        v J = lVar.J();
        if (J == null) {
            w.f("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            lVar.a(i3, makeReturnJson("fail"));
            return;
        }
        w.d("MicroMsg.JsApiShowToast", "showToast:%s, callbackId:%d", jSONObject, Integer.valueOf(i3));
        int optInt = jSONObject.optInt("id", -1);
        int optInt2 = jSONObject.optInt("duration", 1500);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("icon", "success");
        String optString3 = jSONObject.optString("image");
        boolean optBoolean = jSONObject.optBoolean("mask");
        if (w0.c(optString2) && w0.c(optString3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        J.a(new a(lVar, z16, J, optInt, optInt2, optString, i3, optBoolean, optString2, optString3));
    }
}
