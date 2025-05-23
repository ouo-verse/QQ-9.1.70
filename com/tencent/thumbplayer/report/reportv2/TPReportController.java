package com.tencent.thumbplayer.report.reportv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.report.v2.ITPReportInfoGetter;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.event.ITPPlayerEventReceiver;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPReportController implements ITPReportExtendedController, ITPPlayerEventReceiver {
    private static final Map<Integer, Integer> CAPTURE_EVENT_TO_PROCESSOR_EVENT_MAP;
    private static final String TAG = "TPReportController";
    private static final long mSyncWaitTimeOutMs = 500;
    private Context mContext;
    private ITPReportInfoGetter mReportInfoGetter = null;
    private HandlerThread mReportThread = null;
    private TPReportEventHandler mEventHandler = null;
    private ITPReporter mITPReporter = null;
    private TPReporterInitParams mReporterInitParams = new TPReporterInitParams();
    private ITPPlayerInfoGetter mPlayerInfoGetter = null;
    private TPReportControllerState mControllerState = new TPReportControllerState();
    private Object mReleaseSyncObjectLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class TPReportEventHandler extends Handler {
        TPReportEventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            TPPlayerEventInfo.BaseEventInfo baseEventInfo = (TPPlayerEventInfo.BaseEventInfo) message.obj;
            TPReportController.this.dealSpecialEventBeforeReporterIfNeed(i3, baseEventInfo);
            if (TPReportController.this.mITPReporter != null) {
                TPReportController.this.mITPReporter.onEvent(i3, baseEventInfo);
            }
            TPReportController.this.dealSpecialEventAfterReporterIfNeed(i3, baseEventInfo);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        CAPTURE_EVENT_TO_PROCESSOR_EVENT_MAP = hashMap;
        hashMap.put(17, 0);
        hashMap.put(1004, 103);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        hashMap.put(5, 5);
        hashMap.put(7, 5);
        hashMap.put(8, 5);
        hashMap.put(6, 6);
        hashMap.put(9, 7);
        hashMap.put(10, 8);
        hashMap.put(11, 9);
        hashMap.put(12, 10);
        hashMap.put(14, 11);
        hashMap.put(15, 12);
        hashMap.put(1001, 100);
        hashMap.put(1002, 101);
        hashMap.put(1003, 102);
        hashMap.put(16, 14);
        hashMap.put(13, 13);
    }

    public TPReportController(Context context) {
        this.mContext = null;
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealSpecialEventAfterReporterIfNeed(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (i3 != 5) {
            if (i3 == 1000) {
                onControllerRelease(baseEventInfo);
                return;
            }
            return;
        }
        onPlayEnd(baseEventInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealSpecialEventBeforeReporterIfNeed(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 6) {
                        if (i3 == 103) {
                            onGetConvertedDataSource(baseEventInfo);
                            return;
                        }
                        return;
                    }
                    onPlayError(baseEventInfo);
                    return;
                }
                onPrepareEnd(baseEventInfo);
                return;
            }
            onPrepareStart(baseEventInfo);
            return;
        }
        onSetDataSource(baseEventInfo);
    }

    private void initReporter(int i3) {
        if (this.mITPReporter != null) {
            TPLogUtil.w(TAG, "mITPReporter has been create, do not create again.");
            return;
        }
        ITPReporter createReporterWithType = TPReporterFactory.createReporterWithType(i3);
        this.mITPReporter = createReporterWithType;
        if (createReporterWithType == null) {
            TPLogUtil.w(TAG, "initReporter(" + i3 + ") fail, mITPReporter is null.");
            return;
        }
        createReporterWithType.init(this.mContext, this.mReporterInitParams);
        this.mITPReporter.setReportInfoGetter(this.mReportInfoGetter);
        this.mITPReporter.setPlayerInfoGetter(this.mPlayerInfoGetter);
    }

    private void onControllerRelease(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        TPLogUtil.i(TAG, "onControllerRelease");
        synchronized (this.mReleaseSyncObjectLock) {
            if (this.mReportThread != null) {
                TPThreadPool.getInstance().recycle(this.mReportThread, this.mEventHandler);
                this.mReportThread = null;
                this.mEventHandler = null;
            }
            this.mReleaseSyncObjectLock.notifyAll();
            this.mReleaseSyncObjectLock = null;
        }
    }

    private void onGetConvertedDataSource(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.DTReturnConvertedUrlEventInfo)) {
            return;
        }
        this.mReporterInitParams.mConvertDataSourceETimeMs = ((TPPlayerEventInfo.DTReturnConvertedUrlEventInfo) baseEventInfo).getEventTimeSinceBootMs();
        TPLogUtil.i(TAG, "onGetConvertedDataSource time:" + this.mReporterInitParams.mConvertDataSourceETimeMs);
    }

    private void onPlayEnd(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        this.mControllerState.setState(1);
        ITPReporter iTPReporter = this.mITPReporter;
        if (iTPReporter != null) {
            iTPReporter.reset();
            this.mITPReporter = null;
        }
        this.mReporterInitParams = new TPReporterInitParams();
    }

    private void onPlayError(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (this.mControllerState.isMatchState(2)) {
            initReporter(2);
        }
        this.mControllerState.setState(1);
    }

    @SuppressLint({"WrongConstant"})
    private void onPrepareEnd(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!this.mControllerState.isMatchState(2)) {
            TPLogUtil.e(TAG, "onPrepareEnd Current state is not match:" + this.mControllerState.toString());
            return;
        }
        this.mControllerState.setState(3);
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PrepareEndEventInfo)) {
            return;
        }
        TPPlayerEventInfo.PrepareEndEventInfo prepareEndEventInfo = (TPPlayerEventInfo.PrepareEndEventInfo) baseEventInfo;
        this.mReporterInitParams.mPlayerType = TPReportUtils.convertTPPlayerTypeToReportPlayerEnum(prepareEndEventInfo.getPlayerCoreType());
        TPLogUtil.i(TAG, "onPrepareEnd durationMs:" + prepareEndEventInfo.getDurationMs() + " playType:" + this.mReporterInitParams.mPlayerType);
        if (prepareEndEventInfo.getDurationMs() == 0) {
            initReporter(1);
        } else {
            initReporter(0);
        }
    }

    private void onPrepareStart(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        this.mControllerState.setState(2);
        if (!(baseEventInfo instanceof TPPlayerEventInfo.PrepareStartEventInfo)) {
            return;
        }
        TPPlayerEventInfo.PrepareStartEventInfo prepareStartEventInfo = (TPPlayerEventInfo.PrepareStartEventInfo) baseEventInfo;
        this.mReporterInitParams.mTPPrepareStartOccurElapsedTimeMs = prepareStartEventInfo.getEventTimeSinceBootMs();
        this.mReporterInitParams.mTPPrepareStartOccurTimeSince1970Ms = prepareStartEventInfo.getEventTimeSince1970Ms();
        this.mReporterInitParams.mPlayFlowId = prepareStartEventInfo.getFlowId();
    }

    private void onSetDataSource(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        if (!(baseEventInfo instanceof TPPlayerEventInfo.SetDataSourceEventInfo)) {
            return;
        }
        TPPlayerEventInfo.SetDataSourceEventInfo setDataSourceEventInfo = (TPPlayerEventInfo.SetDataSourceEventInfo) baseEventInfo;
        this.mReporterInitParams.mTPSetDataSourceTimeMs = setDataSourceEventInfo.getEventTimeSinceBootMs();
        this.mReporterInitParams.mOriginalUrl = setDataSourceEventInfo.getUrl();
        this.mReporterInitParams.mIsUseProxy = setDataSourceEventInfo.isIsUseProxy() ? 1 : 0;
        this.mReporterInitParams.mUrlProtocol = setDataSourceEventInfo.getUrlProtocol();
        TPLogUtil.i(TAG, "onSetDataSource url:" + this.mReporterInitParams.mOriginalUrl + " isUseProxy:" + this.mReporterInitParams.mIsUseProxy + " urlProtocol:" + this.mReporterInitParams.mUrlProtocol);
    }

    public void init() {
        this.mReportThread = TPThreadPool.getInstance().obtainHandleThread("TPRepCtrlThread");
        this.mEventHandler = new TPReportEventHandler(this.mReportThread.getLooper());
    }

    @Override // com.tencent.thumbplayer.event.ITPPlayerEventReceiver
    public void onEvent(TPPlayerEventInfo.BaseEventInfo baseEventInfo) {
        Map<Integer, Integer> map = CAPTURE_EVENT_TO_PROCESSOR_EVENT_MAP;
        if (!map.containsKey(Integer.valueOf(baseEventInfo.getEventId()))) {
            TPLogUtil.w(TAG, "EventId:" + baseEventInfo.getEventId() + " is not need process");
            return;
        }
        this.mEventHandler.obtainMessage(map.get(Integer.valueOf(baseEventInfo.getEventId())).intValue(), baseEventInfo).sendToTarget();
    }

    public void release() {
        TPLogUtil.i(TAG, "release");
        synchronized (this.mReleaseSyncObjectLock) {
            TPReportEventHandler tPReportEventHandler = this.mEventHandler;
            if (tPReportEventHandler != null) {
                tPReportEventHandler.sendEmptyMessage(1000);
            }
            try {
                this.mReleaseSyncObjectLock.wait(500L);
            } catch (InterruptedException e16) {
                TPLogUtil.e(TAG, e16);
            }
        }
    }

    public void setPlayerInfoGetter(@NonNull ITPPlayerInfoGetter iTPPlayerInfoGetter) {
        this.mPlayerInfoGetter = iTPPlayerInfoGetter;
    }

    @Override // com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController
    public void setReportInfoGetter(@Nullable ITPReportInfoGetter iTPReportInfoGetter) {
        this.mReportInfoGetter = iTPReportInfoGetter;
    }

    public void setReportToBeaconNeeded(boolean z16) {
        TPLogUtil.i(TAG, "reporting is needed:" + z16);
        this.mReporterInitParams.mNeedReportToBeacon = Boolean.valueOf(z16);
    }

    @Override // com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController
    public void setReportSamplingRate(float f16) {
    }
}
