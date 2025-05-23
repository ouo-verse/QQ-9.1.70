package com.tencent.richframework.gallery.anim;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R(\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010(\u001a\u0004\u0018\u00010\"8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b\u00a8\u00065"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionInitData;", "", "()V", "backgroundColor", "", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "coverDrawable", "Landroid/graphics/drawable/Drawable;", "getCoverDrawable", "()Landroid/graphics/drawable/Drawable;", "setCoverDrawable", "(Landroid/graphics/drawable/Drawable;)V", "fadeCoverTimeMs", "getFadeCoverTimeMs", "setFadeCoverTimeMs", "imageEndRect", "Landroid/graphics/RectF;", "getImageEndRect", "()Landroid/graphics/RectF;", "setImageEndRect", "(Landroid/graphics/RectF;)V", "imageStartRect", "getImageStartRect", "setImageStartRect", "layoutEndRect", "getLayoutEndRect", "setLayoutEndRect", "layoutStartRect", "getLayoutStartRect", "setLayoutStartRect", "mEndScaleType", "Landroid/widget/ImageView$ScaleType;", "mImageEndRect", "mImageStartRect", "mLayoutEndRect", "mLayoutStartRect", "mStartScaleType", "startScaleType", "getStartScaleType", "()Landroid/widget/ImageView$ScaleType;", "setStartScaleType", "(Landroid/widget/ImageView$ScaleType;)V", "transitionAniDurationMs", "getTransitionAniDurationMs", "setTransitionAniDurationMs", "transitionDelayTimeMs", "getTransitionDelayTimeMs", "setTransitionDelayTimeMs", "toString", "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TransitionInitData {
    private int backgroundColor;

    /* renamed from: coverDrawable, reason: from kotlin metadata and from toString */
    @Nullable
    private Drawable mCoverDrawable;
    private int fadeCoverTimeMs;
    private final ImageView.ScaleType mEndScaleType;
    private RectF mImageEndRect;
    private RectF mImageStartRect;
    private RectF mLayoutEndRect;
    private RectF mLayoutStartRect;
    private ImageView.ScaleType mStartScaleType;
    private int transitionAniDurationMs;
    private int transitionDelayTimeMs;

    public TransitionInitData() {
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
        this.mStartScaleType = scaleType;
        this.mEndScaleType = scaleType;
        this.backgroundColor = -16777216;
        this.transitionDelayTimeMs = 300;
        this.fadeCoverTimeMs = 500;
        this.transitionAniDurationMs = 300;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    /* renamed from: getCoverDrawable, reason: from getter */
    public final Drawable getMCoverDrawable() {
        return this.mCoverDrawable;
    }

    public final int getFadeCoverTimeMs() {
        return this.fadeCoverTimeMs;
    }

    @Nullable
    public final RectF getImageEndRect() {
        RectF rectF = this.mImageEndRect;
        if (rectF == null) {
            return getLayoutEndRect();
        }
        return rectF;
    }

    @Nullable
    public final RectF getImageStartRect() {
        RectF rectF = this.mImageStartRect;
        if (rectF == null) {
            return getLayoutStartRect();
        }
        return rectF;
    }

    @Nullable
    public final RectF getLayoutEndRect() {
        RectF rectF = this.mLayoutEndRect;
        if (rectF == null) {
            return new RectF();
        }
        return rectF;
    }

    @Nullable
    public final RectF getLayoutStartRect() {
        RectF rectF = this.mLayoutStartRect;
        if (rectF == null) {
            return new RectF();
        }
        return rectF;
    }

    @Nullable
    public final ImageView.ScaleType getStartScaleType() {
        ImageView.ScaleType scaleType = this.mStartScaleType;
        if (scaleType == null) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return scaleType;
    }

    public final int getTransitionAniDurationMs() {
        return this.transitionAniDurationMs;
    }

    public final int getTransitionDelayTimeMs() {
        return this.transitionDelayTimeMs;
    }

    public final void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public final void setCoverDrawable(@Nullable Drawable drawable) {
        this.mCoverDrawable = drawable;
    }

    public final void setFadeCoverTimeMs(int i3) {
        this.fadeCoverTimeMs = i3;
    }

    public final void setImageEndRect(@Nullable RectF rectF) {
        this.mImageEndRect = rectF;
    }

    public final void setImageStartRect(@Nullable RectF rectF) {
        this.mImageStartRect = rectF;
    }

    public final void setLayoutEndRect(@Nullable RectF rectF) {
        this.mLayoutEndRect = rectF;
    }

    public final void setLayoutStartRect(@Nullable RectF rectF) {
        this.mLayoutStartRect = rectF;
    }

    public final void setStartScaleType(@Nullable ImageView.ScaleType scaleType) {
        this.mStartScaleType = scaleType;
    }

    public final void setTransitionAniDurationMs(int i3) {
        this.transitionAniDurationMs = i3;
    }

    public final void setTransitionDelayTimeMs(int i3) {
        this.transitionDelayTimeMs = i3;
    }

    @NotNull
    public String toString() {
        return "TransitionInitData{mLayoutStartRect=" + this.mLayoutStartRect + ", mLayoutEndRect=" + this.mLayoutEndRect + ", mImageStartRect=" + this.mImageStartRect + ", mImageEndRect=" + this.mImageEndRect + ", mStartScaleType=" + this.mStartScaleType + ", mCoverDrawable=" + this.mCoverDrawable + '}';
    }
}
