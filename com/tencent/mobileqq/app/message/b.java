package com.tencent.mobileqq.app.message;

import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcGetMsgInfo;
import MessageSvcPack.SvcResponseGetMsgV2;
import QQService.PushCardMsg;
import QQService.PushType;
import QQService.PushVoteIncreaseInfo;
import android.database.Cursor;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements BaseMessageProcessor.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f195880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f195881b;

        a(byte[] bArr, int i3) {
            this.f195880a = bArr;
            this.f195881b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, bArr, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.imcore.message.BaseMessageProcessor.c
        public ToServiceMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ToServiceMsg createToServiceMsg = ((BaseMessageProcessor) b.this).f116343b.createToServiceMsg("MessageSvc.GetMsgV4");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "--->getC2CMessage cChannel: 4vCookies: " + this.f195880a + ",cSyncFlag:" + this.f195881b);
            }
            createToServiceMsg.extraData.putByte("cChannel", (byte) 4);
            createToServiceMsg.extraData.putByteArray("vCookies", this.f195880a);
            createToServiceMsg.extraData.putInt("cSyncFlag", this.f195881b);
            createToServiceMsg.extraData.putByte("onlineSyncFlag", (byte) 1);
            return createToServiceMsg;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.message.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7382b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f195883a;

        /* renamed from: b, reason: collision with root package name */
        public long f195884b;

        /* renamed from: c, reason: collision with root package name */
        public long f195885c;

        /* renamed from: d, reason: collision with root package name */
        public short f195886d;

        public C7382b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f195887a;

        /* renamed from: b, reason: collision with root package name */
        int f195888b;

        /* renamed from: c, reason: collision with root package name */
        short f195889c;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public b(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        }
    }

    private void A(long j3, boolean z16, d dVar) {
        int i3;
        b bVar;
        ArrayList arrayList = new ArrayList();
        long j16 = dVar.f195896g;
        if (j16 == j3) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        new ArrayList();
        SystemMsg systemMsg = new SystemMsg();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i16 = 0; i16 < dVar.f195894e.size(); i16++) {
            stringBuffer.append(new String(dVar.f195894e.get(i16).MsgContent));
            if (i16 < dVar.f195894e.size() - 1) {
                stringBuffer.append("\n");
            }
        }
        systemMsg.sMsg = stringBuffer.toString();
        systemMsg.auth = dVar.f195898i;
        systemMsg.lToMobile = dVar.f195899j;
        systemMsg.strNickName = dVar.f195897h;
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "addFriendRequestByOldVersion, addUin=" + dVar.f195896g + ", msgUid=" + dVar.f195892c + ", msg=" + systemMsg.sMsg);
        }
        String b16 = com.tencent.qqnt.contact.friends.b.f355778a.b(String.valueOf(j16));
        if (b16 != null && b16.length() != 0) {
            systemMsg.message = b16 + BaseApplication.getContext().getString(R.string.f170058eb);
        } else {
            systemMsg.message = j16 + BaseApplication.getContext().getString(R.string.f170058eb);
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("UTF-8");
        systemMsg.writeTo(jceOutputStream);
        String bytes2HexStr = HexUtil.bytes2HexStr(jceOutputStream.toByteArray());
        if (bytes2HexStr != null) {
            MessageRecord d16 = q.d(-1011);
            d16.init(j3, AppConstants.SYSTEM_MSG_UIN_LONGVALUE, j16, bytes2HexStr, 0L, -1011, 0, dVar.f195893d);
            d16.shmsgseq = 187L;
            d16.msgUid = dVar.f195892c;
            if (z16) {
                d16.isread = true;
            }
            d16.issend = i3;
            bVar = this;
            if (!MessageHandlerUtils.msgFilter(bVar.f116342a, d16, true)) {
                arrayList.add(d16);
            } else if (QLog.isColorLevel()) {
                QLog.d(BaseMessageHandler.TAG, 2, "addFriendRequestByOldVersion, the message is remove by msgFilter, addUin=" + dVar.f195896g + ", msgUid=" + d16.msgUid + ", msg=" + systemMsg.sMsg);
            }
        } else {
            bVar = this;
        }
        if (arrayList.size() > 0) {
            int j17 = ad.j(arrayList, (com.tencent.mobileqq.service.message.e) bVar.f116342a.getMsgCache());
            ((IMessageFacade) bVar.f116342a.getRuntimeService(IMessageFacade.class, "")).setAutoPullC2CMsgResult(String.valueOf(AppConstants.SYSTEM_MSG_UIN_LONGVALUE), 0, arrayList, true);
            ((IMessageFacade) bVar.f116342a.getRuntimeService(IMessageFacade.class, "")).addMessage(arrayList, String.valueOf(j3));
            n("addFriendRequestByOldVersion", true, j17, true, false);
            com.tencent.mobileqq.app.handler.c.b(arrayList, true, bVar.f116342a);
        }
    }

    private boolean C(String str, String str2, long j3) {
        int count;
        int count2;
        EntityManager createEntityManager = this.f116342a.getEntityManagerFactory(String.valueOf(str)).createEntityManager();
        Cursor query = createEntityManager.query(false, MessageRecord.getTableName(str2, 1001), (String[]) null, "msgseq=?", new String[]{String.valueOf(j3)}, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                count = query.getCount();
            } finally {
            }
        } else {
            count = 0;
        }
        if (query != null) {
        }
        query = createEntityManager.query(false, MessageRecord.getTableName(str2, 10002), (String[]) null, "msgseq=?", new String[]{String.valueOf(j3)}, (String) null, (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                count2 = query.getCount();
            } finally {
            }
        } else {
            count2 = 0;
        }
        if (query != null) {
        }
        if (count + count2 > 0) {
            return true;
        }
        return false;
    }

    private RichMsg D(byte[] bArr) {
        RichMsg richMsg = null;
        try {
            RichMsg richMsg2 = new RichMsg();
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf-8");
                richMsg2.readFrom(jceInputStream);
                return richMsg2;
            } catch (Exception unused) {
                richMsg = richMsg2;
                return richMsg;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0210  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F(long j3, d dVar, SvcGetMsgInfo svcGetMsgInfo, boolean z16) {
        boolean z17;
        String str;
        int i3;
        String str2;
        String str3;
        b bVar;
        int i16;
        String str4;
        ArrayList<MsgItem> arrayList;
        ArrayList<MessageRecord> arrayList2;
        int i17;
        String str5;
        long j16;
        String c16;
        int i18;
        int i19;
        MessageRecord d16;
        boolean z18;
        int i26;
        byte[] bArr;
        b bVar2 = this;
        long j17 = j3;
        String str6 = "Q.msg.BaseMessageProcessor";
        ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
        ArrayList<MsgItem> arrayList4 = dVar.f195894e;
        String str7 = dVar.f195895f;
        int i27 = -1000;
        int i28 = 0;
        while (i28 < arrayList4.size()) {
            MsgItem msgItem = arrayList4.get(i28);
            byte[] bArr2 = msgItem.MsgContent;
            String str8 = null;
            if (bArr2 != null) {
                str = new String(bArr2);
            } else {
                str = null;
            }
            byte b16 = msgItem.cType;
            try {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    i3 = i27;
                    try {
                        sb5.append("----------handleAccostMsgItemResp msgItem.cType:");
                        sb5.append((int) msgItem.cType);
                        sb5.append(" isReaded:");
                        sb5.append(z16);
                        QLog.d(str6, 2, sb5.toString());
                    } catch (Exception unused) {
                        if (msgItem.MsgContent != null && QLog.isColorLevel()) {
                            QLog.w(str6, 2, "----------handleAccostMsgItemResp msgItem.MsgContent:" + HexUtil.bytes2HexStr(msgItem.MsgContent));
                        }
                        str2 = null;
                        i27 = i3;
                        if (str2 == null) {
                        }
                        i28 = i16 + 1;
                        j17 = j3;
                        bVar2 = bVar;
                        arrayList3 = arrayList2;
                        str6 = str3;
                        str7 = str4;
                        arrayList4 = arrayList;
                    }
                } else {
                    i3 = i27;
                }
                if (b16 != 1) {
                    if (b16 != 19) {
                        if (b16 != 3) {
                            if (b16 != 4) {
                                i27 = i3;
                            } else {
                                str8 = TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
                                i27 = -2002;
                            }
                        } else {
                            str8 = TransfileUtile.makeTransFileProtocolData(str, 0L, 1, false, str);
                            i27 = -2000;
                        }
                    } else {
                        bVar2.A(j17, z16, dVar);
                        return;
                    }
                } else {
                    byte[] bArr3 = msgItem.MsgContent;
                    if (bArr3 != null) {
                        str8 = new String(com.tencent.mobileqq.service.message.b.d(bArr3), "utf-8");
                    }
                    i27 = -1000;
                }
                str2 = str8;
            } catch (Exception unused2) {
                i3 = i27;
            }
            if (str2 == null) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("----------handleAccostMsgItemResp accostMsg.eAccostType");
                    sb6.append(dVar.f195890a);
                    sb6.append("accostMsg.msgId: ");
                    i17 = i28;
                    sb6.append(dVar.f195892c);
                    sb6.append(" accostMsg.time");
                    sb6.append(dVar.f195893d);
                    sb6.append(" msgConten: ");
                    sb6.append(aw.a(str2));
                    QLog.d(str6, 2, sb6.toString());
                } else {
                    i17 = i28;
                }
                long j18 = dVar.f195891b;
                int i29 = dVar.f195890a;
                str3 = str6;
                if (i29 == 1) {
                    str5 = str2;
                    j16 = 9999;
                } else if (i29 == 201) {
                    String c17 = com.tencent.mobileqq.utils.c.c(str2, str7);
                    if (i27 == -2000) {
                        i27 = -1032;
                    } else if (i27 == -2002) {
                        i27 = -1031;
                    } else {
                        i27 = -1003;
                    }
                    str5 = c17;
                    j16 = j18;
                } else {
                    if (i29 == 6) {
                        bVar2.L(str7, j17, false);
                        c16 = com.tencent.mobileqq.utils.c.c(str2, str7);
                        i18 = -3001;
                    } else if (str7 != null && str7.length() > 0) {
                        c16 = com.tencent.mobileqq.utils.c.c(str2, str7);
                        i18 = -3000;
                    } else {
                        str5 = str2;
                        j16 = j18;
                        i19 = i27;
                        d16 = q.d(i19);
                        int i36 = i19;
                        i16 = i17;
                        long j19 = j16;
                        str4 = str7;
                        String str9 = str;
                        arrayList = arrayList4;
                        ArrayList<MessageRecord> arrayList5 = arrayList3;
                        d16.init(j3, j19, dVar.f195891b, str5, dVar.f195893d, i36, 1001, 0L);
                        d16.shmsgseq = dVar.f195892c;
                        d16.isread = z16;
                        if (svcGetMsgInfo == null && (bArr = svcGetMsgInfo.vReserved) != null && bArr.length >= 2) {
                            z18 = false;
                            d16.longMsgCount = bArr[0];
                            d16.longMsgIndex = bArr[1];
                            d16.longMsgId = bArr[2];
                        } else {
                            z18 = false;
                        }
                        if (d16 instanceof MessageForPic) {
                            MessageForPic messageForPic = (MessageForPic) d16;
                            messageForPic.subVersion = 2;
                            i26 = i36;
                            if (i26 == -2000) {
                                messageForPic.path = str9;
                                messageForPic.uuid = str9;
                                messageForPic.size = 0L;
                                messageForPic.type = 1;
                                messageForPic.isRead = z18;
                            }
                        } else {
                            i26 = i36;
                            if (d16 instanceof MessageForPtt) {
                                MessageForPtt messageForPtt = (MessageForPtt) d16;
                                messageForPtt.subVersion = 2;
                                messageForPtt.url = str9;
                                messageForPtt.urlAtServer = str9;
                                messageForPtt.itemType = 2;
                                messageForPtt.fileSize = 0L;
                                messageForPtt.isread = z18;
                            }
                        }
                        bVar = this;
                        arrayList2 = arrayList5;
                        if (!MessageHandlerUtils.msgFilter(bVar.f116342a, d16, z18)) {
                            arrayList2.add(d16);
                        }
                        i27 = i26;
                    }
                    str5 = c16;
                    j16 = j18;
                    i19 = i18;
                    d16 = q.d(i19);
                    int i362 = i19;
                    i16 = i17;
                    long j192 = j16;
                    str4 = str7;
                    String str92 = str;
                    arrayList = arrayList4;
                    ArrayList<MessageRecord> arrayList52 = arrayList3;
                    d16.init(j3, j192, dVar.f195891b, str5, dVar.f195893d, i362, 1001, 0L);
                    d16.shmsgseq = dVar.f195892c;
                    d16.isread = z16;
                    if (svcGetMsgInfo == null) {
                    }
                    z18 = false;
                    if (d16 instanceof MessageForPic) {
                    }
                    bVar = this;
                    arrayList2 = arrayList52;
                    if (!MessageHandlerUtils.msgFilter(bVar.f116342a, d16, z18)) {
                    }
                    i27 = i26;
                }
                i19 = i27;
                d16 = q.d(i19);
                int i3622 = i19;
                i16 = i17;
                long j1922 = j16;
                str4 = str7;
                String str922 = str;
                arrayList = arrayList4;
                ArrayList<MessageRecord> arrayList522 = arrayList3;
                d16.init(j3, j1922, dVar.f195891b, str5, dVar.f195893d, i3622, 1001, 0L);
                d16.shmsgseq = dVar.f195892c;
                d16.isread = z16;
                if (svcGetMsgInfo == null) {
                }
                z18 = false;
                if (d16 instanceof MessageForPic) {
                }
                bVar = this;
                arrayList2 = arrayList522;
                if (!MessageHandlerUtils.msgFilter(bVar.f116342a, d16, z18)) {
                }
                i27 = i26;
            } else {
                str3 = str6;
                bVar = bVar2;
                i16 = i28;
                str4 = str7;
                arrayList = arrayList4;
                arrayList2 = arrayList3;
            }
            i28 = i16 + 1;
            j17 = j3;
            bVar2 = bVar;
            arrayList3 = arrayList2;
            str6 = str3;
            str7 = str4;
            arrayList4 = arrayList;
        }
        b bVar3 = bVar2;
        ArrayList<MessageRecord> arrayList6 = arrayList3;
        if (arrayList6.size() > 0) {
            boolean hasRecvAndUnreadMsg = BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList6);
            int j26 = ad.j(arrayList6, (com.tencent.mobileqq.service.message.e) bVar3.f116342a.getMsgCache());
            IMessageFacade iMessageFacade = (IMessageFacade) bVar3.f116342a.getRuntimeService(IMessageFacade.class, "");
            String valueOf = String.valueOf(j3);
            if (hasRecvAndUnreadMsg && bVar3.f116342a.isBackgroundStop) {
                z17 = true;
            } else {
                z17 = false;
            }
            iMessageFacade.addMessage(arrayList6, valueOf, z17);
            n("handleAccostMsgItemResp", true, j26, bVar3.f116343b.needNotifyNotification(hasRecvAndUnreadMsg), false);
        }
    }

    private void G(long j3, d dVar) {
        CardHandler cardHandler;
        ArrayList<MsgItem> arrayList = dVar.f195894e;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                MsgItem msgItem = arrayList.get(i3);
                new String(msgItem.MsgContent);
                if (-56 == msgItem.cType) {
                    JceInputStream jceInputStream = new JceInputStream(msgItem.MsgContent);
                    jceInputStream.setServerEncoding("utf-8");
                    PushCardMsg pushCardMsg = new PushCardMsg();
                    pushCardMsg.readFrom(jceInputStream);
                    if (PushType.PUSH_TYPE_VOTE_INCR.value() == pushCardMsg.ePushType) {
                        JceInputStream jceInputStream2 = new JceInputStream(pushCardMsg.vPushInfo);
                        jceInputStream2.setServerEncoding("utf-8");
                        PushVoteIncreaseInfo pushVoteIncreaseInfo = new PushVoteIncreaseInfo();
                        pushVoteIncreaseInfo.readFrom(jceInputStream2);
                        if (pushVoteIncreaseInfo.iIncrement > 0 && (cardHandler = (CardHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)) != null) {
                            cardHandler.H4(pushVoteIncreaseInfo, String.valueOf(j3), String.valueOf(dVar.f195891b));
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
    }

    private void H(long j3, ArrayList<AccostMsg> arrayList, ArrayList<C7382b> arrayList2, ArrayList<SvcGetMsgInfo> arrayList3, long j16, String str) {
        SvcGetMsgInfo svcGetMsgInfo;
        RichMsg D;
        ArrayList<MsgItem> arrayList4;
        b bVar = this;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            AccostMsg accostMsg = arrayList.get(i3);
            if (arrayList3 != null && arrayList3.size() > i3) {
                svcGetMsgInfo = arrayList3.get(i3);
            } else {
                svcGetMsgInfo = null;
            }
            SvcGetMsgInfo svcGetMsgInfo2 = svcGetMsgInfo;
            C7382b c7382b = new C7382b();
            c7382b.f195883a = accostMsg.lFromMID;
            c7382b.f195884b = accostMsg.lToMID;
            c7382b.f195885c = accostMsg.uMsgID;
            c7382b.f195886d = accostMsg.shMsgType;
            arrayList2.add(c7382b);
            boolean I = bVar.I(String.valueOf(j3), String.valueOf(accostMsg.lFromMID));
            if (QLog.isColorLevel()) {
                MessageHandlerUtils.qLogColorFormate("Q.msg.BaseMessageProcessor", str, accostMsg.uMsgID, String.valueOf(j3), String.valueOf(accostMsg.lToMID));
                QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleGetAccostMessageResp fromBlackList: " + I + "accostMsg.shMsgType: " + ((int) accostMsg.shMsgType));
            }
            if (!I && accostMsg.shMsgType == 5 && (D = bVar.D(accostMsg.strMsg)) != null && (arrayList4 = D.VecMsg) != null && arrayList4.size() > 0) {
                long j17 = accostMsg.lFromMID;
                int i16 = accostMsg.eAccostType;
                if (i16 == 0) {
                    i16 = accostMsg.iAccostType;
                }
                F(j3, new d(j17, i16, accostMsg.uMsgID, accostMsg.iMsgTime, arrayList4, D.sAction), svcGetMsgInfo2, false);
            }
            i3++;
            bVar = this;
        }
    }

    private boolean I(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2), "Q.msg.BaseMessageProcessor");
        if (friendsSimpleInfoWithUid == null || friendsSimpleInfoWithUid.f() != -1002) {
            return false;
        }
        return true;
    }

    private void J(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String uin;
        int i3;
        SvcResponseGetMsgV2 svcResponseGetMsgV2 = (SvcResponseGetMsgV2) obj;
        if (svcResponseGetMsgV2 != null && svcResponseGetMsgV2.cReplyCode == 0) {
            if (fromServiceMsg.getUin() == null) {
                uin = this.f116342a.getAccount();
            } else {
                uin = fromServiceMsg.getUin();
            }
            long longValue = Long.valueOf(uin).longValue();
            byte b16 = svcResponseGetMsgV2.cMoreMsg;
            byte[] bArr = svcResponseGetMsgV2.vCookies;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<GetMsgV4><R>--->handleGetLbsMessageResp ssoSeq:");
                sb5.append(toServiceMsg.getRequestSsoSeq());
                sb5.append(" msgStruct.cReplyCode: ");
                sb5.append((int) svcResponseGetMsgV2.cReplyCode);
                sb5.append(" vCookies:");
                sb5.append(bArr);
                sb5.append(" size:");
                if (bArr != null) {
                    i3 = bArr.length;
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                QLog.d("Q.msg.BaseMessageProcessor", 2, sb5.toString());
            }
            ArrayList<AccostMsg> arrayList = svcResponseGetMsgV2.vAccostMsg;
            ArrayList<C7382b> arrayList2 = new ArrayList<>();
            ArrayList<SvcGetMsgInfo> arrayList3 = svcResponseGetMsgV2.vMsgInfos;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp : moreMsg: " + ((int) b16) + "cSyncFlag:" + svcResponseGetMsgV2.cSyncFlag);
            }
            if (arrayList != null && arrayList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleGetC2CMessageResp accostMsg size: " + arrayList.size());
                }
                H(longValue, arrayList, arrayList2, arrayList3, 0L, "handleGetLbsMessageResp");
            }
            if (bArr != null && bArr.length > 0) {
                E(bArr, svcResponseGetMsgV2.cSyncFlag);
            } else if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp. final resp of LbsMessage.");
            }
            if (arrayList2.size() > 0) {
                B(null, arrayList2);
                return;
            }
            return;
        }
        this.f116343b.handleError(toServiceMsg, fromServiceMsg);
    }

    private void K(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String uin;
        RichMsg D;
        ArrayList<MsgItem> arrayList;
        RichMsg D2;
        if (obj == null) {
            return;
        }
        SvrMsg svrMsg = (SvrMsg) obj;
        if (svrMsg.stMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg sMsg.stMsg is null");
                return;
            }
            return;
        }
        if (fromServiceMsg.getUin() == null) {
            uin = this.f116342a.getAccount();
        } else {
            uin = fromServiceMsg.getUin();
        }
        boolean I = I(fromServiceMsg.getUin(), String.valueOf(svrMsg.stMsg.lFromMID));
        if (QLog.isColorLevel()) {
            String str = (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_LOGSTR);
            Msg msg2 = svrMsg.stMsg;
            MessageHandlerUtils.qLogColorFormate("Q.msg.BaseMessageProcessor", str, msg2.uMsgID, uin, String.valueOf(msg2.lFromMID));
        }
        if (!I) {
            Msg msg3 = svrMsg.stMsg;
            short s16 = msg3.shMsgType;
            if (s16 != 5) {
                if (s16 == 9 && (D2 = D(msg3.strMsg)) != null) {
                    G(Long.valueOf(uin).longValue(), new d(svrMsg.stMsg.lFromMID, D2.VecMsg));
                }
            } else if ((svrMsg.bResend != 1 || !C(uin, String.valueOf(msg3.lFromMID), svrMsg.stMsg.uMsgID)) && (D = D(svrMsg.stMsg.strMsg)) != null && (arrayList = D.VecMsg) != null) {
                Msg msg4 = svrMsg.stMsg;
                d dVar = new d(msg4.lFromMID, msg4.eAccostType, msg4.uMsgID, msg4.iMsgTime, arrayList, D.sAction);
                if (D.stSender != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg richMsg.stSender is null");
                    }
                    UserInfo userInfo = D.stSender;
                    dVar.f195896g = userInfo.lMobileUin;
                    dVar.f195898i = userInfo.sig;
                    dVar.f195897h = userInfo.nickname;
                }
                dVar.f195899j = svrMsg.stMsg.lFromMID;
                F(Long.valueOf(uin).longValue(), dVar, null, false);
            }
        }
        M(svrMsg);
    }

    private void L(String str, long j3, boolean z16) {
        HashMap<String, String> z17 = Common.z(str);
        String str2 = z17.get("appid");
        String str3 = z17.get("via");
        if (TextUtils.isEmpty("via")) {
            str3 = "ANDROIDQQ.PCPUSH";
        }
        String str4 = str3;
        if (str2 != null) {
            com.tencent.open.business.viareport.c.a().e(String.valueOf(j3), str2, str4, "100", z16);
        }
    }

    public void B(ArrayList<c> arrayList, ArrayList<C7382b> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList, (Object) arrayList2);
            return;
        }
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("MessageSvc.DelMsgV2");
        if (arrayList != null && arrayList.size() > 0) {
            long[] jArr = new long[arrayList.size()];
            int[] iArr = new int[arrayList.size()];
            short[] sArr = new short[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                jArr[i3] = arrayList.get(i3).f195887a;
                iArr[i3] = arrayList.get(i3).f195888b;
                sArr[i3] = arrayList.get(i3).f195889c;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "--->>delC2CMessage i: " + i3 + " fromUin:" + jArr[i3] + " msgTime: " + iArr[i3] + " msgSeq:" + ((int) sArr[i3]));
                }
            }
            createToServiceMsg.extraData.putLongArray("fromUin", jArr);
            createToServiceMsg.extraData.putIntArray("msgTime", iArr);
            createToServiceMsg.extraData.putShortArray("msgSeq", sArr);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            long[] jArr2 = new long[arrayList2.size()];
            long[] jArr3 = new long[arrayList2.size()];
            long[] jArr4 = new long[arrayList2.size()];
            short[] sArr2 = new short[arrayList2.size()];
            for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                jArr2[i16] = arrayList2.get(i16).f195883a;
                jArr3[i16] = arrayList2.get(i16).f195884b;
                jArr4[i16] = arrayList2.get(i16).f195885c;
                sArr2[i16] = arrayList2.get(i16).f195886d;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "--->>delC2CMessage i: " + i16 + " fromUin:" + jArr2[i16] + " msgId: " + jArr4[i16] + " msgType:" + ((int) sArr2[i16]));
                }
            }
            createToServiceMsg.extraData.putLongArray("accostFromUin", jArr2);
            createToServiceMsg.extraData.putLongArray("accostToUin", jArr3);
            createToServiceMsg.extraData.putLongArray("accostMsgId", jArr4);
            createToServiceMsg.extraData.putShortArray("accostMsgType", sArr2);
        }
        this.f116343b.send(createToServiceMsg);
    }

    public void E(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><S>--->getLbsOfflineMsg : cChannel:4,syncFlag:" + i3);
        }
        s(false, false, false, 0L, new a(bArr, i3));
    }

    public void M(SvrMsg svrMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) svrMsg);
            return;
        }
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("AccostSvc.SvrMsg");
        createToServiceMsg.extraData.putSerializable("SvrMsg", svrMsg);
        this.f116343b.send(createToServiceMsg);
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        } else if (i3 == 5002 && QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageError ");
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) objArr);
            return;
        }
        if (i3 != 5001) {
            if (i3 == 5002) {
                if (objArr != null && objArr.length == 3) {
                    J((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            }
            return;
        }
        if (objArr != null && objArr.length == 3) {
            K((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
        } else {
            f(getClass().getName(), i3);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        } else if (i3 == 5002 && QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageTimeOut ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f195890a;

        /* renamed from: b, reason: collision with root package name */
        public long f195891b;

        /* renamed from: c, reason: collision with root package name */
        public long f195892c;

        /* renamed from: d, reason: collision with root package name */
        public long f195893d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<MsgItem> f195894e;

        /* renamed from: f, reason: collision with root package name */
        public String f195895f;

        /* renamed from: g, reason: collision with root package name */
        public long f195896g;

        /* renamed from: h, reason: collision with root package name */
        public String f195897h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f195898i;

        /* renamed from: j, reason: collision with root package name */
        public long f195899j;

        public d(long j3, int i3, long j16, long j17, ArrayList<MsgItem> arrayList, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), arrayList, str);
                return;
            }
            this.f195891b = j3;
            this.f195890a = i3;
            this.f195892c = j16;
            this.f195893d = j17;
            this.f195894e = arrayList;
            this.f195895f = str;
        }

        public d(long j3, ArrayList<MsgItem> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), arrayList);
            } else {
                this.f195891b = j3;
                this.f195894e = arrayList;
            }
        }
    }
}
