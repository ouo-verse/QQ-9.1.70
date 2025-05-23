package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public class VideoDrawable extends Drawable {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private boolean mApplyGravity;
    private final Rect mDstRect;
    private OnPlayerOneFrameListener mFrameDrawListener;
    public boolean mPlayVideoFrame;
    private int mTargetDensity;
    private int mVideoHeight;
    private VideoState mVideoState;
    private int mVideoWidth;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnAudioPlayOnceListener {
        void onFinish();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnPlayRepeatListener {
        void onPlayRepeat(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnPlayerOneFrameListener {
        void oneFrameDrawed();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class VideoDrawableParams {
        static IPatchRedirector $redirector_;
        public String mAfPath;
        public int mDecodeType;
        public boolean mEnableAntiAlias;
        public boolean mEnableFilter;
        public boolean mPlayAudioFrame;
        public boolean mPlayVideoFrame;
        public int mRequestedFPS;
        public int mTotalTime;
        public String mVfPath;
        public int mVideoFrames;
        public int mVideoRoundCorner;

        public VideoDrawableParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mPlayVideoFrame = true;
            this.mPlayAudioFrame = false;
            this.mEnableAntiAlias = false;
            this.mEnableFilter = false;
            this.mRequestedFPS = -1;
            this.mDecodeType = 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            sb5.append(" mVideoRoundCorner: " + this.mVideoRoundCorner);
            sb5.append(" mPlayVideoFrame: " + this.mPlayVideoFrame);
            sb5.append(" mPlayAudioFrame: " + this.mPlayAudioFrame);
            sb5.append(" mEnableAntiAlias: " + this.mEnableAntiAlias);
            sb5.append(" mEnableFilter: " + this.mEnableFilter);
            sb5.append(" mRequestedFPS: " + this.mRequestedFPS);
            sb5.append(" mDecodeType: " + this.mDecodeType);
            sb5.append(" mVfPath: " + this.mVfPath);
            sb5.append(" mAfPath: " + this.mAfPath);
            sb5.append(" mTotalTime: " + this.mTotalTime);
            sb5.append(" mVideoFrames: " + this.mVideoFrames);
            sb5.append("] ");
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class VideoState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;
        int mChangingConfigurations;
        int mGravity;
        Paint mPaint;
        int mTargetDensity;
        AbstractVideoImage mVideo;

        public VideoState(AbstractVideoImage abstractVideoImage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractVideoImage);
                return;
            }
            this.mTargetDensity = 160;
            this.mPaint = new Paint();
            this.mGravity = 119;
            this.mVideo = abstractVideoImage;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new VideoDrawable(this, (Resources) null) : (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new VideoDrawable(this, resources) : (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resources);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            TAG = VideoDrawable.class.getSimpleName();
        }
    }

    public VideoDrawable(File file, Resources resources, boolean z16) {
        this(new NativeVideoImage(file, z16), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, file, resources, Boolean.valueOf(z16));
    }

    private void computeImageSize() {
        this.mVideoWidth = this.mVideoState.mVideo.getScaledWidth(this.mTargetDensity);
        this.mVideoHeight = this.mVideoState.mVideo.getScaledHeight(this.mTargetDensity);
    }

    public static boolean isVideo(File file) {
        String absolutePath = file.getAbsolutePath();
        int lastIndexOf = absolutePath.lastIndexOf(46);
        String substring = absolutePath.substring(lastIndexOf + 1);
        if (lastIndexOf > 0) {
            if (substring.equals("mp4") || substring.equals("vf")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void disableGlobalPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        AbstractVideoImage abstractVideoImage = this.mVideoState.mVideo;
        if (abstractVideoImage != null && (abstractVideoImage instanceof NativeVideoImage)) {
            ((NativeVideoImage) abstractVideoImage).disableGlobalPause();
        }
    }

    public void disableRequireAudioFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        AbstractVideoImage abstractVideoImage = this.mVideoState.mVideo;
        if (abstractVideoImage != null && (abstractVideoImage instanceof NativeVideoImage)) {
            ((NativeVideoImage) abstractVideoImage).mRequireAudioFocus = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        if (this.mApplyGravity) {
            Gravity.apply(this.mVideoState.mGravity, this.mVideoWidth, this.mVideoHeight, getBounds(), this.mDstRect);
            this.mApplyGravity = false;
        }
        OnPlayerOneFrameListener onPlayerOneFrameListener = this.mFrameDrawListener;
        if (onPlayerOneFrameListener != null) {
            onPlayerOneFrameListener.oneFrameDrawed();
        }
        copyBounds(this.mDstRect);
        VideoState videoState = this.mVideoState;
        videoState.mVideo.draw(canvas, this.mDstRect, videoState.mPaint, this.mPlayVideoFrame);
    }

    public void enableGlobalPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        AbstractVideoImage abstractVideoImage = this.mVideoState.mVideo;
        if (abstractVideoImage != null && (abstractVideoImage instanceof NativeVideoImage)) {
            ((NativeVideoImage) abstractVideoImage).mSupportGlobalPause = true;
        }
    }

    public void enableRequireAudioFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        AbstractVideoImage abstractVideoImage = this.mVideoState.mVideo;
        if (abstractVideoImage != null && (abstractVideoImage instanceof NativeVideoImage)) {
            ((NativeVideoImage) abstractVideoImage).mRequireAudioFocus = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mVideoState;
    }

    public Bitmap getCurrentBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Bitmap) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        AbstractVideoImage abstractVideoImage = this.mVideoState.mVideo;
        if (abstractVideoImage != null && (abstractVideoImage instanceof NativeVideoImage)) {
            return ((NativeVideoImage) abstractVideoImage).mCurFrameBitmap;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mVideoHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mVideoWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return -2;
    }

    public boolean isAudioPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.mVideoState.mVideo.isAudioPlaying();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rect);
        } else {
            super.onBoundsChange(rect);
            this.mApplyGravity = true;
        }
    }

    public void removeOnPlayRepeatListener(OnPlayRepeatListener onPlayRepeatListener) {
        AbstractVideoImage abstractVideoImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        VideoState videoState = this.mVideoState;
        if (videoState != null && (abstractVideoImage = videoState.mVideo) != null) {
            abstractVideoImage.removeOnPlayRepeatListener(onPlayRepeatListener);
        }
    }

    public void resetAndPlayAudioCircle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mVideoState.mVideo.resetAndPlayAudioCircle();
        }
    }

    public void resetAndPlayAudioOnce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mVideoState.mVideo.resetAndPlayAudioOnce();
        }
    }

    public void resetPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        AbstractVideoImage abstractVideoImage = this.mVideoState.mVideo;
        if (abstractVideoImage != null && (abstractVideoImage instanceof NativeVideoImage)) {
            ((NativeVideoImage) abstractVideoImage).mResetFlag = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mVideoState.mPaint.setAlpha(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) colorFilter);
        } else {
            this.mVideoState.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.mVideoState.mPaint.setDither(z16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mVideoState.mPaint.setFilterBitmap(z16);
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mVideoState.mGravity = i3;
            this.mApplyGravity = true;
        }
    }

    public void setOnAudioPlayOnceListener(OnAudioPlayOnceListener onAudioPlayOnceListener) {
        AbstractVideoImage abstractVideoImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) onAudioPlayOnceListener);
            return;
        }
        VideoState videoState = this.mVideoState;
        if (videoState != null && (abstractVideoImage = videoState.mVideo) != null) {
            abstractVideoImage.setOnAudioPlayOnceListener(onAudioPlayOnceListener);
        }
    }

    public void setOnPlayRepeatListener(OnPlayRepeatListener onPlayRepeatListener) {
        AbstractVideoImage abstractVideoImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        VideoState videoState = this.mVideoState;
        if (videoState != null && (abstractVideoImage = videoState.mVideo) != null) {
            abstractVideoImage.setOnPlayRepeatListener(onPlayRepeatListener);
        }
    }

    public void setOnPlayerOneFrameListener(OnPlayerOneFrameListener onPlayerOneFrameListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) onPlayerOneFrameListener);
        } else {
            this.mFrameDrawListener = onPlayerOneFrameListener;
        }
    }

    public void setTargetDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        if (i3 != this.mTargetDensity) {
            if (i3 == 0) {
                i3 = 160;
            }
            this.mTargetDensity = i3;
            computeImageSize();
            invalidateSelf();
        }
    }

    public void stopAudio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mVideoState.mVideo.stopPlayAudio();
        }
    }

    public VideoDrawable(AbstractVideoImage abstractVideoImage, Resources resources) {
        this(new VideoState(abstractVideoImage), resources);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) abstractVideoImage, (Object) resources);
        } else {
            this.mVideoState.mTargetDensity = this.mTargetDensity;
        }
    }

    public VideoDrawable(VideoState videoState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoState, (Object) resources);
            return;
        }
        this.mDstRect = new Rect();
        this.mPlayVideoFrame = true;
        this.mTargetDensity = 160;
        this.mFrameDrawListener = null;
        this.mVideoState = videoState;
        videoState.mVideo.attachDrawable(this);
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        } else {
            this.mTargetDensity = videoState.mTargetDensity;
        }
        computeImageSize();
    }
}
