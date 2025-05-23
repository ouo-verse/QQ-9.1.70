package com.tencent.magicbrush.internal;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.ui.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J6\u0010\u0013\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0002R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/magicbrush/internal/EventDispatcher;", "", "", "exception", "stack", "", "contextId", "", "onJSError", "output", "onConsole", "windowId", "onFirstFrameRendered", "canvasId", "virtualElementId", "type", "onScreenCanvasRenderingContextCreated", "Lcom/tencent/luggage/wxa/w8/c;", "Lcom/tencent/magicbrush/ui/g$g;", "a", "T", BdhLogUtil.LogTag.Tag_Req, "l", "Lkotlin/Function1;", "block", "Lcom/tencent/magicbrush/b;", "Lcom/tencent/magicbrush/b;", "getMagicbrush", "()Lcom/tencent/magicbrush/b;", "magicbrush", "<init>", "(Lcom/tencent/magicbrush/b;)V", "lib-magicbrush-nano_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes9.dex */
public final class EventDispatcher {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.magicbrush.b magicbrush;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f147466a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.f147466a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        public final void a(b.d it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147466a);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((b.d) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f147467a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i3) {
            super(1);
            this.f147467a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        public final void a(b.InterfaceC7010b it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147467a);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((b.InterfaceC7010b) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f147468a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f147469b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f147470c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, int i3) {
            super(1);
            this.f147468a = str;
            this.f147469b = str2;
            this.f147470c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
            }
        }

        public final void a(b.d it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147468a, this.f147469b, this.f147470c);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((b.d) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f147471a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i3) {
            super(1);
            this.f147471a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        public final void a(g.InterfaceC7017g it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            } else {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(this.f147471a);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g.InterfaceC7017g) obj);
            return Unit.INSTANCE;
        }
    }

    public EventDispatcher(com.tencent.magicbrush.b magicbrush) {
        Intrinsics.checkNotNullParameter(magicbrush, "magicbrush");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) magicbrush);
        } else {
            this.magicbrush = magicbrush;
        }
    }

    public final com.tencent.luggage.wxa.w8.c a(int virtualElementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.magicbrush.x().find(virtualElementId).getRenderingContextListeners() : (com.tencent.luggage.wxa.w8.c) iPatchRedirector.redirect((short) 6, (Object) this, virtualElementId);
    }

    @Keep
    public final void onConsole(@NotNull String output) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) output);
        } else {
            Intrinsics.checkNotNullParameter(output, "output");
            a(this.magicbrush.w(), new a(output));
        }
    }

    @Keep
    public final void onFirstFrameRendered(int windowId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, windowId);
        } else {
            a(this.magicbrush.v(), new b(windowId));
        }
    }

    @Keep
    public final void onJSError(@NotNull String exception, @NotNull String stack, int contextId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, exception, stack, Integer.valueOf(contextId));
            return;
        }
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(stack, "stack");
        a(this.magicbrush.w(), new c(exception, stack, contextId));
    }

    @Keep
    public final void onScreenCanvasRenderingContextCreated(int canvasId, int virtualElementId, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(canvasId), Integer.valueOf(virtualElementId), Integer.valueOf(type));
            return;
        }
        try {
            this.magicbrush.x().find(virtualElementId).setCanvasId(canvasId);
            a(virtualElementId).b((Function1) new d(type));
        } catch (Exception e16) {
            f.b("MagicBrush", "onScreenCanvasRenderingContextCreated error: " + e16, new Object[0]);
        }
    }

    public final void a(com.tencent.luggage.wxa.w8.c l3, Function1 block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3, (Object) block);
            return;
        }
        try {
            l3.a(block);
        } catch (Exception e16) {
            f.a("MagicBrush", e16, "dispatch event failed", new Object[0]);
        }
    }
}
