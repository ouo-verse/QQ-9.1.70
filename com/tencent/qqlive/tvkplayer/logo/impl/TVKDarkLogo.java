package com.tencent.qqlive.tvkplayer.logo.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDarkLogoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKDarkLogo;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoUtils;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDarkLogo {
    private static final int MAX_ALPHA = 255;
    private static final String TAG = "TVKDarkLogo";
    private BitmapDrawable mBitmapDrawable;

    @Nullable
    private TVKDarkLogoInfo mDarkLogoInfo;
    private boolean mIsUseImageView;

    @NonNull
    private final TVKLogger mLogger;
    private final TVKLogoImageView mLogoImageView;
    private final TVKLogoSurfaceView mLogoSurfaceView;
    private Bitmap mSrcBitmap;

    @NonNull
    private final TVKContext mTVKContext;
    private ScheduledFuture<?> mUpdateTimer;
    private ViewGroup mVideoView;
    private int mViewHeight;
    private int mViewWidth;
    private boolean mIsRunning = false;
    private int mFlickerAlpha = 0;
    private long mFlickerIntervalMs = 0;
    private long mFlickerDurationMs = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.tvkplayer.logo.impl.TVKDarkLogo$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            TVKDarkLogo tVKDarkLogo = TVKDarkLogo.this;
            tVKDarkLogo.refresh(tVKDarkLogo.getAlpha(tVKDarkLogo.mDarkLogoInfo.getDefaultAlpha()));
        }

        @Override // java.lang.Runnable
        public void run() {
            TVKDarkLogo tVKDarkLogo = TVKDarkLogo.this;
            tVKDarkLogo.refresh(tVKDarkLogo.getAlpha(tVKDarkLogo.mDarkLogoInfo.getFlickerInfo().getAlpha()));
            TVKThreadPool.getInstance().obtainScheduledExecutorService().schedule(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    TVKDarkLogo.AnonymousClass1.this.lambda$run$0();
                }
            }, TVKDarkLogo.this.mFlickerDurationMs, TimeUnit.MILLISECONDS);
        }
    }

    public TVKDarkLogo(@NonNull TVKContext tVKContext, ViewGroup viewGroup) {
        int width;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mIsUseImageView = false;
        this.mTVKContext = tVKContext;
        this.mVideoView = viewGroup;
        if (viewGroup == null) {
            width = 0;
        } else {
            width = viewGroup.getWidth();
        }
        this.mViewWidth = width;
        ViewGroup viewGroup2 = this.mVideoView;
        this.mViewHeight = viewGroup2 != null ? viewGroup2.getHeight() : 0;
        this.mLogger = new TVKLogger(tVKContext, TAG);
        this.mIsUseImageView = shouldUseImageView(viewGroup);
        this.mLogoSurfaceView = new TVKLogoSurfaceView(tVKContext.getContext());
        TVKLogoImageView tVKLogoImageView = new TVKLogoImageView(tVKContext.getContext());
        this.mLogoImageView = tVKLogoImageView;
        tVKLogoImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private void addLogoView() {
        final ViewGroup viewGroup = this.mVideoView;
        if (!(viewGroup instanceof ITVKVideoViewPrivate)) {
            return;
        }
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 17;
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                TVKDarkLogo.this.lambda$addLogoView$3(viewGroup, layoutParams);
            }
        });
    }

    private void cancelTimer() {
        ScheduledFuture<?> scheduledFuture = this.mUpdateTimer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.mUpdateTimer = null;
        }
    }

    private void clearLogoSurfaceView() {
        this.mLogger.info("clearLogoSurfaceView", new Object[0]);
        if (this.mLogoSurfaceView != null) {
            TVKLogoUtils.clearSurface(this.mTVKContext.getContext(), this.mLogoSurfaceView);
        }
    }

    private void clearSurface(Canvas canvas) {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void draw() {
        if (!isValidToDrawLogo()) {
            return;
        }
        this.mLogger.info("start draw", new Object[0]);
        cancelTimer();
        this.mUpdateTimer = TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(new AnonymousClass1(), 0L, this.mFlickerIntervalMs, TimeUnit.MILLISECONDS);
    }

    private void drawCanvas(@Nullable Bitmap bitmap, int i3) {
        if (!this.mLogoSurfaceView.isSurfaceReady()) {
            this.mLogger.info("surface is not ready", new Object[0]);
            return;
        }
        Canvas canvas = null;
        try {
            try {
                canvas = TVKLogoUtils.lockCanvasFromSurfaceView(this.mTVKContext.getContext(), this.mLogoSurfaceView);
            } catch (Exception e16) {
                this.mLogger.error("drawCanvas has exception:" + e16.toString(), new Object[0]);
                if (0 == 0) {
                    return;
                }
            }
            if (canvas == null) {
                this.mLogger.warn("drawLogoOnCanvas, canvas is null", new Object[0]);
                if (canvas != null) {
                    this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(canvas);
                    return;
                }
                return;
            }
            clearSurface(canvas);
            if (bitmap != null) {
                Paint paint = new Paint();
                paint.setFilterBitmap(true);
                paint.setAlpha(i3);
                int i16 = 0;
                while (i16 <= this.mViewWidth) {
                    int i17 = 0;
                    while (i17 <= this.mViewHeight) {
                        canvas.drawBitmap(bitmap, i16, i17, paint);
                        i17 += bitmap.getHeight();
                    }
                    i16 += bitmap.getWidth();
                }
            }
            this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(canvas);
        } catch (Throwable th5) {
            if (0 != 0) {
                this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(null);
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAlpha(float f16) {
        return (int) ((f16 * 255.0f) / 100.0f);
    }

    private boolean isValidToDrawLogo() {
        if (!this.mIsRunning) {
            this.mLogger.info("state is invalid", new Object[0]);
            return false;
        }
        if (!isVideoViewSizeValid()) {
            this.mLogger.info("view size invalid", new Object[0]);
            return false;
        }
        if (this.mDarkLogoInfo != null && this.mSrcBitmap != null) {
            if (this.mFlickerIntervalMs <= 0 || this.mFlickerDurationMs <= 0) {
                return false;
            }
            return true;
        }
        this.mLogger.info("logo info is null", new Object[0]);
        return false;
    }

    private boolean isVideoViewSizeValid() {
        String str;
        int i3;
        ViewGroup viewGroup = this.mVideoView;
        if (viewGroup != null && viewGroup.getHeight() > 0 && viewGroup.getWidth() > 0) {
            return true;
        }
        TVKLogger tVKLogger = this.mLogger;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("view size invalid, viewGroup is null:");
        if (viewGroup == null) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        sb5.append(", viewH:");
        int i16 = -1;
        if (viewGroup != null) {
            i3 = viewGroup.getHeight();
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        sb5.append(", viewW:");
        if (viewGroup != null) {
            i16 = viewGroup.getWidth();
        }
        sb5.append(i16);
        tVKLogger.info(sb5.toString(), new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$addLogoView$3(ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
        View view;
        this.mLogger.info("logoImageView parent=" + this.mLogoImageView.getParent() + ", logoSurfaceView parent=" + this.mLogoSurfaceView.getParent(), new Object[0]);
        lambda$updateVideoView$0();
        this.mLogger.info("afterRemoveParent, logoImageView parent=" + this.mLogoImageView.getParent() + ", logoSurfaceView parent=" + this.mLogoSurfaceView.getParent(), new Object[0]);
        ViewGroup innerDarkLogoView = ((ITVKVideoViewPrivate) viewGroup).getInnerDarkLogoView();
        if (this.mIsUseImageView) {
            view = this.mLogoImageView;
        } else {
            view = this.mLogoSurfaceView;
        }
        innerDarkLogoView.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$2(int i3) {
        if (this.mIsUseImageView) {
            this.mLogoImageView.setImageDrawable(this.mBitmapDrawable);
            this.mLogoImageView.setImageAlpha(i3);
        } else {
            drawCanvas(this.mSrcBitmap, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(final int i3) {
        if (i3 <= 0) {
            return;
        }
        this.mFlickerAlpha = i3;
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                TVKDarkLogo.this.lambda$refresh$2(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeLogoView, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$updateVideoView$0() {
        this.mLogger.info("removeLogoView", new Object[0]);
        this.mLogoImageView.setImageDrawable(null);
        ViewParent parent = this.mLogoImageView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mLogoImageView);
        }
        clearLogoSurfaceView();
        ViewParent parent2 = this.mLogoSurfaceView.getParent();
        if (parent2 instanceof ViewGroup) {
            ((ViewGroup) parent2).removeView(this.mLogoSurfaceView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean shouldUseImageView(ViewGroup viewGroup) {
        if (viewGroup instanceof ITVKVideoViewBase) {
            ITVKVideoViewBase iTVKVideoViewBase = (ITVKVideoViewBase) viewGroup;
            if (iTVKVideoViewBase.getLogoView() != null || (iTVKVideoViewBase.getCurrentDisplayView() instanceof TextureView)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void onViewSizeChanged() {
        ViewGroup viewGroup = this.mVideoView;
        this.mViewWidth = viewGroup.getWidth();
        this.mViewHeight = viewGroup.getHeight();
        this.mLogger.info("onViewSizeChanged, view width:" + this.mViewWidth + ", height:" + this.mViewHeight, new Object[0]);
        if (isValidToDrawLogo()) {
            refresh(this.mFlickerAlpha);
        }
    }

    public void start() {
        this.mLogger.info("start", new Object[0]);
        this.mIsRunning = true;
        draw();
    }

    public void stop() {
        this.mLogger.info("stop", new Object[0]);
        this.mIsRunning = false;
        cancelTimer();
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                TVKDarkLogo.this.lambda$stop$1();
            }
        });
    }

    public void updateDarkLogoInfo(@NonNull TVKDarkLogoInfo tVKDarkLogoInfo) {
        this.mDarkLogoInfo = tVKDarkLogoInfo;
        if (tVKDarkLogoInfo != null && tVKDarkLogoInfo.getFlickerInfo() != null && !TextUtils.isEmpty(tVKDarkLogoInfo.getLogo())) {
            this.mFlickerIntervalMs = this.mDarkLogoInfo.getFlickerInfo().getGapMs();
            long durationMs = this.mDarkLogoInfo.getFlickerInfo().getDurationMs();
            this.mFlickerDurationMs = durationMs;
            if (this.mFlickerIntervalMs > 0 && durationMs > 0) {
                byte[] decode = Base64.decode(this.mDarkLogoInfo.getLogo(), 0);
                if (decode == null) {
                    this.mLogger.warn("updateDarkLogoInfo, dark logo bytes is null", new Object[0]);
                    return;
                }
                this.mSrcBitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mTVKContext.getContext().getResources(), this.mSrcBitmap);
                this.mBitmapDrawable = bitmapDrawable;
                bitmapDrawable.setTargetDensity(this.mSrcBitmap.getDensity());
                BitmapDrawable bitmapDrawable2 = this.mBitmapDrawable;
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable2.setTileModeXY(tileMode, tileMode);
                this.mBitmapDrawable.setDither(true);
                addLogoView();
                return;
            }
            this.mLogger.warn("updateDarkLogoInfo, dark logo flicker interval or duration is invalid", new Object[0]);
            return;
        }
        this.mLogger.warn("updateDarkLogoInfo, dark logo info is null", new Object[0]);
    }

    public void updateVideoView(ViewGroup viewGroup) {
        int width;
        if (viewGroup == this.mVideoView) {
            return;
        }
        int i3 = 0;
        this.mLogger.info("updateVideoView, videoView=" + viewGroup, new Object[0]);
        this.mVideoView = viewGroup;
        if (viewGroup == null) {
            width = 0;
        } else {
            width = viewGroup.getWidth();
        }
        this.mViewWidth = width;
        ViewGroup viewGroup2 = this.mVideoView;
        if (viewGroup2 != null) {
            i3 = viewGroup2.getHeight();
        }
        this.mViewHeight = i3;
        this.mIsUseImageView = shouldUseImageView(viewGroup);
        if (this.mVideoView == null) {
            TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    TVKDarkLogo.this.lambda$updateVideoView$0();
                }
            });
        } else {
            addLogoView();
        }
    }
}
