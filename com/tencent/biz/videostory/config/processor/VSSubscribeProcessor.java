package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import mf0.e;

/* loaded from: classes5.dex */
public class VSSubscribeProcessor extends l<e> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e migrateOldOrDefaultContent(int i3) {
        return new e();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            e f16 = e.f(aiVarArr[0].f202268b);
            onUpdate(f16);
            QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            return f16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(e eVar) {
        QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
        if (eVar != null) {
            QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + eVar.toString());
            VSConfigManager.c().j("subscribe_entrance_enable", eVar.a());
            VSConfigManager.c().j("is_open_sharing", eVar.b());
            VSConfigManager.c().j("subscribe_account_title", eVar.e());
            VSConfigManager.c().j("newfollowlist", eVar.c());
            VSConfigManager.c().j("subscribe_publish_entrance_enable", eVar.d());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<e> clazz() {
        return e.class;
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
    public int type() {
        return 463;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
