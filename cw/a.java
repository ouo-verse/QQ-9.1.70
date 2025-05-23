package cw;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.u;
import com.tencent.av.ui.m;
import com.tencent.av.utils.aw;
import com.tencent.av.utils.ba;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import dw.c;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements cw.b {

    /* renamed from: b, reason: collision with root package name */
    private boolean f391936b;

    /* renamed from: c, reason: collision with root package name */
    View f391937c;

    /* renamed from: d, reason: collision with root package name */
    LinearLayout f391938d;

    /* renamed from: e, reason: collision with root package name */
    d f391939e;

    /* renamed from: f, reason: collision with root package name */
    c f391940f;

    /* renamed from: g, reason: collision with root package name */
    e f391941g;

    /* renamed from: h, reason: collision with root package name */
    int f391942h;

    /* renamed from: i, reason: collision with root package name */
    int f391943i;

    /* renamed from: m, reason: collision with root package name */
    VideoAppInterface f391947m;

    /* renamed from: j, reason: collision with root package name */
    ViewTreeObserver.OnGlobalLayoutListener f391944j = new ViewTreeObserverOnGlobalLayoutListenerC10141a();

    /* renamed from: k, reason: collision with root package name */
    int f391945k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f391946l = 0;

    /* renamed from: n, reason: collision with root package name */
    boolean f391948n = false;

    /* renamed from: a, reason: collision with root package name */
    final String f391935a = "AvTipsView_" + com.tencent.av.utils.e.d();

    /* compiled from: P */
    /* renamed from: cw.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class ViewTreeObserverOnGlobalLayoutListenerC10141a implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC10141a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a aVar = a.this;
            if (aVar.f391937c == null) {
                return;
            }
            aVar.k(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        int f391950a = -1;

        /* renamed from: b, reason: collision with root package name */
        int f391951b = -552421387;

        /* renamed from: c, reason: collision with root package name */
        int f391952c = -15550475;

        /* renamed from: d, reason: collision with root package name */
        int f391953d = 14;

        /* renamed from: e, reason: collision with root package name */
        LinearLayout f391954e = null;

        b() {
        }

        void a(int i3) {
            LinearLayout linearLayout = this.f391954e;
            if (linearLayout != null) {
                linearLayout.setVisibility(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c extends b {

        /* renamed from: f, reason: collision with root package name */
        ImageView f391955f;

        /* renamed from: g, reason: collision with root package name */
        ImageView f391956g;

        /* renamed from: h, reason: collision with root package name */
        ProgressBar f391957h;

        /* renamed from: i, reason: collision with root package name */
        TextView f391958i;

        /* renamed from: j, reason: collision with root package name */
        View f391959j;

        c(LinearLayout linearLayout) {
            this.f391954e = linearLayout;
            this.f391955f = (ImageView) linearLayout.findViewById(m.i.f76045d);
            this.f391958i = (TextView) linearLayout.findViewById(m.i.f76044c);
            this.f391956g = (ImageView) linearLayout.findViewById(m.i.f76042a);
            this.f391957h = (ProgressBar) linearLayout.findViewById(m.i.f76043b);
            this.f391959j = linearLayout.findViewById(m.i.f76046e);
        }

        Resources b() {
            return this.f391958i.getResources();
        }

        void c() {
            if (!d()) {
                return;
            }
            ImageView imageView = this.f391955f;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.f391955f.setImageBitmap(null);
            }
            TextView textView = this.f391958i;
            if (textView != null) {
                textView.setVisibility(4);
            }
            ImageView imageView2 = this.f391956g;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ProgressBar progressBar = this.f391957h;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            View view = this.f391959j;
            if (view != null) {
                view.setVisibility(8);
            }
            LinearLayout linearLayout = this.f391954e;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }

        boolean d() {
            if (this.f391958i != null && this.f391957h != null) {
                return true;
            }
            return false;
        }

        boolean e(f fVar) {
            boolean z16;
            View view;
            ImageView imageView;
            ProgressBar progressBar;
            Bitmap bitmap;
            ImageView imageView2;
            c();
            if (fVar.f391967b && (bitmap = fVar.f391969d) != null && (imageView2 = this.f391955f) != null) {
                imageView2.setImageBitmap(bitmap);
                this.f391955f.setVisibility(0);
            }
            if (fVar.f391968c && (progressBar = this.f391957h) != null) {
                progressBar.setVisibility(0);
            }
            if (fVar.f391966a && (imageView = this.f391956g) != null) {
                imageView.setVisibility(0);
                ImageView imageView3 = this.f391956g;
                int i3 = fVar.f391974i;
                if (i3 <= 0) {
                    i3 = R.drawable.de5;
                }
                imageView3.setImageResource(i3);
            }
            if (fVar.f391975j != null && this.f391958i != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                a.B(this.f391958i, fVar);
            }
            if (z16 && (view = this.f391959j) != null) {
                view.setVisibility(0);
            }
            LinearLayout linearLayout = this.f391954e;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d extends b {

        /* renamed from: f, reason: collision with root package name */
        private LinearLayout f391960f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f391961g;

        /* renamed from: h, reason: collision with root package name */
        private TextView f391962h;

        public d(ViewGroup viewGroup) {
            if (viewGroup == null) {
                return;
            }
            this.f391954e = (LinearLayout) viewGroup.findViewById(m.d.f76011i);
            this.f391960f = (LinearLayout) viewGroup.findViewById(m.f.f76031a);
            this.f391962h = (TextView) viewGroup.findViewById(m.i.f76044c);
            LinearLayout linearLayout = this.f391960f;
            if (linearLayout == null) {
                return;
            }
            this.f391961g = (TextView) linearLayout.findViewById(m.f.f76032b);
        }

        public void b() {
            c();
            this.f391960f = null;
            this.f391961g = null;
            this.f391962h = null;
        }

        public void c() {
            LinearLayout linearLayout = this.f391960f;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
        }

        public boolean d(cw.c cVar) {
            LinearLayout linearLayout = this.f391960f;
            if (linearLayout == null || cVar == null) {
                return false;
            }
            linearLayout.setVisibility(0);
            this.f391960f.setOnClickListener(cVar.b());
            TextView textView = this.f391961g;
            if (textView != null) {
                textView.setText(cVar.a());
                this.f391961g.setVisibility(0);
            }
            TextView textView2 = this.f391962h;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            a(0);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class e extends b {

        /* renamed from: f, reason: collision with root package name */
        TextView f391963f;

        /* renamed from: g, reason: collision with root package name */
        Button f391964g;

        /* renamed from: h, reason: collision with root package name */
        View f391965h;

        e(LinearLayout linearLayout) {
            this.f391954e = linearLayout;
            this.f391963f = (TextView) linearLayout.findViewById(m.i.f76048g);
            this.f391964g = (Button) linearLayout.findViewById(m.i.f76049h);
            this.f391965h = linearLayout.findViewById(m.i.f76047f);
        }

        Resources b() {
            return this.f391963f.getResources();
        }

        void c() {
            if (!d()) {
                return;
            }
            this.f391963f.setVisibility(8);
            this.f391965h.setVisibility(8);
        }

        boolean d() {
            if (this.f391963f != null) {
                return true;
            }
            return false;
        }

        boolean e(f fVar) {
            TextView textView;
            c();
            if (fVar.f391975j == null || (textView = this.f391963f) == null) {
                return false;
            }
            a.B(textView, fVar);
            this.f391965h.setVisibility(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        boolean f391966a = false;

        /* renamed from: b, reason: collision with root package name */
        boolean f391967b = false;

        /* renamed from: c, reason: collision with root package name */
        boolean f391968c = false;

        /* renamed from: d, reason: collision with root package name */
        Bitmap f391969d = null;

        /* renamed from: e, reason: collision with root package name */
        int f391970e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f391971f = -1;

        /* renamed from: g, reason: collision with root package name */
        int f391972g = -1;

        /* renamed from: h, reason: collision with root package name */
        int f391973h = -1;

        /* renamed from: i, reason: collision with root package name */
        int f391974i = -1;

        /* renamed from: j, reason: collision with root package name */
        SpannableString f391975j = null;

        /* renamed from: k, reason: collision with root package name */
        boolean f391976k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f391977l = false;

        /* renamed from: m, reason: collision with root package name */
        boolean f391978m = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: cw.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C10142a extends c.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View.OnClickListener f391979d;

            C10142a(View.OnClickListener onClickListener) {
                this.f391979d = onClickListener;
            }

            @Override // dw.c.a, android.text.style.ClickableSpan
            public void onClick(View view) {
                View.OnClickListener onClickListener = this.f391979d;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }

        f() {
        }

        static f a(Resources resources, dw.b bVar, b bVar2) {
            int r16;
            f fVar = new f();
            if (!TextUtils.isEmpty(bVar.g())) {
                fVar.f391975j = new SpannableString(bVar.g());
            }
            fVar.f391970e = bVar2.f391953d;
            fVar.f391971f = bVar2.f391950a;
            fVar.f391972g = bVar2.f391951b;
            fVar.f391973h = bVar2.f391952c;
            int h16 = bVar.h();
            if (h16 != 1) {
                if (h16 != 2) {
                    if (h16 == 3) {
                        dw.c cVar = (dw.c) bVar;
                        int i3 = -1;
                        if (cVar.v() != -1) {
                            fVar.f391970e = cVar.v();
                        }
                        if (cVar.s() != -1) {
                            fVar.f391972g = cVar.s();
                        }
                        if (cVar.t() != -1) {
                            fVar.f391973h = cVar.t();
                        }
                        fVar.f391977l = cVar.u();
                        fVar.f391978m = cVar.w();
                        if (fVar.f391975j != null) {
                            int q16 = cVar.q();
                            if (cVar.r() == -1) {
                                r16 = bVar.g().length();
                            } else {
                                r16 = cVar.r();
                            }
                            int i16 = r16 + q16;
                            fVar.f391975j.setSpan(new C10142a(cVar.y()), q16, i16, 33);
                            if (!cVar.u()) {
                                i3 = fVar.f391972g;
                            }
                            fVar.f391975j.setSpan(new ForegroundColorSpan(i3), q16, i16, 17);
                        }
                    }
                } else {
                    dw.e eVar = (dw.e) bVar;
                    fVar.f391968c = eVar.l();
                    fVar.f391976k = eVar.k();
                }
            } else {
                dw.d dVar = (dw.d) bVar;
                if (dVar.k() instanceof BitmapDrawable) {
                    fVar.f391969d = ((BitmapDrawable) dVar.k()).getBitmap();
                } else {
                    String m3 = dVar.m();
                    if (!TextUtils.isEmpty(m3)) {
                        fVar.f391969d = u.b(resources, m3);
                    }
                }
                int l3 = dVar.l();
                if (l3 != 1) {
                    if (l3 == 2) {
                        fVar.f391967b = true;
                    }
                } else {
                    fVar.f391966a = true;
                    fVar.f391974i = dVar.n();
                }
            }
            return fVar;
        }

        static void b(TextView textView, int i3, int i16, boolean z16) {
            textView.setTag(R.id.jat, Integer.valueOf(i16));
            textView.setTag(R.id.jau, Integer.valueOf(i3));
            textView.setHighlightColor(0);
            cw.d dVar = (cw.d) cw.d.getInstance();
            dVar.b(z16);
            textView.setMovementMethod(dVar);
        }
    }

    static void B(TextView textView, f fVar) {
        textView.setTextSize(fVar.f391970e);
        textView.setTextColor(fVar.f391971f);
        textView.setText(fVar.f391975j);
        textView.setVisibility(0);
        f.b(textView, fVar.f391972g, fVar.f391973h, fVar.f391977l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        if (r1 != 1) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        boolean z16;
        int i3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f391938d.getLayoutParams();
        layoutParams.height = -2;
        SessionInfo f16 = n.e().f();
        if (f16 != null && f16.S0 == 3) {
            int i16 = f16.f73046k2;
            z16 = true;
            if (i16 != 2) {
            }
            if (!z16) {
                i3 = this.f391943i;
            } else {
                i3 = this.f391942h;
            }
            layoutParams.bottomMargin = i3;
            layoutParams.addRule(14, -1);
            layoutParams.addRule(12);
        }
        z16 = false;
        if (!z16) {
        }
        layoutParams.bottomMargin = i3;
        layoutParams.addRule(14, -1);
        layoutParams.addRule(12);
    }

    @SuppressLint({"NewApi"})
    private void s(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.a8x);
        int f16 = BaseAIOUtils.f(156.0f, context.getResources());
        this.f391942h = ((displayMetrics.widthPixels - (dimensionPixelSize * 5)) / 4) + f16;
        this.f391943i = f16;
        QLog.d(this.f391935a, 1, "initData, widthPixels[" + displayMetrics.widthPixels + "], heightPixels[" + displayMetrics.heightPixels + "], density[" + displayMetrics.density + "], densityDpi[" + displayMetrics.densityDpi + "], xdpi[" + displayMetrics.xdpi + "], ydpi[" + displayMetrics.ydpi + "], px[" + f16 + "], mBottomMargin[" + this.f391942h + "], mBottomMarginForScreenShare[" + this.f391943i + "]");
    }

    private boolean t() {
        return true;
    }

    private void x(String str) {
        c cVar = this.f391940f;
        if (cVar != null && cVar.f391954e != null && !TextUtils.isEmpty(str)) {
            LinearLayout linearLayout = this.f391940f.f391954e;
            VideoReport.setElementId(linearLayout, "em_bas_tips");
            VideoReport.setElementClickPolicy(linearLayout, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(linearLayout, ExposurePolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put("tips_name", str);
            VideoReport.reportEvent("dt_imp", linearLayout, hashMap);
        }
    }

    public void A(long j3, float f16) {
        if (this.f391938d != null && !t()) {
            float rotation = this.f391938d.getRotation();
            if (rotation != f16) {
                QLog.w(this.f391935a, 1, "setRotation, rotation[" + rotation + "->" + f16 + "], seq[" + j3 + "]");
                this.f391938d.setRotation(f16);
                k(true);
            }
        }
    }

    public void C(boolean z16, View.OnClickListener onClickListener) {
        Button button;
        int i3;
        e eVar = this.f391941g;
        if (eVar != null && (button = eVar.f391964g) != null) {
            button.setOnClickListener(onClickListener);
            if (z16) {
                aw.c(this.f391941g.f391964g, R.drawable.dao, R.color.f157470qb);
            }
            Button button2 = this.f391941g.f391964g;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            button2.setVisibility(i3);
        }
    }

    @Override // cw.b
    public boolean a() {
        e eVar = this.f391941g;
        if (eVar == null) {
            return false;
        }
        return eVar.d();
    }

    @Override // cw.b
    public boolean b() {
        c cVar = this.f391940f;
        if (cVar == null) {
            return false;
        }
        return cVar.d();
    }

    @Override // cw.b
    public void c() {
        d dVar = this.f391939e;
        if (dVar == null) {
            return;
        }
        dVar.c();
    }

    @Override // cw.b
    public void d() {
        c cVar = this.f391940f;
        if (cVar != null) {
            cVar.a(0);
        }
        e eVar = this.f391941g;
        if (eVar != null) {
            eVar.a(0);
        }
    }

    @Override // cw.b
    public void e() {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f391935a, 1, "RemoveMainTipsView");
        }
        c cVar = this.f391940f;
        if (cVar != null) {
            cVar.c();
        }
        this.f391936b = false;
        QZoneVideoContactsFeedHelper.b();
    }

    @Override // cw.b
    public void f() {
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f391935a, 1, "RemoveSubTipView");
        }
        e eVar = this.f391941g;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // cw.b
    public void g() {
        c cVar = this.f391940f;
        if (cVar != null) {
            cVar.a(4);
        }
        e eVar = this.f391941g;
        if (eVar != null) {
            eVar.a(4);
        }
    }

    @Override // cw.b
    public boolean h(dw.b bVar) {
        e eVar = this.f391941g;
        if (eVar == null) {
            return false;
        }
        f a16 = f.a(eVar.b(), bVar, this.f391941g);
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f391935a, 1, "ShowSubTipsView, tipsInfo[" + ((Object) a16.f391975j) + "]");
        }
        return this.f391941g.e(a16);
    }

    @Override // cw.b
    public boolean i(dw.b bVar) {
        LinearLayout linearLayout;
        c cVar = this.f391940f;
        if (cVar == null) {
            return false;
        }
        f a16 = f.a(cVar.b(), bVar, this.f391940f);
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f391935a, 1, "ShowMainTipsView, tipsInfo[" + ((Object) a16.f391975j) + "]");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.g())) {
            x(bVar.g());
        }
        c();
        this.f391936b = true;
        boolean e16 = this.f391940f.e(a16);
        if (e16 && AppSetting.f99565y && (linearLayout = this.f391940f.f391954e) != null && bVar != null) {
            try {
                com.tencent.mobileqq.util.c.a(linearLayout, bVar.g());
            } catch (Exception e17) {
                QLog.e(this.f391935a, 1, "speak error\n", e17);
                VideoAppInterface videoAppInterface = this.f391947m;
                if (videoAppInterface != null) {
                    videoAppInterface.z0();
                }
            }
        }
        return e16;
    }

    @Override // cw.b
    public boolean j(cw.c cVar) {
        d dVar = this.f391939e;
        if (dVar == null || this.f391936b) {
            return false;
        }
        return dVar.d(cVar);
    }

    void k(boolean z16) {
        boolean z17;
        boolean z18;
        if (this.f391937c == null) {
            return;
        }
        if (t()) {
            p();
            return;
        }
        int width = this.f391937c.getWidth();
        int height = this.f391937c.getHeight();
        if (this.f391945k == width && this.f391946l == height && !z16) {
            return;
        }
        String str = this.f391935a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("adjustPos, w[");
        sb5.append(this.f391945k);
        sb5.append("->");
        sb5.append(width);
        sb5.append("], h[");
        sb5.append(this.f391946l);
        sb5.append("->");
        sb5.append(height);
        sb5.append("], force[");
        sb5.append(z16);
        sb5.append("], tips_layout[");
        int i3 = 0;
        if (this.f391938d != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        if (this.f391938d == null) {
            return;
        }
        this.f391945k = width;
        this.f391946l = height;
        SessionInfo f16 = n.e().f();
        int i16 = f16.f73035i;
        if (i16 == 2) {
            if (!f16.O && !f16.N) {
                i16 = 1;
            }
        } else if (i16 == 4 || i16 == 3) {
            if (f16.f73045k1.size() > 0) {
                if (!f16.P1 && !f16.f73045k1.get(0).f73830d) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                i3 = f16.f73045k1.get(0).f73828b;
            } else {
                z18 = true;
            }
            i16 = (!z18 || i3 == 0) ? 3 : 4;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f391935a, 1, "adjustPos, sessionType[" + f16.f73035i + "->" + i16 + "]");
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f391938d.getLayoutParams();
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        o(layoutParams);
                    }
                } else {
                    n(layoutParams);
                }
            } else {
                m(layoutParams);
            }
        } else {
            l(layoutParams);
        }
        this.f391938d.setLayoutParams(layoutParams);
    }

    void l(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.height = -2;
        layoutParams.topMargin = this.f391946l + ((int) ba.dp2px(this.f391938d.getContext(), 6.0f));
        layoutParams.addRule(14, -1);
        layoutParams.addRule(13, 0);
    }

    void m(RelativeLayout.LayoutParams layoutParams) {
        if (this.f391938d.getRotation() % 180.0f == 0.0f) {
            layoutParams.height = -2;
            layoutParams.topMargin = (int) ba.dp2px(this.f391938d.getContext(), 188.0f);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(13, 0);
            return;
        }
        layoutParams.height = (ba.getScreenWidth(this.f391938d.getContext()) * 23) / 25;
        layoutParams.topMargin = 0;
        layoutParams.addRule(14, 0);
        layoutParams.addRule(13, -1);
    }

    void n(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.height = -2;
        layoutParams.topMargin = this.f391946l + ((int) ba.dp2px(this.f391938d.getContext(), 6.0f));
        layoutParams.addRule(14, -1);
        layoutParams.addRule(13, 0);
    }

    void o(RelativeLayout.LayoutParams layoutParams) {
        if (this.f391938d.getRotation() % 180.0f == 0.0f) {
            layoutParams.height = -2;
            layoutParams.topMargin = (int) ba.dp2px(this.f391938d.getContext(), 188.0f);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(13, 0);
            return;
        }
        layoutParams.height = (ba.getScreenWidth(this.f391938d.getContext()) * 23) / 25;
        layoutParams.topMargin = 0;
        layoutParams.addRule(14, 0);
        layoutParams.addRule(13, -1);
    }

    void q() {
        boolean z16;
        if (com.tencent.av.utils.e.k()) {
            String str = this.f391935a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("attach, isAttach[");
            sb5.append(this.f391948n);
            sb5.append("], titleBar[");
            if (this.f391937c != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
        }
        if (this.f391948n) {
            r();
        }
        if (!this.f391948n) {
            ((ju.a) this.f391947m.B(11)).C(this);
        }
        this.f391948n = true;
        View view = this.f391937c;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.f391944j);
        }
        k(true);
    }

    void r() {
        boolean z16;
        if (com.tencent.av.utils.e.k()) {
            String str = this.f391935a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("detach, isAttach[");
            sb5.append(this.f391948n);
            sb5.append("], qav_activity_root[");
            if (this.f391937c != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
        }
        if (this.f391948n) {
            ((ju.a) this.f391947m.B(11)).C(null);
        }
        this.f391948n = false;
        View view = this.f391937c;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f391944j);
        }
    }

    public void u(VideoAppInterface videoAppInterface, ViewGroup viewGroup) {
        this.f391937c = viewGroup.findViewById(m.d.f76006d);
        this.f391938d = (LinearLayout) viewGroup.findViewById(m.d.f76011i);
        this.f391947m = videoAppInterface;
        this.f391939e = new d(viewGroup);
        this.f391940f = new c(this.f391938d);
        this.f391941g = new e(this.f391938d);
        s(viewGroup.getContext());
        q();
    }

    public void v() {
        if (this.f391948n) {
            r();
        }
        ((ju.a) this.f391947m.B(11)).B();
        this.f391937c = null;
        this.f391938d = null;
        d dVar = this.f391939e;
        if (dVar != null) {
            dVar.b();
            this.f391939e = null;
        }
        this.f391940f = null;
        this.f391941g = null;
    }

    public void w(VideoAppInterface videoAppInterface) {
        q();
    }

    public void y(int i3) {
        ProgressBar progressBar;
        c cVar = this.f391940f;
        if (cVar != null && (progressBar = cVar.f391957h) != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(-11113603, PorterDuff.Mode.MULTIPLY);
        }
    }

    public void z(int i3) {
        c cVar = this.f391940f;
        if (cVar != null) {
            cVar.f391950a = i3;
        }
    }
}
