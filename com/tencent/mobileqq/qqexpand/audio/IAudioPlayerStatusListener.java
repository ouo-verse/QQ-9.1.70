package com.tencent.mobileqq.qqexpand.audio;

import android.support.annotation.UiThread;

/* loaded from: classes16.dex */
public interface IAudioPlayerStatusListener {
    @UiThread
    void onAudioFinishPlay(String str);

    @UiThread
    void onAudioPlayFailed(String str, int i3, String str2);

    @UiThread
    void onAudioStartPlay(String str);
}
