package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IDoraemonApi extends QRouteApi {
    void bindService();

    com.tencent.mobileqq.miniapp.d getAppInfo(String str, int i3, int i16, boolean z16, com.tencent.mobileqq.miniapp.e eVar);

    com.tencent.mobileqq.miniapp.d getAppInfo(String str, int i3, int i16, boolean z16, com.tencent.mobileqq.miniapp.e eVar, int i17);

    Bundle getUserInfo();

    void initBosses();

    boolean isLogin(e eVar);

    void putAppInfo(com.tencent.mobileqq.miniapp.d dVar);

    void unbindService();
}
