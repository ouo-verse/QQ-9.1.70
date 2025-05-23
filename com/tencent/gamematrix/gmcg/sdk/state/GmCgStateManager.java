package com.tencent.gamematrix.gmcg.sdk.state;

import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgApiService;
import com.tencent.gamematrix.gmcg.api.GmCgDeviceState;
import com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.gamematrix.gmcg.api.b;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocateDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgColdStartDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgStateManager implements GmCgDeviceStateObserver {
    private static final int DEFAULT_TIME_SEC_FOR_DEVICE_ALIVE_AFTER_USE = 60;
    private static final int DEFAULT_TIME_SEC_FOR_DEVICE_ALIVE_BEFORE_USE = 60;
    private static final CGSingletonHelper<GmCgStateManager> sInstance = new CGSingletonHelper<GmCgStateManager>() { // from class: com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public GmCgStateManager create() {
            return new GmCgStateManager();
        }
    };
    private GmCgDeviceState mCurDeviceState;
    private CountDownTimer mDeviceAliveCountDownTimer;
    private GmCgApiService mGmCgApiService;
    private GmCgColdStartDeviceInfo mGmCgColdStartDeviceInfo;
    private GmCgDeviceInfo mGmCgDeviceInfo;
    private GmCgError mGmCgError;
    private GmCgGameConfigInfo mGmCgGameConfigInfo;
    private GmCgPlayQueueInfo mGmCgPlayQueueInfo;
    private GmCgDeviceState mLastDeviceState;

    @NonNull
    private final Set<GmCgDeviceStateObserver> mStateUpdateObservers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager$6, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState;

        static {
            int[] iArr = new int[GmCgDeviceState.values().length];
            $SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState = iArr;
            try {
                iArr[GmCgDeviceState.GmCgDeviceStateInit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState[GmCgDeviceState.GmCgDeviceStateExpireBeforeUse.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState[GmCgDeviceState.GmCgDeviceStateExpireAfterUse.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState[GmCgDeviceState.GmCgDeviceStateAliveBeforeUse.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState[GmCgDeviceState.GmCgDeviceStateAliveAfterUse.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void freeDeviceIfNecessary() {
        CGLog.i("GmMcStateManager freeDeviceIfNecessary");
        stopTimerForDeviceAlive();
        GmCgDeviceInfo gmCgDeviceInfo = this.mGmCgDeviceInfo;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.isValid()) {
            if (this.mGmCgDeviceInfo.isCreatedByOther()) {
                getGmCgApiService().freeDeviceForSubAccount(this.mGmCgDeviceInfo.getDeviceID(), new GmCgApiService.ActionResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager.4
                    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService.ActionResultListener
                    public void onActionResult(GmCgError gmCgError) {
                        CGLog.e("GmMcStateManager freeDeviceIfNecessary fail: " + gmCgError.getDetailErrorMsg());
                    }

                    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService.ActionResultListener
                    public void onActionSucceed() {
                        CGLog.i("GmMcStateManager freeDeviceIfNecessary succeed");
                    }
                });
            } else {
                getGmCgApiService().freeMyDevice(this.mGmCgDeviceInfo.getDeviceID(), new GmCgApiService.ActionResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager.5
                    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService.ActionResultListener
                    public void onActionResult(GmCgError gmCgError) {
                        CGLog.e("GmMcStateManager freeDeviceIfNecessary fail: " + gmCgError.getDetailErrorMsg());
                    }

                    @Override // com.tencent.gamematrix.gmcg.api.GmCgApiService.ActionResultListener
                    public void onActionSucceed() {
                        CGLog.i("GmMcStateManager freeDeviceIfNecessary succeed");
                    }
                });
            }
        }
    }

    public static GmCgStateManager get() {
        return sInstance.get();
    }

    private GmCgApiService getGmCgApiService() {
        if (this.mGmCgApiService == null) {
            this.mGmCgApiService = GmCgSdk.createApiService();
        }
        return this.mGmCgApiService;
    }

    private boolean inDeviceState(GmCgDeviceState gmCgDeviceState) {
        if (this.mCurDeviceState == gmCgDeviceState) {
            return true;
        }
        return false;
    }

    private void startTimerForDeviceAliveAfterUse(int i3) {
        CGLog.i("GmMcStateManager startTimerForDeviceAliveAfterUse timerSec: " + i3);
        stopTimerForDeviceAlive();
        long j3 = (long) i3;
        updateTimerForDeviceAliveAfterUse(j3);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CountDownTimer countDownTimer = new CountDownTimer(timeUnit.toMillis(j3), timeUnit.toMillis(1L)) { // from class: com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager.3
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GmCgStateManager.this.updateTimerForDeviceAliveAfterUse(0L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j16) {
                GmCgStateManager.this.updateTimerForDeviceAliveAfterUse(TimeUnit.MILLISECONDS.toSeconds(j16));
            }
        };
        this.mDeviceAliveCountDownTimer = countDownTimer;
        countDownTimer.start();
    }

    private void startTimerForDeviceAliveBeforeUse(int i3) {
        CGLog.i("GmMcStateManager startTimerForDeviceAliveBeforeUse timerSec: " + i3);
        stopTimerForDeviceAlive();
        long j3 = (long) i3;
        updateTimerForDeviceAliveBeforeUse(j3);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        CountDownTimer countDownTimer = new CountDownTimer(timeUnit.toMillis(j3), timeUnit.toMillis(1L)) { // from class: com.tencent.gamematrix.gmcg.sdk.state.GmCgStateManager.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GmCgStateManager.this.updateTimerForDeviceAliveBeforeUse(0L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j16) {
                GmCgStateManager.this.updateTimerForDeviceAliveBeforeUse(TimeUnit.MILLISECONDS.toSeconds(j16));
            }
        };
        this.mDeviceAliveCountDownTimer = countDownTimer;
        countDownTimer.start();
    }

    private void stopTimerForDeviceAlive() {
        CountDownTimer countDownTimer = this.mDeviceAliveCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mDeviceAliveCountDownTimer = null;
        }
    }

    private void updateDeviceState(GmCgDeviceState gmCgDeviceState) {
        GmCgDeviceState gmCgDeviceState2 = this.mCurDeviceState;
        this.mLastDeviceState = gmCgDeviceState2;
        this.mCurDeviceState = gmCgDeviceState;
        onLeaveGmCgDeviceState(gmCgDeviceState2);
        onEnterGmCgDeviceState(this.mCurDeviceState);
        CGLog.i("GmCgStateManager mCurDeviceState: " + this.mCurDeviceState + ", mLastDeviceState: " + this.mLastDeviceState);
        int[] iArr = AnonymousClass6.$SwitchMap$com$tencent$gamematrix$gmcg$api$GmCgDeviceState;
        int i3 = iArr[this.mCurDeviceState.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5 && this.mLastDeviceState != GmCgDeviceState.GmCgDeviceStateAliveAfterUse) {
                    startTimerForDeviceAliveAfterUse(getTimeoutValueForDeviceAliveAfterUse());
                }
            } else if (this.mLastDeviceState != GmCgDeviceState.GmCgDeviceStateAliveBeforeUse) {
                startTimerForDeviceAliveBeforeUse(getTimeoutValueForDeviceAliveBeforeUse());
            }
        } else {
            freeDeviceIfNecessary();
        }
        int i16 = iArr[this.mLastDeviceState.ordinal()];
        if (i16 != 4) {
            if (i16 == 5 && this.mCurDeviceState != GmCgDeviceState.GmCgDeviceStateAliveAfterUse) {
                stopTimerForDeviceAlive();
                return;
            }
            return;
        }
        if (this.mCurDeviceState != GmCgDeviceState.GmCgDeviceStateAliveBeforeUse) {
            stopTimerForDeviceAlive();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimerForDeviceAliveAfterUse(long j3) {
        if (j3 < 1) {
            stopTimerForDeviceAlive();
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateExpireAfterUse);
        } else {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse);
        }
        onTimerUpdateOfGmCgDeviceAliveAfterUse(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimerForDeviceAliveBeforeUse(long j3) {
        if (j3 < 1) {
            stopTimerForDeviceAlive();
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateExpireBeforeUse);
        } else {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveBeforeUse);
        }
        onTimerUpdateOfGmCgDeviceAliveBeforeUse(j3);
    }

    public void addDeviceStateObserver(GmCgDeviceStateObserver gmCgDeviceStateObserver) {
        if (gmCgDeviceStateObserver != null) {
            this.mStateUpdateObservers.add(gmCgDeviceStateObserver);
        }
    }

    public GmCgDeviceState getCurDeviceState() {
        return this.mCurDeviceState;
    }

    @Nullable
    public GmCgColdStartDeviceInfo getGmCgColdStartDeviceInfo() {
        return this.mGmCgColdStartDeviceInfo;
    }

    @Nullable
    public GmCgDeviceInfo getGmCgDeviceInfo() {
        return this.mGmCgDeviceInfo;
    }

    @Nullable
    public GmCgError getGmCgError() {
        return this.mGmCgError;
    }

    @Nullable
    public GmCgGameConfigInfo getGmCgGameConfigInfo() {
        return this.mGmCgGameConfigInfo;
    }

    @Nullable
    public GmCgPlayQueueInfo getGmCgPlayQueueInfo() {
        return this.mGmCgPlayQueueInfo;
    }

    public GmCgDeviceState getLastDeviceState() {
        return this.mLastDeviceState;
    }

    public int getTimeoutValueForDeviceAliveAfterUse() {
        int i3;
        GmCgDeviceInfo gmCgDeviceInfo;
        if (this.mGmCgGameConfigInfo != null && (gmCgDeviceInfo = this.mGmCgDeviceInfo) != null) {
            if (gmCgDeviceInfo.isCreatedByOther()) {
                i3 = this.mGmCgGameConfigInfo.pSubAccountLostReleaseTime;
            } else {
                i3 = this.mGmCgGameConfigInfo.pLostReleaseTime;
            }
        } else {
            i3 = 60;
        }
        if (i3 > 10) {
            return i3 - 10;
        }
        return i3;
    }

    public int getTimeoutValueForDeviceAliveBeforeUse() {
        int i3;
        GmCgDeviceInfo gmCgDeviceInfo;
        if (this.mGmCgGameConfigInfo != null && (gmCgDeviceInfo = this.mGmCgDeviceInfo) != null) {
            if (gmCgDeviceInfo.isCreatedByOther()) {
                i3 = this.mGmCgGameConfigInfo.pSubAccountNoConnectReleaseTime;
            } else {
                i3 = this.mGmCgGameConfigInfo.pNoConnectReleaseTime;
            }
        } else {
            i3 = 60;
        }
        if (i3 > 10) {
            return i3 - 10;
        }
        return i3;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver
    public void onEnterGmCgDeviceState(GmCgDeviceState gmCgDeviceState) {
        for (GmCgDeviceStateObserver gmCgDeviceStateObserver : this.mStateUpdateObservers) {
            if (gmCgDeviceStateObserver != null) {
                gmCgDeviceStateObserver.onEnterGmCgDeviceState(gmCgDeviceState);
            }
        }
    }

    public void onGmCgAllocatorUpdate(boolean z16, GmCgDeviceInfo gmCgDeviceInfo, GmCgPlayQueueInfo gmCgPlayQueueInfo) {
        if (z16) {
            this.mGmCgDeviceInfo = gmCgDeviceInfo;
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveBeforeUse);
        } else {
            this.mGmCgPlayQueueInfo = gmCgPlayQueueInfo;
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateQueue);
            GmCgPlayQueueInfo gmCgPlayQueueInfo2 = this.mGmCgPlayQueueInfo;
            onGmCgDeviceQueueUpdate(gmCgPlayQueueInfo2.pWaitNum, gmCgPlayQueueInfo2.pWaitPos, gmCgPlayQueueInfo2.pWaitSec);
        }
    }

    public void onGmCgAllocatorUpdateNew(int i3, GmCgAllocateDeviceInfo gmCgAllocateDeviceInfo) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mGmCgDeviceInfo = gmCgAllocateDeviceInfo.mCgDeviceInfo;
                    updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveBeforeUse);
                    return;
                }
                return;
            }
            this.mGmCgColdStartDeviceInfo = gmCgAllocateDeviceInfo.mCgColdStartDeviceInfo;
            updateDeviceState(GmCgDeviceState.GmCgDeviceSateColdStart);
            onGmCgDeviceColdStartUpdate(this.mGmCgColdStartDeviceInfo);
            return;
        }
        this.mGmCgPlayQueueInfo = gmCgAllocateDeviceInfo.mCgPlayQueueInfo;
        updateDeviceState(GmCgDeviceState.GmCgDeviceStateQueue);
        GmCgPlayQueueInfo gmCgPlayQueueInfo = this.mGmCgPlayQueueInfo;
        onGmCgDeviceQueueUpdate(gmCgPlayQueueInfo.pWaitNum, gmCgPlayQueueInfo.pWaitPos, gmCgPlayQueueInfo.pWaitSec);
    }

    public void onGmCgBotDevice() {
        updateDeviceState(GmCgDeviceState.GmCgDeviceStateBotInCloud);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver
    public /* synthetic */ void onGmCgDeviceColdStartUpdate(GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        b.b(this, gmCgColdStartDeviceInfo);
    }

    public void onGmCgDeviceError(GmCgError gmCgError) {
        this.mGmCgError = gmCgError;
        updateDeviceState(GmCgDeviceState.GmCgDeviceStateError);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver
    public void onGmCgDeviceQueueUpdate(int i3, int i16, int i17) {
        for (GmCgDeviceStateObserver gmCgDeviceStateObserver : this.mStateUpdateObservers) {
            if (gmCgDeviceStateObserver != null) {
                gmCgDeviceStateObserver.onGmCgDeviceQueueUpdate(i3, i16, i17);
            }
        }
    }

    public void onGmCgPlayStatusUpdate(GmCgPlayStatus gmCgPlayStatus, Object obj) {
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusDeviceAllocated)) {
            this.mGmCgDeviceInfo = (GmCgDeviceInfo) obj;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusGameConfigGot)) {
            this.mGmCgGameConfigInfo = (GmCgGameConfigInfo) obj;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusRTCConnected) && (inDeviceState(GmCgDeviceState.GmCgDeviceStateAliveBeforeUse) || inDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse) || inDeviceState(GmCgDeviceState.GmCgDeviceStateBotInCloud))) {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateUsing);
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusStopped) && inDeviceState(GmCgDeviceState.GmCgDeviceStateUsing)) {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse);
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.RemoteStreamStopped) && inDeviceState(GmCgDeviceState.GmCgDeviceStateUsing)) {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse);
        }
    }

    public void onGmCgPlayStatusUpdateV2(GmCgPlayStatus gmCgPlayStatus, Object obj, boolean z16) {
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusDeviceAllocated)) {
            this.mGmCgDeviceInfo = (GmCgDeviceInfo) obj;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusRestart) && obj != null) {
            this.mGmCgDeviceInfo = (GmCgDeviceInfo) obj;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusGameConfigGot)) {
            this.mGmCgGameConfigInfo = (GmCgGameConfigInfo) obj;
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusRTCConnected) && (inDeviceState(GmCgDeviceState.GmCgDeviceStateAliveBeforeUse) || inDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse) || inDeviceState(GmCgDeviceState.GmCgDeviceStateBotInCloud))) {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateUsing);
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusInStreaming) && inDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse)) {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateUsing);
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            if (inDeviceState(GmCgDeviceState.GmCgDeviceStateUsing)) {
                updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse);
            } else if (inDeviceState(GmCgDeviceState.GmCgDeviceStateBotInCloud) && !z16) {
                updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse);
            }
        }
        if (gmCgPlayStatus.is(GmCgPlayStatus.RemoteStreamStopped) && inDeviceState(GmCgDeviceState.GmCgDeviceStateUsing)) {
            updateDeviceState(GmCgDeviceState.GmCgDeviceStateAliveAfterUse);
        }
        GmCgDeviceInfo gmCgDeviceInfo = this.mGmCgDeviceInfo;
        if (gmCgDeviceInfo != null) {
            gmCgDeviceInfo.setBot(z16);
        }
    }

    public void onGmCgReleaseDevice() {
        updateDeviceState(GmCgDeviceState.GmCgDeviceStateRelease);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver
    public void onLeaveGmCgDeviceState(GmCgDeviceState gmCgDeviceState) {
        for (GmCgDeviceStateObserver gmCgDeviceStateObserver : this.mStateUpdateObservers) {
            if (gmCgDeviceStateObserver != null) {
                gmCgDeviceStateObserver.onLeaveGmCgDeviceState(gmCgDeviceState);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver
    public void onTimerUpdateOfGmCgDeviceAliveAfterUse(long j3) {
        for (GmCgDeviceStateObserver gmCgDeviceStateObserver : this.mStateUpdateObservers) {
            if (gmCgDeviceStateObserver != null) {
                gmCgDeviceStateObserver.onTimerUpdateOfGmCgDeviceAliveAfterUse(j3);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDeviceStateObserver
    public void onTimerUpdateOfGmCgDeviceAliveBeforeUse(long j3) {
        for (GmCgDeviceStateObserver gmCgDeviceStateObserver : this.mStateUpdateObservers) {
            if (gmCgDeviceStateObserver != null) {
                gmCgDeviceStateObserver.onTimerUpdateOfGmCgDeviceAliveBeforeUse(j3);
            }
        }
    }

    public void removeDeviceStateObserver(GmCgDeviceStateObserver gmCgDeviceStateObserver) {
        if (gmCgDeviceStateObserver != null) {
            this.mStateUpdateObservers.remove(gmCgDeviceStateObserver);
        }
    }

    public void reset() {
        stopTimerForDeviceAlive();
        this.mGmCgDeviceInfo = null;
        this.mGmCgPlayQueueInfo = null;
        this.mGmCgGameConfigInfo = null;
        this.mGmCgError = null;
        updateDeviceState(GmCgDeviceState.GmCgDeviceStateInit);
    }

    GmCgStateManager() {
        this.mStateUpdateObservers = new HashSet();
        GmCgDeviceState gmCgDeviceState = GmCgDeviceState.GmCgDeviceStateInit;
        this.mCurDeviceState = gmCgDeviceState;
        this.mLastDeviceState = gmCgDeviceState;
    }
}
