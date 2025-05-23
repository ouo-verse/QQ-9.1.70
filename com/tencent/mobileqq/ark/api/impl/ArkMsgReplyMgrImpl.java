package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkMsgReplyMgr;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkMsgReplyMgrImpl implements IArkMsgReplyMgr {
    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public boolean canReply(String str, String str2, String str3) {
        return ArkMsgReplyConfigMgr.getInstance().canReply(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public boolean canReplyByFreesia(String str, String str2) {
        return ArkMsgReplyConfigMgr.getInstance().canReplyByFreesia(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public Map<String, String> getArkReplyConfig(JSONObject jSONObject) {
        return ArkMsgReplyConfigMgr.getInstance().getArkReplyConfig(jSONObject);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public Map<String, String> getReplyConfigFromMsg(JSONObject jSONObject) {
        return ArkMsgReplyConfigMgr.getInstance().getReplyConfigFromMsg(jSONObject);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public int msgReplyFromType(String str, String str2) {
        return ArkMsgReplyConfigMgr.getInstance().msgReplyFromType(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkMsgReplyMgr
    public void updateConfig(JSONObject jSONObject) {
        ArkMsgReplyConfigMgr.getInstance().updateConfig(jSONObject);
    }
}
