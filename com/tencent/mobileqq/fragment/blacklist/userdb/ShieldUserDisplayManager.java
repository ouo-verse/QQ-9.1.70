package com.tencent.mobileqq.fragment.blacklist.userdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.ShieldUserDisplayData;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.ShieldUserDisplayDataSeq;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DropTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockItem;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ShieldUserDisplayManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f211337d;

    /* renamed from: e, reason: collision with root package name */
    private final EntityManager f211338e;

    /* renamed from: f, reason: collision with root package name */
    private final ShieldUserDisplayData f211339f;

    /* renamed from: h, reason: collision with root package name */
    private final ShieldUserDisplayDataSeq f211340h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ShieldUserDisplayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.this$0.f211338e != null && this.this$0.f211338e.isOpen()) {
                this.this$0.f211338e.drop(ShieldUserDisplayData.class);
                this.this$0.f211338e.drop(ShieldUserDisplayData.class);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ShieldUserDisplayDataSeq f211342a;

        /* renamed from: b, reason: collision with root package name */
        public List<ShieldUserDisplayData> f211343b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f211342a = new ShieldUserDisplayDataSeq();
                this.f211343b = new ArrayList();
            }
        }

        public void a(long j3, List<RelationBlacklist$BlockItem> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), list);
                return;
            }
            this.f211342a = new ShieldUserDisplayDataSeq(Long.valueOf(j3));
            for (RelationBlacklist$BlockItem relationBlacklist$BlockItem : list) {
                if (relationBlacklist$BlockItem.account.type.get() == 3) {
                    this.f211343b.add(new ShieldUserDisplayData(String.valueOf(relationBlacklist$BlockItem.account.uin.get()), relationBlacklist$BlockItem.nickname.get(), relationBlacklist$BlockItem.avatar.get()));
                }
            }
        }
    }

    public ShieldUserDisplayManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f211339f = new ShieldUserDisplayData();
        this.f211340h = new ShieldUserDisplayDataSeq();
        this.f211337d = qQAppInterface;
        this.f211338e = qQAppInterface.getEntityManagerFactory().createEntityManager();
    }

    public a b() {
        List<? extends Entity> query;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        a aVar = new a();
        new ArrayList();
        EntityManager entityManager = this.f211338e;
        if (entityManager == null || !entityManager.isOpen() || (query = this.f211338e.query(ShieldUserDisplayDataSeq.class, true, null, null, null, null, null, String.valueOf(1))) == null || query.isEmpty()) {
            return null;
        }
        aVar.f211342a = (ShieldUserDisplayDataSeq) query.get(0);
        List query2 = this.f211338e.query(ShieldUserDisplayData.class, true, null, null, null, null, null, null);
        aVar.f211343b = query2;
        if (query2 == null) {
            aVar.f211343b = new ArrayList();
        }
        return aVar;
    }

    public ShieldUserDisplayDataSeq c() {
        List<? extends Entity> query;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ShieldUserDisplayDataSeq) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        new ArrayList();
        EntityManager entityManager = this.f211338e;
        if (entityManager == null || !entityManager.isOpen() || (query = this.f211338e.query(ShieldUserDisplayDataSeq.class, true, null, null, null, null, null, String.valueOf(1))) == null || query.isEmpty()) {
            return null;
        }
        return (ShieldUserDisplayDataSeq) query.get(0);
    }

    public boolean d(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar != null && aVar.f211343b != null && aVar.f211342a != null) {
            ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.fragment.blacklist.userdb.ShieldUserDisplayManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f211341d;

                {
                    this.f211341d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShieldUserDisplayManager.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new DropTransaction((Class<? extends Entity>) ShieldUserDisplayData.class));
                    arrayList.add(new DropTransaction((Class<? extends Entity>) ShieldUserDisplayDataSeq.class));
                    Iterator<ShieldUserDisplayData> it = this.f211341d.f211343b.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new PersistOrReplaceTransaction(new ShieldUserDisplayData(it.next())));
                    }
                    arrayList.add(new PersistOrReplaceTransaction(new ShieldUserDisplayDataSeq(this.f211341d.f211342a)));
                    if (!arrayList.isEmpty()) {
                        ShieldUserDisplayManager.this.f211338e.doMultiDBOperateByTransaction(arrayList);
                    }
                }
            }, 32, null, false);
            return true;
        }
        QLog.e("MatchFriendChatManager", 1, "updateUserDisplayDataList but matchFriendData is empty");
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d("MatchFriendChatManager", 1, "MatchFriendChatManager onDestroy");
        EntityManager entityManager = this.f211338e;
        if (entityManager != null && entityManager.isOpen()) {
            this.f211338e.close();
        }
    }
}
