package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPCDNRecorderManager;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.report.RFWPlayerNetFlowReporter;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import cooperation.qqcircle.report.QFSNetFlowReporter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RFWVideoPreloadManager {
    public static final int PRELOAD_DURATION;
    private static final int PRELOAD_MAX_COUNT;
    private static final ConcurrentHashMap<Integer, RFWVideoPreloadManager> sInstances;
    public static int sPreloadMaxCount;
    private final Handler mPreLoadHandler;
    private volatile ISPlayerPreDownloader mPreLoader;
    private final QQConcurrentHashMap<Integer, RFWVideoPreloadBean> mPreloadHistoryMap;
    private final int mSceneId;
    private final ConcurrentSkipListMap<Integer, RFWVideoPreloadBean> mPreloadMap = new ConcurrentSkipListMap<>();
    private final List<WeakReference<OnPreloadListener>> preloadListeners = new ArrayList();
    private final HashMap<Integer, RFWVideoPreloadBaseMsgProcess> mProcessMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface IPreloadInitListener {
        void onInitFailed();

        void onInitSuccess(ISPlayerPreDownloader iSPlayerPreDownloader);
    }

    /* loaded from: classes5.dex */
    public interface OnPreloadListener {
        @WorkerThread
        void beforePreloadStart(RFWVideoPreloadBean rFWVideoPreloadBean);

        @MainThread
        void onPreloadFinish(RFWVideoPreloadBean rFWVideoPreloadBean);
    }

    static {
        int intValue = uq3.c.X0("qqcircle", "qqcircle_video_preload_max_num", 3).intValue();
        PRELOAD_MAX_COUNT = intValue;
        PRELOAD_DURATION = uq3.c.X0("qqcircle", "qqcircle_video_preload_duration", 5000).intValue();
        sPreloadMaxCount = intValue;
        sInstances = new ConcurrentHashMap<>();
    }

    RFWVideoPreloadManager(int i3) {
        this.mSceneId = i3;
        this.mPreloadHistoryMap = new QQConcurrentHashMap<>(Business.QCircle, String.valueOf(i3));
        initProcessMap();
        if (enableCreatePreloadAsync()) {
            initPreloaderAsync(null);
        } else {
            getPreLoader();
        }
        this.mPreLoadHandler = RFWThreadManager.createNewThreadHandler("QFSVideoPreload", getHandlerPriority(), createHandlerCallBack());
    }

    private void callBackCreateLoadFinish(IPreloadInitListener iPreloadInitListener) {
        if (iPreloadInitListener == null) {
            return;
        }
        if (this.mPreLoader == null) {
            RFWLog.d("QFSVideoPreload", RFWLog.USR, "callBackCreateLoadFinish init download sdk failed ");
            iPreloadInitListener.onInitFailed();
        } else {
            RFWLog.d("QFSVideoPreload", RFWLog.USR, "callBackCreateLoadFinish init download sdk success ");
            iPreloadInitListener.onInitSuccess(this.mPreLoader);
        }
    }

    private Handler.Callback createHandlerCallBack() {
        return new Handler.Callback() { // from class: se0.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean lambda$createHandlerCallBack$0;
                lambda$createHandlerCallBack$0 = RFWVideoPreloadManager.this.lambda$createHandlerCallBack$0(message);
                return lambda$createHandlerCallBack$0;
            }
        };
    }

    private synchronized void createPreLoader() {
        if (this.mPreLoader != null) {
            return;
        }
        this.mPreLoader = SuperPlayerFactory.createPreDownloader(RFWApplication.getApplication(), this.mSceneId);
        this.mPreLoader.setOnPreDownloadListener(createPreLoaderListener());
    }

    private ISPlayerPreDownloader.Listener createPreLoaderListener() {
        return new ISPlayerPreDownloader.Listener() { // from class: com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.2
            private long mPreloadSizeByte = 0;

            private RFWPlayerNetFlowReporter.PlayerNetFlowBean getPlayerNetFlowBean(int i3) {
                RFWVideoPreloadBean rFWVideoPreloadBean;
                RFWPlayerOptions playerOptions;
                ConcurrentSkipListMap<Integer, RFWVideoPreloadBean> preloadMap = RFWVideoPreloadManager.this.getPreloadMap();
                if (preloadMap == null) {
                    rFWVideoPreloadBean = null;
                } else {
                    rFWVideoPreloadBean = preloadMap.get(Integer.valueOf(i3));
                }
                if (rFWVideoPreloadBean == null) {
                    playerOptions = null;
                } else {
                    playerOptions = rFWVideoPreloadBean.getPlayerOptions();
                }
                if (playerOptions == null) {
                    return null;
                }
                return RFWPlayerNetFlowReporter.getHistoryAndUpdateNetFlowBean(playerOptions, i3);
            }

            private void updatePreloadCount(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("HttpDownloadSize")) {
                        this.mPreloadSizeByte = jSONObject.optLong("HttpDownloadSize");
                    }
                } catch (Exception e16) {
                    QLog.e("QFSVideoPreload", 1, "[updatePreloadCount] error: ", e16);
                }
            }

            @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
            public void onInfo(int i3, long j3, long j16, Object obj) {
                RFWLog.d("QFSVideoPreload", RFWLog.CLR, "onInfo: " + i3 + "_" + j3 + "_" + j16 + "_" + obj);
                if (i3 == 251 && obj != null) {
                    RFWPCDNRecorderManager.g().decodeAdnRecPCDNFailedInfo("", obj.toString(), "FROM_TYPE_PRELOAD_VIDEO");
                }
            }

            @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
            public void onPrepareDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
                RFWLog.d("QFSVideoPreload", RFWLog.CLR, "onPrepareDownloadProgressUpdate: " + i3 + "_" + i16 + "_" + i17 + "_" + j3 + "_" + j16 + "_" + str);
                RFWVideoPreloadManager.this.sendMsg(6, Integer.valueOf(i3));
                updatePreloadCount(str);
                RFWPlayerNetFlowReporter.addPlayerNetFlowItem(String.valueOf(i3), getPlayerNetFlowBean(i3), str);
            }

            @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
            public void onPrepareError(int i3, int i16, int i17, String str) {
                RFWLog.d("QFSVideoPreload", RFWLog.CLR, "onPrepareError: " + i3);
                RFWVideoPreloadManager.this.sendMsg(4, Integer.valueOf(i3));
                QFSNetFlowReporter.reportFlowCost(QFSNetFlowReporter.QFS_FLOW_COST_SCENE_VIDEO_PRELOAD_FLOW_COUNT, i3 + "", "", this.mPreloadSizeByte, 0L, "QFSVideoPreload", "");
                RFWPlayerNetFlowReporter.reportPlayerNetFlow(String.valueOf(i3));
                if (RFWVideoPreloadManager.this.mPreLoader != null) {
                    RFWVideoPreloadManager.this.mPreLoader.stopPreDownload(i3);
                }
            }

            @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
            public void onPrepareSuccess(int i3) {
                RFWLog.d("QFSVideoPreload", RFWLog.CLR, "onPrepareSuccess: " + i3);
                RFWVideoPreloadManager.this.sendMsg(5, Integer.valueOf(i3));
                QFSNetFlowReporter.reportFlowCost(QFSNetFlowReporter.QFS_FLOW_COST_SCENE_VIDEO_PRELOAD_FLOW_COUNT, i3 + "", "", this.mPreloadSizeByte, 0L, "QFSVideoPreload", "");
                RFWPlayerNetFlowReporter.reportPlayerNetFlow(String.valueOf(i3));
                if (RFWVideoPreloadManager.this.mPreLoader != null) {
                    RFWVideoPreloadManager.this.mPreLoader.stopPreDownload(i3);
                }
            }
        };
    }

    private boolean enableCreatePreloadAsync() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_create_prelaod_async", true);
    }

    public static RFWVideoPreloadManager g(int i3) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_preload_anr", true)) {
            return getInstance(i3);
        }
        return getRfwVideoPreloadManager(i3);
    }

    private int getHandlerPriority() {
        if (Build.VERSION.SDK_INT >= 28) {
            return -10;
        }
        return -2;
    }

    private static RFWVideoPreloadManager getInstance(int i3) {
        ConcurrentHashMap<Integer, RFWVideoPreloadManager> concurrentHashMap = sInstances;
        RFWVideoPreloadManager rFWVideoPreloadManager = concurrentHashMap.get(Integer.valueOf(i3));
        if (rFWVideoPreloadManager == null) {
            RFWVideoPreloadManager rFWVideoPreloadManager2 = new RFWVideoPreloadManager(i3);
            RFWVideoPreloadManager putIfAbsent = concurrentHashMap.putIfAbsent(Integer.valueOf(i3), rFWVideoPreloadManager2);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return rFWVideoPreloadManager2;
        }
        return rFWVideoPreloadManager;
    }

    @Nullable
    private static RFWVideoPreloadManager getRfwVideoPreloadManager(int i3) {
        ConcurrentHashMap<Integer, RFWVideoPreloadManager> concurrentHashMap = sInstances;
        if (concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            return concurrentHashMap.get(Integer.valueOf(i3));
        }
        synchronized (RFWVideoPreloadManager.class) {
            if (concurrentHashMap.containsKey(Integer.valueOf(i3))) {
                return concurrentHashMap.get(Integer.valueOf(i3));
            }
            RFWVideoPreloadManager rFWVideoPreloadManager = new RFWVideoPreloadManager(i3);
            concurrentHashMap.put(Integer.valueOf(i3), rFWVideoPreloadManager);
            return rFWVideoPreloadManager;
        }
    }

    private boolean hasReady() {
        if (!QQVideoPlaySDKManager.isDownloadSDKReady()) {
            RFWLog.i("QFSVideoPreload", RFWLog.CLR, "video sdk is not ready");
            return false;
        }
        if (!enableCreatePreloadAsync()) {
            if (getPreLoader() == null) {
                return false;
            }
            return true;
        }
        if (this.mPreLoader != null) {
            return true;
        }
        RFWLog.i("QFSVideoPreload", RFWLog.USR, "preload is null");
        return false;
    }

    private void initPreloaderAsync(final IPreloadInitListener iPreloadInitListener) {
        if (!enableCreatePreloadAsync()) {
            RFWLog.d("QFSVideoPreload", RFWLog.USR, "not enable init download sdk async ");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.videopreload.a
                @Override // java.lang.Runnable
                public final void run() {
                    RFWVideoPreloadManager.this.lambda$initPreloaderAsync$3(iPreloadInitListener);
                }
            });
        }
    }

    private void initProcessMap() {
        this.mProcessMap.put(0, new RFWVideoPreloadExchangeUrlMsgProcess(this.mSceneId));
        this.mProcessMap.put(1, new RFWVideoPreloadCheckNumMsgProcess(this.mSceneId));
        this.mProcessMap.put(2, new RFWVideoPreloadAddMsgProcess(this.mSceneId));
        this.mProcessMap.put(3, new RFWVideoPreloadCancelMsgProcess(this.mSceneId));
        this.mProcessMap.put(4, new RFWVideoPreloadErrorMsgProcess(this.mSceneId));
        this.mProcessMap.put(5, new RFWVideoPreloadSuccessMsgProcess(this.mSceneId));
        this.mProcessMap.put(6, new RFWVideoPreloadProgressMsgProcess(this.mSceneId));
        this.mProcessMap.put(7, new RFWVideoPreloadStopProcess(this.mSceneId));
        this.mProcessMap.put(8, new RFWVideoPreloadStopAllProcess(this.mSceneId));
        this.mProcessMap.put(9, new RFWUpdatePreloadMaxCount(this.mSceneId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createHandlerCallBack$0(Message message) {
        RFWVideoPreloadBaseMsgProcess rFWVideoPreloadBaseMsgProcess = this.mProcessMap.get(Integer.valueOf(message.what));
        if (rFWVideoPreloadBaseMsgProcess == null) {
            RFWLog.i("QFSVideoPreload", RFWLog.USR, "not define");
            return false;
        }
        return rFWVideoPreloadBaseMsgProcess.handlerMsg(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreLoader$1(boolean z16) {
        if (!z16) {
            RFWLog.d("QFSVideoPreload", RFWLog.USR, "init download sdk failed ");
        } else {
            createPreLoader();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPreloaderAsync$2(IPreloadInitListener iPreloadInitListener, boolean z16) {
        if (!z16) {
            callBackCreateLoadFinish(iPreloadInitListener);
            RFWLog.d("QFSVideoPreload", RFWLog.USR, "init download sdk failed ");
        } else {
            createPreLoader();
            callBackCreateLoadFinish(iPreloadInitListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPreloaderAsync$3(final IPreloadInitListener iPreloadInitListener) {
        if (QQVideoPlaySDKManager.isDownloadSDKReady()) {
            createPreLoader();
            callBackCreateLoadFinish(iPreloadInitListener);
        } else {
            QQVideoPlaySDKManager.initDownloadSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: com.tencent.biz.richframework.video.rfw.player.videopreload.b
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    RFWVideoPreloadManager.this.lambda$initPreloaderAsync$2(iPreloadInitListener, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreloadFinish$4(RFWVideoPreloadBean rFWVideoPreloadBean) {
        synchronized (this.preloadListeners) {
            Iterator<WeakReference<OnPreloadListener>> it = this.preloadListeners.iterator();
            while (it.hasNext()) {
                OnPreloadListener onPreloadListener = it.next().get();
                if (onPreloadListener != null) {
                    onPreloadListener.onPreloadFinish(rFWVideoPreloadBean);
                }
            }
            trimPreloadListener();
        }
    }

    private void trimPreloadListener() {
        for (int size = this.preloadListeners.size() - 1; size >= 0; size--) {
            if (this.preloadListeners.get(size).get() == null) {
                this.preloadListeners.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beforePreloadStart(RFWVideoPreloadBean rFWVideoPreloadBean) {
        synchronized (this.preloadListeners) {
            Iterator<WeakReference<OnPreloadListener>> it = this.preloadListeners.iterator();
            while (it.hasNext()) {
                OnPreloadListener onPreloadListener = it.next().get();
                if (onPreloadListener != null) {
                    onPreloadListener.beforePreloadStart(rFWVideoPreloadBean);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QQConcurrentHashMap<Integer, RFWVideoPreloadBean> getHistoryMap() {
        return this.mPreloadHistoryMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ISPlayerPreDownloader getPreLoader() {
        if (QQVideoPlaySDKManager.isDownloadSDKReady()) {
            createPreLoader();
        } else {
            RFWLog.d("QFSVideoPreload", RFWLog.USR, "video sdk not init mPreLoader may empty");
            QQVideoPlaySDKManager.initDownloadSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: se0.b
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    RFWVideoPreloadManager.this.lambda$getPreLoader$1(z16);
                }
            });
        }
        return this.mPreLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConcurrentSkipListMap<Integer, RFWVideoPreloadBean> getPreloadMap() {
        return this.mPreloadMap;
    }

    public RFWVideoPreloadBean getPreloadRecord(String str) {
        RFWVideoPreloadBean preloadRecord;
        if (hasReady() && (preloadRecord = getPreloadRecord(str, true)) != null) {
            return preloadRecord;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreloadFinish(final RFWVideoPreloadBean rFWVideoPreloadBean) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: se0.c
            @Override // java.lang.Runnable
            public final void run() {
                RFWVideoPreloadManager.this.lambda$onPreloadFinish$4(rFWVideoPreloadBean);
            }
        });
    }

    public boolean preloadVideo(final RFWVideoPreloadBean rFWVideoPreloadBean, final String str) {
        if (hasReady() && rFWVideoPreloadBean != null) {
            sendMsg(0, rFWVideoPreloadBean, str);
            return true;
        }
        initPreloaderAsync(new IPreloadInitListener() { // from class: com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.1
            @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.IPreloadInitListener
            public /* synthetic */ void onInitFailed() {
                c.a(this);
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager.IPreloadInitListener
            public void onInitSuccess(ISPlayerPreDownloader iSPlayerPreDownloader) {
                RFWVideoPreloadManager.this.sendMsg(0, rFWVideoPreloadBean, str);
            }
        });
        return false;
    }

    public void registerPreloadListenerAsWeakRef(OnPreloadListener onPreloadListener) {
        if (onPreloadListener == null) {
            return;
        }
        synchronized (this.preloadListeners) {
            Iterator<WeakReference<OnPreloadListener>> it = this.preloadListeners.iterator();
            while (it.hasNext()) {
                if (it.next().get() == onPreloadListener) {
                    return;
                }
            }
            this.preloadListeners.add(new WeakReference<>(onPreloadListener));
        }
    }

    public void releaseAllPreloadVideo() {
        if (!hasReady()) {
            return;
        }
        sendMsg(8, null);
    }

    public void removeHistoryPreloadRecord(@NonNull String str) {
        Integer num;
        Iterator<Map.Entry<Integer, RFWVideoPreloadBean>> it = this.mPreloadHistoryMap.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<Integer, RFWVideoPreloadBean> next = it.next();
                if (str.equals(next.getValue().getVid())) {
                    num = next.getKey();
                    break;
                }
            } else {
                num = null;
                break;
            }
        }
        if (num != null) {
            this.mPreloadHistoryMap.remove(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMsg(int i3, Object... objArr) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        obtain.obj = objArr;
        this.mPreLoadHandler.sendMessage(obtain);
    }

    public void stopPreload(String str) {
        if (!hasReady()) {
            return;
        }
        sendMsg(7, str);
    }

    public void updateMaxPreloadCount(int i3) {
        sendMsg(9, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RFWVideoPreloadBean getPreloadRecord(String str, boolean z16) {
        QQConcurrentHashMap<Integer, RFWVideoPreloadBean> qQConcurrentHashMap;
        if (!TextUtils.isEmpty(str) && (qQConcurrentHashMap = this.mPreloadHistoryMap) != null) {
            Iterator<Map.Entry<Integer, RFWVideoPreloadBean>> it = qQConcurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                RFWVideoPreloadBean value = it.next().getValue();
                if (str.equals(value.getVid()) && (!z16 || value.isPreloadDataValid())) {
                    return value;
                }
            }
        }
        return null;
    }
}
