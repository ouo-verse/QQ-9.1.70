package com.tencent.mobileqq.phonecontact.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.data.PhoneInfo;
import com.tencent.mobileqq.phonecontact.data.RecommendedListResp;
import com.tencent.mobileqq.phonecontact.observer.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.download.HttpOp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xbf2$PhoneAddrBook;
import tencent.im.oidb.cmd0xbf2$ReqBody;
import tencent.im.oidb.cmd0xbf2$RspBody;
import tencent.im.oidb.oidb_0xbe8$PopupResult;
import tencent.im.oidb.oidb_0xbe8$ReqBody;
import tencent.im.oidb.oidb_0xbe8$RspBody;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ContactBindHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public ContactBindHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        RecommendedListResp recommendedListResp = new RecommendedListResp();
        try {
            cmd0xbf2$RspBody cmd0xbf2_rspbody = new cmd0xbf2$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xbf2_rspbody);
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("handleGetRecommendedList result=%s", Integer.valueOf(parseOIDBPkg)));
            }
            recommendedListResp.f258452d = parseOIDBPkg;
            if (parseOIDBPkg == 0) {
                recommendedListResp.f258453e = cmd0xbf2_rspbody.uint32_end.get();
                recommendedListResp.f258454f = cmd0xbf2_rspbody.uint32_next_index.get();
                List<cmd0xbf2$PhoneAddrBook> list = cmd0xbf2_rspbody.phoneAddrBook.get();
                if (list != null && !list.isEmpty()) {
                    for (cmd0xbf2$PhoneAddrBook cmd0xbf2_phoneaddrbook : list) {
                        PhoneInfo phoneInfo = new PhoneInfo();
                        phoneInfo.f258442d = cmd0xbf2_phoneaddrbook.str_phone.get();
                        phoneInfo.f258443e = cmd0xbf2_phoneaddrbook.str_nick.get();
                        phoneInfo.f258444f = cmd0xbf2_phoneaddrbook.str_long_nick.get();
                        phoneInfo.f258445h = cmd0xbf2_phoneaddrbook.str_head_url.get();
                        recommendedListResp.f258455h.add(phoneInfo);
                    }
                }
                notifyUI(3, true, recommendedListResp);
                return;
            }
            notifyUI(3, false, recommendedListResp);
        } catch (Throwable th5) {
            QLog.e("IMCore.PhoneContact.ContactBindHandler", 1, "handleGetRecommendedList fail.", th5);
            recommendedListResp.f258452d = -1;
            notifyUI(3, false, recommendedListResp);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        int i3;
        int i16;
        oidb_0xbe8$RspBody oidb_0xbe8_rspbody = new oidb_0xbe8$RspBody();
        int i17 = toServiceMsg.extraData.getInt(HttpOp.OP_CODE);
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xbe8_rspbody);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("handleShowBindPhonePage reqOpCode=%s result=%s", Integer.valueOf(i17), Integer.valueOf(parseOIDBPkg)));
        }
        if (parseOIDBPkg == 0) {
            if (oidb_0xbe8_rspbody.uint64_uin.has()) {
                j3 = oidb_0xbe8_rspbody.uint64_uin.get();
            } else {
                j3 = 0;
            }
            if (oidb_0xbe8_rspbody.enum_op_code.has()) {
                i3 = oidb_0xbe8_rspbody.enum_op_code.get();
            } else {
                i3 = 0;
            }
            if (oidb_0xbe8_rspbody.uint32_rsp_of_popup_flag.has()) {
                i16 = oidb_0xbe8_rspbody.uint32_rsp_of_popup_flag.get();
            } else {
                i16 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("handleShowBindPhonePage resUin=%s resOpCode=%s resFlag=%s", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)));
            }
            if (i3 == 2) {
                if (i16 == 1) {
                    notifyUI(1, true, null);
                    return;
                } else {
                    notifyUI(1, false, null);
                    return;
                }
            }
            if (i3 == 4) {
                if (fromServiceMsg.isSuccess()) {
                    notifyUI(2, true, null);
                    return;
                } else {
                    notifyUI(2, false, null);
                    return;
                }
            }
            if (i3 == 11) {
                if (fromServiceMsg.isSuccess()) {
                    notifyUI(4, true, null);
                    return;
                } else {
                    notifyUI(4, false, null);
                    return;
                }
            }
            return;
        }
        if (i17 == 1) {
            notifyUI(1, false, null);
        } else if (i17 == 3) {
            notifyUI(2, false, null);
        }
    }

    public void D2(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("getRecommendedList uin=%s startIndex=%s num=%s", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        try {
            cmd0xbf2$ReqBody cmd0xbf2_reqbody = new cmd0xbf2$ReqBody();
            cmd0xbf2_reqbody.uint64_uin.set(j3);
            cmd0xbf2_reqbody.uint64_start_index.set(i3);
            cmd0xbf2_reqbody.uint64_num.set(i16);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xbf2", 3058, 0, cmd0xbf2_reqbody.toByteArray());
            makeOIDBPkg.setTimeout(10000L);
            sendPbReq(makeOIDBPkg);
        } catch (Throwable th5) {
            QLog.e("IMCore.PhoneContact.ContactBindHandler", 1, "getRecommendedList fail.", th5);
        }
    }

    public void G2(String str) {
        long longValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("queryShowBindPhonePage uin=%s", str));
        }
        try {
            oidb_0xbe8$ReqBody oidb_0xbe8_reqbody = new oidb_0xbe8$ReqBody();
            PBUInt64Field pBUInt64Field = oidb_0xbe8_reqbody.uint64_uin;
            if (TextUtils.isEmpty(str)) {
                longValue = 0;
            } else {
                longValue = Long.valueOf(str).longValue();
            }
            pBUInt64Field.set(longValue);
            oidb_0xbe8_reqbody.enum_op_code.set(1);
            oidb_0xbe8_reqbody.uint32_req_of_popup_flag.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, oidb_0xbe8_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt(HttpOp.OP_CODE, 1);
            makeOIDBPkg.setTimeout(10000L);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("IMCore.PhoneContact.ContactBindHandler", 1, "queryShowBindPhonePage fail.", e16);
        }
    }

    public void H2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("reportCommonGuideWebOpen uin=%s type=%s", str, Integer.valueOf(i3)));
        }
        try {
            oidb_0xbe8$ReqBody oidb_0xbe8_reqbody = new oidb_0xbe8$ReqBody();
            oidb_0xbe8_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
            oidb_0xbe8_reqbody.enum_op_code.set(10);
            oidb_0xbe8$PopupResult oidb_0xbe8_popupresult = new oidb_0xbe8$PopupResult();
            oidb_0xbe8_popupresult.uint32_popup_result.set(0);
            oidb_0xbe8_popupresult.uint32_popup_fieldid.set(i3);
            oidb_0xbe8_reqbody.rpt_msg_popup_result.add(oidb_0xbe8_popupresult);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, oidb_0xbe8_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt(HttpOp.OP_CODE, 10);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("IMCore.PhoneContact.ContactBindHandler", 1, "reportCommonGuideShowState fail.", e16);
        }
    }

    public void I2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("reportContactsGuidePopWindowState uin=%s", str));
        }
        try {
            oidb_0xbe8$ReqBody oidb_0xbe8_reqbody = new oidb_0xbe8$ReqBody();
            oidb_0xbe8_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
            oidb_0xbe8_reqbody.enum_op_code.set(8);
            oidb_0xbe8_reqbody.uint32_mqq808_welcomepage_flag.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, oidb_0xbe8_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt(HttpOp.OP_CODE, 8);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("IMCore.PhoneContact.ContactBindHandler", 1, "queryShowBindPhonePage fail.", e16);
        }
    }

    public void J2(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindHandler", 2, String.format("setShowBindPhonePageResult uin=%s success=%s", str, Boolean.valueOf(z16)));
        }
        try {
            oidb_0xbe8$ReqBody oidb_0xbe8_reqbody = new oidb_0xbe8$ReqBody();
            oidb_0xbe8_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
            oidb_0xbe8_reqbody.enum_op_code.set(3);
            PBUInt32Field pBUInt32Field = oidb_0xbe8_reqbody.uint32_rst_of_popup_flag;
            if (z16) {
                i3 = 1;
            }
            pBUInt32Field.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, oidb_0xbe8_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt(HttpOp.OP_CODE, 3);
            makeOIDBPkg.setTimeout(10000L);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("IMCore.PhoneContact.ContactBindHandler", 1, "setShowBindPhonePageResult fail.", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xbe8");
            this.allowCmdSet.add("OidbSvc.0xbf2");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        if ("OidbSvc.0xbe8".equals(serviceCmd)) {
            F2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xbf2".equals(serviceCmd)) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
