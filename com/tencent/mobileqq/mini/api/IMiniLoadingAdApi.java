package com.tencent.mobileqq.mini.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniLoadingAdApi extends QRouteApi {
    void downloadAd(String str, String str2, boolean z16, Downloader.DownloadListener downloadListener, Downloader.DownloadMode downloadMode, JSONObject jSONObject);

    void reportEvent(String str, Bundle bundle, String str2);

    void updateLoadingAdLayoutAndShow(Activity activity, int i3, String str, String str2, String str3, String str4, String str5, String str6, long j3, IMiniLoadingAdListener iMiniLoadingAdListener);
}
