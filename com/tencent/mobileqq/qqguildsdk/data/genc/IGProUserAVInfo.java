package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProUserAVInfo extends Serializable {
    IGProSpeakTimeCtl getSpeakTimeCtl();

    int getUserAVState();

    IGProUserDevState getUserDevState();

    boolean getUserInSpeakQueue();

    boolean getUserIsHandUp();

    String toString();
}
