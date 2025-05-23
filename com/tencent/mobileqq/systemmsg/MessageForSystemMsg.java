package com.tencent.mobileqq.systemmsg;

import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.util.c;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MessageForSystemMsg extends ChatMessage {
    static IPatchRedirector $redirector_ = null;
    public static final int SYSMSG_MENU_FLAG_DEFAULT = 0;
    public static final int SYSMSG_MENU_FLAG_DEL = 1;
    public static final int SYSMSG_MENU_FLAG_MASK_DEL = 15;
    public static final int SYSMSG_MENU_FLAG_MAYKNOW = 2;
    public static final String TAG = "MessageForSystemMsg";
    public int mSysmsgMenuFlag;
    public structmsg$StructMsg structMsg;

    public MessageForSystemMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.structMsg = null;
            this.mSysmsgMenuFlag = 0 | 1;
        }
    }

    public static String getSysMsgDesc(Resources resources, structmsg$StructMsg structmsg_structmsg) {
        String format;
        String string;
        String str = "";
        if (structmsg_structmsg == null || resources == null) {
            return "";
        }
        int i3 = structmsg_structmsg.msg_type.get();
        if (i3 == 1) {
            int i16 = structmsg_structmsg.f436065msg.sub_type.get();
            if (i16 != 1) {
                if (i16 != 4) {
                    if (i16 != 5) {
                        if (i16 != 6) {
                            string = structmsg_structmsg.f436065msg.msg_describe.get();
                        } else {
                            string = resources.getString(R.string.h0f);
                        }
                    } else {
                        string = resources.getString(R.string.f169981b3);
                    }
                } else {
                    string = resources.getString(R.string.f169982b4);
                }
            } else {
                string = resources.getString(R.string.f170058eb);
            }
            format = structmsg_structmsg.f436065msg.req_uin_nick.get() + string;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("getSysMsgDesc, msg: %s, sub: %s, desc: %s", Integer.valueOf(i3), Integer.valueOf(structmsg_structmsg.f436065msg.sub_type.get()), structmsg_structmsg.f436065msg.msg_describe.get()));
            }
        } else if (i3 == 2) {
            int i17 = structmsg_structmsg.f436065msg.group_msg_type.get();
            QLog.d(TAG, 1, "groupMsgType:" + i17 + "|req_uin_nick:" + structmsg_structmsg.f436065msg.req_uin_nick.get() + "|actor_uin_nick:" + structmsg_structmsg.f436065msg.actor_uin_nick.get() + "|action_uin_nick:" + structmsg_structmsg.f436065msg.action_uin_nick.get() + "|msg_describe:" + structmsg_structmsg.f436065msg.msg_describe.get());
            int b16 = c.b(i17);
            if (b16 == 1) {
                str = structmsg_structmsg.f436065msg.action_uin_nick.get();
            } else if (b16 == 2) {
                str = structmsg_structmsg.f436065msg.req_uin_nick.get();
            }
            format = c.a(structmsg_structmsg, str + structmsg_structmsg.f436065msg.msg_describe.get());
        } else {
            format = String.format("%s %s", structmsg_structmsg.f436065msg.req_uin_nick.get(), structmsg_structmsg.f436065msg.msg_describe.get());
        }
        QLog.i(TAG, 1, String.format("getSysMsgDesc, msg: %s, suffix: %s", Integer.valueOf(i3), format));
        return format;
    }

    public static structmsg$StructMsg parseStructMsg(byte[] bArr) {
        structmsg$StructMsg structmsg_structmsg = new structmsg$StructMsg();
        try {
            structmsg_structmsg.mergeFrom(bArr);
        } catch (Exception e16) {
            QLog.e(TAG, 2, e16, new Object[0]);
        }
        return structmsg_structmsg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.structMsg = parseStructMsg(this.msgData);
        }
    }

    public structmsg$StructMsg getSystemMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (structmsg$StructMsg) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.structMsg == null && !this.mIsParsed) {
            parse();
        }
        return this.structMsg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        structmsg$StructMsg structmsg_structmsg = this.structMsg;
        if (structmsg_structmsg != null) {
            try {
                this.msgData = structmsg_structmsg.toByteArray();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
