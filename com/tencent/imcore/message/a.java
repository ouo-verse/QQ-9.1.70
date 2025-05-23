package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<MessageRecord> f116448a;

    /* renamed from: b, reason: collision with root package name */
    private long f116449b;

    /* renamed from: c, reason: collision with root package name */
    private long f116450c;

    /* renamed from: d, reason: collision with root package name */
    private List<MessageRecord> f116451d;

    /* renamed from: e, reason: collision with root package name */
    private i f116452e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.service.message.a f116453f;

    public a(i iVar, ArrayList<MessageRecord> arrayList, long j3, long j16, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iVar, arrayList, Long.valueOf(j3), Long.valueOf(j16), list, aVar);
            return;
        }
        this.f116448a = arrayList;
        this.f116449b = j3;
        this.f116450c = j16;
        this.f116451d = list;
        this.f116452e = iVar;
        this.f116453f = aVar;
    }

    private void a(ArrayList<MessageRecord> arrayList, MessageRecord messageRecord, boolean z16, boolean z17) {
        if (!z16 && !z17) {
            c(messageRecord);
            if (messageRecord instanceof MessageForMarketFace) {
                com.tencent.mobileqq.model.a.a(this.f116452e.f116342a, (MessageForMarketFace) messageRecord);
            }
            if (AppConstants.NEW_KANDIAN_UIN.equals(messageRecord.frienduin)) {
                messageRecord.time = NetConnInfoCenter.getServerTime();
            }
            arrayList.add(messageRecord);
        }
    }

    private void b(long j3, long j16, long j17, long j18, MessageRecord messageRecord) {
        if (messageRecord.msgtype == -2002) {
            e(j3, j16, j17, j18, messageRecord);
        } else {
            messageRecord.vipBubbleID = 0L;
        }
    }

    private void c(MessageRecord messageRecord) {
        if (messageRecord.istroop == 1008 && (messageRecord instanceof MessageForStructing)) {
            if (StructLongMessageDownloadProcessor.isPALongMsg(messageRecord) || StructLongMessageDownloadProcessor.needFetchOldLongMsg(messageRecord)) {
                String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("longMsg_State");
                if (extInfoFromExtStr == null || !String.valueOf(3).equals(extInfoFromExtStr)) {
                    messageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                    StructLongMessageDownloadProcessor.getStructLongMessage(this.f116452e.f116342a, messageRecord);
                }
            }
        }
    }

    private void d(MessageRecord messageRecord, boolean z16) {
        if (messageRecord.msgtype == -2002) {
            if (!z16 && ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).getStreamFileInfoEntryByMsg(messageRecord.msgUid, messageRecord.shmsgseq) != null) {
                PttInfoCollector.reportPttDownloadStream2Offline(true);
            }
            if (z16 && (messageRecord instanceof MessageForPtt) && ao.r(messageRecord.istroop)) {
                for (MessageRecord messageRecord2 : ((IMessageFacade) this.f116452e.f116342a.getRuntimeService(IMessageFacade.class, "")).getMsgList(messageRecord.frienduin, messageRecord.istroop)) {
                    if ((messageRecord2 instanceof MessageForPtt) && messageRecord2.msgUid == messageRecord.msgUid && messageRecord2.shmsgseq == messageRecord.shmsgseq) {
                        i((MessageForPtt) messageRecord2, (MessageForPtt) messageRecord, this.f116452e);
                        return;
                    }
                }
            }
        }
    }

    private void e(long j3, long j16, long j17, long j18, MessageRecord messageRecord) {
        if (com.tencent.mobileqq.service.message.remote.a.b(messageRecord.issend)) {
            if (j16 != -1) {
                messageRecord.vipBubbleID = j16;
                return;
            } else {
                messageRecord.vipBubbleID = com.tencent.imcore.message.messageprocessor.a.a(this.f116452e.f116342a, String.valueOf(j18), String.valueOf(j17));
                return;
            }
        }
        if (j3 != -1) {
            messageRecord.vipBubbleID = j3;
        } else {
            messageRecord.vipBubbleID = com.tencent.imcore.message.messageprocessor.a.a(this.f116452e.f116342a, String.valueOf(j18), String.valueOf(j17));
        }
    }

    private boolean g(MessageRecord messageRecord) {
        return ((com.tencent.mobileqq.service.message.e) this.f116452e.f116342a.getMsgCache()).o1(messageRecord.frienduin, messageRecord.msgUid, messageRecord.shmsgseq);
    }

    private void h(MessageRecord messageRecord, boolean z16) {
        if (!z16 && messageRecord.istroop == 1008) {
            PublicAccountEventReport.n(this.f116452e.f116342a, messageRecord);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i(MessageForPtt messageForPtt, MessageForPtt messageForPtt2, i iVar) {
        boolean z16;
        if (messageForPtt.getPttStreamFlag() == 10001 && !TextUtils.isEmpty(messageForPtt2.directUrl) && TextUtils.isEmpty(messageForPtt.directUrl)) {
            try {
                messageForPtt.directUrl = messageForPtt2.directUrl;
                messageForPtt.serial();
                ((IMessageFacade) iVar.f116342a.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
                z16 = true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (!QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "updateStreamPttDirectUrl : " + z16);
                return;
            }
            return;
        }
        z16 = false;
        if (!QLog.isColorLevel()) {
        }
    }

    public a f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        for (MessageRecord messageRecord : this.f116451d) {
            long j3 = messageRecord.vipBubbleID;
            if (j3 != -1) {
                if (com.tencent.mobileqq.service.message.remote.a.b(messageRecord.issend)) {
                    this.f116453f.f286166u = j3;
                } else {
                    this.f116453f.f286165t = j3;
                }
            } else {
                com.tencent.mobileqq.service.message.a aVar = this.f116453f;
                b(aVar.f286165t, aVar.f286166u, this.f116449b, this.f116450c, messageRecord);
            }
            this.f116453f.f286168w = messageRecord.istroop;
            boolean g16 = this.f116452e.g(messageRecord, true);
            a(this.f116448a, messageRecord, g16, g(messageRecord));
            d(messageRecord, g16);
            h(messageRecord, g16);
        }
        return this;
    }
}
