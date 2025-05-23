package com.tencent.mobileqq.forward;

import android.content.Intent;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameCenterArkMsgSenderApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class ForwardRedPackArkMsgOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    public ForwardRedPackArkMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        Intent intent2 = this.mIntent;
        if (intent2 != null) {
            intent2.putExtra("is_need_show_toast", false);
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
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && (recentUser.getType() == 0 || recentUser.getType() == 1 || recentUser.getType() == 3000)) {
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean needShowEditInput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        QLog.i("ForwardRedPackArkMsgOption", 1, "[realForwardTo]");
        try {
            String string = this.mExtraData.getString("uin");
            int i3 = this.mExtraData.getInt("uintype", 0);
            JSONObject jSONObject = new JSONObject(this.mExtraData.getString("requestJson"));
            if (i3 == 0) {
                jSONObject.put("aioType", 1);
            } else if (i3 == 1 || i3 == 3000) {
                jSONObject.put("aioType", 2);
            }
            jSONObject.put("number", string);
            ((IGameCenterArkMsgSenderApi) QRoute.api(IGameCenterArkMsgSenderApi.class)).sendArkMsg(jSONObject.toString(), null);
            this.mActivity.finish();
        } catch (Exception e16) {
            QLog.e("ForwardRedPackArkMsgOption", 1, "[realForwardTo],error:" + e16);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }
}
