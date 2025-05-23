package com.tenpay.sdk.apilogic;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.weiyun.poi.PoiDbManager;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.util.Utils;
import cooperation.peak.PeakConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class ApiBaseGotoview extends ApiBaseInterface {
    private static final String TAG = "ApiBaseGotoview";
    protected JSONObject ejson;
    protected Service mService;
    protected String nick_name;

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiBaseGotoview(Context context, String str, String str2, Bundle bundle, ResultReceiver resultReceiver, JSONObject jSONObject, Service service) {
        super(context, str, bundle, resultReceiver);
        this.nick_name = str2;
        this.ejson = jSONObject;
        this.mService = service;
        QwLog.i("gotoView ejson = " + jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addIfHasTheParamHongBao(Map<String, String> map, JSONObject jSONObject) {
        String optString = jSONObject.optString("skin_id");
        String optString2 = jSONObject.optString("hb_from");
        String optString3 = jSONObject.optString("feedsid");
        String optString4 = jSONObject.optString("hb_from_type");
        String optString5 = jSONObject.optString("grab_uin_list");
        String optString6 = jSONObject.optString("feedsid");
        String optString7 = jSONObject.optString(PoiDbManager.TBL_POI);
        String optString8 = jSONObject.optString("resource_type");
        String optString9 = jSONObject.optString("domain");
        String optString10 = jSONObject.optString("client_extend");
        String optString11 = jSONObject.optString("birthday");
        String optString12 = jSONObject.optString("recv_name");
        String optString13 = jSONObject.optString("tinyid");
        String optString14 = jSONObject.optString("guild_id");
        String optString15 = jSONObject.optString("sub_guild_id");
        Utils.addToMapIfHasKeyValue(map, "grab_uin_list", optString5);
        Utils.addToMapIfHasKeyValue(map, "feedsid", optString6);
        Utils.addToMapIfHasKeyValue(map, PoiDbManager.TBL_POI, optString7);
        Utils.addToMapIfHasKeyValue(map, "resource_type", optString8);
        Utils.addToMapIfHasKeyValue(map, "skin_id", optString);
        Utils.addToMapIfHasKeyValue(map, "outer_skin_id", jSONObject.optString("outer_skin_id"));
        Utils.addToMapIfHasKeyValue(map, "skin_from", jSONObject.optString("skin_from"));
        Utils.addToMapIfHasKeyValue(map, "hb_from", optString2);
        Utils.addToMapIfHasKeyValue(map, "feedsid", optString3);
        Utils.addToMapIfHasKeyValue(map, "hb_from_type", optString4);
        Utils.addToMapIfHasKeyValue(map, "domain", optString9);
        Utils.addToMapIfHasKeyValue(map, "subchannel", jSONObject.optInt("subchannel", 0) + "");
        Utils.addToMapIfHasKeyValue(map, "client_extend", optString10);
        Utils.addToMapIfHasKeyValue(map, "birthday", optString11);
        Utils.addToMapIfHasKeyValue(map, "recv_name", optString12);
        Utils.addToMapIfHasKeyValue(map, "tinyid", optString13);
        Utils.addToMapIfHasKeyValue(map, "guild_id", optString14);
        Utils.addToMapIfHasKeyValue(map, "sub_guild_id", optString15);
        Utils.addToMapIfHasKeyValue(map, "hb_flag", jSONObject.optString("hb_flag"));
        Utils.addToMapIfHasKeyValue(map, PeakConstants.COVER_ID, jSONObject.optString(PeakConstants.COVER_ID));
        Utils.addToMapIfHasKeyValue(map, "avatar_id", jSONObject.optString("avatar_id"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent newComIntent() {
        Intent intent = new Intent();
        if (!(getContext() instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("uin", this.uin);
        intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, this.nick_name);
        ResultReceiver resultReceiver = this.callback;
        if (resultReceiver != null) {
            intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, resultReceiver);
        }
        intent.putExtra("is_inner", true);
        intent.putExtra("wallet_bind", 1);
        intent.putExtra("prossesId", System.currentTimeMillis());
        intent.putExtra("extra_data", this.ejson.toString());
        intent.putExtra("appid", this.params.getString("appid"));
        intent.putExtra("guid", this.params.getByteArray("guid"));
        intent.putExtra("come_from", this.params.getInt("come_from"));
        intent.putExtra(j.T0, this.params.getString(j.T0));
        intent.putExtra("curFriendUin", this.params.getString("curFriendUin", ""));
        intent.putExtra("no_start_for_result_for_api_go_to_view", true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendConfirm(Context context, String str, String str2, String str3, ResultReceiver resultReceiver) {
        String str4;
        QwLog.i("" + str);
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", str);
            hashMap.put(WadlProxyConsts.CHANNEL, str2);
            hashMap.put("sp_data", Uri.decode(str3));
            TenpayBL tenpayBL = new TenpayBL();
            tenpayBL.setNetListener(new ApiNetListener(context, resultReceiver, new UserInfo(str, null), true, false));
            if (!"128".equals(str2) && !"256".equals(str2)) {
                if ("512".equals(str2)) {
                    str4 = Cgi.URI_HB_QZONE_VISITOR_CALLBACK;
                } else {
                    str4 = Cgi.URI_HB_PAY_CONFIRM;
                }
            } else {
                str4 = Cgi.URI_HB_QZONE_CALLBACK;
            }
            tenpayBL.doTask(context, str4, hashMap, "", "0", str, true);
            return;
        }
        if (resultReceiver != null) {
            resultReceiver.send(-101, PayHelper.createResultForError("sendConfirm fail! context is " + context + " | uin is " + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendHbReuest(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i3, String str12, String str13, Map<String, String> map, ResultReceiver resultReceiver) {
        int i16;
        String str14;
        QwLog.i("extra: " + map + "___" + str);
        if (context == null || TextUtils.isEmpty(str)) {
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("sendHb fail! context is " + context + " | uin is " + str));
                return;
            }
            return;
        }
        try {
            i16 = Integer.parseInt(str10);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "", e16);
            i16 = 0;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("uin", str);
        hashMap.put("name", str2);
        hashMap.put("total_amount", str3);
        hashMap.put("total_num", str4);
        hashMap.put("bus_type", str5);
        hashMap.put("type", i3 + "");
        hashMap.put("wishing", str6);
        hashMap.put("recv_uin", str7);
        hashMap.put("recv_type", str8);
        hashMap.put(WadlProxyConsts.CHANNEL, str10);
        hashMap.put("na_from_h5_data", str11);
        hashMap.put("session_token", str9);
        if (i16 == 64) {
            hashMap.put("theme_type", str13);
            hashMap.put("group_id", str12);
        }
        if (i16 == 64) {
            str14 = Cgi.URI_HB_GROUP_PACK;
        } else {
            str14 = Cgi.URI_HB_PACK;
        }
        UserInfo userInfo = new UserInfo(str, null);
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiNetListener(context, resultReceiver, userInfo, false, true));
        tenpayBL.doTask(context, str14, hashMap, "", "0", str, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendQZoneHb(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ResultReceiver resultReceiver) {
        QwLog.i("" + str);
        if (context != null && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", str);
            hashMap.put("name", str2);
            hashMap.put("feedsid", str10);
            if ("512".equals(str3)) {
                hashMap.put("total_num", str5);
                hashMap.put("bus_type", str6);
            } else {
                hashMap.put("feeds_uin", str8);
                hashMap.put("feeds_name", str9);
            }
            hashMap.put(WadlProxyConsts.CHANNEL, str3);
            hashMap.put("wishing", str4);
            hashMap.put("amount", str7);
            TenpayBL tenpayBL = new TenpayBL();
            tenpayBL.setNetListener(new ApiNetListener(context, resultReceiver, new UserInfo(str, null), false, true));
            tenpayBL.doTask(context, Cgi.URI_HB_QZONE_PACK, hashMap, "", "0", str, true);
            return;
        }
        if (resultReceiver != null) {
            resultReceiver.send(-101, PayHelper.createResultForError("sendQZoneHb fail! context is " + context + " | uin is " + str));
        }
    }
}
