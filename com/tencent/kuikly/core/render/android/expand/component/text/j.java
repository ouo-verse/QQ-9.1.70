package com.tencent.kuikly.core.render.android.expand.component.text;

import android.graphics.LinearGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.util.SizeF;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R&\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/j;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "Lkotlin/Triple;", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "", "", "d", "Lkotlin/Triple;", "backgroundImageParseTriple", "Lkotlin/Function0;", "Landroid/util/SizeF;", "e", "Lkotlin/jvm/functions/Function0;", "sizeGetter", "", "backgroundImage", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class j extends CharacterStyle implements UpdateAppearance {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Triple<GradientDrawable.Orientation, int[], float[]> backgroundImageParseTriple;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<SizeF> sizeGetter;

    public j(@NotNull String backgroundImage, @NotNull Function0<SizeF> sizeGetter) {
        Intrinsics.checkNotNullParameter(backgroundImage, "backgroundImage");
        Intrinsics.checkNotNullParameter(sizeGetter, "sizeGetter");
        this.sizeGetter = sizeGetter;
        this.backgroundImageParseTriple = f01.b.INSTANCE.c(backgroundImage);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0034. Please report as an issue. */
    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint tp5) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        float f29;
        float f36;
        float f37;
        float f38;
        float f39;
        float f46;
        float f47;
        Intrinsics.checkNotNullParameter(tp5, "tp");
        RectF rectF = new RectF();
        SizeF invoke = this.sizeGetter.invoke();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = invoke.getWidth();
        rectF.bottom = invoke.getHeight();
        switch (i.f117982a[this.backgroundImageParseTriple.getFirst().ordinal()]) {
            case 1:
                f16 = rectF.left;
                f17 = rectF.top;
                f18 = rectF.bottom;
                f38 = f18;
                f39 = f16;
                f46 = f39;
                f47 = f17;
                break;
            case 2:
                f19 = rectF.right;
                f26 = rectF.top;
                f27 = rectF.left;
                f28 = rectF.bottom;
                f38 = f28;
                f39 = f19;
                f47 = f26;
                f46 = f27;
                break;
            case 3:
                f29 = rectF.right;
                f36 = rectF.top;
                f37 = rectF.left;
                f46 = f37;
                f39 = f29;
                f47 = f36;
                f38 = f47;
                break;
            case 4:
                f19 = rectF.right;
                f26 = rectF.bottom;
                f27 = rectF.left;
                f28 = rectF.top;
                f38 = f28;
                f39 = f19;
                f47 = f26;
                f46 = f27;
                break;
            case 5:
                f16 = rectF.left;
                f17 = rectF.bottom;
                f18 = rectF.top;
                f38 = f18;
                f39 = f16;
                f46 = f39;
                f47 = f17;
                break;
            case 6:
                f19 = rectF.left;
                f26 = rectF.bottom;
                f27 = rectF.right;
                f28 = rectF.top;
                f38 = f28;
                f39 = f19;
                f47 = f26;
                f46 = f27;
                break;
            case 7:
                f29 = rectF.left;
                f36 = rectF.top;
                f37 = rectF.right;
                f46 = f37;
                f39 = f29;
                f47 = f36;
                f38 = f47;
                break;
            default:
                f19 = rectF.left;
                f26 = rectF.top;
                f27 = rectF.right;
                f28 = rectF.bottom;
                f38 = f28;
                f39 = f19;
                f47 = f26;
                f46 = f27;
                break;
        }
        tp5.setShader(new LinearGradient(f39, f47, f46, f38, this.backgroundImageParseTriple.getSecond(), this.backgroundImageParseTriple.getThird(), Shader.TileMode.REPEAT));
    }
}
