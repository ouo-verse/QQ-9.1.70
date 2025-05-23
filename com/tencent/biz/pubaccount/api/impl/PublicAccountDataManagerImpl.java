package com.tencent.biz.pubaccount.api.impl;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountProfile;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* loaded from: classes32.dex */
public class PublicAccountDataManagerImpl implements Manager, IPublicAccountDataManager {
    private static final int GET_KANDIAN_SCENE_AFTER_MSG = 1;
    private static final int GET_KANDIAN_SCENE_AFTER_MSG_NOTIFY = 2;
    private static final int GET_KANDIAN_SCENE_PROTECT = 3;
    public static final String TAG = "Q.contacttab.pub";
    private static volatile boolean sAfterMsgSync = false;
    private static final LinkedList<b> sAfterMsgSyncListeners = new LinkedList<>();
    QQAppInterface app;

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f79381em;
    private LruCache<String, PublicAccountDetailImpl> mAccountDetailCache;
    private volatile boolean mIsBuildingList;
    private b mOnAfterMsgSyncListener;
    private ConcurrentHashMap<String, PublicAccountInfo> mPublicAccountCache;
    public boolean cached = false;
    private final Map<Long, PublicAccountInfo> mPublicAccountInfoNetBuffer = new ConcurrentHashMap();
    private int maxSize = 50;
    ArrayList<Entity> publicAccountList = new ArrayList<>();
    ArrayList<Entity> mPublicAccountList = new ArrayList<>();
    ArrayList<PublicRecommendAccountInfo> publicRecommendAccountList = new ArrayList<>();
    private HashMap<Long, Long> noCacheUin = new HashMap<>();

    /* loaded from: classes32.dex */
    class a implements b {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.b
        public void a() {
            PublicAccountDataManagerImpl.this.doGetKandianSubscribeAccountInfo(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public interface b {
        void a();
    }

    private static void addOnAfterMsgSyncListener(b bVar) {
        LinkedList<b> linkedList = sAfterMsgSyncListeners;
        synchronized (linkedList) {
            if (bVar != null) {
                linkedList.add(bVar);
            }
        }
    }

    private boolean canUnfollow(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) findAccountDetailInfoCache(str);
        if (publicAccountDetailImpl == null || publicAccountDetailImpl.isShowFollowButton) {
            return (publicAccountDetailImpl == null && "1770946116".equals(str)) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGetKandianSubscribeAccountInfo(int i3) {
        QLog.d(TAG, 2, "doGetKandianSubscribeAccountInfo " + i3);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(PublicAccountDataManagerImpl.TAG, 2, "preGetKandianSubscribe account info!");
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(PublicAccountDataManagerImpl.this.app, BaseApplication.getContext(), null, AppConstants.KANDIAN_SUBSCRIBE_UIN);
            }
        });
    }

