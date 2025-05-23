package com.tencent.qqmini.nativePlugins;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static final String f346979d = "a";

    @JsEvent({"getQimei36"})
    public void getQimei(RequestEvent requestEvent) {
        try {
            String c16 = com.tencent.mobileqq.statistics.o.c();
            HashMap hashMap = new HashMap();
            hashMap.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, c16);
            requestEvent.ok(new JSONObject(hashMap));
            if (QLog.isColorLevel()) {
                QLog.d(f346979d, 1, "get qimei36 success qimei ==" + c16);
            }
        } catch (Exception e16) {
            requestEvent.fail();
            QLog.e(f346979d, 1, "getQimei" + e16.getMessage());
        }
    }
}
