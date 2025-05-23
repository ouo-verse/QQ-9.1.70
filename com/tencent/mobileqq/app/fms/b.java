package com.tencent.mobileqq.app.fms;

import android.os.SystemClock;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ah;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f195610a;

    /* renamed from: b, reason: collision with root package name */
    String f195611b;

    /* renamed from: c, reason: collision with root package name */
    e f195612c;

    /* renamed from: d, reason: collision with root package name */
    List<Object> f195613d;

    /* renamed from: e, reason: collision with root package name */
    Set<String> f195614e;

    /* renamed from: f, reason: collision with root package name */
    int f195615f;

    /* renamed from: g, reason: collision with root package name */
    FullMessageSearchResult f195616g;

    /* renamed from: h, reason: collision with root package name */
    volatile int f195617h;

    /* renamed from: i, reason: collision with root package name */
    volatile int f195618i;

    /* renamed from: j, reason: collision with root package name */
    d f195619j;

    /* renamed from: k, reason: collision with root package name */
    Object f195620k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements Comparator<Entity> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Entity entity, Entity entity2) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity, (Object) entity2)).intValue();
            }
            RecentUser recentUser = (RecentUser) entity;
            RecentUser recentUser2 = (RecentUser) entity2;
            long max = Math.max(recentUser.lastmsgtime, recentUser.lastmsgdrafttime);
            long max2 = Math.max(recentUser2.lastmsgtime, recentUser2.lastmsgdrafttime);
            if (max < max2) {
                i3 = 1;
            } else if (max == max2) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            if (recentUser.getType() == recentUser2.getType()) {
                return i3;
            }
            if (recentUser.getType() == 0) {
                return -1;
            }
            if (recentUser2.getType() != 0 && recentUser.getType() - recentUser2.getType() > 0) {
                return -1;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(QQAppInterface qQAppInterface, String str, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, eVar);
            return;
        }
        this.f195613d = new ArrayList();
        this.f195614e = new HashSet();
        this.f195615f = 0;
        this.f195617h = 0;
        this.f195618i = 0;
        this.f195619j = new d();
        this.f195620k = new Object();
        this.f195610a = qQAppInterface;
        this.f195611b = str;
        this.f195612c = eVar;
    }

    private FullMessageSearchResult c(long j3) {
        RecentUser recentUser;
        long j16;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey ,task=" + this);
        }
        if (this.f195616g == null) {
            this.f195616g = new FullMessageSearchResult();
        }
        FullMessageSearchResult fullMessageSearchResult = this.f195616g;
        if (fullMessageSearchResult.f195605a == null) {
            fullMessageSearchResult.f195605a = new ArrayList();
        }
        while (true) {
            if (this.f195615f >= this.f195613d.size()) {
                break;
            }
            Object obj = this.f195613d.get(this.f195615f);
            RecentUser recentUser2 = new RecentUser();
            if (obj instanceof RecentUser) {
                recentUser = (RecentUser) obj;
            } else {
                if (obj instanceof Friends) {
                    Friends friends = (Friends) obj;
                    recentUser2.uin = friends.uin;
                    recentUser2.setType(0);
                    recentUser2.displayName = friends.getFriendNickWithAlias();
                } else if (obj instanceof DiscussionInfo) {
                    DiscussionInfo discussionInfo = (DiscussionInfo) obj;
                    recentUser2.uin = discussionInfo.uin;
                    recentUser2.setType(3000);
                    recentUser2.displayName = ac.p(this.f195610a, BaseApplicationImpl.getApplication(), discussionInfo.uin);
                } else if (obj instanceof TroopInfo) {
                    TroopInfo troopInfo = (TroopInfo) obj;
                    recentUser2.uin = troopInfo.troopuin;
                    recentUser2.setType(1);
                    recentUser2.displayName = troopInfo.troopname;
                }
                recentUser = recentUser2;
            }
            String f16 = ao.f(recentUser.uin, recentUser.getType());
            if (!this.f195614e.contains(f16)) {
                this.f195614e.add(f16);
                Message L = this.f195610a.getMessageFacade().L(recentUser.uin, recentUser.getType());
                if (L == null) {
                    j16 = 0;
                } else {
                    j16 = L.time;
                }
                recentUser.lastmsgtime = j16;
                int size = this.f195616g.f195605a.size();
                Pair<Boolean, Integer> d16 = d(this.f195611b, this.f195616g.f195605a, recentUser, j3, L);
                if (this.f195616g.f195605a.size() != size) {
                    this.f195612c.a(this.f195616g);
                }
                if (((Boolean) d16.first).booleanValue()) {
                    if (((Integer) d16.second).intValue() == 3) {
                        b();
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.FullMessageSearchTask", 2, "finish search scs=" + this.f195619j.toString() + ",searchType=" + this.f195617h + ",searchStatus=" + this.f195618i + ",searchFinFlag=" + d16.second);
                        }
                        if (this.f195619j.f195623a > 0) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("queryMessageSize", Integer.toString(this.f195619j.f195623a));
                            hashMap.put("queryConversationSize", Integer.toString(this.f195619j.f195624b));
                            hashMap.put("resultSize", Integer.toString(this.f195619j.f195625c));
                            hashMap.put("keyLength", Integer.toString(this.f195611b.length()));
                            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                            if (this.f195617h == 1) {
                                str = "SearchMessageStatistic";
                            } else {
                                str = "RecentSearchStatistic";
                            }
                            statisticCollector.collectPerformance(null, str, false, this.f195619j.f195627e, 0L, hashMap, null);
                        }
                    }
                    this.f195616g.f195606b = ((Integer) d16.second).intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.FullMessageSearchTask", 2, "pause " + this);
                    }
                }
            }
            this.f195615f++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey search result=" + this.f195616g.toString());
        }
        if (this.f195618i != 2 && this.f195618i != 3) {
            this.f195616g.f195606b = 1;
            a(1);
        }
        return this.f195616g;
    }

    private Pair<Boolean, Integer> d(String str, List<FullMessageSearchResult.SearchResultItem> list, RecentUser recentUser, long j3, Message message) {
        List<MessageRecord> list2;
        List<Long> list3;
        try {
            if (f.a(this.f195610a, recentUser)) {
                long uptimeMillis = SystemClock.uptimeMillis();
                ah ahVar = new ah(recentUser.uin, recentUser.getType(), str, f.f195628a, this);
                this.f195610a.getMessageProxy(recentUser.getType()).P(ahVar);
                FullMessageSearchResult.SearchResultItem searchResultItem = (FullMessageSearchResult.SearchResultItem) ahVar.f116520g;
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (this.f195618i != 2 && this.f195618i != 3) {
                    d dVar = this.f195619j;
                    dVar.f195624b++;
                    dVar.f195627e += uptimeMillis2;
                    if (searchResultItem != null && (((list2 = searchResultItem.secondPageList) != null && list2.size() > 0) || ((list3 = searchResultItem.secondPageMessageUniseq) != null && list3.size() > 0))) {
                        searchResultItem.user = recentUser;
                        searchResultItem.lastMessage = message;
                        list.add(list.size(), searchResultItem);
                    }
                }
                return new Pair<>(Boolean.TRUE, 2);
            }
            if (this.f195617h == 0 && SystemClock.uptimeMillis() - j3 > f.f195630c) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser timeout! " + f.f195630c);
                }
                return new Pair<>(Boolean.TRUE, 3);
            }
            if (SystemClock.uptimeMillis() - j3 > f.f195629b) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser timeout! " + f.f195629b);
                }
                return new Pair<>(Boolean.TRUE, 3);
            }
            return new Pair<>(Boolean.FALSE, 0);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.FullMessageSearchTask", 2, "queryHistroyByUser oom!");
            }
            return new Pair<>(Boolean.TRUE, 3);
        }
    }

    private FullMessageSearchResult i(int i3) {
        ArrayList<Entity> arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "startTask " + this);
        }
        f(i3);
        String str = this.f195611b;
        if (str != null && str.trim().length() != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            List<RecentUser> recentList = this.f195610a.getProxyManager().m().getRecentList(false);
            if (recentList == null) {
                QLog.e("Q.msg.FullMessageSearchTask", 1, "userList is null!");
                return null;
            }
            Iterator<RecentUser> it = recentList.iterator();
            while (it.hasNext()) {
                RecentUser next = it.next();
                if (next.getType() != 0 && next.getType() != 1 && next.getType() != 3000) {
                    it.remove();
                }
            }
            Collections.sort(recentList, new a());
            this.f195613d.addAll(recentList);
            FriendsManager friendsManager = (FriendsManager) this.f195610a.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null) {
                arrayList = friendsManager.B();
            } else {
                arrayList = new ArrayList<>();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.FullMessageSearchTask", 2, "friends size = " + arrayList.size());
            }
            this.f195613d.addAll(arrayList);
            ArrayList<DiscussionInfo> k3 = ((n) this.f195610a.getManager(QQManagerFactory.DISCUSSION_MANAGER)).k();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.FullMessageSearchTask", 2, "discussions size = " + k3.size());
            }
            this.f195613d.addAll(k3);
            List<TroopInfo> joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.FullMessageSearchTask", 2, "troops size = " + joinedTroopInfoFromCache.size());
            }
            this.f195613d.addAll(joinedTroopInfoFromCache);
            return c(uptimeMillis);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "queryAllHistroyByKey key is null!");
        }
        return null;
    }

    public void a(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        synchronized (this.f195620k) {
            if (this.f195618i == 3) {
                return;
            }
            if (this.f195618i == 1) {
                this.f195618i = 3;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.FullMessageSearchTask", 2, "finish search scs=" + this.f195619j.toString() + ",searchType=" + this.f195617h + ",searchStatus=" + this.f195618i + ",searchFinFlag=" + i3);
            }
            if (this.f195619j.f195623a > 0 && this.f195618i == 3 && i3 == 1) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("queryMessageSize", Integer.toString(this.f195619j.f195623a));
                hashMap.put("queryConversationSize", Integer.toString(this.f195619j.f195624b));
                hashMap.put("resultSize", Integer.toString(this.f195619j.f195625c));
                hashMap.put("keyLength", Integer.toString(this.f195611b.length()));
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (this.f195617h == 1) {
                    str = "SearchMessageStatistic";
                } else {
                    str = "RecentSearchStatistic";
                }
                statisticCollector.collectPerformance(null, str, true, this.f195619j.f195627e, 0L, hashMap, null);
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f195620k) {
            if (this.f195618i == 1) {
                this.f195618i = 2;
            }
        }
    }

    public synchronized FullMessageSearchResult e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FullMessageSearchResult) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "resume " + this);
        }
        if (this.f195618i == 0) {
            return g();
        }
        if (this.f195618i != 2 && this.f195618i != 1) {
            if (this.f195618i == 3) {
                return this.f195616g;
            }
            return null;
        }
        this.f195618i = 1;
        this.f195617h = 1;
        return c(SystemClock.uptimeMillis());
    }

    synchronized void f(int i3) {
        this.f195615f = 0;
        this.f195613d.clear();
        this.f195614e.clear();
        this.f195616g = null;
        this.f195618i = 1;
        this.f195617h = i3;
    }

    public synchronized FullMessageSearchResult g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FullMessageSearchResult) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "startAllSearch " + this);
        }
        if (this.f195618i == 0) {
            return i(1);
        }
        if (this.f195618i != 2 && this.f195618i != 1) {
            if (this.f195618i == 3) {
                return this.f195616g;
            }
            return null;
        }
        return e();
    }

    public synchronized FullMessageSearchResult h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FullMessageSearchResult) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearchTask", 2, "startRecentSearch " + this);
        }
        if (this.f195618i != 2 && this.f195618i != 1) {
            if (this.f195618i == 3) {
                return this.f195616g;
            }
            return i(0);
        }
        return e();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SearchStatus:key=" + this.f195611b + ",searchConvList.size=" + this.f195613d.size() + ",searchIndex=" + this.f195615f + ",SearchType=" + this.f195617h + ",SearchStatus=" + this.f195618i;
    }
}
