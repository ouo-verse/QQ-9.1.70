package com.tencent.mobileqq.friend.cache;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FriendCache extends a<String, Friends> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private EntityManager f211570d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f211571e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f211572f;

    /* renamed from: g, reason: collision with root package name */
    public volatile int f211573g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, Friends> f211574h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f211575i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<uc1.c> f211576j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f211577k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f211578l;

    public FriendCache(EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) entityManager);
            return;
        }
        this.f211571e = false;
        this.f211572f = false;
        this.f211573g = 0;
        this.f211574h = new ConcurrentHashMap<>(16);
        this.f211577k = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101925", false);
        this.f211578l = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105434", false);
        this.f211570d = entityManager;
        this.f211575i = new Handler(ThreadManagerV2.getFileThreadLooper());
    }

    private void l() {
        if (!this.f211571e) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        int i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache begin");
        com.tencent.mobileqq.friend.utils.b.d().h(true, System.currentTimeMillis());
        ArrayList<Friends> arrayList = (ArrayList) this.f211570d.query(Friends.class, false, "groupid>=?", new String[]{"0"}, null, null, null, null);
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        ArrayList arrayList2 = new ArrayList();
        if (i3 > 0) {
            for (Friends friends : arrayList) {
                String str = friends.mCompareSpell;
                if (str == null || str.length() == 0) {
                    com.tencent.mobileqq.friend.utils.c.d(friends);
                    arrayList2.add(friends);
                }
                x(friends);
            }
        }
        this.f211571e = true;
        com.tencent.mobileqq.friend.utils.b.d().h(false, System.currentTimeMillis());
        this.f211572f = true;
        w();
        QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache finish| friendCount: " + i3 + ", cost: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        if (arrayList2.size() > 0) {
            a(arrayList2);
        }
    }

    private void w() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("friend_cache_save_optimization_2", true);
        QLog.i("IMCore.friend.FriendCache", 1, "requestFriendListForNT friend_cache_save_optimization_2 switchState is " + isSwitchOn);
        if (!isSwitchOn) {
            return;
        }
        if (this.f211573g != 0 && this.f211573g != com.tencent.mobileqq.friend.utils.b.d().f()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("IMCore.friend.FriendCache", 1, "requestFriendListForNT appRuntime is invalid!");
                return;
            } else {
                ((IFriendHandlerService) peekAppRuntime.getRuntimeService(IFriendHandlerService.class, "")).requestFriendList(false, this.f211573g);
                return;
            }
        }
        QLog.i("IMCore.friend.FriendCache", 1, "requestFriendListForNT mNtRequestFriendListSeq is" + this.f211573g + "! so direct return!");
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    public boolean a(List<Friends> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list)).booleanValue();
        }
        boolean z16 = false;
        if (list != null && list.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendCache", 2, "saveToDB friendList | begin");
            }
            EntityTransaction transaction = this.f211570d.getTransaction();
            transaction.begin();
            try {
                try {
                    Iterator<Friends> it = list.iterator();
                    boolean z17 = true;
                    while (it.hasNext()) {
                        z17 &= d(it.next());
                    }
                    transaction.commit();
                    transaction.end();
                    z16 = z17;
                } catch (Exception e16) {
                    QLog.e("IMCore.friend.FriendCache", 1, "saveToDB", e16);
                    transaction.end();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.friend.FriendCache", 2, "saveToDB friendList| end, size: " + list.size() + ", cost: " + currentTimeMillis2 + ", isSuccess: " + z16);
                }
                return z16;
            } catch (Throwable th5) {
                transaction.end();
                throw th5;
            }
        }
        QLog.e("IMCore.friend.FriendCache", 1, "saveToDB| friendList is empty!");
        return false;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f211570d.close();
            QLog.d("IMCore.friend.FriendCache", 1, "destroy");
        }
    }

    public List<Friends> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101542", true) && !this.f211571e) {
            l();
        }
        return new ArrayList(this.f211574h.values());
    }

    public int n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, z16)).intValue();
        }
        l();
        int size = this.f211574h.size();
        int i3 = 0;
        if (!z16) {
            Iterator<Friends> it = this.f211574h.values().iterator();
            while (it.hasNext()) {
                if (it.next().gathtertype == 1) {
                    i3++;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendCache", 2, "getFriendCount| includeGather: " + z16 + " friendCount: " + size + ", gatherCount: " + i3);
        }
        return size - i3;
    }

    public Friends o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Friends) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f211574h.get(str);
    }

    public List<Friends> p(Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this, (Object) num);
        }
        ArrayList arrayList = new ArrayList();
        for (Friends friends : this.f211574h.values()) {
            if (friends.groupid == num.intValue()) {
                arrayList.add(friends);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendCache", 2, "getGroupFriendList| groupId: " + num + ", size: " + arrayList.size());
        }
        return arrayList;
    }

    public synchronized void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f211571e) {
            QLog.d("IMCore.friend.FriendCache", 1, "initFriendCache| had init!");
            return;
        }
        if (this.f211578l && QLog.isColorLevel()) {
            com.tencent.mobileqq.friend.utils.a.b("IMCore.friend.FriendCache");
        }
        this.f211575i.post(new Runnable() { // from class: com.tencent.mobileqq.friend.cache.FriendCache.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendCache.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    FriendCache.this.r();
                    FriendCache.this.f211571e = true;
                    if (FriendCache.this.f211576j != null && FriendCache.this.f211576j.get() != 0) {
                        ((uc1.c) FriendCache.this.f211576j.get()).a();
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<Friends> s(List<String> list) {
        int i3;
        List list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendCache", 2, "preload begin");
        }
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            StringBuilder sb5 = new StringBuilder("uin=? ");
            for (int i16 = 1; i16 < list.size(); i16++) {
                sb5.append("or uin=? ");
            }
            list2 = this.f211570d.query(Friends.class, true, sb5.toString(), (String[]) list.toArray(new String[i3]), null, null, null, null);
            if (list2 != null) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    x((Friends) it.next());
                }
            }
        } else {
            list2 = null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendCache", 2, "preload: " + list + ", cost: " + currentTimeMillis2);
        }
        return list2;
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Friends c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Friends) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Friends friends = (Friends) DBMethodProxy.find(this.f211570d, (Class<? extends Entity>) Friends.class, str);
        x(friends);
        return friends;
    }

    public Friends u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Friends) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (QLog.isDebugVersion()) {
            QLog.e("IMCore.friend.FriendCache", 1, "removeFromCache frienduin: " + str + " trace: " + QLog.getStackTraceString(new Throwable()));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f211574h.remove(str);
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Friends b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Friends) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        Friends friends = (Friends) DBMethodProxy.find(this.f211570d, (Class<? extends Entity>) Friends.class, str);
        if (friends != null) {
            this.f211570d.remove(friends);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendCache", 2, "removeFromDB| friendUin: " + str);
        }
        return friends;
    }

    public void x(Friends friends) {
        Friends friends2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) friends);
            return;
        }
        if (QLog.isDebugVersion() && friends != null) {
            QLog.e("IMCore.friend.FriendCache", 1, "saveToCache frienduin: " + friends.uin + " trace: " + QLog.getStackTraceString(new Throwable()));
        }
        if (friends != null && !TextUtils.isEmpty(friends.uin)) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("friend_cache_save_optimization", false) && (friends2 = this.f211574h.get(friends.uin)) != null && friends2.datetime > friends.datetime) {
                QLog.i("IMCore.friend.FriendCache", 1, "saveToCache uin is " + friends.uin + " oldFriend.datetime is " + friends2.datetime + " friend.datetime is " + friends.datetime);
                return;
            }
            this.f211574h.put(friends.uin, friends);
        }
    }

    @Override // com.tencent.mobileqq.friend.cache.c
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public boolean d(Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) friends)).booleanValue();
        }
        boolean z16 = false;
        if (friends == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f211570d.isOpen()) {
            if (friends.getStatus() == 1000) {
                this.f211570d.persistOrReplace(friends);
                if (friends.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (friends.getStatus() == 1001 || friends.getStatus() == 1002) {
                z16 = this.f211570d.update(friends);
            }
        } else {
            QLog.d("IMCore.friend.FriendCache", 1, "saveToDB| em closed uin = " + friends.uin);
        }
        if (this.f211577k) {
            QLog.d("IMCore.friend.FriendCache", 2, "saveToDB| friend: " + friends.uin + ", isSuccess: " + z16 + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return z16;
    }

    public void z(uc1.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) cVar);
        } else {
            this.f211576j = new WeakReference<>(cVar);
        }
    }
}
