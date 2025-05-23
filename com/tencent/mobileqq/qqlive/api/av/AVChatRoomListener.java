package com.tencent.mobileqq.qqlive.api.av;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface AVChatRoomListener extends ITRTCRemoteListener {
    void onEnterRoom(long j3, @Nullable String str);

    void onEvent(int i3, int i16, String str);

    void onExitRoom(int i3);

    void onInitRoom(long j3, @Nullable String str);
}
