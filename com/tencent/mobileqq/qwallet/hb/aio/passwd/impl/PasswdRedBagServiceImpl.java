package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PasswdRedBagServiceImpl implements IPasswdRedBagService {
    private static final String KEY_PASSWD_CONFIGS = "key_passwd_configs";
    private static final String SP_PASSWD_CONFIGS = "sp_passwd_configs";
    private boolean isConfigLoaded;
    private boolean isNeedLoadRedBagInfo;
    private boolean isNeedSyncLoadRedBagInfo;
    private HashMap<String, String> mCacheDisGroupInfos;
    private HashMap<String, String> mCacheGroupInfos;
    public Context mContext;
    private List<String> mDefaultPasswds;
    public String mUin;

    private boolean isNeedReInit() {
        if (d.h().equals(this.mUin)) {
            return false;
        }
        return true;
    }

    private void reInit() {
        this.mUin = d.h();
        this.mDefaultPasswds.clear();
        this.isNeedSyncLoadRedBagInfo = true;
        this.isNeedLoadRedBagInfo = true;
    }

    private void saveConfigs(Set<String> set) {
        try {
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences("sp_passwd_configs_" + this.mUin, 0).edit();
            edit.putStringSet(KEY_PASSWD_CONFIGS, set);
            edit.commit();
        } catch (Throwable th5) {
            QLog.e(IPasswdRedBagService.TAG, 1, "error msg in qqpay-impl module: ", th5);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService
    public void loadConfigs() {
        if (this.isConfigLoaded) {
            return;
        }
        try {
            Set<String> stringSet = this.mContext.getSharedPreferences("sp_passwd_configs_" + this.mUin, 0).getStringSet(KEY_PASSWD_CONFIGS, new HashSet());
            if (stringSet != null && stringSet.size() > 0) {
                this.mDefaultPasswds.addAll(stringSet);
            }
        } catch (Throwable th5) {
            QLog.e(IPasswdRedBagService.TAG, 1, "error msg in qqpay-impl module: ", th5);
        }
        this.isConfigLoaded = true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService
    public synchronized void loadRedBagInfoToCache(boolean z16) {
        if (isNeedReInit()) {
            reInit();
        }
        if (z16) {
            if (!this.isNeedSyncLoadRedBagInfo) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + z16 + ",isNeedSyncLoadRedBagInfo=" + this.isNeedSyncLoadRedBagInfo + ",isNeedLoadRedBagInfo=" + this.isNeedLoadRedBagInfo);
            }
            this.isNeedSyncLoadRedBagInfo = false;
        } else {
            if (this.isNeedLoadRedBagInfo && this.isNeedSyncLoadRedBagInfo) {
                if (QLog.isColorLevel()) {
                    QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + z16 + ",isNeedSyncLoadRedBagInfo=" + this.isNeedSyncLoadRedBagInfo + ",isNeedLoadRedBagInfo=" + this.isNeedLoadRedBagInfo);
                }
                this.isNeedLoadRedBagInfo = false;
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mContext = MobileQQ.sMobileQQ;
        this.mUin = d.h();
        this.mDefaultPasswds = new ArrayList();
        this.isNeedSyncLoadRedBagInfo = true;
        this.isNeedLoadRedBagInfo = true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService
    public void saveDisGroupInfos(HashMap<String, String> hashMap) {
        if (this.mCacheDisGroupInfos == null) {
            this.mCacheDisGroupInfos = new HashMap<>();
        }
        this.mCacheDisGroupInfos.putAll(hashMap);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService
    public void saveGroupInfos(HashMap<String, String> hashMap) {
        if (this.mCacheGroupInfos == null) {
            this.mCacheGroupInfos = new HashMap<>();
        }
        this.mCacheGroupInfos.putAll(hashMap);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService
    public void updatePasswdConfig(HashSet<String> hashSet) {
        this.mDefaultPasswds.clear();
        this.mDefaultPasswds.addAll(hashSet);
        saveConfigs(hashSet);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
