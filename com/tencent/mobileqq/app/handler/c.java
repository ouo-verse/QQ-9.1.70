package com.tencent.mobileqq.app.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.f;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(MessageRecord messageRecord, AppInterface appInterface) {
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        if (!(messageRecord instanceof MessageForPic) && !(messageRecord instanceof MessageForMixedMsg)) {
            if (messageRecord instanceof MessageForShortVideo) {
                qQAppInterface.getShortVideoPredownloer().q((MessageForShortVideo) messageRecord);
            } else if (messageRecord instanceof MessageForPtt) {
                d(qQAppInterface, messageRecord);
            } else if ((messageRecord instanceof MessageForLongTextMsg) && messageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3")) {
                c(qQAppInterface, messageRecord, false);
            } else if (messageRecord instanceof MessageForScribble) {
                ((IScribbleDownloader) qQAppInterface.getRuntimeService(IScribbleDownloader.class)).PreDownloadFromMsg((MessageForScribble) messageRecord);
            } else if ((messageRecord instanceof MessageForArkApp) && ArkMsgUtils.isMultiMsg(((MessageForArkApp) messageRecord).ark_app_message)) {
                MultiMsgManager.w().M(messageRecord, qQAppInterface);
            }
        } else {
            ((IPicPreDownload) qQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromMsg(messageRecord, 3);
        }
        if (messageRecord instanceof MessageForStructing) {
            e(qQAppInterface, messageRecord);
        }
    }

    public static void b(ArrayList<MessageRecord> arrayList, boolean z16, AppInterface appInterface) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next(), appInterface);
            }
        }
    }

    public static void c(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        ((MessageForLongTextMsg) messageRecord).loading = true;
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("long_text_msg_resid");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            QLog.e("Q.msg.MessageHandler", 1, "LongTextMsg resid is null!");
        }
        f.g(qQAppInterface, messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, extInfoFromExtStr, z16);
    }

    private static void d(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        ((IPTTPreDownloader) qQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onReceivedPTTMsg((MessageForPtt) messageRecord);
        int i3 = messageRecord.istroop;
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 3;
            } else if (i3 == 3000) {
                i16 = 2;
            } else {
                i16 = 4;
            }
        }
        ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportPTTPV(qQAppInterface, i16, false, 3);
    }

    public static void e(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        Automator automator;
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg == null) {
            return;
        }
        if (!messageRecord.isread && absStructMsg.mMsgServiceID == 38 && !TextUtils.isEmpty(absStructMsg.mResid)) {
            com.tencent.mobileqq.vipgift.b bVar = (com.tencent.mobileqq.vipgift.b) qQAppInterface.getManager(QQManagerFactory.VIP_GIF_MANAGER);
            boolean o16 = bVar.o(messageForStructing);
            com.tencent.mobileqq.vipgift.a d16 = bVar.d();
            if (o16 && (automator = qQAppInterface.mAutomator) != null && automator.H2() && d16 != null && d16.f313121f == 0) {
                long j3 = d16.f313118c;
                if (j3 != 0) {
                    bVar.b(j3);
                }
            }
        } else {
            int i3 = messageForStructing.structingMsg.mMsgServiceID;
            if (i3 == 35) {
                MultiMsgManager.w().M(messageForStructing, qQAppInterface);
            } else if (i3 == 107) {
                MultiMsgManager.w().M(messageForStructing, qQAppInterface);
            }
        }
        ((IPicPreDownload) qQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromMsg(messageRecord, 1);
    }
}
