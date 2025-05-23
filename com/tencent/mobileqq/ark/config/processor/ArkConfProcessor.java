package com.tencent.mobileqq.ark.config.processor;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import d91.d;

/* loaded from: classes11.dex */
public abstract class ArkConfProcessor<T extends d> extends l<T> {
    public static <T extends d> T a(Class<T> cls) {
        try {
            T newInstance = cls.newInstance();
            d dVar = (d) am.s().x(newInstance.a());
            if (dVar == null) {
                return newInstance;
            }
            return cls.cast(dVar);
        } catch (Exception e16) {
            QLog.w("ArkApp.ConfProcessor", 1, e16.toString());
            return null;
        }
    }

    protected abstract T b(String str);

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public T onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ConfProcessor", 2, "[onParsed] config type = " + type());
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            String str = aiVarArr[0].f202268b;
            if (!TextUtils.isEmpty(str)) {
                return b(str);
            }
            QLog.i("ArkApp.ConfProcessor", 1, "[onParsed] content is empty, config type = " + type());
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        QLog.d("ArkApp.ConfProcessor", 1, "[onReqFailed] failCode=" + i3 + ", config type = " + type());
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
        super.onReqNoReceive();
    }

    @Override // com.tencent.mobileqq.config.l
    public final int type() {
        try {
            return ((d) clazz().newInstance()).a();
        } catch (Exception e16) {
            throw new RuntimeException(e16.toString());
        }
    }
}
