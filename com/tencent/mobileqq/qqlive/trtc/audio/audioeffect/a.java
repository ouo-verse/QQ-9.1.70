package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.RTCMusicAccompanyParam;

/* compiled from: P */
/* loaded from: classes17.dex */
interface a {
    void a(@NonNull RTCMusicAccompanyParam rTCMusicAccompanyParam);

    void b(b bVar);

    void c();

    void d();

    long getCurrentPositionMs();

    long getDurationMs();

    void setLoopback(boolean z16);

    void stopAsync();

    void switchAccompanyType(int i3);
}
