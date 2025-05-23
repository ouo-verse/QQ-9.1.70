package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkMsgReplyMgr extends QRouteApi {
    public static final String ARKMSGREPLYBIZSRC = "kArkMsgReplyBizsrc";
    public static final String ArkMsgReplyAction_ShowLargeText = "showLargeText";
    public static final String kArkMsgReplyAction = "kArkMsgReplyAction";
    public static final String kArkMsgReplyApp = "kArkMsgReplyApp";
    public static final String kArkMsgReplyIcon = "kArkMsgReplyIcon";
    public static final String kArkMsgReplyJumpUrl = "kArkMsgReplyJumpUrl";
    public static final String kArkMsgReplyTag = "kArkMsgReplyTag";
    public static final String kArkMsgReplyTitle = "kArkMsgReplyTitle";
    public static final String kArkMsgReplyView = "kArkMsgReplyView";

    boolean canReply(String str, String str2, String str3);

    boolean canReplyByFreesia(String str, String str2);

    Map<String, String> getArkReplyConfig(JSONObject jSONObject);

    Map<String, String> getReplyConfigFromMsg(JSONObject jSONObject);

    int msgReplyFromType(String str, String str2);

    void updateConfig(JSONObject jSONObject);
}
