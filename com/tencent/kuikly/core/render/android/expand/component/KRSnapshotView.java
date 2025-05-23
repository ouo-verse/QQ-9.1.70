package com.tencent.kuikly.core.render.android.expand.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import com.qq.e.comm.managers.plugin.PM;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001\tB\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R;\u0010 \u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019j\u0004\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRSnapshotView;", "Landroid/widget/ImageView;", "Li01/c;", "", "targetViewRef", "", "g", "", "c", "a", "", "propValue", "d", "", "propKey", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "I", "e", "Z", "needSnapshot", "f", "didSetSnapshotBitmap", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", tl.h.F, "Lkotlin/jvm/functions/Function1;", "snapshotSuccessCallback", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRSnapshotView extends ImageView implements i01.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int targetViewRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needSnapshot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean didSetSnapshotBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> snapshotSuccessCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRSnapshotView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.targetViewRef = -1;
    }

    private final void a() {
        Function1<Object, Unit> function1;
        if (this.didSetSnapshotBitmap && (function1 = this.snapshotSuccessCallback) != null) {
            function1.invoke(null);
        }
    }

    private final void c() {
        View view;
        Bitmap b16;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            view = aVar.b(this.targetViewRef);
        } else {
            view = null;
        }
        if (view != null && com.tencent.kuikly.core.render.android.css.ktx.b.j(com.tencent.kuikly.core.render.android.css.ktx.b.f(view)) != 0 && com.tencent.kuikly.core.render.android.css.ktx.b.i(com.tencent.kuikly.core.render.android.css.ktx.b.f(view)) != 0) {
            b16 = c.b(view);
            setImageBitmap(b16);
            this.didSetSnapshotBitmap = true;
            a();
        }
    }

    private final boolean d(Object propValue) {
        if (propValue != null) {
            this.snapshotSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            a();
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean g(int targetViewRef) {
        View view;
        if (this.targetViewRef != targetViewRef) {
            this.targetViewRef = targetViewRef;
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            if (aVar != null) {
                view = aVar.b(targetViewRef);
            } else {
                view = null;
            }
            setScaleType(ImageView.ScaleType.MATRIX);
            setImageMatrix(new Matrix());
            if (view != null && com.tencent.kuikly.core.render.android.css.ktx.b.j(com.tencent.kuikly.core.render.android.css.ktx.b.f(view)) != 0 && com.tencent.kuikly.core.render.android.css.ktx.b.i(com.tencent.kuikly.core.render.android.css.ktx.b.f(view)) != 0) {
                c();
            } else {
                this.needSnapshot = true;
                invalidate();
            }
        }
        return true;
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        int hashCode = propKey.hashCode();
        if (hashCode != -1737507425) {
            if (hashCode == -1536804643 && propKey.equals("targetViewRef")) {
                return g(((Integer) propValue).intValue());
            }
        } else if (propKey.equals("snapshotSuccess")) {
            return d(propValue);
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.a(this, method, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.l(this, parent);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.needSnapshot) {
            this.needSnapshot = false;
            c();
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return c.a.m(this, propKey);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.b(this, method, str, function1);
    }
}
