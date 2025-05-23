package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class DrawableContainer extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;
    private int mAlpha = 255;
    private int mCurIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Api21Impl {
        Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources getResources(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        int mDensity;
        boolean mDither;
        SparseArray<Drawable.ConstantState> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainer mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainer drawableContainer, Resources resources) {
            Resources resources2;
            int i3;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = drawableContainer;
            if (resources != null) {
                resources2 = resources;
            } else if (drawableContainerState != null) {
                resources2 = drawableContainerState.mSourceRes;
            } else {
                resources2 = null;
            }
            this.mSourceRes = resources2;
            if (drawableContainerState != null) {
                i3 = drawableContainerState.mDensity;
            } else {
                i3 = 0;
            }
            int resolveDensity = DrawableContainer.resolveDensity(resources, i3);
            this.mDensity = resolveDensity;
            if (drawableContainerState != null) {
                this.mChangingConfigurations = drawableContainerState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = drawableContainerState.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = drawableContainerState.mVariablePadding;
                this.mConstantSize = drawableContainerState.mConstantSize;
                this.mDither = drawableContainerState.mDither;
                this.mMutated = drawableContainerState.mMutated;
                this.mLayoutDirection = drawableContainerState.mLayoutDirection;
                this.mEnterFadeDuration = drawableContainerState.mEnterFadeDuration;
                this.mExitFadeDuration = drawableContainerState.mExitFadeDuration;
                this.mAutoMirrored = drawableContainerState.mAutoMirrored;
                this.mColorFilter = drawableContainerState.mColorFilter;
                this.mHasColorFilter = drawableContainerState.mHasColorFilter;
                this.mTintList = drawableContainerState.mTintList;
                this.mTintMode = drawableContainerState.mTintMode;
                this.mHasTintList = drawableContainerState.mHasTintList;
                this.mHasTintMode = drawableContainerState.mHasTintMode;
                if (drawableContainerState.mDensity == resolveDensity) {
                    if (drawableContainerState.mCheckedPadding) {
                        this.mConstantPadding = drawableContainerState.mConstantPadding != null ? new Rect(drawableContainerState.mConstantPadding) : null;
                        this.mCheckedPadding = true;
                    }
                    if (drawableContainerState.mCheckedConstantSize) {
                        this.mConstantWidth = drawableContainerState.mConstantWidth;
                        this.mConstantHeight = drawableContainerState.mConstantHeight;
                        this.mConstantMinimumWidth = drawableContainerState.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = drawableContainerState.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (drawableContainerState.mCheckedOpacity) {
                    this.mOpacity = drawableContainerState.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (drawableContainerState.mCheckedStateful) {
                    this.mStateful = drawableContainerState.mStateful;
                    this.mCheckedStateful = true;
                }
                Drawable[] drawableArr = drawableContainerState.mDrawables;
                this.mDrawables = new Drawable[drawableArr.length];
                this.mNumChildren = drawableContainerState.mNumChildren;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.mDrawableFutures;
                if (sparseArray != null) {
                    this.mDrawableFutures = sparseArray.clone();
                } else {
                    this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
                }
                int i16 = this.mNumChildren;
                for (int i17 = 0; i17 < i16; i17++) {
                    Drawable drawable = drawableArr[i17];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.mDrawableFutures.put(i17, constantState);
                        } else {
                            this.mDrawables[i17] = drawableArr[i17];
                        }
                    }
                }
                return;
            }
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.mDrawables[this.mDrawableFutures.keyAt(i3)] = prepareDrawable(this.mDrawableFutures.valueAt(i3).newDrawable(this.mSourceRes));
                }
                this.mDrawableFutures = null;
            }
        }

        private Drawable prepareDrawable(Drawable drawable) {
            DrawableCompat.setLayoutDirection(drawable, this.mLayoutDirection);
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.mOwner);
            return mutate;
        }

        public final int addChild(Drawable drawable) {
            int i3 = this.mNumChildren;
            if (i3 >= this.mDrawables.length) {
                growArray(i3, i3 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.mOwner);
            this.mDrawables[i3] = drawable;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return i3;
        }

        @RequiresApi(21)
        final void applyTheme(Resources.Theme theme) {
            if (theme != null) {
                createAllFutures();
                int i3 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                for (int i16 = 0; i16 < i3; i16++) {
                    Drawable drawable = drawableArr[i16];
                    if (drawable != null && DrawableCompat.canApplyTheme(drawable)) {
                        DrawableCompat.applyTheme(drawableArr[i16], theme);
                        this.mChildrenChangingConfigurations |= drawableArr[i16].getChangingConfigurations();
                    }
                }
                updateDensity(Api21Impl.getResources(theme));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i3 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i16 = 0; i16 < i3; i16++) {
                Drawable drawable = drawableArr[i16];
                if (drawable != null) {
                    if (DrawableCompat.canApplyTheme(drawable)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.mDrawableFutures.get(i16);
                    if (constantState != null && Api21Impl.canApplyTheme(constantState)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState) {
                return this.mCanConstantState;
            }
            createAllFutures();
            this.mCheckedConstantState = true;
            int i3 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i16 = 0; i16 < i3; i16++) {
                if (drawableArr[i16].getConstantState() == null) {
                    this.mCanConstantState = false;
                    return false;
                }
            }
            this.mCanConstantState = true;
            return true;
        }

        final void clearMutated() {
            this.mMutated = false;
        }

        protected void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int i3 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i16 = 0; i16 < i3; i16++) {
                Drawable drawable = drawableArr[i16];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.mConstantWidth) {
                    this.mConstantWidth = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.mConstantHeight) {
                    this.mConstantHeight = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int getCapacity() {
            return this.mDrawables.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final Drawable getChild(int i3) {
            int indexOfKey;
            Drawable drawable = this.mDrawables[i3];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i3)) < 0) {
                return null;
            }
            Drawable prepareDrawable = prepareDrawable(this.mDrawableFutures.valueAt(indexOfKey).newDrawable(this.mSourceRes));
            this.mDrawables[i3] = prepareDrawable;
            this.mDrawableFutures.removeAt(indexOfKey);
            if (this.mDrawableFutures.size() == 0) {
                this.mDrawableFutures = null;
            }
            return prepareDrawable;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getConstantHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            Rect rect = null;
            if (this.mVariablePadding) {
                return null;
            }
            Rect rect2 = this.mConstantPadding;
            if (rect2 == null && !this.mCheckedPadding) {
                createAllFutures();
                Rect rect3 = new Rect();
                int i3 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                for (int i16 = 0; i16 < i3; i16++) {
                    if (drawableArr[i16].getPadding(rect3)) {
                        if (rect == null) {
                            rect = new Rect(0, 0, 0, 0);
                        }
                        int i17 = rect3.left;
                        if (i17 > rect.left) {
                            rect.left = i17;
                        }
                        int i18 = rect3.top;
                        if (i18 > rect.top) {
                            rect.top = i18;
                        }
                        int i19 = rect3.right;
                        if (i19 > rect.right) {
                            rect.right = i19;
                        }
                        int i26 = rect3.bottom;
                        if (i26 > rect.bottom) {
                            rect.bottom = i26;
                        }
                    }
                }
                this.mCheckedPadding = true;
                this.mConstantPadding = rect;
                return rect;
            }
            return rect2;
        }

        public final int getConstantWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            int i3;
            if (this.mCheckedOpacity) {
                return this.mOpacity;
            }
            createAllFutures();
            int i16 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            if (i16 > 0) {
                i3 = drawableArr[0].getOpacity();
            } else {
                i3 = -2;
            }
            for (int i17 = 1; i17 < i16; i17++) {
                i3 = Drawable.resolveOpacity(i3, drawableArr[i17].getOpacity());
            }
            this.mOpacity = i3;
            this.mCheckedOpacity = true;
            return i3;
        }

        public void growArray(int i3, int i16) {
            Drawable[] drawableArr = new Drawable[i16];
            Drawable[] drawableArr2 = this.mDrawables;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i3);
            }
            this.mDrawables = drawableArr;
        }

        void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful) {
                return this.mStateful;
            }
            createAllFutures();
            int i3 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            boolean z16 = false;
            int i16 = 0;
            while (true) {
                if (i16 >= i3) {
                    break;
                }
                if (drawableArr[i16].isStateful()) {
                    z16 = true;
                    break;
                }
                i16++;
            }
            this.mStateful = z16;
            this.mCheckedStateful = true;
            return z16;
        }

        void mutate() {
            int i3 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i16 = 0; i16 < i3; i16++) {
                Drawable drawable = drawableArr[i16];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.mMutated = true;
        }

        public final void setConstantSize(boolean z16) {
            this.mConstantSize = z16;
        }

        public final void setEnterFadeDuration(int i3) {
            this.mEnterFadeDuration = i3;
        }

        public final void setExitFadeDuration(int i3) {
            this.mExitFadeDuration = i3;
        }

        final boolean setLayoutDirection(int i3, int i16) {
            int i17 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            boolean z16 = false;
            for (int i18 = 0; i18 < i17; i18++) {
                Drawable drawable = drawableArr[i18];
                if (drawable != null) {
                    boolean layoutDirection = DrawableCompat.setLayoutDirection(drawable, i3);
                    if (i18 == i16) {
                        z16 = layoutDirection;
                    }
                }
            }
            this.mLayoutDirection = i3;
            return z16;
        }

        public final void setVariablePadding(boolean z16) {
            this.mVariablePadding = z16;
        }

        final void updateDensity(Resources resources) {
            if (resources != null) {
                this.mSourceRes = resources;
                int resolveDensity = DrawableContainer.resolveDensity(resources, this.mDensity);
                int i3 = this.mDensity;
                this.mDensity = resolveDensity;
                if (i3 != resolveDensity) {
                    this.mCheckedConstantSize = false;
                    this.mCheckedPadding = false;
                }
            }
        }
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.mBlockInvalidateCallback.wrap(drawable.getCallback()));
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState.mHasColorFilter) {
                drawable.setColorFilter(drawableContainerState.mColorFilter);
            } else {
                if (drawableContainerState.mHasTintList) {
                    DrawableCompat.setTintList(drawable, drawableContainerState.mTintList);
                }
                DrawableContainerState drawableContainerState2 = this.mDrawableContainerState;
                if (drawableContainerState2.mHasTintMode) {
                    DrawableCompat.setTintMode(drawable, drawableContainerState2.mTintMode);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.mDither);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            DrawableCompat.setAutoMirrored(drawable, this.mDrawableContainerState.mAutoMirrored);
            Rect rect = this.mHotspotBounds;
            if (rect != null) {
                DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
        }
    }

    private boolean needsMirroring() {
        if (isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    static int resolveDensity(@Nullable Resources resources, int i3) {
        if (resources != null) {
            i3 = resources.getDisplayMetrics().densityDpi;
        }
        if (i3 == 0) {
            return 160;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void animate(boolean z16) {
        boolean z17;
        Drawable drawable;
        boolean z18 = true;
        this.mHasAlpha = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            long j3 = this.mEnterAnimationEnd;
            if (j3 != 0) {
                if (j3 <= uptimeMillis) {
                    drawable2.setAlpha(this.mAlpha);
                    this.mEnterAnimationEnd = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j3 - uptimeMillis) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
                    z17 = true;
                    drawable = this.mLastDrawable;
                    if (drawable == null) {
                        long j16 = this.mExitAnimationEnd;
                        if (j16 != 0) {
                            if (j16 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.mLastDrawable = null;
                                this.mExitAnimationEnd = 0L;
                            } else {
                                drawable.setAlpha(((((int) ((j16 - uptimeMillis) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
                                if (z16 && z18) {
                                    scheduleSelf(this.mAnimationRunnable, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.mExitAnimationEnd = 0L;
                    }
                    z18 = z17;
                    if (z16) {
                        return;
                    } else {
                        return;
                    }
                }
            }
        } else {
            this.mEnterAnimationEnd = 0L;
        }
        z17 = false;
        drawable = this.mLastDrawable;
        if (drawable == null) {
        }
        z18 = z17;
        if (z16) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState()) {
            this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            return this.mDrawableContainerState;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null && drawable.isVisible()) {
            return this.mDrawableContainerState.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            Api21Impl.getOutline(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        boolean padding;
        Rect constantPadding = this.mDrawableContainerState.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            if ((constantPadding.right | constantPadding.left | constantPadding.top | constantPadding.bottom) != 0) {
                padding = true;
            } else {
                padding = false;
            }
        } else {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (needsMirroring()) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return padding;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState != null) {
            drawableContainerState.invalidateCache();
        }
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z16;
        Drawable drawable = this.mLastDrawable;
        boolean z17 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z16 = true;
        } else {
            z16 = false;
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0L;
            z16 = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0L;
        } else {
            z17 = z16;
        }
        if (z17) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            DrawableContainerState cloneConstantState = cloneConstantState();
            cloneConstantState.mutate();
            setConstantState(cloneConstantState);
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        return this.mDrawableContainerState.setLayoutDirection(i3, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i3);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i3);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean selectDrawable(int i3) {
        Runnable runnable;
        if (i3 == this.mCurIndex) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration > 0) {
            Drawable drawable = this.mLastDrawable;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                this.mLastDrawable = drawable2;
                this.mExitAnimationEnd = this.mDrawableContainerState.mExitFadeDuration + uptimeMillis;
            } else {
                this.mLastDrawable = null;
                this.mExitAnimationEnd = 0L;
            }
        } else {
            Drawable drawable3 = this.mCurrDrawable;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i3 >= 0) {
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (i3 < drawableContainerState.mNumChildren) {
                Drawable child = drawableContainerState.getChild(i3);
                this.mCurrDrawable = child;
                this.mCurIndex = i3;
                if (child != null) {
                    int i16 = this.mDrawableContainerState.mEnterFadeDuration;
                    if (i16 > 0) {
                        this.mEnterAnimationEnd = uptimeMillis + i16;
                    }
                    initializeDrawableForDisplay(child);
                }
                if (this.mEnterAnimationEnd == 0 || this.mExitAnimationEnd != 0) {
                    runnable = this.mAnimationRunnable;
                    if (runnable != null) {
                        this.mAnimationRunnable = new Runnable() { // from class: androidx.appcompat.graphics.drawable.DrawableContainer.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DrawableContainer.this.animate(true);
                                DrawableContainer.this.invalidateSelf();
                            }
                        };
                    } else {
                        unscheduleSelf(runnable);
                    }
                    animate(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.mCurrDrawable = null;
        this.mCurIndex = -1;
        if (this.mEnterAnimationEnd == 0) {
        }
        runnable = this.mAnimationRunnable;
        if (runnable != null) {
        }
        animate(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (!this.mHasAlpha || this.mAlpha != i3) {
            this.mHasAlpha = true;
            this.mAlpha = i3;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                if (this.mEnterAnimationEnd == 0) {
                    drawable.setAlpha(i3);
                } else {
                    animate(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z16) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.mAutoMirrored != z16) {
            drawableContainerState.mAutoMirrored = z16;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z16);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasColorFilter = true;
        if (drawableContainerState.mColorFilter != colorFilter) {
            drawableContainerState.mColorFilter = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConstantState(DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        int i3 = this.mCurIndex;
        if (i3 >= 0) {
            Drawable child = drawableContainerState.getChild(i3);
            this.mCurrDrawable = child;
            if (child != null) {
                initializeDrawableForDisplay(child);
            }
        }
        this.mLastDrawable = null;
    }

    void setCurrentIndex(int i3) {
        selectDrawable(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.mDither != z16) {
            drawableContainerState.mDither = z16;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z16);
            }
        }
    }

    public void setEnterFadeDuration(int i3) {
        this.mDrawableContainerState.mEnterFadeDuration = i3;
    }

    public void setExitFadeDuration(int i3) {
        this.mDrawableContainerState.mExitFadeDuration = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f16, float f17) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f16, f17);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i3, int i16, int i17, int i18) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(i3, i16, i17, i18);
        } else {
            rect.set(i3, i16, i17, i18);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i3, i16, i17, i18);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasTintList = true;
        if (drawableContainerState.mTintList != colorStateList) {
            drawableContainerState.mTintList = colorStateList;
            DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasTintMode = true;
        if (drawableContainerState.mTintMode != mode) {
            drawableContainerState.mTintMode = mode;
            DrawableCompat.setTintMode(this.mCurrDrawable, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z16, z17);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z16, z17);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateDensity(Resources resources) {
        this.mDrawableContainerState.updateDensity(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
            Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j3);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.mCallback;
            this.mCallback = null;
            return callback;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            this.mCallback = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
        }
    }
}
