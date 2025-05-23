package com.tencent.qzonehub.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRecordAndChangeVoiceService extends QRouteApi {
    public static final int FROM_VOICE_MOOD = 1;

    void cleanData();

    void onReceiveRecordData(Intent intent, int i3);

    void stopPlayingMoodVoice();
}
