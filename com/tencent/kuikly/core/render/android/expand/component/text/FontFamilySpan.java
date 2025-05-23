package com.tencent.kuikly.core.render.android.expand.component.text;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import d01.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/FontFamilySpan;", "Landroid/text/style/TypefaceSpan;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Typeface;", "tf", "", "b", "Landroid/text/TextPaint;", "ds", "updateDrawState", "updateMeasureState", "d", "Landroid/graphics/Typeface;", "tfe", "", "fontFamily", "<init>", "(Ljava/lang/String;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class FontFamilySpan extends TypefaceSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Typeface tfe;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FontFamilySpan(@NotNull String fontFamily) {
        super("");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        d01.f c16 = u.f392615m.c();
        if (c16 != null) {
            c16.a(fontFamily, new Function1<Typeface, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.text.FontFamilySpan.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Typeface typeface) {
                    invoke2(typeface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Typeface typeface) {
                    FontFamilySpan.this.tfe = typeface;
                }
            });
        }
    }

    private final void b(Paint paint, Typeface tf5) {
        paint.setTypeface(tf5);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds5) {
        Intrinsics.checkNotNullParameter(ds5, "ds");
        Typeface typeface = this.tfe;
        if (typeface != null) {
            b(ds5, typeface);
        } else {
            super.updateDrawState(ds5);
        }
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Typeface typeface = this.tfe;
        if (typeface != null) {
            b(paint, typeface);
        } else {
            super.updateMeasureState(paint);
        }
    }
}
