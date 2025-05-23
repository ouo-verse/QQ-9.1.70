package com.tencent.luggage.wxa.m4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.h6.o;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.kj.q1;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.kj.x;
import com.tencent.luggage.wxa.kj.y0;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.m4.b;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.n;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.luggage.wxa.yf.a0;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends v implements com.tencent.luggage.wxa.m4.c {
    public final Runnable A0;
    public com.tencent.luggage.wxa.kj.e B0;
    public b0 C0;

    /* renamed from: y0, reason: collision with root package name */
    public com.tencent.luggage.wxa.dk.a f134074y0;

    /* renamed from: z0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ck.b f134075z0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends h {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.m4.b.h
        public com.tencent.luggage.wxa.ck.b a(b bVar) {
            return new com.tencent.luggage.wxa.ck.b(bVar.getComponentId());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.m4.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6456b extends n {
        public C6456b(com.tencent.luggage.wxa.xd.e eVar) {
            super(eVar);
        }

        @JavascriptInterface
        public String readLibSync(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return b.this.i().g(str);
        }

        @JavascriptInterface
        public String readLibXWebScriptSync(String str) {
            if (TextUtils.isEmpty(str) || !(b.this.v0() instanceof com.tencent.luggage.wxa.kj.a)) {
                return "";
            }
            return ((com.tencent.luggage.wxa.kj.a) b.this.v0()).E().b(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f134079a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f134080b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f134081c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ View f134082d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f134083e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ int f134084f;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.m4.b$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6457a implements g.e {

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.m4.b$c$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class RunnableC6458a implements Runnable {
                    public RunnableC6458a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.w1();
                        o0 D0 = b.this.D0();
                        if (D0 != null) {
                            D0.setVerticalScrollBarEnabled(true);
                        }
                    }
                }

                public C6457a() {
                }

                @Override // com.tencent.luggage.wxa.xd.g.e
                public void a() {
                    b.this.b(this);
                    a aVar = a.this;
                    aVar.f134082d.scrollTo(aVar.f134083e, aVar.f134084f);
                    b.this.D0().c(new RunnableC6458a());
                }
            }

            public a(int i3, int i16, com.tencent.luggage.wxa.xo.b bVar, View view, int i17, int i18) {
                this.f134079a = i3;
                this.f134080b = i16;
                this.f134081c = bVar;
                this.f134082d = view;
                this.f134083e = i17;
                this.f134084f = i18;
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x00ee  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:5:0x0050  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bitmap bitmap;
                int width;
                int i3;
                try {
                    bitmap = b.this.w0();
                } catch (NullPointerException e16) {
                    w.b("MicroMsg.AppBrandPageViewLU", "postOnReRendered getScreenshotWithoutDecor npe(%s), appId[%s] url[%s]", e16, b.this.getAppId(), b.this.A0());
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    Object[] objArr = new Object[2];
                    int i16 = -1;
                    if (bitmap == null) {
                    }
                    objArr[0] = Integer.valueOf(width);
                    if (bitmap != null) {
                    }
                    objArr[1] = Integer.valueOf(i16);
                    w.b("MicroMsg.AppBrandPageViewLU", "getScreenshotWithoutDecor bitmap invalid width(%d), height(%d)", objArr);
                    this.f134081c.a(null);
                    b.this.a(new C6457a());
                } catch (OutOfMemoryError unused) {
                    w.b("MicroMsg.AppBrandPageViewLU", "postOnReRendered getScreenshotWithoutDecor oom, appId[%s] url[%s]", b.this.getAppId(), b.this.A0());
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    Object[] objArr2 = new Object[2];
                    int i162 = -1;
                    if (bitmap == null) {
                    }
                    objArr2[0] = Integer.valueOf(width);
                    if (bitmap != null) {
                    }
                    objArr2[1] = Integer.valueOf(i162);
                    w.b("MicroMsg.AppBrandPageViewLU", "getScreenshotWithoutDecor bitmap invalid width(%d), height(%d)", objArr2);
                    this.f134081c.a(null);
                    b.this.a(new C6457a());
                }
                if (bitmap == null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    int min = Math.min(bitmap.getWidth(), this.f134079a);
                    int min2 = Math.min(bitmap.getHeight(), this.f134080b);
                    if (b.this.W().k()) {
                        int[] iArr = new int[2];
                        b.this.W().getCapsuleView().getLocationInWindow(iArr);
                        i3 = Math.min(iArr[1] + b.this.getContext().getResources().getDimensionPixelSize(R.dimen.c1h), min2);
                    } else {
                        i3 = 0;
                    }
                    try {
                        try {
                            this.f134081c.a(Bitmap.createBitmap(bitmap, 0, i3, min, min2 - i3));
                        } catch (OutOfMemoryError unused2) {
                            w.b("MicroMsg.AppBrandPageViewLU", "postOnReRendered getScreenshotWithoutDecor cut final bitmap oom, appId[%s] url[%s]", b.this.getAppId(), b.this.A0());
                            this.f134081c.a(null);
                        }
                        try {
                            bitmap.recycle();
                        } catch (Throwable unused3) {
                        }
                    } catch (Throwable th5) {
                        try {
                            bitmap.recycle();
                        } catch (Throwable unused4) {
                        }
                        throw th5;
                    }
                } else {
                    Object[] objArr22 = new Object[2];
                    int i1622 = -1;
                    if (bitmap == null) {
                        width = -1;
                    } else {
                        width = bitmap.getWidth();
                    }
                    objArr22[0] = Integer.valueOf(width);
                    if (bitmap != null) {
                        i1622 = bitmap.getHeight();
                    }
                    objArr22[1] = Integer.valueOf(i1622);
                    w.b("MicroMsg.AppBrandPageViewLU", "getScreenshotWithoutDecor bitmap invalid width(%d), height(%d)", objArr22);
                    this.f134081c.a(null);
                }
                b.this.a(new C6457a());
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call(Void r112) {
            w.a("MicroMsg.AppBrandPageViewLU", "getScreenshotForSharing entered");
            View contentView = b.this.D0().getContentView();
            if (contentView == null) {
                return null;
            }
            int width = b.this.D0().getWidth();
            int height = b.this.D0().getHeight();
            int webScrollX = b.this.D0().getWebScrollX();
            int webScrollY = b.this.D0().getWebScrollY();
            if (width != 0 && height != 0) {
                contentView.scrollTo(0, 0);
                b.this.D0().c(new a(width, height, com.tencent.luggage.wxa.xo.h.b(), contentView, webScrollX, webScrollY));
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements g.e {
            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                b.this.w1();
                o0 D0 = b.this.D0();
                if (D0 != null) {
                    D0.setVerticalScrollBarEnabled(true);
                }
            }

            @Override // com.tencent.luggage.wxa.xd.g.e
            public void a() {
                b.this.b(this);
                b.this.D0().c(new Runnable() { // from class: com.tencent.luggage.wxa.m4.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d.a.this.b();
                    }
                });
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.D0() == null || b.this.D0().getWebScrollY() == 0) {
                return;
            }
            b.this.B1();
            b.this.D0().setVerticalScrollBarEnabled(false);
            b.this.a(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f134090a;

        static {
            int[] iArr = new int[i.a.EnumC6399a.values().length];
            f134090a = iArr;
            try {
                iArr[i.a.EnumC6399a.PageConfig.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f134090a[i.a.EnumC6399a.JsApi.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f134090a[i.a.EnumC6399a.HalfScreenConfig.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f134090a[i.a.EnumC6399a.LiteGame.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends com.tencent.luggage.wxa.xd.c {
        static final int CTRL_INDEX = 237;
        static final String NAME = "config_navigationBarRightButton";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends p {
        static final int CTRL_INDEX = 429;
        static final String NAME = "onPageNotFound";

        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class h {
        public abstract com.tencent.luggage.wxa.ck.b a(b bVar);

        public final com.tencent.luggage.wxa.ck.b b(b bVar) {
            final com.tencent.luggage.wxa.ck.b a16 = a(bVar);
            Objects.requireNonNull(a16);
            bVar.b(new g.d() { // from class: com.tencent.luggage.wxa.m4.g
                @Override // com.tencent.luggage.wxa.xd.g.d
                public final void onForeground() {
                    com.tencent.luggage.wxa.ck.b.this.i();
                }
            });
            bVar.a(new g.b() { // from class: com.tencent.luggage.wxa.m4.h
                @Override // com.tencent.luggage.wxa.xd.g.b
                public final void onBackground() {
                    com.tencent.luggage.wxa.ck.b.this.g();
                }
            });
            bVar.a(new g.c() { // from class: com.tencent.luggage.wxa.m4.i
                @Override // com.tencent.luggage.wxa.xd.g.c
                public final void onDestroy() {
                    com.tencent.luggage.wxa.ck.b.this.h();
                }
            });
            bVar.a(new g.f() { // from class: com.tencent.luggage.wxa.m4.j
                @Override // com.tencent.luggage.wxa.xd.g.f
                public final void onReady() {
                    com.tencent.luggage.wxa.ck.b.this.j();
                }
            });
            return a16;
        }
    }

    public b(@Nullable Class<? extends x> cls, @Nullable h hVar) {
        super(cls);
        this.f134074y0 = com.tencent.luggage.wxa.dk.a.CreateOnRuntimeInit;
        this.A0 = new Runnable() { // from class: com.tencent.luggage.wxa.m4.d
            @Override // java.lang.Runnable
            public final void run() {
                b.this.A1();
            }
        };
        this.f134075z0 = (hVar == null ? new a() : hVar).b(this);
    }

    public final void A1() {
        if (!isRunning()) {
            w.h("MicroMsg.AppBrandPageViewLU", "showErrorPageView but not running, appId[%s] url[%s]", getAppId(), A0());
            return;
        }
        w.d("MicroMsg.AppBrandPageViewLU", "showErrorPageView appId:%s, url:%s", getAppId(), A0());
        d(false);
        com.tencent.luggage.wxa.kj.e eVar = new com.tencent.luggage.wxa.kj.e(getContext(), getRuntime());
        FrameLayout q06 = q0();
        this.B0 = eVar;
        q06.addView(eVar);
    }

    public void B1() {
        FrameLayout x16 = x1();
        x16.setBackground(null);
        x16.setVisibility(0);
        x16.bringToFront();
        try {
            w.a("MicroMsg.AppBrandPageViewLU", "showScreenshotCover get screenshot");
            x16.setBackground(new BitmapDrawable(getContext().getResources(), w0()));
        } catch (OutOfMemoryError unused) {
            w.b("MicroMsg.AppBrandPageViewLU", "showScreenshotCover oom, appId = %s, path = %s", getAppId(), A0());
            w1();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public boolean L0() {
        com.tencent.luggage.wxa.mj.i iVar = (com.tencent.luggage.wxa.mj.i) f(com.tencent.luggage.wxa.mj.i.class);
        if (iVar != null && iVar.c()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.d
    public final void c(Runnable runnable) {
        if (getRuntime() != null && getRuntime().y1()) {
            if (runnable != null) {
                z1().a(runnable);
                return;
            }
            return;
        }
        super.c(runnable);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void c1() {
        super.c1();
        l(false);
        b0 b0Var = this.C0;
        if (b0Var != null) {
            b0Var.a((Object) null);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.d
    public final void d(Runnable runnable) {
        b0 b0Var = this.C0;
        if (b0Var != null && runnable != null) {
            b0Var.b(runnable);
        }
        super.d(runnable);
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public final n f() {
        return new C6456b(this);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public Bitmap h(boolean z16) {
        com.tencent.luggage.wxa.kj.e eVar;
        Bitmap h16 = super.h(z16);
        if (h16 != null && !z16 && (eVar = this.B0) != null) {
            q1.b(eVar, new Canvas(h16));
        }
        return h16;
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void k(boolean z16) {
        super.k(z16);
        if (!z16) {
            l(false);
        }
    }

    public final void l(boolean z16) {
        d(this.A0);
        e(new Runnable() { // from class: com.tencent.luggage.wxa.m4.e
            @Override // java.lang.Runnable
            public final void run() {
                b.this.v1();
            }
        });
        if (z16) {
            e("cancelShowErrorPageViewRunnable");
        }
    }

    public final void m(String str) {
        boolean a16 = getRuntime().B1().a(this, g.class);
        w.d("MicroMsg.AppBrandPageViewLU", "publishPageNotFound appId:%s, hasPermission:%b, url:%s", getAppId(), Boolean.valueOf(a16), str);
        if (!a16) {
            A1();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("path", o.b(str));
        hashMap.put("query", o.d(str));
        hashMap.put("rawPath", str);
        hashMap.put("isEntryPage", Boolean.valueOf(w0.d(str).equals(getRuntime().O())));
        a(new g(null).setData(hashMap), (int[]) null);
        b(this.A0, 2000L);
    }

    public com.tencent.luggage.wxa.lh.a q1() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.kj.v, com.tencent.luggage.wxa.xd.i
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.c5.e getRuntime() {
        return (com.tencent.luggage.wxa.c5.e) super.getRuntime();
    }

    public com.tencent.luggage.wxa.xo.d s1() {
        return com.tencent.luggage.wxa.xo.h.c().a(new c());
    }

    @Override // com.tencent.luggage.wxa.kj.v
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.r4.d y0() {
        return (com.tencent.luggage.wxa.r4.d) super.y0();
    }

    public final com.tencent.luggage.wxa.ck.b u1() {
        return this.f134075z0;
    }

    public final void v1() {
        if (q0() != null && this.B0 != null) {
            q0().removeView(this.B0);
            this.B0 = null;
        }
    }

    public void w1() {
        Bitmap bitmap;
        FrameLayout q06 = q0();
        if (q06 == null) {
            w.d("MicroMsg.AppBrandPageViewLU", "hideScreenshotCover, pageArea is null");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) q06.findViewById(R.id.srj);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            if (frameLayout.getBackground() instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) frameLayout.getBackground()).getBitmap();
            } else {
                bitmap = null;
            }
            frameLayout.setBackground(null);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public JSONObject x() {
        JSONObject x16 = super.x();
        com.tencent.luggage.wxa.er.a.b(this.f134074y0, com.tencent.luggage.wxa.dk.a.CreateOnRuntimeInit);
        a(x16, "envPreloadType", Integer.valueOf(this.f134074y0.ordinal()));
        return x16;
    }

    public final FrameLayout x1() {
        FrameLayout frameLayout = (FrameLayout) q0().findViewById(R.id.srj);
        if (frameLayout == null) {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout2.setId(R.id.srj);
            q0().addView(frameLayout2, -1, -1);
            return frameLayout2;
        }
        return frameLayout;
    }

    public void y1() {
        if (getRuntime().Y().getPageCount() == 1 && this.W.b()) {
            W().setNavHidden(true);
        } else {
            W().setNavHidden(false);
        }
    }

    public final b0 z1() {
        if (this.C0 == null) {
            this.C0 = new b0(Looper.getMainLooper());
        }
        return this.C0;
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void a(Context context, com.tencent.luggage.wxa.ic.g gVar) {
        super.a(context, gVar);
        u1().a(gVar);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void b(boolean z16, i.a.EnumC6399a enumC6399a) {
        boolean a16;
        com.tencent.luggage.wxa.rj.c B1 = getRuntime().B1();
        int i3 = e.f134090a[enumC6399a.ordinal()];
        if (i3 != 1) {
            a16 = i3 == 2 ? B1.a(y0(), a0.class) || B1.a(this, a0.class) : i3 == 3 || i3 == 4;
        } else {
            a16 = B1.a(this, f.class);
        }
        if (!a16) {
            z16 = true;
        }
        super.b(z16, enumC6399a);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void f(String str) {
        super.k(true);
        m(str);
    }

    public final void a(com.tencent.luggage.wxa.dk.a aVar) {
        this.f134074y0 = aVar;
        super.i1();
        B();
    }

    public b() {
        this(y0.class, null);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public boolean a(long j3, String str, k1 k1Var) {
        boolean a16 = super.a(j3, str, k1Var);
        u1().a(str);
        if (a16) {
            int i3 = 0;
            l(false);
            while (true) {
                if (i3 >= q0().getChildCount()) {
                    break;
                }
                View childAt = q0().getChildAt(i3);
                if (childAt instanceof com.tencent.luggage.wxa.kj.e) {
                    q0().removeView(childAt);
                    break;
                }
                i3++;
            }
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.kj.d
    public final void b(Runnable runnable, long j3) {
        if (getRuntime() == null || !getRuntime().y1()) {
            super.b(runnable, j3);
        } else if (runnable != null) {
            z1().a(runnable, j3);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var, int[] iArr) {
        if (k0Var instanceof g) {
            w.d("MicroMsg.AppBrandPageViewLU", "publish onPageNotFound, appId:%s, webviewId:%d, data:%s", getAppId(), Integer.valueOf(getComponentId()), k0Var.getData());
        }
        super.a(k0Var, iArr);
    }

    public void a(Bundle bundle) {
        a(new d());
    }
}
