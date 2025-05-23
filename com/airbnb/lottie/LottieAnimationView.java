package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.tencent.mapsdk.internal.by;
import com.tencent.mobileqq.R;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = new LottieListener() { // from class: com.airbnb.lottie.c
        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object obj) {
            LottieAnimationView.lambda$static$0((Throwable) obj);
        }
    };
    private static final String TAG = "LottieAnimationView";
    private String animationName;

    @RawRes
    private int animationResId;
    private boolean autoPlay;
    private boolean cacheComposition;

    @Nullable
    private LottieComposition composition;

    @Nullable
    private LottieTask<LottieComposition> compositionTask;

    @Nullable
    private LottieListener<Throwable> failureListener;

    @DrawableRes
    private int fallbackResource;
    private boolean ignoreUnschedule;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    private final Set<UserActionTaken> userActionsTaken;
    private final LottieListener<Throwable> wrappedFailureListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th5) {
                if (LottieAnimationView.this.fallbackResource != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                }
                (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th5);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null, R.attr.asl);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    private LottieTask<LottieComposition> fromAssets(final String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult lambda$fromAssets$2;
                    lambda$fromAssets$2 = LottieAnimationView.this.lambda$fromAssets$2(str);
                    return lambda$fromAssets$2;
                }
            }, true);
        }
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromAsset(getContext(), str);
        }
        return LottieCompositionFactory.fromAsset(getContext(), str, null);
    }

    private LottieTask<LottieComposition> fromRawRes(@RawRes final int i3) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieResult lambda$fromRawRes$1;
                    lambda$fromRawRes$1 = LottieAnimationView.this.lambda$fromRawRes$1(i3);
                    return lambda$fromRawRes$1;
                }
            }, true);
        }
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromRawRes(getContext(), i3);
        }
        return LottieCompositionFactory.fromRawRes(getContext(), i3, null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i3) {
        String string;
        boolean z16 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r0.a.E, i3, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(r0.a.G, true);
        int i16 = r0.a.Q;
        boolean hasValue = obtainStyledAttributes.hasValue(i16);
        int i17 = r0.a.L;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i17);
        int i18 = r0.a.V;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i18);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i16, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i17);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i18)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(r0.a.K, 0));
        if (obtainStyledAttributes.getBoolean(r0.a.F, false)) {
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(r0.a.O, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        int i19 = r0.a.T;
        if (obtainStyledAttributes.hasValue(i19)) {
            setRepeatMode(obtainStyledAttributes.getInt(i19, 1));
        }
        int i26 = r0.a.S;
        if (obtainStyledAttributes.hasValue(i26)) {
            setRepeatCount(obtainStyledAttributes.getInt(i26, -1));
        }
        int i27 = r0.a.U;
        if (obtainStyledAttributes.hasValue(i27)) {
            setSpeed(obtainStyledAttributes.getFloat(i27, 1.0f));
        }
        int i28 = r0.a.H;
        if (obtainStyledAttributes.hasValue(i28)) {
            setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i28, true));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(r0.a.N));
        setProgress(obtainStyledAttributes.getFloat(r0.a.P, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(r0.a.J, false));
        int i29 = r0.a.I;
        if (obtainStyledAttributes.hasValue(i29)) {
            addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i29, -1)).getDefaultColor())));
        }
        int i36 = r0.a.R;
        if (obtainStyledAttributes.hasValue(i36)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i37 = obtainStyledAttributes.getInt(i36, renderMode.ordinal());
            if (i37 >= RenderMode.values().length) {
                i37 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i37]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(r0.a.M, false));
        obtainStyledAttributes.recycle();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (Utils.getAnimationScale(getContext()) != 0.0f) {
            z16 = true;
        }
        lottieDrawable.setSystemAnimationsAreEnabled(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LottieResult lambda$fromAssets$2(String str) throws Exception {
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromAssetSync(getContext(), str);
        }
        return LottieCompositionFactory.fromAssetSync(getContext(), str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LottieResult lambda$fromRawRes$1(int i3) throws Exception {
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromRawResSync(getContext(), i3);
        }
        return LottieCompositionFactory.fromRawResSync(getContext(), i3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Throwable th5) {
        if (Utils.isNetworkException(th5)) {
            Logger.warning("Unable to load composition.", th5);
        } else {
            if (!com.tencent.mobileqq.g.f211804a) {
                Log.e("Lottie.", "LottieAnimationView Unable to parse composition" + th5);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th5);
        }
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.userActionsTaken.add(UserActionTaken.SET_ANIMATION);
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    private void setLottieDrawable() {
        boolean isAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        if (isAnimating) {
            this.lottieDrawable.resumeAnimation();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.addAnimatorPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t16, LottieValueCallback<T> lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t16, (LottieValueCallback<KeyPath>) lottieValueCallback);
    }

    @MainThread
    public void cancelAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.cancelAnimation();
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z16) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z16);
    }

    public boolean getClipToCompositionBounds() {
        return this.lottieDrawable.getClipToCompositionBounds();
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        if (this.composition != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.lottieDrawable.getMaintainOriginalImageBounds();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public RenderMode getRenderMode() {
        return this.lottieDrawable.getRenderMode();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).getRenderMode() == RenderMode.SOFTWARE) {
            this.lottieDrawable.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void loop(boolean z16) {
        int i3;
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (z16) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        lottieDrawable.setRepeatCount(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.autoPlay) {
            this.lottieDrawable.playAnimation();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i3;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.animationName;
        Set<UserActionTaken> set = this.userActionsTaken;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.animationResId;
        if (!this.userActionsTaken.contains(userActionTaken) && (i3 = this.animationResId) != 0) {
            setAnimation(i3);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_PROGRESS)) {
            setProgress(savedState.progress);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.PLAY_OPTION) && savedState.isAnimating) {
            playAnimation();
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.imageAssetsFolder);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.repeatMode);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.repeatCount);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.isAnimating = this.lottieDrawable.isAnimatingOrWillAnimateOnVisible();
        savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        savedState.repeatMode = this.lottieDrawable.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.lottieDrawable.pauseAnimation();
    }

    @MainThread
    public void playAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.playAnimation();
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.removeAnimatorPauseListener(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    @MainThread
    public void resumeAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.resumeAnimation();
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setAnimation(@RawRes int i3) {
        this.animationResId = i3;
        this.animationName = null;
        setCompositionTask(fromRawRes(i3));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? LottieCompositionFactory.fromUrl(getContext(), str) : LottieCompositionFactory.fromUrl(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z16) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(z16);
    }

    public void setCacheComposition(boolean z16) {
        this.cacheComposition = z16;
    }

    public void setClipToCompositionBounds(boolean z16) {
        this.lottieDrawable.setClipToCompositionBounds(z16);
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        if (L.DBG) {
            Log.v(TAG, "Set Composition \n" + lottieComposition);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        this.ignoreUnschedule = true;
        boolean composition = this.lottieDrawable.setComposition(lottieComposition);
        this.ignoreUnschedule = false;
        if (getDrawable() == this.lottieDrawable && !composition) {
            return;
        }
        if (!composition) {
            setLottieDrawable();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<LottieOnCompositionLoadedListener> it = this.lottieOnCompositionLoadedListeners.iterator();
        while (it.hasNext()) {
            it.next().onCompositionLoaded(lottieComposition);
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i3) {
        this.fallbackResource = i3;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int i3) {
        this.lottieDrawable.setFrame(i3);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z16) {
        this.lottieDrawable.setIgnoreDisabledSystemAnimations(z16);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        cancelLoaderTask();
        super.setImageResource(i3);
    }

    public void setMaintainOriginalImageBounds(boolean z16) {
        this.lottieDrawable.setMaintainOriginalImageBounds(z16);
    }

    public void setMaxFrame(int i3) {
        this.lottieDrawable.setMaxFrame(i3);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.lottieDrawable.setMaxProgress(f16);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17) {
        this.lottieDrawable.setMinAndMaxProgress(f16, f17);
    }

    public void setMinFrame(int i3) {
        this.lottieDrawable.setMinFrame(i3);
    }

    public void setMinProgress(float f16) {
        this.lottieDrawable.setMinProgress(f16);
    }

    public void setOutlineMasksAndMattes(boolean z16) {
        this.lottieDrawable.setOutlineMasksAndMattes(z16);
    }

    public void setPerformanceTrackingEnabled(boolean z16) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z16);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.userActionsTaken.add(UserActionTaken.SET_PROGRESS);
        this.lottieDrawable.setProgress(f16);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.lottieDrawable.setRenderMode(renderMode);
    }

    public void setRepeatCount(int i3) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_COUNT);
        this.lottieDrawable.setRepeatCount(i3);
    }

    public void setRepeatMode(int i3) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_MODE);
        this.lottieDrawable.setRepeatMode(i3);
    }

    public void setSafeMode(boolean z16) {
        this.lottieDrawable.setSafeMode(z16);
    }

    public void setSpeed(float f16) {
        this.lottieDrawable.setSpeed(f16);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.ignoreUnschedule && drawable == (lottieDrawable = this.lottieDrawable) && lottieDrawable.isAnimating()) {
            pauseAnimation();
        } else if (!this.ignoreUnschedule && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.isAnimating()) {
                lottieDrawable2.pauseAnimation();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t16, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t16, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.airbnb.lottie.LottieAnimationView.2
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z16) {
        this.lottieDrawable.setMinAndMaxFrame(str, str2, z16);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }

    public void setMinAndMaxFrame(int i3, int i16) {
        this.lottieDrawable.setMinAndMaxFrame(i3, i16);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th5) {
                if (LottieAnimationView.this.fallbackResource != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                }
                (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th5);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet, R.attr.asl);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.loadedListener = new LottieListener() { // from class: com.airbnb.lottie.b
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                LottieAnimationView.this.setComposition((LottieComposition) obj);
            }
        };
        this.wrappedFailureListener = new LottieListener<Throwable>() { // from class: com.airbnb.lottie.LottieAnimationView.1
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(Throwable th5) {
                if (LottieAnimationView.this.fallbackResource != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
                }
                (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th5);
            }
        };
        this.fallbackResource = 0;
        this.lottieDrawable = new LottieDrawable();
        this.ignoreUnschedule = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        this.userActionsTaken = new HashSet();
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet, i3);
    }
}
