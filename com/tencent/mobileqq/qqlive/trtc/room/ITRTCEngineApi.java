package com.tencent.mobileqq.qqlive.trtc.room;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ITRTCEngineApi extends QRouteApi {
    void addRoomListener(ITRTCRoomListener iTRTCRoomListener);

    void clearRoomListener();

    void destroyEngine();

    void enableAudioVolumeEvaluation(int i3);

    void enterRoom(QQLiveRoomParams qQLiveRoomParams);

    void enterRoom(String str, long j3, int i3, int i16, String str2, String str3);

    void exitRoom();

    void initEngine(Context context, String str, TRTCInitCallback tRTCInitCallback);

    boolean isEngineReady();

    void muteAllRemoteAudio(boolean z16);

    void removeRoomListener(ITRTCRoomListener iTRTCRoomListener);

    void setTRTCRemoteListener(ITRTCRemoteListener iTRTCRemoteListener);

    void stopAudio();
}
