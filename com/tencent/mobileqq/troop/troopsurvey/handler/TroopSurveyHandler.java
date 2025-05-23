package com.tencent.mobileqq.troop.troopsurvey.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.config.ak;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.j;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$MsgBody;
import tt2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSurveyHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static String f301740f;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f301741e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f301740f = "OidbSvc.0xb36_1";
        }
    }

    public TroopSurveyHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String string = toServiceMsg.extraData.getString("troopUin");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handle_oidb_0xb36_1, troopUin = " + string);
        }
        if (!fromServiceMsg.isSuccess()) {
            QLog.e(LogTag.TAG_TROOP_SURVEY, 1, "handle_oidb_0xb36_1, resp not success: ", fromServiceMsg.getBusinessFailMsg(), fromServiceMsg.toString());
            notifyUI(j.f298030e, false, new Object[]{string});
            return;
        }
        try {
            ak.a().c(this.appRuntime, toServiceMsg, string, new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj));
            notifyUI(j.f298030e, true, new Object[]{string});
        } catch (Exception e16) {
            QLog.e(LogTag.TAG_TROOP_SURVEY, 1, "handle_oidb_0xb36_1, pkg.mergeFrom error! ", e16);
            notifyUI(j.f298030e, false, new Object[]{string});
        }
    }

    @Override // tt2.a
    public void c2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "send_oidb_0xb36, troopUin = " + str);
        }
        oidb_cmd0xb36$ReqBody oidb_cmd0xb36_reqbody = new oidb_cmd0xb36$ReqBody();
        try {
            oidb_cmd0xb36_reqbody.group_id.set(Long.parseLong(str));
            oidb_cmd0xb36_reqbody.red_point_num.set(i3);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2870);
            oidb_sso_oidbssopkg.uint32_service_type.set(1);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xb36_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(f301740f);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putString("troopUin", str);
            sendPbReq(createToServiceMsg);
        } catch (NumberFormatException e16) {
            QLog.e(LogTag.TAG_TROOP_SURVEY, 1, "send_oidb_0xb36 error! ", e16);
        }
    }

    @Override // tt2.a
    public boolean e2(com.tencent.mobileqq.troop.unreadmsg.a aVar, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, aVar, subCmd0x1UpdateAppUnreadNum, Integer.valueOf(i3))).booleanValue();
        }
        if (aVar.f301844a != 1106717414) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", aVar.f301845b, " newNum: ", Integer.valueOf(aVar.f301847d), " unreadNumber: ", Integer.valueOf(aVar.f301846c), " from: ", Integer.valueOf(i3));
        }
        if (subCmd0x1UpdateAppUnreadNum != null && subCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has()) {
            String stringUtf8 = subCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.bytes_text.get().toStringUtf8();
            if (!TextUtils.isEmpty(stringUtf8)) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", aVar.f301845b, " will notify ark com.tencent.groupDragon, data: ", stringUtf8);
                }
                ak.a().d(stringUtf8);
            }
        }
        if (i3 != 2 && aVar.f301847d == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_SURVEY, 2, "handle_push_msginfo receive TROOP_SURVEY_REDPOINT troopuin: ", aVar.f301845b, " newNum: ", Integer.valueOf(aVar.f301847d), " unreadNumber: ", Integer.valueOf(aVar.f301846c), " no need to send_oidb_0xb36 , from is: ", Integer.valueOf(i3));
            }
        } else {
            c2(aVar.f301845b, aVar.f301847d);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f301741e == null) {
            HashSet hashSet = new HashSet();
            this.f301741e = hashSet;
            hashSet.add(f301740f);
        }
        return this.f301741e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopSurveyHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return j.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSurveyHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (f301740f.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSurveyHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
