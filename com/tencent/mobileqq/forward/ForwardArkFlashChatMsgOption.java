package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardArkFlashChatMsgOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardArkFlashChatMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (TextUtils.isEmpty(this.mForwardText)) {
            String string = this.mExtraData.getString("forward_ark_app_prompt");
            this.mForwardText = string;
            if (TextUtils.isEmpty(string)) {
                this.mForwardText = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_DESC);
            }
        }
        return this.mForwardText;
    }

    protected boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return m(this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"), this.mExtraData.getString("troop_uin"));
    }

    protected boolean m(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2)).booleanValue();
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FLASHCHAT_RAWCONTENT);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        ArkFlashChatMessage arkFlashChatMessage = new ArkFlashChatMessage();
        arkFlashChatMessage.fromAppXml(string);
        ChatActivityFacade.z0(this.app, sessionInfo, arkFlashChatMessage, this.mExtraData.getInt("KEY_MSG_FORWARD_ID"));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (isMultiTarget2Send()) {
            for (ResultRecord resultRecord : getMultiTargetWithoutDataLine()) {
                m(resultRecord.uin, resultRecord.getUinType(), resultRecord.groupUin);
            }
            return super.realForwardTo();
        }
        l();
        return super.realForwardTo();
    }
}
