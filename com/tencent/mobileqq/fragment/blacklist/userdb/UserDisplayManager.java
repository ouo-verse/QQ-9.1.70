package com.tencent.mobileqq.fragment.blacklist.userdb;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.UserDisplayData;
import com.tencent.mobileqq.fragment.blacklist.userdb.data.UserDisplayDataSeq;
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
public class UserDisplayManager implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f211344d;

    /* renamed from: e, reason: collision with root package name */
    private final EntityManager f211345e;

    /* renamed from: f, reason: collision with root package name */
    private final UserDisplayData f211346f;

    /* renamed from: h, reason: collision with root package name */
    private final UserDisplayDataSeq f211347h;

    public UserDisplayManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f211346f = new UserDisplayData();
        this.f211347h = new UserDisplayDataSeq();
        this.f211344d = qQAppInterface;
        this.f211345e = qQAppInterface.getEntityManagerFactory().createEntityManager();
    }

    public a b() {
        List<? extends Entity> query;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        a aVar = new a();
        new ArrayList();
        EntityManager entityManager = this.f211345e;
        if (entityManager == null || !entityManager.isOpen() || (query = this.f211345e.query(UserDisplayDataSeq.class, true, null, null, null, null, null, String.valueOf(1))) == null || query.isEmpty()) {
            return null;
        }
        aVar.f211349a = (UserDisplayDataSeq) query.get(0);
        List query2 = this.f211345e.query(UserDisplayData.class, true, null, null, null, null, null, null);
        aVar.f211350b = query2;
        if (query2 == null) {
            aVar.f211350b = new ArrayList();
        }
        return aVar;
    }

    public UserDisplayDataSeq c() {
        List<? extends Entity> query;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UserDisplayDataSeq) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        new ArrayList();
        EntityManager entityManager = this.f211345e;
        if (entityManager == null || !entityManager.isOpen() || (query = this.f211345e.query(UserDisplayDataSeq.class, true, null, null, null, null, null, String.valueOf(1))) == null || query.isEmpty()) {
            return null;
        }
        return (UserDisplayDataSeq) query.get(0);
    }

    public boolean d(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar != null && aVar.f211350b != null && aVar.f211349a != null) {
            ThreadManagerV2.excute(new Runnable(aVar) { // from class: com.tencent.mobileqq.fragment.blacklist.userdb.UserDisplayManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f211348d;

                {
                    this.f211348d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UserDisplayManager.this, (Object) aVar);
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
                    arrayList.add(new DropTransaction((Class<? extends Entity>) UserDisplayData.class));
                    arrayList.add(new DropTransaction((Class<? extends Entity>) UserDisplayDataSeq.class));
                    Iterator<UserDisplayData> it = this.f211348d.f211350b.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new PersistOrReplaceTransaction(new UserDisplayData(it.next())));
                    }
                    arrayList.add(new PersistOrReplaceTransaction(new UserDisplayDataSeq(this.f211348d.f211349a)));
                    if (!arrayList.isEmpty()) {
                        UserDisplayManager.this.f211345e.doMultiDBOperateByTransaction(arrayList);
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
        EntityManager entityManager = this.f211345e;
        if (entityManager != null && entityManager.isOpen()) {
            this.f211345e.close();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public UserDisplayDataSeq f211349a;

        /* renamed from: b, reason: collision with root package name */
        public List<UserDisplayData> f211350b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f211349a = new UserDisplayDataSeq();
                this.f211350b = new ArrayList();
            }
        }

        public void a(long j3, List<RelationBlacklist$BlockItem> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), list);
                return;
            }
            this.f211349a = new UserDisplayDataSeq(Long.valueOf(j3));
            for (RelationBlacklist$BlockItem relationBlacklist$BlockItem : list) {
                if (relationBlacklist$BlockItem.account.type.get() == 3) {
                    this.f211350b.add(new UserDisplayData(String.valueOf(relationBlacklist$BlockItem.account.uin.get()), relationBlacklist$BlockItem.nickname.get(), relationBlacklist$BlockItem.avatar.get()));
                }
            }
        }

        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            Iterator<UserDisplayData> it = this.f211350b.iterator();
            while (it.hasNext()) {
                String str2 = it.next().uin;
                if (str2 != null && str2.equals(str)) {
                    it.remove();
                }
            }
        }

        public a(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            this.f211349a = new UserDisplayDataSeq();
            this.f211350b = new ArrayList();
            this.f211349a = new UserDisplayDataSeq(aVar.f211349a);
            this.f211350b.clear();
            Iterator<UserDisplayData> it = aVar.f211350b.iterator();
            while (it.hasNext()) {
                this.f211350b.add(new UserDisplayData(it.next()));
            }
        }
    }
}
