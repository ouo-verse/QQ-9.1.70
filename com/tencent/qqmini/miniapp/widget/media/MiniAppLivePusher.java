package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mm.plugin.appbrand.jsapi.live.c;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class MiniAppLivePusher extends FrameLayout {
    private static final String ON_LIVE_PUSHER_BGM_COMPLETE = "onLivePusherBGMComplete";
    private static final String ON_LIVE_PUSHER_BGM_PROGRESS = "onLivePusherBGMProgress";
    private static final String ON_LIVE_PUSHER_BGM_START = "onLivePusherBGMStart";
    private static final String ON_LIVE_PUSHER_ERR = "onLivePusherError";
    private static final String ON_LIVE_PUSHER_EVENT = "onLivePusherEvent";
    private static final String ON_LIVE_PUSHER_NET_STATUS = "onLivePusherNetStatus";
    private static final String TAG = "MiniAppLivePusher";
    public WeakReference<Activity> atyRef;
    private Context context;
    public String data;
    private ConcurrentHashMap<String, String> downloadMap;
    private AtomicInteger downloadTaskId;
    private Handler handler;
    private boolean hasSetUp;
    public long livePusherId;
    private TXLivePusherJSAdapter livePusherJSAdapter;
    private IMiniAppContext mMiniAppContext;
    public WeakReference<IMiniAppContext> miniAppContextRef;
    private boolean needToStopDownloadBGM;
    private FrameLayout pusherContainer;
    private ArrayList<String> pusherKeyList;
    private View rootView;
    private Runnable stopDumpRunnable;
    private Object tXCloudVideoView;
    private String tempAudioFilePath;
    public int webviewId;

    public MiniAppLivePusher(@NonNull IMiniAppContext iMiniAppContext) {
        this(iMiniAppContext, null);
        setUpView(iMiniAppContext.getContext());
    }

    private void doPlayBGM(final String str, final RequestEvent requestEvent, final JSONObject jSONObject) {
        if (jSONObject != null) {
            this.needToStopDownloadBGM = false;
            final String valueOf = String.valueOf(this.downloadTaskId.getAndIncrement());
            final String optString = jSONObject.optString("url");
            this.downloadMap.put(valueOf, optString);
            final String tmpPathByUrl = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(optString);
            final DownloaderProxy downloaderProxy = (DownloaderProxy) ProxyManager.get(DownloaderProxy.class);
            downloaderProxy.download(optString, null, tmpPathByUrl, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.5
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadFailed(int i3, String str2) {
                    IMiniAppContext iMiniAppContext;
                    MiniAppLivePusher.this.downloadMap.remove(valueOf, optString);
                    QMLog.e(MiniAppLivePusher.TAG, "playBGM - download onDownloadFailed failed:" + str2);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("livePusherId", MiniAppLivePusher.this.livePusherId);
                        jSONObject2.put("errMsg", str2);
                        jSONObject2.put("errCode", 10003);
                        WeakReference<IMiniAppContext> weakReference = MiniAppLivePusher.this.miniAppContextRef;
                        if (weakReference != null) {
                            iMiniAppContext = weakReference.get();
                        } else {
                            iMiniAppContext = null;
                        }
                        if (iMiniAppContext != null) {
                            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePusher.ON_LIVE_PUSHER_ERR, jSONObject2.toString(), MiniAppLivePusher.this.webviewId));
                        }
                        requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePusher.ON_LIVE_PUSHER_ERR, jSONObject2.toString(), MiniAppLivePusher.this.webviewId);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadProgress(float f16, long j3, long j16) {
                    if (MiniAppLivePusher.this.needToStopDownloadBGM) {
                        QMLog.d(MiniAppLivePusher.TAG, "playBGM - download onDownloadProgress, abort");
                        downloaderProxy.abort(optString);
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadSucceed(int i3, String str2, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                    MiniAppLivePusher.this.onDownloadSucceed(str2, optString, tmpPathByUrl, valueOf, jSONObject, str);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
                }
            });
        }
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(c.NAME, null).toString());
    }

    private void doSetBGMPosition(String str, RequestEvent requestEvent, JSONObject jSONObject) {
        try {
            jSONObject.put("BGMPosition", jSONObject.getInt("position") * 1000);
            this.livePusherJSAdapter.operateLivePusher(str, jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "setBGMPosition - JSONException:" + e16);
        }
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(c.NAME, null).toString());
    }

    private void doSnapShot(RequestEvent requestEvent, JSONObject jSONObject) {
        boolean z16;
        String optString;
        if (jSONObject != null && (optString = jSONObject.optString(CustomImageProps.QUALITY)) != null && optString.equalsIgnoreCase("compressed")) {
            z16 = true;
        } else {
            z16 = false;
        }
        takePhoto(c.NAME, z16, requestEvent);
    }

    private void doStartAudioRecord(RequestEvent requestEvent, JSONObject jSONObject) {
        String tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("pcm");
        long optLong = jSONObject.optLong("maxDuration");
        QMLog.d(TAG, "recordFile:" + tmpPath);
        int startDumpAudioData = this.livePusherJSAdapter.startDumpAudioData(tmpPath);
        QMLog.d(TAG, "recordResult:" + startDumpAudioData);
        if (startDumpAudioData == 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                tmpPath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(tmpPath);
                QMLog.d(TAG, "recordFile transformed:" + tmpPath);
                jSONObject2.put("tempFilePath", tmpPath);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.tempAudioFilePath = tmpPath;
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(c.NAME, jSONObject2).toString());
            this.handler.postDelayed(this.stopDumpRunnable, optLong);
        } else if (startDumpAudioData == -1) {
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(c.NAME, null, "LivePusher is recording").toString());
            return;
        } else if (startDumpAudioData == -2) {
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(c.NAME, null, "LivePusher creates recordFile failed").toString());
        } else if (startDumpAudioData == -3) {
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(c.NAME, null, "LivePusher not support current format").toString());
        } else {
            requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackFail(c.NAME, null, "LivePusher starts recording fail").toString());
        }
        QMLog.d(TAG, "recordResult:" + startDumpAudioData);
    }

    private void doStopAudioRecord(RequestEvent requestEvent) {
        QMLog.d(TAG, "stopDumpAudioData");
        this.handler.removeCallbacks(this.stopDumpRunnable);
        this.livePusherJSAdapter.stopDumpAudioData();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.tempAudioFilePath)) {
                jSONObject.put("tempFilePath", this.tempAudioFilePath);
                this.tempAudioFilePath = null;
            } else {
                jSONObject.put("tempFilePath", "");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(c.NAME, jSONObject).toString());
    }

    private void doStopBGM(String str, RequestEvent requestEvent, JSONObject jSONObject) {
        this.needToStopDownloadBGM = true;
        this.livePusherJSAdapter.operateLivePusher(str, jSONObject);
        requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(c.NAME, null).toString());
    }

    private void initPusher(RequestEvent requestEvent, JSONObject jSONObject) {
        if (QMLog.isColorLevel() && jSONObject != null) {
            QMLog.d(TAG, "initLivePusher params = " + jSONObject.toString());
        }
        initPusherKeyList();
        TXLivePusherJSAdapter tXLivePusherJSAdapter = new TXLivePusherJSAdapter(getContext());
        this.livePusherJSAdapter = tXLivePusherJSAdapter;
        tXLivePusherJSAdapter.initLivePusher(this.tXCloudVideoView, jSONObject);
        setBGMNotifyListener(requestEvent);
        setPushListener(requestEvent);
        this.livePusherJSAdapter.updateHomeOrientation(this.mMiniAppContext);
    }

    private void initPusherKeyList() {
        if (this.pusherKeyList == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.pusherKeyList = arrayList;
            arrayList.add("pushUrl");
            this.pusherKeyList.add("mode");
            this.pusherKeyList.add("hide");
            this.pusherKeyList.add("autopush");
            this.pusherKeyList.add("muted");
            this.pusherKeyList.add("enableCamera");
            this.pusherKeyList.add("enableMic");
            this.pusherKeyList.add("enableAGC");
            this.pusherKeyList.add("enableANS");
            this.pusherKeyList.add("audioVolumeType");
            this.pusherKeyList.add("audioReverbType");
            this.pusherKeyList.add("devicePosition");
            this.pusherKeyList.add("focusMode");
            this.pusherKeyList.add("orientation");
            this.pusherKeyList.add("beauty");
            this.pusherKeyList.add("whiteness");
            this.pusherKeyList.add("aspect");
            this.pusherKeyList.add("videoWidth");
            this.pusherKeyList.add("videoHeight");
            this.pusherKeyList.add("minBitrate");
            this.pusherKeyList.add("maxBitrate");
            this.pusherKeyList.add("audioQuality");
            this.pusherKeyList.add("backgroundImage");
            this.pusherKeyList.add("backgroundMute");
            this.pusherKeyList.add("zoom");
            this.pusherKeyList.add("needEvent");
            this.pusherKeyList.add("needBGMEvent");
            this.pusherKeyList.add("watermarkImage");
            this.pusherKeyList.add("watermarkLeft");
            this.pusherKeyList.add("watermarkTop");
            this.pusherKeyList.add("watermarkWidth");
            this.pusherKeyList.add("debug");
            this.pusherKeyList.add("mirror");
            this.pusherKeyList.add("remoteMirror");
            this.pusherKeyList.add("localMirror");
            this.pusherKeyList.add("enableEarMonitor");
        }
    }

    private void initPusherView() {
        Object creatSpecifiedObject = JarReflectUtil.creatSpecifiedObject(IWXLivePusherProxy.CLASS_NAME_TX_CLOUD_VIDEO_VIEW, JarReflectUtil.getParamsClass(Context.class), getContext());
        this.tXCloudVideoView = creatSpecifiedObject;
        if (creatSpecifiedObject == null) {
            QMLog.e(TAG, "tXCloudVideoView is null?! ");
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = (View) this.tXCloudVideoView;
        view.setLayoutParams(layoutParams);
        view.setVisibility(0);
        this.pusherContainer.removeAllViews();
        this.pusherContainer.addView(view);
        this.pusherContainer.setBackgroundColor(-16777216);
        new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.context, 100.0f), DisplayUtil.dip2px(this.context, 100.0f)).gravity = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadSucceed(String str, String str2, String str3, String str4, JSONObject jSONObject, String str5) {
        try {
            QMLog.e(TAG, "playBGM - download onDownloadSucceed:" + str2);
            if (this.needToStopDownloadBGM) {
                QMLog.e(TAG, "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
                return;
            }
            if (!TextUtils.isEmpty(str3)) {
                File file = new File(str3);
                if (!file.exists() && !TextUtils.isEmpty(str)) {
                    QMLog.e(TAG, "file no exists, try to copy again.");
                    try {
                        File file2 = new File(str);
                        if (file2.exists() && file2.isFile() && file2.length() > 0) {
                            QMLog.w(TAG, "download Succeed but target file not exists, try copy from download tmp file:" + str + ", length:" + file2.length() + ", to:" + str3);
                            file = FileUtils.createFile(str3);
                            if (FileUtils.copyFile(file2, file) && file.exists() && file.length() == file2.length()) {
                                QMLog.i(TAG, "copy from download tmp file:" + str + " success");
                            } else if (file.exists()) {
                                file.delete();
                            }
                        }
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "try copy from download tmp file exception! tmp file:" + str, th5);
                    }
                }
                this.downloadMap.remove(str4);
                operateLivePusher(str, str3, jSONObject, str5, file);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
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

    private void setBGMNotifyListener(final RequestEvent requestEvent) {
        this.livePusherJSAdapter.setBGMNotifyListener(new TXLivePushListenerReflect.OnBGMNotify() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
            public void onBGMComplete(int i3) {
                IMiniAppContext iMiniAppContext;
                QMLog.d(MiniAppLivePusher.TAG, "onBGMComplete, errCode:" + i3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePusherId", MiniAppLivePusher.this.livePusherId);
                    jSONObject.put("errCode", i3);
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePusher.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePusher.ON_LIVE_PUSHER_BGM_COMPLETE, jSONObject.toString(), MiniAppLivePusher.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePusher.ON_LIVE_PUSHER_BGM_COMPLETE, jSONObject.toString(), MiniAppLivePusher.this.webviewId);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
            public void onBGMProgress(long j3, long j16) {
                IMiniAppContext iMiniAppContext;
                QMLog.e(MiniAppLivePusher.TAG, "onBGMProgress progress:" + j3 + ",duration:" + j16);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePusherId", MiniAppLivePusher.this.livePusherId);
                    jSONObject.put("progress", j3);
                    jSONObject.put("duration", j16);
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePusher.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePusher.ON_LIVE_PUSHER_BGM_PROGRESS, jSONObject.toString(), MiniAppLivePusher.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePusher.ON_LIVE_PUSHER_BGM_PROGRESS, jSONObject.toString(), MiniAppLivePusher.this.webviewId);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.OnBGMNotify
            public void onBGMStart() {
                IMiniAppContext iMiniAppContext;
                QMLog.e(MiniAppLivePusher.TAG, "onBGMStart");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePusherId", MiniAppLivePusher.this.livePusherId);
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePusher.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePusher.ON_LIVE_PUSHER_BGM_START, jSONObject.toString(), MiniAppLivePusher.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePusher.ON_LIVE_PUSHER_BGM_START, jSONObject.toString(), MiniAppLivePusher.this.webviewId);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    private void setPushListener(final RequestEvent requestEvent) {
        this.livePusherJSAdapter.setPushListener(new TXLivePushListenerReflect.ITXLivePushListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener
            public void onNetStatus(Bundle bundle) {
                IMiniAppContext iMiniAppContext;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("CPU_USAGE", bundle.getString("CPU_USAGE"));
                    jSONObject2.put("VIDEO_WIDTH", bundle.getInt("VIDEO_WIDTH"));
                    jSONObject2.put("VIDEO_HEIGHT", bundle.getInt("VIDEO_HEIGHT"));
                    jSONObject2.put("NET_SPEED", bundle.getInt("NET_SPEED"));
                    jSONObject2.put("NET_JITTER", bundle.getInt("NET_JITTER"));
                    jSONObject2.put("VIDEO_FPS", bundle.getInt("VIDEO_FPS"));
                    jSONObject2.put("VIDEO_GOP", bundle.getInt("VIDEO_GOP"));
                    jSONObject2.put("AUDIO_BITRATE", bundle.getInt("AUDIO_BITRATE"));
                    jSONObject2.put("AUDIO_CACHE", bundle.getInt("AUDIO_CACHE"));
                    jSONObject2.put("VIDEO_CACHE", bundle.getInt("VIDEO_CACHE"));
                    jSONObject2.put("V_SUM_CACHE_SIZE", bundle.getInt("V_SUM_CACHE_SIZE"));
                    jSONObject2.put("V_DEC_CACHE_SIZE", bundle.getInt("V_DEC_CACHE_SIZE"));
                    jSONObject2.put("AV_RECV_INTERVAL", bundle.getInt("AV_RECV_INTERVAL"));
                    jSONObject2.put("AV_PLAY_INTERVAL", bundle.getInt("AV_PLAY_INTERVAL"));
                    jSONObject2.put("AUDIO_CACHE_THRESHOLD", String.format("%.1f", Float.valueOf(bundle.getFloat("AUDIO_CACHE_THRESHOLD"))));
                    jSONObject2.put("VIDEO_BITRATE", bundle.getInt("VIDEO_BITRATE"));
                    jSONObject2.put("AUDIO_DROP", bundle.getInt("AUDIO_DROP"));
                    jSONObject2.put("VIDEO_DROP", bundle.getInt("VIDEO_DROP"));
                    jSONObject2.put("SERVER_IP", bundle.getString("SERVER_IP"));
                    jSONObject2.put("AUDIO_PLAY_INFO", bundle.getString("AUDIO_PLAY_INFO"));
                    jSONObject.put("info", jSONObject2);
                } catch (JSONException e16) {
                    e = e16;
                }
                try {
                    jSONObject.put("livePusherId", MiniAppLivePusher.this.livePusherId);
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePusher.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePusher.ON_LIVE_PUSHER_NET_STATUS, jSONObject.toString(), MiniAppLivePusher.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePusher.ON_LIVE_PUSHER_NET_STATUS, jSONObject.toString(), MiniAppLivePusher.this.webviewId);
                } catch (JSONException e17) {
                    e = e17;
                    e.printStackTrace();
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXLivePushListener
            public void onPushEvent(int i3, Bundle bundle) {
                IMiniAppContext iMiniAppContext;
                QMLog.e(MiniAppLivePusher.TAG, "onPushEvent i:" + i3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePusherId", MiniAppLivePusher.this.livePusherId);
                    jSONObject.put("errCode", i3);
                    if (bundle != null) {
                        jSONObject.put("errMsg", bundle.getString("EVT_MSG"));
                    }
                    WeakReference<IMiniAppContext> weakReference = MiniAppLivePusher.this.miniAppContextRef;
                    if (weakReference != null) {
                        iMiniAppContext = weakReference.get();
                    } else {
                        iMiniAppContext = null;
                    }
                    if (iMiniAppContext != null) {
                        iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MiniAppLivePusher.ON_LIVE_PUSHER_EVENT, jSONObject.toString(), MiniAppLivePusher.this.webviewId));
                    }
                    requestEvent.jsService.evaluateSubscribeJS(MiniAppLivePusher.ON_LIVE_PUSHER_EVENT, jSONObject.toString(), MiniAppLivePusher.this.webviewId);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    private void setUpView(Context context) {
        if (this.hasSetUp) {
            return;
        }
        this.hasSetUp = true;
        setTag(TAG);
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_live_pusher_view, (ViewGroup) null);
        this.rootView = inflate;
        this.pusherContainer = (FrameLayout) inflate.findViewById(R.id.pusher_container);
        addView(this.rootView);
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

    public void initLivePusherSettings(RequestEvent requestEvent, JSONObject jSONObject) {
        if (QMLog.isColorLevel() && jSONObject != null) {
            QMLog.d(TAG, "initLivePusherSettings json: " + jSONObject.toString());
        }
        initPusherView();
        initPusher(requestEvent, jSONObject);
    }

    public void operateLivePusher(String str, RequestEvent requestEvent, JSONObject jSONObject) {
        QMLog.d(TAG, "operateLivePusher json: " + str);
        if (this.livePusherJSAdapter != null) {
            if (com.tencent.luggage.wxa.c8.c.f123373g0.equals(str)) {
                doPlayBGM(str, requestEvent, jSONObject);
                return;
            }
            if ("stopBGM".equals(str)) {
                doStopBGM(str, requestEvent, jSONObject);
                return;
            }
            if ("setBGMPosition".equals(str)) {
                doSetBGMPosition(str, requestEvent, jSONObject);
                return;
            }
            if ("snapshot".equals(str)) {
                doSnapShot(requestEvent, jSONObject);
                return;
            }
            if (str.equalsIgnoreCase("startAudioRecord")) {
                doStartAudioRecord(requestEvent, jSONObject);
            } else {
                if (str.equalsIgnoreCase("stopAudioRecord")) {
                    doStopAudioRecord(requestEvent);
                    return;
                }
                this.livePusherJSAdapter.operateLivePusher(str, jSONObject);
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, ApiUtil.wrapCallbackOk(c.NAME, null).toString());
            }
        }
    }

    public void release() {
        this.handler.removeCallbacks(this.stopDumpRunnable);
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter != null) {
            tXLivePusherJSAdapter.unInitLivePusher();
        }
        ScreenOffOnListener.getInstance().unRegistListener();
    }

    public void setAtyRef(WeakReference<Activity> weakReference) {
        this.atyRef = weakReference;
    }

    public void takePhoto(final String str, boolean z16, final RequestEvent requestEvent) {
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter == null) {
            return;
        }
        tXLivePusherJSAdapter.takePhoto(z16, new TXLivePushListenerReflect.ITXSnapshotListener() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect.ITXSnapshotListener
            public void onSnapshot(final Bitmap bitmap) {
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            File file = new File(((MiniAppFileManager) MiniAppLivePusher.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
                            file.getParentFile().mkdirs();
                            MiniAppLivePusher.saveJpeg(bitmap, file);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tempImagePath", file.getAbsolutePath());
                            jSONObject.put("width", bitmap.getWidth());
                            jSONObject.put("height", bitmap.getHeight());
                            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
                            RequestEvent requestEvent2 = requestEvent;
                            requestEvent2.jsService.evaluateCallbackJs(requestEvent2.callbackId, wrapCallbackOk.toString());
                        } catch (Exception unused) {
                            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, new JSONObject());
                            RequestEvent requestEvent3 = requestEvent;
                            requestEvent3.jsService.evaluateCallbackJs(requestEvent3.callbackId, wrapCallbackFail.toString());
                        }
                    }
                });
            }
        });
    }

    public void updateLivePusherSetting(JSONObject jSONObject) {
        if (QMLog.isColorLevel() && jSONObject != null) {
            QMLog.d(TAG, "updateLivePusherSetting params = " + jSONObject.toString());
        }
        TXLivePusherJSAdapter tXLivePusherJSAdapter = this.livePusherJSAdapter;
        if (tXLivePusherJSAdapter != null) {
            tXLivePusherJSAdapter.updateLivePusher(jSONObject);
        }
    }

    public MiniAppLivePusher(@NonNull IMiniAppContext iMiniAppContext, @Nullable AttributeSet attributeSet) {
        super(iMiniAppContext.getContext(), attributeSet);
        this.hasSetUp = false;
        this.handler = new Handler(Looper.getMainLooper());
        this.tempAudioFilePath = null;
        this.stopDumpRunnable = new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.1
            @Override // java.lang.Runnable
            public void run() {
                QMLog.d(MiniAppLivePusher.TAG, "stopDumpAudio at maxDuration");
                MiniAppLivePusher.this.livePusherJSAdapter.stopDumpAudioData();
            }
        };
        this.downloadTaskId = new AtomicInteger(0);
        this.downloadMap = new ConcurrentHashMap<>();
        this.needToStopDownloadBGM = false;
        this.mMiniAppContext = iMiniAppContext;
        setUpView(iMiniAppContext.getContext());
    }

    private void operateLivePusher(String str, String str2, JSONObject jSONObject, String str3, File file) throws JSONException {
        if (file.exists() && file.canRead()) {
            if (QMLog.isColorLevel()) {
                QMLog.d(TAG, "download success BGMFilePath:" + str2);
            }
            jSONObject.put("BGMFilePath", str2);
            this.livePusherJSAdapter.operateLivePusher(str3, jSONObject);
            return;
        }
        QMLog.d(TAG, "download failed, filepath not exists, tmpFile:" + str);
    }
}
