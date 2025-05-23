package com.tencent.mobileqq.troop.roamsetting.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQHashMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingDataService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoamSettingDataServiceImpl implements IRoamSettingDataService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RoamSettingDataServiceImpl";
    protected AppInterface app;

    /* renamed from: em, reason: collision with root package name */
    EntityManager f298291em;
    Lock lock;
    boolean mIsLoadDb;
    QQHashMap<String, RoamSetting> mSettingCache;
    RoamSetting tagRevision;

    public RoamSettingDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.app = null;
            this.mIsLoadDb = false;
        }
    }

    boolean deleteEntity(Entity entity) {
        if (this.f298291em.isOpen()) {
            return this.f298291em.remove(entity);
        }
        return false;
    }

    public RoamSetting findRoamSetting(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RoamSetting) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        this.lock.lock();
        try {
            RoamSetting roamSetting = this.mSettingCache.get(str);
            if (roamSetting == null && !this.mIsLoadDb && (roamSetting = (RoamSetting) DBMethodProxy.find(this.f298291em, (Class<? extends Entity>) RoamSetting.class, str)) != null && (str2 = roamSetting.path) != null && roamSetting.value != null) {
                this.mSettingCache.put(str2, roamSetting);
            }
            return roamSetting;
        } finally {
            this.lock.unlock();
        }
    }

    public int getRevision() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.tagRevision == null) {
            this.tagRevision = (RoamSetting) DBMethodProxy.find(this.f298291em, (Class<? extends Entity>) RoamSetting.class, RoamSetting.SETTING_REVISION);
        }
        RoamSetting roamSetting = this.tagRevision;
        if (roamSetting == null) {
            return 0;
        }
        String str = roamSetting.value;
        if (str == null) {
            this.tagRevision = null;
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.d(TAG, 2, "parse revision.value exception, revision.value=" + this.tagRevision.value);
            return 0;
        }
    }

    public int getRoamSettingValue(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3)).intValue();
        }
        RoamSetting findRoamSetting = findRoamSetting(str);
        if (findRoamSetting == null && !TextUtils.isEmpty(str)) {
            findRoamSetting = new RoamSetting(str, Integer.toString(i3));
            saveRoamSetting(findRoamSetting);
        }
        return RoamSetting.getIntValue(findRoamSetting, i3);
    }

    BaseTransaction getTransactionObj(Entity entity) {
        if (!this.f298291em.isOpen()) {
            return null;
        }
        if (entity.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(entity);
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return null;
        }
        return new UpdateTransaction(entity);
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoamSettingDataServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList arrayList = (ArrayList) RoamSettingDataServiceImpl.this.f298291em.query(RoamSetting.class, false, null, null, null, null, null, null);
                    if (arrayList != null && arrayList.size() > 0) {
                        RoamSettingDataServiceImpl.this.lock.lock();
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            try {
                                RoamSetting roamSetting = (RoamSetting) arrayList.get(i3);
                                RoamSettingDataServiceImpl.this.mSettingCache.put(roamSetting.path, roamSetting);
                            } finally {
                                RoamSettingDataServiceImpl.this.lock.unlock();
                            }
                        }
                    }
                    RoamSettingDataServiceImpl.this.mIsLoadDb = true;
                }
            }, 8, null, false);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.app = appInterface;
        this.f298291em = appInterface.getEntityManagerFactory().createEntityManager();
        this.mSettingCache = new QQHashMap<>(Business.AIO, "RoamSetting");
        this.lock = new ReentrantLock();
        init();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQHashMap<String, RoamSetting> qQHashMap = this.mSettingCache;
        if (qQHashMap != null) {
            qQHashMap.clear();
        }
        EntityManager entityManager = this.f298291em;
        if (entityManager != null && entityManager.isOpen()) {
            this.f298291em.close();
        }
    }

    public void saveRoamSetting(RoamSetting roamSetting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) roamSetting);
            return;
        }
        if (roamSetting == null || roamSetting.path == null || roamSetting.value == null) {
            return;
        }
        this.lock.lock();
        try {
            this.mSettingCache.put(roamSetting.path, roamSetting);
            this.lock.unlock();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                updateEntity(roamSetting);
            } else {
                ThreadManagerV2.excute(new Runnable(roamSetting) { // from class: com.tencent.mobileqq.troop.roamsetting.api.impl.RoamSettingDataServiceImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ RoamSetting f298292d;

                    {
                        this.f298292d = roamSetting;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RoamSettingDataServiceImpl.this, (Object) roamSetting);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            RoamSettingDataServiceImpl.this.updateEntity(this.f298292d);
                        }
                    }
                }, 32, null, false);
            }
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    public void saveRoamSettingToDB(List<RoamSetting> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    BaseTransaction transactionObj = getTransactionObj(list.get(i3));
                    if (transactionObj != null) {
                        arrayList.add(transactionObj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f298291em.doMultiDBOperateByTransaction(arrayList);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "insert write exception: " + e16.getMessage());
            }
        }
    }

    public void setRevision(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (this.tagRevision != null) {
            String num = Integer.toString(i3);
            if (num.equals(this.tagRevision.value)) {
                return;
            } else {
                this.tagRevision.value = num;
            }
        } else {
            RoamSetting roamSetting = new RoamSetting();
            roamSetting.path = RoamSetting.SETTING_REVISION;
            roamSetting.value = Integer.toString(i3);
            this.tagRevision = roamSetting;
        }
        updateEntity(this.tagRevision);
    }

    boolean updateEntity(Entity entity) {
        if (this.f298291em.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f298291em.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f298291em.update(entity);
            }
        }
        return false;
    }

    public RoamSetting saveRoamSetting(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RoamSetting) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        if (str == null || str2 == null) {
            return null;
        }
        RoamSetting findRoamSetting = findRoamSetting(str);
        if (findRoamSetting == null) {
            findRoamSetting = new RoamSetting(str, str2);
        } else {
            if (str2.equals(findRoamSetting.value)) {
                return null;
            }
            findRoamSetting.value = str2;
        }
        this.lock.lock();
        try {
            this.mSettingCache.put(findRoamSetting.path, findRoamSetting);
            return findRoamSetting;
        } finally {
            this.lock.unlock();
        }
    }
}
