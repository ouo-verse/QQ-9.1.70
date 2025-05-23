package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterError;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class LivePlayerEmbeddedWidgetClient implements IExtendedEmbeddedWidgetClient {
    private static final String TAG = "miniapp-embedded-live-player";
    public static volatile boolean mIsInited = false;
    private IJsService callBackWebview;
    private int curPageWebviewId;
    private boolean isPageBackground;
    private TXLivePlayerJSAdapter livePlayerJSAdapter;
    private Map<String, String> mAttributes;
    private IMiniAppContext mMiniAppContext;
    private String mTagName;
    private IEmbeddedWidget mWidget;
    private Surface mSurface = null;
    private int width = -1;
    private int height = -1;
    private int viewId = -1;

    public LivePlayerEmbeddedWidgetClient(IMiniAppContext iMiniAppContext, String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        this.mTagName = str;
        this.mAttributes = map;
        this.mWidget = iEmbeddedWidget;
        this.mMiniAppContext = iMiniAppContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateCallbackJs(int i3, String str) {
        IJsService iJsService = this.callBackWebview;
        if (iJsService != null) {
            iJsService.evaluateCallbackJs(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, i3));
        }
        IJsService iJsService = this.callBackWebview;
        if (iJsService != null) {
            iJsService.evaluateSubscribeJS(str, str2, this.curPageWebviewId);
        }
    }

    private TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener getAudioVolumeEvaluationListener() {
        return new TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.1
            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
            public void onAudioVolumeEvaluationNotify(int i3) {
                QMLog.d(LivePlayerEmbeddedWidgetClient.TAG, "onAudioVolumeEvaluationNotify code:" + i3);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("viewId", LivePlayerEmbeddedWidgetClient.this.viewId);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i3);
                    jSONObject.put("info", jSONObject2);
                    LivePlayerEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePlayerJsPlugin.EVENT_ON_XWEB_LIVE_AUDIO_VOLUME, jSONObject.toString(), LivePlayerEmbeddedWidgetClient.this.curPageWebviewId);
                    if (QMLog.isColorLevel()) {
                        QMLog.e(LivePlayerEmbeddedWidgetClient.TAG, "onXWebLivePlayerAudioVolume resultObj.toString() = " + jSONObject.toString());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        };
    }

    private TXLivePlayerJSAdapter.IPlayOuterListener getPlayerListener() {
        return new TXLivePlayerJSAdapter.IPlayOuterListener() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.2
            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener
            public void onNetStatus(Bundle bundle) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("VIDEO_BITRATE", bundle.get("VIDEO_BITRATE"));
                    jSONObject.put("AUDIO_BITRATE", bundle.get("AUDIO_BITRATE"));
                    jSONObject.put("VIDEO_FPS", bundle.get("VIDEO_FPS"));
                    jSONObject.put("VIDEO_GOP", bundle.get("VIDEO_GOP"));
                    jSONObject.put("NET_SPEED", bundle.get("NET_SPEED"));
                    jSONObject.put("NET_JITTER", bundle.get("NET_JITTER"));
                    jSONObject.put("VIDEO_WIDTH", bundle.get("VIDEO_WIDTH"));
                    jSONObject.put("VIDEO_HEIGHT", bundle.get("VIDEO_HEIGHT"));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("viewId", LivePlayerEmbeddedWidgetClient.this.viewId);
                    jSONObject2.put("info", jSONObject);
                    LivePlayerEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePlayerJsPlugin.EVENT_TYPE_NET_STATUS, jSONObject2.toString(), LivePlayerEmbeddedWidgetClient.this.curPageWebviewId);
                    QMLog.e(LivePlayerEmbeddedWidgetClient.TAG, "operate start evaluateSubcribeJS onLivePlayerNetStatus = " + jSONObject2.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }

            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.IPlayOuterListener
            public void onPlayEvent(int i3, Bundle bundle) {
                QMLog.d(LivePlayerEmbeddedWidgetClient.TAG, "onPlayEvent code:" + i3);
                if (2028 == i3) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("viewId", LivePlayerEmbeddedWidgetClient.this.viewId);
                        jSONObject.put("errCode", i3);
                        Object obj = bundle.get("EVT_GET_METADATA");
                        if (obj instanceof HashMap) {
                            jSONObject.put("errMsg", new JSONObject((HashMap) obj));
                        }
                        LivePlayerEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePlayerJsPlugin.EVENT_ON_XWEB_LIVE_METADATA, jSONObject.toString(), LivePlayerEmbeddedWidgetClient.this.curPageWebviewId);
                        QMLog.e(LivePlayerEmbeddedWidgetClient.TAG, "operate start evaluateSubcribeJS onXWebLivePlayerMetadata = " + jSONObject.toString());
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("viewId", LivePlayerEmbeddedWidgetClient.this.viewId);
                    jSONObject2.put("errCode", i3);
                    jSONObject2.put("errMsg", bundle.get("EVT_MSG"));
                    LivePlayerEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePlayerJsPlugin.EVENT_TYPE_PLAYER_EVENT, jSONObject2.toString(), LivePlayerEmbeddedWidgetClient.this.curPageWebviewId);
                    QMLog.e(LivePlayerEmbeddedWidgetClient.TAG, "operate start evaluateSubcribeJS onLivePlayerEvent = " + jSONObject2.toString());
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
        };
    }

    private static void saveJpeg(Bitmap bitmap, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, Math.min(100, 100), bufferedOutputStream2);
                bufferedOutputStream2.flush();
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public boolean enterBackground() {
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJSAdapter;
        if (tXLivePlayerJSAdapter == null) {
            return false;
        }
        TXJSAdapterError enterBackground = tXLivePlayerJSAdapter.enterBackground(2);
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "enterBackground: " + enterBackground);
        }
        if (enterBackground.errorCode != 0) {
            return false;
        }
        return true;
    }

    public boolean enterForeground() {
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJSAdapter;
        if (tXLivePlayerJSAdapter == null) {
            return false;
        }
        TXJSAdapterError enterForeground = tXLivePlayerJSAdapter.enterForeground();
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "enterForeground: " + enterForeground);
        }
        if (enterForeground.errorCode != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public IMiniAppContext getMiniAppContext() {
        return this.mMiniAppContext;
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public int getViewId() {
        return this.viewId;
    }

    public void handleInsertXWebLivePlayer(JSONObject jSONObject, IJsService iJsService) {
        this.callBackWebview = iJsService;
        if (iJsService instanceof BrandPageWebview) {
            this.curPageWebviewId = ((BrandPageWebview) iJsService).getWebViewId();
        } else if (iJsService instanceof MiniWebView) {
            this.curPageWebviewId = ((MiniWebView) iJsService).J();
        } else {
            QMLog.e(TAG, "cant get webviewId from " + iJsService);
        }
        if (jSONObject != null) {
            QMLog.d(TAG, "handleInsertXWebLivePlayer : " + jSONObject.toString());
            this.viewId = jSONObject.optInt("viewId");
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
                this.height = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
            }
            QMLog.d(TAG, "handleInsertXWebLivePlayer : initLivePlayer");
            TXLivePlayerJSAdapter tXLivePlayerJSAdapter = new TXLivePlayerJSAdapter(AppLoaderFactory.g().getContext());
            this.livePlayerJSAdapter = tXLivePlayerJSAdapter;
            tXLivePlayerJSAdapter.initEmbeddedLivePlayer(jSONObject);
            this.livePlayerJSAdapter.setPlayListener(getPlayerListener());
            this.livePlayerJSAdapter.setItxAudioVolumeEvaluationOuterListener(getAudioVolumeEvaluationListener());
            this.livePlayerJSAdapter.setSurface(this.mSurface);
            this.livePlayerJSAdapter.setSurfaceSize(this.width, this.height);
        }
    }

    public void handleOperateXWebLivePlayer(JSONObject jSONObject, int i3) {
        boolean z16;
        QMLog.d(TAG, "handleOperateXWebLivePlayer : " + jSONObject.toString());
        if (jSONObject.optInt("viewId", -1) == this.viewId && jSONObject.has("type")) {
            String optString = jSONObject.optString("type");
            if ("snapshot".equalsIgnoreCase(optString)) {
                String optString2 = jSONObject.optString(CustomImageProps.QUALITY);
                if (optString2 != null && optString2.equalsIgnoreCase("compressed")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                takePhoto("operateXWebLivePlayer", z16, i3);
                return;
            }
            this.livePlayerJSAdapter.operateLivePlayer(optString, jSONObject);
            evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePlayer", new JSONObject()).toString());
        }
    }

    public void handleRemoveXWebLivePlayer() {
        release();
    }

    public void handleUpdateXWebLivePlayer(JSONObject jSONObject) {
        if (jSONObject != null) {
            QMLog.d(TAG, "handleUpdateXWebLivePlayer : " + jSONObject.toString());
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
                int density = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
                this.height = density;
                this.livePlayerJSAdapter.setSurfaceSize(this.width, density);
            }
            TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJSAdapter;
            if (tXLivePlayerJSAdapter != null) {
                tXLivePlayerJSAdapter.updateLivePlayer(jSONObject);
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeDestroy() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.nativeDestroy " + this);
        release();
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativePause() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.nativePause " + this);
        if (!this.isPageBackground) {
            this.isPageBackground = enterBackground();
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeResume() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.nativeResume " + this);
        if (this.isPageBackground) {
            this.isPageBackground = !enterForeground();
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onActive() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onActive");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDeactive() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onDeactive");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDestroy() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onDestroy");
        release();
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRectChanged(Rect rect) {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onRectChanged, rect:" + rect.toString() + "\uff1b size : " + (rect.right - rect.left) + "," + (rect.bottom - rect.top));
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRequestRedraw() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onRequestRedraw");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceCreated(Surface surface) {
        Boolean bool;
        QMLog.d(TAG, "onSurfaceCreated: " + surface);
        if (surface != null && surface.isValid()) {
            this.mSurface = surface;
            TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJSAdapter;
            if (tXLivePlayerJSAdapter != null) {
                tXLivePlayerJSAdapter.setSurface(surface);
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSurfaceCreated isValid() : ");
        if (surface != null) {
            bool = Boolean.valueOf(surface.isValid());
        } else {
            bool = null;
        }
        sb5.append(bool);
        QMLog.e(TAG, sb5.toString());
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceDestroyed(Surface surface) {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onSurfaceDestroyed");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public boolean onTouchEvent(MotionEvent motionEvent) {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onTouchEvent, rect:" + motionEvent.toString());
        return false;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onVisibilityChanged(boolean z16) {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.onVisibilityChanged \uff1a " + z16);
    }

    public void release() {
        TXLivePlayerJSAdapter tXLivePlayerJSAdapter = this.livePlayerJSAdapter;
        if (tXLivePlayerJSAdapter != null) {
            tXLivePlayerJSAdapter.uninitLivePlayer();
            this.livePlayerJSAdapter.setSurface(null);
        }
    }

    public void takePhoto(final String str, boolean z16, final int i3) {
        if (this.livePlayerJSAdapter == null) {
            return;
        }
        QMLog.e(TAG, "takePhoto invoke");
        this.livePlayerJSAdapter.setSnapshotListener(new TXLivePlayerJSAdapter.ISnapshotOuterListener() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.3
            @Override // com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ISnapshotOuterListener
            public void onSnapshot(final Bitmap bitmap) {
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z17;
                        try {
                            String tmpPath = ((MiniAppFileManager) LivePlayerEmbeddedWidgetClient.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg");
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("takePhoto - path\uff1a");
                            sb5.append(tmpPath);
                            sb5.append(" bitmap = ");
                            if (bitmap != null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            sb5.append(z17);
                            QMLog.e(LivePlayerEmbeddedWidgetClient.TAG, sb5.toString());
                            File file = new File(tmpPath);
                            ImageUtil.saveBitmapToFile(bitmap, file);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tempImagePath", file.getAbsolutePath());
                            jSONObject.put("width", bitmap.getWidth());
                            jSONObject.put("height", bitmap.getHeight());
                            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            LivePlayerEmbeddedWidgetClient.this.evaluateCallbackJs(i3, wrapCallbackOk.toString());
                            QMLog.e(LivePlayerEmbeddedWidgetClient.TAG, "takePhoto - evaluateCallbackJs\uff1a" + wrapCallbackOk.toString());
                        } catch (Exception unused) {
                            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, new JSONObject());
                            AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                            LivePlayerEmbeddedWidgetClient.this.evaluateCallbackJs(i3, wrapCallbackFail.toString());
                        }
                    }
                });
            }
        });
        this.livePlayerJSAdapter.takePhoto(z16);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewDestroy() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.webViewDestroy " + this);
        release();
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewPause() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.webviewPause " + this);
        if (!this.isPageBackground) {
            this.isPageBackground = enterBackground();
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewResume() {
        QMLog.i(TAG, "LivePlayerEmbeddedWidgetClient.webviewResume " + this);
        if (this.isPageBackground) {
            this.isPageBackground = !enterForeground();
        }
    }
}
