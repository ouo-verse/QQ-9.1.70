package com.tencent.mobileqq.together.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IQQPlayerServiceApi extends QRouteApi {
    String getQQPlayerServiceToken();

    boolean isListeningTogether();

    boolean isPlayStateCompletion(int i3);

    boolean isPlayStateError(int i3);

    boolean isPlayStatePause(int i3);

    boolean isPlayStatePlaying(int i3);

    boolean isPlayStateStop(int i3);

    boolean isQQPlayServicePlaying();

    boolean isStateCompletion(int i3);

    boolean isStateError(int i3);

    boolean isStatePause(int i3);

    boolean isStatePlaying(int i3);

    boolean isStateStop(int i3);
}
