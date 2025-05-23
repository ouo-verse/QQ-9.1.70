package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.drawable.DrawableContainer;

/* compiled from: P */
@Public
/* loaded from: classes5.dex */
public class SpecifiedDrawable extends DrawableContainer {
    private SpecificState mState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SpecificState extends DrawableContainer.ContainerState {
        int mHeight;
        int mWidth;

        SpecificState(Drawable drawable, DrawableContainer drawableContainer) {
            super(drawable, drawableContainer);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new SpecifiedDrawable(this, (Resources) null);
        }

        SpecificState(SpecificState specificState, DrawableContainer drawableContainer, Resources resources) {
            super(specificState, drawableContainer, resources);
            this.mWidth = specificState.mWidth;
            this.mHeight = specificState.mHeight;
        }
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i3 = this.mState.mHeight;
        if (i3 <= 0) {
            return super.getIntrinsicHeight();
        }
        return i3;
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i3 = this.mState.mWidth;
        if (i3 <= 0) {
            return super.getIntrinsicWidth();
        }
        return i3;
    }

    public int getOrginalWidth() {
        return super.getIntrinsicWidth();
    }

    public int getOriginalHeight() {
        return super.getIntrinsicHeight();
    }

    @Public
    public void resize(int i3, int i16) {
        SpecificState specificState = this.mState;
        if (specificState.mWidth != i3 || specificState.mHeight != i16) {
            specificState.mWidth = i3;
            specificState.mHeight = i16;
            invalidateSelf();
        }
    }

    @Public
    public SpecifiedDrawable(Drawable drawable) {
        this(drawable, -1, -1);
    }

    @Public
    public SpecifiedDrawable(Drawable drawable, int i3, int i16) {
        SpecificState specificState = new SpecificState(drawable, this);
        this.mState = specificState;
        specificState.mWidth = i3;
        specificState.mHeight = i16;
        setConstantState(specificState);
    }

    SpecifiedDrawable(SpecificState specificState, Resources resources) {
        SpecificState specificState2 = new SpecificState(specificState, this, resources);
        this.mState = specificState2;
        setConstantState(specificState2);
    }
}
