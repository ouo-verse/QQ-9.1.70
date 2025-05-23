package com.tencent.mobileqq.intervideo.audioroom.player;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes15.dex */
public interface IQQVoiceAudioListener {
    void onAudioFirstFrame();

    void onCompletion();

    boolean onError(int i3, int i16, int i17, String str);

    boolean onInfo(int i3, long j3, long j16, Object obj);
}
