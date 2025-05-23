package com.tencent.qqlive.tvkplayer.vinfo.highrail;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKHighRailInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCheckTimeListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHighRailInfoGetter implements ITVKHighRailInfoGetter {
    private static final AtomicInteger REQUEST_ID_BASE = new AtomicInteger(sdk_event_log.SdkEventDimension.EVENT_CLICK);
    private static final String TAG = "TVKPlayer[TVKHighRailInfoGetter]";
    private Handler mCallbackHandler;
    private final ITVKCheckTimeListener mCheckTimeListener;
    private ITVKHighRailInfoGetter.ITVKHighRailInfoGetterListener mListener;
    private CopyOnWriteArrayList<Integer> mRequestList;

    public TVKHighRailInfoGetter(@NonNull TVKContext tVKContext, @Nullable Looper looper) {
        ITVKCheckTimeListener iTVKCheckTimeListener = new ITVKCheckTimeListener() { // from class: com.tencent.qqlive.tvkplayer.vinfo.highrail.TVKHighRailInfoGetter.1
            @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCheckTimeListener
            public void onFailure(int i3) {
                if (TVKHighRailInfoGetter.this.mRequestList.size() > 0) {
                    Iterator it = TVKHighRailInfoGetter.this.mRequestList.iterator();
                    while (it.hasNext()) {
                        TVKHighRailInfoGetter.this.dealOnFailure(((Integer) it.next()).intValue(), i3);
                    }
                    TVKHighRailInfoGetter.this.mRequestList.clear();
                }
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCheckTimeListener
            public void onSuccess() {
                if (TVKHighRailInfoGetter.this.mRequestList.size() > 0) {
                    Iterator it = TVKHighRailInfoGetter.this.mRequestList.iterator();
                    while (it.hasNext()) {
                        TVKHighRailInfoGetter.this.dealOnSuccess(((Integer) it.next()).intValue());
                    }
                    TVKHighRailInfoGetter.this.mRequestList.clear();
                }
            }
        };
        this.mCheckTimeListener = iTVKCheckTimeListener;
        if (looper != null) {
            this.mCallbackHandler = new Handler(looper);
        }
        this.mRequestList = new CopyOnWriteArrayList<>();
        TVKHighRailCheckTime.getInstance().setListener(iTVKCheckTimeListener);
    }

    private void addRequest(int i3) {
        this.mRequestList.add(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealOnFailure(final int i3, int i16) {
        final ITVKHighRailInfoGetter.ITVKHighRailInfoGetterListener iTVKHighRailInfoGetterListener = this.mListener;
        if (findAndRemoveRequest(i3) && iTVKHighRailInfoGetterListener != null) {
            final TVKError tVKError = new TVKError(TVKCommonErrorCodeUtil.MODULE.CGI_GETVINFO_ERR, i16);
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.highrail.TVKHighRailInfoGetter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        iTVKHighRailInfoGetterListener.onHighRailInfoFailure(i3, tVKError);
                    }
                });
            } else {
                iTVKHighRailInfoGetterListener.onHighRailInfoFailure(i3, tVKError);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealOnSuccess(final int i3) {
        final ITVKHighRailInfoGetter.ITVKHighRailInfoGetterListener iTVKHighRailInfoGetterListener = this.mListener;
        if (findAndRemoveRequest(i3) && iTVKHighRailInfoGetterListener != null) {
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.highrail.TVKHighRailInfoGetter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        iTVKHighRailInfoGetterListener.onHighRailInfoSuccess(i3, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_HIGH_RAIL_HOST), TVKHighRailCheckTime.mServerTimeSec);
                    }
                });
                return;
            } else {
                iTVKHighRailInfoGetterListener.onHighRailInfoSuccess(i3, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_HIGH_RAIL_HOST), TVKHighRailCheckTime.mServerTimeSec);
                return;
            }
        }
        TVKLogUtil.w(TAG, "VOD CGI: canceled or listener is null, return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealRequest(int i3) {
        ITVKHighRailInfoGetter.ITVKHighRailInfoGetterListener iTVKHighRailInfoGetterListener = this.mListener;
        if (findAndRemoveRequest(i3) && iTVKHighRailInfoGetterListener != null) {
            iTVKHighRailInfoGetterListener.onHighRailInfoSuccess(i3, TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_VINFO_HIGH_RAIL_HOST), TVKHighRailCheckTime.mServerTimeSec);
        } else {
            TVKLogUtil.w(TAG, "VOD CGI: canceled or listener is null, return");
        }
    }

    private boolean findAndRemoveRequest(int i3) {
        if (this.mRequestList.contains(Integer.valueOf(i3))) {
            removeRequest(i3);
            return true;
        }
        return false;
    }

    private void removeRequest(int i3) {
        this.mRequestList.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKHighRailInfoGetter
    public void cancelRequest(int i3) {
        removeRequest(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKHighRailInfoGetter
    public int requestPlayInfo(@NonNull String str) {
        final int incrementAndGet = REQUEST_ID_BASE.incrementAndGet();
        addRequest(incrementAndGet);
        if (TVKHighRailCheckTime.mServerTimeSec > 0) {
            Runnable runnable = new Runnable() { // from class: com.tencent.qqlive.tvkplayer.vinfo.highrail.TVKHighRailInfoGetter.2
                @Override // java.lang.Runnable
                public void run() {
                    TVKHighRailInfoGetter.this.dealRequest(incrementAndGet);
                }
            };
            Handler handler = this.mCallbackHandler;
            if (handler != null) {
                handler.post(runnable);
            } else {
                TVKThreadPool.getInstance().obtainHighPriorityExecutor().execute(runnable);
            }
            return incrementAndGet;
        }
        TVKHighRailCheckTime.getInstance().execute();
        return incrementAndGet;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKHighRailInfoGetter
    public void setListener(ITVKHighRailInfoGetter.ITVKHighRailInfoGetterListener iTVKHighRailInfoGetterListener) {
        this.mListener = iTVKHighRailInfoGetterListener;
    }
}
