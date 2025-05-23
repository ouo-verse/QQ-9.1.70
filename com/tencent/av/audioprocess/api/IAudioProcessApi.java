package com.tencent.av.audioprocess.api;

import au.b;
import au.c;
import au.f;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAudioProcessApi extends QRouteApi {
    void addFile(String str, int i3, float f16, int i16);

    void addPCMData(byte[] bArr, int i3);

    boolean init(IAVEngineCommon iAVEngineCommon, f fVar);

    boolean isPlayStarted();

    boolean isRecogStarted();

    boolean isRecordStarted();

    void onReceiveAudioFrame(byte[] bArr, int i3, int i16);

    void pausePlay();

    void pauseRecord();

    void removeAllFiles();

    void removeFile(String str);

    void resumePlay();

    void resumeRecord();

    void scaleVolumeValue(byte[] bArr, float f16);

    boolean startPlay(int i3);

    boolean startRecog(b bVar);

    boolean startRecord(int i3, c cVar);

    void stopPlay();

    void stopRecog();

    void stopRecord();

    void unInit();

    void updateRecogTxt(String str);
}
