package com.tencent.mobileqq.app.friendlist.receiver;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1$ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1$RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1$SetFriendIdRsp;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i extends com.tencent.mobileqq.app.friendlist.receiver.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f195650a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f195651b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f195652c;

        a(long j3, int i3, String str) {
            this.f195650a = j3;
            this.f195651b = i3;
            this.f195652c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, Long.valueOf(j3), Integer.valueOf(i3), str);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            String currentAccountUin = i.this.f195646a.getCurrentAccountUin();
            String qqStr = HardCodeUtil.qqStr(R.string.ms6);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
            d16.init(currentAccountUin, String.valueOf(this.f195650a), currentAccountUin, qqStr, K0, 0, 0, K0);
            d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
            boolean z17 = true;
            d16.isread = true;
            i.this.f195646a.getMessageFacade().c(d16, currentAccountUin);
            i iVar = i.this;
            if (this.f195651b == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Object[] objArr = new Object[5];
            objArr[0] = Long.valueOf(this.f195650a);
            objArr[1] = Boolean.TRUE;
            if (this.f195651b != 0) {
                z17 = false;
            }
            objArr[2] = Boolean.valueOf(z17);
            objArr[3] = Boolean.FALSE;
            objArr[4] = this.f195652c;
            iVar.b(54, z16, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f195654a;

        b(long j3) {
            this.f195654a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, Long.valueOf(j3));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            String currentAccountUin = i.this.f195646a.getCurrentAccountUin();
            String qqStr = HardCodeUtil.qqStr(R.string.ms9);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
            d16.init(currentAccountUin, String.valueOf(this.f195654a), currentAccountUin, qqStr, K0, 0, 0, K0);
            d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
            d16.isread = true;
            i.this.f195646a.getMessageFacade().c(d16, currentAccountUin);
        }
    }

    public i(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3 = toServiceMsg.extraData.getLong("friendUin");
        boolean z16 = toServiceMsg.extraData.getBoolean("isSet");
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + j3 + " isSet:" + z16);
        }
        Boolean bool = Boolean.FALSE;
        b(54, false, new Object[]{Long.valueOf(j3), Boolean.valueOf(z16), bool, bool, ""});
    }

    private void f(ToServiceMsg toServiceMsg, Oidb_0x5d1$RspBody oidb_0x5d1$RspBody) {
        String str;
        String stringUtf8;
        boolean z16;
        boolean z17;
        boolean z18;
        int i3 = oidb_0x5d1$RspBody.uint32_cmd.get();
        long j3 = toServiceMsg.extraData.getLong("friendUin");
        if (i3 == 1 && oidb_0x5d1$RspBody.msg_set_friend_id.has()) {
            Oidb_0x5d1$SetFriendIdRsp oidb_0x5d1$SetFriendIdRsp = oidb_0x5d1$RspBody.msg_set_friend_id.get();
            long j16 = oidb_0x5d1$SetFriendIdRsp.uint64_seq.get();
            int i16 = oidb_0x5d1$SetFriendIdRsp.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + j3 + " cmd:" + i3 + "result : " + i16 + " newSeq:" + j16);
            }
            if (i16 == 0) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, String.valueOf(j3));
                dVar.M();
                dVar.r0(true);
                iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "FriendListHandler.BaseHandlerReceiver", new a(j3, i16, ""));
                return;
            }
            String stringUtf82 = oidb_0x5d1$SetFriendIdRsp.bytes_error_msg.get().toStringUtf8();
            if (i16 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            Object[] objArr = new Object[5];
            objArr[0] = Long.valueOf(j3);
            objArr[1] = Boolean.TRUE;
            if (i16 == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            objArr[2] = Boolean.valueOf(z18);
            objArr[3] = Boolean.FALSE;
            objArr[4] = stringUtf82;
            b(54, z17, objArr);
            return;
        }
        if (i3 == 2 && oidb_0x5d1$RspBody.msg_clear_friend_id.has()) {
            Oidb_0x5d1$ClearFriendIdRsp oidb_0x5d1$ClearFriendIdRsp = oidb_0x5d1$RspBody.msg_clear_friend_id.get();
            long j17 = oidb_0x5d1$ClearFriendIdRsp.uint64_seq.get();
            int i17 = oidb_0x5d1$ClearFriendIdRsp.uint32_result.get();
            if (QLog.isColorLevel()) {
                str = "";
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + j3 + " cmd:" + i3 + "result : " + i17 + " newSeq:" + j17);
            } else {
                str = "";
            }
            if (i17 == 0) {
                String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(j3));
                IFriendsInfoService iFriendsInfoService2 = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin2, String.valueOf(j3));
                dVar2.M();
                dVar2.r0(false);
                iFriendsInfoService2.accurateUpdateNTFriendSimpleInfo(dVar2, "FriendListHandler.BaseHandlerReceiver", new b(j3));
                stringUtf8 = str;
            } else {
                stringUtf8 = oidb_0x5d1$ClearFriendIdRsp.bytes_error_msg.get().toStringUtf8();
            }
            if (i17 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Object[] objArr2 = new Object[5];
            objArr2[0] = Long.valueOf(j3);
            Boolean bool = Boolean.FALSE;
            boolean z19 = true;
            objArr2[1] = bool;
            if (i17 != 0) {
                z19 = false;
            }
            objArr2[2] = Boolean.valueOf(z19);
            objArr2[3] = bool;
            objArr2[4] = stringUtf8;
            b(54, z16, objArr2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i3);
        }
    }

    private void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Oidb_0x5d1$RspBody oidb_0x5d1$RspBody = new Oidb_0x5d1$RspBody();
        if (fromServiceMsg.getResultCode() != 1002 && fromServiceMsg.getResultCode() != 1013 && fromServiceMsg.getResultCode() == 1000) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has()) {
                    int i3 = mergeFrom.uint32_result.get();
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.TROOP_GET_NEWS, 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + i3);
                    }
                }
                if (mergeFrom != null && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    try {
                        oidb_0x5d1$RspBody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        oidb_0x5d1$RspBody = null;
                    }
                }
                if (oidb_0x5d1$RspBody == null) {
                    return;
                }
                int i16 = oidb_0x5d1$RspBody.uint32_id.get();
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : setId:" + i16 + "hex:");
                }
                if (i16 == 4051) {
                    f(toServiceMsg, oidb_0x5d1$RspBody);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TROOP_GET_NEWS, 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + e17.toString());
                    return;
                }
                return;
            }
        }
        h(toServiceMsg, fromServiceMsg);
    }

    private void h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.extraData.getInt("setId") == 4051) {
            e(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return "OidbSvc.0x5d1_0".equals(str);
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x5d1_0".equals(fromServiceMsg.getServiceCmd())) {
            g(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
