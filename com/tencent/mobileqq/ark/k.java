package com.tencent.mobileqq.ark;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class k implements a91.b {
    public static String b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.keys().hasNext()) {
                QLog.e("ArkApp.ArkQQCallBack", 1, "getArkMetaValue fail. meta has no keys.");
                return "";
            }
            return jSONObject.getJSONObject((String) jSONObject.keys().next()).optString(str2);
        } catch (Exception e16) {
            QLog.e("ArkApp.ArkQQCallBack", 1, "getArkMetaValue fail. e: " + e16.getMessage());
            return "";
        }
    }

    @Override // a91.b
    public boolean a(int i3, JSONObject jSONObject) {
        String str;
        String optString = jSONObject.optString("app");
        String optString2 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
        String optString3 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
        Map<String, String> replyConfigFromMsg = ((IArkMsgReplyMgr) QRoute.api(IArkMsgReplyMgr.class)).getReplyConfigFromMsg(jSONObject);
        if (replyConfigFromMsg != null && !replyConfigFromMsg.isEmpty()) {
            str = replyConfigFromMsg.get(IArkMsgReplyMgr.kArkMsgReplyJumpUrl);
        } else if (!TextUtils.isEmpty(optString2)) {
            String b16 = b(optString3, WadlProxyConsts.KEY_JUMP_URL);
            str = TextUtils.isEmpty(b16) ? b(optString3, "jumpURL") : b16;
        } else {
            str = "";
        }
        boolean d16 = a91.a.d(str, i3, optString, optString2);
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkQQCallBack", 1, "canJump = " + d16 + " ,arkJson = " + jSONObject + " ,map = " + replyConfigFromMsg);
        }
        return d16;
    }
}
