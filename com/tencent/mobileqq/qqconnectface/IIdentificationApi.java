package com.tencent.mobileqq.qqconnectface;

import android.content.Context;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IIdentificationApi extends QRouteApi {
    WebViewPlugin createIdentificationPlugin();

    Class<?> getDeleteFaceFragment();

    QIPCModule getIdentityIpcServer();

    void startIdentification(Context context, b bVar, a aVar);

    void unregisterCallback(Context context, a aVar);
}
