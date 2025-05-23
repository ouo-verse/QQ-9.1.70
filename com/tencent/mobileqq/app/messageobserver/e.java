package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e implements d {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.messageobserver.d
    public void a(bs bsVar, int i3, boolean z16, Object obj, Object[] objArr, StatictisInfo statictisInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bsVar, Integer.valueOf(i3), Boolean.valueOf(z16), obj, objArr, statictisInfo);
            return;
        }
        if (i3 != 8031) {
            switch (i3) {
                case MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP /* 8016 */:
                    bsVar.msgRevokeRsp(z16, objArr);
                    return;
                case MessageHandlerConstants.NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB /* 8017 */:
                    bsVar.reqInsertBlacklistPB(z16, obj);
                    return;
                case MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK /* 8018 */:
                    bsVar.reqBlessDirtyTextCheck(z16, objArr);
                    return;
                case MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_MSG /* 8019 */:
                    bsVar.reqBlessMsg(z16, objArr);
                    return;
                case MessageHandlerConstants.NOTIFY_TYPE_NEW_MESSAGE_ADDED /* 8020 */:
                    bsVar.newMessageAdded(obj);
                    return;
                default:
                    switch (i3) {
                        case MessageHandlerConstants.NOTIFY_TYPE_MSG_START_SENDING_UI /* 8022 */:
                            bsVar.msgStartSendingUI(objArr);
                            return;
                        case MessageHandlerConstants.NOTIFY_TYPE_BOX_UNREAD_NUM_REFRESH /* 8023 */:
                            bsVar.onBoxMsgUnreadNumRefresh();
                            return;
                        case MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM /* 8024 */:
                            if (obj != null) {
                                str = ((com.tencent.mobileqq.subaccount.logic.b) obj).f291134a;
                            } else {
                                str = null;
                            }
                            bsVar.onSubAccountThirdQQUnreadMsgNum(z16, str, (com.tencent.mobileqq.subaccount.logic.b) obj);
                            return;
                        default:
                            return;
                    }
            }
        }
        bsVar.onMsgForwardWXResult(((Integer) obj).intValue());
    }
}
