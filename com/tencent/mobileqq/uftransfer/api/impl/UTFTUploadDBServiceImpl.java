package com.tencent.mobileqq.uftransfer.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService;
import com.tencent.mobileqq.uftransfer.data.UploadInfoEntity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UTFTUploadDBServiceImpl implements IUTFTUploadDBService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "[UFTTransfer] UTFUploadDBServiceImpl";
    private AppRuntime mApp;
    private volatile EntityManager mEntityManager;

    public UTFTUploadDBServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void doCallbackOp(IUTFTUploadDBService.a aVar, UploadInfoEntity uploadInfoEntity) {
        if (aVar != null) {
            aVar.a(uploadInfoEntity);
        }
    }

    private EntityManager getEntityManager() {
        if (this.mEntityManager != null) {
            return this.mEntityManager;
        }
        synchronized (this) {
            if (this.mApp == null) {
                return null;
            }
            if (this.mEntityManager == null) {
                this.mEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
            }
            return this.mEntityManager;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: innerAddOrReplace, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$addOrReplaceAsync$0(UploadInfoEntity uploadInfoEntity, IUTFTUploadDBService.a aVar) {
        EntityManager entityManager = getEntityManager();
        if (entityManager != null) {
            entityManager.persistOrReplace(uploadInfoEntity);
        }
        doCallbackOp(aVar, uploadInfoEntity);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addOrReplace finish: key = " + uploadInfoEntity.sessionKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: innerGetEntity, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$getEntityAsync$2(String str, IUTFTUploadDBService.a aVar) {
        UploadInfoEntity uploadInfoEntity;
        EntityManager entityManager = getEntityManager();
        if (entityManager != null) {
            Entity find = DBMethodProxy.find(entityManager, UploadInfoEntity.class, UploadInfoEntity.UNIQUE_KEY_CAUSE, new String[]{str});
            if (find instanceof UploadInfoEntity) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEntity success: key = " + str);
                }
                uploadInfoEntity = (UploadInfoEntity) find;
                doCallbackOp(aVar, uploadInfoEntity);
            }
        }
        uploadInfoEntity = null;
        doCallbackOp(aVar, uploadInfoEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: innerRemove, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$removeAsync$1(String str, IUTFTUploadDBService.a aVar) {
        EntityManager entityManager = getEntityManager();
        if (entityManager != null) {
            entityManager.delete(UploadInfoEntity.TABLE_NAME, UploadInfoEntity.UNIQUE_KEY_CAUSE, new String[]{str});
        }
        doCallbackOp(aVar, null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "remove finish: key = " + str);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService
    public void addOrReplaceAsync(final UploadInfoEntity uploadInfoEntity, final IUTFTUploadDBService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uploadInfoEntity, (Object) aVar);
            return;
        }
        if (uploadInfoEntity == null) {
            QLog.i(TAG, 1, "addOrReplaceAsync fail! entity is null");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            lambda$addOrReplaceAsync$0(uploadInfoEntity, aVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    UTFTUploadDBServiceImpl.this.lambda$addOrReplaceAsync$0(uploadInfoEntity, aVar);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService
    public void getEntityAsync(final String str, final IUTFTUploadDBService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (aVar != null && !TextUtils.isEmpty(str)) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                lambda$getEntityAsync$2(str, aVar);
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.api.impl.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        UTFTUploadDBServiceImpl.this.lambda$getEntityAsync$2(str, aVar);
                    }
                }, 32, null, false);
                return;
            }
        }
        QLog.i(TAG, 1, "getEntityAsync fail! callback is null or sessionKey is null or empty");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUTFTUploadDBService
    public void removeAsync(final String str, final IUTFTUploadDBService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "removeAsync fail! fileMd5 is null or empty");
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            lambda$removeAsync$1(str, aVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    UTFTUploadDBServiceImpl.this.lambda$removeAsync$1(str, aVar);
                }
            }, 32, null, false);
        }
    }
}
