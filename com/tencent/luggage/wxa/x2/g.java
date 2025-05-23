package com.tencent.luggage.wxa.x2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ok.j;
import com.tencent.luggage.wxa.ok.l;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends DrawStatusBarFrameLayout implements j, l {
    public Function0 F;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f144549a;

        public a(Function0 function0) {
            this.f144549a = function0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.getParent() != null) {
                ((ViewGroup) g.this.getParent()).removeView(g.this);
            }
            Function0 function0 = this.f144549a;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public g(@NonNull Context context) {
        super(context);
        setVisibility(8);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void a(String str, String str2) {
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void c(Function0 function0) {
        post(new a(function0));
    }

    public final boolean m() {
        return false;
    }

    @Override // android.view.View
    public final boolean post(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && m()) {
            c0.a(runnable);
            return true;
        }
        return super.post(runnable);
    }

    @Override // android.view.View
    public final boolean postDelayed(Runnable runnable, long j3) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && m()) {
            c0.a(runnable, j3);
            return true;
        }
        return super.postDelayed(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public /* bridge */ /* synthetic */ void setAppServiceType(int i3) {
        o31.b.a(this, i3);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public /* bridge */ /* synthetic */ void setCanShowHideAnimation(boolean z16) {
        o31.b.b(this, z16);
    }

    @Override // com.tencent.luggage.wxa.ok.l
    public void a(Function0 function0) {
        this.F = function0;
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void setProgress(int i3) {
    }
}
