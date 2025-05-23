package com.tencent.gamematrix.gmcg.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgCodecAbility;
import com.tencent.gamematrix.gmcg.api.GmCgImeInputController;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoadingViewCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayPerfInfo;
import com.tencent.gamematrix.gmcg.base.download.image.CGImageDownloader;
import com.tencent.gamematrix.gmcg.base.download.video.CGVideoDownloader;
import com.tencent.gamematrix.gmcg.base.helper.CGPersistHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.impl.CGSessionLoadingProgress;
import com.tencent.gamematrix.gmcg.webrtc.VideoCodecType;
import java.io.File;

/* loaded from: classes6.dex */
public abstract class CGCommPlaySessionViewHolder implements CGImageDownloader.ResultListener, CGVideoDownloader.ResultListener, GmCgImeInputController {
    protected static final String KEY_PERSIST_LOADING_VIEW = ".key.persist.loading.view";
    protected GmCgCodecAbility mCodecAbility;
    protected Context mContext;

    @NonNull
    protected GmCgGameStreamQualityCfg mCurGmCgStreamQualityCfg;

    @DrawableRes
    protected int mDefaultLoadingBackgroundResId;

    @DrawableRes
    protected int mDefaultLoadingLandscapeResId;

    @DrawableRes
    protected int mDefaultLoadingPortraitResId;
    private boolean mEnableExtraOverlay;
    private int mExtraOverlayGravity;
    protected GmCgGameLoadingViewCfg mGameLoadingViewInfo;
    protected int mGameScreenOrientation;
    protected GmCgDeviceInfo mGmCgDeviceInfo;
    protected String mGmCgGameId;
    private Runnable mHideIvLoadingRunnable;
    private Runnable mHideVvLoadingRunnable;
    protected String mIdentity;
    protected CGImeInputControllerInternal mImeInputControllerInternal;
    protected ImageView mIvLoadingView;
    protected ImageView.ScaleType mLoadingScaleType;
    protected CGLoadingViewLruCache mLoadingViewCache;
    protected CGImageDownloader mLoadingViewImageDownloader;
    protected CGLoadingViewMapHolder mLoadingViewMapHolder;
    protected CGVideoDownloader mLoadingViewVideoDownloader;
    protected boolean mPerfDumping;
    protected FrameLayout mPlayContainerView;
    protected GmCgPlayPerfInfo mPlayPerfInfo;
    protected GmCgPlayStatusListener mPlayStatusListener;
    protected String mPlayStatusMessage;
    protected CGSessionLoadingProgress mSessionLoadingProgress;
    protected TextView mTvExtraOverlay;
    protected boolean mUseCustomLoadingView;
    protected VideoCodecType mVideoCodecType;
    protected VideoView mVvLoadingView;

    public CGCommPlaySessionViewHolder() {
        this.mGmCgGameId = "unknown";
        this.mIdentity = "unknown";
        this.mPlayPerfInfo = new GmCgPlayPerfInfo();
        this.mGameScreenOrientation = 2;
        this.mCurGmCgStreamQualityCfg = new GmCgGameStreamQualityCfg();
        this.mPlayStatusMessage = "Unknown";
        this.mCodecAbility = GmCgCodecAbility.CODEC_HARDWARE;
        this.mVideoCodecType = VideoCodecType.H264;
        this.mPerfDumping = false;
        this.mUseCustomLoadingView = false;
        this.mLoadingScaleType = ImageView.ScaleType.FIT_CENTER;
    }

