package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.messagehandler.WorkerHandler;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm$ContentHead;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgcomm.msg_comm$UinPairMsg;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbGetMsgResp;
import msf.msgsvc.msg_svc$PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc$PbGetRoamMsgResp;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;
import msf.msgsvc.msg_svc$PbSearchRoamMsgInCloudResp;
import msf.onlinepush.msg_onlinepush$PbPushMsg;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.searcher.oidb_c2c_searcher$Iterator;
import tencent.im.oidb.searcher.oidb_c2c_searcher$RspBody;

/* compiled from: P */
@Deprecated
/* loaded from: classes7.dex */
public class i extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: y, reason: collision with root package name */
    public static e f116677y;

    /* renamed from: v, reason: collision with root package name */
    public Comparator f116678v;

    /* renamed from: w, reason: collision with root package name */
    private Set<String> f116679w;

    /* renamed from: x, reason: collision with root package name */
    private Set<String> f116680x;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Comparator<msg_comm$Msg> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(msg_comm$Msg msg_comm_msg, msg_comm$Msg msg_comm_msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg_comm_msg, (Object) msg_comm_msg2)).intValue();
            }
            return msg_comm_msg.msg_head.get().msg_time.get() - msg_comm_msg2.msg_head.get().msg_time.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements Comparator<MessageRecord> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord, (Object) messageRecord2)).intValue();
            }
            return (int) (messageRecord.time - messageRecord2.time);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements Comparator<MessageRecord> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord, (Object) messageRecord2)).intValue();
            }
            return (int) (messageRecord.time - messageRecord2.time);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d implements Comparator<MessageRecord> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord, (Object) messageRecord2)).intValue();
            }
            return (int) (messageRecord2.time - messageRecord.time);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface e {
        void A(AppInterface appInterface, String str, C2CMsgReadedNotify c2CMsgReadedNotify);

        void B(String str, long j3, int i3, i iVar);

        void C(List<MessageRecord> list);

        void D(ArrayList<MessageRecord> arrayList, String str, boolean z16, i iVar);

        void E(ArrayList<MessageRecord> arrayList, i iVar);

        long a(AppInterface appInterface, long j3, long j16, long j17, msg_comm$UinPairMsg msg_comm_uinpairmsg);

        String b(msg_comm$UinPairMsg msg_comm_uinpairmsg, AppInterface appInterface, int i3);

        void c(String str, List<msg_comm$Msg> list, boolean z16, int i3, i iVar);

        void d(AppInterface appInterface, String str);

        void e(i iVar, ArrayList<MessageRecord> arrayList, long j3, long j16, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar);

        List<MessageRecord> f(String str, List<msg_comm$Msg> list, i iVar);

        void g(String str, int i3, long j3, i iVar);

        void h(String str, boolean z16, ArrayList<MessageRecord> arrayList, String str2, int i3, i iVar);

        List<MessageRecord> i(String str, long j3, long j16, i iVar);

        void j(ArrayList<MessageRecord> arrayList, i iVar, String str);

        void k(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, long j3, ArrayList<MessageRecord> arrayList, msg_comm$MsgHead msg_comm_msghead, int i3, long j16, long j17, int i16, long j18, int i17, int i18, int i19, ArrayList<MessageRecord> arrayList2, i iVar);

        boolean l(MessageRecord messageRecord, f fVar, i iVar);

        String m(String str, i iVar);

        void n(List<MessageRecord> list, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

        long o(int i3, int i16);

        long p(AppInterface appInterface, long j3, long j16, long j17);

        void q(int i3, i iVar);

        int r(i iVar);

        void s(long j3, i iVar);

        void t(long j3);

        boolean u(MessageRecord messageRecord, i iVar);

        void v(ArrayList<MessageRecord> arrayList, i iVar);

        byte[] w(i iVar);

        void x(List<MessageRecord> list, i iVar);

        void y(i iVar, msg_comm$UinPairMsg msg_comm_uinpairmsg, long j3, ArrayList<MessageRecord> arrayList, ArrayList<msg_comm$Msg> arrayList2, StringBuilder sb5, com.tencent.mobileqq.service.message.a aVar, int i3);

        void z(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public msg_comm$Msg f116685a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<MessageRecord> f116686b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f116687c;

        /* renamed from: d, reason: collision with root package name */
        public String f116688d;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<DelMsgInfo> f116689e;

        /* renamed from: f, reason: collision with root package name */
        private ArrayList<MessageRecord> f116690f;

        /* renamed from: g, reason: collision with root package name */
        public i f116691g;

        public f(i iVar, msg_comm$Msg msg_comm_msg, ArrayList<MessageRecord> arrayList, boolean z16, String str, ArrayList<DelMsgInfo> arrayList2, ArrayList<MessageRecord> arrayList3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, iVar, msg_comm_msg, arrayList, Boolean.valueOf(z16), str, arrayList2, arrayList3);
                return;
            }
            this.f116685a = msg_comm_msg;
            this.f116686b = arrayList;
            this.f116687c = z16;
            this.f116688d = str;
            this.f116689e = arrayList2;
            this.f116690f = arrayList3;
            this.f116691g = iVar;
        }

        private void b(MessageRecord messageRecord) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + messageRecord.senderuin + " mr.msgtype: " + messageRecord.msgtype + " mr.frienduin: " + messageRecord.frienduin + " mr.shmsgseq: " + messageRecord.shmsgseq + " mr.time:" + messageRecord.time + " mr.msg: " + messageRecord.getLogColorContent());
            }
            String str = messageRecord.frienduin;
            if (str != null && str.length() > 2) {
                messageRecord.isread = true;
                messageRecord.issend = 2;
                if (!i.f116677y.l(messageRecord, this, this.f116691g)) {
                    ((IMessageFacade) this.f116691g.f116342a.getRuntimeService(IMessageFacade.class, "")).setReadFrom(messageRecord.frienduin, messageRecord.istroop, messageRecord.time);
                }
                this.f116690f.add(messageRecord);
                DelMsgInfo delMsgInfo = new DelMsgInfo();
                delMsgInfo.lFromUin = Long.parseLong(messageRecord.senderuin);
                delMsgInfo.shMsgSeq = (short) messageRecord.shmsgseq;
                delMsgInfo.uMsgTime = messageRecord.time;
                this.f116689e.add(delMsgInfo);
            }
        }

        public f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (f) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList<MessageRecord> arrayList = this.f116686b;
            if (arrayList != null && arrayList.size() > 0) {
                int size = this.f116686b.size();
                for (int i3 = 0; i3 < size; i3++) {
                    b(this.f116686b.get(i3));
                }
            }
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            s.a();
        }
    }

    public i(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        super(appInterface, baseMessageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
            return;
        }
        this.f116678v = new a();
        this.f116679w = new HashSet();
        this.f116680x = new HashSet();
    }

    private void A(String str, List<msg_comm$Msg> list) {
        if (list.size() > 0) {
            if (this.f116343b.roamCache.containsKey(str)) {
                List<msg_comm$Msg> list2 = this.f116343b.roamCache.get(str);
                if (list2.size() == 0) {
                    list2.addAll(0, list);
                    return;
                } else {
                    if (list2.get(0).msg_head.get().msg_uid.get() != list.get(0).msg_head.get().msg_uid.get() || list2.get(0).msg_head.get().msg_seq.get() != list.get(0).msg_head.get().msg_seq.get()) {
                        list2.addAll(0, list);
                        return;
                    }
                    return;
                }
            }
            this.f116343b.roamCache.put(str, list);
        }
    }

    private void A0(byte b16, String str, List<msg_comm$Msg> list, boolean z16) {
        if (!z16) {
            long z06 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).z0(str);
            long j3 = list.get(0).msg_head.get().msg_time.get();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + str + "lastBreakTime:" + z06 + " currentBreakTime:" + j3 + " channelType:" + ((int) b16));
            }
            com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache();
            if (z06 == 0 || j3 < z06) {
                eVar.j(str, j3, 0L);
                if (b16 > 0) {
                    eVar.s(str, j3);
                }
            }
            if (b16 == 0) {
                eVar.X();
            }
        }
    }

    private void B(boolean z16, String str, ArrayList<MessageRecord> arrayList) {
        f116677y.D(arrayList, str, z16, this);
    }

    private void B0(int i3, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            u0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    private void C(boolean z16, String str, ArrayList<MessageRecord> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Collections.sort(arrayList, new b());
            B(z16, str, arrayList);
            f116677y.x(arrayList, this);
        }
    }

    private int C0(msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp, byte[] bArr) {
        byte[] bArr2;
        int i3;
        if (msg_svc_pbgetmsgresp.pubaccount_cookie.has()) {
            bArr2 = msg_svc_pbgetmsgresp.pubaccount_cookie.get().toByteArray();
        } else {
            bArr2 = null;
        }
        if (msg_svc_pbgetmsgresp.msg_rsp_type.has()) {
            i3 = msg_svc_pbgetmsgresp.msg_rsp_type.get();
        } else {
            i3 = 0;
        }
        W0(bArr, bArr2, i3);
        return i3;
    }

    private void D(ArrayList<MessageRecord> arrayList) {
        f116677y.v(arrayList, this);
    }

    private void D0(msg_comm$Msg msg_comm_msg, FromServiceMsg fromServiceMsg, msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg) {
        String uin;
        msg_comm$MsgHead msg_comm_msghead;
        String str;
        long j3;
        List<MessageRecord> list;
        boolean z16;
        msg_comm$MsgHead msg_comm_msghead2 = msg_comm_msg.msg_head.get();
        if (!msg_comm_msghead2.c2c_cmd.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush: no C2CCmd.");
                return;
            }
            return;
        }
        long j16 = msg_comm_msghead2.c2c_cmd.get();
        long j17 = msg_comm_msghead2.from_uin.get();
        long j18 = msg_comm_msghead2.to_uin.get();
        long j19 = msg_comm_msghead2.msg_seq.get();
        long j26 = msg_comm_msghead2.msg_time.get();
        long j27 = msg_comm_msghead2.msg_uid.get();
        int i3 = msg_comm_msghead2.user_active.get();
        int i16 = msg_comm_msghead2.from_instid.get();
        if (fromServiceMsg.getUin() == null) {
            uin = this.f116342a.getCurrentAccountUin();
        } else {
            uin = fromServiceMsg.getUin();
        }
        long longValue = Long.valueOf(uin).longValue();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            msg_comm_msghead = msg_comm_msghead2;
            sb5.append("<---handleMsgPush_PB_C2CPush:fromUin:");
            sb5.append(j17);
            sb5.append(",toUin:");
            sb5.append(j18);
            sb5.append(",msgTime:");
            sb5.append(j26);
            sb5.append(",msgSeq:");
            sb5.append(j19);
            sb5.append(",msgUid:");
            sb5.append(j27);
            sb5.append(",userActive:");
            sb5.append(i3);
            sb5.append(",fromInstid:");
            sb5.append(i16);
            sb5.append(",hasAppShare:");
            sb5.append(msg_comm_msg.appshare_info.has());
            sb5.append(",hasMsgBody:");
            sb5.append(msg_comm_msg.msg_body.has());
            str = "Q.msg.C2CMessageProcessor";
            QLog.d(str, 2, sb5.toString());
        } else {
            msg_comm_msghead = msg_comm_msghead2;
            str = "Q.msg.C2CMessageProcessor";
        }
        V0(i3);
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        try {
            j3 = j17;
        } catch (Exception e16) {
            e = e16;
            j3 = j17;
        }
        try {
            com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(longValue, j17, true, false, false, false);
            aVar.f286161p = true;
            list = L(msg_comm_msg, aVar);
        } catch (Exception e17) {
            e = e17;
            e.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.w(str, 2, "handleMsgPush_PB_C2CPush decodeSinglePBMsg_C2C error,", e);
            }
            list = null;
            H(list);
            if (list == null) {
            } else {
                return;
            }
        }
        H(list);
        if (list == null && list.size() != 0) {
            j(list, arrayList, true);
            ArrayList<DelMsgInfo> arrayList2 = new ArrayList<>();
            ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
            U(arrayList, arrayList2, arrayList3);
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).C(arrayList3);
            boolean hasRecvAndUnreadMsg = BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList3);
            int j28 = ad.j(arrayList, (com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache());
            IMessageFacade iMessageFacade = (IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "");
            String valueOf = String.valueOf(longValue);
            if (hasRecvAndUnreadMsg && this.f116342a.isBackgroundStop) {
                z16 = true;
            } else {
                z16 = false;
            }
            iMessageFacade.addMessage(arrayList3, valueOf, z16);
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).L1(msg_comm_msghead.msg_seq.get());
            int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
            String stringUtf8 = msg_onlinepush_pbpushmsg.bytes_push_token.get().toStringUtf8();
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "----------handleMsgPush_PB_C2CPush get Push token = ", stringUtf8, " and use ", BaseConstants.CMD_RESPPUSH, " send back to server");
            }
            this.f116343b.delC2COnlinePushMsg(j3, arrayList2, msg_onlinepush_pbpushmsg.svrip.get(), requestSsoSeq, msg_onlinepush_pbpushmsg);
            if (j16 == 127) {
                return;
            }
            n("handleMsgPush_PB_C2CPush", true, j28, this.f116343b.needNotifyNotification(hasRecvAndUnreadMsg), false);
            f116677y.x(arrayList3, this);
        }
    }

    private void E(String str, boolean z16, ArrayList<MessageRecord> arrayList, String str2, int i3) {
        f116677y.h(str, z16, arrayList, str2, i3, this);
    }

    private void F(ArrayList<MessageRecord> arrayList) {
        f116677y.E(arrayList, this);
    }

    private void F0(int i3, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            D0((msg_comm$Msg) objArr[0], (FromServiceMsg) objArr[1], (msg_onlinepush$PbPushMsg) objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    private void G(ArrayList<MessageRecord> arrayList, String str) {
        f116677y.j(arrayList, this, str);
    }

    private void G0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ToServiceMsg toServiceMsg2;
        msg_svc$PbGetOneDayRoamMsgResp msg_svc_pbgetonedayroammsgresp;
        ArrayList<MessageRecord> arrayList;
        long j3;
        ArrayList<MessageRecord> arrayList2;
        int i3;
        long j16;
        long j17;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
        }
        ArrayList<MessageRecord> arrayList3 = null;
        try {
            toServiceMsg2 = toServiceMsg;
            msg_svc_pbgetonedayroammsgresp = new msg_svc$PbGetOneDayRoamMsgResp().mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            toServiceMsg2 = toServiceMsg;
            msg_svc_pbgetonedayroammsgresp = null;
        }
        Bundle bundle = toServiceMsg2.extraData.getBundle("context");
        if (msg_svc_pbgetonedayroammsgresp != null) {
            int i16 = msg_svc_pbgetonedayroammsgresp.result.get();
            List<msg_comm$Msg> list = msg_svc_pbgetonedayroammsgresp.f417535msg.get();
            ArrayList arrayList4 = new ArrayList();
            o0(list, arrayList4);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + i16 + ", complete=" + msg_svc_pbgetonedayroammsgresp.iscomplete.get() + " ,respRandom:" + msg_svc_pbgetonedayroammsgresp.random.get() + ", lastMsgTime:" + msg_svc_pbgetonedayroammsgresp.last_msgtime.get() + ", msgList.size()=" + arrayList4.size() + ", context" + bundle);
            }
            if (i16 == 0) {
                ArrayList<MessageRecord> arrayList5 = new ArrayList<>();
                try {
                    List<MessageRecord> W = W(msg_svc_pbgetonedayroammsgresp.peer_uin.get() + "", arrayList4);
                    if (W != null) {
                        arrayList5.addAll(W);
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", e17);
                    }
                }
                long j18 = msg_svc_pbgetonedayroammsgresp.peer_uin.get();
                if (!arrayList4.isEmpty()) {
                    msg_comm$Msg msg_comm_msg = arrayList4.get(0);
                    arrayList2 = arrayList5;
                    j16 = a0(msg_comm_msg.msg_head.get().from_uin.get(), msg_comm_msg.msg_head.get().to_uin.get(), msg_svc_pbgetonedayroammsgresp.peer_uin.get());
                    i3 = 0;
                } else {
                    arrayList2 = arrayList5;
                    i3 = 0;
                    j16 = j18;
                }
                com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(Long.parseLong(this.f116342a.getCurrentAccountUin()), j16, true, true, false, false);
                aVar.f286161p = true;
                I0(arrayList4, null, arrayList2, aVar);
                if (arrayList2.size() > 0) {
                    Collections.sort(arrayList2, new c());
                    arrayList3 = arrayList2;
                    j17 = arrayList2.get(i3).time;
                } else {
                    j17 = 0;
                }
                arrayList = arrayList3;
                j3 = j17;
            } else {
                if (i16 == 1 && QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
                }
                arrayList = null;
                j3 = 0;
            }
            J0(msg_svc_pbgetonedayroammsgresp, bundle, arrayList, j3, i16);
        }
    }

    private void H(List<MessageRecord> list) {
        f116677y.C(list);
    }

    private void H0(int i3, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            G0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    private void I(List<msg_comm$Msg> list) {
        f116677y.s(list.get(0).msg_head.get().from_uin.get(), this);
    }

    private void I0(List<msg_comm$Msg> list, List<MessageRecord> list2, ArrayList<MessageRecord> arrayList, com.tencent.mobileqq.service.message.a aVar) {
        Iterator<msg_comm$Msg> it = list.iterator();
        while (it.hasNext()) {
            try {
                list2 = L(it.next(), aVar);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", e16);
                }
            }
            if (list2 != null && list2.size() > 0) {
                arrayList.addAll(list2);
            }
        }
    }

    public static boolean J(StringBuilder sb5, int i3, boolean z16, long j3, long j16, AppInterface appInterface) {
        long M0 = ((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).M0(String.valueOf(j16), 0);
        if (j3 > M0 || !z16) {
            return false;
        }
        if (QLog.isColorLevel()) {
            sb5.setLength(0);
            sb5.append("<---decodeC2CMessagePackage : msgList[");
            sb5.append(i3);
            sb5.append("] : filter msg by del time delTime =");
            sb5.append(M0);
            sb5.append(", msgTime = ");
            sb5.append(j3);
            QLog.d("Q.msg.C2CMessageProcessor", 2, sb5.toString());
            return true;
        }
        return true;
    }

    private void J0(msg_svc$PbGetOneDayRoamMsgResp msg_svc_pbgetonedayroammsgresp, Bundle bundle, ArrayList<MessageRecord> arrayList, long j3, int i3) {
        boolean z16;
        if (bundle != null) {
            long j16 = bundle.getLong(NowProxyConstants.AccountInfoKey.UID, 0L);
            boolean z17 = true;
            boolean z18 = bundle.getBoolean("canUpdateEct", true);
            if (msg_svc_pbgetonedayroammsgresp.iscomplete.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 != 0 && i3 != 1 && i3 != 4) {
                z17 = false;
            }
            if (z17 && z18) {
                if (z16) {
                    ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).j(String.valueOf(j16), 0L, 0L);
                } else {
                    ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).j(String.valueOf(msg_svc_pbgetonedayroammsgresp.peer_uin.get()), msg_svc_pbgetonedayroammsgresp.last_msgtime.get(), msg_svc_pbgetonedayroammsgresp.random.get());
                }
            } else if (!z18) {
                if (z16) {
                    bundle.putLong("tempEct", 0L);
                    bundle.putLong("tempRandom", 0L);
                } else {
                    bundle.putLong("tempEct", msg_svc_pbgetonedayroammsgresp.last_msgtime.get());
                    bundle.putLong("tempRandom", msg_svc_pbgetonedayroammsgresp.random.get());
                }
            }
            bundle.putBoolean("complete", z16);
            bundle.putBoolean("success", z17);
            bundle.putLong("lowTime", j3);
            ArrayList arrayList2 = new ArrayList();
            try {
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).handleRefreshMessageListHeadResult(String.valueOf(msg_svc_pbgetonedayroammsgresp.peer_uin.get()), 0, arrayList, arrayList2, bundle);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (arrayList != null) {
                f116677y.x(arrayList2, this);
            }
        }
    }

    private Pair<String, Integer> K(msg_comm$UinPairMsg msg_comm_uinpairmsg, long j3, boolean z16, boolean z17, boolean z18, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z19;
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        long longAccountUin = this.f116342a.getLongAccountUin();
        String currentAccountUin = this.f116342a.getCurrentAccountUin();
        com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(longAccountUin, msg_comm_uinpairmsg.peer_uin.get(), true, z17, z18, false);
        aVar.f286167v = String.valueOf(msg_comm_uinpairmsg.peer_uin.get());
        List<msg_comm$Msg> list = msg_comm_uinpairmsg.f417532msg.get();
        if (list != null && list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            o0(list, arrayList2);
            StringBuilder sb5 = new StringBuilder();
            HashMap<Long, msg_comm$Msg> hashMap = new HashMap<>();
            HashSet<Long> hashSet = new HashSet<>();
            boolean z26 = true;
            aVar.f286158m = true;
            aVar.b(1000, hashMap);
            aVar.b(1001, hashSet);
            int i3 = 0;
            while (i3 < arrayList2.size()) {
                int i16 = i3;
                M(this, msg_comm_uinpairmsg, j3, arrayList, aVar, arrayList2, sb5, i16);
                i3 = i16 + 1;
                hashSet = hashSet;
                longAccountUin = longAccountUin;
                z26 = z26;
                arrayList = arrayList;
                arrayList2 = arrayList2;
                currentAccountUin = currentAccountUin;
            }
            boolean z27 = z26;
            String str = currentAccountUin;
            ArrayList<MessageRecord> arrayList3 = arrayList;
            aVar.f286167v = V(String.valueOf(msg_comm_uinpairmsg.peer_uin.get()), aVar.f286167v);
            m0(longAccountUin, hashMap, hashSet);
            G(arrayList3, aVar.f286167v);
            if (arrayList3.size() > 0) {
                b(toServiceMsg, arrayList3);
                if (!z17) {
                    ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).C(arrayList3);
                }
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setAutoPullC2CMsgResult(aVar.f286167v, 0, arrayList3, z16);
                boolean q06 = q0(arrayList3);
                int j16 = ad.j(arrayList3, (com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache());
                F(arrayList3);
                IMessageFacade iMessageFacade = (IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "");
                if (q06 && this.f116342a.isBackgroundStop) {
                    z19 = z27;
                } else {
                    z19 = false;
                }
                iMessageFacade.addMessage(arrayList3, str, z19);
                D(arrayList3);
                n("handleGetBuddyMessageResp", true, j16, q06, z17);
                f116677y.n(arrayList3, toServiceMsg, fromServiceMsg);
                E(String.valueOf(msg_comm_uinpairmsg.peer_uin.get()), z17, arrayList3, aVar.f286167v, aVar.f286168w);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 4, "<---decodeC2CMessagePackage : dstUin:" + aVar.f286167v + ", pkgUinType:" + aVar.f286168w);
            }
            return new Pair<>(aVar.f286167v, Integer.valueOf(aVar.f286168w));
        }
        return new Pair<>(aVar.f286167v, Integer.valueOf(aVar.f286168w));
    }

    private void K0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbGetRoamMsgResp msg_svc_pbgetroammsgresp = null;
        try {
            msg_svc_pbgetroammsgresp = new msg_svc$PbGetRoamMsgResp().mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", e16);
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", e17);
            }
        }
        Long valueOf = Long.valueOf(toServiceMsg.extraData.getLong("lBeginTime"));
        boolean z16 = toServiceMsg.extraData.getBoolean("fetchMore");
        int i3 = toServiceMsg.extraData.getInt("fetchNum");
        boolean z17 = toServiceMsg.extraData.getBoolean(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE);
        boolean z18 = toServiceMsg.extraData.getBoolean("notify", true);
        Bundle bundle = new Bundle();
        bundle.putLong("BEGTIME", valueOf.longValue());
        bundle.putBoolean("FETCH_MORE", z16);
        bundle.putInt("MSG_COUNT", i3);
        bundle.putString("PEER_UIN", toServiceMsg.extraData.getString("peerUin"));
        bundle.putBoolean("IS_PRELOAD_TYPE", z17);
        if (msg_svc_pbgetroammsgresp != null) {
            String valueOf2 = String.valueOf(msg_svc_pbgetroammsgresp.peer_uin.get());
            int i16 = msg_svc_pbgetroammsgresp.result.get();
            List<msg_comm$Msg> list = msg_svc_pbgetroammsgresp.f417536msg.get();
            if (list == null) {
                this.f116343b.roamCache.remove(valueOf2);
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + i16 + ", msgList is null !");
                }
                l(1004, false, bundle);
                return;
            }
            List<msg_comm$Msg> arrayList = new ArrayList<>();
            o0(list, arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + valueOf + ", code=" + i16 + " ,errMsg=" + msg_svc_pbgetroammsgresp.errmsg.get() + ", msgList.size()=" + arrayList.size() + ",peerUin=" + valueOf2 + ",time=" + msg_svc_pbgetroammsgresp.last_msgtime.get() + ",fetchMore:" + z16 + ",fetchNum: " + i3);
            }
            h0(toServiceMsg, msg_svc_pbgetroammsgresp, valueOf, i3, z17, z18, bundle, valueOf2, i16, arrayList);
            return;
        }
        l(1004, false, bundle);
    }

    private long L0(msg_svc$PbGetRoamMsgResp msg_svc_pbgetroammsgresp, ArrayList<msg_comm$Msg> arrayList, long j3) {
        if (!arrayList.isEmpty()) {
            msg_comm$Msg msg_comm_msg = arrayList.get(0);
            return a0(msg_comm_msg.msg_head.get().from_uin.get(), msg_comm_msg.msg_head.get().to_uin.get(), msg_svc_pbgetroammsgresp.peer_uin.get());
        }
        return j3;
    }

    private static void M(i iVar, msg_comm$UinPairMsg msg_comm_uinpairmsg, long j3, ArrayList<MessageRecord> arrayList, com.tencent.mobileqq.service.message.a aVar, ArrayList<msg_comm$Msg> arrayList2, StringBuilder sb5, int i3) {
        f116677y.y(iVar, msg_comm_uinpairmsg, j3, arrayList, arrayList2, sb5, aVar, i3);
    }

    private void M0(int i3, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            K0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    private void N(ArrayList<msg_comm$Msg> arrayList, ArrayList<MessageRecord> arrayList2, com.tencent.mobileqq.service.message.a aVar) {
        Iterator<msg_comm$Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                List<MessageRecord> L = L(it.next(), aVar);
                if (L != null && !L.isEmpty()) {
                    arrayList2.addAll(L);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", e16);
                }
            }
        }
    }

    private void N0(int i3, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            O0((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    private void O(msg_comm$Msg msg_comm_msg, ArrayList<MessageRecord> arrayList, com.tencent.mobileqq.service.message.a aVar, BaseMessageHandler baseMessageHandler) {
        Iterator<com.tencent.mobileqq.service.message.codec.decoder.d> it = ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).getRegistry().h().getInstances().iterator();
        while (it.hasNext()) {
            it.next().a(baseMessageHandler, msg_comm_msg, arrayList, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbSearchRoamMsgInCloudResp msg_svc_pbsearchroammsgincloudresp;
        int i3 = toServiceMsg.extraData.getInt("loadType");
        HashMap<String, Object> hashMap = new HashMap<>(1);
        hashMap.put("KEYWORD", toServiceMsg.extraData.getString("keyword"));
        hashMap.put("SEARCHSEQUENCE", Long.valueOf(toServiceMsg.extraData.getLong("sequence")));
        hashMap.put("LOADTYPE", Integer.valueOf(i3));
        try {
            msg_svc_pbsearchroammsgincloudresp = new msg_svc$PbSearchRoamMsgInCloudResp().mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud InvalidProtocolBufferMicroException ! ", e16);
            }
            msg_svc_pbsearchroammsgincloudresp = null;
            if (msg_svc_pbsearchroammsgincloudresp != null) {
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud OutOfMemoryError ! ", e17);
            }
            msg_svc_pbsearchroammsgincloudresp = null;
            if (msg_svc_pbsearchroammsgincloudresp != null) {
            }
        }
        if (msg_svc_pbsearchroammsgincloudresp != null) {
            oidb_c2c_searcher$RspBody c06 = c0(msg_svc_pbsearchroammsgincloudresp, new oidb_c2c_searcher$RspBody());
            if (c06 == null) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.C2CMessageProcessor", 2, "<----processSearchRoamMsgInCloud error oidb_search null----> ");
                }
                l0(toServiceMsg, fromServiceMsg, false);
                return;
            }
            int i16 = c06.result.get();
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud result--------->>>>>> " + i16 + ", loadType: " + i3);
            }
            if (i16 != 0 && i16 != 1) {
                l0(toServiceMsg, fromServiceMsg, false);
            } else {
                k0(msg_svc_pbsearchroammsgincloudresp, c06, i16, toServiceMsg, i3, hashMap);
            }
        }
    }

    private void P(int i3, msg_comm$Msg msg_comm_msg, ArrayList<MessageRecord> arrayList, BaseMessageHandler baseMessageHandler, com.tencent.mobileqq.service.message.a aVar) {
        com.tencent.mobileqq.service.message.codec.decoder.d T = T(i3);
        if (T != null) {
            T.a(baseMessageHandler, msg_comm_msg, arrayList, aVar);
        }
    }

    private void P0(msg_comm$Msg msg_comm_msg, FromServiceMsg fromServiceMsg, msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg) {
        i iVar;
        long j3;
        long j16;
        String str;
        String uin;
        msg_comm$MsgHead msg_comm_msghead;
        String str2;
        List<MessageRecord> list;
        msg_comm$MsgHead msg_comm_msghead2 = msg_comm_msg.msg_head.get();
        if (!msg_comm_msghead2.c2c_cmd.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
                return;
            }
            return;
        }
        long j17 = msg_comm_msghead2.c2c_cmd.get();
        long j18 = msg_comm_msghead2.from_uin.get();
        long j19 = msg_comm_msghead2.to_uin.get();
        long j26 = msg_comm_msghead2.msg_seq.get();
        long j27 = msg_comm_msghead2.msg_time.get();
        long j28 = msg_comm_msghead2.msg_uid.get();
        int i3 = msg_comm_msghead2.user_active.get();
        int i16 = msg_comm_msghead2.from_instid.get();
        if (fromServiceMsg.getUin() == null) {
            iVar = this;
            j3 = j17;
            j16 = j28;
            str = "Q.msg.C2CMessageProcessor";
            uin = iVar.f116342a.getCurrentAccountUin();
        } else {
            iVar = this;
            j3 = j17;
            j16 = j28;
            str = "Q.msg.C2CMessageProcessor";
            uin = fromServiceMsg.getUin();
        }
        long longValue = Long.valueOf(uin).longValue();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            msg_comm_msghead = msg_comm_msghead2;
            sb5.append("<---handleMsgPush_PB_SlaveMaster:fromUin:");
            sb5.append(j18);
            sb5.append(",toUin:");
            sb5.append(j19);
            sb5.append(",msgTime:");
            sb5.append(j27);
            sb5.append(",msgSeq:");
            sb5.append(j26);
            sb5.append(",msgUid:");
            sb5.append(j16);
            sb5.append(",userActive:");
            sb5.append(i3);
            sb5.append(",fromInstid:");
            sb5.append(i16);
            sb5.append(",hasAppShare:");
            sb5.append(msg_comm_msg.appshare_info.has());
            sb5.append(",hasMsgBody:");
            sb5.append(msg_comm_msg.msg_body.has());
            str2 = str;
            QLog.d(str2, 2, sb5.toString());
        } else {
            msg_comm_msghead = msg_comm_msghead2;
            str2 = str;
        }
        iVar.V0(i3);
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        try {
            com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(longValue, j19, true, false, false, false);
            aVar.f286161p = true;
            list = iVar.L(msg_comm_msg, aVar);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(str2, 2, "decodeSinglePBMsg_C2C error,", e16);
            }
            list = null;
        }
        iVar.H(list);
        if (list != null && list.size() != 0) {
            iVar.j(list, arrayList, true);
            ArrayList<DelMsgInfo> arrayList2 = new ArrayList<>();
            ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
            f a16 = new f(this, msg_comm_msg, arrayList, false, null, arrayList2, arrayList3).a();
            boolean z16 = a16.f116687c;
            String str3 = a16.f116688d;
            ((com.tencent.mobileqq.service.message.e) iVar.f116342a.getMsgCache()).C(arrayList3);
            ((IMessageFacade) iVar.f116342a.getRuntimeService(IMessageFacade.class, "")).addMessage(arrayList3, String.valueOf(longValue), false);
            ((com.tencent.mobileqq.service.message.e) iVar.f116342a.getMsgCache()).L1(msg_comm_msghead.msg_seq.get());
            iVar.f116343b.delC2COnlinePushMsg(j18, arrayList2, msg_onlinepush_pbpushmsg.svrip.get(), fromServiceMsg.getRequestSsoSeq(), null);
            if (j3 == 127) {
                return;
            }
            n("handleMsgPush_PB_SlaveMaster", true, 0, iVar.f116343b.needNotifyNotification(false), false);
            f116677y.x(arrayList3, iVar);
            if (z16 && !TextUtils.isEmpty(str3)) {
                iVar.n0(str3);
            }
        }
    }

    private Pair<List<MessageRecord>, List<MessageRecord>> Q(List<msg_comm$Msg> list, List<MessageRecord> list2, long j3, long j16, long j17) {
        ArrayList arrayList = new ArrayList();
        List<MessageRecord> X = X(j3, j16, j17);
        if (X != null && !X.isEmpty()) {
            Iterator<msg_comm$Msg> it = list.iterator();
            while (true) {
                int i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                msg_comm$Msg next = it.next();
                if (!next.msg_head.has()) {
                    it.remove();
                } else {
                    msg_comm$MsgHead msg_comm_msghead = next.msg_head.get();
                    long j18 = msg_comm_msghead.msg_uid.get();
                    long j19 = (short) msg_comm_msghead.msg_seq.get();
                    while (true) {
                        if (i3 < X.size()) {
                            MessageRecord messageRecord = X.get(i3);
                            if (messageRecord.msgUid == j18 && messageRecord.shmsgseq == j19) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + messageRecord);
                                }
                                arrayList.add(messageRecord);
                                it.remove();
                            } else {
                                i3++;
                            }
                        }
                    }
                }
            }
            Iterator<MessageRecord> it5 = list2.iterator();
            while (it5.hasNext()) {
                MessageRecord next2 = it5.next();
                int i16 = 0;
                while (true) {
                    if (i16 < X.size()) {
                        MessageRecord messageRecord2 = X.get(i16);
                        if (messageRecord2.msgUid == next2.msgUid && messageRecord2.shmsgseq == next2.shmsgseq) {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + next2);
                            }
                            it5.remove();
                        } else {
                            i16++;
                        }
                    }
                }
            }
        }
        return new Pair<>(arrayList, list2);
    }

    private void Q0(int i3, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            P0((msg_comm$Msg) objArr[0], (FromServiceMsg) objArr[1], (msg_onlinepush$PbPushMsg) objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    private int R() {
        return f116677y.r(this);
    }

    private void R0(long j3) {
        f116677y.t(j3);
    }

    private void S0(String str, int i3) {
        f116677y.z(str, i3);
    }

    private void U(ArrayList<MessageRecord> arrayList, ArrayList<DelMsgInfo> arrayList2, ArrayList<MessageRecord> arrayList3) {
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                MessageRecord messageRecord = arrayList.get(i3);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: " + messageRecord.senderuin + " mr.msgtype: " + messageRecord.msgtype + " mr.frienduin: " + messageRecord.frienduin + " mr.shmsgseq: " + messageRecord.shmsgseq + " mr.time:" + messageRecord.time + " mr.msg: " + messageRecord.getLogColorContent());
                }
                String str = messageRecord.frienduin;
                if (str != null && str.length() > 2) {
                    messageRecord.isread = false;
                    arrayList3.add(messageRecord);
                    DelMsgInfo delMsgInfo = new DelMsgInfo();
                    delMsgInfo.lFromUin = Long.parseLong(messageRecord.senderuin);
                    delMsgInfo.shMsgSeq = (short) messageRecord.shmsgseq;
                    delMsgInfo.uMsgTime = messageRecord.time;
                    arrayList2.add(delMsgInfo);
                }
            }
        }
    }

    public static void U0(e eVar) {
        f116677y = eVar;
    }

    private String V(String str, String str2) {
        if (str2 != null && !str2.equals("0")) {
            return str2;
        }
        return str;
    }

    private void V0(int i3) {
        f116677y.q(i3, this);
    }

    private List<MessageRecord> W(String str, List<msg_comm$Msg> list) {
        return f116677y.f(str, list, this);
    }

    private void W0(byte[] bArr, byte[] bArr2, int i3) {
        com.tencent.mobileqq.service.message.e eVar = (com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    eVar.Q1(bArr2);
                    this.f116343b.setPAMsgGetting(false);
                    return;
                }
                return;
            }
            eVar.R1(bArr);
            this.f116343b.setMsgGetting(false);
            return;
        }
        eVar.R1(bArr);
        eVar.Q1(bArr);
        this.f116343b.setMsgGetting(false);
        this.f116343b.setPAMsgGetting(false);
    }

    private List<MessageRecord> X(long j3, long j16, long j17) {
        return f116677y.i(String.valueOf(j3), j16 - 30, j17 + 30, this);
    }

    private void X0(ToServiceMsg toServiceMsg, String str) {
        f116677y.B(str, toServiceMsg.extraData.getLong("lBeginTime"), 3, this);
    }

    @NonNull
    private String Y(msg_comm$UinPairMsg msg_comm_uinpairmsg, int i3) {
        return f116677y.b(msg_comm_uinpairmsg, this.f116342a, i3);
    }

    private String Z(String str) {
        return f116677y.m(str, this);
    }

    private long a0(long j3, long j16, long j17) {
        return f116677y.p(this.f116342a, j3, j16, j17);
    }

    private int b0(byte b16, msg_comm$UinPairMsg msg_comm_uinpairmsg, String str, int i3) {
        IMessageFacade iMessageFacade = (IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "");
        if (msg_comm_uinpairmsg.c2c_type.has() && msg_comm_uinpairmsg.service_type.has()) {
            int i16 = msg_comm_uinpairmsg.c2c_type.get();
            int i17 = msg_comm_uinpairmsg.service_type.get();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + str + "c2cType:" + i16 + " serviceType:" + i17 + " channelType:" + ((int) b16));
            }
            if (i16 == 1 && i17 == 130) {
                return 1006;
            }
            if (i16 == 1 && i17 == 164) {
                return 10007;
            }
            if (i16 == 2 && i17 == 0) {
                return 1000;
            }
            if (i16 == 2 && i17 == 1) {
                return 1004;
            }
            if (i16 == 1 && i17 == 133) {
                return 1023;
            }
            if (i16 == 1 && i17 == 134) {
                return 1022;
            }
            if (i16 == 1 && i17 == 167) {
                return 10010;
            }
            if (i16 == 1 && i17 == 172) {
                return 1046;
            }
            return iMessageFacade.getLastMessage(str, i3).istroop;
        }
        return iMessageFacade.getLastMessage(str, i3).istroop;
    }

    @Nullable
    private oidb_c2c_searcher$RspBody c0(msg_svc$PbSearchRoamMsgInCloudResp msg_svc_pbsearchroammsgincloudresp, oidb_c2c_searcher$RspBody oidb_c2c_searcher_rspbody) {
        if (!msg_svc_pbsearchroammsgincloudresp.serialize_rspbody.has()) {
            return null;
        }
        try {
            return oidb_c2c_searcher_rspbody.mergeFrom(msg_svc_pbsearchroammsgincloudresp.serialize_rspbody.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud InvalidProtocolBufferMicroException oidb_search! ", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud OutOfMemoryError ! oidb_search!", e17);
            return null;
        }
    }

    private byte[] d0() {
        return f116677y.w(this);
    }

    private long e0(int i3, int i16) {
        return f116677y.o(i3, i16);
    }

    private void f0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putLong("BEGTIME", toServiceMsg.extraData.getLong("lBeginTime"));
        bundle.putBoolean("FETCH_MORE", toServiceMsg.extraData.getBoolean("fetchMore"));
        l(1004, false, bundle);
    }

    private void g0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        bundle.putLong("BEGTIME", toServiceMsg.extraData.getLong("lBeginTime"));
        bundle.putBoolean("FETCH_MORE", toServiceMsg.extraData.getBoolean("fetchMore"));
        l(1004, false, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void h0(ToServiceMsg toServiceMsg, msg_svc$PbGetRoamMsgResp msg_svc_pbgetroammsgresp, Long l3, int i3, boolean z16, boolean z17, Bundle bundle, String str, int i16, List<msg_comm$Msg> list) {
        int i17;
        int i18;
        String str2;
        String str3;
        Bundle bundle2;
        boolean z18;
        if (i16 != 0 && i16 != 1) {
            i18 = 1004;
            z18 = false;
            str3 = str;
            bundle2 = bundle;
        } else {
            try {
                long j3 = msg_svc_pbgetroammsgresp.last_msgtime.get();
                long j16 = toServiceMsg.extraData.getLong("lEndTime");
                if (i16 == 0) {
                    A(str, list);
                    this.f116343b.getRoamMsgByTime(str, l3.longValue(), j3, j16, (short) 0, msg_svc_pbgetroammsgresp.random.get(), 1, d0(), R(), toServiceMsg.extraData.getBoolean("fetchMore"), i3, z16, z17);
                    return;
                }
                ArrayList<msg_comm$Msg> arrayList = new ArrayList<>(list);
                if (this.f116343b.roamCache.containsKey(str)) {
                    arrayList.addAll(this.f116343b.roamCache.get(str));
                    this.f116343b.roamCache.remove(str);
                }
                if (arrayList.isEmpty()) {
                    bundle.putBoolean("NO_MSG", true);
                    l(1004, false, bundle);
                    return;
                }
                long j17 = toServiceMsg.extraData.getLong("lBeginTime");
                ArrayList<msg_comm$Msg> arrayList2 = new ArrayList<>();
                try {
                    z(arrayList, j17, j16, arrayList2);
                    List<MessageRecord> W = W(str, arrayList2);
                    ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
                    long L0 = L0(msg_svc_pbgetroammsgresp, arrayList2, Long.parseLong(str));
                    try {
                        arrayList3.addAll((Collection) Q(arrayList2, W, L0, l3.longValue(), j16).second);
                        com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(Long.parseLong(this.f116342a.getCurrentAccountUin()), L0, true, true, false, false);
                        aVar.f286161p = true;
                        N(arrayList2, arrayList3, aVar);
                        C(z17, str, arrayList3);
                        Pair<Long, Long> m06 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).m0(String.valueOf(msg_svc_pbgetroammsgresp.peer_uin.get()));
                        if (m06 == null || ((Long) m06.first).longValue() > j3) {
                            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).j(String.valueOf(msg_svc_pbgetroammsgresp.peer_uin.get()), toServiceMsg.extraData.getLong("lBeginTime"), 0L);
                        }
                        X0(toServiceMsg, str);
                        if (!QLog.isColorLevel()) {
                            str2 = "Q.msg.C2CMessageProcessor";
                            i17 = 2;
                        } else {
                            try {
                                str2 = "Q.msg.C2CMessageProcessor";
                                i17 = 2;
                                try {
                                    QLog.w(str2, 2, "handlePBGetRoamMsg resList size = " + arrayList.size() + ", dayList size = " + arrayList2.size() + ", loopList size=" + arrayList3.size());
                                } catch (Exception e16) {
                                    e = e16;
                                    bundle2 = bundle;
                                    str3 = str;
                                    i18 = 1004;
                                    e.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                } catch (OutOfMemoryError e17) {
                                    e = e17;
                                    bundle2 = bundle;
                                    str3 = str;
                                    i18 = 1004;
                                    e.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                }
                            } catch (Exception e18) {
                                e = e18;
                                str2 = "Q.msg.C2CMessageProcessor";
                                i17 = 2;
                                bundle2 = bundle;
                                str3 = str;
                                i18 = 1004;
                                e.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.w(str2, i17, "handlePBGetRoamMsg exception ! ", e);
                                }
                                z18 = false;
                                if (!z18) {
                                }
                            } catch (OutOfMemoryError e19) {
                                e = e19;
                                str2 = "Q.msg.C2CMessageProcessor";
                                i17 = 2;
                                bundle2 = bundle;
                                str3 = str;
                                i18 = 1004;
                                e.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.w(str2, i17, "handlePBGetRoamMsg OutOfMemoryError ! ", e);
                                }
                                z18 = false;
                                if (!z18) {
                                }
                            }
                        }
                        bundle2 = bundle;
                        str3 = str;
                    } catch (Exception e26) {
                        e = e26;
                        bundle2 = bundle;
                        str3 = str;
                        str2 = "Q.msg.C2CMessageProcessor";
                        i17 = 2;
                        i18 = 1004;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        z18 = false;
                        if (!z18) {
                        }
                    } catch (OutOfMemoryError e27) {
                        e = e27;
                        bundle2 = bundle;
                        str3 = str;
                        str2 = "Q.msg.C2CMessageProcessor";
                        i17 = 2;
                        i18 = 1004;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        z18 = false;
                        if (!z18) {
                        }
                    }
                    try {
                        bundle2.putInt("MSG_COUNT", i3 - arrayList3.size());
                        i18 = 1004;
                        try {
                            l(1004, true, bundle2);
                            z18 = true;
                        } catch (Exception e28) {
                            e = e28;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            z18 = false;
                            if (!z18) {
                            }
                        } catch (OutOfMemoryError e29) {
                            e = e29;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            z18 = false;
                            if (!z18) {
                            }
                        }
                    } catch (Exception e36) {
                        e = e36;
                        i18 = 1004;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        z18 = false;
                        if (!z18) {
                        }
                    } catch (OutOfMemoryError e37) {
                        e = e37;
                        i18 = 1004;
                        e.printStackTrace();
                        if (QLog.isColorLevel()) {
                        }
                        z18 = false;
                        if (!z18) {
                        }
                    }
                } catch (Exception e38) {
                    e = e38;
                    str3 = str;
                    bundle2 = bundle;
                } catch (OutOfMemoryError e39) {
                    e = e39;
                    str3 = str;
                    bundle2 = bundle;
                }
            } catch (Exception e46) {
                e = e46;
                i17 = 2;
                i18 = 1004;
                str2 = "Q.msg.C2CMessageProcessor";
                str3 = str;
                bundle2 = bundle;
            } catch (OutOfMemoryError e47) {
                e = e47;
                i17 = 2;
                i18 = 1004;
                str2 = "Q.msg.C2CMessageProcessor";
                str3 = str;
                bundle2 = bundle;
            }
        }
        if (!z18) {
            this.f116343b.roamCache.remove(str3);
            bundle2.putInt("SVR_CODE", i16);
            if (msg_svc_pbgetroammsgresp.errmsg.has()) {
                bundle2.putString("SVR_MSG", msg_svc_pbgetroammsgresp.errmsg.get());
            }
            l(i18, false, bundle2);
        }
    }

    private void i0(C2CMsgReadedNotify c2CMsgReadedNotify, String str) {
        f116677y.A(this.f116342a, str, c2CMsgReadedNotify);
    }

    private void j0(ArrayList<msg_comm$Msg> arrayList, long j3, com.tencent.mobileqq.service.message.a aVar, ArrayList<MessageRecord> arrayList2) {
        String str;
        Iterator<msg_comm$Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            msg_comm$Msg next = it.next();
            if (next != null) {
                try {
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud decodeSinglePBMsg_C2C error,", e16);
                    }
                }
                if (next.msg_head.has() && next.msg_body.has()) {
                    msg_comm$MsgHead msg_comm_msghead = next.msg_head.get();
                    long j16 = msg_comm_msghead.to_uin.get();
                    long j17 = msg_comm_msghead.from_uin.get();
                    if (j16 != j3 && j17 != j3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C msg uin not selfUin and toUin : ");
                        }
                    } else {
                        if (j16 == j3) {
                            j16 = j17;
                        }
                        aVar.f286338a = j16;
                        List<MessageRecord> L = L(next, aVar);
                        if (L != null && !L.isEmpty()) {
                            arrayList2.addAll(L);
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("decodeSinglePBMsg_C2C return : ");
                if (next == null) {
                    str = " msg=null";
                } else {
                    str = " msg.msg_head:" + next.msg_head + " msg.msg_body:" + next.msg_body.has();
                }
                sb5.append(str);
                QLog.d("Q.msg.C2CMessageProcessor", 2, sb5.toString());
            }
        }
    }

    private void k0(msg_svc$PbSearchRoamMsgInCloudResp msg_svc_pbsearchroammsgincloudresp, oidb_c2c_searcher$RspBody oidb_c2c_searcher_rspbody, int i3, ToServiceMsg toServiceMsg, int i16, HashMap<String, Object> hashMap) {
        ArrayList<MessageRecord> arrayList;
        List<oidb_c2c_searcher$Iterator> list;
        List<msg_comm$Msg> list2 = msg_svc_pbsearchroammsgincloudresp.f417537msg.get();
        if (list2 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud pb error search result == null");
                return;
            }
            return;
        }
        ArrayList<msg_comm$Msg> arrayList2 = new ArrayList<>();
        o0(list2, arrayList2);
        long parseLong = Long.parseLong(this.f116342a.getCurrentAccountUin());
        com.tencent.mobileqq.service.message.a aVar = new com.tencent.mobileqq.service.message.a(parseLong, 0L, true, true, false, false);
        aVar.f286161p = true;
        ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
        j0(arrayList2, parseLong, aVar, arrayList3);
        if (arrayList3.size() > 0) {
            arrayList = arrayList3;
            Collections.sort(arrayList, new d());
        } else {
            arrayList = arrayList3;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud resultList size:" + list2.size() + ",outList size:" + arrayList2.size() + ",loopList size:" + arrayList.size());
        }
        if (oidb_c2c_searcher_rspbody.friends.has()) {
            list = oidb_c2c_searcher_rspbody.friends.get();
        } else {
            list = null;
        }
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo size:" + list.size());
            }
        } else if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud friendsInfo == null");
        }
        boolean z16 = false;
        if (arrayList.size() == 0 && i3 != 1) {
            int i17 = toServiceMsg.extraData.getInt("retryIndex");
            if (i17 < 4) {
                ((BaseMessageHandler) this.f116342a.getBusinessHandler("com.tencent.mobileqq.app.MessageHandler")).searchRoamMsgInCloud(i16, null, toServiceMsg.extraData.getString("keyword"), toServiceMsg.extraData.getLong("sequence"), list, i17 + 1, 0L);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.C2CMessageProcessor", 2, "processSearchRoamMsgInCloud retry extend 5 times, do not request again");
                }
                hashMap.put("SEARCHINFO", list);
                l(MessageHandlerConstants.NOTIFY_TYPE_ROAM_MESSAGE_SEARCH_IN_CLOUD, false, hashMap);
                return;
            }
        }
        hashMap.put("SEARCHINFO", list);
        hashMap.put("SEARCHRESULT", arrayList);
        if (i3 == 1) {
            z16 = true;
        }
        hashMap.put("SEARCHCOMPLETE", Boolean.valueOf(z16));
        l(MessageHandlerConstants.NOTIFY_TYPE_ROAM_MESSAGE_SEARCH_IN_CLOUD, true, hashMap);
    }

    private void l0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("KEYWORD", toServiceMsg.extraData.getString("keyword"));
        hashMap.put("SEARCHSEQUENCE", Long.valueOf(toServiceMsg.extraData.getLong("sequence")));
        hashMap.put("LOADTYPE", Integer.valueOf(toServiceMsg.extraData.getInt("loadType")));
        int i3 = toServiceMsg.extraData.getInt("retryIndex");
        if (!z16 && i3 < 2) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + i3);
            }
            toServiceMsg.extraData.putInt("retryIndex", i3 + 1);
            this.f116342a.getBusinessHandler("com.tencent.mobileqq.app.MessageHandler").sendPbReq(toServiceMsg);
            return;
        }
        l(MessageHandlerConstants.NOTIFY_TYPE_ROAM_MESSAGE_SEARCH_IN_CLOUD, false, hashMap);
    }

    private void m0(long j3, HashMap<Long, msg_comm$Msg> hashMap, HashSet<Long> hashSet) {
        if (!hashMap.isEmpty()) {
            Iterator<Long> it = hashSet.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                hashMap.remove(next);
                if (QLog.isColorLevel()) {
                    QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + next);
                }
            }
            Iterator<Long> it5 = hashMap.keySet().iterator();
            while (it5.hasNext()) {
                msg_comm$Msg msg_comm_msg = hashMap.get(it5.next());
                if (msg_comm_msg.msg_body.has()) {
                    msg_comm_msg.msg_body.get().msg_content.has();
                }
            }
        }
    }

    private void n0(String str) {
        f116677y.d(this.f116342a, str);
    }

    private void o0(List<msg_comm$Msg> list, List<msg_comm$Msg> list2) {
        super.h(list, list2);
    }

    private boolean p0(MessageRecord messageRecord) {
        return f116677y.u(messageRecord, this);
    }

    private void r0(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    l(4016, true, null);
                    return;
                }
                return;
            }
            l(4001, true, null);
            return;
        }
        l(4016, true, null);
        l(4001, true, null);
    }

    private void s0(String str, int i3, long j3) {
        f116677y.g(str, i3, j3, this);
    }

    @Nullable
    private msg_svc$PbGetMsgResp t0(byte[] bArr) {
        msg_svc$PbGetMsgResp msg_svc_pbgetmsgresp;
        try {
            msg_svc_pbgetmsgresp = new msg_svc$PbGetMsgResp().mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB : decode pb:", e16);
            }
            msg_svc_pbgetmsgresp = null;
        }
        if (msg_svc_pbgetmsgresp == null) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f116342a.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap<>(), "");
        }
        return msg_svc_pbgetmsgresp;
    }

    private void u0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Integer valueOf;
        int i3;
        byte b16;
        byte[] bArr;
        long j3;
        byte b17;
        String str;
        String str2;
        String str3;
        int i16;
        byte b18;
        boolean z16 = toServiceMsg.extraData.getBoolean("isPullRoamMsg", true);
        boolean z17 = toServiceMsg.extraData.getBoolean("needNofityConversation", true);
        boolean z18 = toServiceMsg.extraData.getBoolean("used_register_proxy", false);
        long currentTimeMillis = System.currentTimeMillis();
        msg_svc$PbGetMsgResp t06 = t0((byte[]) obj);
        StringBuilder sb5 = new StringBuilder();
        if (t06 != null && t06.result.has() && t06.result.get() == 0) {
            List<msg_comm$UinPairMsg> list = t06.uin_pair_msgs.get();
            this.f116343b.retryGetBuddyMsgCount(0);
            if (t06.sync_flag.has()) {
                i3 = t06.sync_flag.get();
            } else {
                i3 = 2;
            }
            if (i3 < 2) {
                b16 = (byte) 1;
            } else {
                b16 = 0;
            }
            if (t06.sync_cookie.has()) {
                bArr = t06.sync_cookie.get().toByteArray();
            } else {
                bArr = null;
            }
            int C0 = C0(t06, bArr);
            boolean handleMsgNew = this.f116343b.handleMsgNew();
            if (b16 > 0) {
                b17 = b16;
                i16 = 2;
                j3 = currentTimeMillis;
                str3 = "Q.msg.C2CMessageProcessor";
                str = "<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:";
                byte[] bArr2 = bArr;
                str2 = " msgStruct.cReplyCode: ";
                this.f116343b.getC2CMessage_PB(b17, bArr2, i3, z16, z17, handleMsgNew, null, C0, null);
            } else {
                j3 = currentTimeMillis;
                b17 = b16;
                str = "<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:";
                str2 = " msgStruct.cReplyCode: ";
                str3 = "Q.msg.C2CMessageProcessor";
                i16 = 2;
            }
            if (QLog.isColorLevel()) {
                sb5.setLength(0);
                sb5.append(str);
                sb5.append(toServiceMsg.getRequestSsoSeq());
                sb5.append(str2);
                sb5.append(t06.result.get());
                sb5.append(" hasSyncCookie:");
                sb5.append(t06.sync_cookie.has());
                sb5.append(" channelType:");
                b18 = b17;
                sb5.append((int) b18);
                sb5.append(" cSyncFlag:");
                sb5.append(i3);
                sb5.append(" isPullRoam");
                sb5.append(z16);
                sb5.append(",needNofityConversation:");
                sb5.append(z17);
                sb5.append(" uinPairMsg size:");
                sb5.append(list.size());
                sb5.append(", dataHash=@");
                sb5.append(Integer.toHexString(obj.hashCode()));
                sb5.append("pullMsgType");
                sb5.append(C0);
                QLog.d(str3, i16, sb5.toString());
            } else {
                b18 = b17;
            }
            String str4 = str3;
            long v06 = v0(b18, z16, z18, j3, sb5, list, C0, toServiceMsg, fromServiceMsg);
            int i17 = i16;
            x0(b18, z16, C0);
            long currentTimeMillis2 = System.currentTimeMillis() - v06;
            if (QLog.isColorLevel()) {
                QLog.d(str4, i17, "decodecMsg costTime = [" + currentTimeMillis2 + "]");
            }
            R0(currentTimeMillis2);
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.setLength(0);
            sb5.append("<PbGetMsg><R><---handleGetC2CMessageResp_PB ssoSeq:");
            sb5.append(toServiceMsg.getRequestSsoSeq());
            sb5.append(" msgStruct.cReplyCode: ");
            Object obj2 = "null";
            if (t06 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(t06.result.get());
            }
            sb5.append(valueOf);
            sb5.append(",hasSyncCookie:");
            if (t06 != null) {
                obj2 = Boolean.valueOf(t06.sync_cookie.has());
            }
            sb5.append(obj2);
            sb5.append(",isPullRoam:");
            sb5.append(z16);
            sb5.append(",needNofityConversation:");
            sb5.append(z17);
            QLog.e("Q.msg.C2CMessageProcessor", 2, sb5.toString());
        }
        this.f116343b.handleError(toServiceMsg, fromServiceMsg);
    }

    private long v0(byte b16, boolean z16, boolean z17, long j3, StringBuilder sb5, List<msg_comm$UinPairMsg> list, int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z18;
        List<msg_comm$Msg> list2;
        long j16;
        String str;
        int i16;
        boolean z19;
        boolean z26;
        String str2;
        int intValue;
        Object valueOf;
        int i17 = 0;
        long j17 = j3;
        int i18 = 0;
        while (i18 < list.size()) {
            long currentTimeMillis = System.currentTimeMillis();
            msg_comm$UinPairMsg msg_comm_uinpairmsg = list.get(i18);
            String valueOf2 = String.valueOf(msg_comm_uinpairmsg.peer_uin.get());
            long j18 = msg_comm_uinpairmsg.last_read_time.get() & 4294967295L;
            List<msg_comm$Msg> list3 = msg_comm_uinpairmsg.f417532msg.get();
            if (msg_comm_uinpairmsg.msg_completed.has() && msg_comm_uinpairmsg.msg_completed.get() != 0) {
                z18 = true;
            } else {
                z18 = i17;
            }
            if (QLog.isDevelopLevel()) {
                sb5.setLength(i17);
                sb5.append("<---handleGetC2CMessageResp pkgPeerUin:");
                sb5.append(valueOf2);
                sb5.append(" uMsgCompleted:");
                sb5.append(z18);
                sb5.append(" lastReadTime:");
                sb5.append(j18);
                sb5.append(" msgListSize:");
                if (list3 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(list3.size());
                }
                sb5.append(valueOf);
                QLog.d("Q.msg.C2CMessageProcessor", 4, sb5.toString());
            }
            if (list3 != null && list3.size() > 0) {
                if (list3.size() > 1) {
                    Collections.sort(list3, this.f116678v);
                }
                I(list3);
                try {
                    synchronized (this.f116343b.getMessageHandleThreadSyncLock(valueOf2, i17)) {
                        z26 = z18;
                        list2 = list3;
                        j16 = j18;
                        Pair<String, Integer> K = K(msg_comm_uinpairmsg, j18, z18, z16, z17, toServiceMsg, fromServiceMsg);
                        str2 = (String) K.first;
                        intValue = ((Integer) K.second).intValue();
                    }
                    A0(b16, str2, list2, z26);
                    i16 = intValue;
                    str = str2;
                    i17 = 0;
                    z19 = false;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessagePackage error " + e16, e16);
                    }
                    i17 = 0;
                }
            } else {
                list2 = list3;
                j16 = j18;
                int b06 = b0(b16, msg_comm_uinpairmsg, valueOf2, i17);
                S0(valueOf2, b06);
                str = valueOf2;
                i16 = b06;
                z19 = true;
            }
            if (z16) {
                z0(b16, i3, j16, msg_comm_uinpairmsg, str, i16, list2, z19);
            }
            i18++;
            j17 = currentTimeMillis;
        }
        return j17;
    }

    private void w0(ConversationInfo conversationInfo) {
        if (ao.r(conversationInfo.type) && ConversationFacade.G(conversationInfo) > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "update c2c unread , frienduin=" + conversationInfo.uin + ", friendUinType=" + conversationInfo.type);
            }
            if (conversationInfo.uin.length() <= 4) {
                return;
            }
            int i3 = conversationInfo.type;
            if (i3 == 1001) {
                byte[] b06 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).b0(conversationInfo.uin);
                if (b06 != null && b06.length > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.C2CMessageProcessor", 2, "clean the unreadcount of lbs : " + b06);
                    }
                } else {
                    return;
                }
            } else if (i3 == 10002) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, "processOffline : ");
                }
            } else if (conversationInfo.isImax) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImaxAdvertisement", 2, "processOffline 0xf9 no need syn unreadtime");
                    return;
                }
                return;
            }
            android.os.Message message = new android.os.Message();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putLong(WorkerHandler.MSG_UPDATE_UNREAD_TIME, Long.MAX_VALUE);
            bundle.putString(WorkerHandler.MSG_UPDATE_UNREAD_UIN, conversationInfo.uin);
            bundle.putInt(WorkerHandler.MSG_UPDATE_UNREAD_TYPE, conversationInfo.type);
            message.setData(bundle);
            this.f116343b.sendWorkMessage(message, true);
        }
    }

    private void x0(byte b16, boolean z16, int i3) {
        if (b16 <= 0) {
            this.f116343b.doC2CUpdateWork();
            if (z16) {
                y0(i3, ((IConversationFacade) this.f116342a.getRuntimeService(IConversationFacade.class, "")).getConversationInfoSet());
                if (i3 == 2) {
                    this.f116680x.clear();
                } else {
                    this.f116679w.clear();
                }
            }
            MsgAutoMonitorUtil.getInstance().markC2CFinishTime();
            r0(i3);
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).z1();
            if (this.f116343b.handleMsgNew()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB handleMsgNew()");
                }
                this.f116343b.getC2CMessage(false, 0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (r4.f116680x.size() <= 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        if (r4.f116680x.contains(r0.uin) == false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y0(int i3, Set<ConversationInfo> set) {
        int i16;
        Iterator<ConversationInfo> it = set.iterator();
        while (it.hasNext()) {
            ConversationInfo next = it.next();
            if (next.uin != null && (i16 = next.type) != 1036 && ao.c(i16) != 1032 && (i3 != 1 || next.type != 1008)) {
                if (i3 != 2 || next.type == 1008) {
                    if (i3 == 2 || this.f116679w.size() <= 0 || !this.f116679w.contains(next.uin)) {
                        w0(next);
                    }
                }
            }
        }
    }

    private void z(ArrayList<msg_comm$Msg> arrayList, long j3, long j16, ArrayList<msg_comm$Msg> arrayList2) {
        Iterator<msg_comm$Msg> it = arrayList.iterator();
        while (it.hasNext()) {
            msg_comm$Msg next = it.next();
            if (!next.msg_head.has()) {
                if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
                }
            } else {
                long j17 = next.msg_head.get().msg_time.get();
                if (j17 >= j3 && j17 <= j16) {
                    arrayList2.add(next);
                }
            }
        }
    }

    private void z0(byte b16, int i3, long j3, msg_comm$UinPairMsg msg_comm_uinpairmsg, String str, int i16, List<msg_comm$Msg> list, boolean z16) {
        msg_comm$UinPairMsg msg_comm_uinpairmsg2;
        int i17;
        if (i16 == 1006) {
            Z(str);
        }
        boolean z17 = false;
        if (ao.c(i16) == 1032) {
            msg_comm_uinpairmsg2 = msg_comm_uinpairmsg;
            i17 = 0;
        } else {
            msg_comm_uinpairmsg2 = msg_comm_uinpairmsg;
            i17 = i16;
        }
        String Y = Y(msg_comm_uinpairmsg2, i17);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "update c2c unread , pkguin=" + Y + ", pkgUinType=" + i16 + ", lastReadTime=" + j3);
        }
        f116677y.c(Y, list, z16, i17, this);
        android.os.Message message = new android.os.Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putLong(WorkerHandler.MSG_UPDATE_UNREAD_TIME, j3);
        bundle.putString(WorkerHandler.MSG_UPDATE_UNREAD_UIN, Y);
        bundle.putInt(WorkerHandler.MSG_UPDATE_UNREAD_TYPE, i17);
        message.setData(bundle);
        BaseMessageHandler baseMessageHandler = this.f116343b;
        if (b16 <= 0) {
            z17 = true;
        }
        baseMessageHandler.sendWorkMessage(message, z17);
        if (i3 == 2) {
            this.f116680x.add(Y);
        } else {
            this.f116679w.add(Y);
        }
        if (i16 == 0 && !z16 && list != null && list.size() > 0) {
            com.tencent.imcore.message.report.a.a(Y);
        }
    }

    public void E0(C2CMsgReadedNotify c2CMsgReadedNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) c2CMsgReadedNotify);
            return;
        }
        String valueOf = String.valueOf(c2CMsgReadedNotify.lPeerUin);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "processPushReadedNotify is called. uAioType = " + c2CMsgReadedNotify.uAioType);
        }
        if (c2CMsgReadedNotify.uAioType == 3) {
            i0(c2CMsgReadedNotify, valueOf);
            return;
        }
        ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setReadFrom(valueOf, 0, c2CMsgReadedNotify.lLastReadTime);
        if (c2CMsgReadedNotify.lLastReadTime >= 0) {
            ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).removeNotification(valueOf, 0);
        }
    }

    public List<MessageRecord> L(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.u uVar) {
        String str;
        String str2;
        int i3;
        int i16;
        int i17;
        long j3;
        long j16;
        int i18;
        int i19;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg_comm_msg, (Object) uVar);
        }
        if (!(uVar instanceof com.tencent.mobileqq.service.message.a)) {
            return new ArrayList();
        }
        com.tencent.mobileqq.service.message.a aVar = (com.tencent.mobileqq.service.message.a) uVar;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        if (msg_comm_msg != null && msg_comm_msg.msg_head.has() && msg_comm_msg.msg_body.has()) {
            msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
            short s16 = (short) msg_comm_msghead.msg_seq.get();
            long j17 = msg_comm_msghead.to_uin.get();
            long j18 = msg_comm_msghead.from_uin.get();
            long j19 = msg_comm_msghead.msg_time.get();
            long j26 = msg_comm_msghead.msg_uid.get();
            int i27 = msg_comm_msghead.msg_type.get();
            int i28 = msg_comm_msg.msg_head.c2c_cmd.get();
            aVar.f286163r = 0;
            aVar.f286164s = 0;
            if (!msg_comm_msg.content_head.has()) {
                str2 = "Q.msg.C2CMessageProcessor";
                i3 = 0;
                i16 = 0;
                i17 = 0;
            } else {
                msg_comm$ContentHead msg_comm_contenthead = msg_comm_msg.content_head.get();
                str2 = "Q.msg.C2CMessageProcessor";
                int i29 = msg_comm_contenthead.div_seq.get();
                int i36 = msg_comm_contenthead.pkg_num.get();
                i17 = msg_comm_contenthead.pkg_index.get();
                i3 = i29;
                i16 = i36;
            }
            if (!aVar.f286157l) {
                j3 = j17;
                j16 = p.c(this.f116343b, msg_comm_msg, String.valueOf(aVar.f286338a), String.valueOf(j18));
            } else {
                j3 = j17;
                j16 = -1;
            }
            aVar.f286149d = j18;
            aVar.f286150e = j19;
            int a16 = p.a(msg_comm_msg);
            aVar.f286152g = a16;
            int i37 = i3;
            long j27 = j16;
            aVar.f286151f = e0((int) j16, a16);
            aVar.f286153h = p.b(msg_comm_msg);
            if (j18 == aVar.f286148c) {
                aVar.f286154i = true;
                aVar.f286159n = true;
            } else {
                aVar.f286159n = false;
            }
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:");
                sb5.append(j19);
                sb5.append(" shortSeq:");
                sb5.append((int) s16);
                sb5.append(" uint32Seq:");
                sb5.append(msg_comm_msghead.msg_seq.get());
                sb5.append(" msgUid:");
                sb5.append(j26);
                sb5.append(" toUin:");
                sb5.append(j3);
                sb5.append(" senderUin:");
                sb5.append(j18);
                sb5.append(" friendUin:");
                sb5.append(aVar.f286338a);
                sb5.append(" isReaded:");
                sb5.append(aVar.f286154i);
                sb5.append(" isSyncFromOtherTerm:");
                sb5.append(aVar.f286159n);
                sb5.append(" msgType:0x");
                sb5.append(Integer.toHexString(i27));
                sb5.append(" c2CCmd:0x");
                sb5.append(Integer.toHexString(i28));
                sb5.append(" hasTemp:");
                sb5.append(msg_comm_msghead.c2c_tmp_msg_head.has());
                sb5.append(" hasShare:");
                sb5.append(msg_comm_msg.appshare_info.has());
                sb5.append(" pkgID:");
                sb5.append(j27);
                sb5.append(" longMsgID:");
                i19 = i37;
                sb5.append(i19);
                sb5.append(" longMsgCount:");
                int i38 = i16;
                sb5.append(i38);
                sb5.append(" longMsgIndex:");
                i26 = i17;
                sb5.append(i26);
                sb5.append("init_direction_flag");
                sb5.append(aVar.f286164s);
                QLog.d(str2, 4, sb5.toString());
                i18 = i38;
            } else {
                String str3 = str2;
                i18 = i16;
                i19 = i37;
                i26 = i17;
                if (aVar.f286338a == 0) {
                    QLog.e(str3, 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
                }
            }
            ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
            P(i27, msg_comm_msg, arrayList2, this.f116343b, aVar);
            O(msg_comm_msg, arrayList2, aVar, this.f116343b);
            f116677y.k(msg_comm_msg, aVar, currentTimeMillis, arrayList, msg_comm_msghead, s16, j18, j26, i27, j18, i19, i18, i26, arrayList2, this);
            if (getClass() == i.class && ae.c(arrayList)) {
                return new ArrayList();
            }
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("decodeSinglePBMsg_C2C return : ");
            if (msg_comm_msg == null) {
                str = " msg=null";
            } else {
                str = " msg.msg_head:" + msg_comm_msg.msg_head + " msg.msg_body:" + msg_comm_msg.msg_body.has();
            }
            sb6.append(str);
            QLog.d("Q.msg.C2CMessageProcessor", 2, sb6.toString());
        }
        return arrayList;
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<--- dataLine getC2CMessage()");
            this.f116343b.getC2CMessage(true, 0);
        }
    }

    public com.tencent.mobileqq.service.message.codec.decoder.d T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.service.message.codec.decoder.d) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).getRegistry().g(i3);
    }

    public void T0(ArrayList<Pair<Long, Long>> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            StringBuilder sb5 = new StringBuilder("-ReportList-");
            msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
            msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
            Iterator<Pair<Long, Long>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<Long, Long> next = it.next();
                msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                uinPairReadInfo.peer_uin.set(((Long) next.first).longValue());
                uinPairReadInfo.last_read_time.set(((Long) next.second).intValue());
                sb5.append("-uin:");
                sb5.append(next.first);
                sb5.append("-ReadTime-");
                sb5.append(next.second);
                msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
            }
            byte[] F0 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).F0();
            if (F0 != null) {
                msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
            }
            msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + sb5.toString());
            }
            w(msg_svc_pbmsgreadedreportreq);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void c(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        super.c(str, i3, j3);
        if (!ao.r(i3) || j3 == 0) {
            return;
        }
        s0(str, i3, j3);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    protected String e(msg_comm$Msg msg_comm_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg_comm_msg);
        }
        long j3 = msg_comm_msg.msg_head.get().msg_uid.get();
        long j16 = msg_comm_msg.msg_head.get().msg_seq.get();
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("key_uid_");
        sb5.append(j3);
        sb5.append("_seq_");
        sb5.append(j16);
        return sb5.toString();
    }

    public boolean q0(ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) arrayList)).booleanValue();
        }
        if (arrayList == null) {
            return false;
        }
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            if (p0(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        } else {
            if (i3 != 2001) {
                if (i3 == 2005) {
                    l0(toServiceMsg, fromServiceMsg, false);
                    return;
                }
                return;
            }
            f0(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) objArr);
            return;
        }
        if (i3 != 2001) {
            if (i3 != 2003) {
                if (i3 != 2005) {
                    switch (i3) {
                        case 1001:
                            F0(i3, objArr);
                            return;
                        case 1002:
                            B0(i3, objArr);
                            return;
                        case 1003:
                            H0(i3, objArr);
                            return;
                        default:
                            return;
                    }
                }
                N0(i3, objArr);
                return;
            }
            Q0(i3, objArr);
            return;
        }
        M0(i3, objArr);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        } else {
            if (i3 != 2001) {
                if (i3 == 2005) {
                    l0(toServiceMsg, fromServiceMsg, true);
                    return;
                }
                return;
            }
            g0(toServiceMsg, fromServiceMsg);
        }
    }
}
