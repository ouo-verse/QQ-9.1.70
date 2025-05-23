package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IHapticManagerApi extends QRouteApi {
    void addEffects();

    void pauseEffect(int i3);

    int playEffect(String str, int i3);

    void resumeEffect(int i3);

    void stopEffect(int i3);

    void update(int i3, int i16);
}
