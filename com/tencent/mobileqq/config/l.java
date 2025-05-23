package com.tencent.mobileqq.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class l<T> {
    public static final int CODE_REQ_SUCCESS = 0;
    public static final int DEFAULT = 1;
    public static final int FAIL_CODE_ERROR = -2;
    public static final int FAIL_CODE_REQ_TIMEOUT = -1;
    public static final int MIGRATE = 0;

    public abstract Class<T> clazz();

    public boolean handleEmptyResp() {
        return true;
    }

    public boolean isAccountRelated() {
        return true;
    }

    public abstract boolean isNeedCompressed();

    public abstract boolean isNeedStoreLargeFile();

    public boolean isNeedUpgradeReset() {
        return false;
    }

    @NonNull
    public abstract T migrateOldOrDefaultContent(int i3);

    public abstract int migrateOldVersion();

    @Nullable
    public ai migrateToFreesia(@NonNull ai[] aiVarArr) {
        if (aiVarArr.length <= 0) {
            return null;
        }
        return aiVarArr[0];
    }

    @Nullable
    public abstract T onParsed(ai[] aiVarArr) throws QStorageInstantiateException;

    public abstract void onReqFailed(int i3);

    public abstract void onUpdate(T t16);

    public String tabExperimentId() {
        return "";
    }

    public String tabGroupId() {
        return "";
    }

    public abstract int type();

    public void onReqNoReceive() {
    }

    public void onProcessorConstructed(int i3) {
    }

    public int onSend(int i3) {
        return i3;
    }
}
