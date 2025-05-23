package com.tencent.mobileqq.app.friendlist.receiver;

import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.model.x;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x972.oidb_0x972$RspBody;
import unite.DynamicSearch$ResultItemGroup;

/* compiled from: P */
/* loaded from: classes11.dex */
public class p extends a {
    static IPatchRedirector $redirector_;

    public p(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        if (fromServiceMsg.isSuccess() && obj != null && (obj instanceof RespCondSearch)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RespHead respHead = (RespHead) this.f195647b.decodePacket(fromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
            if (respHead != null) {
                i3 = respHead.iResult;
            } else {
                i3 = 0;
                z16 = false;
            }
        } else {
            i3 = 0;
        }
        b(70, z16, new Object[]{Long.valueOf(toServiceMsg.extraData.getLong("search_seq")), obj, Integer.valueOf(i3), Integer.valueOf(toServiceMsg.extraData.getInt("param_search_from"))});
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_0x972$RspBody oidb_0x972_rspbody = new oidb_0x972$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x972_rspbody);
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleCondSearchFriendNewProto resultCode = " + parseOIDBPkg);
        }
        if (fromServiceMsg.isSuccess() && parseOIDBPkg == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        b(70, z16, new Object[]{Long.valueOf(toServiceMsg.extraData.getLong("search_seq")), oidb_0x972_rspbody, Integer.valueOf(parseOIDBPkg), Integer.valueOf(toServiceMsg.extraData.getInt("param_search_from"))});
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        boolean z18;
        String str;
        int i17;
        List<x> list;
        char c16;
        int i18;
        String str2;
        int i19 = toServiceMsg.extraData.getInt("search_version");
        int[] intArray = toServiceMsg.extraData.getIntArray("search_list");
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i19 == 2) {
            z16 &= obj instanceof RespSearch;
            i3 = 83;
        } else if (i19 == 3) {
            z16 &= obj instanceof ArrayList;
            i3 = 84;
        } else {
            i3 = -1;
        }
        boolean z19 = z16;
        int i26 = i3;
        boolean z26 = z19;
        if (z26) {
            RespHead respHead = (RespHead) this.f195647b.decodePacket(fromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
            if (respHead != null) {
                i18 = respHead.iResult;
                str2 = respHead.strErrorMsg;
            } else {
                z26 = false;
                i18 = 0;
                str2 = null;
            }
            z18 = toServiceMsg.extraData.getBoolean("search_decode");
            i16 = i18;
            str = str2;
            z17 = z26;
        } else {
            z17 = z26;
            i16 = 0;
            z18 = false;
            str = null;
        }
        RespSearch respSearch = (RespSearch) this.f195647b.decodePacket(fromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
        if (respSearch != null) {
            i17 = respSearch.result;
            if (i17 == 1) {
                if (intArray == com.tencent.mobileqq.activity.contact.addcontact.g.f181137j) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 1, "handleSearchFriend search troop and hit TwiLight");
                } else {
                    DynamicSearch$ResultItemGroup dynamicSearch$ResultItemGroup = new DynamicSearch$ResultItemGroup();
                    try {
                        dynamicSearch$ResultItemGroup.mergeFrom(respSearch.weiguang);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(dynamicSearch$ResultItemGroup);
                        list = new ip2.e().a(toServiceMsg.extraData.getString("param_keyword"), arrayList, Integer.valueOf(toServiceMsg.extraData.getInt(IProfileCardConst.KEY_FROM_TYPE)));
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (QLog.isColorLevel()) {
                        c16 = 2;
                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handleSearchFriend  searchType = " + i26 + " isSuccess = " + z17 + " subId = " + i17 + " data =" + obj);
                    } else {
                        c16 = 2;
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(i26);
                    objArr[1] = obj;
                    objArr[c16] = Integer.valueOf(i16);
                    objArr[3] = str;
                    objArr[4] = Boolean.valueOf(z18);
                    objArr[5] = Long.valueOf(toServiceMsg.extraData.getLong(ServiceConst.PARA_SESSION_ID));
                    objArr[6] = Integer.valueOf(i17);
                    objArr[7] = list;
                    b(48, z17, objArr);
                }
            }
            list = null;
            if (QLog.isColorLevel()) {
            }
            Object[] objArr2 = new Object[8];
            objArr2[0] = Integer.valueOf(i26);
            objArr2[1] = obj;
            objArr2[c16] = Integer.valueOf(i16);
            objArr2[3] = str;
            objArr2[4] = Boolean.valueOf(z18);
            objArr2[5] = Long.valueOf(toServiceMsg.extraData.getLong(ServiceConst.PARA_SESSION_ID));
            objArr2[6] = Integer.valueOf(i17);
            objArr2[7] = list;
            b(48, z17, objArr2);
        }
        i17 = 0;
        list = null;
        if (QLog.isColorLevel()) {
        }
        Object[] objArr22 = new Object[8];
        objArr22[0] = Integer.valueOf(i26);
        objArr22[1] = obj;
        objArr22[c16] = Integer.valueOf(i16);
        objArr22[3] = str;
        objArr22[4] = Boolean.valueOf(z18);
        objArr22[5] = Long.valueOf(toServiceMsg.extraData.getLong(ServiceConst.PARA_SESSION_ID));
        objArr22[6] = Integer.valueOf(i17);
        objArr22[7] = list;
        b(48, z17, objArr22);
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"SummaryCard.ReqSearch".equals(str) && !"SummaryCard.ReqCondSearch".equals(str) && !"OidbSvc.0x972_5".equals(str)) {
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
        if ("SummaryCard.ReqSearch".equals(serviceCmd)) {
            g(toServiceMsg, fromServiceMsg, obj);
        } else if ("SummaryCard.ReqCondSearch".equals(serviceCmd)) {
            e(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x972_5".equals(serviceCmd)) {
            f(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
