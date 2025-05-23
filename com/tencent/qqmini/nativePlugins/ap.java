package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class ap extends BaseJsPlugin implements nl0.c {

    /* renamed from: d, reason: collision with root package name */
    SparseArray<RequestEvent> f347009d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private int f347010e = 0;

    public ap() {
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).addListener(this);
    }

    private synchronized int b() {
        int i3;
        i3 = this.f347010e;
        this.f347010e = i3 + 1;
        return i3;
    }

    private JSONObject c(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e("WebSsoJsPlugin", 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    @Override // nl0.c
    public HashSet<String> getFilterCmds() {
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null) {
            return gVar.c();
        }
        return GameCenterUtil.DEFAULT_WEBSSO_CMDS;
    }

    @JsEvent({WebSsoJsPlugin.EVENT_QUERY_WEBSSO})
    public void requestWebSSO(RequestEvent requestEvent) {
        try {
            JSONObject c16 = c(requestEvent);
            if (c16 != null) {
                JSONObject jSONObject = c16.getJSONObject("data");
                String string = jSONObject.getString(WadlProxyConsts.PARAM_WEBSSO_CMD_ID);
                JSONObject jSONObject2 = jSONObject.getJSONObject(WadlProxyConsts.PARAM_WEBSSO_REQ);
                HashSet<String> filterCmds = getFilterCmds();
                if (!TextUtils.isEmpty(string) && filterCmds != null && filterCmds.contains(string)) {
                    int b16 = b();
                    this.f347009d.put(b16, requestEvent);
                    Bundle bundle = new Bundle();
                    bundle.putInt(WebSsoJsPlugin.KEY_SEQ, b16);
                    ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).requestWebSso(string, jSONObject2, bundle);
                    return;
                }
                requestEvent.fail(HardCodeUtil.qqStr(R.string.vjz));
            }
        } catch (Throwable unused) {
            requestEvent.fail(HardCodeUtil.qqStr(R.string.vjy));
            if (QLog.isColorLevel()) {
                QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
            }
        }
    }

    @Override // nl0.c
    public void onCmdRsp(Intent intent, String str, long j3, JSONObject jSONObject) {
        int intExtra = intent != null ? intent.getIntExtra(WebSsoJsPlugin.KEY_SEQ, -1) : -1;
        if (intExtra == -1) {
            return;
        }
        RequestEvent requestEvent = this.f347009d.get(intExtra);
        this.f347009d.remove(intExtra);
        if (requestEvent == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cmd", str);
            jSONObject2.put("ret", j3);
            jSONObject2.put("rsp", jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (j3 == 0) {
            requestEvent.ok(jSONObject2);
        } else {
            requestEvent.fail(jSONObject2, "");
        }
    }
}
