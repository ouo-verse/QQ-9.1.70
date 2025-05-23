package com.tencent.mobileqq.emosm;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class CustomEmotionRoamingDBManagerBase<T extends CustomEmotionBase> implements IRuntimeService {
    protected static final int DELETE = 4;
    protected static final int INSERT = 1;
    public static final String TAG = "CustomEmotionRoamingDBManagerBase";
    protected static final int UPDATE = 2;
    protected BaseQQAppInterface app;
    protected List<T> customEmotionDbCache = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void callbackInMainThread(List<EmoticonInfo> list);
    }

    public void asyncGetFavEmotionInfoShowedInPanel(final a aVar) {
        if (aVar == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.3
            @Override // java.lang.Runnable
            public void run() {
                final List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = CustomEmotionRoamingDBManagerBase.this.syncGetCustomEmotionInfoShowedInPanel();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.callbackInMainThread(syncGetCustomEmotionInfoShowedInPanel);
                    }
                });
            }
        }, 5, null, true);
    }

    public void asyncGetFavEmotionInfoShowedInPreview(final a aVar) {
        if (aVar == null) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.4
            @Override // java.lang.Runnable
            public void run() {
                final List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview = CustomEmotionRoamingDBManagerBase.this.syncGetCustomEmotionInfoShowedInPreview();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.callbackInMainThread(syncGetCustomEmotionInfoShowedInPreview);
                    }
                });
            }
        }, 5, null, true);
    }

    public abstract EmoticonInfo convertEmotionDataToInfo(T t16, BaseQQAppInterface baseQQAppInterface);

    public void deleteCustomEmotion(T t16) {
        if (t16 != null) {
            updateCache(t16, 4);
            updateCustomEmotionDataInDB(t16, 4);
        }
    }

    public void deleteCustomEmotionList(List<T> list) {
        if (list != null && list.size() >= 1) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                updateCache(list.get(i3), 4);
            }
            updateCustomEmotionDataListInDB(list, 4);
        }
    }

    public List<T> findMagicEmosById(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from findMagicEmosById.");
        }
        List<T> emoticonDataList = getEmoticonDataList();
        ArrayList arrayList = new ArrayList();
        if (emoticonDataList != null && emoticonDataList.size() > 0) {
            for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                T t16 = emoticonDataList.get(i3);
                if (t16 != null && t16.emoPath.equals(str)) {
                    arrayList.add(t16);
                }
            }
        }
        return arrayList;
    }

    public abstract String getCustomEmoticonPath(T t16);

    public List<String> getCustomEmoticonResIdsByType(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getCustomEmoticonResIdsByType.");
        }
        List<T> emoticonDataList = getEmoticonDataList();
        if (emoticonDataList != null && emoticonDataList.size() > 0) {
            for (T t16 : emoticonDataList) {
                String str2 = t16.resid;
                if (t16.RomaingType.equals(str) && str2 != null && !"".equals(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public abstract T getCustomEmotionDataBYResId(List<T> list, String str);

    public abstract Class getDBClass();

    public abstract List<T> getEmoticonDataList();

    public List<T> getEmoticonDatasByType(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getEmoticonDatasByType.");
        }
        List<T> emoticonDataList = getEmoticonDataList();
        if (emoticonDataList != null && emoticonDataList.size() > 0) {
            arrayList = new ArrayList();
            for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                T t16 = emoticonDataList.get(i3);
                if (t16.RomaingType.equals(str)) {
                    arrayList.add(t16);
                }
            }
        }
        return arrayList;
    }

    public T getEmotionDataByUrl(String str) {
        EntityManager createEntityManager;
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null || (createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager()) == null) {
            return null;
        }
        List<? extends Entity> query = createEntityManager.query(getDBClass(), false, "url=?", new String[]{str}, null, null, null, null);
        createEntityManager.close();
        if (query == null || query.size() != 1) {
            return null;
        }
        return (T) query.get(0);
    }

    public abstract CustomEmotionRoamingManagerBase<T> getRoamingManager();

    public void insertCustomEmotion(T t16) {
        if (t16 != null) {
            updateCache(t16, 1);
            updateCustomEmotionDataInDB(t16, 1);
        }
    }

    public void insertCustomEmotionList(List<T> list) {
        if (list != null && list.size() >= 1) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                updateCache(list.get(i3), 1);
            }
            updateCustomEmotionDataListInDB(list, 1);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = (BaseQQAppInterface) appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.customEmotionDbCache.clear();
        this.app = null;
    }

    public void runInCurrentThread(Runnable runnable, int i3) {
        if (runnable != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
            } else {
                ThreadManagerV2.post(runnable, i3, null, true);
            }
        }
    }

    public abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel();

    protected abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview();

    public void trimCache() {
        ArrayList arrayList = new ArrayList();
        for (T t16 : this.customEmotionDbCache) {
            if (t16.RomaingType.equals("failed")) {
                arrayList.add(t16);
            }
        }
        this.customEmotionDbCache.removeAll(arrayList);
        this.customEmotionDbCache.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateCache(T t16, int i3) {
        if (t16 == null) {
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not update fav emoticon cache data, type:" + i3);
                        return;
                    }
                    return;
                }
                for (T t17 : this.customEmotionDbCache) {
                    if (t17.emoId == t16.emoId) {
                        this.customEmotionDbCache.remove(t17);
                        return;
                    }
                }
                return;
            }
            for (T t18 : this.customEmotionDbCache) {
                if (t18.emoId == t16.emoId) {
                    t18.replace(t16);
                    return;
                }
            }
            return;
        }
        this.customEmotionDbCache.add(t16);
    }

    public void updateCustomEmotion(T t16) {
        if (t16 != null) {
            updateCache(t16, 2);
            updateCustomEmotionDataInDB(t16, 2);
        }
    }

    public void updateCustomEmotionDataInDB(final T t16, final int i3) {
        if (t16 == null) {
            return;
        }
        runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.2
            /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                EntityManager createEntityManager;
                boolean z16;
                BaseQQAppInterface baseQQAppInterface = CustomEmotionRoamingDBManagerBase.this.app;
                if (baseQQAppInterface == null || (createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager()) == null) {
                    return;
                }
                int i16 = i3;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 4) {
                            if (QLog.isColorLevel()) {
                                QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not save fav emoticon data, type:" + i3);
                            }
                        } else {
                            z16 = createEntityManager.remove(t16);
                        }
                    } else {
                        z16 = createEntityManager.update(t16);
                    }
                    createEntityManager.close();
                    if (!QLog.isColorLevel()) {
                        QLog.d("CustomEmotionRoamingDBManagerBase", 2, "updateCustomEmotionDataListInDB type:" + i3 + "save result: " + z16);
                        return;
                    }
                    return;
                }
                t16.setStatus(1000);
                createEntityManager.persist(t16);
                z16 = false;
                createEntityManager.close();
                if (!QLog.isColorLevel()) {
                }
            }
        }, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateCustomEmotionDataListInDB(final List<T> list, final int i3) {
        if (list != null && list.size() >= 1) {
            runInCurrentThread(new Runnable() { // from class: com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.1
                @Override // java.lang.Runnable
                public void run() {
                    EntityManager createEntityManager;
                    BaseQQAppInterface baseQQAppInterface = CustomEmotionRoamingDBManagerBase.this.app;
                    if (baseQQAppInterface == null || (createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager()) == null) {
                        return;
                    }
                    boolean z16 = false;
                    try {
                        try {
                            ArrayList arrayList = new ArrayList(list.size());
                            for (int i16 = 0; i16 < list.size(); i16++) {
                                CustomEmotionBase customEmotionBase = (CustomEmotionBase) list.get(i16);
                                int i17 = i3;
                                if (i17 != 1) {
                                    if (i17 != 2) {
                                        if (i17 != 4) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("CustomEmotionRoamingDBManagerBase", 2, "can not save custom emoticon data, type:" + i3);
                                            }
                                        } else {
                                            arrayList.add(new RemoveTransaction(customEmotionBase));
                                        }
                                    } else {
                                        arrayList.add(new UpdateTransaction(customEmotionBase));
                                    }
                                } else {
                                    customEmotionBase.setStatus(1000);
                                    arrayList.add(new PersistTransaction(customEmotionBase));
                                }
                            }
                            z16 = createEntityManager.doMultiDBOperateByTransaction(arrayList);
                        } catch (Exception e16) {
                            QLog.e("CustomEmotionRoamingDBManagerBase", 1, "updateCustomEmotionDataListInDB error", e16);
                        }
                        createEntityManager.close();
                        if (QLog.isColorLevel()) {
                            QLog.d("CustomEmotionRoamingDBManagerBase", 2, "updateCustomEmotionDataListInDB type:" + i3 + ",data size:" + list.size() + ", save result: " + z16);
                        }
                    } catch (Throwable th5) {
                        createEntityManager.close();
                        throw th5;
                    }
                }
            }, 8);
        }
    }

    public void updateCustomEmotionList(List<T> list) {
        if (list != null && list.size() >= 1) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                updateCache(list.get(i3), 2);
            }
            updateCustomEmotionDataListInDB(list, 2);
        }
    }

    public List<String> getCustomEmoticonResIdsByType(List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        List<T> emoticonDataList = getEmoticonDataList();
        if (emoticonDataList != null && emoticonDataList.size() > 0) {
            for (T t16 : emoticonDataList) {
                String str = t16.resid;
                if (!TextUtils.isEmpty(str) && !list.contains(t16.RomaingType)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }
}
