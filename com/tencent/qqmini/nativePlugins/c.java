package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class c extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347031d;

        a(RequestEvent requestEvent) {
            this.f347031d = requestEvent;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            int i3;
            String str;
            int i16;
            String str2;
            String str3;
            String str4;
            boolean z16;
            Bundle bundle = eIPCResult.data;
            if (bundle != null) {
                i3 = bundle.getInt("result");
                str = bundle.getString("errMsg");
                str3 = bundle.getString("nick");
                str4 = bundle.getString("avatar");
                i16 = bundle.getInt("identity");
                z16 = bundle.getBoolean("isBind");
                str2 = bundle.getString("accountSecret");
            } else {
                i3 = -1;
                str = "";
                i16 = 0;
                str2 = "";
                str3 = str2;
                str4 = str3;
                z16 = false;
            }
            if (i3 != 0) {
                QLog.i("ChannelJsPlugin", 1, "OnGetMemberInfoByOpenId result:" + i3 + " errMsg:" + str);
                this.f347031d.fail();
                return;
            }
            try {
                QLog.i("ChannelJsPlugin", 1, "OnGetMemberInfoByOpenId succeed. nick:" + str3 + " avatar:" + str4 + " identity:" + i16 + " isBind:" + z16 + " accountSecret:" + str2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("nick", str3);
                jSONObject.put("avatar", str4);
                jSONObject.put("identity", i16);
                jSONObject.put("isBind", z16);
                jSONObject.put("accountSecret", str2);
                this.f347031d.ok(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
                this.f347031d.fail();
            }
        }
    }

    @JsEvent({PluginConst.ChannelJsPluginConst.API_GET_CHANNEL_USER_INFO})
    public void getChannelUserInfo(RequestEvent requestEvent) {
        boolean z16;
        boolean z17;
        JSONObject jSONObject;
        QLog.d("ChannelJsPlugin", 1, "[getChanneUserInfo] START");
        if (requestEvent == null) {
            return;
        }
        QLog.i("ChannelJsPlugin", 1, "getChannelUserInfo--JsEvent=" + requestEvent.event);
        if (PluginConst.ChannelJsPluginConst.API_GET_CHANNEL_USER_INFO.equals(requestEvent.event)) {
            String str = "";
            boolean z18 = false;
            long j3 = 0;
            try {
                jSONObject = new JSONObject(requestEvent.jsonParams).getJSONObject("data");
                str = jSONObject.getString("guildOpenid");
                j3 = jSONObject.getLong("miniAppId");
                z17 = jSONObject.getBoolean("isNeedBind");
            } catch (Exception unused) {
                z16 = false;
            }
            try {
                z18 = jSONObject.getBoolean("isNeedAccountSecret");
                QLog.i("ChannelJsPlugin", 1, "getChannelUserInfo param. guildOpenId:" + str + " miniAppId:" + j3 + " isNeedBind:" + z17 + " isNeedAccountSecret:" + z18);
            } catch (Exception unused2) {
                z16 = z18;
                z18 = z17;
                if (QLog.isColorLevel()) {
                    QLog.w("ChannelJsPlugin", 2, "decode guildOpenId param error");
                }
                z17 = z18;
                z18 = z16;
                Bundle bundle = new Bundle();
                bundle.putString("guildOpenId", str);
                bundle.putLong("miniAppId", j3);
                bundle.putBoolean("isNeedBind", z17);
                bundle.putBoolean("isNeedAccountSecret", z18);
                QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, IGuildIPCService.ACTION_GET_MEMBERINFO_BY_OPENID, bundle, new a(requestEvent));
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("guildOpenId", str);
            bundle2.putLong("miniAppId", j3);
            bundle2.putBoolean("isNeedBind", z17);
            bundle2.putBoolean("isNeedAccountSecret", z18);
            QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, IGuildIPCService.ACTION_GET_MEMBERINFO_BY_OPENID, bundle2, new a(requestEvent));
        }
    }
}
