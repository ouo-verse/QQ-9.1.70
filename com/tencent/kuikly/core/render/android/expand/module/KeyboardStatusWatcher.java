package com.tencent.kuikly.core.render.android.expand.module;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.kuikly.core.render.android.expand.module.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0006R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0013R&\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KeyboardStatusWatcher;", "Landroid/widget/PopupWindow;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "f", "height", "", "g", "onGlobalLayout", "Lcom/tencent/kuikly/core/render/android/expand/module/s;", "listener", "c", tl.h.F, "d", "Landroid/widget/FrameLayout;", "Lkotlin/Lazy;", "e", "()Landroid/widget/FrameLayout;", "popupView", "I", "lastVisibleHeight", "lastVisibleBottom", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "listeners", "Landroid/app/Activity;", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/kuikly/core/render/android/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyRenderContext", "<init>", "(Landroid/app/Activity;Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KeyboardStatusWatcher extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy popupView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastVisibleHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastVisibleBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ArrayList<s> listeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyRenderContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardStatusWatcher(@NotNull Activity activity, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        super(activity);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.kuiklyRenderContext = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KeyboardStatusWatcher$popupView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                Activity activity2;
                activity2 = KeyboardStatusWatcher.this.activity;
                FrameLayout frameLayout = new FrameLayout(activity2);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
                return frameLayout;
            }
        });
        this.popupView = lazy;
        this.lastVisibleHeight = -1;
        this.lastVisibleBottom = -1;
        this.listeners = new ArrayList<>();
        setContentView(e());
        setSoftInputMode(21);
        setInputMethodMode(1);
        setWidth(0);
        setHeight(-1);
        final View findViewById = activity.findViewById(R.id.content);
        if (findViewById != null) {
            findViewById.post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.module.KeyboardStatusWatcher.1
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardStatusWatcher.this.e().getViewTreeObserver().addOnGlobalLayoutListener(KeyboardStatusWatcher.this);
                    if (!KeyboardStatusWatcher.this.isShowing() && findViewById.getWindowToken() != null) {
                        KeyboardStatusWatcher.this.showAtLocation(findViewById, 0, 0, 0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout e() {
        return (FrameLayout) this.popupView.getValue();
    }

    private final int f() {
        try {
            Object systemService = this.activity.getSystemService("window");
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                if (defaultDisplay != null) {
                    com.tencent.kuikly.core.render.android.a aVar = this.kuiklyRenderContext;
                    if (aVar != null && aVar.u0()) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getRealMetrics(displayMetrics);
                        return displayMetrics.heightPixels;
                    }
                    return defaultDisplay.getHeight();
                }
                return -1;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        } catch (SecurityException e16) {
            w.f392617a.b("KRKeyboardModule", "getScreenHeight: " + e16.getMessage());
            return -1;
        }
    }

    private final void g(int height) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            s.a.a((s) it.next(), height, null, null, 6, null);
        }
    }

    public final void c(@NotNull s listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void d() {
        dismiss();
        e().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.listeners.clear();
    }

    public final void h(@NotNull s listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i3;
        Rect rect = new Rect();
        e().getWindowVisibleDisplayFrame(rect);
        int i16 = rect.bottom - rect.top;
        if (i16 == this.lastVisibleHeight) {
            return;
        }
        this.lastVisibleHeight = i16;
        int f16 = f();
        if (this.lastVisibleBottom < 0 && i16 > f16 * 0.8d) {
            this.lastVisibleBottom = rect.bottom;
        }
        int i17 = this.lastVisibleBottom;
        if (i17 < 0) {
            Rect rect2 = new Rect();
            Window window = this.activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            i17 = rect2.bottom;
            i3 = rect.bottom;
        } else {
            i3 = rect.bottom;
        }
        int i18 = i17 - i3;
        if (i18 > f16 * 0.2d) {
            com.tencent.kuikly.core.render.android.a aVar = this.kuiklyRenderContext;
            if (aVar != null && aVar.u0()) {
                i18 += f16 - this.lastVisibleBottom;
            }
            g(i18);
            return;
        }
        g(0);
    }
}
