package com.xingin.xhssharesdk.model.sharedata;

import androidx.annotation.Keep;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsShareDeeplinkData {
    public String did;
    public XhsNote noteInfo;
    public String sdkVersion;
    public String shareSessionId;
    public String shareType;
    public long startShareTimestamp;
    public String thirdAppPackage;
    public String thirdAppVersion;

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        XhsNote xhsNote = this.noteInfo;
        if (xhsNote != null) {
            jSONObject.putOpt("note_info", xhsNote.toJsonForDeeplink());
        }
        jSONObject.putOpt(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, this.shareType);
        jSONObject.putOpt("sdk_version", this.sdkVersion);
        jSONObject.putOpt("third_app_package", this.thirdAppPackage);
        jSONObject.putOpt("third_app_version", this.thirdAppVersion);
        jSONObject.putOpt("share_session_id", this.shareSessionId);
        jSONObject.putOpt(MessageForRichState.SIGN_MSG_DATA_ID_KEY, this.did);
        jSONObject.putOpt("start_share_timestamp", Long.valueOf(this.startShareTimestamp));
        return jSONObject;
    }
}
