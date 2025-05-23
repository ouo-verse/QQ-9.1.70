package com.tencent.superplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.MethodNotSupportedException;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.TPMediaAssetFactory;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.preload.ITPPreloader;
import com.tencent.thumbplayer.api.preload.TPPreloaderFactory;
import com.tencent.thumbplayer.asset.TPMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SPlayerPreDownloaderImpl implements ISPlayerPreDownloader {
    public static final String TAG = "SPlayerPreDownloaderImpl";
    private ISPlayerPreDownloader.Listener mCallbackListener;
    private Context mContext;
    private int mServiceType;
    private volatile ITPPreloader mTPPreloadProxy;
    private int sceneId;
    private AtomicInteger mTaskIdIncreaser = new AtomicInteger(0);
    private final Hashtable<Integer, Integer> mTaskIdMap = new Hashtable<>();
    private final Hashtable<Integer, com.tencent.superplayer.report.b> mReportMap = new Hashtable<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a extends TPMediaAsset {
        a() {
        }

        @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
        public int getAssetType() {
            return 0;
        }

        @Override // com.tencent.thumbplayer.asset.TPMediaAsset, com.tencent.thumbplayer.api.asset.ITPMediaAsset
        public boolean isValid() {
            return false;
        }
    }

    public SPlayerPreDownloaderImpl(Context context, int i3) {
        this.sceneId = i3;
        int i16 = CommonUtil.i(i3);
        this.mServiceType = i16;
        CommonUtil.j(i16);
        this.mContext = context.getApplicationContext();
        initPreloadProxy();
    }

    private Object addTaskIdToExtra(Object obj, int i3, String str) {
        if (obj == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(obj.toString());
            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, i3);
            jSONObject.put("fileId", str);
            return jSONObject.toString();
        } catch (Exception e16) {
            LogUtil.d(TAG, "addTaskIdToExtra() error" + e16);
            return obj;
        }
    }

    private boolean checkParamCorrect(SuperPlayerVideoInfo superPlayerVideoInfo) {
        int videoSource = superPlayerVideoInfo.getVideoSource();
        if (videoSource != 1) {
            if (videoSource != 2 || TextUtils.isEmpty(superPlayerVideoInfo.getPlayUrl())) {
                return false;
            }
            if (superPlayerVideoInfo.getFormat() != 302 && superPlayerVideoInfo.getFormat() != 301 && superPlayerVideoInfo.getFormat() != 101 && superPlayerVideoInfo.getFormat() != 102) {
                return false;
            }
            return true;
        }
        if (TextUtils.isEmpty(superPlayerVideoInfo.getPlayUrl()) || superPlayerVideoInfo.getVideoType() != 1 || superPlayerVideoInfo.getFormat() == 304) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ITPMediaAsset creMediaAsset(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16, SuperPlayerDownOption superPlayerDownOption) {
        superPlayerVideoInfo.setVideoDurationMs(j3);
        superPlayerVideoInfo.setFileId(CommonUtil.a(superPlayerVideoInfo));
        ITPMediaAsset mediaAssert = superPlayerVideoInfo.getMediaAssert();
        if (mediaAssert == null) {
            mediaAssert = createMediaAsset(superPlayerVideoInfo);
        }
        mediaAssert.setParam("task_biz_id", String.valueOf(this.mServiceType));
        mediaAssert.setParam("dl_param_play_keyid", superPlayerVideoInfo.getFileId());
        if (j16 > 0) {
            mediaAssert.setParam("dl_param_preload_duration", String.valueOf(j16));
        }
        innerInitDownloadParamData(superPlayerVideoInfo, superPlayerDownOption);
        return mediaAssert;
    }

    private ITPMediaAsset createMediaAsset(SuperPlayerVideoInfo superPlayerVideoInfo) {
        ITPMediaAsset iTPMediaAsset = null;
        try {
            if (superPlayerVideoInfo.getFileDescriptor() != null) {
                iTPMediaAsset = TPMediaAssetFactory.createPfdMediaAsset(superPlayerVideoInfo.getFileDescriptor());
            } else if (superPlayerVideoInfo.getUri() != null) {
                iTPMediaAsset = TPMediaAssetFactory.createPfdMediaAsset(this.mContext.getContentResolver().openFileDescriptor(superPlayerVideoInfo.getUri(), "r"));
            } else {
                iTPMediaAsset = TPMediaAssetFactory.createUrlMediaAsset(superPlayerVideoInfo.getPlayUrl());
                if (superPlayerVideoInfo.getPlayUrls() != null) {
                    for (String str : superPlayerVideoInfo.getPlayUrls()) {
                        ((TPUrlMediaAsset) iTPMediaAsset).addBackUrl(str);
                    }
                }
            }
        } catch (Exception e16) {
            LogUtil.e(TAG, "createMediaAsset:" + e16.getMessage());
        }
        if (iTPMediaAsset == null) {
            iTPMediaAsset = new a();
            LogUtil.e(TAG, "createMediaAsset error null,please check params");
        }
        superPlayerVideoInfo.setMediaAssert(iTPMediaAsset);
        return iTPMediaAsset;
    }

    private void createPreDownloadTask(SuperPlayerVideoInfo superPlayerVideoInfo, ITPMediaAsset iTPMediaAsset, final int i3) {
        initPreloadProxy();
        if (this.mTPPreloadProxy == null) {
            LogUtil.d(TAG, "createPreDownloadTask fail, preload proxy not init, taskId=" + i3 + ", videoInfo=" + superPlayerVideoInfo);
            return;
        }
        int videoSource = superPlayerVideoInfo.getVideoSource();
        if (videoSource != 1) {
            if (videoSource == 2) {
                doPreDownload(superPlayerVideoInfo, iTPMediaAsset, i3);
            }
        } else {
            VInfoGetter vInfoGetter = new VInfoGetter(this.mContext, ThreadUtil.getSubThreadLooper());
            vInfoGetter.setListener(new VInfoGetter.VInfoGetterListener() { // from class: com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.4
                @Override // com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener
                public void onGetVInfoFailed(SuperPlayerVideoInfo superPlayerVideoInfo2, int i16, int i17, String str) {
                    if (SPlayerPreDownloaderImpl.this.mCallbackListener != null) {
                        SPlayerPreDownloaderImpl.this.mCallbackListener.onPrepareError(i3, i16, i17, str);
                    }
                }

                @Override // com.tencent.superplayer.vinfo.VInfoGetter.VInfoGetterListener
                public void onGetVInfoSuccess(SuperPlayerVideoInfo superPlayerVideoInfo2) {
                    superPlayerVideoInfo2.setVideoDurationMs(superPlayerVideoInfo2.getTVideoNetInfo().getVideoDuration());
                    ITPMediaAsset creMediaAsset = SPlayerPreDownloaderImpl.this.creMediaAsset(superPlayerVideoInfo2, superPlayerVideoInfo2.getVideoDurationMs(), superPlayerVideoInfo2.getPreloadDurationMs(), null);
                    if (superPlayerVideoInfo2.getPreloadSize() > 0) {
                        creMediaAsset.setParam("dl_param_preload_size", String.valueOf(superPlayerVideoInfo2.getPreloadSize()));
                    }
                    SPlayerPreDownloaderImpl.this.doPreDownload(superPlayerVideoInfo2, creMediaAsset, i3);
                }
            });
            vInfoGetter.doGetVInfo(superPlayerVideoInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, ITPMediaAsset iTPMediaAsset, int i3) {
        String str = TAG;
        LogUtil.d(str, "doPreDownload() taskid=" + i3 + ", videoInfo=" + superPlayerVideoInfo);
        if (!checkParamCorrect(superPlayerVideoInfo)) {
            LogUtil.d(str, "doPreDownload() checkParamCorrect(videoInfo) error, return");
            return;
        }
        int start = this.mTPPreloadProxy.start(iTPMediaAsset);
        this.mTaskIdMap.put(Integer.valueOf(start), Integer.valueOf(i3));
        this.mReportMap.put(Integer.valueOf(start), new com.tencent.superplayer.report.b(superPlayerVideoInfo, superPlayerVideoInfo.getVideoDurationMs(), this.sceneId));
        LogUtil.d(str, "doPreDownload() map: taskid=" + i3 + "-> taskIdForTPProxy=" + start);
    }

    private int findTaskIdForTpProxy(int i3) {
        for (Map.Entry<Integer, Integer> entry : this.mTaskIdMap.entrySet()) {
            if (entry.getValue().intValue() == i3) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    private void initPreloadProxy() {
        if (this.mTPPreloadProxy == null) {
            synchronized (this) {
                if (this.mTPPreloadProxy == null && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                    this.mTPPreloadProxy = TPPreloaderFactory.createPreloader();
                    this.mTPPreloadProxy.setPreloadListener(new ITPPreloader.ITPPreloadListener() { // from class: com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.1
                        @Override // com.tencent.thumbplayer.api.preload.ITPPreloader.ITPPreloadListener
                        public void onPreloadError(int i3, TPError tPError) {
                            Integer num = (Integer) SPlayerPreDownloaderImpl.this.mTaskIdMap.remove(Integer.valueOf(i3));
                            if (num == null) {
                                return;
                            }
                            if (SPlayerPreDownloaderImpl.this.mCallbackListener != null) {
                                SPlayerPreDownloaderImpl.this.mCallbackListener.onPrepareError(num.intValue(), -1, tPError.getErrorCode(), "");
                            }
                            com.tencent.superplayer.report.b bVar = (com.tencent.superplayer.report.b) SPlayerPreDownloaderImpl.this.mReportMap.remove(Integer.valueOf(i3));
                            if (bVar != null) {
                                bVar.f373930b = false;
                                bVar.c();
                            }
                            SPlayerPreDownloaderImpl.this.mTPPreloadProxy.stop(i3);
                        }

                        @Override // com.tencent.thumbplayer.api.preload.ITPPreloader.ITPPreloadListener
                        public void onPreloadProgressUpdate(int i3, TPDownloadProgressInfo tPDownloadProgressInfo) {
                            Integer num = (Integer) SPlayerPreDownloaderImpl.this.mTaskIdMap.get(Integer.valueOf(i3));
                            if (num != null && SPlayerPreDownloaderImpl.this.mCallbackListener != null) {
                                SPlayerPreDownloaderImpl.this.mCallbackListener.onPrepareDownloadProgressUpdate(num.intValue(), (int) tPDownloadProgressInfo.getAvailablePositionMs(), (int) tPDownloadProgressInfo.getDownloadSpeedbps(), tPDownloadProgressInfo.getDownloadBytes(), tPDownloadProgressInfo.getFileTotalBytes(), tPDownloadProgressInfo.getExtraInfo());
                            }
                        }

                        @Override // com.tencent.thumbplayer.api.preload.ITPPreloader.ITPPreloadListener
                        public void onPreloadSuccess(int i3) {
                            Integer num = (Integer) SPlayerPreDownloaderImpl.this.mTaskIdMap.remove(Integer.valueOf(i3));
                            if (num == null) {
                                return;
                            }
                            if (SPlayerPreDownloaderImpl.this.mCallbackListener != null) {
                                SPlayerPreDownloaderImpl.this.mCallbackListener.onPrepareSuccess(num.intValue());
                            }
                            com.tencent.superplayer.report.b bVar = (com.tencent.superplayer.report.b) SPlayerPreDownloaderImpl.this.mReportMap.remove(Integer.valueOf(i3));
                            if (bVar != null) {
                                bVar.f373930b = true;
                                bVar.c();
                            }
                            SPlayerPreDownloaderImpl.this.mTPPreloadProxy.stop(i3);
                        }
                    });
                }
            }
        }
    }

    private void innerInitDownloadParamData(SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerDownOption superPlayerDownOption) {
        boolean z16;
        ITPMediaAsset mediaAssert = superPlayerVideoInfo.getMediaAssert();
        mediaAssert.setParam("task_file_type", String.valueOf(parseDownloadType(superPlayerVideoInfo)));
        if (!TextUtils.isEmpty(superPlayerVideoInfo.getLocalSavePath())) {
            mediaAssert.setParam("dl_param_save_path", superPlayerVideoInfo.getLocalSavePath());
        }
        mediaAssert.setParam("dl_param_need_cache", "true");
        mediaAssert.setParam("dl_param_file_duration", String.valueOf(superPlayerVideoInfo.getVideoDurationMs()));
        if (SuperPlayerSDKMgr.hasDeviceId() && superPlayerDownOption != null) {
            mediaAssert.setParam("dl_param_vinfo_fp2p", String.valueOf(superPlayerDownOption.enableP2P ? 1 : 0));
            if (superPlayerDownOption.enableP2P) {
                SuperPlayerSDKMgr.notifyEnterP2PScene(this.sceneId);
            }
        }
        mediaAssert.setParam("dl_param_play_flowid", UUID.randomUUID().toString() + System.nanoTime() + "_" + this.mServiceType);
        HashMap<String, String> extraDownloadParams = superPlayerVideoInfo.getExtraDownloadParams();
        if (extraDownloadParams != null) {
            for (Map.Entry<String, String> entry : extraDownloadParams.entrySet()) {
                mediaAssert.setParam(entry.getKey(), entry.getValue());
            }
        }
        if (superPlayerDownOption != null) {
            mediaAssert.setParam("dl_param_quic_enable_mode", String.valueOf(superPlayerDownOption.quicEnableMode));
            mediaAssert.setParam("dl_param_is_enable_quic_plaintext", String.valueOf(superPlayerDownOption.enableQuicPlaintext));
            mediaAssert.setParam("dl_param_is_enable_quic_connection_migration", String.valueOf(superPlayerDownOption.enableQuicConnectionMigration));
            mediaAssert.setParam("dl_param_quic_congestion_type", String.valueOf(superPlayerDownOption.quicCongestionType));
            mediaAssert.setParam("dl_param_enable_teg_pcdn", String.valueOf(superPlayerDownOption.enablePcdn));
            mediaAssert.setParam(TPDownloadProxyEnum.DL_PARAM_ENABLE_PRELOAD_LIMIT, String.valueOf(superPlayerDownOption.enablePreloadLimitSpeed));
            if (!superPlayerDownOption.enableBandwidthStats && !com.tencent.superplayer.bandwidth.a.a(this.sceneId)) {
                z16 = false;
            } else {
                z16 = true;
            }
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_BANDWIDTH_STATS_ENABLE, String.valueOf(z16));
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_BANDWIDTH_STATS_HOST, superPlayerDownOption.bandwidthReportHost);
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PCDN_FILE_MIN_BUFF_TIME, String.valueOf(superPlayerDownOption.pcdnMinBuffTime));
            mediaAssert.setParam(TPDownloadProxyEnum.DLPARAM_PCDN_FILE_PROTECT_BUFF_TIME, String.valueOf(superPlayerDownOption.pcdnProtectBuffTime));
            mediaAssert.setParam("dl_param_pcdn_charge_id", superPlayerDownOption.pcdnChargeId);
            mediaAssert.setParam(TPDownloadProxyEnum.DL_PARAM_ENABLE_PRELOAD_LIMIT, String.valueOf(superPlayerDownOption.enablePreloadLimitSpeed));
        }
    }

    private int parseDownloadType(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (superPlayerVideoInfo == null) {
            return 0;
        }
        int format = superPlayerVideoInfo.getFormat();
        if (format != 101) {
            if (format != 102) {
                if (format != 104 && format != 107) {
                    if (format != 201 && format != 401) {
                        switch (format) {
                            case 301:
                                break;
                            case 302:
                                break;
                            case 303:
                                return 2;
                            default:
                                return 0;
                        }
                    } else {
                        return 5;
                    }
                } else {
                    return 10;
                }
            }
            return 3;
        }
        return 1;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void destory() {
        LogUtil.d(TAG, "destory()");
        this.mCallbackListener = null;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void setOnPreDownloadListener(ISPlayerPreDownloader.Listener listener) {
        this.mCallbackListener = listener;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16) {
        superPlayerVideoInfo.setVideoDurationMs(j3);
        superPlayerVideoInfo.setPreloadDurationMs(j16);
        ITPMediaAsset creMediaAsset = creMediaAsset(superPlayerVideoInfo, j3, j16, null);
        int addAndGet = this.mTaskIdIncreaser.addAndGet(1);
        LogUtil.d(TAG, "startPreDownload() videoInfo=" + superPlayerVideoInfo.toString() + ", videoDurationMs=" + j3 + ", preloadDurationMs=" + j16 + ", taskId=" + addAndGet);
        createPreDownloadTask(superPlayerVideoInfo, creMediaAsset, addAndGet);
        return addAndGet;
    }

    @Override // com.tencent.superplayer.tvkplayer.datatransport.ITVKPlayerPreDownloader
    public int startTVKPreDownload(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ISPlayerPreDownloader.Listener listener) {
        throw new MethodNotSupportedException("startTVKPreDownload is not supported in SuperPlayer");
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void stopAllPreDownload() {
        if (this.mTPPreloadProxy == null) {
            return;
        }
        synchronized (this.mTaskIdMap) {
            LogUtil.d(TAG, "stopAllPreDownload(), mTaskIdMap.size()=" + this.mTaskIdMap.size());
            Iterator<Integer> it = this.mTaskIdMap.keySet().iterator();
            while (it.hasNext()) {
                final int intValue = it.next().intValue();
                ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtil.d(SPlayerPreDownloaderImpl.TAG, "stopAllPreDownload(), stop taskIdForTPProxy=" + intValue);
                        SPlayerPreDownloaderImpl.this.mTPPreloadProxy.stop(intValue);
                    }
                });
            }
            this.mTaskIdMap.clear();
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void stopPreDownload(final int i3) {
        LogUtil.d(TAG, "stopPreDownload() taskid=" + i3);
        if (this.mTPPreloadProxy == null) {
            return;
        }
        synchronized (this.mTaskIdMap) {
            if (this.mTaskIdMap.containsValue(Integer.valueOf(i3))) {
                final int findTaskIdForTpProxy = findTaskIdForTpProxy(i3);
                ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtil.d(SPlayerPreDownloaderImpl.TAG, "stopPreDownload() taskId=" + i3 + "->taskIdForTPProxy:" + findTaskIdForTpProxy);
                        SPlayerPreDownloaderImpl.this.mTPPreloadProxy.stop(findTaskIdForTpProxy);
                    }
                });
                this.mTaskIdMap.remove(Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3) {
        superPlayerVideoInfo.setPreloadSize(j3);
        int addAndGet = this.mTaskIdIncreaser.addAndGet(1);
        ITPMediaAsset creMediaAsset = creMediaAsset(superPlayerVideoInfo, superPlayerVideoInfo.getVideoDurationMs(), 0L, null);
        creMediaAsset.setParam("dl_param_preload_size", String.valueOf(j3));
        LogUtil.d(TAG, "startPreDownload() videoInfo=" + superPlayerVideoInfo.toString() + ", preloadSize=" + j3 + ", taskId=" + addAndGet);
        createPreDownloadTask(superPlayerVideoInfo, creMediaAsset, addAndGet);
        return addAndGet;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16, SuperPlayerDownOption superPlayerDownOption) {
        superPlayerVideoInfo.setVideoDurationMs(j3);
        superPlayerVideoInfo.setPreloadDurationMs(j16);
        int addAndGet = this.mTaskIdIncreaser.addAndGet(1);
        ITPMediaAsset creMediaAsset = creMediaAsset(superPlayerVideoInfo, j3, j16, superPlayerDownOption);
        LogUtil.d(TAG, "startPreDownload() videoInfo=" + superPlayerVideoInfo.toString() + ", videoDurationMs=" + j3 + ", preloadDurationMs=" + j16 + ", taskId=" + addAndGet);
        createPreDownloadTask(superPlayerVideoInfo, creMediaAsset, addAndGet);
        return addAndGet;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerDownOption superPlayerDownOption) {
        superPlayerVideoInfo.setPreloadSize(j3);
        int addAndGet = this.mTaskIdIncreaser.addAndGet(1);
        ITPMediaAsset creMediaAsset = creMediaAsset(superPlayerVideoInfo, superPlayerVideoInfo.getVideoDurationMs(), 0L, superPlayerDownOption);
        creMediaAsset.setParam("dl_param_preload_size", String.valueOf(j3));
        LogUtil.d(TAG, "startPreDownload() videoInfo=" + superPlayerVideoInfo.toString() + ", preloadSize=" + j3 + ", taskId=" + addAndGet);
        createPreDownloadTask(superPlayerVideoInfo, creMediaAsset, addAndGet);
        return addAndGet;
    }
}
