package com.tencent.gamecenter.wadl.api;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import nl0.c;
import nl0.e;
import nl0.f;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameNetService extends QRouteApi {
    void addListener(c cVar);

    void destroy();

    void getApkDownloadInfo(String str, ArrayList<String> arrayList);

    void getAutoDownloadTask(int i3);

    void onRespWebSso(Intent intent, boolean z16, byte[] bArr);

    void removeListener(c cVar);

    void requestFloatingWindow(String str, String str2, String str3, e eVar);

    void requestInterceptPageConfig(String str, f fVar);

    void requestRedPoint(int i3);

    void requestWebSso(String str, JSONObject jSONObject, Bundle bundle);
}
