package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.util.EmbeddedHelper;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.miniapp.widget.camera.CameraCallBack;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class MediaJsPlugin extends BaseJsPlugin {
    private static final String EVENT_INSERT_CAMERA = "insertCamera";
    private static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
    public static final String EVENT_OPERATE_CAMERA = "operateCamera";
    private static final String EVENT_OPERATE_VIDEO_PLAYER = "operateVideoPlayer";
    public static final String EVENT_REMOVE_CAMERA = "removeCamera";
    private static final String EVENT_REMOVE_VIDEOPLAYER = "removeVideoPlayer";
    public static final String EVENT_UPDATE_CAMERA = "updateCamera";
    private static final String EVENT_UPDATE_VIDEO_PLAYER = "updateVideoPlayer";
    public static final String TAG = "MediaJsPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleSeek(CoverVideoView coverVideoView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 1) {
                return false;
            }
            return coverVideoView.seekTo((int) (jSONArray.getDouble(0) * 1000.0d));
        } catch (Exception unused) {
            QMLog.e("MediaJsPlugin", "wrong seek pram. " + str);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendDanmu(CoverVideoView coverVideoView, String str, RequestEvent requestEvent, String str2, int i3) {
        String str3;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i16 = 0;
            if (jSONArray.length() == 2) {
                str3 = jSONArray.getString(0);
                i16 = ColorUtils.parseColor(jSONArray.getString(1));
            } else if (jSONArray.length() == 1) {
                str3 = jSONArray.getString(0);
            } else {
                str3 = null;
            }
            coverVideoView.playDanmu(str3, i16);
        } catch (Exception e16) {
            QMLog.e("MediaJsPlugin", "sendDanmu error." + e16);
            callbackJsEventFail(requestEvent, str2, null, i3);
        }
    }

    public void callbackJsEventFail(RequestEvent requestEvent, String str, JSONObject jSONObject, int i3) {
        requestEvent.jsService.evaluateCallbackJs(i3, ApiUtil.wrapCallbackFail(str, jSONObject).toString());
    }

    public void callbackJsEventOK(RequestEvent requestEvent, String str, JSONObject jSONObject, int i3) {
        requestEvent.jsService.evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk(str, jSONObject).toString());
    }

    @JsEvent({"insertCamera"})
    public void insertCamera(final RequestEvent requestEvent) {
        final String str;
        String str2 = "auto";
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("cameraId");
            final int optInt2 = jSONObject.optInt("parentId");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            String optString = jSONObject.optString("flash");
            final String optString2 = jSONObject.optString("devicePosition");
            if (optString.equals("on")) {
                str = "on";
            } else {
                if (!optString.equals("auto")) {
                    str2 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                }
                str = str2;
            }
            final boolean optBoolean = jSONObject.optBoolean(QCircleDaTongConstant.ElementParamValue.FIXED, false);
            final String optString3 = jSONObject.optString("mode");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.5
                @Override // java.lang.Runnable
                public void run() {
                    MediaJsPlugin.this.insertCamera(requestEvent, optInt, optInt2, optString2, optJSONObject.optInt("left"), optJSONObject.optInt("top"), optJSONObject.optInt("width"), optJSONObject.optInt("height"), new CameraCallBack() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.5.1
                        @Override // com.tencent.qqmini.miniapp.widget.camera.CameraCallBack
                        public void onStartPreview(boolean z16) {
                            if (z16) {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                requestEvent.ok(jSONObject2);
                            } else {
                                requestEvent.fail();
                            }
                        }
                    }, str, optBoolean, optString3);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("MediaJsPlugin", requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"insertVideoPlayer"})
    public void insertVideoPlayer(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("videoPlayerId");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    int pageId;
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (coverView == null) {
                        Activity attachActivity = ((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext.getAttachActivity();
                        if (attachActivity == null) {
                            QMLog.e("MediaJsPlugin", "insertVideoPlayer activity is null error!");
                            requestEvent.fail();
                            return;
                        }
                        CoverVideoView coverVideoView = new CoverVideoView(attachActivity);
                        coverVideoView.setData(jSONObject.optString("data"));
                        coverVideoView.setJsService(requestEvent.jsService);
                        if (((BaseJsPlugin) MediaJsPlugin.this).mIsContainer) {
                            pageId = requestEvent.webViewId;
                        } else {
                            pageId = PageAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext).getPageId();
                        }
                        coverVideoView.setPageWebViewId(pageId);
                        coverVideoView.setVideoPlayerId(optInt);
                        CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).add(0, optInt, coverVideoView);
                        ((ObserverManager) ((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext.getManager(ObserverManager.class)).addObserver(coverVideoView.getVideoPlayerStatusObserver());
                        coverView = coverVideoView;
                    }
                    if (coverView instanceof CoverVideoView) {
                        CoverVideoView coverVideoView2 = (CoverVideoView) coverView;
                        coverVideoView2.setMiniAppContext(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext);
                        coverVideoView2.initVideoPlayerSettings(jSONObject);
                    }
                    requestEvent.ok(jSONObject2);
                }
            });
        } catch (Exception e16) {
            QMLog.e("MediaJsPlugin", requestEvent.event + " error.", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        if ("insertVideoPlayer".equals(requestEvent.event)) {
            EmbeddedHelper.checkEmbeddedWidgetSupport(requestEvent, this.mMiniAppContext.getMiniAppInfo().appId, this.mMiniAppContext.getAttachActivity());
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"operateCamera"})
    public void operateCamera(RequestEvent requestEvent) {
        QMLog.d("MediaJsPlugin", requestEvent.jsonParams);
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).get(jSONObject.optInt("cameraId"));
            if (!(coverView instanceof CoverCameraView)) {
                requestEvent.fail();
                return;
            }
            String optString = jSONObject.optString("type");
            if ("takePhoto".equals(optString)) {
                ((CoverCameraView) coverView).takePhoto(requestEvent, jSONObject.optString(CustomImageProps.QUALITY));
            } else if ("startRecord".equals(optString)) {
                ((CoverCameraView) coverView).startRecord(requestEvent);
            } else if ("stopRecord".equals(optString)) {
                ((CoverCameraView) coverView).stopRecord(requestEvent);
            }
        } catch (JSONException e16) {
            QMLog.e("MediaJsPlugin", "operateCamera error!", e16);
        }
    }

    @JsEvent({"operateVideoPlayer"})
    public void operateVideoPlayer(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("type");
            final int optInt = jSONObject.optInt("videoPlayerId");
            final String optString2 = jSONObject.optString("data");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (!(coverView instanceof CoverVideoView)) {
                        QMLog.e("MediaJsPlugin", "videoPlayer is not CoverVideoView type!");
                        requestEvent.fail();
                        return;
                    }
                    if ("play".equals(optString)) {
                        z16 = ((CoverVideoView) coverView).playWithUi();
                    } else if ("pause".equals(optString)) {
                        z16 = ((CoverVideoView) coverView).pauseWithUi();
                    } else {
                        if ("stop".equals(optString)) {
                            ((CoverVideoView) coverView).stop();
                        } else if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(optString)) {
                            if (!MediaJsPlugin.this.handleSeek((CoverVideoView) coverView, optString2)) {
                                MediaJsPlugin.this.callbackJsEventFail(requestEvent, optString, null, optInt);
                                return;
                            }
                        } else if ("playbackRate".equals(optString) && !TextUtils.isEmpty(optString2)) {
                            QMLog.e("MediaJsPlugin", "playbackRate is not support.");
                        } else if ("requestFullScreen".equals(optString)) {
                            ((CoverVideoView) coverView).fullScreen();
                        } else if ("exitFullScreen".equals(optString)) {
                            ((CoverVideoView) coverView).smallScreen();
                        } else if ("sendDanmu".equals(optString)) {
                            MediaJsPlugin.this.handleSendDanmu((CoverVideoView) coverView, optString2, requestEvent, optString, optInt);
                        }
                        z16 = false;
                    }
                    QMLog.d("MediaJsPlugin", "operateVideoPlayer type\uff1a" + optString + " data:" + optString2 + " isPlaying:" + z16);
                    MediaJsPlugin.this.callbackJsEventOK(requestEvent, optString, null, optInt);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("MediaJsPlugin", "operateVideoPlayer error!", e16);
        }
    }

    @JsEvent({"removeCamera"})
    public void removeCamera(final RequestEvent requestEvent) {
        QMLog.d("MediaJsPlugin", requestEvent.jsonParams);
        try {
            final int optInt = new JSONObject(requestEvent.jsonParams).optInt("cameraId");
            final CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).get(optInt);
            if (!(coverView instanceof CoverCameraView)) {
                requestEvent.fail();
            } else {
                ((CoverCameraView) coverView).closeCamera();
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.6
                    @Override // java.lang.Runnable
                    public void run() {
                        int parentId = ((CoverCameraView) coverView).getParentId();
                        if (parentId == 0) {
                            CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(optInt);
                        } else {
                            CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(parentId);
                        }
                        requestEvent.ok();
                    }
                });
            }
        } catch (JSONException e16) {
            QMLog.e("MediaJsPlugin", "removeCamera error!", e16);
        }
    }

    @JsEvent({"removeVideoPlayer"})
    public void removeVideoPlayer(final RequestEvent requestEvent) {
        try {
            final int optInt = new JSONObject(requestEvent.jsonParams).optInt("videoPlayerId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (coverView instanceof CoverVideoView) {
                        ((ObserverManager) ((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext.getManager(ObserverManager.class)).deleteObserver(((CoverVideoView) coverView).getVideoPlayerStatusObserver());
                        CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(optInt);
                        requestEvent.ok();
                    } else {
                        QMLog.e("MediaJsPlugin", "removeVideoPlayer error!");
                        requestEvent.fail();
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e("MediaJsPlugin", requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"updateCamera"})
    public void updateCamera(RequestEvent requestEvent) {
        String str = "auto";
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).get(jSONObject.optInt("cameraId"));
            if (!(coverView instanceof CoverCameraView)) {
                requestEvent.fail();
                return;
            }
            String optString = jSONObject.optString("devicePosition");
            String optString2 = jSONObject.optString("flash");
            if (optString2.equals("on")) {
                str = "on";
            } else if (!optString2.equals("auto")) {
                str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            if ("front".equalsIgnoreCase(optString)) {
                ((CoverCameraView) coverView).switchCamera(false, str);
            } else if ("back".equalsIgnoreCase(optString)) {
                ((CoverCameraView) coverView).switchCamera(true, str);
            }
        } catch (JSONException e16) {
            QMLog.e("MediaJsPlugin", "updateCamera error!", e16);
        }
    }

    @JsEvent({"updateVideoPlayer"})
    public void updateVideoPlayer(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("videoPlayerId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) MediaJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (!(coverView instanceof CoverVideoView)) {
                        QMLog.e("MediaJsPlugin", requestEvent.event + "videoPlayer is not a CoverVideoView!");
                        requestEvent.fail();
                        return;
                    }
                    CoverVideoView coverVideoView = (CoverVideoView) coverView;
                    if (coverVideoView.isPageBackground()) {
                        QMLog.e("MediaJsPlugin", requestEvent.event + " videoPlayer is in PageBackground!");
                        requestEvent.fail();
                        return;
                    }
                    coverVideoView.updateVideoPlayerSettings(jSONObject);
                    String optString = jSONObject.optString("filePath");
                    if (!StringUtil.isEmpty(optString)) {
                        coverVideoView.setVideoPath(optString);
                    }
                    requestEvent.ok();
                }
            });
        } catch (Throwable th5) {
            QMLog.e("MediaJsPlugin", requestEvent.event + " error.", th5);
        }
    }

    public void insertCamera(RequestEvent requestEvent, int i3, int i16, String str, int i17, int i18, int i19, int i26, CameraCallBack cameraCallBack, String str2, boolean z16, String str3) {
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).get(i3);
        CoverView coverView2 = coverView;
        if (coverView == null) {
            CoverCameraView coverCameraView = new CoverCameraView(this.mMiniAppContext, requestEvent.jsService);
            coverCameraView.setParentId(i16);
            coverCameraView.setFixed(z16);
            coverCameraView.setCameraId(i3);
            coverCameraView.setWebviewId(this.mIsContainer ? requestEvent.webViewId : PageAction.obtain(this.mMiniAppContext).getPageId());
            CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).add(i16, i3, coverCameraView, z16);
            coverView2 = coverCameraView;
        }
        float density = DisplayUtil.getDensity(this.mMiniAppContext.getContext());
        if (coverView2 instanceof CoverCameraView) {
            CoverCameraView coverCameraView2 = (CoverCameraView) coverView2;
            coverCameraView2.setMode(str3);
            coverCameraView2.setFlashMode(str2);
            coverCameraView2.setCameraSurfaceCallBack(cameraCallBack);
            coverCameraView2.openCamera(str);
            int i27 = (int) ((i19 * density) + 0.5f);
            int i28 = (int) ((i26 * density) + 0.5f);
            coverCameraView2.setCameraWidth(i27);
            coverCameraView2.setCameraHeight(i28);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i27, i28);
            layoutParams.leftMargin = (int) ((i17 * density) + 0.5f);
            layoutParams.topMargin = (int) ((density * i18) + 0.5f);
            coverCameraView2.setLayoutParams(layoutParams);
        }
    }
}
