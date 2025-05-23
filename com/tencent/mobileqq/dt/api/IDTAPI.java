package com.tencent.mobileqq.dt.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IDTAPI extends QRouteApi {
    String getO3MMKVData(String str);

    Class<?> getO3SchemeParserClass();

    void getSecureEntryList(f fVar);

    void initO3();

    void jumpReport(Context context, b bVar);

    void jumpReport(Context context, b bVar, d dVar);

    void onSecDispatchToAppEvent(String str, byte[] bArr);

    void preInitO3();

    void registerExternalModule(com.tencent.kuikly.core.render.android.b bVar);

    void registerExternalView(com.tencent.kuikly.core.render.android.b bVar);

    void scanCameraSecurity(e eVar);

    void scanPressSecurityReport(ScanPicData scanPicData);

    void tryDLFEKIT();

    void webCheck(i iVar, h hVar);
}
