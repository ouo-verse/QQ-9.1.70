package com.tencent.mobileqq.mini.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.mini.ad.MiniLoadingAdCommonManager;
import com.tencent.mobileqq.mini.api.IMiniLoadingAdApi;
import com.tencent.mobileqq.mini.api.data.IMiniLoadingAdListener;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdReportHelper;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLoadingAdApiImpl implements IMiniLoadingAdApi {
    @Override // com.tencent.mobileqq.mini.api.IMiniLoadingAdApi
    public void downloadAd(String str, String str2, boolean z16, Downloader.DownloadListener downloadListener, Downloader.DownloadMode downloadMode, JSONObject jSONObject) {
        MiniappDownloadUtil.getInstance().download(str, str2, z16, downloadListener, downloadMode, jSONObject);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniLoadingAdApi
    public void reportEvent(String str, Bundle bundle, String str2) {
        MiniLoadingAdReportHelper.INSTANCE.reportEvent(str, bundle, "", str2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniLoadingAdApi
    public void updateLoadingAdLayoutAndShow(Activity activity, int i3, String str, String str2, String str3, String str4, String str5, String str6, long j3, final IMiniLoadingAdListener iMiniLoadingAdListener) {
        if (iMiniLoadingAdListener == null) {
            return;
        }
        MiniLoadingAdCommonManager.INSTANCE.updateLoadingAdLayoutAndShow(activity, i3, str, str2, str3, str4, str5, str6, j3, new AdProxy.ILoadingAdListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniLoadingAdApiImpl.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void getLoadingAdLayoutReady() {
                iMiniLoadingAdListener.getLoadingAdLayoutReady();
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onAdClick(int i16) {
                iMiniLoadingAdListener.onAdClick(i16);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onAdDismiss(boolean z16) {
                iMiniLoadingAdListener.onAdDismiss(z16);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onAdShow(View view) {
                iMiniLoadingAdListener.onAdShow(view);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onDownloadAdEnd(String str7, long j16, String str8) {
                iMiniLoadingAdListener.onDownloadAdEnd(str7, j16, str8);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onPreloadAdReceive(int i16) {
                iMiniLoadingAdListener.onPreloadAdReceive(i16);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onSelectAdProcessDone(String str7, ArrayList<Long> arrayList, HashMap<String, String> hashMap) {
                iMiniLoadingAdListener.onSelectAdProcessDone(str7, arrayList, hashMap);
            }
        });
    }
}
