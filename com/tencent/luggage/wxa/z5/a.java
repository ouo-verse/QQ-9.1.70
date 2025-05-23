package com.tencent.luggage.wxa.z5;

import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.p5.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f146328a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z5.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6973a implements g.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Boolean[] f146329a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long[] f146330b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f146331c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View[] f146332d;

        public C6973a(Boolean[] boolArr, Long[] lArr, e eVar, View[] viewArr) {
            this.f146329a = boolArr;
            this.f146330b = lArr;
            this.f146331c = eVar;
            this.f146332d = viewArr;
        }

        @Override // com.tencent.luggage.wxa.xd.g.f
        public final void onReady() {
            ThreeDotsLoadingView threeDotsLoadingView;
            this.f146329a[0] = Boolean.TRUE;
            if (this.f146330b[0].longValue() > 0) {
                w.d("MicroMsg.MPEntryPageFastLoadHelper", "tryFastLoadEntryPage, onReady called with promptView shown, appId[" + this.f146331c.getRuntime().getAppId() + "], time diff: " + (w0.a() - this.f146330b[0].longValue()));
            }
            View view = this.f146332d[0];
            if (view != null) {
                com.tencent.luggage.wxa.ok.a.a(view);
                if (view instanceof ThreeDotsLoadingView) {
                    threeDotsLoadingView = (ThreeDotsLoadingView) view;
                } else {
                    threeDotsLoadingView = null;
                }
                if (threeDotsLoadingView != null) {
                    threeDotsLoadingView.stopLoadingAnimation();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Boolean[] f146333a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f146334b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View[] f146335c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long[] f146336d;

        public b(Boolean[] boolArr, e eVar, View[] viewArr, Long[] lArr) {
            this.f146333a = boolArr;
            this.f146334b = eVar;
            this.f146335c = viewArr;
            this.f146336d = lArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup;
            if (this.f146333a[0].booleanValue()) {
                return;
            }
            View contentView = this.f146334b.getContentView();
            if (contentView instanceof ViewGroup) {
                viewGroup = (ViewGroup) contentView;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                View a16 = a.f146328a.a(viewGroup);
                e eVar = this.f146334b;
                View[] viewArr = this.f146335c;
                Long[] lArr = this.f146336d;
                w.d("MicroMsg.MPEntryPageFastLoadHelper", "tryFastLoadEntryPage, show promptView, appId[" + eVar.getRuntime().getAppId() + ']');
                viewArr[0] = a16;
                lArr[0] = Long.valueOf(w0.a());
                eVar.u0().a(a16, 10000L);
                eVar.getRuntime().p0();
            }
        }
    }

    public static final void a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        if (eVar.getRuntime() == null || eVar.getRuntime().t0() || eVar.getRuntime().Q1() || !eVar.J0()) {
            return;
        }
        if (!eVar.W().k() || (eVar.b0() instanceof com.tencent.luggage.wxa.kj.g)) {
            Boolean[] boolArr = {Boolean.FALSE};
            View[] viewArr = new View[1];
            Long[] lArr = {0L};
            eVar.a(new C6973a(boolArr, lArr, eVar, viewArr));
            View contentView = eVar.getContentView();
            if (contentView != null) {
                contentView.post(new b(boolArr, eVar, viewArr, lArr));
            }
        }
    }

    public final View a(ViewGroup viewGroup) {
        int roundToInt;
        ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(viewGroup.getContext(), R.style.ay8));
        progressBar.setIndeterminateDrawable(ContextCompat.getDrawable(progressBar.getContext(), R.drawable.k7a));
        roundToInt = MathKt__MathJVMKt.roundToInt(progressBar.getContext().getResources().getDisplayMetrics().density * 36);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(roundToInt, roundToInt));
        return progressBar;
    }
}
