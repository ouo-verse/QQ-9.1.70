package com.tencent.mobileqq.troop.troopanonymous;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.cs.cmd0x3bb.cmd0x3bb$AnonyMsg;
import tencent.im.cs.cmd0x3bb.cmd0x3bb$AnonyStatus;
import tencent.im.cs.cmd0x3bb.cmd0x3bb$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAnonymousHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    public TroopAnonymousHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        int i3;
        if (toServiceMsg != null && fromServiceMsg != null) {
            if (fromServiceMsg.getResultCode() != 1000) {
                notifyUI(e.f298012e, false, null);
                return;
            }
            cmd0x3bb$AnonyMsg cmd0x3bb_anonymsg = new cmd0x3bb$AnonyMsg();
            try {
                cmd0x3bb_anonymsg.mergeFrom((byte[]) obj);
                cmd0x3bb$RspBody cmd0x3bb_rspbody = cmd0x3bb_anonymsg.msg_anony_rsp.get();
                if (cmd0x3bb_rspbody == null) {
                    notifyUI(e.f298012e, false, null);
                    return;
                }
                if (cmd0x3bb_rspbody.int32_ret.get() != 0) {
                    notifyUI(e.f298012e, false, null);
                    return;
                }
                String string = toServiceMsg.extraData.getString("troopUin");
                String str2 = new String(cmd0x3bb_rspbody.str_anony_name.get().toByteArray());
                int i16 = cmd0x3bb_rspbody.uint32_portrait_index.get();
                int i17 = cmd0x3bb_rspbody.uint32_bubble_index.get();
                int i18 = cmd0x3bb_rspbody.uint32_expired_time.get();
                cmd0x3bb$AnonyStatus cmd0x3bb_anonystatus = cmd0x3bb_rspbody.msg_anony_status.get();
                if (cmd0x3bb_anonystatus == null) {
                    str = "";
                    i3 = 0;
                } else {
                    i3 = cmd0x3bb_anonystatus.uint32_forbid_talking.get();
                    str = new String(cmd0x3bb_anonystatus.str_err_msg.get().toByteArray());
                }
                notifyUI(e.f298012e, true, new Object[]{string, str2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i3), str, cmd0x3bb_rspbody.color.get()});
            } catch (InvalidProtocolBufferMicroException unused) {
                notifyUI(e.f298012e, false, null);
            }
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
            hashSet.add("group_anonymous_generate_nick.group");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopAnonymousHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAnonymousHandler", 2, "onReceive,resp == null");
                return;
            }
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAnonymousHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if ("group_anonymous_generate_nick.group".equals(fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
