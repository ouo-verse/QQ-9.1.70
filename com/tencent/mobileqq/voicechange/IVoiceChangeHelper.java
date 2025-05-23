package com.tencent.mobileqq.voicechange;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVoiceChangeHelper extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void onCompressFinished(String str, int i3, int i16);
    }
}
