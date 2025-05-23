package com.tencent.mobileqq.msgbackup.controller;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMsgBackupProxy;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.IDataMigrationGetMsgListCalback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITaskFinishCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupController implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public static String Q;
    private static int R;
    private static int S;
    private static int T;
    private static int U;
    private AtomicBoolean C;
    private HandlerThread D;
    private Executor E;
    private HandlerThread F;
    private Handler G;
    private ArrayList<String> H;
    private ArrayList<String> I;
    private ConcurrentHashMap<String, com.tencent.mobileqq.msgbackup.data.b> J;
    private ConcurrentHashMap<String, j> K;
    private ConcurrentHashMap<String, j> L;
    private ConcurrentHashMap<String, j> M;
    private ConcurrentHashMap<String, String> N;
    private i P;

    /* renamed from: d, reason: collision with root package name */
    private BaseQQAppInterface f251012d;

    /* renamed from: e, reason: collision with root package name */
    private List<d> f251013e;

    /* renamed from: f, reason: collision with root package name */
    private int f251014f;

    /* renamed from: h, reason: collision with root package name */
    private MqqHandler f251015h;

    /* renamed from: i, reason: collision with root package name */
    private MqqHandler f251016i;

    /* renamed from: m, reason: collision with root package name */
    private HandlerThread f251017m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgBackupController.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MsgBackupController.this.r(message);
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements ITaskFinishCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f251032a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f251033b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.msgbackup.data.b f251034c;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements IOperateCallback {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public void onResult(int i3, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                } else {
                    QLog.d(MsgBackupController.Q, 1, "addRecentContact onResult: ", Integer.valueOf(i3), " errMsg: ", str);
                }
            }
        }

        b(j jVar, int i3, com.tencent.mobileqq.msgbackup.data.b bVar) {
            this.f251032a = jVar;
            this.f251033b = i3;
            this.f251034c = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MsgBackupController.this, jVar, Integer.valueOf(i3), bVar);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ITaskFinishCallback
        public void onResult(int i3, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Long.valueOf(j3));
                return;
            }
            QLog.d(MsgBackupController.Q, 1, "dataMigrationImportMsgPbRecord onResult: ", Integer.valueOf(i3), " errMsg: ", str, " taskId: ", Long.valueOf(j3));
            synchronized (this) {
                MsgBackupController.f(MsgBackupController.this, MsgBackupController.R);
                this.f251032a.f251092k += this.f251033b;
                QLog.d(MsgBackupController.Q, 1, "segmentDaoru step segment startNext,request.doneCount = " + this.f251032a.f251092k + " ,mPendingMsgCount = " + MsgBackupController.this.f251014f + ",totalCount = " + this.f251032a.f251091j + " ,uin = " + this.f251032a.f251082a);
                j jVar = this.f251032a;
                if (jVar.f251092k >= jVar.f251091j) {
                    if (MsgBackupController.this.P != null && MsgBackupController.this.P.f251080h != null) {
                        com.tencent.mobileqq.msgbackup.data.h hVar = new com.tencent.mobileqq.msgbackup.data.h();
                        j jVar2 = this.f251032a;
                        hVar.f251142a = jVar2.f251082a;
                        hVar.f251143b = jVar2.f251084c;
                        MsgBackupController.this.P.f251080h.a(MsgBackupController.this.P, hVar);
                    }
                    QLog.d(MsgBackupController.Q, 1, "segmentDaoru step this session has process done ,uin = " + this.f251032a.f251082a + " ,uintype = " + this.f251032a.f251084c);
                    MsgBackupController.this.J.remove(this.f251034c.c());
                    this.f251034c.a();
                    MsgBackupController.this.f251016i.removeCallbacksAndMessages(null);
                    MsgBackupController.this.f251016i.sendEmptyMessage(3);
                    IKernelService i16 = com.tencent.qqnt.msg.f.i();
                    if (i16 == null) {
                        QLog.d(MsgBackupController.Q, 1, "kernelService is null!");
                        return;
                    }
                    aa recentContactService = i16.getRecentContactService();
                    if (recentContactService == null) {
                        QLog.d(MsgBackupController.Q, 1, "recentContactService is null!");
                        return;
                    }
                    int n3 = MsgBackupController.this.n(this.f251032a.f251085d);
                    String str2 = MsgBackupController.Q;
                    String str3 = this.f251032a.f251082a;
                    QLog.d(str2, 1, "chatType: ", Integer.valueOf(n3), " request.uin: ", str3, " touid: ", MsgBackupController.this.o(str3));
                    String o16 = MsgBackupController.this.o(this.f251032a.f251082a);
                    j jVar3 = this.f251032a;
                    if (jVar3.f251085d == 1) {
                        o16 = jVar3.f251082a;
                    }
                    recentContactService.addRecentContact(new Contact(n3, o16, ""), new a());
                } else {
                    MsgBackupController.this.f251016i.sendEmptyMessage(4);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        Q = "MsgBackup_MsgBackupController";
        R = 500;
        S = 5000;
        T = 1000;
        U = 10000;
    }

    public MsgBackupController(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.C = new AtomicBoolean(false);
        this.H = new ArrayList<>();
        this.I = new ArrayList<>();
        this.f251012d = baseQQAppInterface;
        if (this.D == null) {
            HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("MsgbackupController_request", 5);
            this.D = newFreeHandlerThread;
            newFreeHandlerThread.start();
            this.f251015h = new MqqHandler(this.D.getLooper(), this);
        }
        if (this.f251016i == null) {
            HandlerThread newFreeHandlerThread2 = ThreadManagerV2.newFreeHandlerThread("MsgbackupController_flow", 5);
            this.f251017m = newFreeHandlerThread2;
            newFreeHandlerThread2.start();
            this.f251016i = new MqqHandler(this.f251017m.getLooper(), new a());
        }
        if (this.F == null) {
            HandlerThread newFreeHandlerThread3 = ThreadManagerV2.newFreeHandlerThread("MSGBACKUP_MOVEOUT", 5);
            this.F = newFreeHandlerThread3;
            newFreeHandlerThread3.start();
            this.G = new Handler(this.F.getLooper());
        }
        if (this.E == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            com.tencent.mobileqq.msgbackup.util.f.D(Q, "MsgBackupController cpuCount = %d ", Integer.valueOf(availableProcessors));
            ThreadPoolParams threadPoolParams = new ThreadPoolParams();
            int i3 = (availableProcessors * 2) + 1;
            threadPoolParams.corePoolsize = availableProcessors;
            threadPoolParams.maxPooolSize = i3;
            threadPoolParams.priority = 5;
            threadPoolParams.poolThreadName = "msgbackupThreadPool";
            this.E = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
            S = R * i3;
            U = i3 * T;
        }
        this.K = new ConcurrentHashMap<>();
        this.L = new ConcurrentHashMap<>();
        this.M = new ConcurrentHashMap<>();
        this.J = new ConcurrentHashMap<>();
        this.N = new ConcurrentHashMap<>();
        this.f251013e = new ArrayList();
        g gVar = new g(this.f251012d);
        l lVar = new l(this.f251012d);
        f fVar = new f(this.f251012d);
        this.f251013e.add(gVar);
        this.f251013e.add(lVar);
        this.f251013e.add(fVar);
    }

    private void A(j jVar) {
        this.M.clear();
        this.N.clear();
        this.M.put(m(jVar.f251082a, jVar.f251084c), jVar);
        this.f251016i.sendEmptyMessage(5);
        com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_start");
    }

    private void B(j jVar, com.tencent.mobileqq.msgbackup.data.b bVar) {
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.e(Q, 1, "kernelMsgService is null!");
            return;
        }
        ChatInfo chatInfo = new ChatInfo(jVar.f251085d, jVar.f251083b);
        QLog.d(Q, 1, "chatInfo.chatType: " + jVar.f251085d + "chatInfo.uid: " + chatInfo.getPeerUid());
        ArrayList arrayList = new ArrayList();
        if (jVar.f251090i) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(0);
            arrayList.add(new MsgTypeFilter(2, arrayList2));
        }
        ArrayList arrayList3 = new ArrayList();
        QLog.d(Q, 1, "isAllText is " + jVar.f251090i + ", startTime is " + jVar.f251088g, ", endTime is " + jVar.f251089h);
        e16.dataMigrationGetMsgList(new QueryMsgsParams(chatInfo, arrayList, arrayList3, jVar.f251088g, jVar.f251089h, R, true, true), new IDataMigrationGetMsgListCalback(bVar, jVar) { // from class: com.tencent.mobileqq.msgbackup.controller.MsgBackupController.2
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.msgbackup.data.b f251018a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ j f251019b;

            {
                this.f251018a = bVar;
                this.f251019b = jVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MsgBackupController.this, bVar, jVar);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IDataMigrationGetMsgListCalback
            public void onResult(int i3, String str, boolean z16, ArrayList<DataMigrationMsgInfo> arrayList4, ArrayList<DataMigrationResourceInfo> arrayList5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), arrayList4, arrayList5);
                    return;
                }
                if (arrayList4 != null && arrayList5 != null && str != null) {
                    QLog.d(MsgBackupController.Q, 1, "dataMigrationGetMsgList result = " + i3 + ", errMsg = " + str + ", hasMore = " + z16 + ", msgInfoListSize = " + arrayList4.size() + ", resourceInfoListSize = " + arrayList5.size());
                }
                MsgBackupController.this.G.post(new Runnable(arrayList4, arrayList5, z16) { // from class: com.tencent.mobileqq.msgbackup.controller.MsgBackupController.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ArrayList f251021d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ArrayList f251022e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f251023f;

                    {
                        this.f251021d = arrayList4;
                        this.f251022e = arrayList5;
                        this.f251023f = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AnonymousClass2.this, arrayList4, arrayList5, Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.d(MsgBackupController.Q, 1, "begin segmentExcuteQianchu");
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        MsgBackupController.this.G(anonymousClass2.f251018a, anonymousClass2.f251019b, this.f251021d, this.f251022e, this.f251023f);
                    }
                });
            }
        });
    }

    private void D(String str, String str2, long j3) {
        MsgBackupTransportProcessor.u().h(str, str2, j3);
    }

    private void E() {
        MsgBackupTransportProcessor.u().G0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(List<MsgBackupResEntity> list, j jVar, int i3) {
        QLog.d(Q, 1, "segmentExcuteQianru step:query res.size = " + list.size());
        for (MsgBackupResEntity msgBackupResEntity : list) {
            Iterator<d> it = this.f251013e.iterator();
            while (true) {
                if (it.hasNext()) {
                    d next = it.next();
                    if (next.c(msgBackupResEntity)) {
                        com.tencent.mobileqq.msgbackup.util.d.b();
                        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251379i++;
                        k b16 = next.b(null, msgBackupResEntity);
                        if (b16.b()) {
                            String a16 = b16.a(next, null, msgBackupResEntity);
                            QLog.d(Q, 1, "segmentExcuteQianru step:need res:uin = " + jVar.f251082a + " ,uinType =  " + jVar.f251084c + " ,msgType = " + msgBackupResEntity.msgType + " ,filePath = " + msgBackupResEntity.filePath + " ,clientPath = " + a16 + " , filesize = " + msgBackupResEntity.fileSize);
                            if (TextUtils.isEmpty(a16)) {
                                QLog.d(Q, 1, "segmentExcuteQianru step:need res,but clientPath is empty");
                            } else if (!this.N.containsKey(a16)) {
                                this.N.put(a16, "");
                                D(msgBackupResEntity.filePath, a16, msgBackupResEntity.fileSize);
                            }
                        }
                    }
                }
            }
        }
        synchronized (this) {
            jVar.f251092k += list.size();
            this.f251014f -= i3;
            QLog.d(Q, 1, "segmentExcuteQianru step segment startNext,,request.doneCount = " + jVar.f251092k + " ,mPendingMsgCount = " + this.f251014f + " ,totalCount = " + jVar.f251091j);
            if (jVar.f251092k >= jVar.f251091j) {
                this.f251014f = 0;
                if (this.N.size() > 0) {
                    D(null, null, 0L);
                    this.N.clear();
                } else {
                    this.f251016i.removeCallbacksAndMessages(null);
                    this.f251016i.sendEmptyMessage(6);
                }
                com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_end");
                com.tencent.mobileqq.msgbackup.util.e.d();
            } else {
                this.f251016i.removeCallbacksAndMessages(null);
                this.f251016i.sendEmptyMessage(5);
            }
        }
    }

    private void L() {
        int i3;
        int i16;
        i iVar = this.P;
        if (iVar != null && (i3 = iVar.f251079g) < (i16 = iVar.f251078f)) {
            j jVar = this.L.get(this.I.get(i3));
            if (jVar.f251093l < jVar.f251091j && this.f251014f < S) {
                J(jVar);
            }
            com.tencent.mobileqq.msgbackup.util.f.B(Q, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d,querySingleIndex = %d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(jVar.f251093l));
        }
    }

    static /* synthetic */ int f(MsgBackupController msgBackupController, int i3) {
        int i16 = msgBackupController.f251014f - i3;
        msgBackupController.f251014f = i16;
        return i16;
    }

    private void k(j jVar) {
        String r16 = com.tencent.mobileqq.msgbackup.util.f.r(jVar);
        QLog.d(Q, 1, "analysisFileMeta:start dbName = %s ", r16);
        com.tencent.mobileqq.msgbackup.util.f.b();
        com.tencent.mobileqq.msgbackup.data.b bVar = new com.tencent.mobileqq.msgbackup.data.b(r16);
        List<MsgBackupExtraEntity> g16 = bVar.g();
        if (g16 != null && g16.size() > 0) {
            for (MsgBackupExtraEntity msgBackupExtraEntity : g16) {
                if (msgBackupExtraEntity != null && !TextUtils.isEmpty(msgBackupExtraEntity.name) && msgBackupExtraEntity.name.equalsIgnoreCase("key_meta") && !TextUtils.isEmpty(msgBackupExtraEntity.value)) {
                    String str = msgBackupExtraEntity.value;
                    MsgBackupManager.D = str;
                    String str2 = MsgBackupManager.G.get(str);
                    MsgBackupManager.F = str2;
                    if (TextUtils.isEmpty(str2)) {
                        MsgBackupManager.x().S();
                    }
                }
            }
        }
        bVar.a();
    }

    private String m(String str, int i3) {
        return String.format("%s_%d", str, Integer.valueOf(com.tencent.mobileqq.msgbackup.util.f.q(i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Message message) {
        j nextElement;
        if (!this.C.get()) {
            return;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            v();
                            return;
                        }
                        return;
                    } else {
                        if (this.M.size() > 0 && (nextElement = this.M.elements().nextElement()) != null) {
                            M(nextElement);
                            return;
                        }
                        return;
                    }
                }
                L();
                return;
            }
            t();
            return;
        }
        u();
    }

    private void t() {
        i iVar = this.P;
        if (iVar != null) {
            int i3 = iVar.f251079g + 1;
            iVar.f251079g = i3;
            int i16 = iVar.f251078f;
            QLog.d(Q, 1, "nextDaoru curIndex = " + i3 + ",totalCount = " + i16);
            if (i3 == 0) {
                com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_start");
            }
            if (i3 == i16) {
                com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_end");
                com.tencent.mobileqq.msgbackup.util.e.b();
            }
            if (i3 < i16) {
                j jVar = this.L.get(this.I.get(i3));
                jVar.f251093l = 0;
                QLog.d(Q, 1, "nextDaoru " + jVar.f251082a + " ,uinType = " + jVar.f251084c);
                J(jVar);
            }
        }
    }

    private void u() {
        i iVar = this.P;
        if (iVar != null) {
            if (iVar.f251079g == -1) {
                com.tencent.mobileqq.msgbackup.util.e.j(null, "single_uin_cost");
            } else {
                com.tencent.mobileqq.msgbackup.util.e.j("single_uin_cost", null);
                com.tencent.mobileqq.msgbackup.util.e.j(null, "single_uin_cost");
            }
            i iVar2 = this.P;
            int i3 = iVar2.f251079g + 1;
            iVar2.f251079g = i3;
            int i16 = iVar2.f251078f;
            if (i3 == 0) {
                com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_start");
            }
            if (i3 == i16) {
                com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_end");
                com.tencent.mobileqq.msgbackup.util.e.c();
            }
            if (i3 < i16) {
                j jVar = this.K.get(this.H.get(i3));
                String r16 = com.tencent.mobileqq.msgbackup.util.f.r(jVar);
                com.tencent.mobileqq.msgbackup.data.b.b(r16);
                com.tencent.mobileqq.msgbackup.util.f.b();
                com.tencent.mobileqq.msgbackup.data.b bVar = new com.tencent.mobileqq.msgbackup.data.b(r16);
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(MsgBackupManager.D)) {
                    com.tencent.mobileqq.msgbackup.util.f.B(Q, "file meta is %s, key is %s", MsgBackupManager.D, MsgBackupManager.E);
                    MsgBackupExtraEntity msgBackupExtraEntity = new MsgBackupExtraEntity();
                    msgBackupExtraEntity.name = "key_meta";
                    msgBackupExtraEntity.value = MsgBackupManager.D;
                    arrayList.add(msgBackupExtraEntity);
                    MsgBackupExtraEntity msgBackupExtraEntity2 = new MsgBackupExtraEntity();
                    msgBackupExtraEntity2.name = "db_version";
                    msgBackupExtraEntity2.value = String.valueOf(1);
                    arrayList.add(msgBackupExtraEntity2);
                }
                bVar.d(arrayList);
                bVar.a();
                K(jVar);
            }
        }
    }

    private void v() {
        E();
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        MqqHandler mqqHandler = this.f251015h;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
            this.D.quit();
        }
        MqqHandler mqqHandler2 = this.f251016i;
        if (mqqHandler2 != null) {
            mqqHandler2.removeCallbacksAndMessages(null);
            this.f251017m.quit();
        }
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.F.quit();
        }
    }

    public void F(com.tencent.mobileqq.msgbackup.data.b bVar, j jVar, List<MsgBackupMsgEntity> list, List<MsgBackupResEntity> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, bVar, jVar, list, list2);
        } else if (bVar != null && jVar != null && list != null) {
            y(bVar, jVar, list, list2);
        }
    }

    public void G(com.tencent.mobileqq.msgbackup.data.b bVar, j jVar, List<DataMigrationMsgInfo> list, List<DataMigrationResourceInfo> list2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bVar, jVar, list, list2, Boolean.valueOf(z16));
            return;
        }
        if (bVar != null && list != null && list2 != null) {
            QLog.d(Q, 1, "begin processPackPb uin = " + jVar.f251082a + " ,type = " + jVar.f251084c);
            x(bVar, list, list2);
            if (!z16) {
                i iVar = this.P;
                if (iVar != null && iVar.f251080h != null) {
                    QLog.d(Q, 1, "segmentExcuteQianchu onProgress ,uin = " + jVar.f251082a + " ,uintype = " + jVar.f251084c + " ,msgSize = " + bVar.i() + ", resSize = " + bVar.l());
                    com.tencent.mobileqq.msgbackup.data.h hVar = new com.tencent.mobileqq.msgbackup.data.h();
                    hVar.f251142a = jVar.f251082a;
                    hVar.f251143b = jVar.f251084c;
                    i iVar2 = this.P;
                    iVar2.f251080h.a(iVar2, hVar);
                }
                QLog.d(Q, 1, "segmentExcuteQianchu step this session has process done ,uin = " + jVar.f251082a + " ,uintype = " + jVar.f251084c + " ,msgSize = " + bVar.i() + ", resSize = " + bVar.l());
                this.J.remove(bVar.c());
                bVar.a();
                h.d();
                com.tencent.mobileqq.msgbackup.util.e.g("statis_qianchums_end");
                this.f251016i.removeCallbacksAndMessages(null);
                this.f251016i.sendEmptyMessage(1);
                return;
            }
            return;
        }
        QLog.d(Q, 1, "params is null return");
    }

    public void I(i iVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar, i3);
            return;
        }
        this.C.set(true);
        com.tencent.mobileqq.msgbackup.util.f.B(Q, "sendRequest is called from = %d", Integer.valueOf(i3));
        this.P = iVar;
        if (com.tencent.mobileqq.msgbackup.util.f.f251422b) {
            if (i3 == 10000) {
                Message obtainMessage = this.f251015h.obtainMessage(5);
                obtainMessage.obj = iVar;
                this.f251015h.sendMessageDelayed(obtainMessage, 100L);
                return;
            } else {
                if (i3 == 10001) {
                    MsgBackupManager.D = null;
                    MsgBackupManager.F = null;
                    Message obtainMessage2 = this.f251015h.obtainMessage(7);
                    obtainMessage2.obj = iVar;
                    this.f251015h.sendMessageDelayed(obtainMessage2, 100L);
                    return;
                }
                Message obtainMessage3 = this.f251015h.obtainMessage(0);
                obtainMessage3.obj = iVar;
                this.f251015h.sendMessageDelayed(obtainMessage3, 100L);
                return;
            }
        }
        Message obtainMessage4 = this.f251015h.obtainMessage(0);
        obtainMessage4.obj = iVar;
        this.f251015h.sendMessage(obtainMessage4);
    }

    public void J(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) jVar);
            return;
        }
        MsgBackupManager.D = null;
        MsgBackupManager.F = null;
        k(jVar);
        if (TextUtils.isEmpty(MsgBackupManager.F)) {
            if (this.P.f251080h != null) {
                com.tencent.mobileqq.msgbackup.data.h hVar = new com.tencent.mobileqq.msgbackup.data.h();
                hVar.f251142a = jVar.f251082a;
                hVar.f251143b = jVar.f251084c;
                com.tencent.mobileqq.msgbackup.util.f.B(Q, "singleDaoru progress callback curIndex = %d,totalCount = %d ", Integer.valueOf(jVar.f251094m), Integer.valueOf(jVar.f251091j));
                i iVar = this.P;
                iVar.f251080h.a(iVar, hVar);
            }
            this.f251016i.removeCallbacksAndMessages(null);
            this.f251016i.sendEmptyMessage(3);
            return;
        }
        String r16 = com.tencent.mobileqq.msgbackup.util.f.r(jVar);
        if (this.J.get(r16) == null) {
            this.J.put(r16, new com.tencent.mobileqq.msgbackup.data.b(r16));
        }
        com.tencent.mobileqq.msgbackup.data.b bVar = this.J.get(r16);
        int i3 = bVar.i();
        if (jVar.f251091j == 0) {
            jVar.f251091j = bVar.i();
        }
        if (jVar.f251091j != 0 && (jVar.f251093l < i3 || this.f251014f != 0)) {
            while (jVar.f251093l < i3 && this.f251014f < S) {
                QLog.d(Q, 1, "singleDaoru queryMsgBefore  curIndex = " + jVar.f251094m + " ,totalCount = " + jVar.f251091j + " ,doneCount = " + jVar.f251092k);
                List<MsgBackupMsgEntity> h16 = bVar.h((long) (jVar.f251094m + 1), R);
                List<MsgBackupResEntity> j3 = bVar.j(jVar.f251094m + 1, T);
                jVar.f251093l = jVar.f251093l + R;
                if (h16 != null && h16.size() != 0) {
                    jVar.f251094m = (int) h16.get(h16.size() - 1).getId();
                    QLog.d(Q, 1, "singleDaoru queryMsg result.size = " + h16.size());
                    this.f251014f = this.f251014f + R;
                    this.E.execute(new Runnable(bVar, jVar, h16, j3) { // from class: com.tencent.mobileqq.msgbackup.controller.MsgBackupController.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.msgbackup.data.b f251027d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ j f251028e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ List f251029f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ List f251030h;

                        {
                            this.f251027d = bVar;
                            this.f251028e = jVar;
                            this.f251029f = h16;
                            this.f251030h = j3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, MsgBackupController.this, bVar, jVar, h16, j3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                MsgBackupController.this.F(this.f251027d, this.f251028e, this.f251029f, this.f251030h);
                            }
                        }
                    });
                } else {
                    com.tencent.mobileqq.msgbackup.util.f.B(Q, "singleDaoru..query result == 0", new Object[0]);
                    if (this.f251014f == 0 && this.P.f251080h != null) {
                        com.tencent.mobileqq.msgbackup.util.f.D(Q, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
                        com.tencent.mobileqq.msgbackup.data.h hVar2 = new com.tencent.mobileqq.msgbackup.data.h();
                        hVar2.f251142a = jVar.f251082a;
                        hVar2.f251143b = jVar.f251084c;
                        i iVar2 = this.P;
                        iVar2.f251080h.a(iVar2, hVar2);
                        bVar.a();
                        this.f251016i.sendEmptyMessage(3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.P.f251080h != null) {
            com.tencent.mobileqq.msgbackup.data.h hVar3 = new com.tencent.mobileqq.msgbackup.data.h();
            hVar3.f251142a = jVar.f251082a;
            hVar3.f251143b = jVar.f251084c;
            com.tencent.mobileqq.msgbackup.util.f.B(Q, "singleDaoru progress callback curIndex = %d,totalCount = %d ", Integer.valueOf(jVar.f251094m), Integer.valueOf(jVar.f251091j));
            i iVar3 = this.P;
            iVar3.f251080h.a(iVar3, hVar3);
        }
        bVar.a();
        this.f251016i.sendEmptyMessage(3);
    }

    public void K(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar);
            return;
        }
        String r16 = com.tencent.mobileqq.msgbackup.util.f.r(jVar);
        com.tencent.mobileqq.msgbackup.util.f.B(Q, "singleExcuteQianchu,start uin = %s,dbPath = %s,request.startQueryIndex = %d ", jVar.f251082a, r16, Integer.valueOf(jVar.f251094m));
        if (this.J.get(r16) == null) {
            this.J.put(r16, new com.tencent.mobileqq.msgbackup.data.b(r16));
        }
        B(jVar, this.J.get(r16));
    }

    public void M(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar);
            return;
        }
        String r16 = com.tencent.mobileqq.msgbackup.util.f.r(jVar);
        QLog.d(Q, 1, "singleNextQianru step:start dbName = " + r16 + " ,request.queryIndex = " + jVar.f251094m + " ,request.doneCount = " + jVar.f251092k + " ,mPendingMsgCount = " + this.f251014f + " ,totalCount = " + jVar.f251091j);
        com.tencent.mobileqq.msgbackup.util.f.b();
        com.tencent.mobileqq.msgbackup.data.b bVar = new com.tencent.mobileqq.msgbackup.data.b(r16);
        if (jVar.f251091j == 0) {
            jVar.f251091j = bVar.l();
        }
        int i3 = jVar.f251091j;
        if (i3 != 0 && (jVar.f251093l < i3 || this.f251014f != 0)) {
            while (jVar.f251093l < i3 && this.f251014f < U) {
                QLog.d(Q, 1, "singleNextQianru step:,request.queryIndex = " + jVar.f251094m + " ,request.doneCount = " + jVar.f251092k + " ,mPendingMsgCount = " + this.f251014f + " ,totalCount = " + jVar.f251091j);
                List<MsgBackupResEntity> j3 = bVar.j(jVar.f251094m + 1, T);
                jVar.f251093l = jVar.f251093l + R;
                if (j3 != null && j3.size() > 0) {
                    jVar.f251094m = (int) j3.get(j3.size() - 1).getId();
                    this.f251014f += T;
                    this.E.execute(new Runnable(j3, jVar) { // from class: com.tencent.mobileqq.msgbackup.controller.MsgBackupController.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ List f251025d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ j f251026e;

                        {
                            this.f251025d = j3;
                            this.f251026e = jVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, MsgBackupController.this, j3, jVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                MsgBackupController.this.H(this.f251025d, this.f251026e, MsgBackupController.T);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                } else if (this.f251014f == 0) {
                    if (jVar.f251092k != jVar.f251091j && this.M.size() > 0) {
                        D(null, null, 0L);
                    } else {
                        this.f251016i.removeCallbacksAndMessages(null);
                        this.f251016i.sendEmptyMessage(6);
                    }
                }
            }
            bVar.a();
            return;
        }
        QLog.d(Q, 1, "singleNextQianru step queryResList.size = 0,");
        this.f251016i.removeCallbacksAndMessages(null);
        this.f251016i.sendEmptyMessage(6);
        bVar.a();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        boolean z16 = false;
        if (!this.C.get()) {
            QLog.d(Q, 1, "is not working");
            return false;
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 5) {
                if (i3 != 6) {
                    if (i3 == 7) {
                        if (TextUtils.isEmpty(MsgBackupManager.D)) {
                            QLog.d(Q, 1, "sFileMeta is empty");
                            Object obj = message.obj;
                            if (obj instanceof i) {
                                j jVar = new j();
                                String str = ((i) obj).f251081i;
                                com.tencent.mobileqq.msgbackup.util.f.I(str.substring(str.lastIndexOf("/") + 1), jVar);
                                k(jVar);
                            }
                        }
                        Message obtainMessage = this.f251015h.obtainMessage(6);
                        obtainMessage.obj = message.obj;
                        this.f251015h.sendMessage(obtainMessage);
                    }
                } else {
                    if (TextUtils.isEmpty(MsgBackupManager.D)) {
                        QLog.d(Q, 1, "MSG_WHAT_SUB_DECRYPT_KEY_VALID sFileMeta is null, so skip this session!");
                        E();
                        return true;
                    }
                    String str2 = MsgBackupManager.G.get(MsgBackupManager.D);
                    if (TextUtils.isEmpty(str2)) {
                        Message obtainMessage2 = this.f251015h.obtainMessage(6);
                        obtainMessage2.obj = message.obj;
                        this.f251015h.sendMessageDelayed(obtainMessage2, 1000L);
                    } else {
                        MsgBackupManager.F = str2;
                        Message obtainMessage3 = this.f251015h.obtainMessage(0);
                        obtainMessage3.obj = message.obj;
                        this.f251015h.sendMessage(obtainMessage3);
                    }
                }
            } else if (TextUtils.isEmpty(MsgBackupManager.E)) {
                Message obtainMessage4 = this.f251015h.obtainMessage(5);
                obtainMessage4.obj = message.obj;
                this.f251015h.sendMessageDelayed(obtainMessage4, 1000L);
            } else {
                Message obtainMessage5 = this.f251015h.obtainMessage(0);
                obtainMessage5.what = 0;
                obtainMessage5.obj = message.obj;
                this.f251015h.sendMessage(obtainMessage5);
            }
        } else {
            String str3 = Q;
            Object[] objArr = new Object[2];
            objArr[0] = "MSG_WHAT_SUB_REQUEST_POST msg.obj = %b";
            if (message.obj != null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d(str3, 1, objArr);
            Object obj2 = message.obj;
            if (obj2 instanceof i) {
                s((i) obj2);
            }
        }
        return true;
    }

    public void l(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iVar);
            return;
        }
        HashSet<com.tencent.mobileqq.msgbackup.data.j> hashSet = iVar.f251073a;
        if (hashSet != null && hashSet.size() != 0) {
            this.I.clear();
            this.L.clear();
            this.J.clear();
            Iterator<com.tencent.mobileqq.msgbackup.data.j> it = hashSet.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msgbackup.data.j next = it.next();
                String d16 = next.d();
                int f16 = next.f();
                QLog.d(Q, 1, "daoru uin = " + d16);
                j jVar = new j();
                jVar.f251082a = d16;
                jVar.f251084c = f16;
                jVar.f251085d = f16;
                jVar.f251087f = 2;
                jVar.f251093l = -1;
                jVar.f251094m = -1;
                String m3 = m(d16, f16);
                this.I.add(m3);
                this.L.put(m3, jVar);
            }
            iVar.f251078f = hashSet.size();
            iVar.f251079g = -1;
            this.f251016i.sendEmptyMessage(3);
            return;
        }
        QLog.d(Q, 1, "daoru no recentdBaseData ");
    }

    public int n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, i3)).intValue();
        }
        if (i3 != 0 && i3 != 1) {
            return 0;
        }
        return com.tencent.nt.adapter.session.c.l(i3);
    }

    public String o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        return ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
    }

    public String p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        return ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
    }

    public int q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, i3)).intValue();
        }
        if (i3 != 1 && i3 != 2 && i3 != 100) {
            return 10021;
        }
        return com.tencent.nt.adapter.session.c.c(i3);
    }

    public void s(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar);
            return;
        }
        if (this.C.get() && com.tencent.mobileqq.msgbackup.util.f.b()) {
            int i3 = iVar.f251074b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        QLog.d(Q, 1, "requestDaoru start ");
                        l(iVar);
                        return;
                    }
                    return;
                }
                QLog.d(Q, 1, "requestQianru start ");
                j jVar = new j();
                String str = iVar.f251081i;
                com.tencent.mobileqq.msgbackup.util.f.I(str.substring(str.lastIndexOf("/") + 1), jVar);
                MsgBackupManager.L = jVar.f251082a;
                MsgBackupManager.M = jVar.f251084c;
                A(jVar);
                return;
            }
            int size = iVar.f251073a.size();
            QLog.d(Q, 1, "requestQianchu start,request.dataList.size() = " + size);
            if (size == 0) {
                c cVar = iVar.f251080h;
                if (cVar != null) {
                    cVar.b(1, iVar, null);
                    return;
                }
                return;
            }
            z(iVar);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.f.B(Q, "handleRequest checkDBDirs result = false,requestType = %d ", Integer.valueOf(iVar.f251074b));
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.C.set(false);
        MqqHandler mqqHandler = this.f251015h;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
        MqqHandler mqqHandler2 = this.f251016i;
        if (mqqHandler2 != null) {
            mqqHandler2.removeCallbacksAndMessages(null);
        }
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.J.clear();
        this.H.clear();
        this.K.clear();
        this.I.clear();
        this.K.clear();
        h.a();
        com.tencent.mobileqq.msgbackup.util.e.e();
    }

    public void x(com.tencent.mobileqq.msgbackup.data.b bVar, List<DataMigrationMsgInfo> list, List<DataMigrationResourceInfo> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bVar, list, list2);
            return;
        }
        if (bVar != null && list != null && list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (DataMigrationMsgInfo dataMigrationMsgInfo : list) {
                MsgBackupMsgEntity msgBackupMsgEntity = new MsgBackupMsgEntity();
                msgBackupMsgEntity.chatUin = dataMigrationMsgInfo.getChatUin();
                msgBackupMsgEntity.chatType = dataMigrationMsgInfo.getChatType();
                msgBackupMsgEntity.msgType = dataMigrationMsgInfo.getMsgType();
                msgBackupMsgEntity.msgTime = dataMigrationMsgInfo.getMsgTime();
                msgBackupMsgEntity.msgSeq = dataMigrationMsgInfo.getMsgSeq();
                msgBackupMsgEntity.msgRandom = dataMigrationMsgInfo.getMsgRandom();
                msgBackupMsgEntity.extensionData = dataMigrationMsgInfo.getExtensionData();
                arrayList.add(msgBackupMsgEntity);
            }
            ArrayList arrayList2 = new ArrayList();
            for (DataMigrationResourceInfo dataMigrationResourceInfo : list2) {
                MsgBackupResEntity msgBackupResEntity = new MsgBackupResEntity();
                msgBackupResEntity.msgSeq = dataMigrationResourceInfo.getMsgSeq();
                msgBackupResEntity.msgRandom = dataMigrationResourceInfo.getMsgRandom();
                msgBackupResEntity.msgType = dataMigrationResourceInfo.getMsgType();
                msgBackupResEntity.msgSubType = dataMigrationResourceInfo.getMsgSubType();
                msgBackupResEntity.filePath = dataMigrationResourceInfo.getFilePath();
                msgBackupResEntity.fileSize = dataMigrationResourceInfo.getFileSize();
                msgBackupResEntity.extraDataStr = dataMigrationResourceInfo.getExtraData();
                arrayList2.add(msgBackupResEntity);
            }
            QLog.d(Q, 1, "processPackPb step segment msg process, msgEntityList = " + arrayList.size() + " , resEntityList = " + arrayList2.size());
            bVar.e(arrayList);
            bVar.f(arrayList2);
            QLog.d(Q, 1, "processPackPb step segment insert db done");
        }
    }

    public void y(com.tencent.mobileqq.msgbackup.data.b bVar, j jVar, List<MsgBackupMsgEntity> list, List<MsgBackupResEntity> list2) {
        int i3;
        IMsgBackupProxy iMsgBackupProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        char c16 = 0;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bVar, jVar, list, list2);
            return;
        }
        int size = list.size();
        IMsgBackupProxy iMsgBackupProxy2 = (IMsgBackupProxy) QRoute.api(IMsgBackupProxy.class);
        com.tencent.mobileqq.msgbackup.util.f.B(Q, "segmentDaoru step:query done ,msgEntity.size = %d ", Integer.valueOf(size));
        ArrayList<DataMigrationMsgInfo> arrayList = new ArrayList<>();
        ArrayList<DataMigrationResourceInfo> arrayList2 = new ArrayList<>();
        Iterator<MsgBackupMsgEntity> it = list.iterator();
        while (it.hasNext()) {
            MsgBackupMsgEntity next = it.next();
            DataMigrationMsgInfo dataMigrationMsgInfo = new DataMigrationMsgInfo(next.chatType, next.chatUin, next.msgType, next.msgTime, next.msgSeq, next.msgRandom, next.extensionData, "");
            c16 = 0;
            QLog.d(Q, 1, "msgInfo: ", dataMigrationMsgInfo);
            arrayList.add(dataMigrationMsgInfo);
            i17 = 1;
            size = size;
            it = it;
            i16 = 2;
        }
        int i18 = i16;
        int i19 = i17;
        int i26 = size;
        String str = Q;
        Object[] objArr = new Object[i18];
        objArr[c16] = "msgInfoList: ";
        objArr[i19] = Integer.valueOf(arrayList.size());
        QLog.d(str, i19, objArr);
        if (list2 != null) {
            for (MsgBackupResEntity msgBackupResEntity : list2) {
                IMsgBackupProxy iMsgBackupProxy3 = iMsgBackupProxy2;
                ArrayList<DataMigrationMsgInfo> arrayList3 = arrayList;
                DataMigrationResourceInfo dataMigrationResourceInfo = new DataMigrationResourceInfo(msgBackupResEntity.msgSeq, msgBackupResEntity.msgRandom, msgBackupResEntity.msgType, msgBackupResEntity.msgSubType, msgBackupResEntity.filePath, msgBackupResEntity.fileSize, msgBackupResEntity.extraDataStr);
                QLog.d(Q, 1, "resourceInfo: ", dataMigrationResourceInfo);
                arrayList2.add(dataMigrationResourceInfo);
                Iterator<d> it5 = this.f251013e.iterator();
                while (it5.hasNext()) {
                    it5.next().g(msgBackupResEntity);
                }
                iMsgBackupProxy2 = iMsgBackupProxy3;
                arrayList = arrayList3;
            }
        }
        IMsgBackupProxy iMsgBackupProxy4 = iMsgBackupProxy2;
        ArrayList<DataMigrationMsgInfo> arrayList4 = arrayList;
        QLog.d(Q, 1, "resourceInfoList: ", Integer.valueOf(arrayList2.size()));
        ArrayList<MessageRecord> arrayList5 = new ArrayList(i26);
        int i27 = 0;
        for (MsgBackupMsgEntity msgBackupMsgEntity : list) {
            if (msgBackupMsgEntity.extensionData == null) {
                i27++;
                QLog.d(Q, 1, "segmentDaoru step has encounter msgEntity.extensionData == null,msgType = %d,invalidMsgCount = %d", Integer.valueOf(msgBackupMsgEntity.msgType), Integer.valueOf(i27));
            } else {
                try {
                    iMsgBackupProxy = iMsgBackupProxy4;
                } catch (Throwable th5) {
                    th = th5;
                    iMsgBackupProxy = iMsgBackupProxy4;
                }
                try {
                    MessageRecord transToMessageRecord = iMsgBackupProxy.transToMessageRecord(this.f251012d, msgBackupMsgEntity);
                    if (transToMessageRecord != null) {
                        QLog.d(Q, 1, "messageRecord transToMessageRecord is  " + transToMessageRecord.msgBackupMsgSeq);
                        arrayList5.add(transToMessageRecord);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    QLog.e(Q, 1, "transToMessageRecord " + th);
                    iMsgBackupProxy4 = iMsgBackupProxy;
                }
                iMsgBackupProxy4 = iMsgBackupProxy;
            }
        }
        QLog.d(Q, 1, "segmentDaoru step:trans done ,msg.size =  " + arrayList5.size());
        if (arrayList5.size() > 0) {
            for (MessageRecord messageRecord : arrayList5) {
                Iterator<d> it6 = this.f251013e.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        d next2 = it6.next();
                        if (next2.a(messageRecord)) {
                            List<MsgBackupResEntity> k3 = bVar.k(messageRecord.msgBackupMsgSeq, messageRecord.msgBackupMsgRandom);
                            if (k3 != null) {
                                i3 = k3.size();
                            } else {
                                i3 = 0;
                            }
                            QLog.d(Q, 1, "segmentDaoru step:rich process ,query.res.size = " + i3);
                            next2.f(messageRecord, k3);
                        }
                    }
                }
            }
        }
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.d(Q, 1, "kernelMsgService is null!");
        } else {
            QLog.d(Q, 1, "dataMigrationImportMsgPbRecord taskId: ", e16.dataMigrationImportMsgPbRecord(arrayList4, arrayList2, new b(jVar, i26, bVar)));
        }
    }

    public void z(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.e.f251412j = 0L;
        HashSet<com.tencent.mobileqq.msgbackup.data.j> hashSet = iVar.f251073a;
        if (hashSet != null && hashSet.size() != 0) {
            this.H.clear();
            this.K.clear();
            this.J.clear();
            h.a();
            com.tencent.mobileqq.msgbackup.util.e.e();
            Iterator<com.tencent.mobileqq.msgbackup.data.j> it = hashSet.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.msgbackup.data.j next = it.next();
                String d16 = next.d();
                String c16 = next.c();
                int f16 = next.f();
                int a16 = next.a();
                com.tencent.mobileqq.msgbackup.util.f.B(Q, "requestQianchu uin = %s ", d16);
                j jVar = new j();
                jVar.f251082a = d16;
                jVar.f251083b = c16;
                jVar.f251084c = f16;
                jVar.f251085d = a16;
                jVar.f251087f = 0;
                jVar.f251088g = iVar.f251075c;
                jVar.f251089h = iVar.f251076d;
                jVar.f251090i = iVar.f251077e;
                jVar.f251093l = -1;
                jVar.f251094m = 0;
                String m3 = m(d16, f16);
                this.H.add(m3);
                this.K.put(m3, jVar);
            }
            iVar.f251078f = hashSet.size();
            iVar.f251079g = -1;
            this.f251016i.sendEmptyMessage(1);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.f.B(Q, "qianchu no recentdBaseData ", new Object[0]);
    }
}
