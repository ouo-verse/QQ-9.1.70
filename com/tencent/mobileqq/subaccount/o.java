package com.tencent.mobileqq.subaccount;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.CommonMMKVUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe34.cmd0xe34$BindUinInfo;
import tencent.im.oidb.cmd0xe34.cmd0xe34$GroupMsgUnreadNumInfo;
import tencent.im.oidb.cmd0xe34.cmd0xe34$LoginSig;
import tencent.im.oidb.cmd0xe34.cmd0xe34$ReqBody;
import tencent.im.oidb.cmd0xe34.cmd0xe34$RspBody;
import tencent.im.oidb.cmd0xe34.cmd0xe34$UnReadInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends MSFServlet {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(long j3, int i3, int i16) {
        int i17;
        if (i16 > 0) {
            i17 = 1;
            long j16 = i3;
            if (j16 > CommonMMKVUtils.getLong("troop_last_unread_time_" + j3, 0L, true)) {
                CommonMMKVUtils.putLong("troop_last_unread_time_" + j3, j16, true);
                if (QLog.isColorLevel()) {
                    QLog.i("SubAccountServlet", 2, "[getTroopUnreadNum] unread result:" + i17);
                }
                return i17;
            }
        }
        i17 = 0;
        if (QLog.isColorLevel()) {
        }
        return i17;
    }

    public static NewIntent fetchOneTroopNewMsg(AppInterface appInterface, String str) {
        String str2;
        if (appInterface == null) {
            QLog.d("SubAccountServlet", 2, "app is null");
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountServlet", 2, "fetchOneTroopNewMsg TIME=" + System.currentTimeMillis());
        }
        ISubAccountService iSubAccountService = (ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            str2 = iSubAccountService.getA2(str);
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            NewIntent newIntent = new NewIntent(appInterface.getApplication(), o.class);
            newIntent.putExtra("key_type", 1);
            newIntent.putExtra("key_appid", AppSetting.f());
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            ArrayList<String> arrayList2 = new ArrayList<>(1);
            arrayList2.add(str2);
            newIntent.putStringArrayListExtra("key_sub_account", arrayList);
            newIntent.putStringArrayListExtra("key_sub_acc_sig", arrayList2);
            appInterface.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountServlet", 2, "fetchOneTroopNewMsg uin:", str);
            }
            return newIntent;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubAccountServlet", 2, "fetchOneTroopNewMsg uin:", str, " no login sig");
        }
        return null;
    }

    public void b(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean z17;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        int i3;
        boolean z18;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        boolean z19 = false;
        z19 = false;
        if (isSuccess) {
            try {
                byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(a16);
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                try {
                } catch (Exception e16) {
                    e = e16;
                    z16 = false;
                }
            } catch (Exception e17) {
                e = e17;
                z16 = z19;
            }
            if (i3 == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                cmd0xe34$RspBody cmd0xe34_rspbody = new cmd0xe34$RspBody();
                cmd0xe34_rspbody.mergeFrom(byteArray);
                ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) getAppRuntime().getRuntimeService(ISubAccountControlService.class, "");
                iSubAccountControlService.setTroopDelayTime(cmd0xe34_rspbody.ReqInterval.get());
                List<cmd0xe34$UnReadInfo> list = cmd0xe34_rspbody.rpt_unread_info.get();
                if (list != null && list.size() > 0) {
                    int i16 = 0;
                    while (i16 < list.size()) {
                        cmd0xe34$UnReadInfo cmd0xe34_unreadinfo = list.get(i16);
                        long j3 = cmd0xe34_unreadinfo.uint64_uin.get();
                        int i17 = cmd0xe34_unreadinfo.retcode.get();
                        cmd0xe34$GroupMsgUnreadNumInfo cmd0xe34_groupmsgunreadnuminfo = cmd0xe34_unreadinfo.group_info.get();
                        int i18 = cmd0xe34_groupmsgunreadnuminfo.last_msg_time.get();
                        bundle.putInt("key_new_msg_time", i18);
                        if (QLog.isColorLevel()) {
                            Object[] objArr = new Object[12];
                            objArr[z19 ? 1 : 0] = "subAccount:";
                            objArr[1] = Long.valueOf(j3);
                            objArr[2] = " msg_num:";
                            objArr[3] = Integer.valueOf(cmd0xe34_groupmsgunreadnuminfo.msg_num.get());
                            objArr[4] = " group_num:";
                            c16 = 5;
                            objArr[5] = Integer.valueOf(cmd0xe34_groupmsgunreadnuminfo.group_num.get());
                            objArr[6] = " last_msg_time:";
                            objArr[7] = Integer.valueOf(i18);
                            objArr[8] = " fetchTroopMsgInterval:";
                            objArr[9] = Long.valueOf(iSubAccountControlService.getsTroopDelayTime());
                            objArr[10] = " retCode:";
                            objArr[11] = Integer.valueOf(i17);
                            QLog.d("SubAccountServlet", 2, objArr);
                        } else {
                            c16 = 5;
                        }
                        if (i17 == 0) {
                            SubAccountMessage subAccountMessage = new SubAccountMessage();
                            subAccountMessage.frienduin = String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE);
                            subAccountMessage.unreadNum = a(j3, i18, cmd0xe34_groupmsgunreadnuminfo.msg_num.get());
                            subAccountMessage.msgtype = -1000;
                            subAccountMessage.time = i18;
                            subAccountMessage.senderuin = String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE);
                            subAccountMessage.subUin = String.valueOf(j3);
                            subAccountMessage.istroop = 1;
                            subAccountMessage.sendername = "\u7fa4\u804a\u6d88\u606f";
                            subAccountMessage.f203118msg = "";
                            ISubAccountService iSubAccountService = (ISubAccountService) getAppRuntime().getRuntimeService(ISubAccountService.class, "");
                            if (iSubAccountService != null) {
                                iSubAccountService.updateTroopMsgRedDot(subAccountMessage);
                                iSubAccountService.addNewMessage(subAccountMessage);
                            }
                            com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
                            aVar.f291123c = fromServiceMsg.getUin();
                            aVar.f291124d = String.valueOf(j3);
                            aVar.f291132l = true;
                            aVar.f291133m = true;
                            try {
                                aVar.f291121a = 0;
                                if (MobileQQ.sProcessId == 1) {
                                    ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).notifyUI(8003, true, aVar);
                                }
                            } catch (Exception e18) {
                                e = e18;
                                z16 = false;
                            }
                        }
                        i16++;
                        z19 = false;
                    }
                    z18 = true;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("SubAccountServlet", 2, "unReadInfos is empty");
                    }
                    z18 = false;
                }
                z17 = z18;
                notifyObserver(intent, 1, z17, bundle, com.tencent.mobileqq.loginregister.servlet.g.class);
            }
            if (QLog.isColorLevel()) {
                Object[] objArr2 = new Object[4];
                z16 = false;
                try {
                    objArr2[0] = "result:";
                    objArr2[1] = Integer.valueOf(i3);
                    objArr2[2] = " hasBody:";
                    objArr2[3] = Boolean.valueOf(oidb_sso_oidbssopkg.bytes_bodybuffer.has());
                    QLog.d("SubAccountServlet", 2, objArr2);
                } catch (Exception e19) {
                    e = e19;
                }
            } else {
                z16 = false;
            }
            QLog.d("SubAccountServlet", 2, e.toString());
            z17 = z16;
            notifyObserver(intent, 1, z17, bundle, com.tencent.mobileqq.loginregister.servlet.g.class);
        }
        z16 = false;
        z18 = z16;
        z17 = z18;
        notifyObserver(intent, 1, z17, bundle, com.tencent.mobileqq.loginregister.servlet.g.class);
    }

    public void c(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("key_sub_account");
        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("key_sub_acc_sig");
        if (stringArrayListExtra != null && stringArrayListExtra.size() != 0 && stringArrayListExtra2 != null && stringArrayListExtra2.size() != 0) {
            if (stringArrayListExtra2.size() != stringArrayListExtra.size()) {
                QLog.e("SubAccountServlet", 2, "uin and sig size not right");
                return;
            }
            int intExtra = intent.getIntExtra("key_appid", -1);
            cmd0xe34$ReqBody cmd0xe34_reqbody = new cmd0xe34$ReqBody();
            for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                String str = stringArrayListExtra.get(i3);
                cmd0xe34$BindUinInfo cmd0xe34_binduininfo = new cmd0xe34$BindUinInfo();
                cmd0xe34_binduininfo.uint32_app_id.set(1001);
                cmd0xe34_binduininfo.uint32_instance_id.set(intExtra);
                try {
                    cmd0xe34_binduininfo.uint64_uin.set(Long.parseLong(str));
                } catch (Exception e16) {
                    QLog.e("SubAccountServlet", 2, e16.toString());
                }
                cmd0xe34$LoginSig cmd0xe34_loginsig = new cmd0xe34$LoginSig();
                cmd0xe34_loginsig.uint32_appid.set(16);
                cmd0xe34_loginsig.uint32_type.set(8);
                if (!TextUtils.isEmpty(stringArrayListExtra2.get(i3))) {
                    cmd0xe34_loginsig.bytes_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes(stringArrayListExtra2.get(i3))));
                }
                cmd0xe34_binduininfo.msg_login_sig.set(cmd0xe34_loginsig);
                cmd0xe34_reqbody.rpt_bind_uin_info.add(cmd0xe34_binduininfo);
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(3636);
            oidb_sso_oidbssopkg.uint32_service_type.set(1);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xe34_reqbody.toByteArray()));
            packet.setSSOCommand("OidbSvc.0xe34_1");
            packet.putSendData(fh.b(oidb_sso_oidbssopkg.toByteArray()));
            if (QLog.isColorLevel()) {
                QLog.d("SubAccountServlet", 2, "onSendFetchTroopNewMsg");
                return;
            }
            return;
        }
        QLog.e("SubAccountServlet", 2, "subaccountuins is empty");
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
        } else if (intent.getIntExtra("key_type", 0) == 1) {
            b(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
        } else if (intent.getIntExtra("key_type", 0) == 1) {
            c(intent, packet);
        }
    }
}
