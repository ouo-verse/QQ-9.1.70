package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IDataLineMessageSpreadManager;
import ta1.g;

/* loaded from: classes10.dex */
public class TencentDocDataLineTipsConfigProcessor extends l<g> {
    public static g a() {
        return new g();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g migrateOldOrDefaultContent(int i3) {
        return new g();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g onParsed(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            return g.g(aiVarArr);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<g> clazz() {
        return g.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(g gVar) {
        ((IDataLineMessageSpreadManager) QRoute.api(IDataLineMessageSpreadManager.class)).updateConfig(gVar);
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
        return 383;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
