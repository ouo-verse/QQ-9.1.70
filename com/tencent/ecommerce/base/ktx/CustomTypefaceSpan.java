package com.tencent.ecommerce.base.ktx;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0016R\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/base/ktx/CustomTypefaceSpan;", "Landroid/text/style/TypefaceSpan;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Typeface;", "tf", "", "a", "Landroid/text/TextPaint;", "ds", "updateDrawState", "updateMeasureState", "kotlin.jvm.PlatformType", "d", "Landroid/graphics/Typeface;", "type", "Landroid/content/Context;", "context", "", "fontPath", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class CustomTypefaceSpan extends TypefaceSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Typeface type;

    public CustomTypefaceSpan(Context context, String str) {
        super("");
        this.type = Typeface.createFromAsset(context.getAssets(), str);
    }

    private final void a(Paint paint, Typeface tf5) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (~tf5.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(tf5);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds5) {
        a(ds5, this.type);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        a(paint, this.type);
    }
}
