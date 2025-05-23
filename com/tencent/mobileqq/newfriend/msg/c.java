package com.tencent.mobileqq.newfriend.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public MessageForSystemMsg f254022d;

    public c(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
        } else {
            this.f254035a = str;
            this.f254036b = j3;
        }
    }

    public static String g(Context context, structmsg$StructMsg structmsg_structmsg) {
        String str;
        if (context == null || structmsg_structmsg == null) {
            return null;
        }
        boolean i3 = i(structmsg_structmsg.msg_type.get(), structmsg_structmsg.f436065msg.sub_type.get());
        if (!TextUtils.isEmpty(structmsg_structmsg.f436065msg.msg_additional.get())) {
            if (!TextUtils.isEmpty(structmsg_structmsg.f436065msg.msg_qna.get())) {
                str = structmsg_structmsg.f436065msg.msg_qna.get();
            } else {
                str = structmsg_structmsg.f436065msg.msg_additional.get();
            }
            if (i3 && !TextUtils.isEmpty(str)) {
                str = context.getString(R.string.f160751vv) + context.getString(R.string.f160731vt) + str;
            }
        } else {
            str = structmsg_structmsg.f436065msg.msg_describe.get();
            if (i3 && !TextUtils.isEmpty(str)) {
                str = context.getString(R.string.bxc) + context.getString(R.string.f160731vt) + str;
            }
        }
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static boolean h(AppRuntime appRuntime, String str, structmsg$StructMsg structmsg_structmsg, boolean z16) {
        boolean z17;
        int i3;
        boolean z18;
        boolean z19 = false;
        if (structmsg_structmsg != null && structmsg_structmsg.f436065msg.uint32_source_flag.has() && appRuntime != null) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (z16 && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "FriendSystemMessage")) {
                z17 = true;
            } else {
                z17 = false;
            }
            i3 = structmsg_structmsg.f436065msg.uint32_source_flag.get();
            if ((i3 & 16) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z16) {
                if (z18 && !z17) {
                    z19 = true;
                }
            } else {
                z19 = z18;
            }
        } else {
            z17 = false;
            i3 = 0;
            z18 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("isMsgFromWZRY", 2, "result=" + z19 + ",isFromWzry=" + z18 + ",sourceFlag=" + i3 + ",isFriend=" + z17 + ",checkFriend=" + z16);
        }
        return z19;
    }

    public static boolean i(int i3, int i16) {
        if (i3 == 1) {
            if (i16 == 1 || i16 == 2 || i16 == 3 || i16 == 7 || i16 == 8 || i16 == 9 || i16 == 10) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean j(structmsg$StructMsg structmsg_structmsg) {
        structmsg$SystemMsg structmsg_systemmsg;
        if (structmsg_structmsg == null || (structmsg_systemmsg = structmsg_structmsg.f436065msg) == null || !structmsg_systemmsg.uint32_doubt_flag.has() || structmsg_structmsg.f436065msg.uint32_doubt_flag.get() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public String a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        }
        MessageForSystemMsg messageForSystemMsg = this.f254022d;
        if (messageForSystemMsg != null && TextUtils.isEmpty(messageForSystemMsg.f203106msg)) {
            this.f254022d.parse();
            this.f254022d.f203106msg = MessageForSystemMsg.getSysMsgDesc(BaseApplication.getContext().getResources(), this.f254022d.structMsg);
            this.f254035a = this.f254022d.f203106msg;
        }
        return this.f254035a;
    }

    @Override // com.tencent.mobileqq.newfriend.msg.i
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f254022d.isread;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.f254022d.structMsg.f436065msg.req_uin_nick.has()) {
            return this.f254022d.structMsg.f436065msg.req_uin_nick.get();
        }
        return null;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return String.valueOf(this.f254022d.structMsg.req_uin.get());
    }

    public String f(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        MessageForSystemMsg messageForSystemMsg = this.f254022d;
        if (messageForSystemMsg != null) {
            return g(context, messageForSystemMsg.structMsg);
        }
        return null;
    }

    public c(MessageForSystemMsg messageForSystemMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForSystemMsg);
            return;
        }
        this.f254022d = messageForSystemMsg;
        this.f254035a = messageForSystemMsg.extStr;
        this.f254036b = messageForSystemMsg.time;
        this.f254037c = j(messageForSystemMsg.getSystemMsg());
    }
}
