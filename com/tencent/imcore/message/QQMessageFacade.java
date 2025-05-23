package com.tencent.imcore.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.miniaio.MiniMsgHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.e;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.imcore.message.QQMessageFacadeStub;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.utils.bd;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import com.tencent.widget.TraceUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQMessageFacade extends BaseQQMessageFacade implements QQMessageFacadeStub {
    static IPatchRedirector $redirector_;
    public static final Object R;
    private final QQAppInterface I;
    String J;
    int K;
    List<ChatMessage> L;
    private DraftTextManager M;
    private final Map<String, IMessageManager> N;
    private ed1.c P;
    public final com.tencent.imcore.message.facade.h Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements e.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MessageForFile f116438a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f116439b;

        a(MessageForFile messageForFile, FileManagerEntity fileManagerEntity) {
            this.f116438a = messageForFile;
            this.f116439b = fileManagerEntity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQMessageFacade.this, messageForFile, fileManagerEntity);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.data.e.a
        public void onError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 == -6101 || i3 == -7003) {
                QLog.d("Q.msg.QQMessageFacade", 1, "revertMsg error code= " + i3 + "retMsg = " + str + "fileSize = " + this.f116439b.fileSize + " fileType = " + this.f116439b.nFileType + " uuid = " + this.f116439b.Uuid);
                this.f116439b.status = 16;
                QQMessageFacade.this.I.getFileManagerDataCenter().f0(this.f116439b);
            }
            UncommonMessageProcessor n3 = QQMessageFacade.this.I.getMsgHandler().n3();
            MessageForFile messageForFile = this.f116438a;
            n3.P(messageForFile.frienduin, messageForFile.istroop, BaseMessageProcessor.f116329i, 0);
        }

        @Override // com.tencent.mobileqq.filemanager.data.e.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QQMessageFacade.this.F(this.f116438a.istroop).m(this.f116438a);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66109);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 87)) {
            redirector.redirect((short) 87);
        } else {
            R = new Object();
        }
    }

    QQMessageFacade(QQAppInterface qQAppInterface, boolean z16) {
        super(qQAppInterface, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, Boolean.valueOf(z16));
            return;
        }
        this.J = null;
        this.K = -1;
        this.N = new ConcurrentHashMap();
        this.I = qQAppInterface;
        this.Q = new com.tencent.imcore.message.facade.h(this, qQAppInterface);
    }

    public int A1(String str, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return ((Integer) iPatchRedirector.redirect((short) 85, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16))).intValue();
        }
        SQLiteDatabase readableDatabase = this.I.getReadableDatabase();
        if (readableDatabase == null) {
            return 0;
        }
        if (z16) {
            i3 = -1000;
        }
        return readableDatabase.getCount(str, j3, j16, i3, -1000);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r3 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<MessageRecord> C1(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (List) iPatchRedirector.redirect((short) 84, (Object) this, (Object) str, (Object) str2);
        }
        SQLiteDatabase readableDatabase = this.I.getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        EntityManager a16 = this.I.getEntityManagerFactory().a();
        Cursor cursor = null;
        try {
            try {
                cursor = readableDatabase.rawQuery(str, str2, null, null);
                List<? extends Entity> cursor2List = a16.cursor2List(MessageRecord.class, str2, cursor);
                if (cursor2List != null && cursor2List.size() > 0) {
                    arrayList.addAll(cursor2List);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public int D1(String str, long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return ((Integer) iPatchRedirector.redirect((short) 86, this, str, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16))).intValue();
        }
        String currentUin = this.I.getCurrentUin();
        SQLiteDatabase readableDatabase = new com.tencent.mobileqq.persistence.qslowtable.a(currentUin).build(currentUin).getReadableDatabase();
        if (readableDatabase == null) {
            return 0;
        }
        if (z16) {
            i3 = -1000;
        }
        int count = readableDatabase.getCount(str, j3, j16, i3, -1000);
        readableDatabase.close();
        return count;
    }

    @Override // com.tencent.imcore.message.BaseQQMessageFacade
    public void E0(MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, this, messageRecord, businessObserver, Boolean.valueOf(z16));
            return;
        }
        super.E0(messageRecord, businessObserver, z16);
        if (messageRecord.msgtype == -2011) {
            com.tencent.mobileqq.statistics.e.c(messageRecord);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r0 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<MessageRecord> E1(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (List) iPatchRedirector.redirect((short) 83, (Object) this, (Object) str, (Object) str2);
        }
        String currentUin = this.I.getCurrentUin();
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.persistence.qslowtable.a aVar = new com.tencent.mobileqq.persistence.qslowtable.a(currentUin);
        EntityManager b16 = aVar.b();
        SQLiteDatabase writableDatabase = aVar.build(currentUin).getWritableDatabase();
        Cursor cursor = null;
        try {
            try {
                cursor = writableDatabase.rawQuery(str, str2, null, null);
                List<? extends Entity> cursor2List = b16.cursor2List(MessageRecord.class, str2, cursor);
                if (cursor2List != null && cursor2List.size() > 0) {
                    arrayList.addAll(cursor2List);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            }
            writableDatabase.close();
            return arrayList;
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th5;
        }
    }

    public ed1.c F1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ed1.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.P == null) {
            synchronized (this) {
                if (this.P == null) {
                    QQAppInterface qQAppInterface = this.I;
                    this.P = new ed1.c(qQAppInterface, qQAppInterface.getCacheManager().getDBDelayManager());
                }
            }
        }
        return this.P;
    }

    public com.tencent.mobileqq.troop.data.x G1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.mobileqq.troop.data.x) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (com.tencent.mobileqq.troop.data.x) F(1);
    }

    public int H1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return com.tencent.imcore.message.facade.unread.count.g.c(this.I, this);
    }

    public void I1(ArrayList<RevokeMsgInfo> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            String str = arrayList.get(0).f281288f;
            int i3 = arrayList.get(0).f281286d;
            F(i3).j(arrayList, z16);
            ((MiniMsgHandler) this.I.getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).F2(str, i3, -1);
            ((IZPlanMiniAIOHelper) QRoute.api(IZPlanMiniAIOHelper.class)).notifyUnreadCount();
            if (z16) {
                if (i3 == 1 || i3 == 3000) {
                    M0(str, i3, G().C(str, i3));
                }
            }
        }
    }

    public void J1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.imcore.message.QQMessageFacade.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQMessageFacade.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TraceUtils.traceBegin("initMsgCache");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.QQMessageFacade", 2, "before refreshCache");
                    }
                    QQMessageFacade.this.setChanged();
                    QQMessageFacade.this.notifyObservers(new RecentUser());
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.QQMessageFacade", 2, "after refreshCache");
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        MsgAutoMonitorUtil.getInstance().printKeyAndValue(MsgAutoMonitorUtil.MSG_INIT_TIME_KEY, currentTimeMillis2 + "");
                    }
                    TraceUtils.traceEnd();
                }
            }, 10, null, false);
        }
    }

    public boolean K1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.J != null && this.K >= 0) {
            return true;
        }
        return false;
    }

    public void L1(String str, int i3, String str2, String str3, long j3) {
        long j16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3));
            return;
        }
        long j17 = 0;
        if (QLog.isColorLevel()) {
            j16 = System.currentTimeMillis();
        } else {
            j16 = 0;
        }
        if (TextUtils.isEmpty(str3)) {
            i16 = i3;
        } else {
            i16 = i3;
            j17 = j3;
        }
        F(i16).m0(str, i3, str2, str3, j17);
        if (QLog.isColorLevel()) {
            QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - j16) + " drafttime = " + j17);
        }
    }

    public void M1(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
            return;
        }
        ISVIPHandler iSVIPHandler = (ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (!com.tencent.biz.anonymous.a.m(messageRecord)) {
            iSVIPHandler.addSendingBubbleId(messageRecord);
        }
    }

    public boolean O1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this, (Object) str)).booleanValue();
        }
        return P1(str, 0);
    }

    public boolean P1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this, (Object) str, i3)).booleanValue();
        }
        return Q1(str, i3);
    }

    public boolean Q1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (this.I.mAutomator.H2()) {
            this.I.getMsgHandler().h3(str, i3);
            return true;
        }
        return false;
    }

    public void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        } else {
            this.Q.d();
        }
    }

    public void T1(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            V1(str, i3, j3, true);
        }
    }

    public void V1(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        MessageRecord w06 = w0(str, i3, j3);
        if (S(i3).s0(str, i3, j3) == 2) {
            this.I.getConversationFacade().w(str, i3, w06);
        }
        BaseMessageManager.b bVar = BaseMessageManager.D;
        if (bVar != null) {
            bVar.q(Collections.singletonList(w06));
        }
        if (!z16) {
            return;
        }
        if (w06 != null) {
            if (!G().i0(w06.frienduin, w06.istroop)) {
                return;
            }
            if (w06 instanceof MessageForLongMsg) {
                z17 = ao.D(w06, getLastMessage(w06.frienduin, w06.istroop));
            } else if (!k0(w06)) {
                z17 = false;
            }
            if (z17) {
                if (ao.q(w06.istroop)) {
                    F(w06.istroop).n0(w06);
                    return;
                } else {
                    F(w06.istroop).r0(w06);
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + str + ",type=" + i3 + ",uniseq=" + j3);
        }
    }

    public void X1(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            F(i3).W(str, i3, str2, str3);
        }
    }

    public void Y1(String str, int i3, String str2, String str3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            F(i3).X(str, i3, str2, str3, i16, i17, true);
        }
    }

    public void Z1(RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) recentUser);
        } else {
            this.I.getProxyManager().m().delRecentUser(recentUser, false);
            R0(recentUser.uin, recentUser.getType(), true, true);
        }
    }

    public void a2(ArrayList<RevokeMsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) arrayList);
        } else {
            F(arrayList.get(0).f281286d).o(arrayList);
        }
    }

    public void b2(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord != null && !F(messageRecord.istroop).l(messageRecord)) {
            if (messageRecord.msgtype == -2005) {
                c2((MessageForFile) messageRecord);
            } else {
                F(messageRecord.istroop).m(messageRecord);
            }
        }
    }

    public void c2(MessageForFile messageForFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) messageForFile);
            return;
        }
        FileManagerEntity E = this.I.getFileManagerDataCenter().E(messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
        if (E != null) {
            if (messageForFile.isSend()) {
                int i3 = E.status;
                if (i3 == 1 || i3 == -1 || i3 == 3) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
                    }
                    this.I.getFileManagerEngine().r0(messageForFile, E, new a(messageForFile, E));
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg uniseq[" + messageForFile.uniseq + "], sendUin[" + FileManagerUtil.enCodecString(messageForFile.senderuin) + "], type[" + messageForFile.istroop + "], Entity is Null, return");
        }
    }

    public void d2(QQAppInterface qQAppInterface, MessageRecord messageRecord, ArrayList<String> arrayList, ChatActivityFacade.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, qQAppInterface, messageRecord, arrayList, aVar);
        } else {
            ThreadManagerV2.post(new Runnable(qQAppInterface, messageRecord, arrayList, aVar) { // from class: com.tencent.imcore.message.QQMessageFacade.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f116434d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ MessageRecord f116435e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ ArrayList f116436f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ ChatActivityFacade.a f116437h;

                {
                    this.f116434d = qQAppInterface;
                    this.f116435e = messageRecord;
                    this.f116436f = arrayList;
                    this.f116437h = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQMessageFacade.this, qQAppInterface, messageRecord, arrayList, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f116434d.getMsgHandler().n3().S(this.f116435e, this.f116436f, this.f116437h);
                    }
                }
            }, 8, null, false);
        }
    }

    public void e2(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) message);
        } else {
            this.f116353m.setIncomingMsg(message);
        }
    }

    public void f1(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), list);
            return;
        }
        if (list != null && list.size() > 0) {
            S(list.get(0).istroop).a(str, i3, list);
            setChanged();
            notifyObservers(list.get(0));
            QQAppInterface qQAppInterface = this.I;
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getCurrentAccountUin()).createEntityManager();
            try {
                l(list, createEntityManager, true, true, false, false);
                createEntityManager.close();
                l0(list);
            } catch (Throwable th5) {
                createEntityManager.close();
                throw th5;
            }
        }
    }

    public void f2(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord instanceof MessageForShortVideo) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
            if (!messageForShortVideo.isSendFromLocal()) {
                com.tencent.mobileqq.video.a.a(this.I, messageForShortVideo.frienduin, messageForShortVideo.uniseq);
            } else {
                com.tencent.mobileqq.video.a.b(this.I, messageForShortVideo.frienduin, messageForShortVideo.uniseq);
            }
            ShortVideoUtils.deleteCacheFileByMsg(messageForShortVideo);
        }
        if (!messageRecord.isSendFromLocal()) {
            return;
        }
        ITransFileController iTransFileController = (ITransFileController) this.I.getRuntimeService(ITransFileController.class);
        ArrayList arrayList = new ArrayList();
        if (messageRecord instanceof MessageForMixedMsg) {
            MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord;
            int size = messageForMixedMsg.msgElemList.size();
            for (int i3 = 0; i3 < size; i3++) {
                MessageRecord messageRecord2 = messageForMixedMsg.msgElemList.get(i3);
                if (messageRecord2 instanceof MessageForPic) {
                    arrayList.add((MessageForPic) messageRecord2);
                }
            }
        } else if (messageRecord instanceof MessageForLongMsg) {
            MessageForLongMsg messageForLongMsg = (MessageForLongMsg) messageRecord;
            int size2 = messageForLongMsg.longMsgFragmentList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                MessageRecord messageRecord3 = messageForLongMsg.longMsgFragmentList.get(i16);
                if (messageRecord3 instanceof MessageForPic) {
                    arrayList.add((MessageForPic) messageRecord3);
                } else if (messageRecord3 instanceof MessageForMixedMsg) {
                    MessageForMixedMsg messageForMixedMsg2 = (MessageForMixedMsg) messageRecord3;
                    int size3 = messageForMixedMsg2.msgElemList.size();
                    for (int i17 = 0; i17 < size3; i17++) {
                        MessageRecord messageRecord4 = messageForMixedMsg2.msgElemList.get(i17);
                        if (messageRecord4 instanceof MessageForPic) {
                            arrayList.add((MessageForPic) messageRecord4);
                        }
                    }
                }
            }
        } else if (messageRecord instanceof MessageForPic) {
            arrayList.add((MessageForPic) messageRecord);
        } else {
            return;
        }
        int size4 = arrayList.size();
        for (int i18 = 0; i18 < size4; i18++) {
            MessageForPic messageForPic = (MessageForPic) arrayList.get(i18);
            String str = messageForPic.frienduin + messageForPic.uniseq + "_" + messageForPic.subMsgId;
            IHttpCommunicatorListener findProcessor = iTransFileController.findProcessor(str);
            if (findProcessor != null && (findProcessor instanceof BaseTransProcessor)) {
                ((BaseTransProcessor) findProcessor).stop();
                iTransFileController.removeProcessor(str);
            }
        }
    }

    public void g1() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        List<MessageRecord> o16 = S(1032).o(AppConstants.CONFESS_UIN, 1032);
        HashSet hashSet = new HashSet(o16.size());
        for (int i16 = 0; i16 < o16.size(); i16++) {
            MessageRecord messageRecord = o16.get(i16);
            if (messageRecord.isSelfConfessor()) {
                i3 = 1033;
            } else {
                i3 = 1034;
            }
            String str = i3 + ContainerUtils.FIELD_DELIMITER + messageRecord.senderuin;
            if (!hashSet.contains(str)) {
                hashSet.add(str);
                r(messageRecord.senderuin, i3, true, true);
            }
        }
        ConfessMsgUtil.i(this.I, true);
        ConfessMsgUtil.h(this.I, true);
    }

    public void g2(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + str + " type = " + i3 + " uniseq = " + j3 + " shmsgseq = " + j16 + " time = " + j17);
        }
        f S = S(i3);
        MessageRecord messageRecord = null;
        if (i3 == 1 || i3 == 3000 || i3 == 1026) {
            messageRecord = S.y0(str, i3, j3, j16, j17);
            ((bd) this.I.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).f(j3, j16);
        }
        BaseMessageManager F = F(i3);
        F.l0(str, i3, messageRecord, 3);
        M0(str, i3, j16);
        setChanged();
        notifyObservers(messageRecord);
        this.I.getMsgHandler().notifyUI(MessageHandlerConstants.NOTIFY_TYPE_UPDATE_SELF_MSG_SEQ_AND_TIME, true, messageRecord);
        if (messageRecord == null) {
            return;
        }
        com.tencent.mobileqq.service.message.e msgCache = this.I.getMsgCache();
        if ((F instanceof BaseMessageManagerForTroopAndDisc) && msgCache.s1()) {
            if (((BaseMessageManagerForTroopAndDisc) F).T0(messageRecord) || msgCache.k1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq)) {
                if (QLog.isColorLevel()) {
                    QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
                }
                msgCache.U1(null);
                F.a0();
            }
        }
    }

    @Override // com.tencent.mobileqq.imcore.message.QQMessageFacadeStub
    public DraftSummaryInfo getDraftSummaryInfo(String str, int i3) {
        DraftTextManager draftTextManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return (DraftSummaryInfo) iPatchRedirector.redirect((short) 74, (Object) this, (Object) str, i3);
        }
        if (str != null && (draftTextManager = this.M) != null) {
            return draftTextManager.e(this.I, str, i3);
        }
        return null;
    }

    public void h1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) str, i3);
        } else if (str != null && str.length() >= 5 && this.M != null && str.length() >= 5) {
            this.M.b(this.I, str, i3);
        }
    }

    public void i1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        RecentUserProxy m3 = this.I.getProxyManager().m();
        String tableName = new RecentUser().getTableName();
        String tableName2 = new PubAccountAssistantData().getTableName();
        String tableName3 = new TroopBarData().getTableName();
        String tableName4 = new NeedHandleUserData().getTableName();
        SQLiteDatabase writableDatabase = this.I.getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.delete(tableName, null, null);
        writableDatabase.delete(tableName2, null, null);
        writableDatabase.delete(tableName4, null, null);
        writableDatabase.delete(tableName3, null, null);
        t();
        m3.clearRecentUser();
    }

    public MessageRecord i2(String str, int i3, long j3, String str2, String str3, long j16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, str3, Long.valueOf(j16), Integer.valueOf(i16));
        }
        MessageRecord P = P(str, i3, j3);
        if (P == null) {
            return null;
        }
        String forwardMsgContent = TransfileUtile.getForwardMsgContent(P.f203106msg, str2, str3, j16, i16);
        P.f203106msg = forwardMsgContent;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentToForward: set msg =" + P.getBaseInfoString());
        }
        ContentValues contentValues = new ContentValues();
        if (P.versionCode > 0) {
            try {
                contentValues.put(AppConstants.Key.COLUMN_MSG_DATA, forwardMsgContent.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentToForward fail!" + e16);
                }
            }
        } else {
            contentValues.put("msg", forwardMsgContent);
        }
        c1(str, i3, P, contentValues, null);
        if (P instanceof ChatMessage) {
            ((ChatMessage) P).reParse();
        }
        return P;
    }

    public void j1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
            return;
        }
        EntityManager createEntityManager = this.I.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = (ArrayList) createEntityManager.query(TransFileInfo.class, false, "friendUin = ?", new String[]{str}, null, null, null, null);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                createEntityManager.remove((TransFileInfo) it.next());
            }
        }
        createEntityManager.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.BaseQQMessageFacade
    public void l(List<MessageRecord> list, EntityManager entityManager, boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, list, entityManager, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        List<MessageRecord> i3 = com.tencent.mobileqq.forward.l.i(this.I, list);
        if (i3.isEmpty()) {
            QLog.d("Q.msg.QQMessageFacade", 1, "addMultiMessagesInner all fake messages");
        } else {
            super.l(i3, entityManager, z16, z17, z18, z19);
        }
    }

    public List<ChatMessage> l1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (List) iPatchRedirector.redirect((short) 61, (Object) this, (Object) str, i3);
        }
        return m1(str, i3, -1L);
    }

    public List<ChatMessage> m1(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (List) iPatchRedirector.redirect((short) 63, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        return o1(str, i3, j3, false);
    }

    @Override // com.tencent.imcore.message.BaseQQMessageFacade
    public void n(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) messageRecord, i3);
        } else {
            M1(this.I, messageRecord);
            super.n(messageRecord, i3);
        }
    }

    public List<ChatMessage> n1(String str, int i3, long j3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (List) iPatchRedirector.redirect((short) 65, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        List<ChatMessage> t16 = F(i3).t(str, i3, j3, i16, z16);
        k1(str, i3, j3, i16, z16, t16);
        return t16;
    }

    public List<ChatMessage> o1(String str, int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (List) iPatchRedirector.redirect((short) 64, this, str, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        }
        return n1(str, i3, j3, 0, z16);
    }

    @Override // com.tencent.imcore.message.BaseQQMessageFacade, mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this);
            return;
        }
        super.onDestroy();
        DraftTextManager draftTextManager = this.M;
        if (draftTextManager != null) {
            draftTextManager.a();
        }
        this.Q.c();
        ed1.c cVar = this.P;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // com.tencent.imcore.message.BaseQQMessageFacade
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        super.p();
        g1();
        S(0).i();
        S(0).h();
        S(3000).i();
        S(3000).h();
        S(1).i();
        S(1).h();
    }

    public List<ChatMessage> p1(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (List) iPatchRedirector.redirect((short) 62, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return o1(str, i3, -1L, z16);
    }

    public List<ChatMessage> q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.L;
    }

    public int r1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.K;
    }

    public String s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.J;
    }

    public DatalineMessageManager t1(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (DatalineMessageManager) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                str = "dataline_manager_pc";
            } else {
                str = "dataline_manager_phone";
            }
        } else {
            str = "dataline_manager_ipad";
        }
        return (DatalineMessageManager) z1(str);
    }

    public Message u1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Message) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "getFirstUnreadMessage() called with: uin = [" + str + "], type = [" + i3 + "]");
        }
        long j3 = this.I.getProxyManager().f().j(str, i3);
        Message I = I(j3, Q(str, i3));
        if (I != null) {
            return I;
        }
        Message I2 = I(j3, r0(str, i3, j3, 3, String.format("time>=%d", Long.valueOf(j3))));
        if (I2 != null) {
            return I2;
        }
        Message message = new Message();
        message.frienduin = str;
        message.istroop = i3;
        return message;
    }

    public Message v1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (Message) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return this.f116353m.getIncomingMsg();
    }

    public String w1(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (String) iPatchRedirector.redirect((short) 68, this, str, str2, Long.valueOf(j3));
        }
        List<MessageRecord> A = S(0).A(str, 0, 0, false);
        if (A != null) {
            MessageForPic messageForPic = null;
            for (int size = A.size() - 1; size >= 0; size--) {
                MessageRecord messageRecord = A.get(size);
                if (messageRecord.uniseq == j3) {
                    z16 = true;
                }
                if (messageRecord instanceof MessageForPic) {
                    messageForPic = (MessageForPic) messageRecord;
                    if (z16) {
                        break;
                    }
                }
            }
            if (messageForPic != null) {
                if (str2 == null) {
                    str2 = "chatthumb";
                }
                return messageForPic.getFilePath(str2);
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MessageRecord x1(String str, int i3) {
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 67, (Object) this, (Object) str, i3);
        }
        List<MessageRecord> r16 = S(i3).r(str, i3);
        if (r16 != null) {
            for (int size = r16.size() - 1; size >= 0; size--) {
                messageRecord = r16.get(size);
                if (messageRecord.isValid && !ad.D(messageRecord.msgtype)) {
                    if (messageRecord.isLongMsg()) {
                        messageRecord = C(messageRecord);
                    }
                    if (messageRecord == null) {
                        return messageRecord;
                    }
                    Message lastMessage = getLastMessage(str, i3);
                    if (lastMessage != null && lastMessage.isCacheValid) {
                        MessageRecord messageRecord2 = lastMessage.lastMsg;
                        if (messageRecord2 == null) {
                            messageRecord2 = n0(lastMessage);
                        }
                        messageRecord = messageRecord2;
                        lastMessage.lastMsg = messageRecord;
                    }
                    if (messageRecord == null) {
                        return S(i3).U(str, i3, null);
                    }
                    return messageRecord;
                }
            }
        }
        messageRecord = null;
        if (messageRecord == null) {
        }
    }

    public MessageRecord y1(String str, int i3) {
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 66, (Object) this, (Object) str, i3);
        }
        List<MessageRecord> p16 = S(i3).p(str, i3);
        if (p16 == null) {
            return null;
        }
        int size = p16.size() - 1;
        while (true) {
            if (size >= 0) {
                messageRecord = p16.get(size);
                if (messageRecord.isValid && !ad.D(messageRecord.msgtype)) {
                    if (messageRecord.isLongMsg()) {
                        messageRecord = C(messageRecord);
                    }
                } else {
                    size--;
                }
            } else {
                messageRecord = null;
                break;
            }
        }
        if (messageRecord == null) {
            return S(i3).U(str, i3, null);
        }
        return messageRecord;
    }

    public IMessageManager z1(String str) {
        IMessageManager iMessageManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IMessageManager) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        Map<String, IMessageManager> map = this.N;
        if (map == null) {
            return null;
        }
        if (!map.containsKey(str)) {
            synchronized (this.N) {
                if (!this.N.containsKey(str)) {
                    if ("dataline_manager_pc".equals(str)) {
                        iMessageManager = new com.tencent.mobileqq.app.message.e(this.I, this);
                    } else if ("dataline_manager_ipad".equals(str)) {
                        iMessageManager = new com.tencent.mobileqq.app.message.d(this.I, this);
                    } else if ("dataline_manager_phone".equals(str)) {
                        iMessageManager = new com.tencent.mobileqq.app.message.f(this.I, this);
                    } else {
                        iMessageManager = null;
                    }
                    if (iMessageManager == null) {
                        return null;
                    }
                    this.N.put(str, iMessageManager);
                }
            }
        }
        return this.N.get(str);
    }

    public QQMessageFacade(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.J = null;
        this.K = -1;
        this.N = new ConcurrentHashMap();
        this.I = qQAppInterface;
        this.Q = new com.tencent.imcore.message.facade.h(this, qQAppInterface);
        if (com.tencent.mobileqq.startup.director.a.n() == null) {
            J1();
        }
    }

    private void k1(String str, int i3, long j3, int i16, boolean z16, List list) {
    }
}
