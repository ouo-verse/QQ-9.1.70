package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$AppCategories;
import NS_MINI_INTERFACE.INTERFACE$SetWXAppInfoRequest;
import NS_MINI_INTERFACE.INTERFACE$WXAppInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetWxAppInfoRequest extends ProtoBufRequest {
    private final INTERFACE$SetWXAppInfoRequest request = new INTERFACE$SetWXAppInfoRequest();

    public SetWxAppInfoRequest(Intent intent) {
        INTERFACE$WXAppInfo iNTERFACE$WXAppInfo = new INTERFACE$WXAppInfo();
        String nonnullString = nonnullString(intent.getStringExtra("app_id"));
        String nonnullString2 = nonnullString(intent.getStringExtra(MiniConst.WxMiniAppInfoConst.EXTRA_ALIAS));
        String nonnullString3 = nonnullString(intent.getStringExtra("app_name"));
        String nonnullString4 = nonnullString(intent.getStringExtra(MiniConst.WxMiniAppInfoConst.EXTRA_ICON));
        String nonnullString5 = nonnullString(intent.getStringExtra(MiniConst.WxMiniAppInfoConst.EXTRA_DESC));
        String nonnullString6 = nonnullString(intent.getStringExtra(MiniConst.WxMiniAppInfoConst.EXTRA_REGISTER_BODY));
        String nonnullString7 = nonnullString(intent.getStringExtra(MiniConst.WxMiniAppInfoConst.EXTRA_CATEGORIES));
        String nonnullString8 = nonnullString(intent.getStringExtra("result_code"));
        int intExtra = intent.getIntExtra("scene", 0);
        intExtra = intExtra == 9999 ? 0 : intExtra;
        iNTERFACE$WXAppInfo.appid.set(nonnullString);
        iNTERFACE$WXAppInfo.appAliasName.set(nonnullString2);
        iNTERFACE$WXAppInfo.appName.set(nonnullString3);
        iNTERFACE$WXAppInfo.appIcon.set(nonnullString4);
        iNTERFACE$WXAppInfo.appDesc.set(nonnullString5);
        iNTERFACE$WXAppInfo.appRegisterInfo.set(nonnullString6);
        iNTERFACE$WXAppInfo.errCode.set(nonnullString8);
        iNTERFACE$WXAppInfo.appType.set(0);
        iNTERFACE$WXAppInfo.scene.set(intExtra);
        if (!TextUtils.isEmpty(nonnullString7)) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(nonnullString7);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "");
                        String optString2 = optJSONObject.optString(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "");
                        INTERFACE$AppCategories iNTERFACE$AppCategories = new INTERFACE$AppCategories();
                        iNTERFACE$AppCategories.first.set(optString);
                        iNTERFACE$AppCategories.second.set(optString2);
                        arrayList.add(iNTERFACE$AppCategories);
                    }
                }
                if (!arrayList.isEmpty()) {
                    iNTERFACE$WXAppInfo.appCategories.set(arrayList);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        this.request.wxAppInfo.set(iNTERFACE$WXAppInfo);
        QLog.i("ProtoBufRequest", 1, "SetWxAppInfoRequest appid:" + iNTERFACE$WXAppInfo.appid.get() + " errCode:" + iNTERFACE$WXAppInfo.errCode.get() + " scene:" + iNTERFACE$WXAppInfo.scene.get());
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.request.toByteArray();
    }

    private String nonnullString(String str) {
        return str == null ? "" : str;
    }
}
