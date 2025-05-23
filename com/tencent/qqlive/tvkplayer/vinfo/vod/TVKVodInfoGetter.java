package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.context.TVKDebugTrackingEventReporter;
import com.tencent.qqlive.tvkplayer.context.TVKReportEventParamsInner;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoProxyCacheListener;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKVodFeature;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIRequestBase;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVodInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodInfoGetter implements ITVKVodInfoGetter {
    private static final String MODULE_NAME = "TVKVodInfoGetter";
    private static final AtomicInteger REQUEST_ID_BASE = new AtomicInteger(AECameraConstants.TRIBE_MAX_RATE);
    private ITVKVodInfoProxyCacheListener mCacheListener;
    private Handler mCallbackHandler;
    private ITVKVodInfoGetter.ITVKVodInfoGetterListener mListener;
    private final ITVKLogger mLogger;
    ITVKVodInfoListener mRequestListener = new AnonymousClass1();
    private final ConcurrentHashMap<Integer, ITVKCGIRequestBase> mRequestMap;

    @NonNull
    private final TVKContext mTVKContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements ITVKVodInfoListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$0(int i3, TVKError tVKError) {
            TVKVodInfoGetter.this.handleOnFailure(i3, tVKError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$1(int i3, TVKVodVideoInfo tVKVodVideoInfo) {
            TVKVodInfoGetter.this.handleOnSuccess(i3, tVKVodVideoInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVodInfoListener
        public void onFailure(final int i3, final TVKError tVKError) {
            if (!TVKVodInfoGetter.this.mRequestMap.containsKey(Integer.valueOf(i3))) {
                TVKVodInfoGetter.this.mLogger.error("[onFailure] request canceled, requestId=" + i3, new Object[0]);
                return;
            }
            if (TVKVodInfoGetter.this.mCallbackHandler == null) {
                TVKVodInfoGetter.this.handleOnFailure(i3, tVKError);
            } else {
                TVKVodInfoGetter.this.mCallbackHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKVodInfoGetter.AnonymousClass1.this.lambda$onFailure$0(i3, tVKError);
                    }
                });
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKVodInfoListener
        public void onSuccess(final int i3, final TVKVodVideoInfo tVKVodVideoInfo) {
            if (!TVKVodInfoGetter.this.mRequestMap.containsKey(Integer.valueOf(i3))) {
                TVKVodInfoGetter.this.mLogger.error("[onSuccess] request canceled, requestId=" + i3, new Object[0]);
                return;
            }
            if (TVKVodInfoGetter.this.mCallbackHandler == null) {
                TVKVodInfoGetter.this.handleOnSuccess(i3, tVKVodVideoInfo);
            } else {
                TVKVodInfoGetter.this.mCallbackHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.vod.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKVodInfoGetter.AnonymousClass1.this.lambda$onSuccess$1(i3, tVKVodVideoInfo);
                    }
                });
            }
        }
    }

    public TVKVodInfoGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        if (looper != null) {
            this.mCallbackHandler = new Handler(looper);
        }
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mRequestMap = new ConcurrentHashMap<>();
    }

    private void addRequest(int i3, ITVKCGIRequestBase iTVKCGIRequestBase) {
        this.mLogger.info("addRequest, requestId=" + i3 + " request=" + iTVKCGIRequestBase, new Object[0]);
        this.mRequestMap.put(Integer.valueOf(i3), iTVKCGIRequestBase);
    }

    private ITVKCGIRequestBase createVodInfoRequest(int i3, TVKVodRequestBuilder tVKVodRequestBuilder, ITVKFeatureGroup iTVKFeatureGroup, TVKVodProxyCache tVKVodProxyCache) {
        List<ITVKVodFeature> vodFeatureList;
        if (iTVKFeatureGroup == null) {
            vodFeatureList = null;
        } else {
            vodFeatureList = iTVKFeatureGroup.getVodFeatureList();
        }
        if (tVKVodRequestBuilder.getRequestType() == 2) {
            return new TVKVodOfflineInfoRequest(i3, this.mTVKContext, tVKVodRequestBuilder, new TVKVodInfoParser(vodFeatureList, this.mLogger), tVKVodProxyCache, this.mRequestListener);
        }
        return new TVKVodOnlineInfoRequest(i3, this.mTVKContext, tVKVodRequestBuilder, new TVKVodInfoParser(vodFeatureList, this.mLogger), tVKVodProxyCache, this.mRequestListener);
    }

    private ITVKCGIRequestBase findAndRemoveRequest(int i3) {
        if (this.mRequestMap.containsKey(Integer.valueOf(i3))) {
            this.mLogger.info("remove requestId=" + i3 + " from requestMap", new Object[0]);
            return this.mRequestMap.remove(Integer.valueOf(i3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFailure(int i3, TVKError tVKError) {
        ITVKCGIRequestBase findAndRemoveRequest = findAndRemoveRequest(i3);
        ITVKVodInfoGetter.ITVKVodInfoGetterListener iTVKVodInfoGetterListener = this.mListener;
        if (findAndRemoveRequest != null && iTVKVodInfoGetterListener != null) {
            iTVKVodInfoGetterListener.onFailure(i3, tVKError);
            return;
        }
        this.mLogger.error("[handleOnFailure] request canceled, requestId=" + i3 + ", listener=" + iTVKVodInfoGetterListener, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSuccess(int i3, TVKVodVideoInfo tVKVodVideoInfo) {
        ITVKCGIRequestBase findAndRemoveRequest = findAndRemoveRequest(i3);
        ITVKVodInfoGetter.ITVKVodInfoGetterListener iTVKVodInfoGetterListener = this.mListener;
        if (findAndRemoveRequest != null && iTVKVodInfoGetterListener != null) {
            reportEvent(ITVKReportEventListener.ReportEvent.TVK_REPORT_EVENT_CGI_THREAD_CHANGE_TO_PLAYER_THREAD, new TVKReportEventParamsInner.Builder().build());
            iTVKVodInfoGetterListener.onSuccess(i3, tVKVodVideoInfo);
            return;
        }
        this.mLogger.error("[handleOnSuccess] request canceled, requestId=" + i3 + ", listener=" + iTVKVodInfoGetterListener, new Object[0]);
    }

    private void reportEvent(@NonNull ITVKReportEventListener.ReportEvent reportEvent, @NonNull TVKReportEventParamsInner tVKReportEventParamsInner) {
        TVKDebugTrackingEventReporter debugTrackingEventReporter = this.mTVKContext.getDebugTrackingEventReporter();
        if (debugTrackingEventReporter == null) {
            this.mLogger.warn("onReportPushEvent, debugTrackingEventReporter == null", new Object[0]);
            return;
        }
        this.mLogger.info("event happens: " + reportEvent.name() + " in UTC timeMs=" + tVKReportEventParamsInner.getTimeSince1970Ms(), new Object[0]);
        debugTrackingEventReporter.sendEvent(reportEvent, tVKReportEventParamsInner);
    }

    private int request(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup, int i3) throws IllegalArgumentException {
        int incrementAndGet = REQUEST_ID_BASE.incrementAndGet();
        ITVKCGIRequestBase createVodInfoRequest = createVodInfoRequest(incrementAndGet, new TVKVodRequestBuilder(this.mTVKContext, tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, i3), iTVKFeatureGroup, new TVKVodProxyCache(this.mTVKContext, tVKCGIRequestParam.getVideoInfo(), tVKCGIRequestParam.getAsset(), tVKCGIRequestParam.getDefinition(), this.mCacheListener));
        addRequest(incrementAndGet, createVodInfoRequest);
        createVodInfoRequest.execute();
        return incrementAndGet;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public void cancelRequest(int i3) {
        this.mLogger.info("call cancel request, requestId=" + i3, new Object[0]);
        ITVKCGIRequestBase findAndRemoveRequest = findAndRemoveRequest(i3);
        if (findAndRemoveRequest != null) {
            findAndRemoveRequest.cancel();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public int requestDlnaPlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return request(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 3);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public int requestOfflineDownloadInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return request(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 1);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public int requestOfflinePlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return request(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 2);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public int requestOnlinePlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return request(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 0);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public void setProxyCacheListener(ITVKVodInfoProxyCacheListener iTVKVodInfoProxyCacheListener) {
        this.mCacheListener = iTVKVodInfoProxyCacheListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter
    public void setVodInfoListener(ITVKVodInfoGetter.ITVKVodInfoGetterListener iTVKVodInfoGetterListener) {
        this.mListener = iTVKVodInfoGetterListener;
    }
}
