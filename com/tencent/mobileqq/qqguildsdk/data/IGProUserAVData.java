package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProUserAVData extends Serializable {
    IGProSpeakTimeCtl getSpeakTimeCtl();

    int getUserAVState();

    IGProUserDevStateData getUserDevState();

    boolean isUserHandUp();

    boolean isUserInSpeakQueue();

    void setUserAVState(int i3);
}
