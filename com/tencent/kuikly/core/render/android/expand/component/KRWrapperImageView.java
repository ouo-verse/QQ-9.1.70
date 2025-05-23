package com.tencent.kuikly.core.render.android.expand.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016JI\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010#\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRWrapperImageView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "src", "", "L", "K", "propKey", "", "propValue", "", "b", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "H", "Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "placeholderView", "I", "Ljava/lang/String;", "placeholder", "J", "imageView", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRWrapperImageView extends KRView {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private KRImageView placeholderView;

    /* renamed from: I, reason: from kotlin metadata */
    private String placeholder;

    /* renamed from: J, reason: from kotlin metadata */
    private KRImageView imageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRWrapperImageView$a;", "", "", "PROP_PLACEHOLDER", "Ljava/lang/String;", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRWrapperImageView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRWrapperImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.placeholder = "";
        KRImageView kRImageView = new KRImageView(context);
        addView(kRImageView);
        Unit unit = Unit.INSTANCE;
        this.imageView = kRImageView;
    }

    private final void K() {
        KRImageView kRImageView = this.placeholderView;
        if (kRImageView != null) {
            com.tencent.kuikly.core.render.android.css.ktx.b.n(kRImageView);
        }
        this.placeholderView = null;
        this.placeholder = "";
    }

    private final void L(String src) {
        boolean z16 = true;
        if (!Intrinsics.areEqual(this.placeholder, src)) {
            this.placeholder = src;
            KRImageView kRImageView = this.placeholderView;
            if (kRImageView != null) {
                com.tencent.kuikly.core.render.android.css.ktx.b.n(kRImageView);
            }
            if (this.placeholder.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                KRImageView kRImageView2 = new KRImageView(context);
                kRImageView2.setLayoutParams(new FrameLayout.LayoutParams(com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this)));
                kRImageView2.setScaleType(this.imageView.getScaleType());
                kRImageView2.b("src", this.placeholder);
                addView(kRImageView2, 0);
                Unit unit = Unit.INSTANCE;
                this.placeholderView = kRImageView2;
                return;
            }
            K();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        boolean b16 = super.b(propKey, propValue);
        if (!b16) {
            b16 = this.imageView.b(propKey, propValue);
        }
        if (Intrinsics.areEqual(propKey, "resize")) {
            KRImageView kRImageView = this.placeholderView;
            if (kRImageView != null) {
                kRImageView.b(propKey, propValue);
                return b16;
            }
            return b16;
        }
        if (Intrinsics.areEqual(propKey, "placeholder")) {
            L((String) propValue);
            return true;
        }
        return b16;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        return this.imageView.call(method, params, callback);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        super.s(propKey);
        boolean s16 = this.imageView.s(propKey);
        if (Intrinsics.areEqual(propKey, "placeholder")) {
            K();
            return true;
        }
        return s16;
    }

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        if (params != null) {
            this.imageView.setLayoutParams(new FrameLayout.LayoutParams(params.width, params.height));
            KRImageView kRImageView = this.placeholderView;
            if (kRImageView != null) {
                kRImageView.setLayoutParams(new FrameLayout.LayoutParams(params.width, params.height));
            }
        }
    }
}
