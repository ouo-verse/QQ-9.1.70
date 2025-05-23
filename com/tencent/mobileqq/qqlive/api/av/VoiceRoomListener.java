package com.tencent.mobileqq.qqlive.api.av;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface VoiceRoomListener {
    void onEnterRoom(long j3, @Nullable String str);

    void onExitRoom(int i3);

    void onPreEnterRoom(int i3, @Nullable String str);
}
