package com.tencent.mobileqq.config.business.search;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.luggage.wxa.c3.f;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class UinSearchConfProcessor extends l<a> {

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static int f202821b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static int f202822c = 2;

        /* renamed from: a, reason: collision with root package name */
        public int f202823a = f202822c;

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(String str) {
            a aVar = new a();
            try {
                aVar.f202823a = new JSONObject(str).optInt("action", f202822c);
            } catch (Throwable th5) {
                QLog.e("UinSearchConfProcessor", 1, th5, new Object[0]);
            }
            return aVar;
        }

        public boolean c() {
            if (this.f202823a == f202821b) {
                return true;
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            a b16 = a.b(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.i("UinSearchConfProcessor", 2, "onParsed: " + aiVarArr[0].f202268b);
            }
            return b16;
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("UinSearchConfProcessor", 2, "onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

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

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return f.CTRL_INDEX;
    }
}
