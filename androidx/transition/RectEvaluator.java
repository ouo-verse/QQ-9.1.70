package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectEvaluator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f16, Rect rect, Rect rect2) {
        int i3 = rect.left + ((int) ((rect2.left - r0) * f16));
        int i16 = rect.top + ((int) ((rect2.top - r1) * f16));
        int i17 = rect.right + ((int) ((rect2.right - r2) * f16));
        int i18 = rect.bottom + ((int) ((rect2.bottom - r6) * f16));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i3, i16, i17, i18);
        }
        rect3.set(i3, i16, i17, i18);
        return this.mRect;
    }
}
