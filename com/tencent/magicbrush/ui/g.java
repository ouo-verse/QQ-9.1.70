package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends FrameLayout {
    static IPatchRedirector $redirector_;
    public static final h C;
    public static final JsTouchEventHandler D;

    /* renamed from: m, reason: collision with root package name */
    public static final a f147509m;

    /* renamed from: a, reason: collision with root package name */
    public int f147510a;

    /* renamed from: b, reason: collision with root package name */
    public b f147511b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f147512c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.w8.c f147513d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.w8.c f147514e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.w8.c f147515f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f147516g;

    /* renamed from: h, reason: collision with root package name */
    public int f147517h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.magicbrush.b f147518i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f147519j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f147520k;

    /* renamed from: l, reason: collision with root package name */
    public final com.tencent.magicbrush.ui.h f147521l;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.magicbrush.ui.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public /* synthetic */ class C7016a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f147522a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58631);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[h.values().length];
                try {
                    iArr[h.f147523a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[h.f147524b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f147522a = iArr;
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        public final h a(AttributeSet attributeSet) {
            IntRange until;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (h) iPatchRedirector.redirect((short) 3, (Object) this, (Object) attributeSet);
            }
            h hVar = null;
            if (attributeSet != null) {
                until = RangesKt___RangesKt.until(0, attributeSet.getAttributeCount());
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    if (Intrinsics.areEqual("viewType", attributeSet.getAttributeName(nextInt))) {
                        String viewTypeName = attributeSet.getAttributeValue(nextInt);
                        a aVar = g.f147509m;
                        Intrinsics.checkNotNullExpressionValue(viewTypeName, "viewTypeName");
                        aVar.a(viewTypeName);
                        if (Intrinsics.areEqual(viewTypeName, "SurfaceView")) {
                            hVar = h.f147523a;
                        } else {
                            hVar = h.f147524b;
                        }
                    }
                }
            }
            return hVar;
        }

        public final void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            if (Intrinsics.areEqual(str, "SurfaceView") || Intrinsics.areEqual(str, "TextureView")) {
                return;
            }
            String format = String.format("ViewType must be [SurfaceView|TextureView], but is [%s]", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            throw new IllegalStateException(format.toString());
        }

        public final b a(Context context, h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) hVar);
            }
            int i3 = C7016a.f147522a[hVar.ordinal()];
            if (i3 == 1) {
                return new com.tencent.magicbrush.ui.e(context);
            }
            if (i3 == 2) {
                return new com.tencent.magicbrush.ui.f(context);
            }
            throw new Exception("invalid viewType");
        }

        public final b a(Context context, b bVar, AttributeSet attributeSet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, this, context, bVar, attributeSet);
            }
            if (bVar != null) {
                return bVar;
            }
            h a16 = a(attributeSet);
            if (a16 == null) {
                a16 = g.C;
            }
            return a(context, a16);
        }

        public final Bitmap a(Bitmap bitmap, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Bitmap) iPatchRedirector.redirect((short) 7, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() == i3 && bitmap.getHeight() == i16) {
                return bitmap;
            }
            try {
                bitmap.reconfigure(i3, i16, Bitmap.Config.ARGB_8888);
                return bitmap;
            } catch (Exception unused) {
                return null;
            }
        }

        public final void a(com.tencent.magicbrush.b bVar, h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar, (Object) hVar);
                return;
            }
            if (hVar == h.f147524b) {
                if (bVar.t().b() != a.b.f147486c) {
                    return;
                }
                throw new IllegalStateException(("ViewType [" + hVar + "] can not work with RAF mode[" + bVar.t().b() + ']').toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a {
            public static Object a(b bVar) {
                View thisView = bVar.getThisView();
                if (thisView != null) {
                    if (thisView instanceof TextureView) {
                        return ((TextureView) thisView).getSurfaceTexture();
                    }
                    if (thisView instanceof SurfaceView) {
                        return ((SurfaceView) thisView).getHolder().getSurface();
                    }
                    return null;
                }
                return null;
            }
        }

        Object getSurface();

        View getThisView();

        h getViewType();

        void setSurfaceListener(c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a {
            public static /* synthetic */ void a(c cVar, Object obj, int i3, int i16, boolean z16, boolean z17, int i17, Object obj2) {
                if (obj2 == null) {
                    if ((i17 & 16) != 0) {
                        z17 = false;
                    }
                    cVar.a(obj, i3, i16, z16, z17);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSurfaceAvailable");
            }
        }

        void a(Object obj, int i3, int i16);

        void a(Object obj, int i3, int i16, boolean z16, boolean z17);

        void a(Object obj, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class d implements e {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.magicbrush.ui.g.c
        public void a(Object surface, int i3, int i16, boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Intrinsics.checkNotNullParameter(surface, "surface");
            } else {
                iPatchRedirector.redirect((short) 2, this, surface, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
        }

        @Override // com.tencent.magicbrush.ui.g.e
        public void b(Object surface, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                Intrinsics.checkNotNullParameter(surface, "surface");
            }
        }

        @Override // com.tencent.magicbrush.ui.g.e
        public void c(Object surface, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                Intrinsics.checkNotNullParameter(surface, "surface");
            }
        }

        @Override // com.tencent.magicbrush.ui.g.c
        public void a(Object surface, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                Intrinsics.checkNotNullParameter(surface, "surface");
            } else {
                iPatchRedirector.redirect((short) 3, this, surface, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e extends c {
        void a(Object obj);

        void b(Object obj, int i3, int i16);

        void c(Object obj, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        void a();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.magicbrush.ui.g$g, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC7017g {
        void a(int i3);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final h f147523a;

        /* renamed from: b, reason: collision with root package name */
        public static final h f147524b;

        /* renamed from: c, reason: collision with root package name */
        public static final h f147525c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ h[] f147526d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58663);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f147523a = new h("SurfaceView", 0);
            f147524b = new h("TextureView", 1);
            f147525c = new h("VirtualView", 2);
            f147526d = a();
        }

        public h(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static final /* synthetic */ h[] a() {
            return new h[]{f147523a, f147524b, f147525c};
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f147526d.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class i extends Lambda implements Function0 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f147527a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f147528b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Bitmap bitmap, b bVar) {
            super(0);
            this.f147527a = bitmap;
            this.f147528b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap, (Object) bVar);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Bitmap bitmap = this.f147527a;
            if (bitmap != null) {
                return ((TextureView) this.f147528b).getBitmap(bitmap);
            }
            return ((TextureView) this.f147528b).getBitmap();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58676);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f147509m = new a(null);
        C = h.f147524b;
        D = new JsTouchEventHandler();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Context context, h viewType) {
        this(context, f147509m.a(context, viewType), null, -1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) viewType);
    }

    public final int getCanvasId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.f147517h;
    }

    public int getDefaultBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return -16777216;
    }

    public final boolean getEnableTouchEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f147519j;
    }

    @NotNull
    public final com.tencent.magicbrush.b getMagicBrush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.magicbrush.b) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        com.tencent.magicbrush.b bVar = this.f147518i;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
            return null;
        }
        return bVar;
    }

    public final boolean getOpaque() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f147516g;
    }

    @NotNull
    public final com.tencent.luggage.wxa.w8.c getPreparedListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.luggage.wxa.w8.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f147513d;
    }

    @NotNull
    public final b getRendererView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f147511b;
    }

    @NotNull
    public final com.tencent.luggage.wxa.w8.c getRenderingContextListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.luggage.wxa.w8.c) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f147514e;
    }

    @NotNull
    public final com.tencent.luggage.wxa.w8.c getSurfaceListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.luggage.wxa.w8.c) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f147515f;
    }

    public final boolean getUseRawAxisTouchEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.f147520k;
    }

    @UiThread
    @NotNull
    public final h getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (h) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f147511b.getViewType();
    }

    public final int getVirtualElementId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f147510a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.f147519j) {
            return super.onTouchEvent(event);
        }
        JsTouchEventHandler jsTouchEventHandler = D;
        com.tencent.magicbrush.b bVar = this.f147518i;
        com.tencent.magicbrush.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
            bVar = null;
        }
        long a16 = jsTouchEventHandler.a(event, bVar.t().g(), this.f147520k);
        com.tencent.magicbrush.b bVar3 = this.f147518i;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a(this.f147510a, a16, jsTouchEventHandler.a());
        return true;
    }

    public final void setCanvasId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f147517h = i3;
        }
    }

    public final void setEnableTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.f147519j = z16;
        }
    }

    public final void setMagicBrush(@NotNull com.tencent.magicbrush.b value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) value);
        } else {
            Intrinsics.checkNotNullParameter(value, "value");
            a(value, -1);
        }
    }

    public final void setOpaque(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        if (getViewType() == h.f147523a) {
            com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "SurfaceView[" + this.f147510a + "] can not be set to opaque", new Object[0]);
            this.f147516g = false;
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "TextureView[" + this.f147510a + "] opaque set to [" + z16 + ']', new Object[0]);
        if (z16) {
            setBackgroundColor(getDefaultBackground());
        } else {
            setBackground(null);
        }
        Object obj = this.f147511b;
        if (obj instanceof TextureView) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.TextureView");
            ((TextureView) obj).setOpaque(z16);
        }
        this.f147516g = z16;
    }

    public final void setRendererView(@NotNull b v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (com.tencent.luggage.wxa.w8.g.b()) {
            if (Intrinsics.areEqual(v3, this.f147511b)) {
                return;
            }
            if (v3 instanceof TextureView) {
                TextureView textureView = (TextureView) v3;
                textureView.setOpaque(this.f147516g);
                if (this.f147516g) {
                    setBackgroundColor(getDefaultBackground());
                } else {
                    setBackground(null);
                    textureView.setBackground(null);
                }
            }
            com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "dlview: change rendererView to %s", v3);
            Object surface = this.f147511b.getSurface();
            if (surface != null) {
                this.f147521l.a(surface, false);
            }
            this.f147511b.setSurfaceListener(null);
            View thisView = this.f147511b.getThisView();
            if (thisView != null) {
                removeView(thisView);
            }
            v3.setSurfaceListener(this.f147521l);
            View thisView2 = v3.getThisView();
            if (thisView2 != null) {
                addView(thisView2, -1, -1);
            }
            this.f147511b = v3;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void setUseRawAxisTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.f147520k = z16;
        }
    }

    @UiThread
    public final void setViewType(@NotNull h v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        if (com.tencent.luggage.wxa.w8.g.b()) {
            if (v3 == this.f147511b.getViewType()) {
                com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "dlview: viewType, cache hit", new Object[0]);
                return;
            }
            a aVar = f147509m;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            setRendererView(aVar.a(context, v3));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void setVirtualElementId$lib_magicbrush_nano_release(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f147510a = i3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Context context, b renderer) {
        this(context, renderer, null, -1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) renderer);
    }

    public g(Context context, b bVar, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, bVar, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f147510a = -1;
        this.f147513d = new com.tencent.luggage.wxa.w8.c();
        this.f147514e = new com.tencent.luggage.wxa.w8.c();
        this.f147515f = new com.tencent.luggage.wxa.w8.c();
        this.f147516g = true;
        this.f147519j = true;
        com.tencent.magicbrush.ui.h hVar = new com.tencent.magicbrush.ui.h(this);
        this.f147521l = hVar;
        b a16 = f147509m.a(context, bVar, attributeSet);
        this.f147511b = a16;
        a16.setSurfaceListener(hVar);
        if (bVar instanceof TextureView) {
            setBackgroundColor(getDefaultBackground());
        }
        View thisView = this.f147511b.getThisView();
        if (thisView != null) {
            addView(thisView, -1, -1);
        }
    }

    public final void a(InterfaceC7017g l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "l");
            this.f147514e.a(l3);
        }
    }

    public final void a(c l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) l3);
        } else {
            Intrinsics.checkNotNullParameter(l3, "l");
            this.f147515f.a(l3);
        }
    }

    public final void a(com.tencent.magicbrush.b value, int i3) {
        com.tencent.magicbrush.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) value, i3);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.f147518i = value;
        a aVar = f147509m;
        if (value == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
            bVar = null;
        } else {
            bVar = value;
        }
        aVar.a(bVar, getViewType());
        value.x().add$lib_magicbrush_nano_release(this, i3);
    }

    public final Bitmap a(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Bitmap) iPatchRedirector.redirect((short) 27, (Object) this, (Object) bitmap);
        }
        b bVar = this.f147511b;
        if (bVar instanceof TextureView) {
            com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "hy: trigger get bitmap in texture view. need sync ui thread", new Object[0]);
            return (Bitmap) com.tencent.luggage.wxa.w8.g.f144126a.c(new i(bitmap, bVar));
        }
        com.tencent.luggage.wxa.p8.f.c("MagicBrushView", "hy: trigger get bitmap int other views", new Object[0]);
        com.tencent.magicbrush.b bVar2 = this.f147518i;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("magicbrush");
            bVar2 = null;
        }
        return bVar2.s().a(this.f147510a, -1, true);
    }

    public final Bitmap a(int i3, int i16, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Bitmap) iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
        }
        Object obj = this.f147511b;
        boolean z16 = obj instanceof TextureView;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.TextureView");
        TextureView textureView = (TextureView) obj;
        Bitmap a16 = f147509m.a(bitmap, i3, i16);
        if (a16 != null) {
            return textureView.getBitmap(a16);
        }
        return textureView.getBitmap(i3, i16);
    }
}
