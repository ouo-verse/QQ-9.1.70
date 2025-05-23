package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    public abstract Path getPath(float f16, float f17, float f18, float f19);

    public PathMotion(Context context, AttributeSet attributeSet) {
    }
}
