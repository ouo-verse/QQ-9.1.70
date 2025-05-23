package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.guild.api.IGuildTextForwardApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardQCircleArkOption extends ForwardArkMsgOption {
    static IPatchRedirector $redirector_;

    public ForwardQCircleArkOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(this.mExtraData.getString("forward_ark_app_meta", ""));
            if (jSONObject2.has("video")) {
                jSONObject = jSONObject2.optJSONObject("video");
            }
        } catch (JSONException e16) {
            QLog.e(ForwardBaseOption.TAG, 1, "forwardToGuildFeed error", e16);
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("jumpURL");
            return new SharePublishGuildFeedParam.QCircleTypeParam(jSONObject.optString("title"), jSONObject.optString("preview"), optString, jSONObject.optString("pcJumpUrl"));
        }
        return GuildForwardUtilKt.g(this.mExtraData);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected String getTroopUin(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) resultRecord);
        }
        if (resultRecord == null) {
            return "";
        }
        if (resultRecord.getUinType() == 10014) {
            return resultRecord.guildId;
        }
        return resultRecord.groupUin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), str3)).booleanValue();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = getUserInputStr();
        }
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(ForwardBaseOption.TAG, 2, "sendMessage2TargetOnConfirm: invoked.  textAndEmoji: " + str3);
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        if (i3 == 10014) {
            ((IGuildTextForwardApi) QRoute.api(IGuildTextForwardApi.class)).sendMsg(sessionInfo.f179559f, sessionInfo.f179557e, str3);
        } else {
            com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, str3);
        }
        return true;
    }
}
