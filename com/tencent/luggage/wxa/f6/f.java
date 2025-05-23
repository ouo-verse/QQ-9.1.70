package com.tencent.luggage.wxa.f6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.h6.q;
import com.tencent.luggage.wxa.j4.a;
import com.tencent.luggage.wxa.n3.p0;
import com.tencent.luggage.wxa.xd.m;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.R;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.ok.c {

    /* renamed from: c0, reason: collision with root package name */
    public TextView f125391c0;

    public f(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.luggage.wxa.ok.c
    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        super.a(gVar);
        com.tencent.luggage.wxa.er.a.b(gVar instanceof com.tencent.luggage.wxa.p5.f);
        com.tencent.luggage.wxa.er.a.b(gVar.c(com.tencent.luggage.wxa.p5.a.class));
        gVar.a((m) new com.tencent.luggage.wxa.p5.a((com.tencent.luggage.wxa.p5.f) gVar, this));
        ImageView imageView = (ImageView) findViewById(R.id.f124967ks);
        boolean l3 = ((com.tencent.luggage.wxa.j4.d) this.I.S()).l();
        if (l3) {
            this.f125391c0.setVisibility(0);
            imageView.setImageResource(R.drawable.ox_);
        } else {
            this.f125391c0.setVisibility(8);
            imageView.setImageResource(R.drawable.oxa);
        }
        p0.f135239a.a(((com.tencent.luggage.wxa.j4.d) this.I.S()).I);
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).bottomMargin = d(l3);
        setWindowAndroid(gVar.n0());
    }

    public final int d(boolean z16) {
        float dimension;
        if (z16) {
            dimension = getContext().getResources().getDimension(R.dimen.dkq);
        } else {
            dimension = getContext().getResources().getDimension(R.dimen.dkr);
        }
        return (int) dimension;
    }

    @Override // com.tencent.luggage.wxa.ok.c
    public int getLayoutId() {
        return R.layout.i8e;
    }

    @Override // com.tencent.luggage.wxa.ok.c, com.tencent.luggage.wxa.ok.i, com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Activity j3;
        super.onAttachedToWindow();
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        if (gVar == null) {
            return;
        }
        try {
            if (!(gVar.n0() instanceof WindowAndroidActivityImpl) || (j3 = ((WindowAndroidActivityImpl) this.I.n0()).j()) == null) {
                return;
            }
            com.tencent.luggage.wxa.xj.g.a(j3).c();
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.ok.i, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.M.a();
    }

    @Override // com.tencent.luggage.wxa.ok.c
    public void r() {
        setClickable(true);
        super.r();
        TextView textView = (TextView) findViewById(R.id.f124957kr);
        this.f125391c0 = textView;
        textView.setVisibility(8);
        if (q.b()) {
            findViewById(R.id.f164368st0).setVisibility(4);
        }
    }

    public f(@NonNull com.tencent.luggage.wxa.wj.c cVar) {
        super(cVar.getContext());
        setWindowAndroid(cVar);
    }

    public f(@NonNull Context context, com.tencent.luggage.wxa.p5.f fVar) {
        super(context, fVar);
        a(fVar);
    }

    public f(@NonNull com.tencent.luggage.wxa.wj.c cVar, com.tencent.luggage.wxa.p5.f fVar) {
        super(cVar.getContext(), fVar);
        setWindowAndroid(cVar);
        a(fVar);
    }

    @Override // com.tencent.luggage.wxa.ok.c
    public void a(Configuration configuration) {
        Activity activity;
        boolean isInMultiWindowMode;
        com.tencent.luggage.wxa.ic.g gVar = this.I;
        if (gVar == null) {
            return;
        }
        if (gVar.n0() instanceof WindowAndroidActivityImpl) {
            activity = ((WindowAndroidActivityImpl) this.I.n0()).j();
        } else {
            this.I.n0();
            activity = null;
        }
        a.EnumC6326a enumC6326a = ((com.tencent.luggage.wxa.j4.a) this.I.a(com.tencent.luggage.wxa.j4.a.class)).f130781b;
        com.tencent.luggage.wxa.ic.g gVar2 = this.I;
        boolean z16 = (gVar2 instanceof com.tencent.luggage.wxa.p5.f) && ((com.tencent.luggage.wxa.p5.f) gVar2).Q1();
        if (z16 && activity != null && Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode && activity.getRequestedOrientation() == 1) {
                return;
            }
        }
        if (activity != null) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            if (z16) {
                window.addFlags(1024);
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4 | 256);
            } else {
                window.clearFlags(1024);
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-5));
            }
            if (enumC6326a == a.EnumC6326a.FULLSCREEN) {
                com.tencent.luggage.wxa.ok.g.a((Context) activity, true);
                return;
            }
            if (enumC6326a == a.EnumC6326a.HIDE_STATUS_BAR) {
                com.tencent.luggage.wxa.ok.g.c((Context) activity, true);
                return;
            }
            if (enumC6326a == a.EnumC6326a.HIDE_NAVIGATION_BAR) {
                com.tencent.luggage.wxa.ok.g.b((Context) activity, true);
                com.tencent.luggage.wxa.lo.f.b(activity.getWindow(), !l.f126905a.a(this.I.getAppId()));
            } else {
                if (z16) {
                    return;
                }
                com.tencent.luggage.wxa.ok.g.a((Context) activity, false);
                com.tencent.luggage.wxa.lo.f.b(activity.getWindow(), !l.f126905a.a(this.I.getAppId()));
            }
        }
    }
}
