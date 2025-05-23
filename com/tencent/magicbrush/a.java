package com.tencent.magicbrush;

import android.graphics.Bitmap;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final C7009a f147349b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f147350c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f147351d;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.magicbrush.b f147352a;

    /* compiled from: P */
    /* renamed from: com.tencent.magicbrush.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7009a {
        static IPatchRedirector $redirector_;

        public C7009a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return a.f147350c;
            }
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        public /* synthetic */ C7009a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends com.tencent.luggage.wxa.w8.d {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ a f147353h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f147354i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f147355j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f147356k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j3, a aVar, int i3, int i16, boolean z16) {
            super(j3, null, true);
            this.f147353h = aVar;
            this.f147354i = i3;
            this.f147355j = i16;
            this.f147356k = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), aVar, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.luggage.wxa.w8.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.magicbrush.b c16 = this.f147353h.c();
            final a aVar = this.f147353h;
            final int i3 = this.f147354i;
            final int i16 = this.f147355j;
            final boolean z16 = this.f147356k;
            c16.a(new MBRuntime.p() { // from class: com.tencent.magicbrush.i
                @Override // com.tencent.magicbrush.MBRuntime.p
                public final void a(boolean z17) {
                    a.b.a(a.this, i3, i16, z16, this, z17);
                }
            });
            return null;
        }

        public static final void a(a this$0, int i3, int i16, boolean z16, b this$1, boolean z17) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            com.tencent.luggage.wxa.p8.f.c(a.f147349b.a(), "hy: is swap all window: " + z17, new Object[0]);
            this$1.a(this$0.b(i3, i16, z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function0 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.magicbrush.ui.g f147357a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f147358b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147359c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bitmap f147360d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.tencent.magicbrush.ui.g gVar, int i3, int i16, Bitmap bitmap) {
            super(0);
            this.f147357a = gVar;
            this.f147358b = i3;
            this.f147359c = i16;
            this.f147360d = bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, gVar, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f147357a.a(this.f147358b, this.f147359c, this.f147360d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58032);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f147349b = new C7009a(null);
        f147350c = "MagicBrush.MBCanvasHandler";
        f147351d = 2500L;
    }

    public a(com.tencent.magicbrush.b magicbrush) {
        Intrinsics.checkNotNullParameter(magicbrush, "magicbrush");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) magicbrush);
        } else {
            this.f147352a = magicbrush;
        }
    }

    public final Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? a(this, (Bitmap) null, 1, (Object) null) : (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    public final com.tencent.magicbrush.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f147352a : (com.tencent.magicbrush.b) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public static final Bitmap b(a this$0, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.b(i3, i16, z16);
    }

    public final Bitmap c(final int i3, final int i16, final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        com.tencent.luggage.wxa.p8.f.c("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
        Bitmap bitmap = (Bitmap) this.f147352a.h().a(new Callable() { // from class: com.tencent.magicbrush.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.b(a.this, i3, i16, z16);
            }
        });
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(bitmap == null);
        com.tencent.luggage.wxa.p8.f.c("MagicBrush", "ca done %b", objArr);
        return bitmap;
    }

    public final Bitmap a(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? a(i3, i16, z16, f147351d) : (Bitmap) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
    }

    public final Bitmap b(int i3, int i16, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bitmap) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Long.valueOf(j3));
        }
        com.tencent.luggage.wxa.p8.f.c("MagicBrush", "hy: captureCanvasOnOtherThreadWaitingSwapDone", new Object[0]);
        Bitmap bitmap = (Bitmap) new b(j3, this, i3, i16, z16).a((com.tencent.luggage.wxa.r8.a) this.f147352a.h());
        String str = f147350c;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(bitmap == null);
        com.tencent.luggage.wxa.p8.f.c(str, "hy: is ret bitmap is null? %b", objArr);
        return bitmap;
    }

    public final Bitmap a(int i3, int i16, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Long.valueOf(j3));
        }
        if (i16 <= 0 && !z16) {
            return null;
        }
        if (this.f147352a.h().g()) {
            return b(i3, i16, z16);
        }
        if (!z16) {
            return c(i3, i16, z16);
        }
        return b(i3, i16, z16, j3);
    }

    public final Bitmap b(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.f147352a.a(i3, i16, z16) : (Bitmap) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
    }

    public static /* synthetic */ Bitmap a(a aVar, Bitmap bitmap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bitmap = null;
        }
        return aVar.a(bitmap);
    }

    public final Bitmap a(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? a(0, bitmap) : (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmap);
    }

    public final Bitmap a(int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bitmap);
        }
        com.tencent.magicbrush.ui.g a16 = a(i3);
        if (a16 == null) {
            return null;
        }
        return a16.a(bitmap);
    }

    public final Bitmap a(int i3, int i16, int i17, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bitmap) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bitmap);
        }
        if (i16 > 0 && i17 > 0) {
            com.tencent.magicbrush.ui.g a16 = a(i3);
            if (a16 == null) {
                return null;
            }
            return (Bitmap) com.tencent.luggage.wxa.w8.g.f144126a.c(new c(a16, i16, i17, bitmap));
        }
        String format = String.format("captureScreenCanvas of [%d] [%d, %d]", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        throw new IllegalStateException(format.toString());
    }

    public final com.tencent.magicbrush.ui.g a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.magicbrush.ui.g) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        com.tencent.magicbrush.ui.g findOrNull = this.f147352a.x().findOrNull(i3);
        if (findOrNull != null) {
            return findOrNull;
        }
        com.tencent.luggage.wxa.h.b.b("MagicBrush", "findView [%d] but can not find. thread = [%s]", Integer.valueOf(i3), Thread.currentThread());
        return null;
    }
}
