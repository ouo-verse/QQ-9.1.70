package com.tencent.qqnt.emotion.emosm;

import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionBase;
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
/* loaded from: classes24.dex */
public abstract class CustomEmotionRoamingDBManagerBase<T extends CustomEmotionBase> implements IRuntimeService {
    protected static final int DELETE = 4;
    protected static final int INSERT = 1;
    public static final String ROAMING_TYPE_DELETE = "needDel";
    public static final String ROAMING_TYPE_FAILED = "failed";
    public static final String ROAMING_TYPE_INIT = "init";
    public static final String ROAMING_TYPE_NEED_UPLOAD = "needUpload";
    public static final String ROAMING_TYPE_NORMAL = "normal";
    public static final String TAG = "CustomEmotionRoamingDBManagerBase";
    protected static final int UPDATE = 2;
    protected BaseQQAppInterface app;
    protected List<T> customEmotionDbCache = new CopyOnWriteArrayList();

    public abstract Class getDBClass();

    public void insertCustomEmotion(T t16) {
        if (t16 != null) {
            updateCache(t16, 1);
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
        runInCurrentThread(new Runnable() { // from class: com.tencent.qqnt.emotion.emosm.CustomEmotionRoamingDBManagerBase.1
            /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
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
                    if (!QLog.isDevelopLevel()) {
                        QLog.d("CustomEmotionRoamingDBManagerBase", 4, "updateCustomEmotionDataListInDB type:", Integer.valueOf(i3), "save result: ", Boolean.valueOf(z16));
                        return;
                    }
                    return;
                }
                t16.setStatus(1000);
                createEntityManager.persist(t16);
                z16 = false;
                createEntityManager.close();
                if (!QLog.isDevelopLevel()) {
                }
            }
        }, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateCustomEmotionDataListInDB(final List<T> list, final int i3) {
        if (list != null && list.size() >= 1) {
            runInCurrentThread(new Runnable() { // from class: com.tencent.qqnt.emotion.emosm.CustomEmotionRoamingDBManagerBase.2
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.qqnt.emotion.db.a a16;
                    boolean z16;
                    BaseQQAppInterface baseQQAppInterface = CustomEmotionRoamingDBManagerBase.this.app;
                    if (baseQQAppInterface == null || (a16 = com.tencent.qqnt.emotion.db.b.f356229a.a(baseQQAppInterface)) == null) {
                        return;
                    }
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
                            z16 = a16.c(arrayList);
                        } catch (Exception e16) {
                            QLog.e("CustomEmotionRoamingDBManagerBase", 1, "updateCustomEmotionDataListInDB error", e16);
                            a16.a();
                            z16 = false;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.d("CustomEmotionRoamingDBManagerBase", 4, "updateCustomEmotionDataListInDB type:", Integer.valueOf(i3), ",data size:", Integer.valueOf(list.size()), ", save result: ", Boolean.valueOf(z16));
                        }
                    } finally {
                        a16.a();
                    }
                }
            }, 8);
        }
    }
}
