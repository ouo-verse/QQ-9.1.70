package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetUserAddFriendSettingResp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    public j(@NotNull AppInterface appInterface, @NotNull FriendHandler friendHandler) {
        super(appInterface, friendHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) friendHandler);
        }
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friendlist.getUserAddFriendSetting";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg toServiceMsg, @NotNull FromServiceMsg fromServiceMsg, @Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            f(toServiceMsg, (GetUserAddFriendSettingResp) obj);
        }
    }

    protected void f(ToServiceMsg toServiceMsg, GetUserAddFriendSettingResp getUserAddFriendSettingResp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) getUserAddFriendSettingResp);
            return;
        }
        Bundle bundle = toServiceMsg.extraData;
        boolean z16 = bundle.getBoolean("isFromZPlan", false);
        ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("zplanResultReceiver");
        if (getUserAddFriendSettingResp != null && getUserAddFriendSettingResp.result == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("GetUserAddFriendSettingReceiver", 2, "handleAddFriendSetting " + getUserAddFriendSettingResp.queryuinsetting + ", " + getUserAddFriendSettingResp.contact_bothway_friend + ", " + getUserAddFriendSettingResp.vecStrUserQuestion);
            }
            bundle.putInt("friend_setting", getUserAddFriendSettingResp.queryuinsetting);
            bundle.putLong("query_friend_uin", getUserAddFriendSettingResp.queryuin);
            bundle.putStringArrayList("user_question", getUserAddFriendSettingResp.vecStrUserQuestion);
            bundle.putBoolean("contact_bothway", getUserAddFriendSettingResp.contact_bothway_friend);
            d().notifyUI(12, true, bundle);
            if (z16 && resultReceiver != null) {
                resultReceiver.send(getUserAddFriendSettingResp.result, bundle);
                return;
            }
            return;
        }
        if (getUserAddFriendSettingResp != null) {
            i3 = getUserAddFriendSettingResp.result;
        } else {
            i3 = -10000;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetUserAddFriendSettingReceiver", 2, "handleAddFriendSetting " + i3);
        }
        d().notifyUI(12, false, bundle);
        if (z16 && resultReceiver != null) {
            resultReceiver.send(i3, bundle);
        }
    }
}
