package com.tencent.mobileqq.wxapi;

import android.content.Intent;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWXAuthApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(int i3, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void onResult(boolean z16);
    }

    void checkWXNeedShowRedDotGuide(b bVar);

    String getWXAppId();

    QIPCModule getWXIPCModule();

    void handleWXEntryIntent(Intent intent);

    boolean isInBlackDeviceList();

    boolean isWXAppInstalled();

    void reportWXAuthResult(int i3, int i16);

    void reqWXAuthCode(a aVar);
}
