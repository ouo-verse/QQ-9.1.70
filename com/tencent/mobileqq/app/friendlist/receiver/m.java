package com.tencent.mobileqq.app.friendlist.receiver;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.utils.z;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.nt.api.IRelationMsgService;
import friendlist.DelFriendResp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m extends com.tencent.mobileqq.app.friendlist.receiver.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements hx3.a<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DelFriendResp f195657a;

        a(DelFriendResp delFriendResp) {
            this.f195657a = delFriendResp;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this, (Object) delFriendResp);
            }
        }

        @Override // hx3.a
        public void a(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            QQAppInterface qQAppInterface = m.this.f195646a;
            if (qQAppInterface != null) {
                IceBreakingUtil.z(qQAppInterface, this.f195657a.deluin + "");
                com.tencent.mobileqq.tofumsg.m.c(m.this.f195646a, this.f195657a.deluin + "");
                m.this.l(this.f195657a);
                com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) m.this.f195646a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                if (bVar != null) {
                    bVar.c().put("" + this.f195657a.deluin, 1);
                }
                m.this.b(15, true, Long.valueOf(this.f195657a.deluin));
            }
        }
    }

    public m(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void i(QQAppInterface qQAppInterface, String str) {
        w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("FriendListHandler.BaseHandlerReceiver", 1, "cancelTopContactOnDelFriend fail, service is null");
        } else {
            msgService.setContactLocalTop(new Contact(1, ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), ""), false, new IOperateCallback() { // from class: com.tencent.mobileqq.app.friendlist.receiver.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str2) {
                    m.m(i3, str2);
                }
            });
        }
    }

    private void j(ToServiceMsg toServiceMsg, boolean z16) {
        int i3 = toServiceMsg.extraData.getInt("bType");
        String valueOf = String.valueOf(toServiceMsg.extraData.getLong("lToMID"));
        byte b16 = toServiceMsg.extraData.getByte("bGroupId");
        if (i3 == 1) {
            i3 = 2;
        }
        if (i3 == 0) {
            toServiceMsg.extraData.getString("strNickName");
            this.f195647b.addFriendToFriendList(valueOf, b16, BuddySource.DEFAULT, null, false, false, -1L);
        }
        z.f(this.f195646a.getApp().getApplicationContext(), valueOf + AppConstants.Preferences.ADD_REQUEST_ANSWER_ADDED + toServiceMsg.extraData.getLong("infotime", 0L) + toServiceMsg.extraData.getLong("dbid", 0L), i3);
        b(10, true, new Object[]{valueOf, Integer.valueOf(i3)});
    }

    private void k(FromServiceMsg fromServiceMsg, DelFriendResp delFriendResp) {
        if (delFriendResp.errorCode != 0) {
            b(15, false, null);
            return;
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f195646a.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            iPhoneContactService.onFriendListChanged();
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).deleteNTFriendSimpleInfo(String.valueOf(delFriendResp.deluin), "FriendListHandler.BaseHandlerReceiver", new a(delFriendResp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final DelFriendResp delFriendResp) {
        i(this.f195646a, String.valueOf(delFriendResp.deluin));
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.friendlist.receiver.j
            @Override // java.lang.Runnable
            public final void run() {
                m.o(DelFriendResp.this);
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(int i3, String str) {
        QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "cancelTopContactOnDelFriend, result=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleDelFriend deleteRecentContacts! result " + i3 + " errMsg " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(DelFriendResp delFriendResp) {
        ((IRelationMsgService) QRoute.api(IRelationMsgService.class)).deleteRecentContacts(new com.tencent.relation.common.nt.data.a(String.valueOf(delFriendResp.deluin), 0, ""), new IOperateCallback() { // from class: com.tencent.mobileqq.app.friendlist.receiver.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                m.n(i3, str);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"friendlist.delFriend".equals(str) && !"BumpSvc.ReqComfirmContactFriend".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("friendlist.delFriend".equals(serviceCmd)) {
            if (obj != null) {
                k(fromServiceMsg, (DelFriendResp) obj);
                return;
            } else {
                b(15, false, null);
                return;
            }
        }
        if ("BumpSvc.ReqComfirmContactFriend".equals(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                j(toServiceMsg, true);
            } else {
                b(10, false, null);
            }
        }
    }
}
