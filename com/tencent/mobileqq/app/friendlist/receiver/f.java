package com.tencent.mobileqq.app.friendlist.receiver;

import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.SetRichSigRes;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import friendlist.GetOnlineInfoResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0$BindContactsFriendInfo;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f extends com.tencent.mobileqq.app.friendlist.receiver.a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private short f195648c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                f.this.b(28, true, null);
            }
        }
    }

    public f(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        } else {
            this.f195648c = (short) 20002;
        }
    }

    private void e(FromServiceMsg fromServiceMsg, CheckUpdateResp checkUpdateResp) {
        if (fromServiceMsg.getResultCode() == 1000) {
            QLog.i(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, "getCheckUpdate ok resultcode = " + fromServiceMsg.getResultCode());
        }
        if (fromServiceMsg.getResultCode() == 1002 || fromServiceMsg.getResultCode() == 1013) {
            QLog.i(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, "getCheckUpdate timeout resultcode = " + fromServiceMsg.getResultCode());
        }
        this.f195647b.handleCheckUpdate(checkUpdateResp);
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        StringBuilder sb5;
        boolean z17;
        int i3;
        PBBytesField pBBytesField;
        boolean isColorLevel;
        boolean isSuccess = fromServiceMsg.isSuccess();
        int i16 = 1;
        if (isSuccess && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch success=" + z16);
        }
        try {
            if (z16) {
                try {
                    oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                    if (mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (mergeFrom.uint32_result.has()) {
                        i3 = mergeFrom.uint32_result.get();
                    } else {
                        i3 = -1;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch result=" + z17);
                    }
                    if (z17 && (pBBytesField = mergeFrom.bytes_bodybuffer) != null && pBBytesField.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        ByteBuffer wrap = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        byte b16 = wrap.get();
                        int i17 = wrap.getInt();
                        short s16 = wrap.getShort();
                        HashMap hashMap = new HashMap(s16);
                        if (QLog.isColorLevel()) {
                            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch cNickCut=" + ((int) b16) + " dwNextUin=" + i17 + " wSimpleInfoNum=" + ((int) s16));
                        }
                        if (i17 == -1) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (short s17 = 0; s17 < s16; s17 = (short) (s17 + 1)) {
                                String valueOf = String.valueOf(Utils.P(wrap.getInt()));
                                short s18 = wrap.getShort();
                                if (QLog.isColorLevel()) {
                                    stringBuffer.append(" wFieldNum=");
                                    stringBuffer.append((int) s18);
                                }
                                if (s18 == 1) {
                                    short s19 = wrap.getShort();
                                    if (QLog.isColorLevel()) {
                                        stringBuffer.append(" wFieldID=");
                                        stringBuffer.append((int) s19);
                                    }
                                    if (s19 == this.f195648c) {
                                        byte[] bArr = new byte[wrap.getShort()];
                                        wrap.get(bArr);
                                        String str = new String(bArr);
                                        if (QLog.isColorLevel()) {
                                            stringBuffer.append(" uin=");
                                            stringBuffer.append(valueOf.substring(0, 4));
                                            stringBuffer.append(" nick=");
                                            stringBuffer.append(aw.a(str));
                                        }
                                        hashMap.put(valueOf, str);
                                    }
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, stringBuffer.toString());
                            }
                        } else {
                            z17 = false;
                        }
                        b(72, z17, hashMap);
                        if (isColorLevel) {
                            return;
                        } else {
                            return;
                        }
                    }
                    i16 = i3;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch e", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.w("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch ex", e17);
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                    }
                }
            } else {
                i16 = 0;
            }
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder();
                sb5.append("handleGetFriendNickBatch over time=");
                sb5.append(System.currentTimeMillis());
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, sb5.toString());
            }
            b(72, false, Integer.valueOf(i16));
        } finally {
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
            }
        }
    }

    private void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        Object valueOf;
        cmd0xcf0$RspBody cmd0xcf0_rspbody = new cmd0xcf0$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xcf0_rspbody);
        ArrayList arrayList = null;
        if (parseOIDBPkg == 0) {
            i3 = cmd0xcf0_rspbody.uint32_total_bind_contacts_frd_num.get();
            List<cmd0xcf0$BindContactsFriendInfo> list = cmd0xcf0_rspbody.rpt_msg_bind_contacts_frds.get();
            if (list != null && list.size() > 0) {
                arrayList = new ArrayList(list.size());
                for (cmd0xcf0$BindContactsFriendInfo cmd0xcf0_bindcontactsfriendinfo : list) {
                    if (cmd0xcf0_bindcontactsfriendinfo != null && cmd0xcf0_bindcontactsfriendinfo.uint64_uin.get() != 0) {
                        arrayList.add(String.valueOf(cmd0xcf0_bindcontactsfriendinfo.uint64_uin.get()));
                    }
                }
            }
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f195646a.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null) {
                iPhoneContactService.onGetFriendsHasBindPhone(i3, arrayList);
            }
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(parseOIDBPkg);
            objArr[1] = Integer.valueOf(i3);
            if (arrayList == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(arrayList.size());
            }
            objArr[2] = valueOf;
            QLog.i("FriendListHandler.BaseHandlerReceiver", 2, String.format("handleGetFriendsHasBindPhone [%s, %s, %s]", objArr));
        }
        if (parseOIDBPkg == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        b(114, z16, new Object[]{Integer.valueOf(i3), arrayList});
    }

    private void h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String string;
        long j3 = toServiceMsg.extraData.getLong("dwReqType", 1L);
        if (j3 == 0) {
            string = String.valueOf(toServiceMsg.extraData.getLong("dwUin"));
        } else {
            string = toServiceMsg.extraData.getString("strMobile");
        }
        if (obj == null) {
            b(64, false, new Object[]{Long.valueOf(j3), string});
            return;
        }
        if (obj instanceof GetOnlineInfoResp) {
            GetOnlineInfoResp getOnlineInfoResp = (GetOnlineInfoResp) obj;
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleOnlineInfo, uin = " + com.tencent.util.k.d(string) + ", result = " + getOnlineInfoResp.result + ", itermType = " + getOnlineInfoResp.iTermType + ", netType = " + getOnlineInfoResp.eNetworkType + ", abi = " + getOnlineInfoResp.uAbiFlag + ", status = " + getOnlineInfoResp.dwStatus + ", strTermDesc = " + com.tencent.util.k.d(getOnlineInfoResp.strTermDesc));
            }
            if (j3 == 0 && getOnlineInfoResp.result == 0) {
                ((FriendsManager) this.f195646a.getManager(QQManagerFactory.FRIENDS_MANAGER)).K0(string, getOnlineInfoResp);
            } else if (j3 == 1 && getOnlineInfoResp.result == 0) {
                ((IPhoneContactService) this.f195646a.getRuntimeService(IPhoneContactService.class, "")).updateOnlineStatus(string, getOnlineInfoResp);
            }
            long j16 = getOnlineInfoResp.dwInterval * 1000;
            getOnlineInfoResp.dwInterval = j16;
            if (j16 < 15000) {
                getOnlineInfoResp.dwInterval = 15000L;
            }
            this.f195647b.intervalGetOnlineInfo = getOnlineInfoResp.dwInterval;
            b(64, true, new Object[]{Long.valueOf(j3), string, getOnlineInfoResp});
        }
    }

    private void i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String string = toServiceMsg.extraData.getString("uin");
        String string2 = toServiceMsg.extraData.getString(ProfileContants.CMD_PARAM_COM_VALUE);
        boolean z16 = toServiceMsg.extraData.getBoolean(ProfileContants.CMD_PARAM_NOTIFY_PLUGIN);
        Object[] objArr = new Object[3];
        boolean z17 = false;
        objArr[0] = string;
        objArr[1] = string2;
        if (1000 == fromServiceMsg.getResultCode()) {
            ChangeFriendNameRes changeFriendNameRes = (ChangeFriendNameRes) obj;
            if (changeFriendNameRes != null && changeFriendNameRes.cResult == 0) {
                this.f195647b.setFriendComment(string, string2, true);
                objArr[2] = Byte.valueOf(changeFriendNameRes.cResult);
                b(27, true, objArr);
                z17 = true;
            } else {
                if (changeFriendNameRes != null) {
                    objArr[2] = Byte.valueOf(changeFriendNameRes.cResult);
                } else {
                    objArr[2] = (byte) -1;
                }
                b(27, false, objArr);
            }
        } else {
            objArr[2] = (byte) -1;
            b(27, false, objArr);
        }
        if (z16) {
            Intent intent = new Intent(ProfileContants.ACTION_SET_REMARK_FOR_PLUGIN);
            intent.putExtra("uin", string);
            intent.putExtra("remark", string2);
            intent.putExtra(ProfileContants.KEY_IS_SUC, z17);
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    private void j(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.isSuccess() && obj != null) {
            SetRichSigRes setRichSigRes = (SetRichSigRes) obj;
            byte b16 = setRichSigRes.cResult;
            if (b16 == 0) {
                if (((FriendsManager) this.f195646a.getManager(QQManagerFactory.FRIENDS_MANAGER)) != null) {
                    byte[] byteArray = toServiceMsg.extraData.getByteArray(ProfileContants.CMD_PARAM_SIG_VALUE);
                    if (setRichSigRes.dwTime == 0) {
                        setRichSigRes.dwTime = 1L;
                    }
                    String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f195646a.getCurrentAccountUin());
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, this.f195646a.getCurrentAccountUin());
                    dVar.M();
                    com.tencent.mobileqq.richstatus.c.m(dVar, byteArray, setRichSigRes.dwTime);
                    iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "FriendListHandler.BaseHandlerReceiver", new a());
                    return;
                }
                b(28, true, null);
                return;
            }
            b(28, false, Integer.valueOf(b16));
            return;
        }
        b(28, false, null);
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!ProfileContants.CMD_SETCOMMENT.equals(str) && !ProfileContants.CMD_SETSIGNATURE.equals(str) && !"OidbSvc.0x77c".equals(str) && !ProfileContants.CMD_CHECK_UPDATE_REQ.equals(str) && !"OidbSvc.0xcf0_0".equals(str) && !"OidbSvc.0x49d_107".equals(str) && !"friendlist.GetOnlineInfoReq".equals(str)) {
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
        if (ProfileContants.CMD_SETCOMMENT.equals(serviceCmd)) {
            i(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_SETSIGNATURE.equals(serviceCmd)) {
            j(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!"OidbSvc.0x77c".equals(serviceCmd)) {
            if (ProfileContants.CMD_CHECK_UPDATE_REQ.equals(serviceCmd)) {
                e(fromServiceMsg, (CheckUpdateResp) obj);
                return;
            }
            if ("OidbSvc.0xcf0_0".equals(serviceCmd)) {
                g(toServiceMsg, fromServiceMsg, obj);
            } else if ("OidbSvc.0x49d_107".equals(serviceCmd)) {
                f(toServiceMsg, fromServiceMsg, obj);
            } else if ("friendlist.GetOnlineInfoReq".equals(serviceCmd)) {
                h(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
