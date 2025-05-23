package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class CustomEmotionRoamingManagerBase<T extends CustomEmotionBase> implements IRuntimeService {
    public static final String TAG = "CustomEmotionRoamingManagerBase";
    protected String uin;
    protected BaseQQAppInterface mApp = null;
    protected CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.emosm.favroaming.n>> listeners = new CopyOnWriteArrayList<>();
    protected AtomicBoolean isInSync = new AtomicBoolean(false);

    public void addSyncListener(com.tencent.mobileqq.emosm.favroaming.n nVar) {
        Iterator<WeakReference<com.tencent.mobileqq.emosm.favroaming.n>> it = this.listeners.iterator();
        while (it.hasNext()) {
            if (it.next().get() == nVar) {
                return;
            }
        }
        this.listeners.add(new WeakReference<>(nVar));
    }

    protected abstract CustomEmotionRoamingDBManagerBase<T> getDBManager();

    protected abstract CustomEmoRoamingBaseHandler<T> getRoamingHandler();

    protected abstract int getUploadProcessorID();

    public boolean isInSyncing() {
        return this.isInSync.compareAndSet(false, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        this.mApp = baseQQAppInterface;
        this.uin = baseQQAppInterface.getCurrentAccountUin();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.listeners.clear();
        this.isInSync.set(false);
    }

    public void removeSyncListener(com.tencent.mobileqq.emosm.favroaming.n nVar) {
        if (nVar == null) {
            return;
        }
        Iterator<WeakReference<com.tencent.mobileqq.emosm.favroaming.n>> it = this.listeners.iterator();
        while (it.hasNext()) {
            WeakReference<com.tencent.mobileqq.emosm.favroaming.n> next = it.next();
            if (next.get() == nVar) {
                this.listeners.remove(next);
                return;
            }
        }
    }

    public void resetSyncState() {
        this.isInSync.set(false);
    }

    public abstract void syncLocalDel();

    public void syncRoaming() {
        CustomEmoRoamingBaseHandler<T> roamingHandler;
        if (this.mApp != null && (roamingHandler = getRoamingHandler()) != null) {
            QLog.d(TAG, 1, "------------start syncRoaming----------");
            roamingHandler.queryUserEmoRoamingReq();
        }
    }
}
