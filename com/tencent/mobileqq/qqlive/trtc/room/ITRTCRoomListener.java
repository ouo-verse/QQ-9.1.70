package com.tencent.mobileqq.qqlive.trtc.room;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface ITRTCRoomListener {
    void onEnterRoom(long j3, String str);

    void onEvent(int i3, int i16, String str, Bundle bundle);

    void onExitRoom(int i3);

    void onFirstLocalAudioFrameSent();

    void onFirstLocalVideoFrameSent(int i3);

    void onRemoteUserEnterRoom(String str);

    void onRemoteUserLeaveRoom(String str, int i3);

    void onSwitchRoom(int i3, String str);
}
