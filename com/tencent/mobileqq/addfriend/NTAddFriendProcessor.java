package com.tencent.mobileqq.addfriend;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyRsp;
import com.tencent.qqnt.remote.d;
import friendlist.a;
import mqq.app.AppRuntime;

/* loaded from: classes33.dex */
public class NTAddFriendProcessor extends BaseFriendProcessor {
    public NTAddFriendProcessor(AppRuntime appRuntime) {
        super(appRuntime);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onAddFriendSuccess(AddBuddyRsp addBuddyRsp, d dVar) {
        if (QLog.isColorLevel()) {
            QLog.i("NTAddFriendProcessor", 2, "onAddFriendSuccess called");
        }
        if (addBuddyRsp != null && dVar != null) {
            Bundle a16 = dVar.a();
            boolean z16 = a16.getBoolean("auto_send", false);
            int i3 = a16.getInt("source_id");
            String string = a16.getString("uin");
            int i16 = a16.getInt("friend_setting");
            boolean z17 = a16.getBoolean("contact_bothway");
            String string2 = a16.getString("remark");
            boolean z18 = z16 && ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).couldAddFriendSuccessDirectly(addBuddyRsp.getAddFriendSetting(), i3, z17);
            long longValue = (addBuddyRsp.getTargetInfo() == null || addBuddyRsp.getTargetInfo().getUin() == null) ? 0L : addBuddyRsp.getTargetInfo().getUin().longValue();
            if (z16 && z18 && longValue != 0) {
                ((FriendListHandler) ((AppInterface) this.mApp).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(String.valueOf(longValue), addBuddyRsp.getGroupId().intValue(), i3, a16.getString("src_name"), true, false, -1L);
            } else if (a.a(i3)) {
                ((IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "")).makePhoneContactAddInfo(string, i16, string2);
            }
            try {
                ((FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).y().f(string);
                return;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        QLog.i("NTAddFriendProcessor", 1, "null == resp || null == req");
    }
}
