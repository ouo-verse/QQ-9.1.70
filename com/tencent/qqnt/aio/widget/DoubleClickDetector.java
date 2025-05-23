package com.tencent.qqnt.aio.widget;

import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.widget.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b2\u00103J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0014\u0010\"\"\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u001b\u0010,\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b \u0010+R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b\u0018\u0010+R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/aio/widget/DoubleClickDetector;", "", "Landroid/view/MotionEvent;", "firstDown", "firstUp", "secondDown", "", "g", "event", "f", "oldUpEvent", "newDownEvent", tl.h.F, "j", "Landroid/view/View;", "a", "Landroid/view/View;", "e", "()Landroid/view/View;", "view", "b", "Z", "isDown", "Ly03/c;", "c", "Ly03/c;", "getFontDrawable", "()Ly03/c;", "l", "(Ly03/c;)V", "fontDrawable", "Lcom/tencent/qqnt/aio/widget/i;", "d", "Lcom/tencent/qqnt/aio/widget/i;", "()Lcom/tencent/qqnt/aio/widget/i;", "k", "(Lcom/tencent/qqnt/aio/widget/i;)V", "doubleClickListener", "Landroid/view/MotionEvent;", "previousUpEvent", "currentDownEvent", "", "Lkotlin/Lazy;", "()I", "doubleTapTimeout", "doubleTapSlopSquare", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "mSingleTap", "<init>", "(Landroid/view/View;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class DoubleClickDetector {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f352424k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDown;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private y03.c fontDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i doubleClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MotionEvent previousUpEvent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MotionEvent currentDownEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy doubleTapTimeout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy doubleTapSlopSquare;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable mSingleTap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/widget/DoubleClickDetector$a;", "", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.widget.DoubleClickDetector$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48035);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
            f352424k = com.tencent.mobileqq.vas.toggle.c.f310992a.a("vas_single_click_enter_preview_new", true);
        }
    }

    public DoubleClickDetector(@NotNull View view) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.view = view;
        lazy = LazyKt__LazyJVMKt.lazy(DoubleClickDetector$doubleTapTimeout$2.INSTANCE);
        this.doubleTapTimeout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.qqnt.aio.widget.DoubleClickDetector$doubleTapSlopSquare$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DoubleClickDetector.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ViewConfiguration viewConfiguration = ViewConfiguration.get(DoubleClickDetector.this.e().getContext());
                return Integer.valueOf(viewConfiguration.getScaledDoubleTapSlop() * viewConfiguration.getScaledDoubleTapSlop());
            }
        });
        this.doubleTapSlopSquare = lazy2;
        this.mSingleTap = new Runnable() { // from class: com.tencent.qqnt.aio.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                DoubleClickDetector.i(DoubleClickDetector.this);
            }
        };
    }

    private final int c() {
        return ((Number) this.doubleTapSlopSquare.getValue()).intValue();
    }

    private final int d() {
        return ((Number) this.doubleTapTimeout.getValue()).intValue();
    }

    private final boolean f(MotionEvent event) {
        boolean z16;
        View view = this.view;
        if ((view instanceof TextView) && (((TextView) view).getText() instanceof Spannable)) {
            float x16 = (event.getX() - ((TextView) this.view).getTotalPaddingLeft()) + ((TextView) this.view).getScrollX();
            float y16 = (event.getY() - ((TextView) this.view).getTotalPaddingTop()) + ((TextView) this.view).getScrollY();
            Layout layout = ((TextView) this.view).getLayout();
            if (layout != null) {
                try {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y16), x16);
                    CharSequence text = ((TextView) this.view).getText();
                    Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spannable");
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr == null) {
                        return false;
                    }
                    if (clickableSpanArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!(!z16)) {
                        return false;
                    }
                    return true;
                } catch (Exception e16) {
                    QLog.e("DoubleClickDetector", 1, "hasClickableSpan error:", e16);
                }
            }
        }
        return false;
    }

    private final boolean g(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
        long eventTime = secondDown.getEventTime() - firstUp.getEventTime();
        if (eventTime > d() || eventTime < 30) {
            return false;
        }
        int x16 = ((int) firstDown.getX()) - ((int) secondDown.getX());
        int y16 = ((int) firstDown.getY()) - ((int) secondDown.getY());
        if ((x16 * x16) + (y16 * y16) >= c()) {
            return false;
        }
        return true;
    }

    private final boolean h(MotionEvent oldUpEvent, MotionEvent newDownEvent) {
        if (oldUpEvent == null || newDownEvent == null || newDownEvent.getEventTime() - oldUpEvent.getEventTime() > d()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(DoubleClickDetector this$0) {
        i iVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        y03.c cVar = this$0.fontDrawable;
        if (cVar != null) {
            cVar.o();
        }
        if (f352424k && (iVar = this$0.doubleClickListener) != null) {
            iVar.a(true);
        }
    }

    @Nullable
    public final i b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (i) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.doubleClickListener;
    }

    @NotNull
    public final View e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.view;
    }

    public final boolean j(@NotNull MotionEvent event) {
        MotionEvent motionEvent;
        MotionEvent motionEvent2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.doubleClickListener == null) {
            return false;
        }
        if (event.getAction() == 0) {
            this.isDown = true;
            if (this.previousUpEvent != null && (motionEvent2 = this.currentDownEvent) != null) {
                Intrinsics.checkNotNull(motionEvent2);
                MotionEvent motionEvent3 = this.previousUpEvent;
                Intrinsics.checkNotNull(motionEvent3);
                if (g(motionEvent2, motionEvent3, event)) {
                    this.currentDownEvent = null;
                    this.previousUpEvent = null;
                    this.isDown = false;
                    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mSingleTap);
                    i iVar = this.doubleClickListener;
                    if (iVar != null && i.a.a(iVar, false, 1, null)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return true;
                    }
                }
            }
            if (!f(event)) {
                MotionEvent motionEvent4 = this.currentDownEvent;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.currentDownEvent = MotionEvent.obtain(event);
            }
        } else if (event.getAction() == 1) {
            if (this.isDown && (((motionEvent = this.previousUpEvent) == null || h(motionEvent, this.currentDownEvent)) && !f(event))) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.mSingleTap, 300L);
            }
            if (!f(event)) {
                MotionEvent motionEvent5 = this.previousUpEvent;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.previousUpEvent = MotionEvent.obtain(event);
            }
            this.isDown = false;
        } else if (event.getAction() == 3) {
            this.isDown = false;
        }
        return false;
    }

    public final void k(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iVar);
        } else {
            this.doubleClickListener = iVar;
        }
    }

    public final void l(@Nullable y03.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.fontDrawable = cVar;
        }
    }
}
