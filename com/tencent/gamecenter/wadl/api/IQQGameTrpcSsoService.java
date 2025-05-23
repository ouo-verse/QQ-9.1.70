package com.tencent.gamecenter.wadl.api;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import nl0.h;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameTrpcSsoService extends QRouteApi {
    void addListener(h hVar);

    void checkDownloadByIntercept(WadlParams wadlParams, String str, Bundle bundle);

    void checkGameDownload(WadlParams wadlParams, Bundle bundle);

    void checkIndependentDownload(WadlParams wadlParams, Bundle bundle);

    void checkPreload(WadlParams wadlParams, Bundle bundle);

    void getGameRegister(String str);

    void getInterruptGameInfoByUrl(String str);

    void onRespTrpcSso(Intent intent, boolean z16, int i3, int i16, byte[] bArr);

    void removeListener(h hVar);

    void reqRemindFullScreenInfo(String str);

    void reqSsoInstallTip(String str, Bundle bundle);

    void requestDownloadConfig(long j3);

    void requestJointRegexConfig(int i3);

    void requestTrpc(String str, byte[] bArr, Bundle bundle);

    void setOrderGame(int i3, Bundle bundle, String... strArr);
}
