package com.tencent.mobileqq.app.asyncdb.cache;

import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.RecentForwardUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
public class RecentForwardUserCache extends FullCache implements IRecentForwardUserProxy {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Q.db.Cache.RecentForwardUserCache";
    private static int recentAllDataNum;
    private static int recentAllDataNumDel;
    protected BaseQQAppInterface app;
    private final Comparator<Entity> comparator;
    private final Comparator<Entity> comparatorWithoutShowUp;
    private final Comparator<Entity> forwardComparator;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class RecentComparator implements Comparator<Entity> {
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

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class RecentForwardComparator implements Comparator<Entity> {
        static IPatchRedirector $redirector_;
        private final boolean withShowUp;

        public RecentForwardComparator(boolean z16) {
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
            RecentForwardUser recentForwardUser = (RecentForwardUser) entity;
            RecentForwardUser recentForwardUser2 = (RecentForwardUser) entity2;
            long max = Math.max(recentForwardUser.lastMsgTime, recentForwardUser.lastMsgDraftTime);
            long max2 = Math.max(recentForwardUser2.lastMsgTime, recentForwardUser2.lastMsgDraftTime);
            if (this.withShowUp) {
                long j3 = recentForwardUser.showUpTime;
                if (j3 > 0 && max == 0) {
                    max = Math.max(recentForwardUser.opTime, j3);
                } else if (max == 0) {
                    max = recentForwardUser.opTime;
                }
                long j16 = recentForwardUser2.showUpTime;
                if (j16 > 0 && max2 == 0) {
                    max2 = Math.max(recentForwardUser2.opTime, j16);
                } else if (max2 == 0) {
                    max2 = recentForwardUser2.opTime;
                }
            } else {
                if (max == 0) {
                    max = recentForwardUser.opTime;
                }
                if (max2 == 0) {
                    max2 = recentForwardUser2.opTime;
                }
            }
            long j17 = 2;
            long j18 = max > max2 ? 3L : max < max2 ? 1L : 2L;
            if (this.withShowUp) {
                if (recentForwardUser.showUpTime > 0) {
                    j18 |= 4096;
                }
                if (recentForwardUser2.showUpTime > 0) {
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            recentAllDataNum = 149;
            recentAllDataNumDel = 140;
        }
    }

    public RecentForwardUserCache(BaseQQAppInterface baseQQAppInterface, DBDelayManager dBDelayManager) {
        super(baseQQAppInterface, dBDelayManager, RecentForwardUser.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) dBDelayManager);
            return;
        }
        this.comparator = new RecentComparator(true);
        this.comparatorWithoutShowUp = new RecentComparator(false);
        this.forwardComparator = new RecentForwardComparator(true);
        com.tencent.mobileqq.activity.recent.config.cache.a.a();
        this.app = baseQQAppInterface;
        initCache();
    }

    private void checkRecentUserNull(RecentForwardUser recentForwardUser) {
        if (recentForwardUser.uin == null) {
            recentForwardUser.uin = "";
        }
        if (recentForwardUser.troopUin == null) {
            recentForwardUser.troopUin = "";
        }
        if (recentForwardUser.displayName == null) {
            recentForwardUser.displayName = "";
        }
    }

    private List<RecentForwardUser> getRecentUsersFromDB() {
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        Pair<Integer, Integer> toggleRecentDataNum = BaseRecentUserCache.getToggleRecentDataNum();
        if (toggleRecentDataNum != null) {
            recentAllDataNum = ((Integer) toggleRecentDataNum.first).intValue();
            recentAllDataNumDel = ((Integer) toggleRecentDataNum.second).intValue();
        }
        QLog.i(TAG, 1, "getRecentUsersFromDB switch=,recentAllDataNum=" + recentAllDataNum + ",recentAllDataNumDel=" + recentAllDataNumDel);
        List query = createEntityManager.query(RecentForwardUser.class, false, "type!=?", new String[]{String.valueOf(10007)}, null, null, "showUpTime desc, lastMsgTime desc", Integer.toString(recentAllDataNum + 1));
        if (query == null) {
            query = new ArrayList(20);
        } else if (query.size() > recentAllDataNum) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                RecentForwardUser recentForwardUser = (RecentForwardUser) query.get(recentAllDataNumDel);
                boolean execSQL = DBMethodProxy.execSQL(createEntityManager, "delete from " + RecentForwardUser.TABLE_NAME + " where showUpTime < " + recentForwardUser.showUpTime + " or showUpTime = " + recentForwardUser.showUpTime + " and max(lastMsgTime, lastMsgDraftTime) < " + Math.max(recentForwardUser.lastMsgTime, recentForwardUser.lastMsgDraftTime) + "; ");
                if (execSQL) {
                    query = new ArrayList(query.subList(0, recentAllDataNumDel));
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doInit int recentUserProxy delete recent table >", Integer.valueOf(recentAllDataNum), " isOk = ", Boolean.valueOf(execSQL), "; time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getRecentUsersFromDB failed", e16);
            }
        }
        createEntityManager.close();
        return query;
    }

