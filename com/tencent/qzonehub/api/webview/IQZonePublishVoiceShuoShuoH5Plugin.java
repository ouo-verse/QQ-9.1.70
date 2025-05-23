package com.tencent.qzonehub.api.webview;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZonePublishVoiceShuoShuoH5Plugin extends QRouteApi {
    void onDeleteAudioVoice(String str);

    void onNotifyH5CutCancel();
}
