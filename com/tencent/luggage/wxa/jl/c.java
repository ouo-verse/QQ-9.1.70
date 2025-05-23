package com.tencent.luggage.wxa.jl;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.lo.o;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends View.AccessibilityDelegate {

    /* renamed from: l */
    public static final a f131190l = new a(null);

    /* renamed from: m */
    public static final Lazy f131191m;

    /* renamed from: a */
    public final View f131192a;

    /* renamed from: b */
    public final Class f131193b;

    /* renamed from: c */
    public final String f131194c;

    /* renamed from: d */
    public final boolean f131195d;

    /* renamed from: e */
    public final Boolean f131196e;

    /* renamed from: f */
    public final Boolean f131197f;

    /* renamed from: g */
    public final String f131198g;

    /* renamed from: h */
    public final Function0 f131199h;

    /* renamed from: i */
    public final Rect f131200i;

    /* renamed from: j */
    public final Rect f131201j;

    /* renamed from: k */
    public final Lazy f131202k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jl.c$a$a */
        /* loaded from: classes8.dex */
        public static final class C6343a implements com.tencent.luggage.wxa.jl.b {
            @Override // com.tencent.luggage.wxa.jl.b
            public void a(View view, int i3, int i16, int i17, int i18) {
                View view2;
                Intrinsics.checkNotNullParameter(view, "view");
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.left -= i3;
                rect.top -= i16;
                rect.right += i17;
                rect.bottom += i18;
                Object parent = view.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ View f131203a;

            /* renamed from: b */
            public final /* synthetic */ int f131204b;

            /* renamed from: c */
            public final /* synthetic */ int f131205c;

            /* renamed from: d */
            public final /* synthetic */ int f131206d;

            /* renamed from: e */
            public final /* synthetic */ int f131207e;

            public b(View view, int i3, int i16, int i17, int i18) {
                this.f131203a = view;
                this.f131204b = i3;
                this.f131205c = i16;
                this.f131206d = i17;
                this.f131207e = i18;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.f131190l.a().a(this.f131203a, this.f131204b, this.f131205c, this.f131206d, this.f131207e);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.tencent.luggage.wxa.jl.b a() {
            return (com.tencent.luggage.wxa.jl.b) c.f131191m.getValue();
        }

        public static /* synthetic */ void a(a aVar, View view, Class cls, Integer num, boolean z16, Boolean bool, Boolean bool2, Integer num2, Function0 function0, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int i3, Object obj) {
            aVar.a(view, (i3 & 2) != 0 ? null : cls, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? null : bool, (i3 & 32) != 0 ? null : bool2, (i3 & 64) != 0 ? null : num2, (i3 & 128) != 0 ? null : function0, (i3 & 256) != 0 ? null : num3, (i3 & 512) != 0 ? null : num4, (i3 & 1024) != 0 ? null : num5, (i3 & 2048) != 0 ? null : num6, (i3 & 4096) == 0 ? num7 : null);
        }

        public final void a(View view, Class cls, Integer num, boolean z16, Boolean bool, Boolean bool2, Integer num2, Function0 function0, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
            Intrinsics.checkNotNullParameter(view, "view");
            Rect rect = null;
            String string = num != null ? view.getContext().getString(num.intValue()) : null;
            String string2 = num2 != null ? view.getContext().getString(num2.intValue()) : null;
            int c16 = num7 != null ? o.c(view.getContext(), num7.intValue()) : 0;
            int a16 = num3 != null ? o.a(view.getContext(), num3.intValue()) : c16;
            int a17 = num4 != null ? o.a(view.getContext(), num4.intValue()) : c16;
            int a18 = num5 != null ? o.a(view.getContext(), num5.intValue()) : c16;
            if (num6 != null) {
                c16 = o.a(view.getContext(), num6.intValue());
            }
            int i3 = c16;
            if (a16 != 0 || a17 != 0 || a18 != 0 || i3 != 0) {
                view.post(new b(view, a16, a18, a17, i3));
                rect = new Rect(a16, a18, a17, i3);
            }
            view.setAccessibilityDelegate(new c(view, cls, string, z16, bool, bool2, string2, function0, rect, null));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a */
        public static final b f131208a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final com.tencent.luggage.wxa.jl.b invoke() {
            com.tencent.luggage.wxa.jl.b bVar = (com.tencent.luggage.wxa.jl.b) g.a(com.tencent.luggage.wxa.jl.b.class);
            if (bVar == null) {
                return new a.C6343a();
            }
            return bVar;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.jl.c$c */
    /* loaded from: classes8.dex */
    public static final class C6344c extends Lambda implements Function0 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.jl.c$c$a */
        /* loaded from: classes8.dex */
        public static final class a extends AccessibilityNodeProvider {

            /* renamed from: a */
            public final /* synthetic */ c f131210a;

            public a(c cVar) {
                this.f131210a = cVar;
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.f131210a.f131192a);
                this.f131210a.f131192a.onInitializeAccessibilityNodeInfo(obtain);
                if (obtain != null) {
                    obtain.getBoundsInScreen(this.f131210a.f131201j);
                }
                Rect rect = this.f131210a.f131201j;
                c cVar = this.f131210a;
                rect.left -= cVar.f131200i.left;
                rect.top -= cVar.f131200i.top;
                rect.right += cVar.f131200i.right;
                rect.bottom += cVar.f131200i.bottom;
                if (obtain != null) {
                    obtain.setBoundsInScreen(this.f131210a.f131201j);
                }
                return obtain;
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public boolean performAction(int i3, int i16, Bundle bundle) {
                return this.f131210a.f131192a.performAccessibilityAction(i16, bundle);
            }
        }

        public C6344c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final a invoke() {
            if (c.this.f131200i == null) {
                return null;
            }
            return new a(c.this);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) b.f131208a);
        f131191m = lazy;
    }

    public /* synthetic */ c(View view, Class cls, String str, boolean z16, Boolean bool, Boolean bool2, String str2, Function0 function0, Rect rect, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, cls, str, z16, bool, bool2, str2, function0, rect);
    }

    public static final void a(View view, Class cls, Integer num, boolean z16, Boolean bool, Boolean bool2, Integer num2, Function0 function0, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        f131190l.a(view, cls, num, z16, bool, bool2, num2, function0, num3, num4, num5, num6, num7);
    }

    @Override // android.view.View.AccessibilityDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        C6344c.a b16 = b();
        if (b16 == null) {
            return super.getAccessibilityNodeProvider(host);
        }
        return b16;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        Class cls = this.f131193b;
        if (cls != null) {
            info.setClassName(cls.getName());
        }
        String str = this.f131194c;
        if (str != null) {
            info.setContentDescription(str);
        }
        if (this.f131195d) {
            info.setCollectionInfo(null);
        }
        Boolean bool = this.f131196e;
        if (bool != null) {
            info.setFocusable(bool.booleanValue());
        }
        Boolean bool2 = this.f131197f;
        if (bool2 != null) {
            info.setClickable(bool2.booleanValue());
        }
        if (this.f131198g != null) {
            info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, this.f131198g));
        }
        Function0 function0 = this.f131199h;
        if (function0 != null) {
            boolean booleanValue = ((Boolean) function0.invoke()).booleanValue();
            info.setCheckable(true);
            info.setChecked(booleanValue);
        }
    }

    public c(View view, Class cls, String str, boolean z16, Boolean bool, Boolean bool2, String str2, Function0 function0, Rect rect) {
        Lazy lazy;
        this.f131192a = view;
        this.f131193b = cls;
        this.f131194c = str;
        this.f131195d = z16;
        this.f131196e = bool;
        this.f131197f = bool2;
        this.f131198g = str2;
        this.f131199h = function0;
        this.f131200i = rect;
        this.f131201j = new Rect();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new C6344c());
        this.f131202k = lazy;
    }

    public final C6344c.a b() {
        return (C6344c.a) this.f131202k.getValue();
    }
}
