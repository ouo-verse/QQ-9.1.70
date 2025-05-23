package com.tencent.imcore.message;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.api.IOnLinePushMessageProcessorService;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    protected final com.tencent.imcore.message.basic.c<Long, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a> f116654v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected boolean f116655a;

        /* renamed from: b, reason: collision with root package name */
        protected FromServiceMsg f116656b;

        /* renamed from: c, reason: collision with root package name */
        protected SvcReqPushMsg f116657c;

        /* renamed from: d, reason: collision with root package name */
        protected String f116658d;

        /* renamed from: e, reason: collision with root package name */
        protected ArrayList<MessageRecord> f116659e;

        /* renamed from: f, reason: collision with root package name */
        protected ArrayList<MsgInfo> f116660f;

        /* renamed from: g, reason: collision with root package name */
        protected ArrayList<DelMsgInfo> f116661g;

        /* renamed from: h, reason: collision with root package name */
        protected long f116662h;

        /* renamed from: i, reason: collision with root package name */
        protected ArrayList<String> f116663i;

        /* renamed from: j, reason: collision with root package name */
        protected MsgInfo f116664j;

        /* renamed from: k, reason: collision with root package name */
        protected boolean f116665k;

        public a(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) bVar);
                return;
            }
            this.f116656b = bVar.f116667a;
            this.f116657c = bVar.f116668b;
            this.f116658d = bVar.f116669c;
            this.f116659e = bVar.f116670d;
            this.f116660f = bVar.f116671e;
            this.f116661g = bVar.f116672f;
            this.f116662h = bVar.f116673g;
            this.f116663i = bVar.f116674h;
            this.f116664j = bVar.f116675i;
            this.f116665k = bVar.f116676j;
        }

        private void a() {
            if (!this.f116665k) {
                long j3 = this.f116664j.uAppShareID;
                if (j3 > 0) {
                    this.f116663i.add(com.tencent.mobileqq.utils.h.g(j3));
                }
            }
        }

        private boolean d(SvcReqPushMsg svcReqPushMsg, ArrayList<MessageRecord> arrayList, MsgInfo msgInfo, int i3) {
            ag H = g.this.H(i3, msgInfo, svcReqPushMsg);
            if (H != null) {
                MessageRecord messageRecord = H.f116512a;
                if (messageRecord != null) {
                    arrayList.add(messageRecord);
                }
                if (H.f116513b) {
                    return true;
                }
                return false;
            }
            return false;
        }

        private void e(Exception exc) {
            exc.printStackTrace();
            if (this.f116664j.vMsg != null && QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.bytes2HexStr(this.f116664j.vMsg));
            }
        }

        private void h(int i3) {
            if (42 != i3 && 83 != i3 && 127 != i3 && QLog.isColorLevel()) {
                MessageHandlerUtils.qLogColorFormate("Q.msg.BaseMessageProcessor", this.f116658d, this.f116664j.shMsgSeq, String.valueOf(this.f116662h), String.valueOf(this.f116664j.lFromUin));
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + this.f116664j.lFromUin + " msgInfo.shMsgType: " + ((int) this.f116664j.shMsgType) + " msgInfo.uRealMsgTime: " + this.f116664j.uRealMsgTime + " msgInfo.shMsgSeq: " + ((int) this.f116664j.shMsgSeq) + ", msgInfo.lMsgUid" + this.f116664j.lMsgUid);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b(ArrayList<MessageRecord> arrayList, long j3, MsgInfo msgInfo, int i3, int i16, String str, byte[] bArr, int i17, long j16, long j17, boolean z16, boolean z17) {
            MessageRecord messageRecord;
            byte[] bArr2;
            int i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, arrayList, Long.valueOf(j3), msgInfo, Integer.valueOf(i3), Integer.valueOf(i16), str, bArr, Integer.valueOf(i17), Long.valueOf(j16), Long.valueOf(j17), Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z17 || str == null) {
                return;
            }
            MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(i16);
            if (i3 == 1006) {
                IOnLinePushMessageProcessorService iOnLinePushMessageProcessorService = (IOnLinePushMessageProcessorService) QRoute.api(IOnLinePushMessageProcessorService.class);
                messageRecord = createMsgRecordByMsgType;
                bArr2 = bArr;
                i18 = i17;
                createMsgRecordByMsgType.init(String.valueOf(j3), iOnLinePushMessageProcessorService.getPhoneNumByUin(g.this.f116342a, String.valueOf(j17)), iOnLinePushMessageProcessorService.getPhoneNumByUin(g.this.f116342a, String.valueOf(j16)), str, msgInfo.uRealMsgTime, i16, i3, msgInfo.uMsgTime);
            } else {
                messageRecord = createMsgRecordByMsgType;
                bArr2 = bArr;
                i18 = i17;
                messageRecord.init(j3, j17, j16, str, msgInfo.uRealMsgTime, i16, i3, msgInfo.uMsgTime);
            }
            MessageRecord messageRecord2 = messageRecord;
            messageRecord2.shmsgseq = msgInfo.shMsgSeq;
            messageRecord2.isread = z16;
            messageRecord2.msgUid = msgInfo.lMsgUid;
            messageRecord2.msgData = bArr2;
            if (i18 > 0) {
                messageRecord2.setExtraFlag(i18);
            }
            if (!MessageHandlerUtils.msgFilter(g.this.f116342a, messageRecord2, true)) {
                arrayList.add(messageRecord2);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + j17 + " msgType: " + i16 + " friendType: " + i3 + " shMsgSeq: " + ((int) msgInfo.shMsgSeq) + " msgContent: " + aw.a(str));
            }
        }

        protected boolean c(DelMsgInfo delMsgInfo) throws UnsupportedEncodingException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) delMsgInfo)).booleanValue();
            }
            return true;
        }

        public a f() {
            a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            try {
                MsgInfo msgInfo = this.f116664j;
                short s16 = msgInfo.shMsgType;
                long j3 = msgInfo.lFromUin;
                DelMsgInfo delMsgInfo = new DelMsgInfo();
                ((IOnLinePushMessageProcessorService) QRoute.api(IOnLinePushMessageProcessorService.class)).changeBuddyOnline(g.this.f116342a, this.f116664j.lFromUin);
                MsgInfo msgInfo2 = this.f116664j;
                delMsgInfo.lFromUin = msgInfo2.lFromUin;
                delMsgInfo.shMsgSeq = msgInfo2.shMsgSeq;
                delMsgInfo.uMsgTime = msgInfo2.uMsgTime;
                delMsgInfo.vMsgCookies = msgInfo2.vMsgCookies;
                this.f116661g.add(delMsgInfo);
                h(s16);
                if (OnLinePushMsgTypeProcessorDispatcher.getProcessorMap().containsKey(Integer.valueOf(s16))) {
                    try {
                        if (d(this.f116657c, this.f116659e, this.f116664j, s16)) {
                            this.f116655a = true;
                            return this;
                        }
                        b(this.f116659e, this.f116662h, this.f116664j, 0, -1000, null, null, -1, j3, j3, false, this.f116665k);
                        aVar = this;
                    } catch (Exception e16) {
                        e = e16;
                        aVar = this;
                        aVar.e(e);
                        a();
                        aVar.f116655a = false;
                        return aVar;
                    }
                } else {
                    aVar = this;
                    try {
                        if (aVar.c(delMsgInfo)) {
                            return aVar;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        aVar.e(e);
                        a();
                        aVar.f116655a = false;
                        return aVar;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                aVar = this;
            }
            a();
            aVar.f116655a = false;
            return aVar;
        }

        public boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f116665k;
        }

        boolean i() {
            return this.f116655a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        FromServiceMsg f116667a;

        /* renamed from: b, reason: collision with root package name */
        SvcReqPushMsg f116668b;

        /* renamed from: c, reason: collision with root package name */
        String f116669c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<MessageRecord> f116670d;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<MsgInfo> f116671e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<DelMsgInfo> f116672f;

        /* renamed from: g, reason: collision with root package name */
        long f116673g;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<String> f116674h;

        /* renamed from: i, reason: collision with root package name */
        MsgInfo f116675i;

        /* renamed from: j, reason: collision with root package name */
        boolean f116676j;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public g(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        super(appInterface, baseMessageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
        } else {
            this.f116654v = new com.tencent.imcore.message.basic.d();
        }
    }

    public static MsgType0x210 G(byte[] bArr) {
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf-8");
            MsgType0x210 msgType0x210 = new MsgType0x210();
            msgType0x210.readFrom(jceInputStream);
            return msgType0x210;
        } catch (Exception e16) {
            QLog.d("Q.msg.BaseMessageProcessor", 1, e16, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ag H(int i3, MsgInfo msgInfo, SvcReqPushMsg svcReqPushMsg) {
        return this.f116343b.getProcessor(OnLinePushMsgTypeProcessorDispatcher.getProcessorKey(i3)).o(OnLinePushMsgTypeProcessorDispatcher.getProcessType(i3), msgInfo, svcReqPushMsg);
    }

    private boolean M(MsgType0x210 msgType0x210) {
        if (msgType0x210.uSubMsgType == 36 && msgType0x210.stMsgInfo0x24 != null) {
            return true;
        }
        return false;
    }

    private boolean N(MsgType0x210 msgType0x210) {
        if (msgType0x210.uSubMsgType == 234) {
            return true;
        }
        return false;
    }

    protected void A(FromServiceMsg fromServiceMsg, ArrayList<MessageRecord> arrayList, ArrayList<String> arrayList2, SvcReqPushMsg svcReqPushMsg, ArrayList<DelMsgInfo> arrayList3, long j3, int i3) {
        throw null;
    }

    protected void B(SvcReqPushMsg svcReqPushMsg) {
        throw null;
    }

    protected a C(b bVar) {
        throw null;
    }

    MessageRecord D(MsgInfo msgInfo, long j3, MsgType0x210 msgType0x210) {
        com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a aVar = this.f116654v.get(Long.valueOf(msgType0x210.uSubMsgType));
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 4, "decode0x210ProtoBuf subMsgType:" + msgType0x210.uSubMsgType);
        }
        if (aVar != null) {
            return aVar.decode(this, msgType0x210, j3, msgType0x210.vProtobuf, msgInfo);
        }
        return null;
    }

    protected void E(MsgType0x210 msgType0x210) {
        throw null;
    }

    protected void F(MsgType0x210 msgType0x210) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageRecord I(MsgInfo msgInfo, long j3) {
        MsgType0x210 G = G(msgInfo.vMsg);
        if (!K(G)) {
            return null;
        }
        if (M(G)) {
            E(G);
            return null;
        }
        if (L(G)) {
            return D(msgInfo, j3, G);
        }
        if (!N(G)) {
            return null;
        }
        F(G);
        return null;
    }

    protected void J(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, svcReqPushMsg);
            return;
        }
        B(svcReqPushMsg);
        String str = (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR);
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        ArrayList<MsgInfo> arrayList2 = svcReqPushMsg.vMsgInfos;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList<DelMsgInfo> arrayList3 = new ArrayList<>();
            long j3 = svcReqPushMsg.lUin;
            int i3 = svcReqPushMsg.svrip;
            ArrayList<String> arrayList4 = new ArrayList<>();
            Iterator<MsgInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                MsgInfo next = it.next();
                b bVar = new b();
                bVar.f116667a = fromServiceMsg;
                bVar.f116668b = svcReqPushMsg;
                bVar.f116669c = str;
                bVar.f116670d = arrayList;
                bVar.f116671e = arrayList2;
                bVar.f116672f = arrayList3;
                bVar.f116673g = j3;
                bVar.f116674h = arrayList4;
                bVar.f116675i = next;
                bVar.f116676j = false;
                a f16 = C(bVar).f();
                if (!f16.i() && f16.g()) {
                    return;
                }
            }
            A(fromServiceMsg, arrayList, arrayList4, svcReqPushMsg, arrayList3, j3, i3);
        }
    }

    boolean K(MsgType0x210 msgType0x210) {
        if (msgType0x210 != null) {
            return true;
        }
        return false;
    }

    public boolean L(MsgType0x210 msgType0x210) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgType0x210)).booleanValue();
        }
        if (msgType0x210.vProtobuf != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
            return;
        }
        if (i3 == 3001) {
            if (objArr != null && objArr.length == 3) {
                J((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], (SvcReqPushMsg) objArr[2]);
            } else {
                f(getClass().getName(), i3);
            }
        }
    }
}
