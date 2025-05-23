package com.tencent.mobileqq.app.friendlist.processor;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendResp;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class AddFriendProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public AddFriendProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onAddFriendSuccess(AddFriendResp addFriendResp, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) addFriendResp, (Object) toServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendProcessor", 2, "onAddFriendSuccess called");
        }
        Bundle bundle = toServiceMsg.extraData;
        boolean z16 = false;
        boolean z17 = bundle.getBoolean("auto_send", false);
        int i3 = bundle.getInt("source_id");
        String string = bundle.getString("uin");
        int i16 = bundle.getInt("friend_setting");
        boolean z18 = bundle.getBoolean("contact_bothway");
        String string2 = bundle.getString("remark");
        if (z17 && ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(addFriendResp.adduinsetting, i3, z18)) {
            z16 = true;
        }
        if (z17 && z16 && addFriendResp.adduin != 0) {
            ((FriendListHandler) ((AppInterface) this.mApp).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(String.valueOf(addFriendResp.adduin), addFriendResp.myfriendgroupid, i3, bundle.getString("src_name"), true, false, -1L);
        } else if (friendlist.a.a(i3)) {
            ((IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "")).makePhoneContactAddInfo(string, i16, string2);
        }
        try {
            ((FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).y().f(string);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
