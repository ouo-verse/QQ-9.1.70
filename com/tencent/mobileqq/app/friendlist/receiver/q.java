package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$DoubtInfo;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$GetListRspBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$RspBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q extends a {
    static IPatchRedirector $redirector_;

    public q(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, oidb_cmd0xd69$RspBody oidb_cmd0xd69_rspbody, int i3, StringBuilder sb5, INewFriendService iNewFriendService) {
        byte[] bArr;
        Object obj;
        String str;
        boolean z16;
        Object attribute = toServiceMsg.getAttribute("exactData");
        ArrayList<SysSuspiciousMsg> arrayList = null;
        if (oidb_cmd0xd69_rspbody.msg_get_list_body.has()) {
            if (oidb_cmd0xd69_rspbody.msg_get_list_body.bytes_cookies.has()) {
                bArr = oidb_cmd0xd69_rspbody.msg_get_list_body.bytes_cookies.get().toByteArray();
            } else {
                bArr = null;
            }
            oidb_cmd0xd69$GetListRspBody oidb_cmd0xd69_getlistrspbody = oidb_cmd0xd69_rspbody.msg_get_list_body.get();
            if (oidb_cmd0xd69_getlistrspbody.rpt_msg_list.has()) {
                List<oidb_cmd0xd69$DoubtInfo> list = oidb_cmd0xd69_getlistrspbody.rpt_msg_list.get();
                arrayList = new ArrayList<>(list.size());
                Iterator<oidb_cmd0xd69$DoubtInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(SysSuspiciousMsg.covertFrom(it.next()));
                }
                if (bArr == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                iNewFriendService.updateSuspiciousMsgListFromServer(arrayList, z16);
            }
        } else {
            bArr = null;
        }
        sb5.append("CMD_GET_LIST unread=");
        sb5.append("|");
        if (arrayList != null) {
            obj = Integer.valueOf(arrayList.size());
        } else {
            obj = " no list";
        }
        sb5.append(obj);
        sb5.append("|");
        if (bArr != null) {
            str = " has cookie";
        } else {
            str = " no cookie";
        }
        sb5.append(str);
        b(116, true, new Object[]{Integer.valueOf(i3), arrayList, bArr, attribute});
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"OidbSvc.0xd69".equals(str) && !"OidbSvc.0xd72".equals(str)) {
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
        if ("OidbSvc.0xd69".equals(serviceCmd)) {
            g(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xd72".equals(serviceCmd)) {
            f(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            long longValue = ((Long) toServiceMsg.getAttribute("toUin", 0L)).longValue();
            if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleAgreeSuspiciousMsg " + longValue);
            }
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_cmd0xd72$RspBody>() { // from class: tencent.im.oidb.cmd0xd72.oidb_cmd0xd72$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xd72$RspBody.class);
            });
            if (parseOIDBPkg == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleAgreeSuspiciousMsg suc " + longValue);
                }
                ((INewFriendService) this.f195646a.getRuntimeService(INewFriendService.class)).deleteSysSuspiciousMsg(longValue);
                b(120, true, new Object[]{Integer.valueOf(parseOIDBPkg), Long.valueOf(longValue)});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleAgreeSuspiciousMsg failed result:" + parseOIDBPkg);
            }
            b(120, false, new Object[]{Integer.valueOf(parseOIDBPkg), Long.valueOf(longValue)});
        }
    }

    public void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        int intValue = ((Integer) toServiceMsg.getAttribute("cmd", 0)).intValue();
        oidb_cmd0xd69$RspBody oidb_cmd0xd69_rspbody = new oidb_cmd0xd69$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0xd69_rspbody);
        int i16 = oidb_cmd0xd69_rspbody.cmd_type.get();
        StringBuilder sb5 = new StringBuilder(1024);
        if (parseOIDBPkg == 0) {
            INewFriendService iNewFriendService = (INewFriendService) this.f195646a.getRuntimeService(INewFriendService.class);
            if (i16 == 2) {
                if (oidb_cmd0xd69_rspbody.msg_get_unread_num_body.has()) {
                    i3 = oidb_cmd0xd69_rspbody.msg_get_unread_num_body.get().doubt_unread_num.get();
                } else {
                    i3 = 0;
                }
                sb5.append("CMD_GET_UNREAD unread=");
                sb5.append(i3);
                iNewFriendService.setSysSuspiciousUnreadNum(i3);
                b(115, true, new Object[]{Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3)});
            } else if (i16 == 1) {
                e(toServiceMsg, oidb_cmd0xd69_rspbody, parseOIDBPkg, sb5, iNewFriendService);
            } else if (i16 == 3) {
                long longValue = ((Long) toServiceMsg.getAttribute("uin", 0L)).longValue();
                sb5.append("CMD_DELETE uin=");
                sb5.append(longValue);
                iNewFriendService.deleteSysSuspiciousMsg(longValue);
                b(117, true, new Object[]{Integer.valueOf(parseOIDBPkg), Long.valueOf(longValue)});
            } else if (i16 == 4) {
                if (QLog.isColorLevel()) {
                    QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousClear ");
                }
                sb5.append("CMD_CLEAR unread=");
                iNewFriendService.clearAllSysSuspiciousMsg();
                b(118, true, new Object[]{Integer.valueOf(parseOIDBPkg)});
            } else if (i16 == 5) {
                sb5.append("CMD_REPORT");
                b(119, true, new Object[]{Integer.valueOf(parseOIDBPkg)});
            }
        } else if (i16 == 2) {
            sb5.append("CMD_GET_UNREAD failed");
            b(115, false, new Object[]{Integer.valueOf(parseOIDBPkg), 0});
        } else if (i16 == 1) {
            sb5.append("CMD_GET_LIST failed");
            b(116, false, new Object[]{Integer.valueOf(parseOIDBPkg), null, null, toServiceMsg.getAttribute("exactData")});
        } else if (i16 == 3) {
            long longValue2 = ((Long) toServiceMsg.getAttribute("uin", 0L)).longValue();
            sb5.append("CMD_DELETE failed ");
            sb5.append(longValue2);
            b(117, false, new Object[]{Integer.valueOf(parseOIDBPkg), Long.valueOf(longValue2)});
        } else if (i16 == 4) {
            sb5.append("CMD_CLEAR failed");
            b(118, false, new Object[]{Integer.valueOf(parseOIDBPkg)});
        } else if (i16 == 5) {
            sb5.append("CMD_REPORT failed");
            b(119, false, new Object[]{Integer.valueOf(parseOIDBPkg)});
        }
        if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler.BaseHandlerReceiver", 2, "handleGetSuspiciousMsg cmd:" + i16 + " localCmd:" + intValue + " result:" + parseOIDBPkg + " |" + sb5.toString());
        }
    }
}
