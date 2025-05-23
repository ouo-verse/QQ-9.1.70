package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppUserAppInfoListManager implements Manager {
    private static final String TAG = "MiniAppUserAppInfoListManager";
    private COMM.StCommonExt mDelExtInfo;
    private volatile COMM.StCommonExt mExtInfo;
    private COMM.StCommonExt mTopExtInfo;
    private LinkedList<MiniAppInfo> mTopAppList = new LinkedList<>();
    private LinkedList<MiniAppInfo> mUsedAppList = new LinkedList<>();
    private LinkedList<MiniAppInfo> mDbCacheAppList = new LinkedList<>();
    private ConcurrentHashMap<String, Integer> mPublicAccountRedDotMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> mPushRedDotMap = new ConcurrentHashMap<>();
    private BusinessObserver redDotObserver = new com.tencent.mobileqq.applets.a() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.1
        @Override // com.tencent.mobileqq.applets.a
        protected void onGetAppletsPushUnreadInfo(Object obj) {
            if (MiniAppConfProcessor.i() && (obj instanceof MiniAppRedDotEntity)) {
                MiniAppUserAppInfoListManager.this.setMiniAppPushRedDotData((MiniAppRedDotEntity) obj);
            }
        }

        @Override // com.tencent.mobileqq.applets.a
        protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> map) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.applets.a.TAG, 1, "onReceiveAppletsMessageUnreadInfo: " + map);
            }
            MiniAppUserAppInfoListManager.this.setMiniAppNoticeRedDotData(map);
        }
    };
    public Runnable initLocalDataRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.5
        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            MiniAppInfo createFromBuffer;
            byte[] bArr2;
            MiniAppInfo createFromBuffer2;
            AppInterface appInterface = MiniAppUtils.getAppInterface();
            if (appInterface == null) {
                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "initLocalDataRunnable, app is null.");
                return;
            }
            try {
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    List<? extends Entity> query = createEntityManager.query(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, "position asc", (String) null);
                    StringBuilder sb5 = new StringBuilder();
                    if (query != null) {
                        synchronized (MiniAppUserAppInfoListManager.class) {
                            if ((MiniAppUserAppInfoListManager.this.mUsedAppList.size() > 0 || MiniAppUserAppInfoListManager.this.mTopAppList.size() > 0) && MiniAppUserAppInfoListManager.this.mExtInfo != null) {
                                MiniAppUserAppInfoListManager.this.mDbCacheAppList.clear();
                                Iterator<? extends Entity> it = query.iterator();
                                while (it.hasNext()) {
                                    MiniAppEntity miniAppEntity = (MiniAppEntity) it.next();
                                    if (miniAppEntity != null && (bArr = miniAppEntity.appInfo) != null && (createFromBuffer = miniAppEntity.createFromBuffer(bArr)) != null) {
                                        MiniAppUserAppInfoListManager.this.mDbCacheAppList.add(createFromBuffer);
                                    }
                                }
                                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "initLocalDataRunnable, has get server data, top list size: " + MiniAppUserAppInfoListManager.this.mTopAppList.size() + ", user list size: " + MiniAppUserAppInfoListManager.this.mUsedAppList.size() + ", mDbCacheAppList size: " + MiniAppUserAppInfoListManager.this.mDbCacheAppList.size());
                                return;
                            }
                            if (MiniAppUserAppInfoListManager.this.mUsedAppList.size() + MiniAppUserAppInfoListManager.this.mTopAppList.size() == query.size()) {
                                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "initLocalDataRunnable, has init. mUsedAppList size: " + MiniAppUserAppInfoListManager.this.mUsedAppList.size() + ", mTopAppList size: " + MiniAppUserAppInfoListManager.this.mTopAppList.size());
                                return;
                            }
                            Iterator<? extends Entity> it5 = query.iterator();
                            while (it5.hasNext()) {
                                MiniAppEntity miniAppEntity2 = (MiniAppEntity) it5.next();
                                if (miniAppEntity2 != null && (bArr2 = miniAppEntity2.appInfo) != null && (createFromBuffer2 = miniAppEntity2.createFromBuffer(bArr2)) != null) {
                                    if (createFromBuffer2.topType == 1) {
                                        MiniAppUserAppInfoListManager.this.mTopAppList.add(createFromBuffer2);
                                    } else {
                                        MiniAppUserAppInfoListManager.this.mUsedAppList.add(createFromBuffer2);
                                    }
                                    sb5.append(createFromBuffer2.position);
                                    sb5.append(":");
                                    sb5.append(createFromBuffer2.name);
                                    sb5.append(", ");
                                }
                            }
                            MiniAppUserAppInfoListManager.this.mDbCacheAppList.clear();
                            MiniAppUserAppInfoListManager.this.mDbCacheAppList.addAll(MiniAppUserAppInfoListManager.this.mTopAppList);
                            MiniAppUserAppInfoListManager.this.mDbCacheAppList.addAll(MiniAppUserAppInfoListManager.this.mUsedAppList);
                            MiniAppUtils.updateMiniAppList(8);
                            QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "initLocalDataRunnable, tempList size=" + query.size() + ", mUsedAppList size=" + MiniAppUserAppInfoListManager.this.mUsedAppList.size() + ", DB cache app List = [" + sb5.toString() + "]");
                        }
                    } else {
                        QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "initLocalDataRunnable, tempList is null.");
                    }
                    List<? extends Entity> query2 = createEntityManager.query(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                    if (query2 != null && query2.size() > 0) {
                        Iterator<? extends Entity> it6 = query2.iterator();
                        while (it6.hasNext()) {
                            MiniAppRedDotEntity miniAppRedDotEntity = (MiniAppRedDotEntity) it6.next();
                            if (miniAppRedDotEntity != null && !TextUtils.isEmpty(miniAppRedDotEntity.appId)) {
                                MiniAppUserAppInfoListManager.this.mPushRedDotMap.put(miniAppRedDotEntity.appId, Integer.valueOf(miniAppRedDotEntity.wnsPushRedDotNum));
                            }
                        }
                    }
                }
                AppletsHandler appletsHandler = (AppletsHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
                if (appletsHandler != null) {
                    appletsHandler.R2();
                }
            } catch (Throwable th5) {
                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "initLocalDataRunnable error,", th5);
            }
        }
    };

    public MiniAppUserAppInfoListManager(QQAppInterface qQAppInterface) {
        AppInterface appInterface;
        QLog.d(TAG, 1, "MiniAppUserAppInfoListManager init.");
        if (!(QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_MINI_APP_OLD_ENTRY_CLOSE_RED_DOT, 0) == 0) || (appInterface = MiniAppUtils.getAppInterface()) == null) {
            return;
        }
        appInterface.addObserver(this.redDotObserver);
    }

    private void clearNoticeRedDotData() {
        this.mPublicAccountRedDotMap.clear();
        ArrayList<MiniAppInfo> arrayList = new ArrayList();
        synchronized (MiniAppUserAppInfoListManager.class) {
            arrayList.addAll(this.mTopAppList);
            arrayList.addAll(this.mUsedAppList);
        }
        for (MiniAppInfo miniAppInfo : arrayList) {
            if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
                Integer num = this.mPushRedDotMap.get(miniAppInfo.appId);
                if (num != null && num.intValue() > 0) {
                    updateRedDotData(new MiniAppRedDotEntity(miniAppInfo.appId, 0, num.intValue()));
                } else {
                    deleteRedDotDataFromDB(miniAppInfo.appId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compareServerAndDbDataAsync(AppInterface appInterface, List<MiniAppInfo> list) {
        byte[] bArr;
        boolean z16;
        String str;
        List<? extends Entity> query = appInterface.getEntityManagerFactory().createEntityManager().query(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        if (list == null || list.size() == 0 || query == null || query.size() == 0) {
            return;
        }
        Iterator<? extends Entity> it = query.iterator();
        while (it.hasNext()) {
            MiniAppEntity miniAppEntity = (MiniAppEntity) it.next();
            if (miniAppEntity != null && (bArr = miniAppEntity.appInfo) != null) {
                MiniAppInfo createFromBuffer = miniAppEntity.createFromBuffer(bArr);
                Iterator<MiniAppInfo> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        z16 = false;
                        break;
                    }
                    MiniAppInfo next = it5.next();
                    if (createFromBuffer != null && (str = createFromBuffer.appId) != null && next != null && str.equals(next.appId) && createFromBuffer.verType == next.verType) {
                        z16 = true;
                        break;
                    }
                }
                if (!z16 && createFromBuffer != null) {
                    deleteMiniAppFromDB(createFromBuffer);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteMiniAppFromDB(final MiniAppInfo miniAppInfo) {
        synchronized (MiniAppUserAppInfoListManager.class) {
            if (this.mUsedAppList.contains(miniAppInfo)) {
                this.mUsedAppList.remove(miniAppInfo);
            }
            if (this.mTopAppList.contains(miniAppInfo)) {
                this.mTopAppList.remove(miniAppInfo);
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.8
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "deleteMiniAppFromDB, app is null.");
                    return;
                }
                MiniAppEntity miniAppEntity = new MiniAppEntity(miniAppInfo);
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    try {
                        miniAppEntity.setStatus(1001);
                        if (createEntityManager.remove(miniAppEntity, "appId=?", new String[]{miniAppEntity.appId})) {
                            QLog.d(MiniAppUserAppInfoListManager.TAG, 2, "deleteMiniAppFromDB, delete " + miniAppEntity.name + " success from db");
                        } else {
                            QLog.d(MiniAppUserAppInfoListManager.TAG, 2, "deleteMiniAppFromDB, delete " + miniAppEntity.name + " fail from db");
                        }
                    } catch (Throwable th5) {
                        QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "deleteMiniAppFromDB, exception: " + Log.getStackTraceString(th5));
                    }
                }
            }
        }, 32, null, true);
    }

    private void deleteRedDotDataFromDB(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.12
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "deleteMiniAppFromDB, app is null.");
                    return;
                }
                MiniAppRedDotEntity miniAppRedDotEntity = new MiniAppRedDotEntity(str, 0, 0);
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    try {
                        miniAppRedDotEntity.setStatus(1001);
                        if (createEntityManager.remove(miniAppRedDotEntity, "appId=?", new String[]{miniAppRedDotEntity.appId})) {
                            QLog.d(MiniAppUserAppInfoListManager.TAG, 2, "deleteRedDotDataFromDB, delete " + miniAppRedDotEntity.appId + " success from db");
                        } else {
                            QLog.d(MiniAppUserAppInfoListManager.TAG, 2, "deleteRedDotDataFromDB, delete " + miniAppRedDotEntity.appId + " fail from db");
                        }
                    } catch (Throwable th5) {
                        QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "deleteRedDotDataFromDB, exception: " + Log.getStackTraceString(th5));
                    }
                }
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseTransaction getUpdateEntityTransaction(Entity entity) {
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return new UpdateTransaction(entity);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertRecommendMiniAppToDB(final MiniAppInfo miniAppInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.10
            @Override // java.lang.Runnable
            public void run() {
                if (miniAppInfo == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "insertRecommendMiniAppToDB, appInfo is null.");
                    return;
                }
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "insertRecommendMiniAppToDB, app is null.");
                    return;
                }
                MiniAppInfo miniAppInfo2 = miniAppInfo;
                RecommendMiniAppEntity recommendMiniAppEntity = new RecommendMiniAppEntity(miniAppInfo2.appId, miniAppInfo2.name, miniAppInfo2.recommend);
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    if (MiniAppUserAppInfoListManager.this.updateEntity(createEntityManager, recommendMiniAppEntity)) {
                        QLog.d(MiniAppUserAppInfoListManager.TAG, 1, "insertRecommendMiniAppToDB, success to delete recommend appInfo: " + recommendMiniAppEntity);
                        return;
                    }
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "insertRecommendMiniAppToDB, failed to delete recommend appInfo: " + recommendMiniAppEntity);
                }
            }
        }, 32, null, true);
    }

    private void saveDataToDBWithBatch(final List<MiniAppInfo> list, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.9
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "saveDataToDBWithBatch, app is null.");
                    return;
                }
                if (z16) {
                    MiniAppUserAppInfoListManager.this.compareServerAndDbDataAsync(appInterface, list);
                }
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    StringBuilder sb5 = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    int i3 = 1;
                    for (MiniAppInfo miniAppInfo : list) {
                        miniAppInfo.position = i3;
                        MiniAppEntity miniAppEntity = new MiniAppEntity(miniAppInfo);
                        miniAppEntity.setStatus(1000);
                        BaseTransaction updateEntityTransaction = MiniAppUserAppInfoListManager.this.getUpdateEntityTransaction(miniAppEntity);
                        if (updateEntityTransaction != null) {
                            arrayList.add(updateEntityTransaction);
                            i3++;
                        }
                        sb5.append(miniAppInfo.name);
                        sb5.append(", ");
                    }
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                    if (QLog.isColorLevel()) {
                        QLog.d(MiniAppUserAppInfoListManager.TAG, 2, "saveMiniAppInfoList : ", sb5.toString());
                    }
                }
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateEntity(EntityManager entityManager, Entity entity) {
        boolean z16 = false;
        if (entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                entityManager.persistOrReplace(entity);
                if (entity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                z16 = entityManager.update(entity);
            }
            entityManager.close();
        }
        return z16;
    }

    private void updateRedDotData(final MiniAppRedDotEntity miniAppRedDotEntity) {
        if (miniAppRedDotEntity == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.11
            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "updateRedDotData, app is null.");
                    return;
                }
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    if (MiniAppUserAppInfoListManager.this.updateRedDotData(createEntityManager, miniAppRedDotEntity)) {
                        QLog.d(MiniAppUserAppInfoListManager.TAG, 1, "updateRedDotData, success to delete recommend appInfo: " + miniAppRedDotEntity);
                        return;
                    }
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "updateRedDotData, failed to delete recommend appInfo: " + miniAppRedDotEntity);
                }
            }
        }, 32, null, true);
    }

    public MiniAppInfo findMiniApp(String str, int i3) {
        synchronized (MiniAppUserAppInfoListManager.class) {
            Iterator<MiniAppInfo> it = this.mTopAppList.iterator();
            while (it.hasNext()) {
                MiniAppInfo next = it.next();
                if (next != null && str.equals(next.appId) && i3 == next.verType) {
                    QLog.d(TAG, 1, "findMiniApp, appInfo = " + next);
                    return next;
                }
            }
            Iterator<MiniAppInfo> it5 = this.mUsedAppList.iterator();
            while (it5.hasNext()) {
                MiniAppInfo next2 = it5.next();
                if (next2 != null && str.equals(next2.appId) && i3 == next2.verType) {
                    QLog.d(TAG, 1, "findMiniApp, appInfo = " + next2);
                    return next2;
                }
            }
            QLog.d(TAG, 1, "findMiniApp, failed to find Miniapp, appId = " + str);
            return null;
        }
    }

    public MiniAppInfo findTopMiniApp(String str) {
        synchronized (MiniAppUserAppInfoListManager.class) {
            Iterator<MiniAppInfo> it = this.mTopAppList.iterator();
            while (it.hasNext()) {
                MiniAppInfo next = it.next();
                if (next != null && str.equals(next.appId)) {
                    QLog.d(TAG, 1, "findMiniApp, appInfo = " + next);
                    return next;
                }
            }
            QLog.d(TAG, 1, "findMiniApp, failed to find  top Miniapp");
            return null;
        }
    }

    public List<MiniAppInfo> getMiniAppInfoData() {
        LinkedList linkedList = new LinkedList();
        synchronized (MiniAppUserAppInfoListManager.class) {
            if (this.mTopAppList.size() > 0) {
                linkedList.addAll(this.mTopAppList);
            }
            if (this.mUsedAppList.size() > 0) {
                linkedList.addAll(this.mUsedAppList);
            }
            if (linkedList.size() <= 0) {
                linkedList.addAll(this.mDbCacheAppList);
                QLog.e(TAG, 1, "getMiniAppInfoData, user DB cache data. size = " + linkedList.size());
            }
        }
        QLog.d(TAG, 2, "getMiniAppInfoData, size = " + linkedList.size());
        return linkedList;
    }

    public List<RecommendMiniAppEntity> getOldRecommendMiniAppList() {
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 1, "getOldRecommendMiniAppList, app is null.");
            return null;
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            return createEntityManager.query(RecommendMiniAppEntity.class, RecommendMiniAppEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
        }
        return null;
    }

    public COMM.StCommonExt getPullDownEntryExtInfo() {
        return this.mExtInfo;
    }

    public Map<String, Integer> getRedDotData() {
        HashMap hashMap = new HashMap();
        ArrayList<MiniAppInfo> arrayList = new ArrayList();
        synchronized (MiniAppUserAppInfoListManager.class) {
            arrayList.addAll(this.mTopAppList);
            arrayList.addAll(this.mUsedAppList);
        }
        if (arrayList.size() <= 0) {
            return hashMap;
        }
        boolean h16 = MiniAppConfProcessor.h();
        for (MiniAppInfo miniAppInfo : arrayList) {
            if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
                Integer num = this.mPublicAccountRedDotMap.get(miniAppInfo.appId);
                Integer num2 = this.mPushRedDotMap.get(miniAppInfo.appId);
                int i3 = 0;
                if (num != null && num.intValue() > 0 && h16) {
                    i3 = 0 + num.intValue();
                }
                if (num2 != null && num2.intValue() > 0) {
                    i3 += num2.intValue();
                }
                hashMap.put(miniAppInfo.appId, Integer.valueOf(i3));
            }
        }
        return hashMap;
    }

    public int getTopMiniAppNumber() {
        int size;
        synchronized (MiniAppUserAppInfoListManager.class) {
            size = this.mTopAppList.size();
        }
        return size;
    }

    public void queryMiniAppInfoFromDb() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.6
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                MiniAppInfo createFromBuffer;
                AppInterface appInterface = MiniAppUtils.getAppInterface();
                if (appInterface == null) {
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "queryMiniAppInfoFromDb, app is null.");
                    return;
                }
                EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    List<? extends Entity> query = createEntityManager.query(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, "position asc", (String) null);
                    StringBuilder sb5 = new StringBuilder();
                    if (query != null) {
                        synchronized (MiniAppUserAppInfoListManager.class) {
                            if (query.size() > 0 && MiniAppUserAppInfoListManager.this.mDbCacheAppList.size() <= 0) {
                                MiniAppUserAppInfoListManager.this.mDbCacheAppList.clear();
                                Iterator<? extends Entity> it = query.iterator();
                                while (it.hasNext()) {
                                    MiniAppEntity miniAppEntity = (MiniAppEntity) it.next();
                                    if (miniAppEntity != null && (bArr = miniAppEntity.appInfo) != null && (createFromBuffer = miniAppEntity.createFromBuffer(bArr)) != null) {
                                        MiniAppUserAppInfoListManager.this.mDbCacheAppList.add(createFromBuffer);
                                        sb5.append(createFromBuffer.name);
                                        sb5.append(",");
                                    }
                                }
                                MiniAppUtils.updateMiniAppList(9);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(MiniAppUserAppInfoListManager.TAG, 2, "queryMiniAppInfoFromDb, mDbCacheAppList size = " + MiniAppUserAppInfoListManager.this.mDbCacheAppList.size() + ", " + sb5.toString());
                            }
                        }
                        return;
                    }
                    QLog.d(MiniAppUserAppInfoListManager.TAG, 1, "queryMiniAppInfoFromDb, mDbCacheAppList tempList is null.");
                }
            }
        }, 32, null, true);
    }

    public void removeAllMiniAppInfo() {
        QLog.i(TAG, 2, "clear memory cache");
        synchronized (MiniAppUserAppInfoListManager.class) {
            this.mUsedAppList.clear();
            this.mTopAppList.clear();
        }
    }

    public void removeRedDotData(String str) {
        this.mPublicAccountRedDotMap.remove(str);
        this.mPushRedDotMap.remove(str);
        deleteRedDotDataFromDB(str);
    }

    public void saveMiniAppInfoList(List<MiniAppInfo> list, List<MiniAppInfo> list2) {
        ArrayList arrayList = new ArrayList();
        synchronized (MiniAppUserAppInfoListManager.class) {
            this.mTopAppList.addAll(list);
            this.mUsedAppList.addAll(list2);
            arrayList.addAll(this.mTopAppList);
            arrayList.addAll(this.mUsedAppList);
        }
        saveDataToDBWithBatch(arrayList, true);
    }

    public void sendDelUserAppRequest(final MiniAppInfo miniAppInfo) {
        MiniAppCmdUtil.getInstance().delUserApp(miniAppInfo.appId, miniAppInfo.verType, miniAppInfo.recommend, 1, this.mDelExtInfo, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.3
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    COMM.StCommonExt stCommonExt = (COMM.StCommonExt) jSONObject.opt("ext");
                    if (stCommonExt != null) {
                        MiniAppUserAppInfoListManager.this.mDelExtInfo = stCommonExt;
                    }
                    MiniAppUserAppInfoListManager.this.deleteMiniAppFromDB(miniAppInfo);
                    MiniAppUtils.updateMiniAppList(4);
                    MiniAppInfo miniAppInfo2 = miniAppInfo;
                    if (miniAppInfo2.recommend == 1) {
                        MiniAppUserAppInfoListManager.this.insertRecommendMiniAppToDB(miniAppInfo2);
                    }
                    if (!MiniAppConfProcessor.m()) {
                        MiniAppUserAppInfoListManager.this.removeRedDotData(miniAppInfo.appId);
                    }
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 2, "sendDelUserAppRequest, success. delete appInfo: " + miniAppInfo);
                    return;
                }
                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "sendDelUserAppRequest, failed to delete miniapp!");
                QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.o86), 0).show();
            }
        });
    }

    public void sendSetUserAppTopRequest(final MiniAppInfo miniAppInfo) {
        MiniAppCmdUtil.getInstance().setUserAppTop(miniAppInfo.appId, miniAppInfo.topType, miniAppInfo.verType, this.mTopExtInfo, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.4
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    COMM.StCommonExt stCommonExt = (COMM.StCommonExt) jSONObject.opt("ext");
                    if (stCommonExt != null) {
                        MiniAppUserAppInfoListManager.this.mTopExtInfo = stCommonExt;
                    }
                    MiniAppUserAppInfoListManager.this.updateMiniAppTopStatus(miniAppInfo);
                    QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "sendSetUserAppTopRequest, success.");
                    return;
                }
                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "sendSetUserAppTopRequest, failed to set top!");
                QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.o87), 0).show();
            }
        });
    }

    public void setMiniAppPushRedDotData(MiniAppRedDotEntity miniAppRedDotEntity) {
        QLog.d(TAG, 1, "setMiniAppPushRedDotData, data: " + miniAppRedDotEntity);
        if (miniAppRedDotEntity == null || TextUtils.isEmpty(miniAppRedDotEntity.appId)) {
            return;
        }
        if (findMiniApp(miniAppRedDotEntity.appId) == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "setMiniAppPushRedDotData, current app is not opened");
            }
        } else {
            this.mPushRedDotMap.put(miniAppRedDotEntity.appId, Integer.valueOf(miniAppRedDotEntity.wnsPushRedDotNum));
            Integer num = this.mPublicAccountRedDotMap.get(miniAppRedDotEntity.appId);
            updateRedDotData(new MiniAppRedDotEntity(miniAppRedDotEntity.appId, (num == null || num.intValue() <= 0) ? 0 : num.intValue(), miniAppRedDotEntity.wnsPushRedDotNum));
            MiniAppUtils.updateMiniAppList(101);
        }
    }

    public void updateMiniAppTopStatus(final MiniAppInfo miniAppInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.7
            @Override // java.lang.Runnable
            public void run() {
                MiniAppUserAppInfoListManager.this.updateAppInfoTopRecord(miniAppInfo);
                MiniAppUtils.updateMiniAppList(5);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetUserAppListData(INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp) {
        boolean z16;
        if (iNTERFACE$StGetUserAppListRsp != null) {
            List<INTERFACE$StUserAppInfo> list = iNTERFACE$StGetUserAppListRsp.userAppList.get();
            List<INTERFACE$StUserAppInfo> list2 = iNTERFACE$StGetUserAppListRsp.fixApps.get();
            if (list == null && list2 == null) {
                QLog.e(TAG, 1, "handleGetUserAppListData, userAppInfoList = " + list + ", fixApps = " + list2);
                return;
            }
            if (list != null && list2 != null && list.size() == 0 && list2.size() == 0) {
                removeAllMiniAppInfo();
                QLog.e(TAG, 1, "handleGetUserAppListData, userAppInfoList = " + list + ", fixApps = " + list2);
                return;
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            List<RecommendMiniAppEntity> oldRecommendMiniAppList = getOldRecommendMiniAppList();
            StringBuilder sb5 = new StringBuilder();
            if (list2 != null && list2.size() != 0) {
                for (INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo : list2) {
                    if (iNTERFACE$StUserAppInfo != null && iNTERFACE$StUserAppInfo.appInfo != null) {
                        MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StUserAppInfo);
                        linkedList.add(from);
                        sb5.append(from.name);
                        sb5.append("(fixApp), ");
                    }
                }
            }
            if (list != null) {
                for (INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo2 : list) {
                    if (iNTERFACE$StUserAppInfo2 != null && iNTERFACE$StUserAppInfo2.appInfo != null) {
                        MiniAppInfo from2 = MiniAppInfo.from(iNTERFACE$StUserAppInfo2);
                        if (!from2.isEngineTypeMiniGame() || GameWnsUtils.gameEnable()) {
                            int i3 = from2.recommend;
                            if (i3 == 1 && oldRecommendMiniAppList != null) {
                                RecommendMiniAppEntity recommendMiniAppEntity = new RecommendMiniAppEntity(from2.appId, from2.name, i3);
                                Iterator<RecommendMiniAppEntity> it = oldRecommendMiniAppList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z16 = false;
                                        break;
                                    }
                                    RecommendMiniAppEntity next = it.next();
                                    String str = from2.appId;
                                    if (str != null && str.equals(next.appId)) {
                                        z16 = true;
                                        break;
                                    }
                                }
                                if (z16) {
                                    QLog.d(TAG, 2, "handleGetUserAppListData, filter recommend mini app: " + recommendMiniAppEntity);
                                }
                            }
                            if (from2.topType == 0) {
                                linkedList2.add(from2);
                            } else {
                                linkedList.add(from2);
                            }
                            sb5.append(from2.name);
                            sb5.append(", ");
                        }
                    }
                }
            }
            this.mExtInfo = iNTERFACE$StGetUserAppListRsp.extInfo;
            if (linkedList2.size() > 0 || linkedList.size() > 0) {
                removeAllMiniAppInfo();
                saveMiniAppInfoList(linkedList, linkedList2);
            }
            QLog.d(TAG, 1, "handleGetUserAppListData, app List = " + sb5.toString());
            return;
        }
        QLog.e(TAG, 2, "handleGetUserAppListData, rsp = null");
    }

    public void sendUserAppListRequest(long j3, long j16) {
        AppletsHandler appletsHandler;
        QLog.d(TAG, 1, "sendUserAppListRequest");
        MiniAppCmdUtil.getInstance().getUserAppList(j3, j16, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    String optString = jSONObject.optString("errMsg");
                    if (optLong != 0) {
                        MiniAppUserAppInfoListManager.this.queryMiniAppInfoFromDb();
                        MiniAppUtils.updateMiniAppList(10);
                        MiniAppUtils.resetUserAppListRequestRefreshTime();
                        QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "sendUserAppListRequest, retCode = " + optLong + ", errMsg = " + optString);
                        return;
                    }
                    INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp = (INTERFACE$StGetUserAppListRsp) jSONObject.opt("response");
                    MiniAppUserAppInfoListManager.this.handleGetUserAppListData(iNTERFACE$StGetUserAppListRsp);
                    AppInterface appInterface = MiniAppUtils.getAppInterface();
                    if (appInterface != null) {
                        MiniAppUtils.handlePreloadAppData(appInterface.getApp(), iNTERFACE$StGetUserAppListRsp);
                    } else {
                        QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "sendUserAppListRequest, app is null.");
                    }
                    MiniAppUtils.updateMiniAppList(1);
                    return;
                }
                if (jSONObject != null && jSONObject.optLong("retCode") != 1000) {
                    MiniAppUtils.resetUserAppListRequestRefreshTime();
                }
                MiniAppUserAppInfoListManager.this.queryMiniAppInfoFromDb();
                MiniAppUtils.updateMiniAppList(2);
                QLog.e(MiniAppUserAppInfoListManager.TAG, 1, "sendUserAppListRequest, isSuccess = " + z16 + ", ret = " + jSONObject);
            }
        });
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            SharedPreferences preferences = appInterface.getPreferences();
            String str = appInterface.getCurrentAccountUin() + AppConstants.Preferences.KEY_UPDATE_APPLETS_NOTIFICATION_SETTING_TIME;
            long j17 = preferences.getLong(str, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j17 <= QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_GET_APPLETS_NOTIFICATION_SETTING_INTERVAL, 1L) * 1000 || (appletsHandler = (AppletsHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER)) == null) {
                return;
            }
            appletsHandler.E2();
            preferences.edit().putLong(str, currentTimeMillis).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateRedDotData(EntityManager entityManager, Entity entity) {
        boolean z16 = false;
        if (entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                entityManager.persistOrReplace(entity);
                if (entity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                z16 = entityManager.update(entity);
            }
            entityManager.close();
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    public static void recordMiniAppStart(MiniAppInfo miniAppInfo) {
        AppRuntime runtime;
        if (miniAppInfo == null || (runtime = BaseApplicationImpl.getApplication().getRuntime()) == null) {
            return;
        }
        MiniAppUserAppInfoListManager miniAppUserAppInfoListManager = (MiniAppUserAppInfoListManager) runtime.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        if (miniAppUserAppInfoListManager != null) {
            miniAppUserAppInfoListManager.updateMiniAppStartRecord(miniAppInfo);
        }
        QLog.d(TAG, 1, "recordMiniAppStart, appInfo = " + miniAppInfo + ", appRuntime = " + runtime + "\uff0c manager = " + miniAppUserAppInfoListManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAppInfoTopRecord(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            ArrayList arrayList = new ArrayList();
            synchronized (MiniAppUserAppInfoListManager.class) {
                if (this.mTopAppList.contains(miniAppInfo)) {
                    this.mTopAppList.remove(miniAppInfo);
                }
                if (this.mUsedAppList.contains(miniAppInfo)) {
                    this.mUsedAppList.remove(miniAppInfo);
                }
                int i3 = miniAppInfo.topType;
                if (i3 == 0) {
                    this.mUsedAppList.addFirst(miniAppInfo);
                } else if (i3 == 1) {
                    this.mTopAppList.addFirst(miniAppInfo);
                }
                arrayList.addAll(this.mTopAppList);
                arrayList.addAll(this.mUsedAppList);
            }
            saveDataToDBWithBatch(arrayList, false);
            return;
        }
        QLog.e(TAG, 1, "insertAppInfo error app info is invalid, appInfo = " + miniAppInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:8:0x0015, B:10:0x001d, B:13:0x001f, B:15:0x0028, B:17:0x0032, B:19:0x0042, B:21:0x0058, B:22:0x005e, B:24:0x0069, B:26:0x006f, B:27:0x0074, B:28:0x007e, B:32:0x0050), top: B:7:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateMiniAppStartRecord(MiniAppInfo miniAppInfo) {
        boolean z16;
        boolean z17 = true;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            ArrayList arrayList = new ArrayList();
            synchronized (MiniAppUserAppInfoListManager.class) {
                if (this.mTopAppList.contains(miniAppInfo)) {
                    return;
                }
                if (this.mUsedAppList.contains(miniAppInfo)) {
                    this.mUsedAppList.remove(miniAppInfo);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    MiniAppInfo findMiniApp = findMiniApp(miniAppInfo.appId, miniAppInfo.verType);
                    if (this.mTopAppList.contains(findMiniApp)) {
                        this.mTopAppList.set(this.mTopAppList.indexOf(findMiniApp), miniAppInfo);
                        if (!z17) {
                            int size = this.mTopAppList.size();
                            while (this.mUsedAppList.size() + size >= 20) {
                                this.mUsedAppList.removeLast();
                            }
                            this.mUsedAppList.addFirst(miniAppInfo);
                        }
                        arrayList.addAll(this.mTopAppList);
                        arrayList.addAll(this.mUsedAppList);
                        saveDataToDBWithBatch(arrayList, false);
                        return;
                    }
                    if (findMiniApp != null) {
                        this.mUsedAppList.remove(findMiniApp);
                    }
                }
                z17 = false;
                if (!z17) {
                }
                arrayList.addAll(this.mTopAppList);
                arrayList.addAll(this.mUsedAppList);
                saveDataToDBWithBatch(arrayList, false);
                return;
            }
        }
        QLog.e(TAG, 1, "insertAppInfo error app info is invalid, appInfo = " + miniAppInfo);
    }

    public void setMiniAppNoticeRedDotData(Map<String, Integer> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null && value.intValue() > 0) {
                    this.mPublicAccountRedDotMap.put(key, value);
                    Integer num = this.mPushRedDotMap.get(key);
                    if (num == null) {
                        num = 0;
                    }
                    updateRedDotData(new MiniAppRedDotEntity(key, value.intValue(), num.intValue()));
                }
            }
            MiniAppUtils.updateMiniAppList(101);
            return;
        }
        QLog.d(TAG, 1, "setMiniAppNoticeRedDotData, data is null or data size = 0");
        clearNoticeRedDotData();
        MiniAppUtils.updateMiniAppList(101);
    }

    public MiniAppInfo findMiniApp(String str) {
        synchronized (MiniAppUserAppInfoListManager.class) {
            Iterator<MiniAppInfo> it = this.mTopAppList.iterator();
            while (it.hasNext()) {
                MiniAppInfo next = it.next();
                if (next != null && str.equals(next.appId)) {
                    QLog.d(TAG, 1, "findMiniApp, appInfo = " + next);
                    return next;
                }
            }
            Iterator<MiniAppInfo> it5 = this.mUsedAppList.iterator();
            while (it5.hasNext()) {
                MiniAppInfo next2 = it5.next();
                if (next2 != null && str.equals(next2.appId)) {
                    QLog.d(TAG, 1, "findMiniApp, appInfo = " + next2);
                    return next2;
                }
            }
            QLog.d(TAG, 1, "findMiniApp, failed to find Miniapp, appId = " + str);
            return null;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
