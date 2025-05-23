package com.tencent.mobileqq.ark.api;

import a91.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkHelper extends QRouteApi {
    String CopyFileToCache(String str, String str2);

    String CopyFileToCache(String str, byte[] bArr);

    String arkPathToSysPath(String str, String str2);

    void cleanAppCache();

    void cleanAppStorage();

    void cleanWebCache();

    Map<String, String> getArkExtendInfo(String str, String str2);

    Map<String, String> getArkReplyConfig(JSONObject jSONObject);

    String getArkReplyIcon(JSONObject jSONObject);

    String getCacheResPath(String str, String str2);

    boolean handleArkQuoteOpenUrl(int i3, JSONObject jSONObject);

    boolean isSupportReply(String str, String str2, String str3);

    void onThemeChange();

    void preDownloadApp(String str, String str2, String str3);

    void preloadCommon();

    void registerArkCallBack(b bVar);

    void reportEvent(AppRuntime appRuntime, String str, String str2, String str3, long j3, long j16, long j17, long j18, long j19, String str4, String str5);

    void stopArkSilkAudio();

    void unregisterCallBack();
}
