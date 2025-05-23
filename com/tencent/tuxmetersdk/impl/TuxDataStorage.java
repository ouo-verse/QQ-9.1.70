package com.tencent.tuxmetersdk.impl;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tuxmetersdk.export.config.TuxEnvironment;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.injector.storage.ITuxStorage;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxDataStorage {
    static IPatchRedirector $redirector_ = null;
    private static final String EXPOSE_STORAGE_DATA_VALUE_DEFAULT;
    private static final String STORAGE_FILE_NAME_EMPTY_APP_ID = "EmptyAppId";
    private static final String STORAGE_FILE_NAME_EMPTY_ENVIRONMENT = "EmptyEnvironment";
    private static final String STORAGE_FILE_NAME_EMPTY_UID = "EmptyUid";
    private static final String STORAGE_FILE_NAME_PREFIX = "tux_sdk_data_info";
    private static final String STORAGE_FILE_NAME_SEPARATOR = "_";
    private static final String TAG = "TuxDataStorage";
    private final ITuxStorage storageImpl;
    private final String tuxStorageKey;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9954);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EXPOSE_STORAGE_DATA_VALUE_DEFAULT = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TuxDataStorage(TuxMeterSDKSetting tuxMeterSDKSetting, ITuxLog iTuxLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tuxMeterSDKSetting, (Object) iTuxLog);
        } else {
            this.storageImpl = tuxMeterSDKSetting.getTuxInjectStorage();
            this.tuxStorageKey = createStorageKey(tuxMeterSDKSetting);
        }
    }

    private static Gson createGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    private String createStorageKey(TuxMeterSDKSetting tuxMeterSDKSetting) {
        return "tux_sdk_data_info_" + Utils.getTextWithCheckEmpty(TuxEnvironment.toStorageName(tuxMeterSDKSetting.getEnvironment()), STORAGE_FILE_NAME_EMPTY_ENVIRONMENT) + "_" + Utils.getTextWithCheckEmpty(tuxMeterSDKSetting.getAppId(), STORAGE_FILE_NAME_EMPTY_APP_ID) + "_" + Utils.getTextWithCheckEmpty(tuxMeterSDKSetting.getUid(), STORAGE_FILE_NAME_EMPTY_UID);
    }

    private String getStorageString(String str, String str2) {
        if (this.storageImpl != null && !TextUtils.isEmpty(str)) {
            return this.storageImpl.getString(str);
        }
        return str2;
    }

    private void putStorageString(String str, String str2) {
        if (this.storageImpl != null && !TextUtils.isEmpty(str)) {
            this.storageImpl.putString(str, str2);
        }
    }

    private void removeStorage(String str) {
        if (this.storageImpl != null && !TextUtils.isEmpty(str)) {
            this.storageImpl.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExposeInfo getExposeInfo() {
        String storageString = getStorageString(this.tuxStorageKey, EXPOSE_STORAGE_DATA_VALUE_DEFAULT);
        if (storageString == null) {
            return null;
        }
        return (ExposeInfo) createGson().fromJson(storageString, ExposeInfo.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void putExposeInfo(ExposeInfo exposeInfo) {
        if (exposeInfo == null) {
            return;
        }
        String json = createGson().toJson(exposeInfo);
        if (json == null) {
            return;
        }
        putStorageString(this.tuxStorageKey, json);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void removeExposeInfo() {
        removeStorage(this.tuxStorageKey);
    }
}
