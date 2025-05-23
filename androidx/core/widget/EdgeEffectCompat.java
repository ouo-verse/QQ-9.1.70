package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    private EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i3) {
        this.mEdgeEffect.onAbsorb(i3);
        return true;
    }

    @Deprecated
    public boolean onPull(float f16) {
        this.mEdgeEffect.onPull(f16);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i3, int i16) {
        this.mEdgeEffect.setSize(i3, i16);
    }

    @Deprecated
    public boolean onPull(float f16, float f17) {
        onPull(this.mEdgeEffect, f16, f17);
        return true;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f16, float f17) {
        edgeEffect.onPull(f16, f17);
    }
}
