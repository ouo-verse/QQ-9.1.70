package com.tencent.thumbplayer.core.datatransport.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;

/* loaded from: classes26.dex */
public class TPDataTransportLifecycleObserver implements LifecycleObserver {
    private final ITPDataTransportLog mLogger;

    public TPDataTransportLifecycleObserver() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPDataTransportLifecycleObserver");
        this.mLogger = logger;
        logger.i("construct lifecycle observer");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        this.mLogger.i("on create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onPause() {
        this.mLogger.i("on pause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        this.mLogger.i("on resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onStart() {
        this.mLogger.i("on start");
        TPDataTransportMgr.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE, String.valueOf(0));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onStop() {
        this.mLogger.i("on stop");
        TPDataTransportMgr.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE, String.valueOf(1));
    }
}
