package com.tencent.aelight.camera.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IMediaCodecDPC extends QRouteApi {
    int getBadCaseReportNumber();

    float getBeatyRate();

    int getCamera2ForceOpenSdkVersion();

    int getCamera2SwitchValue();

    int getCqMaxBitrate();

    int getFollowCaptureGopSize();

    int getQmcfDPCFrameType();

    boolean isARParticleSwtichOpen();

    boolean isBadCaseReport();

    boolean isBeautySwitchOpen();

    boolean isCqBitrateModeSwitchOpen();

    boolean isDanceRankingSwitchOpen();

    boolean isDeNoiseSwitchOpen();

    boolean isFaceDanceSwitchOpen();

    boolean isFollowCaptureSwitchOpen();

    boolean isGestureSwitchOpen();

    boolean isInQijianPhone();

    boolean isPortraitSwitchOpen();

    boolean isSamSungCameraOpen();

    boolean isSegmentMediaCodecEncodeSwtichOpen();

    boolean isSvafSwitchOpen();

    boolean isSwitchOpen();

    boolean isTransitionSwtichOpen();
}
