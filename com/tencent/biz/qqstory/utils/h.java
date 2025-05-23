package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z16);

        View getView();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class c extends f {
        public c(g gVar, View view) {
            super(gVar, view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class d extends f {

        /* renamed from: m, reason: collision with root package name */
        TextView f94454m;

        public d(g gVar, View view) {
            super(gVar, view);
            TextView textView = (TextView) view.findViewById(R.id.jgc);
            this.f94454m = textView;
            textView.setMaxLines(1);
            this.f94454m.setSingleLine();
        }

        public CharSequence d() {
            return this.f94454m.getText();
        }

        public void e(boolean z16) {
            if (z16) {
                this.f94454m.setBackgroundResource(R.drawable.a__);
            } else {
                this.f94454m.setBackgroundResource(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e extends c implements View.OnTouchListener {
        public static final int[] E = {R.id.air, R.id.ais};
        public static final int[] F = {R.drawable.eit, R.drawable.eiw};
        public static final int[] G = {R.drawable.eiu, R.drawable.eix};
        public static final int[] H = {R.id.jig, R.id.jih};
        TextView C;
        TextView D;

        /* renamed from: m, reason: collision with root package name */
        int f94455m;

        public e(g gVar, View view, int i3) {
            super(gVar, view);
            this.f94455m = i3;
            this.C = (TextView) view.findViewById(E[i3]);
            this.D = (TextView) view.findViewById(H[i3]);
            view.setOnTouchListener(this);
        }

        @Override // com.tencent.biz.qqstory.utils.h.f
        public void c(boolean z16) {
            if (z16 && this.D.getVisibility() != 0) {
                this.D.setVisibility(0);
                d(this.C.getText());
            } else if (!z16 && this.D.getVisibility() == 0) {
                this.D.setVisibility(8);
                d(this.C.getText());
            }
        }

        public void d(CharSequence charSequence) {
            CharSequence charSequence2;
            boolean z16;
            int b16;
            float[] fArr;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence2 = this.C.getHint();
            } else {
                charSequence2 = charSequence;
            }
            if (this.D.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b16 = UIUtils.b(this.C.getContext(), 72.5f);
                fArr = new float[]{21.0f, 18.0f, 14.0f};
            } else {
                b16 = UIUtils.b(this.C.getContext(), 84.0f);
                fArr = new float[]{28.0f, 21.0f};
            }
            this.C.setMaxWidth(b16);
            int length = charSequence2.length();
            float[] fArr2 = new float[length];
            Paint paint = new Paint(this.C.getPaint());
            int i3 = 0;
            while (i3 < fArr.length) {
                paint.setTextSize(TypedValue.applyDimension(1, fArr[i3], this.C.getResources().getDisplayMetrics()));
                paint.getTextWidths(charSequence2.toString(), fArr2);
                int i16 = 0;
                for (int i17 = 0; i17 < length; i17++) {
                    i16 = (int) (i16 + fArr2[i17]);
                }
                if (i16 > b16 && i3 != fArr.length - 1) {
                    i3++;
                } else {
                    this.C.setTextSize(1, fArr[i3]);
                    this.C.setText(charSequence);
                    hd0.c.b("Q.qqstory.widget.PollWidgetUtils", "text size = %s", Float.valueOf(fArr[i3]));
                    break;
                }
            }
            i3 = -1;
            this.C.setText(h.c(this.C, 2));
            if (z16 && i3 == fArr.length - 1) {
                this.D.setTextSize(1, 20.0f);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a();
            return view.onTouchEvent(motionEvent);
        }
    }

    public static float[] a(float f16, float f17, float f18) {
        double d16 = f16;
        double d17 = (f18 * 3.141592653589793d) / 180.0d;
        double d18 = f17;
        return new float[]{((float) (Math.cos(d17) * d16)) - ((float) (Math.sin(d17) * d18)), ((float) (d16 * Math.sin(d17))) + ((float) (d18 * Math.cos(d17)))};
    }

    public static a b(Context context, int i3, int i16, String str) {
        return new g(context);
    }

    public static String c(TextView textView, int i3) {
        Layout layout = textView.getLayout();
        String charSequence = textView.getText().toString();
        if (layout != null && layout.getLineCount() > i3) {
            return charSequence.substring(0, layout.getLineStart(i3));
        }
        return charSequence;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class f {

        /* renamed from: d, reason: collision with root package name */
        g f94456d;

        /* renamed from: e, reason: collision with root package name */
        View f94457e;

        /* renamed from: f, reason: collision with root package name */
        b f94458f;

        /* renamed from: h, reason: collision with root package name */
        boolean f94459h = false;

        /* renamed from: i, reason: collision with root package name */
        private View.OnClickListener f94460i = new a();

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                f.this.getClass();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public f(g gVar, View view) {
            this.f94456d = gVar;
            this.f94457e = view;
        }

        public boolean a() {
            return this.f94459h;
        }

        void b(b bVar) {
            this.f94458f = bVar;
        }

        public void c(boolean z16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class g implements a, View.OnLayoutChangeListener, View.OnAttachStateChangeListener, View.OnClickListener {
        public float C;
        public float D;
        public float E;
        public float F;
        public float G;
        public int H;
        public int I;
        public float J;
        public float K;
        public float L;
        private int M;
        private int N;

        /* renamed from: d, reason: collision with root package name */
        d f94462d;

        /* renamed from: e, reason: collision with root package name */
        c f94463e;

        /* renamed from: f, reason: collision with root package name */
        c f94464f;

        /* renamed from: h, reason: collision with root package name */
        private ViewGroup f94465h;

        /* renamed from: i, reason: collision with root package name */
        public ViewGroup f94466i;

        /* renamed from: m, reason: collision with root package name */
        public int[] f94467m = null;
        private boolean P = false;
        private boolean Q = false;
        public boolean R = false;
        private boolean S = false;
        private Handler T = new Handler(Looper.getMainLooper());
        b U = new a();

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements b {
            a() {
            }
        }

        public g(Context context) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.apb, (ViewGroup) null, false);
            this.f94466i = viewGroup;
            viewGroup.addOnLayoutChangeListener(this);
            this.f94466i.addOnAttachStateChangeListener(this);
            this.f94462d = new d(this, this.f94466i.findViewById(R.id.jgc));
            e eVar = new e(this, this.f94466i.findViewById(R.id.e4k), 0);
            this.f94463e = eVar;
            eVar.b(this.U);
            e eVar2 = new e(this, this.f94466i.findViewById(R.id.e4l), 1);
            this.f94464f = eVar2;
            eVar2.b(this.U);
        }

        private void h() {
            ViewGroup viewGroup = this.f94465h;
            if (viewGroup == null) {
                hd0.c.a("WidgetWrapper", "mAttendWidget is null, no action, return");
                return;
            }
            float f16 = this.J;
            float f17 = this.C;
            float f18 = (f16 * f17) + this.D;
            float f19 = (this.K * f17) + this.E;
            int height = viewGroup.getHeight();
            int width = this.f94465h.getWidth();
            float f26 = (height * 1.0f) / 2.0f;
            float[] a16 = h.a(0.0f, ((this.M * 1.0f) / 2.0f) + f26 + UIUtils.b(this.f94465h.getContext(), 10.0f), this.L);
            float f27 = a16[0];
            float f28 = a16[1];
            if ((this.F * f27) + f18 < 0.0f || ((this.f94465h.getParent() != null && (this.G * f28) + f19 > ((ViewGroup) this.f94465h.getParent()).getHeight()) || ((this.f94465h.getParent() != null && (this.F * f27) + f18 > ((ViewGroup) this.f94465h.getParent()).getWidth()) || (this.G * f28) + f19 < 0.0f))) {
                f27 = -f27;
                f28 = -f28;
            }
            this.f94465h.setX((f18 + (this.F * f27)) - ((width * 1.0f) / 2.0f));
            this.f94465h.setY((f19 + (this.G * f28)) - f26);
            this.f94465h.setRotation(this.L);
            this.f94465h.setScaleX(this.F);
            this.f94465h.setScaleY(this.G);
            if (width != 0) {
                j(this.R);
            } else {
                this.f94465h.setVisibility(4);
            }
            hd0.c.b("WidgetWrapper", "relayoutAttendView %d", Integer.valueOf(this.f94465h.hashCode()));
            hd0.c.f("WidgetWrapper", "relayoutAttendView 2widgets(%d, %d, %d, %d) showAttend? %b, stack=%s", Integer.valueOf(this.N), Integer.valueOf(this.M), Integer.valueOf(width), Integer.valueOf(height), Boolean.valueOf(this.R), pd0.a.a(5));
            hd0.c.e("WidgetWrapper", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.D), Float.valueOf(this.E), Float.valueOf(f27), Float.valueOf(f28));
        }

        @Override // com.tencent.biz.qqstory.utils.h.a
        public void a(boolean z16) {
            for (f fVar : d()) {
                fVar.c(z16);
            }
        }

        public f[] d() {
            return new f[]{this.f94462d, this.f94463e, this.f94464f};
        }

        public int e() {
            return getView().getHeight();
        }

        public int f() {
            return getView().getWidth();
        }

        public d g() {
            return this.f94462d;
        }

        @Override // com.tencent.biz.qqstory.utils.h.a
        public View getView() {
            return this.f94466i;
        }

        public void i() {
            if (!this.P) {
                return;
            }
            this.N = f();
            int e16 = e();
            this.M = e16;
            float f16 = this.C;
            int i3 = this.N;
            this.F = (this.H * f16) / i3;
            this.G = (this.I * f16) / e16;
            if (i3 != 0 && e16 != 0) {
                float f17 = (this.J * f16) + this.D;
                float f18 = (this.K * f16) + this.E;
                getView().setX(f17 - ((this.N * 1.0f) / 2.0f));
                getView().setY(f18 - ((this.M * 1.0f) / 2.0f));
                getView().setRotation(this.L);
                getView().setScaleX(this.F);
                getView().setScaleY(this.G);
                hd0.c.f("WidgetWrapper", "%s relayoutPollView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", g().d(), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(this.L), Float.valueOf(this.F), Float.valueOf(this.G), Integer.valueOf(this.N), Integer.valueOf(this.M));
                hd0.c.c("WidgetWrapper", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.D), Float.valueOf(this.E));
                h();
            }
        }

        public void j(boolean z16) {
            int i3;
            ViewGroup viewGroup = this.f94465h;
            if (viewGroup != null) {
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                viewGroup.setVisibility(i3);
            }
            this.R = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (view == this.f94465h) {
                hd0.c.f("WidgetWrapper", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                h();
            } else {
                hd0.c.f("WidgetWrapper", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                i();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
