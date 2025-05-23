package com.tencent.gdtad.kuikly.module;

import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.statistics.metric.IAdMetric;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.kuikly.module.c;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
final class GdtKuiklyModuleDeviceInfoHandler {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(e eVar, c cVar, qq_ad_get.QQAdGet.DeviceInfo deviceInfo) {
        JSONObject jSONObject;
        h hVar = null;
        if (deviceInfo != null) {
            try {
                jSONObject = (JSONObject) GdtJsonPbUtil.pbToJson(deviceInfo);
            } catch (Throwable th5) {
                QLog.e("GdtKuiklyModuleDeviceInfoHandler", 1, "[callback] info:" + cVar, th5);
            }
            JSONObject newJSONObject = AdJSONUtil.newJSONObject();
            AdJSONUtil.put(newJSONObject, "deviceInfo", jSONObject);
            if (eVar != null) {
                hVar = eVar.f109311b;
            }
            if (hVar != null) {
                QLog.e("GdtKuiklyModuleDeviceInfoHandler", 1, "[callback] error, callback is null, info:" + cVar + " jsonResult:" + newJSONObject);
                return;
            }
            QLog.i("GdtKuiklyModuleDeviceInfoHandler", 1, "[callback] info:" + cVar + " jsonResult:" + newJSONObject);
            hVar.invoke(newJSONObject);
            return;
        }
        jSONObject = null;
        JSONObject newJSONObject2 = AdJSONUtil.newJSONObject();
        AdJSONUtil.put(newJSONObject2, "deviceInfo", jSONObject);
        if (eVar != null) {
        }
        if (hVar != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(e eVar) {
        String str;
        String str2;
        boolean z16;
        c.b bVar;
        c.b bVar2;
        c.a aVar;
        c.a aVar2;
        boolean z17 = true;
        if (eVar == null) {
            QLog.e("GdtKuiklyModuleDeviceInfoHandler", 1, "[handleImpl] error, params is null");
            return;
        }
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = null;
        if (!wm0.b.m().r()) {
            QLog.e("GdtKuiklyModuleDeviceInfoHandler", 1, "[handleImpl] error, not enabled");
            b(eVar, null, null);
            return;
        }
        c cVar = (c) com.tencent.gdtad.json.a.a(eVar.f109313d, c.class, null);
        QLog.i("GdtKuiklyModuleDeviceInfoHandler", 1, "[handleImpl] info:" + cVar);
        IAdMetric build = AdMetricService.getInstance().build(AdMetricID.Kuikly.Module.GET_DEVICE_INFO);
        if (cVar != null && (aVar2 = cVar.contextInfo) != null) {
            str = aVar2.bundleName;
        } else {
            str = null;
        }
        IAdMetric tagSet = build.setTagSet(AdMetricTag.Kuikly.BUNDLE_NAME, str);
        if (cVar != null && (aVar = cVar.contextInfo) != null) {
            str2 = aVar.pageName;
        } else {
            str2 = null;
        }
        AdMetricService.getInstance().handle(new WeakReference<>(BaseApplication.getContext()), tagSet.setTagSet(AdMetricTag.Kuikly.PAGE_NAME, str2).setTagSet(AdMetricTag.EVENT_NAME, eVar.f109312c).setEnabled(wm0.b.m().u()));
        GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
        if (cVar != null && (bVar2 = cVar.paramsInfo) != null && bVar2.supportOpenMotiveAd) {
            z16 = true;
        } else {
            z16 = false;
        }
        params.supportOpenMotiveAd = z16;
        if (cVar == null || (bVar = cVar.paramsInfo) == null || !bVar.supportWxMiniAuthorizationState) {
            z17 = false;
        }
        params.supportWXMINIAuthorizationState = z17;
        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), params);
        if (create != null) {
            deviceInfo = create.deviceInfo;
        }
        b(eVar, cVar, deviceInfo);
    }

    public void c(final e eVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.kuikly.module.GdtKuiklyModuleDeviceInfoHandler.1
            @Override // java.lang.Runnable
            public void run() {
                GdtKuiklyModuleDeviceInfoHandler.this.d(eVar);
            }
        }, 128, null, true);
    }
}
