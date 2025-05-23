package com.tencent.qqlive.tvkplayer.logo.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLogoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoDownloader;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKStaticLogo implements ITVKLogoImpl {
    private static final String TAG = "TVKStaticLogo";
    private final Context mContext;
    private List<TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView> mCurrentLogoWithImageViewList;
    private final ITVKLogger mLogger;
    private final TVKLogoSurfaceView mLogoSurfaceView;
    private final int mLogoViewType;
    private ViewGroup mViewGroup;
    private final List<TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews> mDownloadedLogoInfoList = new ArrayList();
    private int mXyAxisType = 0;
    private int mVideoW = 0;
    private int mVideoH = 0;

    public TVKStaticLogo(TVKContext tVKContext, ViewGroup viewGroup, int i3) {
        Context context = tVKContext.getContext();
        this.mContext = context;
        this.mLogger = new TVKLogger(tVKContext, TAG);
        this.mViewGroup = viewGroup;
        this.mLogoViewType = i3;
        TVKLogoSurfaceView tVKLogoSurfaceView = new TVKLogoSurfaceView(context);
        this.mLogoSurfaceView = tVKLogoSurfaceView;
        if (i3 == 0) {
            TVKLogoUtils.addLogoSurfaceViewInUIThread(tVKLogoSurfaceView, this.mViewGroup);
        }
    }

    private List<TVKLogoCommonDefine.LogoShowUIInfo> calculateStaticLogoUIInfo(@NonNull List<TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView> list, int i3, int i16, int i17) {
        float f16;
        float width;
        float height;
        float x16;
        float y16;
        int i18 = i3;
        ArrayList arrayList = new ArrayList();
        int width2 = this.mViewGroup.getWidth();
        int height2 = this.mViewGroup.getHeight();
        int i19 = 0;
        while (i19 < list.size()) {
            if (list.get(i19) != null) {
                TVKLogoInfo tVKLogoInfo = list.get(i19).logoInfo;
                float f17 = width2;
                float f18 = i18;
                float f19 = f17 / f18;
                float f26 = height2;
                float f27 = i16;
                float f28 = f26 / f27;
                if (tVKLogoInfo.getVideoMinSideSize() > 0) {
                    if (i16 > i18) {
                        f16 = f18 / tVKLogoInfo.getVideoMinSideSize();
                    } else {
                        f16 = f27 / tVKLogoInfo.getVideoMinSideSize();
                    }
                } else {
                    f16 = 1.0f;
                }
                if (f19 > f28) {
                    if (!TVKMediaPlayerConfig.PlayerConfig.is_logo_position_fixed && i17 != 0) {
                        if (i17 == 6) {
                            float f29 = f26 / ((f18 / f27) * f26);
                            width = tVKLogoInfo.getWidth() * f28 * f16 * f29;
                            height = tVKLogoInfo.getHeight() * f28 * f16 * f29;
                            x16 = ((f17 - ((f27 * f28) * f29)) / 2.0f) + (tVKLogoInfo.getX() * f28 * f16 * f29);
                            y16 = f28 * tVKLogoInfo.getY() * f16 * f29;
                        } else {
                            width = tVKLogoInfo.getWidth() * f19 * f16;
                            height = tVKLogoInfo.getHeight() * f19 * f16;
                            x16 = tVKLogoInfo.getX() * f19 * f16;
                            y16 = f19 * tVKLogoInfo.getY() * f16;
                        }
                    } else {
                        width = tVKLogoInfo.getWidth() * f28 * f16;
                        float height3 = tVKLogoInfo.getHeight() * f28 * f16;
                        x16 = ((f17 - (f18 * f28)) / 2.0f) + (tVKLogoInfo.getX() * f28 * f16);
                        y16 = f28 * tVKLogoInfo.getY() * f16;
                        height = height3;
                    }
                } else {
                    width = tVKLogoInfo.getWidth() * f19 * f16;
                    height = tVKLogoInfo.getHeight() * f19 * f16;
                    x16 = tVKLogoInfo.getX() * f19 * f16;
                    y16 = ((f26 - (f27 * f19)) / 2.0f) + (f19 * tVKLogoInfo.getY() * f16);
                }
                TVKLogoCommonDefine.LogoShowUIInfo logoShowUIInfo = new TVKLogoCommonDefine.LogoShowUIInfo();
                if (tVKLogoInfo.getAlpha() != 0) {
                    logoShowUIInfo.setAlpha(tVKLogoInfo.getAlpha());
                }
                logoShowUIInfo.setLogoHeight(height);
                logoShowUIInfo.setLogoWidth(width);
                logoShowUIInfo.setRightX(x16);
                logoShowUIInfo.setRightY(y16);
                logoShowUIInfo.setNeedShow(tVKLogoInfo.getShow());
                logoShowUIInfo.setImageView(list.get(i19).imageView);
                arrayList.add(logoShowUIInfo);
            }
            i19++;
            i18 = i3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogoSurfaceView() {
        this.mLogger.info("clearLogoSurfaceView", new Object[0]);
        TVKLogoSurfaceView tVKLogoSurfaceView = this.mLogoSurfaceView;
        if (tVKLogoSurfaceView != null) {
            TVKLogoUtils.clearSurface(this.mContext, tVKLogoSurfaceView);
        }
    }

    private List<TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView> downloadLogoImage(List<TVKLogoInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            final TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView logoInfoWithImageView = new TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView();
            logoInfoWithImageView.logoInfo = list.get(i3);
            logoInfoWithImageView.imageView = new TVKLogoImageView(this.mContext);
            try {
                new TVKLogoDownloader(this.mContext, new TVKLogoDownloader.CallBack() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKStaticLogo.1
                    @Override // com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoDownloader.CallBack
                    public void onFailure(int i16) {
                        TVKStaticLogo.this.mLogger.info("logo download failed.", new Object[0]);
                    }

                    @Override // com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoDownloader.CallBack
                    public void onSuccess(Bitmap bitmap) {
                        logoInfoWithImageView.imageView.setBitmap(bitmap);
                        logoInfoWithImageView.imageView.setImageBitmap(bitmap);
                    }
                }).execute(list.get(i3).getLogoUrl(), list.get(i3).getLogoHttpsUrl(), list.get(i3).getMd5(), String.valueOf(list.get(i3).getId()));
            } catch (Exception unused) {
            }
            arrayList.add(logoInfoWithImageView);
        }
        return arrayList;
    }

    private boolean drawLogoOnCanvas(List<TVKLogoCommonDefine.LogoShowUIInfo> list) {
        try {
            Canvas lockCanvasFromSurfaceView = TVKLogoUtils.lockCanvasFromSurfaceView(this.mContext, this.mLogoSurfaceView);
            if (lockCanvasFromSurfaceView == null) {
                this.mLogger.warn("drawLogoOnCanvas, canvas is null", new Object[0]);
                if (lockCanvasFromSurfaceView != null) {
                    this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
                }
                return false;
            }
            if (!TVKLogoUtils.drawCanvas(lockCanvasFromSurfaceView, this.mViewGroup.getWidth(), this.mViewGroup.getHeight(), list)) {
                this.mLogger.info("drawImageViews failed", new Object[0]);
                this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
                return false;
            }
            this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
            this.mLogger.info("logoShowSurface done, logoSurfaceView=" + this.mLogoSurfaceView, new Object[0]);
            return true;
        } catch (Throwable unused) {
            if (0 != 0) {
                this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(null);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean drawLogoOnImageView(int i3, int i16, int i17) {
        removeAllImageViews();
        try {
            if (!TVKLogoUtils.drawImageViews(this.mViewGroup, calculateStaticLogoUIInfo(this.mCurrentLogoWithImageViewList, i3, i16, i17))) {
                this.mLogger.info("drawImageViews failed", new Object[0]);
                return false;
            }
            this.mLogger.info("drawLogoOnImageView, done", new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean drawLogoOnSurfaceView(int i3, int i16, int i17) {
        if (!this.mLogoSurfaceView.isSurfaceReady()) {
            this.mLogger.info("logoSurfaceView not ready", new Object[0]);
            return false;
        }
        List<TVKLogoCommonDefine.LogoShowUIInfo> calculateStaticLogoUIInfo = calculateStaticLogoUIInfo(this.mCurrentLogoWithImageViewList, i3, i16, i17);
        if (calculateStaticLogoUIInfo != null && !calculateStaticLogoUIInfo.isEmpty()) {
            return drawLogoOnCanvas(calculateStaticLogoUIInfo);
        }
        this.mLogger.info("drawLogoOnSurfaceView, logoInfoList is empty", new Object[0]);
        return false;
    }

    private boolean isDrawLogoConditionValid() {
        if (this.mViewGroup == null) {
            this.mLogger.info("viewGroup is null", new Object[0]);
            return false;
        }
        if (!isVideoViewSizeValid()) {
            this.mLogger.info("video or view size invalid", new Object[0]);
            return false;
        }
        if (this.mCurrentLogoWithImageViewList == null) {
            this.mLogger.info("currentLogoWithImageViewList is null", new Object[0]);
            return false;
        }
        return true;
    }

    private boolean isVideoViewSizeValid() {
        if (this.mVideoW > 0 && this.mVideoH > 0 && this.mViewGroup.getHeight() > 0 && this.mViewGroup.getWidth() > 0) {
            return true;
        }
        this.mLogger.info("video or view size invalid, viewGroup:" + this.mViewGroup + ", videoW:" + this.mVideoW + ", videoH:" + this.mVideoH + ", viewGroup.getHeight():" + this.mViewGroup.getHeight() + ", viewGroup.getWidth():" + this.mViewGroup.getWidth(), new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllImageViews() {
        if (this.mDownloadedLogoInfoList.isEmpty()) {
            return;
        }
        for (TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews tVKStaticLogoInfoWithImageViews : this.mDownloadedLogoInfoList) {
            if (tVKStaticLogoInfoWithImageViews != null) {
                removeImageViewByLogoInfo(tVKStaticLogoInfoWithImageViews.logoInfoWithImageViewList);
            }
        }
    }

    private void removeAllViewsOnUiThread() {
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKStaticLogo.3
            @Override // java.lang.Runnable
            public void run() {
                TVKStaticLogo.this.mLogger.info("removeAllViewsOnUiThread", new Object[0]);
                try {
                    TVKStaticLogo.this.removeAllImageViews();
                    TVKStaticLogo.this.clearLogoSurfaceView();
                    TVKStaticLogo.this.removeLogoSurfaceView();
                    TVKStaticLogo.this.mDownloadedLogoInfoList.clear();
                } catch (Exception unused) {
                }
            }
        });
    }

    private void removeImageViewByLogoInfo(List<TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView> list) {
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                try {
                    TVKLogoImageView tVKLogoImageView = list.get(i3).imageView;
                    ViewGroup viewGroup = (ViewGroup) tVKLogoImageView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(tVKLogoImageView);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLogoSurfaceView() {
        ViewGroup viewGroup;
        TVKLogoSurfaceView tVKLogoSurfaceView = this.mLogoSurfaceView;
        if (tVKLogoSurfaceView != null && (viewGroup = (ViewGroup) tVKLogoSurfaceView.getParent()) != null) {
            viewGroup.removeView(this.mLogoSurfaceView);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public boolean draw() {
        if (!isDrawLogoConditionValid()) {
            return false;
        }
        try {
            final int i3 = this.mVideoW;
            final int i16 = this.mVideoH;
            final int i17 = this.mXyAxisType;
            if (this.mLogoViewType == 0) {
                boolean drawLogoOnSurfaceView = drawLogoOnSurfaceView(i3, i16, i17);
                if ("Redmi Note 8 Pro".equals(TVKVcSystemInfo.getDeviceModel())) {
                    return drawLogoOnSurfaceView(i3, i16, i17);
                }
                return drawLogoOnSurfaceView;
            }
            TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKStaticLogo.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TVKStaticLogo.this.drawLogoOnImageView(i3, i16, i17);
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public int getCurrentLogoType() {
        return 1;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void release() {
        this.mLogger.info("release", new Object[0]);
        removeAllViewsOnUiThread();
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void setVideoSize(int i3, int i16) {
        this.mVideoW = i3;
        this.mVideoH = i16;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void setXYaxis(int i3) {
        this.mXyAxisType = i3;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void updateLogoInfo(TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo) {
        if (tVKOriginalLogoInfo == null) {
            this.mCurrentLogoWithImageViewList = null;
            this.mLogger.info("downloadLogoInfo, originalLogoInfo is null", new Object[0]);
            return;
        }
        this.mLogger.info("start downloadLogo", new Object[0]);
        List<TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews.LogoInfoWithImageView> downloadLogoImage = downloadLogoImage(tVKOriginalLogoInfo.logoInfoList);
        if (!downloadLogoImage.isEmpty()) {
            TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews tVKStaticLogoInfoWithImageViews = new TVKLogoCommonDefine.TVKStaticLogoInfoWithImageViews();
            tVKStaticLogoInfoWithImageViews.logoInfoWithImageViewList = downloadLogoImage;
            tVKStaticLogoInfoWithImageViews.defn = tVKOriginalLogoInfo.defn;
            tVKStaticLogoInfoWithImageViews.videoW = tVKOriginalLogoInfo.videoW;
            tVKStaticLogoInfoWithImageViews.videoH = tVKOriginalLogoInfo.videoH;
            this.mDownloadedLogoInfoList.add(tVKStaticLogoInfoWithImageViews);
        }
        this.mCurrentLogoWithImageViewList = downloadLogoImage;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void resetStartTime() {
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void updatePlayerPositionMs(long j3) {
    }
}
