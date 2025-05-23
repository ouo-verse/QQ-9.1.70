package com.tencent.mobileqq.friend.cache;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GroupCache extends a<Integer, Groups> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private EntityManager f211579d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f211580e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f211581f;

    /* renamed from: g, reason: collision with root package name */
    private LinkedList<Groups> f211582g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Groups> f211583h;

    public GroupCache(EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) entityManager);
            return;
        }
        this.f211580e = false;
        this.f211581f = new Object();
        this.f211582g = new LinkedList<>();
        this.f211583h = new ConcurrentHashMap<>(16);
        this.f211579d = entityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.f211580e) {
            o();
        }
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    public boolean a(List<Groups> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list)).booleanValue();
        }
        boolean z16 = false;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            EntityTransaction transaction = this.f211579d.getTransaction();
            try {
                try {
                    transaction.begin();
                    boolean z17 = true;
                    for (Groups groups : list) {
                        z17 &= d(groups);
                        arrayList.add(Integer.valueOf(groups.group_id));
                    }
                    for (Groups groups2 : new ArrayList(this.f211583h.values())) {
                        if (!arrayList.contains(Integer.valueOf(groups2.group_id))) {
                            b(Integer.valueOf(groups2.group_id));
                        }
                    }
                    transaction.commit();
                    transaction.end();
                    z16 = z17;
                } catch (Exception e16) {
                    QLog.e("IMCore.friend.GroupCache", 1, "saveToDB", e16);
                    transaction.end();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.friend.GroupCache", 2, "saveToDB: " + list.size() + ", isSuccess: " + z16);
                }
                return z16;
            } catch (Throwable th5) {
                transaction.end();
                throw th5;
            }
        }
        QLog.d("IMCore.friend.GroupCache", 1, "saveToDB| groupList is empty!");
        return false;
    }

    public List<Groups> j(uc1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        }
        if (this.f211580e) {
            return new ArrayList(this.f211582g);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.friend.cache.GroupCache.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ uc1.a f211584d;

            {
                this.f211584d = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupCache.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    GroupCache.this.l();
                    uc1.a aVar2 = this.f211584d;
                    if (aVar2 != null) {
                        aVar2.onResult(new ArrayList(GroupCache.this.f211582g));
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        return null;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public Groups m(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Groups) iPatchRedirector.redirect((short) 6, (Object) this, (Object) num);
        }
        l();
        return this.f211583h.get(num);
    }

    public List<Groups> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        l();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101860", false);
        if (QLog.isColorLevel()) {
            QLog.i("IMCore.friend.GroupCache", 1, "synchronizedOptSwitch :" + isSwitchOn);
        }
        if (isSwitchOn) {
            if (this.f211582g.size() == 0) {
                return Collections.synchronizedList(new ArrayList());
            }
            return Collections.synchronizedList(new ArrayList(this.f211582g));
        }
        return new ArrayList(this.f211582g);
    }

    public synchronized void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f211580e) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f211580e = true;
        List<? extends Entity> query = this.f211579d.query(Groups.class, false, "group_id>=?", new String[]{"0"}, null, null, "seqid asc", null);
        if (query != null && !query.isEmpty()) {
            synchronized (this.f211581f) {
                this.f211583h.clear();
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    Groups groups = (Groups) it.next();
                    this.f211583h.put(Integer.valueOf(groups.group_id), groups);
                }
                this.f211582g.clear();
                this.f211582g.addAll(query);
            }
        } else {
            QLog.d("IMCore.friend.GroupCache", 1, "init| groupList is empty!");
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "init| group size: " + this.f211582g.size() + ", cost: " + elapsedRealtime2);
        }
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Groups c(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Groups) iPatchRedirector.redirect((short) 10, (Object) this, (Object) num);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "queryFromDB: " + num);
        }
        Groups groups = (Groups) DBMethodProxy.find(this.f211579d, (Class<? extends Entity>) Groups.class, String.valueOf(num));
        s(groups);
        return groups;
    }

    public Groups q(Integer num) {
        Groups remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Groups) iPatchRedirector.redirect((short) 5, (Object) this, (Object) num);
        }
        synchronized (this.f211581f) {
            remove = this.f211583h.remove(num);
            Iterator<Groups> it = this.f211582g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().group_id == num.intValue()) {
                    it.remove();
                    break;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "removeFromCache| groupId: " + num + ", group: " + remove);
        }
        return remove;
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Groups b(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Groups) iPatchRedirector.redirect((short) 9, (Object) this, (Object) num);
        }
        Groups groups = (Groups) DBMethodProxy.find(this.f211579d, (Class<? extends Entity>) Groups.class, String.valueOf(num));
        if (groups != null) {
            this.f211579d.remove(groups);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "removeFromDB| groupId: " + num + ", group: " + groups);
        }
        return groups;
    }

    public void s(Groups groups) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) groups);
            return;
        }
        if (groups == null) {
            return;
        }
        synchronized (this.f211581f) {
            this.f211583h.put(Integer.valueOf(groups.group_id), groups);
            Iterator<Groups> it = this.f211582g.iterator();
            while (true) {
                if (it.hasNext()) {
                    Groups next = it.next();
                    if (next.group_id == groups.group_id) {
                        next.group_name = groups.group_name;
                        next.group_friend_count = groups.group_friend_count;
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.f211582g = com.tencent.mobileqq.friend.utils.c.c(this.f211582g, groups);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "saveToCache| groupId: " + groups.group_id);
        }
    }

    public void t(List<Groups> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
            QLog.d("IMCore.friend.GroupCache", 1, "saveToCache| groupList == null");
        }
        synchronized (this.f211581f) {
            this.f211582g.clear();
            this.f211583h.clear();
            for (Groups groups : list) {
                this.f211583h.put(Integer.valueOf(groups.group_id), groups);
                this.f211582g.add(groups);
            }
            Collections.sort(this.f211582g, com.tencent.mobileqq.friend.utils.c.f211740a);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "saveToCache| groupList size: " + list.size());
        }
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public boolean d(Groups groups) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) groups)).booleanValue();
        }
        boolean z16 = false;
        if (groups == null) {
            return false;
        }
        if (this.f211579d.isOpen()) {
            if (groups.getStatus() == 1000) {
                this.f211579d.persistOrReplace(groups);
                if (groups.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (groups.getStatus() == 1001 || groups.getStatus() == 1002) {
                z16 = this.f211579d.update(groups);
            }
        } else {
            QLog.d("IMCore.friend.GroupCache", 1, "saveToDB| em closed groupId = " + groups.group_id);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.GroupCache", 2, "saveToDB| saveGroup: " + groups);
        }
        return z16;
    }
}
