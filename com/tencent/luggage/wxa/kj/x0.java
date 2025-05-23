package com.tencent.luggage.wxa.kj;

import android.util.Log;
import com.tencent.luggage.wxa.mj.g;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class x0 implements com.tencent.luggage.wxa.mj.g {

    /* renamed from: a, reason: collision with root package name */
    public final v f132548a;

    /* renamed from: b, reason: collision with root package name */
    public final z f132549b;

    /* renamed from: c, reason: collision with root package name */
    public final String f132550c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132552b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f132553c;

        public a(x0 x0Var, boolean z16) {
            this.f132552b = x0Var;
            this.f132553c = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
            } else {
                this.f132552b.f132549b.setPullDownEnabled(this.f132553c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132555b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f132556c;

        public b(x0 x0Var, boolean z16) {
            this.f132555b = x0Var;
            this.f132556c = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
            } else {
                this.f132555b.f132549b.setPullDownEnabled(this.f132556c);
                this.f132555b.f132549b.a(this.f132556c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132558b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g.a f132559c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f132560d;

        public c(x0 x0Var, g.a aVar, int i3) {
            this.f132558b = x0Var;
            this.f132559c = aVar;
            this.f132560d = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
            } else {
                this.f132558b.f132549b.a(this.f132559c.b(), this.f132560d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132562b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f132563c;

        public d(x0 x0Var, String str) {
            this.f132562b = x0Var;
            this.f132563c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
            } else {
                this.f132562b.f132549b.setBackgroundTextStyle(this.f132563c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132565b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f132566c;

        public e(x0 x0Var, String str) {
            this.f132565b = x0Var;
            this.f132566c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
            } else {
                this.f132565b.f132549b.setPullDownText(this.f132566c);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132568b;

        public f(x0 x0Var) {
            this.f132568b = x0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.d(this.f132568b.f132550c, "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + this.f132568b.f132548a.getAppId() + " url:" + this.f132568b.f132548a.A0());
                try {
                    if (this.f132568b.f132548a.D0().getWebScrollY() != 0) {
                        this.f132568b.f132548a.D0().z();
                    }
                    this.f132568b.f132549b.a(true);
                    this.f132568b.f132549b.h();
                    return;
                } catch (NullPointerException e16) {
                    com.tencent.luggage.wxa.tn.w.b(this.f132568b.f132550c, "AppBrandPullDown OnUiThread startPullDownRefresh appId:" + this.f132568b.f132548a.getAppId() + " url:" + this.f132568b.f132548a.A0() + " e:" + e16);
                    throw e16;
                }
            }
            com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x0 f132570b;

        public g(x0 x0Var) {
            this.f132570b = x0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!x0.this.f132548a.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b(x0.this.f132550c, "runOnUiThread in ui-thread PageView destroyed");
            } else {
                this.f132570b.f132549b.r();
            }
        }
    }

    public x0(v mPageView, z mPullDownWrapper) {
        Intrinsics.checkNotNullParameter(mPageView, "mPageView");
        Intrinsics.checkNotNullParameter(mPullDownWrapper, "mPullDownWrapper");
        this.f132548a = mPageView;
        this.f132549b = mPullDownWrapper;
        this.f132550c = "Luggage.MPPageViewPullDownExtensionImpl";
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void a() {
        com.tencent.luggage.wxa.tn.w.d(this.f132550c, "AppBrandPullDown invoke entered startPullDownRefresh appId:" + this.f132548a.getAppId() + " url:" + this.f132548a.A0());
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new f(this));
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void b() {
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new g(this));
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void b(boolean z16) {
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new b(this, z16));
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void a(boolean z16) {
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new a(this, z16));
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void b(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new e(this, text));
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void a(g.a style, int i3) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new c(this, style, i3));
    }

    @Override // com.tencent.luggage.wxa.mj.g
    public void a(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (!this.f132548a.isRunning()) {
            com.tencent.luggage.wxa.tn.w.b(this.f132550c, "runOnUiThread PageView destroyed, stack=" + Log.getStackTraceString(new Throwable()));
            return;
        }
        this.f132548a.a(new d(this, style));
    }
}
