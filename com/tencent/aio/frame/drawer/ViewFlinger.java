package com.tencent.aio.frame.drawer;

import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001+BW\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00126\u0010%\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00020\u001c\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J6\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aRG\u0010%\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/aio/frame/drawer/ViewFlinger;", "Ljava/lang/Runnable;", "", "f", "e", "", "startX", "startY", "dx", "dy", "duration", "g", "stop", TencentLocation.RUN_MODE, "Landroid/widget/OverScroller;", "d", "Landroid/widget/OverScroller;", "getMOverScroller", "()Landroid/widget/OverScroller;", "setMOverScroller", "(Landroid/widget/OverScroller;)V", "mOverScroller", "Landroid/view/View;", "Landroid/view/View;", "view", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "interpolator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "curX", "curY", h.F, "Lkotlin/jvm/functions/Function2;", "getListener", "()Lkotlin/jvm/functions/Function2;", "listener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/view/animation/Interpolator;Lkotlin/jvm/functions/Function2;)V", "i", "a", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class ViewFlinger implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private OverScroller mOverScroller;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View view;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Interpolator interpolator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<Integer, Integer, Unit> listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/frame/drawer/ViewFlinger$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.frame.drawer.ViewFlinger$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ViewFlinger(@NotNull Context context, @NotNull View view, @NotNull Interpolator interpolator, @NotNull Function2<? super Integer, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, view, interpolator, listener);
            return;
        }
        this.view = view;
        this.interpolator = interpolator;
        this.listener = listener;
        this.mOverScroller = new OverScroller(context, interpolator);
    }

    private final void e() {
        this.view.removeCallbacks(this);
        ViewCompat.postOnAnimation(this.view, this);
    }

    private final void f() {
        e();
    }

    public static /* synthetic */ void h(ViewFlinger viewFlinger, int i3, int i16, int i17, int i18, int i19, int i26, Object obj) {
        int i27;
        int i28;
        int i29;
        int i36;
        if ((i26 & 1) != 0) {
            i27 = 0;
        } else {
            i27 = i3;
        }
        if ((i26 & 2) != 0) {
            i28 = 0;
        } else {
            i28 = i16;
        }
        if ((i26 & 4) != 0) {
            i29 = 0;
        } else {
            i29 = i17;
        }
        if ((i26 & 8) != 0) {
            i36 = 0;
        } else {
            i36 = i18;
        }
        viewFlinger.g(i27, i28, i29, i36, i19);
    }

    public final void g(int startX, int startY, int dx5, int dy5, int duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(startX), Integer.valueOf(startY), Integer.valueOf(dx5), Integer.valueOf(dy5), Integer.valueOf(duration));
            return;
        }
        stop();
        this.mOverScroller.startScroll(startX, startY, dx5, dy5, duration);
        f();
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        OverScroller overScroller = this.mOverScroller;
        if (overScroller.computeScrollOffset()) {
            this.listener.invoke(Integer.valueOf(overScroller.getCurrX()), Integer.valueOf(overScroller.getCurrY()));
            f();
        }
    }

    public final void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mOverScroller.abortAnimation();
        }
    }
}
