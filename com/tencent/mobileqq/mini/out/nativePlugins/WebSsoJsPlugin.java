package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.g;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import nl0.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class WebSsoJsPlugin implements NativePlugin, c {
    public static final String EVENT_QUERY_WEBSSO = "requestWebSSO";
    public static final String KEY_CMD = "cmd";
    public static final String KEY_RET = "ret";
    public static final String KEY_RSP = "rsp";
    public static final String KEY_SEQ = "mini_seq";
    private static final String TAG = "WebSsoJsPlugin";
    SparseArray<JSContext> callbackMap = new SparseArray<>();
    private int seq = 0;

    public WebSsoJsPlugin() {
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).addListener(this);
    }

    private synchronized int genSeq() {
        int i3;
        i3 = this.seq;
        this.seq = i3 + 1;
        return i3;
    }

    @Override // nl0.c
    public HashSet<String> getFilterCmds() {
        g gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null) {
            return gVar.c();
        }
        return GameCenterUtil.DEFAULT_WEBSSO_CMDS;
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext != null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, jSONObject.toString());
            }
            if (EVENT_QUERY_WEBSSO.equals(jSONObject.optString("api_name"))) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    String string = jSONObject2.getString(WadlProxyConsts.PARAM_WEBSSO_CMD_ID);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(WadlProxyConsts.PARAM_WEBSSO_REQ);
                    HashSet<String> filterCmds = getFilterCmds();
                    if (!TextUtils.isEmpty(string) && filterCmds != null && filterCmds.contains(string)) {
                        int genSeq = genSeq();
                        this.callbackMap.put(genSeq, jSContext);
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_SEQ, genSeq);
                        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).requestWebSso(string, jSONObject3, bundle);
                        return;
                    }
                    jSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.qqStr(R.string.vjz));
                } catch (Throwable unused) {
                    jSContext.evaluateCallback(false, new JSONObject(), HardCodeUtil.qqStr(R.string.vjy));
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "requestWebSSO,decode param error");
                    }
                }
            }
        }
    }

    @Override // nl0.c
    public void onCmdRsp(Intent intent, String str, long j3, JSONObject jSONObject) {
        int intExtra = intent != null ? intent.getIntExtra(KEY_SEQ, -1) : -1;
        if (intExtra == -1) {
            return;
        }
        JSContext jSContext = this.callbackMap.get(intExtra);
        this.callbackMap.remove(intExtra);
        if (jSContext == null) {
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
        jSContext.evaluateCallback(j3 == 0, jSONObject2, "");
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