    private void getKandianSubscribeAccountInfo() {
        if (sAfterMsgSync) {
            doGetKandianSubscribeAccountInfo(1);
            return;
        }
        a aVar = new a();
        this.mOnAfterMsgSyncListener = aVar;
        addOnAfterMsgSyncListener(aVar);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                if (PublicAccountDataManagerImpl.removeOnAfterMsgSyncListener(PublicAccountDataManagerImpl.this.mOnAfterMsgSyncListener)) {
                    PublicAccountDataManagerImpl.this.doGetKandianSubscribeAccountInfo(3);
                }
            }
        }, 10000L);
    }

    private static void notifyOnAfterMsgSync() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (PublicAccountDataManagerImpl.sAfterMsgSyncListeners) {
                        int size = PublicAccountDataManagerImpl.sAfterMsgSyncListeners.size();
                        if (size <= 0) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList(size);
                        arrayList.addAll(PublicAccountDataManagerImpl.sAfterMsgSyncListeners);
                        PublicAccountDataManagerImpl.sAfterMsgSyncListeners.clear();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).a();
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.d(PublicAccountDataManagerImpl.TAG, 2, "notifyOnAfterMsgSync", e16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean removeOnAfterMsgSyncListener(b bVar) {
        LinkedList<b> linkedList = sAfterMsgSyncListeners;
        synchronized (linkedList) {
            if (bVar == null) {
                return false;
            }
            return linkedList.remove(bVar);
        }
    }

    public static void setAfterMsgSync() {
        if (!sAfterMsgSync) {
            notifyOnAfterMsgSync();
        }
        sAfterMsgSync = true;
    }

    public synchronized void buildPublicAccountUI() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "buildPublicAccountUI begin");
        }
        this.mIsBuildingList = true;
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.mPublicAccountCache;
        if (concurrentHashMap != null) {
            int size = concurrentHashMap.size();
            ArrayList<Entity> arrayList = new ArrayList<>(size);
            ArrayList arrayList2 = new ArrayList(size);
            ArrayList arrayList3 = new ArrayList(size);
            for (PublicAccountInfo publicAccountInfo : this.mPublicAccountCache.values()) {
                PublicAccountInfo publicAccountInfo2 = publicAccountInfo;
                String str = publicAccountInfo2.mCompareSpell;
                if (str == null || str.length() == 0) {
                    com.tencent.mobileqq.app.j.h(publicAccountInfo2);
                }
                if (publicAccountInfo2.hasIvrAbility()) {
                    arrayList2.add(publicAccountInfo);
                } else {
                    arrayList3.add(publicAccountInfo);
                }
            }
            if (arrayList2.size() > 0) {
                if (arrayList2.size() > 1) {
                    Collections.sort(arrayList2, com.tencent.mobileqq.app.j.f195808a);
                }
                arrayList.addAll(arrayList2);
            }
            if (arrayList3.size() > 0) {
                if (arrayList3.size() > 1) {
                    Collections.sort(arrayList3, com.tencent.mobileqq.app.j.f195808a);
                }
                arrayList.addAll(arrayList3);
            }
            this.publicAccountList = arrayList;
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, com.tencent.mobileqq.app.j.f195808a);
            }
            this.mPublicAccountList = arrayList;
            com.tencent.mobileqq.search.util.o.a().f285063b = true;
        }
        this.mIsBuildingList = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "buildPublicAccountUI end: " + this.publicAccountList.size());
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void decodeMessageRecord(ArrayList<MessageRecord> arrayList, AppInterface appInterface) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MessageRecord next = it.next();
                try {
                    long parseLong = Long.parseLong(next.senderuin);
                    if (parseLong != AppConstants.KANDIAN_MERGE_UIN_LONGVALUE || next.istroop != 7220) {
                        if (next.istroop == 1008 && !arrayList2.contains(Long.valueOf(parseLong))) {
                            arrayList2.add(Long.valueOf(parseLong));
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            Long l3 = (Long) it5.next();
            if (((PublicAccountInfo) findPublicAccountInfo(l3.toString())) == null && ((PublicAccountDetailImpl) findAccountDetailInfo(l3.toString())) == null && (this.noCacheUin.get(l3) == null || (this.noCacheUin.get(l3) != null && System.currentTimeMillis() - this.noCacheUin.get(l3).longValue() > 120000))) {
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getPublicAccountDetailRequest(appInterface, BaseApplication.getContext(), null, l3.toString());
                this.noCacheUin.put(l3, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void delAccountDetailInfoCache(String str) {
        if (this.mAccountDetailCache == null) {
            this.mAccountDetailCache = new LruCache<>(this.maxSize);
        }
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) findAccountDetailInfo(str);
        if (publicAccountDetailImpl != null) {
            this.mAccountDetailCache.remove(str);
            this.f79381em.remove(publicAccountDetailImpl);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void delPublicAccountInfo(String str) {
        if (this.mPublicAccountCache == null) {
            this.mPublicAccountCache = new ConcurrentHashMap<>();
        }
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) findPublicAccountInfo(str);
        if (publicAccountInfo != null) {
            this.mPublicAccountCache.remove(str);
            this.f79381em.remove(publicAccountInfo);
        }
        buildPublicAccountUI();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void delPublicAccountInfoCache(String str) {
        if (this.mPublicAccountCache == null) {
            this.mPublicAccountCache = new ConcurrentHashMap<>();
        }
        if (((PublicAccountInfo) findPublicAccountInfo(str)) != null) {
            this.mPublicAccountCache.remove(str);
            buildPublicAccountUI();
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public IPublicAccountDetail findAccountDetailInfo(String str) {
        EntityManager entityManager;
        LruCache<String, PublicAccountDetailImpl> lruCache = this.mAccountDetailCache;
        if (lruCache == null || str == null) {
            return null;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = lruCache.get(str);
        if (publicAccountDetailImpl != null || (entityManager = this.f79381em) == null) {
            return publicAccountDetailImpl;
        }
        PublicAccountDetailImpl publicAccountDetailImpl2 = (PublicAccountDetailImpl) DBMethodProxy.find(entityManager, (Class<? extends Entity>) PublicAccountDetailImpl.class, str);
        if (publicAccountDetailImpl2 == null) {
            return publicAccountDetailImpl2;
        }
        this.mAccountDetailCache.put(publicAccountDetailImpl2.uin, publicAccountDetailImpl2);
        return publicAccountDetailImpl2;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public IPublicAccountDetail findAccountDetailInfoCache(final String str) {
        LruCache<String, PublicAccountDetailImpl> lruCache = this.mAccountDetailCache;
        PublicAccountDetailImpl publicAccountDetailImpl = (lruCache == null || str == null) ? null : lruCache.get(str);
        if (publicAccountDetailImpl == null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountDataManagerImpl.this.findAccountDetailInfo(str);
                }
            });
        }
        return publicAccountDetailImpl;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object findPublicAccountInfo(String str, boolean z16) {
        EntityManager entityManager;
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap;
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap2 = this.mPublicAccountCache;
        if (concurrentHashMap2 == null || str == null) {
            if (concurrentHashMap2 == null && z16) {
                return (PublicAccountInfo) DBMethodProxy.find(this.f79381em, (Class<? extends Entity>) PublicAccountInfo.class, str);
            }
            return null;
        }
        PublicAccountInfo publicAccountInfo = concurrentHashMap2.get(str);
        if (publicAccountInfo != null || (entityManager = this.f79381em) == null) {
            return publicAccountInfo;
        }
        PublicAccountInfo publicAccountInfo2 = (PublicAccountInfo) DBMethodProxy.find(entityManager, (Class<? extends Entity>) PublicAccountInfo.class, str);
        if (publicAccountInfo2 == null || (concurrentHashMap = this.mPublicAccountCache) == null) {
            return publicAccountInfo2;
        }
        concurrentHashMap.put(publicAccountInfo2.getUin(), publicAccountInfo2);
        return publicAccountInfo2;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object findPublicAccountInfoCache(String str) {
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.mPublicAccountCache;
        if (concurrentHashMap == null || str == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object getAccountInfo(String str) {
        if (this.mPublicAccountCache == null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("init_account_cache_if null", true)) {
            initPublicAccountDataManager();
        }
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.mPublicAccountCache;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object getPublicAccountEqqInfoList() {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.mPublicAccountCache;
        if (concurrentHashMap == null) {
            return arrayList;
        }
        Iterator<Map.Entry<String, PublicAccountInfo>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public ArrayList<Entity> getPublicAccountListNotIVR() {
        return this.mPublicAccountList;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object getPublicAccountScriptList() {
        ConcurrentHashMap<String, PublicAccountInfo> concurrentHashMap = this.mPublicAccountCache;
        if (concurrentHashMap != null) {
            ArrayList arrayList = new ArrayList(concurrentHashMap.size());
            for (PublicAccountInfo publicAccountInfo : this.mPublicAccountCache.values()) {
                if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isSubscript(publicAccountInfo.accountFlag, publicAccountInfo.accountFlag2)) {
                    arrayList.add(publicAccountInfo);
                }
            }
            return arrayList;
        }
        return new ArrayList(0);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object getPublicRecommendAccountList() {
        return this.publicRecommendAccountList;
    }

    public void initAccountDetailCache() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initAccountDetailCache begin");
        }
        List<? extends Entity> query = this.f79381em.query(PublicAccountDetailImpl.class);
        this.mAccountDetailCache = new LruCache<>(this.maxSize);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) it.next();
                if (publicAccountDetailImpl != null && (str = publicAccountDetailImpl.uin) != null) {
                    this.mAccountDetailCache.put(str, publicAccountDetailImpl);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initAccountDetailCache end: " + this.mAccountDetailCache.size());
        }
    }

    public void initPublicAccountCache() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initPublicAccountCache begin");
        }
        List<? extends Entity> query = this.f79381em.query(PublicAccountInfo.class, false, "showFlag=?", new String[]{String.valueOf(1)}, null, null, null, null);
        this.mPublicAccountCache = new ConcurrentHashMap<>(query != null ? query.size() : 0);
        if (query != null) {
            ArrayList arrayList = new ArrayList();
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                PublicAccountInfo publicAccountInfo = (PublicAccountInfo) it.next();
                if (publicAccountInfo.isNeedShow()) {
                    if (!((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isDeleteOldKandian(this.app) || !TextUtils.equals(publicAccountInfo.getUin(), AppConstants.OLD_KANDIAN_UIN)) {
                        this.mPublicAccountCache.put(publicAccountInfo.getUin(), publicAccountInfo);
                    }
                }
                String str = publicAccountInfo.mCompareSpell;
                if (str == null || str.length() == 0) {
                    com.tencent.mobileqq.app.j.h(publicAccountInfo);
                    arrayList.add(publicAccountInfo);
                }
                if (publicAccountInfo.lastAIOReadTime <= 0) {
                    if (arrayList.contains(publicAccountInfo)) {
                        arrayList.remove(publicAccountInfo);
                    }
                    publicAccountInfo.lastAIOReadTime = serverTimeMillis;
                    arrayList.add(publicAccountInfo);
                }
            }
            if (arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    updateEntityTransaction((PublicAccountInfo) it5.next(), arrayList2);
                }
                this.f79381em.doMultiDBOperateByTransaction(arrayList2);
                arrayList.clear();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initPublicAccountCache end: " + this.mPublicAccountCache.size());
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public synchronized void initPublicAccountDataManager() {
        if (this.cached) {
            return;
        }
        initPublicAccountCache();
        buildPublicAccountUI();
        initPublicRecommendAccountCache();
        initAccountDetailCache();
        this.cached = true;
        TroopBarAssistantManager.n().D(this.app, (List) getPublicAccountEqqInfoList());
    }

    public void initPublicRecommendAccountCache() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initPublicRecommendAccountCache begin");
        }
        this.publicRecommendAccountList = (ArrayList) this.f79381em.query(PublicRecommendAccountInfo.class);
        if (!QLog.isColorLevel() || this.publicRecommendAccountList == null) {
            return;
        }
        QLog.d(TAG, 2, "initPublicRecommendAccountCache end: " + this.publicRecommendAccountList.size());
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public boolean isBuildingList() {
        return this.mIsBuildingList;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public boolean isCached() {
        return this.cached;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public boolean isCertifiedAccount(Object obj) {
        PublicAccountInfo publicAccountInfo;
        return (obj instanceof SessionInfo) && (publicAccountInfo = (PublicAccountInfo) findPublicAccountInfo(((SessionInfo) obj).f179557e)) != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType2(publicAccountInfo.accountFlag2) == -10;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public boolean isFollowedUin(Long l3) {
        return isFollowedUin(l3, false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        this.app = qQAppInterface;
        this.f79381em = qQAppInterface.getEntityManagerFactory().createEntityManager();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDataManagerImpl.this.initPublicAccountDataManager();
            }
        }, 32, null, true, 10L);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f79381em.close();
        LruCache<String, PublicAccountDetailImpl> lruCache = this.mAccountDetailCache;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void refreshPublicRecommendList(Object obj) {
        List list = (List) obj;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<? extends Entity> query = this.f79381em.query(PublicRecommendAccountInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                PublicRecommendAccountInfo publicRecommendAccountInfo = (PublicRecommendAccountInfo) it.next();
                if (publicRecommendAccountInfo.getStatus() == 1001) {
                    arrayList.add(new DeleteTransaction(publicRecommendAccountInfo.getTableName(), "_id=?", new String[]{String.valueOf(publicRecommendAccountInfo.getId())}));
                }
            }
        }
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList.add(new PersistTransaction((PublicRecommendAccountInfo) it5.next()));
        }
        this.publicRecommendAccountList = (ArrayList) list;
        this.f79381em.doMultiDBOperateByTransaction(arrayList);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void saveAccountDetailInfoCache(Object obj) {
        if (obj instanceof PublicAccountDetailImpl) {
            PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) obj;
            if (this.mAccountDetailCache == null) {
                this.mAccountDetailCache = new LruCache<>(this.maxSize);
            }
            if (TextUtils.isEmpty(publicAccountDetailImpl.uin)) {
                QLog.d(TAG, 2, "save account detail info fail because uin is null or empty name:" + publicAccountDetailImpl.name + " id: " + publicAccountDetailImpl.uid);
                return;
            }
            this.mAccountDetailCache.put(publicAccountDetailImpl.uin, publicAccountDetailImpl);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mAccountDetailCache size: " + this.mAccountDetailCache.size() + " cacheCount()" + this.mAccountDetailCache.cacheCount() + "  maxSize=" + this.mAccountDetailCache.maxSize() + "  putCount:" + this.mAccountDetailCache.putCount() + "  createCount:" + this.mAccountDetailCache.createCount() + "  missed:" + this.mAccountDetailCache.missCount());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("save account detail info, puin : ");
                sb5.append(publicAccountDetailImpl.uin);
                QLog.d(TAG, 2, sb5.toString());
            }
            if (publicAccountDetailImpl.followType == 1) {
                com.tencent.biz.pubaccount.util.j.INSTANCE.k(publicAccountDetailImpl);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object saveEqqAccountInfos(Object obj, long j3) {
        List<PublicAccountInfo> list = (List) obj;
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        if (this.mPublicAccountCache == null) {
            this.mPublicAccountCache = new ConcurrentHashMap<>();
        }
        List<BaseTransaction> arrayList2 = new ArrayList<>();
        if (list.size() > 0) {
            for (PublicAccountInfo publicAccountInfo : list) {
                updateEntityTransaction(publicAccountInfo, arrayList2);
                this.mPublicAccountCache.put(publicAccountInfo.getUin(), publicAccountInfo);
            }
        }
        Iterator<Map.Entry<String, PublicAccountInfo>> it = this.mPublicAccountCache.entrySet().iterator();
        while (it.hasNext()) {
            PublicAccountInfo value = it.next().getValue();
            if (value.extendType == 2 && value.dateTime < j3) {
                it.remove();
                if (value.getStatus() == 1001) {
                    arrayList2.add(new DeleteTransaction(value.getTableName(), "_id=?", new String[]{String.valueOf(value.getId())}));
                }
                arrayList.add(value);
            }
        }
        this.f79381em.doMultiDBOperateByTransaction(arrayList2);
        buildPublicAccountUI();
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void savePublicAccountInfo(Object obj) {
        if (obj instanceof PublicAccountInfo) {
            final PublicAccountInfo publicAccountInfo = (PublicAccountInfo) obj;
            QLog.d(TAG, 2, "save PublicAccountInfo, puin : " + publicAccountInfo.getUin());
            if (this.mPublicAccountCache == null) {
                this.mPublicAccountCache = new ConcurrentHashMap<>();
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountDataManagerImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountDataManagerImpl.this.lambda$updateAccountDetailEntity$0(publicAccountInfo);
                }
            });
            if (publicAccountInfo.isNeedShow()) {
                this.mPublicAccountCache.put(publicAccountInfo.getUin(), publicAccountInfo);
            } else {
                this.mPublicAccountCache.remove(publicAccountInfo.getUin(), publicAccountInfo);
            }
            buildPublicAccountUI();
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object savePublicAccountInfos(Object obj, long j3, boolean z16, boolean z17, boolean z18, int i3) {
        List<BaseTransaction> arrayList = new ArrayList<>();
        List<PublicAccountInfo> list = (List) obj;
        if (this.mPublicAccountCache == null) {
            this.mPublicAccountCache = new ConcurrentHashMap<>(list != null ? list.size() : 0);
        }
        ArrayList arrayList2 = new ArrayList();
        if (list != null && list.size() > 0) {
            for (PublicAccountInfo publicAccountInfo : list) {
                updateEntityTransaction(publicAccountInfo, arrayList);
                String valueOf = String.valueOf(publicAccountInfo.uin);
                if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(valueOf)) {
                    ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(valueOf, publicAccountInfo.uid);
                }
                if (publicAccountInfo.isNeedShow()) {
                    this.mPublicAccountCache.put(publicAccountInfo.getUin(), publicAccountInfo);
                    this.mPublicAccountInfoNetBuffer.put(Long.valueOf(publicAccountInfo.uin), publicAccountInfo);
                } else {
                    this.mPublicAccountCache.remove(publicAccountInfo.getUin());
                    if (!publicAccountInfo.isVisible()) {
                        arrayList2.add(publicAccountInfo);
                    }
                }
            }
        }
        if (!z16 && z17) {
            Iterator<Map.Entry<String, PublicAccountInfo>> it = this.mPublicAccountCache.entrySet().iterator();
            while (it.hasNext()) {
                PublicAccountInfo value = it.next().getValue();
                if (value.dateTime < j3) {
                    it.remove();
                    arrayList.add(new DeleteTransaction(value.getTableName(), "uin=?", new String[]{value.getUin()}));
                    arrayList2.add(value);
                }
            }
        }
        this.f79381em.doMultiDBOperateByTransaction(arrayList);
        if (z17) {
            com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo publicAccountInfo2 = new com.tencent.qqnt.kernel.nativeinterface.PublicAccountInfo();
            ArrayList<PublicAccountProfile> arrayList3 = new ArrayList<>();
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            Iterator<Map.Entry<Long, PublicAccountInfo>> it5 = this.mPublicAccountInfoNetBuffer.entrySet().iterator();
            while (it5.hasNext()) {
                PublicAccountInfo value2 = it5.next().getValue();
                if (value2 != null) {
                    PublicAccountProfile d16 = com.tencent.biz.pubaccount.util.j.INSTANCE.d(value2);
                    d16.accountPosUpdateTime = Long.valueOf(serverTimeMillis);
                    arrayList3.add(d16);
                }
            }
            this.mPublicAccountInfoNetBuffer.clear();
            publicAccountInfo2.profiles = arrayList3;
            QLog.d(TAG, 1, "upsert kernel public account info source: " + i3 + " isNewLogic: " + z18 + " profile size: " + arrayList3.size());
            com.tencent.biz.pubaccount.util.j.INSTANCE.l(publicAccountInfo2, i3);
        }
        buildPublicAccountUI();
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: updateEntity, reason: merged with bridge method [inline-methods] */
    public boolean lambda$updateAccountDetailEntity$0(Entity entity) {
        if (entity.getStatus() == 1000) {
            this.f79381em.persistOrReplace(entity);
            return entity.getStatus() == 1001;
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return this.f79381em.update(entity);
        }
        return false;
    }

    protected void updateEntityTransaction(Entity entity, List<BaseTransaction> list) {
        if (entity.getStatus() == 1000) {
            list.add(new PersistOrReplaceTransaction(entity));
        } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            list.add(new UpdateTransaction(entity));
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public ArrayList<Entity> getPublicAccountList() {
        return this.publicAccountList;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public boolean isFollowedUin(Long l3, boolean z16) {
        PublicAccountDetailImpl publicAccountDetailImpl;
        List list = (List) getPublicAccountEqqInfoList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((PublicAccountInfo) list.get(i3)).uin == l3.longValue()) {
                return true;
            }
        }
        if (z16) {
            publicAccountDetailImpl = (PublicAccountDetailImpl) findAccountDetailInfoCache(String.valueOf(l3));
        } else {
            publicAccountDetailImpl = (PublicAccountDetailImpl) findAccountDetailInfo(String.valueOf(l3));
        }
        return publicAccountDetailImpl != null && publicAccountDetailImpl.followType == 1;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void updateAccountDetailEntity(IPublicAccountDetail iPublicAccountDetail) {
        if (iPublicAccountDetail == null || iPublicAccountDetail.getId() == -1 || !(iPublicAccountDetail instanceof PublicAccountDetailImpl)) {
            return;
        }
        final PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDetail;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountDataManagerImpl.this.lambda$updateAccountDetailEntity$0(publicAccountDetailImpl);
            }
        }, 32, null, false);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public void updateAccountDetailReceiveMsg(IPublicAccountDetail iPublicAccountDetail, boolean z16) {
        if (iPublicAccountDetail == null || iPublicAccountDetail.getId() == -1 || !(iPublicAccountDetail instanceof PublicAccountDetailImpl)) {
            return;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDetail;
        AppletsHandler appletsHandler = (AppletsHandler) this.app.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (appletsHandler == null) {
            return;
        }
        QLog.d(TAG, 1, "updateAccountDetailReceiveMsg isReceiveMsg:" + z16);
        int i3 = z16 ? 1 : 3;
        appletsHandler.T2(publicAccountDetailImpl.uin, publicAccountDetailImpl.name, z16 ? 1 : 0);
        PublicAccountUtilImpl.setMessageSetting(publicAccountDetailImpl, i3);
        publicAccountDetailImpl.isRecvPush = z16;
        publicAccountDetailImpl.isRecvMsg = z16;
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, publicAccountDetailImpl.name);
        }
        if (!createEntityManager.update(publicAccountDetailImpl)) {
            createEntityManager.drop(PublicAccountDetailImpl.class);
        }
        createEntityManager.close();
        saveAccountDetailInfoCache(iPublicAccountDetail);
        if (i3 == 1) {
            xx.b.INSTANCE.t(publicAccountDetailImpl.uin);
        } else {
            xx.b.INSTANCE.u(publicAccountDetailImpl.uin);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public boolean isSupportPay(String str) {
        long j3;
        if (str == null || str.length() == 0) {
            return false;
        }
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) findPublicAccountInfo(str);
        if (publicAccountInfo != null) {
            j3 = publicAccountInfo.accountFlag2;
        } else {
            PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) findAccountDetailInfo(str);
            if (publicAccountDetailImpl == null) {
                return false;
            }
            j3 = publicAccountDetailImpl.accountFlag2;
        }
        return (j3 & 256) != 0;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountDataManager
    public Object findPublicAccountInfo(String str) {
        return findPublicAccountInfo(str, false);
    }
}
