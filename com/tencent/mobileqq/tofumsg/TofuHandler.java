package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xe61.oidb_0xe61$BeancurdCubeInfoResult;
import tencent.im.oidb.cmd0xe61.oidb_0xe61$RspBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TofuHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public TofuHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        List<oidb_0xe61$BeancurdCubeInfoResult> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String string = toServiceMsg.extraData.getString("selfUin", "");
        String string2 = toServiceMsg.extraData.getString("frdUin", "");
        oidb_0xe61$RspBody oidb_0xe61_rspbody = new oidb_0xe61$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe61_rspbody);
        if (parseOIDBPkg == 0) {
            if (oidb_0xe61_rspbody.rpt_beancurd_cube_info_result.has()) {
                list = oidb_0xe61_rspbody.rpt_beancurd_cube_info_result.get();
            } else {
                list = null;
            }
            if (list != null && list.size() > 0) {
                notifyUI(0, true, new Object[]{string, string2, list});
                z16 = true;
                if (!z16) {
                    notifyUI(0, false, new Object[]{string, string2, null});
                }
                if (!QLog.isColorLevel()) {
                    QLog.i("Tofu_TofuHandler", 2, String.format("handlePullTofuData result=%d suc=%b selfUin=%s frdUin=%s", Integer.valueOf(parseOIDBPkg), Boolean.valueOf(z16), string, MobileQQ.getShortUinStr(string2)));
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
        if (!QLog.isColorLevel()) {
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x6e1_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return n.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x6e1_1".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