    private void initCache() {
        List<RecentForwardUser> recentUsersFromDB = getRecentUsersFromDB();
        Collections.sort(recentUsersFromDB, this.forwardComparator);
        for (RecentForwardUser recentForwardUser : recentUsersFromDB) {
            checkRecentUserNull(recentForwardUser);
            this.cacheMap.put(getKey(recentForwardUser), recentForwardUser);
        }
        QLog.i(TAG, 1, "initCache userList size=" + recentUsersFromDB.size() + " cacheMap size=" + this.cacheMap.size());
    }

    private boolean shouldAddInRecentList(RecentUser recentUser, boolean z16) {
        if (recentUser == null) {
            return true;
        }
        if (recentUser.getType() != 10014 && recentUser.getType() != 10016) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy
    public void clearRecentUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.cacheMap;
        if (concurrentHashMap == null) {
            return;
        }
        Iterator<Map.Entry<String, Entity>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            removeCache(it.next().getValue());
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy
    public void clearSpecificRecentUser(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.cacheMap;
        if (concurrentHashMap == null) {
            return;
        }
        for (Map.Entry<String, Entity> entry : concurrentHashMap.entrySet()) {
            if (((RecentForwardUser) entry.getValue()).uin.equals(str)) {
                removeCache(entry.getValue());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.asyncdb.BaseCache
    public final String getKey(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) entity);
        }
        RecentForwardUser recentForwardUser = (RecentForwardUser) entity;
        return recentForwardUser.uin + ContainerUtils.FIELD_DELIMITER + recentForwardUser.getType();
    }

    @Override // com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy
    public List<RecentUser> getRecentList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getRecentList(z16, true) : (List) iPatchRedirector.redirect((short) 2, (Object) this, z16);
    }

    @Override // com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy
    public void saveRecentUser(RecentUser recentUser) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) recentUser);
            return;
        }
        if (recentUser != null && recentUser.getType() >= 0 && (str = recentUser.uin) != null && str.length() > 2) {
            QLog.d(TAG, 1, "saveRecentUser user: " + recentUser.uin + " type " + recentUser.getType() + " msgType " + recentUser.msgType);
            RecentUser c16 = com.tencent.mobileqq.activity.recent.config.cache.a.c(this.app, recentUser, false);
            if (c16 == null) {
                return;
            }
            RecentForwardUser createFrom = RecentForwardUser.createFrom(c16);
            checkRecentUserNull(createFrom);
            addCache(createFrom);
            return;
        }
        if (recentUser == null) {
            QLog.w(TAG, 1, "Save RecentUser with error user: " + ((Object) null));
            return;
        }
        QLog.w(TAG, 1, "Save RecentUser with error user: " + recentUser.uin + " type " + recentUser.getType() + " msgType " + recentUser.msgType);
    }

    @Override // com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy
    public List<RecentUser> getRecentList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getRecentList(z16, z17, true) : (List) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy
    public List<RecentUser> getRecentList(boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        try {
            ArrayList arrayList = new ArrayList(this.cacheMap.size());
            Iterator<Map.Entry<String, Entity>> it = this.cacheMap.entrySet().iterator();
            while (it.hasNext()) {
                RecentUser recentUser = ((RecentForwardUser) it.next().getValue()).toRecentUser();
                if (shouldAddInRecentList(recentUser, z17)) {
                    arrayList.add(recentUser);
                }
            }
            if (z16) {
                if (z18) {
                    Collections.sort(arrayList, this.comparator);
                } else {
                    Collections.sort(arrayList, this.comparatorWithoutShowUp);
                }
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
