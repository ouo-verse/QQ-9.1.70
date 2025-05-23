package com.tencent.mobileqq.app.asyncdb.cache;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.business.d;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.h;
import com.tencent.mobileqq.service.message.z;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseRecentUserCache extends FullCache implements RecentUserProxy {
    static IPatchRedirector $redirector_ = null;
    public static final int MIN_RECENT_SIZE = 149;
    public static final int RECENT_ALL_DATA_NUM_DEL_DIFF = 9;
    private static final int RECENT_ALL_TINY_ALL_NUM = 50;
    public static final String RECENT_USER_OPEN_COUNT_LIMIT = "recent_user_open_count_limit_new";
    private static final String TAG = "Q.db.Cache.RecentUserCache";
    private static int recentAllDataNum;
    private static int recentAllDataNumDel;
    protected BaseQQAppInterface app;
    Comparator<Entity> comparator;
    Comparator<Entity> comparatorWithoutShowUp;
    private ConcurrentHashMap<String, Long> lastUpdateParcelTimeMap;
    private Handler parcelDataHandler;
    protected ConcurrentHashMap<String, ConcurrentHashMap<String, Entity>> uinMap;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class CacheMap extends ConcurrentHashMap<String, Entity> {
        static IPatchRedirector $redirector_;

        CacheMap() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseRecentUserCache.this);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                BaseRecentUserCache.this.uinMap.clear();
                super.clear();
            }
        }

        /* synthetic */ CacheMap(BaseRecentUserCache baseRecentUserCache, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseRecentUserCache, (Object) aVar);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public Entity put(String str, Entity entity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Entity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) entity);
            }
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            if (split.length >= 2) {
                String str2 = split[0];
                String str3 = split[1];
                ConcurrentHashMap<String, Entity> concurrentHashMap = BaseRecentUserCache.this.uinMap.get(str2);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    BaseRecentUserCache.this.uinMap.put(str2, concurrentHashMap);
                }
                concurrentHashMap.put(str3, entity);
            }
            return (Entity) super.put((CacheMap) str, (String) entity);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public Entity remove(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Entity) iPatchRedirector.redirect((short) 3, (Object) this, obj);
            }
            String[] split = ((String) obj).split(ContainerUtils.FIELD_DELIMITER);
            if (split.length >= 2) {
                String str = split[0];
                String str2 = split[1];
                ConcurrentHashMap<String, Entity> concurrentHashMap = BaseRecentUserCache.this.uinMap.get(str);
                if (concurrentHashMap != null) {
                    concurrentHashMap.remove(str2);
                    if (concurrentHashMap.isEmpty()) {
                        BaseRecentUserCache.this.uinMap.remove(str);
                    }
                }
            }
            return (Entity) super.remove(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class RecentComparator implements Comparator<Entity> {
        static IPatchRedirector $redirector_;
        private boolean withShowUp;

        public RecentComparator(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.withShowUp = z16;
            }
        }

        @Override // java.util.Comparator
        public int compare(Entity entity, Entity entity2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity, (Object) entity2)).intValue();
            }
            RecentUser recentUser = (RecentUser) entity;
            RecentUser recentUser2 = (RecentUser) entity2;
            long max = Math.max(recentUser.lastmsgtime, recentUser.lastmsgdrafttime);
            long max2 = Math.max(recentUser2.lastmsgtime, recentUser2.lastmsgdrafttime);
            if (this.withShowUp) {
                long j3 = recentUser.showUpTime;
                if (j3 > 0 && max == 0) {
                    max = Math.max(recentUser.opTime, j3);
                } else if (max == 0) {
                    max = recentUser.opTime;
                }
                long j16 = recentUser2.showUpTime;
                if (j16 > 0 && max2 == 0) {
                    max2 = Math.max(recentUser2.opTime, j16);
                } else if (max2 == 0) {
                    max2 = recentUser2.opTime;
                }
            } else {
                if (max == 0) {
                    max = recentUser.opTime;
                }
                if (max2 == 0) {
                    max2 = recentUser2.opTime;
                }
            }
            long j17 = 2;
            long j18 = max > max2 ? 3L : max < max2 ? 1L : 2L;
            if (this.withShowUp) {
                if (recentUser.showUpTime > 0) {
                    j18 |= 4096;
                }
                if (recentUser2.showUpTime > 0) {
                    j17 = 4098;
                }
            }
            if (j18 < j17) {
                return 1;
            }
            return j18 == j17 ? 0 : -1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            recentAllDataNum = 149;
            recentAllDataNumDel = 140;
        }
    }

    public BaseRecentUserCache(BaseQQAppInterface baseQQAppInterface, DBDelayManager dBDelayManager) {
        super(baseQQAppInterface, dBDelayManager, RecentUser.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) dBDelayManager);
            return;
        }
        this.uinMap = new ConcurrentHashMap<>(64);
        this.comparator = new RecentComparator(true);
        this.comparatorWithoutShowUp = new RecentComparator(false);
        this.lastUpdateParcelTimeMap = new ConcurrentHashMap<>(64);
        this.parcelDataHandler = null;
        this.app = baseQQAppInterface;
        this.cacheMap = new CacheMap(this, null);
        com.tencent.mobileqq.activity.recent.config.cache.a.a();
        initCache();
    }

    private void checkRecentUserNull(RecentUser recentUser) {
        if (recentUser.uin == null) {
            recentUser.uin = "";
        }
        if (recentUser.troopUin == null) {
            recentUser.troopUin = "";
        }
        if (recentUser.displayName == null) {
            recentUser.displayName = "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private List<RecentUser> getRecentUsersFromDB(EntityManager entityManager) {
        Pair<Integer, Integer> toggleRecentDataNum = getToggleRecentDataNum();
        if (toggleRecentDataNum != null) {
            recentAllDataNum = ((Integer) toggleRecentDataNum.first).intValue();
            recentAllDataNumDel = ((Integer) toggleRecentDataNum.second).intValue();
        }
        QLog.i(TAG, 1, "getRecentUsersFromDB switch=,recentAllDataNum=" + recentAllDataNum + ",recentAllDataNumDel=" + recentAllDataNumDel);
        List query = entityManager.query(RecentUser.class, false, "type!=?", new String[]{String.valueOf(10007)}, null, null, "showUpTime desc, lastmsgtime desc", Integer.toString(recentAllDataNum + 1));
        if (query == null) {
            return new ArrayList(20);
        }
        if (query.size() > recentAllDataNum) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                RecentUser recentUser = (RecentUser) query.get(recentAllDataNumDel);
                boolean execSQL = DBMethodProxy.execSQL(entityManager, "delete from " + RecentUser.TABLE_NAME + " where showUpTime < " + recentUser.showUpTime + " or showUpTime = " + recentUser.showUpTime + " and max(lastmsgtime, lastmsgdrafttime) < " + Math.max(recentUser.lastmsgtime, recentUser.lastmsgdrafttime) + "; ");
                query = query;
                if (execSQL) {
                    query = new ArrayList(query.subList(0, recentAllDataNumDel));
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doInit int recentUserProxy delete recent table >", Integer.valueOf(recentAllDataNum), " isOk = ", Boolean.valueOf(execSQL), "; time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return query;
                }
                return query;
            } catch (Exception e16) {
                e16.printStackTrace();
                return query;
            }
        }
        return query;
    }

    public static String getShortUinStr(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 4) {
            return str;
        }
        return str.substring(0, 4);
    }

    public static Pair<Integer, Integer> getToggleRecentDataNum() {
        Pair<Boolean, String> switchAndValue = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).getSwitchAndValue(RECENT_USER_OPEN_COUNT_LIMIT);
        if (switchAndValue == null) {
            QLog.i(TAG, 1, "getToggleRecentDataNum switchAndValue=null");
            return null;
        }
        Boolean bool = (Boolean) switchAndValue.first;
        String str = (String) switchAndValue.second;
        QLog.i(TAG, 1, "getToggleRecentDataNum switch=" + bool + ",value=" + str);
        if (bool != null && bool.booleanValue() && !TextUtils.isEmpty(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt >= 149) {
                    return new Pair<>(Integer.valueOf(parseInt), Integer.valueOf(parseInt - 9));
                }
            } catch (Exception e16) {
                QLog.i(TAG, 1, "getToggleRecentDataNum value=" + str, e16);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Throwable, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Throwable, java.lang.Exception] */
    private void initCache() {
        List<RecentUser> list;
        long currentTimeMillis = System.currentTimeMillis();
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        try {
            try {
                list = getRecentUsersFromDB(createEntityManager);
                createEntityManager = createEntityManager;
                if (createEntityManager != null) {
                    try {
                        createEntityManager.close();
                        createEntityManager = createEntityManager;
                    } catch (Exception e16) {
                        QLog.i(TAG, 1, " em.close()", e16);
                        createEntityManager = e16;
                    }
                }
            } catch (Exception e17) {
                QLog.i(TAG, 1, "getRecentUsersFromDB", e17);
                EntityManager entityManager = createEntityManager;
                if (createEntityManager != null) {
                    try {
                        createEntityManager.close();
                        entityManager = createEntityManager;
                    } catch (Exception e18) {
                        QLog.i(TAG, 1, " em.close()", e18);
                        entityManager = e18;
                    }
                }
                list = null;
                createEntityManager = entityManager;
            }
            if (list == null) {
                list = new ArrayList<>(20);
            }
            QLog.d(TAG, 2, "descRecentList before size=", Integer.valueOf(list.size()), ",costTime=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            com.tencent.mobileqq.activity.recent.config.cache.a.d(this.app, list);
            QLog.d(TAG, 2, "descRecentList after size=", Integer.valueOf(list.size()));
            Collections.sort(list, this.comparator);
            for (RecentUser recentUser : list) {
                checkRecentUserNull(recentUser);
                this.cacheMap.put(getKey(recentUser), recentUser);
            }
        } catch (Throwable th5) {
            if (createEntityManager != null) {
                try {
                    createEntityManager.close();
                } catch (Exception e19) {
                    QLog.i(TAG, 1, " em.close()", e19);
                }
            }
            throw th5;
        }
    }

    private void setUnreadMark(String str, int i3, int i16) {
        com.tencent.mobileqq.imcore.proxy.msg.a.c(this.app, str, i3, i16);
    }

    private boolean shouldAddInRecentList(RecentUser recentUser, boolean z16) {
        return com.tencent.mobileqq.activity.recent.config.cache.a.e(this.app, recentUser, z16);
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void clearRecentUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.cacheMap.clear();
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public boolean contains(@NonNull RecentUser recentUser) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) recentUser)).booleanValue();
        }
        synchronized (this.cacheMap) {
            contains = this.cacheMap.contains(recentUser);
        }
        return contains;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public boolean containsKey(@NonNull String str) {
        boolean containsKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.cacheMap) {
            containsKey = this.cacheMap.containsKey(str);
        }
        return containsKey;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void delAllRecentUserByUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.uinMap.get(str);
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            for (String str2 : concurrentHashMap.keySet()) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "findRecentUserByUin, uin:" + str + ",type:" + str2);
                    }
                    int parseInt = Integer.parseInt(str2);
                    if (parseInt != 7000) {
                        delRecentUser(findRecentUserByUin(str, parseInt));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void delC2CRecentUser(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16));
            return;
        }
        for (int i3 : ao.f116570d) {
            String key = getKey(str, i3);
            if (this.cacheMap.containsKey(key)) {
                RecentUser recentUser = (RecentUser) this.cacheMap.get(key);
                if (recentUser == null) {
                    return;
                }
                if (z16) {
                    setUnreadMark(recentUser.uin, recentUser.getType(), 0);
                }
                recentUser.setType(i3);
                removeCache(recentUser);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "delRecentUser user: " + getShortUinStr(recentUser.uin) + " type " + recentUser.getType() + " msgType " + recentUser.msgType);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void delRecentUser(RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            delRecentUser(recentUser, true);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) recentUser);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void deleteRecentUserByType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteRecentUserByType, type:" + i3);
        }
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.cacheMap;
        if (concurrentHashMap == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "deleteRecentUserByType cacheMap  is null");
                return;
            }
            return;
        }
        synchronized (concurrentHashMap) {
            Iterator<Map.Entry<String, Entity>> it = this.cacheMap.entrySet().iterator();
            while (it.hasNext()) {
                if (((RecentUser) it.next().getValue()).getType() == i3) {
                    it.remove();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "deleteRecentUserByType remove ru");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public RecentUser findRecentUser(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RecentUser) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
        synchronized (this.cacheMap) {
            RecentUser recentUser = (RecentUser) this.cacheMap.get(getKey(str, i3));
            if (recentUser == null) {
                return null;
            }
            if (recentUser.f203116msg == null) {
                if (recentUser.mIsParsed) {
                    recentUser.reParse();
                } else {
                    recentUser.parse();
                }
            }
            return recentUser;
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public RecentUser findRecentUserByUin(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecentUser) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
        if (i3 >= 0 && str != null) {
            str.length();
        }
        RecentUser recentUser = (RecentUser) this.cacheMap.get(getKey(str, i3));
        if (recentUser == null) {
            RecentUser recentUser2 = new RecentUser(str, i3);
            recentUser2.displayName = recentUser2.uin;
            recentUser2.parse();
            checkRecentUserNull(recentUser2);
            return recentUser2;
        }
        if (recentUser.f203116msg == null) {
            if (recentUser.mIsParsed) {
                recentUser.reParse();
                return recentUser;
            }
            recentUser.parse();
            return recentUser;
        }
        return recentUser;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public List<RecentUser> getHiddenRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (List) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        try {
            ArrayList arrayList = new ArrayList(this.cacheMap.size());
            Iterator<Map.Entry<String, Entity>> it = this.cacheMap.entrySet().iterator();
            while (it.hasNext()) {
                RecentUser recentUser = (RecentUser) it.next().getValue();
                recentUser.parse();
                if (recentUser.isHiddenChat == 1) {
                    arrayList.add(recentUser);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("getHiddenRecentList, size = %s", Integer.valueOf(arrayList.size())));
            }
            return arrayList;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getHiddenCacheList is error!", e16);
            }
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public final String getKey(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) entity);
        }
        RecentUser recentUser = (RecentUser) entity;
        return recentUser.uin + ContainerUtils.FIELD_DELIMITER + recentUser.getType();
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public z getRecentConvInfo(String str, int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (z) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, i3);
        }
        try {
            ArrayList arrayList = new ArrayList(this.cacheMap.size());
            Iterator<Map.Entry<String, Entity>> it = this.cacheMap.entrySet().iterator();
            while (it.hasNext()) {
                RecentUser recentUser = (RecentUser) it.next().getValue();
                recentUser.parse();
                arrayList.add(recentUser);
            }
            Collections.sort(arrayList, this.comparator);
            RecentUser recentUser2 = (RecentUser) this.cacheMap.get(getKey(str, i3));
            if (recentUser2 != null) {
                i16 = arrayList.indexOf(recentUser2) + 1;
            } else {
                i16 = -1;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (it5.hasNext()) {
                    RecentUser recentUser3 = (RecentUser) it5.next();
                    if (currentTimeMillis - recentUser3.lastmsgtime > h.f286257a) {
                        i17 = arrayList.indexOf(recentUser3) + 1;
                        break;
                    }
                } else {
                    i17 = -1;
                    break;
                }
            }
            if (i17 == -1) {
                i17 = arrayList.size();
            }
            z zVar = new z();
            zVar.f286364a = i16;
            zVar.f286365b = i17;
            zVar.f286366c = arrayList.size();
            return zVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getRecentConvInfo is error!", e16);
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public List<RecentUser> getRecentList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getRecentList(z16, true) : (List) iPatchRedirector.redirect((short) 2, (Object) this, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.FullCache, com.tencent.mobileqq.app.asyncdb.BaseCache
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public boolean isRecentUserInCache(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3)).booleanValue();
        }
        synchronized (this.cacheMap) {
            if (((RecentUser) this.cacheMap.get(getKey(str, i3))) == null) {
                return false;
            }
            return true;
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public boolean isUinInRecent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.uinMap.get(str);
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public boolean isUinInRecentNotSubAccount(String str) {
        ConcurrentHashMap<String, Entity> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null || (concurrentHashMap = this.uinMap.get(str)) == null || concurrentHashMap.isEmpty()) {
            return false;
        }
        if (concurrentHashMap.containsKey(String.valueOf(7000)) && concurrentHashMap.keySet().size() <= 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        Handler handler = this.parcelDataHandler;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void preLoadTinyRecentUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(RecentUser.class, false, "type=?", new String[]{String.valueOf(10007)}, null, null, "lastmsgtime desc", Integer.toString(50));
        int size = this.cacheMap.size();
        if (query != null) {
            synchronized (this.cacheMap) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    RecentUser recentUser = (RecentUser) it.next();
                    String key = getKey(recentUser);
                    if (!this.cacheMap.containsKey(key)) {
                        this.cacheMap.put(key, recentUser);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preLoadTinyRecentUser is called. preCount = " + size + ", afterCount = " + this.cacheMap.size());
        }
        d.b(this.app);
        createEntityManager.close();
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public Entity removeKey(@NonNull Object obj) {
        Entity remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Entity) iPatchRedirector.redirect((short) 23, (Object) this, obj);
        }
        synchronized (this.cacheMap) {
            remove = this.cacheMap.remove(obj);
        }
        return remove;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void saveRecentUser(RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) recentUser);
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void delRecentUser(RecentUser recentUser, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, recentUser, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseRecentUserCache", 2, "delRecentUser user: " + getShortUinStr(recentUser.uin) + " type " + recentUser.getType() + " msgType " + recentUser.msgType + ",uin = " + recentUser.uin);
        }
        if (z16) {
            setUnreadMark(recentUser.uin, recentUser.getType(), 0);
        }
        removeCache(recentUser);
        com.tencent.mobileqq.activity.recent.config.cache.a.b(this.app, recentUser, z16);
        IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) this.app.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
        if (recentForwardCache != null) {
            recentForwardCache.clearSpecificRecentUser(recentUser.uin);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public List<RecentUser> getRecentList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getRecentList(z16, z17, true) : (List) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public void saveRecentUser(RecentUser recentUser, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, this, recentUser, Boolean.valueOf(z16));
    }

    public static String getKey(String str, int i3) {
        return str + ContainerUtils.FIELD_DELIMITER + i3;
    }

    @Override // com.tencent.mobileqq.app.proxy.RecentUserProxy
    public List<RecentUser> getRecentList(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        try {
            ArrayList arrayList = new ArrayList(this.cacheMap.size());
            Iterator<Map.Entry<String, Entity>> it = this.cacheMap.entrySet().iterator();
            while (it.hasNext()) {
                RecentUser recentUser = (RecentUser) it.next().getValue();
                recentUser.parse();
                if (shouldAddInRecentList(recentUser, z17)) {
                    arrayList.add(recentUser);
                } else {
                    QLog.d(TAG, 2, "getRecentList, filter =", recentUser.uin, "|", Integer.valueOf(recentUser.type));
                }
            }
            if (z16) {
                if (z18) {
                    Collections.sort(arrayList, this.comparator);
                } else {
                    Collections.sort(arrayList, this.comparatorWithoutShowUp);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("BaseRecentUserCache", 2, String.format("getRecentList, size = %s", Integer.valueOf(arrayList.size())));
            }
            return arrayList;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getCacheList is error!", e16);
            }
            return new ArrayList();
        }
    }
}
