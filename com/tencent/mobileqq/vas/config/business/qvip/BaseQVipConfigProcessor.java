package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.vas.util.AssertUtils;
import hd0.c;

/* loaded from: classes20.dex */
public abstract class BaseQVipConfigProcessor<T> extends l<T> {
    public static final String TAG = "QVipConfigProcessor";

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @NonNull
    public abstract T migrateDefaultContent();

    @NonNull
    public abstract T migrateOldContent();

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    public T migrateOldOrDefaultContent(int i3) {
        T t16;
        if (i3 == 1) {
            t16 = migrateDefaultContent();
        } else if (i3 == 0) {
            t16 = migrateOldContent();
        } else {
            AssertUtils.fail(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + i3, new Object[0]);
            t16 = null;
        }
        if (t16 == null) {
            AssertUtils.fail(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + i3, new Object[0]);
            return migrateOldContent();
        }
        return t16;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    public T onParsed(ai[] aiVarArr) {
        boolean z16;
        if (aiVarArr != null && aiVarArr.length > 0) {
            c.t(TAG, getClass().getName() + ".parsed content count=" + aiVarArr.length);
            return parsed(aiVarArr);
        }
        c.g(TAG, getClass().getName() + ".onParsed error: confFiles is empty");
        T migrateOldContent = migrateOldContent();
        if (migrateOldContent != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        AssertUtils.assertTrue(z16, getClass().getName() + ".onParsed error: confFiles is empty");
        return migrateOldContent;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        c.g(TAG, getClass().getName() + ".onReqFailed: " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(T t16) {
        c.t(TAG, getClass().getName() + ".onUpdate: " + t16);
    }

    @NonNull
    public abstract T parsed(@NonNull ai[] aiVarArr);
}
