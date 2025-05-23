package com.tencent.mobileqq.guild.aisearch.input;

import android.os.Build;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0004\u000b\u0011\u0016\u0019B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u00060\u001bR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u00060\u001fR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/f;", "", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", tl.h.F, "", "k", "j", "g", "Landroid/view/View;", "a", "Landroid/view/View;", "getInputPanelContainer", "()Landroid/view/View;", "inputPanelContainer", "Lcom/tencent/mobileqq/guild/aisearch/input/f$b;", "b", "Lcom/tencent/mobileqq/guild/aisearch/input/f$b;", "i", "()Lcom/tencent/mobileqq/guild/aisearch/input/f$b;", "stateListener", "c", "I", "persistentInsetTypes", "d", "deferredInsetTypes", "Lcom/tencent/mobileqq/guild/aisearch/input/f$d;", "e", "Lcom/tencent/mobileqq/guild/aisearch/input/f$d;", "inputTranslateDeferringInsetsCallback", "Lcom/tencent/mobileqq/guild/aisearch/input/f$c;", "f", "Lcom/tencent/mobileqq/guild/aisearch/input/f$c;", "rootViewDeferringInsetsCallback", "", "Z", "isAnimationProgressing", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/aisearch/input/f$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f214059i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View inputPanelContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b stateListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int persistentInsetTypes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int deferredInsetTypes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d inputTranslateDeferringInsetsCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c rootViewDeferringInsetsCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimationProgressing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR\u001d\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/f$a;", "", "", "isUseSystemWindowInsetAnimation", "Z", "a", "()Z", "isUseSystemWindowInsetAnimation$annotations", "()V", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.input.f$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return f.f214059i;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/f$b;", "", "", "keyboardHeight", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(int keyboardHeight);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/f$c;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View;", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/input/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private final class c implements OnApplyWindowInsetsListener {
        public c() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NotNull
        public WindowInsetsCompat onApplyWindowInsets(@Nullable View v3, @NotNull WindowInsetsCompat insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            if (!f.this.isAnimationProgressing) {
                f.this.k();
            }
            return insets;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/f$d;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/WindowInsetsAnimationCompat;", "animation", "", "onPrepare", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", "runningAnimations", "onProgress", "onEnd", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/input/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    private final class d extends WindowInsetsAnimationCompat.Callback {
        public d() {
            super(0);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(@NotNull WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onEnd(animation);
            if (f.this.isAnimationProgressing && (animation.getTypeMask() & f.this.deferredInsetTypes) != 0) {
                f.this.isAnimationProgressing = false;
                f.this.k();
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onPrepare(@NotNull WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onPrepare(animation);
            if ((animation.getTypeMask() & f.this.deferredInsetTypes) != 0) {
                f.this.isAnimationProgressing = true;
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            if (f.this.isAnimationProgressing) {
                f.this.getStateListener().a(f.this.h(insets));
                return insets;
            }
            return insets;
        }
    }

    static {
        boolean z16;
        if (Build.VERSION.SDK_INT >= 30) {
            z16 = true;
        } else {
            z16 = false;
        }
        f214059i = z16;
    }

    public f(@NotNull View inputPanelContainer, @NotNull b stateListener) {
        Intrinsics.checkNotNullParameter(inputPanelContainer, "inputPanelContainer");
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        this.inputPanelContainer = inputPanelContainer;
        this.stateListener = stateListener;
        this.persistentInsetTypes = WindowInsetsCompat.Type.navigationBars();
        this.deferredInsetTypes = WindowInsetsCompat.Type.ime();
        this.inputTranslateDeferringInsetsCallback = new d();
        this.rootViewDeferringInsetsCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h(WindowInsetsCompat insets) {
        Insets insets2 = insets.getInsets(this.deferredInsetTypes);
        Intrinsics.checkNotNullExpressionValue(insets2, "insets.getInsets(deferredInsetTypes)");
        Insets insets3 = insets.getInsets(this.persistentInsetTypes);
        Intrinsics.checkNotNullExpressionValue(insets3, "insets.getInsets(persistentInsetTypes)");
        Insets max = Insets.max(Insets.subtract(insets2, insets3), Insets.NONE);
        Intrinsics.checkNotNullExpressionValue(max, "subtract(typesInset, oth\u2026t, Insets.NONE)\n        }");
        return max.bottom - max.top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.inputPanelContainer);
        if (rootWindowInsets == null) {
            return;
        }
        boolean isVisible = rootWindowInsets.isVisible(this.deferredInsetTypes);
        int h16 = h(rootWindowInsets);
        if (isVisible) {
            if (h16 > 0) {
                this.stateListener.a(h16);
                return;
            }
            return;
        }
        this.stateListener.a(0);
    }

    public final void g() {
        if (!f214059i) {
            return;
        }
        ViewCompat.setWindowInsetsAnimationCallback(this.inputPanelContainer, null);
        ViewCompat.setOnApplyWindowInsetsListener(this.inputPanelContainer, null);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final b getStateListener() {
        return this.stateListener;
    }

    public final void j() {
        if (!f214059i) {
            return;
        }
        ViewCompat.setWindowInsetsAnimationCallback(this.inputPanelContainer, this.inputTranslateDeferringInsetsCallback);
        ViewCompat.setOnApplyWindowInsetsListener(this.inputPanelContainer, this.rootViewDeferringInsetsCallback);
    }
}
