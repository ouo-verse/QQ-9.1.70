package com.tencent.qqperf.monitor.file;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.luggage.wxa.wh.b;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes25.dex */
public class ExternalDirOperationConfigProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return a.b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ExternalDirOperationConfigProcessor", 1, "onParsed:" + aiVarArr[0].f202268b);
        }
        return a.a(aiVarArr[0].f202268b);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        QLog.d("ExternalDirOperationConfigProcessor", 1, "onUpdate:" + aVar);
        a.c(BaseApplication.getContext(), aVar.f363253b);
        a.e(BaseApplication.getContext(), aVar.f363254c);
        a.f(BaseApplication.getContext(), aVar.f363255d);
        a.d(aVar.f363256e);
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
        QLog.d("ExternalDirOperationConfigProcessor", 1, "onReqFailed:" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return b.CTRL_INDEX;
    }
}
