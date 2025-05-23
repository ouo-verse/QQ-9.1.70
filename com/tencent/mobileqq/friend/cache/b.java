package com.tencent.mobileqq.friend.cache;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a<String, ExtensionInfo> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppRuntime f211588d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f211589e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f211590f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f211591g;

    /* renamed from: h, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, ExtensionInfo> f211592h;

    public b(AppRuntime appRuntime, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) entityManager);
            return;
        }
        this.f211590f = new Object();
        this.f211591g = false;
        this.f211592h = new ConcurrentHashMap<>(16);
        this.f211588d = appRuntime;
        this.f211589e = entityManager;
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    public boolean a(List<ExtensionInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list)).booleanValue();
        }
        if (list != null && list.size() != 0) {
            EntityTransaction transaction = this.f211589e.getTransaction();
            transaction.begin();
            try {
                try {
                    Iterator<ExtensionInfo> it = list.iterator();
                    boolean z16 = true;
                    while (it.hasNext()) {
                        z16 &= d(it.next());
                    }
                    transaction.commit();
                    transaction.end();
                    return z16;
                } catch (Exception e16) {
                    QLog.e("IMCore.friend.ExtensionInfoCache", 1, "saveToDB", e16);
                    transaction.end();
                    return false;
                }
            } catch (Throwable th5) {
                transaction.end();
                throw th5;
            }
        }
        QLog.e("IMCore.friend.ExtensionInfoCache", 1, "saveToDB| friendList is empty!");
        return false;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f211592h.clear();
            this.f211591g = false;
        }
    }

    public List<ExtensionInfo> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new ArrayList(this.f211592h.values());
    }

    public ExtensionInfo j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f211592h.get(str);
    }

    public synchronized void k() {
        List<? extends Entity> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f211591g) {
            QLog.d("IMCore.friend.ExtensionInfoCache", 1, "init extension info| had init!");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.ExtensionInfoCache", 2, "initExtensionCache begin");
        }
        List<Friends> allFriends = FriendDataServiceImpl.getService(this.f211588d).getAllFriends();
        if (allFriends != null) {
            if (allFriends.size() < 100) {
                StringBuilder sb5 = new StringBuilder(allFriends.size() * 20);
                ArrayList arrayList = new ArrayList(allFriends.size());
                for (Friends friends : allFriends) {
                    if (friends.isFriend()) {
                        sb5.append("uin=? or ");
                        arrayList.add(friends.uin);
                    }
                }
                if (sb5.length() > 4) {
                    sb5 = sb5.delete(sb5.length() - 4, sb5.length());
                }
                list = this.f211589e.query(ExtensionInfo.class, true, sb5.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, null, null, null);
            } else {
                list = null;
            }
            if (list == null) {
                try {
                    list = (ArrayList) this.f211589e.query(ExtensionInfo.class);
                } catch (OutOfMemoryError e16) {
                    ArrayList arrayList2 = new ArrayList(0);
                    QLog.e("IMCore.friend.ExtensionInfoCache", 1, "initExtensionInfoCache error OOM", e16);
                    list = arrayList2;
                }
            }
            if (list != null) {
                synchronized (this.f211590f) {
                    this.f211592h.clear();
                    Iterator<? extends Entity> it = list.iterator();
                    while (it.hasNext()) {
                        ExtensionInfo extensionInfo = (ExtensionInfo) it.next();
                        if (!TextUtils.isEmpty(extensionInfo.uin)) {
                            this.f211592h.put(extensionInfo.uin, extensionInfo);
                        } else {
                            QLog.e("IMCore.friend.ExtensionInfoCache", 1, "initExtensionCache| uin is null");
                        }
                    }
                }
            }
        }
        this.f211591g = true;
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.ExtensionInfoCache", 2, "initExtensionCache, size: " + this.f211592h.size() + ", cost: " + elapsedRealtime2);
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f211591g;
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ExtensionInfo c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(this.f211589e, (Class<? extends Entity>) ExtensionInfo.class, str);
        p(extensionInfo);
        return extensionInfo;
    }

    public ExtensionInfo n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f211592h.remove(str);
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public ExtensionInfo b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ExtensionInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ExtensionInfo extensionInfo = (ExtensionInfo) DBMethodProxy.find(this.f211589e, (Class<? extends Entity>) ExtensionInfo.class, str);
        if (extensionInfo != null) {
            this.f211589e.remove(extensionInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.ExtensionInfoCache", 2, "removeFromDB end | friendUin: " + str + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return extensionInfo;
    }

    public void p(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) extensionInfo);
        } else if (extensionInfo != null && !TextUtils.isEmpty(extensionInfo.uin)) {
            this.f211592h.put(extensionInfo.uin, extensionInfo);
        }
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean d(ExtensionInfo extensionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) extensionInfo)).booleanValue();
        }
        if (extensionInfo == null) {
            return false;
        }
        if (this.f211589e.isOpen()) {
            if (extensionInfo.getStatus() == 1000) {
                this.f211589e.persistOrReplace(extensionInfo);
                if (extensionInfo.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (extensionInfo.getStatus() != 1001 && extensionInfo.getStatus() != 1002) {
                return false;
            }
            return this.f211589e.update(extensionInfo);
        }
        QLog.d("IMCore.friend.ExtensionInfoCache", 1, "saveToDB| em closed uin = " + extensionInfo.uin);
        return false;
    }
}
