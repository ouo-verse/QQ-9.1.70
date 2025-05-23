package com.tencent.mobileqq.service.message;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import msf.msgcomm.msg_comm$GroupInfo;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$RichMsg;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<AppRuntime> f286340a;

    /* JADX INFO: Access modifiers changed from: protected */
    public v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286340a = new WeakReference<>(MobileQQ.sMobileQQ.waitAppRuntime(null));
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (bArr != null && bArr.length > 0) {
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() < 2) {
                    sb5.append(0);
                }
                sb5.append(hexString);
            }
            return sb5.toString();
        }
        return null;
    }

    private im_msg_body$GeneralFlags c(List<im_msg_body$Elem> list) {
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
        }
        return im_msg_body_generalflags;
    }

    private long d(msg_comm$Msg msg_comm_msg, long j3, int i3) {
        msg_comm$GroupInfo msg_comm_groupinfo;
        if ((i3 == 82 || i3 == 43) && (msg_comm_groupinfo = msg_comm_msg.msg_head.group_info) != null && msg_comm_groupinfo.group_code.has()) {
            return msg_comm_msg.msg_head.group_info.group_code.get();
        }
        return j3;
    }

    private im_msg_body$RichMsg e(List<im_msg_body$Elem> list) {
        im_msg_body$RichMsg im_msg_body_richmsg = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.rich_msg.has()) {
                im_msg_body_richmsg = im_msg_body_elem.rich_msg.get();
            }
        }
        return im_msg_body_richmsg;
    }

    private im_msg_body$Text f(List<im_msg_body$Elem> list) {
        im_msg_body$Text im_msg_body_text = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.text.has()) {
                im_msg_body_text = im_msg_body_elem.text.get();
            }
        }
        return im_msg_body_text;
    }

    private boolean i(im_msg_body$GeneralFlags im_msg_body_generalflags) {
        if (im_msg_body_generalflags != null && (im_msg_body_generalflags.long_text_flag.get() == 1 || im_msg_body_generalflags.long_text_flag.get() == 3)) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.d("QMessagePBElemDecoder", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
            return true;
        }
        return false;
    }

    private void q(aa aaVar, AtTroopMemberInfo atTroopMemberInfo, byte[] bArr) {
        ArrayList<Object> arrayList = aaVar.f286171a;
        if (arrayList != null) {
            if (atTroopMemberInfo != null || bArr != null) {
                if (arrayList.isEmpty()) {
                    arrayList.add(atTroopMemberInfo);
                    arrayList.add(bArr);
                    return;
                }
                if (arrayList.size() != 2) {
                    return;
                }
                if (arrayList.get(0) != null && arrayList.get(1) != null) {
                    return;
                }
                Object obj = atTroopMemberInfo;
                if (arrayList.get(0) != null) {
                    obj = arrayList.get(0);
                }
                Object obj2 = bArr;
                if (arrayList.get(1) != null) {
                    obj2 = arrayList.get(1);
                }
                arrayList.clear();
                arrayList.add(obj);
                arrayList.add(obj2);
            }
        }
    }

    @NonNull
    private StringBuilder r(StringBuilder sb5) {
        if (sb5 != null) {
            return new StringBuilder(sb5);
        }
        return new StringBuilder();
    }

    protected void b(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, im_msg_body$GeneralFlags im_msg_body_generalflags, boolean z16, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, list, list2, sb5, msg_comm_msg, cVar, im_msg_body_generalflags, Boolean.valueOf(z16), messageRecord);
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("c2cMsgContent.data:null;\n");
        }
        n(list, list2, sb5, msg_comm_msg, cVar);
    }

    protected t g(im_msg_body$RichMsg im_msg_body_richmsg, List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (t) iPatchRedirector.redirect((short) 10, this, im_msg_body_richmsg, list, msg_comm_msg, im_msg_body_generalflags);
        }
        return t.a();
    }

    protected boolean h(List<im_msg_body$Elem> list, List<MessageRecord> list2, msg_comm$Msg msg_comm_msg, im_msg_body$GeneralFlags im_msg_body_generalflags, im_msg_body$Text im_msg_body_text, byte[] bArr, long j3, MessageRecord messageRecord, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 11, this, list, list2, msg_comm_msg, im_msg_body_generalflags, im_msg_body_text, bArr, Long.valueOf(j3), messageRecord, Long.valueOf(j16), Integer.valueOf(i3))).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChatMessage j(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, ArrayList<Object> arrayList, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ChatMessage) iPatchRedirector.redirect((short) 8, this, list, msg_comm_msg, arrayList, cVar, arrayList2);
        }
        ChatMessage chatMessage = (ChatMessage) ((IMessageRecordFactoryService) QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
        if (arrayList.size() > 0) {
            ArrayList<AtTroopMemberInfo> arrayList3 = new ArrayList<>(arrayList.size());
            Iterator<Object> it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof AtTroopMemberInfo) {
                    arrayList3.add((AtTroopMemberInfo) next);
                }
            }
            chatMessage.atInfoTempList = arrayList3;
        }
        return chatMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public im_msg_body$GeneralFlags k(List<im_msg_body$Elem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (im_msg_body$GeneralFlags) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
        }
        return im_msg_body_generalflags;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(msg_comm$Msg msg_comm_msg, byte[] bArr, MessageRecord messageRecord) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, msg_comm_msg, bArr, messageRecord);
            return;
        }
        if (msg_comm_msg.msg_head.from_uin.has()) {
            if (TextUtils.equals(o().getCurrentAccountUin(), Long.toString(msg_comm_msg.msg_head.from_uin.get()))) {
                z16 = true;
                if (bArr == null && !z16) {
                    messageRecord.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(bArr));
                    return;
                }
            }
        }
        z16 = false;
        if (bArr == null) {
        }
    }

    public void m(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QMessagePBElemDecoder", 2, "begin decodePBMsgElems_RichMsg");
        }
        im_msg_body$RichMsg e16 = e(list);
        im_msg_body$GeneralFlags c16 = c(list);
        im_msg_body$Text f16 = f(list);
        if (e16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QMessagePBElemDecoder", 2, "richMsg is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:RichMsg;\n");
        }
        boolean i3 = i(c16);
        if (msg_comm_msg.msg_head.from_uin.has()) {
            j3 = msg_comm_msg.msg_head.from_uin.get();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        long j17 = msg_comm_msg.msg_head.to_uin.get();
        int i16 = msg_comm_msg.msg_head.msg_type.get();
        long d16 = d(msg_comm_msg, j17, i16);
        t g16 = g(e16, list, msg_comm_msg, c16);
        if (h(list, list2, msg_comm_msg, c16, f16, g16.f286337b, j16, g16.f286336a, d16, i16)) {
            return;
        }
        MessageRecord messageRecord = g16.f286336a;
        messageRecord.f203106msg = "richMsg";
        b(list, list2, sb5, msg_comm_msg, cVar, c16, i3, messageRecord);
    }

    public void n(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        aa aaVar = new aa();
        ArrayList<Object> arrayList = aaVar.f286171a;
        ArrayList<AtTroopMemberInfo> arrayList2 = new ArrayList<>(2);
        StringBuilder t16 = t(null, list, sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, aaVar, arrayList2, msg_comm_msg.msg_head.msg_time.get());
        if (t16.length() == 0) {
            return;
        }
        ChatMessage j3 = j(list, msg_comm_msg, arrayList, cVar, arrayList2);
        j3.f203106msg = t16.toString();
        list2.add(j3);
    }

    public AppRuntime o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime appRuntime = this.f286340a.get();
        if (appRuntime == null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            this.f286340a = new WeakReference<>(waitAppRuntime);
            QLog.i("QMessagePBElemDecoder", 1, "getQQAppInterface == null");
            return waitAppRuntime;
        }
        return appRuntime;
    }

    protected y p(StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr, StringBuilder sb6, boolean z16, im_msg_body$Elem im_msg_body_elem, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (y) iPatchRedirector.redirect((short) 5, this, sb5, Long.valueOf(j3), cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, Boolean.valueOf(z16), im_msg_body_elem, Long.valueOf(j16));
        }
        return new y(o(), sb5, j3, cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, z16, im_msg_body_elem, j16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String s(List<im_msg_body$Elem> list, List<MessageRecord> list2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, this, list, list2, Boolean.valueOf(z16));
        }
        String str = null;
        im_msg_body$Text im_msg_body_text = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.text.has()) {
                im_msg_body_text = im_msg_body_elem.text.get();
            }
        }
        if (im_msg_body_text != null && im_msg_body_text.str.has()) {
            str = im_msg_body_text.str.get().toStringUtf8();
            if (z16) {
                String c16 = s.c(str, false);
                if (c16.length() > 0) {
                    MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactoryService) QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
                    createMsgRecordByMsgType.msgtype = -1000;
                    createMsgRecordByMsgType.f203106msg = c16;
                    list2.add(createMsgRecordByMsgType);
                }
            }
        }
        return str;
    }

    public StringBuilder t(StringBuilder sb5, List<im_msg_body$Elem> list, StringBuilder sb6, long j3, com.tencent.mobileqq.troop.data.c cVar, aa aaVar, ArrayList<AtTroopMemberInfo> arrayList, long j16) {
        aa aaVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (StringBuilder) iPatchRedirector.redirect((short) 4, this, sb5, list, sb6, Long.valueOf(j3), cVar, aaVar, arrayList, Long.valueOf(j16));
        }
        if (aaVar == null) {
            aaVar2 = new aa();
        } else {
            aaVar2 = aaVar;
        }
        AtTroopMemberInfo atTroopMemberInfo = aaVar2.f286172b;
        StringBuilder r16 = r(sb5);
        Iterator<im_msg_body$Elem> it = list.iterator();
        AtTroopMemberInfo atTroopMemberInfo2 = atTroopMemberInfo;
        boolean z16 = false;
        AtTroopMemberInfo atTroopMemberInfo3 = null;
        byte[] bArr = null;
        while (it.hasNext()) {
            y i3 = p(sb6, j3, cVar, arrayList, atTroopMemberInfo3, atTroopMemberInfo2, bArr, r16, z16, it.next(), j16).i();
            atTroopMemberInfo3 = i3.g();
            atTroopMemberInfo2 = i3.h();
            bArr = i3.e();
            z16 = i3.j();
        }
        aaVar2.f286172b = atTroopMemberInfo2;
        q(aaVar2, atTroopMemberInfo3, bArr);
        return r16;
    }
}
