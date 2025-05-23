package com.tencent.qqlive.module.videoreport.dtreport.audio.api;

import com.tencent.qqlive.module.videoreport.dtreport.audio.api.AudioTimerPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IAudioTimerListener {
    AudioTimerPolicy.StartType onAudioStart();

    AudioTimerPolicy.StopType onAudioStop();
}
