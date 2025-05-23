package com.tencent.now.pkgame.pkgame.scorebar.view;

import android.content.Context;
import android.text.TextPaint;
import com.tencent.mobileqq.util.x;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import oo3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J0\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/scorebar/view/b;", "", "Landroid/content/Context;", "context", "", "textSizeSp", "", "b", "width", "", "leftScore", "rightScore", "leftReserveWidth", "rightReserveWidth", "Loo3/e;", "a", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f339090a = new b();

    b() {
    }

    @JvmStatic
    @NotNull
    public static final e a(int width, long leftScore, long rightScore, float leftReserveWidth, float rightReserveWidth) {
        e eVar = new e();
        eVar.f423269a = leftScore;
        eVar.f423270b = rightScore;
        if (leftScore == 0 && rightScore == 0) {
            eVar.f423271c = width * 0.5f;
        } else if (leftScore > 0 && rightScore == 0) {
            eVar.f423271c = width - rightReserveWidth;
        } else if (leftScore == 0 && rightScore > 0) {
            eVar.f423271c = leftReserveWidth;
        } else {
            float f16 = ((float) leftScore) * 1.0f;
            float f17 = (float) (leftScore + rightScore);
            float f18 = f16 / f17;
            float f19 = (((float) rightScore) * 1.0f) / f17;
            float f26 = width;
            float f27 = f18 * f26;
            eVar.f423271c = f27;
            float f28 = f19 * f26;
            eVar.f423272d = f28;
            if (f27 < leftReserveWidth) {
                eVar.f423271c = leftReserveWidth;
            }
            if (f28 < rightReserveWidth) {
                eVar.f423271c = f26 - rightReserveWidth;
            }
        }
        eVar.f423272d = width - eVar.f423271c;
        return eVar;
    }

    @JvmStatic
    public static final float b(@Nullable Context context, int textSizeSp) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(x.c(context, textSizeSp));
        return textPaint.measureText("0");
    }
}
