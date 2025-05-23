package com.tencent.qqmini.nativePlugins;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class f extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f347038d;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347039d;

        a(RequestEvent requestEvent) {
            this.f347039d = requestEvent;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Integer num;
            QLog.d("ExpandPlugin", 2, "[doGetUserExpandProfile] onCallback");
            Bundle bundle = eIPCResult.data;
            if (bundle == null) {
                this.f347039d.fail();
                return;
            }
            String string = bundle.getString("data");
            if (TextUtils.isEmpty(string)) {
                this.f347039d.fail("empty data!");
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(string).optJSONObject("infos");
                if (optJSONObject == null) {
                    this.f347039d.fail("empty infos!");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("base_info");
                if (optJSONObject2 != null) {
                    String optString = optJSONObject2.optString("nick");
                    String optString2 = optJSONObject.optString("avatar");
                    int optInt = optJSONObject2.optInt("gender");
                    String optString3 = optJSONObject2.optString(LpReport_UserInfo_dc02148.CONSTELLATION);
                    jSONObject.put("nick", optString);
                    jSONObject.put("avatar", optString2);
                    jSONObject.put("gender", optInt);
                    if (!TextUtils.isEmpty(optString3) && (num = (Integer) f.f347038d.get(optString3)) != null) {
                        jSONObject.put(LpReport_UserInfo_dc02148.CONSTELLATION, num);
                    }
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("expand_info");
                if (optJSONObject3 != null) {
                    String optString4 = optJSONObject3.optString("declarationa");
                    String optString5 = optJSONObject3.optString("voice_url");
                    long optLong = optJSONObject3.optLong("voice_duration");
                    String optString6 = optJSONObject3.optString("voice_color");
                    String str = "";
                    if (!TextUtils.isEmpty(optString6)) {
                        String format = String.format("%08X", Integer.valueOf(Color.parseColor("#" + optString6) & (-1)));
                        str = "#" + format.substring(2) + format.substring(0, 2);
                    }
                    jSONObject.put("declaration", optString4);
                    jSONObject.put("voice", optString5);
                    jSONObject.put("voiceDuration", optLong);
                    jSONObject.put("voiceColor", str);
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("selected_pic");
                if (optJSONArray != null) {
                    jSONObject.put("pictureWallPictures", optJSONArray);
                }
                this.f347039d.ok(jSONObject);
            } catch (Exception e16) {
                this.f347039d.fail(e16.getMessage());
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f347038d = hashMap;
        hashMap.put("\u6c34\u74f6\u5ea7", 1);
        hashMap.put("\u53cc\u9c7c\u5ea7", 2);
        hashMap.put("\u767d\u7f8a\u5ea7", 3);
        hashMap.put("\u91d1\u725b\u5ea7", 4);
        hashMap.put("\u53cc\u5b50\u5ea7", 5);
        hashMap.put("\u5de8\u87f9\u5ea7", 6);
        hashMap.put("\u72ee\u5b50\u5ea7", 7);
        hashMap.put("\u5904\u5973\u5ea7", 8);
        hashMap.put("\u5929\u79e4\u5ea7", 9);
        hashMap.put("\u6c34\u74f6\u5ea7", 10);
        hashMap.put("\u5c04\u624b\u5ea7", 11);
        hashMap.put("\u6469\u7faf\u5ea7", 12);
    }

    @JsEvent({"openExpandChat"})
    private void openExpandChat(RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            String optString = optJSONObject.optString("uin");
            int optInt = optJSONObject.optInt("matchRelationSource", -1);
            String optString2 = optJSONObject.optString("signature");
            if (!TextUtils.isEmpty(optString) && optInt >= 0 && !TextUtils.isEmpty(optString2)) {
                Bundle bundle = new Bundle();
                bundle.putInt("accost_type", 163);
                bundle.putString("match_uin", optString);
                bundle.putInt("matchRelationSource", optInt);
                bundle.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, Base64.decode(optString2, 0));
                EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ExpandFlutterIPCServer", "notifyOpenAio", bundle);
                if (callServer != null && callServer.isSuccess()) {
                    requestEvent.ok();
                    return;
                } else {
                    requestEvent.fail();
                    return;
                }
            }
            requestEvent.fail("Invalid params!");
        } catch (Throwable th5) {
            requestEvent.fail(th5.getMessage());
        }
    }

    @JsEvent({PluginConst.ExpandJsPluginConst.API_GET_GET_EXPAND_USER_INFO})
    public void getExpandUserInfo(RequestEvent requestEvent) {
        QLog.d("ExpandPlugin", 2, "[getExpandUserInfo] start");
        QIPCClientHelper.getInstance().callServer("ExpandFlutterIPCServer", PluginConst.ExpandJsPluginConst.API_GET_GET_EXPAND_USER_INFO, null, new a(requestEvent));
    }
}
