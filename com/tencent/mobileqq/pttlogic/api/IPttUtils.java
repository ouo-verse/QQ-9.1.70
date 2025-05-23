package com.tencent.mobileqq.pttlogic.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.ptt.a;
import com.tencent.mobileqq.ptt.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttUtils extends QRouteApi {
    a creatPttAudioDataManager();

    b createPttVoiceChangePreSender(AppRuntime appRuntime);

    int getReceivedPTTStatus(AppInterface appInterface, MessageForPtt messageForPtt);

    void showDialogAboutMeizuRecordPermission(Context context);
}
