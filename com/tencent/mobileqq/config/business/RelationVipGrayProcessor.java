package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class RelationVipGrayProcessor extends com.tencent.mobileqq.config.l<bc> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bc migrateOldOrDefaultContent(int i3) {
        return new bc();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bc onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            bc a16 = bc.a(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("RelationVipGrayProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        return new bc();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<bc> clazz() {
        return bc.class;
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
        return P2VGlobalConfig.WATER_MARKER_WIDTH;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(bc bcVar) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
