package com.tencent.mtt.supportui.views.asyncimage;

import android.animation.Animator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter;
import com.tencent.mtt.supportui.adapters.image.IImageRequestListener;
import com.tencent.mtt.supportui.views.IBorder;
import com.tencent.mtt.supportui.views.IGradient;
import com.tencent.mtt.supportui.views.IShadow;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class AsyncImageView extends ViewGroup implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, IBorder, IGradient, IShadow {
    public static final int FADE_DURATION = 150;
    public static final int IMAGE_LOADED = 2;
    public static final int IMAGE_LOADING = 1;
    public static final int IMAGE_UNLOAD = 0;
    protected static final int SOURCE_TYPE_DEFAULT_SRC = 2;
    protected static final int SOURCE_TYPE_SRC = 1;
    private ValueAnimator mAlphaAnimator;
    protected BackgroundDrawable mBGDrawable;
    protected Drawable mContentDrawable;
    private IDrawableTarget mDefaultSourceDrawable;
    protected String mDefaultSourceUrl;
    private long mFadeDuration;
    private boolean mFadeEnable;
    protected IImageLoaderAdapter mImageAdapter;
    private int mImagePositionX;
    private int mImagePositionY;
    protected String mImageType;
    private boolean mIsAttached;
    protected Drawable mRippleDrawable;
    protected ScaleType mScaleType;
    protected IDrawableTarget mSourceDrawable;
    protected int mTintColor;
    protected String mUrl;
    protected int mUrlFetchState;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public enum ScaleType {
        FIT_XY,
        CENTER,
        CENTER_INSIDE,
        CENTER_CROP,
        ORIGIN,
        REPEAT
    }

    public AsyncImageView(Context context) {
        super(context);
        this.mUrlFetchState = 0;
        this.mUrl = null;
        this.mDefaultSourceUrl = null;
        this.mImageType = null;
        setFadeEnabled(false);
        setFadeDuration(150L);
    }

    private void fetchImageByUrl(String str, int i3) {
        if (str != null && this.mImageAdapter != null) {
            if (shouldUseFetchImageMode(str)) {
                String replaceAll = str.trim().replaceAll(" ", "%20");
                if (i3 == 1) {
                    if (!shouldFetchImage()) {
                        return;
                    } else {
                        this.mUrlFetchState = 1;
                    }
                }
                onFetchImage(replaceAll);
                handleGetImageStart();
                doFetchImage(getFetchParam(), i3);
                return;
            }
            handleGetImageStart();
            handleImageRequest(this.mImageAdapter.getImage(str, null), i3, null);
        }
    }

    private BackgroundDrawable getBackGround() {
        if (this.mBGDrawable == null) {
            this.mBGDrawable = generateBackgroundDrawable();
            Drawable background = getBackground();
            super.setBackgroundDrawable(null);
            if (background == null) {
                super.setBackgroundDrawable(this.mBGDrawable);
            } else {
                super.setBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mBGDrawable, background}));
            }
        }
        return this.mBGDrawable;
    }

    private void resetBackgroundDrawable() {
        ArrayList arrayList = new ArrayList();
        BackgroundDrawable backgroundDrawable = this.mBGDrawable;
        if (backgroundDrawable != null) {
            arrayList.add(backgroundDrawable);
        }
        Drawable drawable = this.mContentDrawable;
        if (drawable != null) {
            arrayList.add(drawable);
        }
        Drawable drawable2 = this.mRippleDrawable;
        if (drawable2 != null) {
            arrayList.add(drawable2);
        }
        super.setBackground(null);
        if (arrayList.size() > 0) {
            Drawable[] drawableArr = new Drawable[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                drawableArr[i3] = (Drawable) arrayList.get(i3);
            }
            super.setBackground(new LayerDrawable(drawableArr));
        }
    }

    protected void applyTintColor(int i3) {
        Drawable drawable = this.mContentDrawable;
        if (drawable instanceof ContentDrawable) {
            ((ContentDrawable) drawable).setTintColor(i3);
            invalidate();
        }
    }

    protected void doFetchImage(Object obj, final int i3) {
        String str;
        IImageLoaderAdapter iImageLoaderAdapter = this.mImageAdapter;
        if (iImageLoaderAdapter != null) {
            if (i3 == 1) {
                str = this.mUrl;
            } else {
                str = this.mDefaultSourceUrl;
            }
            iImageLoaderAdapter.fetchImage(str, new IImageRequestListener<IDrawableTarget>() { // from class: com.tencent.mtt.supportui.views.asyncimage.AsyncImageView.1
                @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
                public void onRequestFail(Throwable th5, String str2) {
                    AsyncImageView.this.handleImageRequest(null, i3, th5);
                }

                @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
                public void onRequestStart(IDrawableTarget iDrawableTarget) {
                    AsyncImageView.this.mSourceDrawable = iDrawableTarget;
                }

                @Override // com.tencent.mtt.supportui.adapters.image.IImageRequestListener
                public void onRequestSuccess(IDrawableTarget iDrawableTarget) {
                    AsyncImageView.this.handleImageRequest(iDrawableTarget, i3, null);
                }
            }, obj);
        }
    }

    protected BackgroundDrawable generateBackgroundDrawable() {
        return new BackgroundDrawable();
    }

    protected ContentDrawable generateContentDrawable() {
        return new ContentDrawable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap getBitmap() {
        IDrawableTarget iDrawableTarget = this.mSourceDrawable;
        if (iDrawableTarget != null) {
            return iDrawableTarget.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getFetchParam() {
        IDrawableTarget iDrawableTarget = this.mSourceDrawable;
        if (iDrawableTarget != null) {
            return iDrawableTarget.getExtraData();
        }
        return null;
    }

    protected int getTintColor() {
        return this.mTintColor;
    }

    public String getUrl() {
        return this.mUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleImageRequest(IDrawableTarget iDrawableTarget, int i3, Object obj) {
        if (iDrawableTarget == null) {
            Throwable th5 = null;
            if (i3 == 1) {
                this.mSourceDrawable = null;
                if (this.mDefaultSourceDrawable != null) {
                    if (this.mContentDrawable == null) {
                        this.mContentDrawable = generateContentDrawable();
                    }
                    setContent(2);
                } else {
                    this.mContentDrawable = null;
                }
                if (obj instanceof Throwable) {
                    th5 = (Throwable) obj;
                }
                handleGetImageFail(th5);
                return;
            }
            if (i3 == 2) {
                this.mDefaultSourceDrawable = null;
                return;
            }
            return;
        }
        this.mContentDrawable = generateContentDrawable();
        if (i3 == 1) {
            this.mSourceDrawable = iDrawableTarget;
            handleGetImageSuccess();
        } else if (i3 == 2) {
            this.mDefaultSourceDrawable = iDrawableTarget;
        }
        setContent(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAttached() {
        return this.mIsAttached;
    }

    public boolean isFadeEnabled() {
        return this.mFadeEnable;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.mFadeEnable) {
            Drawable drawable = this.mContentDrawable;
            if (drawable != null) {
                drawable.setAlpha(255);
            }
            restoreBackgroundColorAfterSetContent();
        }
    }

    public void onAnimationEnd(Animator animator) {
        if (this.mFadeEnable) {
            restoreBackgroundColorAfterSetContent();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2;
        if (this.mFadeEnable) {
            if (!isAttached() && (valueAnimator2 = this.mAlphaAnimator) != null) {
                valueAnimator2.cancel();
            }
            Drawable drawable = this.mContentDrawable;
            if (drawable != null) {
                drawable.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.mIsAttached = true;
        super.onAttachedToWindow();
        IDrawableTarget iDrawableTarget = this.mDefaultSourceDrawable;
        if (iDrawableTarget != null) {
            iDrawableTarget.onDrawableAttached();
        }
        if (shouldFetchImage()) {
            resetContent();
        }
        fetchImageByUrl(this.mUrl, 1);
        onDrawableAttached();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator;
        this.mIsAttached = false;
        if (this.mFadeEnable && (valueAnimator = this.mAlphaAnimator) != null) {
            valueAnimator.cancel();
        }
        super.onDetachedFromWindow();
        onDrawableDetached();
        IDrawableTarget iDrawableTarget = this.mDefaultSourceDrawable;
        if (iDrawableTarget != null) {
            iDrawableTarget.onDrawableDetached();
        }
    }

    protected void onDrawableAttached() {
        IDrawableTarget iDrawableTarget = this.mSourceDrawable;
        if (iDrawableTarget != null) {
            iDrawableTarget.onDrawableAttached();
        }
    }

    protected void onDrawableDetached() {
        IDrawableTarget iDrawableTarget = this.mSourceDrawable;
        if (iDrawableTarget != null) {
            iDrawableTarget.onDrawableDetached();
        }
    }

    protected void performFetchImage() {
        fetchImageByUrl(this.mUrl, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void performSetContent() {
        setContent(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetContent() {
        this.mSourceDrawable = null;
        if (this.mDefaultSourceDrawable != null) {
            updateContentDrawableProperty(2);
        } else {
            this.mContentDrawable = null;
        }
        resetBackgroundDrawable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetFadeAnimation() {
        if (this.mFadeEnable) {
            ValueAnimator valueAnimator = this.mAlphaAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mAlphaAnimator.cancel();
            }
            this.mAlphaAnimator = null;
        }
    }

    protected void restoreBackgroundColorAfterSetContent() {
        setBackgroundColor(0);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        getBackGround().setBackgroundColor(i3);
        invalidate();
    }

    public void setBorderColor(int i3, int i16) {
        getBackGround().setBorderColor(i3, i16);
        invalidate();
    }

    public void setBorderRadius(float f16, int i3) {
        getBackGround().setBorderRadius(f16, i3);
        Drawable drawable = this.mContentDrawable;
        if (drawable instanceof ContentDrawable) {
            ((ContentDrawable) drawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
            invalidate();
        }
    }

    public void setBorderStyle(int i3) {
        getBackGround().setBorderStyle(i3);
        invalidate();
    }

    public void setBorderWidth(float f16, int i3) {
        getBackGround().setBorderWidth(f16, i3);
        Drawable drawable = this.mContentDrawable;
        if (drawable instanceof ContentDrawable) {
            ((ContentDrawable) drawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContent(int i3) {
        if (this.mContentDrawable == null || !shouldSetContent()) {
            return;
        }
        onSetContent(this.mUrl);
        updateContentDrawableProperty(i3);
        resetBackgroundDrawable();
        afterSetContent(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCustomBackgroundDrawable(BackgroundDrawable backgroundDrawable) {
        this.mBGDrawable = backgroundDrawable;
        super.setBackgroundDrawable(backgroundDrawable);
    }

    public void setDefaultSource(String str) {
        if (!TextUtils.equals(this.mDefaultSourceUrl, str)) {
            this.mDefaultSourceUrl = str;
            if (this.mDefaultSourceDrawable != null) {
                if (isAttached()) {
                    this.mDefaultSourceDrawable.onDrawableDetached();
                }
                this.mDefaultSourceDrawable = null;
            }
            if (this.mSourceDrawable == null) {
                this.mContentDrawable = null;
                resetBackgroundDrawable();
            }
            fetchImageByUrl(this.mDefaultSourceUrl, 2);
        }
    }

    public void setFadeDuration(long j3) {
        this.mFadeDuration = j3;
    }

    public void setFadeEnabled(boolean z16) {
        this.mFadeEnable = z16;
    }

    @Override // com.tencent.mtt.supportui.views.IGradient
    public void setGradientAngle(String str) {
        getBackGround().setGradientAngle(str);
        invalidate();
    }

    @Override // com.tencent.mtt.supportui.views.IGradient
    public void setGradientColors(ArrayList<Integer> arrayList) {
        getBackGround().setGradientColors(arrayList);
        invalidate();
    }

    @Override // com.tencent.mtt.supportui.views.IGradient
    public void setGradientPositions(ArrayList<Float> arrayList) {
        getBackGround().setGradientPositions(arrayList);
        invalidate();
    }

    public void setImageAdapter(IImageLoaderAdapter iImageLoaderAdapter) {
        this.mImageAdapter = iImageLoaderAdapter;
    }

    public void setImagePositionX(int i3) {
        this.mImagePositionX = i3;
    }

    public void setImagePositionY(int i3) {
        this.mImagePositionY = i3;
    }

    public void setImageType(String str) {
        this.mImageType = str;
    }

    @RequiresApi(api = 21)
    public void setRippleDrawable(@NonNull Drawable drawable) {
        this.mRippleDrawable = drawable;
        resetBackgroundDrawable();
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    @Override // com.tencent.mtt.supportui.views.IShadow
    public void setShadowColor(int i3) {
        getBackGround().setShadowColor(i3);
        invalidate();
    }

    @Override // com.tencent.mtt.supportui.views.IShadow
    public void setShadowOffsetX(float f16) {
        getBackGround().setShadowOffsetX(f16);
        invalidate();
    }

    @Override // com.tencent.mtt.supportui.views.IShadow
    public void setShadowOffsetY(float f16) {
        getBackGround().setShadowOffsetY(f16);
        invalidate();
    }

    @Override // com.tencent.mtt.supportui.views.IShadow
    public void setShadowOpacity(float f16) {
        getBackGround().setShadowOpacity(f16);
        invalidate();
    }

    @Override // com.tencent.mtt.supportui.views.IShadow
    public void setShadowRadius(float f16) {
        getBackGround().setShadowRadius(Math.abs(f16));
        invalidate();
    }

    public void setTintColor(int i3) {
        this.mTintColor = i3;
        applyTintColor(i3);
    }

    public void setUrl(String str) {
        if (!TextUtils.equals(str, this.mUrl)) {
            this.mUrl = str;
            this.mUrlFetchState = 0;
            if (isAttached()) {
                onDrawableDetached();
                resetContent();
                fetchImageByUrl(this.mUrl, 1);
                return;
            }
            this.mSourceDrawable = null;
        }
    }

    protected boolean shouldFetchImage() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldSetContent() {
        return true;
    }

    protected boolean shouldUseFetchImageMode(String str) {
        return true;
    }

    protected void startFadeAnimation() {
        if (this.mFadeEnable) {
            if (this.mFadeDuration > 0 && this.mAlphaAnimator == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
                this.mAlphaAnimator = ofInt;
                ofInt.setEvaluator(new IntEvaluator());
                this.mAlphaAnimator.addUpdateListener(this);
                this.mAlphaAnimator.addListener(this);
                this.mAlphaAnimator.setDuration(this.mFadeDuration);
            }
            ValueAnimator valueAnimator = this.mAlphaAnimator;
            if (valueAnimator != null) {
                if (valueAnimator.isRunning()) {
                    this.mAlphaAnimator.cancel();
                }
                this.mAlphaAnimator.setCurrentPlayTime(0L);
                this.mAlphaAnimator.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateContentDrawableProperty(int i3) {
        IDrawableTarget iDrawableTarget;
        if (!(this.mContentDrawable instanceof ContentDrawable)) {
            return;
        }
        Bitmap bitmap = getBitmap();
        if (i3 == 2 && (iDrawableTarget = this.mDefaultSourceDrawable) != null && (this.mUrlFetchState != 2 || this.mSourceDrawable == null)) {
            bitmap = iDrawableTarget.getBitmap();
        }
        if (bitmap != null) {
            ((ContentDrawable) this.mContentDrawable).setSourceType(i3);
            ((ContentDrawable) this.mContentDrawable).setBitmap(bitmap);
            ((ContentDrawable) this.mContentDrawable).setTintColor(getTintColor());
            ((ContentDrawable) this.mContentDrawable).setScaleType(this.mScaleType);
            ((ContentDrawable) this.mContentDrawable).setImagePositionX(this.mImagePositionX);
            ((ContentDrawable) this.mContentDrawable).setImagePositionY(this.mImagePositionY);
        }
        BackgroundDrawable backgroundDrawable = this.mBGDrawable;
        if (backgroundDrawable != null) {
            ((ContentDrawable) this.mContentDrawable).setBorder(backgroundDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
            ((ContentDrawable) this.mContentDrawable).setShadowOffsetX(this.mBGDrawable.getShadowOffsetX());
            ((ContentDrawable) this.mContentDrawable).setShadowOffsetY(this.mBGDrawable.getShadowOffsetY());
            ((ContentDrawable) this.mContentDrawable).setShadowRadius(this.mBGDrawable.getShadowRadius());
        }
    }

    protected void handleGetImageStart() {
    }

    protected void handleGetImageSuccess() {
    }

    protected void afterSetContent(String str) {
    }

    protected void handleGetImageFail(Throwable th5) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    protected void onFetchImage(String str) {
    }

    protected void onSetContent(String str) {
    }

    @Override // com.tencent.mtt.supportui.views.IShadow
    public void setShadowSpread(float f16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
