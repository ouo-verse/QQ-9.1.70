package com.tencent.qqlive.tvkplayer.logo.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDynamicsLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLogoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoDownloader;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoInfoParser;
import com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDynamicsLogo implements ITVKLogoImpl {
    private static final int CONNECTION_TIME_OUT_1ST_MS = 5000;
    private static final int CONNECTION_TIME_OUT_2ND_MS = 5000;
    private static final int CONNECTION_TIME_OUT_3RD_MS = 10000;
    private static final int[] FETCH_CONFIG_CONNECTION_TIME_OUT = {5000, 5000, 10000};
    private static final int FETCH_CONFIG_RETRY_TIMES = 2;
    private static final String HTTP_REQUEST_TAG = "TVKDynamicsLogo";
    private static final String TAG = "[TVKPlayer]TVKDynamicsLogo";
    private final Context mContext;
    private TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews mCurrentLogoWithImageViews;
    private final ITVKLogger mLogger;
    private final TVKLogoSurfaceView mLogoSurfaceView;
    private final int mLogoViewType;
    private long mStartTimeMs;
    private int mVideoH;
    private int mVideoW;
    private final ViewGroup mViewGroup;
    private int mXyAxisType;
    private final Map<String, TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews> mDownloadedLogoInfoMap = new HashMap();
    private int mRepeatCount = 0;
    private long mPlayerPositionMs = 0;

    public TVKDynamicsLogo(TVKContext tVKContext, ViewGroup viewGroup, int i3) {
        this.mStartTimeMs = 0L;
        this.mLogger = new TVKLogger(tVKContext, TAG);
        Context context = tVKContext.getContext();
        this.mContext = context;
        this.mViewGroup = viewGroup;
        this.mLogoViewType = i3;
        TVKLogoSurfaceView tVKLogoSurfaceView = new TVKLogoSurfaceView(context);
        this.mLogoSurfaceView = tVKLogoSurfaceView;
        if (i3 == 0) {
            TVKLogoUtils.addLogoSurfaceViewInUIThread(tVKLogoSurfaceView, viewGroup);
        }
        this.mStartTimeMs = System.currentTimeMillis();
    }

    private TVKLogoCommonDefine.LogoShowUIInfo calculateDynamicsLogoUIInfo(TVKLogoInfo tVKLogoInfo, int i3, int i16, int i17) {
        float f16;
        float width;
        float f17;
        float f18;
        float f19;
        if (tVKLogoInfo == null) {
            return null;
        }
        TVKLogoCommonDefine.LogoShowUIInfo logoShowUIInfo = new TVKLogoCommonDefine.LogoShowUIInfo();
        int width2 = this.mViewGroup.getWidth();
        int height = this.mViewGroup.getHeight();
        float f26 = width2;
        float f27 = i3;
        float f28 = f26 / f27;
        float f29 = height;
        float f36 = i16;
        float f37 = f29 / f36;
        if (tVKLogoInfo.getVideoMinSideSize() > 0) {
            if (i16 > i3) {
                f16 = f27 / tVKLogoInfo.getVideoMinSideSize();
            } else {
                f16 = f36 / tVKLogoInfo.getVideoMinSideSize();
            }
        } else {
            f16 = 1.0f;
        }
        if (f28 > f37) {
            if (!TVKMediaPlayerConfig.PlayerConfig.is_logo_position_fixed && i17 != 0) {
                if (i17 == 6) {
                    float f38 = f29 / ((f27 / f36) * f29);
                    width = tVKLogoInfo.getWidth() * f37 * f16 * f38;
                    f17 = tVKLogoInfo.getHeight() * f37 * f16 * f38;
                    f18 = ((f26 - ((f36 * f37) * f38)) / 2.0f) + (tVKLogoInfo.getX() * f37 * f16 * f38);
                    f19 = f37 * tVKLogoInfo.getY() * f16 * f38;
                } else {
                    width = tVKLogoInfo.getWidth() * f28 * f16;
                    float x16 = tVKLogoInfo.getX() * f28 * f16;
                    f19 = f28 * tVKLogoInfo.getY() * f16;
                    f17 = tVKLogoInfo.getHeight() * f28 * f16;
                    f18 = x16;
                }
            } else {
                float width3 = tVKLogoInfo.getWidth() * f37 * f16;
                float height2 = tVKLogoInfo.getHeight() * f37 * f16;
                f18 = ((f26 - (f27 * f37)) / 2.0f) + (tVKLogoInfo.getX() * f37 * f16);
                f19 = f37 * tVKLogoInfo.getY() * f16;
                width = width3;
                f17 = height2;
            }
        } else {
            width = tVKLogoInfo.getWidth() * f28 * f16;
            float height3 = tVKLogoInfo.getHeight() * f28 * f16;
            float x17 = tVKLogoInfo.getX() * f28 * f16;
            float y16 = (f28 * tVKLogoInfo.getY() * f16) + ((f29 - (f36 * f28)) / 2.0f);
            f17 = height3;
            f18 = x17;
            f19 = y16;
        }
        if (tVKLogoInfo.getAlpha() != 0) {
            logoShowUIInfo.setAlpha(tVKLogoInfo.getAlpha());
        }
        logoShowUIInfo.setLogoHeight(f17);
        logoShowUIInfo.setLogoWidth(width);
        logoShowUIInfo.setRightX(f18);
        logoShowUIInfo.setRightY(f19);
        logoShowUIInfo.setNeedShow(tVKLogoInfo.getShow());
        this.mLogger.info("calculateDynamicsLogo, videoW=" + i3 + ", videoH=" + i16 + ", viewW=" + width2 + ", viewH=" + height + ", XyAxisType=" + i17, new Object[0]);
        this.mLogger.info("calculateDynamicsLogo, logoW=" + width + ", logoH=" + f17 + ", topRightX=" + f18 + ", topRightY=" + f19 + ", isShow=" + tVKLogoInfo.getShow() + ", alpha=" + tVKLogoInfo.getAlpha(), new Object[0]);
        return logoShowUIInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogoSurfaceView() {
        this.mLogger.info("clearLogoSurfaceView", new Object[0]);
        TVKLogoSurfaceView tVKLogoSurfaceView = this.mLogoSurfaceView;
        if (tVKLogoSurfaceView != null) {
            TVKLogoUtils.clearSurface(this.mContext, tVKLogoSurfaceView);
        }
    }

    private void downloadLogoForLive(TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo) {
        TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews = new TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews();
        tVKDynamicLogoInfoWithImageViews.setDynamicsLogoInfo(tVKOriginalLogoInfo.liveDynamicLogoInfo);
        downloadLogoImage(tVKDynamicLogoInfoWithImageViews);
        if (this.mCurrentLogoWithImageViews != null) {
            TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKDynamicsLogo.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TVKDynamicsLogo tVKDynamicsLogo = TVKDynamicsLogo.this;
                        tVKDynamicsLogo.removeImageViewByScenes(tVKDynamicsLogo.mCurrentLogoWithImageViews.getSceneWithImageViewsList());
                    } catch (Exception e16) {
                        TVKDynamicsLogo.this.mLogger.error(e16.toString(), new Object[0]);
                    }
                }
            });
        }
        this.mCurrentLogoWithImageViews = tVKDynamicLogoInfoWithImageViews;
    }

    private void downloadLogoForVod(TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo) {
        String str;
        if (TextUtils.isEmpty(tVKOriginalLogoInfo.vodDynamicLogoActionUrl)) {
            this.mLogger.info("vodDynamicLogo actionUrl is empty", new Object[0]);
            return;
        }
        if (this.mDownloadedLogoInfoMap.containsKey(tVKOriginalLogoInfo.vid + TVKUtils.getMd5(tVKOriginalLogoInfo.vodDynamicLogoActionUrl))) {
            this.mCurrentLogoWithImageViews = this.mDownloadedLogoInfoMap.get(tVKOriginalLogoInfo.vid + TVKUtils.getMd5(tVKOriginalLogoInfo.vodDynamicLogoActionUrl));
            return;
        }
        try {
            LocalCache localCache = LocalCache.get(this.mContext);
            if (localCache != null) {
                str = localCache.getAsString(tVKOriginalLogoInfo.vid + TVKUtils.getMd5(tVKOriginalLogoInfo.vodDynamicLogoActionUrl));
                if (TextUtils.isEmpty(str)) {
                    str = fetchLogoConfig(tVKOriginalLogoInfo.vodDynamicLogoActionUrl);
                    localCache.put(tVKOriginalLogoInfo.vid + TVKUtils.getMd5(tVKOriginalLogoInfo.vodDynamicLogoActionUrl), str);
                }
            } else {
                str = null;
            }
            TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews parseDynamicLogoJson = TVKLogoInfoParser.parseDynamicLogoJson(str);
            downloadLogoImage(parseDynamicLogoJson);
            if (parseDynamicLogoJson != null) {
                if (!this.mDownloadedLogoInfoMap.containsKey(tVKOriginalLogoInfo.vid + TVKUtils.getMd5(tVKOriginalLogoInfo.vodDynamicLogoActionUrl))) {
                    this.mDownloadedLogoInfoMap.put(tVKOriginalLogoInfo.vid + TVKUtils.getMd5(tVKOriginalLogoInfo.vodDynamicLogoActionUrl), parseDynamicLogoJson);
                }
            }
            this.mCurrentLogoWithImageViews = parseDynamicLogoJson;
        } catch (Exception e16) {
            this.mLogger.error("download logo exception:" + e16, new Object[0]);
        }
    }

    private void downloadLogoImage(TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews) {
        if (tVKDynamicLogoInfoWithImageViews == null) {
            this.mLogger.info("downloadLogoImage dynamicsLogoInfo is null", new Object[0]);
            return;
        }
        Iterator<TVKDynamicsLogoInfo.Scenes> it = tVKDynamicLogoInfoWithImageViews.getDynamicsLogoInfo().getSceneList().iterator();
        while (it.hasNext()) {
            TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews.SceneWithImageViews sceneWithImageViews = new TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews.SceneWithImageViews(this.mContext, it.next());
            tVKDynamicLogoInfoWithImageViews.addSceneWithImageViews(sceneWithImageViews);
            for (Map.Entry<TVKLogoInfo, TVKLogoImageView> entry : sceneWithImageViews.getLogoInfoToImageViewMap().entrySet()) {
                TVKLogoInfo key = entry.getKey();
                final TVKLogoImageView value = entry.getValue();
                new TVKLogoDownloader(this.mContext, new TVKLogoDownloader.CallBack() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKDynamicsLogo.2
                    @Override // com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoDownloader.CallBack
                    public void onFailure(int i3) {
                        TVKDynamicsLogo.this.mLogger.info("downloadLogoImage failed, errCode:" + i3, new Object[0]);
                    }

                    @Override // com.tencent.qqlive.tvkplayer.logo.utils.TVKLogoDownloader.CallBack
                    public void onSuccess(Bitmap bitmap) {
                        value.setBitmap(bitmap);
                        value.setImageBitmap(bitmap);
                    }
                }).execute(key.getLogoUrl(), key.getLogoHttpsUrl(), key.getMd5(), String.valueOf(key.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean drawLogoOnImageView(TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews, int i3, int i16, int i17) {
        long currentTimeMillis;
        removeAllImageViews();
        try {
            TVKDynamicsLogoInfo dynamicsLogoInfo = tVKDynamicLogoInfoWithImageViews.getDynamicsLogoInfo();
            if (dynamicsLogoInfo.getRunMode() == 1) {
                currentTimeMillis = this.mPlayerPositionMs;
            } else {
                currentTimeMillis = System.currentTimeMillis() - this.mStartTimeMs;
            }
            if (isCurrentPosOutOfLogoShowRange(currentTimeMillis, dynamicsLogoInfo)) {
                this.mLogger.info("currentPositionMs:" + currentTimeMillis + " isOutOfLogoShowRange, dynamiclogo duration:" + dynamicsLogoInfo.getDurationMs() + ", curRunMode:" + dynamicsLogoInfo.getRunMode(), new Object[0]);
                return true;
            }
            if (!TVKLogoUtils.drawImageViews(this.mViewGroup, getCurrentLogoUIInfo(tVKDynamicLogoInfoWithImageViews.getSceneWithImageViewsList(), (int) (currentTimeMillis / dynamicsLogoInfo.getDurationMs()), currentTimeMillis % dynamicsLogoInfo.getDurationMs(), i3, i16, i17))) {
                this.mLogger.info("drawImageViews failed", new Object[0]);
                return false;
            }
            this.mLogger.info("drawLogoOnImageView, done", new Object[0]);
            return true;
        } catch (Exception e16) {
            this.mLogger.error(e16.toString(), new Object[0]);
            return false;
        }
    }

    private boolean drawLogoOnSurfaceView(TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews, int i3, int i16, int i17) {
        long currentTimeMillis;
        if (!this.mLogoSurfaceView.isSurfaceReady()) {
            this.mLogger.info("logoSurfaceView not ready", new Object[0]);
            return false;
        }
        Canvas canvas = null;
        try {
            Canvas lockCanvasFromSurfaceView = TVKLogoUtils.lockCanvasFromSurfaceView(this.mContext, this.mLogoSurfaceView);
            if (lockCanvasFromSurfaceView == null) {
                if (lockCanvasFromSurfaceView != null) {
                    this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
                }
                return false;
            }
            try {
                TVKDynamicsLogoInfo dynamicsLogoInfo = tVKDynamicLogoInfoWithImageViews.getDynamicsLogoInfo();
                if (dynamicsLogoInfo.getRunMode() == 1) {
                    currentTimeMillis = this.mPlayerPositionMs;
                } else {
                    currentTimeMillis = System.currentTimeMillis() - this.mStartTimeMs;
                }
                int durationMs = (int) (currentTimeMillis / dynamicsLogoInfo.getDurationMs());
                if (isCurrentPosOutOfLogoShowRange(currentTimeMillis, dynamicsLogoInfo)) {
                    TVKLogoUtils.clearCanvas(lockCanvasFromSurfaceView);
                    this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
                    return true;
                }
                if (!TVKLogoUtils.drawCanvas(lockCanvasFromSurfaceView, this.mViewGroup.getWidth(), this.mViewGroup.getHeight(), getCurrentLogoUIInfo(tVKDynamicLogoInfoWithImageViews.getSceneWithImageViewsList(), durationMs, currentTimeMillis % dynamicsLogoInfo.getDurationMs(), i3, i16, i17))) {
                    this.mLogger.info("drawCanvas failed", new Object[0]);
                    this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
                    return false;
                }
                this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(lockCanvasFromSurfaceView);
                this.mLogger.info("logoShowSurface, done surface=" + this.mLogoSurfaceView, new Object[0]);
                return true;
            } catch (Throwable th5) {
                th = th5;
                canvas = lockCanvasFromSurfaceView;
                try {
                    this.mLogger.info(th.toString(), new Object[0]);
                    return false;
                } finally {
                    if (canvas != null) {
                        this.mLogoSurfaceView.getHolder().unlockCanvasAndPost(canvas);
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private String fetchLogoConfig(String str) throws IOException {
        String str2 = null;
        IOException e16 = null;
        int i3 = 0;
        while (true) {
            if (i3 > 2) {
                break;
            }
            try {
                str2 = new String(TVKHttpProcessorFactory.getHttpRequester().execute(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, str).reqTag(HTTP_REQUEST_TAG).callTimeoutMs(FETCH_CONFIG_CONNECTION_TIME_OUT[i3]).build()).getData());
                break;
            } catch (IOException e17) {
                e16 = e17;
                this.mLogger.warn("Attempt on fetching LOGO config from " + str + " failed, retried " + i3 + " time(s): " + e16, new Object[0]);
                i3++;
            }
        }
        if (i3 <= 2) {
            return str2;
        }
        this.mLogger.error("Fails to fetch LOGO config from " + str + MsgSummary.STR_COLON + e16, new Object[0]);
        throw e16;
    }

    private List<TVKLogoCommonDefine.LogoShowUIInfo> getCurrentLogoUIInfo(List<TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews.SceneWithImageViews> list, int i3, long j3, int i16, int i17, int i18) {
        ArrayList arrayList = new ArrayList();
        for (TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews.SceneWithImageViews sceneWithImageViews : list) {
            if ((i3 >= sceneWithImageViews.getStart() && i3 < sceneWithImageViews.getEnd()) || sceneWithImageViews.getEnd() == 0) {
                if (sceneWithImageViews.getInTimeMs() < j3 && sceneWithImageViews.getOutTimeMs() > j3) {
                    for (Map.Entry<TVKLogoInfo, TVKLogoImageView> entry : sceneWithImageViews.getLogoInfoToImageViewMap().entrySet()) {
                        TVKLogoCommonDefine.LogoShowUIInfo calculateDynamicsLogoUIInfo = calculateDynamicsLogoUIInfo(entry.getKey(), i16, i17, i18);
                        if (calculateDynamicsLogoUIInfo != null) {
                            calculateDynamicsLogoUIInfo.setImageView(entry.getValue());
                            arrayList.add(calculateDynamicsLogoUIInfo);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isCurrentPosOutOfLogoShowRange(long j3, TVKDynamicsLogoInfo tVKDynamicsLogoInfo) {
        long durationMs = (tVKDynamicsLogoInfo.getDurationMs() * tVKDynamicsLogoInfo.getRepeat()) + 10;
        if (tVKDynamicsLogoInfo.getRepeat() != 0 && j3 > durationMs) {
            return true;
        }
        return false;
    }

    private boolean isDrawLogoConditionValid() {
        if (!isVideoViewSizeValid()) {
            this.mLogger.info("video or view size invalid", new Object[0]);
            return false;
        }
        TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews = this.mCurrentLogoWithImageViews;
        if (tVKDynamicLogoInfoWithImageViews != null && tVKDynamicLogoInfoWithImageViews.getDynamicsLogoInfo() != null) {
            List<TVKDynamicsLogoInfo.Scenes> sceneList = this.mCurrentLogoWithImageViews.getDynamicsLogoInfo().getSceneList();
            if (sceneList != null && !sceneList.isEmpty()) {
                return true;
            }
            this.mLogger.info("scenes is empty", new Object[0]);
            return false;
        }
        this.mLogger.info("mCurrentLogoWithImageViews is null", new Object[0]);
        return false;
    }

    private boolean isValidTime(List<TVKDynamicsLogoInfo.Scenes> list, int i3, long j3) {
        boolean z16 = false;
        for (int i16 = 0; i16 < list.size(); i16++) {
            try {
                TVKDynamicsLogoInfo.Scenes scenes = list.get(i16);
                if (((i3 >= scenes.getStart() && i3 < scenes.getEnd()) || scenes.getEnd() == 0) && j3 >= scenes.getInTimeMs() - 1000 && j3 <= scenes.getOutTimeMs() + 1000 && (j3 <= scenes.getInTimeMs() + 1000 || j3 >= scenes.getOutTimeMs() - 1000)) {
                    z16 = true;
                }
            } catch (Exception e16) {
                this.mLogger.error(e16.toString(), new Object[0]);
            }
        }
        return z16;
    }

    private boolean isVideoViewSizeValid() {
        String str;
        int i3;
        ViewGroup viewGroup = this.mViewGroup;
        if (viewGroup != null && this.mVideoW > 0 && this.mVideoH > 0 && viewGroup.getHeight() > 0 && this.mViewGroup.getWidth() > 0) {
            return true;
        }
        ITVKLogger iTVKLogger = this.mLogger;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("video or view size invalid, viewGroup is null:");
        if (this.mViewGroup == null) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        sb5.append(", videoW:");
        sb5.append(this.mVideoW);
        sb5.append(", videoH:");
        sb5.append(this.mVideoH);
        sb5.append(", viewH:");
        ViewGroup viewGroup2 = this.mViewGroup;
        int i16 = -1;
        if (viewGroup2 != null) {
            i3 = viewGroup2.getHeight();
        } else {
            i3 = -1;
        }
        sb5.append(i3);
        sb5.append(", viewW:");
        ViewGroup viewGroup3 = this.mViewGroup;
        if (viewGroup3 != null) {
            i16 = viewGroup3.getWidth();
        }
        sb5.append(i16);
        iTVKLogger.info(sb5.toString(), new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllImageViews() {
        this.mLogger.info("removeAllImageViews", new Object[0]);
        if (this.mDownloadedLogoInfoMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews>> it = this.mDownloadedLogoInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews value = it.next().getValue();
            if (value != null) {
                removeImageViewByScenes(value.getSceneWithImageViewsList());
            }
        }
    }

    private void removeAllViewsOnUiThread() {
        TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKDynamicsLogo.4
            @Override // java.lang.Runnable
            public void run() {
                TVKDynamicsLogo.this.mLogger.info("removeAllViewsOnUiThread", new Object[0]);
                try {
                    TVKDynamicsLogo.this.removeAllImageViews();
                    TVKDynamicsLogo.this.clearLogoSurfaceView();
                    TVKDynamicsLogo.this.removeLogoSurfaceView();
                    TVKDynamicsLogo.this.mDownloadedLogoInfoMap.clear();
                } catch (Exception e16) {
                    TVKDynamicsLogo.this.mLogger.error(e16.toString(), new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImageViewByScenes(@NonNull List<TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews.SceneWithImageViews> list) {
        if (list.isEmpty()) {
            return;
        }
        Iterator<TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews.SceneWithImageViews> it = list.iterator();
        while (it.hasNext()) {
            Iterator<Map.Entry<TVKLogoInfo, TVKLogoImageView>> it5 = it.next().getLogoInfoToImageViewMap().entrySet().iterator();
            while (it5.hasNext()) {
                TVKLogoImageView value = it5.next().getValue();
                ViewGroup viewGroup = (ViewGroup) value.getParent();
                if (viewGroup != null) {
                    this.mLogger.info("removeImageView, view:" + value, new Object[0]);
                    viewGroup.removeView(value);
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
        this.mLogger.info("start draw", new Object[0]);
        if (!isDrawLogoConditionValid()) {
            return false;
        }
        boolean z16 = true;
        try {
            final TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews = this.mCurrentLogoWithImageViews;
            final int i3 = this.mVideoW;
            final int i16 = this.mVideoH;
            final int i17 = this.mXyAxisType;
            if (this.mLogoViewType == 0) {
                z16 = drawLogoOnSurfaceView(tVKDynamicLogoInfoWithImageViews, i3, i16, i17);
                if ("Redmi Note 8 Pro".equals(TVKVcSystemInfo.getDeviceModel())) {
                    z16 = drawLogoOnSurfaceView(tVKDynamicLogoInfoWithImageViews, i3, i16, i17);
                }
            } else {
                TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logo.impl.TVKDynamicsLogo.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TVKDynamicsLogo.this.drawLogoOnImageView(tVKDynamicLogoInfoWithImageViews, i3, i16, i17);
                        } catch (Exception e16) {
                            TVKDynamicsLogo.this.mLogger.error(e16.toString(), new Object[0]);
                        }
                    }
                });
            }
        } catch (Exception e16) {
            this.mLogger.error(e16.toString(), new Object[0]);
        }
        return z16;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public int getCurrentLogoType() {
        return 2;
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void release() {
        this.mLogger.info("release", new Object[0]);
        removeAllViewsOnUiThread();
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void resetStartTime() {
        this.mStartTimeMs = System.currentTimeMillis();
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
            this.mCurrentLogoWithImageViews = null;
        } else if (tVKOriginalLogoInfo.liveDynamicLogoInfo != null) {
            downloadLogoForLive(tVKOriginalLogoInfo);
        } else {
            downloadLogoForVod(tVKOriginalLogoInfo);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.logo.impl.ITVKLogoImpl
    public void updatePlayerPositionMs(long j3) {
        this.mPlayerPositionMs = j3;
        TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews = this.mCurrentLogoWithImageViews;
        if (tVKDynamicLogoInfoWithImageViews != null && tVKDynamicLogoInfoWithImageViews.getDynamicsLogoInfo() != null) {
            TVKDynamicsLogoInfo dynamicsLogoInfo = this.mCurrentLogoWithImageViews.getDynamicsLogoInfo();
            if (dynamicsLogoInfo.getRunMode() != 1) {
                j3 = System.currentTimeMillis() - this.mStartTimeMs;
            }
            long durationMs = j3 % dynamicsLogoInfo.getDurationMs();
            int durationMs2 = (int) (j3 / dynamicsLogoInfo.getDurationMs());
            List<TVKDynamicsLogoInfo.Scenes> sceneList = dynamicsLogoInfo.getSceneList();
            if (sceneList != null && sceneList.size() > 0 && !isValidTime(sceneList, durationMs2, durationMs)) {
                return;
            }
            this.mLogger.info("updatePlayerPositionMs, need draw", new Object[0]);
            draw();
        }
    }
}
