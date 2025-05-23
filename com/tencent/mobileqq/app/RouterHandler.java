package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class RouterHandler extends BusinessHandler implements LiteTransferOperatorCallback, LiteTransferListenerCallback {
    static IPatchRedirector $redirector_;
    protected HashMap<Long, RouterMsgRecord> C;
    long D;
    protected HashMap<Long, Session> E;

    /* renamed from: d, reason: collision with root package name */
    protected String f195006d;

    /* renamed from: e, reason: collision with root package name */
    QQAppInterface f195007e;

    /* renamed from: f, reason: collision with root package name */
    protected LiteTransferWrapper f195008f;

    /* renamed from: h, reason: collision with root package name */
    private NotifyReceiver f195009h;

    /* renamed from: i, reason: collision with root package name */
    protected ProtocolHelper f195010i;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<RouterMsgRecord> f195011m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.RouterHandler$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubMsgType0x7$MsgBody.MsgHeader f195012d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f195013e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f195014f;
        final /* synthetic */ RouterHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f195008f.OnPbMsgReceive(this.this$0.f195010i.MsgCSBodyFromNFCNotify(0, this.f195012d, this.f195013e, this.f195014f));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.RouterHandler$2, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubMsgType0x7$MsgBody.MsgHeader f195015d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f195016e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f195017f;
        final /* synthetic */ RouterHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.this$0.f195008f.OnPbMsgReceive(this.this$0.f195010i.MsgCSBodyFromFTNNotify(0, this.f195015d, this.f195016e, this.f195017f));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.RouterHandler$8, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass8 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ RouterHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class NotifyReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        public NotifyReceiver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RouterHandler.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent != null && (action = intent.getAction()) != null) {
                if (!action.equals(QQAppInterface.QQ_ACTION_LOGOUT) && !action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED) && !action.equals(NewIntent.ACTION_FORCE_LOGOUT)) {
                    if (!action.equals("mqq.intent.action.EXIT_" + RouterHandler.this.f195007e.getApp().getPackageName()) && !action.equals(NewIntent.ACTION_LOGOUT)) {
                        return;
                    }
                }
                RouterHandler.this.H2();
            }
        }
    }

    public RouterHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195006d = "router";
        this.f195007e = null;
        this.f195009h = null;
        this.f195011m = new ArrayList<>();
        this.C = new HashMap<>();
        this.D = 0L;
        this.E = new HashMap<>();
        this.f195007e = qQAppInterface;
        this.f195010i = new ProtocolHelper(this.f195007e, 1);
        this.f195008f = new LiteTransferWrapper(this, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QQAppInterface.QQ_ACTION_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
        intentFilter.addAction("mqq.intent.action.EXIT_" + this.f195007e.getApp().getPackageName());
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        this.f195009h = new NotifyReceiver();
        this.f195007e.getApp().registerReceiver(this.f195009h, intentFilter);
    }

    private int G2(int i3) {
        if (i3 == 3 || i3 != 1) {
            return -2005;
        }
        return -2000;
    }

    private void I2(String str) {
        QQMessageFacade messageFacade = this.f195007e.getMessageFacade();
        if (messageFacade == null) {
            return;
        }
        EntityManager createEntityManager = this.f195007e.getEntityManagerFactory().createEntityManager();
        RecentUser findRecentUserByUin = this.f195007e.getProxyManager().m().findRecentUserByUin(str, 6002);
        createEntityManager.close();
        if (findRecentUserByUin != null) {
            messageFacade.K0(findRecentUserByUin);
        }
    }

    private void J2(RouterMsgRecord routerMsgRecord) {
        String l3 = Long.toString(routerMsgRecord.peerDin);
        String F2 = F2(routerMsgRecord.peerDin);
        RecentUserProxy m3 = this.f195007e.getProxyManager().m();
        RecentUser findRecentUserByUin = m3.findRecentUserByUin(l3, 6002);
        findRecentUserByUin.setType(6002);
        findRecentUserByUin.lastmsgtime = com.tencent.mobileqq.service.message.e.K0();
        findRecentUserByUin.displayName = F2;
        findRecentUserByUin.msgType = routerMsgRecord.msgtype;
        m3.saveRecentUser(findRecentUserByUin);
    }

    private void K2(int i3, MsgCSBody0x211 msgCSBody0x211) {
        if (msgCSBody0x211.uMsgSubType != 7) {
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211");
                return;
            }
            return;
        }
        L2(i3, msgCSBody0x211.msgBody0x211_0x7);
    }

    private void L2(int i3, MsgCSBody0x211_0x7 msgCSBody0x211_0x7) {
        long j3 = msgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
        if (QLog.isColorLevel()) {
            QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
        }
    }

    private void M2(int i3, MsgCSBody0x346 msgCSBody0x346) {
        if (QLog.isColorLevel()) {
            QLog.d("dataline.Router", 2, "SendPbMsg: _handleCSMsg0x346");
        }
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(msgCSBody0x346.uMsgSubType);
        cmd0x346_reqbody.uint32_seq.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(56);
        cmd0x346_reqbody.uint32_client_type.set(310);
        this.f195010i.FillReqBody(msgCSBody0x346, cmd0x346_reqbody);
    }

    private void P2(RouterMsgRecord routerMsgRecord, boolean z16) {
        boolean z17;
        String f16 = com.tencent.imcore.message.ao.f(String.valueOf(routerMsgRecord.peerDin), 6002);
        QQMessageFacade messageFacade = this.f195007e.getMessageFacade();
        if (messageFacade == null) {
            return;
        }
        if (messageFacade.f116349e.containsKey(f16)) {
            z17 = messageFacade.f116349e.get(f16).hasReply;
            messageFacade.f116349e.remove(f16);
        } else {
            z17 = false;
        }
        routerMsgRecord.frienduin = String.valueOf(routerMsgRecord.peerDin);
        Message message = new Message();
        MessageRecord.copyMessageRecordBaseField(message, routerMsgRecord);
        message.emoRecentMsg = null;
        message.hasReply = z17;
        messageFacade.w(message);
        messageFacade.f116349e.put(f16, message);
        if (z16) {
            I2(String.valueOf(routerMsgRecord.peerDin));
        }
    }

    public void D2(RouterMsgRecord routerMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) routerMsgRecord);
            return;
        }
        this.f195007e.getProxyManager().addMsgQueue(String.valueOf(0), 0, routerMsgRecord.getTableName(), routerMsgRecord.m174clone(), 0, null);
        J2(routerMsgRecord);
        P2(routerMsgRecord, true);
    }

    public void E2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
        } else {
            this.f195008f.CancelAll(i3, false);
        }
    }

    public String F2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this, j3);
        }
        return BaseApplication.getContext().getString(R.string.ahi);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void GetThumbFilePath(int i3, Session session) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) session);
        }
    }

    protected void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("dataline.Router", 2, "--->>logout cancel all task");
        }
        E2(32);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void HandleSession(int i3, long j3, int i16, MsgHeader msgHeader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), msgHeader);
        } else if (i16 == 5) {
            new Handler(Looper.getMainLooper()).post(new Runnable(j3, msgHeader) { // from class: com.tencent.mobileqq.app.RouterHandler.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f195018d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ MsgHeader f195019e;

                {
                    this.f195018d = j3;
                    this.f195019e = msgHeader;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RouterHandler.this, Long.valueOf(j3), msgHeader);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Session session = RouterHandler.this.E.get(Long.valueOf(this.f195018d));
                    if (session == null) {
                        EntityManager createEntityManager = RouterHandler.this.f195007e.getEntityManagerFactory().createEntityManager();
                        List<Entity> rawQuery = DBMethodProxy.rawQuery(createEntityManager, RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + this.f195019e.uint64_src_uin + " where uSessionID=?", new String[]{String.valueOf(this.f195018d)});
                        createEntityManager.close();
                        if (rawQuery != null && rawQuery.size() > 0) {
                            session = RouterHandler.this.f195010i.genSession(0, ((RouterMsgRecord) rawQuery.get(0)).filename, null, 0, 0, this.f195018d, 0, 0, 0);
                            if (session != null) {
                                if (0 == session.uSessionID) {
                                    session.uSessionID = RouterHandler.this.f195008f.generateSessionID(0);
                                }
                                session.msgHeader = RouterHandler.this.f195010i.msgHeader(this.f195019e.uint64_src_uin);
                                RouterHandler.this.f195010i.fillService(session, null, null);
                                RouterHandler.this.E.put(Long.valueOf(session.uSessionID), session);
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("dataline.Router", 2, "cannot find session from db and memory, sessiondi=" + this.f195018d);
                        }
                    }
                    if (session != null) {
                        ArrayList<Session> arrayList = new ArrayList<>();
                        arrayList.add(session);
                        RouterHandler.this.N2(arrayList, true);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("dataline.Router", 2, "cannot handle session, sessiondi=" + this.f195018d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void InvokeReport(ReportItem reportItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) reportItem);
        } else {
            com.dataline.util.k.b(this.f195007e, reportItem, com.dataline.util.k.f32464c);
        }
    }

    protected void N2(ArrayList<Session> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        ArrayList<Session> arrayList2 = new ArrayList<>();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f195010i.showNoNetworkDialog();
            return;
        }
        Iterator<Session> it = arrayList.iterator();
        while (it.hasNext()) {
            Session next = it.next();
            File file = new File(next.strFilePathSrc);
            if (!z16 && !file.exists()) {
                this.f195010i.showFileNotExistDialog(file.getName());
            } else if (!z16 && file.length() == 0) {
                this.f195010i.showFileIsEmptyDialog(file.getName());
            } else if (!z16 && file.length() > 2147483648L) {
                this.f195010i.showFileTooLargeDialog(file.getName());
            } else {
                arrayList2.add(next);
            }
        }
        if (arrayList2.size() == 0) {
            return;
        }
        LiteTransferWrapper liteTransferWrapper = this.f195008f;
        if (arrayList2.size() != 1) {
            z17 = true;
        }
        liteTransferWrapper.SendGroup(arrayList2, z16, z17);
    }

    public void O2(RouterMsgRecord routerMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) routerMsgRecord);
            return;
        }
        ProxyManager proxyManager = this.f195007e.getProxyManager();
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(routerMsgRecord.status));
        proxyManager.addMsgQueue(String.valueOf(0), 0, routerMsgRecord.getTableName(), contentValues, "msgId=?", new String[]{String.valueOf(routerMsgRecord.msgId)}, 1, null);
        P2(routerMsgRecord, true);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnGroupComplete(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnGroupStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public boolean OnQueryAutoDownload(long j3, byte b16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Byte.valueOf(b16))).booleanValue();
        }
        if (b16 != 2) {
            return true;
        }
        boolean isWifiConnected = NetworkUtil.isWifiConnected(BaseApplication.getContext());
        if (j3 <= 3145728) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!isWifiConnected && (!getAutoDownload() || !z16)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionComplete(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.d("dataline.Router", 1, "OnSessionComplete uSessionID=" + j3 + " retCode=" + i16 + " TaskStatus=" + i3);
        new Handler(Looper.getMainLooper()).post(new Runnable(j3, i3) { // from class: com.tencent.mobileqq.app.RouterHandler.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f195025d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f195026e;

            {
                this.f195025d = j3;
                this.f195026e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RouterHandler.this, Long.valueOf(j3), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Session session = RouterHandler.this.E.get(Long.valueOf(this.f195025d));
                if (this.f195026e == 2 && session != null) {
                    RouterHandler.this.E.remove(Long.valueOf(this.f195025d));
                }
                RouterHandler.this.Q2(2, session, 0.0d, this.f195026e);
            }
        });
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionConnected(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionNew(Session session, NFCInfo nFCInfo, FTNInfo fTNInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, session, nFCInfo, fTNInfo);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(session) { // from class: com.tencent.mobileqq.app.RouterHandler.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Session f195020d;

                {
                    this.f195020d = session;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RouterHandler.this, (Object) session);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        RouterHandler.this.E.put(Long.valueOf(this.f195020d.uSessionID), this.f195020d);
                        RouterHandler.this.Q2(3, this.f195020d, 0.0d, 0);
                    }
                }
            });
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionProgress(long j3, long j16, long j17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(j3, j16, j17) { // from class: com.tencent.mobileqq.app.RouterHandler.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f195022d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f195023e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f195024f;

                {
                    this.f195022d = j3;
                    this.f195023e = j16;
                    this.f195024f = j17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RouterHandler.this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        RouterHandler.this.Q2(1, RouterHandler.this.E.get(Long.valueOf(this.f195022d)), (float) ((((float) this.f195023e) * 1.0d) / ((float) this.f195024f)), 0);
                    }
                }
            });
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionStart(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(j3) { // from class: com.tencent.mobileqq.app.RouterHandler.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f195021d;

                {
                    this.f195021d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RouterHandler.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Session session = RouterHandler.this.E.get(Long.valueOf(this.f195021d));
                    if (session == null) {
                        Iterator<RouterMsgRecord> it = RouterHandler.this.f195011m.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            RouterMsgRecord next = it.next();
                            if (next.uSessionID == this.f195021d && (session = RouterHandler.this.f195010i.genSession(0, next.filename, null, DataLineHandler.D4(next.msgtype), 0, this.f195021d, 0, 0, 0)) != null) {
                                if (0 == session.uSessionID) {
                                    session.uSessionID = RouterHandler.this.f195008f.generateSessionID(0);
                                }
                                session.msgHeader = RouterHandler.this.f195010i.msgHeader(next.peerDin);
                                RouterHandler routerHandler = RouterHandler.this;
                                routerHandler.f195010i.fillService(session, routerHandler.f195006d, null);
                                RouterHandler.this.E.put(Long.valueOf(this.f195021d), session);
                                RouterHandler.this.C.put(Long.valueOf(next.uSessionID), next);
                            }
                        }
                    }
                    RouterHandler.this.Q2(0, session, 0.0d, 0);
                }
            });
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionStartRun(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        }
    }

    @Override // com.tencent.litetransfersdk.LiteTransferListenerCallback
    public void OnSessionUpdate(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Long.valueOf(j3), str);
        }
    }

    public void Q2(int i3, Session session, double d16, int i16) {
        int i17;
        Object[] objArr;
        int i18;
        int i19;
        boolean z16;
        boolean z17;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), session, Double.valueOf(d16), Integer.valueOf(i16));
            return;
        }
        if (session == null) {
            if (QLog.isColorLevel()) {
                QLog.d("dataline.Router", 2, "updateSession\u65f6\uff0csession\u4e3a\u7a7a, updateType[" + i3 + "], fProgress[" + d16 + "], emTaskStatus[" + i16);
                return;
            }
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        i19 = 0;
                    } else {
                        long j3 = this.D + 1;
                        this.D = j3;
                        RouterMsgRecord routerMsgRecord = new RouterMsgRecord(j3);
                        long j16 = session.msgHeader.uint64_src_uin;
                        routerMsgRecord.setTableName(String.valueOf(j16));
                        routerMsgRecord.uSessionID = session.uSessionID;
                        if (QLog.isColorLevel()) {
                            QLog.d("dataline.Router", 2, "\u83b7\u5f97sessionID=" + routerMsgRecord.uSessionID + ", path=" + session.strFilePathSrc + "din:" + j16);
                        }
                        routerMsgRecord.filename = session.strFilePathSrc;
                        routerMsgRecord.fileSize = session.uFileSizeSrc;
                        routerMsgRecord.issend = session.bSend ? 1 : 0;
                        routerMsgRecord.peerDin = j16;
                        routerMsgRecord.f203106msg = "file";
                        routerMsgRecord.msgtype = G2(session.emFileType);
                        routerMsgRecord.extInt = 1;
                        routerMsgRecord.time = com.tencent.mobileqq.service.message.e.K0();
                        this.f195011m.add(routerMsgRecord);
                        D2(routerMsgRecord);
                        this.C.put(Long.valueOf(routerMsgRecord.uSessionID), routerMsgRecord);
                        if (session.bSend) {
                            i26 = 7;
                        } else {
                            i26 = 6;
                        }
                        Boolean bool = Boolean.FALSE;
                        objArr = new Object[]{0L, Long.valueOf(session.uSessionID), session.strFilePathSrc, Byte.valueOf((byte) session.emFileType), bool, bool, Long.valueOf(session.uFileSizeSrc)};
                        i18 = i26;
                        z16 = true;
                        notifyUI(i18, z16, objArr);
                    }
                } else {
                    RouterMsgRecord routerMsgRecord2 = this.C.get(Long.valueOf(session.uSessionID));
                    if (routerMsgRecord2 != null) {
                        if (i16 == 2) {
                            routerMsgRecord2.progress = 1.0d;
                            routerMsgRecord2.status = 3;
                        } else if (i16 != 32 && i16 != 11 && i16 != 8) {
                            routerMsgRecord2.status = 4;
                        } else {
                            routerMsgRecord2.status = 5;
                        }
                        routerMsgRecord2.msgtype = G2(session.emFileType);
                        routerMsgRecord2.f203106msg = "file";
                        routerMsgRecord2.extInt = routerMsgRecord2.status;
                        routerMsgRecord2.time = com.tencent.mobileqq.service.message.e.K0();
                        O2(routerMsgRecord2);
                        if (routerMsgRecord2.status != 5) {
                            this.C.remove(Long.valueOf(session.uSessionID));
                        }
                        if (session.bSend) {
                            i18 = 2;
                        } else {
                            i18 = 3;
                        }
                        if (i16 == 2) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objArr = new Object[]{0L, Long.valueOf(session.uSessionID), session.strFilePathSrc};
                        z16 = z17;
                        notifyUI(i18, z16, objArr);
                    }
                    i19 = 0;
                }
            } else {
                RouterMsgRecord routerMsgRecord3 = this.C.get(Long.valueOf(session.uSessionID));
                if (routerMsgRecord3 != null) {
                    routerMsgRecord3.status = 2;
                    float f16 = (float) d16;
                    routerMsgRecord3.progress = f16;
                    objArr = new Object[]{0L, Long.valueOf(session.uSessionID), Float.valueOf(f16)};
                    z16 = true;
                    i18 = 4;
                    notifyUI(i18, z16, objArr);
                }
                i19 = 0;
            }
            objArr = null;
            i18 = i19;
            z16 = i18;
            notifyUI(i18, z16, objArr);
        }
        RouterMsgRecord routerMsgRecord4 = this.C.get(Long.valueOf(session.uSessionID));
        if (routerMsgRecord4 != null) {
            routerMsgRecord4.status = 2;
            routerMsgRecord4.progress = d16;
            if (session.bSend) {
                i17 = 7;
            } else {
                i17 = 6;
            }
            objArr = new Object[]{0L, Long.valueOf(session.uSessionID), session.strFilePathSrc, Byte.valueOf((byte) session.emFileType), Boolean.FALSE, Boolean.TRUE, Long.valueOf(session.uFileSizeSrc)};
            i18 = i17;
            z16 = true;
            notifyUI(i18, z16, objArr);
        }
        i19 = 0;
        objArr = null;
        i18 = i19;
        z16 = i18;
        notifyUI(i18, z16, objArr);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public void SendPbMsg(int i3, MsgCSBody msgCSBody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) msgCSBody);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("dataline.Router", 2, "SendPbMsg: msgBody.uMsgType[" + msgCSBody.uMsgType + "], nCookie[" + i3);
        }
        int i16 = msgCSBody.uMsgType;
        if (i16 != 529) {
            if (i16 != 838) {
                if (QLog.isColorLevel()) {
                    QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form JNI");
                    return;
                }
                return;
            }
            M2(i3, msgCSBody.msgBody0x346);
            return;
        }
        K2(i3, msgCSBody.msgBody0x211);
    }

    @Override // com.tencent.litetransfersdk.LiteTransferOperatorCallback
    public boolean getAutoDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f195007e.getPreferences().getBoolean("auto_receive_files", false);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return k.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f195007e;
        if (qQAppInterface != null && qQAppInterface.getApp() != null && this.f195009h != null) {
            this.f195007e.getApp().unregisterReceiver(this.f195009h);
            this.f195009h = null;
        }
        E2(32);
        LiteTransferWrapper liteTransferWrapper = this.f195008f;
        if (this.C.size() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        liteTransferWrapper.endLiteTransfer(z16);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void sendFilesWithService(ArrayList<FileInfo> arrayList, String str, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, arrayList, str, bArr, Long.valueOf(j3));
            return;
        }
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        ArrayList<Session> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            Session genSession = this.f195010i.genSession(0, arrayList.get(i3).k(), null, 0, 0, 0L, 0, 0, 0);
            if (genSession != null) {
                arrayList2.add(genSession);
                genSession.uSessionID = this.f195008f.generateSessionID(0);
                genSession.msgHeader = this.f195010i.msgHeader(j3);
                this.f195010i.fillService(genSession, str, bArr);
            }
        }
        if (arrayList2.size() > 0) {
            N2(arrayList2, false);
        }
    }
}
