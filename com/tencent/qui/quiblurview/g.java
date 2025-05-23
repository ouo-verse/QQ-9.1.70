package com.tencent.qui.quiblurview;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qui.quiblurview.QQBlurPreDrawListener;
import com.tencent.qui.quiblurview.QQNativeBlurView;
import com.tencent.qui.quiblurview.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\fB3\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010&\u001a\u00020$\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qui/quiblurview/g;", "Lcom/tencent/qui/quiblurview/QQNativeBlurView$b;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "d", "e", "Lkotlin/Pair;", "", "f", "", "position", "a", "draw", "Lcom/tencent/qui/quiblurview/QQNativeBlurView;", "qqNativeBlurView", "b", "c", "", "getScrollX", "getScrollY", "getScale", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "bgList", "Landroid/view/View;", "Landroid/view/View;", "bgView", "", "Ljava/util/List;", "bgParam", "Lcom/tencent/qui/quiblurview/f$d;", "Lcom/tencent/qui/quiblurview/f$d;", "nativeBlurParam", "", "Z", "isViewScaled", "<init>", "(Landroid/view/View;Ljava/util/List;Lcom/tencent/qui/quiblurview/f$d;Z)V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class g implements QQNativeBlurView.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Object> bgList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View bgView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<Object> bgParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final f.d nativeBlurParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isViewScaled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qui/quiblurview/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QUIBlurView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.qui.quiblurview.g$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9376);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull View bgView, @Nullable List<? extends Object> list, @Nullable f.d dVar, boolean z16) {
        Intrinsics.checkNotNullParameter(bgView, "bgView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bgView, list, dVar, Boolean.valueOf(z16));
            return;
        }
        this.bgView = bgView;
        this.bgParam = list;
        this.nativeBlurParam = dVar;
        this.isViewScaled = z16;
        this.bgList = new ArrayList<>();
        if (list != null) {
            for (Object obj : list) {
                if ((obj instanceof Drawable) || (obj instanceof View)) {
                    this.bgList.add(obj);
                }
            }
        }
    }

    private final void d(Canvas canvas) {
        for (Object obj : this.bgList) {
            if (obj instanceof View) {
                ((View) obj).draw(canvas);
            } else if (obj instanceof Drawable) {
                Drawable drawable = (Drawable) obj;
                if (drawable.getBounds().width() > 0 && drawable.getBounds().height() > 0) {
                    drawable.draw(canvas);
                }
            }
        }
    }

    private final void e(Canvas canvas) {
        this.bgView.draw(canvas);
    }

    private final Pair<Float, Float> f() {
        View view = this.bgView;
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        while (view.getParent() != null && (view.getParent() instanceof View)) {
            Object parent = view.getParent();
            if (parent != null) {
                view = (View) parent;
                scaleX *= view.getScaleX();
                scaleY *= view.getScaleY();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
        }
        return new Pair<>(Float.valueOf(scaleX), Float.valueOf(scaleY));
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    public void a(@NotNull int[] position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) position);
        } else {
            Intrinsics.checkNotNullParameter(position, "position");
            this.bgView.getLocationOnScreen(position);
        }
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    public void b(@NotNull QQNativeBlurView qqNativeBlurView) {
        f.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqNativeBlurView);
            return;
        }
        Intrinsics.checkNotNullParameter(qqNativeBlurView, "qqNativeBlurView");
        QQBlurPreDrawListener.Companion companion = QQBlurPreDrawListener.INSTANCE;
        View view = this.bgView;
        f.d dVar = this.nativeBlurParam;
        f.b bVar2 = null;
        if (dVar != null) {
            bVar = dVar.b();
        } else {
            bVar = null;
        }
        QQBlurPreDrawListener a16 = companion.a(view, bVar);
        f.d dVar2 = this.nativeBlurParam;
        if (dVar2 != null) {
            bVar2 = dVar2.a();
        }
        a16.d(qqNativeBlurView, bVar2);
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    public void c(@NotNull QQNativeBlurView qqNativeBlurView) {
        f.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qqNativeBlurView);
            return;
        }
        Intrinsics.checkNotNullParameter(qqNativeBlurView, "qqNativeBlurView");
        QQBlurPreDrawListener.Companion companion = QQBlurPreDrawListener.INSTANCE;
        View view = this.bgView;
        f.d dVar = this.nativeBlurParam;
        if (dVar != null) {
            bVar = dVar.b();
        } else {
            bVar = null;
        }
        companion.a(view, bVar).e(qqNativeBlurView);
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        try {
            if (!this.bgList.isEmpty()) {
                d(canvas);
            } else {
                e(canvas);
            }
        } catch (Throwable th5) {
            ud0.d.g("QQNativeBlurViewBlurSource", ud0.d.f438811e, "[draw] exc=" + th5);
        }
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    @NotNull
    public Pair<Float, Float> getScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Pair) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!this.isViewScaled) {
            return new Pair<>(Float.valueOf(1.0f), Float.valueOf(1.0f));
        }
        return f();
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    public int getScrollX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.bgView.getScrollX();
    }

    @Override // com.tencent.qui.quiblurview.QQNativeBlurView.b
    public int getScrollY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.bgView.getScrollY();
    }

    public /* synthetic */ g(View view, List list, f.d dVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, list, dVar, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, view, list, dVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
