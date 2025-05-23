package com.tencent.mobileqq.addfriend.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.utils.a;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.LabelTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x1004.oidb_cmd0x1004$Person;
import tencent.im.oidb.cmd0x1004.oidb_cmd0x1004$ReqBody;
import tencent.im.oidb.cmd0x1004.oidb_cmd0x1004$RspBody;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddFriendHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    protected AddFriendHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void E2(FromServiceMsg fromServiceMsg, Object obj) {
        oidb_cmd0x1004$RspBody oidb_cmd0x1004_rspbody = new oidb_cmd0x1004$RspBody();
        if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0x1004_rspbody) == 0 && oidb_cmd0x1004_rspbody.person_list.size() > 0) {
            oidb_cmd0x1004$Person oidb_cmd0x1004_person = oidb_cmd0x1004_rspbody.person_list.get(0);
            List<LabelTag> n3 = a.n(oidb_cmd0x1004_person);
            if (n3 == null && QLog.isColorLevel()) {
                QLog.d("AddFriendHandler", 2, "handleAddFriendRequestTag | data is null ");
            }
            notifyUI(1, true, n3);
            notifyUI(2, true, oidb_cmd0x1004_person.nickname.get());
            return;
        }
        String stringForLog = fromServiceMsg.getStringForLog();
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendHandler", 2, "handleGetAddFriendRequestTag error. res=" + stringForLog);
        }
    }

    public void D2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        try {
            oidb_cmd0x1004$ReqBody oidb_cmd0x1004_reqbody = new oidb_cmd0x1004$ReqBody();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j3));
            oidb_cmd0x1004_reqbody.uin_list.set(arrayList);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.oidb_0x1004", 4100, 1, oidb_cmd0x1004_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("uin", String.valueOf(j3));
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("AddFriendHandler", 1, "getAddFriendRequestTag exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.oidb_0x1004");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.observer.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        } else if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            QLog.d("AddFriendHandler", 4, "onReceive() cmd is invalid, req.cmd = ", toServiceMsg.getServiceCmd());
        } else if ("OidbSvc.oidb_0x1004".equals(toServiceMsg.getServiceCmd())) {
            E2(fromServiceMsg, obj);
        }
    }
}
