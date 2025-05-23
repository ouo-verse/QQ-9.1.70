package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureGroup;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKLiveInfoListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveInfoGetter implements ITVKLiveInfoGetter {
    private static final String MODULE_NAME = "TVKLiveInfoGetter";
    private static final AtomicInteger REQUEST_ID_BASE = new AtomicInteger(30000);
    private Handler mCallbackHandler;
    private ITVKLiveInfoGetter.ITVKLiveInfoGetterListener mListener;
    private final ITVKLogger mLogger;
    private final ITVKLiveInfoListener mRequestListener = new ITVKLiveInfoListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.1
        @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKLiveInfoListener
        public void onFailure(final int i3, final TVKError tVKError) {
            if (!TVKLiveInfoGetter.this.mRequestMap.containsKey(Integer.valueOf(i3))) {
                TVKLiveInfoGetter.this.mLogger.error("[handleOnFailure] request canceled ,return", new Object[0]);
            } else if (TVKLiveInfoGetter.this.mCallbackHandler == null) {
                TVKLiveInfoGetter.this.handleOnFailure(i3, tVKError);
            } else {
                TVKLiveInfoGetter.this.mCallbackHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TVKLiveInfoGetter.this.handleOnFailure(i3, tVKError);
                    }
                });
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKLiveInfoListener
        public void onSuccess(final int i3, final TVKLiveVideoInfo tVKLiveVideoInfo) {
            if (!TVKLiveInfoGetter.this.mRequestMap.containsKey(Integer.valueOf(i3))) {
                TVKLiveInfoGetter.this.mLogger.error("[handleOnSuccess] request canceled ,return", new Object[0]);
            } else if (TVKLiveInfoGetter.this.mCallbackHandler == null) {
                TVKLiveInfoGetter.this.handleOnSuccess(i3, tVKLiveVideoInfo);
            } else {
                TVKLiveInfoGetter.this.mCallbackHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TVKLiveInfoGetter.this.handleOnSuccess(i3, tVKLiveVideoInfo);
                    }
                });
            }
        }
    };
    private final ConcurrentHashMap<Integer, TVKLiveInfoRequest> mRequestMap;
    private final TVKContext mTVKContext;

    public TVKLiveInfoGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        if (looper != null) {
            this.mCallbackHandler = new Handler(looper);
        }
        this.mTVKContext = tVKContext;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mRequestMap = new ConcurrentHashMap<>();
    }

    private void addRequest(int i3, TVKLiveInfoRequest tVKLiveInfoRequest) {
        this.mRequestMap.put(Integer.valueOf(i3), tVKLiveInfoRequest);
    }

    private int createLiveInfoRequest(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup, int i3) throws IllegalArgumentException {
        int incrementAndGet = REQUEST_ID_BASE.incrementAndGet();
        TVKLiveInfoRequest tVKLiveInfoRequest = new TVKLiveInfoRequest(incrementAndGet, this.mTVKContext, new TVKLiveRequestBuilder(this.mTVKContext, tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, i3), new TVKLiveInfoParser(iTVKFeatureGroup), this.mRequestListener);
        addRequest(incrementAndGet, tVKLiveInfoRequest);
        tVKLiveInfoRequest.execute();
        return incrementAndGet;
    }

    private TVKLiveInfoRequest findAndRemoveRequest(int i3) {
        if (this.mRequestMap.containsKey(Integer.valueOf(i3))) {
            return this.mRequestMap.remove(Integer.valueOf(i3));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFailure(int i3, TVKError tVKError) {
        TVKLiveInfoRequest findAndRemoveRequest = findAndRemoveRequest(i3);
        ITVKLiveInfoGetter.ITVKLiveInfoGetterListener iTVKLiveInfoGetterListener = this.mListener;
        if (findAndRemoveRequest != null && iTVKLiveInfoGetterListener != null) {
            iTVKLiveInfoGetterListener.onFailure(i3, tVKError);
        } else {
            this.mLogger.error("[handleOnFailure] request canceled ,return", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSuccess(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
        TVKLiveInfoRequest findAndRemoveRequest = findAndRemoveRequest(i3);
        ITVKLiveInfoGetter.ITVKLiveInfoGetterListener iTVKLiveInfoGetterListener = this.mListener;
        if (findAndRemoveRequest != null && iTVKLiveInfoGetterListener != null) {
            iTVKLiveInfoGetterListener.onSuccess(i3, tVKLiveVideoInfo);
        } else {
            this.mLogger.error("[handleOnSuccess] request canceled ,return", new Object[0]);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter
    public void cancelRequest(int i3) {
        TVKLiveInfoRequest findAndRemoveRequest = findAndRemoveRequest(i3);
        if (findAndRemoveRequest != null) {
            findAndRemoveRequest.cancel();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter
    public int inquireLiveInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return createLiveInfoRequest(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 4);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter
    public int requestDlnaPlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return createLiveInfoRequest(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 3);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter
    public int requestLivePlayInfo(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureGroup iTVKFeatureGroup, ITVKFeatureParamGroup iTVKFeatureParamGroup) throws IllegalArgumentException {
        return createLiveInfoRequest(tVKCGIRequestParam, iTVKFeatureGroup, iTVKFeatureParamGroup, 0);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter
    public void setLiveInfoListener(ITVKLiveInfoGetter.ITVKLiveInfoGetterListener iTVKLiveInfoGetterListener) {
        this.mListener = iTVKLiveInfoGetterListener;
    }
}
