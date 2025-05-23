package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class LivePusherEmbeddedWidgetClient implements IExtendedEmbeddedWidgetClient {
    private static final String TAG = "miniapp-embedded-live-pusher";
    public static volatile boolean mIsInited = false;
    private IJsService callBackWebview;
    private int curPageWebviewId;
    private TXLivePusherJSAdapter livePusherJSAdapter;
    private Map<String, String> mAttributes;
    private IMiniAppContext mMiniAppContext;
    private String mTagName;
    private IEmbeddedWidget mWidget;
    private Surface mSurface = null;
    private int width = -1;
    private int height = -1;
    private int viewId = -1;
    private Handler handler = new Handler(Looper.getMainLooper());
    private String tempAudioFilePath = null;
    private Runnable stopDumpRunnable = new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.1
        @Override // java.lang.Runnable
        public void run() {
            QMLog.d(LivePusherEmbeddedWidgetClient.TAG, "stopDumpAudio at maxDuration");
            LivePusherEmbeddedWidgetClient.this.livePusherJSAdapter.stopDumpAudioData();
        }
    };
    private AtomicInteger downloadTaskId = new AtomicInteger(0);
    private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap<>();
    private boolean needToStopDownloadBGM = false;

    public LivePusherEmbeddedWidgetClient(IMiniAppContext iMiniAppContext, String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        this.mTagName = str;
        this.mAttributes = map;
        this.mWidget = iEmbeddedWidget;
        this.mMiniAppContext = iMiniAppContext;
    }

    private File copyFile(String str, String str2) {
        Throwable th5;
        File file;
        File file2;
        File file3 = new File(str2);
        if (!file3.exists() && !TextUtils.isEmpty(str)) {
            QMLog.e(TAG, "file no exists, try to copy again.");
            try {
                file2 = new File(str);
            } catch (Throwable th6) {
                th5 = th6;
                file = file3;
            }
            if (file2.exists() && file2.isFile() && file2.length() > 0) {
                QMLog.w(TAG, "download Succeed but target file not exists, try copy from download tmp file:" + str + ", length:" + file2.length() + ", to:" + str2);
                file = FileUtils.createFile(str2);
                try {
                    if (FileUtils.copyFile(file2, file) && file.exists() && file.length() == file2.length()) {
                        QMLog.d(TAG, "copy from download tmp file:" + str + " success");
                    } else if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    QMLog.e(TAG, "try copy from download tmp file exception! tmp file:" + str, th5);
                    return file;
                }
                return file;
            }
            return file3;
        }
        return file3;
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
            iJsService.evaluateSubscribeJS(str, str2, i3);
        }
    }

    private DownloaderProxy.DownloadListener getBGMDownloadListener(final JSONObject jSONObject, final int i3, final String str, final String str2, final String str3, final String str4, final DownloaderProxy downloaderProxy) {
        return new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i16, String str5) {
                LivePusherEmbeddedWidgetClient.this.handleBGMDownloadFailed(str5, str2, str3, i3);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
                if (LivePusherEmbeddedWidgetClient.this.needToStopDownloadBGM) {
                    QMLog.d(LivePusherEmbeddedWidgetClient.TAG, "playBGM - download onDownloadProgress, abort");
                    downloaderProxy.abort(str3);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i16, String str5, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                LivePusherEmbeddedWidgetClient.this.handleBGMDownloadSuc(i16, str5, str4, str2, jSONObject, str);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i16, Map<String, List<String>> map) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBGMDownloadFailed(String str, String str2, String str3, int i3) {
        this.downloadMap.remove(str2, str3);
        QMLog.e(TAG, "playBGM - download onDownloadFailed failed:" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewId", i3);
            jSONObject.put("errMsg", str);
            jSONObject.put("errCode", 10003);
            evaluateSubscribeJS(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_ERR, jSONObject.toString(), this.curPageWebviewId);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBGMDownloadSuc(int i3, String str, String str2, String str3, JSONObject jSONObject, String str4) {
        try {
            QMLog.e(TAG, "playBGM - download onDownloadSucceed statusCode:" + i3);
            if (this.needToStopDownloadBGM) {
                QMLog.e(TAG, "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                File copyFile = copyFile(str, str2);
                this.downloadMap.remove(str3);
                if (copyFile.exists() && copyFile.canRead()) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d(TAG, "download success bgmFilePath:" + str2);
                    }
                    jSONObject.put("BGMFilePath", str2);
                    this.livePusherJSAdapter.operateLivePusher(str4, jSONObject);
                    return;
                }
                QMLog.d(TAG, "download failed, filepath not exists, tmpFile:" + str);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handlePlayBGMEvent(JSONObject jSONObject, int i3, int i16, String str) {
        this.needToStopDownloadBGM = false;
        String valueOf = String.valueOf(this.downloadTaskId.getAndIncrement());
        String optString = jSONObject.optString("url");
        this.downloadMap.put(valueOf, optString);
        String tmpPathByUrl = MiniAppFileManager.getInstance().getTmpPathByUrl(optString);
        DownloaderProxy downloaderProxy = (DownloaderProxy) ProxyManager.get(DownloaderProxy.class);
        downloaderProxy.download(optString, null, tmpPathByUrl, 60, getBGMDownloadListener(jSONObject, i16, str, valueOf, optString, tmpPathByUrl, downloaderProxy));
        evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
    }

    private void handleSetBGMPosition(JSONObject jSONObject, int i3, String str) {
        try {
            jSONObject.put("BGMPosition", jSONObject.getInt("position") * 1000);
            this.livePusherJSAdapter.operateLivePusher(str, jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "setBGMPosition - JSONException:" + e16);
        }
        evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
    }

    private void handleSnapShotEvent(JSONObject jSONObject, int i3) {
        boolean z16;
        String optString;
        if (jSONObject != null && (optString = jSONObject.optString(CustomImageProps.QUALITY)) != null && optString.equalsIgnoreCase("compressed")) {
            z16 = true;
        } else {
            z16 = false;
        }
        takePhoto("operateXWebLivePusher", z16, i3);
    }

    private void handleStartAudioRecord(JSONObject jSONObject, int i3) {
        String tmpPath = MiniAppFileManager.getInstance().getTmpPath("pcm");
        long optLong = jSONObject.optLong("maxDuration");
        QMLog.d(TAG, "recordFile:" + tmpPath);
        int startDumpAudioData = this.livePusherJSAdapter.startDumpAudioData(tmpPath);
        QMLog.d(TAG, "recordResult:" + startDumpAudioData);
        if (startDumpAudioData == 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                tmpPath = MiniAppFileManager.getInstance().getWxFilePath(tmpPath);
                QMLog.d(TAG, "recordFile transformed:" + tmpPath);
                jSONObject2.put("tempFilePath", tmpPath);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.tempAudioFilePath = tmpPath;
            evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePusher", jSONObject2).toString());
            this.handler.postDelayed(this.stopDumpRunnable, optLong);
        } else if (startDumpAudioData == -1) {
            evaluateCallbackJs(i3, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher is recording").toString());
            return;
        } else if (startDumpAudioData == -2) {
            evaluateCallbackJs(i3, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher creates recordFile failed").toString());
        } else if (startDumpAudioData == -3) {
            evaluateCallbackJs(i3, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher not support current format").toString());
        } else {
            evaluateCallbackJs(i3, ApiUtil.wrapCallbackFail("operateXWebLivePusher", null, "LivePusher starts recording fail").toString());
        }
        QMLog.d(TAG, "recordResult:" + startDumpAudioData);
    }

    private void handleStopAudioRecord(int i3) {
        QMLog.d(TAG, "stopDumpAudioData");
        this.handler.removeCallbacks(this.stopDumpRunnable);
        this.livePusherJSAdapter.stopDumpAudioData();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!StringUtil.isEmpty(this.tempAudioFilePath)) {
                jSONObject.put("tempFilePath", this.tempAudioFilePath);
                this.tempAudioFilePath = null;
            } else {
                jSONObject.put("tempFilePath", "");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePusher", jSONObject).toString());
    }

    private void handleStopBGMEvent(JSONObject jSONObject, int i3, String str) {
        this.needToStopDownloadBGM = true;
        this.livePusherJSAdapter.operateLivePusher(str, jSONObject);
        evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveJpeg(Bitmap bitmap, File file) throws IOException {
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
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "enterBackground");
        }
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter != null) {
            tXLivePusherJSAdapter.enterBackground(false);
            return true;
        }
        return true;
    }

    public boolean enterForeground() {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "enterForeground");
        }
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter != null) {
            tXLivePusherJSAdapter.enterForeground();
            return true;
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

    public void handleInsertXWebLivePusher(JSONObject jSONObject, IJsService iJsService) {
        this.callBackWebview = iJsService;
        if (iJsService instanceof BrandPageWebview) {
            this.curPageWebviewId = ((BrandPageWebview) iJsService).getWebViewId();
        } else if (iJsService instanceof MiniWebView) {
            this.curPageWebviewId = ((MiniWebView) iJsService).J();
        } else {
            QMLog.e(TAG, "cant get webviewId from " + iJsService);
        }
        if (jSONObject != null) {
            QMLog.d(TAG, "handleInsertXWebLivePusher : " + jSONObject.toString());
            this.viewId = jSONObject.optInt("viewId");
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
                this.height = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
            }
            TXLivePusherJSAdapter tXLivePusherJSAdapter = new TXLivePusherJSAdapter(AppLoaderFactory.g().getContext());
            this.livePusherJSAdapter = tXLivePusherJSAdapter;
            tXLivePusherJSAdapter.setSurface(this.mSurface);
            this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
            this.livePusherJSAdapter.initEmbeddedLivePusher(jSONObject);
            this.livePusherJSAdapter.setBGMNotifyListener(new TXLivePushListenerReflect.OnBGMNotify() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.2
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
                public void onBGMComplete(int i3) {
                    QMLog.d(LivePusherEmbeddedWidgetClient.TAG, "onBGMComplete, errCode:" + i3);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("viewId", LivePusherEmbeddedWidgetClient.this.viewId);
                        jSONObject2.put("errCode", i3);
                        LivePusherEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_BGM_COMPLETE, jSONObject2.toString(), LivePusherEmbeddedWidgetClient.this.curPageWebviewId);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
                public void onBGMProgress(long j3, long j16) {
                    QMLog.e(LivePusherEmbeddedWidgetClient.TAG, "onBGMProgress progress:" + j3 + ",duration:" + j16);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("viewId", LivePusherEmbeddedWidgetClient.this.viewId);
                        jSONObject2.put("progress", j3);
                        jSONObject2.put("duration", j16);
                        LivePusherEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_BGM_PROGRESS, jSONObject2.toString(), LivePusherEmbeddedWidgetClient.this.curPageWebviewId);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
                public void onBGMStart() {
                    QMLog.e(LivePusherEmbeddedWidgetClient.TAG, "onBGMStart");
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("viewId", LivePusherEmbeddedWidgetClient.this.viewId);
                        LivePusherEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_BGM_START, jSONObject2.toString(), LivePusherEmbeddedWidgetClient.this.curPageWebviewId);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            });
            this.livePusherJSAdapter.setPushListener(new TXLivePushListenerReflect.ITXLivePushListener() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener
                public void onNetStatus(Bundle bundle) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject2.put("info", jSONObject3);
                        jSONObject3.put("CPU_USAGE", bundle.getString("CPU_USAGE"));
                        jSONObject3.put("VIDEO_WIDTH", bundle.getInt("VIDEO_WIDTH"));
                        jSONObject3.put("VIDEO_HEIGHT", bundle.getInt("VIDEO_HEIGHT"));
                        jSONObject3.put("NET_SPEED", bundle.getInt("NET_SPEED"));
                        jSONObject3.put("NET_JITTER", bundle.getInt("NET_JITTER"));
                        jSONObject3.put("VIDEO_FPS", bundle.getInt("VIDEO_FPS"));
                        jSONObject3.put("VIDEO_GOP", bundle.getInt("VIDEO_GOP"));
                        jSONObject3.put("AUDIO_BITRATE", bundle.getInt("AUDIO_BITRATE"));
                        jSONObject3.put("AUDIO_CACHE", bundle.getInt("AUDIO_CACHE"));
                        jSONObject3.put("VIDEO_CACHE", bundle.getInt("VIDEO_CACHE"));
                        jSONObject3.put("V_SUM_CACHE_SIZE", bundle.getInt("V_SUM_CACHE_SIZE"));
                        jSONObject3.put("V_DEC_CACHE_SIZE", bundle.getInt("V_DEC_CACHE_SIZE"));
                        jSONObject3.put("AV_RECV_INTERVAL", bundle.getInt("AV_RECV_INTERVAL"));
                        jSONObject3.put("AV_PLAY_INTERVAL", bundle.getInt("AV_PLAY_INTERVAL"));
                        jSONObject3.put("AUDIO_CACHE_THRESHOLD", String.format("%.1f", Float.valueOf(bundle.getFloat("AUDIO_CACHE_THRESHOLD"))));
                        jSONObject3.put("VIDEO_BITRATE", bundle.getInt("VIDEO_BITRATE"));
                        jSONObject3.put("AUDIO_DROP", bundle.getInt("AUDIO_DROP"));
                        jSONObject3.put("VIDEO_DROP", bundle.getInt("VIDEO_DROP"));
                        jSONObject3.put("SERVER_IP", bundle.getString("SERVER_IP"));
                        jSONObject3.put("AUDIO_PLAY_INFO", bundle.getString("AUDIO_PLAY_INFO"));
                    } catch (JSONException e16) {
                        e = e16;
                    }
                    try {
                        LivePusherEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_NET_STATUS, jSONObject2.toString(), LivePusherEmbeddedWidgetClient.this.curPageWebviewId);
                    } catch (JSONException e17) {
                        e = e17;
                        e.printStackTrace();
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener
                public void onPushEvent(int i3, Bundle bundle) {
                    QMLog.e(LivePusherEmbeddedWidgetClient.TAG, "onPushEvent i:" + i3);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("viewId", LivePusherEmbeddedWidgetClient.this.viewId);
                        jSONObject2.put("errCode", i3);
                        if (bundle != null) {
                            jSONObject2.put("errMsg", bundle.getString("EVT_MSG"));
                        }
                        LivePusherEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedLivePusherJsPlugin.EVENT_ON_XWEB_LIVE_PUSHER_EVENT, jSONObject2.toString(), LivePusherEmbeddedWidgetClient.this.curPageWebviewId);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
        TXLivePusherJSAdapter tXLivePusherJSAdapter2 = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter2 != null) {
            tXLivePusherJSAdapter2.updateHomeOrientation(this.mMiniAppContext);
        }
    }

    public void handleOperateXWebLivePusher(JSONObject jSONObject, int i3) {
        QMLog.d(TAG, "handleOperateXWebLivePusher : " + jSONObject.toString());
        int optInt = jSONObject.optInt("viewId", -1);
        if (optInt == this.viewId && jSONObject.has("type")) {
            String optString = jSONObject.optString("type");
            if (this.livePusherJSAdapter != null) {
                if (com.tencent.luggage.wxa.c8.c.f123373g0.equals(optString)) {
                    handlePlayBGMEvent(jSONObject, i3, optInt, optString);
                    return;
                }
                if ("stopBGM".equals(optString)) {
                    handleStopBGMEvent(jSONObject, i3, optString);
                    return;
                }
                if ("setBGMPosition".equals(optString)) {
                    handleSetBGMPosition(jSONObject, i3, optString);
                    return;
                }
                if ("snapshot".equals(optString)) {
                    handleSnapShotEvent(jSONObject, i3);
                    return;
                }
                if (optString.equalsIgnoreCase("startAudioRecord")) {
                    handleStartAudioRecord(jSONObject, i3);
                } else if (optString.equalsIgnoreCase("stopAudioRecord")) {
                    handleStopAudioRecord(i3);
                } else {
                    this.livePusherJSAdapter.operateLivePusher(optString, jSONObject);
                    evaluateCallbackJs(i3, ApiUtil.wrapCallbackOk("operateXWebLivePusher", null).toString());
                }
            }
        }
    }

    public void handleRemoveXWebLivePusher() {
        release();
    }

    public void handleUpdateXWebLivePusher(JSONObject jSONObject) {
        if (jSONObject != null) {
            QMLog.d(TAG, "handleUpdateXWebLivePusher : " + jSONObject.toString());
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
                int density = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
                this.height = density;
                this.livePusherJSAdapter.setSurfaceSize(this.width, density);
            }
            TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
            if (tXLivePusherJSAdapter != null) {
                tXLivePusherJSAdapter.updateLivePusher(jSONObject);
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeDestroy() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.nativeDestroy " + this);
        release();
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativePause() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.nativePause " + this);
        enterBackground();
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeResume() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.nativeResume " + this);
        enterForeground();
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onActive() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onActive");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDeactive() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onDeactive");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDestroy() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onDestroy");
        release();
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRectChanged(Rect rect) {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onRectChanged, rect:" + rect.toString() + "\uff1b size : " + (rect.right - rect.left) + "," + (rect.bottom - rect.top));
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRequestRedraw() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onRequestRedraw");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceCreated(Surface surface) {
        Boolean bool;
        QMLog.d(TAG, "onSurfaceCreated: " + surface);
        if (surface != null && surface.isValid()) {
            this.mSurface = surface;
            TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
            if (tXLivePusherJSAdapter != null) {
                tXLivePusherJSAdapter.setSurface(surface);
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
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onSurfaceDestroyed");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public boolean onTouchEvent(MotionEvent motionEvent) {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onTouchEvent, rect:" + motionEvent.toString());
        return false;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onVisibilityChanged(boolean z16) {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.onVisibilityChanged \uff1a " + z16);
    }

    public void release() {
        this.handler.removeCallbacks(this.stopDumpRunnable);
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter != null) {
            tXLivePusherJSAdapter.unInitLivePusher();
            this.livePusherJSAdapter.setSurface(null);
        }
    }

    public void takePhoto(final String str, boolean z16, final int i3) {
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter == null) {
            return;
        }
        tXLivePusherJSAdapter.takePhoto(z16, new TXLivePushListenerReflect.ITXSnapshotListener() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener
            public void onSnapshot(final Bitmap bitmap) {
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            File file = new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
                            file.getParentFile().mkdirs();
                            LivePusherEmbeddedWidgetClient.saveJpeg(bitmap, file);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tempImagePath", file.getAbsolutePath());
                            jSONObject.put("width", bitmap.getWidth());
                            jSONObject.put("height", bitmap.getHeight());
                            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            LivePusherEmbeddedWidgetClient.this.evaluateCallbackJs(i3, wrapCallbackOk.toString());
                        } catch (Exception unused) {
                            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, new JSONObject());
                            AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                            LivePusherEmbeddedWidgetClient.this.evaluateCallbackJs(i3, wrapCallbackFail.toString());
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewDestroy() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.webViewDestroy " + this);
        release();
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewPause() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.webviewPause " + this);
        enterBackground();
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewResume() {
        QMLog.d(TAG, "LivePusherEmbeddedWidgetClient.webviewResume " + this);
        enterForeground();
    }
}
