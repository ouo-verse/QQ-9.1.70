package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.minigame.manager.GameVideoPlayerManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class VideoJsPlugin extends BaseJsPlugin {
    public static final String EMPTY_RESULT = "{}";
    public static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
    public static final String EVENT_OPERATE_VIDEO_PLAYER = "operateVideoPlayer";
    public static final String EVENT_REMOVE_VIDEOPLAYER = "removeVideoPlayer";
    public static final String EVENT_UPDATE_VIDEO_PLAYER = "updateVideoPlayer";
    private static final String TAG = "VideoJsPlugin";
    private float density;
    private final SparseArray<CoverView> mCoverViewSparseArray = new SparseArray<>();
    private final List<String> mUnderGameViewList = new ArrayList();

    private boolean operatePlayerSeek(String str, CoverVideoView coverVideoView) {
        try {
            return coverVideoView.seekTo((int) (new JSONObject(str).optDouble("time") * 1000.0d));
        } catch (Exception e16) {
            QMLog.e("VideoJsPlugin", "wrong seek pram. " + str, e16);
            return false;
        }
    }

    private boolean operatePlayerSendDanmu(String str, CoverVideoView coverVideoView) {
        String str2;
        int i3;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 2) {
                str2 = jSONArray.getString(0);
                i3 = ColorUtils.parseColor(jSONArray.getString(1));
            } else {
                if (jSONArray.length() == 1) {
                    str2 = jSONArray.getString(0);
                } else {
                    str2 = null;
                }
                i3 = 0;
            }
            coverVideoView.playDanmu(str2, i3);
            return true;
        } catch (Exception e16) {
            QMLog.e("VideoJsPlugin", "sendDanmu error.", e16);
            return false;
        }
    }

    private void removeCoverChildView(int i3) {
        for (int i16 = 0; i16 < this.mCoverViewSparseArray.size(); i16++) {
            CoverView coverView = this.mCoverViewSparseArray.get(this.mCoverViewSparseArray.keyAt(i16));
            if (coverView != null && coverView.getParentId() == i3) {
                if (coverView.getParentId() == 0) {
                    GameVideoPlayerManager.removeView(this.mMiniAppContext, coverView);
                } else {
                    CoverView coverView2 = this.mCoverViewSparseArray.get(coverView.getParentId());
                    if (coverView2 != null) {
                        coverView2.removeView(coverView);
                    }
                }
            }
        }
    }

    @JsEvent({"insertVideoPlayer"})
    public String insertVideoPlayer(final RequestEvent requestEvent) {
        if (this.density <= 0.0f) {
            this.density = DisplayUtil.getDensity(this.mContext);
        }
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("videoPlayerId");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.VideoJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoJsPlugin videoJsPlugin = VideoJsPlugin.this;
                    if (videoJsPlugin.insertVideoPlayer(((BaseJsPlugin) videoJsPlugin).mMiniAppContext, requestEvent.jsService, optInt, jSONObject)) {
                        requestEvent.ok(jSONObject2);
                    } else {
                        requestEvent.fail();
                    }
                }
            });
            return "{}";
        } catch (Throwable th5) {
            QMLog.e("VideoJsPlugin", requestEvent.event + " error.", th5);
            return "{}";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        if (this.mCoverViewSparseArray.size() > 0) {
            for (int i3 = 0; i3 < this.mCoverViewSparseArray.size(); i3++) {
                CoverView valueAt = this.mCoverViewSparseArray.valueAt(i3);
                if (valueAt instanceof CoverVideoView) {
                    CoverVideoView coverVideoView = (CoverVideoView) valueAt;
                    coverVideoView.stop();
                    coverVideoView.release();
                }
            }
            this.mCoverViewSparseArray.clear();
        }
    }

    @JsEvent({"operateVideoPlayer"})
    public String operateVideoPlayer(final RequestEvent requestEvent) {
        if (this.density <= 0.0f) {
            this.density = DisplayUtil.getDensity(this.mContext);
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("type");
            final int optInt = jSONObject.optInt("videoPlayerId");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.VideoJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoJsPlugin.this.operateVideoPlayer(optInt, optString, requestEvent.jsonParams)) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail(null);
                    }
                }
            });
            return "{}";
        } catch (Throwable th5) {
            QMLog.e("VideoJsPlugin", requestEvent.event + " error.", th5);
            return "{}";
        }
    }

    @JsEvent({"removeVideoPlayer"})
    public String removeVideoPlayer(final RequestEvent requestEvent) {
        if (this.density <= 0.0f) {
            this.density = DisplayUtil.getDensity(this.mContext);
        }
        try {
            final int optInt = new JSONObject(requestEvent.jsonParams).optInt("videoPlayerId");
            CoverView coverView = this.mCoverViewSparseArray.get(optInt);
            if (coverView instanceof CoverVideoView) {
                ((CoverVideoView) coverView).pauseWithUi();
                ((CoverVideoView) coverView).stop();
                ((CoverVideoView) coverView).release();
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.VideoJsPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    VideoJsPlugin.this.removeVideoPlayer(optInt);
                    requestEvent.ok();
                }
            });
            return "{}";
        } catch (Throwable th5) {
            QMLog.e("VideoJsPlugin", requestEvent.event + " error.", th5);
            return "{}";
        }
    }

    @JsEvent({"updateVideoPlayer"})
    public String updateVideoPlayer(final RequestEvent requestEvent) {
        if (this.density <= 0.0f) {
            this.density = DisplayUtil.getDensity(this.mContext);
        }
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("videoPlayerId");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.VideoJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoJsPlugin.this.updateVideoPlayer(optInt, jSONObject);
                    requestEvent.ok();
                }
            });
            return "{}";
        } catch (Throwable th5) {
            QMLog.e("VideoJsPlugin", requestEvent.event + " error.", th5);
            return "{}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoPlayer(int i3, JSONObject jSONObject) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (coverView instanceof CoverVideoView) {
            CoverVideoView coverVideoView = (CoverVideoView) coverView;
            coverVideoView.updateVideoPlayerSettings(jSONObject);
            if (!jSONObject.optBoolean("hide")) {
                coverVideoView.setVisibility(0);
            }
            String optString = jSONObject.optString("src");
            if (StringUtil.isEmpty(optString)) {
                return;
            }
            coverVideoView.setVideoPath(optString);
        }
    }

    public boolean operateVideoPlayer(int i3, String str, String str2) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (!(coverView instanceof CoverVideoView)) {
            return false;
        }
        QMLog.d("VideoJsPlugin", "operateVideoPlayer type: " + str + " data: " + str2);
        if ("play".equals(str)) {
            ((CoverVideoView) coverView).playWithUi();
            return true;
        }
        if ("pause".equals(str)) {
            ((CoverVideoView) coverView).pauseWithUi();
            return true;
        }
        if ("stop".equals(str)) {
            ((CoverVideoView) coverView).stop();
            return true;
        }
        if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(str) && !TextUtils.isEmpty(str2)) {
            return operatePlayerSeek(str2, (CoverVideoView) coverView);
        }
        if ("playbackRate".equals(str) && !TextUtils.isEmpty(str2)) {
            QMLog.e("VideoJsPlugin", "playbackRate is not support.");
            return true;
        }
        if ("requestFullScreen".equals(str)) {
            CoverVideoView coverVideoView = (CoverVideoView) coverView;
            if (!coverVideoView.isFullScreen()) {
                coverVideoView.fullScreen();
            }
            return true;
        }
        if ("exitFullScreen".equals(str)) {
            CoverVideoView coverVideoView2 = (CoverVideoView) coverView;
            if (coverVideoView2.isFullScreen()) {
                coverVideoView2.smallScreen();
            }
            return true;
        }
        if ("sendDanmu".equals(str)) {
            return operatePlayerSendDanmu(str2, (CoverVideoView) coverView);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean insertVideoPlayer(IMiniAppContext iMiniAppContext, IJsService iJsService, int i3, JSONObject jSONObject) {
        if (DebugUtil.isDebugVersion()) {
            QMLog.i("VideoJsPlugin", "insertVideoPlayer: " + jSONObject);
        }
        boolean z16 = false;
        if (iMiniAppContext == null || iMiniAppContext.getAttachActivity() == null) {
            return false;
        }
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        CoverView coverView2 = coverView;
        if (coverView == null) {
            CoverVideoView coverVideoView = new CoverVideoView(attachActivity);
            coverVideoView.setData(jSONObject.optString("data"));
            coverVideoView.setJsService(iJsService);
            coverVideoView.setVideoPlayerId(i3);
            coverVideoView.setParentId(i3);
            this.mCoverViewSparseArray.put(i3, coverVideoView);
            coverView2 = coverVideoView;
        }
        if (coverView2 instanceof CoverVideoView) {
            CoverVideoView coverVideoView2 = (CoverVideoView) coverView2;
            coverVideoView2.setMiniAppContext(iMiniAppContext);
            coverVideoView2.initVideoPlayerSettings(jSONObject);
            z16 = jSONObject.optBoolean("underGameView", false);
            if (jSONObject.optBoolean("hide")) {
                coverVideoView2.setVisibility(8);
            }
        }
        if (z16) {
            this.mUnderGameViewList.add(String.valueOf(i3));
        }
        GameVideoPlayerManager.setUnderGameView(iMiniAppContext, !this.mUnderGameViewList.isEmpty());
        GameVideoPlayerManager.addPlayerView(iMiniAppContext, coverView2, z16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVideoPlayer(int i3) {
        CoverView coverView = this.mCoverViewSparseArray.get(i3);
        if (coverView instanceof CoverVideoView) {
            removeCoverChildView(i3);
            GameVideoPlayerManager.removeView(this.mMiniAppContext, coverView);
            this.mUnderGameViewList.remove(String.valueOf(i3));
            if (this.mUnderGameViewList.isEmpty()) {
                GameVideoPlayerManager.setUnderGameView(this.mMiniAppContext, false);
            }
        }
    }
}
