package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class WrappedDrawableState extends Drawable.ConstantState {
    int mChangingConfigurations;
    Drawable.ConstantState mDrawableState;
    ColorStateList mTint;
    PorterDuff.Mode mTintMode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableState(@Nullable WrappedDrawableState wrappedDrawableState) {
        this.mTint = null;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (wrappedDrawableState != null) {
            this.mChangingConfigurations = wrappedDrawableState.mChangingConfigurations;
            this.mDrawableState = wrappedDrawableState.mDrawableState;
            this.mTint = wrappedDrawableState.mTint;
            this.mTintMode = wrappedDrawableState.mTintMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canConstantState() {
        if (this.mDrawableState != null) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i3;
        int i16 = this.mChangingConfigurations;
        Drawable.ConstantState constantState = this.mDrawableState;
        if (constantState != null) {
            i3 = constantState.getChangingConfigurations();
        } else {
            i3 = 0;
        }
        return i16 | i3;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return new WrappedDrawableApi21(this, resources);
    }
}
