package com.tencent.mobileqq.icgame.api.impl.room.trtc;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.icgame.api.impl.room.trtc.RoomTRTCPlayCallback;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes15.dex */
public class RoomTRTCPlayCallback extends TRTCCloudListener {
    private static final String TAG = "RoomTRTCPlayCallback";
    private static final int TRTC_DISCONNECT_ERROR = -1;
    private List<b32.a> playerListeners;
    private final StateCallback stateCallback;
    private final IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private String anchorId = "0";
    private com.tencent.mobileqq.activity.richmedia.i videoSize = new com.tencent.mobileqq.activity.richmedia.i(0, 0);
    private long startEnterRoomTime = 0;
    private boolean isNotifyFirstFrame = false;
    private int videoWidth = -1;
    private int videoHeight = -1;
    private long startBufferTime = 0;

    /* loaded from: classes15.dex */
    public interface StateCallback {
        void onPlayError();

        void onPlayStatusChange(int i3);

        void onPrepareStateChange(int i3);

        void onVideoAvailableChange(String str, boolean z16);
    }

    public RoomTRTCPlayCallback(@NotNull StateCallback stateCallback, List<b32.a> list) {
        this.stateCallback = stateCallback;
        this.playerListeners = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnBufferEnd$15() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopBuffer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnBufferStart$14() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartBuffer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnError$9(int i3, String str) {
        for (b32.a aVar : this.playerListeners) {
            aVar.onError(i3, str);
            aVar.onError(0, 0, i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnFirstFrameCome$5(long j3) {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onFirstFrameCome(this.startEnterRoomTime, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnPause$11() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnPlay$12() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnPlayCompleted$8() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnPreparing$4(String str, PlayerConfig playerConfig) {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreparing(StreamType.TRTC, str, playerConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnResume$10() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnStop$13() {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOnVideoSizeChange$6(int i3, int i16) {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyStatistics$7(long j3, long j16) {
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onStatistics(j3, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterRoom$0() {
        this.stateCallback.onPrepareStateChange(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onExitRoom$1() {
        this.stateCallback.onPrepareStateChange(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFirstVideoFrame$3() {
        this.stateCallback.onPlayStatusChange(1);
        notifyOnPlay();
        notifyOnFirstFrameCome();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUserVideoAvailable$2(String str, boolean z16) {
        this.stateCallback.onVideoAvailableChange(str, z16);
    }

    private void notifyOnBufferEnd(long j3) {
        this.iAegisLogApi.i(TAG, "notifyOnBufferEnd duration:" + j3);
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.k
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnBufferEnd$15();
            }
        });
    }

    private void notifyOnBufferStart() {
        this.iAegisLogApi.i(TAG, "notifyOnBufferStart");
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.j
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnBufferStart$14();
            }
        });
    }

    private void notifyOnError(final int i3, final String str) {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.f
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnError$9(i3, str);
            }
        });
    }

    private void notifyOnFirstFrameCome() {
        final long currentTimeMillis = System.currentTimeMillis();
        this.iAegisLogApi.i(TAG, "notifyOnFirstFrameCome");
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.i
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnFirstFrameCome$5(currentTimeMillis);
            }
        });
    }

    private void notifyOnVideoSizeChange(final int i3, final int i16) {
        this.iAegisLogApi.i(TAG, "notifyOnVideoSizeChange " + i3 + HippyTKDListViewAdapter.X + i16);
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.l
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnVideoSizeChange$6(i3, i16);
            }
        });
    }

    private void notifyStatistics(final long j3, final long j16) {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.m
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyStatistics$7(j3, j16);
            }
        });
    }

    private void runOnUIThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public com.tencent.mobileqq.activity.richmedia.i getVideoSize() {
        return this.videoSize;
    }

    public void notifyOnPause() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.n
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnPause$11();
            }
        });
    }

    public void notifyOnPlay() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.o
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnPlay$12();
            }
        });
    }

    public void notifyOnPlayCompleted() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.p
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnPlayCompleted$8();
            }
        });
    }

    public void notifyOnPreparing(final String str, final PlayerConfig playerConfig) {
        this.startEnterRoomTime = 0L;
        this.iAegisLogApi.i(TAG, "notifyOnPreparing url:" + str + " playerConfig:" + playerConfig);
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.q
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnPreparing$4(str, playerConfig);
            }
        });
    }

    public void notifyOnResume() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.h
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnResume$10();
            }
        });
    }

    public void notifyOnStop() {
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.e
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$notifyOnStop$13();
            }
        });
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionLost() {
        this.iAegisLogApi.i(TAG, "onConnectionLost");
        this.isNotifyFirstFrame = false;
        notifyOnError(-1, "onConnectionLost");
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectionRecovery() {
        this.iAegisLogApi.i(TAG, "onConnectionRecovery");
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long j3) {
        String str;
        IAegisLogApi iAegisLogApi = this.iAegisLogApi;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onEnterRoom result:");
        sb5.append(j3);
        sb5.append(" ");
        if (j3 > 0) {
            str = "\u8fdb\u623f\u6210\u529f";
        } else {
            str = "\u8fdb\u623f\u5931\u8d25";
        }
        sb5.append(str);
        iAegisLogApi.i(TAG, sb5.toString());
        this.isNotifyFirstFrame = false;
        if (j3 < 0) {
            runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.b
                @Override // java.lang.Runnable
                public final void run() {
                    RoomTRTCPlayCallback.this.lambda$onEnterRoom$0();
                }
            });
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int i3, String str, Bundle bundle) {
        this.iAegisLogApi.e(TAG, "onError errCode:" + i3 + " errMsg:" + str + " extraInfo:" + bundle);
        notifyOnError(i3, str);
        final StateCallback stateCallback = this.stateCallback;
        Objects.requireNonNull(stateCallback);
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.d
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.StateCallback.this.onPlayError();
            }
        });
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int i3) {
        this.iAegisLogApi.i(TAG, "onExitRoom reason:" + i3);
        this.isNotifyFirstFrame = false;
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.g
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$onExitRoom$1();
            }
        });
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstAudioFrame(String str) {
        this.iAegisLogApi.i(TAG, "onFirstAudioFrame userId:" + str);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(String str, int i3, int i16, int i17) {
        this.videoSize = new com.tencent.mobileqq.activity.richmedia.i(i16, i17);
        this.iAegisLogApi.i(TAG, "onFirstVideoFrame userId:" + str + " streamType:" + i3 + " width:" + i16 + " height:" + i17);
        this.startBufferTime = 0L;
        if (!this.isNotifyFirstFrame) {
            this.isNotifyFirstFrame = true;
            runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.c
                @Override // java.lang.Runnable
                public final void run() {
                    RoomTRTCPlayCallback.this.lambda$onFirstVideoFrame$3();
                }
            });
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRecvSEIMsg(String str, byte[] bArr) {
        a32.c cVar = new a32.c();
        cVar.f25429b = 5;
        cVar.f25431d = bArr;
        Iterator<b32.a> it = this.playerListeners.iterator();
        while (it.hasNext()) {
            it.next().onInfo(cVar);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteVideoStatusUpdated(String str, int i3, int i16, int i17, Bundle bundle) {
        this.iAegisLogApi.i(TAG, "onRemoteVideoStatusUpdated userId:" + str + " streamType:" + i3 + " status:" + i16 + " reason:" + i17 + " extraInfo:" + bundle);
        if (!this.isNotifyFirstFrame) {
            return;
        }
        if (i16 == 2) {
            this.startBufferTime = System.currentTimeMillis();
            notifyOnBufferStart();
        } else if (i16 == 0) {
            this.startBufferTime = 0L;
        } else if (i16 == 1 && this.startBufferTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.startBufferTime;
            this.startBufferTime = 0L;
            notifyOnBufferEnd(currentTimeMillis);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(TRTCStatistics tRTCStatistics) {
        notifyStatistics(tRTCStatistics.sendBytes, tRTCStatistics.receiveBytes);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onTryToReconnect() {
        this.iAegisLogApi.i(TAG, "onTryToReconnect");
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserAudioAvailable(String str, boolean z16) {
        this.iAegisLogApi.i(TAG, "onUserAudioAvailable userId:" + str + " available:" + z16);
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(final String str, final boolean z16) {
        this.iAegisLogApi.i(TAG, "onUserVideoAvailable userId:" + str + " available:" + z16);
        runOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.trtc.a
            @Override // java.lang.Runnable
            public final void run() {
                RoomTRTCPlayCallback.this.lambda$onUserVideoAvailable$2(str, z16);
            }
        });
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoSizeChanged(String str, int i3, int i16, int i17) {
        this.videoSize = new com.tencent.mobileqq.activity.richmedia.i(i16, i17);
        this.iAegisLogApi.i(TAG, "onUserVideoSizeChanged userId:" + str + " streamType:" + i3 + " newWidth:" + i16 + " newHeight:" + i17);
        if (this.videoWidth != i16 || this.videoHeight != i17) {
            this.videoWidth = i16;
            this.videoHeight = i17;
            notifyOnVideoSizeChange(i16, i17);
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onWarning(int i3, String str, Bundle bundle) {
        this.iAegisLogApi.e(TAG, "onWarning warningCode:" + i3 + " warningMsg:" + str + " extraInfo:" + bundle);
    }

    public void setAnchorId(String str) {
        this.anchorId = str;
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onSpeedTestResult(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult) {
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteAudioStatusUpdated(String str, int i3, int i16, Bundle bundle) {
    }
}
