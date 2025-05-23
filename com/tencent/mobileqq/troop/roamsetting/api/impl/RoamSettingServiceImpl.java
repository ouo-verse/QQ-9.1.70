package com.tencent.mobileqq.troop.roamsetting.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.config.u;
import com.tencent.mobileqq.troop.roamsetting.ReqGetSettingsHandler;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingHandler;
import com.tencent.mobileqq.troop.roamsetting.a;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingDataService;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoamSettingServiceImpl implements IRoamSettingService {
    static IPatchRedirector $redirector_ = null;
    public static final int RETRY_MAX = 3;
    public static final String TAG = "RoamSettingServiceImpl";
    public static final long TIME_DELAY = 45000;
    Lock lock;
    ConcurrentHashMap<String, Integer> mapNewValue;
    protected ConcurrentHashMap<String, Boolean> mapRequest;
    protected ConcurrentHashMap<String, Integer> mapUploading;
    boolean stateAllLoading;
    boolean stateNewValue;
    boolean stateReqUpgradeSettings;
    long timeAllLoading;
    int uploadTryCount;

    public RoamSettingServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.stateAllLoading = false;
        this.stateReqUpgradeSettings = false;
        this.timeAllLoading = 0L;
        this.stateNewValue = false;
        this.mapUploading = new ConcurrentHashMap<>();
        this.mapNewValue = new ConcurrentHashMap<>();
        this.uploadTryCount = 0;
        this.mapRequest = new ConcurrentHashMap<>();
    }

    private void clearUploading() {
        this.lock.lock();
        try {
            this.mapUploading.clear();
        } finally {
            this.lock.unlock();
        }
    }

    private void copyNewValue2Uploading() {
        this.lock.lock();
        try {
            this.mapUploading.putAll(this.mapNewValue);
            this.mapNewValue.clear();
            this.stateNewValue = false;
            this.lock.unlock();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "copyNewValue2Uploading, change state_newValue=false, mapUploading:" + this.mapUploading.toString());
            }
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    private AppInterface getApp() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void revertUploading2NewValue() {
        this.lock.lock();
        try {
            for (Map.Entry<String, Integer> entry : this.mapUploading.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                if (!this.mapNewValue.containsKey(key)) {
                    this.mapNewValue.put(key, Integer.valueOf(value.intValue()));
                }
            }
            this.mapUploading.clear();
            this.stateNewValue = true;
        } finally {
            this.lock.unlock();
        }
    }

    private void uploadNewValue() {
        Object valueOf;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "uploadNewValue...");
        }
        AppInterface app = getApp();
        if (app != null && app.isRunning()) {
            if (this.stateAllLoading) {
                long j3 = this.timeAllLoading;
                if (j3 > 0 && j3 + 45000 < System.currentTimeMillis()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "uploadNewValue state_allLoading=" + this.stateAllLoading + " more than 45s, forced to stop");
                    }
                    this.timeAllLoading = 0L;
                    this.stateAllLoading = false;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "uploadNewValue but return, state_allLoading=" + this.stateAllLoading + ", time_allLoading less than 60s, waitting...");
                        return;
                    }
                    return;
                }
            }
            copyNewValue2Uploading();
            RoamSettingHandler roamSettingHandler = (RoamSettingHandler) app.getBusinessHandler(RoamSettingHandler.class.getName());
            if (roamSettingHandler != null) {
                roamSettingHandler.M2(((RoamSettingDataServiceImpl) app.getRuntimeService(IRoamSettingDataService.class, "")).getRevision(), this.mapUploading);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("uploadNewValue return directly, app.isRunning=");
            if (app == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(app.isRunning());
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    public boolean enableRetry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.uploadTryCount < 3) {
            return true;
        }
        return false;
    }

    public int getGeneralSettingType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).intValue();
        }
        return u.c().b(str);
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
    public ConcurrentHashMap<String, Boolean> getMapRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mapRequest;
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
    public ConcurrentHashMap<String, Integer> getMapUploading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mapUploading;
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
    public a getReqGetSettingsHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new ReqGetSettingsHandler(getApp());
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
    public int getSettingValue(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3)).intValue();
        }
        if (str == null) {
            return i3;
        }
        this.lock.lock();
        try {
            if (this.mapNewValue.containsKey(str)) {
                return this.mapNewValue.get(str).intValue();
            }
            if (this.mapUploading.containsKey(str)) {
                return this.mapUploading.get(str).intValue();
            }
            this.lock.unlock();
            return ((RoamSettingDataServiceImpl) getApp().getRuntimeService(IRoamSettingDataService.class, "")).getRoamSettingValue(str, i3);
        } finally {
            this.lock.unlock();
        }
    }

    public void loadAllRoamSettings(boolean z16, RoamSettingHandler roamSettingHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), roamSettingHandler);
            return;
        }
        AppInterface app = getApp();
        if (app != null && app.isRunning()) {
            if (this.stateAllLoading) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadAllRoamSettings but return, state_allUpdating=" + this.stateAllLoading);
                    return;
                }
                return;
            }
            this.stateAllLoading = true;
            int revision = ((RoamSettingDataServiceImpl) app.getRuntimeService(IRoamSettingDataService.class, "")).getRevision();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadAllRoamSettings, localRevision=" + revision + " needTroopSettings=" + z16 + " thread=" + Thread.currentThread().getName());
            }
            loadRoamSettingsByPage(revision, 0L, -1, z16, roamSettingHandler);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadAllRoamSetting return directly, app.isRunning=");
            sb5.append(app == null ? "null" : Boolean.valueOf(app.isRunning()));
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    public void loadRoamSettingsByPage(int i3, long j3, int i16, boolean z16, RoamSettingHandler roamSettingHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16), roamSettingHandler);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadRoamSettingsByPage,localRevision=" + i3 + " offset=" + j3 + " respRevision=" + i16 + " needTroopSettings=" + z16 + " thread=" + Thread.currentThread().getName());
        }
        if (roamSettingHandler == null) {
            roamSettingHandler = (RoamSettingHandler) getApp().getBusinessHandler(RoamSettingHandler.class.getName());
        }
        roamSettingHandler.G2(i3, j3, i16, z16);
        this.timeAllLoading = System.currentTimeMillis();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.lock = new ReentrantLock();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void onGetAllSettingsFinish(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetAllSettingsFinish isSucc=" + z16 + " next=" + z17);
        }
        this.stateAllLoading = false;
        this.timeAllLoading = 0L;
        if (z17 && this.stateNewValue) {
            uploadNewValue();
        }
    }

    public void onUploadRomingSettingsFinish(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onUploadRomingSettingsFinish isSuccess=" + z16 + " reload=" + z17);
        }
        clearUploading();
        if (z16 && z17) {
            loadAllRoamSettings(true, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
    public void setRoamSettingNewValue(String str, Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) num);
            return;
        }
        this.stateNewValue = true;
        this.uploadTryCount = 0;
        this.lock.lock();
        try {
            this.mapNewValue.put(str, num);
            this.lock.unlock();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "state_newValue=" + this.stateNewValue + " setRoamSettingNewValue, path=" + str + " value=" + num + " uploadingCount=" + this.uploadTryCount);
            }
            uploadNewValue();
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
    public void loadAllRoamSettings(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            loadAllRoamSettings(z16, null);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }
}
