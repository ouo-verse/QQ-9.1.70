package com.tencent.mobileqq.wxmini.ad.kuikly.module;

import ab3.a;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wxmini.ad.kuikly.module.d;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes35.dex */
final class c {
    static boolean c(String str, boolean z16) {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, z16);
        } catch (Throwable th5) {
            QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[isSwitchOn] groupId:" + str, th5);
            return z16;
        }
    }

    public void b(e eVar) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        if (eVar == null) {
            QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[handle] error, params is null");
            return;
        }
        if (!c("106186", true)) {
            QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[handle] error, not enabled");
            a(eVar, null, null);
            return;
        }
        d dVar = (d) cb3.a.a(eVar.f327603d, d.class, null);
        if (dVar != null && dVar.a()) {
            JsonObject jsonObject = dVar.adInfo;
            String jsonElement = jsonObject != null ? jsonObject.toString() : null;
            if (TextUtils.isEmpty(jsonElement)) {
                QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[handle] error, adInfoString is empty, info:" + dVar.b(null));
                a(eVar, dVar, null);
                return;
            }
            JSONObject newJSONObject = AdJSONUtil.newJSONObject(jsonElement);
            if (AdJSONUtil.isJSONObjectNull(newJSONObject)) {
                QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[handle] error, adInfoJSONObject is null, info:" + dVar.b(null));
                a(eVar, dVar, null);
                return;
            }
            try {
                adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), newJSONObject);
            } catch (Throwable th5) {
                QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[handle]", th5);
                adInfo = null;
            }
            if (adInfo == null) {
                QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, "[handle] error, adInfo is null, info:" + dVar.b(null));
                a(eVar, dVar, null);
                return;
            }
            GdtAd gdtAd = new GdtAd(adInfo);
            String str = "[handle] info:" + dVar.b(gdtAd);
            d.a aVar = dVar.contextInfo;
            bb3.a.b("WxMiniGameCenterAdKuiklyModuleClickHandler", str, AdMetricID.WXMINIGameCenter.Kuikly.Module.CLICK, gdtAd, aVar != null ? aVar.bundleName : null, aVar != null ? aVar.pageName : null, eVar.f327602c);
            a.b bVar = new a.b();
            bVar.f25776a = new GdtAd(adInfo);
            d.b bVar2 = dVar.optionsInfo;
            bVar.f25777b = bVar2.slot;
            bVar.f25778c = cb3.a.b(bVar2.wxMiniHostExtraData, null);
            bVar.f25779d = dVar.optionsInfo.wxMiniHostScene;
            bVar.f25782g = new WeakReference<>(eVar.f327600a);
            ab3.a.e(bVar);
            a(eVar, dVar, gdtAd);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handle] error, info is not valid, info:");
        sb5.append(dVar != null ? dVar.b(null) : null);
        QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, sb5.toString());
        a(eVar, dVar, null);
    }

    private void a(e eVar, d dVar, GdtAd gdtAd) {
        a aVar = eVar != null ? eVar.f327601b : null;
        if (aVar == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[callback] error, callback is null, info:");
            sb5.append(dVar != null ? dVar.b(gdtAd) : null);
            QLog.e("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, sb5.toString());
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[callback] info:");
        sb6.append(dVar != null ? dVar.b(gdtAd) : null);
        QLog.i("WxMiniGameCenterAdKuiklyModuleClickHandler", 1, sb6.toString());
        aVar.invoke(null);
    }
}
