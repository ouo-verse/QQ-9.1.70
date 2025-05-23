package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    abstract void calcPosition(int i3, int i16, float f16, float f17, float f18, float f19);

    abstract float getPositionX();

    abstract float getPositionY();

    public abstract boolean intersects(int i3, int i16, RectF rectF, RectF rectF2, float f16, float f17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f16, float f17, String[] strArr, float[] fArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }
}
