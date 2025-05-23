package com.tencent.qqlive.tvkplayer.qqliveasset.subtitle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.view.api.ITVKVideoViewPrivate;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPSubtitleFrameBuffer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSubtitleRenderer implements ITVKSubtitleRenderer {
    private static final String TAG = "TVKSubtitleRenderer";
    private final ITVKLogger mLogger;
    private final ImageView mSubtitleImageView;
    private final TVKSubtitleSurfaceView mSubtitleSurfaceView;
    private boolean mUseImageView = false;
    private TPSubtitleData mCurrentSubtitleData = null;

    public TVKSubtitleRenderer(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, TAG);
        this.mSubtitleSurfaceView = new TVKSubtitleSurfaceView(tVKQQLiveAssetPlayerContext.getContext());
        this.mSubtitleImageView = new TVKSubtitleImageView(tVKQQLiveAssetPlayerContext.getContext());
    }

    private void clearSurface(Canvas canvas) {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPaint(paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void clearSurfaceView(SurfaceView surfaceView) {
        Canvas lockCanvas = surfaceView.getHolder().lockCanvas();
        if (lockCanvas != null) {
            clearSurface(lockCanvas);
            surfaceView.getHolder().unlockCanvasAndPost(lockCanvas);
            this.mLogger.info("clear surface canvas success", new Object[0]);
            return;
        }
        this.mLogger.info("canvas is null, clear surface canvas failed", new Object[0]);
    }

    private void drawCanvas(@Nullable Bitmap bitmap) {
        if (!this.mSubtitleSurfaceView.isSurfaceReady()) {
            this.mLogger.info("surface is not ready", new Object[0]);
            return;
        }
        Canvas canvas = null;
        try {
            try {
                canvas = this.mSubtitleSurfaceView.getHolder().lockCanvas();
                if (canvas != null) {
                    clearSurface(canvas);
                    if (bitmap != null) {
                        Paint paint = new Paint();
                        paint.setFilterBitmap(true);
                        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.mSubtitleSurfaceView.getWidth(), this.mSubtitleSurfaceView.getHeight()), paint);
                    }
                }
                if (canvas == null) {
                    return;
                }
            } catch (Exception e16) {
                this.mLogger.error("drawCanvas has exception:" + e16.toString(), new Object[0]);
                if (canvas == null) {
                    return;
                }
            }
            this.mSubtitleSurfaceView.getHolder().unlockCanvasAndPost(canvas);
        } catch (Throwable th5) {
            if (canvas != null) {
                this.mSubtitleSurfaceView.getHolder().unlockCanvasAndPost(canvas);
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$1(Bitmap bitmap) {
        if (this.mUseImageView) {
            this.mSubtitleImageView.setImageBitmap(bitmap);
        } else {
            drawCanvas(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateVideoView$0(ITVKVideoViewPrivate iTVKVideoViewPrivate, FrameLayout.LayoutParams layoutParams) {
        View view;
        this.mLogger.info("subtitleImageView parent=" + this.mSubtitleImageView.getParent() + ", subtitleSurfaceView parent=" + this.mSubtitleSurfaceView.getParent(), new Object[0]);
        lambda$reset$2();
        this.mLogger.info("afterRemoveParent, subtitleImageView parent=" + this.mSubtitleImageView.getParent() + ", subtitleSurfaceView parent=" + this.mSubtitleSurfaceView.getParent(), new Object[0]);
        ViewGroup innerSubtitleView = iTVKVideoViewPrivate.getInnerSubtitleView();
        if (this.mUseImageView) {
            view = this.mSubtitleImageView;
        } else {
            view = this.mSubtitleSurfaceView;
        }
        innerSubtitleView.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeSubtitleView, reason: merged with bridge method [inline-methods] */
    public void lambda$reset$2() {
        this.mSubtitleImageView.setImageBitmap(null);
        ViewParent parent = this.mSubtitleImageView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mSubtitleImageView);
        }
        clearSurfaceView(this.mSubtitleSurfaceView);
        ViewParent parent2 = this.mSubtitleSurfaceView.getParent();
        if (parent2 instanceof ViewGroup) {
            ((ViewGroup) parent2).removeView(this.mSubtitleSurfaceView);
        }
    }

    private boolean shouldUseImageView(ITVKVideoViewBase iTVKVideoViewBase) {
        if (iTVKVideoViewBase.getSubtitleView() != null || (iTVKVideoViewBase.getCurrentDisplayView() instanceof TextureView)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    @Nullable
    public TPSubtitleData getCurrentSubtitleData() {
        return this.mCurrentSubtitleData;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    public void render(@Nullable TPSubtitleData tPSubtitleData) {
        this.mCurrentSubtitleData = tPSubtitleData;
        final Bitmap bitmap = null;
        if (tPSubtitleData instanceof TPSubtitleFrameBuffer) {
            try {
                bitmap = ((TPSubtitleFrameBuffer) tPSubtitleData).toBitmap();
            } catch (Exception e16) {
                this.mLogger.error("draw subtitle, toBitmap has exception:" + e16, new Object[0]);
            }
        }
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.a
            @Override // java.lang.Runnable
            public final void run() {
                TVKSubtitleRenderer.this.lambda$render$1(bitmap);
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    public void reset() {
        this.mUseImageView = false;
        this.mCurrentSubtitleData = null;
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.b
            @Override // java.lang.Runnable
            public final void run() {
                TVKSubtitleRenderer.this.lambda$reset$2();
            }
        });
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.ITVKSubtitleRenderer
    public void updateVideoView(final ITVKVideoViewPrivate iTVKVideoViewPrivate) {
        if (iTVKVideoViewPrivate == null) {
            this.mLogger.info("No need to updateVideoView, videoView is null", new Object[0]);
            return;
        }
        this.mLogger.info("updateVideoView", new Object[0]);
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.gravity = 17;
        this.mUseImageView = shouldUseImageView((ITVKVideoViewBase) iTVKVideoViewPrivate);
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.subtitle.c
            @Override // java.lang.Runnable
            public final void run() {
                TVKSubtitleRenderer.this.lambda$updateVideoView$0(iTVKVideoViewPrivate, layoutParams);
            }
        });
    }
}
