package com.tencent.mobileqq.newfriend.observer;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends BaseMessageObserver {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void deleteAllSystemMsg(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), objArr);
        } else if (objArr != null && objArr.length >= 1) {
            onDeleteAllSysMsg(z16, ((Integer) objArr[0]).intValue());
        }
    }

    public void getDelSystemMsgError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            onGetDelSystemMsgError();
        }
    }

    public void getDelSystemMsgFin(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            onGetDelSystemMsgFin(z16, false);
        }
    }

    public void getSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
        } else {
            onGetSystemMsgFin(z16, z17, list);
        }
    }

    protected void onDeleteAllSysMsg(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    protected void onGetDelSystemMsgError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    protected void onGetDelSystemMsgFin(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
        }
    }

    protected void onSendSystemMsgActionError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
    }

    protected void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
        throw null;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = null;
        }
        if (8039 == i3) {
            deleteAllSystemMsg(z16, objArr);
            return;
        }
        if (4015 == i3) {
            getDelSystemMsgError();
            return;
        }
        if (4014 == i3) {
            getDelSystemMsgFin(z16);
            return;
        }
        if (4005 == i3) {
            getSystemMsgFin(z16, false, (List) obj);
            return;
        }
        if (4006 == i3) {
            getSystemMsgFin(false, true, null);
        } else if (4011 == i3) {
            sendSystemMsgActionFin(z16, (ToServiceMsg) obj);
        } else if (4012 == i3) {
            sendSystemMsgActionError((ToServiceMsg) obj);
        }
    }

    public void sendSystemMsgActionError(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg);
        } else {
            onSendSystemMsgActionError((String) toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR));
        }
    }

    public void sendSystemMsgActionFin(boolean z16, ToServiceMsg toServiceMsg) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), toServiceMsg);
            return;
        }
        String str4 = (String) toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR);
        int i3 = toServiceMsg.extraData.getInt("system_msg_action_type");
        String string = toServiceMsg.extraData.getString("system_msg_action_resp_key");
        String string2 = toServiceMsg.extraData.getString("system_msg_action_resp_error_key");
        int i16 = toServiceMsg.extraData.getInt("system_msg_action_resp_result_code_key");
        int i17 = toServiceMsg.extraData.getInt("system_msg_action_resp_type_key");
        String string3 = toServiceMsg.extraData.getString("system_msg_action_resp_invalid_decided_key");
        int i18 = toServiceMsg.extraData.getInt("system_msg_action_resp_remark_result_key");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        if (string3 == null) {
            str3 = "";
        } else {
            str3 = string3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageObserver", 2, "sendSystemMsgActionResult logStr=" + str4 + ";actionType=" + i3 + ";msgDetail=" + str + ";resultCode=" + i16 + ";respType=" + i17 + ";msgFail=" + str2 + ";msgInvalidDecided=" + str3 + ";remarkRet=" + i18);
        }
        onSendSystemMsgActionFin(z16, str4, i3, str, i16, i17, str2, str3, i18);
    }
}
