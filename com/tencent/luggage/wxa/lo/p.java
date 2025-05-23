package com.tencent.luggage.wxa.lo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: j, reason: collision with root package name */
    public static final a f133752j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f133753a;

    /* renamed from: b, reason: collision with root package name */
    public ObjectAnimator f133754b;

    /* renamed from: c, reason: collision with root package name */
    public d f133755c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f133756d;

    /* renamed from: e, reason: collision with root package name */
    public d f133757e;

    /* renamed from: f, reason: collision with root package name */
    public ObjectAnimator f133758f;

    /* renamed from: g, reason: collision with root package name */
    public d f133759g;

    /* renamed from: h, reason: collision with root package name */
    public ObjectAnimator f133760h;

    /* renamed from: i, reason: collision with root package name */
    public d f133761i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public p(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f133753a = context;
    }

    public final float a() {
        return q.b(this.f133753a).x;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(View view, Function0 function0, float f16) {
        boolean z16;
        d dVar;
        ObjectAnimator objectAnimator;
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator objectAnimator2 = this.f133754b;
        if (objectAnimator2 != null) {
            Object target = objectAnimator2.getTarget();
            if (target instanceof View) {
                view2 = (View) target;
            } else {
                view2 = null;
            }
            if (Intrinsics.areEqual(view2, view)) {
                a("WeUISlideAnimHelper", "slideFromRight view:" + view.hashCode() + " reuseAnim");
                dVar = this.f133755c;
                if (dVar != null) {
                    dVar.a(view, function0);
                }
                objectAnimator = this.f133754b;
                if (objectAnimator == null) {
                    objectAnimator.start();
                    return;
                }
                return;
            }
        }
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = a();
        }
        this.f133754b = ObjectAnimator.ofFloat(view, "translationX", f16, 0.0f);
        d dVar2 = this.f133755c;
        if (dVar2 == null) {
            dVar2 = new d();
        }
        this.f133755c = dVar2;
        ObjectAnimator objectAnimator3 = this.f133754b;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(dVar2);
        }
        ObjectAnimator objectAnimator4 = this.f133754b;
        if (objectAnimator4 != null) {
            objectAnimator4.setTarget(view);
        }
        dVar = this.f133755c;
        if (dVar != null) {
        }
        objectAnimator = this.f133754b;
        if (objectAnimator == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(View view, Function0 function0, float f16) {
        boolean z16;
        d dVar;
        ObjectAnimator objectAnimator;
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator objectAnimator2 = this.f133760h;
        if (objectAnimator2 != null) {
            Object target = objectAnimator2.getTarget();
            if (target instanceof View) {
                view2 = (View) target;
            } else {
                view2 = null;
            }
            if (Intrinsics.areEqual(view2, view)) {
                a("WeUISlideAnimHelper", "slideToLeftAnim view:" + view.hashCode() + " reuseAnim");
                dVar = this.f133761i;
                if (dVar != null) {
                    dVar.a(view, function0);
                }
                objectAnimator = this.f133760h;
                if (objectAnimator == null) {
                    objectAnimator.start();
                    return;
                }
                return;
            }
        }
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = a();
        }
        this.f133760h = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -f16);
        d dVar2 = this.f133761i;
        if (dVar2 == null) {
            dVar2 = new d();
        }
        this.f133761i = dVar2;
        ObjectAnimator objectAnimator3 = this.f133760h;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(dVar2);
        }
        ObjectAnimator objectAnimator4 = this.f133760h;
        if (objectAnimator4 != null) {
            objectAnimator4.setTarget(view);
        }
        dVar = this.f133761i;
        if (dVar != null) {
        }
        objectAnimator = this.f133760h;
        if (objectAnimator == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(View view, Function0 function0, float f16) {
        boolean z16;
        d dVar;
        ObjectAnimator objectAnimator;
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator objectAnimator2 = this.f133756d;
        if (objectAnimator2 != null) {
            Object target = objectAnimator2.getTarget();
            if (target instanceof View) {
                view2 = (View) target;
            } else {
                view2 = null;
            }
            if (Intrinsics.areEqual(view2, view)) {
                a("WeUISlideAnimHelper", "slideToRightAnim view:" + view.hashCode() + " reuseAnim");
                dVar = this.f133757e;
                if (dVar != null) {
                    dVar.a(view, function0);
                }
                objectAnimator = this.f133756d;
                if (objectAnimator == null) {
                    objectAnimator.start();
                    return;
                }
                return;
            }
        }
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = a();
        }
        this.f133756d = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f16);
        d dVar2 = this.f133757e;
        if (dVar2 == null) {
            dVar2 = new d();
        }
        this.f133757e = dVar2;
        ObjectAnimator objectAnimator3 = this.f133756d;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(dVar2);
        }
        ObjectAnimator objectAnimator4 = this.f133756d;
        if (objectAnimator4 != null) {
            objectAnimator4.setTarget(view);
        }
        dVar = this.f133757e;
        if (dVar != null) {
        }
        objectAnimator = this.f133756d;
        if (objectAnimator == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(View view, Function0 function0, float f16) {
        d dVar;
        ObjectAnimator objectAnimator;
        Intrinsics.checkNotNullParameter(view, "view");
        ObjectAnimator objectAnimator2 = this.f133758f;
        if (objectAnimator2 != null) {
            Object target = objectAnimator2.getTarget();
            if (Intrinsics.areEqual(target instanceof View ? (View) target : null, view)) {
                a("WeUISlideAnimHelper", "slideFromLeft view:" + view.hashCode() + " reuseAnim");
                dVar = this.f133759g;
                if (dVar != null) {
                    dVar.a(view, function0);
                }
                objectAnimator = this.f133758f;
                if (objectAnimator == null) {
                    objectAnimator.start();
                    return;
                }
                return;
            }
        }
        if (f16 == 0.0f) {
            f16 = a();
        }
        this.f133758f = ObjectAnimator.ofFloat(view, "translationX", -f16, 0.0f);
        d dVar2 = this.f133759g;
        if (dVar2 == null) {
            dVar2 = new d();
        }
        this.f133759g = dVar2;
        ObjectAnimator objectAnimator3 = this.f133758f;
        if (objectAnimator3 != null) {
            objectAnimator3.addListener(dVar2);
        }
        ObjectAnimator objectAnimator4 = this.f133758f;
        if (objectAnimator4 != null) {
            objectAnimator4.setTarget(view);
        }
        dVar = this.f133759g;
        if (dVar != null) {
        }
        objectAnimator = this.f133758f;
        if (objectAnimator == null) {
        }
    }

    public final void a(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        n.c(tag + "(Debug)", msg2, new Object[0]);
    }
}
