package com.tencent.mobileqq.qqaudio.audioplayer;

import com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes16.dex */
public interface IAudioDeviceService extends IRuntimeService, AudioSenorManager.b {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        int e();

        void g(int i3, boolean z16);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.b
    /* synthetic */ void onNearToEarStatusChanged(int i3);

    void registerAudioDeviceListener(a aVar);

    void unRegisterAudioDeviceListener(a aVar);
}