    private void addDefaultLoadingView() {
        GmImageCgLoadingView gmImageCgLoadingView = new GmImageCgLoadingView(this.mContext);
        this.mIvLoadingView = gmImageCgLoadingView;
        gmImageCgLoadingView.setScaleType(this.mLoadingScaleType);
        if (1 == this.mGameScreenOrientation) {
            this.mIvLoadingView.setImageResource(this.mDefaultLoadingPortraitResId);
        } else {
            this.mIvLoadingView.setImageResource(this.mDefaultLoadingLandscapeResId);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mIvLoadingView.setBackgroundResource(this.mDefaultLoadingBackgroundResId);
        CGLog.i("addDefaultLoadingView");
        this.mPlayContainerView.addView(this.mIvLoadingView, 2, layoutParams);
    }

    private void addImageLoadingView() {
        GmImageCgLoadingView gmImageCgLoadingView = new GmImageCgLoadingView(this.mContext);
        this.mIvLoadingView = gmImageCgLoadingView;
        gmImageCgLoadingView.setScaleType(this.mLoadingScaleType);
        this.mIvLoadingView.setImageURI(Uri.fromFile(new File(this.mLoadingViewMapHolder.pPath)));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (CGStringUtil.notEmpty(this.mLoadingViewMapHolder.pLoadingPictureColor)) {
            this.mIvLoadingView.setBackgroundColor(Color.parseColor(this.mLoadingViewMapHolder.pLoadingPictureColor));
        }
        CGLog.i("addImageLoadingView mLoadingViewMapHolder: " + this.mLoadingViewMapHolder);
        this.mPlayContainerView.addView(this.mIvLoadingView, 2, layoutParams);
    }

    private void addLastFrameLoadingView(String str) {
        GmImageCgLoadingView gmImageCgLoadingView = new GmImageCgLoadingView(this.mContext);
        this.mIvLoadingView = gmImageCgLoadingView;
        gmImageCgLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mIvLoadingView.setImageURI(Uri.fromFile(new File(str)));
        this.mPlayContainerView.addView(this.mIvLoadingView, 2, new FrameLayout.LayoutParams(-1, -1));
    }

    private void addServerConfigLoadingView() {
        this.mLoadingViewCache = (CGLoadingViewLruCache) new Gson().fromJson(CGPersistHelper.getKVasString(KEY_PERSIST_LOADING_VIEW, ""), CGLoadingViewLruCache.class);
        CGLog.i("setupLoadingViewIfNecessary mLoadingViewCache: " + this.mLoadingViewCache);
        if (this.mLoadingViewCache == null) {
            this.mLoadingViewCache = new CGLoadingViewLruCache(10);
        }
        this.mLoadingViewMapHolder = this.mLoadingViewCache.get(this.mGmCgGameId);
        CGLog.i("setupLoadingViewIfNecessary mLoadingViewMapHolder: " + this.mLoadingViewMapHolder + ", mGmCgGameId: " + this.mGmCgGameId);
        CGLoadingViewMapHolder cGLoadingViewMapHolder = this.mLoadingViewMapHolder;
        if (cGLoadingViewMapHolder != null && cGLoadingViewMapHolder.isValid()) {
            int i3 = this.mLoadingViewMapHolder.type;
            if (i3 != 1) {
                if (i3 == 2) {
                    addVideoLoadingView();
                    return;
                }
                return;
            }
            addImageLoadingView();
            return;
        }
        addDefaultLoadingView();
    }

    private void addVideoLoadingView() {
        GmVideoCgLoadingView gmVideoCgLoadingView = new GmVideoCgLoadingView(this.mContext);
        this.mVvLoadingView = gmVideoCgLoadingView;
        gmVideoCgLoadingView.setVideoPath(this.mLoadingViewMapHolder.pPath);
        CGLog.i("addVideoLoadingView path: " + this.mLoadingViewMapHolder.pPath);
        this.mVvLoadingView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.gamematrix.gmcg.sdk.view.CGCommPlaySessionViewHolder.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                CGLog.i("video onPrepared");
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });
        this.mVvLoadingView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.gamematrix.gmcg.sdk.view.c
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
                boolean lambda$addVideoLoadingView$2;
                lambda$addVideoLoadingView$2 = CGCommPlaySessionViewHolder.this.lambda$addVideoLoadingView$2(mediaPlayer, i3, i16);
                return lambda$addVideoLoadingView$2;
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        layoutParams.setMargins(1, 1, 1, 1);
        this.mPlayContainerView.addView(this.mVvLoadingView, 2, layoutParams);
        this.mVvLoadingView.start();
    }

    private int checkLoadingViewType(GmCgGameLoadingViewCfg gmCgGameLoadingViewCfg) {
        if (CGStringUtil.notEmpty(gmCgGameLoadingViewCfg.pLoadingAnimation) && gmCgGameLoadingViewCfg.pLoadingAnimation.startsWith("http")) {
            return 2;
        }
        if (CGStringUtil.notEmpty(gmCgGameLoadingViewCfg.pLoadingPicture) && gmCgGameLoadingViewCfg.pLoadingPicture.startsWith("http")) {
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$addVideoLoadingView$2(MediaPlayer mediaPlayer, int i3, int i16) {
        CGLog.w("mVvLoadingView play is error!");
        this.mVvLoadingView.stopPlayback();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPlaySessionStreaming$0() {
        CGLog.i("session\u63a8\u6d41\u540e\u9690\u85cfloading\u56fe");
        this.mIvLoadingView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPlaySessionStreaming$1() {
        CGLog.i("session\u63a8\u6d41\u540e\u9690\u85cfloading\u89c6\u9891");
        this.mIvLoadingView.setVisibility(8);
    }

    private void onPlayLoadingFinished() {
        ImageView imageView = this.mIvLoadingView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (this.mVvLoadingView != null) {
            CGLog.i("onPlayFirstFrameRendered stop video!");
            this.mVvLoadingView.setVisibility(8);
            this.mVvLoadingView.stopPlayback();
        }
    }

    private void onPlaySessionConnected() {
        CGSessionLoadingProgress cGSessionLoadingProgress = this.mSessionLoadingProgress;
        if (cGSessionLoadingProgress != null) {
            cGSessionLoadingProgress.isSessionResumed(true);
        }
    }

    private void onPlaySessionErrorHappen() {
        CGLog.i("session error, removeHideLoadingDelayAction");
        removeHideLoadingDelayAction();
    }

    private void onPlaySessionStart() {
        ImageView imageView = this.mIvLoadingView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.mVvLoadingView != null) {
            CGLog.i("onPlaySessionStart start video!");
            this.mVvLoadingView.setVisibility(0);
            this.mVvLoadingView.start();
        }
    }

    private void onPlaySessionStop() {
        CGImageDownloader cGImageDownloader = this.mLoadingViewImageDownloader;
        if (cGImageDownloader != null) {
            cGImageDownloader.cancel();
        }
        CGLog.i("session stop, removeHideLoadingDelayAction");
        removeHideLoadingDelayAction();
    }

    private void onPlaySessionStreaming(long j3) {
        ImageView imageView = this.mIvLoadingView;
        if (imageView != null && imageView.getVisibility() == 0) {
            CGLog.i("session\u63a8\u6d41\u4e2d, loading\u56fe\u5c1a\u672a\u9690\u85cf, " + j3 + "ms\u540e\u9690\u85cfloading\u56fe");
            if (this.mHideIvLoadingRunnable == null) {
                this.mHideIvLoadingRunnable = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.view.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        CGCommPlaySessionViewHolder.this.lambda$onPlaySessionStreaming$0();
                    }
                };
            }
            this.mIvLoadingView.postDelayed(this.mHideIvLoadingRunnable, j3);
        }
        VideoView videoView = this.mVvLoadingView;
        if (videoView != null && videoView.getVisibility() == 0) {
            CGLog.i("session\u63a8\u6d41\u4e2d, loading\u89c6\u9891\u5c1a\u672a\u9690\u85cf, " + j3 + "ms\u540e\u9690\u85cfloading\u89c6\u9891");
            if (this.mHideVvLoadingRunnable == null) {
                this.mHideVvLoadingRunnable = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.view.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        CGCommPlaySessionViewHolder.this.lambda$onPlaySessionStreaming$1();
                    }
                };
            }
            this.mVvLoadingView.postDelayed(this.mHideIvLoadingRunnable, j3);
        }
    }

    private void removeHideLoadingDelayAction() {
        Runnable runnable;
        Runnable runnable2;
        ImageView imageView = this.mIvLoadingView;
        if (imageView != null && (runnable2 = this.mHideIvLoadingRunnable) != null) {
            imageView.removeCallbacks(runnable2);
        }
        VideoView videoView = this.mVvLoadingView;
        if (videoView != null && (runnable = this.mHideVvLoadingRunnable) != null) {
            videoView.removeCallbacks(runnable);
        }
    }

    private void saveImageViewHolder(CGLoadingViewMapHolder cGLoadingViewMapHolder) {
        String str;
        if (cGLoadingViewMapHolder != null) {
            cGLoadingViewMapHolder.addRefGameId(this.mGmCgGameId);
            GmCgGameLoadingViewCfg gmCgGameLoadingViewCfg = this.mGameLoadingViewInfo;
            if (gmCgGameLoadingViewCfg != null) {
                str = gmCgGameLoadingViewCfg.pLoadingPictureColor;
            } else {
                str = "#101023";
            }
            cGLoadingViewMapHolder.pLoadingPictureColor = str;
            CGLoadingViewLruCache cGLoadingViewLruCache = this.mLoadingViewCache;
            if (cGLoadingViewLruCache != null) {
                cGLoadingViewLruCache.put(this.mGmCgGameId, cGLoadingViewMapHolder);
                CGLog.i("onImageDownloadResult mGmCgGameId: " + this.mGmCgGameId + ", mLoadingViewCache: " + new Gson().toJson(this.mLoadingViewCache));
                CGPersistHelper.putKVasString(KEY_PERSIST_LOADING_VIEW, new Gson().toJson(this.mLoadingViewCache));
            }
        }
    }

    private void saveVideoViewHolder(CGLoadingViewMapHolder cGLoadingViewMapHolder) {
        if (cGLoadingViewMapHolder != null) {
            cGLoadingViewMapHolder.addRefGameId(this.mGmCgGameId);
            CGLoadingViewLruCache cGLoadingViewLruCache = this.mLoadingViewCache;
            if (cGLoadingViewLruCache != null) {
                cGLoadingViewLruCache.put(this.mGmCgGameId, cGLoadingViewMapHolder);
                CGLog.i("onVideoDownloadResult mGmCgGameId: " + this.mGmCgGameId + ",  mLoadingViewCache: " + this.mLoadingViewCache);
                CGPersistHelper.putKVasString(KEY_PERSIST_LOADING_VIEW, new Gson().toJson(this.mLoadingViewCache));
            }
        }
    }

    private void setupExtraOverlay(boolean z16, boolean z17, boolean z18) {
        this.mEnableExtraOverlay = z16;
        this.mExtraOverlayGravity = (z17 ? 8388613 : 8388611) | (z18 ? 80 : 48);
        setupExtraOverlay();
    }

    private void setupLoadingViewIfNecessary() {
        if (this.mPlayContainerView == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.mPlayContainerView.getChildCount()) {
                break;
            }
            if (this.mPlayContainerView.getChildAt(i3) instanceof GmCgLoadingView) {
                this.mPlayContainerView.removeViewAt(i3);
                break;
            }
            i3++;
        }
        Bitmap provideLastFrameScreenShot = provideLastFrameScreenShot();
        if (provideLastFrameScreenShot != null && !provideLastFrameScreenShot.isRecycled()) {
            addLastFrameLoadingView(provideLastFrameScreenShot);
        } else {
            addServerConfigLoadingView();
        }
    }

    private void startLoadImage(String str) {
        CGLoadingViewMapHolder hasCacheByUrl;
        if (CGStringUtil.notEmpty(str) && str.startsWith("http")) {
            CGLoadingViewMapHolder cGLoadingViewMapHolder = this.mLoadingViewMapHolder;
            if (cGLoadingViewMapHolder != null && cGLoadingViewMapHolder.hasCached(str)) {
                CGLog.i("mLoadingViewMapHolder has image cache, gameId: " + this.mGmCgGameId);
                return;
            }
            CGLoadingViewLruCache cGLoadingViewLruCache = this.mLoadingViewCache;
            if (cGLoadingViewLruCache != null && (hasCacheByUrl = cGLoadingViewLruCache.hasCacheByUrl(str)) != null && hasCacheByUrl.hasCached(str)) {
                saveImageViewHolder(hasCacheByUrl);
                CGLog.i("has save image url in cache: " + hasCacheByUrl);
                return;
            }
            if (!this.mUseCustomLoadingView) {
                if (this.mLoadingViewMapHolder != null) {
                    this.mLoadingViewCache.removeAndDeleteFile(this.mGmCgGameId);
                }
                CGImageDownloader cGImageDownloader = new CGImageDownloader(str, "loading_img_" + CGSystemUtil.encryptMd5(str.getBytes()), this);
                this.mLoadingViewImageDownloader = cGImageDownloader;
                cGImageDownloader.download();
            }
        }
    }

    private void startLoadVideo(String str) {
        CGLoadingViewMapHolder hasCacheByUrl;
        if (CGStringUtil.notEmpty(str) && str.startsWith("http")) {
            CGLoadingViewMapHolder cGLoadingViewMapHolder = this.mLoadingViewMapHolder;
            if (cGLoadingViewMapHolder != null && cGLoadingViewMapHolder.hasCached(str)) {
                CGLog.i("mLoadingViewMapHolder has video cache, gameId: " + this.mGmCgGameId);
                return;
            }
            CGLog.i("startLoadVideo mUseCustomLoadingView: " + this.mUseCustomLoadingView);
            CGLoadingViewLruCache cGLoadingViewLruCache = this.mLoadingViewCache;
            if (cGLoadingViewLruCache != null && (hasCacheByUrl = cGLoadingViewLruCache.hasCacheByUrl(str)) != null && hasCacheByUrl.hasCached(str)) {
                saveVideoViewHolder(hasCacheByUrl);
                CGLog.i("has save video url in cache: " + hasCacheByUrl);
                return;
            }
            if (!this.mUseCustomLoadingView) {
                if (this.mLoadingViewMapHolder != null) {
                    this.mLoadingViewCache.removeAndDeleteFile(this.mGmCgGameId);
                }
                CGVideoDownloader cGVideoDownloader = new CGVideoDownloader(this.mContext);
                this.mLoadingViewVideoDownloader = cGVideoDownloader;
                cGVideoDownloader.downloadVideo(str, "loading_video_" + CGSystemUtil.encryptMd5(str.getBytes()), this);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void closeImeInput() {
        CGImeInputControllerInternal cGImeInputControllerInternal = this.mImeInputControllerInternal;
        if (cGImeInputControllerInternal != null) {
            cGImeInputControllerInternal.closeImeInput();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void enableImeInput(boolean z16, Activity activity, FrameLayout frameLayout, GmCgImeInputController.GmCgImeInputEvtListener gmCgImeInputEvtListener) {
        if (this.mImeInputControllerInternal == null) {
            this.mImeInputControllerInternal = new CGImeInputControllerInternal(this.mPlayContainerView, this.mGameScreenOrientation);
        }
        this.mImeInputControllerInternal.enableImeInput(z16, activity, frameLayout, gmCgImeInputEvtListener);
    }

    public Context getContext() {
        return this.mContext;
    }

    protected abstract String getLastFrameImgToLoading();

    public int getPlayRenderHeight() {
        FrameLayout frameLayout = this.mPlayContainerView;
        if (frameLayout != null) {
            return frameLayout.getHeight();
        }
        return 0;
    }

    public int getPlayRenderWidth() {
        FrameLayout frameLayout = this.mPlayContainerView;
        if (frameLayout != null) {
            return frameLayout.getWidth();
        }
        return 0;
    }

    public boolean isExtraOverlayShowing() {
        TextView textView = this.mTvExtraOverlay;
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void onBaseInfoUpdate(String str, String str2) {
        this.mIdentity = str;
        this.mGmCgGameId = str2;
        if (!this.mUseCustomLoadingView) {
            setupLoadingViewIfNecessary();
        }
        showOverlayExtraInfo();
    }

    public void onDeviceInfoUpdate(GmCgDeviceInfo gmCgDeviceInfo) {
        this.mGmCgDeviceInfo = gmCgDeviceInfo;
        showOverlayExtraInfo();
    }

    public void onGameLoadingViewCfgGot(GmCgGameLoadingViewCfg gmCgGameLoadingViewCfg) {
        if (gmCgGameLoadingViewCfg != null) {
            this.mGameLoadingViewInfo = gmCgGameLoadingViewCfg;
            int checkLoadingViewType = checkLoadingViewType(gmCgGameLoadingViewCfg);
            CGLog.i("onGameLoadingViewCfgGot " + gmCgGameLoadingViewCfg + ", type: " + checkLoadingViewType);
            if (checkLoadingViewType != 1) {
                if (checkLoadingViewType != 2) {
                    if (this.mLoadingViewMapHolder != null) {
                        this.mLoadingViewCache.removeAndDeleteFile(this.mGmCgGameId);
                        CGPersistHelper.putKVasString(KEY_PERSIST_LOADING_VIEW, new Gson().toJson(this.mLoadingViewCache));
                        return;
                    }
                    return;
                }
                startLoadVideo(this.mGameLoadingViewInfo.pLoadingAnimation);
                return;
            }
            startLoadImage(this.mGameLoadingViewInfo.pLoadingPicture);
        }
    }

    public void onGameStreamQualityChanged(GmCgGameStreamQualityCfg gmCgGameStreamQualityCfg) {
        if (gmCgGameStreamQualityCfg != null) {
            this.mCurGmCgStreamQualityCfg = gmCgGameStreamQualityCfg;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.base.download.image.CGImageDownloader.ResultListener
    public void onImageDownloadResult(boolean z16, String str, String str2) {
        if (z16) {
            saveImageViewHolder(CGLoadingViewMapHolder.createLoadingImageViewHolder(str, str2));
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void onImeInputCloudFinish() {
        CGImeInputControllerInternal cGImeInputControllerInternal = this.mImeInputControllerInternal;
        if (cGImeInputControllerInternal != null) {
            cGImeInputControllerInternal.onImeInputCloudFinish();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController
    public void onImeInputCloudStart() {
        CGImeInputControllerInternal cGImeInputControllerInternal = this.mImeInputControllerInternal;
        if (cGImeInputControllerInternal != null) {
            cGImeInputControllerInternal.onImeInputCloudStart();
        }
    }

    public void onPerfDumpingUpdate(boolean z16) {
        this.mPerfDumping = z16;
        showOverlayExtraInfo();
    }

    public void onPerfInfoUpdate(GmCgPlayPerfInfo gmCgPlayPerfInfo) {
        this.mPlayPerfInfo = gmCgPlayPerfInfo;
        showOverlayExtraInfo();
    }

    protected abstract void onPlayRenderViewSetup();

    @CallSuper
    protected void onPlaySessionRestart() {
        ImageView imageView = this.mIvLoadingView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onStatusUpdate(GmCgPlayStatus gmCgPlayStatus, int i3, int i16) {
        CGSessionLoadingProgress cGSessionLoadingProgress = this.mSessionLoadingProgress;
        if (cGSessionLoadingProgress != null) {
            cGSessionLoadingProgress.onGmCgPlayStatusUpdate(gmCgPlayStatus);
        }
        String statusName = gmCgPlayStatus.getStatusName();
        this.mPlayStatusMessage = statusName;
        if (CGStringUtil.isEmpty(statusName)) {
            this.mPlayStatusMessage = "Unknown";
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            onPlaySessionStop();
            return;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusServerClosed)) {
            this.mPlayStatusMessage += "(" + i16 + ")";
            return;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusErrorHappen)) {
            this.mPlayStatusMessage += String.format("(0x%X)", Integer.valueOf(i3));
            onPlaySessionErrorHappen();
            return;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusStart)) {
            onPlaySessionStart();
            return;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusLoadingFinished)) {
            onPlayLoadingFinished();
            return;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusRestart)) {
            onPlaySessionRestart();
            return;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusRTCConnected)) {
            onPlaySessionConnected();
        } else if (gmCgPlayStatus.is(GmCgPlayStatus.StatusInStreaming)) {
            onPlaySessionStreaming(5000L);
        } else {
            showOverlayExtraInfo();
        }
    }

    public void onStreamConfigGot(GmCgCodecAbility gmCgCodecAbility, VideoCodecType videoCodecType) {
        this.mCodecAbility = gmCgCodecAbility;
        this.mVideoCodecType = videoCodecType;
    }

    @Override // com.tencent.gamematrix.gmcg.base.download.video.CGVideoDownloader.ResultListener
    public void onVideoDownloadResult(boolean z16, String str, String str2) {
        if (z16) {
            saveVideoViewHolder(CGLoadingViewMapHolder.createLoadingVideoViewHolder(str, str2));
        }
    }

    @Nullable
    protected Bitmap provideLastFrameScreenShot() {
        return null;
    }

    public void removePlayStatusListener() {
        this.mPlayStatusListener = null;
        this.mSessionLoadingProgress = null;
    }

    public void setDefaultLoadingBackgroundResId(@DrawableRes int i3) {
        if (i3 != 0) {
            this.mDefaultLoadingBackgroundResId = i3;
        }
    }

    public void setDefaultLoadingLandscapeResId(@DrawableRes int i3) {
        if (i3 != 0) {
            this.mDefaultLoadingLandscapeResId = i3;
        }
    }

    public void setDefaultLoadingPortraitResId(@DrawableRes int i3) {
        if (i3 != 0) {
            this.mDefaultLoadingPortraitResId = i3;
        }
    }

    public void setLoadingScaleType(ImageView.ScaleType scaleType) {
        this.mLoadingScaleType = scaleType;
    }

    public void setPlayContainer(FrameLayout frameLayout) {
        if (this.mPlayContainerView == frameLayout) {
            CGLog.w(CGStringUtil.format("the play container %s is same, no need to repeat set!!!", frameLayout));
            return;
        }
        this.mPlayContainerView = frameLayout;
        this.mContext = frameLayout.getContext();
        setupPlayRenderView();
        onPlayRenderViewSetup();
        setupExtraOverlay();
        if (!this.mUseCustomLoadingView) {
            setupLoadingViewIfNecessary();
        }
    }

    public void setPlayScreenOrientation(int i3) {
        this.mGameScreenOrientation = i3;
    }

    public void setPlayStatusListener(GmCgPlayStatusListener gmCgPlayStatusListener) {
        if (gmCgPlayStatusListener != null) {
            this.mPlayStatusListener = gmCgPlayStatusListener;
            this.mSessionLoadingProgress = new CGSessionLoadingProgress(gmCgPlayStatusListener);
        }
    }

    protected abstract void setupPlayRenderView();

    public void showExtraOverlay(boolean z16) {
        int i3;
        TextView textView = this.mTvExtraOverlay;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    protected abstract void showOverlayExtraInfo();

    public void toggleExtraOverlay() {
        boolean z16;
        TextView textView = this.mTvExtraOverlay;
        if (textView != null) {
            int i3 = 0;
            if (textView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            TextView textView2 = this.mTvExtraOverlay;
            if (z16) {
                i3 = 8;
            }
            textView2.setVisibility(i3);
        }
    }

    private void setupExtraOverlay() {
        if (this.mPlayContainerView == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.mPlayContainerView.getChildCount()) {
                break;
            }
            if (this.mPlayContainerView.getChildAt(i3) instanceof GmCgExtraOverlayView) {
                this.mPlayContainerView.removeViewAt(i3);
                break;
            }
            i3++;
        }
        this.mTvExtraOverlay = new GmCgExtraOverlayView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mExtraOverlayGravity;
        this.mPlayContainerView.addView(this.mTvExtraOverlay, 1, layoutParams);
        this.mTvExtraOverlay.setVisibility(this.mEnableExtraOverlay ? 0 : 8);
    }

    private void addLastFrameLoadingView(Bitmap bitmap) {
        try {
            GmImageCgLoadingView gmImageCgLoadingView = new GmImageCgLoadingView(this.mContext);
            this.mIvLoadingView = gmImageCgLoadingView;
            gmImageCgLoadingView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.mIvLoadingView.setImageBitmap(bitmap);
            this.mPlayContainerView.addView(this.mIvLoadingView, 2, new FrameLayout.LayoutParams(-1, -1));
        } catch (Exception e16) {
            CGLog.e("addLastFrameLoadingView: " + e16.getMessage());
        }
    }

    public CGCommPlaySessionViewHolder(@NonNull FrameLayout frameLayout) {
        this.mGmCgGameId = "unknown";
        this.mIdentity = "unknown";
        this.mPlayPerfInfo = new GmCgPlayPerfInfo();
        this.mGameScreenOrientation = 2;
        this.mCurGmCgStreamQualityCfg = new GmCgGameStreamQualityCfg();
        this.mPlayStatusMessage = "Unknown";
        this.mCodecAbility = GmCgCodecAbility.CODEC_HARDWARE;
        this.mVideoCodecType = VideoCodecType.H264;
        this.mPerfDumping = false;
        this.mUseCustomLoadingView = false;
        this.mLoadingScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mPlayContainerView = frameLayout;
        this.mContext = frameLayout.getContext();
        setupPlayRenderView();
    }

    public CGCommPlaySessionViewHolder(@NonNull FrameLayout frameLayout, boolean z16) {
        this(frameLayout);
        this.mUseCustomLoadingView = z16;
    }

    public CGCommPlaySessionViewHolder(@NonNull FrameLayout frameLayout, boolean z16, boolean z17, boolean z18, boolean z19) {
        this(frameLayout, z16);
        setupExtraOverlay(z17, z18, z19);
    }
}
