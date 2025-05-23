package com.tencent.mobileqq.vas.pay.page;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/c;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/graphics/Paint;", "paint", "", "a", "Landroid/text/TextPaint;", "drawState", "updateDrawState", "updateMeasureState", "Landroid/graphics/Typeface;", "d", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "<init>", "(Landroid/graphics/Typeface;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends MetricAffectingSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Typeface typeface;

    public c(@NotNull Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    private final void a(Paint paint) {
        Typeface typeface = paint.getTypeface();
        Intrinsics.checkNotNullExpressionValue(typeface, "paint.typeface");
        int style = typeface.getStyle() & (~this.typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint drawState) {
        Intrinsics.checkNotNullParameter(drawState, "drawState");
        a(drawState);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        a(paint);
    }
}
