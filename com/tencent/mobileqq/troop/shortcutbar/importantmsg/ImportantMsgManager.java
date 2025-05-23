package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xea3.oidb_0xea3$BackMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ImportantMsgManager extends Observable implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f298659d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f298660e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Long, Integer> f298661f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Long, ImportantMsgItem> f298662h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.f f298663i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager$2, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f298664d;
        final /* synthetic */ ImportantMsgManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.p(this.f298664d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager$3, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f298665d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f298666e;
        final /* synthetic */ ImportantMsgManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.l(this.f298665d, this.f298666e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager$4, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f298667d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f298668e;
        final /* synthetic */ ImportantMsgManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.m(this.f298667d, this.f298668e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.shortcutbar.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImportantMsgManager.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.f
        protected void c(long j3, boolean z16, List<oidb_0xea3$BackMsg> list, List<Long> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ImportantMsgManager.this.r(j3, z16, list, list2);
            } else {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), list, list2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f298675a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f298676b;

        b(ArrayList arrayList, int i3) {
            this.f298675a = arrayList;
            this.f298676b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ImportantMsgManager.this, arrayList, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.d
        public void a(long j3, ImportantMsgItem importantMsgItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), importantMsgItem);
                return;
            }
            if (importantMsgItem == null) {
                return;
            }
            ArrayList<ImportantMsgItem.MsgInfo> msgInfoList = importantMsgItem.getMsgInfoList();
            Iterator it = this.f298675a.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                Long l3 = (Long) it.next();
                int indexOf = msgInfoList.indexOf(com.tencent.mobileqq.troop.shortcutbar.importantmsg.d.b(l3.longValue()));
                if (-1 != indexOf) {
                    msgInfoList.get(indexOf).msgNeedShow = false;
                    msgInfoList.get(indexOf).msgSummary = "";
                    int i3 = this.f298676b;
                    if (i3 == 1) {
                        msgInfoList.get(indexOf).msgNotShowType = 1;
                    } else if (i3 == 2) {
                        msgInfoList.get(indexOf).msgNotShowType = 2;
                    }
                    QLog.i("ImportantMsgManager", 2, "delImportantMsg msgSeq:" + l3 + " from:" + this.f298676b);
                    z16 = true;
                }
            }
            if (z16) {
                ImportantMsgManager.this.t(importantMsgItem.m225clone());
            }
            if (this.f298676b == 1 || z16) {
                ImportantMsgManager.this.q(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f298678a;

        c(ArrayList arrayList) {
            this.f298678a = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImportantMsgManager.this, (Object) arrayList);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.d
        public void a(long j3, ImportantMsgItem importantMsgItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), importantMsgItem);
                return;
            }
            if (importantMsgItem == null) {
                return;
            }
            importantMsgItem.addMsgInfos(this.f298678a);
            if (ImportantMsgManager.this.f298661f.containsKey(Long.valueOf(j3)) && importantMsgItem.maxImportantMsgSeq >= ((Integer) ImportantMsgManager.this.f298661f.get(Long.valueOf(j3))).intValue()) {
                if (QLog.isColorLevel()) {
                    QLog.i("ImportantMsgManager", 2, "handlerPushImportantMsg updateMaxMsgSeq: maxImportantMsgSeq:" + importantMsgItem.maxImportantMsgSeq + " registerProxy lastSeq:" + ImportantMsgManager.this.f298661f.get(Long.valueOf(j3)));
                }
                importantMsgItem.updateMaxMsgSeq();
            }
            ImportantMsgManager.this.t(importantMsgItem.m225clone());
            ImportantMsgManager.this.q(j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        void a(long j3, ImportantMsgItem importantMsgItem);
    }

    public ImportantMsgManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f298661f = new ConcurrentHashMap<>();
        this.f298662h = new HashMap<>();
        this.f298659d = qQAppInterface;
        this.f298660e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        a aVar = new a();
        this.f298663i = aVar;
        this.f298659d.addObserver(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j3, ArrayList<Long> arrayList) {
        i(j3, arrayList, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(long j3, ArrayList<ImportantMsgItem.MsgInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            j(j3, new c(arrayList));
        }
    }

    private void n(long j3, ArrayList<ImportantMsgItem.MsgInfo> arrayList, List<Long> list) {
        if (!this.f298662h.containsKey(Long.valueOf(j3))) {
            QLog.i("ImportantMsgManager", 1, "handlerRspImportantMsg mImportantDataMap notcontains troopUin:" + j3);
            return;
        }
        ImportantMsgItem importantMsgItem = this.f298662h.get(Long.valueOf(j3));
        if (arrayList != null && !arrayList.isEmpty()) {
            importantMsgItem.addMsgInfos(arrayList);
        }
        importantMsgItem.updateMaxMsgSeq();
        QLog.i("ImportantMsgManager", 1, "handlerRspImportantMsg reciveMaxSeq:" + importantMsgItem.maxImportantMsgSeq + " registerProxy lastSeq:" + k(j3));
        t(importantMsgItem.m225clone());
        q(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(HashMap<Long, Integer> hashMap) {
        setChanged();
        notifyObservers(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j3) {
        ImportantMsgItem importantMsgItem = this.f298662h.get(Long.valueOf(j3));
        if (importantMsgItem != null) {
            setChanged();
            notifyObservers(importantMsgItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j3, boolean z16, List<oidb_0xea3$BackMsg> list, List<Long> list2) {
        if (!z16) {
            return;
        }
        o(j3, list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(Entity entity) {
        if (this.f298660e.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f298660e.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f298660e.update(entity);
            }
        }
        return false;
    }

    public void i(long j3, ArrayList<Long> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), arrayList, Integer.valueOf(i3));
        } else {
            ((ImportantMsgManager) this.f298659d.getManager(QQManagerFactory.TROOP_IMPORTANT_MSG_MANAGER)).j(j3, new b(arrayList, i3));
        }
    }

    public void j(long j3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), dVar);
        } else {
            if (dVar == null) {
                return;
            }
            if (this.f298662h.containsKey(Long.valueOf(j3))) {
                dVar.a(j3, this.f298662h.get(Long.valueOf(j3)));
            } else {
                ThreadManagerV2.post(new Runnable(j3, dVar) { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ long f298669d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ d f298670e;

                    {
                        this.f298669d = j3;
                        this.f298670e = dVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ImportantMsgManager.this, Long.valueOf(j3), dVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        ImportantMsgItem s16 = ImportantMsgManager.this.s(this.f298669d);
                        if (QLog.isColorLevel()) {
                            QLog.i("ImportantMsgManager", 2, "readEntity costTime" + (System.currentTimeMillis() - currentTimeMillis) + " msgItem:" + s16.toString());
                        }
                        ThreadManager.getUIHandler().post(new Runnable(s16) { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.6.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ImportantMsgItem f298671d;

                            {
                                this.f298671d = s16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) s16);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (ImportantMsgManager.this.f298662h.containsKey(Long.valueOf(AnonymousClass6.this.f298669d))) {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    anonymousClass6.f298670e.a(anonymousClass6.f298669d, (ImportantMsgItem) ImportantMsgManager.this.f298662h.get(Long.valueOf(AnonymousClass6.this.f298669d)));
                                } else {
                                    ImportantMsgManager.this.f298662h.put(Long.valueOf(AnonymousClass6.this.f298669d), this.f298671d);
                                    AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                                    anonymousClass62.f298670e.a(anonymousClass62.f298669d, this.f298671d);
                                }
                            }
                        });
                    }
                }, 5, null, false);
            }
        }
    }

    public int k(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, j3)).intValue();
        }
        if (this.f298661f.containsKey(Long.valueOf(j3))) {
            return this.f298661f.get(Long.valueOf(j3)).intValue();
        }
        return 0;
    }

    public void o(long j3, List<oidb_0xea3$BackMsg> list, List<Long> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), list, list2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (oidb_0xea3$BackMsg oidb_0xea3_backmsg : list) {
                ArrayList arrayList2 = new ArrayList();
                com.tencent.mobileqq.troop.shortcutbar.importantmsg.d.a(this.f298659d, oidb_0xea3_backmsg, arrayList2);
                if (!arrayList2.isEmpty()) {
                    arrayList.add((MessageRecord) arrayList2.get(0));
                }
            }
        }
        n(j3, com.tencent.mobileqq.troop.shortcutbar.importantmsg.d.o(this.f298659d, j3, arrayList, true), list2);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.shortcutbar.f fVar = this.f298663i;
        if (fVar != null) {
            this.f298659d.removeObserver(fVar);
            this.f298663i = null;
        }
        this.f298661f.clear();
        this.f298662h.clear();
        this.f298660e.close();
    }

    protected ImportantMsgItem s(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ImportantMsgItem) iPatchRedirector.redirect((short) 10, (Object) this, j3);
        }
        ImportantMsgItem importantMsgItem = new ImportantMsgItem();
        try {
            List<? extends Entity> query = this.f298660e.query(ImportantMsgItem.class, false, "troopUin=?", new String[]{String.valueOf(j3)}, null, null, null, null);
            if (query != null && query.size() > 0) {
                return (ImportantMsgItem) query.get(0);
            }
        } catch (Exception e16) {
            QLog.e("ImportantMsgManager", 1, "readEntity exception + " + e16.getMessage(), e16);
        }
        importantMsgItem.troopUin = j3;
        return importantMsgItem;
    }

    protected void t(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) entity);
        } else {
            ThreadManagerV2.post(new Runnable(entity) { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgManager.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Entity f298673d;

                {
                    this.f298673d = entity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImportantMsgManager.this, (Object) entity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    ImportantMsgManager.this.u(this.f298673d);
                    if (QLog.isColorLevel()) {
                        QLog.i("ImportantMsgManager", 2, "updateEntity costTime" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }, 5, null, false);
        }
    }
}
