package com.tencent.mobileqq.troop.api.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.troopnotification.TroopNotificationApplicantInfoController;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopNotificationServiceImpl implements ITroopNotificationService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopNotificationServiceImpl";
    private AppRuntime app;
    private Object lock;
    private Map<Class, com.tencent.mobileqq.troop.troopnotification.a> mControllerCache;

    public TroopNotificationServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lock = new Object();
            this.mControllerCache = new ConcurrentHashMap();
        }
    }

    private void dispatchControllerDestroy() {
        for (com.tencent.mobileqq.troop.troopnotification.a aVar : this.mControllerCache.values()) {
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    private com.tencent.mobileqq.troop.troopnotification.a genController(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(AppRuntime.class);
            declaredConstructor.setAccessible(true);
            return (com.tencent.mobileqq.troop.troopnotification.a) declaredConstructor.newInstance(this.app);
        } catch (Exception e16) {
            e16.printStackTrace();
            handleGenControllerException(e16);
            return null;
        }
    }

    private <T extends com.tencent.mobileqq.troop.troopnotification.a> T getController(Class<T> cls) {
        T t16 = (T) this.mControllerCache.get(cls);
        if (t16 == null) {
            synchronized (this.lock) {
                t16 = (T) this.mControllerCache.get(cls);
                if (t16 == null) {
                    t16 = (T) genController(cls);
                    if (t16 != null) {
                        QLog.i(TAG, 1, "Controller name:" + cls.getSimpleName() + " is not null");
                        this.mControllerCache.put(cls, t16);
                    } else {
                        QLog.i(TAG, 1, "Controller name:" + cls.getSimpleName() + " is null");
                    }
                }
            }
        }
        return t16;
    }

    private void handleGenControllerException(Exception exc) {
        if (exc instanceof NoSuchMethodException) {
            QLog.e(TAG, 1, "genController getDeclaredConstructor throw NoSuchMethodException e:" + exc.getMessage());
            return;
        }
        if (exc instanceof SecurityException) {
            QLog.e(TAG, 1, "genController getDeclaredConstructor or setAccessible throw SecurityException e:" + exc.getMessage());
            return;
        }
        if (!(exc instanceof IllegalAccessException) && !(exc instanceof IllegalArgumentException) && !(exc instanceof InstantiationException) && !(exc instanceof InvocationTargetException)) {
            QLog.e(TAG, 1, "genController throw other Exception e:" + exc.getMessage() + "Exception name:" + exc.getClass().getSimpleName());
            return;
        }
        QLog.e(TAG, 1, "genController newInstance throw Exception e:" + exc.getMessage() + "Exception name:" + exc.getClass().getSimpleName());
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    public void addLackApplicantInfoUinToCacheBy0x5eb(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3);
        } else {
            ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).e(l3, 0, "OidbSvc.0x5eb_troopnotifycation");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    public void addLackApplicantInfoUinToCacheBy0x668(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3);
        } else {
            ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).e(l3, 0, "OidbSvc.0x668");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    @Nullable
    public com.tencent.mobileqq.data.troop.d getApplicantInfo(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.data.troop.d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) l3);
        }
        return ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).h(l3);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    public void getNotifyCationApplicantInfoBy0x5eb(@Nullable List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).j(list, "OidbSvc.0x5eb_troopnotifycation");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    public void getNotifyCationApplicantQQLevelBy0x668(@Nullable List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        } else {
            ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).j(list, "OidbSvc.0x668");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    @NonNull
    public List<Long> getWaitingLevelApplicantInfoUinFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).i("OidbSvc.0x668");
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    @NonNull
    public List<Long> getWaitingTagApplicantInfoUinFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).i("OidbSvc.0x5eb_troopnotifycation");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            dispatchControllerDestroy();
            this.mControllerCache.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    public void saveApplicantInfoListToCacheFrom0x5eb(@Nullable List<com.tencent.mobileqq.data.troop.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).l(list);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopNotificationService
    public void saveApplicantInfoToCacheFrom0x668(Map<Long, Integer> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
        } else {
            ((TroopNotificationApplicantInfoController) getController(TroopNotificationApplicantInfoController.class)).m(map);
        }
    }
}
