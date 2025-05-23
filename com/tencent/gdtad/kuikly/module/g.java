package com.tencent.gdtad.kuikly.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
final class g {
    private void a(h hVar) {
        if (hVar == null) {
            QLog.i("GdtKuiklyModuleWebViewHandler", 1, "[callback] error, callback is null, ");
        } else {
            QLog.i("GdtKuiklyModuleWebViewHandler", 1, "[callback]");
            hVar.invoke(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(e eVar) {
        String str;
        GdtAd gdtAd;
        Intent intent;
        if (eVar == null) {
            QLog.e("GdtKuiklyModuleWebViewHandler", 1, "[handle] error, params is null");
            return;
        }
        JSONObject newJSONObject = AdJSONUtil.newJSONObject(eVar.f109313d);
        String str2 = null;
        String optString = AdJSONUtil.optString(AdJSONUtil.optJSONObject(newJSONObject, "context"), "pageName", null);
        JSONObject optJSONObject = AdJSONUtil.optJSONObject(newJSONObject, "adInfo");
        try {
            str = newJSONObject.getString("url");
        } catch (Throwable th5) {
            th = th5;
            str = null;
        }
        try {
            gdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), optJSONObject));
        } catch (Throwable th6) {
            th = th6;
            QLog.e("GdtKuiklyModuleWebViewHandler", 1, "[handle]", th);
            gdtAd = null;
            if (!TextUtils.isEmpty(str)) {
            }
        }
        if (!TextUtils.isEmpty(str)) {
            QLog.i("GdtKuiklyModuleWebViewHandler", 1, "[handle] error, url is empty");
            a(eVar.f109311b);
            return;
        }
        Activity activity = eVar.f109310a;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            str2 = intent.getStringExtra(LaunchParam.KEY_REF_ID);
        }
        com.tencent.gdtad.kuikly.a.l("GdtKuiklyModuleWebViewHandler", "[handle] refId:" + str2, AdMetricID.Kuikly.Module.WEB_VIEW, gdtAd, null, optString, eVar.f109312c);
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(eVar.f109310a, new InitGdtContextParams());
        } catch (Throwable th7) {
            QLog.e("GdtKuiklyModuleWebViewHandler", 1, "[handle]", th7);
        }
        AdBrowser.Params params = new AdBrowser.Params();
        params.activity = new WeakReference<>(eVar.f109310a);
        params.f61348ad = gdtAd;
        params.url = str;
        Bundle bundle = new Bundle();
        params.extrasForIntent = bundle;
        bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
        if (!TextUtils.isEmpty(str2)) {
            params.extrasForIntent.putString(LaunchParam.KEY_REF_ID, str2);
        }
        AdBrowser.getInstance().show(params);
        a(eVar.f109311b);
    }
}
