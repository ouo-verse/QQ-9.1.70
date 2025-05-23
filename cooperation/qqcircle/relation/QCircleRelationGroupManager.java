package cooperation.qqcircle.relation;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import cooperation.qqcircle.relation.entitys.QCircleFriendEntity;
import cooperation.qqcircle.relation.format.QCircleFriendFormat;
import cooperation.qqcircle.relation.request.IQCircleRelationModel;
import cooperation.qqcircle.relation.request.QCircleRelationModel;
import feedcloud.FeedCloudMeta$StRelationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import qqcircle.QQCircleRelation$RelationBiz;
import vd2.GroupInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleRelationGroupManager {
    private static final int BIT_FLAG = 1;
    private static final int DEF_GROUP_FLAG = 0;
    public static final int FOLLOW_LOAD_SCENE = 1;
    private static volatile QCircleRelationGroupManager INSTANCE = null;
    public static final int INTERVAL_LOAD_SCENE = 0;
    public static final String TAG = "RFL-QCircleAtGroupManager";
    private EntityManager mEntityManager;
    private final List<QCircleFriendEntity> mFriendEntityList = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DeleteFriendDBTask implements Runnable {
        private static final String TAG = "RFL-DeleteFriendDBTask";
        private final WeakReference<EntityManager> mEntityManagerWeak;
        private final QCircleFriendEntity mFriendEntity;

        public DeleteFriendDBTask(QCircleFriendEntity qCircleFriendEntity, EntityManager entityManager) {
            this.mEntityManagerWeak = new WeakReference<>(entityManager);
            this.mFriendEntity = qCircleFriendEntity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mFriendEntity == null) {
                QLog.d(TAG, 1, "[run] friend entity not is null.");
                return;
            }
            EntityManager entityManager = this.mEntityManagerWeak.get();
            if (entityManager == null) {
                QLog.d(TAG, 1, "[run] entity manager not is null.");
                return;
            }
            try {
                QLog.d(TAG, 1, "[run] delete count: ", Integer.valueOf(entityManager.delete(QCircleFriendEntity.class.getSimpleName(), "mUin=?", new String[]{String.valueOf(this.mFriendEntity.getUin())})));
            } catch (Throwable th5) {
                QLog.d(TAG, 1, "[run] delete fail: ", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SaveFriendToDBTask implements Runnable {
        private static final String TAG = "RFL-SaveFriendToDBTask";
        private final boolean mIsClearDB;
        private final WeakReference<EntityManager> mSaveFriendToDBTaskWeak;
        private final List<QCircleFriendEntity> mSaveToDBFriendList;

        public SaveFriendToDBTask(boolean z16, List<QCircleFriendEntity> list, EntityManager entityManager) {
            this.mIsClearDB = z16;
            this.mSaveToDBFriendList = list;
            this.mSaveFriendToDBTaskWeak = new WeakReference<>(entityManager);
        }

        private void clearLocalQCircleFriendList() {
            EntityManager entityManager = this.mSaveFriendToDBTaskWeak.get();
            if (entityManager == null) {
                QLog.w(TAG, 1, "[clearLocalQCircleFriendList] manager not is null.");
                return;
            }
            try {
                QLog.d(TAG, 1, "[clearLocalQCircleFriendList] clear qcircle friend count: ", Integer.valueOf(entityManager.delete(QCircleFriendEntity.class.getSimpleName(), null, null)));
            } catch (Exception e16) {
                QLog.w(TAG, 1, "[clearLocalQCircleFriendList] error: ", e16);
            }
        }

        private void updateNewFriendListToDB() {
            EntityManager entityManager = this.mSaveFriendToDBTaskWeak.get();
            if (entityManager == null) {
                QLog.w(TAG, 1, "[updateNewFriendListToDB] manager not is null.");
                return;
            }
            QLog.d(TAG, 1, "[updateNewFriendListToDB] save to db count: ", Integer.valueOf(this.mSaveToDBFriendList.size()));
            ArrayList arrayList = new ArrayList();
            for (QCircleFriendEntity qCircleFriendEntity : this.mSaveToDBFriendList) {
                if (qCircleFriendEntity != null) {
                    arrayList.add(new PersistTransaction(qCircleFriendEntity));
                }
            }
            entityManager.doMultiDBOperateByTransaction(arrayList);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mIsClearDB) {
                clearLocalQCircleFriendList();
            }
            updateNewFriendListToDB();
        }
    }

    QCircleRelationGroupManager() {
    }

    private void addFriendEntity(String str, String str2) {
        QLog.d(TAG, 1, "[addFriendEntity] uin: ", str, " | name: ", str2);
        loadRelationGroupData(1);
    }

    private void asyncInitFriendCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: cooperation.qqcircle.relation.QCircleRelationGroupManager.2
            @Override // java.lang.Runnable
            public void run() {
                QCircleRelationGroupManager.this.updateCurrentFriendCache();
            }
        }, 32, null, true);
    }

    @WorkerThread
    private QCircleFriendEntity buildFriendEntity(String str, NewRelationInfo newRelationInfo) {
        FeedCloudMeta$StRelationInfo relationInfo;
        QCircleFriendEntity qCircleFriendEntity = null;
        if (newRelationInfo == null || TextUtils.isEmpty(str) || (relationInfo = newRelationInfo.getRelationInfo()) == null || "".equals(relationInfo.f398459id.get())) {
            return null;
        }
        long j3 = 0;
        try {
            j3 = Long.parseLong(relationInfo.f398459id.get());
            int groupFlag = newRelationInfo.getGroupFlag();
            String groupId = newRelationInfo.getGroupId();
            QCircleFriendEntity qCircleFriendEntity2 = new QCircleFriendEntity();
            try {
                qCircleFriendEntity2.setUin(j3);
                qCircleFriendEntity2.setGroupName(str);
                qCircleFriendEntity2.setGroupFlag(groupFlag);
                qCircleFriendEntity2.setGroupId(groupId);
                QQCircleRelation$RelationBiz qQCircleRelation$RelationBiz = new QQCircleRelation$RelationBiz();
                qQCircleRelation$RelationBiz.mergeFrom(relationInfo.busiData.get().toByteArray());
                qCircleFriendEntity2.setName(qQCircleRelation$RelationBiz.nick.get());
                qCircleFriendEntity2.setAuthType(qQCircleRelation$RelationBiz.certification.get());
                return qCircleFriendEntity2;
            } catch (Exception unused) {
                qCircleFriendEntity = qCircleFriendEntity2;
                QLog.e(TAG, 1, "[buildFriendEntity] error uin:", Long.valueOf(j3));
                return qCircleFriendEntity;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public List<QCircleFriendEntity> convertFriendList(Map<String, List<NewRelationInfo>> map) {
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, List<NewRelationInfo>> entry : map.entrySet()) {
                List<NewRelationInfo> value = entry.getValue();
                if (value != null && !value.isEmpty()) {
                    String key = entry.getKey();
                    Iterator<NewRelationInfo> it = value.iterator();
                    while (it.hasNext()) {
                        QCircleFriendEntity buildFriendEntity = buildFriendEntity(key, it.next());
                        if (buildFriendEntity != null) {
                            arrayList.add(buildFriendEntity);
                        }
                    }
                }
            }
            return arrayList;
        }
        QLog.w(TAG, 1, "[convertFriendList] current results not is null.");
        return null;
    }

    private void deleteFriendEntityToDB(QCircleFriendEntity qCircleFriendEntity) {
        ThreadManagerV2.excute(new DeleteFriendDBTask(qCircleFriendEntity, getEntityManager()), 32, null, true);
    }

    private QCircleFriendEntity findFriendEntityList(long j3) {
        if (this.mFriendEntityList.isEmpty()) {
            return null;
        }
        for (QCircleFriendEntity qCircleFriendEntity : this.mFriendEntityList) {
            if (qCircleFriendEntity != null && qCircleFriendEntity.mUin == j3) {
                return qCircleFriendEntity;
            }
        }
        return null;
    }

    private EntityManager getEntityManager() {
        if (this.mEntityManager == null) {
            this.mEntityManager = QCircleServiceImpl.getEntityManager();
        }
        return this.mEntityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAtRelationData(final Map<String, List<NewRelationInfo>> map, final long j3) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: cooperation.qqcircle.relation.QCircleRelationGroupManager.3
            @Override // java.lang.Runnable
            public void run() {
                int size;
                List convertFriendList = QCircleRelationGroupManager.this.convertFriendList(map);
                QCircleRelationGroupManager.this.setCurrentFriendCache(convertFriendList);
                QCircleRelationGroupManager.this.saveFriendListToDB(true, convertFriendList);
                long j16 = j3 * 1000;
                long currentTimeMillis = System.currentTimeMillis();
                if (convertFriendList == null) {
                    size = 0;
                } else {
                    size = convertFriendList.size();
                }
                QLog.d(QCircleRelationGroupManager.TAG, 1, "[handleAtRelationData] friend list count: ", Integer.valueOf(size), " | currentLoadTime: ", Long.valueOf(currentTimeMillis), " | loadTimeInterval: ", Long.valueOf(j16));
                QCircleHostConfig.setRelationGroupTimeInterval(j16);
                QCircleHostConfig.setRelationGroupTime(currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFollowSceneLoadData(final Map<String, List<NewRelationInfo>> map) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: cooperation.qqcircle.relation.QCircleRelationGroupManager.4
            @Override // java.lang.Runnable
            public void run() {
                List convertFriendList = QCircleRelationGroupManager.this.convertFriendList(map);
                if (convertFriendList == null) {
                    QLog.d(QCircleRelationGroupManager.TAG, 1, "[handleFollowSceneLoadData] temp friend list should not be null.");
                } else {
                    QLog.d(QCircleRelationGroupManager.TAG, 1, "[handleFollowSceneLoadData] rsp new follow, page data count: ", Integer.valueOf(convertFriendList.size()));
                    QCircleRelationGroupManager.this.saveFriendListToDB(false, QCircleRelationGroupManager.this.updateCurrentFriendCache(convertFriendList));
                }
            }
        });
    }

    private boolean hasRelationDBWrite(int i3) {
        if ((i3 & 1) != 1) {
            return true;
        }
        return false;
    }

    public static QCircleRelationGroupManager instance() {
        if (INSTANCE == null) {
            synchronized (QCircleRelationGroupManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new QCircleRelationGroupManager();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveFriendListToDB(boolean z16, List<QCircleFriendEntity> list) {
        EntityManager entityManager = getEntityManager();
        if (entityManager == null) {
            QLog.w(TAG, 1, "[saveFriendListToDB] entity manager not is null.");
        } else if (list != null && !list.isEmpty()) {
            QLog.d(TAG, 1, "[saveFriendListToDB] friends size: ", Integer.valueOf(list.size()), " | isClearDB: ", Boolean.valueOf(z16));
            ThreadManagerV2.excute(new SaveFriendToDBTask(z16, list, entityManager), 32, null, true);
        } else {
            QLog.w(TAG, 1, "[saveFriendListToDB] current save firends not is empty.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentFriendCache(List<QCircleFriendEntity> list) {
        Object[] objArr = new Object[2];
        int i3 = 0;
        objArr[0] = "[setCurrentFriendCache] list size: ";
        if (list != null) {
            i3 = list.size();
        }
        objArr[1] = Integer.valueOf(i3);
        QLog.d(TAG, 1, objArr);
        this.mFriendEntityList.clear();
        if (list != null && !list.isEmpty()) {
            this.mFriendEntityList.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentFriendCache() {
        EntityManager entityManager = getEntityManager();
        if (entityManager == null) {
            QLog.w(TAG, 1, "[getFriendGroupMap] current entity manager not is null.");
        } else {
            setCurrentFriendCache(entityManager.query(QCircleFriendEntity.class));
        }
    }

    public void deleteFriendEntity(String str) {
        long j3;
        int groupFlag;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.w(TAG, 1, "delete friend uin: " + str, e16);
            j3 = 0;
        }
        QCircleFriendEntity findFriendEntityList = findFriendEntityList(j3);
        if (findFriendEntityList == null) {
            groupFlag = 0;
        } else {
            groupFlag = findFriendEntityList.getGroupFlag();
        }
        if (!hasRelationDBWrite(groupFlag)) {
            QLog.d(TAG, 1, "[run] current not delete uin: ", Long.valueOf(j3), " | hasGroupFlagType == false.");
        } else if (findFriendEntityList != null) {
            this.mFriendEntityList.remove(findFriendEntityList);
            deleteFriendEntityToDB(findFriendEntityList);
            QLog.d(TAG, 1, "[deleteFriendEntity] delete uin: ", Long.valueOf(j3));
        }
    }

    public Map<GroupInfo, List<Entity>> getFriendGroupMap() {
        Map<GroupInfo, List<Entity>> format = QCircleFriendFormat.format(this.mFriendEntityList);
        if (!this.mFriendEntityList.isEmpty()) {
            return format;
        }
        asyncInitFriendCache();
        return format;
    }

    public void loadRelationGroup() {
        long relationGroupLoadTime = QCircleHostConfig.getRelationGroupLoadTime();
        long relationLoadTimeInterval = QCircleHostConfig.getRelationLoadTimeInterval();
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(TAG, 1, "[loadRelationGroup] oldRelationGroupLoadTime: ", Long.valueOf(relationGroupLoadTime), " | oldRelationLoadTimeInterval: ", Long.valueOf(relationLoadTimeInterval), " | currentRelationLoadTime: ", Long.valueOf(currentTimeMillis));
        if (currentTimeMillis - relationGroupLoadTime > relationLoadTimeInterval) {
            loadRelationGroupData(0);
        } else {
            asyncInitFriendCache();
        }
    }

    public void loadRelationGroupData(int i3) {
        QCircleRelationModel qCircleRelationModel = new QCircleRelationModel();
        qCircleRelationModel.setOnLoadAtRelationListener(new IQCircleRelationModel.OnLoadAtRelationListener() { // from class: cooperation.qqcircle.relation.QCircleRelationGroupManager.1
            @Override // cooperation.qqcircle.relation.request.IQCircleRelationModel.OnLoadAtRelationListener
            public void onLoadAtRelationFail(int i16, long j3, String str) {
                QLog.w(QCircleRelationGroupManager.TAG, 1, "[onLoadAtRelationFail] errCode: " + j3 + " | errMsg: " + str + " | scene: " + i16);
            }

            @Override // cooperation.qqcircle.relation.request.IQCircleRelationModel.OnLoadAtRelationListener
            public void onLoadAtRelationFinish(int i16, Map<String, List<NewRelationInfo>> map, long j3) {
                if (i16 == 0) {
                    QCircleRelationGroupManager.this.handleAtRelationData(map, j3);
                } else if (i16 == 1) {
                    QCircleRelationGroupManager.this.handleFollowSceneLoadData(map);
                }
            }
        });
        qCircleRelationModel.loadRelationData(i3);
    }

    public void releaseCache() {
        this.mFriendEntityList.clear();
        this.mEntityManager = null;
    }

    public void updateFollowFriendListToDB(String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (z16) {
                addFriendEntity(str, str2);
                return;
            } else {
                deleteFriendEntity(str);
                return;
            }
        }
        QLog.d(TAG, 1, "[updateFriendListToDB] uin or nick name not is empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<QCircleFriendEntity> updateCurrentFriendCache(List<QCircleFriendEntity> list) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            QLog.d(TAG, 1, "[updateCurrentFriendCache] list should not be null.");
            return arrayList;
        }
        for (QCircleFriendEntity qCircleFriendEntity : list) {
            Iterator<QCircleFriendEntity> it = this.mFriendEntityList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                if (qCircleFriendEntity.mUin == it.next().mUin) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                this.mFriendEntityList.add(qCircleFriendEntity);
                arrayList.add(qCircleFriendEntity);
            }
        }
        return arrayList;
    }
}
