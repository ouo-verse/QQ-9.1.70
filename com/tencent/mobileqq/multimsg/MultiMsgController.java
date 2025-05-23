package com.tencent.mobileqq.multimsg;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.IMultiMsgRecordOp;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MultiMsgController implements d, ad, Handler.Callback, com.tencent.mobileqq.pic.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f251530d;

    /* renamed from: e, reason: collision with root package name */
    protected List<c> f251531e;

    /* renamed from: f, reason: collision with root package name */
    protected Map<String, h> f251532f;

    /* renamed from: h, reason: collision with root package name */
    protected AtomicBoolean f251533h;

    /* renamed from: i, reason: collision with root package name */
    protected MqqHandler f251534i;

    public MultiMsgController(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f251531e = new ArrayList();
        this.f251532f = new HashMap();
        this.f251533h = new AtomicBoolean(false);
        if (qQAppInterface == null && MobileQQ.sProcessId == 1) {
            qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        this.f251530d = qQAppInterface;
        this.f251534i = new MqqHandler(ThreadManagerV2.getSubThreadLooper(), this);
        j jVar = new j(this.f251530d);
        l lVar = new l(this.f251530d);
        k kVar = new k(this.f251530d);
        b bVar = new b(this.f251530d);
        this.f251531e.add(jVar);
        this.f251531e.add(lVar);
        this.f251531e.add(kVar);
        this.f251531e.add(bVar);
    }

    private void d(QQAppInterface qQAppInterface, ArrayList<MessageRecord> arrayList, List<ChatMessage> list, ChatMessage chatMessage) {
        if (i.m(chatMessage) && !TextUtils.isEmpty(i.g(chatMessage)) && qQAppInterface.getMultiMessageProxy().y(chatMessage).size() == 0) {
            arrayList.add(chatMessage);
        }
    }

    private void o(QQAppInterface qQAppInterface, MessageRecord messageRecord, ArrayList<MessageRecord> arrayList) {
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            String extInfoFromExtStr = next.getExtInfoFromExtStr("self_nickname");
            if (TextUtils.isEmpty(extInfoFromExtStr)) {
                extInfoFromExtStr = MultiMsgManager.w().z(next.senderuin, next.msgseq, qQAppInterface);
            }
            if (extInfoFromExtStr == null || extInfoFromExtStr.trim().length() == 0) {
                extInfoFromExtStr = i.d(next.senderuin);
            }
            i.a(next, extInfoFromExtStr, messageRecord);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int s(QQAppInterface qQAppInterface, MessageRecord messageRecord, HashMap<String, ArrayList<MessageRecord>> hashMap, MessageRecord messageRecord2) {
        HashMap<String, ArrayList<MessageRecord>> y16 = qQAppInterface.getMultiMessageProxy().y(messageRecord2);
        int i3 = 0;
        if (y16.size() > 0) {
            for (String str : y16.keySet()) {
                ArrayList<MessageRecord> arrayList = y16.get(str);
                if (arrayList != null) {
                    i3 = arrayList.size();
                    if (str.equalsIgnoreCase("MultiMsg")) {
                        str = String.valueOf(hashMap.size());
                        if (messageRecord2 instanceof IMultiMsgRecordOp) {
                            IMultiMsgRecordOp iMultiMsgRecordOp = (IMultiMsgRecordOp) messageRecord2;
                            iMultiMsgRecordOp.updateFilename(str);
                            iMultiMsgRecordOp.prewrite();
                        }
                    }
                    o(qQAppInterface, messageRecord, arrayList);
                    hashMap.put(str, arrayList);
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.pic.c
    public void a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.multimsg.d
    public void c(int i3, int i16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), hVar);
            return;
        }
        if (this.f251533h.get()) {
            return;
        }
        hVar.e(i16);
        hVar.d(i3, i16);
        if (hVar.a() == 0) {
            Message obtainMessage = this.f251534i.obtainMessage(3);
            obtainMessage.obj = hVar;
            obtainMessage.sendToTarget();
        }
        i.q("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(hVar.a()), Integer.valueOf(hVar.c()));
    }

    public boolean e(QQAppInterface qQAppInterface, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) qQAppInterface, (Object) hVar)).booleanValue();
        }
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        List<ChatMessage> list = hVar.f251618b;
        Iterator<ChatMessage> it = list.iterator();
        while (it.hasNext()) {
            d(qQAppInterface, arrayList, list, it.next());
        }
        if (arrayList.size() > 0) {
            hVar.f251623g = arrayList;
            return true;
        }
        return false;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f251533h.set(true);
        this.f251534i.removeCallbacksAndMessages(null);
        synchronized (this.f251531e) {
            this.f251531e.clear();
        }
        this.f251530d = null;
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 5, (Object) this, (Object) im_msg_body_richtext);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.c
    public void h(c.a aVar) {
        QQAppInterface qQAppInterface;
        List<MessageRecord> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar);
            return;
        }
        if (this.f251533h.get() || (qQAppInterface = this.f251530d) == null) {
            return;
        }
        String str = aVar.f258664k;
        long j3 = aVar.f258665l;
        h hVar = this.f251532f.get(str);
        i.p("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", Long.valueOf(j3), aVar.f258666m, Integer.valueOf(aVar.f258655b));
        if (hVar == null || (list = hVar.f251623g) == null) {
            return;
        }
        synchronized (this) {
            MessageRecord messageRecord = null;
            for (MessageRecord messageRecord2 : list) {
                if (messageRecord2.uniseq == j3) {
                    messageRecord = messageRecord2;
                }
            }
            if (messageRecord == null) {
                return;
            }
            if (aVar.f258655b == 0) {
                list.remove(messageRecord);
                qQAppInterface.getProxyManager().k().M(aVar.f258659f, new HashMap<>(), messageRecord, null);
            } else if (!ArkMsgUtils.isFailHandleEnabled()) {
                MessageRecord c16 = qQAppInterface.getMultiMessageProxy().c(messageRecord, g.f251616b, false);
                int indexOf = hVar.f251618b.indexOf(messageRecord);
                if (indexOf >= 0) {
                    hVar.f251618b.set(indexOf, (ChatMessage) c16);
                }
            }
            if (list.size() == 0) {
                u(hVar);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        h hVar = (h) message.obj;
        int i3 = message.what;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 3) {
                        l(hVar);
                        return false;
                    }
                    return false;
                }
                w(hVar);
                return false;
            }
            x(hVar);
            return false;
        }
        p(hVar);
        return false;
    }

    public void i(QQAppInterface qQAppInterface, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) qQAppInterface, (Object) hVar);
            return;
        }
        List<MessageRecord> list = hVar.f251623g;
        if (list != null && list.size() != 0) {
            for (MessageRecord messageRecord : list) {
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mIsUp = false;
                transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_MULTIMSG;
                transferRequest.resIdStr = i.g(messageRecord);
                transferRequest.mSelfUin = messageRecord.selfuin;
                String str = messageRecord.frienduin;
                transferRequest.mPeerUin = str;
                transferRequest.mSecondId = str;
                transferRequest.mUinType = messageRecord.istroop;
                transferRequest.mUniseq = messageRecord.uniseq;
                transferRequest.mBusiType = 1035;
                transferRequest.mDownCallBack = this;
                transferRequest.mRichTag = hVar.b();
                ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
                i.p("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", Long.valueOf(transferRequest.mUniseq), transferRequest.resIdStr);
            }
            i.p("downloadNestMultiMsg msgSize = %d ", Integer.valueOf(list.size()));
        }
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return 0;
    }

    protected void k(h hVar) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) hVar);
            return;
        }
        if (hVar == null || this.f251533h.get() || (qQAppInterface = this.f251530d) == null) {
            return;
        }
        MessageRecord messageRecord = hVar.f251621e;
        SessionInfo sessionInfo = hVar.f251617a;
        String str = sessionInfo.f179557e;
        int i3 = sessionInfo.f179555d;
        messageRecord.extraflag = 32768;
        qQAppInterface.getMsgCache().G1(str, i3, messageRecord.uniseq);
        if (!((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("multi_msg_forward_cancel_send_comment", false)) {
            com.tencent.mobileqq.activity.aio.forward.b.d().j(qQAppInterface, messageRecord.uniseq);
        }
        com.tencent.imcore.message.Message lastMessage = qQAppInterface.getMessageFacade().getLastMessage(str, i3);
        if (lastMessage != null && lastMessage.uniseq == messageRecord.uniseq) {
            lastMessage.extraflag = 32768;
        }
        ((MessageHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(i3), false, new Object[]{str, Integer.valueOf(i3), -1, null, 0L, Long.valueOf(messageRecord.uniseq)});
    }

    protected void l(h hVar) {
        int parseInt;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hVar);
            return;
        }
        Iterator<String> it = hVar.f251622f.keySet().iterator();
        while (it.hasNext()) {
            ArrayList<MessageRecord> arrayList = hVar.f251622f.get(it.next());
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<MessageRecord> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    MessageRecord next = it5.next();
                    if (next instanceof MessageForReplyText) {
                        MessageForReplyText messageForReplyText = (MessageForReplyText) next;
                        if (messageForReplyText.getSourceMessage() != null && messageForReplyText.mSourceMsgInfo != null) {
                            messageForReplyText.getSourceMessage().createMessageUniseq();
                            messageForReplyText.mSourceMsgInfo.setUniSeq(messageForReplyText.getSourceMessage().uniseq, true);
                            messageForReplyText.mSourceMsgInfo.packSourceMsg(this.f251530d, messageForReplyText.getSourceMessage());
                            if (hVar.f251633q > 0 || (i3 = hVar.f251625i) == 0 || i3 == 9) {
                                messageForReplyText.mSourceMsgInfo.mSourceMsgTroopName = null;
                                ReportController.o(this.f251530d, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
                            }
                            try {
                                messageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(messageForReplyText.mSourceMsgInfo)));
                                if (FileManagerUtil.isMessageRecordOfFile(messageForReplyText.getSourceMessage())) {
                                    String extInfoFromExtStr = messageForReplyText.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                                    ChatMessage changeRealChatMessage = FileManagerUtil.changeRealChatMessage((ChatMessage) messageForReplyText.getSourceMessage());
                                    QFileUtils.k(this.f251530d, changeRealChatMessage, messageForReplyText.getSourceMessage());
                                    if (!TextUtils.isEmpty(extInfoFromExtStr) && changeRealChatMessage != null && ((parseInt = Integer.parseInt(extInfoFromExtStr)) == 1 || parseInt == 2)) {
                                        FileManagerUtil.getFileRecordForMultiMsg(this.f251530d, changeRealChatMessage.uniseq, changeRealChatMessage.frienduin, changeRealChatMessage.istroop, (ChatMessage) messageForReplyText.getSourceMessage());
                                    }
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        if (hVar.f251622f.containsKey("reply_msg")) {
            hVar.f251622f.remove("reply_msg");
        }
        t(hVar);
        if (hVar.c() != 0) {
            k(hVar);
            return;
        }
        Message obtainMessage = this.f251534i.obtainMessage(1);
        obtainMessage.obj = hVar;
        obtainMessage.sendToTarget();
    }

    public HashMap<String, ArrayList<MessageRecord>> n(QQAppInterface qQAppInterface, MessageRecord messageRecord, AbsStructMsg absStructMsg, @NonNull ArrayList<ChatMessage> arrayList, HashMap<String, String> hashMap, HashMap<String, ArrayList<MessageRecord>> hashMap2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (HashMap) iPatchRedirector.redirect((short) 15, this, qQAppInterface, messageRecord, absStructMsg, arrayList, hashMap, hashMap2);
        }
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
        }
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        Iterator<ChatMessage> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ChatMessage next = it.next();
            arrayList2.add(next);
            i.a(next, hashMap.get(com.tencent.imcore.message.ad.k(next)), messageRecord);
            if (i.m(next)) {
                i3 += s(qQAppInterface, messageRecord, hashMap2, next);
            }
            i3++;
        }
        absStructMsg.mTSum = i3;
        if (messageRecord instanceof MessageForStructing) {
            ((MessageForStructing) messageRecord).doPrewrite();
        } else if (messageRecord instanceof MessageForArkApp) {
            MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
            ArkAppMessage arkAppMessage = messageForArkApp.ark_app_message;
            if (arkAppMessage != null) {
                arkAppMessage.updateTSum(i3);
            }
            messageForArkApp.prewrite();
        }
        hashMap2.put("MultiMsg", arrayList2);
        i.p("step.preHandle.mTSum = %d", Integer.valueOf(i3));
        return hashMap2;
    }

    protected void p(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0184  */
    @Override // com.tencent.mobileqq.pic.ad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(ad.a aVar) {
        QQAppInterface qQAppInterface;
        int i3;
        char c16;
        int i16;
        AbsStructMsg absStructMsg;
        int i17;
        Iterator<String> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        if (this.f251533h.get() || (qQAppInterface = this.f251530d) == null) {
            return;
        }
        try {
            long longValue = ((Long) aVar.f258608l).longValue();
            h hVar = null;
            for (String str : this.f251532f.keySet()) {
                if (this.f251532f.get(str).f251621e.uniseq == longValue) {
                    hVar = this.f251532f.get(str);
                }
            }
            if (hVar == null) {
                return;
            }
            this.f251532f.remove(hVar.b());
            MessageRecord messageRecord = hVar.f251621e;
            SessionInfo sessionInfo = hVar.f251617a;
            String str2 = sessionInfo.f179557e;
            int i18 = sessionInfo.f179555d;
            if (hVar.f251625i == 2) {
                if (aVar.f258597a == 0) {
                    if (messageRecord instanceof IMultiMsgRecordOp) {
                        ((IMultiMsgRecordOp) messageRecord).updateFilename(String.valueOf(messageRecord.uniseq));
                    }
                    if (messageRecord instanceof MessageForStructing) {
                        ((MessageForStructing) messageRecord).structingMsg.mResid = aVar.f258602f;
                    } else if (messageRecord instanceof MessageForArkApp) {
                        ((MessageForArkApp) messageRecord).ark_app_message.updateMultiInfo(aVar.f258602f, messageRecord.uniseq);
                        qQAppInterface.getMessageFacade().K0(messageRecord);
                    }
                }
                int i19 = hVar.f251617a.Z;
                new MultiMsgManager.c(qQAppInterface, messageRecord, str2, i19, hVar.f251622f.get("MultiMsg"), (HashMap) hVar.f251619c).q(aVar);
                i3 = 2;
                i18 = i19;
            } else if (aVar.f258597a == 0) {
                if (messageRecord instanceof IMultiMsgRecordOp) {
                    ((IMultiMsgRecordOp) messageRecord).updateFilename(String.valueOf(messageRecord.uniseq));
                }
                if (messageRecord instanceof MessageForStructing) {
                    MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                    messageForStructing.structingMsg.mResid = aVar.f258602f;
                    QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                    long j3 = messageRecord.uniseq;
                    byte[] bytes = messageForStructing.structingMsg.getBytes();
                    i3 = 2;
                    messageFacade.Y0(str2, i18, j3, bytes);
                } else {
                    i3 = 2;
                    if (messageRecord instanceof MessageForArkApp) {
                        MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
                        messageForArkApp.ark_app_message.updateMultiInfo(aVar.f258602f, messageRecord.uniseq);
                        qQAppInterface.getMessageFacade().Y0(str2, i18, messageRecord.uniseq, messageForArkApp.ark_app_message.toBytes());
                        qQAppInterface.getMessageFacade().K0(messageRecord);
                    }
                }
                qQAppInterface.getMessageFacade().D0(messageRecord, null);
            } else {
                i3 = 2;
                c16 = 1;
                hVar.d(1, 65536);
                k(hVar);
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(aVar.f258597a);
                objArr[c16] = Long.valueOf(messageRecord.uniseq);
                objArr[i3] = Integer.valueOf(hVar.a());
                objArr[3] = Integer.valueOf(hVar.c());
                i.q("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", objArr);
                if (i18 != 0) {
                    if (i18 != 3000 && i18 != 1) {
                        if (i18 != 1000 && i18 != 1004) {
                            if (ChatActivityUtils.N(qQAppInterface, hVar.f251617a)) {
                                i16 = 4;
                            }
                        } else {
                            i16 = 3;
                        }
                    } else {
                        i16 = i3;
                    }
                    String str3 = messageRecord.frienduin;
                    absStructMsg = hVar.f251620d;
                    if (absStructMsg == null) {
                        i17 = 0;
                    } else {
                        i17 = absStructMsg.mTSum;
                    }
                    int i26 = hVar.f251629m + hVar.f251630n + hVar.f251631o + hVar.f251632p;
                    HashMap<String, ArrayList<MessageRecord>> hashMap = hVar.f251622f;
                    it = hashMap.keySet().iterator();
                    int i27 = 0;
                    int i28 = 0;
                    while (it.hasNext()) {
                        ArrayList<MessageRecord> arrayList = hashMap.get(it.next());
                        if (arrayList != null) {
                            Iterator<MessageRecord> it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                                int i29 = it5.next().msgtype;
                                if (i29 == -2022) {
                                    i28++;
                                } else if (i29 == -2005 || i29 == -2017) {
                                    i27++;
                                }
                            }
                        }
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", str3, "0X8009AC0", "0X8009AC0", i16, 0, i17 + "", i26 + "", "" + i28, "" + i27);
                }
                i16 = 1;
                String str32 = messageRecord.frienduin;
                absStructMsg = hVar.f251620d;
                if (absStructMsg == null) {
                }
                int i262 = hVar.f251629m + hVar.f251630n + hVar.f251631o + hVar.f251632p;
                HashMap<String, ArrayList<MessageRecord>> hashMap2 = hVar.f251622f;
                it = hashMap2.keySet().iterator();
                int i272 = 0;
                int i282 = 0;
                while (it.hasNext()) {
                }
                ReportController.o(qQAppInterface, "CliOper", "", str32, "0X8009AC0", "0X8009AC0", i16, 0, i17 + "", i262 + "", "" + i282, "" + i272);
            }
            c16 = 1;
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(aVar.f258597a);
            objArr2[c16] = Long.valueOf(messageRecord.uniseq);
            objArr2[i3] = Integer.valueOf(hVar.a());
            objArr2[3] = Integer.valueOf(hVar.c());
            i.q("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", objArr2);
            if (i18 != 0) {
            }
            i16 = 1;
            String str322 = messageRecord.frienduin;
            absStructMsg = hVar.f251620d;
            if (absStructMsg == null) {
            }
            int i2622 = hVar.f251629m + hVar.f251630n + hVar.f251631o + hVar.f251632p;
            HashMap<String, ArrayList<MessageRecord>> hashMap22 = hVar.f251622f;
            it = hashMap22.keySet().iterator();
            int i2722 = 0;
            int i2822 = 0;
            while (it.hasNext()) {
            }
            ReportController.o(qQAppInterface, "CliOper", "", str322, "0X8009AC0", "0X8009AC0", i16, 0, i17 + "", i2622 + "", "" + i2822, "" + i2722);
        } catch (Exception e16) {
            QLog.e("MultiMsg_TAG", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    protected void t(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar);
            return;
        }
        MultiMsgProxy multiMessageProxy = this.f251530d.getMultiMessageProxy();
        Iterator<String> it = hVar.f251622f.keySet().iterator();
        while (it.hasNext()) {
            ArrayList<MessageRecord> arrayList = hVar.f251622f.get(it.next());
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<MessageRecord> it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    MessageRecord next = it5.next();
                    if (next instanceof MessageForReplyText) {
                        if (multiMessageProxy != null) {
                            multiMessageProxy.N(next, null);
                        }
                    } else if ((next instanceof MessageForMixedMsg) && ((MessageForMixedMsg) next).getReplyMessage(this.f251530d) != null && multiMessageProxy != null) {
                        multiMessageProxy.N(next, null);
                    }
                }
            }
        }
    }

    public void u(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) hVar);
            return;
        }
        QQAppInterface qQAppInterface = this.f251530d;
        if (qQAppInterface == null) {
            return;
        }
        if (((IFeatureRuntimeService) qQAppInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_multimsg_send_async", false)) {
            ThreadManagerV2.excute(new Runnable(hVar) { // from class: com.tencent.mobileqq.multimsg.MultiMsgController.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ h f251535d;

                {
                    this.f251535d = hVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiMsgController.this, (Object) hVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MultiMsgController.this.v(this.f251535d);
                    }
                }
            }, 128, null, true);
        } else {
            v(hVar);
        }
    }

    protected void v(h hVar) {
        QQAppInterface qQAppInterface;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hVar);
            return;
        }
        if (this.f251533h.get() || (qQAppInterface = this.f251530d) == null) {
            return;
        }
        if (!this.f251532f.containsKey(hVar.b())) {
            this.f251532f.put(hVar.b(), hVar);
        }
        if (e(qQAppInterface, hVar)) {
            i(qQAppInterface, hVar);
            return;
        }
        if (hVar.f251624h == 0) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        Message obtainMessage = this.f251534i.obtainMessage(i3);
        obtainMessage.obj = hVar;
        obtainMessage.sendToTarget();
    }

    protected void w(h hVar) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) hVar);
            return;
        }
        if (this.f251533h.get() || (qQAppInterface = this.f251530d) == null) {
            return;
        }
        byte[] u16 = qQAppInterface.getProxyManager().k().u(hVar.f251622f, (HashMap) hVar.f251619c, true);
        if (u16 == null) {
            hVar.d(99, 99);
            k(hVar);
            return;
        }
        String account = qQAppInterface.getAccount();
        SessionInfo sessionInfo = hVar.f251617a;
        String str = sessionInfo.f179557e;
        String str2 = sessionInfo.f179559f;
        int i3 = sessionInfo.f179555d;
        long j3 = hVar.f251621e.uniseq;
        hVar.f251629m = u16.length;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mIsUp = true;
        transferRequest.mFileType = FileMsg.TRANSFILE_TYPE_MULTIMSG;
        transferRequest.multiMsgType = 0;
        transferRequest.toSendData = u16;
        transferRequest.mSelfUin = account;
        transferRequest.mPeerUin = str;
        transferRequest.mSecondId = str2;
        transferRequest.mUinType = i3;
        transferRequest.mUniseq = j3;
        transferRequest.mBusiType = 1035;
        transferRequest.mUpCallBack = this;
        transferRequest.upMsgBusiType = j();
        ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
        i.p("step.uploadPb.uniseq = %d,fileSize = %d", Long.valueOf(j3), Integer.valueOf(u16.length));
    }

    public void x(h hVar) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) hVar);
            return;
        }
        if (this.f251533h.get() || (qQAppInterface = this.f251530d) == null) {
            return;
        }
        List<ChatMessage> list = hVar.f251618b;
        HashMap<String, String> hashMap = (HashMap) hVar.f251619c;
        MessageRecord messageRecord = hVar.f251621e;
        HashMap<String, ArrayList<MessageRecord>> x16 = qQAppInterface.getProxyManager().k().x(messageRecord, n(qQAppInterface, messageRecord, hVar.f251620d, (ArrayList) list, hashMap, null), null, true, true);
        hVar.f251622f = x16;
        if (x16.size() == 0) {
            return;
        }
        hVar.e(15);
        synchronized (this.f251531e) {
            Iterator<c> it = this.f251531e.iterator();
            while (it.hasNext()) {
                it.next().a(hVar, x16, this);
            }
        }
        i.p("step.uploadRichStart", new Object[0]);
    }
}
