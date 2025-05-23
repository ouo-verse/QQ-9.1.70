package com.tencent.gdtad.basics.motivebrowsing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u0002*\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingImage;", "Landroid/view/View;", "Landroid/graphics/drawable/Drawable;", "a", "c", "Landroid/content/res/Resources;", "", "id", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/graphics/drawable/GradientDrawable;", "d", "Landroid/graphics/drawable/GradientDrawable;", "circleDrawable", "e", "Landroid/graphics/drawable/Drawable;", "closeDrawable", "f", "Lkotlin/Lazy;", "()I", CanvasView.ACTION_TRANSLATE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtMotiveBrowsingImage extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GradientDrawable circleDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable closeDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy translate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GdtMotiveBrowsingImage(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingImage$translate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(7.5f));
            }
        });
        this.translate = lazy;
    }

    private final Drawable a() {
        if (this.circleDrawable == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.circleDrawable = gradientDrawable;
            Intrinsics.checkNotNull(gradientDrawable);
            gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), Color.parseColor("#E5E5E5"));
            gradientDrawable.setCornerRadius(ViewUtils.dpToPx(18.0f));
            int dpToPx = ViewUtils.dpToPx(33.0f);
            gradientDrawable.setBounds(0, 0, dpToPx, dpToPx);
        }
        GradientDrawable gradientDrawable2 = this.circleDrawable;
        Intrinsics.checkNotNull(gradientDrawable2);
        return gradientDrawable2;
    }

    private final Drawable b(Resources resources, @DrawableRes int i3) {
        Drawable drawable = resources.getDrawable(i3, null);
        Intrinsics.checkNotNullExpressionValue(drawable, "{\n            getDrawable(id, null)\n        }");
        return drawable;
    }

    private final Drawable c() {
        if (this.closeDrawable == null) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            this.closeDrawable = b(resources, R.drawable.mxv);
            int dpToPx = ViewUtils.dpToPx(18.0f);
            Drawable drawable = this.closeDrawable;
            Intrinsics.checkNotNull(drawable);
            drawable.setBounds(0, 0, dpToPx, dpToPx);
        }
        Drawable drawable2 = this.closeDrawable;
        Intrinsics.checkNotNull(drawable2);
        return drawable2;
    }

    private final int d() {
        return ((Number) this.translate.getValue()).intValue();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            a().draw(canvas);
            canvas.save();
            canvas.translate(d(), d());
            c().draw(canvas);
            canvas.restore();
        }
    }
}
