package com.tencent.qqnt.avatar.resource;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.util.d;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/avatar/resource/c;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "", "g", "f", "e", "", "d", "onScrollChanged", "isAttachedToWindow", h.F, "Z", "lastVisible", "", "Lcom/tencent/qqnt/avatar/resource/a;", "Ljava/util/Set;", "viewStateChangeListenerSet", "", "I", "state", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "viewRef", "view", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c implements ViewTreeObserver.OnScrollChangedListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static int D;
    private static int E;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isAttachedToWindow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean lastVisible;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<a> viewStateChangeListenerSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<View> viewRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/avatar/resource/c$a;", "", "Landroid/content/Context;", "context", "", "c", "Lkotlin/Pair;", "", "b", "SCROLL_STATE_IDLE", "I", "SCROLL_STATE_SCROLLING", "", "TAG", "Ljava/lang/String;", "screenHeight", "screenWidth", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.resource.c$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final Pair<Integer, Integer> b(Context context) {
            WindowMetrics currentWindowMetrics;
            Rect bounds;
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager windowManager = (WindowManager) systemService;
            if (Build.VERSION.SDK_INT >= 30) {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "wm.currentWindowMetrics");
                bounds = currentWindowMetrics.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "windowMetrics.bounds");
                return new Pair<>(Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(Context context) {
            Pair<Integer, Integer> b16 = b(context);
            c.D = b16.getFirst().intValue();
            c.E = b16.getSecond().intValue();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.lastVisible = view.getVisibility() == 0;
        this.viewStateChangeListenerSet = new LinkedHashSet();
        this.runnable = new Runnable() { // from class: com.tencent.qqnt.avatar.resource.b
            @Override // java.lang.Runnable
            public final void run() {
                c.i(c.this);
            }
        };
        this.viewRef = new WeakReference<>(view);
    }

    private final boolean d() {
        boolean z16;
        View view = this.viewRef.get();
        if (view == null) {
            d.d(d.f352991a, "ViewStateChangeController", "isVisible view is null", null, 4, null);
            return false;
        }
        if (view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (D == 0 || E == 0) {
            Companion companion = INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            companion.c(context);
        }
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        if (rect.bottom < 0 || rect.top > E || rect.right < 0 || rect.left > D) {
            return false;
        }
        return true;
    }

    private final void e() {
        Iterator<a> it = this.viewStateChangeListenerSet.iterator();
        while (it.hasNext()) {
            it.next().onScrollEnd();
        }
    }

    private final void f() {
        Iterator<a> it = this.viewStateChangeListenerSet.iterator();
        while (it.hasNext()) {
            it.next().onScrollStart();
        }
    }

    private final void g() {
        boolean z16;
        if (this.isAttachedToWindow) {
            z16 = d();
        } else {
            z16 = false;
        }
        if (this.lastVisible == z16) {
            return;
        }
        Iterator<a> it = this.viewStateChangeListenerSet.iterator();
        while (it.hasNext()) {
            it.next().onVisibilityChanged(z16);
        }
        this.lastVisible = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        this$0.state = 0;
    }

    public final void h(boolean isAttachedToWindow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isAttachedToWindow);
            return;
        }
        this.isAttachedToWindow = isAttachedToWindow;
        if (this.viewStateChangeListenerSet.isEmpty()) {
            return;
        }
        g();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.viewStateChangeListenerSet.isEmpty()) {
            return;
        }
        View view = this.viewRef.get();
        if (view == null) {
            d.d(d.f352991a, "ViewStateChangeController", "onScrollChanged view is null", null, 4, null);
            return;
        }
        view.removeCallbacks(this.runnable);
        if (this.state == 0) {
            f();
            this.state = 1;
        }
        g();
        view.postDelayed(this.runnable, 100L);
    }
}
