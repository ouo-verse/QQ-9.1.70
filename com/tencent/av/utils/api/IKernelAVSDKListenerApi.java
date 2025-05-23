package com.tencent.av.utils.api;

import android.os.Bundle;
import com.tencent.av.qav_rtc_push_online$LoginPushMsg;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAVSDKListener;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IKernelAVSDKListenerApi extends QRouteApi {
    IKernelAVSDKListener getKernelAVSDKListener();

    void onRecvMultiVideoS2C_0x210_0x14c_loginPush(qav_rtc_push_online$LoginPushMsg qav_rtc_push_online_loginpushmsg);

    void processMultiVideoOnlineMsg(Bundle bundle, String str, boolean z16);

    void processSharpVideoOnlineMsg(Bundle bundle, String str);
}
