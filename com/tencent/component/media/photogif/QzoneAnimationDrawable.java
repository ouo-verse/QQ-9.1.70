package com.tencent.component.media.photogif;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.GifRenderingExecutor;
import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QzoneAnimationDrawable extends Drawable implements Animatable {
    public static int LOOP_INFINITE = 0;
    private static final String TAG = "QzoneAnimationDrawable";
    private AnimationListener mAnimationListener;
    private volatile Drawable mCurrentFrame;
    private Drawable mDefaultFrame;
    private ScheduledThreadPoolExecutor mExecutor;
    private ImageLoader.Options mFrameOptions;
    private FrameSwitcher mFrameSwitcher;
    private ImageKey mImageKey;
    private InvalidationHandler mInvalidationHandler;
    private volatile Drawable mNextFrame;
    private PhotoLoadListener mPhotoLoadListener;
    private int mPlayCount;
    private int mRepeatCount;
    private ScheduledFuture<?> mScheduledFuture;
    private volatile int mNextFrameIndex = 0;
    private volatile boolean mIsRunning = false;
    private volatile boolean mSwitchFrameWhenLoaded = true;
    private final Rect mDstRect = new Rect();
    private final Paint mPaint = new Paint();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface AnimationListener {
        void onAnimationEnd(Animatable animatable);

        void onAnimationPlay(Animatable animatable, int i3);

        void onAnimationStart(Animatable animatable);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Builder {
        long delayTimeInMs;
        ArrayList<String> photos;
        ImageProcessor processor;
        int repeatCount;
        int reqHeight;
        int reqWidth;

        public static Builder create() {
            return new Builder();
        }

        public QzoneAnimationDrawable build() {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            long j3 = this.delayTimeInMs;
            if (j3 > 0) {
                obtain.photoDelayTimeInMs = j3;
            }
            int i3 = this.reqWidth;
            if (i3 > 0) {
                obtain.clipWidth = i3;
            }
            int i16 = this.reqHeight;
            if (i16 > 0) {
                obtain.clipHeight = i16;
            }
            ArrayList<String> arrayList = this.photos;
            if (arrayList != null) {
                obtain.photoList = arrayList;
            } else {
                obtain.photoList = new ArrayList<>();
            }
            obtain.extraProcessor = this.processor;
            QzoneAnimationDrawable qzoneAnimationDrawable = new QzoneAnimationDrawable(obtain);
            int i17 = this.repeatCount;
            if (i17 > 0) {
                qzoneAnimationDrawable.setRepeatCount(i17);
            }
            return qzoneAnimationDrawable;
        }

        public Builder setDelayTime(long j3) {
            this.delayTimeInMs = j3;
            return this;
        }

        public Builder setPhotos(ArrayList<String> arrayList) {
            this.photos = arrayList;
            return this;
        }

        public Builder setProcessor(ImageProcessor imageProcessor) {
            this.processor = imageProcessor;
            return this;
        }

        public Builder setRepeatCount(int i3) {
            this.repeatCount = i3;
            return this;
        }

        public Builder setReqHeight(int i3) {
            this.reqHeight = i3;
            return this;
        }

        public Builder setReqWidth(int i3) {
            this.reqWidth = i3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class FrameSwitcher implements Runnable {
        FrameSwitcher() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!QzoneAnimationDrawable.this.switchFrame()) {
                QzoneAnimationDrawable.this.mSwitchFrameWhenLoaded = true;
            }
        }
    }

    public QzoneAnimationDrawable(ImageKey imageKey) {
        this.mImageKey = ImageKey.copy(imageKey);
        init();
    }

    private void doBeforeDraw() {
        AnimationListener animationListener;
        if (this.mNextFrameIndex - 1 == 0 && (animationListener = this.mAnimationListener) != null) {
            animationListener.onAnimationStart(this);
        }
        AnimationListener animationListener2 = this.mAnimationListener;
        if (animationListener2 != null) {
            animationListener2.onAnimationPlay(this, this.mNextFrameIndex - 1);
        }
    }

    private void init() {
        ImageLoader.Options copy = ImageLoader.Options.copy(this.mImageKey.options);
        this.mFrameOptions = copy;
        copy.needShowPhotoGifAnimation = false;
        copy.photoList = null;
        this.mExecutor = GifRenderingExecutor.getInstance();
        this.mInvalidationHandler = new InvalidationHandler(this);
        this.mPhotoLoadListener = new PhotoLoadListener();
        this.mFrameSwitcher = new FrameSwitcher();
        this.mPaint.setARGB(255, 240, 240, 240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextFrame() {
        if (this.mNextFrameIndex < this.mImageKey.options.photoList.size()) {
            String str = this.mImageKey.options.photoList.get(this.mNextFrameIndex);
            ImageLoader.getInstance().loadImageAsync(str, this.mPhotoLoadListener, this.mFrameOptions);
            ImageManagerEnv.getLogger().d(TAG, "loadNextFrame:" + str + ",frameIndex:" + this.mNextFrameIndex);
            if (this.mNextFrameIndex == getFrameCounts() - 1) {
                this.mPlayCount++;
            }
            this.mNextFrameIndex = (this.mNextFrameIndex + 1) % this.mImageKey.options.photoList.size();
            return;
        }
        ImageManagerEnv.getLogger().e(TAG, "loadNextFrame: out of index,mNextFrameIndex:" + this.mNextFrameIndex + ",photosize:" + this.mImageKey.options.photoList.size());
    }

    private void reset() {
        ScheduledFuture<?> scheduledFuture = this.mScheduledFuture;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.mScheduledFuture.cancel(true);
        }
        this.mIsRunning = true;
        this.mNextFrameIndex = 0;
        this.mCurrentFrame = null;
        this.mNextFrame = null;
        this.mSwitchFrameWhenLoaded = true;
        this.mPlayCount = 0;
        loadNextFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean switchFrame() {
        boolean z16;
        if (!this.mIsRunning) {
            return false;
        }
        if (this.mNextFrame != null) {
            if (canAnimate()) {
                this.mCurrentFrame = this.mNextFrame;
                this.mNextFrame = null;
                doBeforeDraw();
                if (!this.mInvalidationHandler.hasMessages(0)) {
                    this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }
                loadNextFrame();
            } else if (this.mCurrentFrame == null) {
                this.mCurrentFrame = this.mNextFrame;
                doBeforeDraw();
                if (!this.mInvalidationHandler.hasMessages(0)) {
                    this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                }
            }
            z16 = true;
        } else {
            z16 = false;
        }
        ScheduledFuture<?> scheduledFuture = this.mScheduledFuture;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.mScheduledFuture.cancel(true);
        }
        int i3 = this.mRepeatCount;
        if (i3 != LOOP_INFINITE && this.mPlayCount >= i3) {
            stop();
            AnimationListener animationListener = this.mAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(this);
            }
        } else {
            this.mScheduledFuture = this.mExecutor.schedule(this.mFrameSwitcher, this.mImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
            ImageManagerEnv.getLogger().d(TAG, "------next index:" + this.mNextFrameIndex);
        }
        return z16;
    }

    public boolean canAnimate() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mCurrentFrame != null) {
            this.mCurrentFrame.setBounds(getBounds());
            this.mCurrentFrame.draw(canvas);
            return;
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            drawable.setBounds(getBounds());
            this.mDefaultFrame.draw(canvas);
        } else {
            canvas.drawRect(this.mDstRect, this.mPaint);
        }
    }

    public int getFrameCounts() {
        return this.mImageKey.options.photoList.size();
    }

    public long getFrameDuration() {
        return this.mImageKey.options.photoDelayTimeInMs;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mCurrentFrame != null) {
            return this.mCurrentFrame.getIntrinsicHeight();
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mFrameOptions.clipHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mCurrentFrame != null) {
            return this.mCurrentFrame.getIntrinsicWidth();
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mFrameOptions.clipWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mCurrentFrame != null) {
            return this.mCurrentFrame.getMinimumHeight();
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return this.mFrameOptions.clipHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mCurrentFrame != null) {
            return this.mCurrentFrame.getMinimumWidth();
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return this.mFrameOptions.clipWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mDstRect.set(rect);
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    public void setDrawableForDefaultFrame(Drawable drawable) {
        this.mDefaultFrame = drawable;
    }

    public void setRepeatCount(int i3) {
        this.mRepeatCount = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (z17) {
                reset();
            } else {
                start();
            }
        } else if (visible) {
            stop();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        this.mSwitchFrameWhenLoaded = false;
        if (this.mNextFrame == null) {
            loadNextFrame();
        }
        ScheduledFuture<?> scheduledFuture = this.mScheduledFuture;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.mScheduledFuture.cancel(true);
        }
        this.mScheduledFuture = this.mExecutor.schedule(this.mFrameSwitcher, this.mImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mIsRunning = false;
    }

    public QzoneAnimationDrawable(ImageLoader.Options options) {
        ImageKey obtain = ImageKey.obtain();
        this.mImageKey = obtain;
        obtain.options = ImageLoader.Options.copy(options);
        init();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class PhotoLoadListener implements ImageLoader.ImageLoadListener {
        PhotoLoadListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            QzoneAnimationDrawable.this.loadNextFrame();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            QzoneAnimationDrawable.this.loadNextFrame();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            QzoneAnimationDrawable.this.mNextFrame = drawable;
            if (QzoneAnimationDrawable.this.mSwitchFrameWhenLoaded) {
                QzoneAnimationDrawable.this.mSwitchFrameWhenLoaded = false;
                QzoneAnimationDrawable.this.switchFrame();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
