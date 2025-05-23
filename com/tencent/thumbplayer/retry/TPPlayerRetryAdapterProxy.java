package com.tencent.thumbplayer.retry;

import androidx.annotation.NonNull;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;
import com.tencent.thumbplayer.impl.TPInnerPlayerListeners;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPPlayerRetryAdapterProxy implements InvocationHandler {
    private static final String METHOD_NAME_PAUSE = "pause";
    private static final String METHOD_NAME_PREPARE = "prepareAsync";
    private static final String METHOD_NAME_RELEASE = "release";
    private static final String METHOD_NAME_RESET = "reset";
    private static final String METHOD_NAME_SEEK_TO = "seekToAsync";
    private static final String METHOD_NAME_SELECT_TRACK_ASYNC = "selectTrackAsync";
    private static final String METHOD_NAME_SET_ON_ERROR_LISTENER = "setOnErrorListener";
    private static final String METHOD_NAME_SET_ON_INFO_LISTENER = "setOnInfoListener";
    private static final String METHOD_NAME_SET_ON_PREPARED_LISTENER = "setOnPreparedListener";
    private static final String METHOD_NAME_SET_ON_SEEK_COMPLETION_LISTENER = "setOnSeekCompleteListener";
    private static final String METHOD_NAME_SET_PLAY_SPEED = "setPlaySpeedRatio";
    private static final String METHOD_NAME_START = "start";
    private static final String METHOD_NAME_STOP = "stop";
    private static final Map<String, Class> REPORT_LISTENER_CLASS_MAP;
    private static final String TAG = "TPPlayerRetryAdapterProxy";
    private TPInnerPlayerListeners mPlayerListeners = new TPInnerPlayerListeners(TAG);
    private TPPlayerRetryAdapter mRetryAdapter;
    private Object mRetryAdapterInterfaceProxy;
    private TPPlayerRetryAdapterProxyListeners mRetryAdapterProxyListeners;
    private TPContext mTPContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class TPPlayerRetryAdapterProxyListeners implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPInnerPlayerListener.IOnEventRecordListener {
        TPPlayerRetryAdapterProxyListeners() {
        }

        private void publishBufferingEndEvent(TPOnInfoParam tPOnInfoParam) {
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.BufferingEndEventInfo());
        }

        private void publishBufferingStartEvent(TPOnInfoParam tPOnInfoParam) {
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.BufferingStartEventInfo());
        }

        private void publishSelectTrackEndEvent(TPOnInfoParam tPOnInfoParam) {
            TPPlayerEventInfo.SelectTrackEndEventInfo selectTrackEndEventInfo = new TPPlayerEventInfo.SelectTrackEndEventInfo();
            selectTrackEndEventInfo.setOpaque(tPOnInfoParam.getLongParam1());
            if (tPOnInfoParam.getObjParam() instanceof TPError) {
                selectTrackEndEventInfo.setError((TPError) tPOnInfoParam.getObjParam());
            }
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(selectTrackEndEventInfo);
        }

        @Override // com.tencent.thumbplayer.impl.ITPInnerPlayerListener.IOnEventRecordListener
        public void onDrmInfo(ITPInnerPlayer iTPInnerPlayer, TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            TPPlayerEventInfo.DrmEventInfo drmEventInfo = new TPPlayerEventInfo.DrmEventInfo();
            drmEventInfo.setDrmPlayFlow(tPPlayerDrmParams);
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(drmEventInfo);
            TPPlayerRetryAdapterProxy.this.mPlayerListeners.onDrmInfo(iTPInnerPlayer, tPPlayerDrmParams);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            TPPlayerEventInfo.PlayErrorEventInfo playErrorEventInfo = new TPPlayerEventInfo.PlayErrorEventInfo();
            playErrorEventInfo.setError(tPError);
            TPGeneralPlayFlowParams generalPlayFlowParams = TPPlayerRetryAdapterProxy.this.mRetryAdapter.getGeneralPlayFlowParams();
            if (generalPlayFlowParams == null) {
                generalPlayFlowParams = new TPGeneralPlayFlowParams();
            }
            playErrorEventInfo.setGeneralPlayFlowParams(generalPlayFlowParams);
            TPDynamicStatisticParams dynamicStatisticParams = TPPlayerRetryAdapterProxy.this.mRetryAdapter.getDynamicStatisticParams(false);
            if (dynamicStatisticParams == null) {
                dynamicStatisticParams = new TPDynamicStatisticParams();
            }
            playErrorEventInfo.setDynamicStatisticParams(dynamicStatisticParams);
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(playErrorEventInfo);
            TPPlayerRetryAdapterProxy.this.mPlayerListeners.onError(iTPPlayer, tPError);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            if (i3 != 10 && i3 != 11) {
                if (i3 != 200) {
                    if (i3 == 201) {
                        publishBufferingEndEvent(tPOnInfoParam);
                    }
                } else {
                    publishBufferingStartEvent(tPOnInfoParam);
                }
            } else {
                publishSelectTrackEndEvent(tPOnInfoParam);
            }
            TPPlayerRetryAdapterProxy.this.mPlayerListeners.onInfo(iTPPlayer, i3, tPOnInfoParam);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            TPPlayerEventInfo.PrepareEndEventInfo prepareEndEventInfo = new TPPlayerEventInfo.PrepareEndEventInfo();
            prepareEndEventInfo.setPlayerCoreType(TPPlayerRetryAdapterProxy.this.mRetryAdapter.getPlayerCoreType());
            prepareEndEventInfo.setDurationMs(TPPlayerRetryAdapterProxy.this.mRetryAdapter.getDurationMs());
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(prepareEndEventInfo);
            TPPlayerRetryAdapterProxy.this.mPlayerListeners.onPrepared(iTPPlayer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            TPPlayerRetryAdapterProxy.this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.SeekEndEventInfo());
            TPPlayerRetryAdapterProxy.this.mPlayerListeners.onSeekComplete(iTPPlayer, j3);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        REPORT_LISTENER_CLASS_MAP = hashMap;
        hashMap.put(METHOD_NAME_SET_ON_PREPARED_LISTENER, ITPPlayerListener.IOnPreparedListener.class);
        hashMap.put(METHOD_NAME_SET_ON_INFO_LISTENER, ITPPlayerListener.IOnInfoListener.class);
        hashMap.put(METHOD_NAME_SET_ON_ERROR_LISTENER, ITPPlayerListener.IOnErrorListener.class);
        hashMap.put(METHOD_NAME_SET_ON_SEEK_COMPLETION_LISTENER, ITPPlayerListener.IOnSeekCompleteListener.class);
    }

    public TPPlayerRetryAdapterProxy(@NonNull TPPlayerRetryAdapter tPPlayerRetryAdapter, @NonNull TPContext tPContext) {
        TPPlayerRetryAdapterProxyListeners tPPlayerRetryAdapterProxyListeners = new TPPlayerRetryAdapterProxyListeners();
        this.mRetryAdapterProxyListeners = tPPlayerRetryAdapterProxyListeners;
        this.mRetryAdapter = tPPlayerRetryAdapter;
        this.mTPContext = tPContext;
        tPPlayerRetryAdapter.setOnEventRecordListener(tPPlayerRetryAdapterProxyListeners);
    }

    private static Object dealReturn(Method method) {
        String name = method.getReturnType().getName();
        if (name.equals(HippyControllerProps.BOOLEAN)) {
            return Boolean.FALSE;
        }
        if (name.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
            return 0;
        }
        if (name.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
            return 0L;
        }
        if (name.equals("float")) {
            return Float.valueOf(0.0f);
        }
        return null;
    }

    private void doHookListener(@NonNull Method method, Object[] objArr) {
        Map<String, Class> map = REPORT_LISTENER_CLASS_MAP;
        if (!map.containsKey(method.getName())) {
            return;
        }
        try {
            this.mPlayerListeners.getClass().getMethod(method.getName(), map.get(method.getName())).invoke(this.mPlayerListeners, objArr[0]);
            objArr[0] = this.mRetryAdapterProxyListeners;
        } catch (Exception e16) {
            TPLogUtil.e(TAG, "doHookListener " + method.getName() + " has excecption: " + e16);
        }
    }

    private void doPublishEventIfNeed(@NonNull Method method, Object[] objArr) {
        String name = method.getName();
        name.hashCode();
        char c16 = '\uffff';
        switch (name.hashCode()) {
            case -2055859787:
                if (name.equals(METHOD_NAME_PREPARE)) {
                    c16 = 0;
                    break;
                }
                break;
            case 3540994:
                if (name.equals("stop")) {
                    c16 = 1;
                    break;
                }
                break;
            case 106440182:
                if (name.equals("pause")) {
                    c16 = 2;
                    break;
                }
                break;
            case 108404047:
                if (name.equals("reset")) {
                    c16 = 3;
                    break;
                }
                break;
            case 109757538:
                if (name.equals("start")) {
                    c16 = 4;
                    break;
                }
                break;
            case 218603354:
                if (name.equals(METHOD_NAME_SET_PLAY_SPEED)) {
                    c16 = 5;
                    break;
                }
                break;
            case 1090594823:
                if (name.equals("release")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1251142441:
                if (name.equals(METHOD_NAME_SEEK_TO)) {
                    c16 = 7;
                    break;
                }
                break;
            case 1459371533:
                if (name.equals(METHOD_NAME_SELECT_TRACK_ASYNC)) {
                    c16 = '\b';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                publishPrepareEvent(objArr);
                return;
            case 1:
                publishStopEvent(objArr);
                return;
            case 2:
                publishPauseEvent(objArr);
                return;
            case 3:
                publishResetEvent(objArr);
                return;
            case 4:
                publishStartEvent(objArr);
                return;
            case 5:
                publishSetPlaySpeedRatioEvent(objArr);
                return;
            case 6:
                publishReleaseEvent(objArr);
                return;
            case 7:
                publishSeekToEvent(objArr);
                return;
            case '\b':
                publishSelectTrackAsyncEvent(objArr);
                return;
            default:
                return;
        }
    }

    private void publishPauseEvent(Object[] objArr) {
        this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.PlayPauseEventInfo());
    }

    private void publishReleaseEvent(Object[] objArr) {
        this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.PlayReleaseEventInfo());
    }

    private void publishResetEvent(Object[] objArr) {
        TPPlayerEventInfo.PlayResetEventInfo playResetEventInfo = new TPPlayerEventInfo.PlayResetEventInfo();
        TPGeneralPlayFlowParams generalPlayFlowParams = this.mRetryAdapter.getGeneralPlayFlowParams();
        if (generalPlayFlowParams == null) {
            generalPlayFlowParams = new TPGeneralPlayFlowParams();
        }
        playResetEventInfo.setGeneralPlayFlowParams(generalPlayFlowParams);
        TPDynamicStatisticParams dynamicStatisticParams = this.mRetryAdapter.getDynamicStatisticParams(false);
        if (dynamicStatisticParams == null) {
            dynamicStatisticParams = new TPDynamicStatisticParams();
        }
        playResetEventInfo.setDynamicStatisticParams(dynamicStatisticParams);
        this.mTPContext.getPlayerEventPublisher().publishEvent(playResetEventInfo);
    }

    private void publishSeekToEvent(Object[] objArr) {
        this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.SeekStartEventInfo());
    }

    private void publishSelectTrackAsyncEvent(Object[] objArr) {
        TPPlayerEventInfo.SelectTrackStartEventInfo selectTrackStartEventInfo = new TPPlayerEventInfo.SelectTrackStartEventInfo();
        selectTrackStartEventInfo.setTrackIndex(((Integer) objArr[0]).intValue());
        selectTrackStartEventInfo.setOpaque(((Long) objArr[1]).longValue());
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue >= 0 && intValue < this.mRetryAdapter.getTrackInfo().length) {
            selectTrackStartEventInfo.setTrackInfo(this.mRetryAdapter.getTrackInfo()[intValue]);
        }
        this.mTPContext.getPlayerEventPublisher().publishEvent(selectTrackStartEventInfo);
    }

    private void publishSetPlaySpeedRatioEvent(Object[] objArr) {
        TPPlayerEventInfo.SetPlaySpeedEventInfo setPlaySpeedEventInfo = new TPPlayerEventInfo.SetPlaySpeedEventInfo();
        setPlaySpeedEventInfo.setPlaySpeedRatio(((Float) objArr[0]).floatValue());
        this.mTPContext.getPlayerEventPublisher().publishEvent(setPlaySpeedEventInfo);
    }

    private void publishStartEvent(Object[] objArr) {
        this.mTPContext.getPlayerEventPublisher().publishEvent(new TPPlayerEventInfo.PlayStartEventInfo());
    }

    private void publishStopEvent(Object[] objArr) {
        TPPlayerEventInfo.PlayStopEventInfo playStopEventInfo = new TPPlayerEventInfo.PlayStopEventInfo();
        TPGeneralPlayFlowParams generalPlayFlowParams = this.mRetryAdapter.getGeneralPlayFlowParams();
        if (generalPlayFlowParams == null) {
            generalPlayFlowParams = new TPGeneralPlayFlowParams();
        }
        playStopEventInfo.setGeneralPlayFlowParams(generalPlayFlowParams);
        TPDynamicStatisticParams dynamicStatisticParams = this.mRetryAdapter.getDynamicStatisticParams(false);
        if (dynamicStatisticParams == null) {
            dynamicStatisticParams = new TPDynamicStatisticParams();
        }
        playStopEventInfo.setDynamicStatisticParams(dynamicStatisticParams);
        this.mTPContext.getPlayerEventPublisher().publishEvent(playStopEventInfo);
    }

    public synchronized Object getProxyInstance() {
        if (this.mRetryAdapterInterfaceProxy == null) {
            this.mRetryAdapterInterfaceProxy = Proxy.newProxyInstance(this.mRetryAdapter.getClass().getClassLoader(), this.mRetryAdapter.getClass().getInterfaces(), this);
        }
        return this.mRetryAdapterInterfaceProxy;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            doPublishEventIfNeed(method, objArr);
            doHookListener(method, objArr);
            return method.invoke(this.mRetryAdapter, objArr);
        } catch (InvocationTargetException e16) {
            if (e16.getTargetException() == null) {
                TPLogUtil.e(TAG, "invokeMethod " + method.getName() + " has excecption: " + e16);
                return dealReturn(method);
            }
            throw e16.getTargetException();
        } catch (Throwable th5) {
            TPLogUtil.e(TAG, "invokeMethod " + method.getName() + " has excecption: " + th5);
            return dealReturn(method);
        }
    }

    private void publishPrepareEvent(Object[] objArr) {
    }
}
