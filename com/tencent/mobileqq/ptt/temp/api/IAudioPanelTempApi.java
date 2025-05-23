package com.tencent.mobileqq.ptt.temp.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IAudioPanelTempApi extends QRouteApi {
    void ListenPanel_startPlayAnimByType_RecordStopToPlayType(View view);

    boolean getAppIsVideoChatting(AppRuntime appRuntime);
}
