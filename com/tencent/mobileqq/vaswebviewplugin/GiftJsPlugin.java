package com.tencent.mobileqq.vaswebviewplugin;

import NS_COMM.COMM;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vas.ipc.remote.AnonymousIPC;
import com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.util.Map;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class GiftJsPlugin extends VasWebviewJsPluginV2 {
    public static final String BUSINESS_NAME = "GiftJsPlugin";
    public static final String TAG = "GiftJsPlugin";
    public static String sCallbackJs = "";
    public static String sTroopUin = "";

    public static void openGiftBrowser(Context context, String str) {
        if (str == null) {
            return;
        }
        String str2 = QVipGiftProcessor.getConfig().troopAioUrl;
        boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        String a16 = com.tencent.biz.troopgift.c.a(str);
        sTroopUin = str;
        com.tencent.mobileqq.vas.d.a(context, str2.replace("{troopUin}", str).replace("{themeMode}", (isInNightMode ? 1 : 0) + "").replace("{uin}", a16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        if (map == null || !map.containsKey("requestCode") || !map.containsKey("data") || ((Integer) map.get("requestCode")).intValue() != 12006) {
            return false;
        }
        Intent intent = (Intent) map.get("data");
        String stringExtra = intent.getStringExtra("member_uin");
        String stringExtra2 = intent.getStringExtra("member_nickname");
        String stringExtra3 = intent.getStringExtra("troop_uin");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra3)) {
            com.tencent.biz.troopgift.c.b(stringExtra3, stringExtra);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uin", stringExtra);
            jSONObject.put("nick", stringExtra2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        super.callJs(sCallbackJs, jSONObject.toString());
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "GiftJsPlugin";
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|uin", method = "selectMember")
    public void openSelectMember(String str, String str2) {
        sCallbackJs = str;
        Intent troopMemberListActivityLaunchIntent = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(BaseApplication.getContext(), str2, 14);
        troopMemberListActivityLaunchIntent.putExtra("param_is_pop_up_style", true);
        troopMemberListActivityLaunchIntent.putExtra("custom_title_name", BaseApplication.getContext().getString(R.string.f171418ev1));
        troopMemberListActivityLaunchIntent.setFlags(603979776);
        this.mRuntime.a().startActivityForResult(troopMemberListActivityLaunchIntent, COMM.mini_app_qzone_recommend);
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            troopMemberListActivityLaunchIntent.putExtra("troop_gift_from", b16.getCurrentAccountUin());
        }
        this.mRuntime.a().startActivityForResult(troopMemberListActivityLaunchIntent, COMM.mini_app_qzone_recommend);
        try {
            super.callJs(str);
        } catch (Exception e16) {
            super.callJsOnError(str, e16.getMessage());
        }
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback|troopUin|uin", method = "getAnonymousInfo")
    public void transferAnonymousInfo(String str, String str2, String str3) {
        sCallbackJs = str;
        if (str3.equals(this.mRuntime.b().getCurrentAccountUin())) {
            IAnonymousIPC iAnonymousIPC = (IAnonymousIPC) RemoteProxy.getProxy(AnonymousIPC.class);
            if (!iAnonymousIPC.isAnonymous(str2)) {
                super.callJs(sCallbackJs, "");
                return;
            }
            String nickname = iAnonymousIPC.getNickname(str2);
            String avatarID = iAnonymousIPC.getAvatarID(str2);
            String rankColor = iAnonymousIPC.getRankColor(str2);
            if (nickname != null) {
                String str4 = "name=" + nickname + "&id=" + avatarID + "&color=" + rankColor;
                try {
                    super.callJs(sCallbackJs, "{anonymousInfo:\"" + str4 + "\",sign:\"" + new String(Hex.encodeHex(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest((str4 + "&key=" + QVipGiftProcessor.getConfig().anonymousFlag).getBytes("utf-8")))) + "\"}");
                } catch (Exception e16) {
                    super.callJsOnError(sCallbackJs, e16.getMessage());
                }
            }
        }
    }
}
