package com.tencent.mobileqq.wink.editor.sticker.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.device.OfflineConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\b\u00a2\u0006\u0004\b%\u0010&J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002J\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\u001e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0002R\u001b\u0010\u0015\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/text/TextMenuBgView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "onMaskClick", "e", "", "useBlur", "", "grayColor", "Landroid/graphics/Bitmap;", "blurProvider", "l", "k", "j", "Landroid/util/Size;", "sizeProvider", "d", "Lkotlin/Lazy;", "i", "()Z", "isLowDevice", "Landroid/widget/FrameLayout;", "grayBg", "Lcom/tencent/qui/quiblurview/QQBlurView;", "f", "Lcom/tencent/qui/quiblurview/QQBlurView;", "blurView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "blurOrigView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TextMenuBgView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isLowDevice;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout grayBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQBlurView blurView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView blurOrigView;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f321924i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMenuBgView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 onMaskClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onMaskClick, "$onMaskClick");
        onMaskClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 onMaskClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onMaskClick, "$onMaskClick");
        onMaskClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function0 onMaskClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onMaskClick, "$onMaskClick");
        onMaskClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean i() {
        return ((Boolean) this.isLowDevice.getValue()).booleanValue();
    }

    public final void d(boolean useBlur, @NotNull Function0<Size> sizeProvider) {
        Intrinsics.checkNotNullParameter(sizeProvider, "sizeProvider");
        if (!i() && useBlur) {
            Size invoke = sizeProvider.invoke();
            if (invoke != null) {
                int g16 = (com.tencent.videocut.utils.o.g() - invoke.getWidth()) / 2;
                QQBlurView qQBlurView = this.blurView;
                QQBlurView qQBlurView2 = null;
                if (qQBlurView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    qQBlurView = null;
                }
                qQBlurView.getLayoutParams().width = com.tencent.videocut.utils.o.g();
                QQBlurView qQBlurView3 = this.blurView;
                if (qQBlurView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                } else {
                    qQBlurView2 = qQBlurView3;
                }
                qQBlurView2.getLayoutParams().height = invoke.getHeight();
                ViewGroup.LayoutParams layoutParams = this.grayBg.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = com.tencent.videocut.utils.o.g();
                }
                this.grayBg.setPadding(g16, 0, g16, 0);
                ViewGroup.LayoutParams layoutParams2 = this.grayBg.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = invoke.getHeight();
                    return;
                }
                return;
            }
            return;
        }
        this.grayBg.setPadding(0, 0, 0, 0);
    }

    public final void e(@NotNull final Function0<Unit> onMaskClick) {
        Intrinsics.checkNotNullParameter(onMaskClick, "onMaskClick");
        if (i()) {
            this.grayBg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TextMenuBgView.f(Function0.this, view);
                }
            });
            return;
        }
        ImageView imageView = this.blurOrigView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurOrigView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextMenuBgView.g(Function0.this, view);
            }
        });
        QQBlurView qQBlurView = this.blurView;
        QQBlurView qQBlurView2 = qQBlurView;
        if (qQBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurView2 = null;
        }
        qQBlurView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextMenuBgView.h(Function0.this, view);
            }
        });
        qQBlurView2.m(qQBlurView2);
        qQBlurView2.z(null);
        qQBlurView2.j(this.grayBg);
        qQBlurView2.k(0);
        qQBlurView2.l(10);
        qQBlurView2.A(4.0f);
        qQBlurView2.setEnableBlur(true);
        qQBlurView2.x();
    }

    public final void j() {
        if (i()) {
            return;
        }
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurView = null;
        }
        qQBlurView.onDestroy();
    }

    public final void k() {
        if (i()) {
            return;
        }
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurView = null;
        }
        qQBlurView.onPause();
        QQBlurView qQBlurView2 = this.blurView;
        if (qQBlurView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            qQBlurView2 = null;
        }
        qQBlurView2.setVisibility(8);
        ImageView imageView = this.blurOrigView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurOrigView");
            imageView = null;
        }
        imageView.setImageBitmap(null);
    }

    public final void l(boolean useBlur, @ColorRes int grayColor, @NotNull Function0<Bitmap> blurProvider) {
        Intrinsics.checkNotNullParameter(blurProvider, "blurProvider");
        this.grayBg.setForeground(new ColorDrawable(ContextCompat.getColor(getContext(), grayColor)));
        if (!i()) {
            ImageView imageView = null;
            if (useBlur) {
                QQBlurView qQBlurView = this.blurView;
                if (qQBlurView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    qQBlurView = null;
                }
                qQBlurView.setEnableBlur(true);
                QQBlurView qQBlurView2 = this.blurView;
                if (qQBlurView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    qQBlurView2 = null;
                }
                qQBlurView2.onResume();
                QQBlurView qQBlurView3 = this.blurView;
                if (qQBlurView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    qQBlurView3 = null;
                }
                qQBlurView3.setVisibility(0);
                ImageView imageView2 = this.blurOrigView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurOrigView");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageBitmap(blurProvider.invoke());
                return;
            }
            QQBlurView qQBlurView4 = this.blurView;
            if (qQBlurView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                qQBlurView4 = null;
            }
            qQBlurView4.setEnableBlur(false);
            QQBlurView qQBlurView5 = this.blurView;
            if (qQBlurView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                qQBlurView5 = null;
            }
            qQBlurView5.setVisibility(8);
            ImageView imageView3 = this.blurOrigView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurOrigView");
                imageView3 = null;
            }
            imageView3.setImageBitmap(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMenuBgView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextMenuBgView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.f321924i = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.editor.sticker.text.TextMenuBgView$isLowDevice$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()) == 1);
            }
        });
        this.isLowDevice = lazy;
        FrameLayout frameLayout = new FrameLayout(getContext());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = frameLayout.getContext().getResources().getDimensionPixelSize(R.dimen.dje);
        frameLayout.setLayoutParams(layoutParams);
        addView(frameLayout);
        this.grayBg = frameLayout;
        if (i()) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frameLayout.addView(imageView);
        this.blurOrigView = imageView;
        QQBlurView qQBlurView = new QQBlurView(getContext());
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, -1);
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = qQBlurView.getContext().getResources().getDimensionPixelSize(R.dimen.dje);
        qQBlurView.setLayoutParams(layoutParams2);
        addView(qQBlurView);
        this.blurView = qQBlurView;
    }

    public /* synthetic */ TextMenuBgView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
