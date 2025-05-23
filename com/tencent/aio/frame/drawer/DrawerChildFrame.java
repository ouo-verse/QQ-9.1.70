package com.tencent.aio.frame.drawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001\u0015B\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0003J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerChildFrame;", "Landroid/widget/FrameLayout;", "", "", "b", "", "c", "Landroid/view/View;", "child", "addView", "", "widthMeasureSpec", "heightMeasureSpec", "e", "l", "t", "r", "d", "requestLayout", "", NodeProps.VISIBLE, "a", "(Z)V", "g", "f", "Z", "isVisible", "I", "interceptRequestCount", "Landroid/view/View;", "hostView", "Landroid/content/Context;", "context", "<init>", "(Landroid/view/View;Landroid/content/Context;)V", h.F, "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class DrawerChildFrame extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final a f69266h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isVisible;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int interceptRequestCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View hostView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/frame/drawer/DrawerChildFrame$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
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
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f69266h = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerChildFrame(@Nullable View view, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) context);
            return;
        }
        this.hostView = view;
        if (view != null) {
            addView(view);
        }
    }

    private final String b() {
        Class<?> cls;
        View view = this.hostView;
        if (view != null) {
            cls = view.getClass();
        } else {
            cls = getClass();
        }
        return cls.getSimpleName();
    }

    @CallSuper
    private final void c() {
        if (this.interceptRequestCount > 0) {
            this.interceptRequestCount = 0;
            requestLayout();
        }
    }

    public final void a(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, visible);
            return;
        }
        if (this.isVisible == visible) {
            return;
        }
        this.isVisible = visible;
        if (visible) {
            g();
        } else {
            f();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) child);
            return;
        }
        super.addView(child);
        ct.a.a(this, "DrawerChildFrame", "add " + child + " time at " + System.currentTimeMillis());
    }

    public final void d(int l3, int t16, int r16, int b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(l3), Integer.valueOf(t16), Integer.valueOf(r16), Integer.valueOf(b16));
            return;
        }
        layout(l3, t16, r16, b16);
        ct.a.a(this, "DrawerChildFrame", "layoutFrame " + b() + " l:" + l3 + " t:" + t16 + " r:" + r16 + " b:" + b16);
    }

    public final void e(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
            return;
        }
        measure(widthMeasureSpec, heightMeasureSpec);
        ct.a.a(this, "DrawerChildFrame", "measureFrame " + b());
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ct.a.a(this, "DrawerChildFrame", b() + ", onFrameInvisible");
    }

    @CallSuper
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ct.a.a(this, "DrawerChildFrame", b() + ", onFrameVisible");
        c();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!this.isVisible) {
            this.interceptRequestCount++;
        } else {
            super.requestLayout();
        }
    }
}
