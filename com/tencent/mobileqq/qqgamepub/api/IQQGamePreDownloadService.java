package com.tencent.mobileqq.qqgamepub.api;

import android.os.Bundle;
import com.tencent.mobileqq.qqgamepub.config.c;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.f;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGamePreDownloadService extends QRouteApi {
    void checkAndCleanExpireCache();

    String getActivityUrl(String str);

    c getConfig();

    boolean interceptJumpHippy(String str);

    void preDownloadPubPushRes(List<QQGameMsgInfo> list);

    void setArkResNameToMeta(String str, JSONObject jSONObject);

    void startDownload(DownloadParam downloadParam, f fVar, Bundle bundle);

    void startPreDownload(DownloadParam downloadParam, f fVar, Bundle bundle);

    void updateOfflineByBids(JSONArray jSONArray);
}
