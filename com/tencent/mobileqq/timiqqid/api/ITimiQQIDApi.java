package com.tencent.mobileqq.timiqqid.api;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import pr2.a;
import pr2.b;
import pr2.c;
import pr2.d;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITimiQQIDApi extends QRouteApi {
    public static final String QQID_QIPC_SERVER_NAME = "QQIDQIPCModule";

    void checkIsQQIDAlphaUser(boolean z16, String str, b<Boolean> bVar);

    void fetchWxAppCode(String str, c cVar);

    void fetchYuekangmaData(int i3, String str, d dVar);

    void getNeedShowQQIDEntrance(b<Boolean> bVar);

    QIPCModule getQQIDServerIPCModule();

    int getSceneRecognitionEnable();

    void init();

    void openQQIDActivity(Context context, boolean z16);

    void openRealNameWebview(Context context, String str);

    void requestSceneRecognitionMaxAge(int i3, b<Long> bVar);

    void requestWxCode(String str, String str2, b<String> bVar);

    void setQQIDAlphaUser(String str, @Nullable a aVar);

    void setSceneRecognitionEnable(int i3, String str, a aVar);

    void startFetchPassResult(String str, String str2);

    void stopFetchPassResult();
}
