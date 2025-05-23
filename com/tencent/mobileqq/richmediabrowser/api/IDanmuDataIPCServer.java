package com.tencent.mobileqq.richmediabrowser.api;

import android.text.SpannableString;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IDanmuDataIPCServer extends QRouteApi {
    public static final String NAME = "DanmuDataIPCServer";

    QIPCModule getDanmuIPCServer();

    void notifyDanmuSendResult(long j3, long j16, String str, String str2, long j17, SpannableString spannableString);
}
